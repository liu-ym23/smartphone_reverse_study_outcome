package org.apache.commons.math3.optim.univariate;

import java.util.Arrays;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.exception.TooManyIterationsException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.optim.MaxEval;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.apache.commons.math3.random.RandomGenerator;

/* JADX INFO: loaded from: classes6.dex */
public class MultiStartUnivariateOptimizer extends UnivariateOptimizer {
    private RandomGenerator generator;
    private int maxEvalIndex;
    private OptimizationData[] optimData;
    private UnivariatePointValuePair[] optima;
    private final UnivariateOptimizer optimizer;
    private int searchIntervalIndex;
    private int starts;
    private int totalEvaluations;

    @Override // org.apache.commons.math3.optim.BaseOptimizer
    protected /* bridge */ /* synthetic */ UnivariatePointValuePair doOptimize() {
        return doOptimize2();
    }

    @Override // org.apache.commons.math3.optim.univariate.UnivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    public /* bridge */ /* synthetic */ UnivariatePointValuePair optimize(OptimizationData[] r1) throws TooManyEvaluationsException, TooManyIterationsException {
        return optimize2(r1);
    }

    public MultiStartUnivariateOptimizer(UnivariateOptimizer r2, int r3, RandomGenerator r4) {
        super(r2.getConvergenceChecker());
        this.maxEvalIndex = -1;
        this.searchIntervalIndex = -1;
        if (r3 < 1) goto L7;
        this.optimizer = r2;
        this.starts = r3;
        this.generator = r4;
        return;
    L7:
        throw new NotStrictlyPositiveException(Integer.valueOf(r3));
    }

    @Override // org.apache.commons.math3.optim.BaseOptimizer
    public int getEvaluations() {
        return this.totalEvaluations;
    }

    public UnivariatePointValuePair[] getOptima() {
        UnivariatePointValuePair[] r2 = this.optima;
        if (r2 == null) goto L7;
        return (UnivariatePointValuePair[]) r2.clone();
    L7:
        throw new MathIllegalStateException(LocalizedFormats.NO_OPTIMUM_COMPUTED_YET, new Object[0]);
    }

    @Override // org.apache.commons.math3.optim.univariate.UnivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    /* JADX INFO: renamed from: optimize, reason: avoid collision after fix types in other method */
    public UnivariatePointValuePair optimize2(OptimizationData... r1) {
        this.optimData = r1;
        return super.optimize(r1);
    }

    @Override // org.apache.commons.math3.optim.BaseOptimizer
    /* JADX INFO: renamed from: doOptimize, reason: avoid collision after fix types in other method */
    protected UnivariatePointValuePair doOptimize2() {
        int r0 = 0;
    L3:
        OptimizationData[] r3 = this.optimData;
        if (r0 >= r3.length) goto L13;
        OptimizationData r4 = r3[r0];
        if ((r4 instanceof MaxEval) == false) goto L9;
        r3[r0] = null;
        this.maxEvalIndex = r0;
    L11:
        r0 = r0 + 1;
        goto L3
    L9:
        if ((r4 instanceof SearchInterval) == false) goto L11;
        r3[r0] = null;
        this.searchIntervalIndex = r0;
        goto L11
    L13:
        if (this.maxEvalIndex == (-1)) goto L35;
        if (this.searchIntervalIndex == (-1)) goto L33;
        this.optima = new UnivariatePointValuePair[this.starts];
        this.totalEvaluations = 0;
        int r5 = getMaxEvaluations();
        double r13 = getMin();
        double r15 = getMax();
        double r17 = getStartValue();
        int r6 = 0;
        RuntimeException e = null;
    L18:
        if (r6 >= this.starts) goto L28;
        this.optimData[this.maxEvalIndex] = new MaxEval(r5 - this.totalEvaluations);     // Catch: RuntimeException -> L25
        if (r6 != 0) goto L22;
        double r11 = r17;
    L23:
        this.optimData[this.searchIntervalIndex] = new SearchInterval(r13, r15, r11);     // Catch: RuntimeException -> L25
        this.optima[r6] = this.optimizer.optimize(this.optimData);     // Catch: RuntimeException -> L25
    L27:
        this.totalEvaluations += this.optimizer.getEvaluations();
        r6 = r6 + 1;
        goto L18
    L22:
        r11 = (this.generator.nextDouble() * (r15 - r13)) + r13;     // Catch: RuntimeException -> L25
    L25:
        e = e;
        this.optima[r6] = null;
        goto L27
    L28:
        sortPairs(getGoalType());
        UnivariatePointValuePair r1 = this.optima[0];
        if (r1 == null) goto L31;
        return r1;
    L31:
        throw e;
    L33:
        throw new MathIllegalStateException();
    L35:
        throw new MathIllegalStateException();
    }

    private void sortPairs(final GoalType r3) {
        Arrays.sort(this.optima, new AnonymousClass1(this, r3));
    }
}
