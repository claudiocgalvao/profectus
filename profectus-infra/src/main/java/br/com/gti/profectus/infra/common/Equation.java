package br.com.gti.profectus.infra.common;

import java.io.Serializable;
import java.util.List;

/**
 * Equatition.
 * @author eduardo.fsantos
 * @since 27/05/2015
 */
public class Equation implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String equation;

    private List<Variable> variables;

    private List<String> functions;

    /**
     * @return the equation
     */
    public String getEquation() {
        return this.equation;
    }

    /**
     * @param equation the equation to set
     */
    public void setEquation(String equation) {
        this.equation = equation;
    }

    /**
     * @return the variables
     */
    public List<Variable> getVariables() {
        return this.variables;
    }

    /**
     * @param variables the variables to set
     */
    public void setVariables(List<Variable> variables) {
        this.variables = variables;
    }

    /**
     * @return the functions
     */
    public List<String> getFunctions() {
        return this.functions;
    }

    /**
     * @param functions the functions to set
     */
    public void setFunctions(List<String> functions) {
        this.functions = functions;
    }

}
