package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class NewtonRaphsonSolver extends AbstractUnivariateDifferentiableSolver {
    private static final double DEFAULT_ABSOLUTE_ACCURACY = 1.0E-6d;

    @Override // org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver, org.apache.commons.math3.analysis.solvers.BaseUnivariateSolver
    public /* bridge */ /* synthetic */ double solve(int r1, UnivariateFunction r2, double r3, double r5) throws MathIllegalArgumentException, TooManyEvaluationsException {
        return solve(r1, (UnivariateDifferentiableFunction) r2, r3, r5);
    }

    public NewtonRaphsonSolver() {
        this(1.0E-6d);
    }

    public NewtonRaphsonSolver(double r1) {
        super(r1);
    }

    public double solve(int r1, UnivariateDifferentiableFunction r2, double r3, double r5) throws TooManyEvaluationsException {
        return super.solve(r1, r2, UnivariateSolverUtils.midpoint(r3, r5));
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver
    protected double doSolve() throws TooManyEvaluationsException {
        double r0 = getStartValue();
        double r2 = getAbsoluteAccuracy();
    L3:
        DerivativeStructure r4 = computeObjectiveValueAndDerivative(r0);
        double r5 = r0 - (r4.getValue() / r4.getPartialDerivative(new int[]{1}));
        if (FastMath.abs(r5 - r0) <= r2) goto L5;
        r0 = r5;
        goto L3
    L5:
        return r5;
    }
}
