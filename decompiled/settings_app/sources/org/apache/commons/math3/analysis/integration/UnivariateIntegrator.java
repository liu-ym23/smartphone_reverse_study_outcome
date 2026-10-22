package org.apache.commons.math3.analysis.integration;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;

/* JADX INFO: loaded from: classes6.dex */
public interface UnivariateIntegrator {
    double getAbsoluteAccuracy();

    int getEvaluations();

    int getIterations();

    int getMaximalIterationCount();

    int getMinimalIterationCount();

    double getRelativeAccuracy();

    double integrate(int r1, UnivariateFunction r2, double r3, double r5) throws TooManyEvaluationsException, MaxCountExceededException, MathIllegalArgumentException, NullArgumentException;
}
