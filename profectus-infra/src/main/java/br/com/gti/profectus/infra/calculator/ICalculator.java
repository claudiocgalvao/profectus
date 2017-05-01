package br.com.gti.profectus.infra.calculator;

import java.util.List;
import java.util.Map;

import br.com.gti.profectus.infra.calculator.antlr.Value;
		
/**
 * ICalculator.
 */
public interface ICalculator {

    /**
     * calculate.
     * @param equation
     * @param variables
     * @return
     */
    Value<Double> calculate(String equation, Map<String, Value<?>> variables);

    /**
     * getVariablesOfEquation.
     * @param equation
     * @return
     */
    List<String> getVariablesOfEquation(String equation);

    /**
     * equationValidator.
     * @param equation
     * @return
     */
    String equationValidator(String equation);

}
