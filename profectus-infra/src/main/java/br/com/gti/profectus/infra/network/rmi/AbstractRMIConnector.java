package br.com.gti.profectus.infra.network.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import br.com.gti.profectus.infra.common.ProtocolRequestMessage;
import br.com.gti.profectus.infra.common.ProtocolResponseMessage;
import lombok.extern.log4j.Log4j2;

/**
 * AbstractRMIConnector.
 * @author eduardo.fsantos
 * @since 26/05/2015
 */
@Log4j2
public abstract class AbstractRMIConnector implements IRMIConnector {

    private Registry registry;

    private String host;

    private String port;

    private String rmiServiceName;

    private IRMIService rmiListener;

    /**
     * Constructor of class AbstractRMIConnector.java.
     */
    public AbstractRMIConnector() {
        super();
    }

    /*
     * (non-Javadoc)
     * @see br.com.gti.profectusnetwork.rmi.IRMIConnector#connect(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public boolean connect(String host, String port, String serviceName) {

        boolean flag = false;
        try {

            this.host = host;
            this.port = port;
            this.rmiServiceName = serviceName;

            if (this.registry == null) {

                System.setProperty("java.rmi.server.hostname", host);

                this.registry = LocateRegistry.getRegistry(host, Integer.parseInt(port));
                this.rmiListener = (IRMIService) this.registry.lookup(serviceName);
            } else {

                for (int index = 0; index < this.registry.list().length; index++) {

                    if (!this.registry.list()[index].equals(serviceName)) {
                        System.setProperty("java.rmi.server.hostname", host);

                        this.registry = LocateRegistry.getRegistry(host, Integer.parseInt(port));
                        this.rmiListener = (IRMIService) this.registry.lookup(serviceName);
                    }
                }
            }
            flag = true;
        } catch (Exception e) {
            flag = false;
            log.error("ERROR: " + this.getClass().getName() + ".connect()");
            log.error("Error details: ", e);
        }

        return flag;
    }

    /*
     * (non-Javadoc)
     * @see br.com.gti.profectusnetwork.rmi.IRMIConnector#disconnect(java.lang.String)
     */
    @Override
    public boolean disconnect(String serviceName) {
        try {

            for (int index = 0; index < this.registry.list().length; index++) {
                if (this.registry.list()[index].equals(serviceName)) {

                    System.setProperty("java.rmi.server.hostname", this.host);

                    this.registry.unbind(serviceName);
                    //Naming.unbind("rmi://" + this.host + ":" + this.port + "/" + serviceName);
                    //UnicastRemoteObject.unexportObject(this.rmiListener, true);

                }
            }

            return true;

        } catch (Exception e) {
            log.error("ERROR: " + this.getClass().getName() + ".disconnect()");
            log.error("Error details: ", e);

        }
        return false;
    }

    @Override
    public ProtocolResponseMessage send(ProtocolRequestMessage protocolRequestMessage) {
        ProtocolResponseMessage protocolResponseMessage = null;

        try {
            protocolResponseMessage = this.rmiListener.requestAction(protocolRequestMessage);
        } catch (Exception e) {
            log.error("ERROR: " + this.getClass().getName() + ".send()");
            log.error("Error details: ", e);

        }

        return protocolResponseMessage;
    }

    /**
     * @return the host
     */
    public String getHost() {
        return this.host;
    }

    /**
     * @return the port
     */
    public String getPort() {
        return this.port;
    }

    /**
     * @return the rmiServiceName
     */
    public String getRmiServiceName() {
        return this.rmiServiceName;
    }

}
