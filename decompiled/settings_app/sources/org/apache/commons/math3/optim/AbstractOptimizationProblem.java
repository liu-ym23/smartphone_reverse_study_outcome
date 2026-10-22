package org.apache.commons.math3.optim;

import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.exception.TooManyIterationsException;
import org.apache.commons.math3.util.Incrementor;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractOptimizationProblem<PAIR> implements OptimizationProblem<PAIR> {
    private static final MaxEvalCallback MAX_EVAL_CALLBACK = null;
    private static final MaxIterCallback MAX_ITER_CALLBACK = null;
    private final ConvergenceChecker<PAIR> checker;
    private final int maxEvaluations;
    private final int maxIterations;

    /* JADX INFO: renamed from: org.apache.commons.math3.optim.AbstractOptimizationProblem$1, reason: invalid class name */
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

    static {
        AnonymousClass1 r1 = null;
        MAX_EVAL_CALLBACK = new MaxEvalCallback(r1);
        MAX_ITER_CALLBACK = new MaxIterCallback(r1);
    }

    protected AbstractOptimizationProblem(int r1, int r2, ConvergenceChecker<PAIR> r3) {
        this.maxEvaluations = r1;
        this.maxIterations = r2;
        this.checker = r3;
    }

    @Override // org.apache.commons.math3.optim.OptimizationProblem
    public Incrementor getEvaluationCounter() {
        return new Incrementor(this.maxEvaluations, MAX_EVAL_CALLBACK);
    }

    @Override // org.apache.commons.math3.optim.OptimizationProblem
    public Incrementor getIterationCounter() {
        return new Incrementor(this.maxIterations, MAX_ITER_CALLBACK);
    }

    @Override // org.apache.commons.math3.optim.OptimizationProblem
    public ConvergenceChecker<PAIR> getConvergenceChecker() {
        return this.checker;
    }
}
