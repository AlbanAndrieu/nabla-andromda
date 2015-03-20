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

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import org.andromda.cartridges.ejb3.EJB3Globals;
import org.andromda.cartridges.ejb3.EJB3Profile;
import org.andromda.core.common.ExceptionRecorder;
import org.andromda.metafacades.uml.AssociationEndFacade;
import org.andromda.metafacades.uml.AttributeFacade;
import org.andromda.metafacades.uml.ClassifierFacade;
import org.andromda.metafacades.uml.DependencyFacade;
import org.andromda.metafacades.uml.Entity;
import org.andromda.metafacades.uml.EntityAssociationEnd;
import org.andromda.metafacades.uml.EntityAttribute;
import org.andromda.metafacades.uml.EntityMetafacadeUtils;
import org.andromda.metafacades.uml.EnumerationFacade;
import org.andromda.metafacades.uml.GeneralizableElementFacade;
import org.andromda.metafacades.uml.MetafacadeUtils;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.OperationFacade;
import org.andromda.metafacades.uml.Role;
import org.andromda.metafacades.uml.TypeMappings;
import org.andromda.metafacades.uml.UMLMetafacadeProperties;
import org.andromda.metafacades.uml.UMLProfile;
import org.andromda.metafacades.uml.ValueObject;
import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.ejb3.metafacades.EJB3EntityFacade.
 * 
 * @see EJB3EntityFacade
 */
public class EJB3EntityFacadeLogicImpl extends EJB3EntityFacadeLogic
{
    private static final long               serialVersionUID                          = 34L;
    /**
     * The default entity association cascade property
     */
    public static final String              ENTITY_DEFAULT_CASCADE                    = "entityDefaultCascade";

    /**
     * Stores the default entity inheritance strategy
     */
    private static final String             ENTITY_INHERITANCE_STRATEGY               = "entityInheritanceStrategy";

    /**
     * Stores the default entity discriminator type used in the
     * inheritance annotation
     */
    private static final String             ENTITY_DISCRIMINATOR_TYPE                 = "entityDiscriminatorType";

    /**
     * Stores the default entity discriminator column name used in
     * the DiscriminatorColumn annotation
     */
    private static final String             ENTITY_DISCRIMINATOR_COLUMN_NAME          = "entityDiscriminatorColumnName";

    /**
     * The default view type accessibility for an entity POJO bean
     */
    public static final String              ENTITY_DEFAULT_VIEW_TYPE                  = "entityViewType";

    /**
     * Value for one table per root class
     */
    private static final String             INHERITANCE_STRATEGY_TABLE_PER_CLASS      = "TABLE_PER_CLASS";

    /**
     * Value for a single table for the hierarchy
     */
    private static final String             INHERITANCE_STRATEGY_SINGLE_TABLE         = "SINGLE_TABLE";

    /**
     * Value for joined subclass
     */
    private static final String             INHERITANCE_STRATEGY_JOINED_SUBLCASS      = "JOINED";

    /**
     * Stores the valid inheritance strategies
     */
    private static final Collection<String> inheritanceStrategies                     = new ArrayList<String>();

    static
    {
        inheritanceStrategies.add(INHERITANCE_STRATEGY_TABLE_PER_CLASS);
        inheritanceStrategies.add(INHERITANCE_STRATEGY_SINGLE_TABLE);
        inheritanceStrategies.add(INHERITANCE_STRATEGY_JOINED_SUBLCASS);
    }

    /**
     * Value for string based discriminator type
     */
    public static final String              DISCRIMINATORTYPE_STRING                  = "STRING";

    /**
     * Value for char based discriminator type
     */
    public static final String              DISCRIMINATORTYPE_CHAR                    = "CHAR";

    /**
     * Value for integer based discriminator type
     */
    public static final String              DISCRIMINATORTYPE_INTEGER                 = "INTEGER";

    /**
     * Stores the valid discriminator types
     */
    private static final Collection<String> discriminatorTypes                        = new ArrayList<String>();

    static
    {
        discriminatorTypes.add(DISCRIMINATORTYPE_STRING);
        discriminatorTypes.add(DISCRIMINATORTYPE_CHAR);
        discriminatorTypes.add(DISCRIMINATORTYPE_INTEGER);
    }

    /**
     * The property which stores the pattern defining the entity name.
     */
    public static final String              ENTITY_NAME_PATTERN                       = "entityNamePattern";

    /**
     * The property which stores the pattern defining the entity
     * implementation name.
     */
    public static final String              ENTITY_IMPLEMENTATION_NAME_PATTERN        = "entityImplementationNamePattern";

    /**
     * The property that stores the pattern defining the entity
     * listener class name.
     */
    public static final String              ENTITY_LISTENER_NAME_PATTERN              = "entityListenerNamePattern";

    /**
     * The property that stores the pattern defining the entity
     * embeddable super class name.
     */
    public static final String              ENTITY_EMBEDDABLE_NAME_PATTERN            = "entityEmbeddableNamePattern";

    /**
     * The property that stores the pattern defining the entity
     * composite primary key class name.
     */
    private static final String             ENTITY_COMPOSITE_PRIMARY_KEY_NAME_PATTERN = "entityCompositePrimaryKeyNamePattern";

    /**
     * The property that stores the generic finders option
     */
    private static final String             ENTITY_GENERIC_FINDERS                    = "entityGenericFinders";

    /**
     * The property that stores whether caching is enabled.
     */
    private static final String             HIBERNATE_ENABLE_CACHE                    = "hibernateEnableCache";

    /**
     * The property that stores the hibernate entity cache value.
     */
    private static final String             HIBERNATE_ENTITY_CACHE                    = "hibernateEntityCache";

    /**
     * The property that determines whether to use the default cache region for
     * entities and queries.
     */
    private static final String             USE_DEFAULT_CACHE_REGION                  = "useDefaultCacheRegion";

    /**
     * The pattern used to construct the DAO implementation name.
     */
    private static final String             DAO_IMPLEMENTATION_PATTERN                = "daoImplementationNamePattern";

    /**
     * The pattern used to construct the DAO base name.
     */
    private static final String             DAO_BASE_PATTERN                          = "daoBaseNamePattern";

    /**
     * The property which stores the pattern defining the DAO default exception name.
     */
    private static final String             DAO_DEFAULT_EXCEPTION_NAME_PATTERN        = "daoDefaultExceptionNamePattern";

    // ---------------- constructor -------------------------------

    /**
     * @param metaObject
     * @param context
     */
    public EJB3EntityFacadeLogicImpl(final Object metaObject, final String context)
    {
        super(metaObject, context);
    }

    // --------------- methods ---------------------

