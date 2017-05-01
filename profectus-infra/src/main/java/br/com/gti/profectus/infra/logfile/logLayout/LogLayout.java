package br.com.gti.profectus.infra.logfile.logLayout;

import java.io.Serializable;
import java.util.Date;

import br.com.gti.profectus.infra.logfile.constant.LogAction;
import br.com.gti.profectus.tools.dateTime.DateHelper;

/**
 * LogLayout.
 * @author tiago.canatelli
 * @since 25/06/2015
 */
public class LogLayout implements Serializable {

    /**
     * default serial version id.
     */
    private static final long serialVersionUID = 1L;

    /** DateTime log. */
    private String dateTime;

    /** Module log. */
    private String module;

    /** Functionality log. */
    private String functionality;

    /** message type (RMI/MQ). */
    private String messageType;

    /** MesageID log (is an legacy MQ message ID or RMI message ID). */
    private String messageID;

    private String messageName;

    /** origin of message. */
    private String origin;

    /** Error Descriptor log. */
    private String description;

    private int line;

    private int column;

    public static String XML = "XML";

    public static String FILE = "FILE";

    private LogAction logAction;

    /**
     * Constructor of class LogLayout.java.
     */
    public LogLayout() {
        line = 0;
        column = 0;
        messageType = null;
        dateTime = DateHelper.formatDateTime(new Date(), DateHelper.DATETIME_YYYY_MM_DD_HH_MM_SS);
    }

    @Override
    public String toString() {
        StringBuilder sbLog = new StringBuilder();
        sbLog.append("Module:").append(module);
        sbLog.append(" - ");
        sbLog.append(dateTime);
        sbLog.append(" ");
        sbLog.append(logAction.getDescription());
        if (messageType != null && messageType.equals(FILE)) {
            if (LogAction.ERROR.equals(logAction)) {
                sbLog.append(" ").append("L").append(line);
                if (column != 0) {
                    sbLog.append(" ").append("C").append(column);
                }
            } else {
                sbLog.append(" ").append("L").append(line);
            }
        }
        sbLog.append(" ").append(description);
        //sbLog.append(" ").append("Message:").append(messageName);
        sbLog.append(" ").append("Type: ").append(messageType);
        //sbLog.append(" ").append(messageID);
        sbLog.append("\n");
        return sbLog.toString();
    }

    /**
     * @return the dateTime
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     * @param dateTime the dateTime to set
     */
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * @return the module
     */
    public String getModule() {
        return module;
    }

    /**
     * @param module the module to set
     */
    public void setModule(String module) {
        this.module = module;
    }

    /**
     * @return the functionality
     */
    public String getFunctionality() {
        return functionality;
    }

    /**
     * @param functionality the functionality to set
     */
    public void setFunctionality(String functionality) {
        this.functionality = functionality;
    }

    /**
     * @return the messageType
     */
    public String getMessageType() {
        return messageType;
    }

    /**
     * @param messageType the messageType to set
     */
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    /**
     * @return the messageID
     */
    public String getMessageID() {
        return messageID;
    }

    /**
     * @param messageID the messageID to set
     */
    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    /**
     * @return the origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * @param origin the origin to set
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * @return the errorDescriptor
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String descriptor) {
        description = descriptor;
    }

    /**
     * @return the line
     */
    public int getLine() {
        return line;
    }

    /**
     * @param line the line to set
     */
    public void setLine(int line) {
        this.line = line;
    }

    /**
     * @return the column
     */
    public int getColumn() {
        return column;
    }

    /**
     * @param column the column to set
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * @return the logAction
     */
    public LogAction getLogAction() {
        return logAction;
    }

    /**
     * @param logAction the logAction to set
     */
    public void setLogAction(LogAction logAction) {
        this.logAction = logAction;
    }

    /**
     * @return the messageName
     */
    public String getMessageName() {
        return messageName;
    }

    /**
     * @param messageName the messageName to set
     */
    public void setMessageName(String messageName) {
        this.messageName = messageName;
    }
}
