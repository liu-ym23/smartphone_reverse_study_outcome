package org.apache.commons.math3.analysis.interpolation;

import java.lang.reflect.Array;
import org.apache.commons.math3.analysis.BivariateFunction;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: BicubicInterpolatingFunction.java */
/* JADX INFO: loaded from: classes6.dex */
class BicubicFunction implements BivariateFunction {
    private static final short N = 4;
    private final double[][] a;

    BicubicFunction(double[] r8) {
        this.a = (double[][]) Array.newInstance(Double.TYPE, new int[]{4, 4});
        int r1 = 0;
    L4:
        if (r1 >= 4) goto L9;
        double[] r3 = this.a[r1];
        int r4 = 0;
    L6:
        if (r4 >= 4) goto L8;
        r3[r4] = r8[(r4 * 4) + r1];
        r4 = r4 + 1;
        goto L6
    L8:
        r1 = r1 + 1;
        goto L4
    }

    @Override // org.apache.commons.math3.analysis.BivariateFunction
    public double value(double r12, double r14) {
        if (r12 < 0.0d) goto L15;
        if (r12 > 1.0d) goto L15;
        if (r14 < 0.0d) goto L13;
        if (r14 > 1.0d) goto L13;
        double r0 = r12 * r12;
        double[] r4 = {1.0d, r12, r0, r0 * r12};
        double r1 = r14 * r14;
        return apply(r4, new double[]{1.0d, r14, r1, r1 * r14}, this.a);
    L13:
        throw new OutOfRangeException(Double.valueOf(r14), 0, 1);
    L15:
        throw new OutOfRangeException(Double.valueOf(r12), 0, 1);
    }

    private double apply(double[] r7, double[] r8, double[][] r9) {
        double r0 = 0.0d;
        int r6 = 0;
    L4:
        if (r6 >= 4) goto L6;
        r0 = r0 + (MathArrays.linearCombination(r9[r6], r8) * r7[r6]);
        r6 = r6 + 1;
        goto L4
    L6:
        return r0;
    }
}
