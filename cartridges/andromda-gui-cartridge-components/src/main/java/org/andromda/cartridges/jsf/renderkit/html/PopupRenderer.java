/*
 * Copyright (c) 2002-2004, Nabla
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Nabla' nor 'Alban' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package org.andromda.cartridges.jsf.renderkit.html;

import org.andromda.cartridges.jsf.Constants;
import org.andromda.cartridges.jsf.component.html.HtmlPopupFrame;
import org.andromda.cartridges.jsf.utils.ComponentUtils;

import java.io.IOException;

import java.util.Iterator;
import java.util.Map;

import javax.faces.component.NamingContainer;
import javax.faces.component.UICommand;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.el.MethodBinding;
import javax.faces.event.ActionEvent;
import javax.faces.render.Renderer;

/**
 * A custom renderer for rendering a popup frame.
 */
public class PopupRenderer extends Renderer
{

    /**
     * hiddenPopupFrame
     */
    public static final String POPUP_FRAME_HIDDEN = "hiddenPopupFrame";

    /**
     * Retrieve the popup resource path (the path within the
     * deployed web application) given the relative <code>path</code>
     *
     * @param path the relative path.
     * @return the complete path including the context path of the application.
     */
    private String getPopupResourcePath(final String path)
    {

        return ComponentUtils.getContextPath(FacesContext.getCurrentInstance().getExternalContext().getRequest()) + Constants.RESOURCE_CONTEXT + path;

    }

    private Object getRequestAttribute(final String attributeName)
    {

        return ComponentUtils.getAttribute(FacesContext.getCurrentInstance().getExternalContext().getRequest(), attributeName);

    }

    private void setRequestAttribute(final String attributeName, final String attributeValue)
    {

        ComponentUtils.setAttribute(FacesContext.getCurrentInstance().getExternalContext().getRequest(), attributeName, attributeValue);

    }

    /**
     * keeps track of whether or not the javascript has been rendered.
     */
    private static final String JS_ATTRIBUTE = "andromda.jsf.js";

    /**
     * @param context
     * @param component
     * @throws IOException
     */
    protected void commonJavascript(final FacesContext context, final UIComponent component) throws IOException
    {

        final ResponseWriter writer = context.getResponseWriter();

        if (this.getRequestAttribute(JS_ATTRIBUTE) == null)
        {

            this.setRequestAttribute(JS_ATTRIBUTE, JS_ATTRIBUTE);
            writer.startElement("script", component);
            writer.writeAttribute("language", "JavaScript", null);
            writer.writeAttribute("src", getPopupResourcePath("/popup/js/popup.js"), null);
            writer.endElement("script");

        }

        writer.startElement("input", null);
        writer.writeAttribute("type", "hidden", null);
        writer.writeAttribute("name", POPUP_FRAME_HIDDEN, null);
        writer.writeAttribute("value", "", null);
        writer.endElement("input");

    }

    private static final String DEFAULT_STYLE = "position:absolute; left:0; top:0; visibility:hidden; border:1px solid black; background-color:#FFFFFF; ";

    /**
     * @see javax.faces.render.Renderer#decode(javax.faces.context.FacesContext, javax.faces.component.UIComponent)
     */
    public void decode(final FacesContext context, final UIComponent component)
    {

        final HtmlPopupFrame command = (HtmlPopupFrame) component;
        final Map parameters = context.getExternalContext().getRequestParameterMap();
        final String popupAction = (String) parameters.get(PopupRenderer.POPUP_FRAME_HIDDEN);

        if ((popupAction != null) && popupAction.equals(getHiddenFieldOpen(command, context)))
        {

            final MethodBinding binding = command.getActionOpen();

            command.setAction(binding);

            final ActionEvent actionEvent = new ActionEvent(command);

            if (command.isImmediate())
            {

                command.queueEventImmediate(actionEvent);

            } else
            {

                command.queueEventNormal(actionEvent);

            }

        } else if ((popupAction != null) && popupAction.equals(getHiddenFieldClose(command, context)))
        {

            final MethodBinding binding = command.getActionClose();

            if (binding != null)
            {

                command.setAction(binding);

                ActionEvent actionEvent = new ActionEvent(command);

                command.queueEventImmediate(actionEvent);

            }

        }

    }

    /**
     * @see javax.faces.render.Renderer#getRendersChildren()
     */
    public boolean getRendersChildren()
    {

        return true;

    }

    private String getHiddenFieldOpen(HtmlPopupFrame command, FacesContext context)
    {

        return command.getClientId(context) + NamingContainer.SEPARATOR_CHAR + UIViewRoot.UNIQUE_ID_PREFIX + "op";

    }

    private String getHiddenFieldClose(HtmlPopupFrame command, FacesContext context)
    {

        return command.getClientId(context) + NamingContainer.SEPARATOR_CHAR + UIViewRoot.UNIQUE_ID_PREFIX + "cl";

    }

