package br.com.gti.profectus.tools;

import java.io.Serializable;

/**
 * Represents all kinds of arguments the composition formula. <li>{@link #SUM}</li> <li>{@link #SUBTRACTION}</li> <li>
 * {@link #MULTIPLICATION}</li> <li>{@link #DIVISION}</li> <li>{@link #EXPONENT}</li> <li>{@link #SMALLER}</li> <li>
 * {@link #BIGGER}</li> <li>{@link #SMALLER_EQUALS}</li> <li>{@link #BIGGER_EQUALS}</li><li>{@link #DIFFERENT}</li> <li>
 * {@link #AND}</li> <li>{@link #OR}</li>
 * @author tiago.canatelli
 */
public enum OperatorsType implements Serializable {
    /**
     * sun.
     */
    SUM(Values.SUM),
    /**
     * subtraction.
     */
    SUBTRACTION(Values.SUBTRACTION),
    /**
     * multiplication.
     */
    MULTIPLICATION(Values.MULTIPLICATION),
    /**
     * description.
     */
    DIVISION(Values.DIVISION),
    /**
     * description.
     */
    EXPONENT(Values.EXPONENT),
    /**
     * description.
     */
    SMALLER(Values.SMALLER),
    /**
     * description.
     */
    BIGGER(Values.BIGGER),
    /**
     * description.
     */
    SMALLER_EQUALS(Values.SMALLER_EQUALS),
    /**
     * description.
     */
    BIGGER_EQUALS(Values.BIGGER_EQUALS),
    /**
     * description.
     */
    DIFFERENT(Values.DIFFERENT),
    /**
     * description.
     */
    AND(Values.AND),
    /**
     * description.
     */
    OR(Values.OR);

    //    public static final String LBL_SUM = "select.operators.sum";
    //    public static final String LBL_SUBTRACTION = "select.operators.subtraction";
    //    public static final String LBL_MULTIPLICATION = "select.operators.multiplication";
    //    public static final String LBL_DIVISION = "select.operators.division";
    //    public static final String LBL_EXPONENT = "select.operators.exponent";
    //    public static final String LBL_SMALLER = "select.operators.smaller";
    //    public static final String LBL_BIGGER = "select.operators.bigger";
    //    public static final String LBL_SMALLER_EQUALS = "select.operators.smallerEquals";
    //    public static final String LBL_BIGGER_EQUALS = "select.operators.biggerEquals";
    //    public static final String LBL_DIFFERENT = "select.operators.different";
    //    public static final String LBL_AND = "select.operators.and";
    //    public static final String LBL_OR = "select.operators.or";
    /**
     * description.
     */
    public static final String LBL_SUM = "+";

    /**
     * description.
     */
    public static final String LBL_SUBTRACTION = "-";

    /**
     * description.
     */
    public static final String LBL_MULTIPLICATION = "*";

    /**
     * description.
     */
    public static final String LBL_DIVISION = "/";

    /**
     * description.
     */
    public static final String LBL_EXPONENT = "^";

    /**
     * description.
     */
    public static final String LBL_SMALLER = "<";

    /**
     * description.
     */
    public static final String LBL_BIGGER = ">";

    /**
     * description.
     */
    public static final String LBL_SMALLER_EQUALS = "<=";

    /**
     * description.
     */
    public static final String LBL_BIGGER_EQUALS = ">=";

    /**
     * description.
     */
    public static final String LBL_DIFFERENT = "<>";

    /**
     * description.
     */
    public static final String LBL_AND = "AND";

    /**
     * description.
     */
    public static final String LBL_OR = "OR";

    /**
     * description.
     */
    private final String code;

    private OperatorsType(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    /**
     * Inform the method description.
     */
    public final String toCode() {
        return code;
    }

    /**
     * from.
     * @param dataTypeCode
     * @return
     */
    public static OperatorsType from(final String dataTypeCode) {
        switch (dataTypeCode) {
            case Values.SUM:
                return SUM;
            case Values.SUBTRACTION:
                return SUBTRACTION;
            case Values.MULTIPLICATION:
                return MULTIPLICATION;
            case Values.DIVISION:
                return DIVISION;
            case Values.EXPONENT:
                return EXPONENT;
            case Values.SMALLER:
                return SMALLER;
            case Values.BIGGER:
                return BIGGER;
            case Values.SMALLER_EQUALS:
                return SMALLER_EQUALS;
            case Values.BIGGER_EQUALS:
                return BIGGER_EQUALS;
            case Values.DIFFERENT:
                return DIFFERENT;
            case Values.AND:
                return AND;
            case Values.OR:
                return OR;
            default:
                throw new IllegalArgumentException("Unknown argument type code: " + dataTypeCode);
        }
    }

    /**
     * Values.
     */
    public static class Values {

        /**
         * description.
         */
        public static final String SUM = "+";

        /**
         * description.
         */
        public static final String SUBTRACTION = "-";

        /**
         * description.
         */
        public static final String MULTIPLICATION = "*";

        /**
         * description.
         */
        public static final String DIVISION = "/";

        /**
         * description.
         */
        public static final String EXPONENT = "^";

        /**
         * description.
         */
        public static final String SMALLER = "<";

        /**
         * description.
         */
        public static final String BIGGER = ">";

        /**
         * description.
         */
        public static final String SMALLER_EQUALS = "<=";

        /**
         * description.
         */
        public static final String BIGGER_EQUALS = ">=";

        /**
         * description.
         */
        public static final String DIFFERENT = "<>";

        /**
         * description.
         */
        public static final String AND = "AND";

        /**
         * description.
         */
        public static final String OR = "OR";
    }
}
