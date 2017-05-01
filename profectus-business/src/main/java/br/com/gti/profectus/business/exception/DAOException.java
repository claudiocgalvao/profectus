package br.com.gti.profectus.business.exception;

/**
 * Excecao referente a camada DAO.
 */
public class DAOException extends TechnicalException {

    private static final long serialVersionUID = -8664194025912011104L;

    /**
     * DAOException.
     * @param codigoErro
     * @param mensagem
     * @param causa
     */
    public DAOException(String codigoErro, String mensagem, Throwable causa) {
        super(codigoErro, mensagem, causa);
    }

    /**
     * DAOException.
     * @param mensagem
     */
    public DAOException(String mensagem) {
        super(mensagem);
    }

    /**
     * DAOException.
     * @param msg
     * @param mensagem
     */
    public DAOException(ErrorCode msg, String mensagem) {
        super(msg, mensagem);
    }

    /**
     * DAOException.
     * @param mensagem
     * @param causa
     */
    public DAOException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

    /**
     * DAOException.
     * Inform the constructor description.
     * @param msg
     * @param mensagem
     * @param causa
     */
    public DAOException(ErrorCode msg, String mensagem, Throwable causa) {
        super(msg, mensagem, causa);
    }

    /**
     * DAOException.
     * @param causa
     */
    public DAOException(Throwable causa) {
        super(causa);
    }

    /**
     * DAOException.
     * @param msg
     * @param causa
     */
    public DAOException(ErrorCode msg, Throwable causa) {
        super(msg, causa);
    }
}
