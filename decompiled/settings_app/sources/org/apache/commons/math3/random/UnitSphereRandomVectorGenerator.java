package org.apache.commons.math3.random;

import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class UnitSphereRandomVectorGenerator implements RandomVectorGenerator {
    private final int dimension;
    private final RandomGenerator rand;

    public UnitSphereRandomVectorGenerator(int r1, RandomGenerator r2) {
        this.dimension = r1;
        this.rand = r2;
    }

    public UnitSphereRandomVectorGenerator(int r2) {
        this(r2, new MersenneTwister());
    }

    @Override // org.apache.commons.math3.random.RandomVectorGenerator
    public double[] nextVector() {
        double[] r0 = new double[this.dimension];
        double r1 = 0.0d;
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r4 >= this.dimension) goto L6;
        double r5 = this.rand.nextGaussian();
        r0[r4] = r5;
        r1 = r1 + (r5 * r5);
        r4 = r4 + 1;
        goto L4
    L6:
        double r6 = 1.0d / FastMath.sqrt(r1);
    L8:
        if (r3 >= this.dimension) goto L10;
        r0[r3] = r0[r3] * r6;
        r3 = r3 + 1;
        goto L8
    L10:
        return r0;
    }
}
