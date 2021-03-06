// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SpringDao.vsl in andromda-spring-cartridge.
//
package org.andromda.timetracker.domain;

import java.util.Collection;
import java.util.Set;
import org.andromda.spring.PaginationResult;
import org.andromda.timetracker.Search;
import org.andromda.timetracker.vo.TimeAllocationVO;

/**
 * TimeAllocation represents a time period for which the timecard submitter worked on the associated
 * task.
 * @see TimeAllocation
 */
public interface TimeAllocationDao
{
    /**
     * This constant is used as a transformation flag; entities can be converted automatically into value objects
     * or other types, different methods in a class implementing this interface support this feature: look for
     * an <code>int</code> parameter called <code>transform</code>.
     * <p>
     * This specific flag denotes no transformation will occur.
     */
    public static final int TRANSFORM_NONE = 0;


    /**
     * Transforms the given results to a collection of {@link TimeAllocation}
     * instances (this is useful when the returned results contains a row of data and you want just entities only).
     *
     * @param results the query results.
     */
    public void toEntities(final Collection<?> results);

    /**
     * This constant is used as a transformation flag; entities can be converted automatically into value objects
     * or other types, different methods in a class implementing this interface support this feature: look for
     * an <code>int</code> parameter called <code>transform</code>.
     * <p>
     * This specific flag denotes entities must be transformed into objects of type
     * {@link TimeAllocationVO}.
     */
    public static final int TRANSFORM_TIMEALLOCATIONVO = 1;

    /**
     * Copies the fields of the specified entity to the target value object. This method is similar to
     * toTimeAllocationVO(), but it does not handle any attributes in the target
     * value object that are "read-only" (as those do not have setter methods exposed).
     * @param source
     * @param target
     */
    public void toTimeAllocationVO(
        TimeAllocation source,
        TimeAllocationVO target);

    /**
     * Converts this DAO's entity to an object of type {@link TimeAllocationVO}.
     * @param entity
     * @return TimeAllocationVO
     */
    public TimeAllocationVO toTimeAllocationVO(TimeAllocation entity);

    /**
     * Converts this DAO's entity to a Collection of instances of type {@link TimeAllocationVO}.
     * @param entities
     * @return Collection<TimeAllocationVO>
     */
    public Collection<TimeAllocationVO> toTimeAllocationVOCollection(Collection<?> entities);

    /**
     * Converts this DAO's entity to an array of instances of type {@link TimeAllocationVO}.
     * @param entities
     * @return TimeAllocationVO[]
     */
    public TimeAllocationVO[] toTimeAllocationVOArray(Collection<?> entities);

