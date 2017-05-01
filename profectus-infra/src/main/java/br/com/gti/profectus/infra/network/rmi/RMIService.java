package br.com.gti.profectus.infra.network.rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import br.com.gti.profectus.infra.common.ProtocolRequestMessage;
import br.com.gti.profectus.infra.common.ProtocolResponseMessage;

/**
 * RMIService.
 * @author eduardo.fsantos
 * @since 17/06/2015
 */
public class RMIService extends UnicastRemoteObject implements IRMIService, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private IRMIService rmiService;

    /**
     * Constructor of class RMIService.java.
     */
    public RMIService(IRMIService rmiService) throws RemoteException {
        this.rmiService = rmiService;
    }

    /*
     * (non-Javadoc)
     * @see
     * br.com.gti.profectusnetwork.rmi.IRMIService#requestAction(br.com.gti.profectuscommon.message.ProtocolRequestMessage
     * )
     */
    @Override
    public ProtocolResponseMessage requestAction(ProtocolRequestMessage protocolMessage) throws RemoteException {
        return this.rmiService.requestAction(protocolMessage);
    }


}
