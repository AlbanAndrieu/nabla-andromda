// license-header java merge-point
// Generated by andromda-jsf cartridge (utils\Messages.java.vsl) DO NOT EDIT!
package org.andromda.presentation.gui;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;

/**
 * Provides access to the application resource messages.
 */
public class Messages
    implements Serializable
{
    private static final long serialVersionUID = 1L;

    /**
     * The messages bundle name.
     */
    private static final String BUNDLE_NAME = "message-resources";

    /**
     * Gets the message given the <code>key</code> by substituting
     * any required <code>arguments</code>.
     *
     * @param key the message key.
     * @param arguments any message arguments to substitute.
     * @return the message (or key if the message isn't found).
     */
    public static String get(String key, Object[] arguments)
    {
        String resourceString = null;
        if (key != null)
        {
            FacesContext context = FacesContext.getCurrentInstance();
            try
            {
                Locale locale;
                if (context != null && context.getViewRoot() != null)
                {
                    locale = context.getViewRoot().getLocale();
                }
                else
                {
                    locale = Locale.getDefault();
                }
                final ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);
                resourceString = bundle.getString(key);
                if (arguments != null)
                {
                    final MessageFormat format = new MessageFormat(resourceString, locale);
                    resourceString = format.format(arguments);
                }
            }
            catch (final MissingResourceException exception)
            {
                resourceString = key;
            }
        }
        return resourceString;
    }

    /**
     * Gets the message given the <code>key</code>.
     *
     * @param key the message key.
     * @return the message (or key if the message isn't found).
     */
    public static String get(String key)
    {
        return get(key, (Object[])null);
    }
}
