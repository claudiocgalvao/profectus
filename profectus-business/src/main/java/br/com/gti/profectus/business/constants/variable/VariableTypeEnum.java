package br.com.gti.profectus.business.constants.variable;

/**
 * VariableTypeEnum.
 * @author claudio.cesar
 * @since 10/12/2014
 */
public enum VariableTypeEnum {
  /**
   * String.
   */
  STRING(1, "constants.select.variable.type.string"),

  /**
   * INTEGER.
   */
  INTEGER(2, "constants.select.variable.type.integer"),

  /**
   * FLOAT.
   */
  FLOAT(3, "constants.select.variable.type.float"),

  /**
   * DATE.
   */
  DATE(4, "constants.select.variable.type.date");

  private Integer id;

  private String description;

  /**
   * Constructor of class VariableTypeEnum.java.
   * @param id
   * @param description
   */
  VariableTypeEnum(final Integer id, final String description) {
    this.id = id;
    this.description = description;
  }

  /**
   * getEnum.
   * @author claudio.cesar
   * @since 23/10/2015
   * @param enumId
   * @return
   */
  public VariableTypeEnum getEnum(Integer enumId) {

    if (enumId != null) {
      for (VariableTypeEnum variabelTypeEnum : VariableTypeEnum.values()) {

        if (variabelTypeEnum.getId().equals(enumId)) {
          return variabelTypeEnum;
        }
      }

    }
    return null;
  }

  public Integer getId() {
    return this.id;
  }

  public String getDescription() {
    return this.description;
  }

}
