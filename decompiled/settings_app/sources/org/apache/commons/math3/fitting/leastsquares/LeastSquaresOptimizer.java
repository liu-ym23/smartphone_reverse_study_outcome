package org.apache.commons.math3.fitting.leastsquares;

/* JADX INFO: loaded from: classes6.dex */
public interface LeastSquaresOptimizer {

    public interface Optimum extends LeastSquaresProblem.Evaluation {
        int getEvaluations();

        int getIterations();
    }

    Optimum optimize(LeastSquaresProblem r1);
}
