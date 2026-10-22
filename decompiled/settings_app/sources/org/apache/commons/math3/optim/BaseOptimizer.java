package org.apache.commons.math3.optim;

import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.exception.TooManyIterationsException;
import org.apache.commons.math3.util.Incrementor;

/* JADX INFO: loaded from: classes6.dex */
public abstract class BaseOptimizer<PAIR> {
    private final ConvergenceChecker<PAIR> checker;
    protected final Incrementor evaluations;
    protected final Incrementor iterations;

    /* JADX INFO: renamed from: org.apache.commons.math3.optim.BaseOptimizer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class MaxEvalCallback implements Incrementor.MaxCountExceededCallback {
        private MaxEvalCallback() {
        }

        /* synthetic */ MaxEvalCallback(AnonymousClass1 r1) {
            this();
        }

        @Override // org.apache.commons.math3.util.Incrementor.MaxCountExceededCallback
        public void trigger(int r1) {
            throw new TooManyEvaluationsException(Integer.valueOf(r1));
        }
    }

    private static class MaxIterCallback implements Incrementor.MaxCountExceededCallback {
        private MaxIterCallback() {
        }

        /* synthetic */ MaxIterCallback(AnonymousClass1 r1) {
            this();
        }

        @Override // org.apache.commons.math3.util.Incrementor.MaxCountExceededCallback
        public void trigger(int r1) {
            throw new TooManyIterationsException(Integer.valueOf(r1));
        }
    }

    protected abstract PAIR doOptimize();

    protected BaseOptimizer(ConvergenceChecker<PAIR> r3) {
        this(r3, 0, Integer.MAX_VALUE);
    }

    protected BaseOptimizer(ConvergenceChecker<PAIR> r3, int r4, int r5) {
        this.checker = r3;
        AnonymousClass1 r1 = null;
        this.evaluations = new Incrementor(r4, new MaxEvalCallback(r1));
        this.iterations = new Incrementor(r5, new MaxIterCallback(r1));
    }

    public int getMaxEvaluations() {
        return this.evaluations.getMaximalCount();
    }

    public int getEvaluations() {
        return this.evaluations.getCount();
    }

    public int getMaxIterations() {
        return this.iterations.getMaximalCount();
    }

    public int getIterations() {
        return this.iterations.getCount();
    }

    public ConvergenceChecker<PAIR> getConvergenceChecker() {
        return this.checker;
    }

    public PAIR optimize(OptimizationData... r1) throws TooManyEvaluationsException, TooManyIterationsException {
        parseOptimizationData(r1);
        this.evaluations.resetCount();
        this.iterations.resetCount();
        return doOptimize();
    }

    public PAIR optimize() throws TooManyEvaluationsException, TooManyIterationsException {
        this.evaluations.resetCount();
        this.iterations.resetCount();
        return doOptimize();
    }

    protected void incrementEvaluationCount() throws TooManyEvaluationsException {
        this.evaluations.incrementCount();
    }

    protected void incrementIterationCount() throws TooManyIterationsException {
        this.iterations.incrementCount();
    }

    protected void parseOptimizationData(OptimizationData... r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        OptimizationData r2 = r5[r1];
        if ((r2 instanceof MaxEval) == false) goto L8;
        this.evaluations.setMaximalCount(((MaxEval) r2).getMaxEval());
    L10:
        r1 = r1 + 1;
        goto L3
    L8:
        if ((r2 instanceof MaxIter) == false) goto L10;
        this.iterations.setMaximalCount(((MaxIter) r2).getMaxIter());
        goto L10
    }
}
