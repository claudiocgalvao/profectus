package br.com.gti.profectus.infra.network.rmi.config;

/**
 * IConfigInfo.
 * @author eduardo.fsantos
 * @since 28/05/2015
 */
public interface IConfigInfo {

    //IBM MQ Consumer
    String PROPERTIES_IBM_MQ_HOST = "listener.ibm.mq.host";

    String PROPERTIES_IBM_MQ_PORT = "listener.ibm.mq.port";

    String PROPERTIES_IBM_MQ_MANAGER = "listener.ibm.mq.manager";

    String PROPERTIES_IBM_MQ_CHANNEL = "listener.ibm.mq.channel";

    String PROPERTIES_IBM_MQ_QUEUE_NAME = "listener.ibm.mq.queue.name";

    //IBM MQ Producer
    String PROPERTIES_IBM_MQ_HOST_PRODUCER = "listener.ibm.mq.host.producer";

    String PROPERTIES_IBM_MQ_PORT_PRODUCER = "listener.ibm.mq.port.producer";

    String PROPERTIES_IBM_MQ_MANAGER_PRODUCER = "listener.ibm.mq.manager.producer";

    String PROPERTIES_IBM_MQ_CHANNEL_PRODUCER = "listener.ibm.mq.channel.producer";

    String PROPERTIES_IBM_MQ_QUEUE_NAME_PRODUCER = "listener.ibm.mq.queue.name.producer";

    //***********************************************************************************************

    String PROPERTIES_LISTENER_TFSCALCULATOR_HOST = "listener.Tfscalculator.Host";

    String PROPERTIES_LISTENER_TFSCALCULATOR_PORT = "listener.Tfscalculator.Port";

    String PROPERTIES_LISTENER_TFSCALCULATOR_SERVICENAME = "listener.Tfscalculator.ServiceName";

    String PROPERTIES_LISTENER_CALCULATORONLINE_HOST = "listener.CalculatorOnLine.Host";

    String PROPERTIES_LISTENER_CALCULATORONLINE_PORT = "listener.CalculatorOnLine.Port";

    String PROPERTIES_LISTENER_CALCULATORONLINE_SERVICENAME = "listener.CalculatorOnLine.ServiceName";

    String PROPERTIES_LISTENER_NETTING_HOST = "listener.Netting.Host";

    String PROPERTIES_LISTENER_NETTING_PORT = "listener.Netting.Port";

    String PROPERTIES_LISTENER_NETTING_SERVICENAME = "listener.Netting.ServiceName";

    String PROPERTIES_LISTENER_MATRIX_HOST = "listener.Matrix.Host";

    String PROPERTIES_LISTENER_MATRIX_PORT = "listener.Matrix.Port";

    String PROPERTIES_LISTENER_MATRIX_SERVICENAME = "listener.Matrix.ServiceName";

    String PROPERTIES_LISTENER_TEST_HOST = "listener.Test.Host";

    String PROPERTIES_LISTENER_TEST_PORT = "listener.Test.Port";

    String PROPERTIES_LISTENER_TEST_SERVICENAME = "listener.Test.ServiceName";

    String PROPERTIES_LISTENER_ADMINISTRATOR_HOST = "listener.Administrator.Host";

    String PROPERTIES_LISTENER_ADMINISTRATOR_PORT = "listener.Administrator.Port";

    String PROPERTIES_LISTENER_ADMINISTRATOR_SERVICENAME = "listener.Administrator.ServiceName";

    String PROPERTIES_LISTENER_SIMULATOR_HOST = "listener.Simulator.Host";

    String PROPERTIES_LISTENER_SIMULATOR_PORT = "listener.Simulator.Port";

    String PROPERTIES_LISTENER_SIMULATOR_SERVICENAME = "listener.Simulator.ServiceName";

    String PROPERTIES_LISTENER_MAINTENANCE_HOST = "listener.Maintenance.Host";

    String PROPERTIES_LISTENER_MAINTENANCE_PORT = "listener.Maintenance.Port";

    String PROPERTIES_LISTENER_MAINTENANCE_SERVICENAME = "listener.Maintenance.ServiceName";

}
