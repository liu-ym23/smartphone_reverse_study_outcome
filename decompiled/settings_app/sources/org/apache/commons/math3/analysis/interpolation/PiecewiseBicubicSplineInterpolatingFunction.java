package org.apache.commons.math3.analysis.interpolation;

import java.util.Arrays;
import org.apache.commons.math3.analysis.BivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.InsufficientDataException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class PiecewiseBicubicSplineInterpolatingFunction implements BivariateFunction {
    private static final int MIN_NUM_POINTS = 5;
    private final double[][] fval;
    private final double[] xval;
    private final double[] yval;

    public PiecewiseBicubicSplineInterpolatingFunction(double[] r7, double[] r8, double[][] r9) throws DimensionMismatchException, NullArgumentException, NoDataException, NonMonotonicSequenceException {
        if (r7 == null) goto L37;
        if (r8 == null) goto L37;
        if (r9 == null) goto L37;
        double[] r1 = r9[0];
        if (r1 == null) goto L37;
        int r2 = r7.length;
        int r3 = r8.length;
        if (r2 == 0) goto L35;
        if (r3 == 0) goto L35;
        if (r9.length == 0) goto L35;
        if (r1.length == 0) goto L35;
        if (r2 < 5) goto L33;
        if (r3 < 5) goto L33;
        if (r9.length < 5) goto L33;
        if (r1.length < 5) goto L33;
        if (r2 != r9.length) goto L31;
        if (r3 != r1.length) goto L29;
        MathArrays.checkOrder(r7);
        MathArrays.checkOrder(r8);
        this.xval = (double[]) r7.clone();
        this.yval = (double[]) r8.clone();
        this.fval = (double[][]) r9.clone();
        return;
    L29:
        throw new DimensionMismatchException(r3, r9[0].length);
    L31:
        throw new DimensionMismatchException(r2, r9.length);
    L33:
        throw new InsufficientDataException();
    L35:
        throw new NoDataException();
    L37:
        throw new NullArgumentException();
    }

    @Override // org.apache.commons.math3.analysis.BivariateFunction
    public double value(double r17, double r19) throws OutOfRangeException {
        AkimaSplineInterpolator r7 = new AkimaSplineInterpolator();
        int r8 = searchIndex(r17, this.xval, 2, 5);
        int r0 = searchIndex(r19, this.yval, 2, 5);
        double[] r2 = new double[5];
        double[] r3 = new double[5];
        double[] r4 = new double[5];
        double[] r5 = new double[5];
        int r10 = 0;
    L3:
        if (r10 >= 5) goto L5;
        r2[r10] = this.xval[r8 + r10];
        r3[r10] = this.yval[r0 + r10];
        r10 = r10 + 1;
        goto L3
    L5:
        int r11 = 0;
    L6:
        if (r11 >= 5) goto L12;
        int r12 = 0;
    L8:
        if (r12 >= 5) goto L10;
        r4[r12] = this.fval[r8 + r12][r0 + r11];
        r12 = r12 + 1;
        goto L8
    L10:
        r5[r11] = r7.interpolate(r2, r4).value(r17);
        r11 = r11 + 1;
        goto L6
    L12:
        return r7.interpolate(r3, r5).value(r19);
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

    private int searchIndex(double r3, double[] r5, int r6, int r7) {
        int r2 = Arrays.binarySearch(r5, r3);
        int r1 = 0;
        if (r2 == (-1)) goto L17;
        if (r2 == ((-r5.length) - 1)) goto L17;
        if (r2 >= 0) goto L8;
        int r4 = ((-r2) - r6) - 1;
    L9:
        if (r4 < 0) goto L13;
        r1 = r4;
    L13:
        if ((r1 + r7) >= r5.length) goto L15;
        return r1;
    L15:
        return r5.length - r7;
    L8:
        r4 = r2 - r6;
    L17:
        throw new OutOfRangeException(Double.valueOf(r3), Double.valueOf(r5[0]), Double.valueOf(r5[r5.length - 1]));
    }
}
