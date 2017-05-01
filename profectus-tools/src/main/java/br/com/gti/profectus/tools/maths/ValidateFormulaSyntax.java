package br.com.gti.profectus.tools.maths;

import java.util.LinkedList;
import java.util.List;

import br.com.gti.profectus.tools.string.CharacterHelper;

/**
 * Verification of formula syntax.
 */
public class ValidateFormulaSyntax {

    private final LinkedList<CharacterHelper> caracteres = new LinkedList<>();

    /**
     * push.
     * @param c
     */
    public void push(CharacterHelper c) {
        caracteres.push(c);
    }

    /**
     * pop.
     * @return
     */
    public CharacterHelper pop() {
        if (isEmpty()) {
            return null;
        } else {
            return this.caracteres.pop();
        }
    }

    /**
     * Verifies if heap is empty.
     * @return
     */
    public boolean isEmpty() {
        return caracteres.isEmpty();
    }

    /**
     * verifies if is first element of heap.
     * @return
     */
    public CharacterHelper primeiroElemento() {
        return this.caracteres.getFirst();
    }

    /**
     * Validate heap.
     * @param pilha
     * @param ch
     * @return
     */
    public boolean validate(final ValidateFormulaSyntax pilha, final List<CharacterHelper> ch) {
        if (pilha.isEmpty()) {
            int countOperators = 0;
            for (int i = 0; i < ch.size(); i++) {
                if (ch.get(i).getTipoCaracter(ch.get(i)).equals(CharacterHelper.OPERADOR)) {
                    int proxIndex = i + 1;
                    countOperators++;
                    if (ch.get(i).getTipoCaracter(ch.get(i))
                            .equals(ch.get(proxIndex).getTipoCaracter(ch.get(proxIndex)))) {
                        return false;
                    }
                    if (ch.get(proxIndex).getTipoCaracter(ch.get(proxIndex)).equals(CharacterHelper.CHAVES)) {
                        return false;
                    }
                }
                if (ch.get(i).getTipoCaracter(ch.get(i)).equals(CharacterHelper.SPACE)) {
                    int proxIndex = i + 1;
                    int beforeIndex = i - 1;
                    if (ch.get(beforeIndex).getTipoCaracter(ch.get(proxIndex)).equals(CharacterHelper.CARACTERE)
                            && ch.get(i).getTipoCaracter(ch.get(proxIndex)).equals(CharacterHelper.SPACE)
                            && ch.get(proxIndex).getTipoCaracter(ch.get(proxIndex)).equals(CharacterHelper.CARACTERE)) {
                        return false;
                    }
                }
                if (ch.get(i).eAbertura(ch.get(i))) {
                    pilha.push(ch.get(i));
                } else if (ch.get(i).eFechamento(ch.get(i))) {
                    if (pilha.isEmpty()) {
                        return false;
                    } else if (pilha.primeiroElemento().getTipoCaracter(pilha.primeiroElemento())
                            .equals(ch.get(i).getTipoCaracter(ch.get(i)))) {
                        pilha.pop();
                    }
                }
                if (pilha.isEmpty()) {
                    if (countOperators == 0) {
                        return false;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Validate variables of heap.
     * @param pilha
     * @param ch
     * @return
     */
    public boolean validateVariables(final ValidateFormulaSyntax pilha, List<CharacterHelper> ch) {
        if (pilha.isEmpty()) {
            for (int i = 0; i < ch.size(); i++) {
                if (ch.get(i).getTipoCaracter(ch.get(i)).equals(CharacterHelper.SPACE) && i > 0) {
                    int proxIndex = i + 1;
                    int beforeIndex = i - 1;
                    if (ch.get(beforeIndex).getTipoCaracter(ch.get(proxIndex))
                            .equals(CharacterHelper.CARACTERE)
                            && ch.get(i).getTipoCaracter(ch.get(proxIndex))
                                    .equals(CharacterHelper.SPACE)
                            && ch.get(proxIndex).getTipoCaracter(ch.get(proxIndex))
                                    .equals(CharacterHelper.CARACTERE)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
