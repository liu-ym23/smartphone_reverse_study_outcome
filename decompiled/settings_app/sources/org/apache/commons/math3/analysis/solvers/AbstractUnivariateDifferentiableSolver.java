package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractUnivariateDifferentiableSolver extends BaseAbstractUnivariateSolver<UnivariateDifferentiableFunction> implements UnivariateDifferentiableSolver {
    private UnivariateDifferentiableFunction function;

    @Override // org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver
    protected /* bridge */ /* synthetic */ void setup(int r1, UnivariateFunction r2, double r3, double r5, double r7) throws NullArgumentException {
        setup(r1, (UnivariateDifferentiableFunction) r2, r3, r5, r7);
    }

    protected AbstractUnivariateDifferentiableSolver(double r1) {
        super(r1);
    }

    protected AbstractUnivariateDifferentiableSolver(double r1, double r3, double r5) {
        super(r1, r3, r5);
    }

    protected DerivativeStructure computeObjectiveValueAndDerivative(double r8) throws TooManyEvaluationsException {
        incrementEvaluationCount();
        return this.function.value(new DerivativeStructure(1, 1, 0, r8));
    }

    protected void setup(int r1, UnivariateDifferentiableFunction r2, double r3, double r5, double r7) {
        super.setup(r1, r2, r3, r5, r7);
        this.function = r2;
    }
}
