package org.apache.commons.math3.distribution;

import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class GumbelDistribution extends AbstractRealDistribution {
    private static final double EULER = 0.5778636748954609d;
    private static final long serialVersionUID = 20141003;
    private final double beta;
    private final double mu;

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportLowerBound() {
        return Double.NEGATIVE_INFINITY;
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
        return false;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public boolean isSupportUpperBoundInclusive() {
        return false;
    }

    public GumbelDistribution(double r7, double r9) {
        this(new Well19937c(), r7, r9);
    }

    public GumbelDistribution(RandomGenerator r3, double r4, double r6) {
        super(r3);
        if (r6 <= 0.0d) goto L7;
        this.beta = r6;
        this.mu = r4;
        return;
    L7:
        throw new NotStrictlyPositiveException(LocalizedFormats.SCALE, Double.valueOf(r6));
    }

    public double getLocation() {
        return this.mu;
    }

    public double getScale() {
        return this.beta;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double density(double r3) {
        double r4 = -((r3 - this.mu) / this.beta);
        return FastMath.exp(r4 - FastMath.exp(r4)) / this.beta;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double cumulativeProbability(double r3) {
        return FastMath.exp(-FastMath.exp(-((r3 - this.mu) / this.beta)));
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    public double inverseCumulativeProbability(double r6) throws OutOfRangeException {
        if (r6 < 0.0d) goto L16;
        if (r6 > 1.0d) goto L16;
        if (r6 != 0.0d) goto L10;
        return Double.NEGATIVE_INFINITY;
    L10:
        if (r6 != 1.0d) goto L14;
        return Double.POSITIVE_INFINITY;
    L14:
        return this.mu - (FastMath.log(-FastMath.log(r6)) * this.beta);
    L16:
        throw new OutOfRangeException(Double.valueOf(r6), Double.valueOf(0.0d), Double.valueOf(1.0d));
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalMean() {
        return this.mu + (this.beta * EULER);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalVariance() {
        double r0 = this.beta;
        return (r0 * r0) * 1.6449340668482264d;
    }
}
