// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by DaoBase.vsl in andromda-ejb3-cartridge.
//
package org.andromda.timetracker.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.andromda.timetracker.vo.TimecardSearchCriteriaVO;
import org.andromda.timetracker.vo.TimecardSummaryVO;
import org.andromda.timetracker.vo.TimecardVO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.apache.log4j.Logger;
import org.hibernate.Session;

/**
 * <p>
 * Base EJB3 DAO Class: is able to create, update, remove, load, and find
 * objects of type <code>Timecard</code>.
 * </p>
 *
 * @see TimecardDao
 */
//@javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
//@javax.ejb.Local({TimecardDao.class})
public abstract class TimecardDaoBase implements TimecardDao
{

    private static final Logger logger = Logger.getLogger(TimecardDaoBase.class);

    /** Session Context Injection */
    @Resource
    protected SessionContext context;

    /**
     * Inject persistence context timetracker-ejb3     */
    @PersistenceContext(unitName = "timetracker-ejb3")
    protected EntityManager entityManager;

    /**
     * Inject Hibernate Session
     */
    @PersistenceContext(unitName = "timetracker-ejb3")    protected Session hibernateSession;

    // ------ DAO Injections ------

    /**
     * Inject DAO TimeAllocationDao
     */
    @EJB
    protected TimeAllocationDao timeAllocationDao;

    /**
     * Gets the reference to <code>timeAllocationDao</code>.
     * @return TimeAllocationDao
     */
    protected TimeAllocationDao getTimeAllocationDao()
    {
        return this.timeAllocationDao;
    }

    /**
     * @see TimecardDao#load
     */
    @Override
    public Object load(final int transform, final Long id) throws TimecardDaoException
    {
        if (id == null)
        {
            throw new IllegalArgumentException("Timecard.load - 'id' can not be null");
        }
        try
        {
                        final Timecard entity = this.entityManager.find(Timecard.class, id);
            return transformEntity(transform, entity);
        }
        catch (Exception ex)
        {
            throw new TimecardDaoException(ex);
        }
    }

    /**
     * @see TimecardDao#load( Long)
     */
    @Override
        public Timecard load( final Long id) throws TimecardDaoException
    {
        return (Timecard)this.load(TRANSFORM_NONE, id);
    }

    /**
     * @see TimecardDao#loadAll()
     */
    @Override
    @SuppressWarnings({"unchecked"})
    public Collection<Timecard> loadAll() throws TimecardDaoException
    {
        return this.loadAll(TRANSFORM_NONE);
    }

    /**
     * @see TimecardDao#loadAll(int)
     */
    @SuppressWarnings("rawtypes")
    @Override
    public Collection loadAll(final int transform) throws TimecardDaoException
    {
        try
        {
            TypedQuery<Timecard> query = this.entityManager.createNamedQuery("Timecard.findAll", Timecard.class);

            List<Timecard> results = query.getResultList();
            this.transformEntities(transform, results);
            return results;
        }
        catch (Exception ex)
        {
            throw new TimecardDaoException(ex);
        }
    }

    /**
     * Create Timecard with no VO transformation
     * @see TimecardDao#create(Timecard)
     */
    @Override
    public Timecard create(Timecard timecard) throws TimecardDaoException
    {
        return (Timecard)this.create(TRANSFORM_NONE, timecard);
    }

    /**
     * Create Timecard with VO transformation
     * @see TimecardDao#create(int, Timecard)
     */
    @Override
    public Object create(final int transform, final Timecard timecard) throws TimecardDaoException
    {
        if (timecard == null)
        {
            throw new IllegalArgumentException("Timecard.create - 'timecard' can not be null");
        }

        try
        {
            this.entityManager.persist(timecard);
            this.entityManager.flush();
            return this.transformEntity(transform, timecard);
        }
        catch (Exception ex)
        {
            throw new TimecardDaoException(ex);
        }
    }

    /**
     * Create a Collection of Timecard with no VO transformation
     * @see TimecardDao#create(Collection)
     */
    @Override
    @SuppressWarnings({"unchecked"})
    public Collection<Timecard> create(final Collection<Timecard> entities) throws TimecardDaoException
    {
        return create(TRANSFORM_NONE, entities);
    }

