// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SpringService.vsl in andromda-spring-cartridge.
//
/**
 * TEMPLATE:    SpringService.vsl in andromda-spring cartridge
 * MODEL CLASS: TimeTracker::TimeTracker::org.andromda.timetracker::service::SecurityService
 * STEREOTYPE:  Service
 */
package org.andromda.timetracker.service;

import org.andromda.timetracker.vo.UserDetailsVO;

/**
 * TODO: Model Documentation for org.andromda.timetracker.service.SecurityService
 */
public interface SecurityService
{
    /**
     * TODO: Model Documentation for org.andromda.timetracker.service.SecurityService.getUserDetails
     * @param username TODO: Model Documentation for
org.andromda.timetracker.service.SecurityService.getUserDetails(username)
     * @return  UserDetailsVO
     */
    public UserDetailsVO getUserDetails(String username);

}
