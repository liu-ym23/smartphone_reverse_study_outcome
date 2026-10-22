package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class MonotonicCurveFit extends CurveFit {
    private static final String TAG = "MonotonicCurveFit";
    private boolean mExtrapolate;
    double[] mSlopeTemp;
    private double[] mT;
    private double[][] mTangent;
    private double[][] mY;

    public MonotonicCurveFit(double[] r22, double[][] r23) {
        this.mExtrapolate = true;
        int r5 = r22.length;
        int r7 = r23[0].length;
        this.mSlopeTemp = new double[r7];
        int r8 = r5 - 1;
        double[][] r10 = (double[][]) Array.newInstance(double.class, new int[]{r8, r7});
        double[][] r3 = (double[][]) Array.newInstance(double.class, new int[]{r5, r7});
        int r4 = 0;
    L3:
        if (r4 >= r7) goto L12;
        int r11 = 0;
    L5:
        if (r11 >= r8) goto L11;
        int r12 = r11 + 1;
        r10[r11][r4] = (r23[r12][r4] - r23[r11][r4]) / (r22[r12] - r22[r11]);
        if (r11 != 0) goto L9;
        r3[r11][r4] = r10[r11][r4];
    L10:
        r11 = r12;
        goto L5
    L9:
        r3[r11][r4] = (r10[r11 - 1][r4] + r10[r11][r4]) * 0.5d;
        goto L10
    L11:
        r3[r8][r4] = r10[r5 - 2][r4];
        r4 = r4 + 1;
        goto L3
    L12:
        int r6 = 0;
    L13:
        if (r6 >= r8) goto L24;
        int r9 = 0;
    L15:
        if (r9 >= r7) goto L23;
        if (r10[r6][r9] != 0.0d) goto L19;
        r3[r6][r9] = 0.0d;
        r3[r6 + 1][r9] = 0.0d;
    L22:
        r9 = r9 + 1;
        goto L15
    L19:
        double r13 = r3[r6][r9] / r10[r6][r9];
        int r14 = r6 + 1;
        double r15 = r3[r14][r9] / r10[r6][r9];
        double r16 = Math.hypot(r13, r15);
        if (r16 <= 9.0d) goto L22;
        double r17 = 3.0d / r16;
        r3[r6][r9] = (r13 * r17) * r10[r6][r9];
        r3[r14][r9] = (r17 * r15) * r10[r6][r9];
        goto L22
    L23:
        r6 = r6 + 1;
        goto L13
    L24:
        this.mT = r22;
        this.mY = r23;
        this.mTangent = r3;
    }

    public static MonotonicCurveFit buildWave(String r8) {
        double[] r0 = new double[r8.length() / 2];
        int r1 = r8.indexOf(40) + 1;
        int r3 = r8.indexOf(44, r1);
        int r4 = 0;
    L4:
        if (r3 == (-1)) goto L6;
        r0[r4] = Double.parseDouble(r8.substring(r1, r3).trim());
        r1 = r3 + 1;
        r3 = r8.indexOf(44, r1);
        r4 = r4 + 1;
        goto L4
    L6:
        String r9 = r8.substring(r1, r8.indexOf(41, r1)).trim();
        r0[r4] = Double.parseDouble(r9);
        return buildWave(Arrays.copyOf(r0, r4 + 1));
    }

    private static MonotonicCurveFit buildWave(double[] r18) {
        int r1 = (r18.length * 3) - 2;
        int r3 = r18.length - 1;
        double r5 = 1.0d / ((double) r3);
        double[][] r2 = (double[][]) Array.newInstance(double.class, new int[]{r1, 1});
        double[] r4 = new double[r1];
        int r9 = 0;
    L4:
        if (r9 >= r18.length) goto L10;
        double r10 = r18[r9];
        int r12 = r9 + r3;
        r2[r12][0] = r10;
        double r13 = ((double) r9) * r5;
        r4[r12] = r13;
        if (r9 <= 0) goto L8;
        int r14 = (r3 * 2) + r9;
        r2[r14][0] = r10 + 1.0d;
        r4[r14] = r13 + 1.0d;
        int r15 = r9 - 1;
        r2[r15][0] = (r10 - 1.0d) - r5;
        r4[r15] = (r13 - 1.0d) - r5;
    L8:
        r9 = r9 + 1;
        goto L4
    L10:
        return new MonotonicCurveFit(r4, r2);
    }

    private static double diff(double r10, double r12, double r14, double r16, double r18, double r20) {
        double r0 = r12 * r12;
        double r6 = r12 * 6.0d;
        double r2 = (((((-6.0d) * r0) * r16) + (r6 * r16)) + ((6.0d * r0) * r14)) - (r6 * r14);
        double r4 = 3.0d * r10;
        return ((((r2 + ((r4 * r20) * r0)) + ((r4 * r18) * r0)) - (((2.0d * r10) * r20) * r12)) - (((4.0d * r10) * r18) * r12)) + (r10 * r18);
    }

    private static double interpolate(double r12, double r14, double r16, double r18, double r20, double r22) {
        double r0 = r14 * r14;
        double r2 = r0 * r14;
        double r6 = 3.0d * r0;
        double r4 = ((((((-2.0d) * r2) * r18) + (r6 * r18)) + ((r2 * 2.0d) * r16)) - (r6 * r16)) + r16;
        double r7 = r12 * r22;
        double r5 = r4 + (r7 * r2);
        double r10 = r12 * r20;
        return (((r5 + (r2 * r10)) - (r7 * r0)) - (((r12 * 2.0d) * r20) * r0)) + (r10 * r14);
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double r23, int r25) {
        double[] r2 = this.mT;
        int r3 = r2.length;
        int r5 = 0;
        if (this.mExtrapolate == false) goto L13;
        if (r23 <= r2[0]) goto L7;
        int r4 = r3 - 1;
        if (r23 < r2[r4]) goto L21;
        return this.mY[r4][r25] + ((r23 - r2[r4]) * getSlope(r2[r4], r25));
    L21:
        if (r5 >= (r3 - 1)) goto L31;
        double[] r6 = this.mT;
        if (r23 == r6[r5]) goto L25;
        int r7 = r5 + 1;
        if (r23 < r6[r7]) goto L28;
        r5 = r7;
        goto L21
    L28:
        double r10 = r6[r7] - r6[r5];
        double r12 = (r23 - r6[r5]) / r10;
        double[][] r8 = this.mY;
        double r14 = r8[r5][r25];
        double r16 = r8[r7][r25];
        double[][] r0 = this.mTangent;
        return interpolate(r10, r12, r14, r16, r0[r5][r25], r0[r7][r25]);
    L25:
        return this.mY[r5][r25];
    L31:
        return 0.0d;
    L7:
        return this.mY[0][r25] + ((r23 - r2[0]) * getSlope(r2[0], r25));
    L13:
        if (r23 <= r2[0]) goto L15;
        int r9 = r3 - 1;
        if (r23 < r2[r9]) goto L21;
        return this.mY[r9][r25];
    L15:
        return this.mY[0][r25];
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double r24, double[] r26) {
        double[] r1 = this.mT;
        int r2 = r1.length;
        int r4 = 0;
        int r3 = this.mY[0].length;
        if (this.mExtrapolate == false) goto L17;
        if (r24 > r1[0]) goto L10;
        getSlope(r1[0], this.mSlopeTemp);
        int r5 = 0;
    L7:
        if (r5 >= r3) goto L9;
        r26[r5] = this.mY[0][r5] + ((r24 - this.mT[0]) * this.mSlopeTemp[r5]);
        r5 = r5 + 1;
        goto L7
    L9:
        return;
    L10:
        int r6 = r2 - 1;
        if (r24 < r1[r6]) goto L27;
        getSlope(r1[r6], this.mSlopeTemp);
    L13:
        if (r4 >= r3) goto L15;
        r26[r4] = this.mY[r6][r4] + ((r24 - this.mT[r6]) * this.mSlopeTemp[r4]);
        r4 = r4 + 1;
        goto L13
    L15:
        return;
    L27:
        int r7 = 0;
    L29:
        if (r7 >= (r2 - 1)) goto L42;
        if (r24 != this.mT[r7]) goto L35;
        int r8 = 0;
    L33:
        if (r8 >= r3) goto L35;
        r26[r8] = this.mY[r7][r8];
        r8 = r8 + 1;
    L35:
        double[] r9 = this.mT;
        int r10 = r7 + 1;
        if (r24 < r9[r10]) goto L37;
        r7 = r10;
        goto L29
    L37:
        double r11 = r9[r10] - r9[r7];
        double r12 = (r24 - r9[r7]) / r11;
    L38:
        if (r4 >= r3) goto L40;
        double[][] r13 = this.mY;
        double r15 = r13[r7][r4];
        double r17 = r13[r10][r4];
        double[][] r14 = this.mTangent;
        r26[r4] = interpolate(r11, r12, r15, r17, r14[r7][r4], r14[r10][r4]);
        r4 = r4 + 1;
        goto L38
    L40:
        return;
    L42:
        return;
    L17:
        if (r24 > r1[0]) goto L22;
        int r16 = 0;
    L19:
        if (r16 >= r3) goto L21;
        r26[r16] = this.mY[0][r16];
        r16 = r16 + 1;
        goto L19
    L21:
        return;
    L22:
        int r18 = r2 - 1;
        if (r24 < r1[r18]) goto L27;
    L24:
        if (r4 >= r3) goto L26;
        r26[r4] = this.mY[r18][r4];
        r4 = r4 + 1;
        goto L24
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double r24, float[] r26) {
        double[] r1 = this.mT;
        int r2 = r1.length;
        int r4 = 0;
        int r3 = this.mY[0].length;
        if (this.mExtrapolate == false) goto L17;
        if (r24 > r1[0]) goto L10;
        getSlope(r1[0], this.mSlopeTemp);
        int r5 = 0;
    L7:
        if (r5 >= r3) goto L9;
        r26[r5] = (float) (this.mY[0][r5] + ((r24 - this.mT[0]) * this.mSlopeTemp[r5]));
        r5 = r5 + 1;
        goto L7
    L9:
        return;
    L10:
        int r6 = r2 - 1;
        if (r24 < r1[r6]) goto L27;
        getSlope(r1[r6], this.mSlopeTemp);
    L13:
        if (r4 >= r3) goto L15;
        r26[r4] = (float) (this.mY[r6][r4] + ((r24 - this.mT[r6]) * this.mSlopeTemp[r4]));
        r4 = r4 + 1;
        goto L13
    L15:
        return;
    L27:
        int r7 = 0;
    L29:
        if (r7 >= (r2 - 1)) goto L42;
        if (r24 != this.mT[r7]) goto L35;
        int r8 = 0;
    L33:
        if (r8 >= r3) goto L35;
        r26[r8] = (float) this.mY[r7][r8];
        r8 = r8 + 1;
    L35:
        double[] r9 = this.mT;
        int r10 = r7 + 1;
        if (r24 < r9[r10]) goto L37;
        r7 = r10;
        goto L29
    L37:
        double r11 = r9[r10] - r9[r7];
        double r12 = (r24 - r9[r7]) / r11;
    L38:
        if (r4 >= r3) goto L40;
        double[][] r13 = this.mY;
        double r15 = r13[r7][r4];
        double r17 = r13[r10][r4];
        double[][] r14 = this.mTangent;
        r26[r4] = (float) interpolate(r11, r12, r15, r17, r14[r7][r4], r14[r10][r4]);
        r4 = r4 + 1;
        goto L38
    L40:
        return;
    L42:
        return;
    L17:
        if (r24 > r1[0]) goto L22;
        int r16 = 0;
    L19:
        if (r16 >= r3) goto L21;
        r26[r16] = (float) this.mY[0][r16];
        r16 = r16 + 1;
        goto L19
    L21:
        return;
    L22:
        int r18 = r2 - 1;
        if (r24 < r1[r18]) goto L27;
    L24:
        if (r4 >= r3) goto L26;
        r26[r4] = (float) this.mY[r18][r4];
        r4 = r4 + 1;
        goto L24
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double r24, int r26) {
        double[] r1 = this.mT;
        int r2 = r1.length;
        int r3 = 0;
        if (r24 >= r1[0]) goto L5;
        double r4 = r1[0];
    L10:
        if (r3 >= (r2 - 1)) goto L16;
        double[] r5 = this.mT;
        int r6 = r3 + 1;
        if (r4 <= r5[r6]) goto L13;
        r3 = r6;
        goto L10
    L13:
        double r7 = r5[r6] - r5[r3];
        double r13 = (r4 - r5[r3]) / r7;
        double[][] r8 = this.mY;
        double r15 = r8[r3][r26];
        double r17 = r8[r6][r26];
        double[][] r0 = this.mTangent;
        return diff(r7, r13, r15, r17, r0[r3][r26], r0[r6][r26]) / r7;
    L16:
        return 0.0d;
    L5:
        int r9 = r2 - 1;
        if (r24 < r1[r9]) goto L8;
        r4 = r1[r9];
        goto L10
    L8:
        r4 = r24;
        goto L10
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getSlope(double r26, double[] r28) {
        double[] r1 = this.mT;
        int r2 = r1.length;
        int r4 = 0;
        int r3 = this.mY[0].length;
        if (r26 > r1[0]) goto L5;
        double r5 = r1[0];
    L9:
        int r6 = 0;
    L11:
        if (r6 >= (r2 - 1)) goto L18;
        double[] r7 = this.mT;
        int r8 = r6 + 1;
        if (r5 <= r7[r8]) goto L14;
        r6 = r8;
        goto L11
    L14:
        double r9 = r7[r8] - r7[r6];
        double r10 = (r5 - r7[r6]) / r9;
    L15:
        if (r4 >= r3) goto L22;
        double[][] r11 = this.mY;
        double r17 = r11[r6][r4];
        double r19 = r11[r8][r4];
        double[][] r12 = this.mTangent;
        r28[r4] = diff(r9, r10, r17, r19, r12[r6][r4], r12[r8][r4]) / r9;
        r4 = r4 + 1;
        goto L15
    L22:
        return;
    L18:
        return;
    L5:
        int r13 = r2 - 1;
        if (r26 < r1[r13]) goto L8;
        r5 = r1[r13];
        goto L9
    L8:
        r5 = r26;
        goto L9
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mT;
    }
}
