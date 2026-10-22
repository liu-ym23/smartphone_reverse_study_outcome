package org.apache.commons.math3.distribution;

import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.OutOfRangeException;

/* JADX INFO: loaded from: classes6.dex */
public interface RealDistribution {
    double cumulativeProbability(double r1);

    @Deprecated
    double cumulativeProbability(double r1, double r3) throws NumberIsTooLargeException;

    double density(double r1);

    double getNumericalMean();

    double getNumericalVariance();

    double getSupportLowerBound();

    double getSupportUpperBound();

    double inverseCumulativeProbability(double r1) throws OutOfRangeException;

    boolean isSupportConnected();

    @Deprecated
    boolean isSupportLowerBoundInclusive();

    @Deprecated
    boolean isSupportUpperBoundInclusive();

    double probability(double r1);

    void reseedRandomGenerator(long r1);

    double sample();

    double[] sample(int r1);
}
