package br.com.gti.profectus.business.exception;

/**
 * TechnicalException.
 */
public class TechnicalException extends BaseException {

    private static final long serialVersionUID = 2826598142688685477L;

    /**
     * TechnicalException.
     * @param codigoErro
     * @param mensagem
     * @param causa
     */
    public TechnicalException(String codigoErro, String mensagem, Throwable causa) {
        super(codigoErro, mensagem, causa);
    }

    /**
     * Construtor para uma <code>TechnicalException</code> com o codigo de
     * identificacao, mensagem, instrucao e detalhe da falha ou erro.
     * Codigo de identificacao da falha ou erro.
     * @param mensagem
     * Mensagem explicativa da falha ou erro.
     * Instrucao para tratamento da falha ou erro.
     * Detalhe da falha ou erro.
     */
    public TechnicalException(String mensagem) {
        super(mensagem);
    }

    /**
     * TechnicalException.
     * @param msg
     * @param mensagem
     */
    public TechnicalException(ErrorCode msg, String mensagem) {
        super(msg, mensagem);
    }

    /**
     * Construtor para uma <code>TechnicalException</code> com o codigo de
     * identificacao, mensagem, instrucao, detalhe e causa da falha ou erro.
     * Codigo de identificacao da falha ou erro.
     * @param mensagem
     * Mensagem explicativa da falha ou erro.
     * Instrucao para tratamento da falha ou erro.
     * Detalhe da falha ou erro.
     * @param causa
     * A causa da falha ou erro.
     */
    public TechnicalException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

    /**
     * TechnicalException.
     * @param msg
     * @param mensagem
     * @param causa
     */
    public TechnicalException(ErrorCode msg, String mensagem, Throwable causa) {
        super(msg, mensagem, causa);
    }

    /**
     * Construtor para uma <code>TechnicalException</code> com a causa da falha
     * ou erro.
     * @param causa
     * A causa da falha ou erro.
     */
    public TechnicalException(Throwable causa) {
        super(causa);
    }

    /**
     * TechnicalException.
     * @param msg
     * @param causa
     */
    public TechnicalException(ErrorCode msg, Throwable causa) {
        super(msg, causa);
    }
}
