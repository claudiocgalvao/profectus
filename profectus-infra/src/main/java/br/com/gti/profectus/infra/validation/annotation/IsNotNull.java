package br.com.gti.profectus.infra.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation respons�vel por marcar os atributos do DTO que
 * n�o podem ter valores em branco. <br>
 * <br>
 * - values....: Valores permitidos para o atributo; <br>
 * - message...: Mensagem de erro.
 * @author Tiago B. Suprinyak
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IsNotNull {

    /**
     * Valores permitidos para o atributo.
     */
    String[] values() default "";

    /**
     * Mensagem de erro.
     */
    String message();

}
