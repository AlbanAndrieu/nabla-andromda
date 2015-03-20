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
package org.andromda.cartridges.jsf.validator;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.Field;
import org.apache.commons.validator.GenericTypeValidator;
import org.apache.commons.validator.GenericValidator;
import org.apache.commons.validator.ValidatorAction;
import org.apache.commons.validator.ValidatorException;

import java.io.Serializable;

import java.net.URL;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

/**
 * <p>
 * This class contains the default validations that are used in the
 * validator-rules.xml file.
 * </p>
 * <p>
 * In general passing in a null or blank will return a null Object or a false
 * boolean. However, nulls and blanks do not result in an error being added to
 * the errors.
 * </p>
 */
public class ParameterChecks implements Serializable
{

    /**
     *
     */
    private static final long  serialVersionUID   = 1L;

    /** NULL */
    public static final String FIELD_TEST_NULL    = "NULL";

    /** NOTNULL */
    public static final String FIELD_TEST_NOTNULL = "NOTNULL";

    /** EQUAL */
    public static final String FIELD_TEST_EQUAL   = "EQUAL";

    /**
     * Checks if the field isn't null and length of the field is greater than
     * zero not including whitespace.
     * 
     * @param context the faces context
     * @param object the value of the field being validated.
     * @param parameters Any field parameters from the validation.xml.
     * @param errors The <code>Map</code> object to add errors to if any
     * validation errors occur.
     * @param action The <code>ValidatorAction</code> that is currently being
     * performed.
     * @param field The <code>Field</code> object associated with the current
     * field being validated.
     */
    public static void validateRequired(FacesContext context, Object object, Map parameters, Collection errors, ValidatorAction action, Field field)
    {

        String value = null;

        if (object instanceof String)
        {

            value = (String) object;

        } else
        {

            value = ObjectUtils.toString(object);

        }

        if (StringUtils.isBlank(value))
        {

            errors.add(ValidatorMessages.getMessage(action, field, context));

        }

    }

    /**
     * Checks if the parameter isn't null based on the values of other fields.
     * 
     * @param context the faces context
     * @param object the value of the field being validated.
     * @param parameters Any field parameters from the validation.xml.
     * @param errors The <code>Map</code> object to add errors to if any
     * validation errors occur.
     * @param action The <code>ValidatorAction</code> that is currently being
     * performed.
     * @param field The <code>Field</code> object associated with the current
     * field being validated.
     */
    public static void validateRequiredIf(FacesContext context, Object object, Map parameters, Collection errors, ValidatorAction action, Field field)
    {

        boolean required = false;

        final String value = ObjectUtils.toString(object);

        int ctr = 0;
        String fieldJoin = "AND";

        if (!StringUtils.isBlank(field.getVarValue("fieldJoin")))
        {

            fieldJoin = field.getVarValue("fieldJoin");

        }

        if ("AND".equalsIgnoreCase(fieldJoin))
        {

            required = true;

        }

        while (!StringUtils.isBlank(field.getVarValue("field[" + ctr + ']')))
        {

            String dependProp = field.getVarValue("field[" + ctr + ']');
            String dependTest = field.getVarValue("fieldTest[" + ctr + ']');
            String dependTestValue = field.getVarValue("fieldValue[" + ctr + ']');
            String dependIndexed = field.getVarValue("fieldIndexed[" + ctr + ']');

            if (dependIndexed == null)
            {

                dependIndexed = "false";

            }

            String dependVal = null;
            boolean thisRequired = false;

            if (field.isIndexed() && "true".equalsIgnoreCase(dependIndexed))
            {

                String key = field.getKey();

                if ((key.indexOf('[') > -1) && (key.indexOf(']') > -1))
                {

                    String ind = key.substring(0, key.indexOf('.') + 1);

                    dependProp = ind + dependProp;

                }

            }

            dependVal = (String) parameters.get(dependProp);

            if (dependTest.equals(FIELD_TEST_NULL))
            {

                if ((dependVal != null) && (dependVal.length() > 0))
                {

                    thisRequired = false;

                } else
                {

                    thisRequired = true;

                }

            }

            if (dependTest.equals(FIELD_TEST_NOTNULL))
            {

                if ((dependVal != null) && (dependVal.length() > 0))
                {

                    thisRequired = true;

                } else
                {

                    thisRequired = false;

                }

            }

            if (dependTest.equals(FIELD_TEST_EQUAL))
            {

                thisRequired = dependTestValue.equalsIgnoreCase(dependVal);

            }

            if ("AND".equalsIgnoreCase(fieldJoin))
            {

                required = required && thisRequired;

            } else
            {

                required = required || thisRequired;

            }

            ctr++;

        }

        if (required)
        {

            if (StringUtils.isBlank(value))
            {

                errors.add(ValidatorMessages.getMessage(action, field, context));

            }

        }

    }