    /**
     * Copies the fields of {@link TimeAllocationVO} to the specified entity.
     * @param source
     * @param target
     * @param copyIfNull If FALSE, the value object's field will not be copied to the entity if the value is NULL. If TRUE,
     * it will be copied regardless of its value.
     */
    public void timeAllocationVOToEntity(
        TimeAllocationVO source,
        TimeAllocation target,
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
    public void timeAllocationVOToEntityCollection(Collection<?> instances);

    /**
     * Gets an instance of TimeAllocation from the persistent store.
     * @param id
     * @return TimeAllocation
     */
    public TimeAllocation get(Long id);

    /**
     * <p>
     * Does the same thing as {@link #get(Long)} with an
     * additional flag called <code>transform</code>. If this flag is set to <code>TRANSFORM_NONE</code> then
     * the returned entity will <strong>NOT</strong> be transformed. If this flag is any of the other constants
     * defined in this class then the result <strong>WILL BE</strong> passed through an operation which can
     * optionally transform the entity (into a value object for example). By default, transformation does
     * not occur.
     * </p>
     *
     * @param transform flag to determine transformation type.
     * @param id the identifier of the entity to get.
     * @return either the entity or the object transformed from the entity.
     */
    public Object get(int transform, Long id);

    /**
     * Loads an instance of TimeAllocation from the persistent store.
     * @param id
     * @return TimeAllocation
     */
    public TimeAllocation load(Long id);

    /**
     * <p>
     * Does the same thing as {@link #load(Long)} with an
     * additional flag called <code>transform</code>. If this flag is set to <code>TRANSFORM_NONE</code> then
     * the returned entity will <strong>NOT</strong> be transformed. If this flag is any of the other constants
     * defined in this class then the result <strong>WILL BE</strong> passed through an operation which can
     * optionally transform the entity (into a value object for example). By default, transformation does
     * not occur.
     * </p>
     *
     * @param transform flag to determine transformation type.
     * @param id the identifier of the entity to load.
     * @return either the entity or the object transformed from the entity.
     */
    public Object load(int transform, Long id);

    /**
     * Loads all entities of type {@link TimeAllocation}.
     *
     * @return the loaded entities.
     */
    public Collection<TimeAllocation> loadAll();

    /**
     * <p>
     * Does the same thing as {@link #loadAll()} with an
     * additional flag called <code>transform</code>. If this flag is set to <code>TRANSFORM_NONE</code> then
     * the returned entity will <strong>NOT</strong> be transformed. If this flag is any of the other constants
     * defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     * transform the entity (into a value object for example). By default, transformation does
     * not occur.
     * </p>
     *
     * @param transform the flag indicating what transformation to use.
     * @return the loaded entities.
     */
    public Collection<?> loadAll(final int transform);

    /**
     * <p>
     * Does the same thing as {@link #loadAll()} with an
     * additional two arguments called <code>pageNumber</code> and <code>pageSize</code>. The <code>pageNumber</code>
     * argument allows you to specify the page number when you are paging the results and the pageSize allows you to specify the size of the
     * page retrieved.
     * </p>
     *
     * @param pageNumber the page number to retrieve when paging results.
     * @param pageSize the size of the page to retrieve when paging results.
     * @return the loaded entities.
     */
    public Collection<?> loadAll(final int pageNumber, final int pageSize);

    /**
     * <p>
     * Does the same thing as {@link #loadAll(int)} with an
     * additional two arguments called <code>pageNumber</code> and <code>pageSize</code>. The <code>pageNumber</code>
     * argument allows you to specify the page number when you are paging the results and the pageSize allows you to specify the size of the
     * page retrieved.
     * </p>
     *
     * @param transform the flag indicating what transformation to use.
     * @param pageNumber the page number to retrieve when paging results.
     * @param pageSize the size of the page to retrieve when paging results.
     * @return the loaded entities.
     */
    public Collection<?> loadAll(final int transform, final int pageNumber, final int pageSize);

    /**
     * Creates an instance of TimeAllocation and adds it to the persistent store.
     * @param timeAllocation
     * @return TimeAllocation
     */
    public TimeAllocation create(TimeAllocation timeAllocation);

    /**
     * <p>
     * Does the same thing as {@link #create(TimeAllocation)} with an
     * additional flag called <code>transform</code>. If this flag is set to <code>TRANSFORM_NONE</code> then
     * the returned entity will <strong>NOT</strong> be transformed. If this flag is any of the other constants
     * defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     * transform the entity (into a value object for example). By default, transformation does
     * not occur.
     * </p>
     * @param transform
     * @param timeAllocation
     * @return Object
     */
    public Object create(int transform, TimeAllocation timeAllocation);

    /**
     * Creates a new instance of TimeAllocation and adds
     * from the passed in <code>entities</code> collection
     *
     * @param entities the collection of TimeAllocation
     * instances to create.
     *
     * @return the created instances.
     */
    public Collection<TimeAllocation> create(Collection<TimeAllocation> entities);

    /**
     * <p>
     * Does the same thing as {@link #create(TimeAllocation)} with an
     * additional flag called <code>transform</code>. If this flag is set to <code>TRANSFORM_NONE</code> then
     * the returned entity will <strong>NOT</strong> be transformed. If this flag is any of the other constants
     * defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     * transform the entities (into value objects for example). By default, transformation does
     * not occur.
     * </p>
     * @param transform
     * @param entities
     * @return Collection
     */
    public Collection<?> create(int transform, Collection<TimeAllocation> entities);

    /**
     * <p>
     * Creates a new <code>TimeAllocation</code>
     * instance from <strong>all</strong> attributes and adds it to
     * the persistent store.
     * </p>
     * @param timePeriod TODO: Model Documentation for TimeAllocation.timePeriod
     * @return TimeAllocation
     */
    public TimeAllocation create(
        TimePeriod timePeriod);

    /**
     * <p>
     * Does the same thing as {@link #create(TimePeriod)} with an
     * additional flag called <code>transform</code>. If this flag is set to <code>TRANSFORM_NONE</code> then
     * the returned entity will <strong>NOT</strong> be transformed. If this flag is any of the other constants
     * defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     * transform the entity (into a value object for example). By default, transformation does
     * not occur.
     * </p>
     * @param transform
     * @param timePeriod TODO: Model Documentation for TimeAllocation.timePeriod
     * @return TimeAllocation
     */
    public Object create(
        int transform,
        TimePeriod timePeriod);

    /**
     * <p>
     * Creates a new <code>TimeAllocation</code>
     * instance from only <strong>required</strong> properties (attributes
     * and association ends) and adds it to the persistent store.
     * </p>
     * @param task
     * @param timecard
     * @param timePeriod
     * @return TimeAllocation
     */
    public TimeAllocation create(
        Task task,
        Timecard timecard,
        TimePeriod timePeriod);

    /**
     * <p>
     * Does the same thing as {@link #create(TimePeriod)} with an
     * additional flag called <code>transform</code>. If this flag is set to <code>TRANSFORM_NONE</code> then
     * the returned entity will <strong>NOT</strong> be transformed. If this flag is any of the other constants
     * defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     * transform the entity (into a value object for example). By default, transformation does
     * not occur.
     * </p>
     * @param transform flag to determine transformation type.
     * @param task
     * @param timecard
     * @param timePeriod
     * @return Object
     */
    public Object create(
        int transform,
        Task task,
        Timecard timecard,
        TimePeriod timePeriod);

    /**
     * Updates the <code>timeAllocation</code> instance in the persistent store.
     * @param timeAllocation
     */
    public void update(TimeAllocation timeAllocation);

    /**
     * Updates all instances in the <code>entities</code> collection in the persistent store.
     * @param entities
     */
    public void update(Collection<TimeAllocation> entities);

    /**
     * Removes the instance of TimeAllocation from the persistent store.
     * @param timeAllocation
     */
    public void remove(TimeAllocation timeAllocation);

    /**
     * Removes the instance of TimeAllocation having the given
     * <code>identifier</code> from the persistent store.
     * @param id
     */
    public void remove(Long id);

    /**
     * Removes all entities in the given <code>entities</code> collection.
     * @param entities
     */
    public void remove(Collection<TimeAllocation> entities);


    /**
     * Does the same thing as {@link #search(int, Search)} but with an
     * additional two flags called <code>pageNumber</code> and <code>pageSize</code>. These flags allow you to
     * limit your data to a specified page number and size.
     *
     * @param transform the transformation flag.
     * @param pageNumber the page number in the data to retrieve
     * @param pageSize the size of the page to retrieve.
     * @param search the search object which provides the search parameters and pagination specification.
     * @return any found results from the search wrapped in a {@link PaginationResult} instance.
     */
    public PaginationResult search(final int transform, final int pageNumber, final int pageSize, final Search search);

    /**
     * Does the same thing as {@link #search(Search)} but with an
     * additional two flags called <code>pageNumber</code> and <code>pageSize</code>. These flags allow you to
     * limit your data to a specified page number and size.
     *
     * @param pageNumber the page number in the data to retrieve
     * @param pageSize the size of the page to retrieve.
     * @param search the search object which provides the search parameters and pagination specification.
     * @return any found results from the search wrapped in a {@link PaginationResult} instance.
     */
    public PaginationResult search(final int pageNumber, final int pageSize, final Search search);

    /**
     * Does the same thing as {@link #search(Search)} but with an
     * additional flag called <code>transform</code>. If this flag is set to <code>TRANSFORM_NONE</code> then
     * finder results will <strong>NOT</strong> be transformed during retrieval.
     * If this flag is any of the other constants defined here
     * then results <strong>WILL BE</strong> passed through an operation which can optionally
     * transform the entities (into value objects for example). By default, transformation does
     * not occur.
     *
     * @param transform the transformation flag.
     * @param search the search object which provides the search parameters and pagination specification.
     * @return any found results from the search.
     */
    public Set<?> search(final int transform, final Search search);

    /**
     * Performs a search using the parameters specified in the given <code>search</code> object.
     *
     * @param search the search object which provides the search parameters and pagination specification.
     * @return any found results from the search.
     */
    public Set<TimeAllocation> search(final Search search);

    /**
     * Allows transformation of entities into value objects
     * (or something else for that matter), when the <code>transform</code>
     * flag is set to one of the constants defined in <code>org.andromda.timetracker.domain.TimeAllocationDao</code>, please note
     * that the {@link #TRANSFORM_NONE} constant denotes no transformation, so the entity itself
     * will be returned.
     * <p>
     * This method will return instances of these types:
     * <ul>
     *   <li>{@link TimeAllocation} - {@link #TRANSFORM_NONE}</li>
     *   <li>{@link TimeAllocationVO} - {@link #TRANSFORM_TIMEALLOCATIONVO}</li>
     * </ul>
     *
     * If the integer argument value is unknown {@link #TRANSFORM_NONE} is assumed.
     *
     * @param transform one of the constants declared in {@link org.andromda.timetracker.domain.TimeAllocationDao}
     * @param entity an entity that was found
     * @return the transformed entity (i.e. new value object, etc)
     * @see #transformEntities(int,Collection)
     */
    public Object transformEntity(final int transform, final TimeAllocation entity);

    /**
     * Transforms a collection of entities using the
     * {@link #transformEntity(int,TimeAllocation)}
     * method. This method does not instantiate a new collection.
     * <p>
     * This method is to be used internally only.
     *
     * @param transform one of the constants declared in <code>org.andromda.timetracker.domain.TimeAllocationDao</code>
     * @param entities the collection of entities to transform
     * @see #transformEntity(int,TimeAllocation)
     */
    public void transformEntities(final int transform, final Collection<?> entities);

    /**
     * Searches for a single instance of TimeAllocation.
     * @param timePeriod the unique timePeriod to be used in the search.'
     * @return a single instance of TimeAllocation.
     */
    public TimeAllocation searchUniqueTimePeriod(final TimePeriod timePeriod);

    /**
     * Searches for a single instance of TimeAllocation.
     * @param transform the transformation flag.
     * @param timePeriod the unique timePeriod to be used in the search.
     * @return a value object according the transformation flag.
     */
    public Object searchUniqueTimePeriod(final int transform, final TimePeriod timePeriod);

    // spring-dao merge-point
}
