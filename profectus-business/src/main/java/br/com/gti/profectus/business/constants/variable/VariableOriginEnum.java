package br.com.gti.profectus.business.constants.variable;

/**
 * VariableOriginEnum.
 * @author claudio.cesar
 * @since 10/12/2014
 */
public enum VariableOriginEnum {
    /**
     * Internal.
     */
    INTERNAL(1, "constants.variable.origin.internal"),
    /**
     * External.
     */
    EXTERNAL(2, "constants.variable.origin.external");

    private Integer id;

    private String description;

    /**
     * Constructor of class VariableOriginEnum.java.
     * @param id
     * @param description
     */
    VariableOriginEnum(final Integer id, final String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

}
