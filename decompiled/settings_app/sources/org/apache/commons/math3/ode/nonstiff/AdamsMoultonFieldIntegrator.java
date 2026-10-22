package org.apache.commons.math3.ode.nonstiff;

import java.util.Arrays;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.linear.Array2DRowFieldMatrix;
import org.apache.commons.math3.linear.FieldMatrixPreservingVisitor;
import org.apache.commons.math3.ode.FieldExpandableODE;
import org.apache.commons.math3.ode.FieldODEState;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class AdamsMoultonFieldIntegrator<T extends RealFieldElement<T>> extends AdamsFieldIntegrator<T> {
    private static final String METHOD_NAME = "Adams-Moulton";

    private class Corrector implements FieldMatrixPreservingVisitor<T> {
        private final T[] after;
        private final T[] before;
        private final T[] previous;
        private final T[] scaled;
        final /* synthetic */ AdamsMoultonFieldIntegrator this$0;

        @Override // org.apache.commons.math3.linear.FieldMatrixPreservingVisitor
        public /* bridge */ /* synthetic */ FieldElement end() {
            return end();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.apache.commons.math3.linear.FieldMatrixPreservingVisitor
        public /* bridge */ /* synthetic */ void visit(int r1, int r2, FieldElement r3) {
            visit(r1, r2, (RealFieldElement) r3);
        }

        Corrector(AdamsMoultonFieldIntegrator r1, T[] r2, T[] r3, T[] r4) {
            this.this$0 = r1;
            this.previous = r2;
            this.scaled = r3;
            this.after = r4;
            this.before = (T[]) ((RealFieldElement[]) r4.clone());
        }

        @Override // org.apache.commons.math3.linear.FieldMatrixPreservingVisitor
        public void start(int r1, int r2, int r3, int r4, int r5, int r6) {
            Arrays.fill(this.after, this.this$0.getField().getZero());
        }

        public void visit(int r1, int r2, T r3) {
            if ((r1 & 1) != 0) goto L5;
            FieldElement[] r0 = this.after;
            r0[r2] = (RealFieldElement) r0[r2].subtract(r3);
            return;
        L5:
            FieldElement[] r4 = this.after;
            r4[r2] = (RealFieldElement) r4[r2].add(r3);
        }

        @Override // org.apache.commons.math3.linear.FieldMatrixPreservingVisitor
        public T end() {
            RealFieldElement r0 = (RealFieldElement) this.this$0.getField().getZero();
            int r1 = 0;
        L3:
            FieldElement[] r2 = this.after;
            if (r1 >= r2.length) goto L14;
            r2[r1] = (RealFieldElement) r2[r1].add(this.previous[r1].add(this.scaled[r1]));
            if (r1 >= this.this$0.mainSetDimension) goto L12;
            RealFieldElement r3 = MathUtils.max((RealFieldElement) this.previous[r1].abs(), (RealFieldElement) this.after[r1].abs());
            if (this.this$0.vecAbsoluteTolerance != null) goto L10;
            RealFieldElement r4 = (RealFieldElement) r3.multiply(this.this$0.scalRelativeTolerance);
            double r5 = this.this$0.scalAbsoluteTolerance;
        L11:
            RealFieldElement r6 = (RealFieldElement) ((RealFieldElement) this.after[r1].subtract(this.before[r1])).divide((RealFieldElement) r4.add(r5));
            r0 = (RealFieldElement) r0.add(r6.multiply(r6));
            goto L12
        L10:
            r4 = (RealFieldElement) r3.multiply(this.this$0.vecRelativeTolerance[r1]);
            r5 = this.this$0.vecAbsoluteTolerance[r1];
        L12:
            r1 = r1 + 1;
            goto L3
        L14:
            return (T) ((RealFieldElement) r0.divide(this.this$0.mainSetDimension)).sqrt();
        }
    }

    public AdamsMoultonFieldIntegrator(Field<T> r14, int r15, double r16, double r18, double r20, double r22) throws NumberIsTooSmallException {
        super(r14, METHOD_NAME, r15, r15 + 1, r16, r18, r20, r22);
    }

    public AdamsMoultonFieldIntegrator(Field<T> r12, int r13, double r14, double r16, double[] r18, double[] r19) throws IllegalArgumentException {
        super(r12, METHOD_NAME, r13, r13 + 1, r14, r16, r18, r19);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7, types: [int] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2, types: [org.apache.commons.math3.RealFieldElement[]] */
    /* JADX WARN: Type inference failed for: r13v4, types: [org.apache.commons.math3.RealFieldElement[]] */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v5, types: [T extends org.apache.commons.math3.RealFieldElement<T>[], org.apache.commons.math3.RealFieldElement[]] */
    /* JADX WARN: Type inference failed for: r7v5, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [int] */
    @Override // org.apache.commons.math3.ode.nonstiff.AdamsFieldIntegrator, org.apache.commons.math3.ode.FirstOrderFieldIntegrator
    public FieldODEStateAndDerivative<T> integrate(FieldExpandableODE<T> r23, FieldODEState<T> r24, T r25) throws NumberIsTooSmallException, DimensionMismatchException, MaxCountExceededException, NoBracketingException {
        sanityChecks(r24, r25);
        RealFieldElement r4 = r24.getTime();
        RealFieldElement[] r5 = r23.getMapper().mapState(r24);
        setStepStart(initIntegration(r23, r4, r5, r25));
        double r8 = 0.0d;
        boolean r6 = false;
        if (((RealFieldElement) r25.subtract(r24.getTime())).getReal() <= 0.0d) goto L5;
        boolean r2 = true;
    L6:
        start(r23, getStepStart(), r25);
        FieldODEStateAndDerivative<T> r7 = getStepStart();
        FieldODEStateAndDerivative r9 = AdamsFieldStepInterpolator.taylor(r7, (RealFieldElement) r7.getTime().add(getStepSize()), getStepSize(), this.scaled, this.nordsieck);
        setIsLastStep(false);
    L7:
        RealFieldElement[] r10 = (RealFieldElement[]) MathArrays.buildArray(getField(), r5.length);
        RealFieldElement[] r19 = r5;
        T r14 = (RealFieldElement) getField().getZero().add(10.0d);
        Array2DRowFieldMatrix<T> r12 = null;
        ?? r13 = 0;
    L9:
        if (((RealFieldElement) r14.subtract(1.0d)).getReal() < r8) goto L18;
        ?? r15 = r9.getState();
        T[] r11 = computeDerivatives(r9.getTime(), r15);
        ?? r16 = r6;
    L12:
        if (r16 >= r10.length) goto L14;
        r10[r16] = (RealFieldElement) getStepSize().multiply(r11[r16]);
        r16 = r16 + 1;
        goto L12
    L14:
        r12 = updateHighOrderDerivativesPhase1(this.nordsieck);
        updateHighOrderDerivativesPhase2(this.scaled, r10, r12);
        RealFieldElement[] r17 = r19;
        r14 = r12.walkInOptimizedOrder(new Corrector(this, r17, r10, r15));
        if (((RealFieldElement) r14.subtract(1.0d)).getReal() < r8) goto L17;
        rescale(filterStep((RealFieldElement) getStepSize().multiply(computeStepGrowShrinkFactor(r14)), r2, r6));
        r9 = AdamsFieldStepInterpolator.taylor(getStepStart(), (RealFieldElement) getStepStart().getTime().add(getStepSize()), getStepSize(), this.scaled, this.nordsieck);
    L17:
        r19 = r17;
        r8 = 0.0d;
        r13 = r15;
        goto L9
    L18:
        RealFieldElement[] r18 = r19;
        T[] r20 = computeDerivatives(r9.getTime(), r13);
        ?? r21 = (T[]) ((RealFieldElement[]) MathArrays.buildArray(getField(), r18.length));
        ?? r22 = r6;
    L20:
        if (r22 >= r21.length) goto L22;
        r21[r22] = (RealFieldElement) getStepSize().multiply(r20[r22]);
        r22 = r22 + 1;
        goto L20
    L22:
        updateHighOrderDerivativesPhase2(r10, r21, r12);
        FieldODEStateAndDerivative r26 = new FieldODEStateAndDerivative(r9.getTime(), r13, r20);
        Array2DRowFieldMatrix<T> r27 = r12;
        ?? r1 = r13;
        RealFieldElement r28 = r14;
        setStepStart(acceptStep(new AdamsFieldStepInterpolator(getStepSize(), r26, r21, r27, r2, getStepStart(), r26, r23.getMapper()), r25));
        this.scaled = r21;
        this.nordsieck = r27;
        if (isLastStep() == true) goto L49;
        boolean r29 = false;
        System.arraycopy(r1, 0, r18, 0, r18.length);
        if (resetOccurred() == false) goto L27;
        FieldExpandableODE<T> r30 = r23;
        start(r30, getStepStart(), r25);
    L28:
        RealFieldElement r3 = (RealFieldElement) getStepSize().multiply(computeStepGrowShrinkFactor(r28));
        RealFieldElement r31 = (RealFieldElement) getStepStart().getTime().add(r3);
        if (r2 == false) goto L34;
        if (((RealFieldElement) r31.subtract(r25)).getReal() >= 0.0d) goto L35;
    L36:
        boolean r32 = false;
    L37:
        T r33 = filterStep(r3, r2, r32);
        RealFieldElement r34 = (RealFieldElement) getStepStart().getTime().add(r33);
        if (r2 == false) goto L42;
        double r35 = 0.0d;
        if (((RealFieldElement) r34.subtract(r25)).getReal() >= 0.0d) goto L44;
    L45:
        boolean r36 = false;
    L46:
        if (r36 == false) goto L48;
        r33 = (T) r25.subtract(getStepStart().getTime());
    L48:
        rescale(r33);
        r9 = AdamsFieldStepInterpolator.taylor(getStepStart(), (RealFieldElement) getStepStart().getTime().add(getStepSize()), getStepSize(), this.scaled, this.nordsieck);
    L51:
        if (isLastStep() == true) goto L52;
        r8 = r35;
        r6 = r29;
        r5 = r18;
        goto L7
    L52:
        FieldODEStateAndDerivative<T> r37 = getStepStart();
        setStepStart(null);
        setStepSize(null);
        return r37;
    L44:
        r36 = true;
        goto L46
    L42:
        r35 = 0.0d;
        if (((RealFieldElement) r34.subtract(r25)).getReal() > 0.0d) goto L45;
    L35:
        r32 = true;
        goto L37
    L34:
        if (((RealFieldElement) r31.subtract(r25)).getReal() > 0.0d) goto L36;
    L27:
        r30 = r23;
        goto L28
    L49:
        r30 = r23;
        r29 = false;
        r35 = 0.0d;
        r9 = r26;
        goto L51
    L5:
        r2 = false;
        goto L6
    }
}
