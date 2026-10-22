package org.apache.commons.math3;

import org.apache.commons.math3.exception.DimensionMismatchException;

/* JADX INFO: loaded from: classes6.dex */
public interface RealFieldElement<T> extends FieldElement<T> {
    T abs();

    T acos();

    T acosh();

    T add(double r1);

    T asin();

    T asinh();

    T atan();

    T atan2(T r1) throws DimensionMismatchException;

    T atanh();

    T cbrt();

    T ceil();

    T copySign(double r1);

    T copySign(T r1);

    T cos();

    T cosh();

    T divide(double r1);

    T exp();

    T expm1();

    T floor();

    double getReal();

    T hypot(T r1) throws DimensionMismatchException;

    T linearCombination(double r1, T r3, double r4, T r6);

    T linearCombination(double r1, T r3, double r4, T r6, double r7, T r9);

    T linearCombination(double r1, T r3, double r4, T r6, double r7, T r9, double r10, T r12);

    T linearCombination(T r1, T r2, T r3, T r4);

    T linearCombination(T r1, T r2, T r3, T r4, T r5, T r6);

    T linearCombination(T r1, T r2, T r3, T r4, T r5, T r6, T r7, T r8);

    T linearCombination(double[] r1, T[] r2) throws DimensionMismatchException;

    T linearCombination(T[] r1, T[] r2) throws DimensionMismatchException;

    T log();

    T log1p();

    T multiply(double r1);

    T pow(double r1);

    T pow(int r1);

    T pow(T r1) throws DimensionMismatchException;

    @Override // org.apache.commons.math3.FieldElement
    T reciprocal();

    T remainder(double r1);

    T remainder(T r1) throws DimensionMismatchException;

    T rint();

    T rootN(int r1);

    long round();

    T scalb(int r1);

    T signum();

    T sin();

    T sinh();

    T sqrt();

    T subtract(double r1);

    T tan();

    T tanh();
}
