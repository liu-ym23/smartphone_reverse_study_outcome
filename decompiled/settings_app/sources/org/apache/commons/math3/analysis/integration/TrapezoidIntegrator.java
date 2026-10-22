package org.apache.commons.math3.analysis.integration;

import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class TrapezoidIntegrator extends BaseAbstractUnivariateIntegrator {
    public static final int TRAPEZOID_MAX_ITERATIONS_COUNT = 64;
    private double s;

    public TrapezoidIntegrator(double r1, double r3, int r5, int r6) throws NotStrictlyPositiveException, NumberIsTooSmallException, NumberIsTooLargeException {
        super(r1, r3, r5, r6);
        if (r6 > 64) goto L6;
        return;
    L6:
        throw new NumberIsTooLargeException(Integer.valueOf(r6), 64, false);
    }

    public TrapezoidIntegrator(int r2, int r3) throws NotStrictlyPositiveException, NumberIsTooSmallException, NumberIsTooLargeException {
        super(r2, r3);
        if (r3 > 64) goto L6;
        return;
    L6:
        throw new NumberIsTooLargeException(Integer.valueOf(r3), 64, false);
    }

    public TrapezoidIntegrator() {
        super(3, 64);
    }

    double stage(BaseAbstractUnivariateIntegrator r20, int r21) throws TooManyEvaluationsException {
        if (r21 != 0) goto L6;
        double r4 = r20.getMax();
        double r6 = r20.getMin();
        double r8 = ((r4 - r6) * 0.5d) * (r20.computeObjectiveValue(r6) + r20.computeObjectiveValue(r4));
        this.s = r8;
        return r8;
    L6:
        long r7 = 1 << (r21 - 1);
        double r9 = r20.getMax();
        double r11 = r20.getMin();
        double r10 = (r9 - r11) / r7;
        double r12 = r11 + (r10 * 0.5d);
        double r13 = 0.0d;
        long r15 = 0;
    L8:
        if (r15 >= r7) goto L10;
        r13 = r13 + r20.computeObjectiveValue(r12);
        r12 = r12 + r10;
        r15 = r15 + 1;
        goto L8
    L10:
        double r5 = (this.s + (r13 * r10)) * 0.5d;
        this.s = r5;
        return r5;
    }

    @Override // org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator
    protected double doIntegrate() throws MathIllegalArgumentException, TooManyEvaluationsException, MaxCountExceededException {
        double r0 = stage(this, 0);
        incrementCount();
    L3:
        int r2 = getIterations();
        double r3 = stage(this, r2);
        if (r2 < getMinimalIterationCount()) goto L10;
        double r5 = FastMath.abs(r3 - r0);
        if (r5 <= ((getRelativeAccuracy() * (FastMath.abs(r0) + FastMath.abs(r3))) * 0.5d)) goto L9;
        if (r5 > getAbsoluteAccuracy()) goto L10;
    L9:
        return r3;
    L10:
        incrementCount();
        r0 = r3;
        goto L3
    }
}
