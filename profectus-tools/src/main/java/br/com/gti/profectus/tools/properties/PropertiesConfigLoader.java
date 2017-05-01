package br.com.gti.profectus.tools.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Classe utilitaria para carregar dados de arquivo de Properties, seja arquivo
 * localizado via o caminho em disco (path/filename), seja via nome de recurso
 * carregado no classloader, ou parametros configurados no banco de dados. <br>
 * Exemplo: <br>
 * <br>
 * Para carregar e obter um objeto Properties do "arquivo.properties", que esta
 * no diretorio "META-INF" do JAR (ou do classpath). <br>
 * <code>Properties prop = PropertiesConfigLoader.loadResource("META-INF/arquivo.properties");</code> <br>
 * <br>
 * Para carregar e obter um objeto Properties do "arquivo.properties", que esta
 * no diretorio "/tmp" do disco. <br>
 * <code>Properties prop = PropertiesConfigLoader.loadFile("/tmp/arquivo.properties");</code> <br>
 * <br>
 * Para carregar e obter um objeto Properties com as propriedades configuradas
 * no banco de dados para o sistema "XYZ". <br>
 * <code>Properties prop = PropertiesConfigLoader.loadBD("XYZ");</code>
 */
public abstract class PropertiesConfigLoader {

    private PropertiesConfigLoader() {
    }

    /**
     * Carrega as configuracoes a partir do nome de um recurso carregado no
     * classloader, que referencia um arquivo em disco (filesystem) ou no pacote
     * (JAR/WAR/EAR). O metodo retorna um objeto java.util.Properties com as
     * configuracoes carregadas.
     * @param resource nome do recurso carregado no classloader.
     * @return objeto Properties com as configuracoes carregadas.
     * @throws IOException caso algum erro ocorra.
     */
    public static Properties loadResource(String resource) throws IOException {
        return loadResource(resource, PropertiesConfigLoader.class.getClassLoader());
    }

    /**
     * Carrega as configuracoes a partir do nome de um recurso que referencia um
     * arquivo em disco (filesystem) ou no pacote (JAR/WAR/EAR) carregado no
     * classloader informado. O metodo retorna um objeto java.util.Properties
     * com as configuracoes carregadas.
     * @param resource nome do recurso carregado no classloader.
     * @param cl ClassLoader onde o recurso vai ser procurado.
     * @return objeto Properties com as configuracoes carregadas.
     * @throws IOException caso algum erro ocorra.
     */
    public static Properties loadResource(String resource, ClassLoader cl) throws IOException {
        InputStream is = null;
        is = cl.getResourceAsStream(resource);
        if (is == null) {
            throw new IOException("Resource not found - stream null");
        }
        try {
            return load(is);
        } finally {
            close(is);
        }
    }

    /**
     * Carrega as configuracoes a partir do caminho (path) de um arquivo
     * em disco (filesystem). O metodo retorna um objeto java.util.Properties
     * com as configuracoes carregadas.
     * @param filename Caminho do arquivo em disco.
     * @return
     * @throws IOException
     */
    public static Properties loadFile(String filename) throws IOException {
        return loadFile(new File(filename));
    }

    /**
     * Carrega as configuracoes a partir de um File que referencia um arquivo
     * em disco (filesystem). O metodo retorna um objeto java.util.Properties
     * com as configuracoes carregadas.
     * @param file referencia para o arquivo em disco.
     * @return objeto Properties com as configuracoes carregadas.
     * @throws IOException caso algum erro ocorra.
     */
    public static Properties loadFile(File file) throws IOException {
        InputStream is = null;
        try {
            is = new FileInputStream(file);
            return load(is);
        } finally {
            close(is);
        }
    }

    /**
     * Carrega as configuracoes a partir de um InputStream. Este metodo NAO
     * fecha o InputStream, que deve ser fechado externamente. O metodo retorna
     * um objeto java.util.Properties com as configuracoes carregadas.
     * @param is InputStream para leitura das configuracoes.
     * @return objeto Properties com as configuracoes carregadas.
     * @throws IOException caso algum erro ocorra.
     */
    public static Properties load(InputStream is) throws IOException {
        Properties prop = new Properties();
        prop.load(is);
        return prop;
    }

    /**
     * Fecha a referencia para um InputStream. Este metodo NAO lanca nenhuma
     * excecao.
     * @param is objeto InputStream.
     */
    private static void close(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (Exception e) {
                // do nothing
            }
        }
    }
}
