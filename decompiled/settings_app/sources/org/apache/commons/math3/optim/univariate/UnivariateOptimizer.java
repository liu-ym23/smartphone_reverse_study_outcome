package org.apache.commons.math3.optim.univariate;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.exception.TooManyIterationsException;
import org.apache.commons.math3.optim.BaseOptimizer;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

/* JADX INFO: loaded from: classes6.dex */
public abstract class UnivariateOptimizer extends BaseOptimizer<UnivariatePointValuePair> {
    private UnivariateFunction function;
    private GoalType goal;
    private double max;
    private double min;
    private double start;

    @Override // org.apache.commons.math3.optim.BaseOptimizer
    public /* bridge */ /* synthetic */ UnivariatePointValuePair optimize(OptimizationData[] r1) throws TooManyEvaluationsException, TooManyIterationsException {
        return optimize(r1);
    }

    protected UnivariateOptimizer(ConvergenceChecker<UnivariatePointValuePair> r1) {
        super(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.apache.commons.math3.optim.BaseOptimizer
    public UnivariatePointValuePair optimize(OptimizationData... r1) throws TooManyEvaluationsException {
        return (UnivariatePointValuePair) super.optimize(r1);
    }

    public GoalType getGoalType() {
        return this.goal;
    }

    @Override // org.apache.commons.math3.optim.BaseOptimizer
    protected void parseOptimizationData(OptimizationData... r6) {
        super.parseOptimizationData(r6);
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L14;
        OptimizationData r2 = r6[r1];
        if ((r2 instanceof SearchInterval) == false) goto L8;
        SearchInterval r3 = (SearchInterval) r2;
        this.min = r3.getMin();
        this.max = r3.getMax();
        this.start = r3.getStartValue();
    L13:
        r1 = r1 + 1;
        goto L3
    L8:
        if ((r2 instanceof UnivariateObjectiveFunction) == false) goto L11;
        this.function = ((UnivariateObjectiveFunction) r2).getObjectiveFunction();
        goto L13
    L11:
        if ((r2 instanceof GoalType) == false) goto L13;
        this.goal = (GoalType) r2;
        goto L13
    }

    public double getStartValue() {
        return this.start;
    }

    public double getMin() {
        return this.min;
    }

    public double getMax() {
        return this.max;
    }

    protected double computeObjectiveValue(double r1) {
        super.incrementEvaluationCount();
        return this.function.value(r1);
    }
}
