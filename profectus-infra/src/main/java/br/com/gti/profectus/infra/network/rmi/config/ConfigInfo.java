package br.com.gti.profectus.infra.network.rmi.config;

import java.util.HashMap;
import java.util.Map;

/**
 * ConfigInfo.
 * @author eduardo.fsantos
 * @since 28/05/2015
 */
public class ConfigInfo implements IConfigInfo {

    private String localPropertiesHost;

    private String localPropertiesPort;

    private String localPropertiesServiceName; //Map poderia ter n services!!!!!!!!!!

    private String localListenerHost;

    private String localListenerPort;

    private String localServiceName; //Map poderia ter n services!!!!!!!!!!

    //********** Consumer IBM MQ *************
    /** Manager. */
    private String propertiesManagerMQ;

    /** Hostname. */
    private String propertiesHostMQ;

    /** Port. */
    private String propertiesPortMQ;

    /** Channel. */
    private String propertiesChannelMQ;

    /** Queue name. */
    private String propertiesQueueNameMQ;

    /** Manager. */
    private String managerMQ;

    /** Hostname. */
    private String hostMQ;

    /** Port. */
    private String portMQ;

    /** Channel. */
    private String channelMQ;

    /** Queue name. */
    private String queueNameMQ;

    //********** Producer IBM MQ *********
    /** Manager. */
    private String propertiesManagerMQProducer;

    /** Hostname. */
    private String propertiesHostMQProducer;

    /** Port. */
    private String propertiesPortMQProducer;

    /** Channel. */
    private String propertiesChannelMQProducer;

    /** Queue name. */
    private String propertiesQueueNameMQProducer;

    /** Manager. */
    private String managerMQProducer;

    /** Hostname. */
    private String hostMQProducer;

    /** Port. */
    private String portMQProducer;

    /** Channel. */
    private String channelMQProducer;

    /** Queue name. */
    private String queueNameMQProducer;

    private Map<String, String> remoteHostPortServiceMap; //Map<propertiesName, Value>

    public ConfigInfo() {
        this.localPropertiesHost = "";

        this.localPropertiesPort = "";

        this.localPropertiesServiceName = ""; //Map poderia ter n services!!!!!!!!!!

        this.localListenerHost = "";

        this.localListenerPort = "";

        this.localServiceName = ""; //Map poderia ter n services!!!!!!!!!!

        this.remoteHostPortServiceMap = new HashMap<String, String>(); //Map<propertiesName, Value>

        //******* IBM MQ Consumer*********
        this.setPropertiesManagerMQ("");
        this.setPropertiesChannelMQ("");
        this.setPropertiesHostMQ("");
        this.setPropertiesPortMQ("");
        this.setPropertiesQueueNameMQ("");

        this.setManagerMQ("");
        this.setChannelMQ("");
        this.setHostMQ("");
        this.setPortMQ("");
        this.setQueueNameMQ("");

        //******* IBM MQ Producer *********
        this.setPropertiesManagerMQProducer("");
        this.setPropertiesChannelMQProducer("");
        this.setPropertiesHostMQProducer("");
        this.setPropertiesPortMQProducer("");
        this.setPropertiesQueueNameMQProducer("");

        this.setManagerMQProducer("");
        this.setChannelMQProducer("");
        this.setHostMQProducer("");
        this.setPortMQProducer("");
        this.setQueueNameMQProducer("");

    }

    /**
     * @return the localListenerHost
     */
    public String getLocalListenerHost() {
        return this.localListenerHost;
    }

    /**
     * @param localListenerHost the localListenerHost to set
     */
    public void setLocalListenerHost(String localListenerHost) {
        this.localListenerHost = localListenerHost;
    }

    /**
     * @return the localListenerPort
     */
    public String getLocalListenerPort() {
        return this.localListenerPort;
    }

    /**
     * @param localListenerPort the localListenerPort to set
     */
    public void setLocalListenerPort(String localListenerPort) {
        this.localListenerPort = localListenerPort;
    }

    /**
     * @return the localServiceName
     */
    public String getLocalServiceName() {
        return this.localServiceName;
    }

    /**
     * @param localServiceName the localServiceName to set
     */
    public void setLocalServiceName(String localServiceName) {
        this.localServiceName = localServiceName;
    }

