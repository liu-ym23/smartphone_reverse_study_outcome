package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.linear.Array2DRowFieldMatrix;
import org.apache.commons.math3.linear.FieldMatrix;
import org.apache.commons.math3.ode.FieldExpandableODE;
import org.apache.commons.math3.ode.FieldODEState;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class AdamsBashforthFieldIntegrator<T extends RealFieldElement<T>> extends AdamsFieldIntegrator<T> {
    private static final String METHOD_NAME = "Adams-Bashforth";

    public AdamsBashforthFieldIntegrator(Field<T> r14, int r15, double r16, double r18, double r20, double r22) throws NumberIsTooSmallException {
        super(r14, METHOD_NAME, r15, r15, r16, r18, r20, r22);
    }

    public AdamsBashforthFieldIntegrator(Field<T> r12, int r13, double r14, double r16, double[] r18, double[] r19) throws IllegalArgumentException {
        super(r12, METHOD_NAME, r13, r13, r14, r16, r18, r19);
    }

    private T errorEstimation(T[] r8, T[] r9, T[] r10, FieldMatrix<T> r11) {
        T r0 = getField().getZero();
        int r1 = 0;
    L4:
        if (r1 >= this.mainSetDimension) goto L18;
        RealFieldElement r2 = (RealFieldElement) r9[r1].abs();
        if (this.vecAbsoluteTolerance != null) goto L8;
        RealFieldElement r3 = (RealFieldElement) r2.multiply(this.scalRelativeTolerance);
        double r4 = this.scalAbsoluteTolerance;
    L9:
        RealFieldElement r5 = (RealFieldElement) r3.add(r4);
        T r6 = getField().getZero();
        if ((r11.getRowDimension() % 2) != 0) goto L12;
        int r7 = -1;
    L13:
        int r12 = r11.getRowDimension() - 1;
    L14:
        if (r12 < 0) goto L16;
        r6 = (T) r6.add(((RealFieldElement) r11.getEntry(r12, r1)).multiply(r7));
        r7 = -r7;
        r12 = r12 - 1;
        goto L14
    L16:
        RealFieldElement r13 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r9[r1].subtract(r8[r1])).add((RealFieldElement) r6.subtract(r10[r1]))).divide(r5);
        r0 = (T) r0.add(r13.multiply(r13));
        r1 = r1 + 1;
        goto L4
    L12:
        r7 = 1;
        goto L13
    L8:
        r3 = (RealFieldElement) r2.multiply(this.vecRelativeTolerance[r1]);
        r4 = this.vecAbsoluteTolerance[r1];
        goto L9
    L18:
        return (T) ((RealFieldElement) r0.divide(this.mainSetDimension)).sqrt();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6, types: [int] */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r15v1, types: [T extends org.apache.commons.math3.RealFieldElement<T>[], org.apache.commons.math3.RealFieldElement[]] */
    @Override // org.apache.commons.math3.ode.nonstiff.AdamsFieldIntegrator, org.apache.commons.math3.ode.FirstOrderFieldIntegrator
    public FieldODEStateAndDerivative<T> integrate(FieldExpandableODE<T> r22, FieldODEState<T> r23, T r24) throws NumberIsTooSmallException, DimensionMismatchException, MaxCountExceededException, NoBracketingException {
        sanityChecks(r23, r24);
        RealFieldElement r4 = r23.getTime();
        RealFieldElement[] r5 = r22.getMapper().mapState(r23);
        setStepStart(initIntegration(r22, r4, r5, r24));
        double r8 = 0.0d;
        boolean r6 = false;
        if (((RealFieldElement) r24.subtract(r23.getTime())).getReal() <= 0.0d) goto L5;
        boolean r2 = true;
    L6:
        start(r22, getStepStart(), r24);
        FieldODEStateAndDerivative<T> r7 = getStepStart();
        FieldODEStateAndDerivative r9 = AdamsFieldStepInterpolator.taylor(r7, (RealFieldElement) r7.getTime().add(getStepSize()), getStepSize(), this.scaled, this.nordsieck);
        setIsLastStep(false);
    L7:
        ?? r15 = (T[]) ((RealFieldElement[]) MathArrays.buildArray(getField(), r5.length));
        RealFieldElement[] r19 = r5;
        RealFieldElement r13 = (RealFieldElement) getField().getZero().add(10.0d);
        Object r11 = null;
        Array2DRowFieldMatrix<T> r12 = null;
    L9:
        if (((RealFieldElement) r13.subtract(1.0d)).getReal() < r8) goto L18;
        r11 = r9.getState();
        T[] r10 = computeDerivatives(r9.getTime(), r11);
        ?? r14 = r6;
    L12:
        if (r14 >= r15.length) goto L14;
        r15[r14] = (RealFieldElement) getStepSize().multiply(r10[r14]);
        r14 = r14 + 1;
        goto L12
    L14:
        r12 = updateHighOrderDerivativesPhase1(this.nordsieck);
        updateHighOrderDerivativesPhase2(this.scaled, r15, r12);
        RealFieldElement[] r16 = r19;
        r13 = errorEstimation(r16, r11, r15, r12);
        if (((RealFieldElement) r13.subtract(1.0d)).getReal() < r8) goto L17;
        rescale(filterStep((RealFieldElement) getStepSize().multiply(computeStepGrowShrinkFactor(r13)), r2, r6));
        r9 = AdamsFieldStepInterpolator.taylor(getStepStart(), (RealFieldElement) getStepStart().getTime().add(getStepSize()), getStepSize(), this.scaled, this.nordsieck);
    L17:
        r19 = r16;
        r8 = 0.0d;
        goto L9
    L18:
        RealFieldElement[] r17 = r19;
        Object r18 = r11;
        Array2DRowFieldMatrix<T> r20 = r12;
        RealFieldElement r21 = r13;
        setStepStart(acceptStep(new AdamsFieldStepInterpolator(getStepSize(), r9, r15, r20, r2, getStepStart(), r9, r22.getMapper()), r24));
        this.scaled = r15;
        this.nordsieck = r20;
        if (isLastStep() == true) goto L45;
        boolean r25 = false;
        System.arraycopy(r18, 0, r17, 0, r17.length);
        if (resetOccurred() == false) goto L23;
        FieldExpandableODE<T> r26 = r22;
        start(r26, getStepStart(), r24);
    L24:
        RealFieldElement r1 = (RealFieldElement) getStepSize().multiply(computeStepGrowShrinkFactor(r21));
        RealFieldElement r27 = (RealFieldElement) getStepStart().getTime().add(r1);
        if (r2 == false) goto L30;
        if (((RealFieldElement) r27.subtract(r24)).getReal() >= 0.0d) goto L31;
    L32:
        boolean r28 = false;
    L33:
        T r3 = filterStep(r1, r2, r28);
        RealFieldElement r29 = (RealFieldElement) getStepStart().getTime().add(r3);
        if (r2 == false) goto L38;
        double r30 = 0.0d;
        if (((RealFieldElement) r29.subtract(r24)).getReal() >= 0.0d) goto L40;
    L41:
        boolean r31 = false;
    L42:
        if (r31 == false) goto L44;
        r3 = (T) r24.subtract(getStepStart().getTime());
    L44:
        rescale(r3);
        r9 = AdamsFieldStepInterpolator.taylor(getStepStart(), (RealFieldElement) getStepStart().getTime().add(getStepSize()), getStepSize(), this.scaled, this.nordsieck);
    L47:
        if (isLastStep() == true) goto L48;
        r5 = r17;
        r8 = r30;
        r6 = r25;
        goto L7
    L48:
        FieldODEStateAndDerivative<T> r32 = getStepStart();
        setStepStart(null);
        setStepSize(null);
        return r32;
    L40:
        r31 = true;
        goto L42
    L38:
        r30 = 0.0d;
        if (((RealFieldElement) r29.subtract(r24)).getReal() > 0.0d) goto L41;
    L31:
        r28 = true;
        goto L33
    L30:
        if (((RealFieldElement) r27.subtract(r24)).getReal() > 0.0d) goto L32;
    L23:
        r26 = r22;
        goto L24
    L45:
        r26 = r22;
        r25 = false;
        r30 = 0.0d;
        goto L47
    L5:
        r2 = false;
        goto L6
    }
}
