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
package org.andromda.metafacades.uml;

import org.andromda.core.profile.Profile;

/**
 * Contains the common UML AndroMDA profile. That is, it contains elements "common" to all AndroMDA components (tagged
 * values, stereotypes, and datatypes).
 * 
 * @author Chad Brandon
 * @author Bob Fields
 */
public class UMLProfile
{
    /* ----------------- Stereotypes -------------------- */

    /**
     * The Profile instance from which we retrieve the mapped profile names.
     */
    private static final Profile profile                                                = Profile.instance();

    /**
     * 'Criteria' Represents a criteria search.
     */
    public static final String   STEREOTYPE_CRITERIA                                    = profile.get("CRITERIA");

    /**
     * 'Entity' Represents a persistent entity.
     */
    public static final String   STEREOTYPE_ENTITY                                      = profile.get("ENTITY");

    /**
     * 'EmbeddedValue'
     * Represents an embedded value (typically embedded with an entity as an attribute).
     */
    public static final String   STEREOTYPE_EMBEDDED_VALUE                              = profile.get("EMBEDDED_VALUE");

    /**
     * 'FinderMethod' Represents a finder method on an entity.
     */
    public static final String   STEREOTYPE_FINDER_METHOD                               = profile.get("FINDER_METHOD");

    /**
     * 'Identifier' Represents the primary key of an entity.
     */
    public static final String   STEREOTYPE_IDENTIFIER                                  = profile.get("IDENTIFIER");

    /**
     * 'Unique' If an attribute has this stereotype, it is considered unique.
     */
    public static final String   STEREOTYPE_UNIQUE                                      = profile.get("UNIQUE");

    /**
     * 'Service' Represents a service.
     */
    public static final String   STEREOTYPE_SERVICE                                     = profile.get("SERVICE");

    /**
     * Represents a service class/operation.
     */
    public static final String   STEREOTYPE_SERVICE_ELEMENT                             = profile.get("SERVICE_ELEMENT");

    /**
     * 'ValueObject' Represents a value object.
     */
    public static final String   STEREOTYPE_VALUE_OBJECT                                = profile.get("VALUE_OBJECT");

    /**
     * 'WebFault'
     * Represents a web service exception (fault). Stereotype a class with this stereotype when it is thrown by a CXF/JAX-WS service.
     */
    public static final String   STEREOTYPE_WEB_FAULT                                   = profile.get("WEB_FAULT");

    /**
     * 'WebService' Represents a web service. Stereotype a class with this stereotype when you want everything on the class to be
     * exposed as a web service.
     */
    public static final String   STEREOTYPE_WEBSERVICE                                  = profile.get("WEBSERVICE");

    /**
     * 'WebServiceOperation'
     * Stereotype an operation on a <code>service</code> if you wish to expose the operation.
     */
    public static final String   STEREOTYPE_WEBSERVICE_OPERATION                        = profile.get("WEBSERVICE_OPERATION");

    /**
     * 'XmlSchema'
     * Stereotype an operation on a <code>service</code> if you wish to expose the operation.
     */
    public static final String   STEREOTYPE_XMLSCHEMA                                   = profile.get("XMLSCHEMA");

    /**
     * 'Exception'
     * The base exception stereotype. If a model element is stereotyped with this (or one of its specializations), then
     * the exception can be generated by a cartridge and a dependency to it from an operation will add a throws clause.
     */
    public static final String   STEREOTYPE_EXCEPTION                                   = profile.get("EXCEPTION");

    /**
     * 'Enumeration' Represents an enumeration type.
     */
    public static final String   STEREOTYPE_ENUMERATION                                 = profile.get("ENUMERATION");

    /**
     * 'ApplicationException'
     * Represents exceptions thrown during normal application processing (such as business exceptions). It extends the
     * base exception stereotype.
     */
    public static final String   STEREOTYPE_APPLICATION_EXCEPTION                       = profile.get("APPLICATION_EXCEPTION");

