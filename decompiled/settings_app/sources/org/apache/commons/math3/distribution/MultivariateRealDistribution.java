package org.apache.commons.math3.distribution;

import org.apache.commons.math3.exception.NotStrictlyPositiveException;

/* JADX INFO: loaded from: classes6.dex */
public interface MultivariateRealDistribution {
    double density(double[] r1);

    int getDimension();

    void reseedRandomGenerator(long r1);

    double[] sample();

    double[][] sample(int r1) throws NotStrictlyPositiveException;
}
