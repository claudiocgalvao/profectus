package br.com.gti.profectus.web.support;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Utilizar esta anotacao quando for necessaria a utilizacao de um layout diferente do layout padrao.
 * @author adriano.machado
 */
@Target({
         ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Layout {

    /**
     * Informar o nome do layout a ser utilizado.
     */
    String value() default "";
}