    /**
     * 'UnexpectedException'
     * Represents unexpected exceptions that can occur during application processing. This that a caller isn't expected
     * to handle.
     */
    public static final String   STEREOTYPE_UNEXPECTED_EXCEPTION                        = profile.get("UNEXPECTED_EXCEPTION");

    /**
     * 'ExceptionRef'
     * Represents a reference to an exception model element. Model dependencies to unstereotyped exception model
     * elements can be stereotyped with this. This allows the user to create a custom exception class since the
     * exception itself will not be generated but the references to it will be (i.e. the throws clause within an
     * operation).
     * Deprecated: In UML2, design the operation to throw the declared exceptions instead of drawing a dependency.
     */
    public static final String   STEREOTYPE_EXCEPTION_REF                               = profile.get("EXCEPTION_REF");

    /**
     * 'Nullable'
     * Used to indicate whether or not a parameter is nullable (since parameters do <strong>NOT </strong> allow
     * specification of multiplicity.
     * Deprecated: Use the parameter multiplicity lowerBound=0 instead
     */
    public static final String   STEREOTYPE_NULLABLE                                    = profile.get("NULLABLE");

    /**
     * 'Manageable' Represents a manageable entity.
     */
    public static final String   STEREOTYPE_MANAGEABLE                                  = profile.get("MANAGEABLE");

    /**
     * 'Transient' Indicates if a persistence type's property is transient.
     */
    public static final String   STEREOTYPE_TRANSIENT                                   = profile.get("TRANSIENT");

    /**
     * 'FrontEndUseCase'
     * Represents a "front end" use case (that is a use case used to model a presentation tier or "front end").
     */
    public static final String   STEREOTYPE_FRONT_END_USECASE                           = profile.get("FRONT_END_USE_CASE");

    /**
     * 'FrontEndApplication'
     * Represents a "front end" use case that is the entry point to the presentation tier.
     */
    public static final String   STEREOTYPE_FRONT_END_APPLICATION                       = profile.get("FRONT_END_APPLICATION");

    /**
     * 'FrontEndView'
     * Represents a "front end" view (that is it can represent a JSP page, etc).
     */
    public static final String   STEREOTYPE_FRONT_END_VIEW                              = profile.get("FRONT_END_VIEW");

    /**
     * 'FrontEndException'
     * Represents an exception on a "front-end" view.
     */
    public static final String   STEREOTYPE_FRONT_END_EXCEPTION                         = profile.get("FRONT_END_EXCEPTION");

    /**
     * 'Queue' Represents a "Queue" message destination.
     */
    public static final String   STEREOTYPE_QUEUE                                       = profile.get("QUEUE");

    /**
     * 'Topic' Represents a "Topic" message destination.
     */
    public static final String   STEREOTYPE_TOPIC                                       = profile.get("TOPIC");

    /**
     * 'DocOnly' Modeled component is for documentation only. Do not generate code.
     */
    public static final String   STEREOTYPE_DOC_ONLY                                    = profile.get("DOC_ONLY");

    /**
     * 'Future' Modeled component will be developed in the Future. Do not generate code.
     */
    public static final String   STEREOTYPE_FUTURE                                      = profile.get("FUTURE");

    /**
     * 'Ignore' Modeled component should be ignored. Do not generate code.
     */
    public static final String   STEREOTYPE_IGNORE                                      = profile.get("IGNORE");

    /**
     * 'analysis' Modeled component should be ignored. Do not generate code.
     */
    public static final String   STEREOTYPE_ANALYSIS                                    = profile.get("ANALYSIS");

    /**
     * 'perspective' Modeled component should be ignored. Do not generate code.
     */
    public static final String   STEREOTYPE_PERSPECTIVE                                 = profile.get("PERSPECTIVE");

    /* ----------------- Tagged Values -------------------- */

    /**
     * 'documentation' Represents documentation stored as a tagged value
     */
    public static final String   TAGGEDVALUE_DOCUMENTATION                              = profile.get("DOCUMENTATION");

