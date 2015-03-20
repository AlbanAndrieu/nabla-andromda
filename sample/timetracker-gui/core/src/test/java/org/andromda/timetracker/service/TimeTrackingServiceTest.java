package org.andromda.timetracker.service;

import java.util.Formatter;
import org.andromda.timetracker.ServiceLocator;
import org.andromda.timetracker.vo.TimecardSearchCriteriaVO;
import org.andromda.timetracker.vo.TimecardSummaryVO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 *
 */
public class TimeTrackingServiceTest
{
    private static String       TimecardHdrFormat = "%-13s %-13s %-10s %-11s";
    private static String       TimecardRowFormat = "%-13s %-13s %-10s %-11tD";

    private Log                 logger            = LogFactory.getLog(TimeTrackingServiceTest.class);
    private TimeTrackingService timeTrackingService;

    /**
     * Initialize test suite
     */
    @BeforeSuite
    public void initializeTestSuite()
    {

        // Initialize ServiceLocator
        this.logger.info("Initializing ServiceLocator");
        ServiceLocator locator = ServiceLocator.instance();
        locator.init("testBeanRefFactory.xml", "beanRefFactory");

        // Initialize TimeTrackingService
        this.logger.info("Initializing TimeTrackingService");
        this.timeTrackingService = locator.getTimeTrackingService();
    }

    /**
     *
     */
    @Test
    public void testFindAllTimecards()
    {
        this.logger.info("testFindAllTimecards:");
        TimecardSearchCriteriaVO criteria = new TimecardSearchCriteriaVO();
        // Collection<? extends TimecardSummaryVO> timecards = this.timeTrackingService.findTimecards(criteria);
        TimecardSummaryVO[] timecards = this.timeTrackingService.findTimecards(criteria);
        logTimecards(timecards);
    }

    /**
     *
     */
    @Test
    public void testFindTimecardsForSubmitter()
    {
        this.logger.info("testFindTimecardsForSubmitter:");
        TimecardSearchCriteriaVO criteria = new TimecardSearchCriteriaVO();
        criteria.setSubmitterId(new Long(1));
        // Collection<? extends TimecardSummaryVO> timecards = this.timeTrackingService.findTimecards(criteria);
        TimecardSummaryVO[] timecards = this.timeTrackingService.findTimecards(criteria);
        logTimecards(timecards);
    }

    private void logTimecards(TimecardSummaryVO[] timecards)
    // private void logTimecards(Collection<? extends TimecardSummaryVO> timecards)
    {
        Formatter formatter = new Formatter();
        formatter.format(TimecardHdrFormat, "Submitter", "Approver", "Status", "Start Date");
        this.logger.info(formatter.toString());
        // for (TimecardSummaryVO timecard : timecards)
        for (int i = 0; i < timecards.length; i++)
        {
            formatter = new Formatter();
            formatter.format(TimecardRowFormat, timecards[i].getSubmitterName(), timecards[i].getApproverName(), timecards[i].getStatus(), timecards[i].getStartDate());
            this.logger.info(formatter.toString());
        }
    }
}
