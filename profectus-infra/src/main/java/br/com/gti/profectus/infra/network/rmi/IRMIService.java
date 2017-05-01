package br.com.gti.profectus.infra.network.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import br.com.gti.profectus.infra.common.ProtocolRequestMessage;
import br.com.gti.profectus.infra.common.ProtocolResponseMessage;

/**
 * IRMIListener.
 * @author eduardo.fsantos
 * @since 22/05/2015
 */
public interface IRMIService extends Remote {

    /**
     * .
     * @author eduardo.fsantos
     * @since 26/05/2015
     * @param protocolMessage
     * @return
     * @throws RemoteException
     */
    ProtocolResponseMessage requestAction(ProtocolRequestMessage protocolMessage) throws RemoteException;

}
