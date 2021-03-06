// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by EntityEmbeddable.vsl in andromda-ejb3-cartridge.
//
package org.andromda.timetracker.domain;

import java.io.Serializable;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 * TimeAllocation represents a time period for which the timecard submitter worked on the associated
 * task.
 *
 * Autogenerated POJO EJB class for TimeAllocation containing the
 * bulk of the entity implementation.
 *
 * This is autogenerated by AndroMDA using the EJB3
 * cartridge.
 *
 * DO NOT MODIFY this class.
 */
@Entity
@Table(name="TIME_ALLOCATION")
@NamedQuery(name="TimeAllocation.findAll", query="SELECT t FROM TimeAllocation AS t")
public class TimeAllocation implements Serializable, Comparable<TimeAllocation>{
    private static final long serialVersionUID = 6048749692954952788L;

    // ----------- 2 Attribute Definitions ------------
    private TimePeriod timePeriod;
    private Long id;

    // --------- 2 Relationship Definitions -----------
    private Task task;
    private Timecard timecard;

    // ---- Manageable Display Attributes (Transient) -----
    private String taskLabel;    // Manageable display attribute

    // -------- 2 Attribute Accessors ----------
    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.TimeAllocation.timePeriod
     * Get the timePeriod property.
     * @return TimePeriod The value of timePeriod
     */
    @Embedded
    @AttributeOverrides
    ({
        @AttributeOverride(name="startTime", column=@Column(name="TIME_PERIOD_START_TIME", nullable=false, insertable=true, updatable=true)),
        @AttributeOverride(name="endTime", column=@Column(name="TIME_PERIOD_END_TIME", nullable=false, insertable=true, updatable=true))
    })
    @NotNull(message="timePeriod is required")
    public TimePeriod getTimePeriod()
    {
        return this.timePeriod;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.TimeAllocation.timePeriod
     * Set the timePeriod property.
     * @param value the new value
     */
    public void setTimePeriod(TimePeriod value)
    {
        this.timePeriod = value;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.TimeAllocation.id
     * Get the id property.
     * @return Long The value of id
     */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID", unique=true, nullable=false, insertable=true, updatable=true)
    public Long getId()
    {
        return this.id;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.TimeAllocation.id
     * Set the id property.
     * @param value the new value
     */
    public void setId(Long value)
    {
        this.id = value;
    }


    // ------------- 2 Relations ------------------
    /**
     * This class represents a task for which time allocations need to be tracked.
     * Get the task
     * @return Task
     */
    @ManyToOne(optional=false)
    @JoinColumn(name="TASK", insertable=true, updatable=true)
    public Task getTask()
    {
        return this.task;
    }

    /**
     * This class represents a task for which time allocations need to be tracked.
     * Set the task
     * @param taskIn
     */
    public void setTask(Task taskIn)
    {
        this.task = taskIn;
    }

    /**
     * This class represents a timecard submitted by a person.
     * Get the timecard
     * @return Timecard
     */
    @ManyToOne(optional=false)
    @JoinColumn(name="TIMECARD", insertable=true, updatable=true)
    public Timecard getTimecard()
    {
        return this.timecard;
    }

    /**
     * This class represents a timecard submitted by a person.
     * Set the timecard
     * @param timecardIn
     */
    public void setTimecard(Timecard timecardIn)
    {
        this.timecard = timecardIn;
    }

    // -------- Manageable Attribute Display -----------
    /**
     * This class represents a task for which time allocations need to be tracked.
     * Get the taskLabel
     * @return String     */
    @Transient
    public String getTaskLabel()
    {
        return this.taskLabel;
    }

    /**
     * This class represents a task for which time allocations need to be tracked.
     * Set the taskLabel
     * @param taskLabelIn
     */
    public void setTaskLabel (String taskLabelIn)
    {
        this.taskLabel = taskLabelIn;
    }

    // --------------- Constructors -----------------

    /**
     * Default empty no-arg constructor
     */
    public TimeAllocation()
    {
        // Default empty constructor
    }

    /**
     * Constructor with all updatable Entity attributes except auto incremented identifiers.
     *
     * @param timePeriod TimePeriod value for the timePeriod property true  1
     */
    public TimeAllocation(TimePeriod timePeriod)
    {
        setTimePeriod(timePeriod);
    }


    /**
     * Constructor with all Entity attribute values and CMR relations.
     *
     * @param timePeriod TimePeriod value for the timePeriod property
     * @param task Task value for the task relation
     * @param timecard Timecard value for the timecard relation
     */
    public TimeAllocation(TimePeriod timePeriod, Task task, Timecard timecard)
    {
        // 1 updatableAttributes
        setTimePeriod(timePeriod);

        // 2 relations
        setTask(task);
        setTimecard(timecard);
    }

    // -------- Common Methods -----------
    /**
     * Indicates if the argument is of the same type and all values are equal.
     * @param object The target object to compare with
     * @return boolean True if both objects a 'equal'
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object object)
    {
        if (null == object)
        {
            return false;
        }
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof TimeAllocation))
        {
            return false;
        }
        final TimeAllocation that = (TimeAllocation)object;
        if (this.getId() == null || that.getId() == null || !this.getId().equals(that.getId()))
        {
            return false;
        }
        return true;
    }

    /**
     * Returns a hash code value for the object
     * @return int The hash code value
     * @see Object#hashCode
     */
    @Override
    public int hashCode()
    {
        int hashCode = 0;
        hashCode = 29 * hashCode + (getId() == null ? 0 : getId().hashCode());

        return hashCode;
    }

    /**
     * Returns a String representation of the object
     * @return String Textual representation of the object displaying name/value pairs for all attributes
     * @see Object#toString
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("TimeAllocation(");
        sb.append(" timePeriod=").append(getTimePeriod().toString());
        sb.append(" id=").append(getId());
        sb.append(" task=").append(getTask());
        sb.append(" timecard=").append(getTimecard());
        sb.append(")");
        return sb.toString();
    }

    /**
     * @see Comparable#compareTo
     */
            @Override
    public int compareTo(TimeAllocation o)
    {
        int cmp = 0;
        if (this.getId() != null)
        {
            cmp = this.getId().compareTo(o.getId());
        }
        else
        {
        }
        return cmp;
    }


}