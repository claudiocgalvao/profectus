package br.com.gti.profectus.infra.network;

import br.com.gti.profectus.infra.network.rmi.IRMIService;	

/**
 * IRegistry.
 * @author eduardo.fsantos
 * @since 26/05/2015
 */
public interface IRegistry {

    public void setListener(String port);

    public void setListener(String host, String port);

    public boolean addStart(String serviceName, IRMIService rmiService, int port);

    public boolean stop(String serviceName);

    //public boolean start();

    //public boolean stop();

}
