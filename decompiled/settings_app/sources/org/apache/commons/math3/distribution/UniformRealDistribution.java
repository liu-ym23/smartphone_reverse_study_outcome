package org.apache.commons.math3.distribution;

import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;

/* JADX INFO: loaded from: classes6.dex */
public class UniformRealDistribution extends AbstractRealDistribution {

    @Deprecated
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9d;
    private static final long serialVersionUID = 20120109;
    private final double lower;
    private final double upper;

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
        return true;
    }

    public UniformRealDistribution() {
        this(0.0d, 1.0d);
    }

    public UniformRealDistribution(double r7, double r9) throws NumberIsTooLargeException {
        this(new Well19937c(), r7, r9);
    }

    @Deprecated
    public UniformRealDistribution(double r7, double r9, double r11) throws NumberIsTooLargeException {
        this(new Well19937c(), r7, r9);
    }

    @Deprecated
    public UniformRealDistribution(RandomGenerator r1, double r2, double r4, double r6) {
        this(r1, r2, r4);
    }

    public UniformRealDistribution(RandomGenerator r1, double r2, double r4) throws NumberIsTooLargeException {
        super(r1);
        if (r2 >= r4) goto L7;
        this.lower = r2;
        this.upper = r4;
        return;
    L7:
        throw new NumberIsTooLargeException(LocalizedFormats.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, Double.valueOf(r2), Double.valueOf(r4), false);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double density(double r5) {
        double r0 = this.lower;
        if (r5 < r0) goto L9;
        double r2 = this.upper;
        if (r5 <= r2) goto L8;
        return 0.0d;
    L8:
        return 1.0d / (r2 - r0);
    L9:
        return 0.0d;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double cumulativeProbability(double r5) {
        double r0 = this.lower;
        if (r5 > r0) goto L6;
        return 0.0d;
    L6:
        double r2 = this.upper;
        if (r5 < r2) goto L11;
        return 1.0d;
    L11:
        return (r5 - r0) / (r2 - r0);
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    public double inverseCumulativeProbability(double r5) throws OutOfRangeException {
        if (r5 < 0.0d) goto L9;
        if (r5 > 1.0d) goto L9;
        double r0 = this.upper;
        double r2 = this.lower;
        return (r5 * (r0 - r2)) + r2;
    L9:
        throw new OutOfRangeException(Double.valueOf(r5), 0, 1);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalMean() {
        return (this.lower + this.upper) * 0.5d;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalVariance() {
        double r0 = this.upper - this.lower;
        return (r0 * r0) / 12.0d;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportLowerBound() {
        return this.lower;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportUpperBound() {
        return this.upper;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    public double sample() {
        double r0 = this.random.nextDouble();
        return (this.upper * r0) + ((1.0d - r0) * this.lower);
    }
}
