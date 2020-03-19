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

/**
 * Stores the metafacade namespace properties used throughout the UML metafacades.
 * 
 * @author Chad Brandon
 * @author Bob Fields
 */
public class UMLMetafacadeProperties
{
    /**
     * Stores the property containing the URI to the language mappings file.
     */
    public static final String LANGUAGE_MAPPINGS_URI                      = "languageMappingsUri";

    /**
     * This property controls whether or not to produce templating parameters
     * where possible.
     */
    public static final String ENABLE_TEMPLATING                          = "enableTemplating";

    /**
     * Stores the property defining the default schema name for entity tables.
     */
    public static final String SCHEMA_NAME                                = "schemaName";

    /**
     * Stores the property defining the prefix for entity table names.
     */
    public static final String TABLE_NAME_PREFIX                          = "tableNamePrefix";

    /**
     * Stores the property defining the prefix for entity table column names.
     */
    public static final String COLUMN_NAME_PREFIX                         = "columnNamePrefix";

    /**
     * Stores the property defining the suffix for entity table column names.
     */
    public static final String COLUMN_NAME_SUFFIX                         = "columnNameSuffix";

    /**
     * Stores the property containing the URI to the SQL mappings file.
     */
    public static final String SQL_MAPPINGS_URI                           = "sqlMappingsUri";

    /**
     * Stores the property containing the URI to the JDBC mappings file.
     */
    public static final String JDBC_MAPPINGS_URI                          = "jdbcMappingsUri";

    /**
     * Stores the property containing the URI to the Wrapper mappings file.
     */
    public static final String WRAPPER_MAPPINGS_URI                       = "wrapperMappingsUri";

    /**
     * Allows the pluralization of association end names (when the multiplicity is greater than one) to be turned
     * on/off.
     */
    public static final String PLURALIZE_ASSOCIATION_END_NAMES            = "pluralizeAssociationEndNames";

    /**
     * Allows the pluralization of operation parameter names (when the multiplicity is greater than one) to be turned
     * on/off.
     */
    public static final String PLURALIZE_ATTRIBUTE_NAMES                  = "pluralizeAttributeNames";

    /**
     * Allows the pluralization of attribute names (when the multiplicity is greater than one) to be turned
     * on/off.
     */
    public static final String PLURALIZE_PARAMETER_NAMES                  = "pluralizeParameterNames";

    /**
     * The default suffix to use for foreign keys.
     */
    public static final String FOREIGN_KEY_SUFFIX                         = "foreignKeySuffix";

    /**
     * The default suffix to use for foreign keys.
     */
    public static final String CONSTRAINT_SUFFIX                          = "constraintSuffix";

    /**
     * The mask to apply to role names
     * 
     * @see NameMasker#mask(String, String)
     */
    public static final String ROLE_NAME_MASK                             = "roleNameMask";

    /**
     * The mask to apply to any model element names
     * 
     * @see NameMasker#mask(String, String)
     */
    public static final String MODEL_ELEMENT_NAME_MASK                    = "modelElementNameMask";

    /**
     * The mask to apply to any classifier names
     * 
     * @see NameMasker#mask(String, String)
     */
    public static final String CLASSIFIER_NAME_MASK                       = "classifierNameMask";

    /**
     * The mask to apply to any of the classifier property names
     * 
     * @see NameMasker#mask(String, String)
     */
    public static final String CLASSIFIER_PROPERTY_NAME_MASK              = "classifierPropertyNameMask";

    /**
     * The mask to apply to any operation names
     * 
     * @see NameMasker#mask(String, String)
     */
    public static final String OPERATION_NAME_MASK                        = "operationNameMask";

    /**
     * The mask to apply to any parameter names
     * 
     * @see NameMasker#mask(String, String)
     */
    public static final String PARAMETER_NAME_MASK                        = "parameterNameMask";

    /**
     * The mask to apply to enumeration literal names
     * 
     * @see NameMasker#mask(String, String)
     */
    public static final String ENUMERATION_LITERAL_NAME_MASK              = "enumerationLiteralNameMask";

    /**
     * The mask to apply to the enumeration literal name
     * 
     * @see NameMasker#mask(String, String)
     */
    public static final String ENUMERATION_NAME_MASK                      = "enumerationNameMask";

    /**
     * The mask to apply to the entity name
     * 
     * @see NameMasker#mask(String, String)
     */
    public static final String ENTITY_NAME_MASK                           = "entityNameMask";

    /**
     * The mask to apply to the entity property (attributes and association) names
     * 
     * @see NameMasker#mask(String, String)
     */
    public static final String ENTITY_PROPERTY_NAME_MASK                  = "entityPropertyNameMask";

