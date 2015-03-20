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

import java.util.Collection;
import org.andromda.cartridges.ejb3.EJB3Profile;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.ParameterFacade;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;

/**
 * <p/>
 * Represents an EJB finder method. </p>
 * MetafacadeLogic implementation for org.andromda.cartridges.ejb3.metafacades.EJB3FinderMethodFacade.
 * 
 * @see EJB3FinderMethodFacade
 */
public class EJB3FinderMethodFacadeLogicImpl extends EJB3FinderMethodFacadeLogic
{
    private static final long   serialVersionUID           = 34L;
    /**
     * Stores whether or not named parameters should be used in EJB queries.
     */
    private static final String QUERY_USE_NAMED_PARAMETERS = "queryUseNamedParameters";

    // ---------------- constructor -------------------------------

    /**
     * @param metaObject
     * @param context
     */
    public EJB3FinderMethodFacadeLogicImpl(final Object metaObject, final String context)
    {
        super(metaObject, context);
    }

    // --------------- methods ---------------------

    /**
     * Stores the translated query so that its only translated once.
     */
    private String translatedQuery = null;

    /**
     * Retrieves the translated query.
     */
    private String getTranslatedQuery()
    {
        if (this.translatedQuery == null)
        {
            this.translatedQuery = super.getQuery("query.Hibernate-QL");
        }
        return this.translatedQuery;
    }

    /**
     * @see EJB3FinderMethodFacade#getQuery()
     */
    @Override
    protected String handleGetQuery()
    {
        return this.getQuery((EJB3EntityFacade) null);
    }

    /**
     * @see EJB3FinderMethodFacade#getTransactionType()
     */
    @Override
    protected String handleGetTransactionType()
    {
        return (String) this.findTaggedValue(EJB3Profile.TAGGEDVALUE_EJB_TRANSACTION_TYPE, true);
    }

    /**
     * @see EJB3FinderMethodFacadeLogic#handleIsUseNamedParameters()
     */
    @Override
    protected boolean handleIsUseNamedParameters()
    {
        return BooleanUtils.toBoolean(String.valueOf(this.getConfiguredProperty(QUERY_USE_NAMED_PARAMETERS)));
    }

    /**
     * @see EJB3FinderMethodFacadeLogic#handleIsUseQueryCache()
     */
    @Override
    protected boolean handleIsUseQueryCache()
    {
        boolean queryCacheEnabled = ((EJB3EntityFacade) this.getOwner()).isUseQueryCache();
        String queryCacheEnabledStr = (String) super.findTaggedValue(EJB3Profile.TAGGEDVALUE_EJB_USE_QUERY_CACHE);
        if (StringUtils.isNotBlank(queryCacheEnabledStr))
        {
            queryCacheEnabled = BooleanUtils.toBoolean(queryCacheEnabledStr);
        }
        return queryCacheEnabled;
    }

    /**
     * @see EJB3FinderMethodFacadeLogic#handleGetQuery(EJB3EntityFacade)
     */
    @Override
    protected String handleGetQuery(final EJB3EntityFacade entity)
    {
        // first see if we can retrieve the query from the super class as an OCL
        // translation
        String queryString = this.getTranslatedQuery();

        boolean whereClauseExists = false;

        // otherwise see if there is a query stored as a tagged value
        if (StringUtils.isBlank(queryString))
        {
            queryString = (String) this.findTaggedValue(EJB3Profile.TAGGEDVALUE_EJB_QUERY);
            if (queryString != null)
            {
                // remove any excess whitespace
                queryString = queryString.replaceAll("[$\\s]+", " ");
            }
        }

        // if there wasn't any stored query, create one by default.
        if (StringUtils.isBlank(queryString))
        {
            ModelElementFacade owner;
            if (entity == null)
            {
                owner = this.getOwner();
            } else
            {
                owner = entity;
            }
            String variableName = StringUtils.uncapitalize(owner.getName()).substring(0, 1);
            queryString = "SELECT " + variableName + " from " + owner.getName() + " as " + variableName;
            Collection<ParameterFacade> arguments = this.getArguments();
            // int size = this.getArguments().size();
            int argCount = 0;
            if (arguments != null && !arguments.isEmpty())
            {
                for (ParameterFacade facade : arguments)
                {
                    EJB3FinderMethodArgumentFacade argument = (EJB3FinderMethodArgumentFacade) facade;
                    if (!argument.isFirstResult() && !argument.isMaxResults())
                    {
                        if (!whereClauseExists)
                        {
                            queryString += " WHERE";
                            whereClauseExists = true;
                        }
                        String parameter = "?";
                        if (this.isUseNamedParameters())
                        {
                            parameter = ':' + argument.getName();
                        }
                        queryString += ' ' + variableName + '.' + argument.getName() + " = " + parameter + " AND";
                        argCount++;
                    }
                }
                if (argCount > 0)
                {
                    // Remove the final ' and'
                    queryString = queryString.substring(0, queryString.length() - 4);
                }
            }
        }
        return queryString;
    }

    /**
     * @see EJB3FinderMethodFacadeLogic#handleIsNamedQuery()
     */
    @Override
    protected boolean handleIsNamedQuery()
    {
        boolean isNamedQuery = true;
        final String query = (String) this.findTaggedValue(EJB3Profile.TAGGEDVALUE_EJB_QUERY);
        if (StringUtils.isNotBlank(query))
        {
            isNamedQuery = false;
        }
        return isNamedQuery;
    }
}
