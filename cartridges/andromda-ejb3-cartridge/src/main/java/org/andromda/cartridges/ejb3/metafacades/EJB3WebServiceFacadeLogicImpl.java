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
package org.andromda.cartridges.ejb3.metafacades;

import java.text.MessageFormat;

import org.andromda.cartridges.ejb3.EJB3Globals;
import org.andromda.cartridges.ejb3.EJB3Profile;
import org.andromda.cartridges.ejb3.EJB3ScriptHelper;
import org.andromda.metafacades.uml.OperationFacade;
import org.andromda.metafacades.uml.UMLProfile;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.lang.StringUtils;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceFacade.
 * 
 * @see EJB3WebServiceFacade
 */
public class EJB3WebServiceFacadeLogicImpl extends EJB3WebServiceFacadeLogic
{
    private static final long   serialVersionUID                   = 34L;
    /**
     * The property which stores the pattern defining the web service interface name.
     */
    private static final String WEB_SERVICE_INTERFACE_NAME_PATTERN = "webServiceInterfaceNamePattern";

    /**
     * The property defining the default style to give the web services.
     */
    private static final String PROPERTY_DEFAULT_STYLE             = "webServiceDefaultStyle";

    /**
     * Represents a "document" style.
     */
    private static final String STYLE_DOCUMENT                     = "document";

    /**
     * Represents a "rpc" style.
     */
    private static final String STYLE_RPC                          = "rpc";

    /**
     * The property defining the default style to give the web services.
     */
    private static final String PROPERTY_DEFAULT_USE               = "webServiceDefaultUse";

    /**
     * Represents a "literal" use.
     */
    private static final String USE_LITERAL                        = "literal";

    /**
     * Represents an "encoded" use.
     */
    private static final String USE_ENCODED                        = "encoded";

    /**
     * Represents the default parameter encoding style
     */
    private static final String PROPERTY_DEFAULT_PARAMETER_STYLE   = "webServiceDefaultParameterStyle";

    /**
     * Represents a "wrapped" parameter style.
     */
    private static final String PARAMETER_STYLE_WRAPPED            = "wrapped";

    /**
     * Represents a "bare" parameter style.
     */
    private static final String PARAMETER_STYLE_BARE               = "bare";

    /**
     * Represents the qualified name local part pattern
     */
    private static final String QNAME_LOCAL_PART_PATTERN           = "webServiceQualifiedNameLocalPartPattern";

    /**
     * Determine if the namespace should be reversed
     */
    private static final String REVERSE_NAMESPACE                  = "webServiceReverseNamespace";

    /**
     * Retrieve the namespace pattern used to generate the namespace
     */
    private static final String NAMESPACE_PATTERN                  = "webServiceNamespacePattern";

    /**
     * @param metaObject
     * @param context
     */
    public EJB3WebServiceFacadeLogicImpl(final Object metaObject, final String context)
    {
        super(metaObject, context);
    }

    /**
     * @see EJB3WebServiceFacade#getFullyQualifiedWebServiceInterfaceName()
     */
    @Override
    protected String handleGetFullyQualifiedWebServiceInterfaceName()
    {
        return EJB3MetafacadeUtils.getFullyQualifiedName(this.getPackageName(), this.getWebServiceInterfaceName(), null);
    }

    /**
     * @see EJB3WebServiceFacade#getWebServiceInterfaceName()
     */
    @Override
    protected String handleGetWebServiceInterfaceName()
    {
        String webServiceInterfaceNamePattern = String.valueOf(this.getConfiguredProperty(WEB_SERVICE_INTERFACE_NAME_PATTERN));

        return MessageFormat.format(webServiceInterfaceNamePattern, StringUtils.trimToEmpty(this.getName()));
    }

    /**
     * @see EJB3WebServiceFacade#getStyle()
     */
    @Override
    protected String handleGetStyle()
    {
        String style = (String) this.findTaggedValue(UMLProfile.TAGGEDVALUE_WEBSERVICE_STYLE);
        if (StringUtils.isBlank(style))
        {
            style = String.valueOf(this.getConfiguredProperty(PROPERTY_DEFAULT_STYLE));
        }
        return style;
    }

    /**
     * @see EJB3WebServiceFacade#getUse()
     */
    @Override
    protected String handleGetUse()
    {
        String use = (String) this.findTaggedValue(UMLProfile.TAGGEDVALUE_WEBSERVICE_USE);
        if (StringUtils.isBlank(use))
        {
            use = String.valueOf(this.getConfiguredProperty(PROPERTY_DEFAULT_USE));
        }
        return use;
    }

