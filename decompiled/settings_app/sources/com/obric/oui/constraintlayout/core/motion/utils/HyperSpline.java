package com.obric.oui.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes4.dex */
public class HyperSpline {
    double[][] mCtl;
    Cubic[][] mCurve;
    double[] mCurveLength;
    int mDimensionality;
    int mPoints;
    double mTotalLength;

    public static class Cubic {
        double mA;
        double mB;
        double mC;
        double mD;

        public Cubic(double r1, double r3, double r5, double r7) {
            this.mA = r1;
            this.mB = r3;
            this.mC = r5;
            this.mD = r7;
        }

        public double eval(double r5) {
            return (((((this.mD * r5) + this.mC) * r5) + this.mB) * r5) + this.mA;
        }

        public double vel(double r7) {
            return ((((this.mD * 3.0d) * r7) + (this.mC * 2.0d)) * r7) + this.mB;
        }
    }

    public HyperSpline(double[][] r1) {
        setup(r1);
    }

    public HyperSpline() {
    }

    public void setup(double[][] r8) {
        int r1 = r8[0].length;
        this.mDimensionality = r1;
        int r2 = r8.length;
        this.mPoints = r2;
        this.mCtl = (double[][]) Array.newInstance(Double.TYPE, new int[]{r1, r2});
        this.mCurve = new Cubic[this.mDimensionality][];
        int r3 = 0;
    L4:
        if (r3 >= this.mDimensionality) goto L10;
        int r4 = 0;
    L7:
        if (r4 >= this.mPoints) goto L9;
        this.mCtl[r3][r4] = r8[r4][r3];
        r4 = r4 + 1;
        goto L7
    L9:
        r3 = r3 + 1;
        goto L4
    L10:
        int r9 = 0;
    L11:
        int r5 = this.mDimensionality;
        if (r9 >= r5) goto L14;
        Cubic[][] r6 = this.mCurve;
        double[] r7 = this.mCtl[r9];
        r6[r9] = calcNaturalCubic(r7.length, r7);
        r9 = r9 + 1;
        goto L11
    L14:
        this.mCurveLength = new double[this.mPoints - 1];
        this.mTotalLength = 0.0d;
        Cubic[] r10 = new Cubic[r5];
        int r11 = 0;
    L16:
        if (r11 >= this.mCurveLength.length) goto L22;
        int r12 = 0;
    L19:
        if (r12 >= this.mDimensionality) goto L21;
        r10[r12] = this.mCurve[r12][r11];
        r12 = r12 + 1;
        goto L19
    L21:
        double r13 = this.mTotalLength;
        double[] r14 = this.mCurveLength;
        double r15 = approxLength(r10);
        r14[r11] = r15;
        this.mTotalLength = r13 + r15;
        r11 = r11 + 1;
        goto L16
    }

    public void getVelocity(double r6, double[] r8) {
        double r7 = r6 * this.mTotalLength;
        int r0 = 0;
        int r1 = 0;
    L3:
        double[] r2 = this.mCurveLength;
        if (r1 >= (r2.length - 1)) goto L9;
        double r3 = r2[r1];
        if (r3 >= r7) goto L9;
        r7 = r7 - r3;
        r1 = r1 + 1;
    L9:
        if (r0 >= r8.length) goto L11;
        r8[r0] = this.mCurve[r0][r1].vel(r7 / this.mCurveLength[r1]);
        r0 = r0 + 1;
        goto L9
    }

    public void getPos(double r6, double[] r8) {
        double r7 = r6 * this.mTotalLength;
        int r0 = 0;
        int r1 = 0;
    L3:
        double[] r2 = this.mCurveLength;
        if (r1 >= (r2.length - 1)) goto L9;
        double r3 = r2[r1];
        if (r3 >= r7) goto L9;
        r7 = r7 - r3;
        r1 = r1 + 1;
    L9:
        if (r0 >= r8.length) goto L11;
        r8[r0] = this.mCurve[r0][r1].eval(r7 / this.mCurveLength[r1]);
        r0 = r0 + 1;
        goto L9
    }

