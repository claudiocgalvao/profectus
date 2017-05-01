package br.com.gti.profectus.infra.common;

import br.com.gti.profectus.infra.calculator.antlr.Value;

/**
 * ResponseMessage.
 * @author eduardo.fsantos
 * @since 25/05/2015
 */
public class ProtocolResponseMessage implements IProtocolResponseMessage {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String messageId;

    private String message;

    private String messageErro;

    private Integer erro; //0 = ok / 1 = erro

    private Equation equation;

    private Value<?> result;

    public ProtocolResponseMessage() {

    }

    /**
     * @return the messageId
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * @param messageId the messageId to set
     */
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the result
     */
    public Value<?> getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(Value<?> result) {
        this.result = result;
    }

    /**
     * @return the messageErro
     */
    public String getMessageErro() {
        return messageErro;
    }

    /**
     * @param messageErro the messageErro to set
     */
    public void setMessageErro(String messageErro) {
        this.messageErro = messageErro;
    }

    /**
     * @return the erro
     */
    public Integer getErro() {
        return erro;
    }

    /**
     * @param erro the erro to set
     */
    public void setErro(Integer erro) {
        this.erro = erro;
    }

    /**
     * @return the equation
     */
    public Equation getEquation() {
        return equation;
    }

    /**
     * @param equation the equation to set
     */
    public void setEquation(Equation equation) {
        this.equation = equation;
    }
}
