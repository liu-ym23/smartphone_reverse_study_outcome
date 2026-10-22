package org.apache.commons.math3.analysis.interpolation;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class SplineInterpolator implements UnivariateInterpolator {
    public SplineInterpolator() {
    }

    @Override // org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator
    public /* bridge */ /* synthetic */ UnivariateFunction interpolate(double[] r1, double[] r2) throws MathIllegalArgumentException, DimensionMismatchException {
        return interpolate(r1, r2);
    }

    @Override // org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator
    public PolynomialSplineFunction interpolate(double[] r30, double[] r31) throws DimensionMismatchException, NumberIsTooSmallException, NonMonotonicSequenceException {
        if (r30.length != r31.length) goto L24;
        if (r30.length < 3) goto L22;
        int r2 = r30.length - 1;
        MathArrays.checkOrder(r30);
        double[] r5 = new double[r2];
        int r7 = 0;
    L7:
        if (r7 >= r2) goto L9;
        int r8 = r7 + 1;
        r5[r7] = r30[r8] - r30[r7];
        r7 = r8;
        goto L7
    L9:
        double[] r9 = new double[r2];
        int r10 = r2 + 1;
        double[] r11 = new double[r10];
        r9[0] = 0.0d;
        r11[0] = 0.0d;
        int r12 = 1;
    L11:
        if (r12 >= r2) goto L13;
        int r17 = r12 + 1;
        int r20 = r12 - 1;
        double r18 = ((r30[r17] - r30[r20]) * 2.0d) - (r5[r20] * r9[r20]);
        r9[r12] = r5[r12] / r18;
        double r13 = r31[r17];
        double r21 = r5[r20];
        double r14 = (r13 * r21) - (r31[r12] * (r30[r17] - r30[r20]));
        double r23 = r31[r20];
        double r25 = r5[r12];
        r11[r12] = ((((r14 + (r23 * r25)) * 3.0d) / (r25 * r21)) - (r21 * r11[r20])) / r18;
        r12 = r17;
        goto L11
    L13:
        double[] r15 = new double[r2];
        double[] r16 = new double[r10];
        double[] r3 = new double[r2];
        r11[r2] = 0.0d;
        r16[r2] = 0.0d;
        int r19 = r2 - 1;
    L14:
        if (r19 < 0) goto L16;
        int r110 = r19 + 1;
        double r111 = r11[r19] - (r9[r19] * r16[r110]);
        r16[r19] = r111;
        double r112 = r31[r110] - r31[r19];
        double r22 = r5[r19];
        r15[r19] = (r112 / r22) - ((r22 * (r16[r110] + (r111 * 2.0d))) / 3.0d);
        r3[r19] = (r16[r110] - r16[r19]) / (r5[r19] * 3.0d);
        r19 = r19 - 1;
        goto L14
    L16:
        PolynomialFunction[] r6 = new PolynomialFunction[r2];
        double[] r24 = new double[4];
        int r26 = 0;
    L17:
        if (r26 >= r2) goto L20;
        r24[0] = r31[r26];
        r24[1] = r15[r26];
        r24[2] = r16[r26];
        r24[3] = r3[r26];
        r6[r26] = new PolynomialFunction(r24);
        r26 = r26 + 1;
        goto L17
    L20:
        return new PolynomialSplineFunction(r30, r6);
    L22:
        throw new NumberIsTooSmallException(LocalizedFormats.NUMBER_OF_POINTS, Integer.valueOf(r30.length), 3, true);
    L24:
        throw new DimensionMismatchException(r30.length, r31.length);
    }
}
