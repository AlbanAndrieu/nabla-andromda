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
package org.andromda.cartridges.ejb3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.StringTokenizer;
import org.andromda.cartridges.ejb3.metafacades.EJB3AssociationEndFacade;
import org.andromda.cartridges.ejb3.metafacades.EJB3EntityAttributeFacade;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.lang.StringUtils;

/**
 * Transform class for the EJB3 cartridge.
 * 
 * @author Richard Kunze
 * @author Chad Brandon
 * @author Vance Karimi
 * @author Michail Plushnikov
 */
public class EJB3ScriptHelper
{
    /**
     * Create a collection of String objects representing the argument names.
     * 
     * @param args A comma separated list of arguments
     * @return Collection A collection of of Strings representing the arguments
     */
    public Collection<String> getArgumentsAsList(final String args)
    {
        StringTokenizer st = new StringTokenizer(args, ",");
        Collection<String> retval = new ArrayList<String>(st.countTokens());
        while (st.hasMoreTokens())
        {
            retval.add(st.nextToken().trim());
        }
        return retval;
    }

    /**
     * Filter a list of model elements by visibility.
     * 
     * @param list the original list
     * @param visibility the visibility - "public" "protected", "private" or the empty string (for package visibility)
     * @return a list with all elements from the original list that have a matching visibility.
     */
    public Collection<ModelElementFacade> filterByVisibility(final Collection<ModelElementFacade> list, final String visibility)
    {
        return CollectionUtils.select(list, new Predicate()
        {
            public boolean evaluate(final Object pObj)
            {
                ModelElementFacade elem = (ModelElementFacade) pObj;
                return visibility.equals(elem.getVisibility());
            }
        });
    }

    /**
     * Filter a list of EntityAttributes by removing all non-updatable attributes.
     * This filter currently removes all attributes that are of stereotype Version
     * It also removes identifier attributes for an entity with a composite primary key class
     * or if the identifier attribute has a specified generator.
     * 
     * @param list The original list
     * @param isCompositePKPresent True if entity has a composite primary key
     * @return Collection A list of EntityAttributes from the original list that are updatable
     */
    public Collection<EJB3EntityAttributeFacade> filterUpdatableAttributes(final Collection<EJB3EntityAttributeFacade> list, final boolean isCompositePKPresent)
    {
        return CollectionUtils.select(list, new Predicate()
        {
            public boolean evaluate(final Object pObj)
            {
                if (pObj instanceof EJB3EntityAttributeFacade)
                {
                    EJB3EntityAttributeFacade attr = (EJB3EntityAttributeFacade) pObj;
                    return !attr.isVersion() && ((isCompositePKPresent && !attr.isIdentifier()) || (!isCompositePKPresent && (attr.isIdentifier() && attr.isGeneratorTypeNone()) || !attr.isIdentifier()));
                } else
                {
                    System.out.println("NOT EJB3EntityAttributeFacade: " + pObj);
                    return false;
                }
            }
        });
    }

    /**
     * Filter a list of EntityAttributes by removing all audit attributes.
     * This filter currently removes all attributes that are of stereotype Version
     * It also removes identifier attributes for an entity with a composite primary key class
     * or if the identifier attribute have a specified generator.
     * 
     * @param list The original list
     * @param jpaFramework If using a JPA auditing framework. Filter none if not using it.
     * @return Collection A list of EntityAttributes from the original list that are updatable
     */
    public Collection<EJB3EntityAttributeFacade> filterAuditAttributes(final Collection<EJB3EntityAttributeFacade> list, final boolean jpaFramework)
    {
        return CollectionUtils.select(list, new Predicate()
        {
            public boolean evaluate(final Object pObj)
            {
                // returns true if attribute should not be filtered out
                if (pObj instanceof EJB3EntityAttributeFacade)
                {
                    EJB3EntityAttributeFacade attr = (EJB3EntityAttributeFacade) pObj;
                    /*
                     * System.out.println(attr.getOwner().getName() + " jpa=" + jpaFramework + " attr=" + attr.getName()
                     * + " return=" + (!jpaFramework || !(attr.getName().equals("createDate")
                     * || attr.getName().equals("createdBy") || attr.getName().equals("updateDate")
                     * || attr.getName().equals("updatedBy"))));
                     */
                    return (!jpaFramework || !(attr.getName().equals("createDate") || attr.getName().equals("createdBy") || attr.getName().equals("updateDate") || attr.getName().equals("updatedBy")));
                } else
                {
                    // System.out.println("NOT EJB3EntityAttributeFacade: " + pObj);
                    return false;
                }
            }
        });
    }

