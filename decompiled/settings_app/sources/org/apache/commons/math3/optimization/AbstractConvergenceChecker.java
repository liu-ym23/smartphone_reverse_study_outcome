package org.apache.commons.math3.optimization;

import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public abstract class AbstractConvergenceChecker<PAIR> implements ConvergenceChecker<PAIR> {

    @Deprecated
    private static final double DEFAULT_ABSOLUTE_THRESHOLD = 0.0d;

    @Deprecated
    private static final double DEFAULT_RELATIVE_THRESHOLD = 0.0d;
    private final double absoluteThreshold;
    private final double relativeThreshold;

    @Override // org.apache.commons.math3.optimization.ConvergenceChecker
    public abstract boolean converged(int r1, PAIR r2, PAIR r3);

    static {
        DEFAULT_RELATIVE_THRESHOLD = Precision.EPSILON * 100.0d;
        DEFAULT_ABSOLUTE_THRESHOLD = Precision.SAFE_MIN * 100.0d;
    }

    @Deprecated
    public AbstractConvergenceChecker() {
        this.relativeThreshold = DEFAULT_RELATIVE_THRESHOLD;
        this.absoluteThreshold = DEFAULT_ABSOLUTE_THRESHOLD;
    }

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
