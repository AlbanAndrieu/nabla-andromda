/*
 * Copyright (c) 2002-2004, Nabla
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Nabla' nor 'Alban' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package org.andromda.cartridges.ejb3.metafacades;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.andromda.cartridges.ejb3.EJB3Globals;
import org.andromda.cartridges.ejb3.EJB3Profile;
import org.andromda.core.common.ExceptionUtils;
import org.andromda.metafacades.uml.AttributeFacade;
import org.andromda.metafacades.uml.ClassifierFacade;
import org.andromda.metafacades.uml.EntityMetafacadeUtils;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.OperationFacade;
import org.andromda.metafacades.uml.UMLProfile;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.lang.StringUtils;

/**
 * Contains utilities for use with EJB metafacades.
 * 
 * @author Chad Brandon
 * @author Vance Karimi
 */
class EJB3MetafacadeUtils
{
    /**
     * Gets all create methods for the given <code>classifier</code>.
     * 
     * @param classifier The classifier from which to retries the create methods
     * @param follow if true, all super type create methods are also retrieved
     * @return collection of create methods found.
     */
    static Collection<OperationFacade> getCreateMethods(ClassifierFacade classifier, boolean follow)
    {
        ExceptionUtils.checkNull("classifer", classifier);
        Collection<OperationFacade> retval = new ArrayList<OperationFacade>();
        ClassifierFacade entity = classifier;
        do
        {
            for (final OperationFacade op : entity.getOperations())
            {
                if (op.hasStereotype(EJB3Profile.STEREOTYPE_CREATE_METHOD))
                {
                    retval.add(op);
                }
            }
            if (follow)
            {
                entity = (ClassifierFacade) entity.getGeneralization();
            }
        } while (follow && entity != null);
        return retval;
    }

    /**
     * Gets the interface name for the passed in <code>classifier</code>. Returns 'LocalHome' if the mode element has
     * the entity stereotype, returns 'Home' otherwise.
     * 
     * @param classifier
     * @return the interface name.
     */
    static String getHomeInterfaceName(ClassifierFacade classifier)
    {
        ExceptionUtils.checkNull("classifer", classifier);
        String homeInterfaceName;
        if (classifier.hasStereotype(UMLProfile.STEREOTYPE_ENTITY))
        {
            homeInterfaceName = classifier.getName() + "LocalHome";
        } else
        {
            homeInterfaceName = classifier.getName() + "Home";
        }
        return homeInterfaceName;
    }

    /**
     * Gets the view type for the passed in <code>classifier</code>. If no
     * view type can be retrieved from the <code>classifier</code>, then the
     * <code>defaultViewType</code> is returned.
     * If session ejb pojo then checks the ejb tagged value and if there is
     * no value defined, returns 'remote'.
     * 
     * @param classifier The classifier to lookup the view type tagged value
     * @param defaultViewType The default view type if one is not found
     * @return String the view type name.
     */
    static String getViewType(ClassifierFacade classifier, String defaultViewType)
    {
        ExceptionUtils.checkNull("classifer", classifier);
        String viewType = (String) classifier.findTaggedValue(EJB3Profile.TAGGEDVALUE_EJB_VIEWTYPE);
        if (StringUtils.isBlank(viewType))
        {
            if (classifier.hasStereotype(EJB3Profile.STEREOTYPE_SERVICE))
            {
                // if the view type wasn't found, search all super classes
                if (StringUtils.isBlank(viewType))
                {
                    viewType = (String) CollectionUtils.find(classifier.getAllGeneralizations(), new Predicate()
                    {
                        public boolean evaluate(Object object)
                        {
                            return ((ModelElementFacade) object).findTaggedValue(EJB3Profile.TAGGEDVALUE_EJB_VIEWTYPE) != null;
                        }
                    });
                }
                if (StringUtils.isBlank(viewType))
                {
                    viewType = (StringUtils.isNotBlank(defaultViewType) ? defaultViewType : EJB3Globals.VIEW_TYPE_REMOTE);
                }
            }
        }
        return viewType.toLowerCase();
    }

    /**
     * Gets all the inherited instance attributes, excluding the instance attributes directory from this
     * <code>classifier</code>.
     * 
     * @param classifier the ClassifierFacade from which to retrieve the inherited attributes.
     * @return a list of ordered attributes.
     */
    static List<AttributeFacade> getInheritedInstanceAttributes(ClassifierFacade classifier)
    {
        ExceptionUtils.checkNull("classifer", classifier);
        ClassifierFacade current = (ClassifierFacade) classifier.getGeneralization();
        if (current == null)
        {
            return new ArrayList<AttributeFacade>();
        }
        List<AttributeFacade> retval = getInheritedInstanceAttributes(current);

        if (current.getInstanceAttributes() != null)
        {
            retval.addAll(current.getInstanceAttributes());
        }
        return retval;
    }

