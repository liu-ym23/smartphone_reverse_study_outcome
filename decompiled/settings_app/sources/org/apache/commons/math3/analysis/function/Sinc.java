package org.apache.commons.math3.analysis.function;

import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.FunctionUtils;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class Sinc implements UnivariateDifferentiableFunction, DifferentiableUnivariateFunction {
    private static final double SHORTCUT = 0.006d;
    private final boolean normalized;

    public Sinc() {
        this(false);
    }

    public Sinc(boolean r1) {
        this.normalized = r1;
    }

    @Override // org.apache.commons.math3.analysis.UnivariateFunction
    public double value(double r5) {
        if (this.normalized == false) goto L6;
        r5 = r5 * 3.141592653589793d;
    L6:
        if (FastMath.abs(r5) > SHORTCUT) goto L10;
        double r6 = r5 * r5;
        return (((r6 - 20.0d) * r6) + 120.0d) / 120.0d;
    L10:
        return FastMath.sin(r5) / r5;
    }

    @Override // org.apache.commons.math3.analysis.DifferentiableUnivariateFunction
    @Deprecated
    public UnivariateFunction derivative() {
        return FunctionUtils.toDifferentiableUnivariateFunction(this).derivative();
    }

    @Override // org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction
    public DerivativeStructure value(DerivativeStructure r27) throws DimensionMismatchException {
        Sinc r0 = this;
        double r4 = 1.0d;
        if (r0.normalized == false) goto L5;
        double r6 = 3.141592653589793d;
    L6:
        double r7 = r6 * r27.getValue();
        double r8 = r7 * r7;
        int r10 = 1;
        int r1 = r27.getOrder() + 1;
        double[] r11 = new double[r1];
        int r13 = 0;
        if (FastMath.abs(r7) > SHORTCUT) goto L23;
    L8:
        if (r13 >= r1) goto L22;
        int r12 = r13 / 2;
        if ((r13 & 1) == 0) goto L12;
        double[] r16 = r11;
        if ((r12 & 1) != 0) goto L19;
        double r2 = -r7;
    L20:
        r16[r13] = r2 * ((1.0d / ((double) (r13 + 2))) - (((1.0d / ((double) ((r13 * 6) + 24))) - (r8 / ((double) ((r13 * 120) + 720)))) * r8));
    L21:
        r13 = r13 + 1;
        r11 = r16;
        r4 = 1.0d;
        r10 = 1;
        goto L8
    L19:
        r2 = r7;
        goto L20
    L12:
        if ((r12 & 1) != 0) goto L14;
        int r14 = r10;
    L15:
        r16 = r11;
        r16[r13] = ((double) r14) * ((r4 / ((double) (r13 + 1))) - (((r4 / ((double) ((r13 * 2) + 6))) - (r8 / ((double) ((r13 * 24) + 120)))) * r8));
        goto L21
    L14:
        r14 = -1;
        goto L15
    L22:
        double[] r17 = r11;
        int r23 = r1;
    L35:
        if (r0.normalized == false) goto L40;
        int r3 = r23;
        double r5 = 3.141592653589793d;
        int r15 = 1;
    L37:
        if (r15 >= r3) goto L40;
        r17[r15] = r17[r15] * r5;
        r5 = r5 * 3.141592653589793d;
        r15 = r15 + 1;
    L40:
        return r27.compose(r17);
    L23:
        r17 = r11;
        double r9 = 1.0d / r7;
        double r18 = FastMath.cos(r7);
        double r19 = FastMath.sin(r7);
        r17[0] = r9 * r19;
        double[] r110 = new double[r1];
        r110[0] = 1.0d;
        double r111 = r9;
        int r20 = 1;
    L24:
        if (r20 >= r1) goto L33;
        double r112 = 0.0d;
        if ((r20 & 1) != 0) goto L28;
        r110[r20] = 0.0d;
        int r21 = r20;
        double r22 = 0.0d;
    L30:
        if (r21 <= 1) goto L32;
        int r113 = r21 - 1;
        double r24 = (((double) (r21 - r20)) * r110[r21]) - r110[r113];
        r110[r21] = r24;
        r112 = (r112 * r8) + r24;
        double r25 = (((double) (r113 - r20)) * r110[r113]) + r110[r21 - 2];
        r110[r113] = r25;
        r22 = (r22 * r8) + r25;
        r21 = r21 - 2;
        r1 = r1;
        goto L30
    L32:
        int r26 = r20;
        double r28 = r110[0] * ((double) (-r20));
        r110[0] = r28;
        r111 = r111 * r9;
        r17[r26] = ((((r112 * r8) + r28) * r19) + ((r22 * r7) * r18)) * r111;
        r20 = r26 + 1;
        r1 = r1;
        goto L24
    L28:
        r21 = r20 - 1;
        r22 = r110[r21];
        r110[r20] = r22;
        goto L30
    L33:
        r23 = r1;
        r0 = this;
        goto L35
    L5:
        r6 = 1.0d;
        goto L6
    }
}
