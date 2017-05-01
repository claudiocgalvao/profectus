package br.com.gti.profectus.web.error;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Throwables;

/**
 * General error handler for the application.
 */
@Slf4j
@ControllerAdvice
class DefaultExceptionHandler {
    /**
     * Handle exceptions thrown by handlers.
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView exception(Exception exception, WebRequest request) {
        ModelAndView modelAndView = new ModelAndView("error/generalError");
        addError(exception, modelAndView);
        return modelAndView;
    }

    private void addError(Exception exception, ModelAndView modelAndView) {
        log.error("An error occurred", exception);
        modelAndView.addObject("rootCause", Throwables.getRootCause(exception));
        modelAndView.addObject("stackTraceAsString", Throwables.getStackTraceAsString(exception));
    }
}
