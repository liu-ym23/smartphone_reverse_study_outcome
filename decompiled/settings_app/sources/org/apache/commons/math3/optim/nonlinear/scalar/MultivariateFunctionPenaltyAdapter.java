package org.apache.commons.math3.optim.nonlinear.scalar;

import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class MultivariateFunctionPenaltyAdapter implements MultivariateFunction {
    private final MultivariateFunction bounded;
    private final double[] lower;
    private final double offset;
    private final double[] scale;
    private final double[] upper;

    public MultivariateFunctionPenaltyAdapter(MultivariateFunction r6, double[] r7, double[] r8, double r9, double[] r11) {
        MathUtils.checkNotNull(r7);
        MathUtils.checkNotNull(r8);
        MathUtils.checkNotNull(r11);
        if (r7.length != r8.length) goto L19;
        if (r7.length != r11.length) goto L17;
        int r0 = 0;
    L8:
        if (r0 >= r7.length) goto L14;
        if (r8[r0] < r7[r0]) goto L13;
        r0 = r0 + 1;
        goto L8
    L13:
        throw new NumberIsTooSmallException(Double.valueOf(r8[r0]), Double.valueOf(r7[r0]), true);
    L14:
        this.bounded = r6;
        this.lower = (double[]) r7.clone();
        this.upper = (double[]) r8.clone();
        this.offset = r9;
        this.scale = (double[]) r11.clone();
        return;
    L17:
        throw new DimensionMismatchException(r7.length, r11.length);
    L19:
        throw new DimensionMismatchException(r7.length, r8.length);
    }

    @Override // org.apache.commons.math3.analysis.MultivariateFunction
    public double value(double[] r13) {
        int r0 = 0;
    L4:
        if (r0 >= this.scale.length) goto L25;
        double r1 = r13[r0];
        if (r1 < this.lower[r0]) goto L11;
        if (r1 > this.upper[r0]) goto L11;
        r0 = r0 + 1;
    L11:
        double r3 = 0.0d;
    L12:
        double[] r5 = this.scale;
        if (r0 >= r5.length) goto L23;
        double r6 = r13[r0];
        double r8 = this.lower[r0];
        if (r6 >= r8) goto L17;
        double r10 = r5[r0] * (r8 - r6);
    L21:
        r3 = r3 + FastMath.sqrt(r10);
        r0 = r0 + 1;
        goto L12
    L17:
        double r9 = this.upper[r0];
        if (r6 <= r9) goto L20;
        r10 = r5[r0] * (r6 - r9);
        goto L21
    L20:
        r10 = 0.0d;
        goto L21
    L23:
        return this.offset + r3;
    L25:
        return this.bounded.value(r13);
    }
}
