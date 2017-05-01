package br.com.gti.profectus.web.validation;

import java.text.ParseException;
import java.util.Date;

import org.springframework.util.Assert;
import org.springframework.validation.Errors;

import br.com.gti.profectus.tools.dateTime.DateHelper;

/**
 * GenericValidator (Antigo).
 */
public class GenericValidatorOld {

    /**
     * Method to validate date format to datepiker.
     * @param errors
     * @param field
     * @param errorCode
     * @param errorArgs
     * @param defaultMessage
     */
    protected void validatePeriodDate(final Errors errors, final String field, final String errorCode,
            final Object[] errorArgs, final String defaultMessage) {
        Assert.notNull(errors, "Errors object must not be null");
        Object value = errors.getFieldValue(field);
        try {
            DateHelper.parseToDateTime(value.toString(), DateHelper.DATE_YYYY_MM_DD);
        } catch (ParseException e) {
            errors.rejectValue(field, errorCode, errorArgs, defaultMessage);
        }
    }

    /**
     * Method to validate date format to datepiker.
     * @param errors
     * @param field
     * @param errorCode
     * @param errorArgs
     * @param defaultMessage
     */
    protected void validatePeriodDateGlobalFormat(final Errors errors, final String field, final String errorCode,
            final Object[] errorArgs, final String defaultMessage) {
        Assert.notNull(errors, "Errors object must not be null");
        Object value = errors.getFieldValue(field);
        try {
            DateHelper.parseToDateTime(value.toString(), DateHelper.DATE_YYYY_MM_DD);
        } catch (ParseException e) {
            errors.rejectValue(field, errorCode, errorArgs, defaultMessage);
        }
    }

    /**
     * Method to validate file extension.
     * @param errors
     * @param field
     * @param expectedExtension
     * @param errorCode
     * @param errorArgs
     * @param defaultMessage
     */
    //    protected void validateFileExtension(final Errors errors, final String field, final String expectedExtension,
    //     final String errorCode, final Object[] errorArgs, String defaultMessage) {
    //        Assert.notNull(errors, "Errors object must not be null");
    //        Object value = errors.getFieldValue(field);
    //        String fileExtension = UploadFilesUtil.getFileExtension(value.toString());
    //        if (!fileExtension.equals(expectedExtension)) {
    //            errors.rejectValue(field, errorCode, errorArgs, defaultMessage);
    //        }
    //    }
    protected void validatePeriodBetweenDates(final Errors errors, final String dateIni, final String dateFinal,
            final String message) {
        Assert.notNull(errors, "Errors object must not be null");
        Object valueDataIni = errors.getFieldValue(dateIni);
        Object valueDataFinal = errors.getFieldValue(dateFinal);
        try {
            Date dtInitial = DateHelper.parseToDateTime(valueDataIni.toString(), DateHelper.DATE_DD_MM_YYYY);
            Date dtFinal = DateHelper.parseToDateTime(valueDataFinal.toString(), DateHelper.DATE_DD_MM_YYYY);
            if (dtFinal.before(dtInitial)) {
                errors.rejectValue(dateIni, message);
                errors.rejectValue(dateFinal, message);
            }
        } catch (ParseException e) {
            errors.rejectValue(dateIni, message);
            errors.rejectValue(dateFinal, message);
        }
    }

    /**
     * Validate string dates with global format.
     * @param errors
     * @param dateIni
     * @param dateFinal
     * @param message
     */
    protected void validatePeriodBetweenDatesGlobalFormat(final Errors errors, final String dateIni,
            final String dateFinal, final String message) {
        Assert.notNull(errors, "Errors object must not be null");
        Object valueDataIni = errors.getFieldValue(dateIni);
        Object valueDataFinal = errors.getFieldValue(dateFinal);
        try {
            Date dtInitial = DateHelper.parseToDateTime(valueDataIni.toString(), DateHelper.DATE_YYYY_MM_DD);
            Date dtFinal = DateHelper.parseToDateTime(valueDataFinal.toString(), DateHelper.DATE_YYYY_MM_DD);
            if (dtFinal.before(dtInitial)) {
                errors.rejectValue(dateFinal, message);
            }
        } catch (ParseException e) {
            errors.rejectValue(dateIni, message);
            errors.rejectValue(dateFinal, message);
        }
    }

    /**
     * Validate Date hour field is valid.
     * @param errors
     * @param dateField
     * @param hourField
     * @param message
     */
    protected void validateDateHour(final Errors errors, final String dateField, final String hourField,
            final String message) {
        Assert.notNull(errors, "Errors object must not be null");
        Object valueDataField = errors.getFieldValue(dateField);
        Object valueHourField = errors.getFieldValue(hourField);
        try {
            String dateTime = valueDataField.toString() + " " + valueHourField.toString();
            Date dtScheduling = DateHelper.parseToDateTime(dateTime, DateHelper.DATETIME_YYYY_MM_DD_HH_MM);
            Date dtAtual = new Date();
            if (dtScheduling.before(dtAtual)) {
                errors.rejectValue(dateField, "message.formPurgeScheduling.datehour.scheduling.error");
            }
        } catch (ParseException e) {
            errors.rejectValue(hourField, message);
        }
    }

    /**
     * Method to validate date format to datepiker.
     * @param errors
     * @param field
     * @param errorCode
     * @param errorArgs
     * @param defaultMessage
     */
    protected void validatePeriodDateInv(final Errors errors, final String field, final String errorCode,
            final Object[] errorArgs, final String defaultMessage) {
        Assert.notNull(errors, "Errors object must not be null");
        Object value = errors.getFieldValue(field);
        try {
            DateHelper.parseToDateTime(value.toString(), DateHelper.DATE_YYYY_MM_DD);
        } catch (ParseException e) {
            errors.rejectValue(field, errorCode, errorArgs, defaultMessage);
        }
    }
}
