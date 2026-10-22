package org.apache.commons.math3.distribution;

import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.special.Gamma;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class WeibullDistribution extends AbstractRealDistribution {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9d;
    private static final long serialVersionUID = 8589540077390120676L;
    private double numericalMean;
    private boolean numericalMeanIsCalculated;
    private double numericalVariance;
    private boolean numericalVarianceIsCalculated;
    private final double scale;
    private final double shape;
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

    public WeibullDistribution(double r8, double r10) throws NotStrictlyPositiveException {
        this(r8, r10, 1.0E-9d);
    }

    public WeibullDistribution(double r9, double r11, double r13) {
        this(new Well19937c(), r9, r11, r13);
    }

    public WeibullDistribution(RandomGenerator r9, double r10, double r12) throws NotStrictlyPositiveException {
        this(r9, r10, r12, 1.0E-9d);
    }

    public WeibullDistribution(RandomGenerator r3, double r4, double r6, double r8) throws NotStrictlyPositiveException {
        super(r3);
        this.numericalMean = Double.NaN;
        this.numericalMeanIsCalculated = false;
        this.numericalVariance = Double.NaN;
        this.numericalVarianceIsCalculated = false;
        if (r4 <= 0.0d) goto L11;
        if (r6 <= 0.0d) goto L9;
        this.scale = r6;
        this.shape = r4;
        this.solverAbsoluteAccuracy = r8;
        return;
    L9:
        throw new NotStrictlyPositiveException(LocalizedFormats.SCALE, Double.valueOf(r6));
    L11:
        throw new NotStrictlyPositiveException(LocalizedFormats.SHAPE, Double.valueOf(r4));
    }

    public double getShape() {
        return this.shape;
    }

    public double getScale() {
        return this.scale;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double density(double r7) {
        if (r7 >= 0.0d) goto L5;
        return 0.0d;
    L5:
        double r8 = r7 / this.scale;
        double r0 = FastMath.pow(r8, this.shape - 1.0d);
        return ((this.shape / this.scale) * r0) * FastMath.exp(-(r8 * r0));
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    public double logDensity(double r7) {
        if (r7 >= 0.0d) goto L6;
        return Double.NEGATIVE_INFINITY;
    L6:
        double r8 = r7 / this.scale;
        double r0 = FastMath.log(r8) * (this.shape - 1.0d);
        double r2 = FastMath.exp(r0) * r8;
        return (FastMath.log(this.shape / this.scale) + r0) - r2;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double cumulativeProbability(double r4) {
        if (r4 > 0.0d) goto L6;
        return 0.0d;
    L6:
        return 1.0d - FastMath.exp(-FastMath.pow(r4 / this.scale, this.shape));
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    public double inverseCumulativeProbability(double r8) {
        if (r8 < 0.0d) goto L14;
        if (r8 > 1.0d) goto L14;
        if (r8 == 0.0d) goto L16;
        if (r8 != 1.0d) goto L12;
        return Double.POSITIVE_INFINITY;
    L12:
        return this.scale * FastMath.pow(-FastMath.log1p(-r8), 1.0d / this.shape);
    L16:
        return 0.0d;
    L14:
        throw new OutOfRangeException(Double.valueOf(r8), Double.valueOf(0.0d), Double.valueOf(1.0d));
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    protected double getSolverAbsoluteAccuracy() {
        return this.solverAbsoluteAccuracy;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalMean() {
        if (this.numericalMeanIsCalculated == true) goto L6;
        this.numericalMean = calculateNumericalMean();
        this.numericalMeanIsCalculated = true;
    L6:
        return this.numericalMean;
    }

    protected double calculateNumericalMean() {
        double r0 = getShape();
        return getScale() * FastMath.exp(Gamma.logGamma((1.0d / r0) + 1.0d));
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
        double r0 = getShape();
        double r2 = getScale();
        double r4 = getNumericalMean();
        return ((r2 * r2) * FastMath.exp(Gamma.logGamma((2.0d / r0) + 1.0d))) - (r4 * r4);
    }
}
