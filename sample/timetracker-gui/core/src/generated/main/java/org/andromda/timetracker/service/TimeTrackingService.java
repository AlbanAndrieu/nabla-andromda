// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SpringService.vsl in andromda-spring-cartridge.
//
/**
 * TEMPLATE:    SpringService.vsl in andromda-spring cartridge
 * MODEL CLASS: TimeTracker::TimeTracker::org.andromda.timetracker::service::TimeTrackingService
 * STEREOTYPE:  Service
 */
package org.andromda.timetracker.service;

import org.andromda.timetracker.vo.TimecardSearchCriteriaVO;
import org.andromda.timetracker.vo.TimecardSummaryVO;

/**
 * TODO: Model Documentation for org.andromda.timetracker.service.TimeTrackingService
 */
public interface TimeTrackingService
{
    /**
     * TODO: Model Documentation for
     * org.andromda.timetracker.service.TimeTrackingService.findTimecards
     * @param criteria TODO: Model Documentation for
org.andromda.timetracker.service.TimeTrackingService.findTimecards(criteria)
     * @return  TimecardSummaryVO[]
     */
    public TimecardSummaryVO[] findTimecards(TimecardSearchCriteriaVO criteria);

}
