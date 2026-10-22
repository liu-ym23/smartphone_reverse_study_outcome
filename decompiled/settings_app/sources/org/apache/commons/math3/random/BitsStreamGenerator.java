package org.apache.commons.math3.random;

import java.io.Serializable;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public abstract class BitsStreamGenerator implements RandomGenerator, Serializable {
    private static final long serialVersionUID = 20130104;
    private double nextGaussian;

    protected abstract int next(int r1);

    @Override // org.apache.commons.math3.random.RandomGenerator
    public abstract void setSeed(int r1);

    @Override // org.apache.commons.math3.random.RandomGenerator
    public abstract void setSeed(long r1);

    @Override // org.apache.commons.math3.random.RandomGenerator
    public abstract void setSeed(int[] r1);

    public BitsStreamGenerator() {
        this.nextGaussian = Double.NaN;
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public boolean nextBoolean() {
        if (next(1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public double nextDouble() {
        return ((((long) next(26)) << 26) | ((long) next(26))) * 2.220446049250313E-16d;
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public float nextFloat() {
        return next(23) * 1.1920929E-7f;
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public double nextGaussian() {
        if (Double.isNaN(this.nextGaussian) == false) goto L5;
        double r0 = nextDouble();
        double r1 = r0 * 6.283185307179586d;
        double r2 = FastMath.sqrt(FastMath.log(nextDouble()) * (-2.0d));
        double r4 = FastMath.cos(r1) * r2;
        this.nextGaussian = r2 * FastMath.sin(r1);
        return r4;
    L5:
        double r5 = this.nextGaussian;
        this.nextGaussian = Double.NaN;
        return r5;
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public int nextInt() {
        return next(32);
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public int nextInt(int r5) throws IllegalArgumentException {
        if (r5 <= 0) goto L11;
        if (((-r5) & r5) == r5) goto L6;
    L7:
        int r0 = next(31);
        int r2 = r0 % r5;
        if (((r0 - r2) + (r5 - 1)) < 0) goto L7;
        return r2;
    L6:
        return (int) ((((long) r5) * ((long) next(31))) >> 31);
    L11:
        throw new NotStrictlyPositiveException(Integer.valueOf(r5));
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public long nextLong() {
        return (((long) next(32)) << 32) | (((long) next(32)) & 4294967295L);
    }

    public long nextLong(long r9) throws IllegalArgumentException {
        if (r9 <= 0) goto L8;
    L4:
        long r2 = (((long) next(31)) << 32) | (((long) next(32)) & 4294967295L);
        long r4 = r2 % r9;
        if (((r2 - r4) + (r9 - 1)) < 0) goto L4;
        return r4;
    L8:
        throw new NotStrictlyPositiveException(Long.valueOf(r9));
    }

    public void clear() {
        this.nextGaussian = Double.NaN;
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public void nextBytes(byte[] r3) {
        nextBytesFill(r3, 0, r3.length);
    }

    public void nextBytes(byte[] r3, int r4, int r5) {
        if (r4 < 0) goto L14;
        if (r4 >= r3.length) goto L14;
        if (r5 < 0) goto L12;
        if (r5 > (r3.length - r4)) goto L12;
        nextBytesFill(r3, r4, r5);
        return;
    L12:
        throw new OutOfRangeException(Integer.valueOf(r5), 0, Integer.valueOf(r3.length - r4));
    L14:
        throw new OutOfRangeException(Integer.valueOf(r4), 0, Integer.valueOf(r3.length));
    }

    private void nextBytesFill(byte[] r6, int r7, int r8) {
        int r0 = (2147483644 & r8) + r7;
        int r1 = r7;
    L4:
        if (r1 >= r0) goto L6;
        int r2 = next(32);
        int r3 = r1 + 1;
        r6[r1] = (byte) r2;
        int r4 = r3 + 1;
        r6[r3] = (byte) (r2 >>> 8);
        int r5 = r4 + 1;
        r6[r4] = (byte) (r2 >>> 16);
        r1 = r5 + 1;
        r6[r5] = (byte) (r2 >>> 24);
        goto L4
    L6:
        int r9 = r7 + r8;
        if (r1 >= r9) goto L12;
        int r10 = next(32);
    L9:
        int r11 = r1 + 1;
        r6[r1] = (byte) r10;
        if (r11 >= r9) goto L15;
        r10 = r10 >>> 8;
        r1 = r11;
        goto L9
    L15:
        return;
    }
}
