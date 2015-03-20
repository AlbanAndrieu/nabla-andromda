package org.andromda.cartridges.jsf2.metafacades;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import org.andromda.cartridges.jsf2.JSFGlobals;
import org.andromda.cartridges.jsf2.JSFProfile;
import org.andromda.cartridges.jsf2.JSFUtils;
import org.andromda.metafacades.uml.DependencyFacade;
import org.andromda.metafacades.uml.ManageableEntityAssociationEnd;
import org.andromda.metafacades.uml.ManageableEntityAttribute;
import org.andromda.metafacades.uml.Role;
import org.andromda.metafacades.uml.UMLMetafacadeProperties;
import org.andromda.utils.StringUtilsHelper;
import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.jsf2.metafacades.JSFManageableEntity.
 * 
 * @see org.andromda.cartridges.jsf2.metafacades.JSFManageableEntity
 */
public class JSFManageableEntityLogicImpl extends JSFManageableEntityLogic
{
    private static final long serialVersionUID = 34L;

    /**
     * @param metaObject
     * @param context
     */
    public JSFManageableEntityLogicImpl(Object metaObject, String context)
    {
        super(metaObject, context);
    }

    /**
     * @return getName().toLowerCase() + "-crud"
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getViewName()
     */
    protected String handleGetViewName()
    {
        return this.getName().toLowerCase() + "-crud";
    }

    /**
     * @return toResourceMessageKey(this.getName()) + ".view.title"
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getViewTitleKey()
     */
    protected String handleGetViewTitleKey()
    {
        return StringUtilsHelper.toResourceMessageKey(this.getName()) + ".view.title";
    }

    /**
     * @return StringUtilsHelper.toPhrase(getName())
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getViewTitleValue()
     */
    protected String handleGetViewTitleValue()
    {
        return StringUtilsHelper.toPhrase(getName());
    }

    /**
     * @return "manageableList"
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getListName()
     */
    protected String handleGetListName()
    {
        return "manageableList";
    }

    /**
     * @return getManageablePackageName() + getNamespaceProperty() + this.getFormBeanClassName()
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getFormBeanType()
     */
    protected String handleGetFormBeanType()
    {
        return this.getManageablePackageName() + this.getNamespaceProperty() + this.getFormBeanClassName();
    }

    /**
     * @return formBeanName
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getFormBeanName()
     */
    protected String handleGetFormBeanName()
    {
        final String pattern = ObjectUtils.toString(this.getConfiguredProperty(JSFGlobals.FORM_BEAN_PATTERN));
        final String formBeanName = pattern.replaceFirst("\\{0\\}", "manage");
        return formBeanName.replaceFirst("\\{1\\}", this.getName());
    }

    /**
     * @return StringUtilsHelper.toResourceMessageKey(this.getName()) + ".exception"
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getExceptionKey()
     */
    protected String handleGetExceptionKey()
    {
        return StringUtilsHelper.toResourceMessageKey(this.getName()) + ".exception";
    }

    /**
     * @return getManageablePackageName() + getNamespaceProperty() + getActionClassName()
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getActionType()
     */
    protected String handleGetActionType()
    {
        return this.getManageablePackageName() + this.getNamespaceProperty() + this.getActionClassName();
    }

    /**
     * @return '/' + StringUtils.replace(this.getActionType(), getNamespaceProperty(), "/")
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getActionFullPath()
     */
    protected String handleGetActionFullPath()
    {
        return '/' + StringUtils.replace(this.getActionType(), this.getNamespaceProperty(), "/");
    }

    /**
     * @return '/' + getName() + "/Manage"
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getActionPath()
     */
    protected String handleGetActionPath()
    {
        return '/' + this.getName() + "/Manage";
    }

    /**
     * @return "Manage" + getName()
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getActionClassName()
     */
    protected String handleGetActionClassName()
    {
        return "Manage" + getName();
    }

