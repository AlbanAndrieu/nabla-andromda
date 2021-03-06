// license-header java merge-point
// Generated by: crud/SpringCrudServiceBase.vsl in andromda-spring-cartridge.
package org.andromda.timetracker.domain.crud;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.andromda.timetracker.domain.User;
import org.andromda.timetracker.domain.UserRole;

/**
 *TODO: Model Documentation for User
 */
public final class UserManageableServiceBase
    implements UserManageableService
{
    private UserManageableDao dao;

    /**
     * @param daoIn
     */
    public void setDao(UserManageableDao daoIn)
    {
        this.dao = daoIn;
    }

    /**
     * @return dao
     */
    protected UserManageableDao getDao()
    {
        return this.dao;
    }

    /**
     * @param username TODO: Model Documentation for User.username
     * @param password TODO: Model Documentation for User.password
     * @param firstName TODO: Model Documentation for User.firstName
     * @param lastName TODO: Model Documentation for User.lastName
     * @param email TODO: Model Documentation for User.email
     * @param isEnable TODO: Model Documentation for User.isEnable
     * @param creationDate TODO: Model Documentation for User.creationDate
     * @param comment TODO: Model Documentation for User.comment
     * @param id TODO: Model Documentation for User.id
     * @param roles TODO: Model Documentation for UserRole
     * @return UserValueObject
     * @throws Exception
     * @see org.andromda.timetracker.domain.UserDao#create
     */
    public UserValueObject create(String username, String password, String firstName, String lastName, String email, boolean isEnable, Date creationDate, String comment, Long id, Long[] roles)
        throws Exception
    {
        if (username == null)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.domain.crud.UserManageableService.create(String username, String password, String firstName, String lastName, String email, boolean isEnable, Date creationDate, String comment, Long id, Long[] roles) - 'username' can not be null");
        }

        if (password == null)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.domain.crud.UserManageableService.create(String username, String password, String firstName, String lastName, String email, boolean isEnable, Date creationDate, String comment, Long id, Long[] roles) - 'password' can not be null");
        }

        if (firstName == null)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.domain.crud.UserManageableService.create(String username, String password, String firstName, String lastName, String email, boolean isEnable, Date creationDate, String comment, Long id, Long[] roles) - 'firstName' can not be null");
        }

        if (lastName == null)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.domain.crud.UserManageableService.create(String username, String password, String firstName, String lastName, String email, boolean isEnable, Date creationDate, String comment, Long id, Long[] roles) - 'lastName' can not be null");
        }

        if (email == null)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.domain.crud.UserManageableService.create(String username, String password, String firstName, String lastName, String email, boolean isEnable, Date creationDate, String comment, Long id, Long[] roles) - 'email' can not be null");
        }

        if (creationDate == null)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.domain.crud.UserManageableService.create(String username, String password, String firstName, String lastName, String email, boolean isEnable, Date creationDate, String comment, Long id, Long[] roles) - 'creationDate' can not be null");
        }

        return toValueObject(this.dao.create(username, password, firstName, lastName, email, isEnable, creationDate, comment, id, roles));
    }

    /**
     * @param id
     * @return UserValueObject
     * @throws Exception
     * @see UserManageableService#readById(Long)
     */
    public UserValueObject readById(Long id)
        throws Exception
    {
        return toValueObject(this.dao.readById(id));
    }

    /**
     * @param username TODO: Model Documentation for User.username
     * @param password TODO: Model Documentation for User.password
     * @param firstName TODO: Model Documentation for User.firstName
     * @param lastName TODO: Model Documentation for User.lastName
     * @param email TODO: Model Documentation for User.email
     * @param isEnable TODO: Model Documentation for User.isEnable
     * @param creationDate TODO: Model Documentation for User.creationDate
     * @param comment TODO: Model Documentation for User.comment
     * @param id TODO: Model Documentation for User.id
     * @param roles TODO: Model Documentation for UserRole
     * @return toValueObjects(dao.read())
     * @throws Exception
     * @see UserManageableService#read
     */
    public List<UserValueObject> read(String username, String password, String firstName, String lastName, String email, Boolean isEnable, Date creationDate, String comment, Long id, Long[] roles)
        throws Exception
    {
        return toValueObjects(this.dao.read(username, password, firstName, lastName, email, isEnable, creationDate, comment, id, roles));
    }

    /**
     * @return toValueObjects(dao.readAll())
     * @throws Exception
     */
    public List<UserValueObject> readAll()
        throws Exception
    {
        return toValueObjects(this.dao.readAll());
    }

    /**
     * @return Map<String,?> getDao().readBackingLists()
     * @throws Exception
     * @see UserManageableDao#readBackingLists
     */
    public Map<String,?> readBackingLists()
        throws Exception
    {
        return getDao().readBackingLists();
    }

    /**
     * @param username TODO: Model Documentation for User.username
     * @param password TODO: Model Documentation for User.password
     * @param firstName TODO: Model Documentation for User.firstName
     * @param lastName TODO: Model Documentation for User.lastName
     * @param email TODO: Model Documentation for User.email
     * @param isEnable TODO: Model Documentation for User.isEnable
     * @param creationDate TODO: Model Documentation for User.creationDate
     * @param comment TODO: Model Documentation for User.comment
     * @param id TODO: Model Documentation for User.id
     * @param roles TODO: Model Documentation for UserRole
     * @return toValueObject(this.dao.update(username, password, firstName, lastName, email, isEnable, creationDate, comment, id, roles))
     * @throws Exception
     * @see UserManageableDao#update
     */
    public UserValueObject update(String username, String password, String firstName, String lastName, String email, boolean isEnable, Date creationDate, String comment, Long id, Long[] roles)
        throws Exception
    {
        if (username == null)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.domain.crud.UserManageableService.update(String username, String password, String firstName, String lastName, String email, boolean isEnable, Date creationDate, String comment, Long id, Long[] roles) - 'username' can not be null");
        }

        if (password == null)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.domain.crud.UserManageableService.update(String username, String password, String firstName, String lastName, String email, boolean isEnable, Date creationDate, String comment, Long id, Long[] roles) - 'password' can not be null");
        }

        if (firstName == null)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.domain.crud.UserManageableService.update(String username, String password, String firstName, String lastName, String email, boolean isEnable, Date creationDate, String comment, Long id, Long[] roles) - 'firstName' can not be null");
        }

        if (lastName == null)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.domain.crud.UserManageableService.update(String username, String password, String firstName, String lastName, String email, boolean isEnable, Date creationDate, String comment, Long id, Long[] roles) - 'lastName' can not be null");
        }

        if (email == null)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.domain.crud.UserManageableService.update(String username, String password, String firstName, String lastName, String email, boolean isEnable, Date creationDate, String comment, Long id, Long[] roles) - 'email' can not be null");
        }

        if (creationDate == null)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.domain.crud.UserManageableService.update(String username, String password, String firstName, String lastName, String email, boolean isEnable, Date creationDate, String comment, Long id, Long[] roles) - 'creationDate' can not be null");
        }

        return toValueObject(this.dao.update(username, password, firstName, lastName, email, isEnable, creationDate, comment, id, roles));
    }

    /**
     * @param ids
     * @throws Exception
     * @see UserManageableService#delete(Long[])
     */
    public void delete(Long[] ids)
        throws Exception
    {
        if (ids == null)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.domain.crud.UserManageableService.delete(Long[] ids) - 'ids' can not be null");
        }

        this.dao.delete(ids);
    }

    private static List<UserValueObject> toValueObjects(Collection<User> entities)
    {
        final List<UserValueObject> list = new ArrayList<UserValueObject>();

        for (Iterator<User> iterator = entities.iterator(); iterator.hasNext();)
        {
            list.add(toValueObject(iterator.next()));
        }

        return list;
    }

    private static UserValueObject toValueObject(User entity)
    {
        final UserValueObject valueObject = new UserValueObject();

        valueObject.setUsername(entity.getUsername());
        valueObject.setPassword(entity.getPassword());
        valueObject.setFirstName(entity.getFirstName());
        valueObject.setLastName(entity.getLastName());
        valueObject.setEmail(entity.getEmail());
        valueObject.setIsEnable(entity.isIsEnable());
        valueObject.setCreationDate(entity.getCreationDate());
        valueObject.setComment(entity.getComment());
        valueObject.setId(entity.getId());

        final Collection<UserRole> roles = entity.getRoles();
        if (roles == null || roles.isEmpty())
        {
            valueObject.setRoles(null);
        }
        else
        {
            final Long[] values = new Long[roles.size()];
            int counter = 0;
            for (final Iterator<UserRole> iterator = roles.iterator(); iterator.hasNext();counter++)
            {
                final UserRole element = iterator.next();
                values[counter] = element.getId();
            }
            valueObject.setRoles(values);
        }

        return valueObject;
    }
}
