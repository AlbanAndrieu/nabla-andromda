// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by crud/ManageableServiceBase.vsl in andromda-ejb3-cartridge.
//
package org.andromda.timetracker.domain.crud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.andromda.timetracker.domain.Task;
import org.andromda.timetracker.domain.TimeAllocation;

/**
 * Autogenerated EJB manageable session bean class TaskManageableService.
 */
/**
 * Do not specify the javax.ejb.${manageable.type} annotation
 * Instead, define the session bean in the ejb-jar.xml descriptor
 * javax.ejb.${manageable.type}
 */
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Remote({TaskManageableService.class})
public final class TaskManageableServiceBase
    implements TaskManageableService
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
    private List<TimeAllocation> findTimeAllocationByIds(Long[] ids)
        throws TaskReadManageableException
    {
        try
        {
            Query query = emanager.createQuery("select entity from TimeAllocation as entity where entity.id in (:id)");
            query.setParameter("id", Arrays.asList(ids));
            return query.getResultList();
        }
        catch (Exception ex)
        {
            throw new TaskReadManageableException(ex);
        }
    }

    // ------------ CRUD Operations -------------

    /**
     * Create operations
     *
     * @return TaskVO
     * @throws TaskCreateManageableException
     */
    public TaskVO create(String name, Long id)
        throws TaskCreateManageableException
    {
        if (name == null)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.domain.crud.TaskManageableService.create(String name, Long id) - 'name' can not be null");
        }

        final Task entity = new Task();
        entity.setName(name);
        entity.setId(id);

        try
        {

            emanager.persist(entity);
            emanager.flush();
            return toValueObject(entity);
        }
        catch (Exception ex)
        {
            throw new TaskCreateManageableException(ex);
        }
    }


     /**
     * Entity read operation
     *
     * @return TaskVO
     * @throws TaskReadManageableException
     */
    public TaskVO readById(Long id)
        throws TaskReadManageableException
    {
        try{
            return toValueObject((Task)emanager.find(Task.class, id));
        }
        catch (Exception ex)
        {
            throw new TaskReadManageableException(ex);
        }
    }

    /**
     * Read operation
     *
     * @return List
     * @throws TaskReadManageableException
     */
    public List<TaskVO> read(String name, Long id)
        throws TaskReadManageableException
    {
        String logicalOperator = "";
        StringBuilder buf = new StringBuilder("from Task as entity");
        buf.append(" where ");
        if (name != null)
        {
            buf.append(logicalOperator);
            buf.append("entity.name like :name");
            logicalOperator = " and ";
        }
        if (id != null)
        {
            buf.append(logicalOperator);
            buf.append("entity.id = :id");
            logicalOperator = " and ";
        }

        try
        {
            final Query query = emanager.createQuery(buf.toString());
            query.setMaxResults(250);
            return query.getResultList();
        }
        catch (Exception ex)
        {
            throw new TaskReadManageableException(ex);
        }
    }

    /**
     * Read all operation
     *
     * @return List
     * @throws TaskReadManageableException
     */
    public List<TaskVO> readAll()
        throws TaskReadManageableException
    {
        try
        {
            Query query = emanager.createQuery("select entity from Task as entity");
            query.setMaxResults(250);
            List<Task> entities = query.getResultList();
            return toValueObjects(entities);
        }
        catch (Exception ex)
        {
            throw new TaskReadManageableException(ex);
        }
    }

    /**
     * Update Operation
     *
     * @return TaskVO
     * @throws TaskUpdateManageableException
     */
    public TaskVO update(String name, Long id)
        throws TaskUpdateManageableException
    {
        if (name == null)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.domain.crud.TaskManageableService.update(String name, Long id) - 'name' can not be null");
        }

        final Task entity = (Task)emanager.find(Task.class, id);
        entity.setName(name);

        try
        {

            emanager.merge(entity);
            emanager.flush();
            return toValueObject(entity);
        }
        catch (Exception ex)
        {
            throw new TaskUpdateManageableException(ex);
        }
    }

    /**
     * Delete operation
     *
     * @throws TaskDeleteManageableException
     */
    public void delete(Long[] ids)
        throws TaskDeleteManageableException
    {
        if (ids == null)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.domain.crud.TaskManageableService.delete(Long[] ids) - 'ids' can not be null");
        }

        try
        {
            final Query queryObject = emanager.createQuery("delete from Task where id in (:ids)");
            queryObject.setParameter("ids", Arrays.asList(ids));
            queryObject.executeUpdate();
        }
        catch (Exception ex)
        {
            throw new TaskDeleteManageableException(ex);
        }
    }

    private static List<TaskVO> toValueObjects(Collection<Task> entities)
    {
        final List<TaskVO> list = new ArrayList<TaskVO>();

        for (Iterator<Task> iterator = entities.iterator(); iterator.hasNext();)
        {
            list.add(toValueObject(iterator.next()));
        }

        return list;
    }

    private static TaskVO toValueObject(Task entity)
    {
        final TaskVO valueObject = new TaskVO();

        valueObject.setName(entity.getName());
        valueObject.setId(entity.getId());

        return valueObject;
    }
}