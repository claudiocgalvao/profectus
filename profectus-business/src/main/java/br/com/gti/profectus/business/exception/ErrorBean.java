package br.com.gti.profectus.business.exception;

import java.util.Date;

/**
 * Classe que representa um erro de negocio ou uma falha tecnica.
 */
public class ErrorBean {

    /**
     * Servidor em que ocorreu a falha.
     */
    private String host;

    /**
     * Momento em que ocorreu a falha.
     */
    private Date timestamp;

    /**
     * Codigo de identificacao da falha.
     */
    private String code;

    /**
     * Mensagem descritiva da falha.
     */
    private String message;

    /**
     * Informacoes detalhadas sobre a falha.
     */
    private String trace;

    /**
     * toString.
     */
    public String toString() {
        return "ERROR: CODE[" + getCode() + "] TIMESTAMP[" + getTimestamp() + "] HOST[" + getHost() + "] MESSAGE["
                + getMessage() + "] TRACE:\n" + getTrace();
    }

    /**
     * Obtem o servidor em que ocorreu a falha.
     * @return Servidor em que ocorreu a falha.
     */
    public String getHost() {
        return host;
    }

    /**
     * Atribui o servidor em que ocorreu a falha.
     * @param host
     * O Servidor em que ocorreu a falha para atribuir.
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * Obtem o momento em que ocorreu a falha.
     * @return Momento em que ocorreu a falha.
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * Atribui o momento em que ocorreu a falha.
     * @param timestamp
     * Momento em que ocorreu a falha para atribuir.
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Obtem o codigo de identificacao da falha.
     * @return Codigo de identificacao da falha.
     */
    public String getCode() {
        return code;
    }

    /**
     * Atribui o codigo de identificacao da falha.
     * @param code
     * Codigo de identificacao da falha para atribuir.
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Obtem a mensagem descritiva da falha.
     * @return Mensagem descritiva da falha.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Atribui a mensagem descritiva da falha.
     * @param message
     * Mensagem descritiva da falha para atribuir.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Obtem informacoes detalhadas sobre a falha.
     * @return Informacoes detalhadas sobre a falha.
     */
    public String getTrace() {
        return trace;
    }

    /**
     * Atribui informacoes detalhadas sobre a falha.
     * @param trace
     * Informacoes detalhadas sobre a falha para atribuir.
     */
    public void setTrace(String trace) {
        this.trace = trace;
    }

    /**
     * ID do erro usado para identificar o problema em log.
     * Essa informacao e um conjunto de CODE+TIMESTAMP
     */
    public String getErrorId() {
        return code + ":" + timestamp.getTime();
    }
}