    /**
     * Gets all instance attributes including those instance attributes belonging to the
     * <code>classifier</code> and any inherited ones.
     * 
     * @param classifier the ClassifierFacade from which to retrieve the instance attributes.
     * @return the list of all instance attributes.
     */
    static List<AttributeFacade> getAllInstanceAttributes(ClassifierFacade classifier)
    {
        ExceptionUtils.checkNull("classifer", classifier);
        List<AttributeFacade> retval = getInheritedInstanceAttributes(classifier);
        retval.addAll(classifier.getInstanceAttributes());
        return retval;
    }

    /**
     * Gets all environment entries for the specified <code>classifier</code>. If <code>follow</code> is true, then a
     * search up the inheritance hierarchy will be performed and all super type environment entries will also be
     * retrieved.
     * 
     * @param classifier the classifier from which to retrieve the env-entries
     * @param follow true/false on whether or not to 'follow' the inheritance hierarchy when retrieving the
     * env-entries.
     * @return the collection of environment entries
     */
    static Collection<AttributeFacade> getEnvironmentEntries(ClassifierFacade classifier, boolean follow)
    {
        ExceptionUtils.checkNull("classifer", classifier);

        Collection<AttributeFacade> attributes = classifier.getStaticAttributes();

        if (follow)
        {
            for (classifier = (ClassifierFacade) classifier.getGeneralization(); classifier != null; classifier = (ClassifierFacade) classifier.getGeneralization())
            {
                attributes.addAll(classifier.getStaticAttributes());
            }
        }

        CollectionUtils.filter(attributes, new Predicate()
        {
            public boolean evaluate(Object object)
            {
                return ((AttributeFacade) object).hasStereotype(EJB3Profile.STEREOTYPE_ENV_ENTRY);
            }
        });

        return attributes;
    }

    /**
     * Returns the transaction type for the specified <code>classifier</code>.
     * 
     * @param classifier the classifier from which to retrieve the transaction type.
     * @param defaultTransactionType the default transaction type if no tagged value is specified.
     * @return the transaction type as a String.
     */
    static String getTransactionType(ClassifierFacade classifier, String defaultTransactionType)
    {
        ExceptionUtils.checkNull("classifer", classifier);

        String transactionType = (String) classifier.findTaggedValue(EJB3Profile.TAGGEDVALUE_EJB_TRANSACTION_TYPE);
        if (StringUtils.isNotBlank(transactionType))
        {
            transactionType = convertTransactionType(transactionType);
        } else
        {
            transactionType = defaultTransactionType;
        }
        return transactionType;
    }

    /**
     * Convert the transaction type from lower casing to upper casing.
     * This maintains reusable tagged value enumeration from EJB
     * implementation.
     * 
     * @param transType
     * @return transactionType
     */
    static String convertTransactionType(String transType)
    {
        ExceptionUtils.checkNull("transType", transType);

        String type = null;
        if (StringUtils.equalsIgnoreCase(transType, EJB3Globals.TRANSACTION_TYPE_MANDATORY))
        {
            type = "MANDATORY";
        } else if (StringUtils.equalsIgnoreCase(transType, EJB3Globals.TRANSACTION_TYPE_NEVER))
        {
            type = "NEVER";
        } else if (StringUtils.equalsIgnoreCase(transType, EJB3Globals.TRANSACTION_TYPE_NOT_SUPPORTED))
        {
            type = "NOT_SUPPORTED";
        } else if (StringUtils.equalsIgnoreCase(transType, EJB3Globals.TRANSACTION_TYPE_REQUIRED))
        {
            type = "REQUIRED";
        } else if (StringUtils.equalsIgnoreCase(transType, EJB3Globals.TRANSACTION_TYPE_REQUIRES_NEW))
        {
            type = "REQUIRES_NEW";
        } else if (StringUtils.equalsIgnoreCase(transType, EJB3Globals.TRANSACTION_TYPE_SUPPORTS))
        {
            type = "SUPPORTS";
        }
        return type;
    }

