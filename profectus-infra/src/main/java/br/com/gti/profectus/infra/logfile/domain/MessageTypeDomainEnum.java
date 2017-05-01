package br.com.gti.profectus.infra.logfile.domain;

/**
 * MessageTypeDomainEnum.
 * @author tiago.canatelli
 * @since 25/06/2015
 */
public enum MessageTypeDomainEnum {

  /** RMI message. */
  RMI("RMI", "RMI Message"),
  /** MQ message. */
  IBMMQ("IBMMQ", "IBM MQ Message");

  private String id;

  private String description;

  /**
   * Constructor.
   * @param id
   * @param description
   */
  MessageTypeDomainEnum(final String id, final String description) {
    this.id = id;
    this.description = description;
  }

  public String getId() {
    return this.id;
  }

  public String getDescription() {
    return this.description;
  }

  /**
   * GetByValue.
   * @author tiago.canatelli
   * @since 25/11/2014
   * @param id
   * @return TypeParameterEnum
   */
  public static MessageTypeDomainEnum getByValue(final String id) {
    for (final MessageTypeDomainEnum retorno : MessageTypeDomainEnum.values()) {
      if (retorno.getId().equals(id)) {
        return retorno;
      }
    }
    return null;
  }

  /**
   * getDescription.
   * @author tiago.canatelli
   * @since 25/11/2014
   * @param value
   * @return String
   */
  public static String getDescription(final String value) {
    for (final MessageTypeDomainEnum retorno : MessageTypeDomainEnum.values()) {
      if (retorno.getId().equals(value)) {
        return retorno.getDescription();
      }
    }
    return "";
  }
}
