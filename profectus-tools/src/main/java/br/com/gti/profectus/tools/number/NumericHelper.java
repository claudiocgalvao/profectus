package br.com.gti.profectus.tools.number;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

import lombok.extern.slf4j.Slf4j;
import br.com.gti.profectus.tools.constants.NumberDoubleMagic;

/**
 * Classe utilitaria para manipulacao de valores numericos.
 */
@Slf4j
public final class NumericHelper {

    private static final String MASK_MILHAR_INT = "###,###,###";

    private static final String MASK_MILHAR_DBL = "###,###,##0.00";

    private static final NumberFormat FORMATTER_INT = new DecimalFormat(MASK_MILHAR_INT);

    private static final NumberFormat FORMATTER_DBL = new DecimalFormat(MASK_MILHAR_DBL);

    private static final int ZERO = 0;

    private static final int ONE = 1;

    private static final int TWO = 2;

    private static final int TEN = 10;

    private static final int ELEVEN = 11;

    private NumericHelper() {
    }

    /**
     * Verifica se o valor passado representa um valor numerico. O valor deve
     * estar no formato brasileiro (ex: "1234", "1.234", "1,23", "1.234,56"),
     * mesmo se o valor representar um numero negativo.
     * @param valor valor a ser verificado.
     * @return true se for numerico ou false caso contrario.
     */
    public static boolean isNumeric(String valor) {
        if (valor != null) {
            // retira os pontos (se houver) da string
            valor = valor.replaceAll("\\.", "");
            valor = valor.replaceAll(",", ".");
            try {
                Double.parseDouble(valor);
                return true;
            } catch (NumberFormatException e) {
                log.error(e.getLocalizedMessage(), e);
            }
        }
        return false;
    }

    /**
     * Compara dois valores numericos, retornando um se os dois valores
     * sao iguais ou nulos, retorna 1 caso o primeiro argumento seja maior
     * ou o segundo argumento seja exclusivamente nulo, ou entao retorna 2
     * caso o segundo argumento seja maior ou o primeiro argumento seja
     * exclusivamente nulo.
     * @param num1 primeiro numero.
     * @param num2 segundo numero.
     * @return
     */
    public static int comparar(Number num1, Number num2) {
        if (num1 == null) {
            if (num2 == null) {
                return ZERO;
            } else {
                return -ONE;
            }
        } else
            if (num2 == null) {
                return num1 == null ? ZERO : ONE;
            } else {
                if (num1.equals(num2)) {
                    return ZERO;
                } else
                    if (num1.doubleValue() > num2.doubleValue()) {
                        return ONE;
                    } else {
                        return -ONE;
                    }
            }
    }

    /**
     * Verifica se o valor numerico passado tem o valor zero ou se for uma
     * referencia nula (null).
     * @param num valor numerico a ser verificado.
     * @return true se for zero ou null, false caso seja numero diferente de zero.
     */
    public static boolean isZeroOrNull(Number num) {
        if (num == null || num.doubleValue() == NumberDoubleMagic.ZERO) {
            return true;
        }
        return false;
    }

    /**
     * Formata um valor inteiro (long) para uma String no formato "1.234".
     * @param valor valor a ser formatado.
     * @return valor formatado.
     */
    public static String format(long valor) {
        return FORMATTER_INT.format(valor);
    }

    /**
     * Formata um valor decimal (double) para uma String no formato "1.234,56".
     * @param valor valor a ser formatado.
     * @return valor formatado.
     */
    public static String format(double valor) {
        return FORMATTER_DBL.format(valor);
    }

    /**
     * Faz a convers�o (parsing) de uma String para um valor inteiro (long). A
     * String deve seguir o formato "1.234", ou "1234".
     * @param valor valor a ser convertido.
     * @return valor convertido.
     * @throws ParseException caso o formato seja inv�lido.
     */
    public static long parseLong(String valor) throws ParseException {
        if (!isNumeric(valor)) {
            throw new ParseException("Valor invalido: " + valor, ZERO);
        }
        return FORMATTER_INT.parse(valor).longValue();
    }

    /**
     * Faz a conversao (parsing) de uma String para um valor decimal (double). A
     * String deve seguir o formato "1.234,56", ou "1234,56", ou "1234".
     * @param valor valor a ser convertido.
     * @return valor convertido.
     * @throws ParseException caso o formato seja inv�lido.
     */
    public static double parseDouble(String valor) throws ParseException {
        if (!isNumeric(valor)) {
            throw new ParseException("Valor invalido: " + valor, ZERO);
        }
        return FORMATTER_DBL.parse(valor).doubleValue();
    }

    /**
     * Retorna o valor arredondado, considerando o numero de casas decimais.
     * Este metodo faz o mesmo que o metodo <code>Math.round(double)</code>,
     * porem considerando as casas decimais.
     * @see java.lang.Math#round(double)
     * @param val valor a ser arredondado.
     * @param precision Numero de casas decimais a considerar.
     * @return valor arredondado, considerando a precisao (numero) de casas
     * decimais.
     */
    public static double round(double val, int precision) {
        if (precision <= ZERO) {
            throw new IllegalArgumentException("PrecisAo deve ser maior que zero");
        }
        double fator = Math.pow(TEN, precision);
        return Math.round(val * fator) / fator;
    }

