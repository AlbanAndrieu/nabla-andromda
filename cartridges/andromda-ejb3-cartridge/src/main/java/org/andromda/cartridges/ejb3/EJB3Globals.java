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
package org.andromda.cartridges.ejb3;

/**
 * Stores Globals specific to the EJB3 cartridge.
 *
 * @author Vance Karimi
 */
public class EJB3Globals
{
    /**
     * The property that stores the default EJB transaction type.
     */
    public static final String TRANSACTION_TYPE                           = "transactionType";

    /**
     * The pattern to use for determining the package name for EJBs.
     */
    public static final String JNDI_NAME_PREFIX                           = "jndiNamePrefix";

    /**
     * The property which stores the pattern defining the display attribute
     * label name when it's of type Collection.
     */
    public static final String LABEL_COLLECTION_NAME_PATTERN              = "labelCollectionNamePattern";

    /**
     * The property which stores the pattern defining the display attribute
     * label name when it's not of type Collection.
     */
    public static final String LABEL_SINGLE_NAME_PATTERN                  = "labelSingleNamePattern";

    /**
     * The property which stores the persistence context unit name associated with the default
     * Entity Manager.
     */
    public static final String PERSISTENCE_CONTEXT_UNIT_NAME              = "persistenceContextUnitName";

    /**
     * The property used to specify the implementation operation name pattern
     * on service and entity beans.
     */
    public static final String IMPLEMENTATION_OPERATION_NAME_PATTERN      = "implementationOperationNamePattern";

    /**
     * The property used to specify whether to enable query cache.
     */
    public static final String HIBERNATE_USER_QUERY_CACHE                 = "hibernateUseQueryCache";

    /**
     * The property that stores the comma separated list of roles for manageable
     * service beans.
     */
    public static final String MANAGEABLE_ROLES_ALLOWED                   = "manageableRolesAllowed";

    // --------------- Constants ---------------------

    /**
     * Represents the eager fetch type
     */
    public static final String FETCH_TYPE_EAGER                           = "EAGER";

    /**
     * Represents the lazy fetch type
     */
    public static final String FETCH_TYPE_LAZY                            = "LAZY";

    /**
     * Represents the clob lob type
     */
    public static final String LOB_TYPE_CLOB                              = "CLOB";

    /**
     * Represents the blob lob type
     */
    public static final String LOB_TYPE_BLOB                              = "BLOB";

    /**
     * Represents the table generator type
     */
    public static final String GENERATOR_TYPE_TABLE                       = "TABLE";

    /**
     * Represents the sequence generator type
     */
    public static final String GENERATOR_TYPE_SEQUENCE                    = "SEQUENCE";

    /**
     * Represents the identity generator type
     */
    public static final String GENERATOR_TYPE_IDENTITY                    = "IDENTITY";

    /**
     * Represents the auto generator type
     */
    public static final String GENERATOR_TYPE_AUTO                        = "AUTO";

    /**
     * Represents the generic generator type
     */
    public static final String GENERATOR_TYPE_GENERIC                     = "GENERIC";

    /**
     * Represents the none generator type
     */
    public static final String GENERATOR_TYPE_NONE                        = "NONE";

    /**
     * Represents the date temporal type
     */
    public static final String TEMPORAL_TYPE_DATE                         = "DATE";

    /**
     * Represents the time temporal type
     */
    public static final String TEMPORAL_TYPE_TIME                         = "TIME";

    /**
     * Represents the timestamp temporal type
     */
    public static final String TEMPORAL_TYPE_TIMESTAMP                    = "TIMESTAMP";

    /**
     * Represents the none temporal type
     */
    public static final String TEMPORAL_TYPE_NONE                         = "NONE";

    /**
     * Represents the finder method index type on the parameter
     */
    public static final String FINDER_RESULT_TYPE_FIRST                   = "First";

    /**
     * Represents the finder method max count on the parameter
     */
    public static final String FINDER_RESULT_TYPE_MAX                     = "Max";

    /**
     * Represents the view type for the entity POJO as both remote and local
     */
    public static final String VIEW_TYPE_BOTH                             = "both";

    /**
     * Represents the local view type for the entity POJO
     */
    public static final String VIEW_TYPE_LOCAL                            = "local";

    /**
     * Represents the remote view type for the entity POJO
     */
    public static final String VIEW_TYPE_REMOTE                           = "remote";

