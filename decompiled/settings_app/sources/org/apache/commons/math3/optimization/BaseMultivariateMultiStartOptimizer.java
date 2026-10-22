package org.apache.commons.math3.optimization;

import java.util.Arrays;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomVectorGenerator;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class BaseMultivariateMultiStartOptimizer<FUNC extends MultivariateFunction> implements BaseMultivariateOptimizer<FUNC> {
    private RandomVectorGenerator generator;
    private int maxEvaluations;
    private PointValuePair[] optima;
    private final BaseMultivariateOptimizer<FUNC> optimizer;
    private int starts;
    private int totalEvaluations;

    protected BaseMultivariateMultiStartOptimizer(BaseMultivariateOptimizer<FUNC> r2, int r3, RandomVectorGenerator r4) {
        if (r2 == null) goto L12;
        if (r4 == null) goto L12;
        if (r3 < 1) goto L10;
        this.optimizer = r2;
        this.starts = r3;
        this.generator = r4;
        return;
    L10:
        throw new NotStrictlyPositiveException(Integer.valueOf(r3));
    L12:
        throw new NullArgumentException();
    }

    public PointValuePair[] getOptima() {
        PointValuePair[] r2 = this.optima;
        if (r2 == null) goto L7;
        return (PointValuePair[]) r2.clone();
    L7:
        throw new MathIllegalStateException(LocalizedFormats.NO_OPTIMUM_COMPUTED_YET, new Object[0]);
    }

    @Override // org.apache.commons.math3.optimization.BaseOptimizer
    public int getMaxEvaluations() {
        return this.maxEvaluations;
    }

    @Override // org.apache.commons.math3.optimization.BaseOptimizer
    public int getEvaluations() {
        return this.totalEvaluations;
    }

    @Override // org.apache.commons.math3.optimization.BaseOptimizer
    public ConvergenceChecker<PointValuePair> getConvergenceChecker() {
        return this.optimizer.getConvergenceChecker();
    }

    @Override // org.apache.commons.math3.optimization.BaseMultivariateOptimizer
    public PointValuePair optimize(int r9, FUNC r10, GoalType r11, double[] r12) {
        this.maxEvaluations = r9;
        this.optima = new PointValuePair[this.starts];
        this.totalEvaluations = 0;
        int r2 = 0;
        RuntimeException e = null;
    L4:
        if (r2 >= this.starts) goto L14;
        PointValuePair[] r4 = this.optima;     // Catch: RuntimeException -> L11
        BaseMultivariateOptimizer<FUNC> r5 = this.optimizer;     // Catch: RuntimeException -> L11
        int r6 = r9 - this.totalEvaluations;     // Catch: RuntimeException -> L11
        if (r2 != 0) goto L8;
        double[] r7 = r12;
    L9:
        r4[r2] = r5.optimize(r6, r10, r11, r7);     // Catch: RuntimeException -> L11
    L13:
        this.totalEvaluations += this.optimizer.getEvaluations();
        r2 = r2 + 1;
        goto L4
    L8:
        r7 = this.generator.nextVector();     // Catch: RuntimeException -> L11
    L11:
        e = e;
        this.optima[r2] = null;
        goto L13
    L14:
        sortPairs(r11);
        PointValuePair r8 = this.optima[0];
        if (r8 == null) goto L17;
        return r8;
    L17:
        throw e;
    }

    private void sortPairs(final GoalType r3) {
        Arrays.sort(this.optima, new AnonymousClass1(this, r3));
    }
}
