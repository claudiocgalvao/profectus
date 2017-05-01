package br.com.gti.profectus.infra.logfile.constant;

/**
 * LogAction.
 * @author claudio.cesar
 * @since 23 de mar de 2016
 */
public enum LogAction {

    INFO("INFO "),
    ERROR("ERROR");

    private String description;

    LogAction(final String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
