package br.com.gti.profectus.infra.network.rmi;

import br.com.gti.profectus.infra.common.ProtocolRequestMessage;
import br.com.gti.profectus.infra.common.ProtocolResponseMessage;

/**
 * IRMIConnector.
 * @author eduardo.fsantos
 * @since 26/05/2015
 */
public interface IRMIConnector {

    /**
     * .
     * @author eduardo.fsantos
     * @since 26/05/2015
     * @param host
     * @param port
     * @param serviceName
     * @return
     */
    boolean connect(String host, String port, String serviceName);

    /**
     * .
     * @author eduardo.fsantos
     * @since 11/06/2015
     * @param serviceName
     * @return
     */
    boolean disconnect(String serviceName);

    /**
     * .
     * @author eduardo.fsantos
     * @since 26/05/2015
     * @param protocolRequestMessage
     * @return
     */
    ProtocolResponseMessage send(ProtocolRequestMessage protocolRequestMessage);

}
