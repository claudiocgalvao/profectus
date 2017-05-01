package br.com.gti.profectus.infra.logfile.domain;

/**
 * PrefixLogFileDomainEnum.
 * @author tiago.canatelli
 * @since 25/06/2015
 */
public enum PrefixLogFileDomainEnum {

    /** prefix log message IBM MQ legacy process error. */
    MESSAGE_MQ_LEGACY_PROCESS("LEGACY_MQ_MESSAGES", "Log process message IBM MQ Legacy.");

    private String id;

    private String description;

    /**
     * Constructor.
     * @param id
     * @param description
     */
    PrefixLogFileDomainEnum(final String id, final String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
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
    public static PrefixLogFileDomainEnum getByValue(final String id) {
        for (final PrefixLogFileDomainEnum retorno : PrefixLogFileDomainEnum.values()) {
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
        for (final PrefixLogFileDomainEnum retorno : PrefixLogFileDomainEnum.values()) {
            if (retorno.getId().equals(value)) {
                return retorno.getDescription();
            }
        }
        return "";
    }
}
