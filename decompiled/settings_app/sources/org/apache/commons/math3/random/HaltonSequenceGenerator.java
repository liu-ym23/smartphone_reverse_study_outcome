package org.apache.commons.math3.random;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class HaltonSequenceGenerator implements RandomVectorGenerator {
    private static final int[] PRIMES = null;
    private static final int[] WEIGHTS = null;
    private final int[] base;
    private int count;
    private final int dimension;
    private final int[] weight;

    static {
        PRIMES = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173};
        WEIGHTS = new int[]{1, 2, 3, 3, 8, 11, 12, 14, 7, 18, 12, 13, 17, 18, 29, 14, 18, 43, 41, 44, 40, 30, 47, 65, 71, 28, 40, 60, 79, 89, 56, 50, 52, 61, 108, 56, 66, 63, 60, 66};
    }

    public HaltonSequenceGenerator(int r3) throws OutOfRangeException {
        this(r3, PRIMES, WEIGHTS);
    }

    public HaltonSequenceGenerator(int r4, int[] r5, int[] r6) throws NullArgumentException, OutOfRangeException, DimensionMismatchException {
        this.count = 0;
        MathUtils.checkNotNull(r5);
        if (r4 < 1) goto L19;
        if (r4 > r5.length) goto L19;
        if (r6 != null) goto L8;
    L12:
        this.dimension = r4;
        this.base = (int[]) r5.clone();
        if (r6 != null) goto L15;
        int[] r7 = null;
    L16:
        this.weight = r7;
        this.count = 0;
        return;
    L15:
        r7 = (int[]) r6.clone();
        goto L16
    L8:
        if (r6.length == r5.length) goto L12;
        throw new DimensionMismatchException(r6.length, r5.length);
    L19:
        throw new OutOfRangeException(Integer.valueOf(r4), 1, Integer.valueOf(PRIMES.length));
    }

    @Override // org.apache.commons.math3.random.RandomVectorGenerator
    public double[] nextVector() {
        double[] r0 = new double[this.dimension];
        int r2 = 0;
    L4:
        if (r2 >= this.dimension) goto L10;
        int r3 = this.count;
        double r4 = this.base[r2];
        double r6 = 1.0d;
    L6:
        r6 = r6 / r4;
        if (r3 <= 0) goto L9;
        int r5 = this.base[r2];
        r0[r2] = r0[r2] + (((double) scramble(r2, 0, r5, r3 % r5)) * r6);
        int r7 = this.base[r2];
        r3 = r3 / r7;
        r4 = r7;
        goto L6
    L9:
        r2 = r2 + 1;
        goto L4
    L10:
        this.count++;
        return r0;
    }

    protected int scramble(int r1, int r2, int r3, int r4) {
        int[] r0 = this.weight;
        if (r0 != null) goto L5;
        return r4;
    L5:
        return (r0[r1] * r4) % r3;
    }

    public double[] skipTo(int r1) throws NotPositiveException {
        this.count = r1;
        return nextVector();
    }

    public int getNextIndex() {
        return this.count;
    }
}
