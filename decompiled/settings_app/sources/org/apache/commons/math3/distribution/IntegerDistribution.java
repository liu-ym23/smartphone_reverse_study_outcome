package org.apache.commons.math3.distribution;

import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.OutOfRangeException;

/* JADX INFO: loaded from: classes6.dex */
public interface IntegerDistribution {
    double cumulativeProbability(int r1);

    double cumulativeProbability(int r1, int r2) throws NumberIsTooLargeException;

    double getNumericalMean();

    double getNumericalVariance();

    int getSupportLowerBound();

    int getSupportUpperBound();

    int inverseCumulativeProbability(double r1) throws OutOfRangeException;

    boolean isSupportConnected();

    double probability(int r1);

    void reseedRandomGenerator(long r1);

    int sample();

    int[] sample(int r1);
}
