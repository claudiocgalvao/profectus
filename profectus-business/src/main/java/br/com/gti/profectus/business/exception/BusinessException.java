package br.com.gti.profectus.business.exception;

/**
 * BusinessException.
 */
public class BusinessException extends BaseException {

    private static final long serialVersionUID = 1L;

    /**
     * Construtor para uma <code>BusinessException</code> com o codigo de identificacao, mensagem, instrucao e detalhe
     * da falha ou erro.
     * Codigo de identificacao da falha ou erro.
     * @param mensagem
     * Mensagem explicativa da falha ou erro.
     * Instrucao para tratamento da falha ou erro
     * Detalhe da falha ou erro
     */
    public BusinessException(String mensagem) {
        super(mensagem);
    }

    /**
     * BusinessException.
     * @param msg
     * @param mensagem
     */
    public BusinessException(ErrorCode msg, String mensagem) {
        super(msg, mensagem);
    }

    /**
     * BusinessException.
     * @param codigoErro
     * @param mensagem
     * @param causa
     */
    public BusinessException(String codigoErro, String mensagem, Throwable causa) {
        super(codigoErro, mensagem, causa);
    }

    /**
     * Construtor para uma <code>BusinessException</code> com o codigo de
     * identificacao, mensagem, instrucao, detalhe e causa da falha ou erro.
     * Codigo de identificacao da falha ou erro.
     * @param mensagem
     * Mensagem explicativa da falha ou erro.
     * Instrucao para tratamento da falha ou erro.
     * @param causa
     * A causa da falha ou erro.
     */
    public BusinessException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

    /**
     * BusinessException.
     * @param msg
     * @param mensagem
     * @param causa
     */
    public BusinessException(ErrorCode msg, String mensagem, Throwable causa) {
        super(msg, mensagem, causa);
    }

    /**
     * Construtor para uma <code>BusinessException</code> com a causa da falha
     * ou erro.
     * @param causa
     * A causa da falha ou erro.
     */
    public BusinessException(Throwable causa) {
        super(causa);
    }

    /**
     * BusinessException.
     * @param msg
     * @param causa
     */
    public BusinessException(ErrorCode msg, Throwable causa) {
        super(msg, causa);
    }
}
