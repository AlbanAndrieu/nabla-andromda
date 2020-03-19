// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: hibernate/HibernateSearchProperties.vsl in andromda-spring-cartridge.
//
package org.andromda.timetracker;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.andromda.timetracker.domain.MovieImpl;
import org.andromda.timetracker.domain.TaskImpl;
import org.andromda.timetracker.domain.TimeAllocationImpl;
import org.andromda.timetracker.domain.TimePeriodImpl;
import org.andromda.timetracker.domain.TimecardImpl;
import org.andromda.timetracker.domain.UserImpl;
import org.andromda.timetracker.domain.UserRoleImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

/**
 * Stores the embedded values and associations of all entities in the system by type.
 * Is used to determine the appropriate parameter name when an embedded value's property
 * is referenced as the attribute to search by (as opposed to an association).
 *
 * @author Chad Brandon
 */
@SuppressWarnings({"unchecked"})
public class CriteriaSearchProperties
{
    private static final Map embeddedValuesByType = new HashMap();
    private static final Map embeddedValueNamesByType = new HashMap();
    private static final Map navigableAssociationEndsByType = new HashMap();

    static
    {
        initializeUser1();
        initializeTask2();
        initializeTimeAllocation3();
        initializeTimecard4();
        initializeUserRole5();
        initializeMovie6();
    }

    private static final void initializeUser1()
    {
        embeddedValueNamesByType.put(
            UserImpl.class,
            null);
        embeddedValuesByType.put(
            UserImpl.class,
            null);
        navigableAssociationEndsByType.put(
            UserImpl.class,
            Arrays.asList(
                new PropertyType[]
                {
                    new PropertyType("roles", UserRoleImpl.class)
                }
            )
        );
    }

    private static final void initializeTask2()
    {
        embeddedValueNamesByType.put(
            TaskImpl.class,
            null);
        embeddedValuesByType.put(
            TaskImpl.class,
            null);
        navigableAssociationEndsByType.put(
            TaskImpl.class,
            null);
    }

    private static final void initializeTimeAllocation3()
    {
        embeddedValueNamesByType.put(
            TimeAllocationImpl.class,
            Arrays.asList(new String[] {"timePeriod"}));
        embeddedValuesByType.put(
            TimeAllocationImpl.class,
            Arrays.asList(
                new PropertyType[]
                {
                    // EmbeddedValue type=org.andromda.timetracker.domain.TimePeriod
                    new PropertyType("timePeriod", TimePeriodImpl.class)
                }
            )
        );
        navigableAssociationEndsByType.put(
            TimeAllocationImpl.class,
            Arrays.asList(
                new PropertyType[]
                {
                    new PropertyType("task", TaskImpl.class),
                    new PropertyType("timecard", TimecardImpl.class)
                }
            )
        );
    }

    private static final void initializeTimecard4()
    {
        embeddedValueNamesByType.put(
            TimecardImpl.class,
            null);
        embeddedValuesByType.put(
            TimecardImpl.class,
            null);
        navigableAssociationEndsByType.put(
            TimecardImpl.class,
            Arrays.asList(
                new PropertyType[]
                {
                    new PropertyType("approver", UserImpl.class),
                    new PropertyType("submitter", UserImpl.class),
                    new PropertyType("allocations", TimeAllocationImpl.class)
                }
            )
        );
    }

    private static final void initializeUserRole5()
    {
        embeddedValueNamesByType.put(
            UserRoleImpl.class,
            null);
        embeddedValuesByType.put(
            UserRoleImpl.class,
            null);
        navigableAssociationEndsByType.put(
            UserRoleImpl.class,
            Arrays.asList(
                new PropertyType[]
                {
                    new PropertyType("groups", UserRoleImpl.class)
                }
            )
        );
    }

    private static final void initializeMovie6()
    {
        embeddedValueNamesByType.put(
            MovieImpl.class,
            null);
        embeddedValuesByType.put(
            MovieImpl.class,
            null);
        navigableAssociationEndsByType.put(
            MovieImpl.class,
            null);
    }

    /**
     * Attempts to get the embedded value list for the given type (or returns null
     * if one doesn't exist).
     *
     * @param type the type of which to retrieve the value.
     * @return the collection of embedded value names.
     */
    public static Collection getEmbeddedValues(final Class type)
    {
        return (Collection)embeddedValueNamesByType.get(type);
    }

    /**
     * Gets the type of the navigable association end given the <code>ownerType</code>
     * and <code>name</code>
     *
     * @param ownerType the owner of the association.
     * @param name the name of the association end to find.
     * @return the type of the association end.
     */
    public static Class getNavigableAssociationEndType(final Class ownerType, final String name)
    {
        return getPropertyType(navigableAssociationEndsByType, ownerType, name);
    }

    /**
     * Gets the type of the embedded value given the <code>ownerType</code>
     * and <code>name</code>
     *
     * @param ownerType the owner of the association.
     * @param name the name of the association end to find.
     * @return the type of the association end.
     */
    public static Class getEmbeddedValueType(final Class ownerType, final String name)
    {
        return getPropertyType(embeddedValuesByType, ownerType, name);
    }

    /**
     * Gets the type of the embedded value given the <code>ownerType</code>
     * and <code>name</code>
     *
     * @param properties Map contains the Collection of properties given the ownerType Class
     * @param ownerType the owner of the association.
     * @param name the name of the association end to find.
     * @return the type of the association end.
     */
    public static Class getPropertyType(final Map properties, final Class ownerType, final String name)
    {
        final Collection ends = (Collection)properties.get(ownerType);
        final PropertyType type = (PropertyType)CollectionUtils.find(
            ends,
            new Predicate()
            {
                public boolean evaluate(final Object object)
                {
                    return ((PropertyType)object).name.equals(name);
                }
            });
        return type != null ? type.type : null;
    }

    /**
     * Gets the type of the property given the <code>ownerType</code>
     * and <code>name</code>
     *
     * @param ownerType the owner of the association.
     * @param name the name of the association end to find.
     * @return the type of the association end.
     */
    public static Class getPropertyType(final Class ownerType, final String name)
    {
        Class type = getNavigableAssociationEndType(ownerType, name);
        if (type == null)
        {
            type = getEmbeddedValueType(ownerType, name);
        }
        return type;
    }

    /**
     * A private class storing the name and type.
     */
    protected static final class PropertyType
    {
        /**
         * @param nameIn
         * @param typeIn
         */
        protected PropertyType(final String nameIn, final Class typeIn)
        {
            this.name = nameIn;
            this.type = typeIn;
        }

        /** PropertyType name */
        protected String name;
        /** PropertyType type Class */
        protected Class type;
    }
}
