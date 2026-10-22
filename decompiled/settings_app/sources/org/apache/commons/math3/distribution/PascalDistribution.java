package org.apache.commons.math3.distribution;

import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.special.Beta;
import org.apache.commons.math3.util.CombinatoricsUtils;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class PascalDistribution extends AbstractIntegerDistribution {
    private static final long serialVersionUID = 6751309484392813623L;
    private final double log1mProbabilityOfSuccess;
    private final double logProbabilityOfSuccess;
    private final int numberOfSuccesses;
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

    public PascalDistribution(int r2, double r3) throws NotStrictlyPositiveException, OutOfRangeException {
        this(new Well19937c(), r2, r3);
    }

    public PascalDistribution(RandomGenerator r3, int r4, double r5) throws NotStrictlyPositiveException, OutOfRangeException {
        super(r3);
        if (r4 <= 0) goto L13;
        if (r5 < 0.0d) goto L11;
        if (r5 > 1.0d) goto L11;
        this.numberOfSuccesses = r4;
        this.probabilityOfSuccess = r5;
        this.logProbabilityOfSuccess = FastMath.log(r5);
        this.log1mProbabilityOfSuccess = FastMath.log1p(-r5);
        return;
    L11:
        throw new OutOfRangeException(Double.valueOf(r5), 0, 1);
    L13:
        throw new NotStrictlyPositiveException(LocalizedFormats.NUMBER_OF_SUCCESSES, Integer.valueOf(r4));
    }

    public int getNumberOfSuccesses() {
        return this.numberOfSuccesses;
    }

    public double getProbabilityOfSuccess() {
        return this.probabilityOfSuccess;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double probability(int r7) {
        if (r7 >= 0) goto L4;
        return 0.0d;
    L4:
        int r0 = this.numberOfSuccesses;
        return FastMath.pow(1.0d - this.probabilityOfSuccess, r7) * (CombinatoricsUtils.binomialCoefficientDouble((r7 + r0) - 1, r0 - 1) * FastMath.pow(this.probabilityOfSuccess, this.numberOfSuccesses));
    }

    @Override // org.apache.commons.math3.distribution.AbstractIntegerDistribution
    public double logProbability(int r7) {
        if (r7 >= 0) goto L4;
        return Double.NEGATIVE_INFINITY;
    L4:
        int r0 = this.numberOfSuccesses;
        return (CombinatoricsUtils.binomialCoefficientLog((r7 + r0) - 1, r0 - 1) + (this.logProbabilityOfSuccess * ((double) this.numberOfSuccesses))) + (this.log1mProbabilityOfSuccess * ((double) r7));
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double cumulativeProbability(int r7) {
        if (r7 >= 0) goto L5;
        return 0.0d;
    L5:
        return Beta.regularizedBeta(this.probabilityOfSuccess, this.numberOfSuccesses, 1.0d + ((double) r7));
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double getNumericalMean() {
        double r0 = getProbabilityOfSuccess();
        return (((double) getNumberOfSuccesses()) * (1.0d - r0)) / r0;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double getNumericalVariance() {
        double r0 = getProbabilityOfSuccess();
        return (((double) getNumberOfSuccesses()) * (1.0d - r0)) / (r0 * r0);
    }
}
