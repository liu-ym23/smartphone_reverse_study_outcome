package org.apache.commons.math3.optimization.univariate;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.util.Incrementor;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public abstract class BaseAbstractUnivariateOptimizer implements UnivariateOptimizer {
    private final ConvergenceChecker<UnivariatePointValuePair> checker;
    private final Incrementor evaluations;
    private UnivariateFunction function;
    private GoalType goal;
    private double searchMax;
    private double searchMin;
    private double searchStart;

    protected abstract UnivariatePointValuePair doOptimize();

    protected BaseAbstractUnivariateOptimizer(ConvergenceChecker<UnivariatePointValuePair> r2) {
        this.evaluations = new Incrementor();
        this.checker = r2;
    }

    @Override // org.apache.commons.math3.optimization.BaseOptimizer
    public int getMaxEvaluations() {
        return this.evaluations.getMaximalCount();
    }

    @Override // org.apache.commons.math3.optimization.BaseOptimizer
    public int getEvaluations() {
        return this.evaluations.getCount();
    }

    public GoalType getGoalType() {
        return this.goal;
    }

    public double getMin() {
        return this.searchMin;
    }

    public double getMax() {
        return this.searchMax;
    }

    public double getStartValue() {
        return this.searchStart;
    }

    protected double computeObjectiveValue(double r2) {
        this.evaluations.incrementCount();     // Catch: MaxCountExceededException -> L5
        return this.function.value(r2);
    L5:
        e = move-exception;
        throw new TooManyEvaluationsException(e.getMax());
    }

    @Override // org.apache.commons.math3.optimization.univariate.BaseUnivariateOptimizer
    public UnivariatePointValuePair optimize(int r1, UnivariateFunction r2, GoalType r3, double r4, double r6, double r8) {
        if (r2 == null) goto L9;
        if (r3 == null) goto L7;
        this.searchMin = r4;
        this.searchMax = r6;
        this.searchStart = r8;
        this.goal = r3;
        this.function = r2;
        this.evaluations.setMaximalCount(r1);
        this.evaluations.resetCount();
        return doOptimize();
    L7:
        throw new NullArgumentException();
    L9:
        throw new NullArgumentException();
    }

    @Override // org.apache.commons.math3.optimization.univariate.BaseUnivariateOptimizer
    public UnivariatePointValuePair optimize(int r11, UnivariateFunction r12, GoalType r13, double r14, double r16) {
        return optimize(r11, r12, r13, r14, r16, r14 + ((r16 - r14) * 0.5d));
    }

    @Override // org.apache.commons.math3.optimization.BaseOptimizer
    public ConvergenceChecker<UnivariatePointValuePair> getConvergenceChecker() {
        return this.checker;
    }
}
