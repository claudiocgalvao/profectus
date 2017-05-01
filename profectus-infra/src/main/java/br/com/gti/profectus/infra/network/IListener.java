package br.com.gti.profectus.infra.network;

/**
 * IListener.
 * @author eduardo.fsantos
 * @since 25/05/2015
 */
public interface IListener {

    /**
     * setListener.
     * @param port
     */
    void setListener(String port);

    /**
     * setListener.
     * @param host
     * @param port
     */
    void setListener(String host, String port);

    /**
     * start.
     * @return
     */
    boolean start();

    /**
     * stop.
     * @return
     */
    boolean stop();
}
