package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.ode.AbstractIntegrator;
import org.apache.commons.math3.ode.ExpandableStatefulODE;
import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public abstract class RungeKuttaIntegrator extends AbstractIntegrator {
    private final double[][] a;
    private final double[] b;
    private final double[] c;
    private final RungeKuttaStepInterpolator prototype;
    private final double step;

    protected RungeKuttaIntegrator(String r1, double[] r2, double[][] r3, double[] r4, RungeKuttaStepInterpolator r5, double r6) {
        super(r1);
        this.c = r2;
        this.a = r3;
        this.b = r4;
        this.prototype = r5;
        this.step = FastMath.abs(r6);
    }

    @Override // org.apache.commons.math3.ode.AbstractIntegrator
    public void integrate(ExpandableStatefulODE r24, double r25) throws NumberIsTooSmallException, DimensionMismatchException, MaxCountExceededException, NoBracketingException {
        sanityChecks(r24, r25);
        setEquations(r24);
        int r10 = 0;
        if (r25 <= r24.getTime()) goto L5;
        boolean r11 = true;
    L6:
        double[] r12 = r24.getCompleteState();
        double[] r13 = (double[]) r12.clone();
        int r14 = this.c.length + 1;
        double[][] r15 = new double[r14][];
        int r0 = 0;
    L7:
        if (r0 >= r14) goto L9;
        r15[r0] = new double[r12.length];
        r0 = r0 + 1;
        goto L7
    L9:
        double[] r6 = (double[]) r12.clone();
        double[] r5 = new double[r12.length];
        RungeKuttaStepInterpolator r4 = (RungeKuttaStepInterpolator) this.prototype.copy();
        double[] r18 = r5;
        double[] r19 = r6;
        r4.reinitialize(this, r6, r15, r11, r24.getPrimaryMapper(), r24.getSecondaryMappers());
        r4.storeTime(r24.getTime());
        this.stepStart = r24.getTime();
        if (r11 == false) goto L15;
        double r1 = this.stepStart;
        double r2 = this.step;
        if ((r1 + r2) < r25) goto L14;
        this.stepSize = r25 - this.stepStart;
    L19:
        initIntegration(r24.getTime(), r12, r25);
        this.isLastStep = false;
    L20:
        r4.shift();
        computeDerivatives(this.stepStart, r13, r15[r10]);
        int r3 = 1;
    L21:
        if (r3 >= r14) goto L30;
        int r7 = r10;
    L24:
        if (r7 >= r12.length) goto L29;
        int r8 = r3 - 1;
        double r9 = this.a[r8][r10] * r15[r10][r7];
        int r16 = 1;
    L26:
        if (r16 >= r3) goto L28;
        r9 = r9 + (this.a[r8][r16] * r15[r16][r7]);
        r16 = r16 + 1;
        goto L26
    L28:
        r19[r7] = r13[r7] + (this.stepSize * r9);
        r7 = r7 + 1;
        r11 = r11;
        r10 = 0;
        goto L24
    L29:
        computeDerivatives(this.stepStart + (this.c[r3 - 1] * this.stepSize), r19, r15[r3]);
        r3 = r3 + 1;
        r10 = 0;
        goto L21
    L30:
        boolean r17 = r11;
        double[] r110 = r19;
        int r20 = 0;
    L32:
        if (r20 >= r12.length) goto L37;
        double r21 = this.b[0] * r15[0][r20];
        int r22 = 1;
    L34:
        if (r22 >= r14) goto L36;
        r21 = r21 + (this.b[r22] * r15[r22][r20]);
        r22 = r22 + 1;
        goto L34
    L36:
        r110[r20] = r13[r20] + (this.stepSize * r21);
        r20 = r20 + 1;
        goto L32
    L37:
        r4.storeTime(this.stepStart + this.stepSize);
        System.arraycopy(r110, 0, r13, 0, r12.length);
        double[] r23 = r18;
        System.arraycopy(r15[r14 - 1], 0, r23, 0, r12.length);
        this.stepStart = acceptStep(r4, r13, r23, r25);
        if (this.isLastStep == true) goto L51;
        r4.storeTime(this.stepStart);
        double r26 = this.stepStart + this.stepSize;
        if (r17 == false) goto L45;
        if (r26 >= r25) goto L46;
    L47:
        boolean r27 = false;
    L48:
        if (r27 == false) goto L51;
        this.stepSize = r25 - this.stepStart;
    L46:
        r27 = true;
        goto L48
    L45:
        if (r26 > r25) goto L47;
    L51:
        if (this.isLastStep == true) goto L52;
        r18 = r23;
        r19 = r110;
        r10 = 0;
        r11 = r17;
        goto L20
    L52:
        r24.setTime(this.stepStart);
        r24.setCompleteState(r13);
        this.stepStart = Double.NaN;
        this.stepSize = Double.NaN;
        return;
    L14:
        this.stepSize = r2;
        goto L19
    L15:
        double r28 = this.stepStart;
        double r29 = this.step;
        if ((r28 - r29) > r25) goto L18;
        this.stepSize = r25 - this.stepStart;
        goto L19
    L18:
        this.stepSize = -r29;
        goto L19
    L5:
        r11 = false;
        goto L6
    }

    public double[] singleStep(FirstOrderDifferentialEquations r25, double r26, double[] r28, double r29) {
        double[] r5 = (double[]) r28.clone();
        int r7 = 1;
        int r6 = this.c.length + 1;
        double[][] r8 = new double[r6][];
        int r10 = 0;
    L3:
        if (r10 >= r6) goto L5;
        r8[r10] = new double[r28.length];
        r10 = r10 + 1;
        goto L3
    L5:
        double[] r11 = (double[]) r28.clone();
        double r12 = r29 - r26;
        r25.computeDerivatives(r26, r5, r8[0]);
        int r13 = 1;
    L6:
        if (r13 >= r6) goto L15;
        int r14 = 0;
    L9:
        if (r14 >= r28.length) goto L14;
        int r16 = r13 - 1;
        double r17 = this.a[r16][0] * r8[0][r14];
        int r15 = r7;
    L11:
        if (r15 >= r13) goto L13;
        r17 = r17 + (this.a[r16][r15] * r8[r15][r14]);
        r15 = r15 + 1;
        goto L11
    L13:
        r11[r14] = r5[r14] + (r17 * r12);
        r14 = r14 + 1;
        r7 = 1;
        goto L9
    L14:
        r25.computeDerivatives((this.c[r13 - 1] * r12) + r26, r11, r8[r13]);
        r13 = r13 + 1;
        r7 = 1;
        goto L6
    L15:
        int r1 = 0;
    L17:
        if (r1 >= r28.length) goto L22;
        double r2 = this.b[0] * r8[0][r1];
        int r9 = 1;
    L19:
        if (r9 >= r6) goto L21;
        r2 = r2 + (this.b[r9] * r8[r9][r1]);
        r9 = r9 + 1;
        goto L19
    L21:
        r5[r1] = r5[r1] + (r2 * r12);
        r1 = r1 + 1;
        goto L17
    L22:
        return r5;
    }
}
