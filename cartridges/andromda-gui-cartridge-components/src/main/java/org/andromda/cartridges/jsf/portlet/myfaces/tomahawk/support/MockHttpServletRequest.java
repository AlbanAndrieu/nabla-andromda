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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.security.Principal;

import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 */
public class MockHttpServletRequest implements HttpServletRequest
{

    /**
     * @see javax.servlet.http.HttpServletRequest#getAuthType()
     */
    public String getAuthType()
    {

        return null;

    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getContextPath()
     */
    public String getContextPath()
    {

        return null;

    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getCookies()
     */
    public Cookie[] getCookies()
    {

        return new Cookie[0];

    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getDateHeader(String)
     */
    public long getDateHeader(String arg0)
    {

        return 0;

    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getHeader(String)
     */
    public String getHeader(String arg0)
    {

        return null;

    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getHeaderNames()
     */
    public Enumeration getHeaderNames()
    {

        return null;

    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getHeaders(String)
     */
    public Enumeration getHeaders(String arg0)
    {

        return null;

    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getIntHeader(String)
     */
    public int getIntHeader(String arg0)
    {

        return 0;

    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getMethod()
     */
    public String getMethod()
    {

        return null;

    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getPathInfo()
     */
    public String getPathInfo()
    {

        return null;

    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getPathTranslated()
     */
    public String getPathTranslated()
    {

        return null;

    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getQueryString()
     */
    public String getQueryString()
    {

        return null;

    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getRemoteUser()
     */
    public String getRemoteUser()
    {

        return null;

    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getRequestURI()
     */
    public String getRequestURI()
    {

        return null;

    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getRequestURL()
     */
    public StringBuffer getRequestURL()
    {

        return null;

    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getRequestedSessionId()
     */
    public String getRequestedSessionId()
    {

        return null;

    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getServletPath()
     */
    public String getServletPath()
    {

        return null;

    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getSession()
     */
    public HttpSession getSession()
    {

        return null;

    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getSession(boolean)
     */
    public HttpSession getSession(boolean arg0)
    {

        return null;

    }

    /**
     * @see javax.servlet.http.HttpServletRequest#getUserPrincipal()
     */
    public Principal getUserPrincipal()
    {

        return null;

    }

    /**
     * @see javax.servlet.http.HttpServletRequest#isRequestedSessionIdFromCookie()
     */
    public boolean isRequestedSessionIdFromCookie()
    {

        return false;

    }

    /**
     * @see javax.servlet.http.HttpServletRequest#isRequestedSessionIdFromURL()
     */
    public boolean isRequestedSessionIdFromURL()
    {

        return false;

    }

    /**
     * @see javax.servlet.http.HttpServletRequest#isRequestedSessionIdFromUrl()
     * @deprecated
     */
    @Deprecated
    public boolean isRequestedSessionIdFromUrl()
    {

        return false;

    }

    /**
     * @see javax.servlet.http.HttpServletRequest#isRequestedSessionIdValid()
     */
    public boolean isRequestedSessionIdValid()
    {

        return false;

    }

    /**
     * @see javax.servlet.http.HttpServletRequest#isUserInRole(String)
     */
    public boolean isUserInRole(String arg0)
    {

        return false;

    }

    /**
     * @see javax.servlet.ServletRequest#getAttribute(String)
     */
    public Object getAttribute(String arg0)
    {

        return null;

    }

    /**
     * @see javax.servlet.ServletRequest#getAttributeNames()
     */
    public Enumeration getAttributeNames()
    {

        return null;

    }

    /**
     * @see javax.servlet.ServletRequest#getCharacterEncoding()
     */
    public String getCharacterEncoding()
    {

        return null;

    }

    /**
     * @see javax.servlet.ServletRequest#getContentLength()
     */
    public int getContentLength()
    {

        return 0;

    }

    /**
     * @see javax.servlet.ServletRequest#getContentType()
     */
    public String getContentType()
    {

        return null;

    }

    /**
     * @see javax.servlet.ServletRequest#getInputStream()
     */
    public ServletInputStream getInputStream() throws IOException
    {

        return null;

    }

    /**
     * @see javax.servlet.ServletRequest#getLocalAddr()
     */
    public String getLocalAddr()
    {

        return null;

    }

    /**
     * @see javax.servlet.ServletRequest#getLocalName()
     */
    public String getLocalName()
    {

        return null;

    }

    /**
     * @see javax.servlet.ServletRequest#getLocalPort()
     */
    public int getLocalPort()
    {

        return 0;

    }

    /**
     * @see javax.servlet.ServletRequest#getLocale()
     */
    public Locale getLocale()
    {

        return null;

    }

    /**
     * @see javax.servlet.ServletRequest#getLocales()
     */
    public Enumeration getLocales()
    {

        return null;

    }

    /**
     * @see javax.servlet.ServletRequest#getParameter(String)
     */
    public String getParameter(String arg0)
    {

        return null;

    }

    /**
     * @see javax.servlet.ServletRequest#getParameterMap()
     */
    public Map getParameterMap()
    {

        return null;

    }

    /**
     * @see javax.servlet.ServletRequest#getParameterNames()
     */
    public Enumeration getParameterNames()
    {

        return null;

    }

    /**
     * @see javax.servlet.ServletRequest#getParameterValues(String)
     */
    public String[] getParameterValues(String arg0)
    {

        return new String[0];

    }

    /**
     * @see javax.servlet.ServletRequest#getProtocol()
     */
    public String getProtocol()
    {

        return null;

    }

    /**
     * @see javax.servlet.ServletRequest#getReader()
     */
    public BufferedReader getReader() throws IOException
    {

        return null;

    }

    /**
     * @see javax.servlet.ServletRequest#getRealPath(String)
     * @deprecated
     */
    @Deprecated
    public String getRealPath(String arg0)
    {

        return null;

    }

    /**
     * @see javax.servlet.ServletRequest#getRemoteAddr()
     */
    public String getRemoteAddr()
    {

        return null;

    }

    /**
     * @see javax.servlet.ServletRequest#getRemoteHost()
     */
    public String getRemoteHost()
    {

        return null;

    }

    /**
     * @see javax.servlet.ServletRequest#getRemotePort()
     */
    public int getRemotePort()
    {

        return 0;

    }

    /**
     * @see javax.servlet.ServletRequest#getRequestDispatcher(String)
     */
    public RequestDispatcher getRequestDispatcher(String arg0)
    {

        return null;

    }

    /**
     * @see javax.servlet.ServletRequest#getScheme()
     */
    public String getScheme()
    {

        return null;

    }

    /**
     * @see javax.servlet.ServletRequest#getServerName()
     */
    public String getServerName()
    {

        return null;

    }

    /**
     * @see javax.servlet.ServletRequest#getServerPort()
     */
    public int getServerPort()
    {

        return 0;

    }

    /**
     * @see javax.servlet.ServletRequest#isSecure()
     */
    public boolean isSecure()
    {

        return false;

    }

    /**
     * @see javax.servlet.ServletRequest#removeAttribute(String)
     */
    public void removeAttribute(String arg0)
    {

    }

    /**
     * @see javax.servlet.ServletRequest#setAttribute(String, Object)
     */
    public void setAttribute(String arg0, Object arg1)
    {

    }

    /**
     * @see javax.servlet.ServletRequest#setCharacterEncoding(String)
     */
    public void setCharacterEncoding(String arg0) throws UnsupportedEncodingException
    {

    }

}
