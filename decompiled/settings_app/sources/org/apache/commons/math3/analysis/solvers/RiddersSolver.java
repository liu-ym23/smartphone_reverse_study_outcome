package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class RiddersSolver extends AbstractUnivariateSolver {
    private static final double DEFAULT_ABSOLUTE_ACCURACY = 1.0E-6d;

    public RiddersSolver() {
        this(1.0E-6d);
    }

    public RiddersSolver(double r1) {
        super(r1);
    }

    public RiddersSolver(double r1, double r3) {
        super(r1, r3);
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver
    protected double doSolve() throws TooManyEvaluationsException, NoBracketingException {
        double r1 = getMin();
        double r3 = getMax();
        double r5 = computeObjectiveValue(r1);
        double r7 = computeObjectiveValue(r3);
        if (r5 != 0.0d) goto L6;
        return r1;
    L6:
        if (r7 != 0.0d) goto L8;
        return r3;
    L8:
        verifyBracketing(r1, r3);
        double r11 = getAbsoluteAccuracy();
        double r13 = getFunctionValueAccuracy();
        double r15 = getRelativeAccuracy();
        double r17 = Double.POSITIVE_INFINITY;
    L9:
        double r9 = (r1 + r3) * 0.5d;
        double r19 = computeObjectiveValue(r9);
        if (FastMath.abs(r19) <= r13) goto L11;
        double r23 = 1.0d - ((r5 * r7) / (r19 * r19));
        double r21 = ((FastMath.signum(r7) * FastMath.signum(r19)) * (r9 - r1)) / FastMath.sqrt(r23);
        double r24 = r1;
        double r2 = r9 - r21;
        double r25 = computeObjectiveValue(r2);
        r2 = r3;
        double r4 = FastMath.max(r15 * FastMath.abs(r2), r11);
        if (FastMath.abs(r2 - r17) <= r4) goto L14;
        if (FastMath.abs(r25) <= r13) goto L17;
        if (r21 <= 0.0d) goto L25;
        if ((FastMath.signum(r5) + FastMath.signum(r25)) != 0.0d) goto L23;
        r9 = r24;
    L28:
        r7 = r25;
    L29:
        r17 = r2;
        r1 = r9;
        r3 = r2;
        goto L9
    L23:
        r2 = r9;
        r7 = r19;
        r5 = r25;
        r9 = r2;
        goto L29
    L25:
        if ((FastMath.signum(r7) + FastMath.signum(r25)) != 0.0d) goto L27;
        r9 = r2;
        r5 = r25;
        goto L29
    L27:
        r5 = r19;
        goto L28
    L17:
        return r2;
    L14:
        return r2;
    L11:
        return r9;
    }
}
