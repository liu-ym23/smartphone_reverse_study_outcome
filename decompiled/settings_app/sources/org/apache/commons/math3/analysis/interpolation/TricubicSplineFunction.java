package org.apache.commons.math3.analysis.interpolation;

import java.lang.reflect.Array;
import org.apache.commons.math3.analysis.TrivariateFunction;
import org.apache.commons.math3.exception.OutOfRangeException;

/* JADX INFO: compiled from: TricubicSplineInterpolatingFunction.java */
/* JADX INFO: loaded from: classes6.dex */
class TricubicSplineFunction implements TrivariateFunction {
    private static final short N = 4;
    private final double[][][] a;

    TricubicSplineFunction(double[] r9) {
        this.a = (double[][][]) Array.newInstance(Double.TYPE, new int[]{4, 4, 4});
        int r1 = 0;
    L4:
        if (r1 >= 4) goto L12;
        int r3 = 0;
    L6:
        if (r3 >= 4) goto L11;
        int r4 = 0;
    L8:
        if (r4 >= 4) goto L10;
        this.a[r1][r3][r4] = r9[(((r4 * 4) + r3) * 4) + r1];
        r4 = r4 + 1;
        goto L8
    L10:
        r3 = r3 + 1;
        goto L6
    L11:
        r1 = r1 + 1;
        goto L4
    }

    @Override // org.apache.commons.math3.analysis.TrivariateFunction
    public double value(double r17, double r19, double r21) throws OutOfRangeException {
        double r0 = 0.0d;
        if (r17 < 0.0d) goto L29;
        if (r17 > 1.0d) goto L29;
        if (r19 < 0.0d) goto L27;
        if (r19 > 1.0d) goto L27;
        if (r21 < 0.0d) goto L25;
        if (r21 > 1.0d) goto L25;
        double r9 = r17 * r17;
        double[] r4 = {1.0d, r17, r9, r9 * r17};
        double r10 = r19 * r19;
        double[] r14 = {1.0d, r19, r10, r10 * r19};
        double r11 = r21 * r21;
        double[] r15 = {1.0d, r21, r11, r11 * r21};
        int r3 = 0;
    L15:
        if (r3 >= 4) goto L23;
        int r6 = 0;
    L17:
        if (r6 >= 4) goto L22;
        int r7 = 0;
    L19:
        if (r7 >= 4) goto L21;
        r0 = r0 + (((this.a[r3][r6][r7] * r4[r3]) * r14[r6]) * r15[r7]);
        r7 = r7 + 1;
        goto L19
    L21:
        r6 = r6 + 1;
        goto L17
    L22:
        r3 = r3 + 1;
        goto L15
    L23:
        return r0;
    L25:
        throw new OutOfRangeException(Double.valueOf(r21), 0, 1);
    L27:
        throw new OutOfRangeException(Double.valueOf(r19), 0, 1);
    L29:
        throw new OutOfRangeException(Double.valueOf(r17), 0, 1);
    }
}
