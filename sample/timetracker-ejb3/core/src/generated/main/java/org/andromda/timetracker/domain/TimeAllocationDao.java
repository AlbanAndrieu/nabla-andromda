// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by DaoLocal.vsl overrided in andromda-ejb3-cartridge.
//
package org.andromda.timetracker.domain;

import java.util.Collection;
import org.andromda.timetracker.vo.TimeAllocationVO;

/**
 * @see TimeAllocation
 */
public interface TimeAllocationDao
{
    /**
     * This constant is used as a transformation flag; entities can be converted automatically into value objects
     * or other types, different methods in a class implementing this interface support this feature: look for
     * an <code>int</code> parameter called <code>transform</code>.
     * <p/>
     * This specific flag denotes no transformation will occur.
     */
    public static final int TRANSFORM_NONE = 0;

    /**
     * This constant is used as a transformation flag; entities can be converted automatically into value objects
     * or other types, different methods in a class implementing this interface support this feature: look for
     * an <code>int</code> parameter called <code>transform</code>.
     * <p/>
     * This specific flag denotes entities must be transformed into objects of type
     * {@link TimeAllocationVO}.
     */
    public static final int TRANSFORM_TIMEALLOCATIONVO = 1;

    /**
     * Copies the fields of the specified entity to the target value object.  This method is similar to
     * toTimeAllocationVO(), but it does not handle any attributes in the target
     * value object that are "read-only" (as those do not have setter methods exposed).
     * @param sourceEntity
     * @param targetVO
     */
    public void toTimeAllocationVO(
        TimeAllocation sourceEntity,
        TimeAllocationVO targetVO);

    /**
     * Converts this DAO's entity to an object of type {@link TimeAllocationVO}.
     * @param entity
     * @return TimeAllocationVO
     */
    public TimeAllocationVO toTimeAllocationVO(TimeAllocation entity);

    /**
     * Converts this DAO's entity to a Collection of instances of type {@link TimeAllocationVO}.
     * @param entities
     */
    public void toTimeAllocationVOCollection(Collection entities);

    /**
     * Copies the fields of {@link TimeAllocationVO} to the specified entity.
     * @param sourceVO
     * @param targetEntity
     * @param copyIfNull If FALSE, the value object's field will not be copied to the entity if the value is NULL. If TRUE,
     *        it will be copied regardless of its value.
     */
    public void timeAllocationVOToEntity(
        TimeAllocationVO sourceVO,
        TimeAllocation targetEntity,
        boolean copyIfNull);

    /**
     * Converts an instance of type {@link TimeAllocationVO} to this DAO's entity.
     * @param timeAllocationVO
     * @return TimeAllocation
     */
    public TimeAllocation timeAllocationVOToEntity(TimeAllocationVO timeAllocationVO);

    /**
     * Converts a Collection of instances of type {@link TimeAllocationVO} to this
     * DAO's entity.
     * @param instances
     */
    public void timeAllocationVOToEntityCollection(Collection instances);

    /**
     * Loads an instance of TimeAllocation from the persistent store.
     * @param id the identifier of the entity to load.
     * @throws TimeAllocationDaoException
     */
    public TimeAllocation load(Long id)
        throws TimeAllocationDaoException;

    /**
     *   Does the same thing as {@link #load(Long)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined in this class then the result <strong>WILL BE</strong> passed through an operation which can
     *   optionally transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     *
     * @param id the identifier of the entity to load.
     * @return either the entity or the object transformed from the entity.
     * @throws TimeAllocationDaoException
     */
    public Object load(int transform, Long id)
        throws TimeAllocationDaoException;

    /**
     * Loads all entities of type {@link TimeAllocation}.
     *
     * @return the loaded entities.
     * @throws TimeAllocationDaoException
     */
    public Collection<TimeAllocation> loadAll()
        throws TimeAllocationDaoException;

    /**
     *   Does the same thing as {@link #loadAll()} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     *
     * @param transform the flag indicating what transformation to use.
     * @return Collection of the loaded entities.
     * @throws TimeAllocationDaoException
     */
    public Collection loadAll(final int transform)
        throws TimeAllocationDaoException;

