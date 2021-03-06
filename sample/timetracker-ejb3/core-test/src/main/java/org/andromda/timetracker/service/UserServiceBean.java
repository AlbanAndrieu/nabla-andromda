// license-header java merge-point
//
// Generated by SessionBeanImpl.vsl in andromda-ejb3-cartridge on 03/29/2012 12:08:34.
//
package org.andromda.timetracker.service;

import java.util.Collection;

import javax.ejb.Stateful;

import org.andromda.timetracker.domain.User;
import org.andromda.timetracker.domain.UserDao;
import org.andromda.timetracker.domain.UserDaoException;
import org.andromda.timetracker.vo.UserDetailsVO;
import org.andromda.timetracker.vo.UserVO;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.faces.FacesMessages;

/**
 * @see UserServiceBase
 * Remember to manually configure the local business interface this bean implements if originally you only
 * defined the remote business interface. However, this change is automatically reflected in the ejb-jar.xml.
 * Do not specify the javax.ejb.Stateless annotation
 * Instead, the session bean is defined in the ejb-jar.xml descriptor.
 */
// Uncomment to enable webservices for UserServiceBean
// @javax.jws.WebService(endpointInterface = "org.andromda.timetracker.service.UserServiceWSInterface", serviceName = "UserService")
// Comment to enable jboss embedded tests for UserServiceBean
@Stateful
// @Scope(ScopeType.CONVERSATION)
// @Scope(ScopeType.EVENT)
@Name("userService")
// @Interceptors(SeamInterceptor.class)
public class UserServiceBean extends UserServiceBase implements UserServiceLocal, UserServiceRemote
{

    // --------------- Constructors ---------------

    /**
     * Default constructor extending base class default constructor
     */
    public UserServiceBean()
    {
        super();
    }

    // -------- Business Methods Impl --------------

    /**
     * @see UserServiceBase#getAllUsers()
     */
    @Override
    protected UserVO[] handleGetAllUsers() throws Exception
    {
        Collection<UserVO> userVOs = null;
        try
        {
            userVOs = this.getUserDao().loadAll(UserDao.TRANSFORM_USERVO);
            // this.userList = (List<User>) this.getUserDao().loadAll(UserDao.TRANSFORM_NONE);
        } catch (final UserDaoException ex)
        {
            // FacesMessages.instance().addToControl("user", StatusMessage.Severity.ERROR, "User not found on database.", (Object[]) null);
            FacesMessages.instance().addToControl("user", "User not found on database.", (Object[]) null);
            this.logger.debug("Empty person list");
        }
        return userVOs.toArray(new UserVO[userVOs.size()]);
    }

    /**
     * @see UserServiceBase#getUser(String)
     */
    @Override
    protected UserVO handleGetUser(final String username) throws Exception
    {
        try
        {
            final User user = this.getUserDao().getUserDetails(username);
            return this.getUserDao().toUserVO(user);
        } catch (final Exception ex)
        {
            throw new UserDoesNotExistException("User : " + username + " does not exist");
        }
    }

    /**
     * @see UserServiceBase#registerUser(UserDetailsVO)
     */
    @Override
    protected UserDetailsVO handleRegisterUser(final UserDetailsVO userDetailVO) throws Exception
    {
        User user = this.getUserDao().userDetailsVOToEntity(userDetailVO);
        user = this.getUserDao().create(user);
        return this.getUserDao().toUserDetailsVO(user);
    }

    /**
     * @see UserServiceBase#removeUser(UserVO)
     */
    @Override
    protected void handleRemoveUser(final UserVO userVO) throws Exception
    {
        this.getUserDao().remove(userVO.getId());
    }

    // -------- Lifecycle Callback Implementation --------------

}
