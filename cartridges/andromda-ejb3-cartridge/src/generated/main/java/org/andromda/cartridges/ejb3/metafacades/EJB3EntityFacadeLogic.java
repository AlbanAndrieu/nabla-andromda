// license-header java merge-point
//
// Attention: generated code (by MetafacadeLogic.vsl) - do not modify!
//
package org.andromda.cartridges.ejb3.metafacades;

import java.util.Collection;
import java.util.List;
import org.andromda.core.common.Introspector;
import org.andromda.core.metafacade.MetafacadeBase;
import org.andromda.core.metafacade.MetafacadeFactory;
import org.andromda.core.metafacade.ModelValidationMessage;
import org.andromda.metafacades.uml.AssociationEndFacade;
import org.andromda.metafacades.uml.AttributeFacade;
import org.andromda.metafacades.uml.ClassifierFacade;
import org.andromda.metafacades.uml.ConstraintFacade;
import org.andromda.metafacades.uml.DependencyFacade;
import org.andromda.metafacades.uml.Entity;
import org.andromda.metafacades.uml.EntityAssociationEnd;
import org.andromda.metafacades.uml.EntityQueryOperation;
import org.andromda.metafacades.uml.GeneralizableElementFacade;
import org.andromda.metafacades.uml.GeneralizationFacade;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.ModelFacade;
import org.andromda.metafacades.uml.OperationFacade;
import org.andromda.metafacades.uml.PackageFacade;
import org.andromda.metafacades.uml.Role;
import org.andromda.metafacades.uml.StateMachineFacade;
import org.andromda.metafacades.uml.StereotypeFacade;
import org.andromda.metafacades.uml.TaggedValueFacade;
import org.andromda.metafacades.uml.TemplateParameterFacade;
import org.andromda.metafacades.uml.TypeMappings;
import org.andromda.translation.ocl.validation.OCLCollections;
import org.andromda.translation.ocl.validation.OCLIntrospector;
import org.andromda.translation.ocl.validation.OCLResultEnsurer;
import org.apache.log4j.Logger;

/**
 * Represents an entity EJB.
 * MetafacadeLogic for EJB3EntityFacade
 *
 * @see EJB3EntityFacade
 */
