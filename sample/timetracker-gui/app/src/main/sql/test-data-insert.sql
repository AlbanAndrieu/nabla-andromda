-- SEE instead core/src/main/resources/import.sql
insert into TIMECARD (ID, STATUS, START_DATE, COMMENTS, APPROVER, SUBMITTER) values ( 1, 'APPROVED',  PARSEDATETIME('2011-05-15', 'yyyy-MM-dd'), 'Timecard 01', 1, 2);
insert into TIMECARD (ID, STATUS, START_DATE, COMMENTS, APPROVER, SUBMITTER) values ( 2, 'APPROVED',  PARSEDATETIME('2011-05-15', 'yyyy-MM-dd'), 'Timecard 02', 2, 3);
insert into TIMECARD (ID, STATUS, START_DATE, COMMENTS, APPROVER, SUBMITTER) values ( 3, 'APPROVED',  PARSEDATETIME('2011-05-15', 'yyyy-MM-dd'), 'Timecard 03', 3, 4);
insert into TIMECARD (ID, STATUS, START_DATE, COMMENTS, APPROVER, SUBMITTER) values ( 4, 'APPROVED',  PARSEDATETIME('2011-05-15', 'yyyy-MM-dd'), 'Timecard 04', 4, 1);

insert into TIMECARD (ID, STATUS, START_DATE, COMMENTS, APPROVER, SUBMITTER) values ( 5, 'REJECTED',  PARSEDATETIME('2011-05-22', 'yyyy-MM-dd'), 'Timecard 05', 1, 2);
insert into TIMECARD (ID, STATUS, START_DATE, COMMENTS, APPROVER, SUBMITTER) values ( 6, 'REJECTED',  PARSEDATETIME('2011-05-22', 'yyyy-MM-dd'), 'Timecard 06', 2, 3);
insert into TIMECARD (ID, STATUS, START_DATE, COMMENTS, APPROVER, SUBMITTER) values ( 7, 'REJECTED',  PARSEDATETIME('2011-05-22', 'yyyy-MM-dd'), 'Timecard 07', 3, 4);
insert into TIMECARD (ID, STATUS, START_DATE, COMMENTS, APPROVER, SUBMITTER) values ( 8, 'REJECTED',  PARSEDATETIME('2011-05-22', 'yyyy-MM-dd'), 'Timecard 08', 4, 1);

insert into TIMECARD (ID, STATUS, START_DATE, COMMENTS, APPROVER, SUBMITTER) values ( 9, 'SUBMITTED', PARSEDATETIME('2011-05-29', 'yyyy-MM-dd'), 'Timecard 09', 1, 2);
insert into TIMECARD (ID, STATUS, START_DATE, COMMENTS, APPROVER, SUBMITTER) values (10, 'SUBMITTED', PARSEDATETIME('2011-05-29', 'yyyy-MM-dd'), 'Timecard 10', 2, 3);
insert into TIMECARD (ID, STATUS, START_DATE, COMMENTS, APPROVER, SUBMITTER) values (11, 'SUBMITTED', PARSEDATETIME('2011-05-29', 'yyyy-MM-dd'), 'Timecard 11', 3, 4);
insert into TIMECARD (ID, STATUS, START_DATE, COMMENTS, APPROVER, SUBMITTER) values (12, 'SUBMITTED', PARSEDATETIME('2011-05-29', 'yyyy-MM-dd'), 'Timecard 12', 4, 1);

insert into TIMECARD (ID, STATUS, START_DATE, COMMENTS, APPROVER, SUBMITTER) values (13, 'DRAFT',     PARSEDATETIME('2011-06-05', 'yyyy-MM-dd'), 'Timecard 13', null, 2);
insert into TIMECARD (ID, STATUS, START_DATE, COMMENTS, APPROVER, SUBMITTER) values (14, 'DRAFT',     PARSEDATETIME('2011-06-05', 'yyyy-MM-dd'), 'Timecard 14', null, 3);
insert into TIMECARD (ID, STATUS, START_DATE, COMMENTS, APPROVER, SUBMITTER) values (15, 'DRAFT',     PARSEDATETIME('2011-06-05', 'yyyy-MM-dd'), 'Timecard 15', null, 4);
insert into TIMECARD (ID, STATUS, START_DATE, COMMENTS, APPROVER, SUBMITTER) values (16, 'DRAFT',     PARSEDATETIME('2011-06-05', 'yyyy-MM-dd'), 'Timecard 16', null, 1);

