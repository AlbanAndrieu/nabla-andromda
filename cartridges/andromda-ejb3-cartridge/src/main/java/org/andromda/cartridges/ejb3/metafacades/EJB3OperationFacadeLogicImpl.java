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
import org.andromda.metafacades.uml.UMLProfile;
import org.apache.commons.lang.StringUtils;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.ejb3.metafacades.EJB3OperationFacade.
 * 
 * @see EJB3OperationFacade
 */
public class EJB3OperationFacadeLogicImpl extends EJB3OperationFacadeLogic
{
    private static final long serialVersionUID = 34L;

    // ---------------- constructor -------------------------------
    /**
     * @param metaObject
     * @param context
     */
    public EJB3OperationFacadeLogicImpl(final Object metaObject, final String context)
    {
        super(metaObject, context);
    }

    // ---------------- methods -------------------------------

    /**
     * @see EJB3OperationFacade#isBusinessOperation()
     */
    @Override
    protected boolean handleIsBusinessOperation()
    {
        return !this.isCreateMethod() && !this.isFinderMethod() && !this.isSelectMethod();
    }

    /**
     * @see EJB3OperationFacade#isSelectMethod()
     */
    @Override
    protected boolean handleIsSelectMethod()
    {
        return this.hasStereotype(EJB3Profile.STEREOTYPE_SELECT_METHOD);
    }

    /**
     * @see EJB3OperationFacadeLogic#handleIsCreateMethod()
     */
    @Override
    protected boolean handleIsCreateMethod()
    {
        return this.hasStereotype(EJB3Profile.STEREOTYPE_CREATE_METHOD);
    }

    /**
     * @see EJB3OperationFacadeLogic#handleIsFinderMethod()
     */
    @Override
    protected boolean handleIsFinderMethod()
    {
        return this.hasStereotype(UMLProfile.STEREOTYPE_FINDER_METHOD) || this.isQuery();
    }

    /**
     * @see EJB3OperationFacadeLogic#handleIsPrePersist()
     */
    @Override
    protected boolean handleIsPrePersist()
    {
        return this.hasStereotype(EJB3Profile.STEREOTYPE_PRE_PERSIST);
    }

    /**
     * @see EJB3OperationFacadeLogic#handleIsPostPersist()
     */
    @Override
    protected boolean handleIsPostPersist()
    {
        return this.hasStereotype(EJB3Profile.STEREOTYPE_POST_PERSIST);
    }

    /**
     * @see EJB3OperationFacadeLogic#handleIsPreRemove()
     */
    @Override
    protected boolean handleIsPreRemove()
    {
        return this.hasStereotype(EJB3Profile.STEREOTYPE_PRE_REMOVE);
    }

    /**
     * @see EJB3OperationFacadeLogic#handleIsPostRemove()
     */
    @Override
    protected boolean handleIsPostRemove()
    {
        return this.hasStereotype(EJB3Profile.STEREOTYPE_POST_REMOVE);
    }

    /**
     * @see EJB3OperationFacadeLogic#handleIsPreUpdate()
     */
    @Override
    protected boolean handleIsPreUpdate()
    {
        return this.hasStereotype(EJB3Profile.STEREOTYPE_PRE_UPDATE);
    }

    /**
     * @see EJB3OperationFacadeLogic#handleIsPostUpdate()
     */
    @Override
    protected boolean handleIsPostUpdate()
    {
        return this.hasStereotype(EJB3Profile.STEREOTYPE_POST_UPDATE);
    }

    /**
     * @see EJB3OperationFacadeLogic#handleIsPostLoad()
     */
    @Override
    protected boolean handleIsPostLoad()
    {
        return this.hasStereotype(EJB3Profile.STEREOTYPE_POST_LOAD);
    }

    /**
     * @see EJB3OperationFacadeLogic#handleIsLifecycleCallback()
     */
    @Override
    protected boolean handleIsLifecycleCallback()
    {
        return this.isPostLoad() || this.isPostPersist() || this.isPostRemove() || this.isPostUpdate() || this.isPrePersist() || this.isPreRemove() || this.isPreUpdate();
    }

    /**
     * @see EJB3OperationFacadeLogic#handleGetImplementationName()
     */
    @Override
    protected String handleGetImplementationName()
    {
        return this.getImplementationOperationName(StringUtils.capitalize(this.getName()));
    }

    /**
     * @see EJB3OperationFacadeLogic#handleGetImplementationCall()
     */
    @Override
    protected String handleGetImplementationCall()
    {
        return this.getImplementationOperationName(StringUtils.capitalize(this.getCall()));
    }

    /**
     * @see EJB3OperationFacadeLogic#handleGetImplementationSignature()
     */
    @Override
    protected String handleGetImplementationSignature()
    {
        return this.getImplementationOperationName(StringUtils.capitalize(this.getSignature()));
    }

    /**
     * Retrieves the implementationOperatName by replacing the <code>replacement</code> in the {@link EJB3Globals#IMPLEMENTATION_OPERATION_NAME_PATTERN}
     * 
     * @param replacement the replacement string for the pattern.
     * @return the operation name
     */
    private String getImplementationOperationName(final String replacement)
    {
        String implementationNamePattern = (String) this.getConfiguredProperty(EJB3Globals.IMPLEMENTATION_OPERATION_NAME_PATTERN);

        return MessageFormat.format(implementationNamePattern, StringUtils.trimToEmpty(replacement));
    }
}
