package org.apache.commons.math3.distribution;

import java.lang.reflect.Array;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractMultivariateRealDistribution implements MultivariateRealDistribution {
    private final int dimension;
    protected final RandomGenerator random;

    @Override // org.apache.commons.math3.distribution.MultivariateRealDistribution
    public abstract double[] sample();

    protected AbstractMultivariateRealDistribution(RandomGenerator r1, int r2) {
        this.random = r1;
        this.dimension = r2;
    }

    @Override // org.apache.commons.math3.distribution.MultivariateRealDistribution
    public void reseedRandomGenerator(long r1) {
        this.random.setSeed(r1);
    }

    @Override // org.apache.commons.math3.distribution.MultivariateRealDistribution
    public int getDimension() {
        return this.dimension;
    }

    @Override // org.apache.commons.math3.distribution.MultivariateRealDistribution
    public double[][] sample(int r4) {
        if (r4 <= 0) goto L8;
        int r0 = 0;
        double[][] r1 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r4, this.dimension});
    L4:
        if (r0 >= r4) goto L6;
        r1[r0] = sample();
        r0 = r0 + 1;
        goto L4
    L6:
        return r1;
    L8:
        throw new NotStrictlyPositiveException(LocalizedFormats.NUMBER_OF_SAMPLES, Integer.valueOf(r4));
    }
}