    /**
     * @return the localPropertiesHost
     */
    public String getLocalPropertiesHost() {
        return this.localPropertiesHost;
    }

    /**
     * @param localPropertiesHost the localPropertiesHost to set
     */
    public void setLocalPropertiesHost(String localPropertiesHost) {
        this.localPropertiesHost = localPropertiesHost;
    }

    /**
     * @return the localPropertiesPort
     */
    public String getLocalPropertiesPort() {
        return this.localPropertiesPort;
    }

    /**
     * @param localPropertiesPort the localPropertiesPort to set
     */
    public void setLocalPropertiesPort(String localPropertiesPort) {
        this.localPropertiesPort = localPropertiesPort;
    }

    /**
     * @return the localPropetiesServiceName
     */
    public String getLocalPropertiesServiceName() {
        return this.localPropertiesServiceName;
    }

    /**
     * @param localPropetiesServiceName the localPropetiesServiceName to set
     */
    public void setLocalPropertiesServiceName(String localPropertiesServiceName) {
        this.localPropertiesServiceName = localPropertiesServiceName;
    }

    /**
     * @return the remoteHostPortService
     */
    public Map<String, String> getRemoteHostPortServiceMap() {
        return this.remoteHostPortServiceMap;
    }

    /**
     * @param remoteHostPortService the remoteHostPortService to set
     */
    public void setRemoteHostPortServiceMap(Map<String, String> remoteHostPortServiceMap) {
        this.remoteHostPortServiceMap = remoteHostPortServiceMap;
    }

    /**
     * @return the managerMQ
     */
    public String getManagerMQ() {
        return this.managerMQ;
    }

    /**
     * @param managerMQ the managerMQ to set
     */
    public void setManagerMQ(String managerMQ) {
        this.managerMQ = managerMQ;
    }

    /**
     * @return the hostMQ
     */
    public String getHostMQ() {
        return this.hostMQ;
    }

    /**
     * @param hostMQ the hostMQ to set
     */
    public void setHostMQ(String hostMQ) {
        this.hostMQ = hostMQ;
    }

    /**
     * @return the portMQ
     */
    public String getPortMQ() {
        return this.portMQ;
    }

    /**
     * @param portMQ the portMQ to set
     */
    public void setPortMQ(String portMQ) {
        this.portMQ = portMQ;
    }

    /**
     * @return the channelMQ
     */
    public String getChannelMQ() {
        return this.channelMQ;
    }

    /**
     * @param channelMQ the channelMQ to set
     */
    public void setChannelMQ(String channelMQ) {
        this.channelMQ = channelMQ;
    }

    /**
     * @return the queueNameMQ
     */
    public String getQueueNameMQ() {
        return this.queueNameMQ;
    }

    /**
     * @param queueNameMQ the queueNameMQ to set
     */
    public void setQueueNameMQ(String queueNameMQ) {
        this.queueNameMQ = queueNameMQ;
    }

    /**
     * @return the propertiesManagerMQ
     */
    public String getPropertiesManagerMQ() {
        return this.propertiesManagerMQ;
    }

    /**
     * @param propertiesManagerMQ the propertiesManagerMQ to set
     */
    public void setPropertiesManagerMQ(String propertiesManagerMQ) {
        this.propertiesManagerMQ = propertiesManagerMQ;
    }

    /**
     * @return the propertiesHostMQ
     */
    public String getPropertiesHostMQ() {
        return this.propertiesHostMQ;
    }

    /**
     * @param propertiesHostMQ the propertiesHostMQ to set
     */
    public void setPropertiesHostMQ(String propertiesHostMQ) {
        this.propertiesHostMQ = propertiesHostMQ;
    }

    /**
     * @return the propertiesPortMQ
     */
    public String getPropertiesPortMQ() {
        return this.propertiesPortMQ;
    }

    /**
     * @param propertiesPortMQ the propertiesPortMQ to set
     */
    public void setPropertiesPortMQ(String propertiesPortMQ) {
        this.propertiesPortMQ = propertiesPortMQ;
    }

    /**
     * @return the propertiesChannelMQ
     */
    public String getPropertiesChannelMQ() {
        return this.propertiesChannelMQ;
    }

    /**
     * @param propertiesChannelMQ the propertiesChannelMQ to set
     */
    public void setPropertiesChannelMQ(String propertiesChannelMQ) {
        this.propertiesChannelMQ = propertiesChannelMQ;
    }

