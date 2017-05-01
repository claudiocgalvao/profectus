package br.com.gti.profectus.tools.net;

import java.util.regex.Pattern;

/**
 * Classe utilitaria para manipulacao de dados relativos ao ambiente internet.
 */
public final class NetUtil {

    private static final String REGEX_EMAIL =
            "[0-9a-zA-Z_\\-]+(\\.[0-9a-zA-Z_\\-]+)*@[0-9a-zA-Z_\\-]+(\\.[0-9a-zA-Z_\\-]+)*";

    private static final String REGEX_URL_HOST = "(http|https|ftp)://[0-9a-zA-Z_\\-]+(\\.[0-9a-zA-Z_\\-]+)*";

    private static final String REGEX_URL = REGEX_URL_HOST + "(:[0-9]+)?(/[^/]*)*";

    private static final Pattern PATTERN_HOST = Pattern.compile(REGEX_URL_HOST + "/?", Pattern.CASE_INSENSITIVE);

    private static final Pattern PATTERN_URL = Pattern.compile(REGEX_URL, Pattern.CASE_INSENSITIVE);

    private static final Pattern PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL, Pattern.CASE_INSENSITIVE);

    private NetUtil() {
    }

    /**
     * Verifica se a URL informada esta em um padrao valido. A URL deve conter o
     * protocolo (http, https ou ftp), o host, opcionalmente a porta,
     * opcionalmente o path e opcionalmente a query string.
     * Exemplos:
     * <ul>
     * <li>http://www.dominio.com.br</li>
     * <li>http://www.dominio.com.br/</li>
     * <li>http://www.dominio.com.br/pagina.html</li>
     * <li>http://www.dominio.com.br:8888/em/</li>
     * <li>http://127.0.0.1/</li>
     * <li>https://www.dominio.com.br</li>
     * <li>ftp://ftp.dominio.com</li>
     * </ul>
     * @param url url.
     * @return true se a url for v�lida, ou false caso contr�rio.
     */
    public static boolean isValidURL(String url) {
        if (url == null) {
            return false;
        }
        return PATTERN_URL.matcher(url).matches();
    }

    /**
     * Verifica se a URL informada esta em um padrao valido para um host. A
     * URL nao deve conter a porta, apenas o protocolo (http, https ou ftp) e
     * o nome do host, e opcionalmente a barra no final.
     * Exemplos:
     * <ul>
     * <li>http://www.tokiomarine.com.br</li>
     * <li>http://www.tokiomarine.com.br/</li>
     * <li>https://www.tokiomarine.com.br</li>
     * <li>https://www.tokiomarine.com.br/</li>
     * <li>ftp://ftp.xpto.com</li>
     * <li>ftp://ftp.xpto.com/</li>
     * </ul>
     * @param url url.
     * @return true se a url for valida, ou false caso contrario.
     */
    public static boolean isValidURLHost(String url) {
        if (url == null) {
            return false;
        }
        return PATTERN_HOST.matcher(url).matches();
    }

    /**
     * Verifica se o e-mail informado esta em um padrao valido.
     * @param email endereco de e-mail.
     * @return true se a url for valida, ou false caso contrario.
     */
    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        return PATTERN_EMAIL.matcher(email).matches();
    }
}
