package br.com.gti.profectus.infra.network.rmi.config;

/**
 * IConfigManager.
 * @author eduardo.fsantos
 * @since 28/05/2015
 */
public interface IConfigManager {

    public void save(String pathFile, ConfigInfo configInfo);

    public ConfigInfo load(String pathFile, String fileConfigProperties);

    public ConfigInfo getConfigInfo();
}
