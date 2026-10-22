package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public abstract class AbstractDifferentiableUnivariateSolver extends BaseAbstractUnivariateSolver<DifferentiableUnivariateFunction> implements DifferentiableUnivariateSolver {
    private UnivariateFunction functionDerivative;

    @Override // org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver
    protected /* bridge */ /* synthetic */ void setup(int r1, UnivariateFunction r2, double r3, double r5, double r7) throws NullArgumentException {
        setup(r1, (DifferentiableUnivariateFunction) r2, r3, r5, r7);
    }

    protected AbstractDifferentiableUnivariateSolver(double r1) {
        super(r1);
    }

    protected AbstractDifferentiableUnivariateSolver(double r1, double r3, double r5) {
        super(r1, r3, r5);
    }

    protected double computeDerivativeObjectiveValue(double r1) throws TooManyEvaluationsException {
        incrementEvaluationCount();
        return this.functionDerivative.value(r1);
    }

    protected void setup(int r1, DifferentiableUnivariateFunction r2, double r3, double r5, double r7) {
        super.setup(r1, r2, r3, r5, r7);
        this.functionDerivative = r2.derivative();
    }
}
