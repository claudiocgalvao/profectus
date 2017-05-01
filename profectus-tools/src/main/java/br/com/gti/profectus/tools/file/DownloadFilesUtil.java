package br.com.gti.profectus.tools.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Util class to utilize for file download.
 * @author tiago.canatelli
 */
public final class DownloadFilesUtil {

    private DownloadFilesUtil() {
    }

    /**
     * Generic method to use to download Files. This return a FilesDTO object (contains the bytes of archive, file name
     * and others).
     * @param setup
     * @param fileName
     * @return
     * @throws IOException
     */
    public static FilesObject downloadFile(final Setup setup, final String fileName) throws IOException {
        FilesObject fileToDownload = new FilesObject();
        // Get Origin File Path
        final String pathOrigin = setup.getDestinationPath();
        try {
            // Create nio.path to get file bytes
            Path path = Paths.get(pathOrigin + "\\" + fileName);
            byte[] data = Files.readAllBytes(path);
            fileToDownload.setFilename(fileName);
            fileToDownload.setFile(data);
            fileToDownload.setType("txt");
            return fileToDownload;
        } catch (FileNotFoundException fne) {
            throw fne;
        }
    }
}
