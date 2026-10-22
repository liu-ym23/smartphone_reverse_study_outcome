package org.apache.commons.math3.linear;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.OutOfRangeException;

/* JADX INFO: loaded from: classes6.dex */
public interface FieldVector<T extends FieldElement<T>> {
    FieldVector<T> add(FieldVector<T> r1) throws DimensionMismatchException;

    FieldVector<T> append(T r1);

    FieldVector<T> append(FieldVector<T> r1);

    FieldVector<T> copy();

    T dotProduct(FieldVector<T> r1) throws DimensionMismatchException;

    FieldVector<T> ebeDivide(FieldVector<T> r1) throws DimensionMismatchException, MathArithmeticException;

    FieldVector<T> ebeMultiply(FieldVector<T> r1) throws DimensionMismatchException;

    @Deprecated
    T[] getData();

    int getDimension();

    T getEntry(int r1) throws OutOfRangeException;

    Field<T> getField();

    FieldVector<T> getSubVector(int r1, int r2) throws OutOfRangeException, NotPositiveException;

    FieldVector<T> mapAdd(T r1) throws NullArgumentException;

    FieldVector<T> mapAddToSelf(T r1) throws NullArgumentException;

    FieldVector<T> mapDivide(T r1) throws NullArgumentException, MathArithmeticException;

    FieldVector<T> mapDivideToSelf(T r1) throws NullArgumentException, MathArithmeticException;

    FieldVector<T> mapInv() throws MathArithmeticException;

    FieldVector<T> mapInvToSelf() throws MathArithmeticException;

    FieldVector<T> mapMultiply(T r1) throws NullArgumentException;

    FieldVector<T> mapMultiplyToSelf(T r1) throws NullArgumentException;

    FieldVector<T> mapSubtract(T r1) throws NullArgumentException;

    FieldVector<T> mapSubtractToSelf(T r1) throws NullArgumentException;

    FieldMatrix<T> outerProduct(FieldVector<T> r1);

    FieldVector<T> projection(FieldVector<T> r1) throws DimensionMismatchException, MathArithmeticException;

    void set(T r1);

    void setEntry(int r1, T r2) throws OutOfRangeException;

    void setSubVector(int r1, FieldVector<T> r2) throws OutOfRangeException;

    FieldVector<T> subtract(FieldVector<T> r1) throws DimensionMismatchException;

    T[] toArray();
}