    /**
     * Create a Collection of Timecard with VO transformation
     * @see TimecardDao#create(int, Collection)
     */
    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public Collection create(final int transform, final Collection<Timecard> entities) throws TimecardDaoException
    {
        if (entities == null)
        {
            throw new IllegalArgumentException("Timecard.create - 'entities' can not be null");
        }
        Collection results = new ArrayList();
        try
        {
            for (final Timecard entity : entities)
            {
                results.add(create(transform, entity));
            }
        }
        catch (Exception ex)
        {
            throw new TimecardDaoException(ex);
        }
        return results;
    }

    /**
     * Create Entity Timecard using instance attributes with no VO transformation
     * @see TimecardDao#create(String, Date, TimecardStatus)
     */
    @Override
    public Timecard create(String comments, Date startDate, TimecardStatus status) throws TimecardDaoException
    {
        return (Timecard)this.create(TRANSFORM_NONE, comments, startDate, status);
    }

    /**
     * Create Entity Timecard using instance attributes with VO transformation
     * @see TimecardDao#create(int, String, Date, TimecardStatus)
     * composite=false identifiers=1
     */
    @Override
    public Object create(final int transform, String comments, Date startDate, TimecardStatus status) throws TimecardDaoException
    {
        Timecard entity = new Timecard();
        entity.setComments(comments);
        entity.setStartDate(startDate);
        entity.setStatus(status);
        return this.create(transform, entity);
    }

    /**
     * Create Entity Timecard using required properties with no VO transformation
     * @see TimecardDao#create(String, Date, TimecardStatus, User)
     */
    @Override
    public Timecard create(String comments, Date startDate, TimecardStatus status, User submitter) throws TimecardDaoException
    {
        return (Timecard)this.create(TRANSFORM_NONE, comments, startDate, status, submitter);
    }

    /**
     * Create Entity Timecard using required properties with VO transformation
     * @see TimecardDao#create(int, String, Date, TimecardStatus, User)
     */
    @Override
    public Object create(final int transform,String comments, Date startDate, TimecardStatus status, User submitter) throws TimecardDaoException
    {
        Timecard entity = new Timecard();
        // comments $propertyType.fullyQualifiedName identifier=$propertyType.identifier false
        entity.setComments(comments);
        // startDate $propertyType.fullyQualifiedName identifier=$propertyType.identifier false
        entity.setStartDate(startDate);
        // status $propertyType.fullyQualifiedName identifier=$propertyType.identifier false
        entity.setStatus(status);
        // submitter $propertyType.fullyQualifiedName identifier=$propertyType.identifier false
        entity.setSubmitter(submitter);
        return this.create(transform, entity);
    }

    /**
     * @see TimecardDao#update(Timecard)
     */
    @Override
    public void update(Timecard timecard) throws TimecardDaoException
    {
        if (timecard == null)
        {
            throw new IllegalArgumentException("Timecard.update - 'timecard' can not be null");
        }
        try
        {
            this.entityManager.merge(timecard);
            this.entityManager.flush();
        }
        catch (Exception ex)
        {
            throw new TimecardDaoException(ex);
        }
    }

    /**
     * @see TimecardDao#update(Collection)
     */
    @Override
    public void update(final Collection<Timecard> entities) throws TimecardDaoException
    {
        if (entities == null)
        {
            throw new IllegalArgumentException("Timecard.update - 'entities' can not be null");
        }
        try
        {
            for (final Timecard entity : entities)
            {
                update(entity);
            }
        }
        catch (Exception ex)
        {
            throw new TimecardDaoException(ex);
        }
    }

    /**
     * @see TimecardDao#remove(Timecard)
     */
    @Override
    public void remove(Timecard timecard) throws TimecardDaoException
    {
        if (timecard == null)
        {
            throw new IllegalArgumentException("Timecard.remove - 'timecard' can not be null");
        }
        try
        {
            this.entityManager.remove(timecard);
            this.entityManager.flush();
        }
        catch (Exception ex)
        {
            throw new TimecardDaoException(ex);
        }
    }

    /**
     * @see TimecardDao#remove(Long)
     */
    @Override
    public void remove(Long id) throws TimecardDaoException
    {
        if (id == null)
        {
            throw new IllegalArgumentException("Timecard.remove - 'id' can not be null");
        }
        try
        {
            final Timecard entity = this.load(id);
            if (entity != null)
            {
                this.remove(entity);
            }
        }
        catch (Exception ex)
        {
            throw new TimecardDaoException(ex);
        }
    }

