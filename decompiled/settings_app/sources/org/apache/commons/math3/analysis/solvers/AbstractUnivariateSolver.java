package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.analysis.UnivariateFunction;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractUnivariateSolver extends BaseAbstractUnivariateSolver<UnivariateFunction> implements UnivariateSolver {
    protected AbstractUnivariateSolver(double r1) {
        super(r1);
    }

    protected AbstractUnivariateSolver(double r1, double r3) {
        super(r1, r3);
    }

    protected AbstractUnivariateSolver(double r1, double r3, double r5) {
        super(r1, r3, r5);
    }
}
