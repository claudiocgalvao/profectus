package br.com.gti.profectus.business.constants;

/**
 * TypeParameterEnum.
 * @author tiago.canatelli
 * @since 25/11/2014
 */
public enum YesNoStringEnum {

    /** Yes. */
    YES("S", "button.yes"),

    /** No. */
    NO("N", "button.no");

    private String id;

    private String description;

    /**
     * Constructor.
     * @param id
     * @param description
     */
    YesNoStringEnum(final String id, final String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    /**
     * GetByValue.
     * @author tiago.canatelli
     * @since 25/11/2014
     * @param id
     * @return TypeParameterEnum
     */
    public static YesNoStringEnum getByValue(final String id) {
        for (final YesNoStringEnum retorno : YesNoStringEnum.values()) {
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
     * @param value
     * @return String
     */
    public static String getDescription(final String value) {
        for (final YesNoStringEnum retorno : YesNoStringEnum.values()) {
            if (retorno.getId().equals(value)) {
                return retorno.getDescription();
            }
        }
        return "";
    }
}
