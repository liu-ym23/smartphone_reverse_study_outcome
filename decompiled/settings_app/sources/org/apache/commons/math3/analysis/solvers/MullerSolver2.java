package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class MullerSolver2 extends AbstractUnivariateSolver {
    private static final double DEFAULT_ABSOLUTE_ACCURACY = 1.0E-6d;

    public MullerSolver2() {
        this(1.0E-6d);
    }

    public MullerSolver2(double r1) {
        super(r1);
    }

    public MullerSolver2(double r1, double r3) {
        super(r1, r3);
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver
    protected double doSolve() throws TooManyEvaluationsException, NumberIsTooLargeException, NoBracketingException {
        double r1 = getMin();
        double r3 = getMax();
        verifyInterval(r1, r3);
        double r5 = getRelativeAccuracy();
        double r7 = getAbsoluteAccuracy();
        double r9 = getFunctionValueAccuracy();
        double r11 = computeObjectiveValue(r1);
        if (FastMath.abs(r11) >= r9) goto L5;
        return r1;
    L5:
        double r13 = computeObjectiveValue(r3);
        if (FastMath.abs(r13) >= r9) goto L9;
        return r3;
    L9:
        if ((r11 * r13) > 0.0d) goto L35;
        double r14 = (r1 + r3) * 0.5d;
        double r25 = r1;
        double r23 = r3;
        double r27 = Double.POSITIVE_INFINITY;
        double r12 = r13;
        double r21 = computeObjectiveValue(r14);
        double r15 = r14;
        double r16 = r11;
    L11:
        double r29 = r15 - r23;
        double r26 = r29 / (r23 - r25);
        double r33 = r26 + 1.0d;
        double r35 = ((r21 - (r33 * r12)) + (r26 * r16)) * r26;
        double r39 = ((((r26 * 2.0d) + 1.0d) * r21) - ((r33 * r33) * r12)) + ((r26 * r26) * r16);
        double r34 = r33 * r21;
        double r17 = r39 * r39;
        double r28 = r17 - ((r35 * 4.0d) * r34);
        if (r28 < 0.0d) goto L17;
        double r18 = r39 + FastMath.sqrt(r28);
        double r310 = r39 - FastMath.sqrt(r28);
        if (FastMath.abs(r18) > FastMath.abs(r310)) goto L19;
        r18 = r310;
    L19:
        if (r18 == 0.0d) goto L26;
        double r19 = r15 - (((r34 * 2.0d) * r29) / r18);
    L22:
        if (r19 == r23) goto L25;
        if (r19 == r15) goto L25;
    L27:
        double r210 = computeObjectiveValue(r19);
        double r31 = r12;
        if (FastMath.abs(r19 - r27) <= FastMath.max(r5 * FastMath.abs(r19), r7)) goto L33;
        if (FastMath.abs(r210) <= r9) goto L33;
        r27 = r19;
        r12 = r21;
        r21 = r210;
        r25 = r23;
        r16 = r31;
        r23 = r15;
        r15 = r27;
    L33:
        return r19;
    L25:
        r19 = r19 + r7;
        goto L22
    L26:
        r19 = (FastMath.random() * (r3 - r1)) + r1;
        r27 = Double.POSITIVE_INFINITY;
        goto L27
    L17:
        r18 = FastMath.sqrt(r17 - r28);
        goto L19
    L35:
        throw new NoBracketingException(r1, r3, r11, r13);
    }
}
