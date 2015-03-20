// license-header java merge-point
// Generated by: crud/SpringCrudValueObject.vsl in andromda-spring-cartridge.
package org.andromda.timetracker.domain.crud;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO: Model Documentation for org.andromda.timetracker.domain.User
 */
public class UserValueObject
    implements Serializable
{
    /** The serial version UID of this class. Needed for serialization. */
    private static final long serialVersionUID = -6177852626226267723L;

    private String username;

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.username
     * @return username
     */
    public String getUsername()
    {
        return this.username;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.username
     * @param usernameIn
     */
    public void setUsername(String usernameIn)
    {
        this.username = usernameIn;
    }

    private String password;

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.password
     * @return password
     */
    public String getPassword()
    {
        return this.password;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.password
     * @param passwordIn
     */
    public void setPassword(String passwordIn)
    {
        this.password = passwordIn;
    }

    private String firstName;

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.firstName
     * @return firstName
     */
    public String getFirstName()
    {
        return this.firstName;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.firstName
     * @param firstNameIn
     */
    public void setFirstName(String firstNameIn)
    {
        this.firstName = firstNameIn;
    }

    private String lastName;

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.lastName
     * @return lastName
     */
    public String getLastName()
    {
        return this.lastName;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.lastName
     * @param lastNameIn
     */
    public void setLastName(String lastNameIn)
    {
        this.lastName = lastNameIn;
    }

    private String email;

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.email
     * @return email
     */
    public String getEmail()
    {
        return this.email;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.email
     * @param emailIn
     */
    public void setEmail(String emailIn)
    {
        this.email = emailIn;
    }

    private boolean isActive;

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.isActive
     * @return isActive
     */
    public boolean isIsActive()
    {
        return this.isActive;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.isActive
     * @param isActiveIn
     */
    public void setIsActive(boolean isActiveIn)
    {
        this.isActive = isActiveIn;
    }

    private Date creationDate;

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.creationDate
     * @return creationDate
     */
    public Date getCreationDate()
    {
        return this.creationDate;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.creationDate
     * @param creationDateIn
     */
    public void setCreationDate(Date creationDateIn)
    {
        this.creationDate = creationDateIn;
    }

    private String comment;

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.comment
     * @return comment
     */
    public String getComment()
    {
        return this.comment;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.comment
     * @param commentIn
     */
    public void setComment(String commentIn)
    {
        this.comment = commentIn;
    }

    private Long id;

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.id
     * @return id
     */
    public Long getId()
    {
        return this.id;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.id
     * @param idIn
     */
    public void setId(Long idIn)
    {
        this.id = idIn;
    }


    private Long[] roles;

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.UserRole
     * @return roles
     */
    public Long[] getRoles()
    {
        return this.roles;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.UserRole
     * @param rolesIn
     */
    public void setRoles(Long[] rolesIn)
    {
        this.roles = rolesIn;
    }

    private Long[][] rolesLabels;

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.UserRole
     * @return roles
     */
    public Long[][] getRolesLabels()
    {
        return this.rolesLabels;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.UserRole
     * @param rolesLabelsIn
     */
    public void setRolesLabels(Long[][] rolesLabelsIn)
    {
        this.rolesLabels = rolesLabelsIn;
    }
}