    /**
     * Gets all constants for the specified <code>classifier</code>.
     * If <code>follow</code> is true, then a search up
     * the inheritance hierarchy will be performed and all super
     * type constants will also be retrieved.
     * 
     * @param classifier the classifier from which to retrieve the constants
     * @param follow true/false on whether or not to 'follow' the inheritance hierarchy when retrieving the
     * constants.
     * @return the collection of environment entries
     */
    static Collection<AttributeFacade> getConstants(ClassifierFacade classifier, boolean follow)
    {
        ExceptionUtils.checkNull("classifer", classifier);

        Collection<AttributeFacade> attributes = classifier.getStaticAttributes();

        if (follow)
        {
            for (classifier = (ClassifierFacade) classifier.getGeneralization(); classifier != null; classifier = (ClassifierFacade) classifier.getGeneralization())
            {
                attributes.addAll(classifier.getStaticAttributes());
            }
        }

        CollectionUtils.filter(attributes, new Predicate()
        {
            public boolean evaluate(Object object)
            {
                return !((AttributeFacade) object).hasStereotype(EJB3Profile.STEREOTYPE_ENV_ENTRY);
            }
        });

        return attributes;
    }

    /**
     * Returns true/false based on whether or not synthetic or auto generated create methods should be allowed.
     * 
     * @param classifier The entity or session bean.
     * @return true/false
     */
    static boolean allowSyntheticCreateMethod(ClassifierFacade classifier)
    {
        ExceptionUtils.checkNull("classifer", classifier);
        return !classifier.isAbstract() && classifier.findTaggedValue(EJB3Profile.TAGGEDVALUE_EJB_NO_SYNTHETIC_CREATE_METHOD) == null;
    }

    /**
     * Creates a fully qualified name from the given <code>packageName</code>,
     * <code>name</code>, and <code>suffix</code>.
     * 
     * @param packageName the name of the model element package.
     * @param name the name of the model element.
     * @param suffix the suffix to append.
     * @return the new fully qualified name.
     */
    static String getFullyQualifiedName(String packageName, String name, String suffix)
    {
        StringBuilder fullyQualifiedName = new StringBuilder(StringUtils.trimToEmpty(packageName));
        if (StringUtils.isNotBlank(packageName))
        {
            fullyQualifiedName.append('.');
        }
        fullyQualifiedName.append(StringUtils.trimToEmpty(name));
        fullyQualifiedName.append(StringUtils.trimToEmpty(suffix));
        return fullyQualifiedName.toString();
    }

    /**
     * Returns true if the Seam stereotype is modeled on the class.
     * 
     * @param classifier The classifier to lookup if the stereotype is modeled
     * @return True is stereotype exists, false otherwise
     */
    static boolean isSeamComponent(ClassifierFacade classifier)
    {
        boolean isSeamComponent = false;
        if (classifier.hasStereotype(EJB3Profile.STEREOTYPE_SEAM_COMPONENT))
        {
            isSeamComponent = true;
        }
        return isSeamComponent;
    }

    /**
     * Gets the Seam component scope type for Entity and Session beans.
     * If no scope has been specified:
     * If the Classifier is a stateless session bean, then returns STATELESS
     * If the Classifier is an entity or stateful session bean, then returns CONVERSATION
     * 
     * @param classifier The classifier to lookup the scope type tagged value
     * @param stateless Whether the classifier is a stateless session bean
     * @return The scope type as a String
     */
    static String getSeamComponentScopeType(ClassifierFacade classifier, boolean stateless)
    {
        ExceptionUtils.checkNull("classifer", classifier);
        String scopeType = (String) classifier.findTaggedValue(EJB3Profile.TAGGEDVALUE_SEAM_SCOPE_TYPE);
        if (StringUtils.isBlank(scopeType))
        {
            if (stateless)
            {
                scopeType = EJB3Globals.SEAM_COMPONENT_SCOPE_STATELESS;
            } else
            {
                scopeType = EJB3Globals.SEAM_COMPONENT_SCOPE_CONVERSATION;
            }
        }
        return scopeType;
    }

    /**
     * Returns the Seam component name. Can override using tagged value, otherwise just the
     * class name.
     * 
     * @param classifier The classifier to get the tagged value or the name from.
     * @return The Seam component name
     */
    static String getSeamComponentName(ClassifierFacade classifier)
    {
        ExceptionUtils.checkNull("classifer", classifier);
        String componentName = (String) classifier.findTaggedValue(EJB3Profile.TAGGEDVALUE_SEAM_COMPONENT_NAME);
        if (StringUtils.isBlank(componentName))
        {
            componentName = StringUtils.uncapitalize(classifier.getName());
        }
        return componentName;
    }

