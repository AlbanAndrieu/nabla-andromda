// license-header java merge-point
// Generated by andromda-jsf cartridge (forms\crud\Form.java.vsl) DO NOT EDIT!
package org.andromda.timetracker.domain.crud;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import org.andromda.presentation.gui.JsfUtils;

/**
 * TODO: Model Documentation for org.andromda.timetracker.domain.User
 * This form encapsulates the fields that are used in the execution of the CRUD operations in User
 */
public class ManageUserForm
    implements Serializable
{
    /**
     * Default constructor. Initializes the attribute formatters.
     */
    public ManageUserForm(){
        DateFormat creationDateDateFormatter = new SimpleDateFormat("MM/dd/yyyy");
        creationDateDateFormatter.setLenient(true);
        this.dateTimeFormatters.put("creationDate", creationDateDateFormatter);
        this.dateTimeFormatters.put("searchForm.creationDate", creationDateDateFormatter);
        // - setup the default Date.toString() formatter
        DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        dateFormatter.setLenient(true);
        this.dateTimeFormatters.put(null, dateFormatter);

        this.searchForm = new ManageUserSearchForm();

        this.editState=false;
    }

    /**
     * Holds the edit/search state of the form
     */
    private boolean editState;

    /**
     * @return editState
     */
    public boolean getEditState(){
        return this.editState;
    }

    /**
     * @param editStateIn
     */
    public void setEditState(boolean editStateIn){
        this.editState = editStateIn;
    }

    private ManageUserSearchForm searchForm;

    /**
     * @return searchForm
     */
    public ManageUserSearchForm getSearchForm(){
        return this.searchForm;
    }

    /**
     * @param searchFormIn
     */
    public void setSearchForm(ManageUserSearchForm searchFormIn){
        this.searchForm = searchFormIn;
    }

    private List manageableList = null;

    /**
     * @return manageableList
     */
    public List getManageableList()
    {
        return this.manageableList;
    }

    /**
     * @param manageableListIn
     */
    public void setManageableList(List manageableListIn)
    {
        this.manageableList = manageableListIn;
    }

    private Long[] selectedRows = null;

    /**
     * @return selectedRows
     */
    public Long[] getSelectedRows()
    {
        return this.selectedRows;
    }

    /**
     * @param selectedRowsIn
     */
    public void setSelectedRows(Long[] selectedRowsIn)
    {
        this.selectedRows = selectedRowsIn;
    }

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

    private Collection<?> usernameBackingList;

    /**
     * @return usernameBackingList
     */
    public Collection<?> getUsernameBackingList(){
        return this.usernameBackingList;
    }

    /**
     * @param usernameBackingListIn
     */
    public void setUsernameBackingList(Collection<?> usernameBackingListIn){
        this.usernameBackingList = usernameBackingListIn;
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

    private Collection<?> passwordBackingList;

    /**
     * @return passwordBackingList
     */
    public Collection<?> getPasswordBackingList(){
        return this.passwordBackingList;
    }

    /**
     * @param passwordBackingListIn
     */
    public void setPasswordBackingList(Collection<?> passwordBackingListIn){
        this.passwordBackingList = passwordBackingListIn;
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

    private Collection<?> firstNameBackingList;

    /**
     * @return firstNameBackingList
     */
    public Collection<?> getFirstNameBackingList(){
        return this.firstNameBackingList;
    }

    /**
     * @param firstNameBackingListIn
     */
    public void setFirstNameBackingList(Collection<?> firstNameBackingListIn){
        this.firstNameBackingList = firstNameBackingListIn;
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

    private Collection<?> lastNameBackingList;

    /**
     * @return lastNameBackingList
     */
    public Collection<?> getLastNameBackingList(){
        return this.lastNameBackingList;
    }

    /**
     * @param lastNameBackingListIn
     */
    public void setLastNameBackingList(Collection<?> lastNameBackingListIn){
        this.lastNameBackingList = lastNameBackingListIn;
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

    private Collection<?> emailBackingList;

    /**
     * @return emailBackingList
     */
    public Collection<?> getEmailBackingList(){
        return this.emailBackingList;
    }

    /**
     * @param emailBackingListIn
     */
    public void setEmailBackingList(Collection<?> emailBackingListIn){
        this.emailBackingList = emailBackingListIn;
    }

    private boolean isEnable;

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.isEnable
     * @return isEnable
     */
    public boolean isIsEnable()
    {
        return this.isEnable;
    }

    /**
     * TODO: Model Documentation for org.andromda.timetracker.domain.User.isEnable
     * @param isEnableIn
     */
    public void setIsEnable(boolean isEnableIn)
    {
        this.isEnable = isEnableIn;
    }

    private Collection<?> isEnableBackingList;

    /**
     * @return isEnableBackingList
     */
    public Collection<?> getIsEnableBackingList(){
        return this.isEnableBackingList;
    }

    /**
     * @param isEnableBackingListIn
     */
    public void setIsEnableBackingList(Collection<?> isEnableBackingListIn){
        this.isEnableBackingList = isEnableBackingListIn;
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

    private Collection<?> creationDateBackingList;

    /**
     * @return creationDateBackingList
     */
    public Collection<?> getCreationDateBackingList(){
        return this.creationDateBackingList;
    }

    /**
     * @param creationDateBackingListIn
     */
    public void setCreationDateBackingList(Collection<?> creationDateBackingListIn){
        this.creationDateBackingList = creationDateBackingListIn;
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

    private Collection<?> commentBackingList;

    /**
     * @return commentBackingList
     */
    public Collection<?> getCommentBackingList(){
        return this.commentBackingList;
    }

    /**
     * @param commentBackingListIn
     */
    public void setCommentBackingList(Collection<?> commentBackingListIn){
        this.commentBackingList = commentBackingListIn;
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

    private Collection<?> idBackingList;

    /**
     * @return idBackingList
     */
    public Collection<?> getIdBackingList(){
        return this.idBackingList;
    }

    /**
     * @param idBackingListIn
     */
    public void setIdBackingList(Collection<?> idBackingListIn){
        this.idBackingList = idBackingListIn;
    }


    // Manageable associationEnds in User
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
        //the code below avoids the "0 when null" issue of EL
        this.roles = JsfUtils.removeZeros(rolesIn);
    }

    private Collection rolesBackingList;

    /**
     * The current collection of possible values of roles.
     * @return rolesBackingList
     */
    public Collection getRolesBackingList(){
        return this.rolesBackingList;
    }

    /**
     * The current collection of possible values of roles.
     * @param rolesBackingListIn
     */
    public void setRolesBackingList(Collection rolesBackingListIn){
        this.rolesBackingList = rolesBackingListIn;
    }

    /**
     * Stores any date or time formatters for this form.
     */
    private final Map<String,DateFormat> dateTimeFormatters = new HashMap<String,DateFormat>();

    /**
     * Gets any date and time formatters (keyed by property name)
     * for this form.
     *
     * @return the Map containing any date and time formatters.
     */
    public Map<String,DateFormat> getDateTimeFormatters()
    {
        return this.dateTimeFormatters;
    }

    /**
     * The current collection of messages stored within this form.
     */
    private Map<String, FacesMessage> jsfMessages =
        new LinkedHashMap<String, FacesMessage>();

    /**
     * Adds a {@link FacesMessage} message to the current messages
     * stored within this form.
     *
     * @param jsfMessage the faces message to add.
     */
    public void addJsfMessages(FacesMessage jsfMessage)
    {
        if (jsfMessage != null)
        {
            this.jsfMessages.put(jsfMessage.getDetail(), jsfMessage);
        }
    }

    /**
     * Gets the current {@link FacesMessage} message
     * instances stored within this form.
     *
     * @return the current Faces messages.
     */
    public Collection<FacesMessage> getJsfMessages()
    {
        return this.jsfMessages.values();
    }

    /**
     * Sets the current {@link FacesMessage} message
     * instances stored within this form.
     *
     * @param messages a collection of the current Faces messages.
     */
    public void setJsfMessages(final Collection<FacesMessage> messages)
    {
        if (messages != null)
        {
            for (final FacesMessage jsfMessage : messages)
            {
                this.jsfMessages.put(jsfMessage.getDetail(), jsfMessage);
            }
        }
    }

    /**
     * Clear the current {@link FacesMessage} message
     * instances stored within this form.
     */
    public void clearJsfMessages()
    {
        this.jsfMessages.clear();
    }

    /**
     * The faces message title (used on a view).
     */
    private String jsfMessagesTitle;

    /**
     * The optional faces message title to set (used on a view).  If not set, the default title
     * will be used.
     *
     * @param jsfMessagesTitleIn the title to use for the messages on the view.
     */
    public void setJsfMessagesTitle(final String jsfMessagesTitleIn)
    {
        this.jsfMessagesTitle = jsfMessagesTitleIn;
    }

    /**
     * Gets the faces messages title to use.
     *
     * @return the faces messages title.
     */
    public String getJsfMessagesTitle()
    {
        return this.jsfMessagesTitle;
    }

    /**
     * Gets the maximum severity of the messages stored in this form.
     *
     * @return the maximum severity or null if no messages are present and/or severity isn't set.
     */
    public FacesMessage.Severity getMaximumMessageSeverity()
    {
        FacesMessage.Severity maxSeverity = null;
        for (final FacesMessage message : this.getJsfMessages())
        {
            final FacesMessage.Severity severity = message.getSeverity();
            if (maxSeverity == null || (severity != null && severity.getOrdinal() > maxSeverity.getOrdinal()))
            {
                maxSeverity = severity;
            }
        }
        return maxSeverity;
    }

    /**
     * Copy all the properties from the other form to the current form.
     *
     * @param otherForm the form with the source properties to be copied.
     */
    public void copyFrom(ManageUserForm otherForm){
        this.setUsername(otherForm.getUsername());
        this.setUsernameBackingList(otherForm.getUsernameBackingList());
        this.setPassword(otherForm.getPassword());
        this.setPasswordBackingList(otherForm.getPasswordBackingList());
        this.setFirstName(otherForm.getFirstName());
        this.setFirstNameBackingList(otherForm.getFirstNameBackingList());
        this.setLastName(otherForm.getLastName());
        this.setLastNameBackingList(otherForm.getLastNameBackingList());
        this.setEmail(otherForm.getEmail());
        this.setEmailBackingList(otherForm.getEmailBackingList());
        this.setIsEnable(otherForm.isIsEnable());
        this.setIsEnableBackingList(otherForm.getIsEnableBackingList());
        this.setCreationDate(otherForm.getCreationDate());
        this.setCreationDateBackingList(otherForm.getCreationDateBackingList());
        this.setComment(otherForm.getComment());
        this.setCommentBackingList(otherForm.getCommentBackingList());
        this.setId(otherForm.getId());
        this.setIdBackingList(otherForm.getIdBackingList());
        this.setRoles(otherForm.getRoles());
        this.setRolesBackingList(otherForm.getRolesBackingList());

        this.setJsfMessages(otherForm.getJsfMessages());
        this.setJsfMessagesTitle(otherForm.getJsfMessagesTitle());

        this.setEditState(otherForm.getEditState());
        this.setSearchForm(otherForm.getSearchForm());
        this.setManageableList(otherForm.getManageableList());
        this.setSelectedRows(otherForm.getSelectedRows());
    }

    /**
     * The serial version UID of this class. Needed for serialization.
     */
    private static final long serialVersionUID = 2315613480778833561L;
}
