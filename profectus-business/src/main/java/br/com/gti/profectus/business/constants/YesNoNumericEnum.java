package br.com.gti.profectus.business.constants;

import br.com.gti.profectus.business.constants.message.TypeParameterEnum;

/**
 * TypeParameterEnum.
 * @author tiago.canatelli
 * @since 25/11/2014
 */
public enum YesNoNumericEnum {

    /** Yes. */
    YES(new Short("1"), "button.yes"),

    /** No. */
    NO(new Short("2"), "button.no");

    private Short id;

    private String description;

    /**
     * Constructor.
     * @param id
     * @param description
     */
    YesNoNumericEnum(final Short id, final String description) {
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
