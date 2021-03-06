/*package br.com.gti.profectus.web.error;

import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.core.util.Throwables;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

*//**
 * ErrorController.
 *//*
@Controller
class ErrorController {

    *//**
     * Display an error page, as defined in web.xml <code>custom-error</code> element.
     *//*
    @RequestMapping("generalError")
    public String generalError(HttpServletRequest request, HttpServletResponse response, Model model) {
        // retrieve some useful information from the request
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
        if (servletName == null) {
            servletName = "Unknown";
        }
        String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
        if (requestUri == null) {
            requestUri = "Unknown";
        }
        String exceptionMessage = getExceptionMessage(throwable, statusCode);
        String message = MessageFormat.format("{0} returned for {1} with message {2}", statusCode, requestUri,
                exceptionMessage);
        model.addAttribute("errorMessage", message);
        return "error/general";
    }

    *//**
     * getExceptionMessage.
     * @param throwable
     * @param statusCode
     * @return
     *//*
    private static String getExceptionMessage(Throwable throwable, Integer statusCode) {
        if (throwable != null) {
            return Throwables.getRootCause(throwable).getMessage();
        }
        HttpStatus httpStatus = HttpStatus.valueOf(statusCode);
        return httpStatus.getReasonPhrase();
    }
}
*/