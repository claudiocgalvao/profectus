package br.com.gti.profectus.business.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * Excecao para erros de validacao que permite armazenar varios erros ocorridos.
 */
public class ValidationException extends BaseException {

    private static final long serialVersionUID = 1568286820669069691L;

    private List<ClientMessage> mensagens = new ArrayList<ClientMessage>();

    /**
     * ValidationException.
     */
    public ValidationException() {
        super((String) null);
    }

    /**
     * Adiciona uma chave da mensagem de validacao.
     * @param key chave da mensagem da validacao.
     */
    public void add(String key) {
        add(key, (String) null);
    }

    /**
     * Adiciona uma chave da mensagem de validacao e um parametro.
     * @param key chave da mensagem da validacao.
     * @param param parametro a substituir na mensagem.
     */
    public void add(String key, String param) {
        add(key, new String[]{param});
    }

    /**
     * Adiciona uma chave de mensagem de validacao e alguns parametros.
     */
    public void add(String key, String[] params) {
        mensagens.add(new ClientMessage(key, params));
    }

    /**
     * Retorna uma lista de mensagens de validacao.
     * @return mensagens de validacao.
     */
    public List<ClientMessage> getMensagens() {
        return new ArrayList<ClientMessage>(mensagens);
    }

    /**
     * Verifica se a excecao possui mensagens que foram adicionadas a ela.
     * @return retorna true se possui ao menos uma mensagem ou false caso nao
     * tenha mensagens.
     */
    public boolean possuiMensagens() {
        return !(mensagens == null || mensagens.size() <= 0);
    }
}
