package org.apache.commons.math3.optim;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractConvergenceChecker<PAIR> implements ConvergenceChecker<PAIR> {
    private final double absoluteThreshold;
    private final double relativeThreshold;

    @Override // org.apache.commons.math3.optim.ConvergenceChecker
    public abstract boolean converged(int r1, PAIR r2, PAIR r3);

    public AbstractConvergenceChecker(double r1, double r3) {
        this.relativeThreshold = r1;
        this.absoluteThreshold = r3;
    }

    public double getRelativeThreshold() {
        return this.relativeThreshold;
    }

    public double getAbsoluteThreshold() {
        return this.absoluteThreshold;
    }
}