    /**
     * 'hyperlinkModel' Represents a model hyperlink stored as a tagged value.
     */
    public static final String   TAGGEDVALUE_MODEL_HYPERLINK                            = profile.get("MODEL_HYPERLINK");

    /**
     * 'hyperlinkTextActive' Represents an external hyperlink (a website outside of a model).
     */
    public static final String   TAGGEDVALUE_EXTERNAL_HYPERLINK                         = profile.get("EXTERNAL_HYPERLINK");

    /**
     * 'andromda_persistence_schema' Represents the name of the schema for entity persistence.
     */
    public static final String   TAGGEDVALUE_PERSISTENCE_SCHEMA                         = profile.get("PERSISTENCE_SCHEMA");

    /**
     * 'andromda_persistence_table' Represents a relational table name for entity persistence.
     */
    public static final String   TAGGEDVALUE_PERSISTENCE_TABLE                          = profile.get("PERSISTENCE_TABLE");

    /**
     * 'andromda_persistence_column' Represents a relational table column name for entity persistence.
     */
    public static final String   TAGGEDVALUE_PERSISTENCE_COLUMN                         = profile.get("PERSISTENCE_COLUMN");

    /**
     * 'andromda_persistence_column_length' Represents a relational table column length
     */
    public static final String   TAGGEDVALUE_PERSISTENCE_COLUMN_LENGTH                  = profile.get("PERSISTENCE_COLUMN_LENGTH");

    /**
     * 'andromda_persistence_column_index' Represents a relational table column index name.
     */
    public static final String   TAGGEDVALUE_PERSISTENCE_COLUMN_INDEX                   = profile.get("PERSISTENCE_COLUMN_INDEX");

    /**
     * 'andromda_persistence_immutable' Indicates if a persistence type is immutable.
     */
    public static final String   TAGGEDVALUE_PERSISTENCE_IMMUTABLE                      = profile.get("PERSISTENCE_IMMUTABLE");

    /**
     * 'andromda_persistence_foreign_identifier'
     * Used on an association end to indicate whether its owning entity should have its identifier also be the foreign
     * key to the related entity.
     */
    public static final String   TAGGEDVALUE_PERSISTENCE_FOREIGN_IDENTIFIER             = profile.get("PERSISTENCE_FOREIGN_IDENTIFIER");

    /**
     * 'andromda_persistence_assigned_identifier'
     * Used on an identifier to indicate whether or not the identifier is <em>assigned</em> (meaning
     * that the identifier is manually assigned instead of generated.
     */
    public static final String   TAGGEDVALUE_PERSISTENCE_ASSIGNED_IDENTIFIER            = profile.get("PERSISTENCE_ASSIGNED_IDENTIFIER");

    /**
     * 'andromda_persistence_foreignkey_constraint'
     * Used on an association end to denote to name of the foreign key constraint to use in the database.
     */
    public static final String   TAGGEDVALUE_PERSISTENCE_FOREIGN_KEY_CONSTRAINT_NAME    = profile.get("PERSISTENCE_FOREIGN_KEY_CONSTRAINT_NAME");

    /**
     * 'andromda_persistence_joincolumn_order' Specifies the order of columns in JoinColumn annotations
     * which must match the FK column order for the association, delimited by , or ; or |
     */
    public static final String   TAGGEDVALUE_PERSISTENCE_JOINCOLUMN_ORDER               = profile.get("PERSISTENCE_JOINCOLUMN_ORDER");

    /**
     * 'andromda_persistence_enumeration_member_variable'
     * Used to assign an enumeration attribute as a member variable rather than a literal.
     */
    public static final String   TAGGEDVALUE_PERSISTENCE_ENUMERATION_MEMBER_VARIABLE    = profile.get("PERSISTENCE_ENUMERATION_MEMBER_VARIABLE");

