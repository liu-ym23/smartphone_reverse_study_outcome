package org.apache.commons.math3.ode.nonstiff;

import java.lang.reflect.Array;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.ode.ExpandableStatefulODE;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public abstract class EmbeddedRungeKuttaIntegrator extends AdaptiveStepsizeIntegrator {
    private final double[][] a;
    private final double[] b;
    private final double[] c;
    private final double exp;
    private final boolean fsal;
    private double maxGrowth;
    private double minReduction;
    private final RungeKuttaStepInterpolator prototype;
    private double safety;

    protected abstract double estimateError(double[][] r1, double[] r2, double[] r3, double r4);

    public abstract int getOrder();

    protected EmbeddedRungeKuttaIntegrator(String r12, boolean r13, double[] r14, double[][] r15, double[] r16, RungeKuttaStepInterpolator r17, double r18, double r20, double r22, double r24) {
        super(r12, r18, r20, r22, r24);
        this.fsal = r13;
        this.c = r14;
        this.a = r15;
        this.b = r16;
        this.prototype = r17;
        this.exp = (-1.0d) / ((double) getOrder());
        setSafety(0.9d);
        setMinReduction(0.2d);
        setMaxGrowth(10.0d);
    }

    protected EmbeddedRungeKuttaIntegrator(String r10, boolean r11, double[] r12, double[][] r13, double[] r14, RungeKuttaStepInterpolator r15, double r16, double r18, double[] r20, double[] r21) {
        super(r10, r16, r18, r20, r21);
        this.fsal = r11;
        this.c = r12;
        this.a = r13;
        this.b = r14;
        this.prototype = r15;
        this.exp = (-1.0d) / ((double) getOrder());
        setSafety(0.9d);
        setMinReduction(0.2d);
        setMaxGrowth(10.0d);
    }

    public double getSafety() {
        return this.safety;
    }

    public void setSafety(double r1) {
        this.safety = r1;
    }

    @Override // org.apache.commons.math3.ode.nonstiff.AdaptiveStepsizeIntegrator, org.apache.commons.math3.ode.AbstractIntegrator
    public void integrate(ExpandableStatefulODE r30, double r31) throws NumberIsTooSmallException, DimensionMismatchException, MaxCountExceededException, NoBracketingException {
        EmbeddedRungeKuttaIntegrator r10 = this;
        sanityChecks(r30, r31);
        setEquations(r30);
        int r13 = 0;
        if (r31 <= r30.getTime()) goto L5;
        boolean r14 = true;
    L6:
        double[] r15 = r30.getCompleteState();
        double[] r9 = (double[]) r15.clone();
        int r8 = r10.c.length + 1;
        double[][] r16 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r8, r9.length});
        double[] r7 = (double[]) r15.clone();
        double[] r6 = new double[r9.length];
        RungeKuttaStepInterpolator r5 = (RungeKuttaStepInterpolator) r10.prototype.copy();
        double[] r20 = r6;
        r5.reinitialize(this, r7, r16, r14, r30.getPrimaryMapper(), r30.getSecondaryMappers());
        r5.storeTime(r30.getTime());
        r10.stepStart = r30.getTime();
        initIntegration(r30.getTime(), r15, r31);
        r10.isLastStep = false;
        double r0 = 0.0d;
        boolean r2 = true;
    L7:
        r5.shift();
        double r17 = r0;
        boolean r11 = r2;
        double r4 = 10.0d;
    L9:
        if (r4 < 1.0d) goto L55;
        if (r11 == false) goto L12;
    L13:
        r10.computeDerivatives(r10.stepStart, r9, r16[r13]);
    L14:
        if (r11 == false) goto L25;
        int r1 = r10.mainSetDimension;
        double[] r3 = new double[r1];
        if (r10.vecAbsoluteTolerance != null) goto L21;
        int r12 = r13;
    L18:
        if (r12 >= r1) goto L20;
        r3[r12] = r10.scalAbsoluteTolerance + (r10.scalRelativeTolerance * FastMath.abs(r9[r12]));
        r12 = r12 + 1;
        r14 = r14;
        goto L18
    L20:
        boolean r23 = r14;
    L24:
        double[] r19 = r7;
        double r18 = initializeStep(r23, getOrder(), r3, r10.stepStart, r9, r16[0], r19, r16[1]);
        r11 = false;
    L26:
        r10.stepSize = r18;
        if (r23 == false) goto L32;
        if ((r10.stepStart + r10.stepSize) < r31) goto L34;
        r10.stepSize = r31 - r10.stepStart;
    L34:
        int r21 = 1;
    L35:
        if (r21 >= r8) goto L44;
        int r22 = 0;
    L38:
        if (r22 >= r15.length) goto L43;
        int r24 = r21 - 1;
        double r110 = r10.a[r24][0] * r16[0][r22];
        int r25 = 1;
    L40:
        if (r25 >= r21) goto L42;
        r110 = r110 + (r10.a[r24][r25] * r16[r25][r22]);
        r25 = r25 + 1;
        goto L40
    L42:
        r19[r22] = r9[r22] + (r10.stepSize * r110);
        r22 = r22 + 1;
        goto L38
    L43:
        r10.computeDerivatives(r10.stepStart + (r10.c[r21 - 1] * r10.stepSize), r19, r16[r21]);
        r21 = r21 + 1;
        r11 = r11;
        goto L35
    L44:
        r11 = r11;
        double[] r26 = r19;
        int r27 = 0;
    L46:
        if (r27 >= r15.length) goto L51;
        double r28 = r10.b[0] * r16[0][r27];
        int r29 = 1;
    L48:
        if (r29 >= r8) goto L50;
        r28 = r28 + (r10.b[r29] * r16[r29][r27]);
        r29 = r29 + 1;
        goto L48
    L50:
        r26[r27] = r9[r27] + (r10.stepSize * r28);
        r27 = r27 + 1;
        goto L46
    L51:
        r4 = estimateError(r16, r9, r26, r10.stepSize);
        if (r4 >= 1.0d) goto L53;
        r17 = r18;
        r7 = r26;
        r14 = r23;
        r13 = 0;
        goto L9
    L53:
        boolean r32 = r23;
        r7 = r26;
        r17 = r10.filterStep(r10.stepSize * FastMath.min(r10.maxGrowth, FastMath.max(r10.minReduction, r10.safety * FastMath.pow(r4, r10.exp))), r32, false);
        r13 = 0;
        r14 = r32;
        goto L9
    L32:
        if ((r10.stepStart + r10.stepSize) > r31) goto L34;
        r10.stepSize = r31 - r10.stepStart;
        goto L34
    L21:
        r23 = r14;
        int r33 = 0;
    L22:
        if (r33 >= r1) goto L24;
        r3[r33] = r10.vecAbsoluteTolerance[r33] + (r10.vecRelativeTolerance[r33] * FastMath.abs(r9[r33]));
        r33 = r33 + 1;
        goto L22
    L25:
        r19 = r7;
        r23 = r14;
        r18 = r17;
        goto L26
    L12:
        if (r10.fsal == true) goto L14;
    L55:
        double[] r111 = r7;
        boolean r34 = r14;
        double[] r112 = r9;
        int r35 = r13;
        int r113 = r8;
        r5.storeTime(r10.stepStart + r10.stepSize);
        System.arraycopy(r111, r35, r112, r35, r15.length);
        double[] r36 = r20;
        System.arraycopy(r16[r113 - 1], r35, r36, r35, r15.length);
        double r210 = r4;
        r10.stepStart = acceptStep(r5, r112, r36, r31);
        System.arraycopy(r112, r35, r111, r35, r112.length);
        if (r10.isLastStep == true) goto L80;
        r5.storeTime(r10.stepStart);
        if (r10.fsal == false) goto L60;
        System.arraycopy(r36, r35, r16[r35], r35, r15.length);
    L60:
        boolean r114 = r11;
        double[] r211 = r111;
        EmbeddedRungeKuttaIntegrator r37 = this;
        double r38 = r37.stepSize * FastMath.min(r10.maxGrowth, FastMath.max(r10.minReduction, r10.safety * FastMath.pow(r210, r10.exp)));
        double r39 = r37.stepStart + r38;
        boolean r40 = r34;
        if (r40 == false) goto L66;
        if (r39 >= r31) goto L67;
    L68:
        boolean r41 = false;
    L69:
        r0 = r37.filterStep(r38, r40, r41);
        double r42 = r37.stepStart + r0;
        if (r40 == false) goto L75;
        if (r42 >= r31) goto L76;
    L77:
        boolean r43 = false;
    L78:
        if (r43 == false) goto L82;
        r0 = r31 - r37.stepStart;
    L82:
        if (r37.isLastStep == true) goto L83;
        r10 = r37;
        r9 = r112;
        r2 = r114;
        r7 = r211;
        r14 = r40;
        r20 = r36;
        r8 = r113;
        r13 = 0;
        goto L7
    L83:
        r30.setTime(r37.stepStart);
        r30.setCompleteState(r112);
        resetInternalState();
        return;
    L76:
        r43 = true;
        goto L78
    L75:
        if (r42 > r31) goto L77;
    L67:
        r41 = true;
        goto L69
    L66:
        if (r39 > r31) goto L68;
    L80:
        r114 = r11;
        r211 = r111;
        r37 = r10;
        r40 = r34;
        r0 = r17;
        goto L82
    L5:
        r14 = false;
        goto L6
    }

    public double getMinReduction() {
        return this.minReduction;
    }

    public void setMinReduction(double r1) {
        this.minReduction = r1;
    }

    public double getMaxGrowth() {
        return this.maxGrowth;
    }

    public void setMaxGrowth(double r1) {
        this.maxGrowth = r1;
    }
}
