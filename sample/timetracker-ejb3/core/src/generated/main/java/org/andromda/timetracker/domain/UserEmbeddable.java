// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by EntityEmbeddable.vsl in andromda-ejb3-cartridge.
//
package org.andromda.timetracker.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Index;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.jboss.seam.annotations.security.management.UserEnabled;
import org.jboss.seam.annotations.security.management.UserPassword;
import org.jboss.seam.annotations.security.management.UserPrincipal;

/**
 * TODO: Model Documentation for org.andromda.timetracker.domain.User
 *
 * Autogenerated POJO EJB mapped super class for User containing the
 * bulk of the entity implementation.
 *
 * This is a mapped super class and autogenerated by AndroMDA using the EJB3
 * cartridge.
 *
 * DO NOT MODIFY this class.
 */
@MappedSuperclass
public abstract class UserEmbeddable implements Serializable{
    private static final long serialVersionUID = 280161844106669459L;

    // ----------- 9 Attribute Definitions ------------
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private boolean isEnable;
    private Date creationDate;
    private String comment;
    private Long id;

    // --------- 1 Relationship Definitions -----------
    private Set<UserRole> roles = new HashSet<UserRole>();

    // ---- Manageable Display Attributes (Transient) -----

    // -------- 9 Attribute Accessors ----------
    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.username
     * Get the username property.
     * @return String The value of username
     */
    @Column(name="USERNAME", unique=true, nullable=false, insertable=true, updatable=true, length=50)
    @NotNull(message="username is required")
    @NotEmpty(message = "You should enter a value for username.")

