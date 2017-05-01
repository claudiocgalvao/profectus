package br.com.gti.profectus.infra.logfile.domain;

/**
 * LogFileExtensionsDomainEnum.
 * @author tiago.canatelli
 * @since 25/06/2015
 */
public enum LogFileExtensionsDomainEnum {

  /** text file extension. */
  TXT("txt", "Text file.");

  private String id;

  private String description;

  /**
   * Constructor.
   * @param id
   * @param description
   */
  LogFileExtensionsDomainEnum(final String id, final String description) {
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
  public static LogFileExtensionsDomainEnum getByValue(final String id) {
    for (final LogFileExtensionsDomainEnum retorno : LogFileExtensionsDomainEnum.values()) {
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
    for (final LogFileExtensionsDomainEnum retorno : LogFileExtensionsDomainEnum.values()) {
      if (retorno.getId().equals(value)) {
        return retorno.getDescription();
      }
    }
    return "";
  }
}