    /**
     * This was meant to overrides the default implementation in EntityLogicImpl.java.
     * TODO: check - is it really required?
     * 
     * @return identifiers
     * @see EJB3EntityFacade#getIdentifiers()
     */
    public Collection handleGetIdentifiers()
    {
        Collection identifiers = new ArrayList();
        // This looks at dependencies only, not attributes or association identifiers
        for (final DependencyFacade dep : this.getSourceDependencies())
        {
            if (dep.hasStereotype(EJB3Profile.STEREOTYPE_IDENTIFIER))
            {
                identifiers = ((ClassifierFacade) dep.getTargetElement()).getInstanceAttributes();
                MetafacadeUtils.filterByStereotype(identifiers, EJB3Profile.STEREOTYPE_IDENTIFIER);
                return identifiers;
            }
        }

        // No PK dependency found - use PK attribute/association identifiers
        Collection<ModelElementFacade> entityIdentifiers = this.getIdentifiers(true);
        if (entityIdentifiers != null && !entityIdentifiers.isEmpty())
        {
            identifiers.addAll(entityIdentifiers);
        }

        // Still nothing found - recurse up the inheritance tree
        GeneralizableElementFacade general = this.getGeneralization();
        if (identifiers.isEmpty() && general instanceof EJB3EntityFacade)
        {
            identifiers = ((EJB3EntityFacade) general).getIdentifiers();
        }
        return identifiers;
    }

    /**
     * This overrides the default implementation in EntityLogicImpl.java.
     * This provides the means to check super classes, even those modeled
     * as mapped superclasses, as well as entities.
     * Gets all identifiers for this entity. If 'follow' is true, and if
     * no identifiers can be found on the entity, a search up the
     * inheritance chain will be performed, and the identifiers from
     * the first super class having them will be used.
     * 
     * @param follow a flag indicating whether or not the inheritance hierarchy
     * should be followed
     * @return the collection of identifiers.
     */
    public Collection<ModelElementFacade> getIdentifiers(boolean follow)
    {
        final List<AttributeFacade> attributes = this.getAttributes();
        MetafacadeUtils.filterByStereotype(attributes, UMLProfile.STEREOTYPE_IDENTIFIER);

        final List<AssociationEndFacade> associations = this.getAssociationEnds();
        MetafacadeUtils.filterByStereotype(associations, UMLProfile.STEREOTYPE_IDENTIFIER);

        if (attributes.isEmpty() && associations.isEmpty() && follow)
        {
            if (this.getGeneralization() instanceof EJB3EntityFacade)
            {
                return ((EJB3EntityFacade) this.getGeneralization()).getIdentifiers(follow);
            } else if (this.getGeneralization() instanceof EJB3MappedSuperclassFacade)
            {
                return ((EJB3MappedSuperclassFacade) this.getGeneralization()).getIdentifiers(follow);
            }
        }
        Collection<ModelElementFacade> identifiers = new ArrayList<ModelElementFacade>();
        for (AttributeFacade attribute : attributes)
        {
            identifiers.add((EntityAttribute) attribute);
        }
        for (AssociationEndFacade association : associations)
        {
            identifiers.add((EntityAssociationEnd) association);
        }
        return identifiers;
    }

    /**
     * @see EJB3EntityFacade#isSyntheticCreateMethodAllowed()
     */
    @Override
    protected boolean handleIsSyntheticCreateMethodAllowed()
    {
        return EJB3MetafacadeUtils.allowSyntheticCreateMethod(this);
    }

    /**
     * @return getEntityRelations()
     * @see EJB3EntityFacade#getAllEntityRelations()
     */
    protected Collection handleGetAllEntityRelations()
    {
        return this.getEntityRelations();
    }

    /**
     * @see EJB3EntityFacade#getJndiName()
     */
    @Override
    protected String handleGetJndiName()
    {
        StringBuilder jndiName = new StringBuilder();
        String jndiNamePrefix = StringUtils.trimToEmpty(this.getJndiNamePrefix());
        if (StringUtils.isNotBlank(jndiNamePrefix))
        {
            jndiName.append(jndiNamePrefix);
            jndiName.append("/");
        }
        jndiName.append("ejb/");
        jndiName.append(this.getFullyQualifiedName());
        return jndiName.toString();
    }

    /**
     * Gets the <code>jndiNamePrefix</code> for this EJB.
     * 
     * @return the EJB Jndi name prefix.
     */
    protected String getJndiNamePrefix()
    {
        String prefix = null;
        if (this.isConfiguredProperty(EJB3Globals.JNDI_NAME_PREFIX))
        {
            prefix = (String) this.getConfiguredProperty(EJB3Globals.JNDI_NAME_PREFIX);
        }
        return prefix;
    }

    /**
     * @see EJB3EntityFacade#getViewType()
     */
    @Override
    protected String handleGetViewType()
    {
        return EJB3MetafacadeUtils.getViewType(this, String.valueOf(this.getConfiguredProperty(ENTITY_DEFAULT_VIEW_TYPE)));
    }

    /**
     * @return EJB3MetafacadeUtils.getAllInstanceAttributes(this)
     * @see EJB3EntityFacade#getAllInstanceAttributes()
     */
    protected List handleGetAllInstanceAttributes()
    {
        return EJB3MetafacadeUtils.getAllInstanceAttributes(this);
    }

    /**
     * @return EJB3MetafacadeUtils.getInheritedInstanceAttributes(this)
     * @see EJB3EntityFacade#getInheritedInstanceAttributes()
     */
    protected List handleGetInheritedInstanceAttributes()
    {
        return EJB3MetafacadeUtils.getInheritedInstanceAttributes(this);
    }

    /**
     * @see EJB3EntityFacade#getHomeInterfaceName()
     */
    @Override
    protected String handleGetHomeInterfaceName()
    {
        return EJB3MetafacadeUtils.getHomeInterfaceName(this);
    }

    /**
     * @return dependencies
     * @see EJB3EntityFacade#getValueDependencies()
     * NOTE: This is not required since ValueObject no longer exist and replaced with POJOs
     */
    protected Collection handleGetValueDependencies()
    {
        Collection dependencies = super.getSourceDependencies();
        CollectionUtils.filter(dependencies, new Predicate()
        {
            public boolean evaluate(Object object)
            {
                boolean isValueRef = false;
                if (object instanceof DependencyFacade)
                {
                    DependencyFacade dep = (DependencyFacade) object;
                    isValueRef = dep.getStereotypeNames().contains(EJB3Profile.STEREOTYPE_VALUE_REF) && dep.getTargetElement().hasExactStereotype(EJB3Profile.STEREOTYPE_VALUE_OBJECT);
                }
                return isValueRef;
            }
        });
        return dependencies;
    }

    /**
     * @return entityRelations
     * @see EJB3EntityFacade#getEntityRelations()
     */
    protected Collection handleGetEntityRelations()
    {
        Collection<AssociationEndFacade> result = new ArrayList<AssociationEndFacade>();
        for (final AssociationEndFacade associationEnd : this.getAssociationEnds())
        {
            ClassifierFacade target = associationEnd.getOtherEnd().getType();
            if (target instanceof EJB3EntityFacade && associationEnd.getOtherEnd().isNavigable())
            {
                result.add(associationEnd);
            }
        }

        return result;
    }