    /**
     * The maximum length a SQL name can be before its truncated.
     */
    public static final String MAX_SQL_NAME_LENGTH                        = "maxSqlNameLength";

    /**
     * Whether or not to allow default identifiers for modeled entities.
     */
    public static final String ALLOW_DEFAULT_IDENTITIFIERS                = "allowDefaultIdentifiers";

    /**
     * The pattern used to construct the name entity default identifiers (if enabled).
     */
    public static final String DEFAULT_IDENTIFIER_PATTERN                 = "defaultIdentifierPattern";

    /**
     * The type to given default identifiers.
     */
    public static final String DEFAULT_IDENTIFIER_TYPE                    = "defaultIdentifierType";

    /**
     * The visibility to apply to default identifiers.
     */
    public static final String DEFAULT_IDENTIFIER_VISIBILITY              = "defaultIdentifierVisibility";

    /**
     * The suffix to add to the composite identifier type name.
     */
    public static final String COMPOSITE_IDENTIFIER_TYPE_NAME_SUFIX       = "compositeIdentifierTypeNameSuffix";

    /**
     * The suffix to add to the composite identifier name.
     */
    public static final String COMPOSITE_IDENTIFIER_NAME_SUFIX            = "compositeIdentifierNameSuffix";

    /**
     * Are manageable tables resolved by default when referenced ?
     */
    public static final String PROPERTY_DEFAULT_RESOLVEABLE               = "defaultResolveable";

    /**
     * Stores the default upper limit for lists.
     */
    public static final String PROPERTY_DEFAULT_MAX_LIST_SIZE             = "defaultMaximumListSize";

    /**
     * Stores the default number of records shown per page.
     */
    public static final String PROPERTY_DEFAULT_PAGE_SIZE                 = "defaultPageSize";

    /**
     * The separator used for packages and element names when constructing fully qualified names.
     */
    public static final String NAMESPACE_SEPARATOR                        = "namespaceSeparator";

    /**
     * The name given to model elements without a name.
     */
    public static final String UNDEFINED_NAME                             = "undefinedName";

    /**
     * Stores the suffix given to array type names.
     */
    public static final String ARRAY_NAME_SUFFIX                          = "arrayNameSuffix";

    /**
     * Whether or not to enable manageable entities for the currently running cartridge.
     */
    public static final String ENABLE_MANAGEABLE_ENTITIES                 = "enableManageableEntities";

    /**
     * The namespace property used to denote the name of the subpackage create for
     * manageable entities.
     */
    public static final String MANAGEABLE_PACKAGE_NAME_SUFFIX             = "manageablePackageSuffix";

    /**
     * Stores the boolean flag indicating whether or not we should use arrays instead of collections with associations
     * of type many (where appropriate).
     */
    public static final String USE_ARRAYS_FOR_MULTIPLICITIES_OF_TYPE_MANY = "useArraysForMultiplicitiesOfTypeMany";

    /**
     * The separator for relation names between associations.
     */
    public static final String RELATION_NAME_SEPARATOR                    = "relationNameSeparator";

    /**
     * The separator to use when constructing SQL names.
     */
    public static final String SQL_NAME_SEPARATOR                         = "sqlNameSeparator";

    /**
     * The pattern used for constructing operations that handle precondition constraints.
     */
    public static final String PRECONDITION_NAME_PATTERN                  = "preconditionNamePattern";

    /**
     * The pattern used for constructing operations that handle postcondition constraints.
     */
    public static final String POSTCONDITION_NAME_PATTERN                 = "postconditionNamePattern";

    /**
     * The namespace property used to identify the pattern used to construct the backend CRUD service's accessor.
     */
    public static final String MANAGEABLE_SERVICE_ACCESSOR_PATTERN        = "manageableServiceAccessorPattern";

    /**
     * The namespace property used to define the default multiplicity of
     * an attribute or association end (when one isn't modeled).
     */
    public static final String DEFAULT_MULTIPLICITY                       = "defaultMultiplicity";

    /**
     * Denotes whether or not the id needs to be displayed when managing an entity, or whether this
     * should be transparent for the user.
     */
    public static final String MANAGEABLE_ID_DISPLAY_STRATEGY             = "manageableIdDisplayStrategy";

    /**
     * Indicates whether enumerations must be generated using a Java 5 type-safe enum or a
     * traditional enumeration-pattern class.
     */
    public static final String TYPE_SAFE_ENUMS_ENABLED                    = "typeSafeEnumsEnabled";

    /**
     * Value indicating work to do in source code. Default=TODO
     */
    public static final String TODO_TAG                                   = "toDoTag";

    /**
     * Value indicating missing documentation in model elements. Default=false, do not insert todo tags.
     */
    public static final String TODO_FOR_MISSING_DOCUMENTATION             = "toDoForMissingDocumentation";
}
