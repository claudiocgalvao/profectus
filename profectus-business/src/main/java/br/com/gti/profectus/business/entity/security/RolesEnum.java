package br.com.gti.profectus.business.entity.security;

/**
 * RolesEnum.
 * @author tiago.canatelli
 * @since 27/07/2015
 */
public enum RolesEnum {

  /** administrator. */
  ADMIN("ADMIN");

  /** key. */
  private String key;

  /**
   * Constructor.
   * @param key
   */
  RolesEnum(final String key) {
    this.key = key;
  }

  /**
   * get key.
   * @author tiago.canatelli
   * @since 15/07/2015
   * @return
   */
  public String getKey() {
    return this.key;
  }

  /**
   * get value.
   * @author tiago.canatelli
   * @since 15/07/2015
   * @param keyValue
   * @return
   */
  public static RolesEnum getByValue(final String keyValue) {
    for (final RolesEnum retorno : RolesEnum.values()) {
      if (retorno.getKey().equals(keyValue)) {
        return retorno;
      }
    }
    return null;
  }
}
