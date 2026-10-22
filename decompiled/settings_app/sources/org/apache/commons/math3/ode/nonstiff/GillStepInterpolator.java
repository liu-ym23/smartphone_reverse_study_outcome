package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.ode.sampling.StepInterpolator;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
class GillStepInterpolator extends RungeKuttaStepInterpolator {
    private static final double ONE_MINUS_INV_SQRT_2 = 0.0d;
    private static final double ONE_PLUS_INV_SQRT_2 = 0.0d;
    private static final long serialVersionUID = 20111120;

    static {
        ONE_MINUS_INV_SQRT_2 = 1.0d - FastMath.sqrt(0.5d);
        ONE_PLUS_INV_SQRT_2 = FastMath.sqrt(0.5d) + 1.0d;
    }

    public GillStepInterpolator() {
    }

    GillStepInterpolator(GillStepInterpolator r1) {
        super(r1);
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    protected StepInterpolator doCopy() {
        return new GillStepInterpolator(this);
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    protected void computeInterpolatedStateAndDerivatives(double r37, double r39) {
        double r3 = r37 * 2.0d;
        double r5 = r3 * r3;
        double r7 = ((r3 - 3.0d) * r37) + 1.0d;
        double r11 = (1.0d - r37) * r3;
        double r13 = ONE_MINUS_INV_SQRT_2;
        double r15 = r11 * r13;
        double r17 = ONE_PLUS_INV_SQRT_2;
        double r12 = r11 * r17;
        double r19 = (r3 - 1.0d) * r37;
        if (this.previousState != null) goto L5;
    L10:
        double r26 = r39 / 6.0d;
        double r4 = ((r3 + 2.0d) - r5) * r26;
        double r1 = ((1.0d - (5.0d * r37)) + r5) * r26;
        double r14 = r13 * r4;
        double r6 = r4 * r17;
        double r27 = r26 * ((r37 + 1.0d) + r5);
        int r8 = 0;
    L12:
        if (r8 >= this.interpolatedState.length) goto L17;
        double r18 = this.yDotK[0][r8];
        double r21 = this.yDotK[1][r8];
        double r28 = this.yDotK[2][r8];
        double r30 = this.yDotK[3][r8];
        this.interpolatedState[r8] = (((this.currentState[r8] - (r1 * r18)) - (r14 * r21)) - (r6 * r28)) - (r27 * r30);
        this.interpolatedDerivatives[r8] = (((r18 * r7) + (r21 * r15)) + (r28 * r12)) + (r30 * r19);
        r8 = r8 + 1;
        goto L12
    L17:
        return;
    L5:
        if (r37 > 0.5d) goto L10;
        double r2 = (this.h * r37) / 6.0d;
        double r9 = ((r37 * 6.0d) - r5) * r2;
        double r29 = ((6.0d - (9.0d * r37)) + r5) * r2;
        double r16 = r13 * r9;
        double r10 = r9 * r17;
        double r20 = r2 * (((-3.0d) * r37) + r5);
        int r22 = 0;
    L8:
        if (r22 >= this.interpolatedState.length) goto L14;
        double r110 = this.yDotK[0][r22];
        double r23 = this.yDotK[1][r22];
        double r210 = this.yDotK[2][r22];
        double r31 = this.yDotK[3][r22];
        this.interpolatedState[r22] = (((this.previousState[r22] + (r29 * r110)) + (r16 * r23)) + (r10 * r210)) + (r20 * r31);
        this.interpolatedDerivatives[r22] = (((r110 * r7) + (r23 * r15)) + (r210 * r12)) + (r31 * r19);
        r22 = r22 + 1;
        goto L8
    }
}
