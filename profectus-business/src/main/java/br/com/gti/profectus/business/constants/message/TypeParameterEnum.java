package br.com.gti.profectus.business.constants.message;

/**
 * TypeParameterEnum.
 * @author tiago.canatelli
 * @since 25/11/2014
 */
public enum TypeParameterEnum {

    /** String. */
    STRING(new Short("1"), "constants.message.typeparameter.string"),

    /** Number. */
    NUMBER(new Short("2"), "constants.message.typeparameter.number"),
    
    /** Float. **/
    FLOAT(new Short("3"), "constants.message.typeparameter.float"),
    
    /** Date. */
    DATE(new Short("4"), "constants.message.typeparameter.date"),
    
    /** Boolean. */
    BOOLEAN(new Short("5"), "constants.message.typeparameter.boolean");

    private Short id;

    private String description;

    /**
     * Constructor.
     * @param id
     * @param description
     */
    TypeParameterEnum(final Short id, final String description) {
        this.id = id;
        this.description = description;
    }

    public Short getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    /**
     * GetByValue.
     * @author tiago.canatelli
     * @since 25/11/2014
     * @param id
     * @return TypeParameterEnum
     */
    public static TypeParameterEnum getByValue(final Short id) {
        for (final TypeParameterEnum retorno : TypeParameterEnum.values()) {
            if (retorno.getId().equals(id)) {
                return retorno;
            }
        }
        return null;
    }

    /**
     * getDescription.
     * @author tiago.canatelli
     * @since 25/11/2014
     * @param id
     * @return String
     */
    public static String getDescription(final Short id) {
        for (final TypeParameterEnum retorno : TypeParameterEnum.values()) {
            if (retorno.getId().equals(id)) {
                return retorno.getDescription();
            }
        }
        return "";
    }
}