    /**
     * Checks if the parameter matches the regular expression in the field's
     * mask attribute.
     * 
     * @param context the faces context
     * @param object the value of the field being validated.
     * @param parameters Any field parameters from the validation.xml.
     * @param errors The <code>Map</code> object to add errors to if any
     * validation errors occur.
     * @param action The <code>ValidatorAction</code> that is currently being
     * performed.
     * @param field The <code>Field</code> object associated with the current
     * field being validated.
     */
    public static void validateMask(FacesContext context, Object object, Map parameters, Collection errors, ValidatorAction action, Field field)
    {

        final String mask = field.getVarValue("mask");
        final String value = ObjectUtils.toString(object);

        if (StringUtils.isNotBlank(value) && !GenericValidator.matchRegexp(value, mask))
        {

            errors.add(ValidatorMessages.getMessage(action, field, context));

        }

    }

    /**
     * Checks if the field can safely be converted to a byte primitive.
     * 
     * @param context the faces context
     * @param object the value of the field being validated.
     * @param parameters Any field parameters from the validation.xml.
     * @param errors The <code>Map</code> object to add errors to if any
     * validation errors occur.
     * @param action The <code>ValidatorAction</code> that is currently being
     * performed.
     * @param field The <code>Field</code> object associated with the current
     * field being validated.
     */
    public static void validateByte(FacesContext context, Object object, Map parameters, Collection errors, ValidatorAction action, Field field)
    {

        Byte result = null;
        String value = ObjectUtils.toString(object);

        if (StringUtils.isNotBlank(value))
        {

            result = GenericTypeValidator.formatByte(value);

            if (result == null)
            {

                errors.add(ValidatorMessages.getMessage(action, field, context));

            }

        }

    }

    /**
     * Checks if the field can safely be converted to a short primitive.
     * 
     * @param context the faces context
     * @param object the value of the field being validated.
     * @param parameters Any field parameters from the validation.xml.
     * @param errors The <code>Map</code> object to add errors to if any
     * validation errors occur.
     * @param action The <code>ValidatorAction</code> that is currently being
     * performed.
     * @param field The <code>Field</code> object associated with the current
     * field being validated.
     */
    public static void validateShort(FacesContext context, Object object, Map parameters, Collection errors, ValidatorAction action, Field field)
    {

        Short result = null;
        String value = ObjectUtils.toString(object);

        if (StringUtils.isNotBlank(value))
        {

            result = GenericTypeValidator.formatShort(value);

            if (result == null)
            {

                errors.add(ValidatorMessages.getMessage(action, field, context));

            }

        }

    }

    /**
     * Checks if the field can safely be converted to an int primitive.
     * 
     * @param context the faces context
     * @param object the value of the field being validated.
     * @param parameters Any field parameters from the validation.xml.
     * @param errors The <code>Map</code> object to add errors to if any
     * validation errors occur.
     * @param action The <code>ValidatorAction</code> that is currently being
     * performed.
     * @param field The <code>Field</code> object associated with the current
     * field being validated.
     */
    public static void validateInteger(FacesContext context, Object object, Map parameters, Collection errors, ValidatorAction action, Field field)
    {

        Integer result = null;
        String value = ObjectUtils.toString(object);

        if (StringUtils.isNotBlank(value))
        {

            result = GenericTypeValidator.formatInt(value);

            if (result == null)
            {

                errors.add(ValidatorMessages.getMessage(action, field, context));

            }

        }

    }