    /**
     * Represents the mandatory transaction type
     */
    public static final String TRANSACTION_TYPE_MANDATORY                 = "Manadatory";

    /**
     * Represents the never transaction type
     */
    public static final String TRANSACTION_TYPE_NEVER                     = "Never";

    /**
     * Represents the not supported transaction type
     */
    public static final String TRANSACTION_TYPE_NOT_SUPPORTED             = "NotSupported";

    /**
     * Represents the required transaction type
     */
    public static final String TRANSACTION_TYPE_REQUIRED                  = "Required";

    /**
     * Represents the required transaction type
     */
    public static final String TRANSACTION_TYPE_REQUIRES_NEW              = "RequiresNew";

    /**
     * Represents the supports transaction type
     */
    public static final String TRANSACTION_TYPE_SUPPORTS                  = "Supports";

    /**
     * Represents the stateless session bean
     */
    public static final String SERVICE_TYPE_STATELESS                     = "Stateless";

    /**
     * Represents the stateful session bean
     */
    public static final String SERVICE_TYPE_STATEFUL                      = "Stateful";

    /**
     * Represents the JBoss persistence container constant
     */
    public static final String PERSISTENCE_CONTAINER_JBOSS                = "jboss";

    /**
     * Represents the Weblogic persistence container contant
     */
    public static final String PERSISTENCE_CONTAINER_WEBLOGIC             = "weblogic";

    /**
     * Represents the default security domain
     */
    public static final String SECURITY_REALM                             = "securityRealm";

    /**
     * Represents the bean managed transaction demarcation
     */
    public static final String TRANSACTION_MANAGEMENT_BEAN                = "bean";

    /**
     * Represents the container managed transaction demarcation
     */
    public static final String TRANSACTION_MANAGEMENT_CONTAINER           = "container";

    /**
     * Represents the fully qualified topic destination type for the
     * JMS message driven bean
     */
    public static final String MDB_DESTINATION_TYPE_TOPIC                 = "javax.jms.Topic";

    /**
     * Represents the fully qualified queue destination type for the
     * JMS message driven bean
     */
    public static final String MDB_DESTINATION_TYPE_QUEUE                 = "javax.jms.Queue";

    /**
     * Represents the durable subscription topic
     */
    public static final String MDB_SUBSCRIPTION_DURABLE                   = "Durable";

    /**
     * Represents the non durable subscription topic
     */
    public static final String MDB_SUBSCRIPTION_NONDURABLE                = "NonDurable";

    /**
     * The namespace delimiter (separates namespaces).
     */
    public static final char   NAMESPACE_DELIMITER                        = '.';

    /**
     * Defines the prefix given to the transformation constants.
     */
    public static final String TRANSFORMATION_CONSTANT_PREFIX             = "TRANSFORM_";

    /**
     * The suffix given to the no transformation constant.
     */
    public static final String NO_TRANSFORMATION_CONSTANT_SUFFIX          = "NONE";

    /**
     * The prefix given to transformation method names.
     */
    public static final String TRANSFORMATION_METHOD_PREFIX               = "to";

    /**
     * The suffix given to transformation method names.
     */
    public static final String TRANSFORMATION_TO_COLLECTION_METHOD_SUFFIX = "Collection";

    /**
     * Seam component scope type STATELESS
     */
    public static final String SEAM_COMPONENT_SCOPE_STATELESS             = "STATELESS";

    /**
     * Seam component scope type CONVERSATION
     */
    public static final String SEAM_COMPONENT_SCOPE_CONVERSATION          = "CONVERSATION";

    /**
     * The property representing the default collection interface of java.util.SortedSet
     */
    public static final String COLLECTION_INTERFACE_SORTED_SET            = "java.util.SortedSet";

    /**
     * The suffix to append to the class names of CRUD value objects.
     */
    public static final String CRUD_VALUE_OBJECT_SUFFIX                   = "crudValueObjectSuffix";

    /**
     * The pattern used to construct the DAO name.
     */
    public static final String DAO_PATTERN                                = "daoNamePattern";

    /**
     * The service base class suffix.
     */
    // static final String SERVICE_BASE_SUFFIX = "Base";

    /**
     * The name prefix for all spring bean ids.
     */
    public static final String BEAN_NAME_PREFIX                           = "beanNamePrefix";

    /**
     * The bean name target suffix
     */
    public static final String BEAN_NAME_TARGET_SUFFIX                    = "Target";
}
