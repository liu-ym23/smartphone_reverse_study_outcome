package org.apache.commons.math3.analysis.interpolation;

import java.lang.reflect.Array;
import org.apache.commons.math3.analysis.BivariateFunction;
import org.apache.commons.math3.exception.OutOfRangeException;

/* JADX INFO: compiled from: BicubicSplineInterpolatingFunction.java */
/* JADX INFO: loaded from: classes6.dex */
class BicubicSplineFunction implements BivariateFunction {
    private static final short N = 4;
    private final double[][] a;
    private final BivariateFunction partialDerivativeX;
    private final BivariateFunction partialDerivativeXX;
    private final BivariateFunction partialDerivativeXY;
    private final BivariateFunction partialDerivativeY;
    private final BivariateFunction partialDerivativeYY;

    static /* synthetic */ double access$000(BicubicSplineFunction r0, double[] r1, double[] r2, double[][] r3) {
        return r0.apply(r1, r2, r3);
    }

    BicubicSplineFunction(double[] r2) {
        this(r2, false);
    }

    BicubicSplineFunction(double[] r19, boolean r20) {
        this.a = (double[][]) Array.newInstance(Double.TYPE, new int[]{4, 4});
        int r3 = 0;
    L3:
        int r4 = 4;
        if (r3 >= 4) goto L9;
        int r5 = 0;
    L6:
        if (r5 >= 4) goto L8;
        this.a[r3][r5] = r19[(r3 * 4) + r5];
        r5 = r5 + 1;
        goto L6
    L8:
        r3 = r3 + 1;
        goto L3
    L9:
        if (r20 == false) goto L17;
        final double[][] r6 = (double[][]) Array.newInstance(Double.TYPE, new int[]{4, 4});
        final double[][] r7 = (double[][]) Array.newInstance(Double.TYPE, new int[]{4, 4});
        final double[][] r8 = (double[][]) Array.newInstance(Double.TYPE, new int[]{4, 4});
        final double[][] r9 = (double[][]) Array.newInstance(Double.TYPE, new int[]{4, 4});
        final double[][] r1 = (double[][]) Array.newInstance(Double.TYPE, new int[]{4, 4});
        int r10 = 0;
    L11:
        if (r10 >= r4) goto L16;
        int r11 = 0;
    L13:
        if (r11 >= r4) goto L15;
        double r12 = this.a[r10][r11];
        double[] r13 = r6[r10];
        r13[r11] = ((double) r10) * r12;
        double[] r14 = r7[r10];
        double r15 = r11;
        r14[r11] = r12 * r15;
        r8[r10][r11] = ((double) (r10 - 1)) * r13[r11];
        r9[r10][r11] = ((double) (r11 - 1)) * r14[r11];
        r1[r10][r11] = r15 * r13[r11];
        r11 = r11 + 1;
        r7 = r7;
        r4 = 4;
        goto L13
    L15:
        r10 = r10 + 1;
        r4 = 4;
        goto L11
    L16:
        this.partialDerivativeX = new AnonymousClass1(this, r6);
        this.partialDerivativeY = new AnonymousClass2(this, r7);
        this.partialDerivativeXX = new AnonymousClass3(this, r8);
        this.partialDerivativeYY = new AnonymousClass4(this, r9);
        this.partialDerivativeXY = new AnonymousClass5(this, r1);
        return;
    L17:
        this.partialDerivativeX = null;
        this.partialDerivativeY = null;
        this.partialDerivativeXX = null;
        this.partialDerivativeYY = null;
        this.partialDerivativeXY = null;
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

    private double apply(double[] r10, double[] r11, double[][] r12) {
        double r0 = 0.0d;
        int r2 = 0;
    L4:
        if (r2 >= 4) goto L9;
        int r4 = 0;
    L6:
        if (r4 >= 4) goto L8;
        r0 = r0 + ((r12[r2][r4] * r10[r2]) * r11[r4]);
        r4 = r4 + 1;
        goto L6
    L8:
        r2 = r2 + 1;
        goto L4
    L9:
        return r0;
    }

    public BivariateFunction partialDerivativeX() {
        return this.partialDerivativeX;
    }

    public BivariateFunction partialDerivativeY() {
        return this.partialDerivativeY;
    }

    public BivariateFunction partialDerivativeXX() {
        return this.partialDerivativeXX;
    }

    public BivariateFunction partialDerivativeYY() {
        return this.partialDerivativeYY;
    }

    public BivariateFunction partialDerivativeXY() {
        return this.partialDerivativeXY;
    }
}
