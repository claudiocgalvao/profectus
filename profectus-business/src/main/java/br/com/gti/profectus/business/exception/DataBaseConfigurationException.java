package br.com.gti.profectus.business.exception;

/**
 * Class exception data base configuration.
 * @author tiago.canatelli
 */
public class DataBaseConfigurationException extends DAOException {

    private static final long serialVersionUID = -8664194025912011104L;

    /**
     * DataBaseConfigurationException.
     * @param mensagem
     */
    public DataBaseConfigurationException(String mensagem) {
        super(mensagem);
    }

    /**
     * DataBaseConfigurationException.
     * @param msg
     * @param mensagem
     */
    public DataBaseConfigurationException(ErrorCode msg, String mensagem) {
        super(msg, mensagem);
    }

    /**
     * DataBaseConfigurationException.
     * @param mensagem
     * @param causa
     */
    public DataBaseConfigurationException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

    /**
     * DataBaseConfigurationException.
     * @param msg
     * @param mensagem
     * @param causa
     */
    public DataBaseConfigurationException(ErrorCode msg, String mensagem, Throwable causa) {
        super(msg, mensagem, causa);
    }

    /**
     * DataBaseConfigurationException.
     * @param causa
     */
    public DataBaseConfigurationException(Throwable causa) {
        super(causa);
    }

    /**
     * DataBaseConfigurationException.
     * @param msg
     * @param causa
     */
    public DataBaseConfigurationException(ErrorCode msg, Throwable causa) {
        super(msg, causa);
    }
}
