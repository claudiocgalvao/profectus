package br.com.gti.profectus.business.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

import lombok.extern.log4j.Log4j2;

/**
 * Helper class to Exception.
 * @author tiago.canatelli
 */
@Log4j2
public final class ExceptionHelper {

    private ExceptionHelper() {
    }

    private static final Integer QTDE_MAX = 512;

    /**
     * Get error code.
     * @param ex
     * @return
     */
    public static String getErrorCode(Throwable ex) {
        if (ex instanceof BaseException) {
            return ((BaseException) ex).getCodigo();
        } else {
            return "";
        }
    }

    /**
     * Inform the method description.
     * @paInform the method description* @return
     */
    public static String getErrorTrace(Throwable ex) {
        String trace = null;
        if (ex != null) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            trace = sw.toString();
        } else {
            trace = "-";
        }
        return trace;
    }

    /**
     * Get Fault Info.
     * @param ex
     * @return
     */
    public static String getFaultInfo(Throwable ex) {
        if (ex instanceof BaseException) {
            return ((BaseException) ex).getDetail();
        } else {
            try {
                Method methodGetFaultInfo = ex.getClass().getMethod("getFaultInfo", new Class[] {});
                if (methodGetFaultInfo != null) { // verifica se a excecao e uma FaultException (mensagem de servico)
                    Object faultInfo = methodGetFaultInfo.invoke(ex, new Object[] {});
                    if (faultInfo != null) {
                        Method methodGetHost = faultInfo.getClass().getMethod("getHost", new Class[] {});
                        Method methodGetTimestamp = faultInfo.getClass().getMethod("getTimestamp", new Class[] {});
                        Method methodGetCodigo = faultInfo.getClass().getMethod("getCodigo", new Class[] {});
                        Method methodGetInstrucao = faultInfo.getClass().getMethod("getInstrucao", new Class[] {});
                        Method methodGetDetalhe = faultInfo.getClass().getMethod("getDetalhe", new Class[] {});
                        String host = (String) methodGetHost.invoke(faultInfo, new Object[] {});
                        String timeStr = (String) methodGetTimestamp.invoke(faultInfo, new Object[] {});
                        String codigo = (String) methodGetCodigo.invoke(faultInfo, new Object[] {});
                        String instrucao = (String) methodGetInstrucao.invoke(faultInfo, new Object[] {});
                        String detalhe = (String) methodGetDetalhe.invoke(faultInfo, new Object[] {});
                        StringBuilder text = new StringBuilder(QTDE_MAX);
                        text.append("Host: ");
                        text.append(host);
                        text.append("\nTimestamp: ");
                        text.append(timeStr);
                        text.append("\nError Code: ");
                        text.append(codigo);
                        text.append("\nError Message: ");
                        text.append(ex.getMessage());
                        text.append("\nError Intruction: ");
                        text.append(instrucao);
                        text.append("\nError Detail: ");
                        text.append(detalhe);
                        return text.toString();
                    }
                }
            } catch (Exception e) {
                log.error(e.getLocalizedMessage(), e);
            }
        }
        return null;
    }
}
