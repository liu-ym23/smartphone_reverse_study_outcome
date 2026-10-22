package com.obric.oui.constraintlayout.core.motion.utils;

/* JADX INFO: loaded from: classes3.dex */
public class LinearCurveFit extends CurveFit {
    private static final String TAG = "LinearCurveFit";
    private boolean mExtrapolate;
    double[] mSlopeTemp;
    private double[] mT;
    private double mTotalLength;
    private double[][] mY;

    public LinearCurveFit(double[] r11, double[][] r12) {
        this.mTotalLength = Double.NaN;
        this.mExtrapolate = true;
        int r1 = r12[0].length;
        this.mSlopeTemp = new double[r1];
        this.mT = r11;
        this.mY = r12;
        if (r1 <= 2) goto L16;
        int r3 = 0;
        double r4 = 0.0d;
    L5:
        double r6 = r4;
        if (r3 >= r11.length) goto L11;
        double r8 = r12[r3][0];
        if (r3 <= 0) goto L10;
        Math.hypot(r8 - r4, r8 - r6);
    L10:
        r3 = r3 + 1;
        r4 = r8;
        goto L5
    L11:
        this.mTotalLength = 0.0d;
        return;
    }

    private double getLength2D(double r21) {
        if (Double.isNaN(this.mTotalLength) == false) goto L5;
        return 0.0d;
    L5:
        double[] r1 = this.mT;
        int r4 = r1.length;
        if (r21 > r1[0]) goto L8;
        return 0.0d;
    L8:
        int r5 = r4 - 1;
        if (r21 >= r1[r5]) goto L11;
        double r7 = 0.0d;
        double r9 = 0.0d;
        double r11 = 0.0d;
        int r2 = 0;
    L13:
        if (r2 >= r5) goto L25;
        double[] r13 = this.mY[r2];
        double r14 = r13[0];
        double r16 = r13[1];
        if (r2 <= 0) goto L17;
        r7 = r7 + Math.hypot(r14 - r9, r16 - r11);
    L17:
        double[] r10 = this.mT;
        double r12 = r10[r2];
        if (r21 == r12) goto L19;
        int r15 = r2 + 1;
        double r18 = r10[r15];
        if (r21 < r18) goto L22;
        r2 = r15;
        r9 = r14;
        r11 = r16;
        goto L13
    L22:
        double r3 = (r21 - r12) / (r18 - r12);
        double[][] r0 = this.mY;
        double[] r6 = r0[r2];
        double r17 = r6[0];
        double[] r8 = r0[r15];
        double r19 = r8[0];
        double r110 = 1.0d - r3;
        return r7 + Math.hypot(r16 - ((r6[1] * r110) + (r8[1] * r3)), r14 - ((r17 * r110) + (r19 * r3)));
    L19:
        return r7;
    L25:
        return 0.0d;
    L11:
        return this.mTotalLength;
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double r13, double[] r15) {
        double[] r0 = this.mT;
        int r1 = r0.length;
        int r3 = 0;
        int r2 = this.mY[0].length;
        if (this.mExtrapolate == false) goto L17;
        double r4 = r0[0];
        if (r13 > r4) goto L10;
        getSlope(r4, this.mSlopeTemp);
        int r5 = 0;
    L7:
        if (r5 >= r2) goto L9;
        r15[r5] = this.mY[0][r5] + ((r13 - this.mT[0]) * this.mSlopeTemp[r5]);
        r5 = r5 + 1;
        goto L7
    L9:
        return;
    L10:
        int r6 = r1 - 1;
        double r7 = r0[r6];
        if (r13 < r7) goto L27;
        getSlope(r7, this.mSlopeTemp);
    L13:
        if (r3 >= r2) goto L15;
        r15[r3] = this.mY[r6][r3] + ((r13 - this.mT[r6]) * this.mSlopeTemp[r3]);
        r3 = r3 + 1;
        goto L13
    L15:
        return;
    L27:
        int r8 = 0;
    L29:
        if (r8 >= (r1 - 1)) goto L42;
        if (r13 != this.mT[r8]) goto L35;
        int r9 = 0;
    L33:
        if (r9 >= r2) goto L35;
        r15[r9] = this.mY[r8][r9];
        r9 = r9 + 1;
    L35:
        double[] r10 = this.mT;
        int r11 = r8 + 1;
        double r12 = r10[r11];
        if (r13 < r12) goto L37;
        r8 = r11;
        goto L29
    L37:
        double r14 = r10[r8];
        double r16 = (r13 - r14) / (r12 - r14);
    L38:
        if (r3 >= r2) goto L40;
        double[][] r17 = this.mY;
        r15[r3] = (r17[r8][r3] * (1.0d - r16)) + (r17[r11][r3] * r16);
        r3 = r3 + 1;
        goto L38
    L40:
        return;
    L42:
        return;
    L17:
        if (r13 > r0[0]) goto L22;
        int r18 = 0;
    L19:
        if (r18 >= r2) goto L21;
        r15[r18] = this.mY[0][r18];
        r18 = r18 + 1;
        goto L19
    L21:
        return;
    L22:
        int r19 = r1 - 1;
        if (r13 < r0[r19]) goto L27;
    L24:
        if (r3 >= r2) goto L26;
        r15[r3] = this.mY[r19][r3];
        r3 = r3 + 1;
        goto L24
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double r13, float[] r15) {
        double[] r0 = this.mT;
        int r1 = r0.length;
        int r3 = 0;
        int r2 = this.mY[0].length;
        if (this.mExtrapolate == false) goto L17;
        double r4 = r0[0];
        if (r13 > r4) goto L10;
        getSlope(r4, this.mSlopeTemp);
        int r5 = 0;
    L7:
        if (r5 >= r2) goto L9;
        r15[r5] = (float) (this.mY[0][r5] + ((r13 - this.mT[0]) * this.mSlopeTemp[r5]));
        r5 = r5 + 1;
        goto L7
    L9:
        return;
    L10:
        int r6 = r1 - 1;
        double r7 = r0[r6];
        if (r13 < r7) goto L27;
        getSlope(r7, this.mSlopeTemp);
    L13:
        if (r3 >= r2) goto L15;
        r15[r3] = (float) (this.mY[r6][r3] + ((r13 - this.mT[r6]) * this.mSlopeTemp[r3]));
        r3 = r3 + 1;
        goto L13
    L15:
        return;
    L27:
        int r8 = 0;
    L29:
        if (r8 >= (r1 - 1)) goto L42;
        if (r13 != this.mT[r8]) goto L35;
        int r9 = 0;
    L33:
        if (r9 >= r2) goto L35;
        r15[r9] = (float) this.mY[r8][r9];
        r9 = r9 + 1;
    L35:
        double[] r10 = this.mT;
        int r11 = r8 + 1;
        double r12 = r10[r11];
        if (r13 < r12) goto L37;
        r8 = r11;
        goto L29
    L37:
        double r14 = r10[r8];
        double r16 = (r13 - r14) / (r12 - r14);
    L38:
        if (r3 >= r2) goto L40;
        double[][] r17 = this.mY;
        r15[r3] = (float) ((r17[r8][r3] * (1.0d - r16)) + (r17[r11][r3] * r16));
        r3 = r3 + 1;
        goto L38
    L40:
        return;
    L42:
        return;
    L17:
        if (r13 > r0[0]) goto L22;
        int r18 = 0;
    L19:
        if (r18 >= r2) goto L21;
        r15[r18] = (float) this.mY[0][r18];
        r18 = r18 + 1;
        goto L19
    L21:
        return;
    L22:
        int r19 = r1 - 1;
        if (r13 < r0[r19]) goto L27;
    L24:
        if (r3 >= r2) goto L26;
        r15[r3] = (float) this.mY[r19][r3];
        r3 = r3 + 1;
        goto L24
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double r9, int r11) {
        double[] r0 = this.mT;
        int r1 = r0.length;
        int r3 = 0;
        if (this.mExtrapolate == false) goto L13;
        double r4 = r0[0];
        if (r9 <= r4) goto L7;
        int r2 = r1 - 1;
        double r5 = r0[r2];
        if (r9 < r5) goto L21;
        return this.mY[r2][r11] + ((r9 - r5) * getSlope(r5, r11));
    L21:
        if (r3 >= (r1 - 1)) goto L31;
        double[] r6 = this.mT;
        double r7 = r6[r3];
        if (r9 == r7) goto L25;
        int r8 = r3 + 1;
        double r10 = r6[r8];
        if (r9 < r10) goto L28;
        r3 = r8;
        goto L21
    L28:
        double r12 = (r9 - r7) / (r10 - r7);
        double[][] r13 = this.mY;
        return (r13[r3][r11] * (1.0d - r12)) + (r13[r8][r11] * r12);
    L25:
        return this.mY[r3][r11];
    L31:
        return 0.0d;
    L7:
        return this.mY[0][r11] + ((r9 - r4) * getSlope(r4, r11));
    L13:
        if (r9 <= r0[0]) goto L15;
        int r14 = r1 - 1;
        if (r9 < r0[r14]) goto L21;
        return this.mY[r14][r11];
    L15:
        return this.mY[0][r11];
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.CurveFit
    public void getSlope(double r11, double[] r13) {
        double[] r0 = this.mT;
        int r1 = r0.length;
        int r3 = 0;
        int r2 = this.mY[0].length;
        double r4 = r0[0];
        if (r11 > r4) goto L5;
    L4:
        r11 = r4;
    L8:
        int r5 = 0;
    L10:
        if (r5 >= (r1 - 1)) goto L17;
        double[] r6 = this.mT;
        int r7 = r5 + 1;
        double r8 = r6[r7];
        if (r11 <= r8) goto L13;
        r5 = r7;
        goto L10
    L13:
        double r9 = r8 - r6[r5];
    L14:
        if (r3 >= r2) goto L21;
        double[][] r12 = this.mY;
        r13[r3] = (r12[r7][r3] - r12[r5][r3]) / r9;
        r3 = r3 + 1;
        goto L14
    L21:
        return;
    L17:
        return;
    L5:
        r4 = r0[r1 - 1];
        if (r11 < r4) goto L8;
        goto L8
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double r8, int r10) {
        double[] r0 = this.mT;
        int r1 = r0.length;
        int r2 = 0;
        double r3 = r0[0];
        if (r8 >= r3) goto L5;
    L4:
        r8 = r3;
    L9:
        if (r2 >= (r1 - 1)) goto L15;
        double[] r4 = this.mT;
        int r5 = r2 + 1;
        double r6 = r4[r5];
        if (r8 <= r6) goto L12;
        r2 = r5;
        goto L9
    L12:
        double r7 = r6 - r4[r2];
        double[][] r9 = this.mY;
        return (r9[r5][r10] - r9[r2][r10]) / r7;
    L15:
        return 0.0d;
    L5:
        r3 = r0[r1 - 1];
        if (r8 < r3) goto L9;
        goto L4
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mT;
    }
}
