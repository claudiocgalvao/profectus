package br.com.gti.profectus.business.constants;

/**
 * MessageTratmentTypeEnum.
 * @author tiago.canatelli
 * @since 01/12/2014
 */
public enum MessageTreatmentTypeEnum {

    /** Success message. */
    SUCCESS("S", "alert-success"),

    /** Warning message. */
    WARNING("W", "alert"),

    /** Warning message. */
    WARNING_INFO("WI", "alert-info"),

    /** Error message. */
    ERROR("E", "alert-error");

    private String value;

    private String alertType;

    /**
     * Constructor.
     * @param value
     * @param description
     */
    MessageTreatmentTypeEnum(final String value, final String alertType) {
        this.value = value;
        this.alertType = alertType;
    }

    public String getValue() {
        return value;
    }

    public String getAlertType() {
        return alertType;
    }

    /**
     * Method get value.
     * @author tiago.canatelli
     * @since 01/12/2014
     * @param value
     * @return MessageTratmentTypeEnum
     */
    public static MessageTreatmentTypeEnum getByValue(final String value) {
        for (final MessageTreatmentTypeEnum retorno : MessageTreatmentTypeEnum.values()) {
            if (retorno.getValue().equals(value)) {
                return retorno;
            }
        }
        return null;
    }

    /**
     * Method get Alert Type.
     * @author tiago.canatelli
     * @since 01/12/2014
     * @param value
     * @return String
     */
    public static String getAlertType(final String value) {
        for (final MessageTreatmentTypeEnum retorno : MessageTreatmentTypeEnum.values()) {
            if (retorno.getValue().equals(value)) {
                return retorno.getAlertType();
            }
        }
        return "";
    }
}
