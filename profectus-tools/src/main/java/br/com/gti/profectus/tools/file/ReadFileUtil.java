package br.com.gti.profectus.tools.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;

import lombok.extern.log4j.Log4j2;

import org.springframework.web.multipart.MultipartFile;

/**
 * Helper to read file.
 */
@Log4j2
public final class ReadFileUtil {

    /**
     * PROPERTIES_PATH_UPLOAD.
     * /opt/middleware/feetax/appdata/tax/simulation/path_upload.properties
     */
    public static final String PROPERTIES_PATH_UPLOAD =
            "/opt/middleware/feetax/appdata/tax/simulation/path_upload.properties";

    /**
     * PROPERTIES_KEY_UPLOAD.
     * path.upload
     */
    public static final String PROPERTIES_KEY_UPLOAD = "path.upload";

    /**
     * PATH_MATRIX_LOG.
     * /opt/middleware/feetax/appdata/tax/operationmatrix/log
     */
    public static final String PATH_MATRIX_LOG = "/opt/middleware/feetax/appdata/tax/operationmatrix/log";

    /**
     * Constructor of class ReadFileUtil.java.
     */
    private ReadFileUtil() {
        super();
    }

    /**
     * Util method to create temp file to convert to java.io.File.
     * @param multipart
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    public static File multipartToFile(final MultipartFile multipart) throws IllegalStateException, IOException {
        File tmpFile =
                File.createTempFile("tempFile_" + multipart.getOriginalFilename() + new Date().getTime(), ".tmp", null);
        multipart.transferTo(tmpFile);

        return tmpFile;
    }

    /**
     * Method to create temp file.
     * @param byteArray
     * @param fileName
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    public static File byteToTmpFile(byte[] byteArray, String fileName) throws IllegalStateException, IOException {
        File tempFile = File.createTempFile("tempFile_" + fileName + new Date().getTime(), ".tmp", null);
        FileOutputStream fos = new FileOutputStream(tempFile);
        fos.write(byteArray);
        fos.close();

        return tempFile;
    }

    /**
     * Busca uma determinada propriedade.
     * @param property
     * @return
     */
    public static String getPathPropertiesFile(String property) {
        String propertyValue = null;

        try {
            Properties props = new Properties();

            InputStream inputStream = (new ReadFileUtil()).getClass().getResourceAsStream("/path.properties");

            props.load(inputStream);

            propertyValue = props.getProperty(property);

            inputStream.close();
        } catch (Exception e) {
            return null;
        }

        return propertyValue;
    }

    /**
     * getPropertiesValue.
     * @author claudio.cesar
     * @since 27/08/2015
     * @param pathProperties
     * @return
     */
    public static String getPropertiesValue(String pathProperties, String keyProperties) {

        String returnvalue = "";

        try {

            Properties properties = new Properties();

            InputStream input;

            input = new FileInputStream(pathProperties);

            properties.load(input);

            Iterator entries = properties.entrySet().iterator();

            while (entries.hasNext()) {

                Entry<String, String> thisEntry = (Entry) entries.next();

                String key = thisEntry.getKey();
                String value = thisEntry.getValue();

                if (key.equals(keyProperties)) {
                    returnvalue = value;
                    break;
                }

            }

        } catch (IOException e) {
            log.error(e.getLocalizedMessage(), e);

        }

        return returnvalue;

    }

}
