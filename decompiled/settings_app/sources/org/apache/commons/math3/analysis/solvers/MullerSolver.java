package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class MullerSolver extends AbstractUnivariateSolver {
    private static final double DEFAULT_ABSOLUTE_ACCURACY = 1.0E-6d;

    public MullerSolver() {
        this(1.0E-6d);
    }

    public MullerSolver(double r1) {
        super(r1);
    }

    public MullerSolver(double r1, double r3) {
        super(r1, r3);
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver
    protected double doSolve() throws TooManyEvaluationsException, NumberIsTooLargeException, NoBracketingException {
        double r8 = getMin();
        double r10 = getMax();
        double r12 = getStartValue();
        double r14 = getFunctionValueAccuracy();
        verifySequence(r8, r12, r10);
        double r5 = computeObjectiveValue(r8);
        if (FastMath.abs(r5) >= r14) goto L5;
        return r8;
    L5:
        double r16 = computeObjectiveValue(r10);
        if (FastMath.abs(r16) >= r14) goto L8;
        return r10;
    L8:
        double r18 = computeObjectiveValue(r12);
        if (FastMath.abs(r18) >= r14) goto L11;
        return r12;
    L11:
        verifyBracketing(r8, r10);
        if (isBracketing(r8, r12) == false) goto L16;
        return solve(r8, r12, r5, r18);
    L16:
        return solve(r12, r10, r18, r16);
    }

    private double solve(double r42, double r44, double r46, double r48) throws TooManyEvaluationsException {
        double r1 = getRelativeAccuracy();
        double r3 = getAbsoluteAccuracy();
        double r5 = getFunctionValueAccuracy();
        double r7 = (r42 + r44) * 0.5d;
        double r15 = r46;
        double r17 = r48;
        double r19 = r7;
        double r21 = computeObjectiveValue(r7);
        double r23 = Double.POSITIVE_INFINITY;
        double r8 = r42;
        double r11 = r44;
    L3:
        double r27 = r19 - r8;
        double r25 = (r21 - r15) / r27;
        double r31 = r11 - r19;
        double r33 = r11 - r8;
        double r29 = (((r17 - r21) / r31) - r25) / r33;
        double r26 = r25 + (r27 * r29);
        double r35 = (r26 * r26) - ((4.0d * r21) * r29);
        double r210 = (-2.0d) * r21;
        double r37 = r19 + (r210 / (r26 + FastMath.sqrt(r35)));
        double r211 = r19 + (r210 / (r26 - FastMath.sqrt(r35)));
        if (isSequence(r8, r37, r11) == false) goto L6;
        double r13 = r37;
    L7:
        double r212 = computeObjectiveValue(r13);
        double r9 = FastMath.max(r1 * FastMath.abs(r13), r3);
        if (FastMath.abs(r13 - r23) <= r9) goto L44;
        if (FastMath.abs(r212) <= r5) goto L44;
        if (r13 >= r19) goto L17;
        if (r27 <= (r33 * 0.95d)) goto L17;
    L21:
        boolean r10 = true;
    L23:
        if (r10 == true) goto L38;
        if (r13 < r19) goto L27;
        r8 = r19;
    L27:
        if (r13 < r19) goto L31;
        r15 = r21;
    L31:
        if (r13 > r19) goto L34;
        r11 = r19;
    L34:
        if (r13 > r19) goto L37;
        r17 = r21;
    L37:
        double r12 = r13;
        r23 = r12;
        r21 = r212;
        long r110 = 4602678819172646912L;
    L43:
        r19 = r12;
        goto L3
    L38:
        r110 = 4602678819172646912L;
        double r14 = (r8 + r11) * 0.5d;
        double r16 = computeObjectiveValue(r14);
        if ((FastMath.signum(r15) + FastMath.signum(r16)) != 0.0d) goto L41;
        r11 = r14;
        r17 = r16;
    L42:
        r12 = (r8 + r11) * 0.5d;
        r21 = computeObjectiveValue(r12);
        r23 = Double.POSITIVE_INFINITY;
        goto L43
    L41:
        r8 = r14;
        r15 = r16;
    L17:
        if (r13 > r19) goto L19;
    L20:
        if (r13 == r19) goto L21;
        r10 = false;
        goto L23
    L19:
        if (r31 > (r33 * 0.95d)) goto L21;
    L44:
        return r13;
    L6:
        r13 = r211;
        goto L7
    }
}
