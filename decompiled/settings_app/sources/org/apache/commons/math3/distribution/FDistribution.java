package org.apache.commons.math3.distribution;

import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.special.Beta;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class FDistribution extends AbstractRealDistribution {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9d;
    private static final long serialVersionUID = -8516354193418641566L;
    private final double denominatorDegreesOfFreedom;
    private final double numeratorDegreesOfFreedom;
    private double numericalVariance;
    private boolean numericalVarianceIsCalculated;
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
        return false;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public boolean isSupportUpperBoundInclusive() {
        return false;
    }

    public FDistribution(double r8, double r10) throws NotStrictlyPositiveException {
        this(r8, r10, 1.0E-9d);
    }

    public FDistribution(double r9, double r11, double r13) throws NotStrictlyPositiveException {
        this(new Well19937c(), r9, r11, r13);
    }

    public FDistribution(RandomGenerator r9, double r10, double r12) throws NotStrictlyPositiveException {
        this(r9, r10, r12, 1.0E-9d);
    }

    public FDistribution(RandomGenerator r3, double r4, double r6, double r8) throws NotStrictlyPositiveException {
        super(r3);
        this.numericalVariance = Double.NaN;
        this.numericalVarianceIsCalculated = false;
        if (r4 <= 0.0d) goto L11;
        if (r6 <= 0.0d) goto L9;
        this.numeratorDegreesOfFreedom = r4;
        this.denominatorDegreesOfFreedom = r6;
        this.solverAbsoluteAccuracy = r8;
        return;
    L9:
        throw new NotStrictlyPositiveException(LocalizedFormats.DEGREES_OF_FREEDOM, Double.valueOf(r6));
    L11:
        throw new NotStrictlyPositiveException(LocalizedFormats.DEGREES_OF_FREEDOM, Double.valueOf(r4));
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double density(double r1) {
        return FastMath.exp(logDensity(r1));
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    public double logDensity(double r13) {
        double r0 = this.numeratorDegreesOfFreedom / 2.0d;
        double r4 = this.denominatorDegreesOfFreedom / 2.0d;
        double r2 = FastMath.log(r13);
        double r6 = FastMath.log(this.numeratorDegreesOfFreedom);
        double r8 = FastMath.log(this.denominatorDegreesOfFreedom);
        double r12 = FastMath.log((this.numeratorDegreesOfFreedom * r13) + this.denominatorDegreesOfFreedom);
        return ((((((r6 * r0) + (r0 * r2)) - r2) + (r8 * r4)) - (r0 * r12)) - (r12 * r4)) - Beta.logBeta(r0, r4);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double cumulativeProbability(double r13) {
        if (r13 <= 0.0d) goto L7;
        double r0 = this.numeratorDegreesOfFreedom;
        double r2 = this.denominatorDegreesOfFreedom;
        double r14 = r13 * r0;
        return Beta.regularizedBeta(r14 / (r2 + r14), r0 * 0.5d, r2 * 0.5d);
    L7:
        return 0.0d;
    }

    public double getNumeratorDegreesOfFreedom() {
        return this.numeratorDegreesOfFreedom;
    }

    public double getDenominatorDegreesOfFreedom() {
        return this.denominatorDegreesOfFreedom;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    protected double getSolverAbsoluteAccuracy() {
        return this.solverAbsoluteAccuracy;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalMean() {
        double r0 = getDenominatorDegreesOfFreedom();
        if (r0 > 2.0d) goto L5;
        return Double.NaN;
    L5:
        return r0 / (r0 - 2.0d);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalVariance() {
        if (this.numericalVarianceIsCalculated == true) goto L6;
        this.numericalVariance = calculateNumericalVariance();
        this.numericalVarianceIsCalculated = true;
    L6:
        return this.numericalVariance;
    }

    protected double calculateNumericalVariance() {
        double r0 = getDenominatorDegreesOfFreedom();
        if (r0 <= 4.0d) goto L6;
        double r4 = getNumeratorDegreesOfFreedom();
        double r8 = r0 - 2.0d;
        return (((r0 * r0) * 2.0d) * ((r4 + r0) - 2.0d)) / ((r4 * (r8 * r8)) * (r0 - 4.0d));
    L6:
        return Double.NaN;
    }
}
