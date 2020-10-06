// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by SessionBeanBase.vsl in andromda-ejb3-cartridge.
//
package org.andromda.timetracker.service;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.andromda.timetracker.domain.UserDao;
import org.andromda.timetracker.vo.UserDetailsVO;

/**
 * Autogenerated EJB3 session bean base class SecurityServiceBean which contains
 * method level annotations for the session bean.  All method level annotations
 * are inherited by the extending session bean class.
 * TODO: Model Documentation for SecurityService
 */
public abstract class SecurityServiceBase implements SecurityService
{

    // ------ Session Context Injection ------

    /**
     * SessionContext Injection
     */
    @Resource
    protected SessionContext context;

    // ------ Persistence Context Definitions --------
    /**
     * Inject persistence context timetracker-ejb3
     */
    @PersistenceContext(unitName = "timetracker-ejb3")
    protected EntityManager emanager;


    // ------ DAO Injection Definitions --------

    /**
     * Inject DAO UserDao
     */
    @EJB
    private UserDao userDao;

    // --------------- Constructors ---------------

    /**
     * Default constructor method with no arguments.
     */
    public SecurityServiceBase()
    {
        super();
    }

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
     * TODO: Model Documentation for SecurityService.getUserDetails
     * @param username
     * @return UserDetailsVO
     */
    public UserDetailsVO getUserDetails(String username)    {
        if (username == null)
        {
            throw new IllegalArgumentException("org.andromda.timetracker.service.SecurityServiceBean.getUserDetails(String username) - 'username' can not be null");
        }
        try
        {
            return this.handleGetUserDetails(username);
        }
        catch (Throwable th)
        {
            throw new SecurityServiceException("Error performing 'SecurityService.getUserDetails(String username)' --> " + th, th);
        }
    }

    /**
     * Performs the core logic for {@link #getUserDetails(String)}
     * @param username
     * @return UserDetailsVO
     * @throws Exception
     */
    protected abstract UserDetailsVO handleGetUserDetails(String username) throws Exception;


    // -------- Lifecycle Callbacks --------------

}