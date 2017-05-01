package br.com.gti.profectus.infra.calculator.antlr;

import java.util.List;
import java.util.Map;


/**
 * ICalculator.
 * @author eduardo.fsantos
 * @since 04/05/2015
 */
public interface ICalculator {

    /**
     * calculate.
     * @param equation
     * @param variables
     * @return
     * @throws Exception
     */
    Value<Double> calculate(String equation, Map<String, Value<?>> variables) throws Exception;

    /**
     * getVariablesOfEquation.
     * @param equation
     * @return
     */
    List<String> getVariablesOfEquation(String equation) throws Exception;


    /**
     * getVariablesOfEquation.
     * @param equation
     * @return
     */
    List<String> getFunctionsOfEquation(String equation) throws Exception;



    /**
     * equationValidator.
     * @param equation
     * @return
     */
    String equationValidator(String equation);



}
