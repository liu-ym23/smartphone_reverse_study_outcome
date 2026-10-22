package org.apache.commons.math3.optimization;

import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class SimpleVectorValueChecker extends AbstractConvergenceChecker<PointVectorValuePair> {
    private static final int ITERATION_CHECK_DISABLED = -1;
    private final int maxIterationCount;

    @Override // org.apache.commons.math3.optimization.AbstractConvergenceChecker, org.apache.commons.math3.optimization.ConvergenceChecker
    public /* bridge */ /* synthetic */ boolean converged(int r1, Object r2, Object r3) {
        return converged(r1, (PointVectorValuePair) r2, (PointVectorValuePair) r3);
    }

    @Deprecated
    public SimpleVectorValueChecker() {
        this.maxIterationCount = -1;
    }

    public SimpleVectorValueChecker(double r1, double r3) {
        super(r1, r3);
        this.maxIterationCount = -1;
    }

    public SimpleVectorValueChecker(double r1, double r3, int r5) {
        super(r1, r3);
        if (r5 <= 0) goto L7;
        this.maxIterationCount = r5;
        return;
    L7:
        throw new NotStrictlyPositiveException(Integer.valueOf(r5));
    }

    public boolean converged(int r10, PointVectorValuePair r11, PointVectorValuePair r12) {
        int r0 = this.maxIterationCount;
        if (r0 == (-1)) goto L6;
        if (r10 < r0) goto L6;
        return true;
    L6:
        double[] r13 = r11.getValueRef();
        double[] r14 = r12.getValueRef();
        int r1 = 0;
    L8:
        if (r1 >= r13.length) goto L15;
        double r3 = r13[r1];
        double r5 = r14[r1];
        double r7 = FastMath.abs(r3 - r5);
        if (r7 <= (FastMath.max(FastMath.abs(r3), FastMath.abs(r5)) * getRelativeThreshold())) goto L14;
        if (r7 <= getAbsoluteThreshold()) goto L14;
        return false;
    L14:
        r1 = r1 + 1;
        goto L8
    L15:
        return true;
    }
}
