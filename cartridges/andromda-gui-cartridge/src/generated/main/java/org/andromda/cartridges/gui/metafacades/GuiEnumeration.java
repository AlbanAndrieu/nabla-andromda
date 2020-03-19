// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.gui.metafacades;

import org.andromda.metafacades.uml.EnumerationFacade;

/**
 * Represents an enumeration used within a JSF application.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface GuiEnumeration
    extends EnumerationFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isGuiEnumerationMetaType();

    /**
     * The converter name used for this enumeration.
     * @return String
     */
    public String getConverterName();

    /**
     * The path to the converter file.
     * @return String
     */
    public String getConverterPath();

    /**
     * The fully qualified converter name for this enumeration.
     * @return String
     */
    public String getFullyQualifiedConverterName();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.gui.metafacades.GuiEnumeration.messageKey
     * @return String
     */
    public String getMessageKey();
}