    /**
     * Creates an instance of TimeAllocation and adds it to the persistent store.
     * @param timeAllocation
     * @return TimeAllocation
     * @throws TimeAllocationDaoException
     */
    public TimeAllocation create(TimeAllocation timeAllocation)
        throws TimeAllocationDaoException;

    /**
     *   Does the same thing as {@link #create(TimeAllocation)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     *
     * @param transform
     * @param timeAllocation
     * @return Object
     * @throws TimeAllocationDaoException
     */
    public Object create(int transform, TimeAllocation timeAllocation)
        throws TimeAllocationDaoException;

    /**
     * Creates a new instance of TimeAllocation and adds
     * from the passed in <code>entities</code> collection
     *
     * @param entities the collection of TimeAllocation
     *        instances to create.
     * @return the created instances. Collection<TimeAllocation>
     * @throws TimeAllocationDaoException
     */
    public Collection<TimeAllocation> create(Collection<TimeAllocation> entities)
        throws TimeAllocationDaoException;

    /**
     *   Does the same thing as {@link #create(TimeAllocation)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entities (into value objects for example).  By default, transformation does
     *   not occur.
     *
     * @param transform
     * @param entities
     * @return the created instances. Collection
     * @throws TimeAllocationDaoException
     */
    public Collection create(int transform, Collection<TimeAllocation> entities)
        throws TimeAllocationDaoException;

    /**
     *   Creates a new <code>TimeAllocation</code>
     *   instance from <strong>all</strong> attributes and adds it to
     *   the persistent store.
     * @param timePeriod
     * @return the created instances. TimeAllocation
     * @throws TimeAllocationDaoException
     */
    public TimeAllocation create(
        TimePeriod timePeriod)
        throws TimeAllocationDaoException;

    /**
     *   Does the same thing as {@link #create(TimePeriod)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     *
     * @param transform
     * @param timePeriod
     * @return the created instances. Object
     * @throws TimeAllocationDaoException
     */
    public Object create(
        int transform,
        TimePeriod timePeriod)
        throws TimeAllocationDaoException;

    /**
     *  Creates a new <code>TimeAllocation</code>
     *  instance from only <strong>required</strong> properties (attributes
     *  and association ends) and adds it to the persistent store.
     *
     * @param task
     * @param timecard
     * @param timePeriod
     * @return the created instance. TimeAllocation
     * @throws TimeAllocationDaoException
     */
    public TimeAllocation create(
        Task task,
        Timecard timecard,
        TimePeriod timePeriod)
        throws TimeAllocationDaoException;

    /**
     *   Does the same thing as {@link #create(TimePeriod)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     *
     * @param transform
     * @param task
     * @param timecard
     * @param timePeriod
     * @return the created instance. Object
     * @throws TimeAllocationDaoException
     */
    public Object create(
        int transform,
        Task task,
        Timecard timecard,
        TimePeriod timePeriod)
        throws TimeAllocationDaoException;

    /**
     * Updates the <code>timeAllocation</code> instance in the persistent store.
     * @param timeAllocation
     * @throws TimeAllocationDaoException
     */
    public void update(TimeAllocation timeAllocation)
        throws TimeAllocationDaoException;

    /**
     * Updates all instances in the <code>entities</code> collection in the persistent store.
     * @param entities
     * @throws TimeAllocationDaoException
     */
    public void update(Collection<TimeAllocation> entities)
        throws TimeAllocationDaoException;

    /**
     * Removes the instance of TimeAllocation from the persistent store.
     * @param timeAllocation
     * @throws TimeAllocationDaoException
     */
    public void remove(TimeAllocation timeAllocation)
        throws TimeAllocationDaoException;

    /**
     * Removes the instance of TimeAllocation having the given
     * <code>identifier</code> from the persistent store.
     * @param id
     * @throws TimeAllocationDaoException
     */
    public void remove(Long id)
        throws TimeAllocationDaoException;

    /**
     * Removes all entities in the given <code>entities<code> collection.
     * @param entities
     * @throws TimeAllocationDaoException
     */
    public void remove(Collection<TimeAllocation> entities)
        throws TimeAllocationDaoException;

}