    /**
     * Filter a list of EntityAttributes by removing all non-required attributes.
     * This filter currently removes all attributes that are of stereotype Version
     * It also removes identifier attributes for an entity with a composite primary key class
     * or if the identifier attribute have a specified generator.
     * 
     * @param list The original list
     * @param isCompositePKPresent True if entity has a composite primary key
     * @return Collection A list of EntityAttributes from the original list that are updatable
     */
    public Collection<EJB3EntityAttributeFacade> filterRequiredAttributes(final Collection<EJB3EntityAttributeFacade> list, final boolean isCompositePKPresent)
    {
        return CollectionUtils.select(list, new Predicate()
        {
            public boolean evaluate(final Object pObj)
            {
                if (pObj instanceof EJB3EntityAttributeFacade)
                {
                    // Wrapped primitive may be set to column nullable = false to override nullable datatype
                    EJB3EntityAttributeFacade attr = (EJB3EntityAttributeFacade) pObj;
                    return !attr.isVersion() && !attr.isColumnNullable() && (!attr.isIdentifier() || (!isCompositePKPresent && attr.isGeneratorTypeNone())
                    /*
                     * ((isCompositePKPresent && !attr.isIdentifier()) ||
                     * (!isCompositePKPresent && (!attr.isIdentifier() ||
                     * (attr.isGeneratorTypeNone()))
                     */
                    );
                } else
                {
                    System.out.println("NOT EJB3EntityAttributeFacade: " + pObj);
                    return false;
                }
            }
        });
    }

    /**
     * Filter a list of EntityAssociationEnds by removing all non-required AssociationEnds.
     * It also removes identifier AssociationEnds for an entity with a composite primary key class
     * 
     * @param list The original list
     * @param isCompositePKPresent True if entity has a composite primary key
     * @return Collection A list of EntityAssociationEnds from the original list that are updatable
     */
    public Collection<EJB3AssociationEndFacade> filterRequiredAssociations(final Collection<EJB3AssociationEndFacade> list, final boolean isCompositePKPresent)
    {
        return CollectionUtils.select(list, new Predicate()
        {
            public boolean evaluate(final Object pObj)
            {
                if (pObj instanceof EJB3AssociationEndFacade)
                {
                    EJB3AssociationEndFacade assoc = (EJB3AssociationEndFacade) pObj;
                    return assoc.getOtherEnd().isRequired() || assoc.isIdentifier();
                    /*
                     * return attr.isRequired() &&
                     * ((isCompositePKPresent && !attr.isIdentifier()) ||
                     * (!isCompositePKPresent && (!attr.isIdentifier() ||
                     * (attr.isIdentifier()))
                     * ));
                     */
                } else
                {
                    System.out.println("NOT EJB3AssociationEndFacade: " + pObj);
                    return false;
                }
            }
        });
    }

    /**
     * Replaces all instances of the dot (.) in the name argument with an underscore (_)
     * and returns the string response.
     * 
     * @param name The name, typically a fully qualified name with dot notation
     * @return The string with all dots replaced with underscore.
     */
    public String toUnderscoreName(final String name)
    {
        return StringUtils.replaceChars(name, '.', '_');
    }

    private static final String BACKSLASH = "\"";
    private static final String QUOTE     = "'";

    /**
     * Removes instances of the quotation marks (" and ') at the beginning and end of the value argument
     * 
     * @param pValue The value, which can contains leading and trailing quotation marks
     * @return The string without quotation marks
     */
    public String removeQuotationmarks(final String pValue)
    {
        String result = StringUtils.removeStart(pValue, BACKSLASH);
        result = StringUtils.removeEnd(result, BACKSLASH);
        result = StringUtils.removeStart(result, QUOTE);
        return StringUtils.removeEnd(result, QUOTE);
    }

    private static final String COMMA = ", ";

    /**
     * Returns the comma separated list of interceptor classes.
     * 
     * @param interceptors The collection ModelElementFacade elements representing the interceptors
     * @param prepend Prefix any interceptors to the comma separated list
     * @return String containing the comma separated fully qualified class names
     */
    public String getInterceptorsAsList(final Collection<ModelElementFacade> interceptors, final String prepend)
    {
        StringBuilder sb = new StringBuilder();
        String separator = "";

        if (StringUtils.isNotBlank(prepend))
        {
            sb.append(prepend);
            separator = COMMA;
        }

        for (ModelElementFacade interceptor : interceptors)
        {
            sb.append(separator);
            separator = COMMA;
            sb.append(interceptor.getFullyQualifiedName()).append(".class");
        }
        return sb.toString();
    }

    /**
     * Reverses the <code>packageName</code>.
     * 
     * @param packageName the package name to reverse.
     * @return the reversed package name.
     */
    public static String reversePackage(final String packageName)
    {
        return StringUtils.reverseDelimited(packageName, EJB3Globals.NAMESPACE_DELIMITER);
    }
}