    /**
     * @param follow
     * @return EJB3MetafacadeUtils.getCreateMethods(this, follow)
     * @see EJB3EntityFacade#getCreateMethods(boolean)
     */
    protected Collection handleGetCreateMethods(boolean follow)
    {
        return EJB3MetafacadeUtils.getCreateMethods(this, follow);
    }

    /**
     * @param follow
     * @return selectMethods
     * @see EJB3EntityFacade#getSelectMethods(boolean)
     */
    protected Collection<OperationFacade> handleGetSelectMethods(boolean follow)
    {
        Collection<OperationFacade> retval = new ArrayList<OperationFacade>();
        EJB3EntityFacade entity = null;
        do
        {
            for (final OperationFacade op : this.getOperations())
            {
                if (op.hasStereotype(EJB3Profile.STEREOTYPE_SELECT_METHOD))
                {
                    retval.add(op);
                }
            }
            if (follow)
            {
                entity = (EJB3EntityFacade) this.getGeneralization();
            } else
            {
                break;
            }
        } while (entity != null);
        return retval;
    }

    /**
     * @param follow
     * @return EJB3MetafacadeUtils.getEnvironmentEntries(this, follow)
     * @see EJB3EntityFacade#getEnvironmentEntries(boolean)
     */
    protected Collection handleGetEnvironmentEntries(boolean follow)
    {
        return EJB3MetafacadeUtils.getEnvironmentEntries(this, follow);
    }

    /**
     * @param follow
     * @return EJB3MetafacadeUtils.getConstants(this, follow)
     * @see EJB3EntityFacade#getConstants(boolean)
     */
    protected Collection handleGetConstants(boolean follow)
    {
        return EJB3MetafacadeUtils.getConstants(this, follow);
    }