    /**
     * Checks if the field can safely be converted to a long primitive.
     * 
     * @param context the faces context
     * @param object the value of the field being validated.
     * @param parameters Any field parameters from the validation.xml.
     * @param errors The <code>Map</code> object to add errors to if any
     * validation errors occur.
     * @param action The <code>ValidatorAction</code> that is currently being
     * performed.
     * @param field The <code>Field</code> object associated with the current
     * field being validated.
     */
    public static void validateLong(FacesContext context, Object object, Map parameters, Collection errors, ValidatorAction action, Field field)
    {

        Long result = null;
        String value = ObjectUtils.toString(object);

        if (StringUtils.isNotBlank(value))
        {

            result = GenericTypeValidator.formatLong(value);

            if (result == null)
            {

                errors.add(ValidatorMessages.getMessage(action, field, context));

            }

        }

    }

    /**
     * Checks if the field can safely be converted to a float primitive.
     * 
     * @param context the faces context
     * @param object the value of the field being validated.
     * @param parameters Any field parameters from the validation.xml.
     * @param errors The <code>Map</code> object to add errors to if any
     * validation errors occur.
     * @param action The <code>ValidatorAction</code> that is currently being
     * performed.
     * @param field The <code>Field</code> object associated with the current
     * field being validated.
     */
    public static void validateFloat(FacesContext context, Object object, Map parameters, Collection errors, ValidatorAction action, Field field)
    {

        Float result = null;
        String value = ObjectUtils.toString(object);

        if (StringUtils.isNotBlank(value))
        {

            result = GenericTypeValidator.formatFloat(value);

            if (result == null)
            {

                errors.add(ValidatorMessages.getMessage(action, field, context));

            }

        }

    }

    /**
     * Checks if the field can safely be converted to a double primitive.
     * 
     * @param context the faces context
     * @param object the value of the field being validated.
     * @param parameters Any field parameters from the validation.xml.
     * @param errors The <code>Map</code> object to add errors to if any
     * validation errors occur.
     * @param action The <code>ValidatorAction</code> that is currently being
     * performed.
     * @param field The <code>Field</code> object associated with the current
     * field being validated.
     */
    public static void validateDouble(FacesContext context, Object object, Map parameters, Collection errors, ValidatorAction action, Field field)
    {

        Double result = null;
        String value = ObjectUtils.toString(object);

        if (StringUtils.isNotBlank(value))
        {

            result = GenericTypeValidator.formatDouble(value);

            if (result == null)
            {

                errors.add(ValidatorMessages.getMessage(action, field, context));

            }

        }

    }

    /**
     * Checks if the field is a valid date. If the field has a datePattern
     * variable, that will be used to format
     * <code>java.text.SimpleDateFormat</code>. If the field has a
     * datePatternStrict variable, that will be used to format
     * <code>java.text.SimpleDateFormat</code> and the length will be checked
     * so '2/12/1999' will not pass validation with the format 'MM/dd/yyyy'
     * because the month isn't two digits. If no datePattern variable is
     * specified, then the field gets the DateFormat.SHORT format for the
     * locale. The setLenient method is set to <code>false</code> for all
     * variations. If the <code>object</code> is a date instance, then validation is not performed.
     * 
     * @param context the faces context
     * @param object the value of the field being validated.
     * @param parameters Any field parameters from the validation.xml.
     * @param errors The <code>Map</code> object to add errors to if any
     * validation errors occur.
     * @param action The <code>ValidatorAction</code> that is currently being
     * performed.
     * @param field The <code>Field</code> object associated with the current
     * field being validated.
     */
    public static void validateDate(FacesContext context, Object object, Map parameters, Collection errors, ValidatorAction action, Field field)
    {

        // - only validate if the object is not already a date or calendar
        if (!(object instanceof Date) && !(object instanceof Calendar))
        {

            Date result = null;
            String value = ObjectUtils.toString(object);
            String datePattern = field.getVarValue("datePattern");
            String datePatternStrict = field.getVarValue("datePatternStrict");
            Locale locale = Locale.getDefault();

            if (StringUtils.isNotBlank(value))
            {

                if (StringUtils.isNotBlank(datePattern))
                {

                    result = GenericTypeValidator.formatDate(value, datePattern, false);

                } else if (StringUtils.isNotBlank(datePatternStrict))
                {

                    result = GenericTypeValidator.formatDate(value, datePatternStrict, true);

                } else
                {

                    result = GenericTypeValidator.formatDate(value, locale);

                }

                if (result == null)
                {

                    errors.add(ValidatorMessages.getMessage(action, field, context));

                }

            }

        }

    }

