package org.apache.commons.math3.analysis.integration;

import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class RombergIntegrator extends BaseAbstractUnivariateIntegrator {
    public static final int ROMBERG_MAX_ITERATIONS_COUNT = 32;

    public RombergIntegrator(double r1, double r3, int r5, int r6) throws NotStrictlyPositiveException, NumberIsTooSmallException, NumberIsTooLargeException {
        super(r1, r3, r5, r6);
        if (r6 > 32) goto L6;
        return;
    L6:
        throw new NumberIsTooLargeException(Integer.valueOf(r6), 32, false);
    }

    public RombergIntegrator(int r2, int r3) throws NotStrictlyPositiveException, NumberIsTooSmallException, NumberIsTooLargeException {
        super(r2, r3);
        if (r3 > 32) goto L6;
        return;
    L6:
        throw new NumberIsTooLargeException(Integer.valueOf(r3), 32, false);
    }

    public RombergIntegrator() {
        super(3, 32);
    }

    @Override // org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator
    protected double doIntegrate() throws TooManyEvaluationsException, MaxCountExceededException {
        int r1 = getMaximalIterationCount() + 1;
        double[] r3 = new double[r1];
        double[] r2 = new double[r1];
        TrapezoidIntegrator r4 = new TrapezoidIntegrator();
        r2[0] = r4.stage(this, 0);
        incrementCount();
        double r6 = r2[0];
    L3:
        int r8 = getIterations();
        r3[0] = r4.stage(this, r8);
        incrementCount();
        int r9 = 1;
    L4:
        if (r9 > r8) goto L6;
        int r12 = r9 - 1;
        double r13 = r3[r12];
        r3[r9] = r13 + ((r13 - r2[r12]) / ((1 << (r9 * 2)) - 1));
        r9 = r9 + 1;
        goto L4
    L6:
        double r10 = r3[r8];
        if (r8 < getMinimalIterationCount()) goto L13;
        double r11 = FastMath.abs(r10 - r6);
        if (r11 <= ((getRelativeAccuracy() * (FastMath.abs(r6) + FastMath.abs(r10))) * 0.5d)) goto L12;
        if (r11 > getAbsoluteAccuracy()) goto L13;
    L12:
        return r10;
    L13:
        r6 = r10;
        double[] r17 = r3;
        r3 = r2;
        r2 = r17;
        goto L3
    }
}
