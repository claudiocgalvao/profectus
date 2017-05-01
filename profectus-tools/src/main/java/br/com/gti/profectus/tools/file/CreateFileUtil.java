package br.com.gti.profectus.tools.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * CreateFileUtil.
 */
public final class CreateFileUtil {

    private CreateFileUtil() {
    }

    /**
     * Write the xml directory.
     * @param xml
     * @param path
     * @param fileName
     * @throws IOException
     */
    public static void writeXML(String xml, String path, String fileName) throws IOException {
        StringBuffer pathWithName = new StringBuffer();
        pathWithName.append(path);
        pathWithName.append("/" + fileName);
        File file = new File(pathWithName.toString());
        //File file = new File("C:/Users/claudio.cesar/workspace/Fontes/core/" + pathWithName.toString());
        FileOutputStream gravar;
        gravar = new FileOutputStream(file);
        gravar.write(xml.getBytes());
        gravar.close();
    }
}
