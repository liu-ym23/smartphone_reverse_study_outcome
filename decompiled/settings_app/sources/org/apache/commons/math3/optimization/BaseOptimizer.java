package org.apache.commons.math3.optimization;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public interface BaseOptimizer<PAIR> {
    ConvergenceChecker<PAIR> getConvergenceChecker();

    int getEvaluations();

    int getMaxEvaluations();
}
