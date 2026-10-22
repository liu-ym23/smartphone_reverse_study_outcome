package org.apache.commons.math3.ode.nonstiff;

import java.util.Arrays;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrixPreservingVisitor;
import org.apache.commons.math3.ode.EquationsMapper;
import org.apache.commons.math3.ode.ExpandableStatefulODE;
import org.apache.commons.math3.ode.sampling.NordsieckStepInterpolator;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class AdamsMoultonIntegrator extends AdamsIntegrator {
    private static final String METHOD_NAME = "Adams-Moulton";

    private class Corrector implements RealMatrixPreservingVisitor {
        private final double[] after;
        private final double[] before;
        private final double[] previous;
        private final double[] scaled;
        final /* synthetic */ AdamsMoultonIntegrator this$0;

        Corrector(AdamsMoultonIntegrator r1, double[] r2, double[] r3, double[] r4) {
            this.this$0 = r1;
            this.previous = r2;
            this.scaled = r3;
            this.after = r4;
            this.before = (double[]) r4.clone();
        }

        @Override // org.apache.commons.math3.linear.RealMatrixPreservingVisitor
        public void start(int r1, int r2, int r3, int r4, int r5, int r6) {
            Arrays.fill(this.after, 0.0d);
        }

        @Override // org.apache.commons.math3.linear.RealMatrixPreservingVisitor
        public void visit(int r3, int r4, double r5) {
            if ((r3 & 1) != 0) goto L5;
            double[] r2 = this.after;
            r2[r4] = r2[r4] - r5;
            return;
        L5:
            double[] r6 = this.after;
            r6[r4] = r6[r4] + r5;
        }

        @Override // org.apache.commons.math3.linear.RealMatrixPreservingVisitor
        public double end() {
            double r0 = 0.0d;
            int r2 = 0;
        L3:
            double[] r3 = this.after;
            if (r2 >= r3.length) goto L14;
            r3[r2] = r3[r2] + (this.previous[r2] + this.scaled[r2]);
            if (r2 >= this.this$0.mainSetDimension) goto L12;
            double r4 = FastMath.max(FastMath.abs(this.previous[r2]), FastMath.abs(this.after[r2]));
            if (this.this$0.vecAbsoluteTolerance != null) goto L10;
            double r5 = this.this$0.scalAbsoluteTolerance;
            double r7 = this.this$0.scalRelativeTolerance;
        L11:
            double r6 = r5 + (r7 * r4);
            double r8 = (this.after[r2] - this.before[r2]) / r6;
            r0 = r0 + (r8 * r8);
            goto L12
        L10:
            r5 = this.this$0.vecAbsoluteTolerance[r2];
            r7 = this.this$0.vecRelativeTolerance[r2];
        L12:
            r2 = r2 + 1;
            goto L3
        L14:
            return FastMath.sqrt(r0 / ((double) this.this$0.mainSetDimension));
        }
    }

    public AdamsMoultonIntegrator(int r13, double r14, double r16, double r18, double r20) throws NumberIsTooSmallException {
        super(METHOD_NAME, r13, r13 + 1, r14, r16, r18, r20);
    }

    public AdamsMoultonIntegrator(int r11, double r12, double r14, double[] r16, double[] r17) throws IllegalArgumentException {
        super(METHOD_NAME, r11, r11 + 1, r12, r14, r16, r17);
    }

    @Override // org.apache.commons.math3.ode.nonstiff.AdamsIntegrator, org.apache.commons.math3.ode.nonstiff.AdaptiveStepsizeIntegrator, org.apache.commons.math3.ode.AbstractIntegrator
    public void integrate(ExpandableStatefulODE r31, double r32) throws NumberIsTooSmallException, DimensionMismatchException, MaxCountExceededException, NoBracketingException {
        sanityChecks(r31, r32);
        setEquations(r31);
        if (r32 <= r31.getTime()) goto L5;
        boolean r10 = true;
    L6:
        double[] r11 = r31.getCompleteState();
        double[] r12 = (double[]) r11.clone();
        double[] r13 = new double[r12.length];
        double[] r14 = new double[r12.length];
        double[] r15 = new double[r12.length];
        NordsieckStepInterpolator r4 = new NordsieckStepInterpolator();
        r4.reinitialize(r12, r10, r31.getPrimaryMapper(), r31.getSecondaryMappers());
        initIntegration(r31.getTime(), r11, r32);
        start(r31.getTime(), r12, r32);
        r4.reinitialize(this.stepStart, this.stepSize, this.scaled, this.nordsieck);
        NordsieckStepInterpolator r5 = r4;
        r5.storeTime(this.stepStart);
        double r0 = this.stepSize;
        r5.rescale(r0);
        this.isLastStep = false;
        Array2DRowRealMatrix r2 = null;
    L7:
        Array2DRowRealMatrix r6 = r2;
        double r3 = r0;
        double r1 = 10.0d;
    L9:
        if (r1 < 1.0d) goto L22;
        this.stepSize = r3;
        boolean r24 = r10;
        double r7 = this.stepStart + this.stepSize;
        r5.setInterpolatedTime(r7);
        ExpandableStatefulODE r8 = getExpandable();
        r8.getPrimaryMapper().insertEquationData(r5.getInterpolatedState(), r14);
        EquationsMapper[] r9 = r8.getSecondaryMappers();
        int r16 = r9.length;
        int r17 = 0;
        int r18 = 0;
    L11:
        if (r18 >= r16) goto L13;
        r9[r18].insertEquationData(r5.getInterpolatedSecondaryState(r17), r14);
        r17 = r17 + 1;
        r18 = r18 + 1;
        r3 = r3;
        goto L11
    L13:
        double r26 = r3;
        computeDerivatives(r7, r14, r13);
        int r19 = 0;
    L15:
        if (r19 >= r11.length) goto L17;
        r15[r19] = this.stepSize * r13[r19];
        r19 = r19 + 1;
        goto L15
    L17:
        r6 = updateHighOrderDerivativesPhase1(this.nordsieck);
        updateHighOrderDerivativesPhase2(this.scaled, r15, r6);
        r1 = r6.walkInOptimizedOrder(new Corrector(this, r12, r15, r14));
        if (r1 < 1.0d) goto L20;
        r10 = r24;
        double r20 = filterStep(this.stepSize * computeStepGrowShrinkFactor(r1), r10, false);
        r5.rescale(r20);
        r3 = r20;
        goto L9
    L20:
        r10 = r24;
        r3 = r26;
        goto L9
    L22:
        double r27 = r3;
        double r21 = this.stepStart + this.stepSize;
        computeDerivatives(r21, r14, r13);
        double[] r22 = new double[r11.length];
        double r28 = r1;
        int r23 = 0;
    L24:
        if (r23 >= r11.length) goto L26;
        r22[r23] = this.stepSize * r13[r23];
        r23 = r23 + 1;
        goto L24
    L26:
        updateHighOrderDerivativesPhase2(r15, r22, r6);
        System.arraycopy(r14, 0, r12, 0, r12.length);
        r5.reinitialize(r21, this.stepSize, r22, r6);
        r5.storeTime(this.stepStart);
        r5.shift();
        r5.storeTime(r21);
        boolean r25 = r10;
        double[] r29 = r13;
        double[] r210 = r11;
        double[] r211 = r13;
        NordsieckStepInterpolator r110 = r5;
        Array2DRowRealMatrix r111 = r6;
        this.stepStart = acceptStep(r5, r12, r29, r32);
        this.scaled = r22;
        this.nordsieck = r111;
        if (this.isLastStep == true) goto L52;
        r110.storeTime(this.stepStart);
        if (this.resetOccurred == false) goto L31;
        start(this.stepStart, r12, r32);
        r110.reinitialize(this.stepStart, this.stepSize, this.scaled, this.nordsieck);
    L31:
        double r30 = this.stepSize * computeStepGrowShrinkFactor(r28);
        double r33 = this.stepStart + r30;
        if (r25 == false) goto L37;
        if (r33 >= r32) goto L38;
    L39:
        boolean r34 = false;
    L40:
        r0 = filterStep(r30, r25, r34);
        double r35 = this.stepStart + r0;
        if (r25 == 0) goto L46;
        if (r35 >= r32) goto L47;
    L48:
        boolean r36 = false;
    L49:
        if (r36 == false) goto L51;
        r0 = r32 - this.stepStart;
    L51:
        r110.rescale(r0);
    L54:
        if (this.isLastStep == true) goto L55;
        r10 = r25;
        r5 = r110;
        r2 = r111;
        r11 = r210;
        r13 = r211;
        goto L7
    L55:
        r31.setTime(this.stepStart);
        r31.setCompleteState(r12);
        resetInternalState();
        return;
    L47:
        r36 = true;
        goto L49
    L46:
        if (r35 > r32) goto L48;
    L38:
        r34 = true;
        goto L40
    L37:
        if (r33 > r32) goto L39;
    L52:
        r25 = r25;
        r0 = r27;
        goto L54
    L5:
        r10 = false;
        goto L6
    }
}
