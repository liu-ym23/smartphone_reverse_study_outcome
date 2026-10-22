package org.apache.commons.math3.ode;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;

/* JADX INFO: loaded from: classes6.dex */
public interface SecondaryEquations {
    void computeDerivatives(double r1, double[] r3, double[] r4, double[] r5, double[] r6) throws MaxCountExceededException, DimensionMismatchException;

    int getDimension();
}
