package org.apache.commons.math3.analysis.interpolation;

import java.lang.reflect.Array;
import org.apache.commons.math3.analysis.TrivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class TricubicSplineInterpolator implements TrivariateGridInterpolator {
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

    @Override // org.apache.commons.math3.analysis.interpolation.TrivariateGridInterpolator
    public /* bridge */ /* synthetic */ TrivariateFunction interpolate(double[] r1, double[] r2, double[] r3, double[][][] r4) throws NoDataException, NumberIsTooSmallException, DimensionMismatchException, NonMonotonicSequenceException {
        return interpolate(r1, r2, r3, r4);
    }

    public TricubicSplineInterpolator() {
    }

    @Override // org.apache.commons.math3.analysis.interpolation.TrivariateGridInterpolator
    public TricubicSplineInterpolatingFunction interpolate(double[] r33, double[] r34, double[] r35, double[][][] r36) throws NoDataException, NumberIsTooSmallException, DimensionMismatchException, NonMonotonicSequenceException {
        double[] r2 = r34;
        if (r33.length == 0) goto L79;
        if (r2.length == 0) goto L79;
        if (r35.length == 0) goto L79;
        if (r36.length == 0) goto L79;
        if (r33.length != r36.length) goto L77;
        MathArrays.checkOrder(r33);
        MathArrays.checkOrder(r34);
        MathArrays.checkOrder(r35);
        int r5 = r33.length;
        int r6 = r2.length;
        int r7 = r35.length;
        int r8 = 3;
        int r12 = 0;
        double[][][] r9 = (double[][][]) Array.newInstance(Double.TYPE, new int[]{r7, r5, r6});
        double[][][] r13 = (double[][][]) Array.newInstance(Double.TYPE, new int[]{r6, r7, r5});
        int r14 = 0;
    L13:
        if (r14 >= r5) goto L29;
        if (r36[r14].length != r6) goto L28;
        int r15 = r12;
    L17:
        if (r15 >= r6) goto L26;
        if (r36[r14][r15].length != r7) goto L25;
        int r16 = 0;
    L21:
        if (r16 >= r7) goto L23;
        double r18 = r36[r14][r15][r16];
        r9[r16][r14][r15] = r18;
        r13[r15][r16][r14] = r18;
        r16 = r16 + 1;
        goto L21
    L23:
        r15 = r15 + 1;
        goto L17
    L25:
        throw new DimensionMismatchException(r36[r14][r15].length, r7);
    L26:
        r14 = r14 + 1;
        r12 = 0;
        goto L13
    L28:
        throw new DimensionMismatchException(r36[r14].length, r6);
    L29:
        BicubicSplineInterpolator r17 = new BicubicSplineInterpolator(true);
        BicubicSplineInterpolatingFunction[] r19 = new BicubicSplineInterpolatingFunction[r5];
        int r110 = 0;
    L30:
        if (r110 >= r5) goto L32;
        r19[r110] = r17.interpolate(r2, r35, r36[r110]);
        r110 = r110 + 1;
        goto L30
    L32:
        BicubicSplineInterpolatingFunction[] r11 = new BicubicSplineInterpolatingFunction[r6];
        int r111 = 0;
    L33:
        if (r111 >= r6) goto L35;
        r11[r111] = r17.interpolate(r35, r33, r13[r111]);
        r111 = r111 + 1;
        goto L33
    L35:
        BicubicSplineInterpolatingFunction[] r10 = new BicubicSplineInterpolatingFunction[r7];
        int r112 = 0;
    L36:
        if (r112 >= r7) goto L38;
        r10[r112] = r17.interpolate(r33, r2, r9[r112]);
        r112 = r112 + 1;
        goto L36
    L38:
        double[][][] r20 = (double[][][]) Array.newInstance(Double.TYPE, new int[]{r5, r6, r7});
        double[][][] r113 = (double[][][]) Array.newInstance(Double.TYPE, new int[]{r5, r6, r7});
        double[][][] r114 = (double[][][]) Array.newInstance(Double.TYPE, new int[]{r5, r6, r7});
        int r115 = 0;
    L39:
        if (r115 >= r7) goto L47;
        BicubicSplineInterpolatingFunction r21 = r10[r115];
        BicubicSplineInterpolatingFunction[] r22 = r10;
        int r116 = 0;
    L41:
        if (r116 >= r5) goto L46;
        double r3 = r33[r116];
        int r0 = 0;
    L43:
        if (r0 >= r6) goto L45;
        int r23 = r5;
        double r24 = r2[r0];
        r20[r116][r0][r115] = r21.partialDerivativeX(r3, r24);
        r113[r116][r0][r115] = r21.partialDerivativeY(r3, r24);
        r114[r116][r0][r115] = r21.partialDerivativeXY(r3, r24);
        r0 = r0 + 1;
        r6 = r6;
        r5 = r23;
        goto L43
    L45:
        r116 = r116 + 1;
        goto L41
    L46:
        r115 = r115 + 1;
        r10 = r22;
        r8 = 3;
        goto L39
    L47:
        int r25 = r5;
        int r26 = r6;
        int r1 = r8;
        int[] r4 = new int[r1];
        r4[2] = r7;
        r4[1] = r26;
        r4[0] = r25;
        double[][][] r27 = (double[][][]) Array.newInstance(Double.TYPE, r4);
        int[] r28 = new int[r1];
        r28[2] = r7;
        r28[1] = r26;
        r28[0] = r25;
        double[][][] r117 = (double[][][]) Array.newInstance(Double.TYPE, r28);
        int r29 = 0;
    L48:
        if (r29 >= r25) goto L56;
        BicubicSplineInterpolatingFunction r30 = r19[r29];
        int r31 = r26;
        int r32 = 0;
    L50:
        if (r32 >= r31) goto L55;
        BicubicSplineInterpolatingFunction[] r210 = r19;
        double r118 = r2[r32];
        double[][][] r211 = r114;
        int r119 = 0;
    L52:
        if (r119 >= r7) goto L54;
        double r37 = r35[r119];
        r27[r29][r32][r119] = r30.partialDerivativeY(r118, r37);
        r117[r29][r32][r119] = r30.partialDerivativeXY(r118, r37);
        r119 = r119 + 1;
        goto L52
    L54:
        r32 = r32 + 1;
        r2 = r34;
        r19 = r210;
        r114 = r211;
        goto L50
    L55:
        r29 = r29 + 1;
        r2 = r34;
        r26 = r31;
        goto L48
    L56:
        int r38 = r26;
        double[][][] r212 = r114;
        double[][][] r120 = (double[][][]) Array.newInstance(Double.TYPE, new int[]{r25, r38, r7});
        int r121 = 0;
    L57:
        if (r121 >= r38) goto L65;
        BicubicSplineInterpolatingFunction r39 = r11[r121];
        int r40 = 0;
    L59:
        if (r40 >= r7) goto L64;
        double r41 = r35[r40];
        int r42 = 0;
    L61:
        if (r42 >= r25) goto L63;
        r120[r42][r121][r40] = r39.partialDerivativeXY(r41, r33[r42]);
        r42 = r42 + 1;
        r11 = r11;
        r117 = r117;
        goto L61
    L63:
        r40 = r40 + 1;
        goto L59
    L64:
        r121 = r121 + 1;
        goto L57
    L65:
        double[][][] r213 = r117;
        int r122 = 0;
        double[][][] r123 = (double[][][]) Array.newInstance(Double.TYPE, new int[]{r25, r38, r7});
        int r43 = 0;
    L66:
        if (r43 >= r25) goto L75;
        int r44 = nextIndex(r43, r25);
        int r45 = previousIndex(r43);
        int r46 = r122;
    L68:
        if (r46 >= r38) goto L73;
        int r124 = nextIndex(r46, r38);
        int r125 = previousIndex(r46);
    L70:
        if (r122 >= r7) goto L72;
        int r126 = nextIndex(r122, r7);
        int r127 = previousIndex(r122);
        double[] r214 = r123[r43][r46];
        double[][] r215 = r36[r44];
        double[] r216 = r215[r124];
        double r217 = r216[r126];
        double[] r218 = r215[r125];
        double r219 = r217 - r218[r126];
        double[][] r220 = r36[r45];
        double[] r221 = r220[r124];
        double r222 = r219 - r221[r126];
        double[] r223 = r220[r125];
        r214[r122] = (((((r222 + r223[r126]) - r216[r127]) + r218[r127]) + r221[r127]) - r223[r127]) / (((r33[r44] - r33[r45]) * (r34[r124] - r34[r125])) * (r35[r126] - r35[r127]));
        r122 = r122 + 1;
        r38 = r38;
        goto L70
    L72:
        r46 = r46 + 1;
        r38 = r38;
        r122 = 0;
        goto L68
    L73:
        r43 = r43 + 1;
        r38 = r38;
        r122 = 0;
        goto L66
    L75:
        return new TricubicSplineInterpolatingFunction(r33, r34, r35, r36, r20, r113, r27, r212, r120, r213, r123);
    L77:
        throw new DimensionMismatchException(r33.length, r36.length);
    L79:
        throw new NoDataException();
    }
}
