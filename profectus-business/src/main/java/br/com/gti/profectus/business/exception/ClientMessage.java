package br.com.gti.profectus.business.exception;

/**
 * Mensagem de valida��o, formada para uma chave (key) ou a mensagem propriamente dita
 * e um array de par�metros para aplicar na mensagem.
 */
public class ClientMessage {

    private String key;
    private String[] params;

    /**
     * Constructor ClientMessage.
     * @param key
     */
    public ClientMessage(String key) {
        this(key, null);
    }

    /**
     * Constrctor.
     * @param key
     * @param params
     */
    public ClientMessage(String key, String[] params) {
        this.key = key;
        this.params = params;
    }

    public String getKey() {
        return this.key;
    }

    public String[] getParams() {
        return this.params;
    }
}