    /**
     * @return getViewFullPath()
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getExceptionPath()
     */
    protected String handleGetExceptionPath()
    {
        return this.getViewFullPath();
    }

    /**
     * @return false
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#isPreload()
     */
    protected boolean handleIsPreload()
    {
        return false; // TODO think about...
        // return this.isCreate() || this.isRead() || this.isUpdate() || this.isDelete();
    }

    /**
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntityLogic#getManageableIdentifier()
     */
    @Override
    public org.andromda.metafacades.uml.ManageableEntityAttribute getManageableIdentifier()
    {
        return super.getManageableIdentifier();
    }

    /**
     * @return StringUtils.capitalize(this.getFormBeanName())
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getFormBeanClassName()
     */
    protected String handleGetFormBeanClassName()
    {
        return StringUtils.capitalize(this.getFormBeanName());
    }

    /**
     * @return StringUtils.replace(getFormBeanType(), getNamespaceProperty(), "/")
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getFormBeanFullPath()
     */
    protected String handleGetFormBeanFullPath()
    {
        return StringUtils.replace(this.getFormBeanType(), this.getNamespaceProperty(), "/");
    }

    /**
     * @return "getManageableList"
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getListGetterName()
     */
    protected String handleGetListGetterName()
    {
        return "getManageableList";
    }

    /**
     * @return "setManageableList"
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getListSetterName()
     */
    protected String handleGetListSetterName()
    {
        return "setManageableList";
    }

    /**
     * @return StringUtilsHelper.toResourceMessageKey(this.getName())
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getMessageKey()
     */
    protected String handleGetMessageKey()
    {
        return StringUtilsHelper.toResourceMessageKey(this.getName());
    }

    /**
     * @return StringUtilsHelper.toPhrase(this.getName())
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getMessageValue()
     */
    protected String handleGetMessageValue()
    {
        return StringUtilsHelper.toPhrase(this.getName());
    }

    /**
     * @return getMessageKey() + ".online.help"
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getOnlineHelpKey()
     */
    protected String handleGetOnlineHelpKey()
    {
        return this.getMessageKey() + ".online.help";
    }

    /**
     * @return onlineHelpValue
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getOnlineHelpValue()
     */
    protected String handleGetOnlineHelpValue()
    {
        final String value = StringUtilsHelper.toResourceMessage(this.getDocumentation("", 64, false));
        return (value == null) ? "No entity documentation has been specified" : value;
    }

    /**
     * @return getActionPath() + "Help"
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getOnlineHelpActionPath()
     */
    protected String handleGetOnlineHelpActionPath()
    {
        return this.getActionPath() + "Help";
    }

    /**
     * @return '/' + getManageablePackagePath() + '/' + getName().toLowerCase() + "_help"
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getOnlineHelpPagePath()
     */
    protected String handleGetOnlineHelpPagePath()
    {
        return '/' + this.getManageablePackagePath() + '/' + this.getName().toLowerCase() + "_help";
    }

    /**
     * @return getTableExportTypes().indexOf("none") == -1
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#isTableExportable()
     */
    protected boolean handleIsTableExportable()
    {
        return this.getTableExportTypes().indexOf("none") == -1;
    }

    /**
     * @return null
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getTableExportTypes()
     */
    protected String handleGetTableExportTypes()
    {
        return null;
        // TODO a resolver
        // return JSFUtils.getDisplayTagExportTypes(
        // this.findTaggedValues(JSFProfile.TAGGEDVALUE_TABLE_EXPORT),
        // (String)getConfiguredProperty(JSFGlobals.PROPERTY_DEFAULT_TABLE_EXPORT_TYPES) );
    }

