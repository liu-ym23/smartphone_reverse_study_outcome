package org.apache.commons.math3.analysis.interpolation;

import java.lang.reflect.Array;
import org.apache.commons.math3.analysis.BivariateFunction;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class BicubicSplineInterpolator implements BivariateGridInterpolator {
    private final boolean initializeDerivatives;

    private int nextIndex(int r1, int r2) {
        int r3 = r1 + 1;
        if (r3 >= r2) goto L6;
        return r3;
    L6:
        return r3 - 1;
    }

    private int previousIndex(int r1) {
        int r2 = r1 - 1;
        if (r2 >= 0) goto L7;
        return 0;
    L7:
        return r2;
    }

    @Override // org.apache.commons.math3.analysis.interpolation.BivariateGridInterpolator
    public /* bridge */ /* synthetic */ BivariateFunction interpolate(double[] r1, double[] r2, double[][] r3) throws NoDataException, DimensionMismatchException, NonMonotonicSequenceException, NumberIsTooSmallException {
        return interpolate(r1, r2, r3);
    }

    public BicubicSplineInterpolator() {
        this(false);
    }

    public BicubicSplineInterpolator(boolean r1) {
        this.initializeDerivatives = r1;
    }

    @Override // org.apache.commons.math3.analysis.interpolation.BivariateGridInterpolator
    public BicubicSplineInterpolatingFunction interpolate(double[] r25, double[] r26, double[][] r27) throws NoDataException, DimensionMismatchException, NonMonotonicSequenceException, NumberIsTooSmallException {
        if (r25.length == 0) goto L49;
        if (r26.length == 0) goto L49;
        if (r27.length == 0) goto L49;
        if (r25.length != r27.length) goto L47;
        MathArrays.checkOrder(r25);
        MathArrays.checkOrder(r26);
        int r4 = r25.length;
        int r5 = r26.length;
        int r9 = 0;
        double[][] r7 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r5, r4});
        int r10 = 0;
    L11:
        if (r10 >= r4) goto L20;
        if (r27[r10].length != r5) goto L19;
        int r11 = 0;
    L15:
        if (r11 >= r5) goto L17;
        r7[r11][r10] = r27[r10][r11];
        r11 = r11 + 1;
        goto L15
    L17:
        r10 = r10 + 1;
        goto L11
    L19:
        throw new DimensionMismatchException(r27[r10].length, r5);
    L20:
        SplineInterpolator r12 = new SplineInterpolator();
        PolynomialSplineFunction[] r13 = new PolynomialSplineFunction[r5];
        int r14 = 0;
    L21:
        if (r14 >= r5) goto L23;
        r13[r14] = r12.interpolate(r25, r7[r14]);
        r14 = r14 + 1;
        goto L21
    L23:
        PolynomialSplineFunction[] r8 = new PolynomialSplineFunction[r4];
        int r15 = 0;
    L24:
        if (r15 >= r4) goto L26;
        r8[r15] = r12.interpolate(r26, r27[r15]);
        r15 = r15 + 1;
        goto L24
    L26:
        double[][] r16 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r4, r5});
        int r17 = 0;
    L27:
        if (r17 >= r5) goto L32;
        UnivariateFunction r18 = r13[r17].derivative();
        int r19 = r9;
    L29:
        if (r19 >= r4) goto L31;
        r16[r19][r17] = r18.value(r25[r19]);
        r19 = r19 + 1;
        r16 = r16;
        goto L29
    L31:
        r17 = r17 + 1;
        r9 = 0;
        goto L27
    L32:
        double[][] r110 = r16;
        double[][] r20 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r4, r5});
        int r111 = 0;
    L33:
        if (r111 >= r4) goto L38;
        UnivariateFunction r112 = r8[r111].derivative();
        int r113 = 0;
    L35:
        if (r113 >= r5) goto L37;
        r20[r111][r113] = r112.value(r26[r113]);
        r113 = r113 + 1;
        goto L35
    L37:
        r111 = r111 + 1;
        goto L33
    L38:
        double[][] r6 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r4, r5});
        int r21 = 0;
    L39:
        if (r21 >= r4) goto L45;
        int r22 = nextIndex(r21, r4);
        int r114 = previousIndex(r21);
        int r115 = 0;
    L41:
        if (r115 >= r5) goto L43;
        int r116 = nextIndex(r115, r5);
        int r117 = previousIndex(r115);
        double[] r118 = r6[r21];
        double[] r119 = r27[r22];
        double r120 = r119[r116] - r119[r117];
        double[] r121 = r27[r114];
        r118[r115] = ((r120 - r121[r116]) + r121[r117]) / ((r25[r22] - r25[r114]) * (r26[r116] - r26[r117]));
        r115 = r115 + 1;
        goto L41
    L43:
        r21 = r21 + 1;
        goto L39
    L45:
        return new BicubicSplineInterpolatingFunction(r25, r26, r27, r110, r20, r6, this.initializeDerivatives);
    L47:
        throw new DimensionMismatchException(r25.length, r27.length);
    L49:
        throw new NoDataException();
    }
}
