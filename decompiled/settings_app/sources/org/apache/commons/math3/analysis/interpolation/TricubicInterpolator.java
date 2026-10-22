package org.apache.commons.math3.analysis.interpolation;

import java.lang.reflect.Array;
import org.apache.commons.math3.analysis.TrivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class TricubicInterpolator implements TrivariateGridInterpolator {
    public TricubicInterpolator() {
    }

    @Override // org.apache.commons.math3.analysis.interpolation.TrivariateGridInterpolator
    public /* bridge */ /* synthetic */ TrivariateFunction interpolate(double[] r1, double[] r2, double[] r3, double[][][] r4) throws NoDataException, NumberIsTooSmallException, DimensionMismatchException, NonMonotonicSequenceException {
        return interpolate(r1, r2, r3, r4);
    }

    @Override // org.apache.commons.math3.analysis.interpolation.TrivariateGridInterpolator
    public TricubicInterpolatingFunction interpolate(final double[] r49, final double[] r50, final double[] r51, final double[][][] r52) throws NoDataException, NumberIsTooSmallException, DimensionMismatchException, NonMonotonicSequenceException {
        double[] r13 = r49;
        if (r13.length == 0) goto L37;
        if (r50.length == 0) goto L37;
        if (r51.length == 0) goto L37;
        if (r52.length == 0) goto L37;
        if (r13.length != r52.length) goto L35;
        MathArrays.checkOrder(r49);
        MathArrays.checkOrder(r50);
        MathArrays.checkOrder(r51);
        int r0 = r13.length;
        int r1 = r50.length;
        int r2 = r51.length;
        int r7 = 1;
        final double[][][] r9 = (double[][][]) Array.newInstance(Double.TYPE, new int[]{r0, r1, r2});
        final double[][][] r10 = (double[][][]) Array.newInstance(Double.TYPE, new int[]{r0, r1, r2});
        final double[][][] r11 = (double[][][]) Array.newInstance(Double.TYPE, new int[]{r0, r1, r2});
        final double[][][] r12 = (double[][][]) Array.newInstance(Double.TYPE, new int[]{r0, r1, r2});
        final double[][][] r17 = (double[][][]) Array.newInstance(Double.TYPE, new int[]{r0, r1, r2});
        final double[][][] r18 = (double[][][]) Array.newInstance(Double.TYPE, new int[]{r0, r1, r2});
        final double[][][] r16 = (double[][][]) Array.newInstance(Double.TYPE, new int[]{r0, r1, r2});
        int r3 = 1;
    L14:
        if (r3 >= (r0 - 1)) goto L33;
        if (r50.length != r52[r3].length) goto L31;
        int r4 = r3 + 1;
        int r6 = r3 - 1;
        double r19 = r13[r4] - r13[r6];
        int r21 = r0;
        int r8 = r7;
    L19:
        if (r8 >= (r1 - 1)) goto L29;
        if (r51.length != r52[r3][r8].length) goto L28;
        int r5 = r8 + 1;
        int r14 = r8 - 1;
        double r24 = r50[r5] - r50[r14];
        double r26 = r19 * r24;
        int r22 = r1;
        int r15 = 1;
    L24:
        if (r15 >= (r2 - 1)) goto L26;
        int r110 = r15 + 1;
        int r28 = r15 - 1;
        double r29 = r51[r110] - r51[r28];
        double[] r31 = r9[r3][r8];
        double[][] r32 = r52[r4];
        double[] r33 = r32[r8];
        double r34 = r33[r15];
        double[][] r36 = r52[r6];
        double[] r37 = r36[r8];
        r31[r15] = (r34 - r37[r15]) / r19;
        double[] r35 = r10[r3][r8];
        double[][] r38 = r52[r3];
        double[] r39 = r38[r5];
        double r310 = r39[r15];
        double[] r40 = r38[r14];
        r35[r15] = (r310 - r40[r15]) / r24;
        double[] r311 = r11[r3][r8];
        double[] r312 = r38[r8];
        r311[r15] = (r312[r110] - r312[r28]) / r29;
        double[] r313 = r12[r3][r8];
        double[] r314 = r32[r5];
        double r43 = r314[r15];
        double[] r315 = r32[r14];
        double r44 = r43 - r315[r15];
        double[] r45 = r36[r5];
        double r46 = r44 - r45[r15];
        double[] r316 = r36[r14];
        r313[r15] = (r46 + r316[r15]) / r26;
        r17[r3][r8][r15] = (((r33[r110] - r33[r28]) - r37[r110]) + r37[r28]) / (r19 * r29);
        r18[r3][r8][r15] = (((r39[r110] - r39[r28]) - r40[r110]) + r40[r28]) / (r24 * r29);
        r16[r3][r8][r15] = (((((((r314[r110] - r315[r110]) - r45[r110]) + r316[r110]) - r314[r28]) + r315[r28]) + r45[r28]) - r316[r28]) / (r29 * r26);
        r15 = r110;
        goto L24
    L26:
        r8 = r5;
        r1 = r22;
        r7 = 1;
        goto L19
    L28:
        throw new DimensionMismatchException(r51.length, r52[r3][r8].length);
    L29:
        r13 = r49;
        r3 = r4;
        r0 = r21;
        goto L14
    L31:
        throw new DimensionMismatchException(r50.length, r52[r3].length);
    L33:
        return new AnonymousClass1(this, r49, r50, r51, r52, r9, r10, r11, r12, r17, r18, r16, r49, r50, r51);
    L35:
        throw new DimensionMismatchException(r49.length, r52.length);
    L37:
        throw new NoDataException();
    }
}