public abstract class EJB3EntityFacadeLogic
    extends MetafacadeBase
    implements EJB3EntityFacade
{

    private static final long serialVersionUID = 1L;

    /**
     * The underlying UML object
     * @see Object
     */
    protected transient Object metaObject;

    /** Create Metafacade implementation instance using the MetafacadeFactory from the context
     * @param metaObjectIn
     * @param context
     */
    protected EJB3EntityFacadeLogic(final Object metaObjectIn, String context)
    {
        super(metaObjectIn, getContext(context));
        this.superEntity =
           (Entity)
            MetafacadeFactory.getInstance().createFacadeImpl(
                    "org.andromda.metafacades.uml.Entity",
                    metaObjectIn,
                    getContext(context));
        this.metaObject = metaObjectIn;
    }

    /**
     * The logger instance.
     */
    private static final Logger LOGGER = Logger.getLogger(EJB3EntityFacadeLogic.class);

    /**
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to EJB3EntityFacade if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.ejb3.metafacades.EJB3EntityFacade";
        }
        return context;
    }

    private Entity superEntity;
    private boolean superEntityInitialized = false;

    /**
     * Gets the Entity parent instance.
     * @return this.superEntity Entity
     */
    private Entity getSuperEntity()
    {
        if (!this.superEntityInitialized)
        {
            ((MetafacadeBase)this.superEntity).setMetafacadeContext(this.getMetafacadeContext());
            this.superEntityInitialized = true;
        }
        return this.superEntity;
    }

    /** Reset context only for non-root metafacades
     * @param context
     * @see MetafacadeBase#resetMetafacadeContext(String context)
     */
    @Override
    public void resetMetafacadeContext(String context)
    {
        if (!this.contextRoot) // reset context only for non-root metafacades
        {
            context = getContext(context);  // to have same value as in original constructor call
            setMetafacadeContext (context);
            if (this.superEntityInitialized)
            {
                ((MetafacadeBase)this.superEntity).resetMetafacadeContext(context);
            }
        }
    }

    /**
     * @return boolean true always
     * @see EJB3EntityFacade
     */
    public boolean isEJB3EntityFacadeMetaType()
    {
        return true;
    }

    // --------------- attributes ---------------------

   /**
    * @see EJB3EntityFacade#isSyntheticCreateMethodAllowed()
    * @return boolean
    */
    protected abstract boolean handleIsSyntheticCreateMethodAllowed();

    private transient boolean syntheticCreateMethodAllowed1a;
    private transient boolean syntheticCreateMethodAllowed1aSet = false;

    /**
     * Whether or not to allow a synthetic (auto generated) create method.
     * @return (boolean)handleIsSyntheticCreateMethodAllowed()
     */
    public final boolean isSyntheticCreateMethodAllowed()
    {
        boolean syntheticCreateMethodAllowed1a = this.syntheticCreateMethodAllowed1a;
        if (!this.syntheticCreateMethodAllowed1aSet)
        {
            // syntheticCreateMethodAllowed has no pre constraints
            syntheticCreateMethodAllowed1a = handleIsSyntheticCreateMethodAllowed();
            // syntheticCreateMethodAllowed has no post constraints
            this.syntheticCreateMethodAllowed1a = syntheticCreateMethodAllowed1a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.syntheticCreateMethodAllowed1aSet = true;
            }
        }
        return syntheticCreateMethodAllowed1a;
    }

   /**
    * @see EJB3EntityFacade#getAllEntityRelations()
    * @return Collection
    */
    protected abstract Collection handleGetAllEntityRelations();

    private transient Collection allEntityRelations2a;
    private transient boolean allEntityRelations2aSet = false;

    /**
     * Find all associations that define relations to other entities.
     * This method returns the source association ends for all associations that define
     * a container managed relation.  The returned collection includes both
     * direct relations and inherited relations. A direct relation is an association with some other
     * class matching the following criteria: 1) The class at the other side of the association is
     * stereotyped <<Entity>> 2) The association is navigable from to the other side.
     * An inherited relation is an association from an abstract super type matching the following
     * criteria: 1) The inheritance path to this abstract super type, including this super type
     * itself, consists only of abstract classes with stereotype <<Entity>> 2)  The class at the
     * other side of the association is stereotyped <<Entity>>. 3) The association is navigable from
     * this abstract super type to the other side.
     * Relations must match the following integrity constraint:
     * - The <<Entity>> at the target end is not abstract.
     * The integrity constraint is necessary because the target of a container managed relation in
     * the EJB framework must be a concrete entity bean; there is no such thing as an
     * "abstract entity bean" in the EJB specification. It is possible, however, to generate and
     * compile code for this case, an error will only show up at deploy time. In order to catch
     * this kind of error at the earliest possible stage, this method checks the integrity
     * constraint and throws an exception if it is violated.
     * @return (Collection)handleGetAllEntityRelations()
     */
    public final Collection getAllEntityRelations()
    {
        Collection allEntityRelations2a = this.allEntityRelations2a;
        if (!this.allEntityRelations2aSet)
        {
            // allEntityRelations has no pre constraints
            allEntityRelations2a = handleGetAllEntityRelations();
            // allEntityRelations has no post constraints
            this.allEntityRelations2a = allEntityRelations2a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.allEntityRelations2aSet = true;
            }
        }
        return allEntityRelations2a;
    }

   /**
    * @see EJB3EntityFacade#getJndiName()
    * @return String
    */
    protected abstract String handleGetJndiName();

    private transient String jndiName3a;
    private transient boolean jndiName3aSet = false;

    /**
     * TODO: Model Documentation for
     * EJB3EntityFacade.jndiName
     * @return (String)handleGetJndiName()
     */
    public final String getJndiName()
    {
        String jndiName3a = this.jndiName3a;
        if (!this.jndiName3aSet)
        {
            // jndiName has no pre constraints
            jndiName3a = handleGetJndiName();
            // jndiName has no post constraints
            this.jndiName3a = jndiName3a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.jndiName3aSet = true;
            }
        }
        return jndiName3a;
    }

   /**
    * @see EJB3EntityFacade#getViewType()
    * @return String
    */
    protected abstract String handleGetViewType();

    private transient String viewType4a;
    private transient boolean viewType4aSet = false;

    /**
     * A string indicating whether the Bean is a local or remotely accessable bean.
     * @return (String)handleGetViewType()
     */
    public final String getViewType()
    {
        String viewType4a = this.viewType4a;
        if (!this.viewType4aSet)
        {
            // viewType has no pre constraints
            viewType4a = handleGetViewType();
            // viewType has no post constraints
            this.viewType4a = viewType4a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.viewType4aSet = true;
            }
        }
        return viewType4a;
    }

   /**
    * @see EJB3EntityFacade#getAllInstanceAttributes()
    * @return List
    */
    protected abstract List handleGetAllInstanceAttributes();

    private transient List allInstanceAttributes5a;
    private transient boolean allInstanceAttributes5aSet = false;

    /**
     * All instanceAttributes for this entity. The list includes the instanceAttributes that are
     * inherited from super classes. The list contains the inherited instanceAttributes first,
     * followed by the instanceAttributes defined in this class.
     * @return (List)handleGetAllInstanceAttributes()
     */
    public final List getAllInstanceAttributes()
    {
        List allInstanceAttributes5a = this.allInstanceAttributes5a;
        if (!this.allInstanceAttributes5aSet)
        {
            // allInstanceAttributes has no pre constraints
            allInstanceAttributes5a = handleGetAllInstanceAttributes();
            // allInstanceAttributes has no post constraints
            this.allInstanceAttributes5a = allInstanceAttributes5a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.allInstanceAttributes5aSet = true;
            }
        }
        return allInstanceAttributes5a;
    }

   /**
    * @see EJB3EntityFacade#getInheritedInstanceAttributes()
    * @return List
    */
    protected abstract List handleGetInheritedInstanceAttributes();

    private transient List inheritedInstanceAttributes6a;
    private transient boolean inheritedInstanceAttributes6aSet = false;

    /**
     * All inherited instanceAttributes this class.  The instanceAttributes are grouped by the class
     * that defines the instanceAttributes, with instanceAttributes from the most removed super
     * class first.
     * @return (List)handleGetInheritedInstanceAttributes()
     */
    public final List getInheritedInstanceAttributes()
    {
        List inheritedInstanceAttributes6a = this.inheritedInstanceAttributes6a;
        if (!this.inheritedInstanceAttributes6aSet)
        {
            // inheritedInstanceAttributes has no pre constraints
            inheritedInstanceAttributes6a = handleGetInheritedInstanceAttributes();
            // inheritedInstanceAttributes has no post constraints
            this.inheritedInstanceAttributes6a = inheritedInstanceAttributes6a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.inheritedInstanceAttributes6aSet = true;
            }
        }
        return inheritedInstanceAttributes6a;
    }

   /**
    * @see EJB3EntityFacade#getHomeInterfaceName()
    * @return String
    */
    protected abstract String handleGetHomeInterfaceName();

    private transient String homeInterfaceName7a;
    private transient boolean homeInterfaceName7aSet = false;

    /**
     * A String representing the name of a home interface for this entity EJB.
     * @return (String)handleGetHomeInterfaceName()
     */
    public final String getHomeInterfaceName()
    {
        String homeInterfaceName7a = this.homeInterfaceName7a;
        if (!this.homeInterfaceName7aSet)
        {
            // homeInterfaceName has no pre constraints
            homeInterfaceName7a = handleGetHomeInterfaceName();
            // homeInterfaceName has no post constraints
            this.homeInterfaceName7a = homeInterfaceName7a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.homeInterfaceName7aSet = true;
            }
        }
        return homeInterfaceName7a;
    }

   /**
    * @see EJB3EntityFacade#getValueDependencies()
    * @return Collection
    */
    protected abstract Collection handleGetValueDependencies();

    private transient Collection valueDependencies8a;
    private transient boolean valueDependencies8aSet = false;

    /**
     * TODO: Model Documentation for
     * EJB3EntityFacade.valueDependencies
     * @return (Collection)handleGetValueDependencies()
     */
    public final Collection getValueDependencies()
    {
        Collection valueDependencies8a = this.valueDependencies8a;
        if (!this.valueDependencies8aSet)
        {
            // valueDependencies has no pre constraints
            valueDependencies8a = handleGetValueDependencies();
            // valueDependencies has no post constraints
            this.valueDependencies8a = valueDependencies8a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.valueDependencies8aSet = true;
            }
        }
        return valueDependencies8a;
    }

   /**
    * @see EJB3EntityFacade#getEntityRelations()
    * @return Collection
    */
    protected abstract Collection handleGetEntityRelations();

    private transient Collection entityRelations9a;
    private transient boolean entityRelations9aSet = false;

    /**
     * TODO: Model Documentation for
     * EJB3EntityFacade.entityRelations
     * @return (Collection)handleGetEntityRelations()
     */
    public final Collection getEntityRelations()
    {
        Collection entityRelations9a = this.entityRelations9a;
        if (!this.entityRelations9aSet)
        {
            // entityRelations has no pre constraints
            entityRelations9a = handleGetEntityRelations();
            // entityRelations has no post constraints
            this.entityRelations9a = entityRelations9a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.entityRelations9aSet = true;
            }
        }
        return entityRelations9a;
    }

   /**
    * @see EJB3EntityFacade#getEntityListenerName()
    * @return String
    */
    protected abstract String handleGetEntityListenerName();

    private transient String entityListenerName10a;
    private transient boolean entityListenerName10aSet = false;

    /**
     * Entity listener class name for callback methods.
     * @return (String)handleGetEntityListenerName()
     */
    public final String getEntityListenerName()
    {
        String entityListenerName10a = this.entityListenerName10a;
        if (!this.entityListenerName10aSet)
        {
            // entityListenerName has no pre constraints
            entityListenerName10a = handleGetEntityListenerName();
            // entityListenerName has no post constraints
            this.entityListenerName10a = entityListenerName10a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.entityListenerName10aSet = true;
            }
        }
        return entityListenerName10a;
    }

   /**
    * @see EJB3EntityFacade#getEntityEmbeddableName()
    * @return String
    */
    protected abstract String handleGetEntityEmbeddableName();

    private transient String entityEmbeddableName11a;
    private transient boolean entityEmbeddableName11aSet = false;

    /**
     * Entity embeddable super class name this entity inherits from.
     * @return (String)handleGetEntityEmbeddableName()
     */
    public final String getEntityEmbeddableName()
    {
        String entityEmbeddableName11a = this.entityEmbeddableName11a;
        if (!this.entityEmbeddableName11aSet)
        {
            // entityEmbeddableName has no pre constraints
            entityEmbeddableName11a = handleGetEntityEmbeddableName();
            // entityEmbeddableName has no post constraints
            this.entityEmbeddableName11a = entityEmbeddableName11a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.entityEmbeddableName11aSet = true;
            }
        }
        return entityEmbeddableName11a;
    }

   /**
    * @see EJB3EntityFacade#getFullyQualifiedEntityListenerName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedEntityListenerName();

    private transient String fullyQualifiedEntityListenerName12a;
    private transient boolean fullyQualifiedEntityListenerName12aSet = false;

    /**
     * Fully qualified name of the Entity listner class holding entity callback methods.
     * @return (String)handleGetFullyQualifiedEntityListenerName()
     */
    public final String getFullyQualifiedEntityListenerName()
    {
        String fullyQualifiedEntityListenerName12a = this.fullyQualifiedEntityListenerName12a;
        if (!this.fullyQualifiedEntityListenerName12aSet)
        {
            // fullyQualifiedEntityListenerName has no pre constraints
            fullyQualifiedEntityListenerName12a = handleGetFullyQualifiedEntityListenerName();
            // fullyQualifiedEntityListenerName has no post constraints
            this.fullyQualifiedEntityListenerName12a = fullyQualifiedEntityListenerName12a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedEntityListenerName12aSet = true;
            }
        }
        return fullyQualifiedEntityListenerName12a;
    }

   /**
    * @see EJB3EntityFacade#getFullyQualifiedEntityEmbeddableName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedEntityEmbeddableName();

    private transient String fullyQualifiedEntityEmbeddableName13a;
    private transient boolean fullyQualifiedEntityEmbeddableName13aSet = false;

    /**
     * The fully qualified name of the embeddable super class of this entity.
     * @return (String)handleGetFullyQualifiedEntityEmbeddableName()
     */
    public final String getFullyQualifiedEntityEmbeddableName()
    {
        String fullyQualifiedEntityEmbeddableName13a = this.fullyQualifiedEntityEmbeddableName13a;
        if (!this.fullyQualifiedEntityEmbeddableName13aSet)
        {
            // fullyQualifiedEntityEmbeddableName has no pre constraints
            fullyQualifiedEntityEmbeddableName13a = handleGetFullyQualifiedEntityEmbeddableName();
            // fullyQualifiedEntityEmbeddableName has no post constraints
            this.fullyQualifiedEntityEmbeddableName13a = fullyQualifiedEntityEmbeddableName13a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedEntityEmbeddableName13aSet = true;
            }
        }
        return fullyQualifiedEntityEmbeddableName13a;
    }

   /**
    * @see EJB3EntityFacade#getDefaultCascadeType()
    * @return String
    */
    protected abstract String handleGetDefaultCascadeType();

    private transient String defaultCascadeType14a;
    private transient boolean defaultCascadeType14aSet = false;

    /**
     * Returns the default entity cascadable property attribute looked up in the namespace
     * descriptor.
     * @return (String)handleGetDefaultCascadeType()
     */
    public final String getDefaultCascadeType()
    {
        String defaultCascadeType14a = this.defaultCascadeType14a;
        if (!this.defaultCascadeType14aSet)
        {
            // defaultCascadeType has no pre constraints
            defaultCascadeType14a = handleGetDefaultCascadeType();
            // defaultCascadeType has no post constraints
            this.defaultCascadeType14a = defaultCascadeType14a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.defaultCascadeType14aSet = true;
            }
        }
        return defaultCascadeType14a;
    }

   /**
    * @see EJB3EntityFacade#getDiscriminatorColumn()
    * @return String
    */
    protected abstract String handleGetDiscriminatorColumn();

    private transient String discriminatorColumn15a;
    private transient boolean discriminatorColumn15aSet = false;

    /**
     * The name of the discriminator column.  Default is TYPE if this is missing.
     * @return (String)handleGetDiscriminatorColumn()
     */
    public final String getDiscriminatorColumn()
    {
        String discriminatorColumn15a = this.discriminatorColumn15a;
        if (!this.discriminatorColumn15aSet)
        {
            // discriminatorColumn has no pre constraints
            discriminatorColumn15a = handleGetDiscriminatorColumn();
            // discriminatorColumn has no post constraints
            this.discriminatorColumn15a = discriminatorColumn15a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.discriminatorColumn15aSet = true;
            }
        }
        return discriminatorColumn15a;
    }

   /**
    * @see EJB3EntityFacade#getDiscriminatorColumnDefinition()
    * @return String
    */
    protected abstract String handleGetDiscriminatorColumnDefinition();

    private transient String discriminatorColumnDefinition16a;
    private transient boolean discriminatorColumnDefinition16aSet = false;

    /**
     * The SQL used when generating the DDL for the discriminator column.
     * @return (String)handleGetDiscriminatorColumnDefinition()
     */
    public final String getDiscriminatorColumnDefinition()
    {
        String discriminatorColumnDefinition16a = this.discriminatorColumnDefinition16a;
        if (!this.discriminatorColumnDefinition16aSet)
        {
            // discriminatorColumnDefinition has no pre constraints
            discriminatorColumnDefinition16a = handleGetDiscriminatorColumnDefinition();
            // discriminatorColumnDefinition has no post constraints
            this.discriminatorColumnDefinition16a = discriminatorColumnDefinition16a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.discriminatorColumnDefinition16aSet = true;
            }
        }
        return discriminatorColumnDefinition16a;
    }

   /**
    * @see EJB3EntityFacade#getDiscriminatorLength()
    * @return int
    */
    protected abstract int handleGetDiscriminatorLength();

    private transient int discriminatorLength17a;
    private transient boolean discriminatorLength17aSet = false;

    /**
     * The standard length of a discriminator value.  Default is 10.
     * @return (int)handleGetDiscriminatorLength()
     */
    public final int getDiscriminatorLength()
    {
        int discriminatorLength17a = this.discriminatorLength17a;
        if (!this.discriminatorLength17aSet)
        {
            // discriminatorLength has no pre constraints
            discriminatorLength17a = handleGetDiscriminatorLength();
            // discriminatorLength has no post constraints
            this.discriminatorLength17a = discriminatorLength17a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.discriminatorLength17aSet = true;
            }
        }
        return discriminatorLength17a;
    }

   /**
    * @see EJB3EntityFacade#getDiscriminatorType()
    * @return String
    */
    protected abstract String handleGetDiscriminatorType();

    private transient String discriminatorType18a;
    private transient boolean discriminatorType18aSet = false;

    /**
     * The type of the entity discriminator column.  Default is STRING.
     * @return (String)handleGetDiscriminatorType()
     */
    public final String getDiscriminatorType()
    {
        String discriminatorType18a = this.discriminatorType18a;
        if (!this.discriminatorType18aSet)
        {
            // discriminatorType has no pre constraints
            discriminatorType18a = handleGetDiscriminatorType();
            // discriminatorType has no post constraints
            this.discriminatorType18a = discriminatorType18a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.discriminatorType18aSet = true;
            }
        }
        return discriminatorType18a;
    }

   /**
    * @see EJB3EntityFacade#getDiscriminatorValue()
    * @return String
    */
    protected abstract String handleGetDiscriminatorValue();

    private transient String discriminatorValue19a;
    private transient boolean discriminatorValue19aSet = false;

    /**
     * The value indicating the row in an entity of the annotated entity type.
     * @return (String)handleGetDiscriminatorValue()
     */
    public final String getDiscriminatorValue()
    {
        String discriminatorValue19a = this.discriminatorValue19a;
        if (!this.discriminatorValue19aSet)
        {
            // discriminatorValue has no pre constraints
            discriminatorValue19a = handleGetDiscriminatorValue();
            // discriminatorValue has no post constraints
            this.discriminatorValue19a = discriminatorValue19a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.discriminatorValue19aSet = true;
            }
        }
        return discriminatorValue19a;
    }

   /**
    * @see EJB3EntityFacade#isInheritanceSingleTable()
    * @return boolean
    */
    protected abstract boolean handleIsInheritanceSingleTable();

    private transient boolean inheritanceSingleTable20a;
    private transient boolean inheritanceSingleTable20aSet = false;

    /**
     * Return true if the entity inheritance strategy as specified by the tagged value
     * andromda_persistence_inheritance is defined as SINGLE_TABLE.
     * @return (boolean)handleIsInheritanceSingleTable()
     */
    public final boolean isInheritanceSingleTable()
    {
        boolean inheritanceSingleTable20a = this.inheritanceSingleTable20a;
        if (!this.inheritanceSingleTable20aSet)
        {
            // inheritanceSingleTable has no pre constraints
            inheritanceSingleTable20a = handleIsInheritanceSingleTable();
            // inheritanceSingleTable has no post constraints
            this.inheritanceSingleTable20a = inheritanceSingleTable20a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.inheritanceSingleTable20aSet = true;
            }
        }
        return inheritanceSingleTable20a;
    }

   /**
    * @see EJB3EntityFacade#getInheritanceStrategy()
    * @return String
    */
    protected abstract String handleGetInheritanceStrategy();

    private transient String inheritanceStrategy21a;
    private transient boolean inheritanceStrategy21aSet = false;

    /**
     * Return the value of the andromda_persistence_inheritance tagged value which is an enumeration
     * containing SINGLE_TABLE, TABLE_PER_CLASS or JOINED.
     * @return (String)handleGetInheritanceStrategy()
     */
    public final String getInheritanceStrategy()
    {
        String inheritanceStrategy21a = this.inheritanceStrategy21a;
        if (!this.inheritanceStrategy21aSet)
        {
            // inheritanceStrategy has no pre constraints
            inheritanceStrategy21a = handleGetInheritanceStrategy();
            // inheritanceStrategy has no post constraints
            this.inheritanceStrategy21a = inheritanceStrategy21a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.inheritanceStrategy21aSet = true;
            }
        }
        return inheritanceStrategy21a;
    }

   /**
    * @see EJB3EntityFacade#isInheritanceTablePerClass()
    * @return boolean
    */
    protected abstract boolean handleIsInheritanceTablePerClass();

    private transient boolean inheritanceTablePerClass22a;
    private transient boolean inheritanceTablePerClass22aSet = false;

    /**
     * Return true if the entity inheritance strategy as specified by the tagged value
     * andromda_persistence_inheritance is defined as TABLE_PER_CLASS.
     * @return (boolean)handleIsInheritanceTablePerClass()
     */
    public final boolean isInheritanceTablePerClass()
    {
        boolean inheritanceTablePerClass22a = this.inheritanceTablePerClass22a;
        if (!this.inheritanceTablePerClass22aSet)
        {
            // inheritanceTablePerClass has no pre constraints
            inheritanceTablePerClass22a = handleIsInheritanceTablePerClass();
            // inheritanceTablePerClass has no post constraints
            this.inheritanceTablePerClass22a = inheritanceTablePerClass22a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.inheritanceTablePerClass22aSet = true;
            }
        }
        return inheritanceTablePerClass22a;
    }

   /**
    * @see EJB3EntityFacade#isInheritanceJoined()
    * @return boolean
    */
    protected abstract boolean handleIsInheritanceJoined();

    private transient boolean inheritanceJoined23a;
    private transient boolean inheritanceJoined23aSet = false;

    /**
     * Return true if the entity inheritance strategy as specified by the tagged value
     * andromda_persistence_inheritance is defined as JOINED.
     * @return (boolean)handleIsInheritanceJoined()
     */
    public final boolean isInheritanceJoined()
    {
        boolean inheritanceJoined23a = this.inheritanceJoined23a;
        if (!this.inheritanceJoined23aSet)
        {
            // inheritanceJoined has no pre constraints
            inheritanceJoined23a = handleIsInheritanceJoined();
            // inheritanceJoined has no post constraints
            this.inheritanceJoined23a = inheritanceJoined23a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.inheritanceJoined23aSet = true;
            }
        }
        return inheritanceJoined23a;
    }

   /**
    * @see EJB3EntityFacade#isRequiresSpecializationMapping()
    * @return boolean
    */
    protected abstract boolean handleIsRequiresSpecializationMapping();

    private transient boolean requiresSpecializationMapping24a;
    private transient boolean requiresSpecializationMapping24aSet = false;

    /**
     * Returns true if the entity requires specialization mapping.  The Inheritance annotation is
     * required for parent entities for all inheritance strategies.
     * @return (boolean)handleIsRequiresSpecializationMapping()
     */
    public final boolean isRequiresSpecializationMapping()
    {
        boolean requiresSpecializationMapping24a = this.requiresSpecializationMapping24a;
        if (!this.requiresSpecializationMapping24aSet)
        {
            // requiresSpecializationMapping has no pre constraints
            requiresSpecializationMapping24a = handleIsRequiresSpecializationMapping();
            // requiresSpecializationMapping has no post constraints
            this.requiresSpecializationMapping24a = requiresSpecializationMapping24a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.requiresSpecializationMapping24aSet = true;
            }
        }
        return requiresSpecializationMapping24a;
    }

   /**
    * @see EJB3EntityFacade#isRequiresGeneralizationMapping()
    * @return boolean
    */
    protected abstract boolean handleIsRequiresGeneralizationMapping();

    private transient boolean requiresGeneralizationMapping25a;
    private transient boolean requiresGeneralizationMapping25aSet = false;

    /**
     * Returns true if the entity requires generalization mapping.  The Inheritance annotation is
     * required for child entities for all inheritance strategies.
     * @return (boolean)handleIsRequiresGeneralizationMapping()
     */
    public final boolean isRequiresGeneralizationMapping()
    {
        boolean requiresGeneralizationMapping25a = this.requiresGeneralizationMapping25a;
        if (!this.requiresGeneralizationMapping25aSet)
        {
            // requiresGeneralizationMapping has no pre constraints
            requiresGeneralizationMapping25a = handleIsRequiresGeneralizationMapping();
            // requiresGeneralizationMapping has no post constraints
            this.requiresGeneralizationMapping25a = requiresGeneralizationMapping25a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.requiresGeneralizationMapping25aSet = true;
            }
        }
        return requiresGeneralizationMapping25a;
    }

   /**
    * @see EJB3EntityFacade#getEntityImplementationName()
    * @return String
    */
    protected abstract String handleGetEntityImplementationName();

    private transient String entityImplementationName26a;
    private transient boolean entityImplementationName26aSet = false;

    /**
     * The name of the implementation class.
     * @return (String)handleGetEntityImplementationName()
     */
    public final String getEntityImplementationName()
    {
        String entityImplementationName26a = this.entityImplementationName26a;
        if (!this.entityImplementationName26aSet)
        {
            // entityImplementationName has no pre constraints
            entityImplementationName26a = handleGetEntityImplementationName();
            // entityImplementationName has no post constraints
            this.entityImplementationName26a = entityImplementationName26a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.entityImplementationName26aSet = true;
            }
        }
        return entityImplementationName26a;
    }

   /**
    * @see EJB3EntityFacade#getFullyQualifiedEntityImplementationName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedEntityImplementationName();

    private transient String fullyQualifiedEntityImplementationName27a;
    private transient boolean fullyQualifiedEntityImplementationName27aSet = false;

    /**
     * Fully qualified name of the Entity implementation class.
     * @return (String)handleGetFullyQualifiedEntityImplementationName()
     */
    public final String getFullyQualifiedEntityImplementationName()
    {
        String fullyQualifiedEntityImplementationName27a = this.fullyQualifiedEntityImplementationName27a;
        if (!this.fullyQualifiedEntityImplementationName27aSet)
        {
            // fullyQualifiedEntityImplementationName has no pre constraints
            fullyQualifiedEntityImplementationName27a = handleGetFullyQualifiedEntityImplementationName();
            // fullyQualifiedEntityImplementationName has no post constraints
            this.fullyQualifiedEntityImplementationName27a = fullyQualifiedEntityImplementationName27a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedEntityImplementationName27aSet = true;
            }
        }
        return fullyQualifiedEntityImplementationName27a;
    }

   /**
    * @see EJB3EntityFacade#getEntityName()
    * @return String
    */
    protected abstract String handleGetEntityName();

    private transient String entityName28a;
    private transient boolean entityName28aSet = false;

    /**
     * The named used for the EJB3 entity.
     * @return (String)handleGetEntityName()
     */
    public final String getEntityName()
    {
        String entityName28a = this.entityName28a;
        if (!this.entityName28aSet)
        {
            // entityName has no pre constraints
            entityName28a = handleGetEntityName();
            // entityName has no post constraints
            this.entityName28a = entityName28a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.entityName28aSet = true;
            }
        }
        return entityName28a;
    }

   /**
    * @see EJB3EntityFacade#getFullyQualifiedEntityName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedEntityName();

    private transient String fullyQualifiedEntityName29a;
    private transient boolean fullyQualifiedEntityName29aSet = false;

    /**
     * The fully qualified name of the EJB3 entity.
     * @return (String)handleGetFullyQualifiedEntityName()
     */
    public final String getFullyQualifiedEntityName()
    {
        String fullyQualifiedEntityName29a = this.fullyQualifiedEntityName29a;
        if (!this.fullyQualifiedEntityName29aSet)
        {
            // fullyQualifiedEntityName has no pre constraints
            fullyQualifiedEntityName29a = handleGetFullyQualifiedEntityName();
            // fullyQualifiedEntityName has no post constraints
            this.fullyQualifiedEntityName29a = fullyQualifiedEntityName29a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedEntityName29aSet = true;
            }
        }
        return fullyQualifiedEntityName29a;
    }

   /**
    * @see EJB3EntityFacade#isEmbeddableSuperclass()
    * @return boolean
    */
    protected abstract boolean handleIsEmbeddableSuperclass();

    private transient boolean embeddableSuperclass30a;
    private transient boolean embeddableSuperclass30aSet = false;

    /**
     * Determines if this entity is an mapped/embeddable super class.
     * @return (boolean)handleIsEmbeddableSuperclass()
     */
    public final boolean isEmbeddableSuperclass()
    {
        boolean embeddableSuperclass30a = this.embeddableSuperclass30a;
        if (!this.embeddableSuperclass30aSet)
        {
            // embeddableSuperclass has no pre constraints
            embeddableSuperclass30a = handleIsEmbeddableSuperclass();
            // embeddableSuperclass has no post constraints
            this.embeddableSuperclass30a = embeddableSuperclass30a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.embeddableSuperclass30aSet = true;
            }
        }
        return embeddableSuperclass30a;
    }

   /**
    * @see EJB3EntityFacade#isGenericFinders()
    * @return boolean
    */
    protected abstract boolean handleIsGenericFinders();

    private transient boolean genericFinders31a;
    private transient boolean genericFinders31aSet = false;

    /**
     * Returns true if the generic finder property is true.  This will create generic finder static
     * methods in the entity POJO like findByPrimaryKey and findAll.
     * @return (boolean)handleIsGenericFinders()
     */
    public final boolean isGenericFinders()
    {
        boolean genericFinders31a = this.genericFinders31a;
        if (!this.genericFinders31aSet)
        {
            // genericFinders has no pre constraints
            genericFinders31a = handleIsGenericFinders();
            // genericFinders has no post constraints
            this.genericFinders31a = genericFinders31a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.genericFinders31aSet = true;
            }
        }
        return genericFinders31a;
    }

   /**
    * @see EJB3EntityFacade#isCompositePrimaryKeyPresent()
    * @return boolean
    */
    protected abstract boolean handleIsCompositePrimaryKeyPresent();

    private transient boolean compositePrimaryKeyPresent32a;
    private transient boolean compositePrimaryKeyPresent32aSet = false;

    /**
     * Returns true if a composite primary key exists for this entity bean.  A composite primary key
     * consists of 2 or more entity identifiers.
     * @return (boolean)handleIsCompositePrimaryKeyPresent()
     */
    public final boolean isCompositePrimaryKeyPresent()
    {
        boolean compositePrimaryKeyPresent32a = this.compositePrimaryKeyPresent32a;
        if (!this.compositePrimaryKeyPresent32aSet)
        {
            // compositePrimaryKeyPresent has no pre constraints
            compositePrimaryKeyPresent32a = handleIsCompositePrimaryKeyPresent();
            // compositePrimaryKeyPresent has no post constraints
            this.compositePrimaryKeyPresent32a = compositePrimaryKeyPresent32a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.compositePrimaryKeyPresent32aSet = true;
            }
        }
        return compositePrimaryKeyPresent32a;
    }

   /**
    * @see EJB3EntityFacade#getFullyQualifiedEntityCompositePrimaryKeyName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedEntityCompositePrimaryKeyName();

    private transient String fullyQualifiedEntityCompositePrimaryKeyName33a;
    private transient boolean fullyQualifiedEntityCompositePrimaryKeyName33aSet = false;

    /**
     * The fully qualified name of the composite primary key class of this entity.
     * @return (String)handleGetFullyQualifiedEntityCompositePrimaryKeyName()
     */
    public final String getFullyQualifiedEntityCompositePrimaryKeyName()
    {
        String fullyQualifiedEntityCompositePrimaryKeyName33a = this.fullyQualifiedEntityCompositePrimaryKeyName33a;
        if (!this.fullyQualifiedEntityCompositePrimaryKeyName33aSet)
        {
            // fullyQualifiedEntityCompositePrimaryKeyName has no pre constraints
            fullyQualifiedEntityCompositePrimaryKeyName33a = handleGetFullyQualifiedEntityCompositePrimaryKeyName();
            // fullyQualifiedEntityCompositePrimaryKeyName has no post constraints
            this.fullyQualifiedEntityCompositePrimaryKeyName33a = fullyQualifiedEntityCompositePrimaryKeyName33a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedEntityCompositePrimaryKeyName33aSet = true;
            }
        }
        return fullyQualifiedEntityCompositePrimaryKeyName33a;
    }

   /**
    * @see EJB3EntityFacade#getEntityCompositePrimaryKeyName()
    * @return String
    */
    protected abstract String handleGetEntityCompositePrimaryKeyName();

    private transient String entityCompositePrimaryKeyName34a;
    private transient boolean entityCompositePrimaryKeyName34aSet = false;

    /**
     * Entity composite primary key class name for this entity.
     * @return (String)handleGetEntityCompositePrimaryKeyName()
     */
    public final String getEntityCompositePrimaryKeyName()
    {
        String entityCompositePrimaryKeyName34a = this.entityCompositePrimaryKeyName34a;
        if (!this.entityCompositePrimaryKeyName34aSet)
        {
            // entityCompositePrimaryKeyName has no pre constraints
            entityCompositePrimaryKeyName34a = handleGetEntityCompositePrimaryKeyName();
            // entityCompositePrimaryKeyName has no post constraints
            this.entityCompositePrimaryKeyName34a = entityCompositePrimaryKeyName34a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.entityCompositePrimaryKeyName34aSet = true;
            }
        }
        return entityCompositePrimaryKeyName34a;
    }

   /**
    * @see EJB3EntityFacade#isEmbeddableSuperclassGeneralizationExists()
    * @return boolean
    */
    protected abstract boolean handleIsEmbeddableSuperclassGeneralizationExists();

    private transient boolean embeddableSuperclassGeneralizationExists35a;
    private transient boolean embeddableSuperclassGeneralizationExists35aSet = false;

    /**
     * Returns true if this entity is a subclass of an mapped/embeddable super class.  You cannot
     * have more than 1 level of inheritance using mapped/embeddable super class.  To achieve
     * multiple levels, use one of the inheritance mapping strategies like single table, table per
     * class or joined table strategies.
     * @return (boolean)handleIsEmbeddableSuperclassGeneralizationExists()
     */
    public final boolean isEmbeddableSuperclassGeneralizationExists()
    {
        boolean embeddableSuperclassGeneralizationExists35a = this.embeddableSuperclassGeneralizationExists35a;
        if (!this.embeddableSuperclassGeneralizationExists35aSet)
        {
            // embeddableSuperclassGeneralizationExists has no pre constraints
            embeddableSuperclassGeneralizationExists35a = handleIsEmbeddableSuperclassGeneralizationExists();
            // embeddableSuperclassGeneralizationExists has no post constraints
            this.embeddableSuperclassGeneralizationExists35a = embeddableSuperclassGeneralizationExists35a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.embeddableSuperclassGeneralizationExists35aSet = true;
            }
        }
        return embeddableSuperclassGeneralizationExists35a;
    }

   /**
    * @see EJB3EntityFacade#isListenerEnabled()
    * @return boolean
    */
    protected abstract boolean handleIsListenerEnabled();

    private transient boolean listenerEnabled36a;
    private transient boolean listenerEnabled36aSet = false;

    /**
     * Returns true if this entity bean has the stereotype Listener.  False otherwise.
     * @return (boolean)handleIsListenerEnabled()
     */
    public final boolean isListenerEnabled()
    {
        boolean listenerEnabled36a = this.listenerEnabled36a;
        if (!this.listenerEnabled36aSet)
        {
            // listenerEnabled has no pre constraints
            listenerEnabled36a = handleIsListenerEnabled();
            // listenerEnabled has no post constraints
            this.listenerEnabled36a = listenerEnabled36a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.listenerEnabled36aSet = true;
            }
        }
        return listenerEnabled36a;
    }

   /**
    * @see EJB3EntityFacade#isFinderFindAllExists()
    * @return boolean
    */
    protected abstract boolean handleIsFinderFindAllExists();

    private transient boolean finderFindAllExists37a;
    private transient boolean finderFindAllExists37aSet = false;

    /**
     * Returns true if the findAll finder method (specified as a query method) has been modelled.
     * @return (boolean)handleIsFinderFindAllExists()
     */
    public final boolean isFinderFindAllExists()
    {
        boolean finderFindAllExists37a = this.finderFindAllExists37a;
        if (!this.finderFindAllExists37aSet)
        {
            // finderFindAllExists has no pre constraints
            finderFindAllExists37a = handleIsFinderFindAllExists();
            // finderFindAllExists has no post constraints
            this.finderFindAllExists37a = finderFindAllExists37a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.finderFindAllExists37aSet = true;
            }
        }
        return finderFindAllExists37a;
    }

   /**
    * @see EJB3EntityFacade#isFinderFindByPrimaryKeyExists()
    * @return boolean
    */
    protected abstract boolean handleIsFinderFindByPrimaryKeyExists();

    private transient boolean finderFindByPrimaryKeyExists38a;
    private transient boolean finderFindByPrimaryKeyExists38aSet = false;

    /**
     * Returns true if the finder findByPrimaryKey has been modelled.
     * @return (boolean)handleIsFinderFindByPrimaryKeyExists()
     */
    public final boolean isFinderFindByPrimaryKeyExists()
    {
        boolean finderFindByPrimaryKeyExists38a = this.finderFindByPrimaryKeyExists38a;
        if (!this.finderFindByPrimaryKeyExists38aSet)
        {
            // finderFindByPrimaryKeyExists has no pre constraints
            finderFindByPrimaryKeyExists38a = handleIsFinderFindByPrimaryKeyExists();
            // finderFindByPrimaryKeyExists has no post constraints
            this.finderFindByPrimaryKeyExists38a = finderFindByPrimaryKeyExists38a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.finderFindByPrimaryKeyExists38aSet = true;
            }
        }
        return finderFindByPrimaryKeyExists38a;
    }

   /**
    * @see EJB3EntityFacade#isManageable()
    * @return boolean
    */
    protected abstract boolean handleIsManageable();

    private transient boolean manageable39a;
    private transient boolean manageable39aSet = false;

    /**
     * Returns true if this entity is assigned the Manageable stereotype.  False otherwise.
     * @return (boolean)handleIsManageable()
     */
    public final boolean isManageable()
    {
        boolean manageable39a = this.manageable39a;
        if (!this.manageable39aSet)
        {
            // manageable has no pre constraints
            manageable39a = handleIsManageable();
            // manageable has no post constraints
            this.manageable39a = manageable39a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.manageable39aSet = true;
            }
        }
        return manageable39a;
    }

   /**
    * @see EJB3EntityFacade#getCacheType()
    * @return String
    */
    protected abstract String handleGetCacheType();

    private transient String cacheType40a;
    private transient boolean cacheType40aSet = false;

    /**
     * Provides the cache policy for the entity.
     * Posible values are NONE, READ_WRITE, NONSTRICT_READ_WRITE, READ_ONLY, TRANSACTIONAL.
     * @return (String)handleGetCacheType()
     */
    public final String getCacheType()
    {
        String cacheType40a = this.cacheType40a;
        if (!this.cacheType40aSet)
        {
            // cacheType has no pre constraints
            cacheType40a = handleGetCacheType();
            // cacheType has no post constraints
            this.cacheType40a = cacheType40a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.cacheType40aSet = true;
            }
        }
        return cacheType40a;
    }

   /**
    * @see EJB3EntityFacade#isCacheEnabled()
    * @return boolean
    */
    protected abstract boolean handleIsCacheEnabled();

    private transient boolean cacheEnabled41a;
    private transient boolean cacheEnabled41aSet = false;

    /**
     * Returns true if caching has been enabled via namespace property hibernateEnableCache.
     * @return (boolean)handleIsCacheEnabled()
     */
    public final boolean isCacheEnabled()
    {
        boolean cacheEnabled41a = this.cacheEnabled41a;
        if (!this.cacheEnabled41aSet)
        {
            // cacheEnabled has no pre constraints
            cacheEnabled41a = handleIsCacheEnabled();
            // cacheEnabled has no post constraints
            this.cacheEnabled41a = cacheEnabled41a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.cacheEnabled41aSet = true;
            }
        }
        return cacheEnabled41a;
    }

   /**
    * @see EJB3EntityFacade#isUseDefaultCacheRegion()
    * @return boolean
    */
    protected abstract boolean handleIsUseDefaultCacheRegion();

    private transient boolean useDefaultCacheRegion42a;
    private transient boolean useDefaultCacheRegion42aSet = false;

    /**
     * Return true if a unique cache region is NOT required for entities and queries.  This means we
     * use the default cache region specified by the container.  Specified via the
     * useDefaultCacheRegion namepsace property.
     * @return (boolean)handleIsUseDefaultCacheRegion()
     */
    public final boolean isUseDefaultCacheRegion()
    {
        boolean useDefaultCacheRegion42a = this.useDefaultCacheRegion42a;
        if (!this.useDefaultCacheRegion42aSet)
        {
            // useDefaultCacheRegion has no pre constraints
            useDefaultCacheRegion42a = handleIsUseDefaultCacheRegion();
            // useDefaultCacheRegion has no post constraints
            this.useDefaultCacheRegion42a = useDefaultCacheRegion42a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.useDefaultCacheRegion42aSet = true;
            }
        }
        return useDefaultCacheRegion42a;
    }

   /**
    * @see EJB3EntityFacade#getDaoName()
    * @return String
    */
    protected abstract String handleGetDaoName();

    private transient String daoName43a;
    private transient boolean daoName43aSet = false;

    /**
     * The name of the DAO for the specified entity.
     * @return (String)handleGetDaoName()
     */
    public final String getDaoName()
    {
        String daoName43a = this.daoName43a;
        if (!this.daoName43aSet)
        {
            // daoName has no pre constraints
            daoName43a = handleGetDaoName();
            // daoName has no post constraints
            this.daoName43a = daoName43a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.daoName43aSet = true;
            }
        }
        return daoName43a;
    }

   /**
    * @see EJB3EntityFacade#getFullyQualifiedDaoName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedDaoName();

    private transient String fullyQualifiedDaoName44a;
    private transient boolean fullyQualifiedDaoName44aSet = false;

    /**
     * The fully qualified name of the DAO.
     * @return (String)handleGetFullyQualifiedDaoName()
     */
    public final String getFullyQualifiedDaoName()
    {
        String fullyQualifiedDaoName44a = this.fullyQualifiedDaoName44a;
        if (!this.fullyQualifiedDaoName44aSet)
        {
            // fullyQualifiedDaoName has no pre constraints
            fullyQualifiedDaoName44a = handleGetFullyQualifiedDaoName();
            // fullyQualifiedDaoName has no post constraints
            this.fullyQualifiedDaoName44a = fullyQualifiedDaoName44a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedDaoName44aSet = true;
            }
        }
        return fullyQualifiedDaoName44a;
    }

   /**
    * @see EJB3EntityFacade#getDaoImplementationName()
    * @return String
    */
    protected abstract String handleGetDaoImplementationName();

    private transient String daoImplementationName45a;
    private transient boolean daoImplementationName45aSet = false;

    /**
     * The DAO implementation class name.
     * @return (String)handleGetDaoImplementationName()
     */
    public final String getDaoImplementationName()
    {
        String daoImplementationName45a = this.daoImplementationName45a;
        if (!this.daoImplementationName45aSet)
        {
            // daoImplementationName has no pre constraints
            daoImplementationName45a = handleGetDaoImplementationName();
            // daoImplementationName has no post constraints
            this.daoImplementationName45a = daoImplementationName45a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.daoImplementationName45aSet = true;
            }
        }
        return daoImplementationName45a;
    }

   /**
    * @see EJB3EntityFacade#getFullyQualifiedDaoImplementationName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedDaoImplementationName();

    private transient String fullyQualifiedDaoImplementationName46a;
    private transient boolean fullyQualifiedDaoImplementationName46aSet = false;

    /**
     * The fully qualified name of the DAO implemetation.
     * @return (String)handleGetFullyQualifiedDaoImplementationName()
     */
    public final String getFullyQualifiedDaoImplementationName()
    {
        String fullyQualifiedDaoImplementationName46a = this.fullyQualifiedDaoImplementationName46a;
        if (!this.fullyQualifiedDaoImplementationName46aSet)
        {
            // fullyQualifiedDaoImplementationName has no pre constraints
            fullyQualifiedDaoImplementationName46a = handleGetFullyQualifiedDaoImplementationName();
            // fullyQualifiedDaoImplementationName has no post constraints
            this.fullyQualifiedDaoImplementationName46a = fullyQualifiedDaoImplementationName46a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedDaoImplementationName46aSet = true;
            }
        }
        return fullyQualifiedDaoImplementationName46a;
    }

   /**
    * @see EJB3EntityFacade#getDaoBaseName()
    * @return String
    */
    protected abstract String handleGetDaoBaseName();

    private transient String daoBaseName47a;
    private transient boolean daoBaseName47aSet = false;

    /**
     * The DAO base class name.  This is the abstract DAO that containsCRUD operations as well as
     * any generated finders defined on an entity.
     * @return (String)handleGetDaoBaseName()
     */
    public final String getDaoBaseName()
    {
        String daoBaseName47a = this.daoBaseName47a;
        if (!this.daoBaseName47aSet)
        {
            // daoBaseName has no pre constraints
            daoBaseName47a = handleGetDaoBaseName();
            // daoBaseName has no post constraints
            this.daoBaseName47a = daoBaseName47a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.daoBaseName47aSet = true;
            }
        }
        return daoBaseName47a;
    }

   /**
    * @see EJB3EntityFacade#getFullyQualifiedDaoBaseName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedDaoBaseName();

    private transient String fullyQualifiedDaoBaseName48a;
    private transient boolean fullyQualifiedDaoBaseName48aSet = false;

    /**
     * The fully qualified name of the base DAO.
     * @return (String)handleGetFullyQualifiedDaoBaseName()
     */
    public final String getFullyQualifiedDaoBaseName()
    {
        String fullyQualifiedDaoBaseName48a = this.fullyQualifiedDaoBaseName48a;
        if (!this.fullyQualifiedDaoBaseName48aSet)
        {
            // fullyQualifiedDaoBaseName has no pre constraints
            fullyQualifiedDaoBaseName48a = handleGetFullyQualifiedDaoBaseName();
            // fullyQualifiedDaoBaseName has no post constraints
            this.fullyQualifiedDaoBaseName48a = fullyQualifiedDaoBaseName48a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedDaoBaseName48aSet = true;
            }
        }
        return fullyQualifiedDaoBaseName48a;
    }

   /**
    * @see EJB3EntityFacade#isDaoBusinessOperationsPresent()
    * @return boolean
    */
    protected abstract boolean handleIsDaoBusinessOperationsPresent();

    private transient boolean daoBusinessOperationsPresent49a;
    private transient boolean daoBusinessOperationsPresent49aSet = false;

    /**
     * Indicates whether or not any business DAO operations are present.
     * @return (boolean)handleIsDaoBusinessOperationsPresent()
     */
    public final boolean isDaoBusinessOperationsPresent()
    {
        boolean daoBusinessOperationsPresent49a = this.daoBusinessOperationsPresent49a;
        if (!this.daoBusinessOperationsPresent49aSet)
        {
            // daoBusinessOperationsPresent has no pre constraints
            daoBusinessOperationsPresent49a = handleIsDaoBusinessOperationsPresent();
            // daoBusinessOperationsPresent has no post constraints
            this.daoBusinessOperationsPresent49a = daoBusinessOperationsPresent49a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.daoBusinessOperationsPresent49aSet = true;
            }
        }
        return daoBusinessOperationsPresent49a;
    }

   /**
    * @see EJB3EntityFacade#isDaoImplementationRequired()
    * @return boolean
    */
    protected abstract boolean handleIsDaoImplementationRequired();

    private transient boolean daoImplementationRequired50a;
    private transient boolean daoImplementationRequired50aSet = false;

    /**
     * True if an implementation is required for the dao class, this is the case when there are
     * business operations or value-object transformation.
     * @return (boolean)handleIsDaoImplementationRequired()
     */
    public final boolean isDaoImplementationRequired()
    {
        boolean daoImplementationRequired50a = this.daoImplementationRequired50a;
        if (!this.daoImplementationRequired50aSet)
        {
            // daoImplementationRequired has no pre constraints
            daoImplementationRequired50a = handleIsDaoImplementationRequired();
            // daoImplementationRequired has no post constraints
            this.daoImplementationRequired50a = daoImplementationRequired50a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.daoImplementationRequired50aSet = true;
            }
        }
        return daoImplementationRequired50a;
    }

   /**
    * @see EJB3EntityFacade#getDaoNoTransformationConstantName()
    * @return String
    */
    protected abstract String handleGetDaoNoTransformationConstantName();

    private transient String daoNoTransformationConstantName51a;
    private transient boolean daoNoTransformationConstantName51aSet = false;

    /**
     * The constant name denoting no transformation is to be applied.
     * @return (String)handleGetDaoNoTransformationConstantName()
     */
    public final String getDaoNoTransformationConstantName()
    {
        String daoNoTransformationConstantName51a = this.daoNoTransformationConstantName51a;
        if (!this.daoNoTransformationConstantName51aSet)
        {
            // daoNoTransformationConstantName has no pre constraints
            daoNoTransformationConstantName51a = handleGetDaoNoTransformationConstantName();
            // daoNoTransformationConstantName has no post constraints
            this.daoNoTransformationConstantName51a = daoNoTransformationConstantName51a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.daoNoTransformationConstantName51aSet = true;
            }
        }
        return daoNoTransformationConstantName51a;
    }

   /**
    * @see EJB3EntityFacade#getDefaultPersistenceContextUnitName()
    * @return String
    */
    protected abstract String handleGetDefaultPersistenceContextUnitName();

    private transient String defaultPersistenceContextUnitName52a;
    private transient boolean defaultPersistenceContextUnitName52aSet = false;

    /**
     * Returns the default persistence context unit name for the injected EntityManger for the
     * DAO/Manageable service beans.  It is derived from the persistenceContextUnitName namespace
     * property.
     * @return (String)handleGetDefaultPersistenceContextUnitName()
     */
    public final String getDefaultPersistenceContextUnitName()
    {
        String defaultPersistenceContextUnitName52a = this.defaultPersistenceContextUnitName52a;
        if (!this.defaultPersistenceContextUnitName52aSet)
        {
            // defaultPersistenceContextUnitName has no pre constraints
            defaultPersistenceContextUnitName52a = handleGetDefaultPersistenceContextUnitName();
            // defaultPersistenceContextUnitName has no post constraints
            this.defaultPersistenceContextUnitName52a = defaultPersistenceContextUnitName52a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.defaultPersistenceContextUnitName52aSet = true;
            }
        }
        return defaultPersistenceContextUnitName52a;
    }

   /**
    * @see EJB3EntityFacade#getDaoDefaultExceptionName()
    * @return String
    */
    protected abstract String handleGetDaoDefaultExceptionName();

    private transient String daoDefaultExceptionName53a;
    private transient boolean daoDefaultExceptionName53aSet = false;

    /**
     * Returns the default DAO exception name.
     * @return (String)handleGetDaoDefaultExceptionName()
     */
    public final String getDaoDefaultExceptionName()
    {
        String daoDefaultExceptionName53a = this.daoDefaultExceptionName53a;
        if (!this.daoDefaultExceptionName53aSet)
        {
            // daoDefaultExceptionName has no pre constraints
            daoDefaultExceptionName53a = handleGetDaoDefaultExceptionName();
            // daoDefaultExceptionName has no post constraints
            this.daoDefaultExceptionName53a = daoDefaultExceptionName53a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.daoDefaultExceptionName53aSet = true;
            }
        }
        return daoDefaultExceptionName53a;
    }

   /**
    * @see EJB3EntityFacade#getFullyQualifiedDaoDefaultExceptionName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedDaoDefaultExceptionName();

    private transient String fullyQualifiedDaoDefaultExceptionName54a;
    private transient boolean fullyQualifiedDaoDefaultExceptionName54aSet = false;

    /**
     * Returns the fully qualified default DAO exception name.
     * @return (String)handleGetFullyQualifiedDaoDefaultExceptionName()
     */
    public final String getFullyQualifiedDaoDefaultExceptionName()
    {
        String fullyQualifiedDaoDefaultExceptionName54a = this.fullyQualifiedDaoDefaultExceptionName54a;
        if (!this.fullyQualifiedDaoDefaultExceptionName54aSet)
        {
            // fullyQualifiedDaoDefaultExceptionName has no pre constraints
            fullyQualifiedDaoDefaultExceptionName54a = handleGetFullyQualifiedDaoDefaultExceptionName();
            // fullyQualifiedDaoDefaultExceptionName has no post constraints
            this.fullyQualifiedDaoDefaultExceptionName54a = fullyQualifiedDaoDefaultExceptionName54a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedDaoDefaultExceptionName54aSet = true;
            }
        }
        return fullyQualifiedDaoDefaultExceptionName54a;
    }

   /**
    * @see EJB3EntityFacade#isEntityImplementationRequired()
    * @return boolean
    */
    protected abstract boolean handleIsEntityImplementationRequired();

    private transient boolean entityImplementationRequired55a;
    private transient boolean entityImplementationRequired55aSet = false;

    /**
     * True if an entity implementation is required for the entity class, this is the case when
     * there are business operations.
     * @return (boolean)handleIsEntityImplementationRequired()
     */
    public final boolean isEntityImplementationRequired()
    {
        boolean entityImplementationRequired55a = this.entityImplementationRequired55a;
        if (!this.entityImplementationRequired55aSet)
        {
            // entityImplementationRequired has no pre constraints
            entityImplementationRequired55a = handleIsEntityImplementationRequired();
            // entityImplementationRequired has no post constraints
            this.entityImplementationRequired55a = entityImplementationRequired55a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.entityImplementationRequired55aSet = true;
            }
        }
        return entityImplementationRequired55a;
    }

   /**
    * @see EJB3EntityFacade#isSecurityEnabled()
    * @return boolean
    */
    protected abstract boolean handleIsSecurityEnabled();

    private transient boolean securityEnabled56a;
    private transient boolean securityEnabled56aSet = false;

    /**
     * Returns true if the security realm is specified.  This will generate the security setting for
     * the DAO components.
     * @return (boolean)handleIsSecurityEnabled()
     */
    public final boolean isSecurityEnabled()
    {
        boolean securityEnabled56a = this.securityEnabled56a;
        if (!this.securityEnabled56aSet)
        {
            // securityEnabled has no pre constraints
            securityEnabled56a = handleIsSecurityEnabled();
            // securityEnabled has no post constraints
            this.securityEnabled56a = securityEnabled56a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.securityEnabled56aSet = true;
            }
        }
        return securityEnabled56a;
    }

   /**
    * @see EJB3EntityFacade#getRolesAllowed()
    * @return String
    */
    protected abstract String handleGetRolesAllowed();

    private transient String rolesAllowed57a;
    private transient boolean rolesAllowed57aSet = false;

    /**
     * Returns the comma separated list of roles allowd to execute DAO operations.  This is defined
     * by actor dependencies on the entity.
     * @return (String)handleGetRolesAllowed()
     */
    public final String getRolesAllowed()
    {
        String rolesAllowed57a = this.rolesAllowed57a;
        if (!this.rolesAllowed57aSet)
        {
            // rolesAllowed has no pre constraints
            rolesAllowed57a = handleGetRolesAllowed();
            // rolesAllowed has no post constraints
            this.rolesAllowed57a = rolesAllowed57a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.rolesAllowed57aSet = true;
            }
        }
        return rolesAllowed57a;
    }

   /**
    * @see EJB3EntityFacade#getSecurityRealm()
    * @return String
    */
    protected abstract String handleGetSecurityRealm();

    private transient String securityRealm58a;
    private transient boolean securityRealm58aSet = false;

    /**
     * Returns the security domain value.  Specified using the securityRealm namespace property or
     * overriden in the andromda.ejb.security.realm tagged value.
     * @return (String)handleGetSecurityRealm()
     */
    public final String getSecurityRealm()
    {
        String securityRealm58a = this.securityRealm58a;
        if (!this.securityRealm58aSet)
        {
            // securityRealm has no pre constraints
            securityRealm58a = handleGetSecurityRealm();
            // securityRealm has no post constraints
            this.securityRealm58a = securityRealm58a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.securityRealm58aSet = true;
            }
        }
        return securityRealm58a;
    }

   /**
    * @see EJB3EntityFacade#isUseQueryCache()
    * @return boolean
    */
    protected abstract boolean handleIsUseQueryCache();

    private transient boolean useQueryCache59a;
    private transient boolean useQueryCache59aSet = false;

    /**
     * Returns true if the application wide namespace property hibernateUseQueryCache is enabled.
     * This is used for generic finder methods i.e. findAll.
     * @return (boolean)handleIsUseQueryCache()
     */
    public final boolean isUseQueryCache()
    {
        boolean useQueryCache59a = this.useQueryCache59a;
        if (!this.useQueryCache59aSet)
        {
            // useQueryCache has no pre constraints
            useQueryCache59a = handleIsUseQueryCache();
            // useQueryCache has no post constraints
            this.useQueryCache59a = useQueryCache59a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.useQueryCache59aSet = true;
            }
        }
        return useQueryCache59a;
    }

   /**
    * @see EJB3EntityFacade#isSeamComponent()
    * @return boolean
    */
    protected abstract boolean handleIsSeamComponent();

    private transient boolean seamComponent60a;
    private transient boolean seamComponent60aSet = false;

    /**
     * Returns true if this entity has the <<Seam>> stereotype modelled indicating it is a Seam
     * entity component.
     * @return (boolean)handleIsSeamComponent()
     */
    public final boolean isSeamComponent()
    {
        boolean seamComponent60a = this.seamComponent60a;
        if (!this.seamComponent60aSet)
        {
            // seamComponent has no pre constraints
            seamComponent60a = handleIsSeamComponent();
            // seamComponent has no post constraints
            this.seamComponent60a = seamComponent60a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamComponent60aSet = true;
            }
        }
        return seamComponent60a;
    }

   /**
    * @see EJB3EntityFacade#getSeamComponentScopeType()
    * @return String
    */
    protected abstract String handleGetSeamComponentScopeType();

    private transient String seamComponentScopeType61a;
    private transient boolean seamComponentScopeType61aSet = false;

    /**
     * Returns the seam component scope type if one is specified.
     * @return (String)handleGetSeamComponentScopeType()
     */
    public final String getSeamComponentScopeType()
    {
        String seamComponentScopeType61a = this.seamComponentScopeType61a;
        if (!this.seamComponentScopeType61aSet)
        {
            // seamComponentScopeType has no pre constraints
            seamComponentScopeType61a = handleGetSeamComponentScopeType();
            // seamComponentScopeType has no post constraints
            this.seamComponentScopeType61a = seamComponentScopeType61a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamComponentScopeType61aSet = true;
            }
        }
        return seamComponentScopeType61a;
    }

   /**
    * @see EJB3EntityFacade#getSeamComponentName()
    * @return String
    */
    protected abstract String handleGetSeamComponentName();

    private transient String seamComponentName62a;
    private transient boolean seamComponentName62aSet = false;

    /**
     * Returns the Seam component name for the class.
     * @return (String)handleGetSeamComponentName()
     */
    public final String getSeamComponentName()
    {
        String seamComponentName62a = this.seamComponentName62a;
        if (!this.seamComponentName62aSet)
        {
            // seamComponentName has no pre constraints
            seamComponentName62a = handleGetSeamComponentName();
            // seamComponentName has no post constraints
            this.seamComponentName62a = seamComponentName62a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamComponentName62aSet = true;
            }
        }
        return seamComponentName62a;
    }

    // ---------------- business methods ----------------------

    /**
     * Method to be implemented in descendants
     * Gets create methods for the entity.  If 'follow'l is set to true, create methods from any
     * super types will also be retrieved by following up the inheritance chain.
     * @param follow
     * @return Collection
     */
    protected abstract Collection handleGetCreateMethods(boolean follow);

    /**
     * Gets create methods for the entity.  If 'follow'l is set to true, create methods from any
     * super types will also be retrieved by following up the inheritance chain.
     * @param follow boolean
     * If true, all create methods will be returned from the inheritance hierarchy, false otherwise.
     * @return handleGetCreateMethods(follow)
     */
    public Collection getCreateMethods(boolean follow)
    {
        // getCreateMethods has no pre constraints
        Collection returnValue = handleGetCreateMethods(follow);
        // getCreateMethods has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * Gets select methods for the entity, if all is set to 'true' then ALL select methods will be
     * retrieved (including those inherited from any superclasses).
     * @param follow
     * @return Collection
     */
    protected abstract Collection handleGetSelectMethods(boolean follow);

    /**
     * Gets select methods for the entity, if all is set to 'true' then ALL select methods will be
     * retrieved (including those inherited from any superclasses).
     * @param follow boolean
     * If set to true, then all select methods including those in its superclass will be retrieved.
     * @return handleGetSelectMethods(follow)
     */
    public Collection getSelectMethods(boolean follow)
    {
        // getSelectMethods has no pre constraints
        Collection returnValue = handleGetSelectMethods(follow);
        // getSelectMethods has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * Gets all env-entries for the specified entity EJB. Env-entries are stored as static
     * attributes on the entity and stereotyped as <<EnvEntry>>.  If 'follow' is true, then the
     * inheritance hierarchy will be followed and we'll retrieve all env-entries from any super
     * types as well.
     * @param follow
     * @return Collection
     */
    protected abstract Collection handleGetEnvironmentEntries(boolean follow);

    /**
     * Gets all env-entries for the specified entity EJB. Env-entries are stored as static
     * attributes on the entity and stereotyped as <<EnvEntry>>.  If 'follow' is true, then the
     * inheritance hierarchy will be followed and we'll retrieve all env-entries from any super
     * types as well.
     * @param follow boolean
     * If true, then the inheritance hierarchy will be followed and we'll retrieve all env-entries
     * from any super types as well.
     * @return handleGetEnvironmentEntries(follow)
     */
    public Collection getEnvironmentEntries(boolean follow)
    {
        // getEnvironmentEntries has no pre constraints
        Collection returnValue = handleGetEnvironmentEntries(follow);
        // getEnvironmentEntries has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * Gets all constants for this entity. Constants are defined as static read-only attributes
     * which do NOT have the <<EnvEntry>> stereotype.   If 'follow' is true, then the inheritance
     * hierarchy will be followed and we'll retrieve all constants from any super types as well.
     * @param follow
     * @return Collection
     */
    protected abstract Collection handleGetConstants(boolean follow);

    /**
     * Gets all constants for this entity. Constants are defined as static read-only attributes
     * which do NOT have the <<EnvEntry>> stereotype.   If 'follow' is true, then the inheritance
     * hierarchy will be followed and we'll retrieve all constants from any super types as well.
     * @param follow boolean
     * If true, then the inheritance hierarchy will be followed and we'll retrieve all constants
     * from any super types as well.
     * @return handleGetConstants(follow)
     */
    public Collection getConstants(boolean follow)
    {
        // getConstants has no pre constraints
        Collection returnValue = handleGetConstants(follow);
        // getConstants has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * TODO: Model Documentation for
     * EJB3EntityFacade.isOperationPresent
     * @param op
     * @return boolean
     */
    protected abstract boolean handleIsOperationPresent(String op);

    /**
     * TODO: Model Documentation for
     * EJB3EntityFacade.isOperationPresent
     * @param op String
     * TODO: Model Documentation for
     * EJB3EntityFacade.isOperationPresent(op)
     * @return handleIsOperationPresent(op)
     */
    public boolean isOperationPresent(String op)
    {
        // isOperationPresent has no pre constraints
        boolean returnValue = handleIsOperationPresent(op);
        // isOperationPresent has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * TODO: Model Documentation for
     * EJB3EntityFacade.isAttributePresent
     * @param att
     * @return boolean
     */
    protected abstract boolean handleIsAttributePresent(String att);

    /**
     * TODO: Model Documentation for
     * EJB3EntityFacade.isAttributePresent
     * @param att String
     * TODO: Model Documentation for
     * EJB3EntityFacade.isAttributePresent(att)
     * @return handleIsAttributePresent(att)
     */
    public boolean isAttributePresent(String att)
    {
        // isAttributePresent has no pre constraints
        boolean returnValue = handleIsAttributePresent(att);
        // isAttributePresent has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * TODO: Model Documentation for
     * EJB3EntityFacade.isIdentifierPresent
     * @param id
     * @return boolean
     */
    protected abstract boolean handleIsIdentifierPresent(String id);

    /**
     * TODO: Model Documentation for
     * EJB3EntityFacade.isIdentifierPresent
     * @param id String
     * TODO: Model Documentation for
     * EJB3EntityFacade.isIdentifierPresent(id)
     * @return handleIsIdentifierPresent(id)
     */
    public boolean isIdentifierPresent(String id)
    {
        // isIdentifierPresent has no pre constraints
        boolean returnValue = handleIsIdentifierPresent(id);
        // isIdentifierPresent has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * TODO: Model Documentation for
     * EJB3EntityFacade.getSqlType
     * @return String
     */
    protected abstract String handleGetSqlType();

    /**
     * TODO: Model Documentation for
     * EJB3EntityFacade.getSqlType
     * @return handleGetSqlType()
     */
    public String getSqlType()
    {
        // getSqlType has no pre constraints
        String returnValue = handleGetSqlType();
        // getSqlType has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * Create a comma separated list of attributes. This method can be used to generate argument
     * lists for constructors, method calls etc. It will not return attributes tagged to be
     * optimistic lock values.  It will consider LOB attributes where the LOB type has been
     * overriden using the @androma.persistence.lob.type tagged value.
     * @param attributes
     * @param includeTypes
     * @param includeNames
     * @param includeAutoIdentifiers
     * @return String
     */
    protected abstract String handleGetAttributesAsList(Collection attributes, boolean includeTypes, boolean includeNames, boolean includeAutoIdentifiers);

    /**
     * Create a comma separated list of attributes. This method can be used to generate argument
     * lists for constructors, method calls etc. It will not return attributes tagged to be
     * optimistic lock values.  It will consider LOB attributes where the LOB type has been
     * overriden using the @androma.persistence.lob.type tagged value.
     * @param attributes Collection
     * a collection of {@link Attribute} objects
     * @param includeTypes boolean
     * if <code>true</code>, the type names of the attributes are included.
     * @param includeNames boolean
     * if <code>true</code>, the names of the attributes are included
     * @param includeAutoIdentifiers boolean
     * Whether to include identifier attributes.
     * @return handleGetAttributesAsList(attributes, includeTypes, includeNames, includeAutoIdentifiers)
     */
    public String getAttributesAsList(Collection attributes, boolean includeTypes, boolean includeNames, boolean includeAutoIdentifiers)
    {
        // getAttributesAsList has no pre constraints
        String returnValue = handleGetAttributesAsList(attributes, includeTypes, includeNames, includeAutoIdentifiers);
        // getAttributesAsList has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * Retrieves the values object references for this entity.  If <code>follow</code> is true, then
     * all value object references (including those that were inherited) will be retrieved.
     * @param follow
     * @return Collection
     */
    protected abstract Collection handleGetValueObjectReferences(boolean follow);

    /**
     * Retrieves the values object references for this entity.  If <code>follow</code> is true, then
     * all value object references (including those that were inherited) will be retrieved.
     * @param follow boolean
     * TODO: Model Documentation for
     * EJB3EntityFacade.getValueObjectReferences(follow)
     * @return handleGetValueObjectReferences(follow)
     */
    public Collection getValueObjectReferences(boolean follow)
    {
        // getValueObjectReferences has no pre constraints
        Collection returnValue = handleGetValueObjectReferences(follow);
        // getValueObjectReferences has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * Gets all instance attributes of the entity, and optionally retieves the super entities
     * instance attributes as well as excludes the entity's identifiers if 'withIdentifiers' is set
     * to false.
     * @param follow
     * @param withIdentifiers
     * @return Collection
     */
    protected abstract Collection handleGetInstanceAttributes(boolean follow, boolean withIdentifiers);

    /**
     * Gets all instance attributes of the entity, and optionally retieves the super entities
     * instance attributes as well as excludes the entity's identifiers if 'withIdentifiers' is set
     * to false.
     * @param follow boolean
     * Whether or not to follow the inheritance hierarchy when retrieving the attributes.
     * @param withIdentifiers boolean
     * Whether or not to include identifiers in the returned attributes.
     * @return handleGetInstanceAttributes(follow, withIdentifiers)
     */
    public Collection getInstanceAttributes(boolean follow, boolean withIdentifiers)
    {
        // getInstanceAttributes has no pre constraints
        Collection returnValue = handleGetInstanceAttributes(follow, withIdentifiers);
        // getInstanceAttributes has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * Gets a comma separated list of instance attribute names.  If 'follow' is true, will travel up
     * the inheritance hierarchy to include instance attributes in parent entities as well.  If
     * 'withIdentifiers' is true, will include identifiers.
     * @param follow
     * @param withIdentifiers
     * @return String
     */
    protected abstract String handleGetInstanceAttributeNameList(boolean follow, boolean withIdentifiers);

    /**
     * Gets a comma separated list of instance attribute names.  If 'follow' is true, will travel up
     * the inheritance hierarchy to include instance attributes in parent entities as well.  If
     * 'withIdentifiers' is true, will include identifiers.
     * @param follow boolean
     * Whether or not to 'follow' the inheritance hierarchy.
     * @param withIdentifiers boolean
     * Whether or not to include identifiers in the returned attributes.
     * @return handleGetInstanceAttributeNameList(follow, withIdentifiers)
     */
    public String getInstanceAttributeNameList(boolean follow, boolean withIdentifiers)
    {
        // getInstanceAttributeNameList has no pre constraints
        String returnValue = handleGetInstanceAttributeNameList(follow, withIdentifiers);
        // getInstanceAttributeNameList has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * Gets a comma separated list of instance attribute types.  If 'follow' is true, will travel up
     * the inheritance hierarchy to include instance attribute types in parent entities as well.  If
     * 'withIdentifiers' is true, will include identifiers.
     * @param follow
     * @param withIdentifiers
     * @return String
     */
    protected abstract String handleGetInstanceAttributeTypeList(boolean follow, boolean withIdentifiers);

    /**
     * Gets a comma separated list of instance attribute types.  If 'follow' is true, will travel up
     * the inheritance hierarchy to include instance attribute types in parent entities as well.  If
     * 'withIdentifiers' is true, will include identifiers.
     * @param follow boolean
     * Whether or not to 'follow' the inheritance hierarchy.
     * @param withIdentifiers boolean
     * Whether or not to include identifiers.
     * @return handleGetInstanceAttributeTypeList(follow, withIdentifiers)
     */
    public String getInstanceAttributeTypeList(boolean follow, boolean withIdentifiers)
    {
        // getInstanceAttributeTypeList has no pre constraints
        String returnValue = handleGetInstanceAttributeTypeList(follow, withIdentifiers);
        // getInstanceAttributeTypeList has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * Gets the Spring bean name, and optionally adds a target suffix, if 'targetSuffix' is set to
     * true.
     * @param targetSuffix
     * @return String
     */
    protected abstract String handleGetBeanName(boolean targetSuffix);

    /**
     * Gets the Spring bean name, and optionally adds a target suffix, if 'targetSuffix' is set to
     * true.
     * @param targetSuffix boolean
     * Whether or not to add a target suffix to the bean name.
     * @return handleGetBeanName(targetSuffix)
     */
    public String getBeanName(boolean targetSuffix)
    {
        // getBeanName has no pre constraints
        String returnValue = handleGetBeanName(targetSuffix);
        // getBeanName has no post constraints
        return returnValue;
    }

    // ------------- associations ------------------

    private transient EJB3EntityFacade getRoot1r;
    private transient boolean getRoot1rSet = false;

    /**
     * Represents an entity EJB.
     * @return (EJB3EntityFacade)handleGetRoot()
     */
    public final EJB3EntityFacade getRoot()
    {
        EJB3EntityFacade getRoot1r = this.getRoot1r;
        if (!this.getRoot1rSet)
        {
            // eJB3EntityFacade has no pre constraints
            Object result = handleGetRoot();
            MetafacadeBase shieldedResult = this.shieldedElement(result);
            try
            {
                getRoot1r = (EJB3EntityFacade) shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                EJB3EntityFacadeLogic.LOGGER.warn("incorrect metafacade cast for EJB3EntityFacadeLogic.getRoot EJB3EntityFacade " + result + ": " + shieldedResult);
            }
            // eJB3EntityFacade has no post constraints
            this.getRoot1r = getRoot1r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getRoot1rSet = true;
            }
        }
        return getRoot1r;
    }

    /**
     * UML Specific type is transformed by shieldedElements to AndroMDA Metafacade type
     * @return Object
     */
    protected abstract Object handleGetRoot();

    /**
     * Represents an entity EJB.
     * @return (Collection<DependencyFacade>)handleGetValueObjectReferences()
     */
    public final Collection<DependencyFacade> getValueObjectReferences()
    {
        Collection<DependencyFacade> getValueObjectReferences2r = null;
        // eJB3EntityFacade has no pre constraints
        Collection result = handleGetValueObjectReferences();
        List shieldedResult = this.shieldedElements(result);
        try
        {
            getValueObjectReferences2r = (Collection<DependencyFacade>) shieldedResult;
        }
        catch (ClassCastException ex)
        {
            // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
            EJB3EntityFacadeLogic.LOGGER.warn("incorrect metafacade cast for EJB3EntityFacadeLogic.getValueObjectReferences Collection<DependencyFacade> " + result + ": " + shieldedResult);
        }
        // eJB3EntityFacade has no post constraints
        return getValueObjectReferences2r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  Collection
     */
    protected abstract Collection handleGetValueObjectReferences();

    /**
     * Represents an entity EJB.
     * @return (AttributeFacade)handleGetManageableDisplayAttribute()
     */
    public final AttributeFacade getManageableDisplayAttribute()
    {
        AttributeFacade getManageableDisplayAttribute3r = null;
        // eJB3EntityFacade has no pre constraints
        Object result = handleGetManageableDisplayAttribute();
        MetafacadeBase shieldedResult = this.shieldedElement(result);
        try
        {
            getManageableDisplayAttribute3r = (AttributeFacade) shieldedResult;
        }
        catch (ClassCastException ex)
        {
            // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
            EJB3EntityFacadeLogic.LOGGER.warn("incorrect metafacade cast for EJB3EntityFacadeLogic.getManageableDisplayAttribute AttributeFacade " + result + ": " + shieldedResult);
        }
        // eJB3EntityFacade has no post constraints
        return getManageableDisplayAttribute3r;
    }

    /**
     * UML Specific type is transformed by shieldedElements to AndroMDA Metafacade type
     * @return Object
     */
    protected abstract Object handleGetManageableDisplayAttribute();

    /**
     * Represents an entity EJB.
     * @return (Collection<DependencyFacade>)handleGetAllValueObjectReferences()
     */
    public final Collection<DependencyFacade> getAllValueObjectReferences()
    {
        Collection<DependencyFacade> getAllValueObjectReferences4r = null;
        // eJB3EntityFacade has no pre constraints
        Collection result = handleGetAllValueObjectReferences();
        List shieldedResult = this.shieldedElements(result);
        try
        {
            getAllValueObjectReferences4r = (Collection<DependencyFacade>) shieldedResult;
        }
        catch (ClassCastException ex)
        {
            // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
            EJB3EntityFacadeLogic.LOGGER.warn("incorrect metafacade cast for EJB3EntityFacadeLogic.getAllValueObjectReferences Collection<DependencyFacade> " + result + ": " + shieldedResult);
        }
        // eJB3EntityFacade has no post constraints
        return getAllValueObjectReferences4r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  Collection
     */
    protected abstract Collection handleGetAllValueObjectReferences();

    private transient Collection<EJB3OperationFacade> getDaoBusinessOperations5r;
    private transient boolean getDaoBusinessOperations5rSet = false;

    /**
     * Represents an entity EJB.
     * @return (Collection<EJB3OperationFacade>)handleGetDaoBusinessOperations()
     */
    public final Collection<EJB3OperationFacade> getDaoBusinessOperations()
    {
        Collection<EJB3OperationFacade> getDaoBusinessOperations5r = this.getDaoBusinessOperations5r;
        if (!this.getDaoBusinessOperations5rSet)
        {
            // eJB3EntityFacade has no pre constraints
            Collection result = handleGetDaoBusinessOperations();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getDaoBusinessOperations5r = (Collection<EJB3OperationFacade>) shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                EJB3EntityFacadeLogic.LOGGER.warn("incorrect metafacade cast for EJB3EntityFacadeLogic.getDaoBusinessOperations Collection<EJB3OperationFacade> " + result + ": " + shieldedResult);
            }
            // eJB3EntityFacade has no post constraints
            this.getDaoBusinessOperations5r = getDaoBusinessOperations5r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getDaoBusinessOperations5rSet = true;
            }
        }
        return getDaoBusinessOperations5r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  Collection
     */
    protected abstract Collection handleGetDaoBusinessOperations();

    /**
     * Represents an entity EJB.
     * @return (Collection<Role>)handleGetNonRunAsRoles()
     */
    public final Collection<Role> getNonRunAsRoles()
    {
        Collection<Role> getNonRunAsRoles6r = null;
        // eJB3EntityFacade has no pre constraints
        Collection result = handleGetNonRunAsRoles();
        List shieldedResult = this.shieldedElements(result);
        try
        {
            getNonRunAsRoles6r = (Collection<Role>) shieldedResult;
        }
        catch (ClassCastException ex)
        {
            // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
            EJB3EntityFacadeLogic.LOGGER.warn("incorrect metafacade cast for EJB3EntityFacadeLogic.getNonRunAsRoles Collection<Role> " + result + ": " + shieldedResult);
        }
        // eJB3EntityFacade has no post constraints
        return getNonRunAsRoles6r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  Collection
     */
    protected abstract Collection handleGetNonRunAsRoles();

    private transient ModelElementFacade getIdentifier7r;
    private transient boolean getIdentifier7rSet = false;

    /**
     * Represents an entity EJB.
     * @return (ModelElementFacade)handleGetIdentifier()
     */
    public final ModelElementFacade getIdentifier()
    {
        ModelElementFacade getIdentifier7r = this.getIdentifier7r;
        if (!this.getIdentifier7rSet)
        {
            // eJB3EntityFacade has no pre constraints
            Object result = handleGetIdentifier();
            MetafacadeBase shieldedResult = this.shieldedElement(result);
            try
            {
                getIdentifier7r = (ModelElementFacade) shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                EJB3EntityFacadeLogic.LOGGER.warn("incorrect metafacade cast for EJB3EntityFacadeLogic.getIdentifier ModelElementFacade " + result + ": " + shieldedResult);
            }
            // eJB3EntityFacade has no post constraints
            this.getIdentifier7r = getIdentifier7r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getIdentifier7rSet = true;
            }
        }
        return getIdentifier7r;
    }

    /**
     * UML Specific type is transformed by shieldedElements to AndroMDA Metafacade type
     * @return Object
     */
    protected abstract Object handleGetIdentifier();

    /**
     * @return true
     * @see Entity
     */
    public boolean isEntityMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see ClassifierFacade
     */
    public boolean isClassifierFacadeMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see GeneralizableElementFacade
     */
    public boolean isGeneralizableElementFacadeMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see ModelElementFacade
     */
    public boolean isModelElementFacadeMetaType()
    {
        return true;
    }

    // ----------- delegates to Entity ------------
    /**
     * Return the attribute which name matches the parameter
     * @see ClassifierFacade#findAttribute(String name)
     */
    public AttributeFacade findAttribute(String name)
    {
        return this.getSuperEntity().findAttribute(name);
    }

    /**
     * Those abstraction dependencies for which this classifier is the client.
     * @see ClassifierFacade#getAbstractions()
     */
    public Collection<ClassifierFacade> getAbstractions()
    {
        return this.getSuperEntity().getAbstractions();
    }

    /**
     * Lists all classes associated to this one and any ancestor classes (through generalization).
     * There will be no duplicates. The order of the elements is predictable.
     * @see ClassifierFacade#getAllAssociatedClasses()
     */
    public Collection<ClassifierFacade> getAllAssociatedClasses()
    {
        return this.getSuperEntity().getAllAssociatedClasses();
    }

    /**
     * A collection containing all 'properties' of the classifier and its ancestors.  Properties are
     * any attributes and navigable connecting association ends.
     * @see ClassifierFacade#getAllProperties()
     */
    public Collection<ModelElementFacade> getAllProperties()
    {
        return this.getSuperEntity().getAllProperties();
    }

    /**
     * A collection containing all required and/or read-only 'properties' of the classifier and its
     * ancestors. Properties are any attributes and navigable connecting association ends.
     * @see ClassifierFacade#getAllRequiredConstructorParameters()
     */
    public Collection<ModelElementFacade> getAllRequiredConstructorParameters()
    {
        return this.getSuperEntity().getAllRequiredConstructorParameters();
    }

    /**
     * Gets the array type for this classifier.  If this classifier already represents an array, it
     * just returns itself.
     * @see ClassifierFacade#getArray()
     */
    public ClassifierFacade getArray()
    {
        return this.getSuperEntity().getArray();
    }

    /**
     * The name of the classifier as an array.
     * @see ClassifierFacade#getArrayName()
     */
    public String getArrayName()
    {
        return this.getSuperEntity().getArrayName();
    }

    /**
     * Lists the classes associated to this one, there is no repitition of classes. The order of the
     * elements is predictable.
     * @see ClassifierFacade#getAssociatedClasses()
     */
    public Collection<ClassifierFacade> getAssociatedClasses()
    {
        return this.getSuperEntity().getAssociatedClasses();
    }

    /**
     * Gets the association ends belonging to a classifier.
     * @see ClassifierFacade#getAssociationEnds()
     */
    public List<AssociationEndFacade> getAssociationEnds()
    {
        return this.getSuperEntity().getAssociationEnds();
    }

    /**
     * Gets the attributes that belong to the classifier.
     * @see ClassifierFacade#getAttributes()
     */
    public List<AttributeFacade> getAttributes()
    {
        return this.getSuperEntity().getAttributes();
    }

    /**
     * Gets all attributes for the classifier and if 'follow' is true goes up the inheritance
     * hierarchy and gets the attributes from the super classes as well.
     * @see ClassifierFacade#getAttributes(boolean follow)
     */
    public List<AttributeFacade> getAttributes(boolean follow)
    {
        return this.getSuperEntity().getAttributes(follow);
    }

    /**
     * The fully qualified name of the classifier as an array.
     * @see ClassifierFacade#getFullyQualifiedArrayName()
     */
    public String getFullyQualifiedArrayName()
    {
        return this.getSuperEntity().getFullyQualifiedArrayName();
    }

    /**
     * Returns all those operations that could be implemented at this classifier's level. This means
     * the operations owned by this classifier as well as any realized interface's operations
     * (recursively) in case this classifier itself is not already an interface, or generalized when
     * this classifier is an interface.
     * @see ClassifierFacade#getImplementationOperations()
     */
    public Collection<OperationFacade> getImplementationOperations()
    {
        return this.getSuperEntity().getImplementationOperations();
    }

    /**
     * A comma separated list of the fully qualified names of all implemented interfaces.
     * @see ClassifierFacade#getImplementedInterfaceList()
     */
    public String getImplementedInterfaceList()
    {
        return this.getSuperEntity().getImplementedInterfaceList();
    }

    /**
     * Those attributes that are scoped to an instance of this class.
     * @see ClassifierFacade#getInstanceAttributes()
     */
    public Collection<AttributeFacade> getInstanceAttributes()
    {
        return this.getSuperEntity().getInstanceAttributes();
    }

    /**
     * Those operations that are scoped to an instance of this class.
     * @see ClassifierFacade#getInstanceOperations()
     */
    public List<OperationFacade> getInstanceOperations()
    {
        return this.getSuperEntity().getInstanceOperations();
    }

    /**
     * Those interfaces that are abstractions of this classifier, this basically means this
     * classifier realizes them.
     * @see ClassifierFacade#getInterfaceAbstractions()
     */
    public Collection<ClassifierFacade> getInterfaceAbstractions()
    {
        return this.getSuperEntity().getInterfaceAbstractions();
    }

    /**
     * A String representing a new Constructor declaration for this classifier type to be used in a
     * Java environment.
     * @see ClassifierFacade#getJavaNewString()
     */
    public String getJavaNewString()
    {
        return this.getSuperEntity().getJavaNewString();
    }

    /**
     * A String representing the null-value for this classifier type to be used in a Java
     * environment.
     * @see ClassifierFacade#getJavaNullString()
     */
    public String getJavaNullString()
    {
        return this.getSuperEntity().getJavaNullString();
    }

    /**
     * The other ends of this classifier's association ends which are navigable.
     * @see ClassifierFacade#getNavigableConnectingEnds()
     */
    public Collection<AssociationEndFacade> getNavigableConnectingEnds()
    {
        return this.getSuperEntity().getNavigableConnectingEnds();
    }

    /**
     * Get the other ends of this classifier's association ends which are navigable and if 'follow'
     * is true goes up the inheritance hierarchy and gets the super association ends as well.
     * @see ClassifierFacade#getNavigableConnectingEnds(boolean follow)
     */
    public List<AssociationEndFacade> getNavigableConnectingEnds(boolean follow)
    {
        return this.getSuperEntity().getNavigableConnectingEnds(follow);
    }

    /**
     * Assuming that the classifier is an array, this will return the non array type of the
     * classifier from
     * the model.  If the classifier is NOT an array, it will just return itself.
     * @see ClassifierFacade#getNonArray()
     */
    public ClassifierFacade getNonArray()
    {
        return this.getSuperEntity().getNonArray();
    }

    /**
     * The attributes from this classifier in the form of an operation call (this example would be
     * in Java): '(String attributeOne, String attributeTwo).  If there were no attributes on the
     * classifier, the result would be an empty '()'.
     * @see ClassifierFacade#getOperationCallFromAttributes()
     */
    public String getOperationCallFromAttributes()
    {
        return this.getSuperEntity().getOperationCallFromAttributes();
    }

    /**
     * The operations owned by this classifier.
     * @see ClassifierFacade#getOperations()
     */
    public List<OperationFacade> getOperations()
    {
        return this.getSuperEntity().getOperations();
    }

    /**
     * A collection containing all 'properties' of the classifier.  Properties are any attributes
     * and navigable connecting association ends.
     * @see ClassifierFacade#getProperties()
     */
    public List<ModelElementFacade> getProperties()
    {
        return this.getSuperEntity().getProperties();
    }

    /**
     * Gets all properties (attributes and navigable association ends) for the classifier and if
     * 'follow' is true goes up the inheritance hierarchy and gets the properties from the super
     * classes as well.
     * @see ClassifierFacade#getProperties(boolean follow)
     */
    public List getProperties(boolean follow)
    {
        return this.getSuperEntity().getProperties(follow);
    }

    /**
     * A collection containing all required and/or read-only 'properties' of the classifier.
     * Properties are any attributes and navigable connecting association ends.
     * @see ClassifierFacade#getRequiredConstructorParameters()
     */
    public Collection<ModelElementFacade> getRequiredConstructorParameters()
    {
        return this.getSuperEntity().getRequiredConstructorParameters();
    }

    /**
     * Returns the serial version UID of the underlying model element.
     * @see ClassifierFacade#getSerialVersionUID()
     */
    public long getSerialVersionUID()
    {
        return this.getSuperEntity().getSerialVersionUID();
    }

    /**
     * Those attributes that are scoped to the definition of this class.
     * @see ClassifierFacade#getStaticAttributes()
     */
    public Collection<AttributeFacade> getStaticAttributes()
    {
        return this.getSuperEntity().getStaticAttributes();
    }

    /**
     * Those operations that are scoped to the definition of this class.
     * @see ClassifierFacade#getStaticOperations()
     */
    public List<OperationFacade> getStaticOperations()
    {
        return this.getSuperEntity().getStaticOperations();
    }

    /**
     * This class' superclass, returns the generalization if it is a ClassifierFacade, null
     * otherwise.
     * @see ClassifierFacade#getSuperClass()
     */
    public ClassifierFacade getSuperClass()
    {
        return this.getSuperEntity().getSuperClass();
    }

    /**
     * The wrapper name for this classifier if a mapped type has a defined wrapper class (ie. 'long'
     * maps to 'Long').  If the classifier doesn't have a wrapper defined for it, this method will
     * return a null.  Note that wrapper mappings must be defined for the namespace by defining the
     * 'wrapperMappingsUri', this property must point to the location of the mappings file which
     * maps the primitives to wrapper types.
     * @see ClassifierFacade#getWrapperName()
     */
    public String getWrapperName()
    {
        return this.getSuperEntity().getWrapperName();
    }

    /**
     * Indicates if this classifier is 'abstract'.
     * @see ClassifierFacade#isAbstract()
     */
    public boolean isAbstract()
    {
        return this.getSuperEntity().isAbstract();
    }

    /**
     * True if this classifier represents an array type. False otherwise.
     * @see ClassifierFacade#isArrayType()
     */
    public boolean isArrayType()
    {
        return this.getSuperEntity().isArrayType();
    }

    /**
     * True if the ClassifierFacade is an AssociationClass.
     * @see ClassifierFacade#isAssociationClass()
     */
    public boolean isAssociationClass()
    {
        return this.getSuperEntity().isAssociationClass();
    }

    /**
     * Returns true if this type represents a Blob type.
     * @see ClassifierFacade#isBlobType()
     */
    public boolean isBlobType()
    {
        return this.getSuperEntity().isBlobType();
    }

    /**
     * Indicates if this type represents a boolean type or not.
     * @see ClassifierFacade#isBooleanType()
     */
    public boolean isBooleanType()
    {
        return this.getSuperEntity().isBooleanType();
    }

    /**
     * Indicates if this type represents a char, Character, or java.lang.Character type or not.
     * @see ClassifierFacade#isCharacterType()
     */
    public boolean isCharacterType()
    {
        return this.getSuperEntity().isCharacterType();
    }

    /**
     * Returns true if this type represents a Clob type.
     * @see ClassifierFacade#isClobType()
     */
    public boolean isClobType()
    {
        return this.getSuperEntity().isClobType();
    }

    /**
     * True if this classifier represents a collection type. False otherwise.
     * @see ClassifierFacade#isCollectionType()
     */
    public boolean isCollectionType()
    {
        return this.getSuperEntity().isCollectionType();
    }

    /**
     * True/false depending on whether or not this classifier represents a datatype. A data type is
     * a type whose instances are identified only by their value. A data type may contain attributes
     * to support the modeling of structured data types.
     * @see ClassifierFacade#isDataType()
     */
    public boolean isDataType()
    {
        return this.getSuperEntity().isDataType();
    }

    /**
     * True when this classifier is a date type.
     * @see ClassifierFacade#isDateType()
     */
    public boolean isDateType()
    {
        return this.getSuperEntity().isDateType();
    }

    /**
     * Indicates if this type represents a Double type or not.
     * @see ClassifierFacade#isDoubleType()
     */
    public boolean isDoubleType()
    {
        return this.getSuperEntity().isDoubleType();
    }

    /**
     * Indicates whether or not this classifier represents an "EmbeddedValue'.
     * @see ClassifierFacade#isEmbeddedValue()
     */
    public boolean isEmbeddedValue()
    {
        return this.getSuperEntity().isEmbeddedValue();
    }

    /**
     * True if this classifier is in fact marked as an enumeration.
     * @see ClassifierFacade#isEnumeration()
     */
    public boolean isEnumeration()
    {
        return this.getSuperEntity().isEnumeration();
    }

    /**
     * Returns true if this type represents a 'file' type.
     * @see ClassifierFacade#isFileType()
     */
    public boolean isFileType()
    {
        return this.getSuperEntity().isFileType();
    }

    /**
     * Indicates if this type represents a Float type or not.
     * @see ClassifierFacade#isFloatType()
     */
    public boolean isFloatType()
    {
        return this.getSuperEntity().isFloatType();
    }

    /**
     * Indicates if this type represents an int or Integer or java.lang.Integer type or not.
     * @see ClassifierFacade#isIntegerType()
     */
    public boolean isIntegerType()
    {
        return this.getSuperEntity().isIntegerType();
    }

    /**
     * True/false depending on whether or not this Classifier represents an interface.
     * @see ClassifierFacade#isInterface()
     */
    public boolean isInterface()
    {
        return this.getSuperEntity().isInterface();
    }

    /**
     * True if this classifier cannot be extended and represent a leaf in the inheritance tree.
     * @see ClassifierFacade#isLeaf()
     */
    public boolean isLeaf()
    {
        return this.getSuperEntity().isLeaf();
    }

    /**
     * True if this classifier represents a list type. False otherwise.
     * @see ClassifierFacade#isListType()
     */
    public boolean isListType()
    {
        return this.getSuperEntity().isListType();
    }

    /**
     * Indicates if this type represents a Long type or not.
     * @see ClassifierFacade#isLongType()
     */
    public boolean isLongType()
    {
        return this.getSuperEntity().isLongType();
    }

    /**
     * Indicates whether or not this classifier represents a Map type.
     * @see ClassifierFacade#isMapType()
     */
    public boolean isMapType()
    {
        return this.getSuperEntity().isMapType();
    }

    /**
     * Indicates whether or not this classifier represents a primitive type.
     * @see ClassifierFacade#isPrimitive()
     */
    public boolean isPrimitive()
    {
        return this.getSuperEntity().isPrimitive();
    }

    /**
     * True if this classifier represents a set type. False otherwise.
     * @see ClassifierFacade#isSetType()
     */
    public boolean isSetType()
    {
        return this.getSuperEntity().isSetType();
    }

    /**
     * Indicates whether or not this classifier represents a string type.
     * @see ClassifierFacade#isStringType()
     */
    public boolean isStringType()
    {
        return this.getSuperEntity().isStringType();
    }

    /**
     * Indicates whether or not this classifier represents a time type.
     * @see ClassifierFacade#isTimeType()
     */
    public boolean isTimeType()
    {
        return this.getSuperEntity().isTimeType();
    }

    /**
     * Returns true if this type is a wrapped primitive type.
     * @see ClassifierFacade#isWrappedPrimitive()
     */
    public boolean isWrappedPrimitive()
    {
        return this.getSuperEntity().isWrappedPrimitive();
    }

    /**
     * Returns a collection of all entities this entity and its ancestors have a relation to.
     * @see Entity#getAllEntityReferences()
     */
    public Collection<DependencyFacade> getAllEntityReferences()
    {
        return this.getSuperEntity().getAllEntityReferences();
    }

    /**
     * Gets a comma separated list of attribute names.  If 'follow' is true, will travel up the
     * inheritance hiearchy to include attributes in parent entities as well.  If 'withIdentifiers'
     * is true, will include identifiers.
     * @see Entity#getAttributeNameList(boolean follow, boolean withIdentifiers)
     */
    public String getAttributeNameList(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperEntity().getAttributeNameList(follow, withIdentifiers);
    }

    /**
     * Gets a comma separated list of attribute names.  If 'follow' is true, will travel up the
     * inheritance hiearchy to include attributes in parent entities as well.  If 'withIdentifiers'
     * is true, will include identifiers  and  if 'withDerived' is set to true, will include derived
     * attributes.
     * @see Entity#getAttributeNameList(boolean follow, boolean withIdentifiers, boolean withDerived)
     */
    public String getAttributeNameList(boolean follow, boolean withIdentifiers, boolean withDerived)
    {
        return this.getSuperEntity().getAttributeNameList(follow, withIdentifiers, withDerived);
    }

    /**
     * Gets a comma separated list of attribute types.  If 'follow' is true, will travel up the
     * inheritance hierarchy to include attributes in parent entities as well.  If 'withIdentifiers'
     * is true, will include identifiers.
     * @see Entity#getAttributeTypeList(boolean follow, boolean withIdentifiers)
     */
    public String getAttributeTypeList(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperEntity().getAttributeTypeList(follow, withIdentifiers);
    }

    /**
     * Gets all attributes of the entity, and optionally retieves the super entities attributes as
     * well as excludes the entity's identifiers if 'withIdentifiers' is set to false.
     * @see Entity#getAttributes(boolean follow, boolean withIdentifiers)
     */
    public Collection<AttributeFacade> getAttributes(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperEntity().getAttributes(follow, withIdentifiers);
    }

    /**
     * Gets all attributes of the entity, and optionally retieves the super entities attributes as
     * well as excludes the entity's identifiers if 'withIdentifiers' is set to false and exclude
     * derived attributes if 'withDerived' is set to false.
     * @see Entity#getAttributes(boolean follow, boolean withIdentifiers, boolean withDerived)
     */
    public Collection<AttributeFacade> getAttributes(boolean follow, boolean withIdentifiers, boolean withDerived)
    {
        return this.getSuperEntity().getAttributes(follow, withIdentifiers, withDerived);
    }

    /**
     * All business operations of the entity, these include any operations that aren't queries.
     * @see Entity#getBusinessOperations()
     */
    public Collection<OperationFacade> getBusinessOperations()
    {
        return this.getSuperEntity().getBusinessOperations();
    }

    /**
     * Gets any children association ends (i.e. entity association ends that are participants in an
     * association with this entity and this entity has composite aggregation defined for those
     * associations).
     * @see Entity#getChildEnds()
     */
    public Collection<EntityAssociationEnd> getChildEnds()
    {
        return this.getSuperEntity().getChildEnds();
    }

    /**
     * The embedded values belonging to this entity.
     * @see Entity#getEmbeddedValues()
     */
    public Collection<AttributeFacade> getEmbeddedValues()
    {
        return this.getSuperEntity().getEmbeddedValues();
    }

    /**
     * All entities referenced by this entity.
     * @see Entity#getEntityReferences()
     */
    public Collection<DependencyFacade> getEntityReferences()
    {
        return this.getSuperEntity().getEntityReferences();
    }

    /**
     * The full name of the type of the identifier. If composite identifier add the PK sufix to the
     * class name. If not, retorns the fully qualified name of the identifier.
     * @see Entity#getFullyQualifiedIdentifierTypeName()
     */
    public String getFullyQualifiedIdentifierTypeName()
    {
        return this.getSuperEntity().getFullyQualifiedIdentifierTypeName();
    }

    /**
     * Gets all the associationEnds of this entity marked with the identifiers stereotype.
     * @see Entity#getIdentifierAssociationEnds()
     */
    public Collection<AssociationEndFacade> getIdentifierAssociationEnds()
    {
        return this.getSuperEntity().getIdentifierAssociationEnds();
    }

    /**
     * The getter name of the identifier.
     * @see Entity#getIdentifierGetterName()
     */
    public String getIdentifierGetterName()
    {
        return this.getSuperEntity().getIdentifierGetterName();
    }

    /**
     * The name of the identifier. If composite identifier add the Pk suffix. If not composite
     * returns the attribute name of the identifier.
     * @see Entity#getIdentifierName()
     */
    public String getIdentifierName()
    {
        return this.getSuperEntity().getIdentifierName();
    }

    /**
     * The setter name of the identifier.
     * @see Entity#getIdentifierSetterName()
     */
    public String getIdentifierSetterName()
    {
        return this.getSuperEntity().getIdentifierSetterName();
    }

    /**
     * The name of the type of the identifier. If composite identifier add the PK suffix to the
     * class name. If not, returns the name of the identifier.
     * @see Entity#getIdentifierTypeName()
     */
    public String getIdentifierTypeName()
    {
        return this.getSuperEntity().getIdentifierTypeName();
    }

    /**
     * All the attributes of the entity which make up its identifier (primary key).  Will search any
     * super classes as well.  If no identifiers exist, a default identifier will be created if the
     * allowDefaultIdentifiers property is set to true.
     * @see Entity#getIdentifiers()
     */
    public Collection<ModelElementFacade> getIdentifiers()
    {
        return this.getSuperEntity().getIdentifiers();
    }

    /**
     * Gets all identifiers for an entity. If 'follow' is true, and if no identifiers can be found
     * on the entity, a search up the inheritance chain will be performed, and the identifiers from
     * the first super class having them will be used.   If no identifiers exist, a default
     * identifier will be created if the allowDefaultIdentifiers property is set to true.
     * Identifiers can be on attributes or associations (composite primary key).
     * @see Entity#getIdentifiers(boolean follow)
     */
    public Collection<ModelElementFacade> getIdentifiers(boolean follow)
    {
        return this.getSuperEntity().getIdentifiers(follow);
    }

    /**
     * The maximum length a SQL name may be.
     * @see Entity#getMaxSqlNameLength()
     */
    public short getMaxSqlNameLength()
    {
        return this.getSuperEntity().getMaxSqlNameLength();
    }

    /**
     * Gets the attributes as a list within an operation call, optionally including the type names
     * and the identifier attributes.
     * @see Entity#getOperationCallFromAttributes(boolean withIdentifiers)
     */
    public String getOperationCallFromAttributes(boolean withIdentifiers)
    {
        return this.getSuperEntity().getOperationCallFromAttributes(withIdentifiers);
    }

    /**
     * Gets the attributes as a list within an operation call.  If 'withTypeNames' is true, it will
     * include the type names, if 'withIdentifiers' is true it will include the identifiers.  If
     * 'follow' is true it will follow the inheritance hierarchy and get the attributes of the super
     * class as well.
     * @see Entity#getOperationCallFromAttributes(boolean withIdentifiers, boolean follow)
     */
    public String getOperationCallFromAttributes(boolean withIdentifiers, boolean follow)
    {
        return this.getSuperEntity().getOperationCallFromAttributes(withIdentifiers, follow);
    }

    /**
     * Returns the parent association end of this entity if its a child entity.  The parent is the
     * entity that is the participant the association that has composite aggregation defined.  Will
     * return null if the entity has no parent.
     * @see Entity#getParentEnd()
     */
    public EntityAssociationEnd getParentEnd()
    {
        return this.getSuperEntity().getParentEnd();
    }

    /**
     * Gets all properties of this entity, this includes the attributes and navigable association
     * ends of the entity.  The 'follow' flag indcates whether or not the inheritance hierarchy
     * should be followed when getting all the properties.  The 'withIdentifiers' flag indicates
     * whether or not identifiers should be included in the collection of properties.
     * @see Entity#getProperties(boolean follow, boolean withIdentifiers)
     */
    public Collection<ModelElementFacade> getProperties(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperEntity().getProperties(follow, withIdentifiers);
    }

    /**
     * Returns all the operations that can perform queries on the entity.
     * @see Entity#getQueryOperations()
     */
    public Collection<EntityQueryOperation> getQueryOperations()
    {
        return this.getSuperEntity().getQueryOperations();
    }

    /**
     * Gets all query operations for an entity. If 'follow' is true, and if no query operations can
     * be found on the entity, a search up the inheritance chain will be performed, and the
     * identifiers from the first super class having them will be used.   If no identifiers exist, a
     * default identifier will be created if the allowDefaultIdentifiers property is set to true.
     * @see Entity#getQueryOperations(boolean follow)
     */
    public Collection<OperationFacade> getQueryOperations(boolean follow)
    {
        return this.getSuperEntity().getQueryOperations(follow);
    }

    /**
     * Gets a comma separated list of required attribute names.  If 'follow' is true, will travel up
     * the inheritance hierarchy to include attributes in parent entities as well.  If
     * 'withIdentifiers' is true, will include identifiers.
     * @see Entity#getRequiredAttributeNameList(boolean follow, boolean withIdentifiers)
     */
    public String getRequiredAttributeNameList(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperEntity().getRequiredAttributeNameList(follow, withIdentifiers);
    }

    /**
     * Gets a comma separated list of attribute types with are required.  If 'follow' is true, will
     * travel up the inheritance hierarchy to include attributes in parent entities as well.  If
     * 'withIdentifiers' is true, will include identifiers.
     * @see Entity#getRequiredAttributeTypeList(boolean follow, boolean withIdentifiers)
     */
    public String getRequiredAttributeTypeList(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperEntity().getRequiredAttributeTypeList(follow, withIdentifiers);
    }

    /**
     * Returns all attributes that are specified as 'required' in the model.  If 'follow' is true,
     * then required attributes in super classes will also be returned, if false, just the ones
     * directly on the entity will be returned.  If 'withIdentifiers' is true, the identifiers will
     * be include, if false, no identifiers will be included.
     * @see Entity#getRequiredAttributes(boolean follow, boolean withIdentifiers)
     */
    public Collection<AttributeFacade> getRequiredAttributes(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperEntity().getRequiredAttributes(follow, withIdentifiers);
    }

    /**
     * Gets all required properties for this entity.  These consist of any required attributes as
     * well as navigable associations that are marked as 'required'.  If 'follow' is true, then the
     * inheritance hierchy will be followed and all required properties from super classes will be
     * included as well.
     * If 'withIdentifiers' is true, the identifiers will be include, if false, no identifiers will
     * be included.
     * @see Entity#getRequiredProperties(boolean follow, boolean withIdentifiers)
     */
    public Collection<ModelElementFacade> getRequiredProperties(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperEntity().getRequiredProperties(follow, withIdentifiers);
    }

    /**
     * Creates a comma separated list of the required property names.
     * @see Entity#getRequiredPropertyNameList(boolean follow, boolean withIdentifiers)
     */
    public String getRequiredPropertyNameList(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperEntity().getRequiredPropertyNameList(follow, withIdentifiers);
    }

    /**
     * A comma separated list of the required property types.
     * @see Entity#getRequiredPropertyTypeList(boolean follow, boolean withIdentifiers)
     */
    public String getRequiredPropertyTypeList(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperEntity().getRequiredPropertyTypeList(follow, withIdentifiers);
    }

    /**
     * The name of the schema that contains the database table
     * @see Entity#getSchema()
     */
    public String getSchema()
    {
        return this.getSuperEntity().getSchema();
    }

    /**
     * The name of the database table to which this entity is persisted.
     * @see Entity#getTableName()
     */
    public String getTableName()
    {
        return this.getSuperEntity().getTableName();
    }

    /**
     * Returns true/false depending on whether or not this entity represetns a child in an
     * association (this occurs when this entity is on the opposite end of an assocation end defined
     * as composite).
     * @see Entity#isChild()
     */
    public boolean isChild()
    {
        return this.getSuperEntity().isChild();
    }

    /**
     * TODO: Model Documentation for Entity.compositeIdentifier
     * @see Entity#isCompositeIdentifier()
     */
    public boolean isCompositeIdentifier()
    {
        return this.getSuperEntity().isCompositeIdentifier();
    }

    /**
     * True if the entity has its identifiers dynamically added, false otherwise.
     * @see Entity#isDynamicIdentifiersPresent()
     */
    public boolean isDynamicIdentifiersPresent()
    {
        return this.getSuperEntity().isDynamicIdentifiersPresent();
    }

    /**
     * True if the entity has any identifiers defined, false otherwise.
     * @see Entity#isIdentifiersPresent()
     */
    public boolean isIdentifiersPresent()
    {
        return this.getSuperEntity().isIdentifiersPresent();
    }

    /**
     * Indiciates if this entity is using an assigned identifier or not.
     * @see Entity#isUsingAssignedIdentifier()
     */
    public boolean isUsingAssignedIdentifier()
    {
        return this.getSuperEntity().isUsingAssignedIdentifier();
    }

    /**
     * Indicates whether or not this entity is using a foreign identifier as its identifiers.  That
     * is: the foreignIdentifier flag was set on an incoming association end and the entity is
     * therefore using the related foreign parent entity's identifier.
     * @see Entity#isUsingForeignIdentifier()
     */
    public boolean isUsingForeignIdentifier()
    {
        return this.getSuperEntity().isUsingForeignIdentifier();
    }

    /**
     * Finds the tagged value optional searching the entire inheritance hierarchy if 'follow' is set
     * to true.
     * @see GeneralizableElementFacade#findTaggedValue(String tagName, boolean follow)
     */
    public Object findTaggedValue(String tagName, boolean follow)
    {
        return this.getSuperEntity().findTaggedValue(tagName, follow);
    }

    /**
     * All generalizations for this generalizable element, goes up the inheritance tree.
     * @see GeneralizableElementFacade#getAllGeneralizations()
     */
    public Collection<GeneralizableElementFacade> getAllGeneralizations()
    {
        return this.getSuperEntity().getAllGeneralizations();
    }

    /**
     * All specializations (travels down the inheritance hierarchy).
     * @see GeneralizableElementFacade#getAllSpecializations()
     */
    public Collection<GeneralizableElementFacade> getAllSpecializations()
    {
        return this.getSuperEntity().getAllSpecializations();
    }

    /**
     * Gets the direct generalization for this generalizable element.
     * @see GeneralizableElementFacade#getGeneralization()
     */
    public GeneralizableElementFacade getGeneralization()
    {
        return this.getSuperEntity().getGeneralization();
    }

    /**
     * Gets the actual links that this generalization element is part of (it plays either the
     * specialization or generalization).
     * @see GeneralizableElementFacade#getGeneralizationLinks()
     */
    public Collection<GeneralizationFacade> getGeneralizationLinks()
    {
        return this.getSuperEntity().getGeneralizationLinks();
    }

    /**
     * A comma separated list of the fully qualified names of all generalizations.
     * @see GeneralizableElementFacade#getGeneralizationList()
     */
    public String getGeneralizationList()
    {
        return this.getSuperEntity().getGeneralizationList();
    }

    /**
     * The element found when you recursively follow the generalization path up to the root. If an
     * element has no generalization itself will be considered the root.
     * @see GeneralizableElementFacade#getGeneralizationRoot()
     */
    public GeneralizableElementFacade getGeneralizationRoot()
    {
        return this.getSuperEntity().getGeneralizationRoot();
    }

    /**
     * The model element that represents an element that can be generalized or specialized.
     * @see GeneralizableElementFacade#getGeneralizations()
     */
    public Collection<GeneralizableElementFacade> getGeneralizations()
    {
        return this.getSuperEntity().getGeneralizations();
    }

    /**
     * Gets the direct specializations (i.e. sub elements) for this generalizatble element.
     * @see GeneralizableElementFacade#getSpecializations()
     */
    public Collection<GeneralizableElementFacade> getSpecializations()
    {
        return this.getSuperEntity().getSpecializations();
    }

    /**
     * Copies all tagged values from the given ModelElementFacade to this model element facade.
     * @see ModelElementFacade#copyTaggedValues(ModelElementFacade element)
     */
    public void copyTaggedValues(ModelElementFacade element)
    {
        this.getSuperEntity().copyTaggedValues(element);
    }

    /**
     * Finds the tagged value with the specified 'tagName'. In case there are more values the first
     * one found will be returned.
     * @see ModelElementFacade#findTaggedValue(String tagName)
     */
    public Object findTaggedValue(String tagName)
    {
        return this.getSuperEntity().findTaggedValue(tagName);
    }

    /**
     * Returns all the values for the tagged value with the specified name. The returned collection
     * will contains only String instances, or will be empty. Never null.
     * @see ModelElementFacade#findTaggedValues(String tagName)
     */
    public Collection<Object> findTaggedValues(String tagName)
    {
        return this.getSuperEntity().findTaggedValues(tagName);
    }

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element. The templates parameter will
     * be replaced by the correct one given the binding relation of the parameter to this element.
     * @see ModelElementFacade#getBindedFullyQualifiedName(ModelElementFacade bindedElement)
     */
    public String getBindedFullyQualifiedName(ModelElementFacade bindedElement)
    {
        return this.getSuperEntity().getBindedFullyQualifiedName(bindedElement);
    }

    /**
     * Gets all constraints belonging to the model element.
     * @see ModelElementFacade#getConstraints()
     */
    public Collection<ConstraintFacade> getConstraints()
    {
        return this.getSuperEntity().getConstraints();
    }

    /**
     * Returns the constraints of the argument kind that have been placed onto this model. Typical
     * kinds are "inv", "pre" and "post". Other kinds are possible.
     * @see ModelElementFacade#getConstraints(String kind)
     */
    public Collection<ConstraintFacade> getConstraints(String kind)
    {
        return this.getSuperEntity().getConstraints(kind);
    }

    /**
     * Gets the documentation for the model element, The indent argument is prefixed to each line.
     * By default this method wraps lines after 64 characters.
     * This method is equivalent to <code>getDocumentation(indent, 64)</code>.
     * @see ModelElementFacade#getDocumentation(String indent)
     */
    public String getDocumentation(String indent)
    {
        return this.getSuperEntity().getDocumentation(indent);
    }

    /**
     * This method returns the documentation for this model element, with the lines wrapped after
     * the specified number of characters, values of less than 1 will indicate no line wrapping is
     * required. By default paragraphs are returned as HTML.
     * This method is equivalent to <code>getDocumentation(indent, lineLength, true)</code>.
     * @see ModelElementFacade#getDocumentation(String indent, int lineLength)
     */
    public String getDocumentation(String indent, int lineLength)
    {
        return this.getSuperEntity().getDocumentation(indent, lineLength);
    }

    /**
     * This method returns the documentation for this model element, with the lines wrapped after
     * the specified number of characters, values of less than 1 will indicate no line wrapping is
     * required. HTML style determines if HTML Escaping is applied.
     * @see ModelElementFacade#getDocumentation(String indent, int lineLength, boolean htmlStyle)
     */
    public String getDocumentation(String indent, int lineLength, boolean htmlStyle)
    {
        return this.getSuperEntity().getDocumentation(indent, lineLength, htmlStyle);
    }

    /**
     * The fully qualified name of this model element.
     * @see ModelElementFacade#getFullyQualifiedName()
     */
    public String getFullyQualifiedName()
    {
        return this.getSuperEntity().getFullyQualifiedName();
    }

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element.  If modelName is true, then
     * the original name of the model element (the name contained within the model) will be the name
     * returned, otherwise a name from a language mapping will be returned.
     * @see ModelElementFacade#getFullyQualifiedName(boolean modelName)
     */
    public String getFullyQualifiedName(boolean modelName)
    {
        return this.getSuperEntity().getFullyQualifiedName(modelName);
    }

    /**
     * Returns the fully qualified name as a path, the returned value always starts with out a slash
     * '/'.
     * @see ModelElementFacade#getFullyQualifiedNamePath()
     */
    public String getFullyQualifiedNamePath()
    {
        return this.getSuperEntity().getFullyQualifiedNamePath();
    }

    /**
     * Gets the unique identifier of the underlying model element.
     * @see ModelElementFacade#getId()
     */
    public String getId()
    {
        return this.getSuperEntity().getId();
    }

    /**
     * UML2: Retrieves the keywords for this element. Used to modify implementation properties which
     * are not represented by other properties, i.e. native, transient, volatile, synchronized,
     * (added annotations) override, deprecated. Can also be used to suppress compiler warnings:
     * (added annotations) unchecked, fallthrough, path, serial, finally, all. Annotations require
     * JDK5 compiler level.
     * @see ModelElementFacade#getKeywords()
     */
    public Collection<String> getKeywords()
    {
        return this.getSuperEntity().getKeywords();
    }

    /**
     * UML2: Retrieves a localized label for this named element.
     * @see ModelElementFacade#getLabel()
     */
    public String getLabel()
    {
        return this.getSuperEntity().getLabel();
    }

    /**
     * The language mappings that have been set for this model element.
     * @see ModelElementFacade#getLanguageMappings()
     */
    public TypeMappings getLanguageMappings()
    {
        return this.getSuperEntity().getLanguageMappings();
    }

    /**
     * Return the model containing this model element (multiple models may be loaded and processed
     * at the same time).
     * @see ModelElementFacade#getModel()
     */
    public ModelFacade getModel()
    {
        return this.getSuperEntity().getModel();
    }

    /**
     * The name of the model element.
     * @see ModelElementFacade#getName()
     */
    public String getName()
    {
        return this.getSuperEntity().getName();
    }

    /**
     * Gets the package to which this model element belongs.
     * @see ModelElementFacade#getPackage()
     */
    public ModelElementFacade getPackage()
    {
        return this.getSuperEntity().getPackage();
    }

    /**
     * The name of this model element's package.
     * @see ModelElementFacade#getPackageName()
     */
    public String getPackageName()
    {
        return this.getSuperEntity().getPackageName();
    }

    /**
     * Gets the package name (optionally providing the ability to retrieve the model name and not
     * the mapped name).
     * @see ModelElementFacade#getPackageName(boolean modelName)
     */
    public String getPackageName(boolean modelName)
    {
        return this.getSuperEntity().getPackageName(modelName);
    }

    /**
     * Returns the package as a path, the returned value always starts with out a slash '/'.
     * @see ModelElementFacade#getPackagePath()
     */
    public String getPackagePath()
    {
        return this.getSuperEntity().getPackagePath();
    }

    /**
     * UML2: Returns the value of the 'Qualified Name' attribute. A name which allows the
     * NamedElement to be identified within a hierarchy of nested Namespaces. It is constructed from
     * the names of the containing namespaces starting at the root of the hierarchy and ending with
     * the name of the NamedElement itself.
     * @see ModelElementFacade#getQualifiedName()
     */
    public String getQualifiedName()
    {
        return this.getSuperEntity().getQualifiedName();
    }

    /**
     * Gets the root package for the model element.
     * @see ModelElementFacade#getRootPackage()
     */
    public PackageFacade getRootPackage()
    {
        return this.getSuperEntity().getRootPackage();
    }

    /**
     * Gets the dependencies for which this model element is the source.
     * @see ModelElementFacade#getSourceDependencies()
     */
    public Collection<DependencyFacade> getSourceDependencies()
    {
        return this.getSuperEntity().getSourceDependencies();
    }

    /**
     * If this model element is the context of an activity graph, this represents that activity
     * graph.
     * @see ModelElementFacade#getStateMachineContext()
     */
    public StateMachineFacade getStateMachineContext()
    {
        return this.getSuperEntity().getStateMachineContext();
    }

    /**
     * The collection of ALL stereotype names for this model element.
     * @see ModelElementFacade#getStereotypeNames()
     */
    public Collection<String> getStereotypeNames()
    {
        return this.getSuperEntity().getStereotypeNames();
    }

    /**
     * Gets all stereotypes for this model element.
     * @see ModelElementFacade#getStereotypes()
     */
    public Collection<StereotypeFacade> getStereotypes()
    {
        return this.getSuperEntity().getStereotypes();
    }

    /**
     * Return the TaggedValues associated with this model element, under all stereotypes.
     * @see ModelElementFacade#getTaggedValues()
     */
    public Collection<TaggedValueFacade> getTaggedValues()
    {
        return this.getSuperEntity().getTaggedValues();
    }

    /**
     * Gets the dependencies for which this model element is the target.
     * @see ModelElementFacade#getTargetDependencies()
     */
    public Collection<DependencyFacade> getTargetDependencies()
    {
        return this.getSuperEntity().getTargetDependencies();
    }

    /**
     * Get the template parameters for this model element.
     * @see ModelElementFacade#getTemplateParameter(String parameterName)
     */
    public Object getTemplateParameter(String parameterName)
    {
        return this.getSuperEntity().getTemplateParameter(parameterName);
    }

    /**
     * Get the template parameter for this model element having the parameterName.
     * @see ModelElementFacade#getTemplateParameters()
     */
    public Collection<TemplateParameterFacade> getTemplateParameters()
    {
        return this.getSuperEntity().getTemplateParameters();
    }

    /**
     * The visibility (i.e. public, private, protected or package) of the model element, will
     * attempt a lookup for these values in the language mappings (if any).
     * @see ModelElementFacade#getVisibility()
     */
    public String getVisibility()
    {
        return this.getSuperEntity().getVisibility();
    }

    /**
     * Returns true if the model element has the exact stereotype (meaning no stereotype inheritance
     * is taken into account when searching for the stereotype), false otherwise.
     * @see ModelElementFacade#hasExactStereotype(String stereotypeName)
     */
    public boolean hasExactStereotype(String stereotypeName)
    {
        return this.getSuperEntity().hasExactStereotype(stereotypeName);
    }

    /**
     * Does the UML Element contain the named Keyword? Keywords can be separated by space, comma,
     * pipe, semicolon, or << >>
     * @see ModelElementFacade#hasKeyword(String keywordName)
     */
    public boolean hasKeyword(String keywordName)
    {
        return this.getSuperEntity().hasKeyword(keywordName);
    }

    /**
     * Returns true if the model element has the specified stereotype.  If the stereotype itself
     * does not match, then a search will be made up the stereotype inheritance hierarchy, and if
     * one of the stereotype's ancestors has a matching name this method will return true, false
     * otherwise.
     * For example, if we have a certain stereotype called <<exception>> and a model element has a
     * stereotype called <<applicationException>> which extends <<exception>>, when calling this
     * method with 'stereotypeName' defined as 'exception' the method would return true since
     * <<applicationException>> inherits from <<exception>>.  If you want to check if the model
     * element has the exact stereotype, then use the method 'hasExactStereotype' instead.
     * @see ModelElementFacade#hasStereotype(String stereotypeName)
     */
    public boolean hasStereotype(String stereotypeName)
    {
        return this.getSuperEntity().hasStereotype(stereotypeName);
    }

    /**
     * True if there are target dependencies from this element that are instances of BindingFacade.
     * Deprecated in UML2: Use TemplateBinding parameters instead of dependencies.
     * @see ModelElementFacade#isBindingDependenciesPresent()
     */
    public boolean isBindingDependenciesPresent()
    {
        return this.getSuperEntity().isBindingDependenciesPresent();
    }

    /**
     * Indicates if any constraints are present on this model element.
     * @see ModelElementFacade#isConstraintsPresent()
     */
    public boolean isConstraintsPresent()
    {
        return this.getSuperEntity().isConstraintsPresent();
    }

    /**
     * Indicates if any documentation is present on this model element.
     * @see ModelElementFacade#isDocumentationPresent()
     */
    public boolean isDocumentationPresent()
    {
        return this.getSuperEntity().isDocumentationPresent();
    }

    /**
     * True if this element name is a reserved word in Java, C#, ANSI or ISO C, C++, JavaScript.
     * @see ModelElementFacade#isReservedWord()
     */
    public boolean isReservedWord()
    {
        return this.getSuperEntity().isReservedWord();
    }

    /**
     * True is there are template parameters on this model element. For UML2, applies to Class,
     * Operation, Property, and Parameter.
     * @see ModelElementFacade#isTemplateParametersPresent()
     */
    public boolean isTemplateParametersPresent()
    {
        return this.getSuperEntity().isTemplateParametersPresent();
    }

    /**
     * True if this element name is a valid identifier name in Java, C#, ANSI or ISO C, C++,
     * JavaScript. Contains no spaces, special characters etc. Constraint always applied on
     * Enumerations and Interfaces, optionally applies on other model elements.
     * @see ModelElementFacade#isValidIdentifierName()
     */
    public boolean isValidIdentifierName()
    {
        return this.getSuperEntity().isValidIdentifierName();
    }

    /**
     * Searches for the constraint with the specified 'name' on this model element, and if found
     * translates it using the specified 'translation' from a translation library discovered by the
     * framework.
     * @see ModelElementFacade#translateConstraint(String name, String translation)
     */
    public String translateConstraint(String name, String translation)
    {
        return this.getSuperEntity().translateConstraint(name, translation);
    }

    /**
     * Translates all constraints belonging to this model element with the given 'translation'.
     * @see ModelElementFacade#translateConstraints(String translation)
     */
    public String[] translateConstraints(String translation)
    {
        return this.getSuperEntity().translateConstraints(translation);
    }

    /**
     * Translates the constraints of the specified 'kind' belonging to this model element.
     * @see ModelElementFacade#translateConstraints(String kind, String translation)
     */
    public String[] translateConstraints(String kind, String translation)
    {
        return this.getSuperEntity().translateConstraints(kind, translation);
    }

    /**
     * @see MetafacadeBase#initialize()
     */
    @Override
    public void initialize()
    {
        this.getSuperEntity().initialize();
    }

    /**
     * @return Object getSuperEntity().getValidationOwner()
     * @see MetafacadeBase#getValidationOwner()
     */
    @Override
    public Object getValidationOwner()
    {
        Object owner = this.getSuperEntity().getValidationOwner();
        return owner;
    }

    /**
     * @return String getSuperEntity().getValidationName()
     * @see MetafacadeBase#getValidationName()
     */
    @Override
    public String getValidationName()
    {
        String name = this.getSuperEntity().getValidationName();
        return name;
    }

    /**
     * <p><b>Constraint:</b> org::andromda::cartridges::ejb3::metafacades::EJB3EntityFacade::entities can only generalize other entities or mapped superclasses</p>
     * <p><b>Error:</b> Entities can only generalize other entities or mapped superclasses.</p>
     * <p><b>OCL:</b> context EJB3EntityFacade
inv: generalization -> notEmpty()
implies (generalization.oclIsKindOf(EJB3EntityFacade) or generalization.oclIsKindOf(EJB3MappedSuperclassFacade))</p>
     * <p><b>Constraint:</b> org::andromda::cartridges::ejb3::metafacades::EJB3EntityFacade::entity must have at least one identifier</p>
     * <p><b>Error:</b> TODO: Model Documentation for org.andromda.cartridges.ejb3.metafacades.constraints.entity must have at least one identifier</p>
     * <p><b>OCL:</b> context EJB3EntityFacade
inv: identifiersPresent</p>
     * @param validationMessages Collection<ModelValidationMessage>
     * @see MetafacadeBase#validateInvariants(Collection validationMessages)
     */
    @Override
    public void validateInvariants(Collection<ModelValidationMessage> validationMessages)
    {
        this.getSuperEntity().validateInvariants(validationMessages);
        try
        {
            final Object contextElement = this.THIS();
            boolean constraintValid = OCLResultEnsurer.ensure((Boolean.valueOf(String.valueOf(OCLCollections.notEmpty(OCLIntrospector.invoke(contextElement,"generalization")))).booleanValue()?(OCLIntrospector.invoke(contextElement,"generalization") instanceof EJB3EntityFacade||OCLIntrospector.invoke(contextElement,"generalization") instanceof EJB3MappedSuperclassFacade):true));
            if (!constraintValid)
            {
                validationMessages.add(
                    new ModelValidationMessage(
                        (MetafacadeBase)contextElement ,
                        "org::andromda::cartridges::ejb3::metafacades::EJB3EntityFacade::entities can only generalize other entities or mapped superclasses",
                        "Entities can only generalize other entities or mapped superclasses."));
            }
        }
        catch (Throwable th)
        {
            Throwable cause = th.getCause();
            int depth = 0; // Some throwables have infinite recursion
            while (cause != null && depth < 7)
            {
                th = cause;
                depth++;
            }
            logger.error("Error validating constraint 'org::andromda::cartridges::ejb3::metafacades::EJB3EntityFacade::entities can only generalize other entities or mapped superclasses' ON "
                + this.THIS().toString() + ": " + th.getMessage(), th);
        }
        try
        {
            final Object contextElement = this.THIS();
            boolean constraintValid = OCLResultEnsurer.ensure(OCLIntrospector.invoke(contextElement,"identifiersPresent"));
            if (!constraintValid)
            {
                validationMessages.add(
                    new ModelValidationMessage(
                        (MetafacadeBase)contextElement ,
                        "org::andromda::cartridges::ejb3::metafacades::EJB3EntityFacade::entity must have at least one identifier",
                        "TODO: Model Documentation for org.andromda.cartridges.ejb3.metafacades.constraints.entity must have at least one identifier"));
            }
        }
        catch (Throwable th)
        {
            Throwable cause = th.getCause();
            int depth = 0; // Some throwables have infinite recursion
            while (cause != null && depth < 7)
            {
                th = cause;
                depth++;
            }
            logger.error("Error validating constraint 'org::andromda::cartridges::ejb3::metafacades::EJB3EntityFacade::entity must have at least one identifier' ON "
                + this.THIS().toString() + ": " + th.getMessage(), th);
        }
    }

    /**
     * The property that stores the name of the metafacade.
     */
    private static final String NAME_PROPERTY = "name";
    private static final String FQNAME_PROPERTY = "fullyQualifiedName";

    /**
     * @see Object#toString()
     */
    @Override
    public String toString()
    {
        final StringBuilder toString = new StringBuilder(this.getClass().getName());
        toString.append("[");
        try
        {
            toString.append(Introspector.instance().getProperty(this, FQNAME_PROPERTY));
        }
        catch (final Throwable tryAgain)
        {
            try
            {
                toString.append(Introspector.instance().getProperty(this, NAME_PROPERTY));
            }
            catch (final Throwable ignore)
            {
                // - just ignore when the metafacade doesn't have a name or fullyQualifiedName property
            }
        }
        toString.append("]");
        return toString.toString();
    }
}