commit;

insert into TIME_ALLOCATION (ID, TIME_PERIOD_START_TIME, TIME_PERIOD_END_TIME, TASK, TIMECARD) values ( 1, PARSEDATETIME('2011-05-15 09:00', 'yyyy-MM-dd hh:mm'), PARSEDATETIME('2011-05-15 05:00', 'yyyy-MM-dd hh:mm'), 1,  1);
insert into TIME_ALLOCATION (ID, TIME_PERIOD_START_TIME, TIME_PERIOD_END_TIME, TASK, TIMECARD) values ( 2, PARSEDATETIME('2011-05-16 09:00', 'yyyy-MM-dd hh:mm'), PARSEDATETIME('2011-05-16 05:00', 'yyyy-MM-dd hh:mm'), 1,  1);
insert into TIME_ALLOCATION (ID, TIME_PERIOD_START_TIME, TIME_PERIOD_END_TIME, TASK, TIMECARD) values ( 3, PARSEDATETIME('2011-05-15 09:00', 'yyyy-MM-dd hh:mm'), PARSEDATETIME('2011-05-15 05:00', 'yyyy-MM-dd hh:mm'), 2,  2);
insert into TIME_ALLOCATION (ID, TIME_PERIOD_START_TIME, TIME_PERIOD_END_TIME, TASK, TIMECARD) values ( 4, PARSEDATETIME('2011-05-16 09:00', 'yyyy-MM-dd hh:mm'), PARSEDATETIME('2011-05-16 05:00', 'yyyy-MM-dd hh:mm'), 2,  2);
insert into TIME_ALLOCATION (ID, TIME_PERIOD_START_TIME, TIME_PERIOD_END_TIME, TASK, TIMECARD) values ( 5, PARSEDATETIME('2011-05-15 09:00', 'yyyy-MM-dd hh:mm'), PARSEDATETIME('2011-05-15 05:00', 'yyyy-MM-dd hh:mm'), 3,  3);
insert into TIME_ALLOCATION (ID, TIME_PERIOD_START_TIME, TIME_PERIOD_END_TIME, TASK, TIMECARD) values ( 6, PARSEDATETIME('2011-05-16 09:00', 'yyyy-MM-dd hh:mm'), PARSEDATETIME('2011-05-16 05:00', 'yyyy-MM-dd hh:mm'), 3,  3);
insert into TIME_ALLOCATION (ID, TIME_PERIOD_START_TIME, TIME_PERIOD_END_TIME, TASK, TIMECARD) values ( 7, PARSEDATETIME('2011-05-15 09:00', 'yyyy-MM-dd hh:mm'), PARSEDATETIME('2011-05-15 05:00', 'yyyy-MM-dd hh:mm'), 4,  4);
insert into TIME_ALLOCATION (ID, TIME_PERIOD_START_TIME, TIME_PERIOD_END_TIME, TASK, TIMECARD) values ( 8, PARSEDATETIME('2011-05-16 09:00', 'yyyy-MM-dd hh:mm'), PARSEDATETIME('2011-05-16 05:00', 'yyyy-MM-dd hh:mm'), 4,  4);

