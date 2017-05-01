package br.com.gti.profectus.infra.common;

/**
 * Variable.
 * @author eduardo.fsantos
 * @since 08/06/2015
 */
public class Variable implements IVariable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String value;

    private int typeOrigem; //Internal/External

    private int typeVariable;

    /**
     * Constructor of class Variable.java.
     */
    public Variable() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor of class Variable.java.
     */
    public Variable(Long id, String name, String value, int typeVariable, int typeOrigem) {

        this.id = id;
        this.name = name;
        this.value = value;
        this.typeOrigem = typeOrigem;
        this.typeVariable = typeVariable;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return this.value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return the type
     */
    public int getTypeOrigem() {
        return this.typeOrigem;
    }

    /**
     * @param type the type to set
     */
    public void setTypeOrigem(int typeOrigem) {
        this.typeOrigem = typeOrigem;
    }

    /**
     * @return the typeVariable
     */
    public int getTypeVariable() {
        return this.typeVariable;
    }

    /**
     * @param typeVariable the typeVariable to set
     */
    public void setTypeVariable(int typeVariable) {
        this.typeVariable = typeVariable;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

}
