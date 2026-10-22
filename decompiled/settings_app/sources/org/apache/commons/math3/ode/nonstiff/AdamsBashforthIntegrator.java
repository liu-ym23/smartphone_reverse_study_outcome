package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.ode.EquationsMapper;
import org.apache.commons.math3.ode.ExpandableStatefulODE;
import org.apache.commons.math3.ode.sampling.NordsieckStepInterpolator;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class AdamsBashforthIntegrator extends AdamsIntegrator {
    private static final String METHOD_NAME = "Adams-Bashforth";

    public AdamsBashforthIntegrator(int r13, double r14, double r16, double r18, double r20) throws NumberIsTooSmallException {
        super(METHOD_NAME, r13, r13, r14, r16, r18, r20);
    }

    public AdamsBashforthIntegrator(int r11, double r12, double r14, double[] r16, double[] r17) throws IllegalArgumentException {
        super(METHOD_NAME, r11, r11, r12, r14, r16, r17);
    }

    private double errorEstimation(double[] r18, double[] r19, double[] r20, RealMatrix r21) {
        int r3 = 0;
        double r4 = 0.0d;
    L4:
        if (r3 >= this.mainSetDimension) goto L18;
        double r6 = FastMath.abs(r19[r3]);
        if (this.vecAbsoluteTolerance != null) goto L8;
        double r8 = this.scalAbsoluteTolerance;
        double r10 = this.scalRelativeTolerance;
    L9:
        double r9 = r8 + (r10 * r6);
        if ((r21.getRowDimension() % 2) != 0) goto L12;
        int r7 = -1;
    L13:
        int r11 = r21.getRowDimension() - 1;
        double r12 = 0.0d;
    L14:
        if (r11 < 0) goto L16;
        r12 = r12 + (((double) r7) * r21.getEntry(r11, r3));
        r7 = -r7;
        r11 = r11 - 1;
        goto L14
    L16:
        double r13 = ((r19[r3] - r18[r3]) + (r12 - r20[r3])) / r9;
        r4 = r4 + (r13 * r13);
        r3 = r3 + 1;
        goto L4
    L12:
        r7 = 1;
        goto L13
    L8:
        r8 = this.vecAbsoluteTolerance[r3];
        r10 = this.vecRelativeTolerance[r3];
        goto L9
    L18:
        return FastMath.sqrt(r4 / ((double) this.mainSetDimension));
    }

    @Override // org.apache.commons.math3.ode.nonstiff.AdamsIntegrator, org.apache.commons.math3.ode.nonstiff.AdaptiveStepsizeIntegrator, org.apache.commons.math3.ode.AbstractIntegrator
    public void integrate(ExpandableStatefulODE r26, double r27) throws NumberIsTooSmallException, DimensionMismatchException, MaxCountExceededException, NoBracketingException {
        sanityChecks(r26, r27);
        setEquations(r26);
        if (r27 <= r26.getTime()) goto L5;
        boolean r10 = true;
    L6:
        double[] r11 = r26.getCompleteState();
        double[] r12 = new double[r11.length];
        NordsieckStepInterpolator r14 = new NordsieckStepInterpolator();
        r14.reinitialize(r11, r10, r26.getPrimaryMapper(), r26.getSecondaryMappers());
        initIntegration(r26.getTime(), r11, r27);
        start(r26.getTime(), r11, r27);
        r14.reinitialize(this.stepStart, this.stepSize, this.scaled, this.nordsieck);
        r14.storeTime(this.stepStart);
        double r0 = this.stepSize;
        r14.rescale(r0);
        this.isLastStep = false;
    L7:
        r14.shift();
        double[] r2 = new double[r11.length];
        int r3 = r11.length;
        double[] r4 = new double[r3];
        Array2DRowRealMatrix r5 = null;
        double r15 = 10.0d;
    L9:
        if (r15 < 1.0d) goto L20;
        double r13 = this.stepStart + r0;
        r14.storeTime(r13);
        ExpandableStatefulODE r6 = getExpandable();
        r6.getPrimaryMapper().insertEquationData(r14.getInterpolatedState(), r2);
        EquationsMapper[] r7 = r6.getSecondaryMappers();
        int r9 = r7.length;
        int r8 = 0;
        int r16 = 0;
    L11:
        if (r16 >= r9) goto L13;
        r7[r16].insertEquationData(r14.getInterpolatedSecondaryState(r8), r2);
        r8 = r8 + 1;
        r16 = r16 + 1;
        r9 = r9;
        r7 = r7;
        goto L11
    L13:
        computeDerivatives(r13, r2, r12);
        int r17 = 0;
    L14:
        if (r17 >= r3) goto L16;
        r4[r17] = r12[r17] * r0;
        r17 = r17 + 1;
        goto L14
    L16:
        r5 = updateHighOrderDerivativesPhase1(this.nordsieck);
        updateHighOrderDerivativesPhase2(this.scaled, r4, r5);
        r15 = errorEstimation(r11, r2, r4, r5);
        if (r15 < 1.0d) goto L9;
        r0 = filterStep(r0 * computeStepGrowShrinkFactor(r15), r10, false);
        r14.rescale(r0);
        goto L9
    L20:
        this.stepSize = r0;
        boolean r18 = r10;
        double r21 = r0;
        double r19 = this.stepStart + this.stepSize;
        double r23 = r15;
        r14.reinitialize(r19, this.stepSize, r4, r5);
        r14.storeTime(r19);
        System.arraycopy(r2, 0, r11, 0, r11.length);
        this.stepStart = acceptStep(r14, r11, r12, r27);
        this.scaled = r4;
        this.nordsieck = r5;
        r14.reinitialize(r19, this.stepSize, this.scaled, this.nordsieck);
        if (this.isLastStep == true) goto L46;
        r14.storeTime(this.stepStart);
        if (this.resetOccurred == false) goto L25;
        start(this.stepStart, r11, r27);
        r14.reinitialize(this.stepStart, this.stepSize, this.scaled, this.nordsieck);
    L25:
        double r20 = this.stepSize * computeStepGrowShrinkFactor(r23);
        double r1 = this.stepStart + r20;
        if (r18 == false) goto L31;
        if (r1 >= r27) goto L32;
    L33:
        boolean r22 = false;
    L34:
        r0 = filterStep(r20, r18, r22);
        double r24 = this.stepStart + r0;
        if (r18 == false) goto L40;
        if (r24 >= r27) goto L41;
    L42:
        boolean r25 = false;
    L43:
        if (r25 == false) goto L45;
        r0 = r27 - this.stepStart;
    L45:
        r14.rescale(r0);
    L48:
        if (this.isLastStep == true) goto L49;
        r10 = r18;
        goto L7
    L49:
        r26.setTime(this.stepStart);
        r26.setCompleteState(r11);
        resetInternalState();
        return;
    L41:
        r25 = true;
        goto L43
    L40:
        if (r24 > r27) goto L42;
    L32:
        r22 = true;
        goto L34
    L31:
        if (r1 > r27) goto L33;
    L46:
        r0 = r21;
        goto L48
    L5:
        r10 = false;
        goto L6
    }
}
