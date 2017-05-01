package br.com.gti.profectus.web.validation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;

import br.com.gti.profectus.infra.validation.annotation.IsDate;
import br.com.gti.profectus.infra.validation.annotation.IsNotEmpty;
import br.com.gti.profectus.infra.validation.annotation.IsNotNull;
import br.com.gti.profectus.infra.validation.annotation.IsNotZero;
import br.com.gti.profectus.tools.constants.NumberIntMagic;
import br.com.gti.profectus.tools.dateTime.DateHelper;

/**
 * Classe de validacao dos atributos de um objeto.
 * @author Tiago B. Suprinyak
 * @param <DTO> - DTO a ser validado
 */
public abstract class AbstractValidator<DTO> {

    /**
     * Metodo abstrato para executar pre-validacao.
     * @param dto
     * @param bindingResult
     * @throws Exception
     */
    public abstract void beforeValidate(DTO dto, BindingResult bindingResult) throws Exception;

    /**
     * Metodo abstrato para executar pre-validacao.
     * @param dto
     * @param bindingResult
     * @throws Exception
     */
    //public abstract void beforeValidateParameter(DTO dto, BindingResult bindingResult) throws Exception;

    /**
     * Metodo responsavel validar os atributos do objetos.
     * @param object
     * @param bindingResult
     * @throws Exception
     */
    public abstract void validate(DTO dto, BindingResult bindingResult) throws Exception;

    /**
     * Metodo responsavel validar os atributos do objetos parametro.
     * @param object
     * @param bindingResult
     * @throws Exception
     */
    //public abstract void validateParameter(DTO dto, BindingResult bindingResult) throws Exception;

    /**
     * Metodo abstrato para executar pos-validacao.
     * @param dto
     * @param bindingResult
     * @throws Exception
     */
    public abstract void afterValidate(DTO dto, BindingResult bindingResult) throws Exception;

    /**
     * Metodo para validação recursiva de fields.
     * @author tiago.canatelli
     * @since 27/11/2014
     * @param dto
     * @param bindingResult
     * @param classChildName
     * @param isValidateChildsDTO - Flag para verificar se a validacao será apenas na DTO pai, ou se irá validar todos!
     * @throws Exception void
     */
    @SuppressWarnings("unchecked")
    protected <VALUES> void validateDTO(DTO dto,
                                        BindingResult bindingResult,
                                        String classChildName,
                                        Boolean isValidateChildsDTO) throws Exception {
        IsDate isDate = null;
        IsNotNull isNotNull = null;
        IsNotEmpty isNotEmpty = null;
        IsNotZero isNotZero = null;

        Field field = null;
        Object objectValue = null;
        Annotation[] annotations = null;

        Field[] fields = dto.getClass().getDeclaredFields();

        for (int idx = 0; idx < fields.length; idx++) {
            field = fields[idx];

            String obj = field.getType().getSimpleName();

            if (obj.endsWith("DTO") && isValidateChildsDTO) {

                objectValue = this.executeMethodGet(dto, field.getName());

                classChildName = classChildName + this.formatChildClassName(obj) + ".";

                this.validateDTO((DTO) objectValue, bindingResult, classChildName, isValidateChildsDTO);

                classChildName = "";

            }

            annotations = field.getAnnotations();
            objectValue = this.executeMethodGet(dto, field.getName());

            for (Annotation annotation : annotations) {
                if (annotation instanceof IsNotNull) {
                    List<VALUES> listValues = null;

                    isNotNull = (IsNotNull) annotation;

                    if (!isNotNull.values()[0].equals("")) {
                        listValues = (List<VALUES>) Arrays.asList(isNotNull.values());
                    }

                    if (objectValue == null) {
                        bindingResult.rejectValue(classChildName + field.getName(), isNotNull.message());
                        break;
                    } else
                        if (listValues != null && !listValues.contains(objectValue)) {
                            bindingResult.rejectValue(classChildName + field.getName(), isNotNull.message());
                            break;
                        }
                } else
                    if (annotation instanceof IsNotEmpty) {
                        isNotEmpty = (IsNotEmpty) annotation;

                        if (objectValue == null || objectValue.toString().trim().equals(isNotEmpty.emptyValue())) {
                            bindingResult.rejectValue(classChildName + field.getName(), isNotEmpty.message());
                            break;
                        }
                    } else
                        if (annotation instanceof IsDate) {
                            isDate = (IsDate) annotation;

                            SimpleDateFormat sdf = new SimpleDateFormat(isDate.formatter());

                            try {
                                sdf.parse(objectValue.toString());
                            } catch (Exception exception) {
                                bindingResult.rejectValue(classChildName + field.getName(), isDate.message());
                                break;
                            }
                        } else
                            if (annotation instanceof IsNotZero) {
                                isNotZero = (IsNotZero) annotation;

                                if (objectValue != null && objectValue.toString().trim().equals(NumberIntMagic.ZERO)) {
                                    bindingResult.rejectValue(classChildName + field.getName(), isNotZero.message());
                                    break;
                                }
                            } else {
                                continue;
                            }
            }
        }
    }

