package br.com.gti.profectus.business.exception;

import java.io.PrintWriter;

import br.com.gti.profectus.tools.host.HostNameHelper;

/**
 * Erro generico usado para encapsular qualquer excecao que tenha instrucao e detalhe.
 */
public class BaseException extends Exception {

    /**
     * Versso da classe para propositos de serializacao.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Codigo de erro usando para a mensagem para o cliente.
     */
    private ErrorCode errorCode;

    /**
     * Codigo de erro usando para a mensagem para o cliente.
     */
    private ClientMessage clientMessage;

    /**
     * Origem do erro.
     */
    private String origem;

    /**
     * Insere uma chave de mensagem para o usuario.
     * @param key chave da mensagem da validacao.
     */
    public void setClientMessage(String key) {
        setClientMessage(key, (String) null);
    }

    /**
     * Insere uma chave de mensagem para o usuario e um parametro.
     * @param key chave da mensagem da validacao.
     * @param param parametro a substituir na mensagem.
     */
    public void setClientMessage(String key, String param) {
        setClientMessage(key, new String[]{param});
    }

    /**
     * Insere uma chave de mensagem para o usuario e alguns par�metros.
     * @param key chave da mensagem da validacao.
     * @param params parmetros a substituir na mensagem.
     */
    public void setClientMessage(String key, String[] params) {
        clientMessage = new ClientMessage(key, params);
    }

    /**
     * Construtor para uma <code>BaseException</code> com o codigo de
     * identificacao, mensagem, instrucao e detalhe da falha ou erro.
     * Codigo de identificacao da falha ou erro.
     * Mensagem explicativa da falha ou erro.
     * Instrucao para tratamento da falha ou erro.
     * Detalhe da falha ou erro.
     * @param mensagem
     */
    public BaseException(String mensagem) {
        super(mensagem);
        this.origem = generetedOrigem();
    }

    /**
     * Construtor para uma <code>BaseException</code> com o codigo de
     * identificacao, mensagem, instrucao, detalhe e causa da falha ou erro.
     * @param codigo
     * @param mensagem
     * @param instrucao
     * @param msg
     */
    public BaseException(ErrorCode msg, String mensagem) {
        super(mensagem);
        this.origem = generetedOrigem();
        this.errorCode = msg;
    }

    /**
     * Inform the constructor description.
     * @param mensagem
     * @param causa
     */
    public BaseException(String mensagem, Throwable causa) {
        super(mensagem, causa);
        this.origem = generetedOrigem();
    }

    /**
     * BaseException.
     * @param msg
     * @param mensagem
     * @param causa
     */
    public BaseException(ErrorCode msg, String mensagem, Throwable causa) {
        super(mensagem, causa);
        this.origem = generetedOrigem();
        this.errorCode = msg;
    }

    /**
     * BaseException.
     * @param codigoErro
     * @param mensagem
     * @param causa
     */
    public BaseException(String codigoErro, String mensagem, Throwable causa) {
        super(mensagem, causa);
        this.origem = generetedOrigem();
        this.errorCode = new ErrorCodeImpl(codigoErro);
    }

    /**
     * BaseException.
     * @param msg
     * @param causa
     */
    public BaseException(ErrorCode msg, Throwable causa) {
        super(causa);
        this.origem = generetedOrigem();
        errorCode = msg;
    }

    /**
     * generetedOrigem.
     * @author claudio.cesar
     * @since 18/11/2014
     * @return
     */
    protected String generetedOrigem() {
        return HostNameHelper.getInstance().getHostname() + "-" + System.currentTimeMillis() + "-" + System.nanoTime();
    }

    /**
     * Construtor para uma <code>BaseException</code> com a causa da falha ou erro.
     * @param causa
     * A causa da falha ou erro.
     */
    public BaseException(Throwable causa) {
        super(causa);
        this.origem = generetedOrigem();
    }

    /**
     * Obtem o codigo de identificacao da falha ou erro.
     * @return O codigo de identificacao da falha ou erro.
     */
    public String getCodigo() {
        return errorCode == null ? null : errorCode.getCode();
    }

    /**
     * Obtem a mensagem explicativa da falha ou erro.
     * @return A mensagem explicativa da falha ou erro.
     */
    public String getMessage() {
        return super.getMessage();
    }

    /**
     * getError.
     */
    public String getError() {
        printStackTraceLocal = false;
        ErrorBean error = ErrorFactory.getInstance().createErrorByBaseException(this);
        printStackTraceLocal = true;
        return "Code[" + (errorCode == null ? "" : errorCode.getCode()) + "] Origem[" + origem + "] Message["
                + super.getMessage() + "] Error:\n " + error;
    }

    private boolean printStackTraceLocal = true;

    /**
     * Defines a custom format for the stack trace as String.
     */
    public void printStackTrace(PrintWriter s) {
        if (printStackTraceLocal) {
            printStackTraceLocal = false;
            s.println(ErrorFactory.getInstance().createErrorByBaseException(this));
            printStackTraceLocal = true;
        } else {
            super.printStackTrace(s);
        }
    }

    /**
     * Defines a custom format for the stack trace as String.
     */
    public void printStackTraceWithoutDetail(PrintWriter s) {
        super.printStackTrace(s);
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    /**
     * getDetail.
     */
    public String getDetail() {
        if (this.getCause() == null) {
            return null;
        } else {
            return ExceptionHelper.getFaultInfo(this.getCause());
        }
    }

    public ClientMessage getClientMessage() {
        return clientMessage;
    }

    public void setClientMessage(ClientMessage clientMessage) {
        this.clientMessage = clientMessage;
    }

    private class ErrorCodeImpl implements ErrorCode {

        private String errorCode = null;

        public ErrorCodeImpl(String errorCode) {
            this.errorCode = errorCode;
        }

        @Override
        public String getCode() {
            return errorCode;
        }
    }
}
