package br.com.gti.profectus.tools.number;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import lombok.extern.log4j.Log4j2;

/**
 * Helper for number formatting.
 */
@Log4j2
public final class NumberHelper {

    private static final int A_HUNDRED = 100;

    private static final int FRACTION_DIgtiS_4 = 4;

    private static final int FRACTION_DIgtiS_DEFAULT = 2;

    private static final String COUNTRY_US = "US";

    private static final String LANGUAGE_EN = "en";

    private static final String COUNTRY_BR = "BR";

    private static final String LANGUAGE_PT = "pt";

    private static final Locale LOCALE_ptBR = new Locale(LANGUAGE_PT, COUNTRY_BR);

    public static final String DECIMAL_PATTERN = "0.00##################";

    public static String formatNumber(final Double d, String pattern) {

        String output = "";
        if (d != null) {
            final NumberFormat numberFormat = NumberFormat.getNumberInstance(LOCALE_ptBR);
            DecimalFormat df = (DecimalFormat) (numberFormat);
            df.applyPattern(pattern);
            output = df.format(d);
        }
        return output;
    }

    /**
     * Numeric format to save bank.
     * @param v value
     * @return Double value
     */
    public static Double formatDouble(String v) {
        final DecimalFormat dff = (DecimalFormat) DecimalFormat.getInstance(new Locale(LANGUAGE_PT, COUNTRY_BR));
        dff.setParseBigDecimal(true);
        try {
            BigDecimal valor = (BigDecimal) dff.parse(v);
            return valor.doubleValue();
        } catch (ParseException ex) {
            final String message = String.format("Unable to format value: %s", v);
            log.error(message, ex);
            throw new RuntimeException(message, ex);
        }
    }

    /**
     * Numeric format to save bank.
     * @param v value
     * @return Double value
     */
    public static Long formatLong(String v) {
        final DecimalFormat dff = (DecimalFormat) DecimalFormat.getInstance(new Locale(LANGUAGE_PT, COUNTRY_BR));
        dff.setParseBigDecimal(true);
        try {
            BigDecimal valor = (BigDecimal) dff.parse(v);
            return valor.longValue();
        } catch (ParseException ex) {
            final String message = String.format("Unable to format value: %s", v);
            log.error(message, ex);
            throw new RuntimeException(message, ex);
        }
    }

    /**
     * Format number to display screen.
     * @param d value
     * @return String value
     * @throws IllegalArgumentException
     */
    public static String formatNumber(final double d) {
        final NumberFormat numberFormat = NumberFormat.getNumberInstance(new Locale(LANGUAGE_PT, COUNTRY_BR));
        numberFormat.setMinimumFractionDigits(FRACTION_DIgtiS_DEFAULT);
        return numberFormat.format(d);
    }

    /**
     * Format number 4 digtis to display screen.
     * @param d value
     * @return String value
     * @throws IllegalArgumentException
     */
    public static String formatNumberPercent4Digtis(final double d) {
        final NumberFormat numberFormat = NumberFormat.getPercentInstance(new Locale(LANGUAGE_PT, COUNTRY_BR));
        numberFormat.setMinimumFractionDigits(FRACTION_DIgtiS_4);
        return numberFormat.format(d / A_HUNDRED);
    }

    /**
     * Format currency to display screen.
     * @param d value
     * @return String value
     * @throws IllegalArgumentException
     */
    public static String formatCurrency(final double d) {
        final NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale(LANGUAGE_PT, COUNTRY_BR));
        numberFormat.setMinimumFractionDigits(FRACTION_DIgtiS_DEFAULT);
        return numberFormat.format(d);
    }

    /**
     * Formatnumber to display screen.
     * @param d value
     * @return String value
     * @throws IllegalArgumentException
     */
    public static String formatNumber(final double d, int decimal) {
        final NumberFormat numberFormat = NumberFormat.getNumberInstance(new Locale(LANGUAGE_PT, COUNTRY_BR));
        numberFormat.setMinimumFractionDigits(decimal);
        return numberFormat.format(d);
    }

    /**
     * Format number to display screen.
     * @param d value
     * @return String value
     * @throws IllegalArgumentException
     */
    public static String formatNumber(final Double d) {
        if (d != null) {
            final NumberFormat numberFormat = NumberFormat.getNumberInstance(new Locale(LANGUAGE_PT, COUNTRY_BR));
            numberFormat.setMinimumFractionDigits(FRACTION_DIgtiS_DEFAULT);
            return numberFormat.format(d);
        } else {
            return "";
        }
    }

    /**
     * Format number 4 digtis to display screen.
     * @param d value
     * @return String value
     * @throws IllegalArgumentException
     */
    public static String formatNumberPercent4Digtis(final Double d) {
        if (d != null) {
            final NumberFormat numberFormat = NumberFormat.getPercentInstance(new Locale(LANGUAGE_PT, COUNTRY_BR));
            numberFormat.setMinimumFractionDigits(FRACTION_DIgtiS_4);
            return numberFormat.format(d / A_HUNDRED);
        } else {
            return "";
        }
    }

    /**
     * Format currency to display screen.
     * @param d value
     * @return String value
     * @throws IllegalArgumentException
     */
    public static String formatCurrency(final Double d) {
        if (d != null) {
            final NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale(LANGUAGE_PT, COUNTRY_BR));
            numberFormat.setMinimumFractionDigits(FRACTION_DIgtiS_DEFAULT);
            return numberFormat.format(d);
        } else {
            return "";
        }
    }

    /**
     * Formatnumber to display screen.
     * @param d value
     * @return String value
     * @throws IllegalArgumentException
     */
    public static String formatNumber(final Double d, int decimal) {
        if (d != null) {
            final NumberFormat numberFormat = NumberFormat.getNumberInstance(new Locale(LANGUAGE_PT, COUNTRY_BR));
            numberFormat.setMinimumFractionDigits(decimal);
            return numberFormat.format(d);
        } else {
            return "";
        }
    }

    /**
     * Formats a number to be displayed in screen.
     * @param d value to be formatted.
     * @param decimal is the number of decimal fraction digtis.
     * @return String value formatted.
     * @throws IllegalArgumentException
     */
    public static String formatNumberUS(Double d, int decimal) {
        if (null == d) {
            d = new Double(0.0);
        }
        final NumberFormat numberFormat = NumberFormat.getNumberInstance(new Locale(LANGUAGE_EN, COUNTRY_US));
        numberFormat.setMinimumFractionDigits(decimal);
        return numberFormat.format(d);
    }

    /**
     * Altera a quantidade de digtios de um numero inteiro.
     * Exemplo: 1,2,3 para 01,02,03
     * @author claudio.cesar
     * @since 25/11/2014
     * @param value
     * @param digti
     * @return String
     */
    public static String formatNumberInt(Integer value, int digti) {
        if (null == value) {

            value = new Integer(0);
        }
        final NumberFormat numberFormat = NumberFormat.getIntegerInstance(new Locale(LANGUAGE_PT, COUNTRY_BR));
        numberFormat.setMinimumIntegerDigits(digti);
        return numberFormat.format(value);
    }

}
