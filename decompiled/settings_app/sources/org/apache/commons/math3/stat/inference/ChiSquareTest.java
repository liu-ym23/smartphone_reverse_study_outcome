package org.apache.commons.math3.stat.inference;

import org.apache.commons.math3.distribution.ChiSquaredDistribution;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class ChiSquareTest {
    public ChiSquareTest() {
    }

    public double chiSquare(double[] r12, long[] r13) throws NotPositiveException, NotStrictlyPositiveException, DimensionMismatchException {
        if (r12.length < 2) goto L24;
        if (r12.length != r13.length) goto L22;
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
        if (r11 >= r13.length) goto L20;
        if (r4 == false) goto L18;
        double r7 = r13[r11];
        double r8 = r12[r11];
        double r9 = r7 - (r6 * r8);
        double r10 = r9 * r9;
        double r14 = r8 * r6;
    L19:
        r0 = r0 + (r10 / r14);
        r11 = r11 + 1;
        goto L15
    L18:
        double r15 = r13[r11];
        r14 = r12[r11];
        double r16 = r15 - r14;
        r10 = r16 * r16;
        goto L19
    L20:
        return r0;
    L13:
        r6 = 1.0d;
        r4 = false;
        goto L15
    L22:
        throw new DimensionMismatchException(r12.length, r13.length);
    L24:
        throw new DimensionMismatchException(r12.length, 2);
    }

    public double chiSquareTest(double[] r7, long[] r8) throws NotPositiveException, NotStrictlyPositiveException, DimensionMismatchException, MaxCountExceededException {
        return 1.0d - new ChiSquaredDistribution(null, ((double) r7.length) - 1.0d).cumulativeProbability(chiSquare(r7, r8));
    }

    public boolean chiSquareTest(double[] r5, long[] r6, double r7) throws NotPositiveException, NotStrictlyPositiveException, DimensionMismatchException, OutOfRangeException, MaxCountExceededException {
        if (r7 <= 0.0d) goto L11;
        if (r7 > 0.5d) goto L11;
        if (chiSquareTest(r5, r6) >= r7) goto L12;
        return true;
    L12:
        return false;
    L11:
        throw new OutOfRangeException(LocalizedFormats.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, Double.valueOf(r7), 0, Double.valueOf(0.5d));
    }

    public double chiSquare(long[][] r18) throws NullArgumentException, NotPositiveException, DimensionMismatchException {
        checkArray(r18);
        int r1 = r18.length;
        int r2 = 0;
        int r3 = r18[0].length;
        double[] r4 = new double[r1];
        double[] r5 = new double[r3];
        int r8 = 0;
        double r9 = 0.0d;
    L3:
        if (r8 >= r1) goto L8;
        int r11 = 0;
    L5:
        if (r11 >= r3) goto L7;
        double r12 = r4[r8];
        long r14 = r18[r8][r11];
        r4[r8] = r12 + r14;
        r5[r11] = r5[r11] + r14;
        r9 = r9 + r14;
        r11 = r11 + 1;
        goto L5
    L7:
        r8 = r8 + 1;
        goto L3
    L8:
        int r10 = 0;
        double r6 = 0.0d;
    L9:
        if (r10 >= r1) goto L14;
        int r13 = r2;
    L11:
        if (r13 >= r3) goto L13;
        double r15 = (r4[r10] * r5[r13]) / r9;
        long r16 = r18[r10][r13];
        r6 = r6 + (((r16 - r15) * (r16 - r15)) / r15);
        r13 = r13 + 1;
        r3 = r3;
        goto L11
    L13:
        r10 = r10 + 1;
        r2 = 0;
        goto L9
    L14:
        return r6;
    }

    public double chiSquareTest(long[][] r7) throws NullArgumentException, DimensionMismatchException, NotPositiveException, MaxCountExceededException {
        checkArray(r7);
        return 1.0d - new ChiSquaredDistribution((((double) r7.length) - 1.0d) * (((double) r7[0].length) - 1.0d)).cumulativeProbability(chiSquare(r7));
    }

    public boolean chiSquareTest(long[][] r5, double r6) throws NullArgumentException, DimensionMismatchException, NotPositiveException, OutOfRangeException, MaxCountExceededException {
        if (r6 <= 0.0d) goto L11;
        if (r6 > 0.5d) goto L11;
        if (chiSquareTest(r5) >= r6) goto L12;
        return true;
    L12:
        return false;
    L11:
        throw new OutOfRangeException(LocalizedFormats.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, Double.valueOf(r6), 0, Double.valueOf(0.5d));
    }

    public double chiSquareDataSetsComparison(long[] r22, long[] r23) throws DimensionMismatchException, NotPositiveException, ZeroException {
        if (r22.length < 2) goto L43;
        if (r22.length != r23.length) goto L41;
        MathArrays.checkNonNegative(r22);
        MathArrays.checkNonNegative(r23);
        char r2 = 0;
        long r3 = 0;
        int r5 = 0;
        long r6 = 0;
        long r8 = 0;
    L8:
        if (r5 >= r22.length) goto L11;
        r6 = r6 + r22[r5];
        r8 = r8 + r23[r5];
        r5 = r5 + 1;
        goto L8
    L11:
        if (r6 == 0) goto L39;
        if (r8 == 0) goto L39;
        if (r6 == r8) goto L17;
        boolean r7 = true;
    L18:
        double r11 = 0.0d;
        if (r7 == false) goto L21;
        double r9 = FastMath.sqrt(r6 / r8);
    L22:
        int r10 = 0;
    L24:
        if (r10 >= r22.length) goto L37;
        long r13 = r22[r10];
        if (r13 == r3) goto L28;
    L32:
        double r14 = r13;
        double r4 = r23[r10];
        if (r7 == false) goto L35;
        double r17 = (r14 / r9) - (r4 * r9);
    L36:
        r11 = r11 + ((r17 * r17) / (r14 + r4));
        r10 = r10 + 1;
        r2 = 0;
        r3 = 0;
        goto L24
    L35:
        r17 = r14 - r4;
        goto L36
    L28:
        if (r23[r10] != r3) goto L32;
        LocalizedFormats r1 = LocalizedFormats.OBSERVED_COUNTS_BOTTH_ZERO_FOR_ENTRY;
        Object[] r12 = new Object[1];
        r12[r2] = Integer.valueOf(r10);
        throw new ZeroException(r1, r12);
    L37:
        return r11;
    L21:
        r9 = 0.0d;
        goto L22
    L17:
        r7 = false;
    L39:
        throw new ZeroException();
    L41:
        throw new DimensionMismatchException(r22.length, r23.length);
    L43:
        throw new DimensionMismatchException(r22.length, 2);
    }

    public double chiSquareTestDataSetsComparison(long[] r7, long[] r8) throws DimensionMismatchException, NotPositiveException, ZeroException, MaxCountExceededException {
        return 1.0d - new ChiSquaredDistribution(null, ((double) r7.length) - 1.0d).cumulativeProbability(chiSquareDataSetsComparison(r7, r8));
    }

    public boolean chiSquareTestDataSetsComparison(long[] r5, long[] r6, double r7) throws DimensionMismatchException, NotPositiveException, ZeroException, OutOfRangeException, MaxCountExceededException {
        if (r7 <= 0.0d) goto L11;
        if (r7 > 0.5d) goto L11;
        if (chiSquareTestDataSetsComparison(r5, r6) >= r7) goto L12;
        return true;
    L12:
        return false;
    L11:
        throw new OutOfRangeException(LocalizedFormats.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, Double.valueOf(r7), 0, Double.valueOf(0.5d));
    }

    private void checkArray(long[][] r3) throws NullArgumentException, DimensionMismatchException, NotPositiveException {
        if (r3.length < 2) goto L11;
        if (r3[0].length < 2) goto L9;
        MathArrays.checkRectangular(r3);
        MathArrays.checkNonNegative(r3);
        return;
    L9:
        throw new DimensionMismatchException(r3[0].length, 2);
    L11:
        throw new DimensionMismatchException(r3.length, 2);
    }
}
