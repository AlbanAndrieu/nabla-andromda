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
package org.andromda.cartridges.jsf.portlet.myfaces.tomahawk.support;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.portlet.PortletContext;
import javax.portlet.PortletSession;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

/**
 * This class is a dummy HttpSessionWrapper.
 * 
 * @author <a href="mailto:shinsuke@yahoo.co.jp">Shinsuke Sugaya</a>
 */
@SuppressWarnings("deprecation")
public class HttpSessionWrapper implements HttpSession
{

    private final PortletSession portletSession;
    private final PortletContext portletContext;

    /**
     * @param portletSession
     * @param portletContext
     */
    public HttpSessionWrapper(final PortletSession portletSession, final PortletContext portletContext)
    {

        this.portletSession = portletSession;
        this.portletContext = portletContext;

    }

    /**
     * @see javax.servlet.http.HttpSession#getCreationTime()
     */
    public long getCreationTime()
    {

        return portletSession.getCreationTime();

    }

    /**
     * @see javax.servlet.http.HttpSession#getId()
     */
    public String getId()
    {

        return portletSession.getId();

    }

    /**
     * @see javax.servlet.http.HttpSession#getLastAccessedTime()
     */
    public long getLastAccessedTime()
    {

        return portletSession.getLastAccessedTime();

    }

    /**
     * @see javax.servlet.http.HttpSession#getServletContext()
     */
    public ServletContext getServletContext()
    {

        return new ServletContextWrapper(portletContext);

    }

    /**
     * @see javax.servlet.http.HttpSession#setMaxInactiveInterval(int)
     */
    public void setMaxInactiveInterval(final int arg0)
    {

        portletSession.setMaxInactiveInterval(arg0);

    }

    /**
     * @see javax.servlet.http.HttpSession#getMaxInactiveInterval()
     */
    public int getMaxInactiveInterval()
    {

        return portletSession.getMaxInactiveInterval();

    }

    /**
     * return null
     * 
     * @see javax.servlet.http.HttpSession#getSessionContext()
     * @deprecated
     */
    @Deprecated
    public HttpSessionContext getSessionContext()
    {

        // TODO Portlet API does not have this method
        return null;

    }

    /**
     * @see javax.servlet.http.HttpSession#getAttribute(String)
     */
    public Object getAttribute(final String arg0)
    {

        return portletSession.getAttribute(arg0);

    }

    /**
     * @see javax.servlet.http.HttpSession#getValue(String)
     * @deprecated
     */
    @Deprecated
    public Object getValue(final String arg0)
    {

        return portletSession.getAttribute(arg0);

    }

    /**
     * @see javax.servlet.http.HttpSession#getAttributeNames()
     */
    public Enumeration getAttributeNames()
    {

        return portletSession.getAttributeNames();

    }

    /**
     * @see javax.servlet.http.HttpSession#getValueNames()
     * @deprecated
     */
    @Deprecated
    public String[] getValueNames()
    {

        final List objs = new ArrayList();

        for (final Enumeration e = portletSession.getAttributeNames(); e.hasMoreElements();)
        {

            final String key = (String) e.nextElement();

            objs.add(key);

        }

        final String[] values = new String[objs.size()];

        for (int i = 0; i < objs.size(); i++)
        {

            values[i] = (String) objs.get(i);

        }

        return values;

    }

    /**
     * @see javax.servlet.http.HttpSession#setAttribute(String, Object)
     */
    public void setAttribute(final String arg0, final Object arg1)
    {

        portletSession.setAttribute(arg0, arg1);

    }

    /**
     * @see javax.servlet.http.HttpSession#putValue(String, Object)
     * @deprecated
     */
    @Deprecated
    public void putValue(final String arg0, final Object arg1)
    {

        portletSession.setAttribute(arg0, arg1);

    }

    /**
     * @see javax.servlet.http.HttpSession#removeAttribute(String)
     */
    public void removeAttribute(final String arg0)
    {

        portletSession.removeAttribute(arg0);

    }

    /**
     * @see javax.servlet.http.HttpSession#removeValue(String)
     * @deprecated
     */
    @Deprecated
    public void removeValue(final String arg0)
    {

        portletSession.removeAttribute(arg0);

    }

    /**
     * @see javax.servlet.http.HttpSession#invalidate()
     */
    public void invalidate()
    {

        portletSession.invalidate();

    }

    /**
     * @see javax.servlet.http.HttpSession#isNew()
     */
    public boolean isNew()
    {

        return portletSession.isNew();

    }

}
