package org.apache.commons.math3.optim;

/* JADX INFO: loaded from: classes6.dex */
public interface ConvergenceChecker<PAIR> {
    boolean converged(int r1, PAIR r2, PAIR r3);
}
