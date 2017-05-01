package br.com.gti.profectus.infra.calculator.antlr;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import org.joda.time.LocalDate;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;

/**
 * A value used in a formula.
 * @param <T>
 */
public final class Value<T extends Comparable<?>> implements Serializable {

	private static final long serialVersionUID = -5878293097333164824L;

	private final DataType dataType;

    private final T value;

    private Scope scope;

    /**
     * Constructor.
     * @param value
     */
    public Value(final T value) {
        this.value = Preconditions.checkNotNull(value, "The value cannot be null");

        if (this.value instanceof Boolean) {
            this.dataType = DataType.BOOLEAN;
            return;
        } else
            if (this.value instanceof Double) {
                this.dataType = DataType.NUMBER;
                return;
            } else
                if (this.value instanceof LocalDate) {
                    this.dataType = DataType.DATE;
                    return;
                } else
                    if (this.value instanceof String) {
                        this.dataType = DataType.TEXT;
                        return;
                    }

        throw new IllegalArgumentException(String.format("Invalid value: %s of type %s", value, value.getClass()
                .getCanonicalName()));
    }

    public Boolean asBoolean() {
        return (Boolean) this.value;
    }

    public LocalDate asDate() {
        return (LocalDate) this.value;
    }

    public Double asNumber() {
        return (Double) this.value;
    }

    public String asString() {
        return String.valueOf(this.value);
    }

    public boolean isBoolean() {
        return this.dataType == DataType.BOOLEAN;
    }

    public boolean isDate() {
        return this.dataType == DataType.DATE;
    }

    public boolean isNumber() {
        return this.dataType == DataType.NUMBER;
    }

    public boolean isString() {
        return this.dataType == DataType.TEXT;
    }

    public DataType getDataType() {
        return this.dataType;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final Value<?> value1 = (Value<?>) o;
        return Objects.equals(this.dataType, value1.dataType) && Objects.equals(this.value, value1.value);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.dataType, this.value);
    }

    /**
     * ToString method override.
     */
    @Override
    public String toString() {
        return String.format("(%s) %s", this.dataType, this.value);
    }

    public static Value<Boolean> from(final boolean aBoolean) {
        return new Value<Boolean>(aBoolean);
    }

    public static Value<LocalDate> from(final Date aDate) {
        return new Value<>(LocalDate.fromDateFields(aDate));
    }

    public static Value<LocalDate> from(final LocalDate aDate) {
        return new Value<>(aDate);
    }

    public static Value<LocalDate> from(final int year, final int monthOfYear, final int dayOfMonth) {
        return new Value<>(new LocalDate(year, monthOfYear, dayOfMonth));
    }

    public static Value<Double> from(final Double aNumber) {
        return new Value<>(aNumber);
    }

    public static Value<Double> from(final BigDecimal aNumber) {
        return new Value<Double>(aNumber.doubleValue());
    }

    public static Value<String> from(final String someText) {
        return new Value<>(someText);
    }

    /**
     * Method that compare values and return max of value.
     * @param first
     * @param second
     * @return
     */
    public static Value<?> max(final Value<?> first, final Value<?> second) {

        if (first != null && second == null) {
            return first;
        } else
            if (first == null && second != null) {
                return second;
            } else
                if (first == null) {
                    return null;
                }

        boolean isNumber = first.isNumber() && second.isNumber();
        boolean isDate = first.isDate() && second.isDate();

        Preconditions.checkArgument(isNumber || isDate,
                "O primeiro valor a ser comparado precisa ser um número ou uma data");
        Preconditions.checkArgument(isNumber || isDate,
                "O segundo valor a ser comparado precisa ser um número ou uma data");

        if (!(isNumber || isDate)) {
            throw new IllegalArgumentException("Os tipos de dados dos valores a serem comparados são diferentes");
        }

        if (isNumber) {
            if (Doubles.compare(first.asNumber(), second.asNumber()) > 0) {
                return first;
            } else {
                return second;
            }
        } else
            if (isDate) {
                if (first.asDate().compareTo(second.asDate()) > 0) {
                    return first;
                } else {
                    return second;
                }
            }

        throw new UnsupportedOperationException("A comparação de valores só trata números e datas");
    }

    /**
     * Method that compare values and return min of value.
     * @param first
     * @param second
     * @return
     */
    public static Value<?> min(final Value<?> first, final Value<?> second) {

        if (first != null && second == null) {
            return first;
        } else
            if (first == null && second != null) {
                return second;
            } else
                if (first == null) {
                    return null;
                }

        boolean isNumber = first.isNumber() && second.isNumber();
        boolean isDate = first.isDate() && second.isDate();

        Preconditions.checkArgument(isNumber || isDate,
                "O primeiro valor a ser comparado precisa ser um número ou uma data");
        Preconditions.checkArgument(isNumber || isDate,
                "O segundo valor a ser comparado precisa ser um número ou uma data");

        if (!(isNumber || isDate)) {
            throw new IllegalArgumentException("Os tipos de dados dos valores a serem comparados são diferentes");
        }

        if (isNumber) {
            if (Doubles.compare(first.asNumber(), second.asNumber()) < 0) {
                return first;
            } else {
                return second;
            }
        } else
            if (isDate) {
                if (first.asDate().compareTo(second.asDate()) < 0) {
                    return first;
                } else {
                    return second;
                }
            }

        throw new UnsupportedOperationException("A comparação de valores só trata números e datas");
    }

    public void setScope(final Scope scope) {
        this.scope = scope;
    }

    public Scope getScope() {
        return this.scope;
    }
}
