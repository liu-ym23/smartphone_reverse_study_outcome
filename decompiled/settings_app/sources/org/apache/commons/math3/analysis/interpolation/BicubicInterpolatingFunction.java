package org.apache.commons.math3.analysis.interpolation;

import java.lang.reflect.Array;
import java.util.Arrays;
import org.apache.commons.math3.analysis.BivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class BicubicInterpolatingFunction implements BivariateFunction {
    private static final double[][] AINV = null;
    private static final int NUM_COEFF = 16;
    private final BicubicFunction[][] splines;
    private final double[] xval;
    private final double[] yval;

    static {
        AINV = new double[][]{new double[]{1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{-3.0d, 3.0d, 0.0d, 0.0d, -2.0d, -1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{2.0d, -2.0d, 0.0d, 0.0d, 1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -3.0d, 3.0d, 0.0d, 0.0d, -2.0d, -1.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 2.0d, -2.0d, 0.0d, 0.0d, 1.0d, 1.0d, 0.0d, 0.0d}, new double[]{-3.0d, 0.0d, 3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -2.0d, 0.0d, -1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, -3.0d, 0.0d, 3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -2.0d, 0.0d, -1.0d, 0.0d}, new double[]{9.0d, -9.0d, -9.0d, 9.0d, 6.0d, 3.0d, -6.0d, -3.0d, 6.0d, -6.0d, 3.0d, -3.0d, 4.0d, 2.0d, 2.0d, 1.0d}, new double[]{-6.0d, 6.0d, 6.0d, -6.0d, -3.0d, -3.0d, 3.0d, 3.0d, -4.0d, 4.0d, -2.0d, 2.0d, -2.0d, -2.0d, -1.0d, -1.0d}, new double[]{2.0d, 0.0d, -2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 2.0d, 0.0d, -2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 1.0d, 0.0d}, new double[]{-6.0d, 6.0d, 6.0d, -6.0d, -4.0d, -2.0d, 4.0d, 2.0d, -3.0d, 3.0d, -3.0d, 3.0d, -2.0d, -1.0d, -2.0d, -1.0d}, new double[]{4.0d, -4.0d, -4.0d, 4.0d, 2.0d, 2.0d, -2.0d, -2.0d, 2.0d, -2.0d, 2.0d, -2.0d, 1.0d, 1.0d, 1.0d, 1.0d}};
    }

    public BicubicInterpolatingFunction(double[] r28, double[] r29, double[][] r30, double[][] r31, double[][] r32, double[][] r33) throws DimensionMismatchException, NoDataException, NonMonotonicSequenceException {
        int r6 = r28.length;
        int r8 = r29.length;
        if (r6 == 0) goto L49;
        if (r8 == 0) goto L49;
        if (r30.length == 0) goto L49;
        int r9 = 0;
        if (r30[0].length == 0) goto L49;
        if (r6 != r30.length) goto L47;
        if (r6 != r31.length) goto L45;
        if (r6 != r32.length) goto L43;
        if (r6 != r33.length) goto L41;
        MathArrays.checkOrder(r28);
        MathArrays.checkOrder(r29);
        this.xval = (double[]) r28.clone();
        this.yval = (double[]) r29.clone();
        char r5 = 1;
        int r7 = r6 - 1;
        int r10 = r8 - 1;
        this.splines = (BicubicFunction[][]) Array.newInstance(BicubicFunction.class, new int[]{r7, r10});
        int r11 = 0;
    L18:
        if (r11 >= r7) goto L39;
        if (r30[r11].length != r8) goto L38;
        if (r31[r11].length != r8) goto L36;
        if (r32[r11].length != r8) goto L34;
        if (r33[r11].length != r8) goto L32;
        int r12 = r11 + 1;
        double[] r13 = this.xval;
        double r14 = r13[r12] - r13[r11];
        int r15 = r9;
    L28:
        if (r15 >= r10) goto L30;
        int r16 = r15 + 1;
        double[] r17 = this.yval;
        double r18 = r17[r16] - r17[r15];
        double r19 = r14 * r18;
        double[] r110 = new double[16];
        double[] r21 = r30[r11];
        r110[r9] = r21[r15];
        double[] r22 = r30[r12];
        r110[r5] = r22[r15];
        r110[2] = r21[r16];
        r110[3] = r22[r16];
        double[] r23 = r31[r11];
        r110[4] = r23[r15] * r14;
        double[] r24 = r31[r12];
        r110[5] = r24[r15] * r14;
        r110[6] = r23[r16] * r14;
        r110[7] = r24[r16] * r14;
        double[] r25 = r32[r11];
        r110[8] = r25[r15] * r18;
        double[] r26 = r32[r12];
        r110[9] = r26[r15] * r18;
        r110[10] = r25[r16] * r18;
        r110[11] = r26[r16] * r18;
        double[] r111 = r33[r11];
        r110[12] = r111[r15] * r19;
        double[] r112 = r33[r12];
        r110[13] = r112[r15] * r19;
        r110[14] = r111[r16] * r19;
        r110[15] = r112[r16] * r19;
        this.splines[r11][r15] = new BicubicFunction(computeSplineCoefficients(r110));
        r15 = r16;
        r5 = 1;
        r9 = 0;
        goto L28
    L30:
        r11 = r12;
        goto L18
    L32:
        throw new DimensionMismatchException(r33[r11].length, r8);
    L34:
        throw new DimensionMismatchException(r32[r11].length, r8);
    L36:
        throw new DimensionMismatchException(r31[r11].length, r8);
    L38:
        throw new DimensionMismatchException(r30[r11].length, r8);
    L39:
        return;
    L41:
        throw new DimensionMismatchException(r6, r33.length);
    L43:
        throw new DimensionMismatchException(r6, r32.length);
    L45:
        throw new DimensionMismatchException(r6, r31.length);
    L47:
        throw new DimensionMismatchException(r6, r30.length);
    L49:
        throw new NoDataException();
    }

    @Override // org.apache.commons.math3.analysis.BivariateFunction
    public double value(double r8, double r10) throws OutOfRangeException {
        int r0 = searchIndex(r8, this.xval);
        int r1 = searchIndex(r10, this.yval);
        double[] r2 = this.xval;
        double r3 = r2[r0];
        double r9 = (r8 - r3) / (r2[r0 + 1] - r3);
        double[] r4 = this.yval;
        double r5 = r4[r1];
        double r11 = (r10 - r5) / (r4[r1 + 1] - r5);
        return this.splines[r0][r1].value(r9, r11);
    }

    public boolean isValidPoint(double r7, double r9) {
        double[] r0 = this.xval;
        if (r7 >= r0[0]) goto L5;
    L12:
        return false;
    L5:
        if (r7 > r0[r0.length - 1]) goto L12;
        double[] r6 = this.yval;
        if (r9 < r6[0]) goto L12;
        if (r9 > r6[r6.length - 1]) goto L12;
        return true;
    }

    private int searchIndex(double r3, double[] r5) {
        int r2 = Arrays.binarySearch(r5, r3);
        if (r2 == (-1)) goto L15;
        if (r2 == ((-r5.length) - 1)) goto L15;
        if (r2 < 0) goto L8;
        int r4 = r5.length - 1;
        if (r2 == r4) goto L12;
        return r2;
    L12:
        return r4 - 1;
    L8:
        return (-r2) - 2;
    L15:
        throw new OutOfRangeException(Double.valueOf(r3), Double.valueOf(r5[0]), Double.valueOf(r5[r5.length - 1]));
    }

    private double[] computeSplineCoefficients(double[] r12) {
        double[] r0 = new double[16];
        int r2 = 0;
    L3:
        if (r2 >= 16) goto L8;
        double[] r3 = AINV[r2];
        double r4 = 0.0d;
        int r6 = 0;
    L5:
        if (r6 >= 16) goto L7;
        r4 = r4 + (r3[r6] * r12[r6]);
        r6 = r6 + 1;
        goto L5
    L7:
        r0[r2] = r4;
        r2 = r2 + 1;
        goto L3
    L8:
        return r0;
    }
}
