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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.andromda.cartridges.ejb3.EJB3Globals;
import org.andromda.metafacades.uml.DependencyFacade;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.lang.StringUtils;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.ejb3.metafacades.EJB3DependencyFacade.
 * 
 * @see EJB3DependencyFacade
 */
public class EJB3DependencyFacadeLogicImpl extends EJB3DependencyFacadeLogic
{
    private static final long   serialVersionUID                            = 34L;
    /**
     * The suffix for the transformation anonymous name.
     */
    private static final String TRANSFORMATION_ANONYMOUS_NAME_SUFFIX        = "_TRANSFORMER";

    /**
     * The suffix for the transformation to entity method name.
     */
    private static final String TRANSFORMATION_TO_ENTITY_METHOD_NAME_SUFFIX = "ToEntity";

    /**
     * The suffix for the value object to entity transformer.
     */
    private static final String VALUE_OBJECT_TO_ENTITY_TRANSFORMER_SUFFIX   = "Transformer";

    /**
     * @param metaObject
     * @param context
     */
    public EJB3DependencyFacadeLogicImpl(final Object metaObject, final String context)
    {
        super(metaObject, context);
    }

    /**
     * @return EJB3Globals.TRANSFORMATION_CONSTANT_PREFIX + this.getName().toUpperCase()
     * @see EJB3DependencyFacade#getTransformationConstantName()
     */
    @Override
    protected String handleGetTransformationConstantName()
    {
        return EJB3Globals.TRANSFORMATION_CONSTANT_PREFIX + this.getName().toUpperCase();
    }

    /**
     * @return EJB3Globals.TRANSFORMATION_METHOD_PREFIX + StringUtils.capitalize(getName())
     * @see EJB3DependencyFacade#getTransformationMethodName()
     */
    @Override
    protected String handleGetTransformationMethodName()
    {
        return EJB3Globals.TRANSFORMATION_METHOD_PREFIX + StringUtils.capitalize(this.getName());
    }

    /**
     * @see EJB3DependencyFacade#getTransformationAnonymousName()
     */
    @Override
    protected String handleGetTransformationAnonymousName()
    {
        return this.getName().toUpperCase() + TRANSFORMATION_ANONYMOUS_NAME_SUFFIX;
    }

    /**
     * @return circularReference
     * @see EJB3DependencyFacade#isCircularReference()
     */
    @Override
    protected boolean handleIsCircularReference()
    {
        boolean circularReference = false;
        final ModelElementFacade sourceElement = this.getSourceElement();
        final ModelElementFacade targetElement = this.getTargetElement();
        final Collection<DependencyFacade> sourceDependencies = targetElement.getSourceDependencies();
        if (sourceDependencies != null && !sourceDependencies.isEmpty())
        {
            circularReference = CollectionUtils.find(sourceDependencies, new Predicate()
            {
                public boolean evaluate(final Object object)
                {
                    DependencyFacade dependency = (DependencyFacade) object;
                    return (dependency != null) && dependency.getTargetElement().equals(sourceElement);
                }
            }) != null;
        }
        return circularReference;
    }

    /**
     * @see EJB3DependencyFacade#getTransformationConstantValue()
     */
    @Override
    protected int handleGetTransformationConstantValue()
    {
        int value = 0;
        ModelElementFacade element = this.getSourceElement();
        if (element instanceof EJB3EntityFacade)
        {
            final List<EJB3EntityFacade> hierarchyList = new ArrayList<EJB3EntityFacade>();
            for (EJB3EntityFacade entity = (EJB3EntityFacade) element; entity != null; entity = (EJB3EntityFacade) entity.getGeneralization())
            {
                hierarchyList.add(entity);
            }
            boolean breakOut = false;
            for (int ctr = hierarchyList.size() - 1; ctr >= 0; ctr--)
            {
                final EJB3EntityFacade generalization = hierarchyList.get(ctr);
                for (final Object reference : generalization.getValueObjectReferences())
                {
                    value++;
                    if (reference.equals(this))
                    {
                        breakOut = true;
                        break;
                    }
                }
                if (breakOut)
                {
                    break;
                }
            }
        }
        return value;
    }

    /**
     * @see EJB3DependencyFacade#getTransformationToCollectionMethodName()
     */
    @Override
    protected String handleGetTransformationToCollectionMethodName()
    {
        return EJB3Globals.TRANSFORMATION_METHOD_PREFIX + StringUtils.capitalize(this.getName()) + EJB3Globals.TRANSFORMATION_TO_COLLECTION_METHOD_SUFFIX;
    }

    /**
     * @see EJB3DependencyFacade#getDaoName()
     */
    @Override
    protected String handleGetDaoName()
    {
        return MessageFormat.format(this.getDaoNamePattern(), StringUtils.trimToEmpty(this.getName()));
    }

    /**
     * Gets the value of the {@link EJB3Globals#DAO_PATTERN}.
     * 
     * @return the DAO name pattern.
     */
    private String getDaoNamePattern()
    {
        return String.valueOf(this.getConfiguredProperty(EJB3Globals.DAO_PATTERN));
    }

    /**
     * @see EJB3DependencyFacade#getDaoGetterName()
     */
    @Override
    protected String handleGetDaoGetterName()
    {
        return "get" + StringUtils.capitalize(this.getDaoName());
    }

    /**
     * @see EJB3DependencyFacade#getDaoSetterName()
     */
    @Override
    protected String handleGetDaoSetterName()
    {
        return "set" + StringUtils.capitalize(this.getDaoName());
    }

    /**
     * @see EJB3DependencyFacade#getTransformationToEntityCollectionMethodName()
     */
    @Override
    protected String handleGetTransformationToEntityCollectionMethodName()
    {
        return this.getTransformationToEntityMethodName() + EJB3Globals.TRANSFORMATION_TO_COLLECTION_METHOD_SUFFIX;
    }

    /**
     * @see EJB3DependencyFacade#getTransformationToEntityMethodName()
     */
    @Override
    protected String handleGetTransformationToEntityMethodName()
    {
        return this.getName() + TRANSFORMATION_TO_ENTITY_METHOD_NAME_SUFFIX;
    }

    /**
     * @see EJB3DependencyFacade#getValueObjectToEntityTransformerName()
     */
    @Override
    protected String handleGetValueObjectToEntityTransformerName()
    {
        return StringUtils.capitalize(this.getTransformationToEntityMethodName()) + VALUE_OBJECT_TO_ENTITY_TRANSFORMER_SUFFIX;
    }
}
