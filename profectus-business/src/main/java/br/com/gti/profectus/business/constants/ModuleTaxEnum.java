package br.com.gti.profectus.business.constants;

/**
 * ModuleTaxEnum.
 * @author claudio.cesar
 * @since 10/12/2014
 */
public enum ModuleTaxEnum {
  /**
   * MAINTENANCE.
   */
  MAINTENANCE(1),

  /**
   * TEST.
   */
  TEST(2),

  /**
   * SIMULATION.
   */
  SIMULATION(3);

  private Integer id;

  /**
   * Constructor of class ModuleTaxEnum.java.
   * @param id
   * @param description
   */
  ModuleTaxEnum(final Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return this.id;
  }

  /**
   * Retorna o Enum correspondente ao id.
   * @author claudio.cesar
   * @param enumId
   * @return
   */
  public static ModuleTaxEnum getEnum(Integer enumId) {

    for (final ModuleTaxEnum enumReturn : ModuleTaxEnum.values()) {

      if (enumReturn.getId().equals(enumId)) {
        return enumReturn;
      }
    }
    return null;
  }

}