    /**
     * @return the propertiesQueueNameMQ
     */
    public String getPropertiesQueueNameMQ() {
        return this.propertiesQueueNameMQ;
    }

    /**
     * @param propertiesQueueNameMQ the propertiesQueueNameMQ to set
     */
    public void setPropertiesQueueNameMQ(String propertiesQueueNameMQ) {
        this.propertiesQueueNameMQ = propertiesQueueNameMQ;
    }

    /**
     * @return the propertiesManagerMQProducer
     */
    public String getPropertiesManagerMQProducer() {
        return this.propertiesManagerMQProducer;
    }

    /**
     * @param propertiesManagerMQProducer the propertiesManagerMQProducer to set
     */
    public void setPropertiesManagerMQProducer(String propertiesManagerMQProducer) {
        this.propertiesManagerMQProducer = propertiesManagerMQProducer;
    }

    /**
     * @return the propertiesHostMQProducer
     */
    public String getPropertiesHostMQProducer() {
        return this.propertiesHostMQProducer;
    }

    /**
     * @param propertiesHostMQProducer the propertiesHostMQProducer to set
     */
    public void setPropertiesHostMQProducer(String propertiesHostMQProducer) {
        this.propertiesHostMQProducer = propertiesHostMQProducer;
    }

    /**
     * @return the propertiesPortMQProducer
     */
    public String getPropertiesPortMQProducer() {
        return this.propertiesPortMQProducer;
    }

    /**
     * @param propertiesPortMQProducer the propertiesPortMQProducer to set
     */
    public void setPropertiesPortMQProducer(String propertiesPortMQProducer) {
        this.propertiesPortMQProducer = propertiesPortMQProducer;
    }

    /**
     * @return the propertiesChannelMQProducer
     */
    public String getPropertiesChannelMQProducer() {
        return this.propertiesChannelMQProducer;
    }

    /**
     * @param propertiesChannelMQProducer the propertiesChannelMQProducer to set
     */
    public void setPropertiesChannelMQProducer(String propertiesChannelMQProducer) {
        this.propertiesChannelMQProducer = propertiesChannelMQProducer;
    }

    /**
     * @return the propertiesQueueNameMQProducer
     */
    public String getPropertiesQueueNameMQProducer() {
        return this.propertiesQueueNameMQProducer;
    }

    /**
     * @param propertiesQueueNameMQProducer the propertiesQueueNameMQProducer to set
     */
    public void setPropertiesQueueNameMQProducer(String propertiesQueueNameMQProducer) {
        this.propertiesQueueNameMQProducer = propertiesQueueNameMQProducer;
    }

    /**
     * @return the managerMQProducer
     */
    public String getManagerMQProducer() {
        return this.managerMQProducer;
    }

    /**
     * @param managerMQProducer the managerMQProducer to set
     */
    public void setManagerMQProducer(String managerMQProducer) {
        this.managerMQProducer = managerMQProducer;
    }

    /**
     * @return the hostMQProducer
     */
    public String getHostMQProducer() {
        return this.hostMQProducer;
    }

    /**
     * @param hostMQProducer the hostMQProducer to set
     */
    public void setHostMQProducer(String hostMQProducer) {
        this.hostMQProducer = hostMQProducer;
    }

    /**
     * @return the portMQProducer
     */
    public String getPortMQProducer() {
        return this.portMQProducer;
    }

    /**
     * @param portMQProducer the portMQProducer to set
     */
    public void setPortMQProducer(String portMQProducer) {
        this.portMQProducer = portMQProducer;
    }

    /**
     * @return the queueNameMQProducer
     */
    public String getQueueNameMQProducer() {
        return this.queueNameMQProducer;
    }

    /**
     * @param queueNameMQProducer the queueNameMQProducer to set
     */
    public void setQueueNameMQProducer(String queueNameMQProducer) {
        this.queueNameMQProducer = queueNameMQProducer;
    }

    /**
     * @return the channelMQProducer
     */
    public String getChannelMQProducer() {
        return this.channelMQProducer;
    }

    /**
     * @param channelMQProducer the channelMQProducer to set
     */
    public void setChannelMQProducer(String channelMQProducer) {
        this.channelMQProducer = channelMQProducer;
    }

}
