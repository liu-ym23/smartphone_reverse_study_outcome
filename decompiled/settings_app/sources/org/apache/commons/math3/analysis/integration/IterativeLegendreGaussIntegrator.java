package org.apache.commons.math3.analysis.integration;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.integration.gauss.GaussIntegratorFactory;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class IterativeLegendreGaussIntegrator extends BaseAbstractUnivariateIntegrator {
    private static final GaussIntegratorFactory FACTORY = null;
    private final int numberOfPoints;

    static {
        FACTORY = new GaussIntegratorFactory();
    }

    public IterativeLegendreGaussIntegrator(int r8, double r9, double r11, int r13, int r14) throws NotStrictlyPositiveException, NumberIsTooSmallException {
        super(r9, r11, r13, r14);
        if (r8 <= 0) goto L7;
        this.numberOfPoints = r8;
        return;
    L7:
        throw new NotStrictlyPositiveException(LocalizedFormats.NUMBER_OF_POINTS, Integer.valueOf(r8));
    }

    public IterativeLegendreGaussIntegrator(int r9, double r10, double r12) throws NotStrictlyPositiveException {
        this(r9, r10, r12, 3, Integer.MAX_VALUE);
    }

    public IterativeLegendreGaussIntegrator(int r9, int r10, int r11) throws NotStrictlyPositiveException, NumberIsTooSmallException {
        this(r9, 1.0E-6d, 1.0E-15d, r10, r11);
    }

    @Override // org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator
    protected double doIntegrate() throws MathIllegalArgumentException, TooManyEvaluationsException, MaxCountExceededException {
        double r1 = stage(1);
        int r3 = 2;
    L3:
        double r4 = stage(r3);
        double r6 = FastMath.abs(r4 - r1);
        double r8 = FastMath.max(getAbsoluteAccuracy(), (getRelativeAccuracy() * (FastMath.abs(r1) + FastMath.abs(r4))) * 0.5d);
        if ((getIterations() + 1) < getMinimalIterationCount()) goto L8;
        if (r6 > r8) goto L8;
        return r4;
    L8:
        r3 = FastMath.max((int) (FastMath.min(4.0d, FastMath.pow(r6 / r8, 0.5d / ((double) this.numberOfPoints))) * ((double) r3)), r3 + 1);
        incrementCount();
        r1 = r4;
        goto L3
    }

    private double stage(int r19) throws TooManyEvaluationsException {
        UnivariateFunction r2 = new AnonymousClass1(this);
        double r3 = getMin();
        double r5 = (getMax() - r3) / ((double) r19);
        double r7 = 0.0d;
        int r9 = 0;
    L3:
        if (r9 >= r19) goto L5;
        double r14 = r3 + (((double) r9) * r5);
        GaussIntegratorFactory r12 = FACTORY;
        int r13 = this.numberOfPoints;
        r7 = r7 + r12.legendreHighPrecision(r13, r14, r14 + r5).integrate(r2);
        r9 = r9 + 1;
        goto L3
    L5:
        return r7;
    }
}
