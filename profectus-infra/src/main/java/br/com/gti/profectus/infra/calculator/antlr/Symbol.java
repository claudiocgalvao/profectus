package br.com.gti.profectus.infra.calculator.antlr;

import java.io.Serializable;

/**
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
 * *
 */
public class Symbol implements Serializable { // A generic programming language symbol

    private static final long serialVersionUID = -925086357493248149L;

    private final String name;      // All symbols at least have a name

    private final DataType dataType;

    private Scope scope;      // All symbols know what scope contains them.

    public Symbol(final String name) {
        this(name, DataType.TEXT);
    }

    public Symbol(final String name, final DataType dataType) {
        this.name = name;
        this.dataType = dataType;
    }

    public String getName() {
        return this.name;
    }

    public DataType getDataType() {
        return this.dataType;
    }

    public Scope getScope() {
        return this.scope;
    }

    public void setScope(final Scope scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        if (this.dataType != DataType.TEXT) {
            return '<' + this.name + ":" + this.dataType + '>';
        }
        return this.name;
    }
}
