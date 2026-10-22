package org.apache.commons.math3.linear;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.ExceptionContext;
import org.apache.commons.math3.util.IterationManager;

/* JADX INFO: loaded from: classes6.dex */
public class ConjugateGradient extends PreconditionedIterativeLinearSolver {
    public static final String OPERATOR = "operator";
    public static final String VECTOR = "vector";
    private boolean check;
    private final double delta;

    public ConjugateGradient(int r1, double r2, boolean r4) {
        super(r1);
        this.delta = r2;
        this.check = r4;
    }

    public ConjugateGradient(IterationManager r1, double r2, boolean r4) throws NullArgumentException {
        super(r1);
        this.delta = r2;
        this.check = r4;
    }

    public final boolean getCheck() {
        return this.check;
    }

    @Override // org.apache.commons.math3.linear.PreconditionedIterativeLinearSolver
    public RealVector solveInPlace(RealLinearOperator r31, RealLinearOperator r32, RealVector r33, RealVector r34) throws NullArgumentException, NonPositiveDefiniteOperatorException, NonSquareOperatorException, DimensionMismatchException, MaxCountExceededException {
        RealLinearOperator r10 = r32;
        checkParameters(r31, r32, r33, r34);
        IterationManager r11 = getIterationManager();
        r11.resetIterationCount();
        double r12 = this.delta * r33.getNorm();
        RealVector r14 = RealVector.unmodifiableRealVector(r33);
        r11.incrementIterationCount();
        RealVector r15 = RealVector.unmodifiableRealVector(r34);
        RealVector r6 = r34.copy();
        RealVector r7 = r33.combine(1.0d, -1.0d, r31.operate(r6));
        RealVector r22 = RealVector.unmodifiableRealVector(r7);
        double r16 = r7.getNorm();
        if (r10 != null) goto L5;
        RealVector r18 = r7;
    L6:
        RealVector r23 = r6;
        RealVector r8 = r7;
        DefaultIterativeLinearSolverEvent r5 = new DefaultIterativeLinearSolverEvent(this, r11.getIterations(), r15, r14, r22, r16);
        r11.fireInitializationEvent(r5);
        if (r16 > r12) goto L10;
        r11.fireTerminationEvent(r5);
        return r34;
    L10:
        double r9 = r16;
        double r17 = 0.0d;
    L11:
        r11.incrementIterationCount();
        r11.fireIterationStartedEvent(new DefaultIterativeLinearSolverEvent(this, r11.getIterations(), r15, r14, r22, r9));
        if (r10 == null) goto L14;
        RealVector r13 = r10.operate(r8);
    L15:
        double r26 = r8.dotProduct(r13);
        RealVector r19 = r8;
        if (this.check == false) goto L23;
        if (r26 > 0.0d) goto L23;
        NonPositiveDefiniteOperatorException r0 = new NonPositiveDefiniteOperatorException();
        ExceptionContext r1 = r0.getContext();
        r1.setValue("operator", r10);
        r1.setValue(VECTOR, r19);
        throw r0;
    L23:
        if (r11.getIterations() != 2) goto L25;
        RealVector r3 = r23;
        r3.setSubVector(0, r13);
        RealVector r110 = r3;
    L26:
        RealVector r20 = r31.operate(r110);
        double r2 = r110.dotProduct(r20);
        if (this.check == true) goto L29;
    L33:
        double r4 = r26 / r2;
        r34.combineToSelf(1.0d, r4, r110);
        r19.combineToSelf(1.0d, -r4, r20);
        double r111 = r19.getNorm();
        DefaultIterativeLinearSolverEvent r112 = new DefaultIterativeLinearSolverEvent(this, r11.getIterations(), r15, r14, r22, r111);
        r11.fireIterationPerformedEvent(r112);
        if (r111 <= r12) goto L35;
        r23 = r110;
        r9 = r111;
        r8 = r19;
        r17 = r26;
        r12 = r12;
        r10 = r32;
        r18 = r13;
        goto L11
    L35:
        r11.fireTerminationEvent(r112);
        return r34;
    L29:
        if (r2 > 0.0d) goto L33;
        NonPositiveDefiniteOperatorException r21 = new NonPositiveDefiniteOperatorException();
        ExceptionContext r24 = r21.getContext();
        r24.setValue("operator", r31);
        r24.setValue(VECTOR, r110);
        throw r21;
    L25:
        RealVector r25 = r23;
        r110 = r25;
        r25.combineToSelf(r26 / r17, 1.0d, r13);
        goto L26
    L14:
        r13 = r18;
        goto L15
    L5:
        r18 = null;
        goto L6
    }
}
