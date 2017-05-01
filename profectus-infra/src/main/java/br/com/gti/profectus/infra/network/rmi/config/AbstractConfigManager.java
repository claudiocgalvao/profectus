package br.com.gti.profectus.infra.network.rmi.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import lombok.extern.slf4j.Slf4j;

/**
 * ConfigManager.
 * @author eduardo.fsantos
 * @since 28/05/2015
 */
@Slf4j
public abstract class AbstractConfigManager implements IConfigManager {

  private final ConfigInfo configInfo;

  private final Properties properties;

  private InputStream input = null;

  private OutputStream output = null;

  /**
   * Constructor of class ConfigManager.java.
   */
  public AbstractConfigManager() {
    this.configInfo = new ConfigInfo();
    this.properties = new Properties();
  }

  @Override
  public void save(String pathFile, ConfigInfo configInfo) {
    try {
      //"/opt/middleware/feetax/appdata/tax/tfscalculator/config.properties"
      File file = new File(pathFile);
      this.output = new FileOutputStream(file, false); //append false

      this.properties.clear();

      this.properties.store(this.output, null);
      this.output.flush();

      //IBM MQ Consumer
      this.properties.setProperty(configInfo.getPropertiesHostMQ(), configInfo.getHostMQ());
      this.properties.setProperty(configInfo.getPropertiesPortMQ(), configInfo.getPortMQ());
      this.properties.setProperty(configInfo.getPropertiesManagerMQ(), configInfo.getManagerMQ());
      this.properties.setProperty(configInfo.getPropertiesChannelMQ(), configInfo.getChannelMQ());
      this.properties.setProperty(configInfo.getPropertiesQueueNameMQ(), configInfo.getQueueNameMQ());

      //IBM MQ Producer
      this.properties.setProperty(configInfo.getPropertiesHostMQProducer(), configInfo.getHostMQProducer());
      this.properties.setProperty(configInfo.getPropertiesPortMQProducer(), configInfo.getPortMQProducer());
      this.properties.setProperty(configInfo.getPropertiesManagerMQProducer(), configInfo.getManagerMQProducer());
      this.properties.setProperty(configInfo.getPropertiesChannelMQProducer(), configInfo.getChannelMQProducer());
      this.properties.setProperty(configInfo.getPropertiesQueueNameMQProducer(), configInfo.getQueueNameMQProducer());

      //LocalListener (TFSCalculator/CalculatorOnLine/Netting)
      this.properties.setProperty(configInfo.getLocalPropertiesHost(), configInfo.getLocalListenerHost());
      this.properties.setProperty(configInfo.getLocalPropertiesPort(), configInfo.getLocalListenerPort());
      this.properties.setProperty(configInfo.getLocalPropertiesServiceName(), configInfo.getLocalServiceName());

      //RemoteListener

      Iterator entries = configInfo.getRemoteHostPortServiceMap().entrySet().iterator();
      while (entries.hasNext()) {
        Entry<String, String> thisEntry = (Entry) entries.next();
        String key = thisEntry.getKey();
        String value = thisEntry.getValue();

        this.properties.setProperty(key, value);
      }

      this.properties.store(this.output, null);
      this.output.flush();
    } catch (IOException e) {

      log.error("ERROR: AbstractConfigManager.save(): " + e);

    } finally {
      if (this.output != null) {
        try {
          this.output.close();
        } catch (IOException e) {
          log.error("ERROR: AbstractConfigManager.save(): " + e);
        }
      }
    }

  }

