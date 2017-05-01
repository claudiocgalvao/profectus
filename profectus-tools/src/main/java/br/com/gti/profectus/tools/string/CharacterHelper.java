package br.com.gti.profectus.tools.string;

import br.com.gti.profectus.tools.OperatorsType;

/**
 * CharacterHelper.
 * @author claudio.cesar
 * @since 17/11/2014
 */
public class CharacterHelper {

    /**
     * Operador.
     */
    public static final String OPERADOR = "operador";
    /**
     * Chaves.
     */
    public static final String CHAVES = "chaves";
    /**
     * Colchetes.
     */
    public static final String COLCHETES = "colchetes";
    /**
     * Parenteses.
     */
    public static final String PARENTESES = "parenteses";
    /**
     * Space.
     */
    public static final String SPACE = "space";
    /**
     * Caractere.
     */
    public static final String CARACTERE = "caractere";
    /**
     * Array Operador.
     */
    private static final String[] ARRAY_OPERATOR = {
                                                    OperatorsType.LBL_AND, OperatorsType.LBL_BIGGER,
                                                    OperatorsType.LBL_BIGGER_EQUALS, OperatorsType.LBL_DIFFERENT,
                                                    OperatorsType.LBL_DIVISION, OperatorsType.LBL_EXPONENT,
                                                    OperatorsType.LBL_MULTIPLICATION, OperatorsType.LBL_OR,
                                                    OperatorsType.LBL_SMALLER, OperatorsType.LBL_SMALLER_EQUALS,
                                                    OperatorsType.LBL_SUBTRACTION, OperatorsType.LBL_SUM};
    /**
     * Conteúdo.
     */
    private char conteudo;

    public char getConteudo() {
        return conteudo;
    }

    public void setConteudo(char conteudo) {
        this.conteudo = conteudo;
    }

    /**
     * getTipoCaracter.
     * @author claudio.cesar
     * @since 17/11/2014
     * @param c
     * @return
     */
    public String getTipoCaracter(CharacterHelper c) {
        String tipo;
        if (c.getConteudo() == '{' || c.getConteudo() == '}') {
            tipo = CHAVES;
        } else if (c.getConteudo() == '[' || c.getConteudo() == ']') {
            tipo = COLCHETES;
        } else if (c.getConteudo() == '(' || c.getConteudo() == ')') {
            tipo = PARENTESES;
        } else if (c.getConteudo() == '+' || c.getConteudo() == '-' || c.getConteudo() == '*' || c.getConteudo() == '/'
                || c.getConteudo() == '^') {
            tipo = OPERADOR;
        } else if (c.getConteudo() == ' ') {
            return SPACE;
        } else {
            return CARACTERE;
        }
        return tipo;
    }

    /**
     * eAbertura.
     */
    public boolean eAbertura(CharacterHelper c) {
        return c.getConteudo() == '{' || c.getConteudo() == '[' || c.getConteudo() == '(';
    }

    /**
     * eFechamento.
     */
    public boolean eFechamento(CharacterHelper c) {
        return c.getConteudo() == '}' || c.getConteudo() == ']' || c.getConteudo() == ')';
    }

    /**
     * validateFormulaOperators.
     */
    public static boolean validateFormulaOperators(final String formula) {
        String[] aOperators = {
                               "+", "-", "*", "/", "<", ">", "<=", ">=", "<>", "AND", "OR"};
        //Verifica se há estruturas abertas somente com operadores
        for (String operator : aOperators) {
            String parenteses = "(" + operator + ")";
            String chaves = "{" + operator + "}";
            String colchetes = "[" + operator + "]";
            if (formula.contains(parenteses)) {
                return false;
            } else if (formula.contains(chaves)) {
                return false;
            } else if (formula.contains(colchetes)) {
                return false;
            }
        }
        for (String operatorIni : ARRAY_OPERATOR) {
            for (String operatorFim : ARRAY_OPERATOR) {
                String stringToUsing = operatorIni + operatorFim;
                if (formula.contains(stringToUsing)) {
                    return false;
                }
            }
        }
        //Verificação parenteses colchetes abertos
        int totalOpenPar = 0;
        int totalClosePar = 0;
        int totalOpenCol = 0;
        int totalCloseCol = 0;
        int totalOpenChave = 0;
        int totalCloseChave = 0;
        for (int i = 0; i < formula.length(); i++) {
            char ch = formula.charAt(i);
            String x1 = String.valueOf(ch);
            if (x1.equalsIgnoreCase("(")) {
                totalOpenPar++;
            }
            if (x1.equalsIgnoreCase(")")) {
                totalClosePar++;
            }
            if (x1.equalsIgnoreCase("[")) {
                totalOpenCol++;
            }
            if (x1.equalsIgnoreCase("]")) {
                totalCloseCol++;
            }
            if (x1.equalsIgnoreCase("{")) {
                totalOpenChave++;
            }
            if (x1.equalsIgnoreCase("}")) {
                totalCloseChave++;
            }
        }
        if (totalOpenPar != totalClosePar) {
            return false;
        } else if (totalOpenCol != totalCloseCol) {
            return false;
        } else if (totalOpenChave != totalCloseChave) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.valueOf(conteudo);
    }
}
