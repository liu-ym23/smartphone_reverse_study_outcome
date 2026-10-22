package org.apache.commons.math3;

import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NullArgumentException;

/* JADX INFO: loaded from: classes6.dex */
public interface FieldElement<T> {
    T add(T r1) throws NullArgumentException;

    T divide(T r1) throws NullArgumentException, MathArithmeticException;

    Field<T> getField();

    T multiply(int r1);

    T multiply(T r1) throws NullArgumentException;

    T negate();

    T reciprocal() throws MathArithmeticException;

    T subtract(T r1) throws NullArgumentException;
}