    /**
     * 'andromda_persistence_enumeration_literal_parameters'
     * Used on an enumeration literal to define the enumeration literal parameters.
     */
    public static final String   TAGGEDVALUE_PERSISTENCE_ENUMERATION_LITERAL_PARAMETERS = profile.get("PERSISTENCE_ENUMERATION_LITERAL_PARAMETERS");

    /**
     * 'andromda_presentation_controller_usecase'
     * Used to assign the controller to the activity (when it can not be assigned explicitly).
     */
    public static final String   TAGGEDVALUE_PRESENTATION_CONTROLLER_USECASE            = profile.get("PRESENTATION_CONTROLLER_USECASE");

    /**
     * 'andromda_presentation_view_table_columns'
     * Used to assign the table columns to a collection/array type parameter representing a table.
     */
    public static final String   TAGGEDVALUE_PRESENTATION_TABLE_COLUMNS                 = profile.get("PRESENTATION_TABLE_COLUMNS");

    /**
     * 'andromda_presentation_view_table'
     * Used to indicate whether or not a parameter should be considered a table (used when no
     * table columns are specified).
     */
    public static final String   TAGGEDVALUE_PRESENTATION_IS_TABLE                      = profile.get("PRESENTATION_IS_TABLE");

    /**
     * 'andromda_presentation_usecase_activity'
     * Used to associate an activity to a use case (when it can not be assigned explicitly).
     */
    public static final String   TAGGEDVALUE_PRESENTATION_USECASE_ACTIVITY              = profile.get("PRESENTATION_USECASE_ACTIVITY");

    /**
     * 'andromda_webservice_style'
     * Stores the style of a web service (document, wrapped, rpc).
     */
    public static final String   TAGGEDVALUE_WEBSERVICE_STYLE                           = profile.get("WEBSERVICE_STYLE");

    /**
     * 'andromda_webservice_use' Stores the use of a web service (literal, encoded).
     */
    public static final String   TAGGEDVALUE_WEBSERVICE_USE                             = profile.get("WEBSERVICE_USE");

    /**
     * 'andromda_webservice_provider' Stores the provider of the web service (RPC, EJB).
     */
    public static final String   TAGGEDVALUE_WEBSERVICE_PROVIDER                        = profile.get("WEBSERVICE_PROVIDER");

    /**
     * 'andromda_role_name'
     * Stores the name of the role (if it's different than the name of the actor stereotyped as role)
     */
    public static final String   TAGGEDVALUE_ROLE_NAME                                  = profile.get("ROLE_NAME");

    /**
     * 'andromda_serialVersionUID'
     * Stores the serial version UID to be used for a class. If not specified, it will be calculated
     * based on the class signature.
     * 
     * @see org.andromda.metafacades.uml.ClassifierFacade#getSerialVersionUID()
     */
    public static final String   TAGGEDVALUE_SERIALVERSION_UID                          = profile.get("SERIALVERSION_UID");

    /**
     * 'andromda_manageable_table_displayname'
     * The attribute to use when referencing this table from another one.
     */
    public static final String   TAGGEDVALUE_MANAGEABLE_DISPLAY_NAME                    = profile.get("MANAGEABLE_DISPLAY_NAME");

    /**
     * 'andromda_manageable_table_maxlistsize' The maximum number of records to load from the DB at the same time.
     * From Spring, Bpm4struts profile.xml.
     */
    public static final String   TAGGEDVALUE_MANAGEABLE_MAXIMUM_LIST_SIZE               = profile.get("MANAGEABLE_MAXIMUM_LIST_SIZE");

    /**
     * 'andromda_manageable_table_pagesize' The maximum number of records to show at the same time.
     */
    public static final String   TAGGEDVALUE_MANAGEABLE_PAGE_SIZE                       = profile.get("MANAGEABLE_PAGE_SIZE");

    /**
     * 'andromda_manageable_table_resolveable'
     * Indicates whether or not the underlying entity keys should be resolved when referencing it.
     */
    public static final String   TAGGEDVALUE_MANAGEABLE_RESOLVEABLE                     = profile.get("MANAGEABLE_RESOLVEABLE");

