package org.apache.commons.math3.optim.nonlinear.scalar;

import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.optim.BaseMultivariateOptimizer;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.PointValuePair;

/* JADX INFO: loaded from: classes6.dex */
public abstract class MultivariateOptimizer extends BaseMultivariateOptimizer<PointValuePair> {
    private MultivariateFunction function;
    private GoalType goal;

    @Override // org.apache.commons.math3.optim.BaseMultivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    public /* bridge */ /* synthetic */ Object optimize(OptimizationData[] r1) {
        return optimize(r1);
    }

    protected MultivariateOptimizer(ConvergenceChecker<PointValuePair> r1) {
        super(r1);
    }

    @Override // org.apache.commons.math3.optim.BaseMultivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    public PointValuePair optimize(OptimizationData... r1) throws TooManyEvaluationsException {
        return (PointValuePair) super.optimize(r1);
    }

    @Override // org.apache.commons.math3.optim.BaseMultivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    protected void parseOptimizationData(OptimizationData... r5) {
        super.parseOptimizationData(r5);
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        OptimizationData r2 = r5[r1];
        if ((r2 instanceof GoalType) == false) goto L8;
        this.goal = (GoalType) r2;
    L10:
        r1 = r1 + 1;
        goto L3
    L8:
        if ((r2 instanceof ObjectiveFunction) == false) goto L10;
        this.function = ((ObjectiveFunction) r2).getObjectiveFunction();
        goto L10
    }

    public GoalType getGoalType() {
        return this.goal;
    }

    public double computeObjectiveValue(double[] r1) {
        super.incrementEvaluationCount();
        return this.function.value(r1);
    }
}
