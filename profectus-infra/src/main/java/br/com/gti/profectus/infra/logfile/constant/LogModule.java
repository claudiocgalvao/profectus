package br.com.gti.profectus.infra.logfile.constant;

/**
 * LogModule.
 * @author claudio.cesar
 * @since 3 de ago de 2016
 */
public enum LogModule {

    MODULE_WEB("[ModuleWeb]"),
    TFS_CALCULATOR("[TFSCalculator]"),
    NETTING("[Netting]"),
    OPERATION_MATRIX("[Matrix]"),
    CALCULATOR_ON_LINE("[CalculatorOnLine]");

    private String description;

    LogModule(final String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
