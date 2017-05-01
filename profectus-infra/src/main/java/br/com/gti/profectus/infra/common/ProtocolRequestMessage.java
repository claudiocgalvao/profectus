package br.com.gti.profectus.infra.common;

import java.io.Serializable;
import java.rmi.RemoteException;

/**
 * ProtocolMassage.
 * @author eduardo.fsantos
 * @since 22/05/2015
 */
public class ProtocolRequestMessage implements IProtocolRequestMessage, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String messageId;

    //Header
    private int typeCalculation;

    private int typeRequest;

    private Long factGeneratorId;

    private Long lossesPayId;

    private int originSystem; //TAX / FEE

    private int originModule; //TAX ----> Netting, Matrix, Administrator, Maintenance, Simulator e Test

    private String cpfCNPJ;

    private String calculationPeriod; //Periodo de apuração

    private String dataOfMovimentOperation; //Data do movimento/opracao

    private String customerInternalCode; // codigo interno do cliente

    private String legacyNumberId; //Numero unico de identificação do movimento/operação (gerado pelo sistema legado que demandou o calculo)

    private String jsonDTO;

    private Object dto;

    private Equation equation;

    private String pathFileToProcess;

    private String messageName;

    private Integer line;

    /**
     * Constructor of class ProtocolMassage.java.
     * @param originMessage
     * @throws RemoteException
     */
    public ProtocolRequestMessage() throws RemoteException {
        super();
    }

    /**
     * Constructor of class AbstractMessage.java.
     */
    public ProtocolRequestMessage(int originModule) throws RemoteException {
        super();
        this.originModule = originModule;
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
     * @return the typeCalculation
     */
    public int getTypeCalculation() {
        return typeCalculation;
    }

    /**
     * @param typeCalculation the typeCalculation to set
     */
    public void setTypeCalculation(int typeCalculation) {
        this.typeCalculation = typeCalculation;
    }

    /**
     * @param originMessage the originMessage to set
     */
    public void setOriginModule(int originModule) {
        this.originModule = originModule;
    }

    /**
     * @return the originMessage
     */
    public int getOriginModule() {
        return originModule;
    }

    /**
     * @return the dto
     */
    public String getJsonDTO() {
        return jsonDTO;
    }

    /**
     * @param dto the dto to set
     */
    public void setJsonDTO(String jsonDTO) {
        this.jsonDTO = jsonDTO;
    }

    /**
     * @return the typeRequest
     */
    public int getTypeRequest() {
        return typeRequest;
    }

    /**
     * @param typeRequest the typeRequest to set
     */
    public void setTypeRequest(int typeRequest) {
        this.typeRequest = typeRequest;
    }

    /**
     * @return the factGeneratorId
     */
    public Long getFactGeneratorId() {
        return factGeneratorId;
    }

    /**
     * @param factGeneratorId the factGeneratorId to set
     */
    public void setFactGeneratorId(Long factGeneratorId) {
        this.factGeneratorId = factGeneratorId;
    }

    /**
     * @return the cpfCNPJ
     */
    public String getCpfCNPJ() {
        return cpfCNPJ;
    }

    /**
     * @param cpfCNPJ the cpfCNPJ to set
     */
    public void setCpfCNPJ(String cpfCNPJ) {
        this.cpfCNPJ = cpfCNPJ;
    }

    /**
     * @return the calculationPeriod
     */
    public String getCalculationPeriod() {
        return calculationPeriod;
    }

    /**
     * @param calculationPeriod the calculationPeriod to set
     */
    public void setCalculationPeriod(String calculationPeriod) {
        this.calculationPeriod = calculationPeriod;
    }

    /**
     * @return the dataOfMovimentOperation
     */
    public String getDataOfMovimentOperation() {
        return dataOfMovimentOperation;
    }

    /**
     * @param dataOfMovimentOperation the dataOfMovimentOperation to set
     */
    public void setDataOfMovimentOperation(String dataOfMovimentOperation) {
        this.dataOfMovimentOperation = dataOfMovimentOperation;
    }

    /**
     * @return the customerInternalCode
     */
    public String getCustomerInternalCode() {
        return customerInternalCode;
    }

    /**
     * @param customerInternalCode the customerInternalCode to set
     */
    public void setCustomerInternalCode(String customerInternalCode) {
        this.customerInternalCode = customerInternalCode;
    }

    /**
     * @return the legacyNumberId
     */
    public String getLegacyNumberId() {
        return legacyNumberId;
    }

    /**
     * @param legacyNumberId the legacyNumberId to set
     */
    public void setLegacyNumberId(String legacyNumberId) {
        this.legacyNumberId = legacyNumberId;
    }

    /**
     * @return the originSystem
     */
    public int getOriginSystem() {
        return originSystem;
    }

    /**
     * @param originSystem the originSystem to set
     */
    public void setOriginSystem(int originSystem) {
        this.originSystem = originSystem;
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

    /**
     * @return the dto
     */
    public Object getDto() {
        return dto;
    }

    /**
     * @param dto the dto to set
     */
    public void setDto(Object dto) {
        this.dto = dto;
    }

    /**
     * @return the pathFileToProcess
     */
    public String getPathFileToProcess() {
        return pathFileToProcess;
    }

    /**
     * @param pathFileToProcess the pathFileToProcess to set
     */
    public void setPathFileToProcess(String pathFileToProcess) {
        this.pathFileToProcess = pathFileToProcess;
    }

    /**
     * @return the lossesPayId
     */
    public Long getLossesPayId() {
        return lossesPayId;
    }

    /**
     * @param lossesPayId the lossesPayId to set
     */
    public void setLossesPayId(Long lossesPayId) {
        this.lossesPayId = lossesPayId;
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

    /**
     * @return the line
     */
    public Integer getLine() {
        return line;
    }

    /**
     * @param line the line to set
     */
    public void setLine(Integer line) {
        this.line = line;
    }

}
