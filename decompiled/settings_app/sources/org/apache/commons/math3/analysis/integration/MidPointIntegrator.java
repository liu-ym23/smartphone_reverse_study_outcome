package org.apache.commons.math3.analysis.integration;

import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class MidPointIntegrator extends BaseAbstractUnivariateIntegrator {
    public static final int MIDPOINT_MAX_ITERATIONS_COUNT = 64;

    public MidPointIntegrator(double r1, double r3, int r5, int r6) throws NotStrictlyPositiveException, NumberIsTooSmallException, NumberIsTooLargeException {
        super(r1, r3, r5, r6);
        if (r6 > 64) goto L6;
        return;
    L6:
        throw new NumberIsTooLargeException(Integer.valueOf(r6), 64, false);
    }

    public MidPointIntegrator(int r2, int r3) throws NotStrictlyPositiveException, NumberIsTooSmallException, NumberIsTooLargeException {
        super(r2, r3);
        if (r3 > 64) goto L6;
        return;
    L6:
        throw new NumberIsTooLargeException(Integer.valueOf(r3), 64, false);
    }

    public MidPointIntegrator() {
        super(3, 64);
    }

    private double stage(int r18, double r19, double r21, double r23) throws TooManyEvaluationsException {
        long r3 = 1 << (r18 - 1);
        double r5 = r23 / r3;
        double r9 = r21 + (r5 * 0.5d);
        double r11 = 0.0d;
        long r13 = 0;
    L4:
        if (r13 >= r3) goto L7;
        r11 = r11 + computeObjectiveValue(r9);
        r9 = r9 + r5;
        r13 = r13 + 1;
        goto L4
    L7:
        return (r19 + (r11 * r5)) * 0.5d;
    }

    @Override // org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator
    protected double doIntegrate() throws MathIllegalArgumentException, TooManyEvaluationsException, MaxCountExceededException {
        double r8 = getMin();
        double r10 = getMax() - r8;
        double r15 = computeObjectiveValue((r10 * 0.5d) + r8) * r10;
    L3:
        incrementCount();
        int r6 = getIterations();
        double r0 = stage(r6, r15, r8, r10);
        if (r6 < getMinimalIterationCount()) goto L10;
        double r2 = FastMath.abs(r0 - r15);
        double r4 = getRelativeAccuracy() * (FastMath.abs(r15) + FastMath.abs(r0));
        long r7 = 4602678819172646912L;
        if (r2 <= (r4 * 0.5d)) goto L9;
        if (r2 <= getAbsoluteAccuracy()) goto L9;
    L11:
        r15 = r0;
    L9:
        return r0;
    L10:
        r7 = 4602678819172646912L;
        goto L11
    }
}
