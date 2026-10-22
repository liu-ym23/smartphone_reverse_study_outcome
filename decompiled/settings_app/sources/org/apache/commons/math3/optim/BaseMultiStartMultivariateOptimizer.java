package org.apache.commons.math3.optim;

import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.random.RandomVectorGenerator;

/* JADX INFO: loaded from: classes6.dex */
public abstract class BaseMultiStartMultivariateOptimizer<PAIR> extends BaseMultivariateOptimizer<PAIR> {
    private RandomVectorGenerator generator;
    private int initialGuessIndex;
    private int maxEvalIndex;
    private OptimizationData[] optimData;
    private final BaseMultivariateOptimizer<PAIR> optimizer;
    private int starts;
    private int totalEvaluations;

    protected abstract void clear();

    public abstract PAIR[] getOptima();

    protected abstract void store(PAIR r1);

    public BaseMultiStartMultivariateOptimizer(BaseMultivariateOptimizer<PAIR> r2, int r3, RandomVectorGenerator r4) {
        super(r2.getConvergenceChecker());
        this.maxEvalIndex = -1;
        this.initialGuessIndex = -1;
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

    @Override // org.apache.commons.math3.optim.BaseMultivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    public PAIR optimize(OptimizationData... r1) {
        this.optimData = r1;
        return (PAIR) super.optimize(r1);
    }

    @Override // org.apache.commons.math3.optim.BaseOptimizer
    protected PAIR doOptimize() {
        int r0 = 0;
    L3:
        OptimizationData[] r3 = this.optimData;
        if (r0 >= r3.length) goto L13;
        if ((r3[r0] instanceof MaxEval) == false) goto L9;
        r3[r0] = null;
        this.maxEvalIndex = r0;
    L9:
        if ((r3[r0] instanceof InitialGuess) == false) goto L11;
        r3[r0] = null;
        this.initialGuessIndex = r0;
    L11:
        r0 = r0 + 1;
        goto L3
    L13:
        if (this.maxEvalIndex == (-1)) goto L53;
        if (this.initialGuessIndex == (-1)) goto L51;
        this.totalEvaluations = 0;
        clear();
        int r4 = getMaxEvaluations();
        double[] r5 = getLowerBound();
        double[] r6 = getUpperBound();
        double[] r7 = getStartPoint();
        int r8 = 0;
        RuntimeException e = null;
    L18:
        if (r8 >= this.starts) goto L45;
        this.optimData[this.maxEvalIndex] = new MaxEval(r4 - this.totalEvaluations);     // Catch: RuntimeException -> L43
        if (r8 != 0) goto L22;
        double[] r9 = r7;
    L41:
        this.optimData[this.initialGuessIndex] = new InitialGuess(r9);     // Catch: RuntimeException -> L43
        store(this.optimizer.optimize(this.optimData));     // Catch: RuntimeException -> L43
    L44:
        this.totalEvaluations += this.optimizer.getEvaluations();
        r8 = r8 + 1;
        goto L18
    L22:
        int r10 = 0;
        r9 = null;
    L23:
        if (r9 != null) goto L41;
        int r11 = r10 + 1;     // Catch: RuntimeException -> L43
        if (r10 >= getMaxEvaluations()) goto L40;
        double[] r12 = this.generator.nextVector();     // Catch: RuntimeException -> L43
        int r13 = 0;
    L27:
        if (r12 == null) goto L38;
        if (r13 >= r12.length) goto L38;
        if (r5 != null) goto L32;
    L33:
        if (r6 == null) goto L37;
        if (r12[r13] <= r6[r13]) goto L37;
    L36:
        r12 = null;
    L37:
        r13 = r13 + 1;     // Catch: RuntimeException -> L43
        goto L27
    L32:
        if (r12[r13] < r5[r13]) goto L36;
    L38:
        double[] r16 = r12;
        r10 = r11;
        r9 = r16;
        goto L23
    L40:
        throw new TooManyEvaluationsException(Integer.valueOf(getMaxEvaluations()));     // Catch: RuntimeException -> L43
    L43:
        e = e;
        goto L44
    L45:
        PAIR[] r1 = getOptima();
        if (r1.length != 0) goto L48;
        throw e;
    L48:
        return r1[0];
    L51:
        throw new MathIllegalStateException();
    L53:
        throw new MathIllegalStateException();
    }
}
