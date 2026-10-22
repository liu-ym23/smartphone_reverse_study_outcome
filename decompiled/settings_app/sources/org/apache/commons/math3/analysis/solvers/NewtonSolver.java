package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class NewtonSolver extends AbstractDifferentiableUnivariateSolver {
    private static final double DEFAULT_ABSOLUTE_ACCURACY = 1.0E-6d;

    @Override // org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver, org.apache.commons.math3.analysis.solvers.BaseUnivariateSolver
    public /* bridge */ /* synthetic */ double solve(int r1, UnivariateFunction r2, double r3, double r5) throws MathIllegalArgumentException, TooManyEvaluationsException {
        return solve(r1, (DifferentiableUnivariateFunction) r2, r3, r5);
    }

    public NewtonSolver() {
        this(1.0E-6d);
    }

    public NewtonSolver(double r1) {
        super(r1);
    }

    public double solve(int r1, DifferentiableUnivariateFunction r2, double r3, double r5) throws TooManyEvaluationsException {
        return super.solve(r1, r2, UnivariateSolverUtils.midpoint(r3, r5));
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver
    protected double doSolve() throws TooManyEvaluationsException {
        double r0 = getStartValue();
        double r2 = getAbsoluteAccuracy();
    L3:
        double r4 = r0 - (computeObjectiveValue(r0) / computeDerivativeObjectiveValue(r0));
        if (FastMath.abs(r4 - r0) <= r2) goto L5;
        r0 = r4;
        goto L3
    L5:
        return r4;
    }
}
