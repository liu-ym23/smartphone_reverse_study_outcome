package org.apache.commons.math3.distribution;

import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.special.Erf;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class LevyDistribution extends AbstractRealDistribution {
    private static final long serialVersionUID = 20130314;
    private final double c;
    private final double halfC;
    private final double mu;

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalMean() {
        return Double.POSITIVE_INFINITY;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalVariance() {
        return Double.POSITIVE_INFINITY;
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

    public LevyDistribution(double r7, double r9) {
        this(new Well19937c(), r7, r9);
    }

    public LevyDistribution(RandomGenerator r1, double r2, double r4) {
        super(r1);
        this.mu = r2;
        this.c = r4;
        this.halfC = r4 * 0.5d;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double density(double r5) {
        double r0 = this.mu;
        if (r5 >= r0) goto L6;
        return Double.NaN;
    L6:
        double r6 = r5 - r0;
        double r1 = this.halfC / r6;
        return (FastMath.sqrt(r1 / 3.141592653589793d) * FastMath.exp(-r1)) / r6;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    public double logDensity(double r7) {
        double r0 = this.mu;
        if (r7 >= r0) goto L6;
        return Double.NaN;
    L6:
        double r8 = r7 - r0;
        double r1 = this.halfC / r8;
        return ((FastMath.log(r1 / 3.141592653589793d) * 0.5d) - r1) - FastMath.log(r8);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double cumulativeProbability(double r5) {
        double r0 = this.mu;
        if (r5 >= r0) goto L7;
        return Double.NaN;
    L7:
        return Erf.erfc(FastMath.sqrt(this.halfC / (r5 - r0)));
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    public double inverseCumulativeProbability(double r5) throws OutOfRangeException {
        if (r5 < 0.0d) goto L9;
        if (r5 > 1.0d) goto L9;
        double r6 = Erf.erfcInv(r5);
        return this.mu + (this.halfC / (r6 * r6));
    L9:
        throw new OutOfRangeException(Double.valueOf(r5), 0, 1);
    }

    public double getScale() {
        return this.c;
    }

    public double getLocation() {
        return this.mu;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportLowerBound() {
        return this.mu;
    }
}
