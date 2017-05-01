package br.com.gti.profectus.tools.properties;

import java.util.Properties;

/**
 * PropertyUtil.
 * @author claudio.cesar
 * @since 18/11/2014
 */
public class PropertyUtil {

    /**
     * Referencia ao property.
     */
    private Properties prop = null;

    /**
     * Arquivo de property.
     */
    private String propertiesFileName = null;

    /**
     * Construtor.
     * Inicializa o Properties
     * @param propertiesFileName
     * @throws Exception
     */
    public PropertyUtil(String propertiesFileName) throws Exception {
        this.propertiesFileName = propertiesFileName;
        prop = getProperties();
    }

    /**
     * Retorna o properties, inicializado caso nao tenho sido.
     * @return
     * @throws Exception
     */
    public Properties getProperties() throws Exception {
        if (prop == null) {
            ClassLoader cl = PropertyUtil.class.getClassLoader();
            try {
                prop = PropertiesConfigLoader.loadResource("./" + propertiesFileName, cl);
            } catch (Exception e) {
                try {
                    return PropertiesConfigLoader.loadResource("/" + propertiesFileName, cl);
                } catch (Exception e2) {
                    try {
                        return PropertiesConfigLoader.loadResource(propertiesFileName, cl);
                    } catch (Exception e3) {
                        throw new Exception("Arquivo nao encontrado Falha na recuperacao do arquivo["
                                + propertiesFileName + "]", e);
                    }
                }
            }
        }
        return prop;
    }

    /**
     * Retorna uma variavel do property.
     * @param property
     * @return
     */
    public String getProperty(String property) {
        return (String) prop.get(property);
    }
}
