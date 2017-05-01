package br.com.gti.profectus.business.constants;

/**
 * TypeParameterEnum.
 * @author tiago.canatelli
 * @since 25/11/2014
 */
public enum TaxFunctionsEnum {

  /** Base Calculation. */
  BASE_CALCULATION("BaseCalculo"),
  /** tax. */
  TAX("imposto");

  private String key;

  /**
   * Constructor.
   * @param key
   */
  TaxFunctionsEnum(final String key) {
    this.key = key;
  }

  /**
   * get key.
   * @author tiago.canatelli
   * @since 02/07/2015
   * @return
   */
  public String getKey() {
    return this.key;
  }

  /**
   * GetByValue.
   * @author tiago.canatelli
   * @since 25/11/2014
   * @param id
   * @return TaxFunctionsEnum
   */
  public static TaxFunctionsEnum getByValue(final String keyValue) {
    for (final TaxFunctionsEnum retorno : TaxFunctionsEnum.values()) {
      if (retorno.getKey().equals(keyValue)) {
        return retorno;
      }
    }
    return null;
  }
}