    /**
     * validateChildDTO.
     * @author eduardo.fsantos
     * @since 03/12/2014
     * @param dto
     * @param bindingResult
     * @param classChildName
     * @throws Exception void
     */
    @SuppressWarnings("unchecked")
    protected <VALUES>
            void
            validateChildDTO(DTO dto, BindingResult bindingResult, String classChildName) throws Exception {

        IsDate isDate = null;
        IsNotNull isNotNull = null;
        IsNotEmpty isNotEmpty = null;
        IsNotZero isNotZero = null;

        Field field = null;
        Object objectValue = null;
        Annotation[] annotations = null;

        Object childClass = this.executeMethodGet(dto, classChildName);

        classChildName = classChildName.concat(".");

        Field[] fields = childClass.getClass().getDeclaredFields();

        for (int idx = 0; idx < fields.length; idx++) {
            field = fields[idx];
            annotations = field.getAnnotations();
            objectValue = this.executeMethodGet(childClass, field.getName());

            for (Annotation annotation : annotations) {
                if (annotation instanceof IsNotNull) {
                    List<VALUES> listValues = null;

                    isNotNull = (IsNotNull) annotation;

                    if (!isNotNull.values()[0].equals("")) {
                        listValues = (List<VALUES>) Arrays.asList(isNotNull.values());
                    }

                    if (objectValue == null) {
                        bindingResult.rejectValue(classChildName + field.getName(), isNotNull.message());
                        break;
                    } else
                        if (listValues != null && !listValues.contains(objectValue)) {
                            bindingResult.rejectValue(classChildName + field.getName(), isNotNull.message());
                            break;
                        }
                } else
                    if (annotation instanceof IsNotEmpty) {
                        isNotEmpty = (IsNotEmpty) annotation;

                        if (objectValue == null || objectValue.toString().trim().equals(isNotEmpty.emptyValue())) {
                            bindingResult.rejectValue(classChildName + field.getName(), isNotEmpty.message());
                            break;
                        }
                    } else
                        if (annotation instanceof IsDate) {
                            isDate = (IsDate) annotation;

                            SimpleDateFormat sdf = new SimpleDateFormat(isDate.formatter());

                            try {
                                sdf.parse(objectValue.toString());
                            } catch (Exception exception) {
                                bindingResult.rejectValue(classChildName + field.getName(), isDate.message());
                                break;
                            }
                        } else
                            if (annotation instanceof IsNotZero) {
                                isNotZero = (IsNotZero) annotation;

                                if (objectValue != null && objectValue.toString().trim().equals(NumberIntMagic.ZERO)) {
                                    bindingResult.rejectValue(classChildName + field.getName(), isNotZero.message());
                                    break;
                                }
                            } else {
                                continue;
                            }
            }
        }
    }

    /**
     * executeMethodGet.
     * @author eduardo.fsantos
     * @since 03/12/2014
     * @param object
     * @param nameMethod
     * @return
     * @throws Exception Object
     */
    private Object executeMethodGet(Object object, String nameMethod) throws Exception {
        Method method = object.getClass().getMethod(this.formatMethodName(nameMethod, "get"));

        return method.invoke(object);
    }

    /**
     * formatMethodName.
     * @author eduardo.fsantos
     * @since 03/12/2014
     * @param field
     * @param prefix
     * @return String
     */
    private String formatMethodName(String field, String prefix) {
        StringBuilder method = new StringBuilder();

        method.append(prefix);
        method.append(field.substring(0, 1).toUpperCase());
        method.append(field.substring(1));

        return method.toString();
    }

    /**
     * Formata o nome de metodos "get", "set" e "is".
     * @param prefix
     * @param field
     * @return String
     */
    private String formatChildClassName(String className) {
        StringBuilder method = new StringBuilder();

        method.append(className.substring(0, 1).toLowerCase());
        method.append(className.substring(1));

        return method.toString();
    }

    /**
     * Validate date format.
     * @since 30/12/2014
     * @param bindingResult
     * @param fieldName
     * @param messagesProperties
     */
    protected void validateDate(final BindingResult bindingResult,
                                final String fieldName,
                                final String messagesProperties) {
        Assert.notNull(bindingResult, "Errors object must not be null");
        Object dateValue = bindingResult.getFieldValue(fieldName);
        try {
            DateHelper.parseToDateTime(dateValue.toString(), DateHelper.DATE_YYYY_MM_DD);

            if (!DateHelper.isDate(dateValue.toString())) {
                bindingResult.rejectValue(fieldName, messagesProperties);
            }

        } catch (ParseException e) {
            bindingResult.rejectValue(fieldName, messagesProperties);
        }
    }

    /**
     * Validar se a data final vem antes da data inicial.
     * @since 30/12/2014
     * @param bindingResult
     * @param fieldNameInitialDate
     * @param fieldNameFinalDate
     * @param messagesProperties
     */
    protected void validateFinalDateComesBeforeInitialDate(final BindingResult bindingResult,
                                                           final String fieldNameInitialDate,
                                                           final String fieldNameFinalDate,
                                                           final String messagesProperties) {
        Assert.notNull(bindingResult, "Errors object must not be null");
        Object valueInitialDate = bindingResult.getFieldValue(fieldNameInitialDate);
        Object valueFinalDate = bindingResult.getFieldValue(fieldNameFinalDate);
        try {
            Date initialDate = DateHelper.parseToDateTime(valueInitialDate.toString(), DateHelper.DATE_YYYY_MM_DD);
            Date finalDate = DateHelper.parseToDateTime(valueFinalDate.toString(), DateHelper.DATE_YYYY_MM_DD);
            if (finalDate.before(initialDate)) {
                bindingResult.rejectValue(fieldNameFinalDate, messagesProperties);
            }
        } catch (ParseException e) {
            bindingResult.rejectValue(fieldNameInitialDate, messagesProperties);
            bindingResult.rejectValue(fieldNameFinalDate, messagesProperties);
        }
    }

}
