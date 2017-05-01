package br.com.gti.profectus.infra.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation respons�vel por marcar os atributos do DTO que
 * n�o podem ser nulos. <br>
 * <br>
 * - emptyValue...: Informa o valor que ser� considerado vazio. <br>
 * - message......: Mensagem de erro.
 * @author Tiago B. Suprinyak
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IsNotEmpty {

    /**
     * Informa o valor que ser� considerado vazio.
     */
    String emptyValue() default "";

    /**
     * Mensagem de erro.
     */
    String message();

}
