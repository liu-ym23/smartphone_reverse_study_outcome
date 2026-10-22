package org.apache.commons.math3.analysis.integration;

import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class SimpsonIntegrator extends BaseAbstractUnivariateIntegrator {
    public static final int SIMPSON_MAX_ITERATIONS_COUNT = 64;

    public SimpsonIntegrator(double r1, double r3, int r5, int r6) throws NotStrictlyPositiveException, NumberIsTooSmallException, NumberIsTooLargeException {
        super(r1, r3, r5, r6);
        if (r6 > 64) goto L6;
        return;
    L6:
        throw new NumberIsTooLargeException(Integer.valueOf(r6), 64, false);
    }

    public SimpsonIntegrator(int r2, int r3) throws NotStrictlyPositiveException, NumberIsTooSmallException, NumberIsTooLargeException {
        super(r2, r3);
        if (r3 > 64) goto L6;
        return;
    L6:
        throw new NumberIsTooLargeException(Integer.valueOf(r3), 64, false);
    }

    public SimpsonIntegrator() {
        super(3, 64);
    }

    @Override // org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator
    protected double doIntegrate() throws TooManyEvaluationsException, MaxCountExceededException {
        TrapezoidIntegrator r1 = new TrapezoidIntegrator();
        if (getMinimalIterationCount() == 1) goto L5;
        double r7 = r1.stage(this, 0);
        double r9 = 0.0d;
    L7:
        double r11 = r1.stage(this, getIterations());
        incrementCount();
        double r8 = ((r11 * 4.0d) - r7) / 3.0d;
        if (getIterations() < getMinimalIterationCount()) goto L14;
        double r13 = FastMath.abs(r8 - r9);
        if (r13 <= ((getRelativeAccuracy() * (FastMath.abs(r9) + FastMath.abs(r8))) * 0.5d)) goto L13;
        if (r13 > getAbsoluteAccuracy()) goto L14;
    L13:
        return r8;
    L14:
        r9 = r8;
        r7 = r11;
        goto L7
    L5:
        return ((r1.stage(this, 1) * 4.0d) - r1.stage(this, 0)) / 3.0d;
    }
}
