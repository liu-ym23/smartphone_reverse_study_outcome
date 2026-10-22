package org.apache.commons.math3.optim;

import org.apache.commons.math3.util.Incrementor;

/* JADX INFO: loaded from: classes6.dex */
public interface OptimizationProblem<PAIR> {
    ConvergenceChecker<PAIR> getConvergenceChecker();

    Incrementor getEvaluationCounter();

    Incrementor getIterationCounter();
}