    /**
     * 'andromda_persistence_column_uniqueGroup' Indicates the unique constraint name grouping the columns.
     */
    public static final String   TAGGEDVALUE_PERSISTENCE_COLUMN_UNIQUE_GROUP            = profile.get("COLUMN_UNIQUE_GROUP");

    /**
     * 'andromda_persistence_associationEnd_uniqueGroup' Indicates the unique constraint name grouping the columns.
     */
    public static final String   TAGGEDVALUE_PERSISTENCE_ASSOCIATION_END_UNIQUE_GROUP   = profile.get("ASSOCIATION_END_UNIQUE_GROUP");

    /**
     * 'andromda_persistence_associationEnd_primary'
     * Indicates whether or not the association end is considered "primary" used for things like indicating
     * which side of a one-to-one association should get the foreign key.
     */
    public static final String   TAGGEDVALUE_PERSISTENCE_ASSOCIATION_END_PRIMARY        = profile.get("PERSISTENCE_ASSOCIATION_END_PRIMARY");

    /* ----------------- Data Types -------------------- */

    /**
     * Used to identify object types in the model, any other type that will be identified as an object must
     * specialize this type.
     */
    public static final String   OBJECT_TYPE_NAME                                       = profile.get("OBJECT_TYPE");

    /**
     * Used to identify collection types in the model, any other type that will be identified as a collection must
     * specialize this type. NonUnique / NonOrdered Collection. Default=Collection
     */
    public static final String   COLLECTION_TYPE_NAME                                   = profile.get("COLLECTION_TYPE");

    /**
     * Used to identify a list type in the model, any other type that will be identified as a list must specialize this
     * type. NonUnique / Ordered Collection. Default=List
     */
    public static final String   LIST_TYPE_NAME                                         = profile.get("LIST_TYPE");

    /**
     * Used to identify a set type in the model, any other type that will be identified as a set must specialize this
     * type. Unique / NonOrdered Collection. Default=Set
     */
    public static final String   SET_TYPE_NAME                                          = profile.get("SET_TYPE");

    /**
     * Used to identify an ordered set type in the model, any other type that will be identified as an ordered set must specialize this
     * type. Unique / Ordered Collection. Default=SortedSet
     */
    public static final String   ORDERED_SET_TYPE_NAME                                  = profile.get("ORDERED_SET_TYPE");

    /**
     * Used to identify a map type in the model, any other type that will be identified as a map type must specialize
     * this type. Default=Map
     */
    public static final String   MAP_TYPE_NAME                                          = profile.get("MAP_TYPE");

    /**
     * Used to identify a map type in the model, any other type that will be identified as a map type must specialize
     * this type. Default=SortedMap
     */
    public static final String   ORDERED_MAP_TYPE_NAME                                  = profile.get("ORDERED_MAP_TYPE");

    /**
     * Used to identify collection types in the model, any other type that will be identified as a collection must
     * specialize this type. NonUnique / NonOrdered Collection. Default=LinkedList
     */
    public static final String   COLLECTION_IMPL_TYPE_NAME                              = profile.get("COLLECTION_IMPL_TYPE");

    /**
     * Used to identify a list type in the model, any other type that will be identified as a list must specialize this
     * type. NonUnique / Ordered Collection. Default=ArrayList
     */
    public static final String   LIST_IMPL_TYPE_NAME                                    = profile.get("LIST_IMPL_TYPE");

    /**
     * Used to identify a set type in the model, any other type that will be identified as a set must specialize this
     * type. Unique / NonOrdered Collection. Default=HashSet
     */
    public static final String   SET_IMPL_TYPE_NAME                                     = profile.get("SET_IMPL_TYPE");