    /**
     * Retorna o proximo valor, considerando a precisao (numero) de casas decimais,
     * por exemplo: se for informado n�mero "123.4567", com duas casas decimais,
     * o metodo retorna "123.46". Este metodo faz o mesmo que o metodo <code>Math.ceil(double)</code>, porem
     * considerando as casas decimais.
     * @see java.lang.Math#ceil(double)
     * @param val valor a ser calculado.
     * @param precision Numero de casas decimais a considerar.
     * @return novo valor, considerando a precisao (numero) de casas
     * decimais.
     */
    public static double ceil(double val, int precision) {
        if (precision <= ZERO) {
            throw new IllegalArgumentException("Precis�o deve ser maior que zero");
        }
        double fator = Math.pow(TEN, precision);
        return Math.ceil(val * fator) / fator;
    }

    /**
     * Retorna o valor anterior, considerando a precisao (numero) de casas decimais,
     * por exemplo: se for informado numero "123.4567", com duas casas decimais,
     * o metodo retorna "123.45". Este metodo faz o mesmo que o metodo <code>Math.floor(double)</code>, porem
     * considerando as casas decimais.
     * @see java.lang.Math#floor(double)
     * @param val valor a ser calculado.
     * @param precision Numero de casas decimais a considerar.
     * @return novo valor, considerando a precisao (numero) de casas
     * decimais.
     */
    public static double floor(double val, int precision) {
        if (precision <= ZERO) {
            throw new IllegalArgumentException("Precisao deve ser maior que zero");
        }
        double fator = Math.pow(TEN, precision);
        return Math.floor(val * fator) / fator;
    }

    /**
     * Retorna o valor truncado considerando o numero de casas decimais, ou seja,
     * ignora os valores depois da precisao definida. Se o argumento for um valor
     * inteiro, retorna ele proprio. Caso o valor seja um decimal (double),
     * trunca a partir do numero de casas decimais (precisao) informado.
     * @param val valor a ser truncado.
     * @param precision Numero de casas decimais a considerar.
     * @return valor truncado, considerando a precisao (numero) de casas
     * decimais.
     */
    public static double trunc(double val, int precision) {
        return trunc(BigDecimal.valueOf(val), precision).doubleValue();
    }

    /**
     * Retorna o valor truncado considerando o numero de casas decimais, ou seja,
     * ignora os valores depois da precisao definida. Se o argumento for um valor
     * inteiro, retorna ele proprio. Caso o valor seja um decimal (double),
     * trunca a partir do numero de casas decimais (precisao) informado.
     * @param val valor a ser truncado.
     * @param precision Numero de casas decimais a considerar.
     * @return valor truncado, considerando a precisao (numero) de casas
     * decimais.
     */
    public static BigDecimal trunc(String val, int precision) {
        return trunc(new BigDecimal(val), precision);
    }

    /**
     * Retorna o valor truncado considerando o numero de casas decimais, ou seja,
     * ignora os valores depois da precisao definida. Se o argumento for um valor
     * inteiro, retorna ele proprio. Caso o valor seja um decimal (double),
     * trunca a partir do numero de casas decimais (precisao) informado.
     * @param val valor a ser truncado.
     * @param precision Numero de casas decimais a considerar.
     * @return valor truncado, considerando a precisao (numero) de casas
     * decimais.
     */
    public static BigDecimal trunc(BigDecimal val, int precision) {
        if (precision <= ZERO) {
            throw new IllegalArgumentException("Precisao deve ser maior que zero");
        }
        return val.setScale(precision, BigDecimal.ROUND_DOWN);
    }

    /**
     * Calcula e retorna o digtio verificador pelo calculo do Modulo 11.
     * @param numero Um numero sem o digtio verificador.
     * @return Digtio verificador.
     */
    public static int calcularModulo11(String numero) {
        int sum; // Sum of Multiply (Digti * Peso)
        int digti; // A number digti
        int coeficient; // A coeficient
        int dv; // Calculated Chek Digti
        // Sum Calculation
        sum = ZERO;
        coeficient = TWO;
        for (int i = numero.length() - ONE; i >= ZERO; i--) {
            digti = Integer.parseInt(String.valueOf(numero.charAt(i)));
            sum += digti * coeficient;
            coeficient++;
        }
        // Module 11
        dv = ELEVEN - sum % ELEVEN;
        if (dv >= TEN) {
            dv = ZERO; // must be beetwen 0 and 9
        }
        return dv;
    }

    /**
     * Calcula e retorna o digtio verificador pelo calculo do Modulo 11.
     * @param numero Um numero sem o digtio verificador.
     * @return Digtio verificador.
     */
    public static int calcularModulo11(long numero) {
        return calcularModulo11(String.valueOf(numero));
    }
}
