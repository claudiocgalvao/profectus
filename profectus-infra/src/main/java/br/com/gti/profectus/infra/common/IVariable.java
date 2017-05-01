package br.com.gti.profectus.infra.common;

import java.io.Serializable;

/**
 * IVariable.
 * @author eduardo.fsantos
 * @since 08/06/2015
 */
public interface IVariable extends Serializable {

    final int TYPE_ORIGEM_INTERNAL = 1;

    final int TYPE_ORIGEM_EXTERNAL = 2;

    final int TYPE_VARIABLE_DOUBLE = 3; //Double

    final int TYPE_VARIABLE_STRING = 1; //String

    final int TYPE_VARIABLE_DATE = 4; // Date

    final int TYPE_VARIABLE_INTEGER = 2; //Integer

    final int TYPE_VARIABLE_BOOLEAN = 5; //Boolean
}
