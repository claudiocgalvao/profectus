package br.com.gti.profectus.tools.string;

import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Inform the class description.
 * @author claudio.cesar
 * @since 18/11/2014
 */
public final class StringHelper {

    /**
     * Inform the constructor description.
     */
    private StringHelper() {
    }

    /**
     * Method to verify string is empty.
     * @param value
     * @return
     */
    public static boolean isEmpty(String value) {
        if (value == null) {
            return true;
        } else {
            return "".equals(value.trim()) ? true : false;
        }
    }

    /**
     * Method to verify String is blank.
     * @param value
     * @return
     */
    public static boolean isBlank(String value) {
        return "".equals(value.trim()) ? true : false;
    }

    /**
     * Method to verify String is blank.
     * @param value
     * @return
     */
    public static boolean stringsIsEqual(String first, String second) throws Exception {
        try {
            return first.trim().equals(second.trim()) ? true : false;
        } catch (Exception e) {
            throw new Exception("One or more Strgings parameter is null.");
        }
    }

    /**
     * Remove accents.
     * @author claudio.cesar
     * @since 23/06/2015
     * @param string
     * @return
     */
    public static String removeAccents(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }

    /**
     * isFindWords.
     * @author claudio.cesar
     * @since 23/06/2015
     * @param text
     * @return
     */
    public static boolean isFindWords(String word, String text) {

        Boolean reaply = Boolean.FALSE;

        Pattern p = Pattern.compile("[a-zA-Zà-úÀ-Ú]+");
        Matcher m = p.matcher(text);

        while (m.find()) {

            if (m.group().equals(word)) {
                reaply = Boolean.TRUE;
            }
        }

        return reaply;

    }

    public static String normalizeToDoubleValue(String value) {

        String vr = "";

        if (value.contains(".") && value.contains(",")) {

            Integer comma = value.indexOf(",");
            Integer digtiSeparator = value.lastIndexOf(".");

            if (comma != null && digtiSeparator != null) {
                if (comma > digtiSeparator) {//Padrao BR
                    vr = value.replace(".", "").replace(",", ".");

                } else if (comma < digtiSeparator) {//Padrao USA
                    vr = value.replace(",", "");
                }
            }

        } else {

            if (!value.contains(".") && value.contains(",")) {//somente virgula padrao BR
                vr = value.replace(",", ".");

            } else if (value.contains(".") && !value.contains(",")) {
                vr = value;

            } else {
                vr = value;
            }
        }

        return vr;
    }

    public static String normalizeToIntegerValue(String value) {

        String vr = "";
        if (value.contains(".") && value.contains(",")) {
            vr = value.replace(".", "").replace(",", "");

        } else if (!value.contains(".") && value.contains(",")) {
            vr = value.replace(",", "");

        } else if (value.contains(".") && !value.contains(",")) {
            vr = value.replace(".", "");

        } else {
            vr = value;
        }
        return vr;
    }

    /**
     * Na importacao do excel remover casa decimal ".0" para nao ocorrer valores inteiros errados na validacoes e
     * conversoes
     * em double.
     * @author claudio.cesar
     * @since 1 de jun de 2016
     * @param value
     * @return
     */
    public static String normalizeNumericValue(String value) {
        String vr = "";
        if (value.contains(".")) {
            String parte1 = value.substring(0, value.lastIndexOf("."));
            String parte2 = value.substring(value.lastIndexOf(".") + 1);

            if (parte2.equalsIgnoreCase("0")) {//decimal 0 nao permitido
                vr = parte1;
            } else {
                vr = value;
            }
        } else {
            vr = value;
        }
        return vr;
    }

}
