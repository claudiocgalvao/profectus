package br.com.gti.profectus.web.support;

import static br.com.gti.profectus.web.support.Message.MESSAGE_ATTRIBUTE;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * MessageHelper.
 * @author claudio.cesar
 * @since 13/11/2014
 */
public final class MessageHelper {

    private MessageHelper() {
    }

    /**
     * addSuccessAttribute.
     * @param ra
     * @param message
     * @param args
     */
    public static void addSuccessAttribute(RedirectAttributes ra, String message, Object... args) {
        addAttribute(ra, message, Message.Type.SUCCESS, args);
    }

    /**
     * addErrorAttribute.
     * @param ra
     * @param message
     * @param args
     */
    public static void addErrorAttribute(RedirectAttributes ra, String message, Object... args) {
        addAttribute(ra, message, Message.Type.DANGER, args);
    }

    /**
     * addInfoAttribute.
     * @param ra
     * @param message
     * @param args
     */
    public static void addInfoAttribute(RedirectAttributes ra, String message, Object... args) {
        addAttribute(ra, message, Message.Type.INFO, args);
    }

    /**
     * addWarningAttribute.
     * @param ra
     * @param message
     * @param args
     */
    public static void addWarningAttribute(RedirectAttributes ra, String message, Object... args) {
        addAttribute(ra, message, Message.Type.WARNING, args);
    }

    /**
     * addAttribute.
     * @param ra
     * @param message
     * @param type
     * @param args
     */
    private static void addAttribute(RedirectAttributes ra, String message, Message.Type type, Object... args) {
        ra.addFlashAttribute(MESSAGE_ATTRIBUTE, new Message(message, type, args));
    }

    /**
     * addSuccessAttribute.
     * @param model
     * @param message
     * @param args
     */
    public static void addSuccessAttribute(Model model, String message, Object... args) {
        addAttribute(model, message, Message.Type.SUCCESS, args);
    }

    /**
     * addErrorAttribute.
     * @param model
     * @param message
     * @param args
     */
    public static void addErrorAttribute(Model model, String message, Object... args) {
        addAttribute(model, message, Message.Type.DANGER, args);
    }

    /**
     * addInfoAttribute.
     * @param model
     * @param message
     * @param args
     */
    public static void addInfoAttribute(Model model, String message, Object... args) {
        addAttribute(model, message, Message.Type.INFO, args);
    }

    /**
     * addWarningAttribute.
     * @param model
     * @param message
     * @param args
     */
    public static void addWarningAttribute(Model model, String message, Object... args) {
        addAttribute(model, message, Message.Type.WARNING, args);
    }

    /**
     * addAttribute.
     * @param model
     * @param message
     * @param type
     * @param args
     */
    private static void addAttribute(Model model, String message, Message.Type type, Object... args) {
        model.addAttribute(MESSAGE_ATTRIBUTE, new Message(message, type, args));
    }
}
