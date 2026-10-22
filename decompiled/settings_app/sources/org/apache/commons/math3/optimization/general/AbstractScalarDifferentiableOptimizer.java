package org.apache.commons.math3.optimization.general;

import org.apache.commons.math3.analysis.DifferentiableMultivariateFunction;
import org.apache.commons.math3.analysis.FunctionUtils;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.analysis.MultivariateVectorFunction;
import org.apache.commons.math3.analysis.differentiation.MultivariateDifferentiableFunction;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.DifferentiableMultivariateOptimizer;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.optimization.PointValuePair;
import org.apache.commons.math3.optimization.direct.BaseAbstractMultivariateOptimizer;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public abstract class AbstractScalarDifferentiableOptimizer extends BaseAbstractMultivariateOptimizer<DifferentiableMultivariateFunction> implements DifferentiableMultivariateOptimizer {
    private MultivariateVectorFunction gradient;

    @Override // org.apache.commons.math3.optimization.direct.BaseAbstractMultivariateOptimizer
    protected /* bridge */ /* synthetic */ PointValuePair optimizeInternal(int r1, MultivariateFunction r2, GoalType r3, double[] r4) {
        return optimizeInternal(r1, (DifferentiableMultivariateFunction) r2, r3, r4);
    }

    @Deprecated
    protected AbstractScalarDifferentiableOptimizer() {
    }

    protected AbstractScalarDifferentiableOptimizer(ConvergenceChecker<PointValuePair> r1) {
        super(r1);
    }

    protected double[] computeObjectiveGradient(double[] r1) {
        return this.gradient.value(r1);
    }

    protected PointValuePair optimizeInternal(int r2, DifferentiableMultivariateFunction r3, GoalType r4, double[] r5) {
        this.gradient = r3.gradient();
        return super.optimizeInternal(r2, r3, r4, r5);
    }

    public PointValuePair optimize(int r1, MultivariateDifferentiableFunction r2, GoalType r3, double[] r4) {
        return optimizeInternal(r1, FunctionUtils.toDifferentiableMultivariateFunction(r2), r3, r4);
    }
}
