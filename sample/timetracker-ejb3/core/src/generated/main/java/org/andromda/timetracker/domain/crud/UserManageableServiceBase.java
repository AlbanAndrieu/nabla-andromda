// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by crud/ManageableServiceBase.vsl in andromda-ejb3-cartridge.
//
package org.andromda.timetracker.domain.crud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.andromda.timetracker.domain.Timecard;
import org.andromda.timetracker.domain.User;
import org.andromda.timetracker.domain.UserRole;

/**
 * Autogenerated EJB manageable session bean class UserManageableService.
 */
/**
 * Do not specify the javax.ejb.${manageable.type} annotation
 * Instead, define the session bean in the ejb-jar.xml descriptor
 * javax.ejb.${manageable.type}
 */
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Remote({UserManageableService.class})
public final class UserManageableServiceBase
    implements UserManageableService
{
    // ------ Session Context Injection ------

    @Resource
    protected SessionContext context;

    // ------ Persistence Context Injection --------

    /**
     * Inject persistence context timetracker-ejb3
     */
    @PersistenceContext(unitName = "timetracker-ejb3")
    protected EntityManager emanager;

    // ------------ Private Operations ----------

    @SuppressWarnings({"unchecked"})
    private List<UserRole> findUserRoleByIds(Long[] ids)
        throws UserReadManageableException
    {
        try
        {
            Query query = emanager.createQuery("select entity from UserRole as entity where entity.id in (:id)");
            query.setParameter("id", Arrays.asList(ids));
            return query.getResultList();
        }
        catch (Exception ex)
        {
            throw new UserReadManageableException(ex);
        }
    }

    @SuppressWarnings({"unchecked"})
    private List<Timecard> findTimecardByIds(Long[] ids)
        throws UserReadManageableException
    {
        try
        {
            Query query = emanager.createQuery("select entity from Timecard as entity where entity.id in (:id)");
            query.setParameter("id", Arrays.asList(ids));
            return query.getResultList();
        }
        catch (Exception ex)
        {
            throw new UserReadManageableException(ex);
        }
    }

    // ------------ CRUD Operations -------------

    /**
     * Create operations
     *
     * @return UserVO
     * @throws UserCreateManageableException
     */
    public UserVO create(String username, String password, String firstName, String lastName, String email, boolean isEnable, Date creationDate, String comment, Long id, Long[] roles)
        throws UserCreateManageableException
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

        final User entity = new User();
        entity.setUsername(username);
        entity.setPassword(password);
        entity.setFirstName(firstName);
        entity.setLastName(lastName);
        entity.setEmail(email);
        entity.setIsEnable(isEnable);
        entity.setCreationDate(creationDate);
        entity.setComment(comment);
        entity.setId(id);

        try
        {
            final List<UserRole> rolesEntities =
                (roles != null && roles.length > 0)
                    ? this.findUserRoleByIds(roles)
                        : Collections.EMPTY_LIST;


            if (rolesEntities != null)
            {
                entity.setRoles(new TreeSet<UserRole>(rolesEntities));
                // we ought to be setting the other end of the many2many association here
                // but the navigability on the other end has been disabled, therefore doing
                // the following would break compilation: element.getUsers()
                // the result is that only one end of this association will be set
            }


            emanager.persist(entity);
            emanager.flush();
            return toValueObject(entity);
        }
        catch (Exception ex)
        {
            throw new UserCreateManageableException(ex);
        }
    }


     /**
     * Entity read operation
     *
     * @return UserVO
     * @throws UserReadManageableException
     */
    public UserVO readById(Long id)
        throws UserReadManageableException
    {
        try{
            return toValueObject((User)emanager.find(User.class, id));
        }
        catch (Exception ex)
        {
            throw new UserReadManageableException(ex);
        }
    }

    /**
     * Read operation
     *
     * @return List
     * @throws UserReadManageableException
     */
    public List<UserVO> read(String username, String password, String firstName, String lastName, String email, boolean isEnable, Date creationDate, String comment, Long id, Long[] roles)
        throws UserReadManageableException
    {
        String logicalOperator = "";
        StringBuilder buf = new StringBuilder("from User as entity");
        buf.append(" join entity.roles as UserRole ");
        buf.append(" where ");
        if (username != null)
        {
            buf.append(logicalOperator);
            buf.append("entity.username like :username");
            logicalOperator = " and ";
        }
        if (password != null)
        {
            buf.append(logicalOperator);
            buf.append("entity.password like :password");
            logicalOperator = " and ";
        }
        if (firstName != null)
        {
            buf.append(logicalOperator);
            buf.append("entity.firstName like :firstName");
            logicalOperator = " and ";
        }
        if (lastName != null)
        {
            buf.append(logicalOperator);
            buf.append("entity.lastName like :lastName");
            logicalOperator = " and ";
        }
        if (email != null)
        {
            buf.append(logicalOperator);
            buf.append("entity.email like :email");
            logicalOperator = " and ";
        }
        buf.append(logicalOperator);
        if (isEnable)
        {
            buf.append("entity.isEnable is true");
        }
        else
        {
            buf.append("entity.isEnable is not true");
        }
        logicalOperator = " and ";
        if (creationDate != null)
        {
            buf.append(logicalOperator);
            final Calendar calendar = new GregorianCalendar();
            calendar.setTime(creationDate);
            if (calendar.get(Calendar.HOUR) != 0
                 || calendar.get(Calendar.MINUTE) != 0
                 || calendar.get(Calendar.SECOND) != 0
                 || calendar.get(Calendar.MILLISECOND) != 0)
            {
                buf.append("entity.creationDate = :creationDate");
            }
            else
            {
                buf.append("entity.creationDate between = :creationDateStart and :creationDateEnd");
            }
            logicalOperator = " and ";
        }
        if (comment != null)
        {
            buf.append(logicalOperator);
            buf.append("entity.comment like :comment");
            logicalOperator = " and ";
        }
        if (id != null)
        {
            buf.append(logicalOperator);
            buf.append("entity.id = :id");
            logicalOperator = " and ";
        }
        if (roles != null && roles.length > 0)
        {
            buf.append(logicalOperator);
            buf.append("UserRole IN (:roles)");
            logicalOperator = " and ";
        }

        try
        {
            final Query query = emanager.createQuery(buf.toString());
            query.setParameter("isEnable", new Boolean(isEnable));
            if (roles != null && roles.length > 0)
            {
                query.setParameter("roles", Arrays.asList(roles));
            }
            query.setMaxResults(250);
            return query.getResultList();
        }
        catch (Exception ex)
        {
            throw new UserReadManageableException(ex);
        }
    }

    /**
     * Read all operation
     *
     * @return List
     * @throws UserReadManageableException
     */
    public List<UserVO> readAll()
        throws UserReadManageableException
    {
        try
        {
            Query query = emanager.createQuery("select entity from User as entity left join fetch entity.roles");
            query.setMaxResults(250);
            List<User> entities = query.getResultList();
            return toValueObjects(entities);
        }
        catch (Exception ex)
        {
            throw new UserReadManageableException(ex);
        }
    }

    /**
     * Read backing list operation
     *
     * @return Map
     * @throws UserReadManageableException
     */
    public Map readBackingLists()
        throws UserReadManageableException
    {
        final Map lists = new HashMap();

        try
        {
            lists.put("roles", emanager.createQuery("select item.id, item.id from UserRole as item order by item.id").getResultList());
        }
        catch (Exception ex)
        {
            throw new UserReadManageableException(ex);
        }
        return lists;
    }

    /**
     * Update Operation
     *
     * @return UserVO
     * @throws UserUpdateManageableException
     */
    public UserVO update(String username, String password, String firstName, String lastName, String email, boolean isEnable, Date creationDate, String comment, Long id, Long[] roles)
        throws UserUpdateManageableException
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

        final User entity = (User)emanager.find(User.class, id);
        entity.setUsername(username);
        entity.setPassword(password);
        entity.setFirstName(firstName);
        entity.setLastName(lastName);
        entity.setEmail(email);
        entity.setIsEnable(isEnable);
        entity.setCreationDate(creationDate);
        entity.setComment(comment);

        try
        {
            final List<UserRole> rolesEntities =
                (roles != null && roles.length > 0)
                    ? this.findUserRoleByIds(roles)
                        : Collections.EMPTY_LIST;


            if (rolesEntities != null)
            {
                entity.setRoles(new TreeSet<UserRole>(rolesEntities));
                // we ought to be setting the other end of the many2many association here
                // but the navigability on the other end has been disabled, therefore doing
                // the following would break compilation: element.getUsers()
                // the result is that only one end of this association will be set
            }

            emanager.merge(entity);
            emanager.flush();
            return toValueObject(entity);
        }
        catch (Exception ex)
        {
            throw new UserUpdateManageableException(ex);
        }
    }

    /**
     * Delete operation
     *
     * @throws UserDeleteManageableException
     */
    public void delete(Long[] ids)
        throws UserDeleteManageableException
    {
        if (ids == null)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.domain.crud.UserManageableService.delete(Long[] ids) - 'ids' can not be null");
        }

        try
        {
            final Query queryObject = emanager.createQuery("delete from User where id in (:ids)");
            queryObject.setParameter("ids", Arrays.asList(ids));
            queryObject.executeUpdate();
        }
        catch (Exception ex)
        {
            throw new UserDeleteManageableException(ex);
        }
    }

    private static List<UserVO> toValueObjects(Collection<User> entities)
    {
        final List<UserVO> list = new ArrayList<UserVO>();

        for (Iterator<User> iterator = entities.iterator(); iterator.hasNext();)
        {
            list.add(toValueObject(iterator.next()));
        }

        return list;
    }

    private static UserVO toValueObject(User entity)
    {
        final UserVO valueObject = new UserVO();

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