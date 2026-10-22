package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
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
            double r0 = (this.mD * 3.0d) * r7;
            return (((this.mC * 2.0d) + r0) * r7) + this.mB;
        }
    }

    public HyperSpline(double[][] r1) {
        setup(r1);
    }

    public static Cubic[] calcNaturalCubic(int r23, double[] r24) {
        double[] r1 = new double[r23];
        double[] r2 = new double[r23];
        double[] r3 = new double[r23];
        int r4 = r23 - 1;
        int r7 = 0;
        r1[0] = 0.5d;
        int r5 = 1;
        int r6 = 1;
    L4:
        if (r6 >= r4) goto L6;
        r1[r6] = 1.0d / (4.0d - r1[r6 - 1]);
        r6 = r6 + 1;
        goto L4
    L6:
        int r0 = r23 - 2;
        r1[r4] = 1.0d / (2.0d - r1[r0]);
        r2[0] = ((r24[1] - r24[0]) * 3.0d) * r1[0];
    L7:
        if (r5 >= r4) goto L9;
        int r8 = r5 + 1;
        int r14 = r5 - 1;
        r2[r5] = (((r24[r8] - r24[r14]) * 3.0d) - r2[r14]) * r1[r5];
        r5 = r8;
        goto L7
    L9:
        double r9 = (((r24[r4] - r24[r0]) * 3.0d) - r2[r0]) * r1[r4];
        r2[r4] = r9;
        r3[r4] = r9;
    L10:
        if (r0 < 0) goto L12;
        r3[r0] = r2[r0] - (r1[r0] * r3[r0 + 1]);
        r0 = r0 - 1;
        goto L10
    L12:
        Cubic[] r10 = new Cubic[r4];
    L13:
        if (r7 >= r4) goto L15;
        double r11 = r24[r7];
        double r17 = r3[r7];
        int r12 = r7 + 1;
        double r15 = r24[r12];
        double r21 = r3[r12];
        r10[r7] = new Cubic((float) r11, r17, (((r15 - r11) * 3.0d) - (r17 * 2.0d)) - r21, (((r11 - r15) * 2.0d) + r17) + r21);
        r7 = r12;
        goto L13
    L15:
        return r10;
    }

    public double approxLength(Cubic[] r15) {
        int r14 = r15.length;
        double[] r16 = new double[r15.length];
        double r0 = 0.0d;
        double r2 = 0.0d;
        double r4 = 0.0d;
    L3:
        int r9 = 0;
        if (r2 >= 1.0d) goto L14;
        double r6 = 0.0d;
    L7:
        if (r9 >= r15.length) goto L10;
        double r10 = r16[r9];
        double r12 = r15[r9].eval(r2);
        r16[r9] = r12;
        double r11 = r10 - r12;
        r6 = r6 + (r11 * r11);
        r9 = r9 + 1;
        goto L7
    L10:
        if (r2 <= 0.0d) goto L12;
        r4 = r4 + Math.sqrt(r6);
    L12:
        r2 = r2 + 0.1d;
    L14:
        if (r9 >= r15.length) goto L17;
        double r3 = r16[r9];
        double r13 = r15[r9].eval(1.0d);
        r16[r9] = r13;
        double r5 = r3 - r13;
        r0 = r0 + (r5 * r5);
        r9 = r9 + 1;
        goto L14
    L17:
        return Math.sqrt(r0) + r4;
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

    public HyperSpline() {
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
}
