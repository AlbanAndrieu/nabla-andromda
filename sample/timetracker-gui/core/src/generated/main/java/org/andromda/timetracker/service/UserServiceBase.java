// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SpringServiceBase.vsl in andromda-spring-cartridge.
//
/**
 * TEMPLATE:    SpringServiceBase.vsl in andromda-spring cartridge
 * MODEL CLASS: TimeTracker::TimeTracker::org.andromda.timetracker::service::UserService
 * STEREOTYPE:  Seam
 * STEREOTYPE:  Service
 */
package org.andromda.timetracker.service;

import java.security.Principal;
import java.util.List;
import java.util.Locale;
import org.andromda.timetracker.BeanLocator;
import org.andromda.timetracker.PrincipalStore;
import org.andromda.timetracker.domain.User;
import org.andromda.timetracker.domain.UserDao;
import org.andromda.timetracker.vo.UserDetailsVO;
import org.andromda.timetracker.vo.UserVO;
import org.springframework.context.MessageSource;

/**
 * <p>
 * Spring Service base class for <code>UserService</code>,
 * provides access to all services and entities referenced by this service.
 * </p>
 *
 * @see UserService
 */
public abstract class UserServiceBase
    implements UserService
{
    /**
     * TODO: Model Documentation for UserService.logger
     */
    private Object logger;

    /**
     * Getter for logger
     * @return Value of logger
     */
    protected Object getLogger()
    {
        return this.logger;
    }
    /**
     * Setter for logger
     * @param loggerIn New value for logger
     */
    protected void setLogger(Object loggerIn)
    {
        this.logger = loggerIn;
    }

    /**
     * TODO: Model Documentation for UserService.user
     */
    private User user;

    /**
     * Getter for user
     * @return Value of user
     */
    public User getUser()
    {
        return this.user;
    }
    /**
     * Setter for user
     * @param userIn New value for user
     */
    public void setUser(User userIn)
    {
        this.user = userIn;
    }

    /**
     * TODO: Model Documentation for UserService.userList
     */
    private List<User> userList;

    /**
     * Getter for userList
     * @return Value of userList
     */
    public List<User> getUserList()
    {
        return this.userList;
    }
    /**
     * Setter for userList
     * @param userListIn New value for userList
     */
    public void setUserList(List<User> userListIn)
    {
        this.userList = userListIn;
    }

    private UserDao userDao;

    /**
     * Sets the reference to <code>user</code>'s DAO.
     * @param userDaoIn
     */
    public void setUserDao(UserDao userDaoIn)
    {
        this.userDao = userDaoIn;
    }

    /**
     * Gets the reference to <code>user</code>'s DAO.
     * @return userDao
     */
    protected UserDao getUserDao()
    {
        return this.userDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserVO[] getAllUsers()
        throws UserDoesNotExistException
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
            throw new UserServiceException(
                "Error performing 'UserService.getAllUsers()' --> " + th,
                th);
        }
    }

    /**
     * Performs the core logic for {@link #getAllUsers()}
     * @return UserVO[]
     * @throws Exception
     */
    protected abstract UserVO[] handleGetAllUsers()
        throws Exception;

    /**
     * {@inheritDoc}
     */
    @Override
    public UserVO getUser(final String username)
        throws UserDoesNotExistException
    {
        if (username == null || username.trim().length() == 0)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.service.UserService.getUser(String username) - 'username' can not be null or empty");
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
            throw new UserServiceException(
                "Error performing 'UserService.getUser(String username)' --> " + th,
                th);
        }
    }

    /**
     * Performs the core logic for {@link #getUser(String)}
     * @param username String TODO: Model Documentation for UserService.getUser(username)
     * @return UserVO
     * @throws Exception
     */
    protected abstract UserVO handleGetUser(String username)
        throws Exception;

    /**
     * {@inheritDoc}
     */
    @Override
    public UserDetailsVO registerUser(final UserDetailsVO userDetailVO)
        throws UserDoesNotExistException
    {
        if (userDetailVO == null)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.service.UserService.registerUser(UserDetailsVO userDetailVO) - 'userDetailVO' can not be null");
        }
        if (userDetailVO.getPassword() == null || userDetailVO.getPassword().trim().length() == 0)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.service.UserService.registerUser(UserDetailsVO userDetailVO) - 'userDetailVO.password' can not be null or empty");
        }
        if (userDetailVO.getEmail() == null || userDetailVO.getEmail().trim().length() == 0)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.service.UserService.registerUser(UserDetailsVO userDetailVO) - 'userDetailVO.email' can not be null or empty");
        }
        if (userDetailVO.getCreationDate() == null)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.service.UserService.registerUser(UserDetailsVO userDetailVO) - 'userDetailVO.creationDate' can not be null");
        }
        if (userDetailVO.getRoles() == null)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.service.UserService.registerUser(UserDetailsVO userDetailVO) - 'userDetailVO.roles' can not be null");
        }
        if (userDetailVO.getUsername() == null || userDetailVO.getUsername().trim().length() == 0)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.service.UserService.registerUser(UserDetailsVO userDetailVO) - 'userDetailVO.username' can not be null or empty");
        }
        if (userDetailVO.getFirstName() == null || userDetailVO.getFirstName().trim().length() == 0)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.service.UserService.registerUser(UserDetailsVO userDetailVO) - 'userDetailVO.firstName' can not be null or empty");
        }
        if (userDetailVO.getLastName() == null || userDetailVO.getLastName().trim().length() == 0)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.service.UserService.registerUser(UserDetailsVO userDetailVO) - 'userDetailVO.lastName' can not be null or empty");
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
            throw new UserServiceException(
                "Error performing 'UserService.registerUser(UserDetailsVO userDetailVO)' --> " + th,
                th);
        }
    }

    /**
     * Performs the core logic for {@link #registerUser(UserDetailsVO)}
     * @param userDetailVO UserDetailsVO TODO: Model Documentation for
UserService.registerUser(userDetailVO)
     * @return UserDetailsVO
     * @throws Exception
     */
    protected abstract UserDetailsVO handleRegisterUser(UserDetailsVO userDetailVO)
        throws Exception;

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeUser(final UserVO userVO)
        throws UserDoesNotExistException
    {
        if (userVO == null)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.service.UserService.removeUser(UserVO userVO) - 'userVO' can not be null");
        }
        if (userVO.getUsername() == null || userVO.getUsername().trim().length() == 0)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.service.UserService.removeUser(UserVO userVO) - 'userVO.username' can not be null or empty");
        }
        if (userVO.getFirstName() == null || userVO.getFirstName().trim().length() == 0)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.service.UserService.removeUser(UserVO userVO) - 'userVO.firstName' can not be null or empty");
        }
        if (userVO.getLastName() == null || userVO.getLastName().trim().length() == 0)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.service.UserService.removeUser(UserVO userVO) - 'userVO.lastName' can not be null or empty");
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
            throw new UserServiceException(
                "Error performing 'UserService.removeUser(UserVO userVO)' --> " + th,
                th);
        }
    }

    /**
     * Performs the core logic for {@link #removeUser(UserVO)}
     * @param userVO UserVO TODO: Model Documentation for UserService.removeUser(userVO)
     * @return void
     * @throws Exception
     */
    protected abstract void handleRemoveUser(UserVO userVO)
        throws Exception;

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
     * Gets the message source available to this service.
     * @return MessageSource
     */
    protected MessageSource getMessages()
    {
        return (MessageSource)
            BeanLocator.instance().getBean("messageSource");
    }

    /**
     * Gets the message having the given <code>key</code> in the underlying message bundle.
     *
     * @param key the key of the message in the messages.properties message bundle.
     * @return String
     */
    protected String getMessage(final String key)
    {
        return this.getMessages().getMessage(key, null, null);
    }

    /**
     * Gets the message having the given <code>key</code> and <code>arguments</code> in the
     * underlying message bundle.
     *
     * @param key the key of the message in the messages.properties message bundle.
     * @param arguments any arguments to substitute when resolving the message.
     * @return String
     */
    protected String getMessage(final String key, final Object[] arguments)
    {
        return this.getMessages().getMessage(key, arguments, null);
    }

    /**
     * Gets the message having the given <code>key</code> using the given <code>arguments</code>
     * for the given <code>locale</code>.
     *
     * @param key the key of the message in the messages.properties message bundle.
     * @param arguments any arguments to substitute when resolving the message.
     * @param locale the locale of the messages to retrieve.
     * @return String
     */
    protected String getMessage(
        final String key, final Object[] arguments,
        final Locale locale)
    {
        return this.getMessages().getMessage(key, arguments, locale);
    }

}