    /**
     * @see javax.faces.render.Renderer#encodeBegin(javax.faces.context.FacesContext, javax.faces.component.UIComponent)
     */
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException
    {

        final HtmlPopupFrame command = (HtmlPopupFrame) component;

        if (command.isRendered())
        {

            final UIForm uiform = this.getForm(context, command);

            if (uiform == null)
            {

                throw new RuntimeException("JSF h:form needed to use this component");

            }

            final String formClientId = uiform.getClientId(context);

            // start differences from command link
            final ResponseWriter writer = context.getResponseWriter();

            commonJavascript(context, command);

            writer.startElement("a", command);
            writer.writeAttribute("href", "#", null);

            String form = "document.forms['" + formClientId + "']";

            StringBuilder buffer = new StringBuilder();

            buffer.append("showPopupFrame(");
            buffer.append(form);
            buffer.append(",this,event");
            buffer.append(",'");
            buffer.append(getHiddenFieldClose(command, context));
            buffer.append("','");
            buffer.append((command.getStyleClassFrame() == null) ? "" : command.getStyleClassFrame());
            buffer.append("','");
            buffer.append(DEFAULT_STYLE);
            buffer.append((command.getStyleFrame() == null) ? "" : command.getStyleFrame());
            buffer.append("',");
            buffer.append((command.getMouseHorizPos() == null) ? "0" : command.getMouseHorizPos());
            buffer.append(',');
            buffer.append((command.getMouseVertPos() == null) ? "0" : command.getMouseVertPos());
            buffer.append(',');
            buffer.append((command.getAbsolute() == null) ? "false" : command.getAbsolute());
            buffer.append(',');
            buffer.append((command.getCenter() == null) ? "false" : command.getCenter());
            buffer.append(",'");
            buffer.append((command.getHeight() == null) ? "" : command.getHeight());
            buffer.append("','");
            buffer.append((command.getWidth() == null) ? "" : command.getWidth());
            buffer.append("','");
            buffer.append((command.getScrolling() == null) ? "auto" : command.getScrolling().toLowerCase());
            buffer.append("');");

            buffer.append(form);
            buffer.append(".target='");
            buffer.append("hiddenPopupFrameTarget");
            buffer.append("';");

            buffer.append(form);
            buffer.append(".elements['");
            buffer.append(POPUP_FRAME_HIDDEN);
            buffer.append("'].value='");
            buffer.append(getHiddenFieldOpen(command, context));
            buffer.append("';");

            buffer.append(form);
            buffer.append(".submit();");
            buffer.append(form);
            buffer.append(".elements['");
            buffer.append(POPUP_FRAME_HIDDEN);
            buffer.append("'].value='';");

            buffer.append(form);
            buffer.append(".target='';");

            buffer.append("return false;");

            writer.writeAttribute("onclick", buffer.toString(), null);

            writer.writeAttribute("id", command.getClientId(context), null);

            final String accesskey = command.getAccesskey();

            if (accesskey != null)
            {

                writer.writeAttribute("accesskey", accesskey, "accesskey");

            }

            final String directory = command.getDir();

            if (directory != null)
            {

                writer.writeAttribute("dir", directory, "dir");

            }

            final String lang = command.getLang();

            if (lang != null)
            {

                writer.writeAttribute("lang", lang, "lang");

            }

            final String tabindex = command.getTabindex();

            if (tabindex != null)
            {

                writer.writeAttribute("tabindex", tabindex, "tabindex");

            }

            final String title = command.getTitle();

            if (title != null)
            {

                writer.writeAttribute("title", title, "title");

            }

            final String styleClass = command.getStyleClass();

            if (styleClass != null)
            {

                writer.writeAttribute("class", styleClass, "styleClass");

            }

            final String style = command.getStyle();

            if (style != null)
            {

                writer.writeAttribute("style", style, "style");

            }

            String label = null;
            final Object value = ((UICommand) component).getValue();

            if (value != null)
            {

                label = value.toString();

            }

            if ((label != null) && (label.length() != 0))
            {

                writer.write(label);

            }

            writer.flush();

        }

    }

    /**
     * @see javax.faces.render.Renderer#encodeChildren(javax.faces.context.FacesContext, javax.faces.component.UIComponent)
     */
    public void encodeChildren(final FacesContext context, final UIComponent component) throws IOException
    {

        // - only render if rendered is true
        if (component.isRendered())
        {

            for (Iterator iterator = component.getChildren().iterator(); iterator.hasNext();)
            {

                final UIComponent child = (UIComponent) iterator.next();

                child.encodeBegin(context);

                if (child.getRendersChildren())
                {

                    child.encodeChildren(context);

                }

                child.encodeEnd(context);

            }

        }

    }

    /**
     * @see javax.faces.render.Renderer#encodeEnd(javax.faces.context.FacesContext, javax.faces.component.UIComponent)
     */
    public void encodeEnd(final FacesContext context, final UIComponent component) throws IOException
    {

        final UICommand command = (UICommand) component;

        // - only render if rendered is true
        if (command.isRendered())
        {

            final ResponseWriter writer = context.getResponseWriter();

            // - complete writing Anchor element
            writer.endElement("a");
            writer.flush();

        }

    }

    /**
     * @see javax.faces.render.Renderer#convertClientId(javax.faces.context.FacesContext, String)
     */
    public String convertClientId(final FacesContext context, final String clientId)
    {

        return clientId;

    }

    /**
     * Gets the form to which the <code>component</code> belongs
     * or null if the form can not be found.
     *
     * @param context the faces context.
     * @param component the component.
     * @return the form.
     */
    protected UIForm getForm(final FacesContext context, final UIComponent component)
    {

        UIComponent parent = component.getParent();

        while (parent != null)
        {

            if (parent instanceof UIForm)
            {

                break;

            }

            parent = parent.getParent();

        }

        return (UIForm) parent;

    }

}
