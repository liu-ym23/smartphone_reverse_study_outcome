package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.ode.sampling.StepInterpolator;

/* JADX INFO: loaded from: classes6.dex */
class ThreeEighthesStepInterpolator extends RungeKuttaStepInterpolator {
    private static final long serialVersionUID = 20111120;

    public ThreeEighthesStepInterpolator() {
    }

    ThreeEighthesStepInterpolator(ThreeEighthesStepInterpolator r1) {
        super(r1);
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    protected StepInterpolator doCopy() {
        return new ThreeEighthesStepInterpolator(this);
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    protected void computeInterpolatedStateAndDerivatives(double r37, double r39) {
        double r1 = 0.75d * r37;
        double r3 = 4.0d * r37;
        double r7 = ((r3 - 5.0d) * r1) + 1.0d;
        double r11 = (5.0d - (6.0d * r37)) * r1;
        double r15 = ((r37 * 2.0d) - 1.0d) * r1;
        if (this.previousState != null) goto L5;
    L10:
        double r5 = r39 / 8.0d;
        double r4 = r3 * r37;
        double r10 = ((1.0d - (7.0d * r37)) + (2.0d * r4)) * r5;
        double r20 = 3.0d * r5;
        double r12 = r37 + 1.0d;
        double r17 = (r12 - r4) * r20;
        double r21 = r20 * r12;
        double r6 = r5 * (r12 + r4);
        int r8 = 0;
    L12:
        if (r8 >= this.interpolatedState.length) goto L17;
        double r13 = this.yDotK[0][r8];
        double r22 = this.yDotK[1][r8];
        double r28 = this.yDotK[2][r8];
        double r30 = this.yDotK[3][r8];
        this.interpolatedState[r8] = (((this.currentState[r8] - (r10 * r13)) - (r17 * r22)) - (r21 * r28)) - (r6 * r30);
        this.interpolatedDerivatives[r8] = (((r13 * r7) + (r22 * r11)) + (r28 * r1)) + (r30 * r15);
        r8 = r8 + 1;
        goto L12
    L17:
        return;
    L5:
        if (r37 > 0.5d) goto L10;
        double r14 = (this.h * r37) / 8.0d;
        double r9 = r3 * r37;
        double r23 = ((8.0d - (15.0d * r37)) + (2.0d * r9)) * r14;
        double r24 = 3.0d * r14;
        double r16 = ((5.0d * r37) - r9) * r24;
        double r25 = r24 * r37;
        double r18 = r14 * (((-3.0d) * r37) + r9);
        int r19 = 0;
    L8:
        if (r19 >= this.interpolatedState.length) goto L14;
        double r110 = this.yDotK[0][r19];
        double r111 = this.yDotK[1][r19];
        double r29 = this.yDotK[2][r19];
        double r31 = this.yDotK[3][r19];
        this.interpolatedState[r19] = (((this.previousState[r19] + (r23 * r110)) + (r16 * r111)) + (r25 * r29)) + (r18 * r31);
        this.interpolatedDerivatives[r19] = (((r110 * r7) + (r111 * r11)) + (r29 * r1)) + (r31 * r15);
        r19 = r19 + 1;
        goto L8
    }
}
