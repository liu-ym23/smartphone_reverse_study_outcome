package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class BrentSolver extends AbstractUnivariateSolver {
    private static final double DEFAULT_ABSOLUTE_ACCURACY = 1.0E-6d;

    public BrentSolver() {
        this(1.0E-6d);
    }

    public BrentSolver(double r1) {
        super(r1);
    }

    public BrentSolver(double r1, double r3) {
        super(r1, r3);
    }

    public BrentSolver(double r1, double r3, double r5) {
        super(r1, r3, r5);
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver
    protected double doSolve() throws NoBracketingException, TooManyEvaluationsException, NumberIsTooLargeException {
        double r8 = getMin();
        double r10 = getMax();
        double r12 = getStartValue();
        double r14 = getFunctionValueAccuracy();
        verifySequence(r8, r12, r10);
        double r16 = computeObjectiveValue(r12);
        if (FastMath.abs(r16) > r14) goto L5;
        return r12;
    L5:
        double r5 = computeObjectiveValue(r8);
        if (FastMath.abs(r5) > r14) goto L9;
        return r8;
    L9:
        if ((r16 * r5) < 0.0d) goto L11;
        double r18 = computeObjectiveValue(r10);
        if (FastMath.abs(r18) > r14) goto L16;
        return r10;
    L16:
        if ((r16 * r18) >= 0.0d) goto L20;
        return brent(r12, r10, r16, r18);
    L20:
        throw new NoBracketingException(r8, r10, r5, r18);
    L11:
        return brent(r8, r12, r5, r16);
    }

    private double brent(double r44, double r46, double r48, double r50) {
        double r2 = getAbsoluteAccuracy();
        double r4 = getRelativeAccuracy();
        double r6 = r44;
        double r8 = r46;
        double r10 = r48;
        double r12 = r10;
        double r14 = r50;
        double r16 = r46 - r44;
        double r18 = r16;
        double r0 = r6;
    L4:
        if (FastMath.abs(r10) >= FastMath.abs(r14)) goto L6;
        r6 = r0;
        r0 = r8;
        r12 = r10;
        r10 = r14;
    L7:
        double r22 = ((r4 * 2.0d) * FastMath.abs(r6)) + r2;
        double r24 = (r0 - r6) * 0.5d;
        if (FastMath.abs(r24) <= r22) goto L52;
        double r28 = r2;
        if (Precision.equals(r12, 0.0d) == true) goto L52;
        if (FastMath.abs(r16) >= r22) goto L15;
    L31:
        double r9 = r24;
        r18 = r9;
    L33:
        if (FastMath.abs(r9) <= r22) goto L38;
        double r15 = r6 + r9;
    L41:
        double r17 = computeObjectiveValue(r15);
        if (r17 <= 0.0d) goto L46;
        if (r10 <= 0.0d) goto L46;
    L49:
        r9 = r15 - r6;
        r18 = r9;
        double r1 = r6;
        r10 = r12;
    L51:
        r0 = r1;
        r2 = r28;
        r16 = r18;
        r18 = r9;
        r8 = r15;
        r14 = r17;
    L46:
        if (r17 <= 0.0d) goto L48;
    L50:
        r1 = r0;
        goto L51
    L48:
        if (r10 > 0.0d) goto L50;
    L38:
        if (r24 <= 0.0d) goto L40;
        r15 = r6 + r22;
        goto L41
    L40:
        r15 = r6 - r22;
        goto L41
    L15:
        if (FastMath.abs(r14) <= FastMath.abs(r12)) goto L31;
        double r30 = r12 / r14;
        if (r8 != r0) goto L20;
        double r20 = (2.0d * r24) * r30;
        double r33 = 1.0d - r30;
    L21:
        double r11 = r20;
        double r19 = r33;
        if (r11 <= 0.0d) goto L24;
        r19 = -r19;
    L26:
        if (r11 >= (((1.5d * r24) * r19) - FastMath.abs(r22 * r19))) goto L31;
        if (r11 >= FastMath.abs((r16 * 0.5d) * r19)) goto L31;
        r9 = r11 / r19;
        goto L33
    L24:
        r11 = -r11;
        goto L26
    L20:
        double r110 = r14 / r10;
        double r35 = r12 / r10;
        double r21 = ((2.0d * r24) * r110) * (r110 - r35);
        double r36 = r35 - 1.0d;
        r20 = (r21 - ((r6 - r8) * r36)) * r30;
        r33 = ((r110 - 1.0d) * r36) * (r30 - 1.0d);
    L52:
        return r6;
    L6:
        double r39 = r12;
        r12 = r14;
        r14 = r39;
        double r41 = r6;
        r6 = r8;
        r8 = r41;
        goto L7
    }
}
