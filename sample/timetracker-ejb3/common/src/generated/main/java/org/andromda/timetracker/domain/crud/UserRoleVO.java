// license-header java merge-point
// Generated by: crud/SpringCrudValueObject.vsl in andromda-spring-cartridge.
package org.andromda.timetracker.domain.crud;

import java.io.Serializable;
import org.andromda.timetracker.domain.Role;

/**
 * TODO: Model Documentation for org.andromda.timetracker.domain.UserRole
 */
public class UserRoleVO
    implements Serializable
{
    /** The serial version UID of this class. Needed for serialization. */
    private static final long serialVersionUID = 4491898486466294586L;

    private Role role;

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.UserRole.role
     * @return role
     */
    public Role getRole()
    {
        return this.role;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.UserRole.role
     * @param roleIn
     */
    public void setRole(Role roleIn)
    {
        this.role = roleIn;
    }

    private Boolean isConditional;

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.UserRole.isConditional
     * @return isConditional
     */
    public Boolean getIsConditional()
    {
        return this.isConditional;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.UserRole.isConditional
     * @param isConditionalIn
     */
    public void setIsConditional(Boolean isConditionalIn)
    {
        this.isConditional = isConditionalIn;
    }

    private Long id;

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.UserRole.id
     * @return id
     */
    public Long getId()
    {
        return this.id;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.UserRole.id
     * @param idIn
     */
    public void setId(Long idIn)
    {
        this.id = idIn;
    }


    private Long[] groups;

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.UserRole
     * @return groups
     */
    public Long[] getGroups()
    {
        return this.groups;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.UserRole
     * @param groupsIn
     */
    public void setGroups(Long[] groupsIn)
    {
        this.groups = groupsIn;
    }

}
