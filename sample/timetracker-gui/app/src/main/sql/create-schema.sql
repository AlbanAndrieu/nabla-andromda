/* Generated by AndroMDA do not edit! */
/* Run this script as the schema owner to create all schema objects */

SET echo ON;

WHENEVER SQLERROR CONTINUE;
WHENEVER OSERROR  EXIT;

@create-table-User.sql
@create-table-Task.sql
@create-table-TimeAllocation.sql
@create-table-Timecard.sql
@create-table-UserRole.sql
@create-table-Movie.sql
@create-table-roles2users.sql
@create-table-groups2roles.sql

@create-foreign-keys.sql
@create-sequences.sql

exit;
