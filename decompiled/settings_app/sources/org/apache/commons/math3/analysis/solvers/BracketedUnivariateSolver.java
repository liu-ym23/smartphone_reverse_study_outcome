package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.analysis.UnivariateFunction;

/* JADX INFO: loaded from: classes6.dex */
public interface BracketedUnivariateSolver<FUNC extends UnivariateFunction> extends BaseUnivariateSolver<FUNC> {
    double solve(int r1, FUNC r2, double r3, double r5, double r7, AllowedSolution r9);

    double solve(int r1, FUNC r2, double r3, double r5, AllowedSolution r7);
}
