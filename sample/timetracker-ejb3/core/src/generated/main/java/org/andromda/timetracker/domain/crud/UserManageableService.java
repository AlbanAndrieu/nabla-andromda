// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by crud/ManageableServiceRemote.vsl in andromda-ejb3-cartridge.
//
package org.andromda.timetracker.domain.crud;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Manageable service bean remote interface
 */
public interface UserManageableService
{
    public UserVO create(String username, String password, String firstName, String lastName, String email, boolean isEnable, Date creationDate, String comment, Long id, Long[] roles)
        throws UserCreateManageableException;


    public UserVO readById(Long id)
        throws UserReadManageableException;

    public List read(String username, String password, String firstName, String lastName, String email, boolean isEnable, Date creationDate, String comment, Long id, Long[] roles)
        throws UserReadManageableException;

    public List readAll()
        throws UserReadManageableException;

    public Map readBackingLists()
        throws UserReadManageableException;

    public UserVO update(String username, String password, String firstName, String lastName, String email, boolean isEnable, Date creationDate, String comment, Long id, Long[] roles)
        throws UserUpdateManageableException;

    public void delete(Long[] ids)
        throws UserDeleteManageableException;

}