    /**
     * @see TimecardDao#remove(Collection)
     */
    @Override
    public void remove(Collection<Timecard> entities) throws TimecardDaoException
    {
        if (entities == null)
        {
            throw new IllegalArgumentException("Timecard.remove - 'entities' can not be null");
        }
        try
        {
            for (final Timecard entity : entities)
            {
                remove(entity);
            }
        }
        catch (Exception ex)
        {
            throw new TimecardDaoException(ex);
        }
    }

    /**
     * @see TimecardDao#findByCriteria(TimecardSearchCriteriaVO)
     */
    @Override
    public List findByCriteria(final TimecardSearchCriteriaVO criteria)    {
        if (criteria == null)
        {
            throw new IllegalArgumentException("org.andromda.timetracker.domain.TimecardDao.findByCriteria(TimecardSearchCriteriaVO criteria) - 'criteria' can not be null");
        }
        try
        {
            return this.handleFindByCriteria(criteria);
        }
        catch (Throwable th)
        {
            TimecardDaoBase.logger.debug("Error performing 'TimecardDao.findByCriteria(TimecardSearchCriteriaVO criteria)' --> " + th);
            throw new RuntimeException("Error performing 'TimecardDao.findByCriteria(TimecardSearchCriteriaVO criteria)' --> " + th, th);
        }
    }

     /**
      * Performs the core logic for {@link #findByCriteria(TimecardSearchCriteriaVO)}
      * @param criteria $argument.fullyQualifiedType
      * @return List
      * @throws Exception
      */
    protected abstract List handleFindByCriteria(TimecardSearchCriteriaVO criteria) throws Exception;

    /**
     * Allows transformation of entities into value objects
     * (or something else for that matter), when the <code>transform</code>
     * flag is set to one of the constants defined in <code>TimecardDao</code>, please note
     * that the {@link #TRANSFORM_NONE} constant denotes no transformation, so the entity itself
     * will be returned.
     * <p/>
     * This method will return instances of these types:
     * <ul>
     *   <li>{@link Timecard} - {@link #TRANSFORM_NONE}</li>
     *   <li>{@link TimecardSummaryVO} - {@link #TRANSFORM_TIMECARDSUMMARYVO}</li>
     *   <li>{@link TimecardVO} - {@link #TRANSFORM_TIMECARDVO}</li>
     * </ul>
     *
     * If the integer argument value is unknown {@link #TRANSFORM_NONE} is assumed.
     *
     * @param transform one of the constants declared in {@link TimecardDao}
     * @param entity an entity that was found
     * @return the transformed entity (i.e. new value object, etc)
     * @see #transformEntities(int,Collection)
     */
    protected Object transformEntity(final int transform, final Timecard entity)
    {
        Object target = null;
        if (entity != null)
        {
            switch (transform)
            {
                case TimecardDao.TRANSFORM_TIMECARDSUMMARYVO :
                    target = toTimecardSummaryVO(entity);
                    break;
                case TimecardDao.TRANSFORM_TIMECARDVO :
                    target = toTimecardVO(entity);
                    break;
                case TRANSFORM_NONE : // fall-through
                default:
                    target = entity;
            }
        }
        return target;
    }

    /**
     * Transforms a collection of entities using the
     * {@link #transformEntity(int, Timecard)}
     * method. This method does not instantiate a new collection.
     * <p/>
     * Transforms into the same collection as the argument, but this time containing the transformed entities
     * This method is to be used internally only.
     *
     * @param transform one of the constants declared in <code>TimecardDao</code>
     * @param entities the collection of entities to transform
     * @see #transformEntity(int, Timecard)
     */
    protected void transformEntities(final int transform, final Collection<Timecard> entities)
    {
        switch (transform)
        {
            case TimecardDao.TRANSFORM_TIMECARDSUMMARYVO :
                toTimecardSummaryVOCollection(entities);
                break;
            case TimecardDao.TRANSFORM_TIMECARDVO :
                toTimecardVOCollection(entities);
                break;
            case TRANSFORM_NONE : // fall-through
                default:
                // do nothing;
        }
    }

