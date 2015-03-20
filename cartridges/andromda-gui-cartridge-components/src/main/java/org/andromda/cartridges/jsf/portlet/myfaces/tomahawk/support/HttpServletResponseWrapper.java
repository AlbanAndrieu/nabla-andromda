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

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.Locale;

import javax.portlet.PortletURL;
import javax.portlet.RenderResponse;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * This class is a dummy HttpServletResponse.
 * 
 * @author <a href="mailto:shinsuke@yahoo.co.jp">Shinsuke Sugaya</a>
 */
public class HttpServletResponseWrapper implements HttpServletResponse, RenderResponse
{

    private final RenderResponse renderResponse;

    /**
     * @param renderResponse
     */
    public HttpServletResponseWrapper(final RenderResponse renderResponse)
    {

        this.renderResponse = renderResponse;

    }

    /**
     * @return renderResponse.getWriter()
     * @throws IOException
     * @see javax.servlet.ServletResponseWrapper#getWriter()
     */
    public PrintWriter getWriter() throws IOException
    {

        return renderResponse.getWriter();

    }

    /**
     * Returns writer to which MyFaces' AddResource stores elements.
     * 
     * @return writer which has elements, such as &lt;script&gt; and
     * &lt;link&gt; public StringWriter getStringWriter() { return
     * (StringWriter) writer; }
     */

    /**
     * @see javax.servlet.ServletResponse#flushBuffer()
     */
    public void flushBuffer() throws IOException
    {

        if (renderResponse != null)
        {

            renderResponse.flushBuffer();

        }

    }

    /**
     * @see javax.servlet.ServletResponse#getBufferSize()
     */
    public int getBufferSize()
    {

        if (renderResponse != null)
        {

            return renderResponse.getBufferSize();

        }

        return 0;

    }

    /**
     * @see javax.servlet.ServletResponse#getCharacterEncoding()
     */
    public String getCharacterEncoding()
    {

        if (renderResponse != null)
        {

            return renderResponse.getCharacterEncoding();

        }

        return null;

    }

    /**
     * @see javax.servlet.ServletResponse#getLocale()
     */
    public Locale getLocale()
    {

        if (renderResponse != null)
        {

            return renderResponse.getLocale();

        }

        return null;

    }

    /**
     * @see javax.servlet.ServletResponse#getOutputStream()
     */
    public ServletOutputStream getOutputStream() throws IOException
    {

        if (renderResponse != null)
        {

            return new ServletOutputStreamWrapper(renderResponse.getPortletOutputStream());

        }

        return null;

    }

    /**
     * @see javax.servlet.ServletResponse#isCommitted()
     */
    public boolean isCommitted()
    {

        if (renderResponse != null)
        {

            return renderResponse.isCommitted();

        }

        return false;

    }

    /**
     * @see javax.servlet.ServletResponse#reset()
     */
    public void reset()
    {

        if (renderResponse != null)
        {

            renderResponse.reset();

        }

    }

    /**
     * @see javax.servlet.ServletResponse#resetBuffer()
     */
    public void resetBuffer()
    {

        if (renderResponse != null)
        {

            renderResponse.resetBuffer();

        }

    }

    /**
     * @see javax.servlet.ServletResponse#setBufferSize(int)
     */
    public void setBufferSize(final int arg0)
    {

        renderResponse.setBufferSize(arg0);

    }

    /**
     * @see javax.servlet.ServletResponse#setContentLength(int)
     */
    public void setContentLength(final int arg0)
    {

    }

    /**
     * @see javax.servlet.ServletResponse#setContentType(String)
     */
    public void setContentType(final String arg0)
    {

        if (renderResponse != null)
        {

            renderResponse.setContentType(arg0);

        }

    }

    /**
     * @see javax.servlet.ServletResponse#setLocale(java.util.Locale)
     */
    public void setLocale(final Locale arg0)
    {

    }

    /**
     * @see javax.servlet.http.HttpServletResponse#addCookie(javax.servlet.http.Cookie)
     */
    public void addCookie(final Cookie arg0)
    {

    }

    /**
     * @see javax.servlet.http.HttpServletResponse#addDateHeader(String, long)
     */
    public void addDateHeader(final String arg0, final long arg1)
    {

    }

    /**
     * @see javax.servlet.http.HttpServletResponse#addHeader(String, String)
     */
    public void addHeader(final String arg0, final String arg1)
    {

    }

