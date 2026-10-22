package org.apache.commons.math3.distribution;

import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.special.Beta;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class BinomialDistribution extends AbstractIntegerDistribution {
    private static final long serialVersionUID = 6751309484392813623L;
    private final int numberOfTrials;
    private final double probabilityOfSuccess;

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public boolean isSupportConnected() {
        return true;
    }

    public BinomialDistribution(int r2, double r3) {
        this(new Well19937c(), r2, r3);
    }

    public BinomialDistribution(RandomGenerator r3, int r4, double r5) {
        super(r3);
        if (r4 < 0) goto L13;
        if (r5 < 0.0d) goto L11;
        if (r5 > 1.0d) goto L11;
        this.probabilityOfSuccess = r5;
        this.numberOfTrials = r4;
        return;
    L11:
        throw new OutOfRangeException(Double.valueOf(r5), 0, 1);
    L13:
        throw new NotPositiveException(LocalizedFormats.NUMBER_OF_TRIALS, Integer.valueOf(r4));
    }

    public int getNumberOfTrials() {
        return this.numberOfTrials;
    }

    public double getProbabilityOfSuccess() {
        return this.probabilityOfSuccess;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double probability(int r3) {
        double r2 = logProbability(r3);
        if (r2 != Double.NEGATIVE_INFINITY) goto L6;
        return 0.0d;
    L6:
        return FastMath.exp(r2);
    }

    @Override // org.apache.commons.math3.distribution.AbstractIntegerDistribution
    public double logProbability(int r7) {
        int r1 = this.numberOfTrials;
        if (r1 != 0) goto L7;
        if (r7 != 0) goto L12;
        return 0.0d;
    L12:
        return Double.NEGATIVE_INFINITY;
    L7:
        if (r7 < 0) goto L13;
        if (r7 > r1) goto L14;
        double r2 = this.probabilityOfSuccess;
        return SaddlePointExpansion.logBinomialProbability(r7, r1, r2, 1.0d - r2);
    L14:
        return Double.NEGATIVE_INFINITY;
    L13:
        return Double.NEGATIVE_INFINITY;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double cumulativeProbability(int r10) {
        if (r10 >= 0) goto L4;
        return 0.0d;
    L4:
        int r0 = this.numberOfTrials;
        if (r10 < r0) goto L8;
        return 1.0d;
    L8:
        return 1.0d - Beta.regularizedBeta(this.probabilityOfSuccess, ((double) r10) + 1.0d, r0 - r10);
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double getNumericalMean() {
        return ((double) this.numberOfTrials) * this.probabilityOfSuccess;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double getNumericalVariance() {
        double r0 = this.probabilityOfSuccess;
        return (((double) this.numberOfTrials) * r0) * (1.0d - r0);
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public int getSupportLowerBound() {
        if (this.probabilityOfSuccess >= 1.0d) goto L6;
        return 0;
    L6:
        return this.numberOfTrials;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public int getSupportUpperBound() {
        if (this.probabilityOfSuccess > 0.0d) goto L7;
        return 0;
    L7:
        return this.numberOfTrials;
    }
}
