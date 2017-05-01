package br.com.gti.profectus.tools.validation;

import br.com.gti.profectus.tools.constants.NumberIntMagic;

/**
 * Helper for data validation.
 */
public final class ValidationsHelper {

  private ValidationsHelper() {
  }

  private static final int[] PESO_CPF = {
                                         11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };

  private static final int[] PESO_CNPJ = {
                                          6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

  private static int calcularDigtio(String str, int[] peso) {
    int soma = 0;
    for (int indice = str.length() - 1, digtio; indice >= 0; indice--) {
      digtio = Integer.parseInt(str.substring(indice, indice + 1));
      soma += digtio * peso[peso.length - str.length() + indice];
    }
    soma = NumberIntMagic.ELEVEN - soma % NumberIntMagic.ELEVEN;
    return soma > NumberIntMagic.NINE ? 0 : soma;
  }

  /**
   * isValidCPF.
   * @param cpf
   * @return
   */
  public static boolean isValidCPF(String cpf) {
    if ((cpf == null) || (cpf.length() != NumberIntMagic.ELEVEN)) {
      return false;
    }

    Integer digti1 = calcularDigtio(cpf.substring(0, NumberIntMagic.NINE), PESO_CPF);
    Integer digti2 = calcularDigtio(cpf.substring(0, NumberIntMagic.NINE) + digti1, PESO_CPF);
    return cpf.equals(cpf.substring(0, NumberIntMagic.NINE) + digti1.toString() + digti2.toString());
  }

  /**
   * isValidCNPJ.
   * @author claudio.cesar
   * @param cnpj
   * @return
   */
  public static boolean isValidCNPJ(String cnpj) {
    if ((cnpj == null) || (cnpj.length() != 14)) {
      return false;
    }

    Integer digtio1 = calcularDigtio(cnpj.substring(0, 12), PESO_CNPJ);
    Integer digtio2 = calcularDigtio(cnpj.substring(0, 12) + digtio1, PESO_CNPJ);
    return cnpj.equals(cnpj.substring(0, 12) + digtio1.toString() + digtio2.toString());
  }

  /**
   * main.
   * @param args
   */
  //  public static void main(String[] args) {
  //    System.out.printf("CPF Valido:%s \n", ValidationsHelper.isValidCPF("25592916818"));
  //    System.out.printf("CNPJ Valido:%s \n", ValidationsHelper.isValidCNPJ("13232"));
  //  }

}