    /**
     * @see EJB3WebServiceFacade#isRpcStyle()
     */
    @Override
    protected boolean handleIsRpcStyle()
    {
        return STYLE_RPC.equalsIgnoreCase(this.getStyle());
    }

    /**
     * @see EJB3WebServiceFacade#isDocumentStyle()
     */
    @Override
    protected boolean handleIsDocumentStyle()
    {
        return STYLE_DOCUMENT.equalsIgnoreCase(this.getStyle());
    }

    /**
     * @see EJB3WebServiceFacade#isEncodedUse()
     */
    @Override
    protected boolean handleIsEncodedUse()
    {
        return USE_ENCODED.equalsIgnoreCase(this.getStyle());
    }

    /**
     * @see EJB3WebServiceFacade#isLiteralUse()
     */
    @Override
    protected boolean handleIsLiteralUse()
    {
        return USE_LITERAL.equalsIgnoreCase(this.getStyle());
    }

    /**
     * @see EJB3WebServiceFacadeLogic#handleIsWebServiceOperationsExist()
     */
    @Override
    protected boolean handleIsWebServiceOperationsExist()
    {
        return CollectionUtils.find(this.getOperations(), new Predicate()
        {
            public boolean evaluate(final Object object)
            {
                boolean isWebService = false;
                final OperationFacade operation = (OperationFacade) object;
                if (operation.hasStereotype(UMLProfile.STEREOTYPE_WEBSERVICE_OPERATION))
                {
                    isWebService = true;
                }
                return isWebService;
            }
        }) != null;
    }

    /**
     * @see EJB3WebServiceFacadeLogic#handleGetParameterStyle()
     */
    @Override
    protected String handleGetParameterStyle()
    {
        String parameterStyle = (String) this.findTaggedValue(EJB3Profile.TAGGEDVALUE_WEBSERVICE_PARAMETER_STYLE);
        if (StringUtils.isBlank(parameterStyle))
        {
            parameterStyle = String.valueOf(this.getConfiguredProperty(PROPERTY_DEFAULT_PARAMETER_STYLE));
        }
        return parameterStyle;
    }

    /**
     * @see EJB3WebServiceFacadeLogic#handleIsWrappedParameterStyle()
     */
    @Override
    protected boolean handleIsWrappedParameterStyle()
    {
        return PARAMETER_STYLE_WRAPPED.equalsIgnoreCase(this.getParameterStyle());
    }

    /**
     * @see EJB3WebServiceFacadeLogic#handleIsBareParameterStyle()
     */
    @Override
    protected boolean handleIsBareParameterStyle()
    {
        return PARAMETER_STYLE_BARE.equalsIgnoreCase(this.getParameterStyle());
    }

    /**
     * @see EJB3WebServiceFacadeLogic#handleGetQName()
     */
    @Override
    protected String handleGetQName()
    {
        String qnameLocalPartPattern = String.valueOf(this.getConfiguredProperty(QNAME_LOCAL_PART_PATTERN));
        return MessageFormat.format(qnameLocalPartPattern, StringUtils.trimToEmpty(this.getName()));
    }

    /**
     * @see EJB3WebServiceFacadeLogic#handleGetNamespace()
     */
    @Override
    protected String handleGetNamespace()
    {
        String packageName = this.getPackageName();
        if (this.isReverseNamespace())
        {
            packageName = EJB3ScriptHelper.reversePackage(packageName);
        }
        String namespacePattern = String.valueOf(this.getConfiguredProperty(NAMESPACE_PATTERN));
        return MessageFormat.format(namespacePattern, StringUtils.trimToEmpty(StringUtils.substringBeforeLast(packageName, String.valueOf(EJB3Globals.NAMESPACE_DELIMITER))),
                StringUtils.trimToEmpty(StringUtils.substringAfterLast(packageName, String.valueOf(EJB3Globals.NAMESPACE_DELIMITER))));
    }

    /**
     * Gets whether or not <code>reverseNamespace</code> is true/false for this type.
     * 
     * @return boolean true/false
     */
    protected boolean isReverseNamespace()
    {
        return Boolean.valueOf(String.valueOf(this.getConfiguredProperty(REVERSE_NAMESPACE))).booleanValue();
    }
}
