// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by SessionRemote.vsl in andromda-ejb3-cartridge.
//
package org.andromda.timetracker.service;

import org.andromda.timetracker.vo.UserDetailsVO;
import org.andromda.timetracker.vo.UserVO;

/**
 * Remote component interface for the UserServiceBean session bean.
 *
 * The service that implement this business interface is a Seam component.  The cartridge
 * will not expose this interface as a Remote business interface for the bean
 * component. Seam components will only have a Local business interface.
 *
 * TODO: Model Documentation for org.andromda.timetracker.service.UserService
 *
 */
public interface UserServiceRemote extends UserService
{

    // ------------ Business Methods  -----------------

    /**
     * TODO: Model Documentation for org.andromda.timetracker.service.UserService.getAllUsers
     * @return UserVO[]
     * @throws UserDoesNotExistException
     */
    public UserVO[] getAllUsers() throws UserDoesNotExistException;

    /**
     * TODO: Model Documentation for org.andromda.timetracker.service.UserService.getUser
     * @param username
     * @return UserVO
     * @throws UserDoesNotExistException
     */
    public UserVO getUser(String username) throws UserDoesNotExistException;

    /**
     * TODO: Model Documentation for org.andromda.timetracker.service.UserService.registerUser
     * @param userDetailVO
     * @return UserDetailsVO
     * @throws UserDoesNotExistException
     */
    public UserDetailsVO registerUser(UserDetailsVO userDetailVO) throws UserDoesNotExistException;

    /**
     * TODO: Model Documentation for org.andromda.timetracker.service.UserService.removeUser
     * @param userVO
     * @throws UserDoesNotExistException
     */
    public void removeUser(UserVO userVO) throws UserDoesNotExistException;

}