// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by Entity.vsl in andromda-ejb3-cartridge.
//
package org.andromda.timetracker.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

/**
 * Autogenerated POJO EJB3 implementation class for User.
 *
 * Add any manual implementation within this class.  This class will NOT
 * be overwritten with incremental changes.
 *
 * TODO: Model Documentation for User
 *
 */
//Uncomment because jboss embedded tests for UserServiceBean does not work with seam
@Scope(ScopeType.SESSION)
@Name("user")
@Entity
@Table(name = "USERS", uniqueConstraints = @UniqueConstraint(columnNames = {"username", "email", "id"}))
// Uncomment to enable entity listener for User
// @javax.persistence.EntityListeners({org.andromda.timetracker.domain.UserListener.class})
// Uncomment to enable caching for User
// @org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.TRANSACTIONAL)
@NamedQueries
({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User AS u"),
    @NamedQuery(name = "User.findByEmail", query = "select u from User u where u.email = :email order by u.email")
})
public class User extends UserEmbeddable implements Serializable, Comparable<User>
{
    /**
     * The serial version UID of this class required for serialization.
     */
    private static final long serialVersionUID = 280161844106669459L;

    // --------------- constructors -----------------

    /**
     * Default User constructor
     */
    public User()
    {
        super();
    }

    /**
     * Implementation for the constructor with all POJO attributes except auto incremented identifiers.
     * This method sets all POJO fields defined in this/super class to the
     * values provided by the parameters.
     *
     */
    public User(String username, String password, String firstName, String lastName, String email, boolean isEnable, Date creationDate, String comment)
    {
        super(username, password, firstName, lastName, email, isEnable, creationDate, comment);
    }

    /**
     * Constructor with all POJO attribute values and CMR relations.
     *
     * @param username Value for the username property
     * @param password Value for the password property
     * @param firstName Value for the firstName property
     * @param lastName Value for the lastName property
     * @param email Value for the email property
     * @param isEnable Value for the isEnable property
     * @param creationDate Value for the creationDate property
     * @param comment Value for the comment property
     * @param roles Value for the roles relation
     */
    public User(String username, String password, String firstName, String lastName, String email, boolean isEnable, Date creationDate, String comment, Set<UserRole> roles)
    {
        super(username, password, firstName, lastName, email, isEnable, creationDate, comment, roles);
    }


    // -------------- Entity Methods -----------------

    /**
     * TODO: Model Documentation for User.getUserDetails
     */
    @Transient
    public static User getUserDetails(String username)
    {
        // TODO put your implementation here.
        return null;
    }


    // --------------- Lifecycle callbacks -----------------

    /**
     * @see Comparable#compareTo
     */
            @Override
    public int compareTo(User o)
    {
        int cmp = 0;
        if (this.getId() != null)
        {
            cmp = this.getId().compareTo(o.getId());
        }
        else
        {
            if (this.getUsername() != null)
            {
                cmp = (cmp != 0 ? cmp : this.getUsername().compareTo(o.getUsername()));
            }
            if (this.getPassword() != null)
            {
                cmp = (cmp != 0 ? cmp : this.getPassword().compareTo(o.getPassword()));
            }
            if (this.getFirstName() != null)
            {
                cmp = (cmp != 0 ? cmp : this.getFirstName().compareTo(o.getFirstName()));
            }
            if (this.getLastName() != null)
            {
                cmp = (cmp != 0 ? cmp : this.getLastName().compareTo(o.getLastName()));
            }
            if (this.getEmail() != null)
            {
                cmp = (cmp != 0 ? cmp : this.getEmail().compareTo(o.getEmail()));
            }
            if (this.getCreationDate() != null)
            {
                cmp = (cmp != 0 ? cmp : this.getCreationDate().compareTo(o.getCreationDate()));
            }
            if (this.getComment() != null)
            {
                cmp = (cmp != 0 ? cmp : this.getComment().compareTo(o.getComment()));
            }
        }
        return cmp;
    }

}
