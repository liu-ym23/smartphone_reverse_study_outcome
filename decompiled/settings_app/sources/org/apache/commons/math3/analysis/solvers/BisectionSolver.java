package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class BisectionSolver extends AbstractUnivariateSolver {
    private static final double DEFAULT_ABSOLUTE_ACCURACY = 1.0E-6d;

    public BisectionSolver() {
        this(1.0E-6d);
    }

    public BisectionSolver(double r1) {
        super(r1);
    }

    public BisectionSolver(double r1, double r3) {
        super(r1, r3);
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver
    protected double doSolve() throws TooManyEvaluationsException {
        double r0 = getMin();
        double r2 = getMax();
        verifyInterval(r0, r2);
        double r4 = getAbsoluteAccuracy();
    L3:
        double r6 = UnivariateSolverUtils.midpoint(r0, r2);
        double r8 = computeObjectiveValue(r0);
        if ((computeObjectiveValue(r6) * r8) <= 0.0d) goto L6;
        r0 = r6;
    L8:
        if (FastMath.abs(r2 - r0) > r4) goto L3;
        return UnivariateSolverUtils.midpoint(r0, r2);
    L6:
        r2 = r6;
        goto L8
    }
}
