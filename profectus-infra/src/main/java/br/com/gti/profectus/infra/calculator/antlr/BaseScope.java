package br.com.gti.profectus.infra.calculator.antlr;

import java.util.Map;

import com.google.common.collect.Maps;	

/**
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
 * *
 */
public abstract class BaseScope implements Scope {

    private static final long serialVersionUID = 1623293562066203036L;

    private final Scope enclosingScope; // null if global (outermost) scope

    private final Map<String, Value<?>> symbols = Maps.newLinkedHashMap();

    /**
     * .
     * Constructor of class BaseScope.java.
     * @param enclosingScope
     */
    public BaseScope(final Scope enclosingScope) {
        this.enclosingScope = enclosingScope;
    }

    @Override
    public Value<?> resolve(final String name) {
        final Value<?> s = this.symbols.get(name);
        if (s != null) {
            return s;
        }

        // if not here, check any enclosing scope
        if (this.enclosingScope != null) {
            return this.enclosingScope.resolve(name);
        }

        return null; // not found
    }

    @Override
    public void define(final String name, final Value<?> value) {
        this.symbols.put(name, value);
        value.setScope(this); // track the scope in each symbol
    }

    @Override
    public Scope getEnclosingScope() {
        return this.enclosingScope;
    }

    @Override
    public String toString() {
        return String.format("%s:%s", this.getScopeName(), this.symbols.keySet().toString());
    }
}
