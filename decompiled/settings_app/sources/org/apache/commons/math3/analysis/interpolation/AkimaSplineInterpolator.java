package org.apache.commons.math3.analysis.interpolation;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class AkimaSplineInterpolator implements UnivariateInterpolator {
    private static final int MINIMUM_NUMBER_POINTS = 5;

    public AkimaSplineInterpolator() {
    }

    @Override // org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator
    public /* bridge */ /* synthetic */ UnivariateFunction interpolate(double[] r1, double[] r2) throws MathIllegalArgumentException, DimensionMismatchException {
        return interpolate(r1, r2);
    }

    @Override // org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator
    public PolynomialSplineFunction interpolate(double[] r21, double[] r22) throws DimensionMismatchException, NumberIsTooSmallException, NonMonotonicSequenceException {
        if (r21 == null) goto L32;
        if (r22 == null) goto L32;
        if (r21.length != r22.length) goto L30;
        if (r21.length < 5) goto L28;
        MathArrays.checkOrder(r21);
        int r0 = r21.length - 1;
        double[] r1 = new double[r0];
        double[] r2 = new double[r0];
        int r3 = 0;
    L10:
        if (r3 >= r0) goto L12;
        int r4 = r3 + 1;
        r1[r3] = (r22[r4] - r22[r3]) / (r21[r4] - r21[r3]);
        r3 = r4;
        goto L10
    L12:
        int r5 = 1;
    L13:
        if (r5 >= r0) goto L15;
        r2[r5] = FastMath.abs(r1[r5] - r1[r5 - 1]);
        r5 = r5 + 1;
        goto L13
    L15:
        int r6 = r21.length;
        double[] r11 = new double[r6];
        int r7 = 2;
    L17:
        if (r7 >= (r6 - 2)) goto L25;
        int r8 = r7 + 1;
        double r9 = r2[r8];
        int r13 = r7 - 1;
        double r14 = r2[r13];
        if (Precision.equals(r9, 0.0d) == true) goto L21;
    L23:
        r11[r7] = ((r1[r13] * r9) + (r1[r7] * r14)) / (r9 + r14);
    L24:
        r7 = r8;
        goto L17
    L21:
        if (Precision.equals(r14, 0.0d) == false) goto L23;
        double r10 = r21[r7];
        double r12 = r21[r8];
        double r15 = r21[r13];
        r11[r7] = (((r12 - r10) * r1[r13]) + ((r10 - r15) * r1[r7])) / (r12 - r15);
        goto L24
    L25:
        r11[0] = differentiateThreePoint(r21, r22, 0, 0, 1, 2);
        r11[1] = differentiateThreePoint(r21, r22, 1, 0, 1, 2);
        r11[r21.length - 2] = differentiateThreePoint(r21, r22, r21.length - 2, r21.length - 3, r21.length - 2, r21.length - 1);
        r11[r21.length - 1] = differentiateThreePoint(r21, r22, r21.length - 1, r21.length - 3, r21.length - 2, r21.length - 1);
        return interpolateHermiteSorted(r21, r22, r11);
    L28:
        throw new NumberIsTooSmallException(LocalizedFormats.NUMBER_OF_POINTS, Integer.valueOf(r21.length), 5, true);
    L30:
        throw new DimensionMismatchException(r21.length, r22.length);
    L32:
        throw new NullArgumentException();
    }

    private double differentiateThreePoint(double[] r9, double[] r10, int r11, int r12, int r13, int r14) {
        double r0 = r10[r12];
        double r2 = r10[r13];
        double r4 = r10[r14];
        double r15 = r9[r11];
        double r6 = r9[r12];
        double r16 = r15 - r6;
        double r17 = r9[r13] - r6;
        double r8 = r9[r14] - r6;
        double r3 = r2 - r0;
        double r5 = ((r4 - r0) - ((r8 / r17) * r3)) / ((r8 * r8) - (r8 * r17));
        double r7 = (r3 - ((r5 * r17) * r17)) / r17;
        return ((r5 * 2.0d) * r16) + r7;
    }

    private PolynomialSplineFunction interpolateHermiteSorted(double[] r30, double[] r31, double[] r32) {
        if (r30.length != r31.length) goto L18;
        if (r30.length != r32.length) goto L16;
        if (r30.length < 2) goto L14;
        int r3 = r30.length - 1;
        PolynomialFunction[] r6 = new PolynomialFunction[r3];
        double[] r7 = new double[4];
        int r9 = 0;
    L9:
        if (r9 >= r3) goto L12;
        int r10 = r9 + 1;
        double r11 = r30[r10] - r30[r9];
        double r15 = r31[r9];
        double r17 = r31[r10];
        double r19 = r32[r9];
        double r21 = r32[r10];
        r7[0] = r15;
        r7[1] = r32[r9];
        r7[2] = (((((r17 - r15) * 3.0d) / r11) - (r19 * 2.0d)) - r21) / r11;
        r7[3] = (((((r15 - r17) * 2.0d) / r11) + r19) + r21) / (r11 * r11);
        r6[r9] = new PolynomialFunction(r7);
        r9 = r10;
        goto L9
    L12:
        return new PolynomialSplineFunction(r30, r6);
    L14:
        throw new NumberIsTooSmallException(LocalizedFormats.NUMBER_OF_POINTS, Integer.valueOf(r30.length), 2, true);
    L16:
        throw new DimensionMismatchException(r30.length, r32.length);
    L18:
        throw new DimensionMismatchException(r30.length, r31.length);
    }
}
