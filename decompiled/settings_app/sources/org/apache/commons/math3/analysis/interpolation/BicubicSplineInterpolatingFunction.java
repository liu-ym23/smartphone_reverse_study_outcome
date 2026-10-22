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
@Deprecated
public class BicubicSplineInterpolatingFunction implements BivariateFunction {
    private static final double[][] AINV = null;
    private static final int NUM_COEFF = 16;
    private final BivariateFunction[][][] partialDerivatives;
    private final BicubicSplineFunction[][] splines;
    private final double[] xval;
    private final double[] yval;

    static {
        AINV = new double[][]{new double[]{1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{-3.0d, 3.0d, 0.0d, 0.0d, -2.0d, -1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{2.0d, -2.0d, 0.0d, 0.0d, 1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -3.0d, 3.0d, 0.0d, 0.0d, -2.0d, -1.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 2.0d, -2.0d, 0.0d, 0.0d, 1.0d, 1.0d, 0.0d, 0.0d}, new double[]{-3.0d, 0.0d, 3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -2.0d, 0.0d, -1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, -3.0d, 0.0d, 3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -2.0d, 0.0d, -1.0d, 0.0d}, new double[]{9.0d, -9.0d, -9.0d, 9.0d, 6.0d, 3.0d, -6.0d, -3.0d, 6.0d, -6.0d, 3.0d, -3.0d, 4.0d, 2.0d, 2.0d, 1.0d}, new double[]{-6.0d, 6.0d, 6.0d, -6.0d, -3.0d, -3.0d, 3.0d, 3.0d, -4.0d, 4.0d, -2.0d, 2.0d, -2.0d, -2.0d, -1.0d, -1.0d}, new double[]{2.0d, 0.0d, -2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 2.0d, 0.0d, -2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 1.0d, 0.0d}, new double[]{-6.0d, 6.0d, 6.0d, -6.0d, -4.0d, -2.0d, 4.0d, 2.0d, -3.0d, 3.0d, -3.0d, 3.0d, -2.0d, -1.0d, -2.0d, -1.0d}, new double[]{4.0d, -4.0d, -4.0d, 4.0d, 2.0d, 2.0d, -2.0d, -2.0d, 2.0d, -2.0d, 2.0d, -2.0d, 1.0d, 1.0d, 1.0d, 1.0d}};
    }

    public BicubicSplineInterpolatingFunction(double[] r9, double[] r10, double[][] r11, double[][] r12, double[][] r13, double[][] r14) throws DimensionMismatchException, NoDataException, NonMonotonicSequenceException {
        this(r9, r10, r11, r12, r13, r14, false);
    }

    public BicubicSplineInterpolatingFunction(double[] r24, double[] r25, double[][] r26, double[][] r27, double[][] r28, double[][] r29, boolean r30) throws DimensionMismatchException, NoDataException, NonMonotonicSequenceException {
        int r7 = r24.length;
        int r9 = r25.length;
        if (r7 == 0) goto L57;
        if (r9 == 0) goto L57;
        if (r26.length == 0) goto L57;
        int r10 = 0;
        if (r26[0].length == 0) goto L57;
        if (r7 != r26.length) goto L55;
        if (r7 != r27.length) goto L53;
        if (r7 != r28.length) goto L51;
        if (r7 != r29.length) goto L49;
        MathArrays.checkOrder(r24);
        MathArrays.checkOrder(r25);
        this.xval = (double[]) r24.clone();
        this.yval = (double[]) r25.clone();
        char r6 = 1;
        int r8 = r7 - 1;
        int r11 = r9 - 1;
        this.splines = (BicubicSplineFunction[][]) Array.newInstance(BicubicSplineFunction.class, new int[]{r8, r11});
        int r12 = 0;
    L18:
        if (r12 >= r8) goto L39;
        if (r26[r12].length != r9) goto L38;
        if (r27[r12].length != r9) goto L36;
        if (r28[r12].length != r9) goto L34;
        if (r29[r12].length != r9) goto L32;
        int r14 = r12 + 1;
        int r13 = r10;
    L28:
        if (r13 >= r11) goto L30;
        int r16 = r13 + 1;
        double[] r15 = new double[16];
        double[] r18 = r26[r12];
        r15[r10] = r18[r13];
        double[] r19 = r26[r14];
        r15[r6] = r19[r13];
        r15[2] = r18[r16];
        r15[3] = r19[r16];
        double[] r110 = r27[r12];
        r15[4] = r110[r13];
        double[] r111 = r27[r14];
        r15[5] = r111[r13];
        r15[6] = r110[r16];
        r15[7] = r111[r16];
        double[] r112 = r28[r12];
        r15[8] = r112[r13];
        double[] r113 = r28[r14];
        r15[9] = r113[r13];
        r15[10] = r112[r16];
        r15[11] = r113[r16];
        double[] r114 = r29[r12];
        r15[12] = r114[r13];
        double[] r115 = r29[r14];
        r15[13] = r115[r13];
        r15[14] = r114[r16];
        r15[15] = r115[r16];
        this.splines[r12][r13] = new BicubicSplineFunction(computeSplineCoefficients(r15), r30);
        r13 = r16;
        r6 = 1;
        r10 = 0;
        goto L28
    L30:
        r12 = r14;
        goto L18
    L32:
        throw new DimensionMismatchException(r29[r12].length, r9);
    L34:
        throw new DimensionMismatchException(r28[r12].length, r9);
    L36:
        throw new DimensionMismatchException(r27[r12].length, r9);
    L38:
        throw new DimensionMismatchException(r26[r12].length, r9);
    L39:
        if (r30 == false) goto L46;
        this.partialDerivatives = (BivariateFunction[][][]) Array.newInstance(BivariateFunction.class, new int[]{5, r8, r11});
        int r3 = 0;
    L41:
        if (r3 >= r8) goto L66;
        int r1 = 0;
    L43:
        if (r1 >= r11) goto L45;
        BicubicSplineFunction r2 = this.splines[r3][r1];
        this.partialDerivatives[0][r3][r1] = r2.partialDerivativeX();
        this.partialDerivatives[1][r3][r1] = r2.partialDerivativeY();
        this.partialDerivatives[2][r3][r1] = r2.partialDerivativeXX();
        this.partialDerivatives[3][r3][r1] = r2.partialDerivativeYY();
        this.partialDerivatives[4][r3][r1] = r2.partialDerivativeXY();
        r1 = r1 + 1;
        goto L43
    L45:
        r3 = r3 + 1;
        goto L41
    L66:
        return;
    L46:
        BivariateFunction[][][] r4 = (BivariateFunction[][][]) null;
        this.partialDerivatives = null;
        return;
    L49:
        throw new DimensionMismatchException(r7, r29.length);
    L51:
        throw new DimensionMismatchException(r7, r28.length);
    L53:
        throw new DimensionMismatchException(r7, r27.length);
    L55:
        throw new DimensionMismatchException(r7, r26.length);
    L57:
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

    public double partialDerivativeX(double r7, double r9) throws OutOfRangeException {
        return partialDerivative(0, r7, r9);
    }

    public double partialDerivativeY(double r7, double r9) throws OutOfRangeException {
        return partialDerivative(1, r7, r9);
    }

    public double partialDerivativeXX(double r7, double r9) throws OutOfRangeException {
        return partialDerivative(2, r7, r9);
    }

    public double partialDerivativeYY(double r7, double r9) throws OutOfRangeException {
        return partialDerivative(3, r7, r9);
    }

    public double partialDerivativeXY(double r7, double r9) throws OutOfRangeException {
        return partialDerivative(4, r7, r9);
    }

    private double partialDerivative(int r8, double r9, double r11) throws OutOfRangeException {
        int r0 = searchIndex(r9, this.xval);
        int r1 = searchIndex(r11, this.yval);
        double[] r2 = this.xval;
        double r3 = r2[r0];
        double r10 = (r9 - r3) / (r2[r0 + 1] - r3);
        double[] r4 = this.yval;
        double r5 = r4[r1];
        double r12 = (r11 - r5) / (r4[r1 + 1] - r5);
        return this.partialDerivatives[r8][r0][r1].value(r10, r12);
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
