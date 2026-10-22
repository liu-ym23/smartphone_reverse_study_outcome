package org.apache.commons.math3.distribution;

import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.special.Beta;
import org.apache.commons.math3.special.Gamma;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class BetaDistribution extends AbstractRealDistribution {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9d;
    private static final long serialVersionUID = -1221965979403477668L;
    private final double alpha;
    private final double beta;
    private final double solverAbsoluteAccuracy;
    private double z;

    private static final class ChengBetaSampler {
        private ChengBetaSampler() {
        }

        static double sample(RandomGenerator r7, double r8, double r10) {
            double r5 = FastMath.min(r8, r10);
            double r11 = FastMath.max(r8, r10);
            if (r5 <= 1.0d) goto L7;
            return algorithmBB(r7, r8, r5, r11);
        L7:
            return algorithmBC(r7, r8, r11, r5);
        }

        private static double algorithmBB(RandomGenerator r20, double r21, double r23, double r25) {
            double r2 = r23 + r25;
            double r4 = FastMath.sqrt((r2 - 2.0d) / (((2.0d * r23) * r25) - r2));
            double r6 = (1.0d / r4) + r23;
        L3:
            double r8 = r20.nextDouble();
            double r10 = r20.nextDouble();
            double r12 = (FastMath.log(r8) - FastMath.log1p(-r8)) * r4;
            double r14 = FastMath.exp(r12) * r23;
            double r9 = (r8 * r8) * r10;
            double r13 = (r12 * r6) - 1.3862944d;
            double r11 = (r23 + r13) - r14;
            if ((r11 + 2.609438d) >= (5.0d * r9)) goto L11;
            double r15 = FastMath.log(r9);
            if (r11 >= r15) goto L11;
            if ((r13 + ((FastMath.log(r2) - FastMath.log(r25 + r14)) * r2)) < r15) goto L3;
        L11:
            double r3 = FastMath.min(r14, Double.MAX_VALUE);
            if (Precision.equals(r23, r21) == false) goto L15;
            return r3 / (r25 + r3);
        L15:
            return r25 / (r25 + r3);
        }

        private static double algorithmBC(RandomGenerator r24, double r25, double r27, double r29) {
            double r2 = r27 + r29;
            double r6 = 1.0d / r29;
            double r4 = (1.0d + r27) - r29;
            double r8 = (((0.0416667d * r29) + 0.0138889d) * r4) / ((r27 * r6) - 0.777778d);
            double r5 = (((0.25d / r4) + 0.5d) * r29) + 0.25d;
        L3:
            double r14 = r24.nextDouble();
            double r16 = r24.nextDouble();
            double r18 = r14 * r16;
            double r20 = r14 * r18;
            if (r14 < 0.5d) goto L6;
            if (r20 <= 0.25d) goto L10;
            if (r20 >= r5) goto L3;
        L14:
            double r17 = (FastMath.log(r14) - FastMath.log1p(-r14)) * r6;
            double r15 = FastMath.exp(r17) * r27;
            if (((((FastMath.log(r2) - FastMath.log(r29 + r15)) + r17) * r2) - 1.3862944d) < FastMath.log(r20)) goto L3;
            double r3 = r15;
        L17:
            double r7 = FastMath.min(r3, Double.MAX_VALUE);
            if (Precision.equals(r27, r25) == false) goto L21;
            return r7 / (r29 + r7);
        L21:
            return r29 / (r29 + r7);
        L10:
            r3 = FastMath.exp(r6 * (FastMath.log(r14) - FastMath.log1p(-r14))) * r27;
            goto L17
        L6:
            if ((((r16 * 0.25d) + r20) - r18) < r8) goto L14;
            goto L14
        }
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportLowerBound() {
        return 0.0d;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportUpperBound() {
        return 1.0d;
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

    public BetaDistribution(double r8, double r10) {
        this(r8, r10, 1.0E-9d);
    }

    public BetaDistribution(double r9, double r11, double r13) {
        this(new Well19937c(), r9, r11, r13);
    }

    public BetaDistribution(RandomGenerator r9, double r10, double r12) {
        this(r9, r10, r12, 1.0E-9d);
    }

    public BetaDistribution(RandomGenerator r1, double r2, double r4, double r6) {
        super(r1);
        this.alpha = r2;
        this.beta = r4;
        this.z = Double.NaN;
        this.solverAbsoluteAccuracy = r6;
    }

    public double getAlpha() {
        return this.alpha;
    }

    public double getBeta() {
        return this.beta;
    }

    private void recomputeZ() {
        if (Double.isNaN(this.z) == false) goto L6;
        this.z = (Gamma.logGamma(this.alpha) + Gamma.logGamma(this.beta)) - Gamma.logGamma(this.alpha + this.beta);
        return;
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
    public double logDensity(double r9) {
        recomputeZ();
        if (r9 >= 0.0d) goto L5;
    L22:
        return Double.NEGATIVE_INFINITY;
    L5:
        if (r9 > 1.0d) goto L22;
        if (r9 == 0.0d) goto L10;
        if (r9 == 1.0d) goto L16;
        double r0 = FastMath.log(r9);
        double r10 = FastMath.log1p(-r9);
        return (((this.alpha - 1.0d) * r0) + ((this.beta - 1.0d) * r10)) - this.z;
    L16:
        if (this.beta < 1.0d) goto L19;
        return Double.NEGATIVE_INFINITY;
    L19:
        throw new NumberIsTooSmallException(LocalizedFormats.CANNOT_COMPUTE_BETA_DENSITY_AT_1_FOR_SOME_BETA, Double.valueOf(this.beta), 1, false);
    L10:
        if (this.alpha < 1.0d) goto L13;
        return Double.NEGATIVE_INFINITY;
    L13:
        throw new NumberIsTooSmallException(LocalizedFormats.CANNOT_COMPUTE_BETA_DENSITY_AT_0_FOR_SOME_ALPHA, Double.valueOf(this.alpha), 1, false);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double cumulativeProbability(double r10) {
        if (r10 > 0.0d) goto L6;
        return 0.0d;
    L6:
        if (r10 < 1.0d) goto L9;
        return 1.0d;
    L9:
        return Beta.regularizedBeta(r10, this.alpha, this.beta);
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    protected double getSolverAbsoluteAccuracy() {
        return this.solverAbsoluteAccuracy;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalMean() {
        double r0 = getAlpha();
        return r0 / (getBeta() + r0);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalVariance() {
        double r0 = getAlpha();
        double r2 = getBeta();
        double r4 = r0 + r2;
        return (r0 * r2) / ((r4 * r4) * (r4 + 1.0d));
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    public double sample() {
        return ChengBetaSampler.sample(this.random, this.alpha, this.beta);
    }
}
