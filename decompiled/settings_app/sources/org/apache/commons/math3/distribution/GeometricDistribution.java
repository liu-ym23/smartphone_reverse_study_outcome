package org.apache.commons.math3.distribution;

import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class GeometricDistribution extends AbstractIntegerDistribution {
    private static final long serialVersionUID = 20130507;
    private final double log1mProbabilityOfSuccess;
    private final double logProbabilityOfSuccess;
    private final double probabilityOfSuccess;

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public int getSupportLowerBound() {
        return 0;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public int getSupportUpperBound() {
        return Integer.MAX_VALUE;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public boolean isSupportConnected() {
        return true;
    }

    public GeometricDistribution(double r2) {
        this(new Well19937c(), r2);
    }

    public GeometricDistribution(RandomGenerator r3, double r4) {
        super(r3);
        if (r4 <= 0.0d) goto L9;
        if (r4 > 1.0d) goto L9;
        this.probabilityOfSuccess = r4;
        this.logProbabilityOfSuccess = FastMath.log(r4);
        this.log1mProbabilityOfSuccess = FastMath.log1p(-r4);
        return;
    L9:
        throw new OutOfRangeException(LocalizedFormats.OUT_OF_RANGE_LEFT, Double.valueOf(r4), 0, 1);
    }

    public double getProbabilityOfSuccess() {
        return this.probabilityOfSuccess;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double probability(int r5) {
        if (r5 >= 0) goto L6;
        return 0.0d;
    L6:
        return FastMath.exp(this.log1mProbabilityOfSuccess * ((double) r5)) * this.probabilityOfSuccess;
    }

    @Override // org.apache.commons.math3.distribution.AbstractIntegerDistribution
    public double logProbability(int r5) {
        if (r5 >= 0) goto L6;
        return Double.NEGATIVE_INFINITY;
    L6:
        return (((double) r5) * this.log1mProbabilityOfSuccess) + this.logProbabilityOfSuccess;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double cumulativeProbability(int r3) {
        if (r3 >= 0) goto L6;
        return 0.0d;
    L6:
        return -FastMath.expm1(this.log1mProbabilityOfSuccess * ((double) (r3 + 1)));
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double getNumericalMean() {
        double r0 = this.probabilityOfSuccess;
        return (1.0d - r0) / r0;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double getNumericalVariance() {
        double r0 = this.probabilityOfSuccess;
        return (1.0d - r0) / (r0 * r0);
    }

    @Override // org.apache.commons.math3.distribution.AbstractIntegerDistribution, org.apache.commons.math3.distribution.IntegerDistribution
    public int inverseCumulativeProbability(double r7) throws OutOfRangeException {
        if (r7 < 0.0d) goto L15;
        if (r7 > 1.0d) goto L15;
        if (r7 != 1.0d) goto L10;
        return Integer.MAX_VALUE;
    L10:
        if (r7 != 0.0d) goto L13;
        return 0;
    L13:
        return Math.max(0, (int) Math.ceil((FastMath.log1p(-r7) / this.log1mProbabilityOfSuccess) - 1.0d));
    L15:
        throw new OutOfRangeException(Double.valueOf(r7), 0, 1);
    }
}