    @Length(min = 5, max = 50)
    @Size(max=50)
    @Pattern(regexp = "^\\w*$", message = "not a valid field")
	@Index(name = "USERNAME_INDEX")
	@UserPrincipal
    public String getUsername()
    {
        return this.username;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.username
     * Set the username property.
     * @param value the new value
     */
    public void setUsername(String value)
    {
        this.username = value;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.password
     * Get the password property.
     * @return String The value of password
     */
    @Column(name="PASSWORD", nullable=false, insertable=true, updatable=true)
    @NotNull(message="password is required")
    @NotEmpty(message = "You should enter a value for password.")

    @Length(min = 5)
	@UserPassword(hash = "md5")
    public String getPassword()
    {
        return this.password;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.password
     * Set the password property.
     * @param value the new value
     */
    public void setPassword(String value)
    {
        this.password = value;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.firstName
     * Get the firstName property.
     * @return String The value of firstName
     */
    @Column(name="FIRST_NAME", nullable=false, insertable=true, updatable=true)
    @NotNull(message="firstName is required")
    @NotEmpty(message = "You should enter a value for firstName.")

    public String getFirstName()
    {
        return this.firstName;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.firstName
     * Set the firstName property.
     * @param value the new value
     */
    public void setFirstName(String value)
    {
        this.firstName = value;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.lastName
     * Get the lastName property.
     * @return String The value of lastName
     */
    @Column(name="LAST_NAME", nullable=false, insertable=true, updatable=true)
    @NotNull(message="lastName is required")
    @NotEmpty(message = "You should enter a value for lastName.")

    public String getLastName()
    {
        return this.lastName;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.lastName
     * Set the lastName property.
     * @param value the new value
     */
    public void setLastName(String value)
    {
        this.lastName = value;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.email
     * Get the email property.
     * @return String The value of email
     */
    @Column(name="EMAIL", unique=true, nullable=false, insertable=true, updatable=true, length=50)
    @NotNull(message="email is required")
    @NotEmpty(message = "You should enter a value for email.")

    @Length( min = 0, max = 50)
    @Size(max=50)
    @Email(message = "invalid e-mail invalid")
    public String getEmail()
    {
        return this.email;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.email
     * Set the email property.
     * @param value the new value
     */
    public void setEmail(String value)
    {
        this.email = value;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.isEnable
     * Get the isEnable property.
     * @return boolean The value of isEnable
     */
    @Column(name="IS_ENABLE", nullable=false, insertable=true, updatable=true)
    @NotNull(message="isEnable is required")

	@UserEnabled
    public boolean isIsEnable()
    {
        return this.isEnable;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.isEnable
     * Set the isEnable property.
     * @param value the new value
     */
    public void setIsEnable(boolean value)
    {
        this.isEnable = value;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.creationDate
     * Get the creationDate property.
     * @return Date The value of creationDate
     */
    @Column(name="CREATION_DATE", nullable=false, insertable=true, updatable=true)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message="creationDate is required")

    public Date getCreationDate()
    {
        return this.creationDate;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.creationDate
     * Set the creationDate property.
     * @param value the new value
     */
    public void setCreationDate(Date value)
    {
        this.creationDate = value;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.comment
     * Get the comment property.
     * @return String The value of comment
     */
    @Column(name="COMMENT", insertable=true, updatable=true)

    public String getComment()
    {
        return this.comment;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.comment
     * Set the comment property.
     * @param value the new value
     */
    public void setComment(String value)
    {
        this.comment = value;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.id
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
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.id
     * Set the id property.
     * @param value the new value
     */
    public void setId(Long value)
    {
        this.id = value;
    }


    // ------------- 1 Relations ------------------
    /**
     * TODO: Model Documentation for UserRole
     * Get the roles Collection
     * @return Set<UserRole>
     */
    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable
    (
        name="USERS2ROLES",
        joinColumns={@JoinColumn(name="USERS_ID", referencedColumnName="ID")},
        inverseJoinColumns={@JoinColumn(name="ROLES_ID", referencedColumnName="ID")}
    )
    public Set<UserRole> getRoles()
    {
        return this.roles;
    }

    /**
     * TODO: Model Documentation for UserRole
     * Set the roles
     * @param rolesIn
     */
    public void setRoles (Set<UserRole> rolesIn)
    {
        this.roles = rolesIn;
    }

    // --------------- Constructors -----------------

    /**
     * Default empty no-arg constructor
     */
    public UserEmbeddable()
    {
        // Default empty constructor
    }

    /**
     * Constructor with all updatable Entity attributes except auto incremented identifiers.
     *
     * @param username String value for the username property true  1
     * @param password String value for the password property true  1
     * @param firstName String value for the firstName property true  1
     * @param lastName String value for the lastName property true  1
     * @param email String value for the email property true  1
     * @param isEnable boolean value for the isEnable property true  1
     * @param creationDate Date value for the creationDate property true  1
     * @param comment String value for the comment property false  0
     */
    public UserEmbeddable(String username, String password, String firstName, String lastName, String email, boolean isEnable, Date creationDate, String comment)
    {
        setUsername(username);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setIsEnable(isEnable);
        setCreationDate(creationDate);
        setComment(comment);
    }

    /**
     * Constructor with required Entity attributes except auto incremented identifiers.
     *
     * @param username Value for the username property
     * @param password Value for the password property
     * @param firstName Value for the firstName property
     * @param lastName Value for the lastName property
     * @param email Value for the email property
     * @param isEnable Value for the isEnable property
     * @param creationDate Value for the creationDate property
     */
    public UserEmbeddable(String username, String password, String firstName, String lastName, String email, boolean isEnable, Date creationDate)
    {
        setUsername(username);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setIsEnable(isEnable);
        setCreationDate(creationDate);
    }

    /**
     * Constructor with all Entity attribute values and CMR relations.
     *
     * @param username String value for the username property
     * @param password String value for the password property
     * @param firstName String value for the firstName property
     * @param lastName String value for the lastName property
     * @param email String value for the email property
     * @param isEnable boolean value for the isEnable property
     * @param creationDate Date value for the creationDate property
     * @param comment String value for the comment property
     * @param roles Set<UserRole> value for the roles relation
     */
    public UserEmbeddable(String username, String password, String firstName, String lastName, String email, boolean isEnable, Date creationDate, String comment, Set<UserRole> roles)
    {
        // 8 updatableAttributes
        setUsername(username);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setIsEnable(isEnable);
        setCreationDate(creationDate);
        setComment(comment);

        // 1 relations
        setRoles(roles);
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
        if (!(object instanceof UserEmbeddable))
        {
            return false;
        }
        final UserEmbeddable that = (UserEmbeddable)object;
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
        sb.append("UserEmbeddable(");
        sb.append(" username=").append(getUsername());
        sb.append(" password=").append(getPassword());
        sb.append(" firstName=").append(getFirstName());
        sb.append(" lastName=").append(getLastName());
        sb.append(" email=").append(getEmail());
        sb.append(" isEnable=").append(isIsEnable());
        sb.append(" creationDate=").append(getCreationDate());
        sb.append(" comment=").append(getComment());
        sb.append(" id=").append(getId());
        sb.append(" roles=").append(getRoles());
        sb.append(")");
        return sb.toString();
    }


}