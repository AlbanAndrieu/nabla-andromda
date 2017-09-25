// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by SessionBeanBase.vsl in andromda-ejb3-cartridge.
//
package org.andromda.timetracker.service;

import java.util.List;
import javax.ejb.EJB;
import org.andromda.timetracker.domain.User;
import org.andromda.timetracker.domain.UserDao;
import org.andromda.timetracker.vo.UserDetailsVO;
import org.andromda.timetracker.vo.UserVO;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.annotations.datamodel.DataModelSelection;
import org.jboss.seam.log.Log;

/**
 * Autogenerated EJB3 session bean base class UserServiceBean which contains
 * method level annotations for the session bean.  All method level annotations
 * are inherited by the extending session bean class.
 *
 * This Seam component is defined through META-INF/components.xml rather than
 * class level annotations.
 * TODO: Model Documentation for UserService
 */
public abstract class UserServiceBase implements UserService
{

    // ------ No Session Context Injection ------
    // ---------- No User Transaction Injection ---------
    // ------ No Persistence Context Definitions --------


    // ------ DAO Injection Definitions --------

    /**
     * Inject DAO UserDao
     */
    @EJB(mappedName="java:global/TimeTracker/UserDaoImpl")
    private UserDao userDao;

    // --------- Attribute Definitions ------------

    /**
     * The logger property
     */
    @Logger
    protected Log logger;

    /**
     * The user property
     */
    @DataModelSelection
    protected User user;

    /**
     * The userList property
     */
    @DataModel
    protected List<User> userList;


    // --------------- Constructors ---------------

    /**
     * Default constructor method with no arguments.
     */
    public UserServiceBase()
    {
        super();
    }

    // ------- Accessors for Attributes ----------


    // ------ DAO Getters --------

    /**
     * Get the injected DAO UserDao
     * @return UserDao
     */
    protected UserDao getUserDao()
    {
        return this.userDao;
    }

    // -------- Business Methods  --------------

    /**
     * TODO: Model Documentation for UserService.getAllUsers
     * @return UserVO[]
     * @throws UserDoesNotExistException
     */
    @Factory
    public UserVO[] getAllUsers() throws UserDoesNotExistException
    {
        try
        {
            return this.handleGetAllUsers();
        }
        catch (UserDoesNotExistException ex)
        {
            throw ex;
        }
        catch (Throwable th)
        {
            throw new UserServiceException("Error performing 'UserService.getAllUsers()' --> " + th, th);
        }
    }

    /**
     * Performs the core logic for {@link #getAllUsers()}
     * @return UserVO[]
     * @throws Exception
     */
    protected abstract UserVO[] handleGetAllUsers() throws Exception;

    /**
     * TODO: Model Documentation for UserService.getUser
     * @param username
     * @return UserVO
     * @throws UserDoesNotExistException
     */
    public UserVO getUser(String username) throws UserDoesNotExistException
    {
        if (username == null)
        {
            throw new IllegalArgumentException("org.andromda.timetracker.service.UserServiceBean.getUser(String username) - 'username' can not be null");
        }
        try
        {
            return this.handleGetUser(username);
        }
        catch (UserDoesNotExistException ex)
        {
            throw ex;
        }
        catch (Throwable th)
        {
            throw new UserServiceException("Error performing 'UserService.getUser(String username)' --> " + th, th);
        }
    }

    /**
     * Performs the core logic for {@link #getUser(String)}
     * @param username
     * @return UserVO
     * @throws Exception
     */
    protected abstract UserVO handleGetUser(String username) throws Exception;

    /**
     * TODO: Model Documentation for UserService.registerUser
     * @param userDetailVO
     * @return UserDetailsVO
     * @throws UserDoesNotExistException
     */
    public UserDetailsVO registerUser(UserDetailsVO userDetailVO) throws UserDoesNotExistException
    {
        if (userDetailVO == null)
        {
            throw new IllegalArgumentException("org.andromda.timetracker.service.UserServiceBean.registerUser(UserDetailsVO userDetailVO) - 'userDetailVO' can not be null");
        }
        try
        {
            return this.handleRegisterUser(userDetailVO);
        }
        catch (UserDoesNotExistException ex)
        {
            throw ex;
        }
        catch (Throwable th)
        {
            throw new UserServiceException("Error performing 'UserService.registerUser(UserDetailsVO userDetailVO)' --> " + th, th);
        }
    }

    /**
     * Performs the core logic for {@link #registerUser(UserDetailsVO)}
     * @param userDetailVO
     * @return UserDetailsVO
     * @throws Exception
     */
    protected abstract UserDetailsVO handleRegisterUser(UserDetailsVO userDetailVO) throws Exception;

    /**
     * TODO: Model Documentation for UserService.removeUser
     * @param userVO
     * @throws UserDoesNotExistException
     */
    public void removeUser(UserVO userVO) throws UserDoesNotExistException
    {
        if (userVO == null)
        {
            throw new IllegalArgumentException("org.andromda.timetracker.service.UserServiceBean.removeUser(UserVO userVO) - 'userVO' can not be null");
        }
        try
        {
            this.handleRemoveUser(userVO);
        }
        catch (UserDoesNotExistException ex)
        {
            throw ex;
        }
        catch (Throwable th)
        {
            throw new UserServiceException("Error performing 'UserService.removeUser(UserVO userVO)' --> " + th, th);
        }
    }

    /**
     * Performs the core logic for {@link #removeUser(UserVO)}
     * @param userVO
     * @throws Exception
     */
    protected abstract void handleRemoveUser(UserVO userVO) throws Exception;


    // -------- Lifecycle Callbacks --------------

}
