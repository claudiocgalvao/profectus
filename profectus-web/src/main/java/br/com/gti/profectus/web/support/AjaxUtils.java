package br.com.gti.profectus.web.support;

/**
 * AjaxUtils.
 */
public final class AjaxUtils {

    private AjaxUtils() {
    }

    /**
     * isAjaxRequest.
     * @param requestedWith
     * @return
     */
    public static boolean isAjaxRequest(String requestedWith) {
        return requestedWith != null ? "XMLHttpRequest".equals(requestedWith) : false;
    }
}
