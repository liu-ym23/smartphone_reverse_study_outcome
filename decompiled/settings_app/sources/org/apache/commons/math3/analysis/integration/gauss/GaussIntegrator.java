package org.apache.commons.math3.analysis.integration.gauss;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: loaded from: classes6.dex */
public class GaussIntegrator {
    private final double[] points;
    private final double[] weights;

    public GaussIntegrator(double[] r3, double[] r4) throws NonMonotonicSequenceException, DimensionMismatchException {
        if (r3.length != r4.length) goto L7;
        MathArrays.checkOrder(r3, MathArrays.OrderDirection.INCREASING, true, true);
        this.points = (double[]) r3.clone();
        this.weights = (double[]) r4.clone();
        return;
    L7:
        throw new DimensionMismatchException(r3.length, r4.length);
    }

    public GaussIntegrator(Pair<double[], double[]> r2) throws NonMonotonicSequenceException {
        this(r2.getFirst(), r2.getSecond());
    }

    public double integrate(UnivariateFunction r12) {
        double r0 = 0.0d;
        int r4 = 0;
        double r2 = 0.0d;
    L3:
        double[] r5 = this.points;
        if (r4 >= r5.length) goto L6;
        double r7 = (this.weights[r4] * r12.value(r5[r4])) - r2;
        double r3 = r0 + r7;
        double r1 = (r3 - r0) - r7;
        r4 = r4 + 1;
        r0 = r3;
        r2 = r1;
        goto L3
    L6:
        return r0;
    }

    public int getNumberOfPoints() {
        return this.points.length;
    }

    public double getPoint(int r1) {
        return this.points[r1];
    }

    public double getWeight(int r1) {
        return this.weights[r1];
    }
}