    /**
     * Checks if a fields value is within a range (min &amp; max specified in
     * the vars attribute).
     * 
     * @param context the faces context
     * @param object the value of the field being validated.
     * @param parameters Any field parameters from the validation.xml.
     * @param errors The <code>Map</code> object to add errors to if any
     * validation errors occur.
     * @param action The <code>ValidatorAction</code> that is currently being
     * performed.
     * @param field The <code>Field</code> object associated with the current
     * field being validated.
     */
    public static void validateLongRange(FacesContext context, Object object, Map parameters, Collection errors, ValidatorAction action, Field field)
    {

        final String value = ObjectUtils.toString(object);

        if (StringUtils.isNotBlank(value))
        {

            try
            {

                long intValue = Long.parseLong(value);
                long min = Long.parseLong(field.getVarValue("min"));
                long max = Long.parseLong(field.getVarValue("max"));

                if (!GenericValidator.isInRange(intValue, min, max))
                {

                    errors.add(ValidatorMessages.getMessage(action, field, context));

                }

            } catch (Exception exception)
            {

                errors.add(ValidatorMessages.getMessage(action, field, context));

            }

        }

    }

    /**
     * Checks if a fields value is within a range (min &amp; max specified in
     * the vars attribute).
     * 
     * @param context the faces context
     * @param object the value of the field being validated.
     * @param parameters Any field parameters from the validation.xml.
     * @param errors The <code>Map</code> object to add errors to if any
     * validation errors occur.
     * @param action The <code>ValidatorAction</code> that is currently being
     * performed.
     * @param field The <code>Field</code> object associated with the current
     * field being validated.
     */
    public static void validateDoubleRange(FacesContext context, Object object, Map parameters, Collection errors, ValidatorAction action, Field field)
    {

        final String value = ObjectUtils.toString(object);

        if (StringUtils.isNotBlank(value))
        {

            try
            {

                double doubleValue = Double.parseDouble(value);
                double min = Double.parseDouble(field.getVarValue("min"));
                double max = Double.parseDouble(field.getVarValue("max"));

                if (!GenericValidator.isInRange(doubleValue, min, max))
                {

                    errors.add(ValidatorMessages.getMessage(action, field, context));

                }

            } catch (Exception exception)
            {

                errors.add(ValidatorMessages.getMessage(action, field, context));

            }

        }

    }

    /**
     * Checks if a fields value is within a range (min &amp; max specified in
     * the vars attribute).
     * 
     * @param context the faces context
     * @param object the value of the field being validated.
     * @param parameters Any field parameters from the validation.xml.
     * @param errors The <code>Map</code> object to add errors to if any
     * validation errors occur.
     * @param action The <code>ValidatorAction</code> that is currently being
     * performed.
     * @param field The <code>Field</code> object associated with the current
     * field being validated.
     */
    public static void validateFloatRange(FacesContext context, Object object, Map parameters, Collection errors, ValidatorAction action, Field field)
    {

        final String value = ObjectUtils.toString(object);

        if (StringUtils.isNotBlank(value))
        {

            try
            {

                float floatValue = Float.parseFloat(value);
                float min = Float.parseFloat(field.getVarValue("min"));
                float max = Float.parseFloat(field.getVarValue("max"));

                if (!GenericValidator.isInRange(floatValue, min, max))
                {

                    errors.add(ValidatorMessages.getMessage(action, field, context));

                }

            } catch (Exception exception)
            {

                errors.add(ValidatorMessages.getMessage(action, field, context));

            }

        }

    }

    /**
     * Checks if the field is a valid credit card number.
     * 
     * @param context the faces context
     * @param object the value of the field being validated.
     * @param parameters Any field parameters from the validation.xml.
     * @param errors The <code>Map</code> object to add errors to if any
     * validation errors occur.
     * @param action The <code>ValidatorAction</code> that is currently being
     * performed.
     * @param field The <code>Field</code> object associated with the current
     * field being validated.
     */
    public static void validateCreditCard(FacesContext context, Object object, Map parameters, Collection errors, ValidatorAction action, Field field)
    {

        Long result = null;
        final String value = ObjectUtils.toString(object);

        if (StringUtils.isNotBlank(value))
        {

            result = GenericTypeValidator.formatCreditCard(value);

            if (result == null)
            {

                errors.add(ValidatorMessages.getMessage(action, field, context));

            }

        }

    }