    /**
     * @see TimecardDao#toTimecardSummaryVOCollection(Collection)
     */
    @Override
    public final void toTimecardSummaryVOCollection(Collection entities)
    {
        if (entities != null)
        {
            CollectionUtils.transform(entities, this.TIMECARDSUMMARYVO_TRANSFORMER);
        }
    }

    /**
     * Default implementation for transforming the results of a report query into a value object. This
     * implementation exists for convenience reasons only. It needs only be overridden in the
     * {@link TimecardDaoImpl} class if you intend to use reporting queries.
     * @param row Object[] Array of Timecard to transform
     * @return target TimecardSummaryVO
     * @see TimecardDao#toTimecardSummaryVO(Timecard)
     */
    protected TimecardSummaryVO toTimecardSummaryVO(Object[] row)
    {
        TimecardSummaryVO target = null;
        if (row != null)
        {
            final int numberOfObjects = row.length;
            for (int ctr = 0; ctr < numberOfObjects; ctr++)
            {
                final Object object = row[ctr];
                if (object instanceof Timecard)
                {
                    target = this.toTimecardSummaryVO((Timecard)object);
                    break;
                }
            }
        }
        return target;
    }

    /**
     * This anonymous transformer is designed to transform entities or report query results
     * (which result in an array of objects) to {@link TimecardSummaryVO}
     * using the Jakarta Commons-Collections Transformation API.
     */
    private Transformer TIMECARDSUMMARYVO_TRANSFORMER =
        new Transformer()
        {
            @Override
            public Object transform(Object input)
            {
                Object result = null;
                if (input instanceof Timecard)
                {
                    result = toTimecardSummaryVO((Timecard)input);
                }
                else if (input instanceof Object[])
                {
                    result = toTimecardSummaryVO((Object[])input);
                }
                return result;
            }
        };

    /**
     * @see TimecardDao#timecardSummaryVOToEntityCollection(Collection)
     */
    @Override
    @SuppressWarnings({"rawtypes"})
    public final void timecardSummaryVOToEntityCollection(Collection instances)
    {
        if (instances != null)
        {
            for (final Iterator iterator = instances.iterator(); iterator.hasNext();)
            {
                // - remove objects that are null or not of the correct instance
                if (!(iterator.next() instanceof TimecardSummaryVO))
                {
                    iterator.remove();
                }
            }
            CollectionUtils.transform(instances, this.TimecardSummaryVOToEntityTransformer);
        }
    }

    private final Transformer TimecardSummaryVOToEntityTransformer =
        new Transformer()
        {
            @Override
            public Object transform(Object input)
            {
                return timecardSummaryVOToEntity((TimecardSummaryVO)input);
            }
        };

    /**
     * @see TimecardDao#toTimecardSummaryVO(Timecard, TimecardSummaryVO)
     */
    @Override
    public void toTimecardSummaryVO( Timecard source, TimecardSummaryVO target)
    {
        target.setId(source.getId());
        target.setStatus(source.getStatus());
        target.setStartDate(source.getStartDate());
        target.setComments(source.getComments());
    }

    /**
     * @see TimecardDao#toTimecardSummaryVO(Timecard)
     */
    @Override
    public TimecardSummaryVO toTimecardSummaryVO(final Timecard entity)
    {
        final TimecardSummaryVO target = new TimecardSummaryVO();
        this.toTimecardSummaryVO(entity, target);
        return target;
    }

    /**
     * @see TimecardDao#timecardSummaryVOToEntity(TimecardSummaryVO, Timecard, boolean)
     */
    @Override
    public void timecardSummaryVOToEntity( TimecardSummaryVO source, Timecard target, boolean copyIfNull)
    {
        if (copyIfNull || source.getComments() != null)
        {
            target.setComments(source.getComments());
        }
        if (copyIfNull || source.getStartDate() != null)
        {
            target.setStartDate(source.getStartDate());
        }
        if (copyIfNull || source.getStatus() != null)
        {
            target.setStatus(source.getStatus());
        }
    }

    /**
     * @see TimecardDao#toTimecardVOCollection(Collection)
     */
    @Override
    public final void toTimecardVOCollection(Collection entities)
    {
        if (entities != null)
        {
            CollectionUtils.transform(entities, this.TIMECARDVO_TRANSFORMER);
        }
    }

