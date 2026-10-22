package org.apache.commons.math3.fitting.leastsquares;

import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

/* JADX INFO: loaded from: classes6.dex */
class OptimumImpl implements LeastSquaresOptimizer.Optimum {
    private final int evaluations;
    private final int iterations;
    private final LeastSquaresProblem.Evaluation value;

    OptimumImpl(LeastSquaresProblem.Evaluation r1, int r2, int r3) {
        this.value = r1;
        this.evaluations = r2;
        this.iterations = r3;
    }

    @Override // org.apache.commons.math3.fitting.leastsquares.LeastSquaresOptimizer.Optimum
    public int getEvaluations() {
        return this.evaluations;
    }

    @Override // org.apache.commons.math3.fitting.leastsquares.LeastSquaresOptimizer.Optimum
    public int getIterations() {
        return this.iterations;
    }

    @Override // org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem.Evaluation
    public RealMatrix getCovariances(double r1) {
        return this.value.getCovariances(r1);
    }

    @Override // org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem.Evaluation
    public RealVector getSigma(double r1) {
        return this.value.getSigma(r1);
    }

    @Override // org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem.Evaluation
    public double getRMS() {
        return this.value.getRMS();
    }

    @Override // org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem.Evaluation
    public RealMatrix getJacobian() {
        return this.value.getJacobian();
    }

    @Override // org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem.Evaluation
    public double getCost() {
        return this.value.getCost();
    }

    @Override // org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem.Evaluation
    public RealVector getResiduals() {
        return this.value.getResiduals();
    }

    @Override // org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem.Evaluation
    public RealVector getPoint() {
        return this.value.getPoint();
    }
}
