package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class SecantSolver extends AbstractUnivariateSolver {
    protected static final double DEFAULT_ABSOLUTE_ACCURACY = 1.0E-6d;

    public SecantSolver() {
        super(1.0E-6d);
    }

    public SecantSolver(double r1) {
        super(r1);
    }

    public SecantSolver(double r1, double r3) {
        super(r1, r3);
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver
    protected final double doSolve() throws TooManyEvaluationsException, NoBracketingException {
        double r1 = getMin();
        double r3 = getMax();
        double r5 = computeObjectiveValue(r1);
        double r7 = computeObjectiveValue(r3);
        double r9 = 0.0d;
        if (r5 != 0.0d) goto L6;
        return r1;
    L6:
        if (r7 != 0.0d) goto L8;
        return r3;
    L8:
        verifyBracketing(r1, r3);
        double r11 = getFunctionValueAccuracy();
        double r13 = getAbsoluteAccuracy();
        double r15 = getRelativeAccuracy();
    L9:
        double r21 = r5;
        r5 = r7;
        double r23 = r1;
        r1 = r3;
        r3 = r1 - (((r1 - r23) * r5) / (r5 - r21));
        r7 = computeObjectiveValue(r3);
        if (r7 == r9) goto L11;
        if (FastMath.abs(r7) <= r11) goto L14;
        if (FastMath.abs(r3 - r1) < FastMath.max(r15 * FastMath.abs(r3), r13)) goto L17;
        r9 = 0.0d;
        goto L9
    L17:
        return r3;
    L14:
        return r3;
    L11:
        return r3;
    }
}