    /**
     * @see EJB3EntityFacade#isOperationPresent(String)
     */
    @Override
    protected boolean handleIsOperationPresent(String op)
    {
        Collection collOps = this.getOperations();
        for (final Iterator it = collOps.iterator(); it.hasNext();)
        {
            final OperationFacade operation = (OperationFacade) it.next();
            if (operation.getName().equalsIgnoreCase(op))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * @see EJB3EntityFacade#isAttributePresent(String)
     */
    @Override
    protected boolean handleIsAttributePresent(String att)
    {
        Collection collAttrib = this.getAttributes(true);
        for (final Iterator it = collAttrib.iterator(); it.hasNext();)
        {
            final AttributeFacade attr = (AttributeFacade) it.next();
            if (attr.getName().equalsIgnoreCase(att))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * @see EJB3EntityFacade#isIdentifierPresent(String)
     */
    @Override
    protected boolean handleIsIdentifierPresent(String id)
    {
        Collection collIdentifier = this.getIdentifiers(true);
        for (final Iterator it = collIdentifier.iterator(); it.hasNext();)
        {
            final AttributeFacade attr = (AttributeFacade) it.next();
            if (attr.getName().equalsIgnoreCase(id))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * @see EJB3EntityFacade#getSqlType()
     */
    @Override
    protected String handleGetSqlType()
    {
        String mpSql = this.getMappingsProperty(UMLMetafacadeProperties.SQL_MAPPINGS_URI).getMappings().getName();
        if (mpSql.startsWith("Oracle"))
        {
            mpSql = "ORACLE";
        }
        return mpSql;
    }

    /**
     * Gets a Mappings instance from a property registered under the given <code>propertyName</code>.
     * 
     * @param propertyName the property name to register under.
     * @return the Mappings instance.
     */
    private TypeMappings getMappingsProperty(final String propertyName)
    {
        Object property = this.getConfiguredProperty(propertyName);
        TypeMappings mappings = null;
        String uri = null;
        if (property instanceof String)
        {
            uri = (String) property;
            try
            {
                mappings = TypeMappings.getInstance(uri);
                this.setProperty(propertyName, mappings);
            } catch (Throwable th)
            {
                String errMsg = "Error getting '" + propertyName + "' --> '" + uri + "'";
                // don't throw the exception
                ExceptionRecorder.instance().record(errMsg, th);
            }
        } else
        {
            mappings = (TypeMappings) property;
        }
        return mappings;
    }

    /**
     * @see org.andromda.metafacades.uml.Entity#getBusinessOperations()
     */
    public Collection<OperationFacade> getBusinessOperations()
    {
        Collection<OperationFacade> operations = super.getBusinessOperations();
        CollectionUtils.filter(operations, new Predicate()
        {
            public boolean evaluate(Object object)
            {
                boolean businessOperation = false;
                if (EJB3OperationFacade.class.isAssignableFrom(object.getClass()))
                {
                    businessOperation = ((EJB3OperationFacade) object).isBusinessOperation();
                }
                return businessOperation;
            }
        });
        return operations;
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetEntityCompositePrimaryKeyName()
     */
    @Override
    protected String handleGetEntityCompositePrimaryKeyName()
    {
        String compPKPattern = String.valueOf(this.getConfiguredProperty(ENTITY_COMPOSITE_PRIMARY_KEY_NAME_PATTERN));

        return MessageFormat.format(compPKPattern, StringUtils.trimToEmpty(this.getName()));
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetEntityListenerName()
     */
    @Override
    protected String handleGetEntityListenerName()
    {
        String entityListenerPattern = (String) this.getConfiguredProperty(ENTITY_LISTENER_NAME_PATTERN);

        return MessageFormat.format(entityListenerPattern, StringUtils.trimToEmpty(this.getName()));
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetEntityEmbeddableName()
     */
    @Override
    protected String handleGetEntityEmbeddableName()
    {
        String embeddableSuperclassName = (String) this.getConfiguredProperty(ENTITY_EMBEDDABLE_NAME_PATTERN);

        return MessageFormat.format(embeddableSuperclassName, StringUtils.trimToEmpty(this.getName()));
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetEntityName()
     */
    @Override
    protected String handleGetEntityName()
    {
        String entityNamePattern = (String) this.getConfiguredProperty(ENTITY_NAME_PATTERN);

        return MessageFormat.format(entityNamePattern, StringUtils.trimToEmpty(this.getName()));
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetFullyQualifiedEntityCompositePrimaryKeyName()
     */
    @Override
    protected String handleGetFullyQualifiedEntityCompositePrimaryKeyName()
    {
        return EJB3MetafacadeUtils.getFullyQualifiedName(this.getPackageName(), this.getEntityCompositePrimaryKeyName(), null);
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetEntityImplementationName()
     */
    @Override
    protected String handleGetEntityImplementationName()
    {
        String implNamePattern = String.valueOf(this.getConfiguredProperty(ENTITY_IMPLEMENTATION_NAME_PATTERN));

        return MessageFormat.format(implNamePattern, StringUtils.trimToEmpty(this.getName()));
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetFullyQualifiedEntityListenerName()
     */
    @Override
    protected String handleGetFullyQualifiedEntityListenerName()
    {
        return EJB3MetafacadeUtils.getFullyQualifiedName(this.getPackageName(), this.getEntityListenerName(), null);
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetFullyQualifiedEntityEmbeddableName()
     */
    @Override
    protected String handleGetFullyQualifiedEntityEmbeddableName()
    {
        return EJB3MetafacadeUtils.getFullyQualifiedName(this.getPackageName(), this.getEntityEmbeddableName(), null);
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetFullyQualifiedEntityName()
     */
    @Override
    protected String handleGetFullyQualifiedEntityName()
    {
        return EJB3MetafacadeUtils.getFullyQualifiedName(this.getPackageName(), this.getEntityName(), null);
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetFullyQualifiedEntityImplementationName()
     */
    @Override
    protected String handleGetFullyQualifiedEntityImplementationName()
    {
        return EJB3MetafacadeUtils.getFullyQualifiedName(this.getPackageName(), this.getEntityImplementationName(), null);
    }

    /**
     * @param targetSuffix
     * @return BeanName
     * @see org.andromda.cartridges.spring.metafacades.SpringEntity#getBeanName(boolean)
     */
    protected String handleGetBeanName(boolean targetSuffix)
    {
        final String beanName = StringUtils.uncapitalize(StringUtils.trimToEmpty(this.getName()));
        StringBuilder beanNameBuffer = new StringBuilder(String.valueOf(this.getConfiguredProperty(EJB3Globals.BEAN_NAME_PREFIX)));
        beanNameBuffer.append(this.getDaoNamePattern().replaceAll("\\{0\\}", beanName));
        if (targetSuffix)
        {
            beanNameBuffer.append(EJB3Globals.BEAN_NAME_TARGET_SUFFIX);
        }
        return beanNameBuffer.toString();
    }

    /**
     * Override the default table name definition to lookup the tagged value first.
     * 
     * @return tableName
     */
    @Override
    public String getTableName()
    {
        String tableName = (String) this.findTaggedValue(EJB3Profile.TAGGEDVALUE_PERSISTENCE_ENTITY_TABLE_NAME);
        if (StringUtils.isBlank(tableName))
        {
            tableName = super.getTableName();
        }
        return tableName;
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetDefaultCascadeType()
     */
    @Override
    protected String handleGetDefaultCascadeType()
    {
        return StringUtils.trimToEmpty(String.valueOf(this.getConfiguredProperty(ENTITY_DEFAULT_CASCADE)));
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetDiscriminatorColumn()
     */
    @Override
    protected String handleGetDiscriminatorColumn()
    {
        String discriminatorColumnName = (String) this.findTaggedValue(EJB3Profile.TAGGEDVALUE_PERSISTENCE_DISCRIMINATOR_COLUMN);
        if (StringUtils.isBlank(discriminatorColumnName))
        {
            discriminatorColumnName = String.valueOf(this.getConfiguredProperty(ENTITY_DISCRIMINATOR_COLUMN_NAME));
        }
        return discriminatorColumnName;
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetDiscriminatorColumnDefinition()
     */
    @Override
    protected String handleGetDiscriminatorColumnDefinition()
    {
        return (String) this.findTaggedValue(EJB3Profile.TAGGEDVALUE_PERSISTENCE_DISCRIMINATOR_COLUMN_DEFINITION);
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetDiscriminatorLength()
     */
    protected int handleGetDiscriminatorLength()
    {
        int length = 0;
        String lengthAsStr = (String) this.findTaggedValue(EJB3Profile.TAGGEDVALUE_PERSISTENCE_DISCRIMINATOR_COLUMN_LENGTH);
        if (StringUtils.isNotBlank(lengthAsStr))
        {
            length = NumberUtils.toInt(lengthAsStr);
        }
        return length;
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetDiscriminatorType()
     */
    @Override
    protected String handleGetDiscriminatorType()
    {
        String discriminatorType = (String) this.findTaggedValue(EJB3Profile.TAGGEDVALUE_PERSISTENCE_DISCRIMINATOR_TYPE);
        if (StringUtils.isBlank(discriminatorType))
        {
            discriminatorType = String.valueOf(this.getConfiguredProperty(ENTITY_DISCRIMINATOR_TYPE));
        }
        return discriminatorType;
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetDiscriminatorValue()
     */
    @Override
    protected String handleGetDiscriminatorValue()
    {
        String discriminatorValue = (String) this.findTaggedValue(EJB3Profile.TAGGEDVALUE_PERSISTENCE_DISCRIMINATOR_VALUE);
        if (StringUtils.isBlank(discriminatorValue))
        {
            discriminatorValue = StringUtils.substring(this.getEntityName(), 0, 1);
        }
        return discriminatorValue;
    }

    /**
     * Gets the default entity inhertance strategy from namespace.
     * 
     * @return the default entity inheritance strategy.
     */
    private String getDefaultInheritanceStrategy()
    {
        return String.valueOf(this.getConfiguredProperty(ENTITY_INHERITANCE_STRATEGY));
    }

    /**
     * Return the inheritance tagged value for for given <code>entity</code>.
     * 
     * @param entity EJB3EntityFacade from which to retrieve the inheritance tagged value.
     * @return String inheritance tagged value.
     */
    private String getInheritance(EJB3EntityFacade entity)
    {
        String inheritance = null;
        if (entity != null)
        {
            Object value = entity.findTaggedValue(EJB3Profile.TAGGEDVALUE_PERSISTENCE_INHERITANCE);
            if (value != null)
            {
                inheritance = String.valueOf(value);
            }
        }
        return inheritance;
    }

    /**
     * Returns the super entity for this entity, if one exists by generalization. If a
     * generalization does NOT exist OR if it's not an instance of EJB3EntityFacade
     * then returns null.
     * 
     * @return the super entity or null if one doesn't exist.
     */
    private EJB3EntityFacade getSuperEntity()
    {
        EJB3EntityFacade superEntity = null;
        if ((this.getGeneralization() != null) && this.getGeneralization() instanceof EJB3EntityFacade && !this.getGeneralization().hasStereotype(EJB3Profile.STEREOTYPE_MAPPED_SUPERCLASS))
        {
            superEntity = (EJB3EntityFacade) this.getGeneralization();
        }
        return superEntity;
    }

    /**
     * @see EJB3EntityFacadeLogic#handleIsInheritanceSingleTable()
     */
    @Override
    protected boolean handleIsInheritanceSingleTable()
    {
        return this.getInheritanceStrategy().equalsIgnoreCase(INHERITANCE_STRATEGY_SINGLE_TABLE);
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetInheritanceStrategy()
     */
    @Override
    protected String handleGetInheritanceStrategy()
    {
        String inheritance = this.getInheritance(this);
        for (EJB3EntityFacade superEntity = this.getSuperEntity(); (superEntity != null) && StringUtils.isBlank(inheritance);)
        {
            inheritance = superEntity.getInheritanceStrategy();
        }

        if (StringUtils.isBlank(inheritance) || !inheritanceStrategies.contains(inheritance))
        {
            inheritance = this.getDefaultInheritanceStrategy();
        }
        return inheritance;
    }

    /**
     * @see EJB3EntityFacadeLogic#handleIsInheritanceTablePerClass()
     */
    @Override
    protected boolean handleIsInheritanceTablePerClass()
    {
        return this.getInheritanceStrategy().equalsIgnoreCase(INHERITANCE_STRATEGY_TABLE_PER_CLASS);
    }

    /**
     * @see EJB3EntityFacadeLogic#handleIsInheritanceJoined()
     */
    @Override
    protected boolean handleIsInheritanceJoined()
    {
        return this.getInheritanceStrategy().equalsIgnoreCase(INHERITANCE_STRATEGY_JOINED_SUBLCASS);
    }

    /**
     * Returns true if this entity is a <code>root</code> entity and has no generalizations.
     * 
     * @return
     */
    private boolean isRoot()
    {
        final EJB3EntityFacade superEntity = this.getSuperEntity();
        return (superEntity == null && !this.isAbstract());
    }

    /**
     * @see EJB3EntityFacadeLogic#handleIsRequiresSpecializationMapping()
     */
    @Override
    protected boolean handleIsRequiresSpecializationMapping()
    {
        return (this.isInheritanceSingleTable() || this.isInheritanceTablePerClass() || this.isInheritanceJoined()) && !this.getSpecializations().isEmpty();
    }

    /**
     * @see EJB3EntityFacadeLogic#handleIsRequiresGeneralizationMapping()
     */
    @Override
    protected boolean handleIsRequiresGeneralizationMapping()
    {
        return (this.getSuperEntity() != null && (this.getSuperEntity().isInheritanceSingleTable() || this.getSuperEntity().isInheritanceTablePerClass() || this.getSuperEntity().isInheritanceJoined()));
    }

    /**
     * @see EJB3EntityFacadeLogic#handleIsEmbeddableSuperclass()
     */
    @Override
    protected boolean handleIsEmbeddableSuperclass()
    {
        boolean isEmbeddableSuperclass = this.hasStereotype(EJB3Profile.STEREOTYPE_MAPPED_SUPERCLASS);

        /**
         * Must the root class - Cannot have embeddable superclass in the middle of the hierarchy
         */
        return isEmbeddableSuperclass && isRoot();
    }

    /**
     * @see EJB3EntityFacadeLogic#handleIsEmbeddableSuperclassGeneralizationExists()
     */
    @Override
    protected boolean handleIsEmbeddableSuperclassGeneralizationExists()
    {
        return (this.getSuperEntity() != null && this.getSuperEntity().isEmbeddableSuperclass());
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetAttributesAsList(Collection, boolean, boolean, boolean)
     */
    @Override
    protected String handleGetAttributesAsList(Collection attributes, boolean includeTypes, boolean includeNames, boolean includeAutoIdentifiers)
    {
        if ((!includeNames && !includeTypes) || attributes == null)
        {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        String separator = "";

        boolean isCompositePKPresent = this.isCompositePrimaryKeyPresent();
        if (isCompositePKPresent)
        {
            if (includeTypes)
            {
                sb.append(this.getFullyQualifiedName()).append("PK");
            }
            sb.append(" pk");
            separator = ", ";
        }
        for (final Object obj : attributes)
        {
            if (obj instanceof EJB3EntityAttributeFacade)
            {
                EJB3EntityAttributeFacade attr = (EJB3EntityAttributeFacade) obj;
                // Do not include attributes that are assigned for optimistic lock value as a version
                if (!attr.isVersion())
                {
                    /*
                     * Do not include identifier attributes for entities with a composite primary key
                     * or if includeAutoIdentifiers is false, do not include identifiers with auto generated values.
                     */
                    if (!attr.isIdentifier() || (!isCompositePKPresent && (includeAutoIdentifiers || attr.isGeneratorTypeNone())))
                    {
                        sb.append(separator);
                        separator = ", ";
                        if (includeTypes)
                        {
                            /*
                             * If attribute is a LOB and lob type is overridden, then use
                             * overriding lob type.
                             */
                            if (attr.isLob() && StringUtils.isNotBlank(attr.getLobType()))
                            {
                                sb.append(attr.getLobType());
                            } else
                            {
                                sb.append(attr.getGetterSetterTypeName());
                            }
                            sb.append(" ");
                        }
                        if (includeNames)
                        {
                            sb.append(attr.getName());
                        }
                    }
                }
            }
            if (obj instanceof EJB3AssociationEndFacade)
            {
                EJB3AssociationEndFacade assoc = (EJB3AssociationEndFacade) obj;
                /*
                 * Do not include identifier attributes for entities with a composite primary key
                 * or if includeAutoIdentifiers is false, do not include identifiers with auto generated values.
                 */
                // System.out.println(this.getName() + "." + assoc.getName() + " Identifier:" + assoc.isIdentifier() + " isCompositePKPresent:" + isCompositePKPresent + " includeAutoIdentifiers:" +
                // includeAutoIdentifiers);
                if (!assoc.isIdentifier() || !isCompositePKPresent)
                {
                    sb.append(separator);
                    separator = ", ";
                    if (includeTypes)
                    {
                        sb.append(assoc.getGetterSetterTypeName()).append(" ");
                    }
                    if (includeNames)
                    {
                        sb.append(assoc.getName());
                    }
                }
            }
        }
        return sb.toString();
    }

    /**
     * @see EJB3EntityFacadeLogic#handleIsGenericFinders()
     */
    @Override
    protected boolean handleIsGenericFinders()
    {
        return BooleanUtils.toBoolean(String.valueOf(this.getConfiguredProperty(ENTITY_GENERIC_FINDERS)));
    }

    /**
     * @see EJB3EntityFacadeLogic#handleIsCompositePrimaryKeyPresent()
     */
    @Override
    protected boolean handleIsCompositePrimaryKeyPresent()
    {
        boolean isCompositePK = false;
        if (this.getIdentifiers().size() > 1)
        {
            isCompositePK = true;
        }
        return isCompositePK;
    }

    /**
     * @see EJB3EntityFacadeLogic#handleIsListenerEnabled()
     */
    @Override
    protected boolean handleIsListenerEnabled()
    {
        return this.hasStereotype(EJB3Profile.STEREOTYPE_LISTENER);
    }

    /**
     * @see EJB3EntityFacadeLogic#handleIsFinderFindAllExists()
     */
    @Override
    protected boolean handleIsFinderFindAllExists()
    {
        boolean finderExists = false;
        for (final Iterator iter = this.getQueryOperations().iterator(); iter.hasNext();)
        {
            final OperationFacade operation = (OperationFacade) iter.next();
            if ("findAll".equalsIgnoreCase(StringUtils.trimToEmpty(operation.getName())))
            {
                // Check for no finder arguments
                if (operation.getArguments().isEmpty())
                {
                    finderExists = true;
                    break;
                }
            }
        }
        return finderExists;
    }

    /**
     * @see EJB3EntityFacadeLogic#handleIsFinderFindByPrimaryKeyExists()
     */
    @Override
    protected boolean handleIsFinderFindByPrimaryKeyExists()
    {
        boolean finderExists = false;
        for (final Iterator iter = this.getQueryOperations().iterator(); iter.hasNext();)
        {
            final OperationFacade operation = (OperationFacade) iter.next();
            if ("findByPrimaryKey".equalsIgnoreCase(operation.getName()))
            {
                finderExists = true;
                break;
            }
        }
        return finderExists;
    }

    /**
     * @see EJB3EntityFacadeLogic#handleIsManageable()
     */
    @Override
    protected boolean handleIsManageable()
    {
        return this.hasStereotype(EJB3Profile.STEREOTYPE_MANAGEABLE);
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetManageableDisplayAttribute()
     */
    protected AttributeFacade handleGetManageableDisplayAttribute()
    {
        AttributeFacade displayAttribute = null;

        final Object taggedValueObject = this.findTaggedValue(UMLProfile.TAGGEDVALUE_MANAGEABLE_DISPLAY_NAME);
        if (taggedValueObject != null)
        {
            displayAttribute = this.findAttribute(StringUtils.trimToEmpty(taggedValueObject.toString()));
        }

        final Collection<AttributeFacade> attributes = this.getAttributes(true);
        for (final Iterator<AttributeFacade> attributeIterator = attributes.iterator(); attributeIterator.hasNext() && displayAttribute == null;)
        {
            final AttributeFacade attribute = attributeIterator.next();
            if (attribute.isUnique())
            {
                displayAttribute = attribute;
            }
        }

        if (displayAttribute == null)
        {
            if (!this.getIdentifiers().isEmpty())
            {
                ModelElementFacade facade = this.getIdentifiers().iterator().next();
                if (facade instanceof AttributeFacade)
                {
                    displayAttribute = (AttributeFacade) facade;
                } else if (!attributes.isEmpty())
                {
                    displayAttribute = (EntityAttribute) attributes.iterator().next();
                }
            } else if (!attributes.isEmpty())
            {
                displayAttribute = (EntityAttribute) attributes.iterator().next();
            }
        }

        return displayAttribute;
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetIdentifier()
     */
    protected ModelElementFacade handleGetIdentifier()
    {
        ModelElementFacade identifier = null;
        final Collection<ModelElementFacade> identifiers = this.getIdentifiers();
        if (identifiers != null && !identifiers.isEmpty())
        {
            identifier = this.getIdentifiers().iterator().next();
        }
        return identifier;
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetCacheType()
     */
    @Override
    protected String handleGetCacheType()
    {
        String cacheType = (String) findTaggedValue(EJB3Profile.TAGGEDVALUE_HIBERNATE_ENTITY_CACHE);
        if (StringUtils.isBlank(cacheType))
        {
            cacheType = String.valueOf(this.getConfiguredProperty(HIBERNATE_ENTITY_CACHE));
        }
        return StringUtils.trimToEmpty(cacheType);
    }

    /**
     * @see EJB3EntityFacadeLogic#handleIsCacheEnabled()
     */
    @Override
    protected boolean handleIsCacheEnabled()
    {
        return BooleanUtils.toBoolean(String.valueOf(this.getConfiguredProperty(HIBERNATE_ENABLE_CACHE)));
    }

    /**
     * @see EJB3EntityFacadeLogic#handleIsUseDefaultCacheRegion()
     */
    @Override
    protected boolean handleIsUseDefaultCacheRegion()
    {
        return BooleanUtils.toBoolean(String.valueOf(this.getConfiguredProperty(USE_DEFAULT_CACHE_REGION)));
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetDaoName()
     */
    @Override
    protected String handleGetDaoName()
    {
        return MessageFormat.format(getDaoNamePattern(), StringUtils.trimToEmpty(this.getName()));
    }

    /**
     * @return getDaoNamePattern().replaceAll("\\{0\\}", getName())
     * @see org.andromda.cartridges.spring.metafacades.SpringEntity#getDaoName()
     */
    /*
     * protected String handleGetDaoName()
     * {
     * return this.getDaoNamePattern().replaceAll(
     * "\\{0\\}",
     * this.getName());
     * }
     */

    /**
     * Gets the value of the {@link EJB3Globals#DAO_PATTERN}
     * 
     * @return the DAO name pattern.
     */
    private String getDaoNamePattern()
    {
        return String.valueOf(this.getConfiguredProperty(EJB3Globals.DAO_PATTERN));
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetFullyQualifiedDaoName()
     */
    @Override
    protected String handleGetFullyQualifiedDaoName()
    {
        return EJB3MetafacadeUtils.getFullyQualifiedName(this.getPackageName(), this.getDaoName(), null);
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetDaoImplementationName()
     */
    @Override
    protected String handleGetDaoImplementationName()
    {
        return MessageFormat.format(getDaoImplementationNamePattern(), StringUtils.trimToEmpty(this.getName()));
    }

    /**
     * Gets the value of the {@link #DAO_IMPLEMENTATION_PATTERN}
     * 
     * @return the DAO implementation name pattern.
     */
    private String getDaoImplementationNamePattern()
    {
        return String.valueOf(this.getConfiguredProperty(DAO_IMPLEMENTATION_PATTERN));
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetFullyQualifiedDaoImplementationName()
     */
    @Override
    protected String handleGetFullyQualifiedDaoImplementationName()
    {
        return EJB3MetafacadeUtils.getFullyQualifiedName(this.getPackageName(), this.getDaoImplementationName(), null);
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetDaoBaseName()
     */
    @Override
    protected String handleGetDaoBaseName()
    {
        return MessageFormat.format(getDaoBaseNamePattern(), StringUtils.trimToEmpty(this.getName()));
    }

    /**
     * Gets the value of the {@link #DAO_BASE_PATTERN}
     * 
     * @return the DAO base name pattern.
     */
    private String getDaoBaseNamePattern()
    {
        return String.valueOf(this.getConfiguredProperty(DAO_BASE_PATTERN));
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetFullyQualifiedDaoBaseName()
     */
    @Override
    protected String handleGetFullyQualifiedDaoBaseName()
    {
        return EJB3MetafacadeUtils.getFullyQualifiedName(this.getPackageName(), this.getDaoBaseName(), null);
    }

    /**
     * @see EJB3EntityFacadeLogic#handleIsDaoBusinessOperationsPresent()
     */
    @Override
    protected boolean handleIsDaoBusinessOperationsPresent()
    {
        return this.getDaoBusinessOperations() != null && !this.getDaoBusinessOperations().isEmpty();
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetDaoBusinessOperations()
     */
    protected Collection<OperationFacade> handleGetDaoBusinessOperations()
    {
        // operations that are not finders and static
        Collection finders = this.getQueryOperations();
        Collection<OperationFacade> operations = this.getOperations();

        Collection<OperationFacade> nonFinders = CollectionUtils.subtract(operations, finders);
        CollectionUtils.filter(nonFinders, new Predicate()
        {
            public boolean evaluate(Object object)
            {
                return ((OperationFacade) object).isStatic();
            }
        });
        return nonFinders;
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetValueObjectReferences()
     */
    protected Collection<DependencyFacade> handleGetValueObjectReferences()
    {
        return this.getValueObjectReferences(false);
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetAllValueObjectReferences()
     */
    protected Collection<DependencyFacade> handleGetAllValueObjectReferences()
    {
        return this.getValueObjectReferences(true);
    }

    /**
     * @see EJB3EntityFacadeLogic#handleIsDaoImplementationRequired()
     */
    @Override
    protected boolean handleIsDaoImplementationRequired()
    {
        return !this.getValueObjectReferences().isEmpty() || !this.getDaoBusinessOperations().isEmpty() || !this.getQueryOperations(true).isEmpty();
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetDaoNoTransformationConstantName()
     */
    @Override
    protected String handleGetDaoNoTransformationConstantName()
    {
        return EJB3Globals.TRANSFORMATION_CONSTANT_PREFIX + EJB3Globals.NO_TRANSFORMATION_CONSTANT_SUFFIX;
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetValueObjectReferences(boolean)
     */
    protected Collection<DependencyFacade> handleGetValueObjectReferences(boolean follow)
    {
        final Collection<DependencyFacade> sourceDependencies = new ArrayList<DependencyFacade>(this.getSourceDependencies());
        if (follow)
        {
            for (GeneralizableElementFacade entity = this.getGeneralization(); entity != null; entity = entity.getGeneralization())
            {
                sourceDependencies.addAll(entity.getSourceDependencies());
            }
        }
        Collection<DependencyFacade> valueDependencies = new ArrayList<DependencyFacade>();
        for (DependencyFacade dependency : sourceDependencies)
        {
            Object targetElement = dependency.getTargetElement();
            if (targetElement instanceof ClassifierFacade)
            {
                ClassifierFacade element = (ClassifierFacade) targetElement;
                if (element.isDataType() || element instanceof ValueObject || element instanceof EnumerationFacade)
                {
                    valueDependencies.add(dependency);
                }
            }
        }
        return valueDependencies;
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetRoot()
     */
    protected Object handleGetRoot()
    {
        GeneralizableElementFacade generalization = this;
        for (; generalization.getGeneralization() != null && generalization instanceof EJB3EntityFacade; generalization = generalization.getGeneralization())
            ;
        return generalization;
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetDefaultPersistenceContextUnitName()
     */
    @Override
    protected String handleGetDefaultPersistenceContextUnitName()
    {
        return StringUtils.trimToEmpty(ObjectUtils.toString(this.getConfiguredProperty(EJB3Globals.PERSISTENCE_CONTEXT_UNIT_NAME)));
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetDaoDefaultExceptionName()
     */
    @Override
    protected String handleGetDaoDefaultExceptionName()
    {
        return MessageFormat.format(getDaoDefaultExceptionNamePattern(), StringUtils.trimToEmpty(this.getName()));
    }

    /**
     * Gets the value of the {@link #DAO_DEFAULT_EXCEPTION_NAME_PATTERN}
     * 
     * @return the DAO default exception name pattern.
     */
    private String getDaoDefaultExceptionNamePattern()
    {
        return String.valueOf(this.getConfiguredProperty(DAO_DEFAULT_EXCEPTION_NAME_PATTERN));
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetFullyQualifiedDaoDefaultExceptionName()
     */
    @Override
    protected String handleGetFullyQualifiedDaoDefaultExceptionName()
    {
        return EJB3MetafacadeUtils.getFullyQualifiedName(this.getPackageName(), this.getDaoDefaultExceptionName(), null);
    }

    /**
     * @see EJB3EntityFacadeLogic#handleIsEntityImplementationRequired()
     */
    @Override
    protected boolean handleIsEntityImplementationRequired()
    {
        return !this.getBusinessOperations().isEmpty();
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetInstanceAttributes(boolean, boolean)
     */
    protected Collection<AttributeFacade> handleGetInstanceAttributes(boolean follow, boolean withIdentifiers)
    {
        final Collection<AttributeFacade> attributes = this.getAttributes(follow, withIdentifiers);
        CollectionUtils.filter(attributes, new Predicate()
        {
            public boolean evaluate(Object object)
            {
                boolean valid = true;
                if (object instanceof EntityAttribute)
                {
                    valid = !((EntityAttribute) object).isStatic();
                }
                return valid;
            }
        });
        // If a 1:1 owned identifier relationship, the dependent identifier attributes should be included in addition to the association
        // and the generator="foreign" and @PrimaryKeyJoinColumn annotations are used.
        final List<AssociationEndFacade> associationEnds = this.getAssociationEnds();
        /*
         * MetafacadeUtils.filterByStereotype(
         * associationEnds,
         * UMLProfile.STEREOTYPE_IDENTIFIER);
         */
        // System.out.println("GetInstanceAttributes " + this.getFullyQualifiedName() + " associationEnds=" + this.getAssociationEnds().size() + " identifiers=" + associationEnds.size());
        for (AssociationEndFacade associationEnd : associationEnds)
        {
            // System.out.println("GetInstanceAttributes " + this.getFullyQualifiedName() + " " + associationEnd.getOtherEnd().getFullyQualifiedName() + " Identifier=" +
            // associationEnd.getOtherEnd().hasStereotype("Identifier") + " associationEnd=" + associationEnd + " One2One=" + associationEnd.getOtherEnd().isOne2One() + " Type=" + associationEnd.getOtherEnd().getType());
            if (associationEnd.getOtherEnd().hasStereotype("Identifier") && associationEnd.getOtherEnd().isOne2One() && !associationEnd.getOtherEnd().hasStereotype(UMLProfile.STEREOTYPE_TRANSIENT)
                    && associationEnd.getOtherEnd() instanceof EJB3AssociationEndFacade)
            {
                EJB3AssociationEndFacade ejb3AssociationEnd = (EJB3AssociationEndFacade) associationEnd;
                // System.out.println("GetInstanceAttributes " + this.getFullyQualifiedName() + " " + ejb3AssociationEnd + " Owning=" + ejb3AssociationEnd.isOwning() + " Aggregation=" + ejb3AssociationEnd.isAggregation()
                // + " Composition=" + ejb3AssociationEnd.isComposition() + " OAggregation=" + ejb3AssociationEnd.getOtherEnd().isAggregation() + " OComposition=" + ejb3AssociationEnd.getOtherEnd().isComposition());
                if (ejb3AssociationEnd.isOwning())
                {
                    Entity entity = (Entity) ejb3AssociationEnd.getType();
                    Collection<ModelElementFacade> identifierAttributes = EntityMetafacadeUtils.getIdentifierAttributes(entity, follow);
                    // System.out.println("GetInstanceAttributes " + this.getFullyQualifiedName() + " entity=" + entity + " Attributes=" + identifierAttributes);
                    for (ModelElementFacade identifier : identifierAttributes)
                    {
                        // System.out.println(identifier);
                        if (identifier instanceof AttributeFacade)
                        {
                            attributes.add((AttributeFacade) identifier);
                            // System.out.println("Added " + identifier + " to entity=" + entity);
                        }
                    }
                }
            }
        }
        return attributes;
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetInstanceAttributeNameList(boolean, boolean)
     */
    @Override
    protected String handleGetInstanceAttributeNameList(boolean follow, boolean withIdentifiers)
    {
        return this.getNameList(this.getInstanceAttributes(follow, withIdentifiers));
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetInstanceAttributeTypeList(boolean, boolean)
     */
    @Override
    protected String handleGetInstanceAttributeTypeList(boolean follow, boolean withIdentifiers)
    {
        return this.getTypeList(this.getInstanceAttributes(follow, withIdentifiers));
    }

    /**
     * Constructs a comma separated list of attribute type names from the passed in collection of
     * <code>attributes</code>.
     * 
     * @param attributes the attributes to construct the list from.
     * @return the comma separated list of attribute types.
     */
    private String getTypeList(final Collection attributes)
    {
        final StringBuilder list = new StringBuilder();
        final String comma = ", ";
        CollectionUtils.forAllDo(attributes, new Closure()
        {
            public void execute(final Object object)
            {
                if (object instanceof AttributeFacade)
                {
                    final AttributeFacade attribute = (AttributeFacade) object;
                    if (attribute.getType() != null)
                    {
                        list.append(attribute.getGetterSetterTypeName());
                        list.append(comma);
                    }
                }
                if (object instanceof AssociationEndFacade)
                {
                    final AssociationEndFacade associationEnd = (AssociationEndFacade) object;
                    if (associationEnd.getType() != null)
                    {
                        list.append(associationEnd.getGetterSetterTypeName());
                        list.append(comma);
                    }
                }
            }
        });
        if (list.toString().endsWith(comma))
        {
            list.delete(list.lastIndexOf(comma), list.length());
        }
        return list.toString();
    }

    /**
     * Constructs a comma separated list of attribute names from the passed in collection of <code>attributes</code>.
     * 
     * @param properties the properties to construct the list from.
     * @return the comma separated list of attribute names.
     */
    private String getNameList(final Collection properties)
    {
        final StringBuilder list = new StringBuilder();
        final String comma = ", ";
        CollectionUtils.forAllDo(properties, new Closure()
        {
            public void execute(Object object)
            {
                if (object instanceof EntityAttribute)
                {
                    list.append(((AttributeFacade) object).getName());
                    list.append(comma);
                }
                if (object instanceof EntityAssociationEnd)
                {
                    list.append(((AssociationEndFacade) object).getName());
                    list.append(comma);
                }
            }
        });
        if (list.toString().endsWith(comma))
        {
            list.delete(list.lastIndexOf(comma), list.length());
        }
        return list.toString();
    }

    /**
     * @see EJB3EntityFacadeLogic#handleIsSecurityEnabled()
     */
    @Override
    protected boolean handleIsSecurityEnabled()
    {
        return StringUtils.isNotBlank(this.getSecurityRealm());
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetRolesAllowed()
     */
    @Override
    protected String handleGetRolesAllowed()
    {
        StringBuilder rolesAllowed = null;
        String separator = "";

        for (final Iterator iter = this.getNonRunAsRoles().iterator(); iter.hasNext();)
        {
            if (rolesAllowed == null)
            {
                rolesAllowed = new StringBuilder();
            }
            rolesAllowed.append(separator);
            Role role = (Role) iter.next();
            rolesAllowed.append('"');
            rolesAllowed.append(role.getName());
            rolesAllowed.append('"');
            separator = ", ";
        }
        return rolesAllowed != null ? rolesAllowed.toString() : null;
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetSecurityRealm()
     */
    @Override
    protected String handleGetSecurityRealm()
    {
        String securityRealm = (String) this.findTaggedValue(EJB3Profile.TAGGEDVALUE_EJB_SECURITY_REALM);
        if (StringUtils.isBlank(securityRealm))
        {
            securityRealm = StringUtils.trimToEmpty(ObjectUtils.toString(this.getConfiguredProperty(EJB3Globals.SECURITY_REALM)));
        }
        return securityRealm;
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetNonRunAsRoles()
     */
    protected Collection handleGetNonRunAsRoles()
    {
        Collection<DependencyFacade> roles = this.getTargetDependencies();
        CollectionUtils.filter(roles, new Predicate()
        {
            public boolean evaluate(final Object object)
            {
                DependencyFacade dependency = (DependencyFacade) object;
                return dependency != null && dependency.getSourceElement() != null && dependency.getSourceElement() instanceof Role && !dependency.hasStereotype(EJB3Profile.STEREOTYPE_SECURITY_RUNAS);
            }
        });
        CollectionUtils.transform(roles, new Transformer()
        {
            public Object transform(final Object object)
            {
                return ((DependencyFacade) object).getSourceElement();
            }
        });
        final Collection allRoles = new LinkedHashSet(roles);
        // add all roles which are generalizations of this one
        CollectionUtils.forAllDo(roles, new Closure()
        {
            public void execute(final Object object)
            {
                allRoles.addAll(((Role) object).getAllSpecializations());
            }
        });
        return allRoles;
    }

    /**
     * @see EJB3EntityFacadeLogic#handleIsUseQueryCache()
     */
    @Override
    protected boolean handleIsUseQueryCache()
    {
        return BooleanUtils.toBoolean(String.valueOf(this.getConfiguredProperty(EJB3Globals.HIBERNATE_USER_QUERY_CACHE)));
    }

    /**
     * @see EJB3EntityFacadeLogic#handleIsSeamComponent()
     */
    @Override
    protected boolean handleIsSeamComponent()
    {
        return EJB3MetafacadeUtils.isSeamComponent(this);
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetSeamComponentScopeType()
     */
    @Override
    protected String handleGetSeamComponentScopeType()
    {
        return EJB3MetafacadeUtils.getSeamComponentScopeType(this, false);
    }

    /**
     * @see EJB3EntityFacadeLogic#handleGetSeamComponentName()
     */
    @Override
    protected String handleGetSeamComponentName()
    {
        return EJB3MetafacadeUtils.getSeamComponentName(this);
    }
}
