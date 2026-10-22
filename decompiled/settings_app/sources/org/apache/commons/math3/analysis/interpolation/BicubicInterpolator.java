package org.apache.commons.math3.analysis.interpolation;

import java.lang.reflect.Array;
import org.apache.commons.math3.analysis.BivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class BicubicInterpolator implements BivariateGridInterpolator {
    public BicubicInterpolator() {
    }

    @Override // org.apache.commons.math3.analysis.interpolation.BivariateGridInterpolator
    public /* bridge */ /* synthetic */ BivariateFunction interpolate(double[] r1, double[] r2, double[][] r3) throws NoDataException, DimensionMismatchException, NonMonotonicSequenceException, NumberIsTooSmallException {
        return interpolate(r1, r2, r3);
    }

    @Override // org.apache.commons.math3.analysis.interpolation.BivariateGridInterpolator
    public BicubicInterpolatingFunction interpolate(final double[] r27, final double[] r28, final double[][] r29) throws NoDataException, DimensionMismatchException, NonMonotonicSequenceException, NumberIsTooSmallException {
        if (r27.length == 0) goto L23;
        if (r28.length == 0) goto L23;
        if (r29.length == 0) goto L23;
        if (r27.length != r29.length) goto L21;
        MathArrays.checkOrder(r27);
        MathArrays.checkOrder(r28);
        int r0 = r27.length;
        int r1 = r28.length;
        final double[][] r7 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r0, r1});
        final double[][] r10 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r0, r1});
        final double[][] r11 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r0, r1});
        int r2 = 1;
    L12:
        if (r2 >= (r0 - 1)) goto L19;
        int r3 = r2 + 1;
        int r6 = r2 - 1;
        double r12 = r27[r3] - r27[r6];
        int r14 = 1;
    L15:
        if (r14 >= (r1 - 1)) goto L17;
        int r15 = r14 + 1;
        int r16 = r14 - 1;
        double r17 = r28[r15] - r28[r16];
        double[] r19 = r7[r2];
        double[] r20 = r29[r3];
        double r21 = r20[r14];
        double[] r23 = r29[r6];
        r19[r14] = (r21 - r23[r14]) / r12;
        double[] r110 = r10[r2];
        double[] r22 = r29[r2];
        r110[r14] = (r22[r15] - r22[r16]) / r17;
        r11[r2][r14] = (((r20[r15] - r20[r16]) - r23[r15]) + r23[r16]) / (r17 * r12);
        r14 = r15;
        goto L15
    L17:
        r2 = r3;
        goto L12
    L19:
        return new AnonymousClass1(this, r27, r28, r29, r7, r10, r11, r27, r28);
    L21:
        throw new DimensionMismatchException(r27.length, r29.length);
    L23:
        throw new NoDataException();
    }
}
