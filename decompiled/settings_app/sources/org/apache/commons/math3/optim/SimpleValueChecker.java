package org.apache.commons.math3.optim;

import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class SimpleValueChecker extends AbstractConvergenceChecker<PointValuePair> {
    private static final int ITERATION_CHECK_DISABLED = -1;
    private final int maxIterationCount;

    @Override // org.apache.commons.math3.optim.AbstractConvergenceChecker, org.apache.commons.math3.optim.ConvergenceChecker
    public /* bridge */ /* synthetic */ boolean converged(int r1, Object r2, Object r3) {
        return converged(r1, (PointValuePair) r2, (PointValuePair) r3);
    }

    public SimpleValueChecker(double r1, double r3) {
        super(r1, r3);
        this.maxIterationCount = -1;
    }

    public SimpleValueChecker(double r1, double r3, int r5) {
        super(r1, r3);
        if (r5 <= 0) goto L7;
        this.maxIterationCount = r5;
        return;
    L7:
        throw new NotStrictlyPositiveException(Integer.valueOf(r5));
    }

    public boolean converged(int r6, PointValuePair r7, PointValuePair r8) {
        int r0 = this.maxIterationCount;
        if (r0 == (-1)) goto L6;
        if (r6 < r0) goto L6;
        return true;
    L6:
        double r9 = r7.getValue().doubleValue();
        double r1 = r8.getValue().doubleValue();
        double r3 = FastMath.abs(r9 - r1);
        if (r3 > (FastMath.max(FastMath.abs(r9), FastMath.abs(r1)) * getRelativeThreshold())) goto L9;
        return true;
    L9:
        if (r3 <= getAbsoluteThreshold()) goto L14;
        return false;
    L14:
        return true;
    }
}
