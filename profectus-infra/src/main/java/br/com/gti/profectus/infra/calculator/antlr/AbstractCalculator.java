package br.com.gti.profectus.infra.calculator.antlr;

import java.util.List;
import java.util.Map;

/**
 * AbstractCalculator.
 * @author eduardo.fsantos
 * @since 05/05/2015
 */
public abstract class AbstractCalculator implements ICalculator {

    /**
     * Constructor of class TaxCalculator.java.
     */
    public AbstractCalculator() {
    }

    @Override
    public Value<Double> calculate(String equation, Map<String, Value<?>> variables) throws Exception {

        return null;
    }

    /*
     * (non-Javadoc)
     * @see br.com.totvs.calculator.common.ICalculator#getVariablesOfEquation(java.lang.String)
     */
    @Override
    public List<String> getVariablesOfEquation(String equation) throws Exception {

        return null;
    }

    /*
     * (non-Javadoc)
     * @see br.com.totvs.calculator.common.ICalculator#getFunctionsOfEquation(java.lang.String)
     */
    @Override
    public List<String> getFunctionsOfEquation(String equation) throws Exception {

        return null;
    }

    /*
     * (non-Javadoc)
     * @see br.com.totvs.calculator.common.ICalculator#equationValidator(java.lang.String)
     */
    @Override
    public String equationValidator(String equation) {

        return null;
    }

}
