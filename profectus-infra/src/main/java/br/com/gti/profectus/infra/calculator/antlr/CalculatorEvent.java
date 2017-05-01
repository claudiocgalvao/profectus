package br.com.gti.profectus.infra.calculator.antlr;

import java.util.Collections;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/**
 * CalculatorListener.
 * @author eduardo.fsantos
 * @since 18/12/2014
 */
@Slf4j
public class CalculatorEvent extends BaseErrorListener {

    private String message;

    /**
     * Constructor of class Calculator.java.
     */
    public CalculatorEvent() {
        this.message = "";
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line,
                            int charPositionInLine,
                            String msg,
                            RecognitionException e) {
        List<String> stack = ((Parser) recognizer).getRuleInvocationStack();
        Collections.reverse(stack);

        //System.err.println("rule stack: " + stack);
        //System.err.println("line " + line + ":" + charPositionInLine + " at --->" + offendingSymbol + ": " + msg);

        log.error(msg);

        this.message = msg;
    }

    /**
     * getMessage.
     * @return the message
     */
    public String getMessage() {
        return this.message;
    }
}
