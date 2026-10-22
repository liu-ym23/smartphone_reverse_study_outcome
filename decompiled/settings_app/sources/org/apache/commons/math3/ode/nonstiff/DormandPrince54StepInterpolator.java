package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.ode.AbstractIntegrator;
import org.apache.commons.math3.ode.EquationsMapper;
import org.apache.commons.math3.ode.sampling.StepInterpolator;

/* JADX INFO: loaded from: classes6.dex */
class DormandPrince54StepInterpolator extends RungeKuttaStepInterpolator {
    private static final double A70 = 0.09114583333333333d;
    private static final double A72 = 0.44923629829290207d;
    private static final double A73 = 0.6510416666666666d;
    private static final double A74 = -0.322376179245283d;
    private static final double A75 = 0.13095238095238096d;
    private static final double D0 = -1.1270175653862835d;
    private static final double D2 = 2.675424484351598d;
    private static final double D3 = -5.685526961588504d;
    private static final double D4 = 3.5219323679207912d;
    private static final double D5 = -1.7672812570757455d;
    private static final double D6 = 2.382468931778144d;
    private static final long serialVersionUID = 20111120;
    private double[] v1;
    private double[] v2;
    private double[] v3;
    private double[] v4;
    private boolean vectorsInitialized;

    public DormandPrince54StepInterpolator() {
        this.v1 = null;
        this.v2 = null;
        this.v3 = null;
        this.v4 = null;
        this.vectorsInitialized = false;
    }

    DormandPrince54StepInterpolator(DormandPrince54StepInterpolator r2) {
        super(r2);
        double[] r0 = r2.v1;
        if (r0 != null) goto L5;
        this.v1 = null;
        this.v2 = null;
        this.v3 = null;
        this.v4 = null;
        this.vectorsInitialized = false;
        return;
    L5:
        this.v1 = (double[]) r0.clone();
        this.v2 = (double[]) r2.v2.clone();
        this.v3 = (double[]) r2.v3.clone();
        this.v4 = (double[]) r2.v4.clone();
        this.vectorsInitialized = r2.vectorsInitialized;
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    protected StepInterpolator doCopy() {
        return new DormandPrince54StepInterpolator(this);
    }

    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaStepInterpolator
    public void reinitialize(AbstractIntegrator r1, double[] r2, double[][] r3, boolean r4, EquationsMapper r5, EquationsMapper[] r6) {
        super.reinitialize(r1, r2, r3, r4, r5, r6);
        this.v1 = null;
        this.v2 = null;
        this.v3 = null;
        this.v4 = null;
        this.vectorsInitialized = false;
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public void storeTime(double r1) {
        super.storeTime(r1);
        this.vectorsInitialized = false;
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    protected void computeInterpolatedStateAndDerivatives(double r26, double r28) {
        char r2 = 0;
        if (this.vectorsInitialized == false) goto L5;
    L12:
        double r3 = 1.0d - r26;
        double r7 = r26 * 2.0d;
        double r9 = 1.0d - r7;
        double r5 = (2.0d - (r26 * 3.0d)) * r26;
        double r8 = r7 * (((r7 - 3.0d) * r26) + 1.0d);
        if (this.previousState != null) goto L15;
    L20:
        int r4 = 0;
    L22:
        if (r4 >= this.interpolatedState.length) goto L28;
        this.interpolatedState[r4] = this.currentState[r4] - ((this.v1[r4] - ((this.v2[r4] + ((this.v3[r4] + (this.v4[r4] * r3)) * r26)) * r26)) * r28);
        this.interpolatedDerivatives[r4] = ((this.v1[r4] + (r9 * this.v2[r4])) + (this.v3[r4] * r5)) + (this.v4[r4] * r8);
        r4 = r4 + 1;
        goto L22
    L28:
        return;
    L15:
        if (r26 > 0.5d) goto L20;
        int r6 = 0;
    L18:
        if (r6 >= this.interpolatedState.length) goto L24;
        double r19 = r8;
        double r21 = r5;
        double r23 = r9;
        this.interpolatedState[r6] = this.previousState[r6] + ((this.h * r26) * (this.v1[r6] + ((this.v2[r6] + ((this.v3[r6] + (this.v4[r6] * r3)) * r26)) * r3)));
        this.interpolatedDerivatives[r6] = ((this.v1[r6] + (r23 * this.v2[r6])) + (this.v3[r6] * r21)) + (this.v4[r6] * r19);
        r6 = r6 + 1;
        r8 = r19;
        r5 = r21;
        r9 = r23;
        goto L18
    L24:
        return;
    L5:
        if (this.v1 != null) goto L7;
        this.v1 = new double[this.interpolatedState.length];
        this.v2 = new double[this.interpolatedState.length];
        this.v3 = new double[this.interpolatedState.length];
        this.v4 = new double[this.interpolatedState.length];
    L7:
        int r1 = 0;
    L9:
        if (r1 >= this.interpolatedState.length) goto L11;
        double r10 = this.yDotK[r2][r1];
        double r11 = this.yDotK[2][r1];
        double r12 = this.yDotK[3][r1];
        double r13 = this.yDotK[4][r1];
        double r14 = this.yDotK[5][r1];
        double r15 = this.yDotK[6][r1];
        double[] r16 = this.v1;
        double r17 = ((((A70 * r10) + (A72 * r11)) + (A73 * r12)) + (A74 * r13)) + (A75 * r14);
        r16[r1] = r17;
        double r18 = r10 - r17;
        this.v2[r1] = r18;
        this.v3[r1] = (r16[r1] - r18) - r15;
        this.v4[r1] = (((((r10 * D0) + (r11 * D2)) + (r12 * D3)) + (r13 * D4)) + (r14 * D5)) + (r15 * D6);
        r1 = r1 + 1;
        r2 = 0;
        goto L9
    L11:
        this.vectorsInitialized = true;
        goto L12
    }
}
