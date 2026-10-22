package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;

/* JADX INFO: loaded from: classes6.dex */
public interface BaseUnivariateSolver<FUNC extends UnivariateFunction> {
    double getAbsoluteAccuracy();

    int getEvaluations();

    double getFunctionValueAccuracy();

    int getMaxEvaluations();

    double getRelativeAccuracy();

    double solve(int r1, FUNC r2, double r3);

    double solve(int r1, FUNC r2, double r3, double r5) throws MathIllegalArgumentException, TooManyEvaluationsException;

    double solve(int r1, FUNC r2, double r3, double r5, double r7) throws MathIllegalArgumentException, TooManyEvaluationsException;
}
