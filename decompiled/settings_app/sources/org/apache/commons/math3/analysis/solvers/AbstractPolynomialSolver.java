package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.exception.NullArgumentException;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractPolynomialSolver extends BaseAbstractUnivariateSolver<PolynomialFunction> implements PolynomialSolver {
    private PolynomialFunction polynomialFunction;

    @Override // org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver
    protected /* bridge */ /* synthetic */ void setup(int r1, UnivariateFunction r2, double r3, double r5, double r7) throws NullArgumentException {
        setup(r1, (PolynomialFunction) r2, r3, r5, r7);
    }

    protected AbstractPolynomialSolver(double r1) {
        super(r1);
    }

    protected AbstractPolynomialSolver(double r1, double r3) {
        super(r1, r3);
    }

    protected AbstractPolynomialSolver(double r1, double r3, double r5) {
        super(r1, r3, r5);
    }

    protected void setup(int r1, PolynomialFunction r2, double r3, double r5, double r7) {
        super.setup(r1, r2, r3, r5, r7);
        this.polynomialFunction = r2;
    }

    protected double[] getCoefficients() {
        return this.polynomialFunction.getCoefficients();
    }
}