insert into TIME_ALLOCATION (ID, TIME_PERIOD_START_TIME, TIME_PERIOD_END_TIME, TASK, TIMECARD) values (11, PARSEDATETIME('2011-05-22 09:00', 'yyyy-MM-dd hh:mm'), PARSEDATETIME('2011-05-22 05:00', 'yyyy-MM-dd hh:mm'), 5,  5);
insert into TIME_ALLOCATION (ID, TIME_PERIOD_START_TIME, TIME_PERIOD_END_TIME, TASK, TIMECARD) values (12, PARSEDATETIME('2011-05-23 09:00', 'yyyy-MM-dd hh:mm'), PARSEDATETIME('2011-05-23 05:00', 'yyyy-MM-dd hh:mm'), 5,  5);
insert into TIME_ALLOCATION (ID, TIME_PERIOD_START_TIME, TIME_PERIOD_END_TIME, TASK, TIMECARD) values (13, PARSEDATETIME('2011-05-22 09:00', 'yyyy-MM-dd hh:mm'), PARSEDATETIME('2011-05-22 05:00', 'yyyy-MM-dd hh:mm'), 1,  6);
insert into TIME_ALLOCATION (ID, TIME_PERIOD_START_TIME, TIME_PERIOD_END_TIME, TASK, TIMECARD) values (14, PARSEDATETIME('2011-05-23 09:00', 'yyyy-MM-dd hh:mm'), PARSEDATETIME('2011-05-23 05:00', 'yyyy-MM-dd hh:mm'), 1,  6);
insert into TIME_ALLOCATION (ID, TIME_PERIOD_START_TIME, TIME_PERIOD_END_TIME, TASK, TIMECARD) values (15, PARSEDATETIME('2011-05-22 09:00', 'yyyy-MM-dd hh:mm'), PARSEDATETIME('2011-05-22 05:00', 'yyyy-MM-dd hh:mm'), 2,  7);
insert into TIME_ALLOCATION (ID, TIME_PERIOD_START_TIME, TIME_PERIOD_END_TIME, TASK, TIMECARD) values (16, PARSEDATETIME('2011-05-23 09:00', 'yyyy-MM-dd hh:mm'), PARSEDATETIME('2011-05-23 05:00', 'yyyy-MM-dd hh:mm'), 2,  7);
insert into TIME_ALLOCATION (ID, TIME_PERIOD_START_TIME, TIME_PERIOD_END_TIME, TASK, TIMECARD) values (17, PARSEDATETIME('2011-05-22 09:00', 'yyyy-MM-dd hh:mm'), PARSEDATETIME('2011-05-22 05:00', 'yyyy-MM-dd hh:mm'), 3,  8);
insert into TIME_ALLOCATION (ID, TIME_PERIOD_START_TIME, TIME_PERIOD_END_TIME, TASK, TIMECARD) values (18, PARSEDATETIME('2011-05-23 09:00', 'yyyy-MM-dd hh:mm'), PARSEDATETIME('2011-05-23 05:00', 'yyyy-MM-dd hh:mm'), 3,  8);

insert into TIME_ALLOCATION (ID, TIME_PERIOD_START_TIME, TIME_PERIOD_END_TIME, TASK, TIMECARD) values (21, PARSEDATETIME('2011-05-29 09:00', 'yyyy-MM-dd hh:mm'), PARSEDATETIME('2011-05-29 05:00', 'yyyy-MM-dd hh:mm'), 4,  9);
insert into TIME_ALLOCATION (ID, TIME_PERIOD_START_TIME, TIME_PERIOD_END_TIME, TASK, TIMECARD) values (22, PARSEDATETIME('2011-05-30 09:00', 'yyyy-MM-dd hh:mm'), PARSEDATETIME('2011-05-30 05:00', 'yyyy-MM-dd hh:mm'), 4,  9);
insert into TIME_ALLOCATION (ID, TIME_PERIOD_START_TIME, TIME_PERIOD_END_TIME, TASK, TIMECARD) values (23, PARSEDATETIME('2011-05-29 09:00', 'yyyy-MM-dd hh:mm'), PARSEDATETIME('2011-05-29 05:00', 'yyyy-MM-dd hh:mm'), 5, 10);
insert into TIME_ALLOCATION (ID, TIME_PERIOD_START_TIME, TIME_PERIOD_END_TIME, TASK, TIMECARD) values (24, PARSEDATETIME('2011-05-30 09:00', 'yyyy-MM-dd hh:mm'), PARSEDATETIME('2011-05-30 05:00', 'yyyy-MM-dd hh:mm'), 5, 10);
insert into TIME_ALLOCATION (ID, TIME_PERIOD_START_TIME, TIME_PERIOD_END_TIME, TASK, TIMECARD) values (25, PARSEDATETIME('2011-05-29 09:00', 'yyyy-MM-dd hh:mm'), PARSEDATETIME('2011-05-29 05:00', 'yyyy-MM-dd hh:mm'), 1, 11);
insert into TIME_ALLOCATION (ID, TIME_PERIOD_START_TIME, TIME_PERIOD_END_TIME, TASK, TIMECARD) values (26, PARSEDATETIME('2011-05-30 09:00', 'yyyy-MM-dd hh:mm'), PARSEDATETIME('2011-05-30 05:00', 'yyyy-MM-dd hh:mm'), 1, 11);
insert into TIME_ALLOCATION (ID, TIME_PERIOD_START_TIME, TIME_PERIOD_END_TIME, TASK, TIMECARD) values (27, PARSEDATETIME('2011-05-29 09:00', 'yyyy-MM-dd hh:mm'), PARSEDATETIME('2011-05-29 05:00', 'yyyy-MM-dd hh:mm'), 2, 12);
insert into TIME_ALLOCATION (ID, TIME_PERIOD_START_TIME, TIME_PERIOD_END_TIME, TASK, TIMECARD) values (28, PARSEDATETIME('2011-05-30 09:00', 'yyyy-MM-dd hh:mm'), PARSEDATETIME('2011-05-30 05:00', 'yyyy-MM-dd hh:mm'), 2, 12);

