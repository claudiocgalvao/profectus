package br.com.gti.profectus.business.dto;

import java.io.Serializable;

import lombok.Data;


/**
 * MessageDTO.
 * @author tiago.canatelli
 * @since 24/11/2014
 */
@Data
public class BaseDTO implements Serializable {

  /**
   * ID.
   */
  private static final long serialVersionUID = 1L;

  /** inputFormFilter. */
  private String inputFormFilter;

  /** optionRadioFilter. */
  private String optionRadioFilter;

  /** showModal. */
  private String showModal;

  /** nameExisting. */
  private boolean nameExisting;

  /** pageMessage. */
  private String pageMessage;

  /** treatmentMessageDTO. */
  private TreatmentMessageDTO treatmentMessageDTO;

  /** userId. */
  private Long userId;

  /** user. */
  private String user;

  /** viewName. */
  private String viewName;

  /** userDTO. */

  /**
   * Constructor of class BaseDTO.java.
   * @param inputFormFilter
   * @param optionRadioFilter
   */
  public BaseDTO(String inputFormFilter, String optionRadioFilter) {
    super();
    this.inputFormFilter = inputFormFilter;
    this.optionRadioFilter = optionRadioFilter;
  }

  /**
   * Constructor of class BaseDTO.java.
   */
  public BaseDTO() {
    super();
  }

  /**
   * Method to add message treatment in a functionality.
   * @author tiago.canatelli
   * @since 01/12/2014
   * @param lblMessage
   * @param typeMessageTreatment void
   */
  public void addMessageTreatment(String lblMessage, String typeMessageTreatment) {
    this.treatmentMessageDTO = new TreatmentMessageDTO(lblMessage, typeMessageTreatment);
  }

}