    /**
     * Builds an annotation parameter line
     * 
     * @param parameters The parameters
     * @return The parameter line
     */
    static String buildAnnotationParameters(Collection<String> parameters)
    {
        StringBuilder buf = new StringBuilder();
        if (!parameters.isEmpty())
        {
            buf.append("(");
            Iterator it = parameters.iterator();
            while (it.hasNext())
            {
                String option = (String) it.next();
                buf.append(option);
                if (it.hasNext())
                {
                    buf.append(", ");
                }
            }
            buf.append(")");
            return buf.toString();
        } else
        {
            return null;
        }
    }

    /**
     * Builds a multi valued parameter string
     * 
     * @param name The name of the parameter
     * @param values The values for the parameters
     * @return The parameter string
     */
    static String buildAnnotationMultivalueParameter(String name, Collection<String> values)
    {
        return buildAnnotationMultivalueParameter(name, values, true);
    }

    /**
     * Builds a multi valued parameter string
     * 
     * @param name The name of the parameter
     * @param values The values for the parameters
     * @param areStrings If the values are strings then surround with " sign
     * @return The parameter string
     */
    static String buildAnnotationMultivalueParameter(String name, Collection<String> values, boolean areStrings)
    {
        return buildAnnotationMultivalueParameter(name, values, areStrings, null);
    }

    /**
     * Builds a multi option string
     * Builds a multi valued parameter string
     * 
     * @param name The name of the parameter
     * @param values The values for the parameters
     * @param areStrings If the values are strings then surround with " sign
     * @param suffix Any suffix to add to the values
     * @return The parameter string
     */
    static String buildAnnotationMultivalueParameter(String name, Collection<String> values, boolean areStrings, String suffix)
    {
        if (values.isEmpty())
        {
            return null;
        } else
        {
            StringBuilder buf = new StringBuilder();
            buf.append(name + " = {");

            Iterator it = values.iterator();
            while (it.hasNext())
            {
                String parameter = (String) it.next();
                if (areStrings)
                {
                    buf.append("\"");
                }
                buf.append(parameter);
                if ((suffix != null) && !parameter.endsWith(suffix))
                {
                    buf.append(suffix);
                }
                if (areStrings)
                {
                    buf.append("\"");
                }
                if (it.hasNext())
                {
                    buf.append(", ");
                }
            }
            buf.append("}");
            return buf.toString();
        }
    }

    /**
     * Gets the SQL name. (i.e. column name, table name, etc.). If it can't find
     * the corresponding tagged value with the specified <code>name</code>,
     * then it uses the element name by default and just returns that.
     * 
     * @param prefix the optional prefix to add to the sql name (i.e. table name
     * prefix, etc.).
     * @param element from which to retrieve the SQL name.
     * @param name the name of the tagged value.
     * @param nameMaxLength if this is not null, then the name returned will be
     * trimmed to this length (if it happens to be longer).
     * @param suffix the optional suffix to add to the sql name (i.e. foreign
     * key suffix, etc.)
     * @param separator character used to separate words
     * @return the SQL name as a String.
     */
    public static String getSqlNameFromTaggedValue(String prefix, final EJB3AssociationFacade element, String name, final Short nameMaxLength, String suffix, final Object separator)
    {
        if (element != null)
        {
            Object value = element.findTaggedValue(name);
            StringBuilder buffer = new StringBuilder(StringUtils.trimToEmpty((String) value));
            if (StringUtils.isBlank(buffer.toString()))
            {
                // if we can't find the tagValue then use the
                // element name for the name
                buffer = new StringBuilder(EntityMetafacadeUtils.toSqlName(element.getName(), separator));

                suffix = StringUtils.trimToEmpty(suffix);
                prefix = StringUtils.trimToEmpty(prefix);
                if (nameMaxLength != null)
                {
                    final short maxLength = (short) (nameMaxLength.shortValue() - suffix.length() - prefix.length());
                    buffer = new StringBuilder(EntityMetafacadeUtils.ensureMaximumNameLength(buffer.toString(), new Short(maxLength)));
                }
                if (StringUtils.isNotBlank(prefix))
                {
                    buffer.insert(0, prefix);
                }
                if (StringUtils.isNotBlank(suffix))
                {
                    buffer.append(suffix);
                }
            }
            name = buffer.toString();
        }
        return name;
    }
}