    /**
     * Checks if a field has a valid exception-mail address.
     * 
     * @param context the faces context
     * @param object the value of the field being validated.
     * @param parameters Any field parameters from the validation.xml.
     * @param errors The <code>Map</code> object to add errors to if any
     * validation errors occur.
     * @param action The <code>ValidatorAction</code> that is currently being
     * performed.
     * @param field The <code>Field</code> object associated with the current
     * field being validated.
     */
    public static void validateEmail(FacesContext context, Object object, Map parameters, Collection errors, ValidatorAction action, Field field)
    {

        final String value = ObjectUtils.toString(object);

        if (StringUtils.isNotBlank(value) && !GenericValidator.isEmail(value))
        {

            errors.add(ValidatorMessages.getMessage(action, field, context));

        }

    }

    /**
     * Checks if the field's length is less than or equal to the maximum value.
     * A <code>Null</code> will be considered an error.
     * 
     * @param context the faces context
     * @param object the value of the field being validated.
     * @param parameters Any field parameters from the validation.xml.
     * @param errors The <code>Map</code> object to add errors to if any
     * validation errors occur.
     * @param action The <code>ValidatorAction</code> that is currently being
     * performed.
     * @param field The <code>Field</code> object associated with the current
     * field being validated.
     */
    public static void validateMaxLength(FacesContext context, Object object, Map parameters, Collection errors, ValidatorAction action, Field field)
    {

        final String value = ObjectUtils.toString(object);

        if (StringUtils.isNotBlank(value))
        {

            try
            {

                int max = Integer.parseInt(field.getVarValue("maxlength"));

                if (!GenericValidator.maxLength(value, max))
                {

                    errors.add(ValidatorMessages.getMessage(action, field, context));

                }

            } catch (Exception exception)
            {

                errors.add(ValidatorMessages.getMessage(action, field, context));

            }

        }

    }

    /**
     * Checks if the field's length is greater than or equal to the minimum
     * value. A <code>Null</code> will be considered an error.
     * 
     * @param context the faces context
     * @param object the value of the field being validated.
     * @param parameters Any field parameters from the validation.xml.
     * @param errors The <code>Map</code> object to add errors to if any
     * validation errors occur.
     * @param action The <code>ValidatorAction</code> that is currently being
     * performed.
     * @param field The <code>Field</code> object associated with the current
     * field being validated.
     */
    public static void validateMinLength(FacesContext context, Object object, Map parameters, Collection errors, ValidatorAction action, Field field)
    {

        String value = ObjectUtils.toString(object);

        if (!StringUtils.isBlank(value))
        {

            try
            {

                int min = Integer.parseInt(field.getVarValue("minlength"));

                if (!GenericValidator.minLength(value, min))
                {

                    errors.add(ValidatorMessages.getMessage(action, field, context));

                }

            } catch (Exception exception)
            {

                errors.add(ValidatorMessages.getMessage(action, field, context));

            }

        }

    }

    /**
     * <p>
     * Validates whether the URL string passed in is a valid URL or not. Does
     * this by attempting to construct a java.net.URL instance and checking
     * whether or not, it's valid.
     * </p>
     * 
     * @param context the faces context
     * @param object the value of the field being validated.
     * @param parameters Any field parameters from the validation.xml.
     * @param errors The <code>Map</code> object to add errors to if any
     * validation errors occur.
     * @param action The <code>ValidatorAction</code> that is currently being
     * performed.
     * @param field The <code>Field</code> object associated with the current
     * field being validated.
     */
    @SuppressWarnings("unused")
    public static void validateUrl(FacesContext context, Object object, Map parameters, Collection errors, ValidatorAction action, Field field)
    {

        boolean valid = true;
        String urlString = ObjectUtils.toString(object);

        try
        {

            new URL(urlString);

        } catch (Exception exception)
        {

            valid = false;

        }

        if (!valid)
        {

            errors.add(ValidatorMessages.getMessage(action, field, context));

        }

    }