    /**
     * @return tableMaxRows
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getTableMaxRows()
     */
    protected int handleGetTableMaxRows()
    {
        final Object taggedValue = this.findTaggedValue(JSFProfile.TAGGEDVALUE_TABLE_MAXROWS);
        int pageSize;

        try
        {
            pageSize = Integer.parseInt(String.valueOf(taggedValue));
        } catch (Exception e)
        {
            pageSize = JSFProfile.TAGGEDVALUE_TABLE_MAXROWS_DEFAULT_COUNT;
        }

        return pageSize;
    }

    /**
     * @return tableSortable
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#isTableSortable()
     */
    protected boolean handleIsTableSortable()
    {
        final Object taggedValue = this.findTaggedValue(JSFProfile.TAGGEDVALUE_TABLE_SORTABLE);
        return (taggedValue == null) ? JSFProfile.TAGGEDVALUE_TABLE_SORTABLE_DEFAULT_VALUE : Boolean.valueOf(String.valueOf(taggedValue)).booleanValue();
    }

    /**
     * @return controllerType
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getControllerType()
     */
    protected String handleGetControllerType()
    {
        return this.getManageablePackageName() + this.getNamespaceProperty() + this.getControllerName();
    }

    /**
     * @return StringUtils.uncapitalize(this.getName()) + "Controller"
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getControllerBeanName()
     */
    protected String handleGetControllerBeanName()
    {
        return StringUtils.uncapitalize(this.getName()) + "Controller";
    }

    /**
     * @return '/' + StringUtils.replace(getControllerType(), getNamespaceProperty(), "/")
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getControllerFullPath()
     */
    protected String handleGetControllerFullPath()
    {
        return '/' + StringUtils.replace(this.getControllerType(), this.getNamespaceProperty(), "/");
    }

    /**
     * @return getName() + "Controller"
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getControllerName()
     */
    protected String handleGetControllerName()
    {
        return this.getName() + "Controller";
    }

    /**
     * @return getName() + this.getConfiguredProperty(JSFGlobals.CRUD_VALUE_OBJECT_SUFFIX)
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getValueObjectClassName()
     */
    protected String handleGetValueObjectClassName()
    {
        return getName() + this.getConfiguredProperty(JSFGlobals.CRUD_VALUE_OBJECT_SUFFIX);
    }

    /**
     * @return formSerialVersionUID
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getFormSerialVersionUID()
     */
    protected String handleGetFormSerialVersionUID()
    {
        final StringBuilder buffer = new StringBuilder();
        buffer.append(this.getFormBeanType());
        addSerialUIDData(buffer);
        return JSFUtils.calcSerialVersionUID(buffer);
    }

    /**
     * @return actionSerialVersionUID
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getActionSerialVersionUID()
     */
    protected String handleGetActionSerialVersionUID()
    {
        final StringBuilder buffer = new StringBuilder();
        buffer.append(this.getActionFullPath());
        addSerialUIDData(buffer);
        return JSFUtils.calcSerialVersionUID(buffer);
    }

    /**
     * @return populatorName
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getPopulatorName()
     */
    protected String handleGetPopulatorName()
    {
        return ObjectUtils.toString(this.getConfiguredProperty(JSFGlobals.VIEW_POPULATOR_PATTERN)).replaceAll("\\{0\\}", StringUtilsHelper.upperCamelCaseName(this.getFormBeanClassName()));
    }

    /**
     * @return '/' + StringUtils.replace(getPopulatorType(), getNamespaceProperty(), "/")
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getPopulatorFullPath()
     */
    protected String handleGetPopulatorFullPath()
    {
        return '/' + StringUtils.replace(this.getPopulatorType(), this.getNamespaceProperty(), "/");
    }

    /**
     * @return getManageablePackageName() + getNamespaceProperty() + getPopulatorName()
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getPopulatorType()
     */
    protected String handleGetPopulatorType()
    {
        return this.getManageablePackageName() + this.getNamespaceProperty() + this.getPopulatorName();
    }

