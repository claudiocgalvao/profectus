package br.com.gti.profectus.infra.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Interface responsavel por verificar se o valor é zero.
 * IsNotZero.
 * @author tiago.canatelli
 * @since 27/11/2014
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IsNotZero {

    /**
     * Mensagem de erro.
     */
    String message();

}
