package br.com.gti.profectus.business.exception;

/**
 * Excecao/ou erros causados na execu��o de um m�todo que responde a uma requisi��o AJAX, incluindo JSON, JSON/RPC,
 * dentre outras.
 */
public class AjaxException extends BaseException {
    private static final long serialVersionUID = -7673019710288797107L;

    /**
     * Inform the constructor description.
     * @param codigoErro
     * @param mensagem
     * @param causa
     */
    public AjaxException(String codigoErro, String mensagem, Throwable causa) {
        super(codigoErro, mensagem, causa);
    }

    /**
     * Construtor que recebe a mensagem de erro.
     * @param mensagem mensagem de erro.
     */
    public AjaxException(String mensagem) {
        super(mensagem);
    }

    /**
     * Inform the constructor description.
     * @param msg
     * @param mensagem
     */
    public AjaxException(ErrorCode msg, String mensagem) {
        super(msg, mensagem);
    }

    /**
     * Construtor que recebe a causa do erro.
     * @param causa causa do erro.
     */
    public AjaxException(Throwable causa) {
        super(causa);
    }

    /**
     * Inform the constructor description.
     * @param msg
     * @param causa
     */
    public AjaxException(ErrorCode msg, Throwable causa) {
        super(msg, causa);
    }

    /**
     * Construtor que recebe a mensagem de erro e a cause do erro.
     * @param mensagem mensagem de erro.
     * @param causa causa do erro.
     */
    public AjaxException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

    /**
     * Inform the constructor description.
     * @param msg
     * @param mensagem
     * @param causa
     */
    public AjaxException(ErrorCode msg, String mensagem, Throwable causa) {
        super(msg, mensagem, causa);
    }
}