insert into TIME_ALLOCATION (ID, TIME_PERIOD_START_TIME, TIME_PERIOD_END_TIME, TASK, TIMECARD) values (29, PARSEDATETIME('2011-06-05 09:00', 'yyyy-MM-dd hh:mm'), PARSEDATETIME('2011-06-05 05:00', 'yyyy-MM-dd hh:mm'), 3, 13);
insert into TIME_ALLOCATION (ID, TIME_PERIOD_START_TIME, TIME_PERIOD_END_TIME, TASK, TIMECARD) values (30, PARSEDATETIME('2011-06-06 09:00', 'yyyy-MM-dd hh:mm'), PARSEDATETIME('2011-06-06 05:00', 'yyyy-MM-dd hh:mm'), 3, 13);
insert into TIME_ALLOCATION (ID, TIME_PERIOD_START_TIME, TIME_PERIOD_END_TIME, TASK, TIMECARD) values (31, PARSEDATETIME('2011-06-05 09:00', 'yyyy-MM-dd hh:mm'), PARSEDATETIME('2011-06-05 05:00', 'yyyy-MM-dd hh:mm'), 4, 14);
insert into TIME_ALLOCATION (ID, TIME_PERIOD_START_TIME, TIME_PERIOD_END_TIME, TASK, TIMECARD) values (32, PARSEDATETIME('2011-06-06 09:00', 'yyyy-MM-dd hh:mm'), PARSEDATETIME('2011-06-06 05:00', 'yyyy-MM-dd hh:mm'), 4, 14);
insert into TIME_ALLOCATION (ID, TIME_PERIOD_START_TIME, TIME_PERIOD_END_TIME, TASK, TIMECARD) values (33, PARSEDATETIME('2011-06-05 09:00', 'yyyy-MM-dd hh:mm'), PARSEDATETIME('2011-06-05 05:00', 'yyyy-MM-dd hh:mm'), 5, 15);
insert into TIME_ALLOCATION (ID, TIME_PERIOD_START_TIME, TIME_PERIOD_END_TIME, TASK, TIMECARD) values (34, PARSEDATETIME('2011-06-06 09:00', 'yyyy-MM-dd hh:mm'), PARSEDATETIME('2011-06-06 05:00', 'yyyy-MM-dd hh:mm'), 5, 15);
insert into TIME_ALLOCATION (ID, TIME_PERIOD_START_TIME, TIME_PERIOD_END_TIME, TASK, TIMECARD) values (35, PARSEDATETIME('2011-06-05 09:00', 'yyyy-MM-dd hh:mm'), PARSEDATETIME('2011-06-05 05:00', 'yyyy-MM-dd hh:mm'), 1, 16);
insert into TIME_ALLOCATION (ID, TIME_PERIOD_START_TIME, TIME_PERIOD_END_TIME, TASK, TIMECARD) values (36, PARSEDATETIME('2011-06-06 09:00', 'yyyy-MM-dd hh:mm'), PARSEDATETIME('2011-06-06 05:00', 'yyyy-MM-dd hh:mm'), 1, 16);

commit;