    /**
     * @return '/' + getManageablePackagePath() + '/' + getViewName()
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getViewFullPath()
     */
    protected String handleGetViewFullPath()
    {
        return '/' + this.getManageablePackagePath() + '/' + this.getViewName();
    }

    /**
     * @return '/' + getManageablePackagePath() + '/' + getName().toLowerCase() + "-ods-export"
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getViewFullPath()
     */
    protected String handleGetOdsExportFullPath()
    {
        return '/' + this.getManageablePackagePath() + '/' + this.getName().toLowerCase() + "-ods-export";
    }

    /**
     * @return isValidationRequired
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#isValidationRequired()
     */
    protected boolean handleIsValidationRequired()
    {
        for (final ManageableEntityAttribute attribute : this.getManageableAttributes())
        {
            if (attribute instanceof JSFManageableEntityAttribute)
            {
                final JSFManageableEntityAttribute jsfAttribute = (JSFManageableEntityAttribute) attribute;
                if (jsfAttribute.isValidationRequired())
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @return searchFormBeanName
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getSearchFormBeanName()
     */
    protected String handleGetSearchFormBeanName()
    {
        final String pattern = ObjectUtils.toString(this.getConfiguredProperty(JSFGlobals.FORM_BEAN_PATTERN));
        final String formBeanName = pattern.replaceFirst("\\{0\\}", "manage");
        return formBeanName.replaceFirst("\\{1\\}", this.getName() + "Search");
    }

    /**
     * @return searchFormBeanType
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getSearchFormBeanType()
     */
    protected String handleGetSearchFormBeanType()
    {
        return this.getManageablePackageName() + this.getNamespaceProperty() + this.getSearchFormBeanClassName();
    }

    /**
     * @return searchFormBeanFullPath
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getSearchFormBeanFullPath()
     */
    protected String handleGetSearchFormBeanFullPath()
    {
        return StringUtils.replace(this.getSearchFormBeanType(), this.getNamespaceProperty(), "/");
    }

    /**
     * @return StringUtils.capitalize(this.getSearchFormBeanName())
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getSearchFormBeanClassName()
     */
    protected String handleGetSearchFormBeanClassName()
    {
        return StringUtils.capitalize(this.getSearchFormBeanName());
    }

    /**
     * @return manageableSearchAttributes
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getManageableSearchAttributes()
     */
    protected Collection<JSFManageableEntityAttribute> handleGetManageableSearchAttributes()
    {
        final Collection<JSFManageableEntityAttribute> coll = new ArrayList<JSFManageableEntityAttribute>();
        for (final ManageableEntityAttribute attribute : getManageableAttributes())
        {
            if (attribute instanceof JSFManageableEntityAttribute)
            {
                final JSFManageableEntityAttribute attr = (JSFManageableEntityAttribute) attribute;
                if (!attr.isHidden())
                    coll.add(attr);
            }
        }
        return coll;
    }

    /**
     * @return getManageableAssociationEnds()
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getManageableSearchAssociationEnds()
     */
    protected Collection<ManageableEntityAssociationEnd> handleGetManageableSearchAssociationEnds()
    {
        return getManageableAssociationEnds();
    }

    /**
     * @param element
     * @return isSearchable
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#isSearchable(Object)
     */
    protected boolean handleIsSearchable(Object element)
    {
        // if(element instanceof JSFManageableEntityAttribute)
        // return getManageableSearchAttributes().contains(element);
        // else
        // return getManageableSearchAssociationEnds().contains(element);

        // TODO corrigir

        if (element instanceof JSFManageableEntityAttribute)
        {
            return !((JSFManageableEntityAttribute) element).isHidden();
        } else
        {
            return true;
        }
    }

    /**
     * @return the configured property denoting the character sequence to use for the separation of namespaces
     */
    private String getNamespaceProperty()
    {
        return (String) this.getConfiguredProperty(UMLMetafacadeProperties.NAMESPACE_SEPARATOR);
    }

    private void addSerialUIDData(StringBuilder buffer)
    {
        for (final ManageableEntityAttribute attribute : this.getManageableAttributes())
        {
            buffer.append(attribute.getName());
        }
        for (final ManageableEntityAssociationEnd end : this.getManageableAssociationEnds())
        {
            buffer.append(end.getName());
        }
    }

    /**
     * @return allRoles
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getRoles()
     */
    protected Collection handleGetRoles()
    {
        // copied form the Service <<Metafacade>>
        final Collection roles = new ArrayList(this.getTargetDependencies());
        CollectionUtils.filter(roles, new Predicate()
        {
            public boolean evaluate(final Object object)
            {
                DependencyFacade dependency = (DependencyFacade) object;
                return dependency != null && dependency.getSourceElement() instanceof Role;
            }
        });
        CollectionUtils.transform(roles, new Transformer()
        {
            public Object transform(final Object object)
            {
                return ((DependencyFacade) object).getSourceElement();
            }
        });
        final Collection allRoles = new LinkedHashSet(roles);
        // add all roles which are generalizations of this one
        CollectionUtils.forAllDo(roles, new Closure()
        {
            public void execute(final Object object)
            {
                allRoles.addAll(((Role) object).getAllSpecializations());
            }
        });
        return allRoles;
    }

    /**
     * @return actionRoles
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getActionRoles()
     */
    protected String handleGetActionRoles()
    {
        // copied from JSFUseCaseLogicImpl
        final StringBuilder rolesBuffer = new StringBuilder();
        boolean first = true;
        for (final Role role : this.getRoles())
        {
            if (first)
            {
                first = false;
            } else
            {
                rolesBuffer.append(',');
            }
            rolesBuffer.append(role.getName());
        }
        return rolesBuffer.toString();
    }

    /**
     * @return needsFileUpload
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#isNeedsFileUpload()
     */
    protected boolean handleIsNeedsFileUpload()
    {
        for (final ManageableEntityAttribute attribute : this.getManageableAttributes())
        {
            if (attribute instanceof JSFManageableEntityAttribute)
            {
                final JSFManageableEntityAttribute jsfAttribute = (JSFManageableEntityAttribute) attribute;
                if (jsfAttribute.isNeedsFileUpload())
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @return needsUserInterface
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#isNeedsUserInterface()
     */
    protected boolean handleIsNeedsUserInterface()
    {
        for (final ManageableEntityAttribute attribute : this.getManageableAttributes())
        {
            if (attribute instanceof JSFManageableEntityAttribute)
            {
                final JSFManageableEntityAttribute jsfAttribute = (JSFManageableEntityAttribute) attribute;
                if (!jsfAttribute.isHidden())
                {
                    return true;
                }
            }
        }
        for (final ManageableEntityAssociationEnd associationEnd : this.getManageableAssociationEnds())
        {
            if (associationEnd instanceof JSFManageableEntityAssociationEnd)
            {
                final JSFManageableEntityAssociationEnd jsfAssociationEnd = (JSFManageableEntityAssociationEnd) associationEnd;
                if (!jsfAssociationEnd.isDisplay())
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @return converterClassName
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getConverterClassName
     */
    public String handleGetConverterClassName()
    {
        return StringUtils.replace(ObjectUtils.toString(this.getConfiguredProperty(JSFGlobals.CONVERTER_PATTERN)), "{0}", this.getName());
    }

    /**
     * @return converterType
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getConverterType
     */
    public String handleGetConverterType()
    {
        return this.getManageablePackageName() + this.getNamespaceProperty() + this.getConverterClassName();
    }

    /**
     * @return converterFullPath
     * @see org.andromda.cartridges.jsf.metafacades.JSFManageableEntity#getConverterFullPath
     */
    public String handleGetConverterFullPath()
    {
        return StringUtils.replace(this.getConverterType(), this.getNamespaceProperty(), "/");
    }
}
