// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by EntityEmbeddable.vsl in andromda-ejb3-cartridge.
//
package org.andromda.timetracker.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Index;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * TODO: Model Documentation for org.andromda.timetracker.domain.Movie
 *
 * Autogenerated POJO EJB class for Movie containing the
 * bulk of the entity implementation.
 *
 * This is autogenerated by AndroMDA using the EJB3
 * cartridge.
 *
 * DO NOT MODIFY this class.
 */
@Entity
/**
 * Use components.xml to define Seam components
 * @org.jboss.seam.annotations.Name("movie")
 *
 * Use components.xml to define Seam component scope type
 * @org.jboss.seam.annotations.Scope(org.jboss.seam.ScopeType.SESSION)
 *
 */
@Table(name="MOVIE")
@NamedQuery(name="Movie.findAll", query="SELECT m FROM Movie AS m")
public class Movie implements Serializable, Comparable<Movie>{
    private static final long serialVersionUID = -5894565260968997027L;

    // ----------- 6 Attribute Definitions ------------
    private String title;
    private Integer year;
    public Integer version;
    private String director;
    private String plot;
    private Long id;

    // -------- 6 Attribute Accessors ----------
    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.Movie.title
     * Get the title property.
     * @return String The value of title
     */
    @Column(name="TITLE", unique=true, nullable=false, insertable=true, updatable=true, length=60)
    @NotNull(message="title is required")
    @NotEmpty(message = "You should enter a value for title.")

    @Length(min = 5, max = 60)
    @Size(max=60)
    @Pattern(regexp = "^\\w*$", message = "not a valid field")
    public String getTitle()
    {
        return this.title;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.Movie.title
     * Set the title property.
     * @param value the new value
     */
    public void setTitle(String value)
    {
        this.title = value;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.Movie.year
     * Get the year property.
     * @return Integer The value of year
     */
    @Column(name="YEAR", nullable=false, insertable=true, updatable=true)
    @NotNull(message="year is required")

    public Integer getYear()
    {
        return this.year;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.Movie.year
     * Set the year property.
     * @param value the new value
     */
    public void setYear(Integer value)
    {
        this.year = value;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.Movie.version
     * Get the version property.
     * @return Integer The value of version
     */
    @Version
    public Integer getVersion()
    {
        return this.version;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.Movie.version
     * Set the version property.
     * @param value the new value
     */
    protected void setVersion(Integer value)
    {
        this.version = value;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.Movie.director
     * Get the director property.
     * @return String The value of director
     */
    @Column(name="DIRECTOR", nullable=false, insertable=true, updatable=true, length=50)
    @NotNull(message="director is required")
    @NotEmpty(message = "You should enter a value for director.")

    @Length( min = 0, max = 50)
    @Size(max=50)
	@Index(name = "DIRECTOR_INDEX")
    public String getDirector()
    {
        return this.director;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.Movie.director
     * Set the director property.
     * @param value the new value
     */
    public void setDirector(String value)
    {
        this.director = value;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.Movie.plot
     * Get the plot property.
     * @return String The value of plot
     */
    @Lob
    @Column(name="PLOT", nullable=false, insertable=true, updatable=true)
    @NotNull(message="plot is required")
    @NotEmpty(message = "You should enter a value for plot.")

    public String getPlot()
    {
        return this.plot;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.Movie.plot
     * Set the plot property.
     * @param value the new value
     */
    public void setPlot(String value)
    {
        this.plot = value;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.Movie.id
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
     * TODO: Model Documentation for org.andromda.timetracker.domain.Movie.id
     * Set the id property.
     * @param value the new value
     */
    public void setId(Long value)
    {
        this.id = value;
    }


    // ------------- 0 Relations ------------------
    // --------------- Constructors -----------------

    /**
     * Default empty no-arg constructor
     */
    public Movie()
    {
        // Default empty constructor
    }

    /**
     * Constructor with all updatable Entity attributes except auto incremented identifiers.
     *
     * @param title String value for the title property true  1
     * @param year Integer value for the year property false  0
     * @param director String value for the director property true  1
     * @param plot String value for the plot property true  1
     */
    public Movie(String title, Integer year, String director, String plot)
    {
        setTitle(title);
        setYear(year);
        setDirector(director);
        setPlot(plot);
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
        if (!(object instanceof Movie))
        {
            return false;
        }
        final Movie that = (Movie)object;
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
        sb.append("Movie(");
        sb.append(" title=").append(getTitle());
        sb.append(" year=").append(getYear());
        sb.append(" version=").append(getVersion());
        sb.append(" director=").append(getDirector());
        sb.append(" plot=").append(getPlot());
        sb.append(" id=").append(getId());
        sb.append(")");
        return sb.toString();
    }

    /**
     * @see Comparable#compareTo
     */
            @Override
    public int compareTo(Movie o)
    {
        int cmp = 0;
        if (this.getId() != null)
        {
            cmp = this.getId().compareTo(o.getId());
        }
        else
        {
            if (this.getTitle() != null)
            {
                cmp = (cmp != 0 ? cmp : this.getTitle().compareTo(o.getTitle()));
            }
            if (this.getYear() != null)
            {
                cmp = (cmp != 0 ? cmp : this.getYear().compareTo(o.getYear()));
            }
            if (this.getVersion() != null)
            {
                cmp = (cmp != 0 ? cmp : this.getVersion().compareTo(o.getVersion()));
            }
            if (this.getDirector() != null)
            {
                cmp = (cmp != 0 ? cmp : this.getDirector().compareTo(o.getDirector()));
            }
        }
        return cmp;
    }


}
