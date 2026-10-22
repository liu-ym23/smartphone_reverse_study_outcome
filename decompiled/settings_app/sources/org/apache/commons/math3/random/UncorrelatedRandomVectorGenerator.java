package org.apache.commons.math3.random;

import java.util.Arrays;
import org.apache.commons.math3.exception.DimensionMismatchException;

/* JADX INFO: loaded from: classes6.dex */
public class UncorrelatedRandomVectorGenerator implements RandomVectorGenerator {
    private final NormalizedRandomGenerator generator;
    private final double[] mean;
    private final double[] standardDeviation;

    public UncorrelatedRandomVectorGenerator(double[] r3, double[] r4, NormalizedRandomGenerator r5) {
        if (r3.length != r4.length) goto L7;
        this.mean = (double[]) r3.clone();
        this.standardDeviation = (double[]) r4.clone();
        this.generator = r5;
        return;
    L7:
        throw new DimensionMismatchException(r3.length, r4.length);
    }

    public UncorrelatedRandomVectorGenerator(int r3, NormalizedRandomGenerator r4) {
        this.mean = new double[r3];
        double[] r5 = new double[r3];
        this.standardDeviation = r5;
        Arrays.fill(r5, 1.0d);
        this.generator = r4;
    }

    @Override // org.apache.commons.math3.random.RandomVectorGenerator
    public double[] nextVector() {
        int r0 = this.mean.length;
        double[] r1 = new double[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = this.mean[r2] + (this.standardDeviation[r2] * this.generator.nextNormalizedDouble());
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }
}
