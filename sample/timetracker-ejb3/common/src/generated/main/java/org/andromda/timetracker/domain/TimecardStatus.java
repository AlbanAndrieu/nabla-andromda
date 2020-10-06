// license-header java merge-point
/* Autogenerated by AndroMDA Enumeration.vsl in andromda-ejb3-cartridge - do not edit */
package org.andromda.timetracker.domain;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Autogenerated enumeration TimecardStatus.
 *
 * This class enumerates the three states a timecard can be in.
 */
public enum TimecardStatus
{
    /** TODO: Model Documentation for Enumeration Literal DRAFT value "Draft" */
    DRAFT("Draft"),

    /** TODO: Model Documentation for Enumeration Literal SUBMITTED value "Submitted" */
    SUBMITTED("Submitted"),

    /** TODO: Model Documentation for Enumeration Literal APPROVED value "Approved" */
    APPROVED("Approved"),

    /** TODO: Model Documentation for Enumeration Literal REJECTED value "Rejected" */
    REJECTED("Rejected");

    /**
     * The serial version UID of this class. Needed for serialization.
     */
    private static final long serialVersionUID = 3912146933603416362L;

    private String enumValue = null;

    /**
     * TimecardStatus constructor with enumeration literal value allowing
     * super classes to access it.
     */
    private TimecardStatus(String value)
    {
        this.enumValue = value;
    }

    /**
     * Return the TimecardStatus from a string value
     * @param value
     * @return TimecardStatus enum object
     */
    public static TimecardStatus fromString(String value)
    {
        return valueOf(value);
    }

    /**
     * Returns an instance of TimecardStatus from String <code>value</code>.
     * Required by JAXB2 enumeration implementation
     *
     * @param value the value to create the TimecardStatus from.
     * @return static Enumeration with corresponding value
     */
    public static TimecardStatus fromValue(String value)
    {
        for (TimecardStatus enumName: TimecardStatus.values())
        {
            if (enumName.getValue().equals(value))
            {
                return enumName;
            }
        }
        throw new IllegalArgumentException("TimecardStatus.fromValue(" + value + ')');
    }

    /**
     * Gets the underlying value of this type safe enumeration.
     * This method is necessary to comply with DaoBase implementation.
     * @return The name of this literal.
     */
    public String getValue()
    {
        return this.enumValue;
    }

    /**
     * Return a Collection of all literal values for this enumeration, can not be modified.
     * @return Collection<String> literal values
     */
    public static Collection<String> literals()
    {
        final Collection<String> literals = new ArrayList<String>(values().length);
        for (int i = 0; i < values().length; i++)
        {
            literals.add(values()[i].name());
        }
        return literals;
    }
}