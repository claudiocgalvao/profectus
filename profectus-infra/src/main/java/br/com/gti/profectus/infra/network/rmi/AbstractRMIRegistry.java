package br.com.gti.profectus.infra.network.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

/**
 * AbstractRMIListener.
 * @author eduardo.fsantos
 * @since 25/05/2015
 */
@Log4j2
@Data
public abstract class AbstractRMIRegistry implements IRMIRegistry {

  private Registry registry;

  private String rmiHost;
  private String rmiPort;

  private RMIService remoteService;

  /**
   * Constructor of class AbstractRMIListener.java.
   */
  public AbstractRMIRegistry() {

  }

  @Override
  public void setListener(String port) {
    try {
      this.registry = LocateRegistry.createRegistry(Integer.parseInt(port));
      //System.out.println("::::::::::TFSCalculator Listener Port: " + port);
    } catch (Exception e) {
      log.error("ERROR: " + this.getClass().getName() + ".setListener()");
      log.error("Error details: ", e);
    }
  }

  @Override
  public void setListener(String host, String port) {

    this.rmiHost = host;
    this.rmiPort = port;

    try {

      if (this.registry == null) {

        System.setProperty("java.rmi.server.hostname", host);

        //this.registry = LocateRegistry.getRegistry(host, Integer.parseInt(port));

        //if (this.registry == null) {

        this.registry = LocateRegistry.createRegistry(Integer.parseInt(port));
        //}
      }
    } catch (Exception e) {
      log.error("ERROR: " + this.getClass().getName() + ".setListener()");
      log.error("Error details: ", e);
    }
  }

  @Override
  public boolean addStart(String serviceName, IRMIService rmiService, int port) {
    try {

      if (this.registry != null) {

        System.setProperty("java.rmi.server.hostname", this.rmiHost);

        this.remoteService = new RMIService(rmiService);

        this.registry.rebind(serviceName, this.remoteService);
        return true;
      } else {
        return false;
      }

    } catch (Exception e) {
      log.error("ERROR: " + this.getClass().getName() + ".addStart()");
      log.error("Error details: ", e);
      return false;
    }
  }

  @Override
  public boolean stop(String serviceName) {
    try {
      System.setProperty("java.rmi.server.hostname", this.rmiHost); //Obs.: Devera ser para cada conexao remota!!!
      for (int index = 0; index < this.registry.list().length; index++) {
        if (this.registry.list()[index].equals(serviceName)) {
          this.registry.unbind(serviceName);
        }
      }

      UnicastRemoteObject.unexportObject(this.remoteService, true);

      return true;
    } catch (Exception e) {
      log.error("ERROR: " + this.getClass().getName() + ".stop()");
      log.error("Error details: ", e);
      return false;
    }
  }

}
