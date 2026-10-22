package org.apache.commons.math3.distribution;

import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class ZipfDistribution extends AbstractIntegerDistribution {
    private static final long serialVersionUID = -140627372283420404L;
    private final double exponent;
    private final int numberOfElements;
    private double numericalMean;
    private boolean numericalMeanIsCalculated;
    private double numericalVariance;
    private boolean numericalVarianceIsCalculated;
    private transient ZipfRejectionInversionSampler sampler;

    static final class ZipfRejectionInversionSampler {
        private final double exponent;
        private final double hIntegralNumberOfElements;
        private final double hIntegralX1;
        private final int numberOfElements;
        private final double s;

        ZipfRejectionInversionSampler(int r5, double r6) {
            this.exponent = r6;
            this.numberOfElements = r5;
            this.hIntegralX1 = hIntegral(1.5d) - 1.0d;
            this.hIntegralNumberOfElements = hIntegral(((double) r5) + 0.5d);
            this.s = 2.0d - hIntegralInverse(hIntegral(2.5d) - h(2.0d));
        }

        int sample(RandomGenerator r12) {
        L2:
            double r0 = this.hIntegralNumberOfElements + (r12.nextDouble() * (this.hIntegralX1 - this.hIntegralNumberOfElements));
            double r2 = hIntegralInverse(r0);
            int r6 = (int) (r2 + 0.5d);
            int r7 = 1;
            if (r6 >= 1) goto L5;
        L4:
            r6 = r7;
        L8:
            double r8 = r6;
            if ((r8 - r2) <= this.s) goto L12;
            if (r0 < (hIntegral(0.5d + r8) - h(r8))) goto L2;
        L12:
            return r6;
        L5:
            r7 = this.numberOfElements;
            if (r6 <= r7) goto L8;
            goto L8
        }

        private double hIntegral(double r5) {
            double r6 = FastMath.log(r5);
            return helper2((1.0d - this.exponent) * r6) * r6;
        }

        private double h(double r3) {
            return FastMath.exp((-this.exponent) * FastMath.log(r3));
        }

        private double hIntegralInverse(double r5) {
            double r0 = (1.0d - this.exponent) * r5;
            if (r0 >= (-1.0d)) goto L6;
            r0 = -1.0d;
        L6:
            return FastMath.exp(helper1(r0) * r5);
        }

        static double helper1(double r4) {
            if (FastMath.abs(r4) <= 1.0E-8d) goto L7;
            return FastMath.log1p(r4) / r4;
        L7:
            return 1.0d - (r4 * (0.5d - ((0.3333333333333333d - (0.25d * r4)) * r4)));
        }

        static double helper2(double r6) {
            if (FastMath.abs(r6) <= 1.0E-8d) goto L7;
            return FastMath.expm1(r6) / r6;
        L7:
            return ((0.5d * r6) * (((0.3333333333333333d * r6) * ((r6 * 0.25d) + 1.0d)) + 1.0d)) + 1.0d;
        }
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public int getSupportLowerBound() {
        return 1;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public boolean isSupportConnected() {
        return true;
    }

    public ZipfDistribution(int r2, double r3) {
        this(new Well19937c(), r2, r3);
    }

    public ZipfDistribution(RandomGenerator r3, int r4, double r5) throws NotStrictlyPositiveException {
        super(r3);
        this.numericalMean = Double.NaN;
        this.numericalMeanIsCalculated = false;
        this.numericalVariance = Double.NaN;
        this.numericalVarianceIsCalculated = false;
        if (r4 <= 0) goto L11;
        if (r5 <= 0.0d) goto L9;
        this.numberOfElements = r4;
        this.exponent = r5;
        return;
    L9:
        throw new NotStrictlyPositiveException(LocalizedFormats.EXPONENT, Double.valueOf(r5));
    L11:
        throw new NotStrictlyPositiveException(LocalizedFormats.DIMENSION, Integer.valueOf(r4));
    }

    public int getNumberOfElements() {
        return this.numberOfElements;
    }

    public double getExponent() {
        return this.exponent;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double probability(int r5) {
        if (r5 > 0) goto L4;
        return 0.0d;
    L4:
        if (r5 <= this.numberOfElements) goto L7;
        return 0.0d;
    L7:
        return (1.0d / FastMath.pow(r5, this.exponent)) / generalizedHarmonic(this.numberOfElements, this.exponent);
    }

    @Override // org.apache.commons.math3.distribution.AbstractIntegerDistribution
    public double logProbability(int r5) {
        if (r5 > 0) goto L4;
        return Double.NEGATIVE_INFINITY;
    L4:
        if (r5 > this.numberOfElements) goto L10;
        double r0 = -FastMath.log(r5);
        double r2 = this.exponent;
        return (r0 * r2) - FastMath.log(generalizedHarmonic(this.numberOfElements, r2));
    L10:
        return Double.NEGATIVE_INFINITY;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double cumulativeProbability(int r5) {
        if (r5 > 0) goto L6;
        return 0.0d;
    L6:
        if (r5 < this.numberOfElements) goto L10;
        return 1.0d;
    L10:
        return generalizedHarmonic(r5, this.exponent) / generalizedHarmonic(this.numberOfElements, this.exponent);
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double getNumericalMean() {
        if (this.numericalMeanIsCalculated == true) goto L6;
        this.numericalMean = calculateNumericalMean();
        this.numericalMeanIsCalculated = true;
    L6:
        return this.numericalMean;
    }

    protected double calculateNumericalMean() {
        int r0 = getNumberOfElements();
        double r1 = getExponent();
        return generalizedHarmonic(r0, r1 - 1.0d) / generalizedHarmonic(r0, r1);
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double getNumericalVariance() {
        if (this.numericalVarianceIsCalculated == true) goto L6;
        this.numericalVariance = calculateNumericalVariance();
        this.numericalVarianceIsCalculated = true;
    L6:
        return this.numericalVariance;
    }

    protected double calculateNumericalVariance() {
        int r0 = getNumberOfElements();
        double r1 = getExponent();
        double r3 = generalizedHarmonic(r0, r1 - 2.0d);
        double r5 = generalizedHarmonic(r0, r1 - 1.0d);
        double r2 = generalizedHarmonic(r0, r1);
        return (r3 / r2) - ((r5 * r5) / (r2 * r2));
    }

    private double generalizedHarmonic(int r7, double r8) {
        double r0 = 0.0d;
    L3:
        if (r7 <= 0) goto L5;
        r0 = r0 + (1.0d / FastMath.pow(r7, r8));
        r7 = r7 - 1;
        goto L3
    L5:
        return r0;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public int getSupportUpperBound() {
        return getNumberOfElements();
    }

    @Override // org.apache.commons.math3.distribution.AbstractIntegerDistribution, org.apache.commons.math3.distribution.IntegerDistribution
    public int sample() {
        if (this.sampler != null) goto L6;
        this.sampler = new ZipfRejectionInversionSampler(this.numberOfElements, this.exponent);
    L6:
        return this.sampler.sample(this.random);
    }
}
