package br.com.gti.profectus.infra.logfile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import br.com.gti.profectus.infra.logfile.constant.LogAction;
import br.com.gti.profectus.infra.logfile.constant.LogModule;
import br.com.gti.profectus.infra.logfile.filter.FileNameFilter;
import br.com.gti.profectus.infra.logfile.logLayout.LogLayout;
import br.com.gti.profectus.tools.dateTime.DateHelper;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * AbstractFileLogService.
 * @author tiago.canatelli
 * @since 25/06/2015
 */
@Slf4j
public abstract class AbstractFileLogService {

    /** Path log file. */
    @Getter
    @Setter
    private String path;

    /** Prefix file log. */
    @Getter
    @Setter
    private String prefix;

    /** file extension. */
    @Getter
    @Setter
    private String extension;

    /**
     * Constructor of class AbstractFileLogService.java.
     */
    public AbstractFileLogService() {
        path = "";
        prefix = "";
        extension = "";
    }

    public void writeLogRegister(LogAction logAction, LogModule logModule, LogLayout logLayout) {

        try {

            logLayout.setLogAction(logAction);
            logLayout.setModule(logModule.getDescription());
            //Date log
            Date logFileDate = new Date();
            //File name log, is defined by date
            String fileName = prefix + "_" + DateHelper.formatDateTime(logFileDate, DateHelper.DATE_YYYY_MM_DD);
            //String file path name
            String filePathName = path + "\\" + fileName + "." + extension;
            log.info("writeLogRegister1 - " + logModule.getDescription() + " - Path file to record: " + filePathName);

            //Get file to Path
            File fileLog = new File(filePathName);

            //Verify file log error exists
            if (!fileLog.exists()) {
                //If not exists, create new empty file
                fileLog.createNewFile();
                //Readable and writable
                fileLog.setReadable(true);
                fileLog.setWritable(true);
            }

            //Append file to write
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileLog, true)));
            //Write file log
            writer.append(logLayout.toString());

            //Close writer
            writer.close();
            log.info("writeLogRegister1 - " + logModule.getDescription() + " - Close writer");

        } catch (Exception e) {
            log.error("Error to write new register in log file error: ", e);
        }
    }

    public void writeLogRegister(LogAction logAction, LogModule logModule, String msg) {

        try {

            LogLayout logLayout = new LogLayout();
            logLayout.setLogAction(logAction);
            logLayout.setDescription(msg);
            logLayout.setModule(logModule.getDescription());
            //Date log
            Date logFileDate = new Date();
            //File name log, is defined by date
            String fileName = prefix + "_" + DateHelper.formatDateTime(logFileDate, DateHelper.DATE_YYYY_MM_DD);
            //String file path name
            String filePathName = path + "\\" + fileName + "." + extension;
            log.info("writeLogRegister2 - " + logModule.getDescription() + " - Path file to record: " + filePathName);

            //Get file to Path
            File fileLog = new File(filePathName);

            //Verify file log error exists
            if (!fileLog.exists()) {
                //If not exists, create new empty file
                fileLog.createNewFile();
                //Readable and writable
                fileLog.setReadable(true);
                fileLog.setWritable(true);
            }

            //Append file to write
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileLog, true)));

            //Write file log
            writer.append(logLayout.toString());

            //Close writer
            writer.close();
            log.info("writeLogRegister2 - " + logModule.getDescription() + " - Close writer");

        } catch (Exception e) {
            log.error("Error to write new register in log file error: ", e);
        }
    }

    /**
     * List files in log error directory.
     * @author tiago.canatelli
     * @since 25/06/2015
     * @return
     */
    public List<String> listFilesInLogDirectory() {

        //Array to store files name found in directory
        List<String> listFiles = null;

        try {

            //Get file to Path
            File pathFile = new File(path);

            //Verify file log error exists
            if (pathFile.exists()) {
                //List files contains in directory
                String[] files = pathFile.list();
                if (files != null && files.length > 0) {
                    listFiles = new ArrayList<String>(Arrays.asList(files));
                }
            }

        } catch (Exception e) {
            log.error("ERROR: AbstractFileLogService.listFilesInLogDirectory");
        }

        return listFiles;
    }

    /**
     * List files name in log error directory.
     * @author tiago.canatelli
     * @since 25/06/2015
     * @return
     */
    public List<String> listFilesNameInLogDirectory(String filter) {

        //Array to store files name found in directory
        List<String> listFiles = null;

        try {

            //Get file to Path
            File pathFile = new File(path);

            //Verify file log error exists
            if (pathFile.exists()) {
                //List files contains in directory
                String[] files = pathFile.list(new FileNameFilter(filter));
                if (files != null && files.length > 0) {
                    listFiles = new ArrayList<String>(Arrays.asList(files));
                }
            }

        } catch (Exception e) {
            log.error("ERROR: AbstractFileLogService.listFilesInLogDirectory");
        }

        return listFiles;
    }

    /**
     * List files in log error directory.
     * @author tiago.canatelli
     * @since 25/06/2015
     * @return
     */
    public List<File> listFilesInLogDirectory(String filter) {

        //Array to store files name found in directory
        List<File> listFiles = null;

        try {

            //Get file to Path
            File pathFile = new File(path);

            //Verify file log error exists
            if (pathFile.exists()) {
                //List files contains in directory
                File[] files = pathFile.listFiles(new FileNameFilter(filter));
                if (files != null && files.length > 0) {
                    listFiles = new ArrayList<File>(Arrays.asList(files));
                }
            }

        } catch (Exception e) {
            log.error("ERROR: AbstractFileLogService.listFilesInLogDirectory");
        }

        return listFiles;
    }
}
