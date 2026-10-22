package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.analysis.RealFieldUnivariateFunction;

/* JADX INFO: loaded from: classes6.dex */
public interface BracketedRealFieldUnivariateSolver<T extends RealFieldElement<T>> {
    T getAbsoluteAccuracy();

    int getEvaluations();

    T getFunctionValueAccuracy();

    int getMaxEvaluations();

    T getRelativeAccuracy();

    T solve(int r1, RealFieldUnivariateFunction<T> r2, T r3, T r4, T r5, AllowedSolution r6);

    T solve(int r1, RealFieldUnivariateFunction<T> r2, T r3, T r4, AllowedSolution r5);
}