    /**
     * Checks if the field is a valid time. If the field has a timePattern variable,
     * that will be used to format <code>java.text.SimpleDateFormat</code>.
     * 
     * @param context the faces context
     * @param object the value of the field being validated.
     * @param parameters Any field parameters from the validation.xml.
     * @param errors The <code>Map</code> object to add errors to if any
     * validation errors occur.
     * @param action The <code>ValidatorAction</code> that is currently being
     * performed.
     * @param field The <code>Field</code> object associated with the current
     * field being validated.
     */
    public static void validateTime(FacesContext context, Object object, Map parameters, Collection errors, ValidatorAction action, Field field)
    {

        // - only validate if the object is not already a date
        if (!(object instanceof Date) && !(object instanceof Calendar))
        {

            final String value = ObjectUtils.toString(object);
            final String timePattern = field.getVarValue("timePattern");

            if (StringUtils.isNotBlank(value))
            {

                try
                {

                    if (StringUtils.isNotBlank(timePattern))
                    {

                        final java.text.DateFormat timeFormatter = new SimpleDateFormat(timePattern);

                        timeFormatter.parse(value);

                    } else
                    {

                        DateFormat.getTimeInstance().parse(value);

                    }

                } catch (Exception exception)
                {

                    errors.add(ValidatorMessages.getMessage(action, field, context));

                }

            }

        }

    }

    /**
     * Checks if the field's value is equal to another field's value on the same form.
     * 
     * @param context the faces context
     * @param object the value of the field being validated.
     * @param parameters Any field parameters from the validation.xml.
     * @param errors The <code>Map</code> object to add errors to if any
     * validation errors occur.
     * @param action The <code>ValidatorAction</code> that is currently being
     * performed.
     * @param field The <code>Field</code> object associated with the current
     * field being validated.
     * @throws Exception
     */
    public static void validateEqual(FacesContext context, Object object, Map parameters, Collection errors, ValidatorAction action, Field field) throws Exception
    {

        final String value = ObjectUtils.toString(object);

        if (StringUtils.isNotBlank(value))
        {

            final String equalFieldName = field.getVarValue("fieldName");
            final EditableValueHolder equalField = (EditableValueHolder) findComponent(context, equalFieldName);
            final Object equalFieldValue = (equalField.getSubmittedValue() != null) ? equalField.getSubmittedValue() : equalField.getValue();

            if ((equalFieldValue != null) && !equalFieldValue.equals(value))
            {

                errors.add(ValidatorMessages.getMessage(action, field, context));

            }

        }

    }

    /**
     * @param context
     * @param componentId
     * @return component
     * @throws ValidatorException
     */
    public static UIComponent findComponent(final FacesContext context, final String componentId) throws ValidatorException
    {

        UIComponent component = null;
        final int index = componentId.indexOf(':');

        if (index != -1)
        {

            final String parentId = componentId.substring(0, index);
            UIComponent parent = context.getViewRoot().findComponent(parentId);

            if (parent == null)
            {

                throw new ValidatorException("No component with id: " + parentId + " could be found on view!");

            }

            final String restOfId = componentId.substring(index + 1, componentId.length());

            component = findComponent(context, parent, restOfId);

        }

        return component;

    }

    private static final char COMPONENT_NAME_SEPARATOR = ':';

    /**
     * @param context
     * @param parent
     * @param componentId
     * @return component
     */
    public static UIComponent findComponent(final FacesContext context, final UIComponent parent, String componentId)
    {

        UIComponent component = null;
        final int index = componentId.indexOf(COMPONENT_NAME_SEPARATOR);

        if (index != -1)
        {

            final String firstId = componentId.substring(0, index);

            component = findChildComponent(parent, firstId);
            componentId = componentId.substring(index + 1, componentId.length());

        } else if (StringUtils.isNotBlank(componentId))
        {

            component = findChildComponent(parent, componentId);

        }

        if ((component != null) && (componentId.indexOf(COMPONENT_NAME_SEPARATOR) != -1))
        {

            component = findComponent(context, component, componentId);

        }

        return component;

    }

    /**
     * @param component
     * @param id
     * @return child
     */
    public static UIComponent findChildComponent(final UIComponent component, final String id)
    {

        UIComponent child = null;

        if (component != null)
        {

            if (component.getId().equals(id))
            {

                child = component;

            } else
            {

                for (final Iterator iterator = component.getFacetsAndChildren(); iterator.hasNext();)
                {

                    child = findChildComponent((UIComponent) iterator.next(), id);

                    if (child != null)
                    {

                        break;

                    }

                }

            }

        }

        return child;

    }

}
