package org.apache.commons.math3.optimization;

import java.util.Arrays;
import org.apache.commons.math3.analysis.MultivariateVectorFunction;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomVectorGenerator;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class BaseMultivariateVectorMultiStartOptimizer<FUNC extends MultivariateVectorFunction> implements BaseMultivariateVectorOptimizer<FUNC> {
    private RandomVectorGenerator generator;
    private int maxEvaluations;
    private PointVectorValuePair[] optima;
    private final BaseMultivariateVectorOptimizer<FUNC> optimizer;
    private int starts;
    private int totalEvaluations;

    protected BaseMultivariateVectorMultiStartOptimizer(BaseMultivariateVectorOptimizer<FUNC> r2, int r3, RandomVectorGenerator r4) {
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

    public PointVectorValuePair[] getOptima() {
        PointVectorValuePair[] r2 = this.optima;
        if (r2 == null) goto L7;
        return (PointVectorValuePair[]) r2.clone();
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
    public ConvergenceChecker<PointVectorValuePair> getConvergenceChecker() {
        return this.optimizer.getConvergenceChecker();
    }

    @Override // org.apache.commons.math3.optimization.BaseMultivariateVectorOptimizer
    public PointVectorValuePair optimize(int r14, FUNC r15, double[] r16, double[] r17, double[] r18) {
        this.maxEvaluations = r14;
        this.optima = new PointVectorValuePair[this.starts];
        this.totalEvaluations = 0;
        int r5 = 0;
        RuntimeException e = null;
    L4:
        if (r5 >= this.starts) goto L15;
        PointVectorValuePair[] r6 = this.optima;     // Catch: RuntimeException -> L11 ConvergenceException -> L13
        BaseMultivariateVectorOptimizer<FUNC> r7 = this.optimizer;     // Catch: RuntimeException -> L11 ConvergenceException -> L13
        int r8 = r14 - this.totalEvaluations;     // Catch: RuntimeException -> L11 ConvergenceException -> L13
        if (r5 != 0) goto L8;
        double[] r12 = r18;
    L9:
        r6[r5] = r7.optimize(r8, r15, r16, r17, r12);     // Catch: RuntimeException -> L11 ConvergenceException -> L13
    L14:
        this.totalEvaluations += this.optimizer.getEvaluations();
        r5 = r5 + 1;
        goto L4
    L8:
        r12 = this.generator.nextVector();     // Catch: RuntimeException -> L11 ConvergenceException -> L13
        goto L9
    L13:
        this.optima[r5] = null;
    L11:
        e = e;
        this.optima[r5] = null;
        goto L14
    L15:
        sortPairs(r16, r17);
        PointVectorValuePair r1 = this.optima[0];
        if (r1 == null) goto L18;
        return r1;
    L18:
        throw e;
    }

    private void sortPairs(final double[] r3, final double[] r4) {
        Arrays.sort(this.optima, new AnonymousClass1(this, r3, r4));
    }
}
