package br.com.gti.profectus.business.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

/**
 * Class error factory.
 * @author tiago.canatelli
 */
@Slf4j
public final class ErrorFactory {

    private static ErrorFactory instance = new ErrorFactory();

    private String hostname;

    private static final Integer QTDE_MAX = 512;

    public static ErrorFactory getInstance() {
        return instance;
    }

    /**
     * Constructor.
     */
    private ErrorFactory() {
    }

    /**
     * Create error by fault message error.
     * @param ex
     * @return
     */
    private ErrorBean createErrorByFaultMsg(Throwable ex) {
        ErrorBean error = null;
        try {
            Method methodGetCodigo = null;
            Method methodGetDetalhe = null;
            Method methodGetFaultInfo = ex.getClass().getMethod("getFaultInfo", new Class[]{});
            if (methodGetFaultInfo != null) { // verifica se a excecao for uma FaultException (mensagem de servico)
                Object faultInfo = methodGetFaultInfo.invoke(ex, new Object[]{});
                if (faultInfo != null) {
                    Method methodGetHost = faultInfo.getClass().getMethod("getHost", new Class[]{});
                    Method methodGetTimestamp = faultInfo.getClass().getMethod("getTimestamp", new Class[]{});
                    methodGetCodigo = faultInfo.getClass().getMethod("getCodigo", new Class[]{});
                    methodGetDetalhe = faultInfo.getClass().getMethod("getDetalhe", new Class[]{});
                    error = new ErrorBean();
                    error.setHost((String) methodGetHost.invoke(faultInfo, new Object[]{}));
                    @SuppressWarnings("unused")
                    String timeStr = (String) methodGetTimestamp.invoke(faultInfo, new Object[]{});
                    //Date timestamp = DateUtil.parse(timeStr, "EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                    error.setTimestamp(new Date());
                    String codigo = (String) methodGetCodigo.invoke(faultInfo, new Object[]{});
                    String detalhe = (String) methodGetDetalhe.invoke(faultInfo, new Object[]{});
                    error.setMessage(ex.getMessage());
                    error.setCode(codigo);
                    StringBuilder detail = new StringBuilder(QTDE_MAX);
                    detail.append("===========================================================\n");
                    detail.append("Detalhe da Camada de Servico:\n");
                    detail.append("Exception:\n" + detalhe);
                    detail.append("===========================================================\n");
                    error.setTrace(detail.toString());
                }
            }
        } catch (Exception e) {
            log.error("Error:", e);
        }
        return error;
    }

    /**
     * Create error by base exception.
     * @param ex
     * @return
     */
    public ErrorBean createErrorByBaseException(BaseException ex) {
        ErrorBean error = null;
        try {
            String codigo = (String) ex.getCodigo();
            String detalhe = (String) ex.getDetail();
            error = new ErrorBean();
            error.setHost(getHostname());
            error.setTimestamp(getTimestamp());
            error.setCode(codigo);
            error.setMessage(ex.getMessage());
            StringBuffer detail = new StringBuffer(QTDE_MAX);
            detail.append("===========================================================\n");
            detail.append("Detalhe Camada Apresentacao:\n");
            detail.append(getStackTrace(ex));
            detail.append("===========================================================\n");
            if (detalhe != null && detalhe.trim().length() > 0) {
                detail.append("Detalhe Camada Servico:\n");
                detail.append(detalhe);
                detail.append("===========================================================\n");
            }
            error.setTrace(detail.toString());
        } catch (Exception e) {
            log.error("Error:", e);
        }
        return error;
    }

    /**
     * Create error.
     * @param ex
     * @return
     */
    public ErrorBean createError(Throwable ex) {
        ErrorBean error = null;
        // verifica a necessidade de criar o tratamento para o erro...
        if (ex != null) {
            if (ex instanceof BaseException) {
                error = createErrorByBaseException((BaseException) ex);
            } else {
                error = createErrorByFaultMsg(ex);
                if (error == null) {
                    error = createErrorByException(ex);
                }
            }
        }
        return error;
    }

    /**
     * Create error by exception.
     * @param ex
     * @return
     */
    private ErrorBean createErrorByException(Throwable ex) {
        ErrorBean error = new ErrorBean();
        String codigo = "-";
        error = new ErrorBean();
        error.setHost(getHostname());
        error.setTimestamp(getTimestamp());
        error.setCode(codigo);
        error.setMessage(ex.getMessage());
        StringBuffer detail = new StringBuffer(QTDE_MAX);
        detail.append("===========================================================\n");
        detail.append("Detalhe Camada Apresentacao:\n");
        detail.append(getStackTrace(ex));
        detail.append("===========================================================\n");
        error.setTrace(detail.toString());
        return error;
    }

    /**
     * Get host name.
     * @return
     */
    protected String getHostname() {
        String host = getLocalHostname();
        String server = System.getProperty("server.name");
        if (server != null) {
            host = server + "@" + host;
        }
        String port = System.getProperty("server.port");
        if (port != null) {
            host += ":" + port;
        }
        return host;
    }

    /**
     * get local host name.
     * @return
     */
    protected String getLocalHostname() {
        if (hostname == null) {
            try {
                hostname = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException ex) {
                ex.printStackTrace();
                return "unknow";
            }
        }
        return hostname;
    }

    /**
     * Get timestamp.
     * @return
     */
    protected Date getTimestamp() {
        return Calendar.getInstance().getTime();
    }

    /**
     * Return stack trace.
     * @param ex
     * @return
     */
    public String getStackTrace(Throwable ex) {
        String trace = null;
        if (ex instanceof BaseException) {
            StringWriter sw = new StringWriter();
            ((BaseException) ex).printStackTraceWithoutDetail(new PrintWriter(sw));
            trace = sw.toString();
        } else {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            trace = sw.toString();
        }
        return trace;
    }
}