    /**
     * Default implementation for transforming the results of a report query into a value object. This
     * implementation exists for convenience reasons only. It needs only be overridden in the
     * {@link TimecardDaoImpl} class if you intend to use reporting queries.
     * @param row Object[] Array of Timecard to transform
     * @return target TimecardVO
     * @see TimecardDao#toTimecardVO(Timecard)
     */
    protected TimecardVO toTimecardVO(Object[] row)
    {
        TimecardVO target = null;
        if (row != null)
        {
            final int numberOfObjects = row.length;
            for (int ctr = 0; ctr < numberOfObjects; ctr++)
            {
                final Object object = row[ctr];
                if (object instanceof Timecard)
                {
                    target = this.toTimecardVO((Timecard)object);
                    break;
                }
            }
        }
        return target;
    }

    /**
     * This anonymous transformer is designed to transform entities or report query results
     * (which result in an array of objects) to {@link TimecardVO}
     * using the Jakarta Commons-Collections Transformation API.
     */
    private Transformer TIMECARDVO_TRANSFORMER =
        new Transformer()
        {
            @Override
            public Object transform(Object input)
            {
                Object result = null;
                if (input instanceof Timecard)
                {
                    result = toTimecardVO((Timecard)input);
                }
                else if (input instanceof Object[])
                {
                    result = toTimecardVO((Object[])input);
                }
                return result;
            }
        };

    /**
     * @see TimecardDao#timecardVOToEntityCollection(Collection)
     */
    @Override
    @SuppressWarnings({"rawtypes"})
    public final void timecardVOToEntityCollection(Collection instances)
    {
        if (instances != null)
        {
            for (final Iterator iterator = instances.iterator(); iterator.hasNext();)
            {
                // - remove objects that are null or not of the correct instance
                if (!(iterator.next() instanceof TimecardVO))
                {
                    iterator.remove();
                }
            }
            CollectionUtils.transform(instances, this.TimecardVOToEntityTransformer);
        }
    }

    private final Transformer TimecardVOToEntityTransformer =
        new Transformer()
        {
            @Override
            public Object transform(Object input)
            {
                return timecardVOToEntity((TimecardVO)input);
            }
        };

    /**
     * @see TimecardDao#toTimecardVO(Timecard, TimecardVO)
     */
    @Override
    public void toTimecardVO( Timecard source, TimecardVO target)
    {
        target.setId(source.getId());
        target.setStatus(source.getStatus());
        target.setStartDate(source.getStartDate());
        target.setComments(source.getComments());
        // No conversion for target.allocations (can't convert source.getAllocations():org.andromda.timetracker.domain.TimeAllocation to org.andromda.timetracker.vo.TimeAllocationVO[])
    }

    /**
     * @see TimecardDao#toTimecardVO(Timecard)
     */
    @Override
    public TimecardVO toTimecardVO(final Timecard entity)
    {
        final TimecardVO target = new TimecardVO();
        this.toTimecardVO(entity, target);
        return target;
    }

    /**
     * @see TimecardDao#timecardVOToEntity(TimecardVO, Timecard, boolean)
     */
    @Override
    public void timecardVOToEntity( TimecardVO source, Timecard target, boolean copyIfNull)
    {
        if (copyIfNull || source.getComments() != null)
        {
            target.setComments(source.getComments());
        }
        if (copyIfNull || source.getStartDate() != null)
        {
            target.setStartDate(source.getStartDate());
        }
        if (copyIfNull || source.getStatus() != null)
        {
            target.setStatus(source.getStatus());
        }
    }


    // For unit testing outside of container - persistence context not injected
    /**
     * @return the context
     */
    public SessionContext getContext()
    {
        return this.context;
    }

    /**
     * @param contextIn the context to set
     */
    public void setContext(SessionContext contextIn)
    {
        this.context = contextIn;
    }

    /**
     * @return the entityManager
     */
    public EntityManager getEntityManager()
    {
        return this.entityManager;
    }

    /**
     * @param entityManagerIn the entityManager to set
     */
    public void setEntityManager(EntityManager entityManagerIn)
    {
        this.entityManager = entityManagerIn;
    }

    /**
     * @return the hibernateSession
     */
    public Session getHibernateSession()
    {
        return this.hibernateSession;
    }

    /**
     * @param hibernateSessionIn the hibernateSession to set
     */
    public void setHibernateSession(Session hibernateSessionIn)
    {
        this.hibernateSession = hibernateSessionIn;
    }
}