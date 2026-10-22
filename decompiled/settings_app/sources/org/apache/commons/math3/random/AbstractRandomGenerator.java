package org.apache.commons.math3.random;

import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractRandomGenerator implements RandomGenerator {
    private double cachedNormalDeviate;

    @Override // org.apache.commons.math3.random.RandomGenerator
    public abstract double nextDouble();

    @Override // org.apache.commons.math3.random.RandomGenerator
    public abstract void setSeed(long r1);

    public AbstractRandomGenerator() {
        this.cachedNormalDeviate = Double.NaN;
    }

    public void clear() {
        this.cachedNormalDeviate = Double.NaN;
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public void setSeed(int r3) {
        setSeed(r3);
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public void setSeed(int[] r8) {
        int r0 = r8.length;
        long r1 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1 = (r1 * 4294967291L) + ((long) r8[r3]);
        r3 = r3 + 1;
        goto L3
    L5:
        setSeed(r1);
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public void nextBytes(byte[] r7) {
        int r1 = 0;
    L4:
        if (r1 >= r7.length) goto L14;
        int r2 = nextInt();
        int r3 = 0;
    L7:
        if (r3 >= 3) goto L4;
        if (r3 <= 0) goto L10;
        r2 = r2 >> 8;
    L10:
        int r4 = r1 + 1;
        r7[r1] = (byte) r2;
        if (r4 == r7.length) goto L12;
        r3 = r3 + 1;
        r1 = r4;
        goto L7
    L12:
        return;
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public int nextInt() {
        return (int) (((nextDouble() * 2.0d) - 1.0d) * 2.147483647E9d);
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public int nextInt(int r5) {
        if (r5 <= 0) goto L9;
        int r4 = (int) (nextDouble() * ((double) r5));
        if (r4 >= r5) goto L7;
        return r4;
    L7:
        return r5 - 1;
    L9:
        throw new NotStrictlyPositiveException(Integer.valueOf(r5));
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public long nextLong() {
        return (long) (((nextDouble() * 2.0d) - 1.0d) * 9.223372036854776E18d);
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public boolean nextBoolean() {
        if (nextDouble() > 0.5d) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public float nextFloat() {
        return (float) nextDouble();
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public double nextGaussian() {
        if (Double.isNaN(this.cachedNormalDeviate) == true) goto L6;
        double r0 = this.cachedNormalDeviate;
        this.cachedNormalDeviate = Double.NaN;
        return r0;
    L6:
        double r6 = 0.0d;
        double r8 = 0.0d;
        double r4 = 1.0d;
    L8:
        if (r4 < 1.0d) goto L11;
        double r5 = (nextDouble() * 2.0d) - 1.0d;
        r8 = (nextDouble() * 2.0d) - 1.0d;
        r4 = (r5 * r5) + (r8 * r8);
        r6 = r5;
        goto L8
    L11:
        if (r4 == 0.0d) goto L13;
        r4 = FastMath.sqrt((FastMath.log(r4) * (-2.0d)) / r4);
    L13:
        this.cachedNormalDeviate = r8 * r4;
        return r6 * r4;
    }
}