    public void getPos(double r6, float[] r8) {
        double r7 = r6 * this.mTotalLength;
        int r0 = 0;
        int r1 = 0;
    L3:
        double[] r2 = this.mCurveLength;
        if (r1 >= (r2.length - 1)) goto L9;
        double r3 = r2[r1];
        if (r3 >= r7) goto L9;
        r7 = r7 - r3;
        r1 = r1 + 1;
    L9:
        if (r0 >= r8.length) goto L11;
        r8[r0] = (float) this.mCurve[r0][r1].eval(r7 / this.mCurveLength[r1]);
        r0 = r0 + 1;
        goto L9
    }

    public double getPos(double r6, int r8) {
        double r7 = r6 * this.mTotalLength;
        int r0 = 0;
    L3:
        double[] r1 = this.mCurveLength;
        if (r0 >= (r1.length - 1)) goto L9;
        double r2 = r1[r0];
        if (r2 >= r7) goto L9;
        r7 = r7 - r2;
        r0 = r0 + 1;
    L9:
        return this.mCurve[r8][r0].eval(r7 / r1[r0]);
    }

    public double approxLength(Cubic[] r18) {
        int r1 = r18.length;
        double[] r2 = new double[r1];
        double r3 = 0.0d;
        double r5 = 0.0d;
        double r7 = 0.0d;
    L3:
        int r12 = 0;
        if (r5 >= 1.0d) goto L12;
        double r9 = 0.0d;
    L6:
        if (r12 >= r1) goto L9;
        double r13 = r2[r12];
        double r15 = r18[r12].eval(r5);
        r2[r12] = r15;
        double r14 = r13 - r15;
        r9 = r9 + (r14 * r14);
        r12 = r12 + 1;
        goto L6
    L9:
        if (r5 <= 0.0d) goto L11;
        r7 = r7 + Math.sqrt(r9);
    L11:
        r5 = r5 + 0.1d;
    L12:
        if (r12 >= r1) goto L15;
        double r6 = r2[r12];
        double r16 = r18[r12].eval(1.0d);
        r2[r12] = r16;
        double r8 = r6 - r16;
        r3 = r3 + (r8 * r8);
        r12 = r12 + 1;
        goto L12
    L15:
        return r7 + Math.sqrt(r3);
    }

    static Cubic[] calcNaturalCubic(int r24, double[] r25) {
        double[] r1 = new double[r24];
        double[] r2 = new double[r24];
        double[] r3 = new double[r24];
        int r0 = r24 - 1;
        int r6 = 0;
        r1[0] = 0.5d;
        int r4 = 1;
        int r5 = 1;
    L4:
        if (r5 >= r0) goto L6;
        r1[r5] = 1.0d / (4.0d - r1[r5 - 1]);
        r5 = r5 + 1;
        goto L4
    L6:
        int r7 = r0 - 1;
        r1[r0] = 1.0d / (2.0d - r1[r7]);
        r2[0] = ((r25[1] - r25[0]) * 3.0d) * r1[0];
    L7:
        if (r4 >= r0) goto L9;
        int r8 = r4 + 1;
        int r9 = r4 - 1;
        r2[r4] = (((r25[r8] - r25[r9]) * 3.0d) - r2[r9]) * r1[r4];
        r4 = r8;
        goto L7
    L9:
        double r10 = (((r25[r0] - r25[r7]) * 3.0d) - r2[r7]) * r1[r0];
        r2[r0] = r10;
        r3[r0] = r10;
    L10:
        if (r7 < 0) goto L12;
        r3[r7] = r2[r7] - (r1[r7] * r3[r7 + 1]);
        r7 = r7 - 1;
        goto L10
    L12:
        Cubic[] r11 = new Cubic[r0];
    L13:
        if (r6 >= r0) goto L15;
        double r12 = r25[r6];
        double r16 = r3[r6];
        int r13 = r6 + 1;
        double r18 = r25[r13];
        double r22 = r3[r13];
        r11[r6] = new Cubic((float) r12, r16, (((r18 - r12) * 3.0d) - (r16 * 2.0d)) - r22, (((r12 - r18) * 2.0d) + r16) + r22);
        r6 = r13;
        goto L13
    L15:
        return r11;
    }
}
