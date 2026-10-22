package org.apache.commons.math3.analysis.integration;

import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class LegendreGaussIntegrator extends BaseAbstractUnivariateIntegrator {
    private static final double[] ABSCISSAS_2 = null;
    private static final double[] ABSCISSAS_3 = null;
    private static final double[] ABSCISSAS_4 = null;
    private static final double[] ABSCISSAS_5 = null;
    private static final double[] WEIGHTS_2 = null;
    private static final double[] WEIGHTS_3 = null;
    private static final double[] WEIGHTS_4 = null;
    private static final double[] WEIGHTS_5 = null;
    private final double[] abscissas;
    private final double[] weights;

    static {
        ABSCISSAS_2 = new double[]{(-1.0d) / FastMath.sqrt(3.0d), 1.0d / FastMath.sqrt(3.0d)};
        WEIGHTS_2 = new double[]{1.0d, 1.0d};
        ABSCISSAS_3 = new double[]{-FastMath.sqrt(0.6d), 0.0d, FastMath.sqrt(0.6d)};
        WEIGHTS_3 = new double[]{0.5555555555555556d, 0.8888888888888888d, 0.5555555555555556d};
        ABSCISSAS_4 = new double[]{-FastMath.sqrt(((FastMath.sqrt(30.0d) * 2.0d) + 15.0d) / 35.0d), -FastMath.sqrt((15.0d - (FastMath.sqrt(30.0d) * 2.0d)) / 35.0d), FastMath.sqrt((15.0d - (FastMath.sqrt(30.0d) * 2.0d)) / 35.0d), FastMath.sqrt(((FastMath.sqrt(30.0d) * 2.0d) + 15.0d) / 35.0d)};
        WEIGHTS_4 = new double[]{(90.0d - (FastMath.sqrt(30.0d) * 5.0d)) / 180.0d, ((FastMath.sqrt(30.0d) * 5.0d) + 90.0d) / 180.0d, ((FastMath.sqrt(30.0d) * 5.0d) + 90.0d) / 180.0d, (90.0d - (FastMath.sqrt(30.0d) * 5.0d)) / 180.0d};
        ABSCISSAS_5 = new double[]{-FastMath.sqrt(((FastMath.sqrt(70.0d) * 2.0d) + 35.0d) / 63.0d), -FastMath.sqrt((35.0d - (FastMath.sqrt(70.0d) * 2.0d)) / 63.0d), 0.0d, FastMath.sqrt((35.0d - (FastMath.sqrt(70.0d) * 2.0d)) / 63.0d), FastMath.sqrt(((FastMath.sqrt(70.0d) * 2.0d) + 35.0d) / 63.0d)};
        WEIGHTS_5 = new double[]{(322.0d - (FastMath.sqrt(70.0d) * 13.0d)) / 900.0d, ((FastMath.sqrt(70.0d) * 13.0d) + 322.0d) / 900.0d, 0.5688888888888889d, ((FastMath.sqrt(70.0d) * 13.0d) + 322.0d) / 900.0d, (322.0d - (FastMath.sqrt(70.0d) * 13.0d)) / 900.0d};
    }

    public LegendreGaussIntegrator(int r8, double r9, double r11, int r13, int r14) throws MathIllegalArgumentException, NotStrictlyPositiveException, NumberIsTooSmallException {
        super(r9, r11, r13, r14);
        if (r8 != 2) goto L5;
        this.abscissas = ABSCISSAS_2;
        this.weights = WEIGHTS_2;
        return;
    L5:
        if (r8 != 3) goto L7;
        this.abscissas = ABSCISSAS_3;
        this.weights = WEIGHTS_3;
        return;
    L7:
        if (r8 != 4) goto L9;
        this.abscissas = ABSCISSAS_4;
        this.weights = WEIGHTS_4;
        return;
    L9:
        if (r8 != 5) goto L12;
        this.abscissas = ABSCISSAS_5;
        this.weights = WEIGHTS_5;
        return;
    L12:
        throw new MathIllegalArgumentException(LocalizedFormats.N_POINTS_GAUSS_LEGENDRE_INTEGRATOR_NOT_SUPPORTED, new Object[]{Integer.valueOf(r8), 2, 5});
    }

    public LegendreGaussIntegrator(int r9, double r10, double r12) throws MathIllegalArgumentException {
        this(r9, r10, r12, 3, Integer.MAX_VALUE);
    }

    public LegendreGaussIntegrator(int r9, int r10, int r11) throws MathIllegalArgumentException {
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
        r3 = FastMath.max((int) (FastMath.min(4.0d, FastMath.pow(r6 / r8, 0.5d / ((double) this.abscissas.length))) * ((double) r3)), r3 + 1);
        incrementCount();
        r1 = r4;
        goto L3
    }

    private double stage(int r20) throws TooManyEvaluationsException {
        double r2 = (getMax() - getMin()) / ((double) r20);
        double r4 = r2 / 2.0d;
        double r6 = getMin() + r4;
        double r8 = 0.0d;
        int r11 = 0;
    L3:
        if (r11 >= r20) goto L10;
        int r12 = 0;
    L5:
        double[] r13 = this.abscissas;
        if (r12 >= r13.length) goto L8;
        r8 = r8 + (this.weights[r12] * computeObjectiveValue(r6 + (r13[r12] * r4)));
        r12 = r12 + 1;
        r11 = r11;
        goto L5
    L8:
        r6 = r6 + r2;
        r11 = r11 + 1;
        goto L3
    L10:
        return r4 * r8;
    }
}
