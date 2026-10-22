package org.apache.commons.math3.fitting.leastsquares;

import org.apache.commons.math3.analysis.MultivariateMatrixFunction;
import org.apache.commons.math3.analysis.MultivariateVectorFunction;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.optim.PointVectorValuePair;

/* JADX INFO: loaded from: classes6.dex */
public class LeastSquaresBuilder {
    private ConvergenceChecker<LeastSquaresProblem.Evaluation> checker;
    private boolean lazyEvaluation;
    private int maxEvaluations;
    private int maxIterations;
    private MultivariateJacobianFunction model;
    private ParameterValidator paramValidator;
    private RealVector start;
    private RealVector target;
    private RealMatrix weight;

    public LeastSquaresBuilder() {
    }

    public LeastSquaresProblem build() {
        return LeastSquaresFactory.create(this.model, this.target, this.start, this.weight, this.checker, this.maxEvaluations, this.maxIterations, this.lazyEvaluation, this.paramValidator);
    }

    public LeastSquaresBuilder maxEvaluations(int r1) {
        this.maxEvaluations = r1;
        return this;
    }

    public LeastSquaresBuilder maxIterations(int r1) {
        this.maxIterations = r1;
        return this;
    }

    public LeastSquaresBuilder checker(ConvergenceChecker<LeastSquaresProblem.Evaluation> r1) {
        this.checker = r1;
        return this;
    }

    public LeastSquaresBuilder checkerPair(ConvergenceChecker<PointVectorValuePair> r1) {
        return checker(LeastSquaresFactory.evaluationChecker(r1));
    }

    public LeastSquaresBuilder model(MultivariateVectorFunction r1, MultivariateMatrixFunction r2) {
        return model(LeastSquaresFactory.model(r1, r2));
    }

    public LeastSquaresBuilder model(MultivariateJacobianFunction r1) {
        this.model = r1;
        return this;
    }

    public LeastSquaresBuilder target(RealVector r1) {
        this.target = r1;
        return this;
    }

    public LeastSquaresBuilder target(double[] r3) {
        return target(new ArrayRealVector(r3, false));
    }

    public LeastSquaresBuilder start(RealVector r1) {
        this.start = r1;
        return this;
    }

    public LeastSquaresBuilder start(double[] r3) {
        return start(new ArrayRealVector(r3, false));
    }

    public LeastSquaresBuilder weight(RealMatrix r1) {
        this.weight = r1;
        return this;
    }

    public LeastSquaresBuilder lazyEvaluation(boolean r1) {
        this.lazyEvaluation = r1;
        return this;
    }

    public LeastSquaresBuilder parameterValidator(ParameterValidator r1) {
        this.paramValidator = r1;
        return this;
    }
}
