package br.com.gti.profectus.infra.logfile.domain;

/**
 * ModuleDomainEnum.
 * @author tiago.canatelli
 * @since 25/06/2015
 */
public enum ModuleDomainEnum {

  /** operation matrix. */
  MATRIXOPERATION("MTX_OP", "Operation Matrix"),
  /** netting. */
  NETTING("NTG", "Netting"),
  /** online. */
  ONLINE("ON", "On-Line"),
  /** calculator. */
  TFSCALCULATOR("CALC", "Tax Calculator"),
  /** administration. */
  ADMINISTRATION("ADM", "Administration"),
  /** maintenance. */
  MAINTENANCE("MTN", "Maintenance"),
  /** test. */
  TEST("TES", "Test"),
  /** simulator. */
  SIMULATOR("SLTOR", "Simulator");

  private String id;

  private String description;

  /**
   * Constructor.
   * @param id
   * @param description
   */
  ModuleDomainEnum(final String id, final String description) {
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
  public static ModuleDomainEnum getByValue(final String id) {
    for (final ModuleDomainEnum retorno : ModuleDomainEnum.values()) {
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
    for (final ModuleDomainEnum retorno : ModuleDomainEnum.values()) {
      if (retorno.getId().equals(value)) {
        return retorno.getDescription();
      }
    }
    return "";
  }
}
