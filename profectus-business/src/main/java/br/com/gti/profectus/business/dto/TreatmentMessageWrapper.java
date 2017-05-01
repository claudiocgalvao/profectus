package br.com.gti.profectus.business.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * TreatmentMessageDTO.
 * @author tiago.canatelli
 * @since 01/12/2014
 */
@XmlRootElement(name = "messages")
public class TreatmentMessageWrapper implements Serializable {

  /**
   * ID.
   */
  private static final long serialVersionUID = 1L;

  private List<TreatmentMessageDTO> list;

  /**
   * get.
   * @author tiago.canatelli
   * @since 30/07/2015
   * @return
   */
  public List<TreatmentMessageDTO> getList() {
    return this.list;
  }

  /**
   * set.
   * @author tiago.canatelli
   * @since 30/07/2015
   * @param list
   */
  public void setList(List<TreatmentMessageDTO> list) {
    this.list = list;
  }

  /**
   * Constructor of class TreatmentMessageWrapper.java.
   */
  public TreatmentMessageWrapper() {
  }

}
