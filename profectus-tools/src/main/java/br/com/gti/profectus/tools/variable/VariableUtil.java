package br.com.gti.profectus.tools.variable;

/**
 * Classe utilitaria para se trabalhar com variaveis contidas em Strings.
 */
public final class VariableUtil {

    private VariableUtil() {
    }

    /**
     * Substitui todas as ocorrencia da variavel no texto, substituindo pelo valor passado. Exemplo:
     * <code>String variavel = "name";
     * String texto = "Meu nome ${name}";
     * String novoTexto = VariableUtil.replaceVariable(texto, variavel, "Amanda");</code>
     * @param text texto que contem a variavel.
     * @param variable nome da variavel.
     * @param value valor a subustituir no lugar da variavel.
     * @return texto alterado (com o valor substituindo a variavel.
     */
    public static String replaceVariable(String text, String variable, String value) {
        return text.replaceAll("\\$\\{" + variable + "\\}", value);
    }
}
