package org.apache.commons.math3.optimization.univariate;

import java.util.Arrays;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.random.RandomGenerator;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class UnivariateMultiStartOptimizer<FUNC extends UnivariateFunction> implements BaseUnivariateOptimizer<FUNC> {
    private RandomGenerator generator;
    private int maxEvaluations;
    private UnivariatePointValuePair[] optima;
    private final BaseUnivariateOptimizer<FUNC> optimizer;
    private int starts;
    private int totalEvaluations;

    public UnivariateMultiStartOptimizer(BaseUnivariateOptimizer<FUNC> r2, int r3, RandomGenerator r4) {
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

    @Override // org.apache.commons.math3.optimization.BaseOptimizer
    public ConvergenceChecker<UnivariatePointValuePair> getConvergenceChecker() {
        return this.optimizer.getConvergenceChecker();
    }

    @Override // org.apache.commons.math3.optimization.BaseOptimizer
    public int getMaxEvaluations() {
        return this.maxEvaluations;
    }

    @Override // org.apache.commons.math3.optimization.BaseOptimizer
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

    @Override // org.apache.commons.math3.optimization.univariate.BaseUnivariateOptimizer
    public UnivariatePointValuePair optimize(int r11, FUNC r12, GoalType r13, double r14, double r16) {
        return optimize(r11, r12, r13, r14, r16, r14 + ((r16 - r14) * 0.5d));
    }

    @Override // org.apache.commons.math3.optimization.univariate.BaseUnivariateOptimizer
    public UnivariatePointValuePair optimize(int r17, FUNC r18, GoalType r19, double r20, double r22, double r24) {
        this.optima = new UnivariatePointValuePair[this.starts];
        this.totalEvaluations = 0;
        int r14 = 0;
        RuntimeException e = null;
    L4:
        if (r14 >= this.starts) goto L13;
        if (r14 != 0) goto L7;
        double r10 = r24;
    L17:
        this.optima[r14] = this.optimizer.optimize(r17 - this.totalEvaluations, r18, r19, r20, r22, r10);     // Catch: RuntimeException -> L10
    L12:
        this.totalEvaluations += this.optimizer.getEvaluations();
        r14 = r14 + 1;
    L10:
        e = e;
        this.optima[r14] = null;
        goto L12
    L7:
        r10 = r20 + (this.generator.nextDouble() * (r22 - r20));     // Catch: RuntimeException -> L10
        goto L17
    L13:
        sortPairs(r19);
        UnivariatePointValuePair r1 = this.optima[0];
        if (r1 == null) goto L16;
        return r1;
    L16:
        throw e;
    }

    private void sortPairs(final GoalType r3) {
        Arrays.sort(this.optima, new AnonymousClass1(this, r3));
    }
}
