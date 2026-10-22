package org.apache.commons.math3.analysis.integration.gauss;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: loaded from: classes6.dex */
public class SymmetricGaussIntegrator extends GaussIntegrator {
    public SymmetricGaussIntegrator(double[] r1, double[] r2) throws NonMonotonicSequenceException, DimensionMismatchException {
        super(r1, r2);
    }

    public SymmetricGaussIntegrator(Pair<double[], double[]> r2) throws NonMonotonicSequenceException {
        this(r2.getFirst(), r2.getSecond());
    }

    @Override // org.apache.commons.math3.analysis.integration.gauss.GaussIntegrator
    public double integrate(UnivariateFunction r20) {
        int r2 = getNumberOfPoints();
        int r4 = 0;
        if (r2 == 1) goto L5;
        int r3 = r2 / 2;
        double r7 = 0.0d;
        double r9 = 0.0d;
    L7:
        if (r4 >= r3) goto L10;
        double r11 = getPoint(r4);
        double r13 = (getWeight(r4) * (r20.value(r11) + r20.value(-r11))) - r7;
        double r8 = r9 + r13;
        r4 = r4 + 1;
        r7 = (r8 - r9) - r13;
        r9 = r8;
        goto L7
    L10:
        if ((r2 % 2) != 0) goto L12;
        return r9;
    L12:
        return r9 + ((getWeight(r3) * r20.value(0.0d)) - r7);
    L5:
        return getWeight(0) * r20.value(0.0d);
    }
}
