package org.apache.commons.math3.stat.inference;

import java.lang.reflect.Array;
import org.apache.commons.math3.distribution.ChiSquaredDistribution;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class GTest {
    public GTest() {
    }

    public double g(double[] r12, long[] r13) throws NotPositiveException, NotStrictlyPositiveException, DimensionMismatchException {
        if (r12.length < 2) goto L25;
        if (r12.length != r13.length) goto L23;
        MathArrays.checkPositive(r12);
        MathArrays.checkNonNegative(r13);
        int r11 = 0;
        double r0 = 0.0d;
        int r2 = 0;
        double r3 = 0.0d;
        double r5 = 0.0d;
    L8:
        if (r2 >= r13.length) goto L11;
        r3 = r3 + r12[r2];
        r5 = r5 + r13[r2];
        r2 = r2 + 1;
        goto L8
    L11:
        if (FastMath.abs(r3 - r5) <= 1.0E-5d) goto L13;
        double r6 = r5 / r3;
        boolean r4 = true;
    L15:
        if (r11 >= r13.length) goto L21;
        if (r4 == false) goto L18;
        double r7 = r13[r11];
        double r8 = r12[r11] * r6;
    L19:
        r0 = r0 + (r13[r11] * FastMath.log(r7 / r8));
        r11 = r11 + 1;
        goto L15
    L18:
        r7 = r13[r11];
        r8 = r12[r11];
        goto L19
    L21:
        return r0 * 2.0d;
    L13:
        r6 = 1.0d;
        r4 = false;
        goto L15
    L23:
        throw new DimensionMismatchException(r12.length, r13.length);
    L25:
        throw new DimensionMismatchException(r12.length, 2);
    }

    public double gTest(double[] r7, long[] r8) throws NotPositiveException, NotStrictlyPositiveException, DimensionMismatchException, MaxCountExceededException {
        return 1.0d - new ChiSquaredDistribution(null, ((double) r7.length) - 1.0d).cumulativeProbability(g(r7, r8));
    }

    public double gTestIntrinsic(double[] r6, long[] r7) throws NotPositiveException, NotStrictlyPositiveException, DimensionMismatchException, MaxCountExceededException {
        return 1.0d - new ChiSquaredDistribution(null, ((double) r6.length) - 2.0d).cumulativeProbability(g(r6, r7));
    }

    public boolean gTest(double[] r5, long[] r6, double r7) throws NotPositiveException, NotStrictlyPositiveException, DimensionMismatchException, OutOfRangeException, MaxCountExceededException {
        if (r7 <= 0.0d) goto L11;
        if (r7 > 0.5d) goto L11;
        if (gTest(r5, r6) >= r7) goto L12;
        return true;
    L12:
        return false;
    L11:
        throw new OutOfRangeException(LocalizedFormats.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, Double.valueOf(r7), 0, Double.valueOf(0.5d));
    }

    private double entropy(long[][] r11) {
        double r0 = 0.0d;
        int r2 = 0;
        double r3 = 0.0d;
    L4:
        if (r2 >= r11.length) goto L10;
        int r5 = 0;
    L6:
        long[] r6 = r11[r2];
        if (r5 >= r6.length) goto L9;
        r3 = r3 + r6[r5];
        r5 = r5 + 1;
        goto L6
    L9:
        r2 = r2 + 1;
        goto L4
    L10:
        int r4 = 0;
    L12:
        if (r4 >= r11.length) goto L22;
        int r7 = 0;
    L14:
        long[] r8 = r11[r4];
        if (r7 >= r8.length) goto L20;
        long r9 = r8[r7];
        if (r9 == 0) goto L19;
        double r10 = r9 / r3;
        r0 = r0 + (r10 * FastMath.log(r10));
    L19:
        r7 = r7 + 1;
        goto L14
    L20:
        r4 = r4 + 1;
        goto L12
    L22:
        return -r0;
    }

    private double entropy(long[] r10) {
        double r0 = 0.0d;
        int r9 = 0;
        int r2 = 0;
        double r3 = 0.0d;
    L4:
        if (r2 >= r10.length) goto L7;
        r3 = r3 + r10[r2];
        r2 = r2 + 1;
    L7:
        if (r9 >= r10.length) goto L13;
        long r5 = r10[r9];
        if (r5 == 0) goto L11;
        double r6 = r5 / r3;
        r0 = r0 + (r6 * FastMath.log(r6));
    L11:
        r9 = r9 + 1;
        goto L7
    L13:
        return -r0;
    }

    public double gDataSetsComparison(long[] r20, long[] r21) throws DimensionMismatchException, NotPositiveException, ZeroException {
        if (r20.length < 2) goto L28;
        if (r20.length != r21.length) goto L26;
        MathArrays.checkNonNegative(r20);
        MathArrays.checkNonNegative(r21);
        long[] r3 = new long[r20.length];
        long[][] r6 = (long[][]) Array.newInstance(Long.TYPE, new int[]{2, r20.length});
        int r10 = 0;
        long r11 = 0;
        long r13 = 0;
    L8:
        if (r10 >= r20.length) goto L18;
        long r15 = r20[r10];
        if (r15 != 0) goto L16;
        if (r21[r10] != 0) goto L16;
        throw new ZeroException(LocalizedFormats.OBSERVED_COUNTS_BOTTH_ZERO_FOR_ENTRY, new Object[]{Integer.valueOf(r10)});
    L16:
        r11 = r11 + r15;
        long r17 = r21[r10];
        r13 = r13 + r17;
        r3[r10] = r15 + r17;
        r6[0][r10] = r20[r10];
        r6[1][r10] = r21[r10];
        r10 = r10 + 1;
        goto L8
    L18:
        if (r11 == 0) goto L24;
        if (r13 == 0) goto L24;
        return ((r11 + r13) * 2.0d) * ((entropy(new long[]{r11, r13}) + entropy(r3)) - entropy(r6));
    L24:
        throw new ZeroException();
    L26:
        throw new DimensionMismatchException(r20.length, r21.length);
    L28:
        throw new DimensionMismatchException(r20.length, 2);
    }

    public double rootLogLikelihoodRatio(long r5, long r7, long r9, long r11) {
        double r0 = FastMath.sqrt(gDataSetsComparison(new long[]{r5, r7}, new long[]{r9, r11}));
        if ((r5 / (r5 + r7)) < (r9 / (r9 + r11))) goto L5;
        return r0;
    L5:
        return -r0;
    }

    public double gTestDataSetsComparison(long[] r7, long[] r8) throws DimensionMismatchException, NotPositiveException, ZeroException, MaxCountExceededException {
        return 1.0d - new ChiSquaredDistribution(null, ((double) r7.length) - 1.0d).cumulativeProbability(gDataSetsComparison(r7, r8));
    }

    public boolean gTestDataSetsComparison(long[] r5, long[] r6, double r7) throws DimensionMismatchException, NotPositiveException, ZeroException, OutOfRangeException, MaxCountExceededException {
        if (r7 <= 0.0d) goto L11;
        if (r7 > 0.5d) goto L11;
        if (gTestDataSetsComparison(r5, r6) >= r7) goto L12;
        return true;
    L12:
        return false;
    L11:
        throw new OutOfRangeException(LocalizedFormats.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, Double.valueOf(r7), 0, Double.valueOf(0.5d));
    }
}
