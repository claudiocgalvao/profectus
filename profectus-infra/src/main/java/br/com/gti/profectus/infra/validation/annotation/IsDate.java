package br.com.gti.profectus.infra.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation respons�vel por marcar os atributos do DTO que
 * s�o do tipo date e seu formato. <br>
 * <br>
 * - formatter...: Formato esperado para data; <br>
 * - message.....: Mensagem de erro.
 * @author Tiago B. Suprinyak
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IsDate {

    /**
     * Formato esperado para data.
     * Padr�o: yyyy-MM-dd
     */
    String formatter() default "yyyy-MM-dd";

    /**
     * Mensagem de erro.
     */
    String message();

}
