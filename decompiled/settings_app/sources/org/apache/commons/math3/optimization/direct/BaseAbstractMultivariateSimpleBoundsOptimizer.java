package org.apache.commons.math3.optimization.direct;

import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.optimization.BaseMultivariateOptimizer;
import org.apache.commons.math3.optimization.BaseMultivariateSimpleBoundsOptimizer;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.optimization.InitialGuess;
import org.apache.commons.math3.optimization.OptimizationData;
import org.apache.commons.math3.optimization.PointValuePair;
import org.apache.commons.math3.optimization.SimpleBounds;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public abstract class BaseAbstractMultivariateSimpleBoundsOptimizer<FUNC extends MultivariateFunction> extends BaseAbstractMultivariateOptimizer<FUNC> implements BaseMultivariateOptimizer<FUNC>, BaseMultivariateSimpleBoundsOptimizer<FUNC> {
    @Deprecated
    protected BaseAbstractMultivariateSimpleBoundsOptimizer() {
    }

    protected BaseAbstractMultivariateSimpleBoundsOptimizer(ConvergenceChecker<PointValuePair> r1) {
        super(r1);
    }

    @Override // org.apache.commons.math3.optimization.direct.BaseAbstractMultivariateOptimizer, org.apache.commons.math3.optimization.BaseMultivariateOptimizer
    public PointValuePair optimize(int r3, FUNC r4, GoalType r5, double[] r6) {
        return super.optimizeInternal(r3, r4, r5, new OptimizationData[]{new InitialGuess(r6)});
    }

    @Override // org.apache.commons.math3.optimization.BaseMultivariateSimpleBoundsOptimizer
    public PointValuePair optimize(int r3, FUNC r4, GoalType r5, double[] r6, double[] r7, double[] r8) {
        return super.optimizeInternal(r3, r4, r5, new OptimizationData[]{new InitialGuess(r6), new SimpleBounds(r7, r8)});
    }
}
