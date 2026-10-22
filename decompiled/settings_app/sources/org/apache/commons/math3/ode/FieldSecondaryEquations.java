package org.apache.commons.math3.ode;

import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;

/* JADX INFO: loaded from: classes6.dex */
public interface FieldSecondaryEquations<T extends RealFieldElement<T>> {
    T[] computeDerivatives(T r1, T[] r2, T[] r3, T[] r4) throws MaxCountExceededException, DimensionMismatchException;

    int getDimension();

    void init(T r1, T[] r2, T[] r3, T r4);
}
