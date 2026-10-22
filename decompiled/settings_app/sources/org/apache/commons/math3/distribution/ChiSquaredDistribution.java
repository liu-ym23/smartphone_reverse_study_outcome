package org.apache.commons.math3.distribution;

import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;

/* JADX INFO: loaded from: classes6.dex */
public class ChiSquaredDistribution extends AbstractRealDistribution {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9d;
    private static final long serialVersionUID = -8352658048349159782L;
    private final GammaDistribution gamma;
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

    public ChiSquaredDistribution(double r3) {
        this(r3, 1.0E-9d);
    }

    public ChiSquaredDistribution(double r7, double r9) {
        this(new Well19937c(), r7, r9);
    }

    public ChiSquaredDistribution(RandomGenerator r7, double r8) {
        this(r7, r8, 1.0E-9d);
    }

    public ChiSquaredDistribution(RandomGenerator r3, double r4, double r6) {
        super(r3);
        this.gamma = new GammaDistribution(r4 / 2.0d, 2.0d);
        this.solverAbsoluteAccuracy = r6;
    }

    public double getDegreesOfFreedom() {
        return this.gamma.getShape() * 2.0d;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double density(double r1) {
        return this.gamma.density(r1);
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    public double logDensity(double r1) {
        return this.gamma.logDensity(r1);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double cumulativeProbability(double r1) {
        return this.gamma.cumulativeProbability(r1);
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    protected double getSolverAbsoluteAccuracy() {
        return this.solverAbsoluteAccuracy;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalMean() {
        return getDegreesOfFreedom();
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalVariance() {
        return getDegreesOfFreedom() * 2.0d;
    }
}
