package br.com.gti.profectus.business.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * TreatmentMessageDTO.
 * @author tiago.canatelli
 * @since 01/12/2014
 */
@SuppressWarnings("serial")
public class TreatmentMessageDTO implements Serializable {

    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    private String typeMessage;

    /**
     * Constructor of class TreatmentMessageDTO.java.
     * @param message
     * @param typeMessage
     */
    public TreatmentMessageDTO(String message, String typeMessage) {
        super();
        this.message = message;
        this.typeMessage = typeMessage;
    }

    /**
     * Constructor of class TreatmentMessageDTO.java.
     */
    public TreatmentMessageDTO() {
        super();
    }

}
