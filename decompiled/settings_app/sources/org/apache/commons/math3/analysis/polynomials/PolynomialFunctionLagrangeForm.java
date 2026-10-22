package org.apache.commons.math3.analysis.polynomials;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class PolynomialFunctionLagrangeForm implements UnivariateFunction {
    private double[] coefficients;
    private boolean coefficientsComputed;
    private final double[] x;
    private final double[] y;

    public PolynomialFunctionLagrangeForm(double[] r5, double[] r6) throws DimensionMismatchException, NumberIsTooSmallException, NonMonotonicSequenceException {
        double[] r0 = new double[r5.length];
        this.x = r0;
        double[] r1 = new double[r6.length];
        this.y = r1;
        System.arraycopy(r5, 0, r0, 0, r5.length);
        System.arraycopy(r6, 0, r1, 0, r6.length);
        this.coefficientsComputed = false;
        if (verifyInterpolationArray(r5, r6, false) == true) goto L6;
        MathArrays.sortInPlace(r0, new double[][]{r1});
        verifyInterpolationArray(r0, r1, true);
        return;
    }

    @Override // org.apache.commons.math3.analysis.UnivariateFunction
    public double value(double r2) {
        return evaluateInternal(this.x, this.y, r2);
    }

    public int degree() {
        return this.x.length - 1;
    }

    public double[] getInterpolatingPoints() {
        double[] r3 = this.x;
        double[] r0 = new double[r3.length];
        System.arraycopy(r3, 0, r0, 0, r3.length);
        return r0;
    }

    public double[] getInterpolatingValues() {
        double[] r3 = this.y;
        double[] r0 = new double[r3.length];
        System.arraycopy(r3, 0, r0, 0, r3.length);
        return r0;
    }

    public double[] getCoefficients() {
        if (this.coefficientsComputed == true) goto L5;
        computeCoefficients();
    L5:
        double[] r3 = this.coefficients;
        double[] r0 = new double[r3.length];
        System.arraycopy(r3, 0, r0, 0, r3.length);
        return r0;
    }

    public static double evaluate(double[] r4, double[] r5, double r6) throws DimensionMismatchException, NumberIsTooSmallException, NonMonotonicSequenceException {
        if (verifyInterpolationArray(r4, r5, false) == true) goto L5;
        double[] r1 = new double[r4.length];
        double[] r2 = new double[r5.length];
        System.arraycopy(r4, 0, r1, 0, r4.length);
        System.arraycopy(r5, 0, r2, 0, r5.length);
        MathArrays.sortInPlace(r1, new double[][]{r2});
        verifyInterpolationArray(r1, r2, true);
        return evaluateInternal(r1, r2, r6);
    L5:
        return evaluateInternal(r4, r5, r6);
    }

    private static double evaluateInternal(double[] r22, double[] r23, double r24) {
        int r1 = r22.length;
        double[] r2 = new double[r1];
        double[] r3 = new double[r1];
        double r5 = Double.POSITIVE_INFINITY;
        int r7 = 0;
        int r8 = 0;
    L3:
        if (r7 >= r1) goto L8;
        r2[r7] = r23[r7];
        r3[r7] = r23[r7];
        double r9 = FastMath.abs(r24 - r22[r7]);
        if (r9 >= r5) goto L7;
        r8 = r7;
        r5 = r9;
    L7:
        r7 = r7 + 1;
        goto L3
    L8:
        double r6 = r23[r8];
        int r10 = 1;
    L9:
        if (r10 >= r1) goto L19;
        int r11 = 0;
    L11:
        int r12 = r1 - r10;
        if (r11 >= r12) goto L15;
        double r13 = r22[r11];
        double r14 = r13 - r24;
        double r15 = r22[r10 + r11];
        double r16 = r15 - r24;
        double r17 = r13 - r15;
        int r18 = r11 + 1;
        double r19 = (r2[r18] - r3[r11]) / r17;
        r2[r11] = r14 * r19;
        r3[r11] = r16 * r19;
        r11 = r18;
        goto L11
    L15:
        if (r8 >= (((double) (r12 + 1)) * 0.5d)) goto L17;
        double r20 = r2[r8];
    L18:
        r6 = r6 + r20;
        r10 = r10 + 1;
        goto L9
    L17:
        r8 = r8 - 1;
        r20 = r3[r8];
        goto L18
    L19:
        return r6;
    }

    protected void computeCoefficients() {
        int r1 = degree() + 1;
        this.coefficients = new double[r1];
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r1) goto L5;
        this.coefficients[r4] = 0.0d;
        r4 = r4 + 1;
        goto L3
    L5:
        double[] r5 = new double[r1 + 1];
        r5[0] = 1.0d;
        int r7 = 0;
    L6:
        if (r7 >= r1) goto L11;
        int r8 = r7;
    L8:
        if (r8 <= 0) goto L10;
        r5[r8] = r5[r8 - 1] - (r5[r8] * this.x[r7]);
        r8 = r8 - 1;
        goto L8
    L10:
        r5[0] = r5[0] * (-this.x[r7]);
        r7 = r7 + 1;
        r5[r7] = 1.0d;
        goto L6
    L11:
        double[] r9 = new double[r1];
        int r10 = 0;
    L12:
        if (r10 >= r1) goto L22;
        int r11 = r3;
        double r12 = 1.0d;
    L14:
        if (r11 >= r1) goto L18;
        if (r10 == r11) goto L17;
        double[] r13 = this.x;
        r12 = r12 * (r13[r10] - r13[r11]);
    L17:
        r11 = r11 + 1;
        goto L14
    L18:
        double r14 = this.y[r10] / r12;
        int r15 = r1 - 1;
        double r16 = r5[r1];
        r9[r15] = r16;
        double[] r17 = this.coefficients;
        r17[r15] = r17[r15] + (r16 * r14);
        int r18 = r1 - 2;
    L19:
        if (r18 < 0) goto L21;
        int r19 = r18 + 1;
        double r110 = r5[r19] + (r9[r19] * this.x[r10]);
        r9[r18] = r110;
        double[] r6 = this.coefficients;
        r6[r18] = r6[r18] + (r110 * r14);
        r18 = r18 - 1;
        goto L19
    L21:
        r10 = r10 + 1;
        r3 = 0;
        goto L12
    L22:
        this.coefficientsComputed = true;
    }

    public static boolean verifyInterpolationArray(double[] r2, double[] r3, boolean r4) throws DimensionMismatchException, NumberIsTooSmallException, NonMonotonicSequenceException {
        if (r2.length != r3.length) goto L11;
        if (r2.length < 2) goto L9;
        return MathArrays.checkOrder(r2, MathArrays.OrderDirection.INCREASING, true, r4);
    L9:
        throw new NumberIsTooSmallException(LocalizedFormats.WRONG_NUMBER_OF_POINTS, 2, Integer.valueOf(r2.length), true);
    L11:
        throw new DimensionMismatchException(r2.length, r3.length);
    }
}