    /**
     * Used to identify an ordered set type in the model, any other type that will be identified as an ordered set must specialize this
     * type. Unique / Ordered Collection. Default=SortedSet
     */
    public static final String   ORDERED_SET_IMPL_TYPE_NAME                             = profile.get("ORDERED_SET_IMPL_TYPE");

    /**
     * Used to identify a map type in the model, any other type that will be identified as a map type must specialize
     * this type. Default=HashMap
     */
    public static final String   MAP_IMPL_TYPE_NAME                                     = profile.get("MAP_IMPL_TYPE");

    /**
     * Used to identify a map type in the model, any other type that will be identified as a map type must specialize
     * this type. Default=SortedMap
     */
    public static final String   ORDERED_MAP_IMPL_TYPE_NAME                             = profile.get("ORDERED_MAP_IMPL_TYPE");

    /**
     * Used to identify date types in the model, any other type that will be identified as a date must specialize this
     * type. Default=datatype::Date
     */
    public static final String   DATE_TYPE_NAME                                         = profile.get("DATE_TYPE");

    /**
     * Used to identify time types in the model, any other type that will be identified as a time must specialize this
     * type. Default=datatype::Time
     */
    public static final String   TIME_TYPE_NAME                                         = profile.get("TIME_TYPE");

    /**
     * Used to identify datetime types in the model. Default=datatype::DateTime
     */
    public static final String   DATETIME_TYPE_NAME                                     = profile.get("DATETIME_TYPE");

    /**
     * Used to identify a boolean type in the model, any other type that will be identified as a boolean type must
     * specialize this type. Default=datatype::boolean
     */
    public static final String   BOOLEAN_TYPE_NAME                                      = profile.get("BOOLEAN_TYPE");
    /**
     * Used to identify a character type in the model, any other type that will be identified as a character type must
     * specialize this type. Default=datatype::Character
     */
    public static final String   CHARACTER_TYPE_NAME                                    = profile.get("CHARACTER_TYPE");

    /**
     * Used to identify a file type in the model, any other type that will be identified as a file type must specialize
     * this type. Default=datatype::File
     */
    public static final String   FILE_TYPE_NAME                                         = profile.get("FILE_TYPE");

    /**
     * Used to identify a Blob type in the model, any other type that will be identified as a Blob type must specialize
     * this type. Default=datatype::Blob
     */
    public static final String   BLOB_TYPE_NAME                                         = profile.get("BLOB_TYPE");

    /**
     * Used to identify a Clob type in the model, any other type that will be identified as a Clob type must specialize
     * this type. Default=datatype::Clob
     */
    public static final String   CLOB_TYPE_NAME                                         = profile.get("CLOB_TYPE");

    /**
     * Used to identify a string type in the model, any other type that will be identified as a string type must
     * specialize this type. Default=datatype::String
     */
    public static final String   STRING_TYPE_NAME                                       = profile.get("STRING_TYPE");

    /**
     * Used to identify a void type in the model, any other type that will be identified as a void type must
     * specialize this type. Default=datatype::void
     */
    public static final String   VOID_TYPE_NAME                                         = profile.get("VOID_TYPE");

    /**
     * Used to identify a double type in the model, any other type that will be identified as a double type must
     * specialize this type. Default=datatype::Double
     */
    public static final String   DOUBLE_TYPE_NAME                                       = profile.get("DOUBLE_TYPE");

    /**
     * Used to identify a float type in the model, any other type that will be identified as a float type must
     * specialize this type. Default=datatype::Float
     */
    public static final String   FLOAT_TYPE_NAME                                        = profile.get("FLOAT_TYPE");

    /**
     * Used to identify a integer type in the model, any other type that will be identified as a integer type must
     * specialize this type. Default=datatype::Integer
     */
    public static final String   INTEGER_TYPE_NAME                                      = profile.get("INTEGER_TYPE");

    /**
     * Used to identify a long type in the model, any other type that will be identified as a long type must
     * specialize this type. Default=datatype::Long
     */
    public static final String   LONG_TYPE_NAME                                         = profile.get("LONG_TYPE");
}