  @SuppressWarnings("rawtypes")
  @Override
  public ConfigInfo load(String pathFile, String fileConfigProperties) {

    try {
      //File file = new File(pathFile);

      this.input = new FileInputStream(pathFile);

      this.properties.load(this.input);

      //Local Listener
	  Iterator entries = this.properties.entrySet().iterator();
      while (entries.hasNext()) {
        @SuppressWarnings("unchecked")
		Entry<String, String> thisEntry = (Entry) entries.next();
        String key = thisEntry.getKey();
        String value = thisEntry.getValue();

        //IBM MQ Consumer
        if (key.equals(IConfigInfo.PROPERTIES_IBM_MQ_HOST)) {
          this.configInfo.setPropertiesHostMQ(key);
          this.configInfo.setHostMQ(value);
        }

        if (key.equals(IConfigInfo.PROPERTIES_IBM_MQ_PORT)) {
          this.configInfo.setPropertiesPortMQ(key);
          this.configInfo.setPortMQ(value);
        }

        if (key.equals(IConfigInfo.PROPERTIES_IBM_MQ_MANAGER)) {
          this.configInfo.setPropertiesManagerMQ(key);
          this.configInfo.setManagerMQ(value);
        }

        if (key.equals(IConfigInfo.PROPERTIES_IBM_MQ_CHANNEL)) {
          this.configInfo.setPropertiesChannelMQ(key);
          this.configInfo.setChannelMQ(value);
        }

        if (key.equals(IConfigInfo.PROPERTIES_IBM_MQ_QUEUE_NAME)) {
          this.configInfo.setPropertiesQueueNameMQ(key);
          this.configInfo.setQueueNameMQ(value);
        }

        //IBM MQ Producer
        if (key.equals(IConfigInfo.PROPERTIES_IBM_MQ_HOST_PRODUCER)) {
          this.configInfo.setPropertiesHostMQProducer(key);
          this.configInfo.setHostMQProducer(value);
        }

        if (key.equals(IConfigInfo.PROPERTIES_IBM_MQ_PORT_PRODUCER)) {
          this.configInfo.setPropertiesPortMQProducer(key);
          this.configInfo.setPortMQProducer(value);
        }

        if (key.equals(IConfigInfo.PROPERTIES_IBM_MQ_MANAGER_PRODUCER)) {
          this.configInfo.setPropertiesManagerMQProducer(key);
          this.configInfo.setManagerMQProducer(value);
        }

        if (key.equals(IConfigInfo.PROPERTIES_IBM_MQ_CHANNEL_PRODUCER)) {
          this.configInfo.setPropertiesChannelMQProducer(key);
          this.configInfo.setChannelMQProducer(value);
        }

        if (key.equals(IConfigInfo.PROPERTIES_IBM_MQ_QUEUE_NAME_PRODUCER)) {
          this.configInfo.setPropertiesQueueNameMQProducer(key);
          this.configInfo.setQueueNameMQProducer(value);
        }

        if (key.equals(IConfigInfo.PROPERTIES_LISTENER_TFSCALCULATOR_HOST)) {
          this.configInfo.setLocalPropertiesHost(key);
          this.configInfo.setLocalListenerHost(value);
        }

        if (key.equals(IConfigInfo.PROPERTIES_LISTENER_TFSCALCULATOR_PORT)) {
          this.configInfo.setLocalPropertiesPort(key);
          this.configInfo.setLocalListenerPort(value);
        }

        if (key.equals(IConfigInfo.PROPERTIES_LISTENER_TFSCALCULATOR_SERVICENAME)) {
          this.configInfo.setLocalPropertiesServiceName(key);
          this.configInfo.setLocalServiceName(value);
        }

        if (key.equals(IConfigInfo.PROPERTIES_LISTENER_CALCULATORONLINE_HOST)) {
          this.configInfo.setLocalPropertiesHost(key);
          this.configInfo.setLocalListenerHost(value);
        }

        if (key.equals(IConfigInfo.PROPERTIES_LISTENER_CALCULATORONLINE_PORT)) {
          this.configInfo.setLocalPropertiesPort(key);
          this.configInfo.setLocalListenerPort(value);
        }

        if (key.equals(IConfigInfo.PROPERTIES_LISTENER_CALCULATORONLINE_SERVICENAME)) {
          this.configInfo.setLocalPropertiesServiceName(key);
          this.configInfo.setLocalServiceName(value);
        }

        if (key.equals(IConfigInfo.PROPERTIES_LISTENER_NETTING_HOST)) {
          this.configInfo.setLocalPropertiesHost(key);
          this.configInfo.setLocalListenerHost(value);
        }

        if (key.equals(IConfigInfo.PROPERTIES_LISTENER_NETTING_PORT)) {
          this.configInfo.setLocalPropertiesPort(key);
          this.configInfo.setLocalListenerPort(value);
        }

        if (key.equals(IConfigInfo.PROPERTIES_LISTENER_NETTING_SERVICENAME)) {
          this.configInfo.setLocalPropertiesServiceName(key);
          this.configInfo.setLocalServiceName(value);
        }

        if (key.equals(IConfigInfo.PROPERTIES_LISTENER_MATRIX_HOST)) {
          this.configInfo.setLocalPropertiesHost(key);
          this.configInfo.setLocalListenerHost(value);
        }

        if (key.equals(IConfigInfo.PROPERTIES_LISTENER_MATRIX_PORT)) {
          this.configInfo.setLocalPropertiesPort(key);
          this.configInfo.setLocalListenerPort(value);
        }

        if (key.equals(IConfigInfo.PROPERTIES_LISTENER_MATRIX_SERVICENAME)) {
          this.configInfo.setLocalPropertiesServiceName(key);
          this.configInfo.setLocalServiceName(value);
        }

        if (key.equals(IConfigInfo.PROPERTIES_LISTENER_TEST_HOST)) {
          this.configInfo.setLocalPropertiesHost(key);
          this.configInfo.setLocalListenerHost(value);
        }

        if (key.equals(IConfigInfo.PROPERTIES_LISTENER_TEST_PORT)) {
          this.configInfo.setLocalPropertiesPort(key);
          this.configInfo.setLocalListenerPort(value);
        }

        if (key.equals(IConfigInfo.PROPERTIES_LISTENER_TEST_SERVICENAME)) {
          this.configInfo.setLocalPropertiesServiceName(key);
          this.configInfo.setLocalServiceName(value);
        }

        if (key.equals(IConfigInfo.PROPERTIES_LISTENER_SIMULATOR_HOST)) {
          this.configInfo.setLocalPropertiesHost(key);
          this.configInfo.setLocalListenerHost(value);
        }

        if (key.equals(IConfigInfo.PROPERTIES_LISTENER_SIMULATOR_PORT)) {
          this.configInfo.setLocalPropertiesPort(key);
          this.configInfo.setLocalListenerPort(value);
        }

        if (key.equals(IConfigInfo.PROPERTIES_LISTENER_SIMULATOR_SERVICENAME)) {
          this.configInfo.setLocalPropertiesServiceName(key);
          this.configInfo.setLocalServiceName(value);
        }

        if (key.equals(IConfigInfo.PROPERTIES_LISTENER_ADMINISTRATOR_HOST)) {
          this.configInfo.setLocalPropertiesHost(key);
          this.configInfo.setLocalListenerHost(value);
        }

        if (key.equals(IConfigInfo.PROPERTIES_LISTENER_ADMINISTRATOR_PORT)) {
          this.configInfo.setLocalPropertiesPort(key);
          this.configInfo.setLocalListenerPort(value);
        }

        if (key.equals(IConfigInfo.PROPERTIES_LISTENER_ADMINISTRATOR_SERVICENAME)) {
          this.configInfo.setLocalPropertiesServiceName(key);
          this.configInfo.setLocalServiceName(value);
        }

        if (key.equals(IConfigInfo.PROPERTIES_LISTENER_MAINTENANCE_HOST)) {
          this.configInfo.setLocalPropertiesHost(key);
          this.configInfo.setLocalListenerHost(value);
        }

        if (key.equals(IConfigInfo.PROPERTIES_LISTENER_MAINTENANCE_PORT)) {
          this.configInfo.setLocalPropertiesPort(key);
          this.configInfo.setLocalListenerPort(value);
        }

        if (key.equals(IConfigInfo.PROPERTIES_LISTENER_MAINTENANCE_SERVICENAME)) {
          this.configInfo.setLocalPropertiesServiceName(key);
          this.configInfo.setLocalServiceName(value);
        }

      }

      //Remote Listener
      Map<String, String> hostPortServiceName = new HashMap<String, String>();

      String key = "";
      String value = "";
      for (int index = 0; index < this.properties.size(); index++) {

        if (this.properties.containsKey(IConfigInfo.PROPERTIES_LISTENER_TFSCALCULATOR_HOST + "." + index)) {
          key = IConfigInfo.PROPERTIES_LISTENER_TFSCALCULATOR_HOST + "." + index;
          value = this.properties.getProperty(IConfigInfo.PROPERTIES_LISTENER_TFSCALCULATOR_HOST + "." + index);

          hostPortServiceName.put(key, value);
        }

        if (this.properties.containsKey(IConfigInfo.PROPERTIES_LISTENER_TFSCALCULATOR_PORT + "." + index)) {
          key = IConfigInfo.PROPERTIES_LISTENER_TFSCALCULATOR_PORT + "." + index;
          value = this.properties.getProperty(IConfigInfo.PROPERTIES_LISTENER_TFSCALCULATOR_PORT + "." + index);
          hostPortServiceName.put(key, value);
        }

        if (this.properties.containsKey(IConfigInfo.PROPERTIES_LISTENER_TFSCALCULATOR_SERVICENAME + "." + index)) {
          key = IConfigInfo.PROPERTIES_LISTENER_TFSCALCULATOR_SERVICENAME + "." + index;
          value = this.properties.getProperty(IConfigInfo.PROPERTIES_LISTENER_TFSCALCULATOR_SERVICENAME + "." + index);
          hostPortServiceName.put(key, value);
        }

        if (this.properties.containsKey(IConfigInfo.PROPERTIES_LISTENER_CALCULATORONLINE_HOST + "." + index)) {
          key = IConfigInfo.PROPERTIES_LISTENER_CALCULATORONLINE_HOST + "." + index;
          value = this.properties.getProperty(IConfigInfo.PROPERTIES_LISTENER_CALCULATORONLINE_HOST + "." + index);
          hostPortServiceName.put(key, value);
        }

        if (this.properties.containsKey(IConfigInfo.PROPERTIES_LISTENER_CALCULATORONLINE_PORT + "." + index)) {
          key = IConfigInfo.PROPERTIES_LISTENER_CALCULATORONLINE_PORT + "." + index;
          value = this.properties.getProperty(IConfigInfo.PROPERTIES_LISTENER_CALCULATORONLINE_PORT + "." + index);
          hostPortServiceName.put(key, value);
        }

        if (this.properties.containsKey(IConfigInfo.PROPERTIES_LISTENER_CALCULATORONLINE_SERVICENAME + "." + index)) {
          key = IConfigInfo.PROPERTIES_LISTENER_CALCULATORONLINE_SERVICENAME + "." + index;
          value =
              this.properties.getProperty(IConfigInfo.PROPERTIES_LISTENER_CALCULATORONLINE_SERVICENAME + "." + index);
          hostPortServiceName.put(key, value);
        }

        if (this.properties.containsKey(IConfigInfo.PROPERTIES_LISTENER_NETTING_HOST + "." + index)) {
          key = IConfigInfo.PROPERTIES_LISTENER_NETTING_HOST + "." + index;
          value = this.properties.getProperty(IConfigInfo.PROPERTIES_LISTENER_NETTING_HOST + "." + index);
          hostPortServiceName.put(key, value);
        }

        if (this.properties.containsKey(IConfigInfo.PROPERTIES_LISTENER_NETTING_PORT + "." + index)) {
          key = IConfigInfo.PROPERTIES_LISTENER_NETTING_PORT + "." + index;
          value = this.properties.getProperty(IConfigInfo.PROPERTIES_LISTENER_NETTING_PORT + "." + index);
          hostPortServiceName.put(key, value);
        }

        if (this.properties.containsKey(IConfigInfo.PROPERTIES_LISTENER_NETTING_SERVICENAME + "." + index)) {
          key = IConfigInfo.PROPERTIES_LISTENER_NETTING_SERVICENAME + "." + index;
          value = this.properties.getProperty(IConfigInfo.PROPERTIES_LISTENER_NETTING_SERVICENAME + "." + index);
          hostPortServiceName.put(key, value);
        }

        if (this.properties.containsKey(IConfigInfo.PROPERTIES_LISTENER_MATRIX_HOST + "." + index)) {
          key = IConfigInfo.PROPERTIES_LISTENER_MATRIX_HOST + "." + index;
          value = this.properties.getProperty(IConfigInfo.PROPERTIES_LISTENER_MATRIX_HOST + "." + index);
          hostPortServiceName.put(key, value);
        }

        if (this.properties.containsKey(IConfigInfo.PROPERTIES_LISTENER_MATRIX_PORT + "." + index)) {
          key = IConfigInfo.PROPERTIES_LISTENER_MATRIX_PORT + "." + index;
          value = this.properties.getProperty(IConfigInfo.PROPERTIES_LISTENER_MATRIX_PORT + "." + index);
          hostPortServiceName.put(key, value);
        }

        if (this.properties.containsKey(IConfigInfo.PROPERTIES_LISTENER_MATRIX_SERVICENAME + "." + index)) {
          key = IConfigInfo.PROPERTIES_LISTENER_MATRIX_SERVICENAME + "." + index;
          value = this.properties.getProperty(IConfigInfo.PROPERTIES_LISTENER_MATRIX_SERVICENAME + "." + index);
          hostPortServiceName.put(key, value);
        }

        if (this.properties.containsKey(IConfigInfo.PROPERTIES_LISTENER_TEST_HOST + "." + index)) {
          key = IConfigInfo.PROPERTIES_LISTENER_TEST_HOST + "." + index;
          value = this.properties.getProperty(IConfigInfo.PROPERTIES_LISTENER_TEST_HOST + "." + index);
          hostPortServiceName.put(key, value);
        }

        if (this.properties.containsKey(IConfigInfo.PROPERTIES_LISTENER_TEST_PORT + "." + index)) {
          key = IConfigInfo.PROPERTIES_LISTENER_TEST_PORT + "." + index;
          value = this.properties.getProperty(IConfigInfo.PROPERTIES_LISTENER_TEST_PORT + "." + index);
          hostPortServiceName.put(key, value);
        }

        if (this.properties.containsKey(IConfigInfo.PROPERTIES_LISTENER_TEST_SERVICENAME + "." + index)) {
          key = IConfigInfo.PROPERTIES_LISTENER_TEST_SERVICENAME + "." + index;
          value = this.properties.getProperty(IConfigInfo.PROPERTIES_LISTENER_TEST_SERVICENAME + "." + index);
          hostPortServiceName.put(key, value);
        }

        if (this.properties.containsKey(IConfigInfo.PROPERTIES_LISTENER_SIMULATOR_HOST + "." + index)) {
          key = IConfigInfo.PROPERTIES_LISTENER_SIMULATOR_HOST + "." + index;
          value = this.properties.getProperty(IConfigInfo.PROPERTIES_LISTENER_SIMULATOR_HOST + "." + index);
          hostPortServiceName.put(key, value);
        }

        if (this.properties.containsKey(IConfigInfo.PROPERTIES_LISTENER_SIMULATOR_PORT + "." + index)) {
          key = IConfigInfo.PROPERTIES_LISTENER_SIMULATOR_PORT + "." + index;
          value = this.properties.getProperty(IConfigInfo.PROPERTIES_LISTENER_SIMULATOR_PORT + "." + index);
          hostPortServiceName.put(key, value);
        }

        if (this.properties.containsKey(IConfigInfo.PROPERTIES_LISTENER_SIMULATOR_SERVICENAME + "." + index)) {
          key = IConfigInfo.PROPERTIES_LISTENER_SIMULATOR_SERVICENAME + "." + index;
          value = this.properties.getProperty(IConfigInfo.PROPERTIES_LISTENER_SIMULATOR_SERVICENAME + "." + index);
          hostPortServiceName.put(key, value);
        }

        if (this.properties.containsKey(IConfigInfo.PROPERTIES_LISTENER_ADMINISTRATOR_HOST + "." + index)) {
          key = IConfigInfo.PROPERTIES_LISTENER_ADMINISTRATOR_HOST + "." + index;
          value = this.properties.getProperty(IConfigInfo.PROPERTIES_LISTENER_ADMINISTRATOR_HOST + "." + index);
          hostPortServiceName.put(key, value);
        }

        if (this.properties.containsKey(IConfigInfo.PROPERTIES_LISTENER_ADMINISTRATOR_PORT + "." + index)) {
          key = IConfigInfo.PROPERTIES_LISTENER_ADMINISTRATOR_PORT + "." + index;
          value = this.properties.getProperty(IConfigInfo.PROPERTIES_LISTENER_ADMINISTRATOR_PORT + "." + index);
          hostPortServiceName.put(key, value);
        }

        if (this.properties.containsKey(IConfigInfo.PROPERTIES_LISTENER_ADMINISTRATOR_SERVICENAME + "." + index)) {
          key = IConfigInfo.PROPERTIES_LISTENER_ADMINISTRATOR_SERVICENAME + "." + index;
          value = this.properties.getProperty(IConfigInfo.PROPERTIES_LISTENER_ADMINISTRATOR_SERVICENAME + "." + index);
          hostPortServiceName.put(key, value);
        }

        if (this.properties.containsKey(IConfigInfo.PROPERTIES_LISTENER_MAINTENANCE_HOST + "." + index)) {
          key = IConfigInfo.PROPERTIES_LISTENER_MAINTENANCE_HOST + "." + index;
          value = this.properties.getProperty(IConfigInfo.PROPERTIES_LISTENER_MAINTENANCE_HOST + "." + index);
          hostPortServiceName.put(key, value);
        }

        if (this.properties.containsKey(IConfigInfo.PROPERTIES_LISTENER_MAINTENANCE_PORT + "." + index)) {
          key = IConfigInfo.PROPERTIES_LISTENER_MAINTENANCE_PORT + "." + index;
          value = this.properties.getProperty(IConfigInfo.PROPERTIES_LISTENER_MAINTENANCE_PORT + "." + index);
          hostPortServiceName.put(key, value);
        }

        if (this.properties.containsKey(IConfigInfo.PROPERTIES_LISTENER_MAINTENANCE_SERVICENAME + "." + index)) {
          key = IConfigInfo.PROPERTIES_LISTENER_MAINTENANCE_SERVICENAME + "." + index;
          value = this.properties.getProperty(IConfigInfo.PROPERTIES_LISTENER_MAINTENANCE_SERVICENAME + "." + index);
          hostPortServiceName.put(key, value);
        }

      }

      this.configInfo.setRemoteHostPortServiceMap(hostPortServiceName);

    } catch (IOException e) {
      log.error("ERROR: AbstractConfigManager.load(): " + e);
    }

    return this.configInfo;

  }

  /*
   * (non-Javadoc)
   * @see br.com.gti.profectusconfig.IConfigManager#getConfigInfo()
   */
  @Override
  public ConfigInfo getConfigInfo() {
    return this.configInfo;
  }
}
