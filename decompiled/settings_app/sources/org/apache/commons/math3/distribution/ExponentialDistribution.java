package org.apache.commons.math3.distribution;

import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.CombinatoricsUtils;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.ResizableDoubleArray;

/* JADX INFO: loaded from: classes6.dex */
public class ExponentialDistribution extends AbstractRealDistribution {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9d;
    private static final double[] EXPONENTIAL_SA_QI = null;
    private static final long serialVersionUID = 2401296428283614780L;
    private final double logMean;
    private final double mean;
    private final double solverAbsoluteAccuracy;

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportLowerBound() {
        return 0.0d;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportUpperBound() {
        return Double.POSITIVE_INFINITY;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public boolean isSupportConnected() {
        return true;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public boolean isSupportLowerBoundInclusive() {
        return true;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public boolean isSupportUpperBoundInclusive() {
        return false;
    }

    static {
        double r0 = FastMath.log(2.0d);
        ResizableDoubleArray r2 = new ResizableDoubleArray(20);
        double r3 = 0.0d;
        int r6 = 1;
    L4:
        if (r3 >= 1.0d) goto L6;
        r3 = r3 + (FastMath.pow(r0, r6) / CombinatoricsUtils.factorial(r6));
        r2.addElement(r3);
        r6 = r6 + 1;
        goto L4
    L6:
        EXPONENTIAL_SA_QI = r2.getElements();
    }

    public ExponentialDistribution(double r3) {
        this(r3, 1.0E-9d);
    }

    public ExponentialDistribution(double r7, double r9) {
        this(new Well19937c(), r7, r9);
    }

    public ExponentialDistribution(RandomGenerator r7, double r8) throws NotStrictlyPositiveException {
        this(r7, r8, 1.0E-9d);
    }

    public ExponentialDistribution(RandomGenerator r3, double r4, double r6) throws NotStrictlyPositiveException {
        super(r3);
        if (r4 <= 0.0d) goto L7;
        this.mean = r4;
        this.logMean = FastMath.log(r4);
        this.solverAbsoluteAccuracy = r6;
        return;
    L7:
        throw new NotStrictlyPositiveException(LocalizedFormats.MEAN, Double.valueOf(r4));
    }

    public double getMean() {
        return this.mean;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double density(double r3) {
        double r2 = logDensity(r3);
        if (r2 != Double.NEGATIVE_INFINITY) goto L6;
        return 0.0d;
    L6:
        return FastMath.exp(r2);
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    public double logDensity(double r3) {
        if (r3 >= 0.0d) goto L7;
        return Double.NEGATIVE_INFINITY;
    L7:
        return ((-r3) / this.mean) - this.logMean;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double cumulativeProbability(double r4) {
        if (r4 > 0.0d) goto L6;
        return 0.0d;
    L6:
        return 1.0d - FastMath.exp((-r4) / this.mean);
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    public double inverseCumulativeProbability(double r6) throws OutOfRangeException {
        if (r6 < 0.0d) goto L11;
        if (r6 > 1.0d) goto L11;
        if (r6 != 1.0d) goto L8;
        return Double.POSITIVE_INFINITY;
    L8:
        double r0 = -this.mean;
        return FastMath.log(1.0d - r6) * r0;
    L11:
        throw new OutOfRangeException(Double.valueOf(r6), Double.valueOf(0.0d), Double.valueOf(1.0d));
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    public double sample() {
        double r0 = this.random.nextDouble();
        double r2 = 0.0d;
    L4:
        if (r0 >= 0.5d) goto L6;
        r2 = r2 + EXPONENTIAL_SA_QI[0];
        r0 = r0 * 2.0d;
        goto L4
    L6:
        double r1 = r0 + (r0 - 1.0d);
        if (r1 <= EXPONENTIAL_SA_QI[0]) goto L9;
        double r6 = this.random.nextDouble();
        int r4 = 0;
    L11:
        r4 = r4 + 1;
        double r8 = this.random.nextDouble();
        if (r8 >= r6) goto L14;
        r6 = r8;
    L14:
        double[] r9 = EXPONENTIAL_SA_QI;
        if (r1 > r9[r4]) goto L11;
        return this.mean * (r2 + (r6 * r9[0]));
    L9:
        return this.mean * (r2 + r1);
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    protected double getSolverAbsoluteAccuracy() {
        return this.solverAbsoluteAccuracy;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalMean() {
        return getMean();
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalVariance() {
        double r0 = getMean();
        return r0 * r0;
    }
}
