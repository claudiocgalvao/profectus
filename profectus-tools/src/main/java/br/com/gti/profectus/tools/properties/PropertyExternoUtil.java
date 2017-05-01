package br.com.gti.profectus.tools.properties;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import br.com.gti.profectus.tools.string.StringHelper;
import br.com.gti.profectus.tools.variable.VariableUtil;

/**
 * Classe utilitaria para recuperacao de properties de arquivos externos.
 */
public final class PropertyExternoUtil {

    private PropertyExternoUtil() {
    }

    /**
     * Metodo responsavel por obter uma configuracao de Web Service.
     * @param recursoExterno - Nome do property para o recurso externo a aplica��o, property presente no arquivo
     * externo.
     * @param recursoInterno - Nome do property presente no arquivo interno que informa o arquivo externo.
     * @param arquivoRecursoInterno - Nome do arquivo interno.
     * @return Configuracaos
     */
    public static
            String getPropertyExterno(String recursoExterno, String recursoInterno, String arquivoRecursoInterno) {
        if (StringHelper.isEmpty(recursoExterno) || StringHelper.isEmpty(recursoInterno)
                || StringHelper.isEmpty(arquivoRecursoInterno)) {
            throw new RuntimeException("Parametrizacao Invalida.");
        }
        Properties properties;
        try {
            String arquivoConfiguracoes =
                    PropertiesConfigLoader.loadResource(arquivoRecursoInterno).getProperty(recursoInterno);
            String dirApp = System.getProperty("dir.app", "/app");
            arquivoConfiguracoes = VariableUtil.replaceVariable(arquivoConfiguracoes, "dir.app", dirApp);
            File arquivoConfiguracoesFile = new File(padronizarBarrasDiretorio(arquivoConfiguracoes));
            if (!arquivoConfiguracoesFile.exists()) {
                throw new RuntimeException("Arquivo nao encontrado[" + arquivoConfiguracoes + "]");
            }
            properties = PropertiesConfigLoader.loadFile(arquivoConfiguracoesFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(recursoExterno);
    }

    /**
     * Metodo responsavel por padronizar os
     * caracteres de separaxao de diretorios de acordo com o SO.
     * @param diretorio - Diretorio
     * @return Diretorio con separadores alterados
     */
    private static
            String padronizarBarrasDiretorio(String diretorio) {
        if (diretorio != null) {
            diretorio = diretorio.replace("//", File.separator);
            diretorio = diretorio.replace("/", File.separator);
            diretorio = diretorio.replace("\\", File.separator);
        }
        return diretorio;
    }
}
