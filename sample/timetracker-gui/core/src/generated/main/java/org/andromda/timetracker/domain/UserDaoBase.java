// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand! hibernate4=false hibernateVersion=3
// Generated by: hibernate/SpringHibernateDaoBase.vsl overrided in andromda-spring-cartridge.
//
package org.andromda.timetracker.domain;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.andromda.spring.PaginationResult;
import org.andromda.timetracker.PrincipalStore;
import org.andromda.timetracker.PropertySearch;
import org.andromda.timetracker.Search;
import org.andromda.timetracker.SearchParameter;
import org.andromda.timetracker.vo.UserDetailsVO;
import org.andromda.timetracker.vo.UserVO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * <p>
 * Base Spring DAO Class: is able to create, update, remove, load, and find
 * objects of type <code>User</code>.
 * </p>
 *
 * @see User
 */
public abstract class UserDaoBase
    extends HibernateDaoSupport
    implements UserDao
{
    private UserRoleDao userRoleDao;

    /**
     * Sets the reference to <code>userRoleDao</code>.
     * @param userRoleDaoIn
     */
    public void setUserRoleDao(UserRoleDao userRoleDaoIn)
    {
        this.userRoleDao = userRoleDaoIn;
    }

    /**
     * Gets the reference to <code>userRoleDao</code>.
     * @return userRoleDao
     */
    protected UserRoleDao getUserRoleDao()
    {
        return this.userRoleDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object get(final int transform, final Long id)
    {
        if (id == null)
        {
            throw new IllegalArgumentException(
                "User.get - 'id' can not be null");
        }
        final Object entity = this.getHibernateTemplate().get(UserImpl.class, id);
        return transformEntity(transform, (User)entity);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public User get(Long id)
    {
        return (User)this.get(TRANSFORM_NONE, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object load(final int transform, final Long id)
    {
        if (id == null)
        {
            throw new IllegalArgumentException(
                "User.load - 'id' can not be null");
        }
        final Object entity = this.getHibernateTemplate().get(UserImpl.class, id);
        return transformEntity(transform, (User)entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User load(Long id)
    {
        return (User)this.load(TRANSFORM_NONE, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings({"unchecked"})
    public Collection<User> loadAll()
    {
        return (Collection<User>) this.loadAll(UserDao.TRANSFORM_NONE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<?> loadAll(final int transform)
    {
        return this.loadAll(transform, -1, -1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<?> loadAll(final int pageNumber, final int pageSize)
    {
        return this.loadAll(UserDao.TRANSFORM_NONE, pageNumber, pageSize);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<?> loadAll(final int transform, final int pageNumber, final int pageSize)
    {
        try
        {
            final Criteria criteria = this.getSession(false).createCriteria(UserImpl.class);
            if (pageNumber > 0 && pageSize > 0)
            {
                criteria.setFirstResult(this.calculateFirstResult(pageNumber, pageSize));
                criteria.setMaxResults(pageSize);
            }
            final Collection<?> results = criteria.list();
            this.transformEntities(transform, results);
            return results;
        }
        catch (HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

    /**
     * firstResult = (pageNumber - 1) * pageSize
     * @param pageNumber
     * @param pageSize
     * @return firstResult
     */
    protected int calculateFirstResult(int pageNumber, int pageSize)
    {
        int firstResult = 0;
        if (pageNumber > 0)
        {
            firstResult = (pageNumber - 1) * pageSize;
        }
        return firstResult;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User create(User user)
    {
        return (User)this.create(UserDao.TRANSFORM_NONE, user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object create(final int transform, final User user)
    {
        if (user == null)
        {
            throw new IllegalArgumentException(
                "User.create - 'user' can not be null");
        }
        this.getHibernateTemplate().save(user);
        return this.transformEntity(transform, user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings({"unchecked"})
    public Collection<User> create(final Collection<User> entities)
    {
        return (Collection<User>) create(UserDao.TRANSFORM_NONE, entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<?> create(final int transform, final Collection<User> entities)
    {
        if (entities == null)
        {
            throw new IllegalArgumentException(
                "User.create - 'entities' can not be null");
        }
        this.getHibernateTemplate().executeWithNativeSession(
            new HibernateCallback()
            {
                public Object doInHibernate(Session session)
                    throws HibernateException
                {
                    for (User entity : entities)
                    {
                        create(transform, entity);
                    }
                    return null;
                }
            });
        return entities;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User create(
        String username,
        String password,
        String firstName,
        String lastName,
        String email,
        boolean isEnable,
        Date creationDate,
        String comment)
    {
        return (User)this.create(UserDao.TRANSFORM_NONE, username, password, firstName, lastName, email, isEnable, creationDate, comment);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object create(
        final int transform,
        String username,
        String password,
        String firstName,
        String lastName,
        String email,
        boolean isEnable,
        Date creationDate,
        String comment)
    {
        User entity = new UserImpl();
        entity.setUsername(username);
        entity.setPassword(password);
        entity.setFirstName(firstName);
        entity.setLastName(lastName);
        entity.setEmail(email);
        entity.setIsEnable(isEnable);
        entity.setCreationDate(creationDate);
        entity.setComment(comment);
        return this.create(transform, entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(User user)
    {
        if (user == null)
        {
            throw new IllegalArgumentException(
                "User.update - 'user' can not be null");
        }
        this.getHibernateTemplate().update(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final Collection<User> entities)
    {
        if (entities == null)
        {
            throw new IllegalArgumentException(
                "User.update - 'entities' can not be null");
        }
        this.getHibernateTemplate().executeWithNativeSession(
            new HibernateCallback()
            {
                public Object doInHibernate(Session session)
                    throws HibernateException
                {
                    for (User entity : entities)
                    {
                        update(entity);
                    }
                    return null;
                }
            });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(User user)
    {
        if (user == null)
        {
            throw new IllegalArgumentException(
                "User.remove - 'user' can not be null");
        }
        this.getHibernateTemplate().delete(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(Long id)
    {
        if (id == null)
        {
            throw new IllegalArgumentException(
                "User.remove - 'id' can not be null");
        }
        User entity = this.get(id);
        if (entity != null)
        {
            this.remove(entity);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(Collection<User> entities)
    {
        if (entities == null)
        {
            throw new IllegalArgumentException(
                "User.remove - 'entities' can not be null");
        }
        for (User entity : entities)
        {
            this.getHibernateTemplate().delete(entity);
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public User findByEmail(String email)
    {
        return (User)this.findByEmail(UserDao.TRANSFORM_NONE, email);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object findByEmail(final int transform, final String email)
    {
        return this.findByEmail(transform, "from UserImpl as user where user.email = :email", email);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User findByEmail(final String queryString, final String email)
    {
        return (User)this.findByEmail(UserDao.TRANSFORM_NONE, queryString, email);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object findByEmail(final int transform, final String queryString, final String email)
    {
        try
        {
            Query queryObject = super.getSession(false).createQuery(queryString);
        queryObject.setParameter("email", email);
        Set results = new LinkedHashSet(queryObject.list());
        Object result = null;
        if (results.size() > 1)
        {
            throw new InvalidDataAccessResourceUsageException(
                "More than one instance of 'org.andromda.timetracker.domain.User"
                    + "' was found when executing query --> '" + queryString + "'");
        }
        else if (results.size() == 1)
        {
            result = results.iterator().next();
        }
        if(transform != TRANSFORM_NONE){
            result = transformEntity(transform, (User)result);
        }
        return result;
        }
        catch (HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getUserDetails(final String username)
    {
        if (username == null)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.domain.UserDao.getUserDetails(String username) - 'username' can not be null");
        }
        try
        {
            return this.handleGetUserDetails(username);
        }
        catch (Throwable th)
        {
            throw new RuntimeException(
            "Error performing 'UserDao.getUserDetails(String username)' --> " + th,
            th);
        }
    }

    /**
     * Performs the core logic for {@link #getUserDetails(String)}
     * @param username
     * @return User
     * @throws Exception
     */
    protected abstract User handleGetUserDetails(String username)
        throws Exception;

    /**
     * Allows transformation of entities into value objects
     * (or something else for that matter), when the <code>transform</code>
     * flag is set to one of the constants defined in <code>UserDao</code>, please note
     * that the {@link #TRANSFORM_NONE} constant denotes no transformation, so the entity itself
     * will be returned.
     * <p>
     * This method will return instances of these types:
     * <ul>
     *   <li>{@link User} - {@link #TRANSFORM_NONE}</li>
     *   <li>{@link UserVO} - {@link #TRANSFORM_USERVO}</li>
     *   <li>{@link UserDetailsVO} - {@link #TRANSFORM_USERDETAILSVO}</li>
     * </ul>
     *
     * If the integer argument value is unknown {@link #TRANSFORM_NONE} is assumed.
     *
     * @param transform one of the constants declared in {@link UserDao}
     * @param entity an entity that was found
     * @return the transformed entity (i.e. new value object, etc)
     * @see UserDao#transformEntity(int, User)
     */
    public Object transformEntity(final int transform, final User entity)
    {
        Object target = null;
        if (entity != null)
        {
            switch (transform)
            {
                case TRANSFORM_USERVO :
                    target = toUserVO(entity);
                    break;
                case TRANSFORM_USERDETAILSVO :
                    target = toUserDetailsVO(entity);
                    break;
                case UserDao.TRANSFORM_NONE : // fall-through
                default:
                    target = entity;
            }
        }
        return target;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void transformEntities(final int transform, final Collection<?> entities)
    {
        switch (transform)
        {
            case TRANSFORM_USERVO :
                toUserVOCollection(entities);
                break;
            case TRANSFORM_USERDETAILSVO :
                toUserDetailsVOCollection(entities);
                break;
            case UserDao.TRANSFORM_NONE : // fall-through
                default:
                // do nothing;
        }
    }

    /**
     * @see UserDao#toEntities(Collection)
     */
    public void toEntities(final Collection<?> results)
    {
        if (results != null)
        {
            CollectionUtils.transform(results, this.ENTITYTRANSFORMER);
        }
    }

    /**
     * This anonymous transformer is designed to transform report query results
     * (which result in an array of entities) to {@link User}
     * using the Jakarta Commons-Collections Transformation API.
     */
    private Transformer ENTITYTRANSFORMER =
        new Transformer()
        {
            public Object transform(Object input)
            {
                Object result = null;
                if (input instanceof Object[])
                {
                    result = toEntity((Object[])input);
                }
                else if (input instanceof User)
                {
                    result = input;
                }
                return result;
            }
        };

    /**
     * @param row
     * @return User
     */
    protected User toEntity(Object[] row)
    {
        User target = null;
        if (row != null)
        {
            final int numberOfObjects = row.length;
            for (int ctr = 0; ctr < numberOfObjects; ctr++)
            {
                final Object object = row[ctr];
                if (object instanceof User)
                {
                    target = (User)object;
                    break;
                }
            }
        }
        return target;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings({"unchecked"})
    public final Collection<UserVO> toUserVOCollection(Collection<?> entities)
    {
        Collection<UserVO> result = new ArrayList<UserVO>();
        if (entities != null)
        {
            CollectionUtils.transform(entities, this.USERVO_TRANSFORMER);
            result.addAll((Collection<? extends UserVO>) entities);
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings({ "unchecked" })
    public final UserVO[] toUserVOArray(Collection<?> entities)
    {
        UserVO[] result = null;
        if (entities != null)
        {
            // Unchecked transformation: reuses entities Collection
            final Collection collection = new ArrayList(entities);
            this.toUserVOCollection(collection);
            result = (UserVO[]) collection.toArray(new UserVO[collection.size()]);
        }
        return result;
    }

    /**
     * Default implementation for transforming the results of a report query into a value object. This
     * implementation exists for convenience reasons only. It needs only be overridden in the
     * {@link UserDaoImpl} class if you intend to use reporting queries.
     * @param row
     * @return toUserVO(this.toEntity(row))
     * @see UserDao#toUserVO(User)
     */
    protected UserVO toUserVO(Object[] row)
    {
        return this.toUserVO(this.toEntity(row));
    }

    /**
     * This anonymous transformer is designed to transform entities or report query results
     * (which result in an array of objects) to {@link UserVO}
     * using the Jakarta Commons-Collections Transformation API.
     */
    private Transformer USERVO_TRANSFORMER =
        new Transformer()
        {
            public Object transform(Object input)
            {
                Object result = null;
                if (input instanceof User)
                {
                    result = toUserVO((User)input);
                }
                else if (input instanceof Object[])
                {
                    result = toUserVO((Object[])input);
                }
                return result;
            }
        };

    /**
     * {@inheritDoc}
     */
    @Override
    public final void userVOToEntityCollection(Collection<?> instances)
    {
        if (instances != null)
        {
            for (final Iterator<?> iterator = instances.iterator(); iterator.hasNext();)
            {
                // - remove an objects that are null or not of the correct instance
                if (!(iterator.next() instanceof UserVO))
                {
                    iterator.remove();
                }
            }
            CollectionUtils.transform(instances, this.UserVOToEntityTransformer);
        }
    }

    private final Transformer UserVOToEntityTransformer =
        new Transformer()
        {
            public Object transform(Object input)
            {
                return userVOToEntity((UserVO)input);
            }
        };


    /**
     * {@inheritDoc}
     */
    @Override
    public void toUserVO(
        User source,
        UserVO target)
    {
        target.setId(source.getId());
        target.setUsername(source.getUsername());
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserVO toUserVO(final User entity)
    {
        UserVO target = null;
        if (entity != null)
        {
            target =  new UserVO();
            this.toUserVO(entity, target);
        }
        return target;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void userVOToEntity(
        UserVO source,
        User target,
        boolean copyIfNull)
    {
        if (copyIfNull || source.getUsername() != null)
        {
            target.setUsername(source.getUsername());
        }
        if (copyIfNull || source.getFirstName() != null)
        {
            target.setFirstName(source.getFirstName());
        }
        if (copyIfNull || source.getLastName() != null)
        {
            target.setLastName(source.getLastName());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings({"unchecked"})
    public final Collection<UserDetailsVO> toUserDetailsVOCollection(Collection<?> entities)
    {
        Collection<UserDetailsVO> result = new ArrayList<UserDetailsVO>();
        if (entities != null)
        {
            CollectionUtils.transform(entities, this.USERDETAILSVO_TRANSFORMER);
            result.addAll((Collection<? extends UserDetailsVO>) entities);
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings({ "unchecked" })
    public final UserDetailsVO[] toUserDetailsVOArray(Collection<?> entities)
    {
        UserDetailsVO[] result = null;
        if (entities != null)
        {
            // Unchecked transformation: reuses entities Collection
            final Collection collection = new ArrayList(entities);
            this.toUserDetailsVOCollection(collection);
            result = (UserDetailsVO[]) collection.toArray(new UserDetailsVO[collection.size()]);
        }
        return result;
    }

    /**
     * Default implementation for transforming the results of a report query into a value object. This
     * implementation exists for convenience reasons only. It needs only be overridden in the
     * {@link UserDaoImpl} class if you intend to use reporting queries.
     * @param row
     * @return toUserDetailsVO(this.toEntity(row))
     * @see UserDao#toUserDetailsVO(User)
     */
    protected UserDetailsVO toUserDetailsVO(Object[] row)
    {
        return this.toUserDetailsVO(this.toEntity(row));
    }

    /**
     * This anonymous transformer is designed to transform entities or report query results
     * (which result in an array of objects) to {@link UserDetailsVO}
     * using the Jakarta Commons-Collections Transformation API.
     */
    private Transformer USERDETAILSVO_TRANSFORMER =
        new Transformer()
        {
            public Object transform(Object input)
            {
                Object result = null;
                if (input instanceof User)
                {
                    result = toUserDetailsVO((User)input);
                }
                else if (input instanceof Object[])
                {
                    result = toUserDetailsVO((Object[])input);
                }
                return result;
            }
        };

    /**
     * {@inheritDoc}
     */
    @Override
    public final void userDetailsVOToEntityCollection(Collection<?> instances)
    {
        if (instances != null)
        {
            for (final Iterator<?> iterator = instances.iterator(); iterator.hasNext();)
            {
                // - remove an objects that are null or not of the correct instance
                if (!(iterator.next() instanceof UserDetailsVO))
                {
                    iterator.remove();
                }
            }
            CollectionUtils.transform(instances, this.UserDetailsVOToEntityTransformer);
        }
    }

    private final Transformer UserDetailsVOToEntityTransformer =
        new Transformer()
        {
            public Object transform(Object input)
            {
                return userDetailsVOToEntity((UserDetailsVO)input);
            }
        };


    /**
     * {@inheritDoc}
     */
    @Override
    public void toUserDetailsVO(
        User source,
        UserDetailsVO target)
    {
        target.setId(source.getId());
        target.setUsername(source.getUsername());
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setPassword(source.getPassword());
        target.setEmail(source.getEmail());
        target.setCreationDate(source.getCreationDate());
        target.setComment(source.getComment());
        // No conversion for target.roles (can't convert source.getRoles():org.andromda.timetracker.domain.UserRole to org.andromda.timetracker.vo.UserRoleVO[])
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserDetailsVO toUserDetailsVO(final User entity)
    {
        UserDetailsVO target = null;
        if (entity != null)
        {
            target =  new UserDetailsVO();
            this.toUserDetailsVO(entity, target);
        }
        return target;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void userDetailsVOToEntity(
        UserDetailsVO source,
        User target,
        boolean copyIfNull)
    {
        if (copyIfNull || source.getUsername() != null)
        {
            target.setUsername(source.getUsername());
        }
        if (copyIfNull || source.getPassword() != null)
        {
            target.setPassword(source.getPassword());
        }
        if (copyIfNull || source.getFirstName() != null)
        {
            target.setFirstName(source.getFirstName());
        }
        if (copyIfNull || source.getLastName() != null)
        {
            target.setLastName(source.getLastName());
        }
        if (copyIfNull || source.getEmail() != null)
        {
            target.setEmail(source.getEmail());
        }
        if (copyIfNull || source.getCreationDate() != null)
        {
            target.setCreationDate(source.getCreationDate());
        }
        if (copyIfNull || source.getComment() != null)
        {
            target.setComment(source.getComment());
        }
    }

    /**
     * Gets the current <code>principal</code> if one has been set,
     * otherwise returns <code>null</code>.
     *
     * @return the current principal
     */
    protected Principal getPrincipal()
    {
        return PrincipalStore.get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings({ "unchecked" })
    public PaginationResult search(final int transform, final int pageNumber, final int pageSize, final Search search)
    {
        try
        {
            search.setPageNumber(pageNumber);
            search.setPageSize(pageSize);
            final PropertySearch propertySearch = new PropertySearch(
                this.getSession(false), UserImpl.class, search);
            final List results = propertySearch.executeAsList();
            this.transformEntities(transform, results);
            return new PaginationResult(results.toArray(new Object[results.size()]), propertySearch.getTotalCount());
        }
        catch (HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResult search(final int pageNumber, final int pageSize, final Search search)
    {
        return this.search(UserDao.TRANSFORM_NONE, pageNumber, pageSize, search);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<?> search(final int transform, final Search search)
    {
        try
        {
            final PropertySearch propertySearch = new PropertySearch(
                this.getSession(false), UserImpl.class, search);
            final Set<?> results = propertySearch.executeAsSet();
            this.transformEntities(transform, results);
            return results;
        }
        catch (HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public Set<User> search(final Search search)
    {
        return (Set<User>) this.search(UserDao.TRANSFORM_NONE, search);
    }

    /**
     * Executes and returns the given Hibernate queryObject as a {@link PaginationResult} instance.
     * @param queryObject
     * @param transform
     * @param pageNumber
     * @param pageSize
     * @return PaginationResult
     */
    @SuppressWarnings({ "unchecked" })
    protected PaginationResult getPaginationResult(
        final Query queryObject,
        final int transform, int pageNumber, int pageSize)
    {
        try
        {
            final ScrollableResults scrollableResults = queryObject.scroll();
            scrollableResults.last();
            int totalCount = scrollableResults.getRowNumber();
            totalCount = totalCount >= 0 ? totalCount + 1 : 0;
            if (pageNumber > 0 && pageSize > 0)
            {
                queryObject.setFirstResult(this.calculateFirstResult(pageNumber, pageSize));
                queryObject.setMaxResults(pageSize);
            }
            // Unchecked transformation because Set object is reused, cannot be strongly typed.
            Set results = new LinkedHashSet(queryObject.list());
            transformEntities(transform, results);
            return new PaginationResult(results.toArray(new Object[results.size()]), totalCount);
        }
        catch (HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User searchUniqueUsername(final String username)
    {
        final Search search=new Search(
            new SearchParameter[]{
                new SearchParameter("username",username,SearchParameter.EQUAL_COMPARATOR)
            }
        );

        final Set<User> searchResult=this.search(search);
        switch(searchResult.size())
        {
            case 0: return null;
            case 1: return searchResult.iterator().next();
            default: throw new NonUniqueResultException(searchResult.size());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object searchUniqueUsername(final int transform, final String username)
    {
        final User uniqueEntity=this.searchUniqueUsername(username);
        if(uniqueEntity == null)
        {
            return null;
        }
        return transformEntity(transform, uniqueEntity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User searchUniqueEmail(final String email)
    {
        final Search search=new Search(
            new SearchParameter[]{
                new SearchParameter("email",email,SearchParameter.EQUAL_COMPARATOR)
            }
        );

        final Set<User> searchResult=this.search(search);
        switch(searchResult.size())
        {
            case 0: return null;
            case 1: return searchResult.iterator().next();
            default: throw new NonUniqueResultException(searchResult.size());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object searchUniqueEmail(final int transform, final String email)
    {
        final User uniqueEntity=this.searchUniqueEmail(email);
        if(uniqueEntity == null)
        {
            return null;
        }
        return transformEntity(transform, uniqueEntity);
    }

    // spring-hibernate-dao-base merge-point
}
