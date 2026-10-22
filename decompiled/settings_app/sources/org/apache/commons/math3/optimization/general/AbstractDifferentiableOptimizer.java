package org.apache.commons.math3.optimization.general;

import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.analysis.MultivariateVectorFunction;
import org.apache.commons.math3.analysis.differentiation.GradientFunction;
import org.apache.commons.math3.analysis.differentiation.MultivariateDifferentiableFunction;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.optimization.InitialGuess;
import org.apache.commons.math3.optimization.OptimizationData;
import org.apache.commons.math3.optimization.PointValuePair;
import org.apache.commons.math3.optimization.direct.BaseAbstractMultivariateOptimizer;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public abstract class AbstractDifferentiableOptimizer extends BaseAbstractMultivariateOptimizer<MultivariateDifferentiableFunction> {
    private MultivariateVectorFunction gradient;

    @Override // org.apache.commons.math3.optimization.direct.BaseAbstractMultivariateOptimizer
    @Deprecated
    protected /* bridge */ /* synthetic */ PointValuePair optimizeInternal(int r1, MultivariateFunction r2, GoalType r3, double[] r4) {
        return optimizeInternal(r1, (MultivariateDifferentiableFunction) r2, r3, r4);
    }

    @Override // org.apache.commons.math3.optimization.direct.BaseAbstractMultivariateOptimizer
    protected /* bridge */ /* synthetic */ PointValuePair optimizeInternal(int r1, MultivariateFunction r2, GoalType r3, OptimizationData[] r4) throws TooManyEvaluationsException {
        return optimizeInternal(r1, (MultivariateDifferentiableFunction) r2, r3, r4);
    }

    protected AbstractDifferentiableOptimizer(ConvergenceChecker<PointValuePair> r1) {
        super(r1);
    }

    protected double[] computeObjectiveGradient(double[] r1) {
        return this.gradient.value(r1);
    }

    @Deprecated
    protected PointValuePair optimizeInternal(int r3, MultivariateDifferentiableFunction r4, GoalType r5, double[] r6) {
        return optimizeInternal(r3, r4, r5, new OptimizationData[]{new InitialGuess(r6)});
    }

    protected PointValuePair optimizeInternal(int r2, MultivariateDifferentiableFunction r3, GoalType r4, OptimizationData... r5) {
        this.gradient = new GradientFunction(r3);
        return super.optimizeInternal(r2, r3, r4, r5);
    }
}
