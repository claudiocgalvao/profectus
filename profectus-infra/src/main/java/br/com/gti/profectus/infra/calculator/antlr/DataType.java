package br.com.gti.profectus.infra.calculator.antlr;

import java.io.Serializable;

import org.antlr.v4.runtime.misc.NotNull;

// import javax.validation.constraints.NotNull;

/**
 * .
 * DataType.
 * @author eduardo.fsantos
 * @since 29/05/2015
 */
public enum DataType implements Serializable {

    /** Boolean. */
    BOOLEAN(Values.BOOLEAN),

    /** Number. */
    NUMBER(Values.NUMBER),

    /** Text. */
    TEXT(Values.TEXT),

    /** Date. */
    DATE(Values.DATE);

    private final String dataTypeCode;

    /**
     * Constructor.
     * @param dataTypeCode
     */
    private DataType(final String dataTypeCode) {
        this.dataTypeCode = dataTypeCode;
    }

    public String getDataTypeCode() {
        return this.dataTypeCode;
    }

    /**
     * .
     * @author eduardo.fsantos
     * @since 29/05/2015
     * @return
     */
    public final String toDatabaseString() {
        return this.dataTypeCode;
    }

    /**
     * .
     * @author eduardo.fsantos
     * @since 29/05/2015
     * @param dataTypeCode
     * @return
     */
    public static DataType from(@NotNull final String dataTypeCode) {
        switch (dataTypeCode) {
            case Values.BOOLEAN:
                return BOOLEAN;
            case Values.NUMBER:
                return NUMBER;
            case Values.TEXT:
                return TEXT;
            case Values.DATE:
                return DATE;
            default:
                throw new IllegalArgumentException("Unknown data type code: " + dataTypeCode);
        }
    }

    @Override
    public String toString() {
        if (this.getDataTypeCode().equals(Values.BOOLEAN)) {
            return "Boolean";
        }
        if (this.getDataTypeCode().equals(Values.DATE)) {
            return "Date";
        }
        if (this.getDataTypeCode().equals(Values.NUMBER)) {
            return "Number";
        }
        if (this.getDataTypeCode().equals(Values.TEXT)) {
            return "Text";
        }
        return "";
    }

    /**
     * .
     * Values.
     * @author eduardo.fsantos
     * @since 29/05/2015
     */
    public static class Values {

        /**
         * 
         */
        public static final String BOOLEAN = "B";

        /*
         * 
         */
        public static final String NUMBER = "N";

        public static final String TEXT = "T";

        public static final String DATE = "D";
    }
}