    /**
     * @see javax.servlet.http.HttpServletResponse#addIntHeader(String, int)
     */
    public void addIntHeader(final String arg0, final int arg1)
    {

    }

    /**
     * @see javax.servlet.http.HttpServletResponse#containsHeader(String)
     */
    public boolean containsHeader(final String arg0)
    {

        return false;

    }

    /**
     * @see javax.servlet.http.HttpServletResponse#encodeRedirectUrl(String)
     * @deprecated
     */
    @Deprecated
    public String encodeRedirectUrl(final String arg0)
    {

        return null;

    }

    /**
     * @see javax.servlet.http.HttpServletResponse#encodeRedirectURL(String)
     */
    public String encodeRedirectURL(final String arg0)
    {

        return null;

    }

    /**
     * @see javax.servlet.http.HttpServletResponse#encodeUrl(String)
     * @deprecated
     */
    @Deprecated
    public String encodeUrl(final String arg0)
    {

        if (renderResponse != null)
        {

            return renderResponse.encodeURL(arg0);

        }

        return null;

    }

    /**
     * @see javax.servlet.http.HttpServletResponse#encodeURL(String)
     */
    public String encodeURL(final String arg0)
    {

        return renderResponse.encodeURL(arg0);

    }

    /**
     * @see javax.servlet.http.HttpServletResponse#sendError(int, String)
     */
    public void sendError(final int arg0, final String arg1) throws IOException
    {

    }

    /**
     * @see javax.servlet.http.HttpServletResponse#sendError(int)
     */
    public void sendError(final int arg0) throws IOException
    {

    }

    /**
     * @see javax.servlet.http.HttpServletResponse#sendRedirect(String)
     */
    public void sendRedirect(final String arg0) throws IOException
    {

    }

    /**
     * @see javax.servlet.http.HttpServletResponse#setDateHeader(String, long)
     */
    public void setDateHeader(final String arg0, final long arg1)
    {

    }

    /**
     * @see javax.servlet.http.HttpServletResponse#setHeader(String, String)
     */
    public void setHeader(final String arg0, final String arg1)
    {

    }

    /**
     * @see javax.servlet.http.HttpServletResponse#setIntHeader(String, int)
     */
    public void setIntHeader(final String arg0, final int arg1)
    {

    }

    /**
     * @see javax.servlet.http.HttpServletResponse#setStatus(int, String)
     * @deprecated
     */
    @Deprecated
    public void setStatus(final int arg0, final String arg1)
    {

    }

    /**
     * @see javax.servlet.http.HttpServletResponse#setStatus(int)
     */
    public void setStatus(final int arg0)
    {

    }

    /**
     * @see javax.portlet.PortletResponse#addProperty(String, String)
     */
    public void addProperty(final String arg0, final String arg1)
    {

        renderResponse.addProperty(arg0, arg1);

    }

    /**
     * @see javax.portlet.PortletResponse#setProperty(String, String)
     */
    public void setProperty(final String arg0, final String arg1)
    {

        renderResponse.setProperty(arg0, arg1);

    }

    /**
     * @see javax.servlet.ServletResponse#getContentType()
     */
    public String getContentType()
    {

        if (renderResponse != null)
        {

            return renderResponse.getContentType();

        }

        return null;

    }

    /**
     * @see javax.servlet.ServletResponse#setCharacterEncoding(String)
     */
    public void setCharacterEncoding(final String arg0)
    {

    }

    /**
     * @see javax.portlet.RenderResponse#createActionURL()
     */
    public PortletURL createActionURL()
    {

        return renderResponse.createActionURL();

    }

    /**
     * @see javax.portlet.RenderResponse#createRenderURL()
     */
    public PortletURL createRenderURL()
    {

        return renderResponse.createRenderURL();

    }

    /**
     * @see javax.portlet.RenderResponse#getNamespace()
     */
    public String getNamespace()
    {

        return renderResponse.getNamespace();

    }

    /**
     * @see javax.portlet.RenderResponse#getPortletOutputStream()
     */
    public OutputStream getPortletOutputStream() throws IOException
    {

        return renderResponse.getPortletOutputStream();

    }

    /**
     * @see javax.portlet.RenderResponse#setTitle(String)
     */
    public void setTitle(final String title)
    {

        renderResponse.setTitle(title);

    }

    /**
     * @return renderResponse
     */
    public RenderResponse getResponse()
    {

        return renderResponse;

    }

}
