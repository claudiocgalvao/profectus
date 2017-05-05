/*package br.com.gti.profectus.tools.file;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.apache.log4j.Logger;

*//**
 * IOHelper.
 *//*
public final class IOHelper {

    private static final Logger LOGGER = Logger.getLogger(IOHelper.class);

    private IOHelper() {
    }

    *//**
     * Read file to string.
     * @param file
     * @return
     *//*
    public static String readFile(File file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            String content = readStream(fis);
            fis.close();
            return content;
        } catch (IOException e) {
            LOGGER.error(e);
            throw new RuntimeException(e);
        }
    }

    *//**
     * Write file content.
     * @param file
     * @param content
     *//*
    public static void writeFile(File file, String content) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
            writer.write(content);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            LOGGER.error(e);
            throw new RuntimeException(e);
        }
    }

    *//**
     * Read stream to a string.
     * @param is
     * @return
     *//*
    public static String readStream(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
        } catch (IOException e) {
            LOGGER.error(e);
            throw new RuntimeException(e);
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                LOGGER.error(e);
                throw new RuntimeException(e);
            }
        }
        return sb.toString();
    }

    *//**
     * Move file to a boolean.
     * @param sourcePath
     * @param destPath
     * @return
     *//*
    public static boolean moveFile(String sourcePath, String destPath) {
        try {
            File sourceFile = new File(sourcePath);
            return sourceFile.renameTo(new File(destPath));
        } catch (Exception e) {
            LOGGER.error(e);
            throw new RuntimeException(e);
        }
    }

    *//**
     * Read file to bytes.
     * @param file
     * @return
     * @throws IOException
     *//*
    public static byte[] readBytes(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        @SuppressWarnings("resource")
        BufferedInputStream bis = new BufferedInputStream(fis);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int ch;
        while ((ch = bis.read()) != -1) {
            baos.write(ch);
        }
        byte[] bytes = baos.toByteArray();
        baos.close();
        return bytes;
    }

    *//**
     * Read file path to bytes.
     * @param filePath
     * @return
     * @throws IOException
     *//*
    public static byte[] readBytes(String filePath) throws IOException {
        return readBytes(new File(filePath));
    }

    *//**
     * Write bytes in a file.
     * @param bytes
     * @param f
     * @throws IOException
     *//*
    public static void writeBytes(byte[] bytes, File f) throws IOException {
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(bytes);
        fos.flush();
        fos.close();
    }

    *//**
     * Write bytes to a file in a destination path.
     * @param bytes
     * @param destDir
     * @param fileName
     * @throws IOException
     *//*
    public static void writeBytes(byte[] bytes, String destDir, String fileName) throws IOException {
        File f = createFile(destDir, fileName);
        writeBytes(bytes, f);
    }

    *//**
     * Create a file.
     * @param destDir
     * @param fileName
     * @return
     * @throws IOException
     *//*
    public static File createFile(String destDir, String fileName) throws IOException {
        File dir = new File(destDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(destDir + fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    *//**
     * Delete file.
     * @param filePath
     * @return
     *//*
    public static boolean deleteFile(String filePath) {
        try {
            File f = new File(filePath);
            return f.delete();
        } catch (Exception e) {
            LOGGER.error(e);
            throw new RuntimeException(e);
        }
    }
}
*/