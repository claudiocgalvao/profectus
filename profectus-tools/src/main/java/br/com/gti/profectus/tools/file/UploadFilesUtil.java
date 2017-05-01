package br.com.gti.profectus.tools.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class UploadFilesUtil {

    private static final int READING_SIZE = 1024;

    @Getter
    private static Setup setup;

    private UploadFilesUtil() {
    }

    /**
     * Generic method to execute file uploads Use Setup object to set
     * destination path and others configuration.
     * @param filePart
     * @throws IOException
     */
    public static void uploadFile(final MultipartFile filePart) throws IOException {
        final String path = setup.getDestinationPath();
        final String fileName = filePart.getOriginalFilename();
        InputStream fileContent = null;
        try (
             final OutputStream out = new FileOutputStream(new File(path + File.separator + fileName))) {
            fileContent = filePart.getInputStream();
            int read;
            final byte[] bytes = new byte[READING_SIZE];
            while ((read = fileContent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
        } catch (FileNotFoundException fne) {
            throw fne;
        } finally {
            if (fileContent != null) {
                fileContent.close();
            }
        }
    }

    /**
     * Generic method to execute file uploads, changed file name concatenate
     * with internal ID Use Setup object to set destination path and others
     * configuration.
     * @param filePart
     * @throws IOException
     */
    @SuppressWarnings({ "resource", "unused" })
    public static void uploadFile(MultipartFile filePart, Long idInternalSystem) throws IOException {
        final String path = setup.getDestinationPath();
        final String fileName = filePart.getOriginalFilename();
        OutputStream out = null;
        InputStream filecontent = null;
        try {
            Properties props = new Properties();
            FileInputStream in = new FileInputStream(System.getProperty("user.dir") + "\\" + "path.properties");
            props.load(in);
            in.close();
            String pathProp = props.getProperty("path.upload");
            // out = new FileOutputStream(new File("C:\\upload" + File.separator
out =
                    new FileOutputStream(new File(pathProp + File.separator
                            + concatenateFileNameWithInternalCode(fileName, idInternalSystem)));
            filecontent = filePart.getInputStream();
            int read;
            final byte[] bytes = new byte[READING_SIZE];
            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
        } catch (FileNotFoundException fne) {
            throw fne;
        } catch (Exception e) {
            throw e;
        } finally {
            if (out != null) {
                out = null;
            }
            if (filecontent != null) {
                filecontent = null;
            }
        }
    }

    /**
     * Generic method to execute file uploads, changed file name concatenate
     * with internal ID Use Setup object to set destination path and others
     * configuration.
     * @param filePart
     * @throws IOException
     */
    @SuppressWarnings({ "resource", "unused" })
    public static void uploadFile(File filePart, Long idInternalSystem) throws IOException {
        final String path = setup.getDestinationPath();
        final String fileName = filePart.getName();
        OutputStream out = null;
        InputStream filecontent = null;
        FileInputStream fileInputStream = null;
        try {
            Properties props = new Properties();
            FileInputStream in = new FileInputStream(System.getProperty("user.dir") + "\\" + "path.properties");
            props.load(in);
            in.close();
            String pathProp = props.getProperty("path.upload");
            // out = new FileOutputStream(new File("C:\\upload" + File.separator
out =
                    new FileOutputStream(new File(pathProp + File.separator
                            + concatenateFileNameWithInternalCode(fileName, idInternalSystem)));
            // filecontent = new filePart.getInputStream();
            fileInputStream = new FileInputStream(filePart);
            int read;
            final byte[] bytes = new byte[READING_SIZE];
            while ((read = fileInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
        } catch (FileNotFoundException fne) {
            throw fne;
        } catch (Exception e) {
            throw e;
        } finally {
            if (out != null) {
                out = null;
            }
            if (filecontent != null) {
                filecontent = null;
            }
        }
    }

    /**
     * Generic method to execute file uploads, changed file name concatenate
     * with internal ID Use Setup object to set destination path and others
     * configuration.
     * @param filePart
     * @throws IOException
     */
    @SuppressWarnings({ "resource", "unused" })
    public static void uploadFile(File filePart, Long idInternalSystem, String fileName) throws IOException {
        final String path = setup.getDestinationPath();
        OutputStream out = null;
        InputStream filecontent = null;
        FileInputStream fileInputStream = null;
        try {
            Properties props = new Properties();
            FileInputStream in = new FileInputStream(System.getProperty("user.dir") + "\\" + "path.properties");
            props.load(in);
            in.close();
            String pathProp = props.getProperty("path.upload");
            // out = new FileOutputStream(new File("C:\\upload" + File.separator
out =
                    new FileOutputStream(new File(pathProp + File.separator
                            + concatenateFileNameWithInternalCode(fileName, idInternalSystem)));
            // filecontent = new filePart.getInputStream();
            fileInputStream = new FileInputStream(filePart);
            int read;
            final byte[] bytes = new byte[READING_SIZE];
            while ((read = fileInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
        } catch (FileNotFoundException fne) {
            throw fne;
        } catch (Exception e) {

            throw e;
        } finally {
            if (out != null) {
                out = null;
            }
            if (filecontent != null) {
                filecontent = null;
            }
        }
    }

    /**
     * Method to return file's extension.
     * @param fileName
     * @return
     */
    public static String getFileExtension(String fileName) {
        String extension = "";
        if (fileName != null && fileName != "") {
            String[] parametrosArquivo = fileName.split("\\.");
            if (parametrosArquivo.length > 0) {
                if (parametrosArquivo.length == 2) {
                    extension = parametrosArquivo[1];
                } else {
                    extension = parametrosArquivo[2];
                }
            }
        }
        return extension;
    }

    /**
     * Method to concatenate the file name + internal code.
     * @param fileName
     * @param idInternalCode
     * @return
     */
    public static String concatenateFileNameWithInternalCode(String fileName, Long idInternalCode) {
        String extension = "";
        String name = "";
        if (fileName != null && fileName != "") {
            String[] parametrosArquivo = fileName.split("\\.");
            if (parametrosArquivo.length > 0) {
                name = parametrosArquivo[0];
                extension = parametrosArquivo[1];
                String nameComplete = name + "_" + idInternalCode + "." + extension;
                return nameComplete;
            }
        }
        return null;
    }

    /**
     * Method to return file's extension.
     * @param fileName
     * @return
     */
    public static String getFileName(String fileName) {
        String name = "";
        if (fileName != null && fileName != "") {
            //"C:\\Users\\tiago.canatelli\\Desktop\\arquivo_teste_tmp_tt3.txt";
            fileName = fileName.replace("\\", "@");
            String[] aFileName = fileName.split("@");
            if (aFileName.length > 1) {
                int lastPos = aFileName.length - 1;
                name = aFileName[lastPos];
            } else {
                name = aFileName[0];
            }
        }
        return name;
    }

    /**
     * getFile.
     * @author claudio.cesar
     * @since 18/12/2015
     * @param path
     * @param fileName
     * @return
     */
    public static File getFile(File path, String fileName) {

        File[] files = path.listFiles();

        for (File file : files) {

            if (fileName.equals(file.getName())) {
                return file;
            }
        }

        return null;
    }

}
