package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class Oscillator {
    public static final int BOUNCE = 6;
    public static final int COS_WAVE = 5;
    public static final int CUSTOM = 7;
    public static final int REVERSE_SAW_WAVE = 4;
    public static final int SAW_WAVE = 3;
    public static final int SIN_WAVE = 0;
    public static final int SQUARE_WAVE = 1;
    public static String TAG = "Oscillator";
    public static final int TRIANGLE_WAVE = 2;
    double PI2;
    double[] mArea;
    MonotonicCurveFit mCustomCurve;
    String mCustomType;
    private boolean mNormalized;
    float[] mPeriod;
    double[] mPosition;
    int mType;

    public Oscillator() {
        this.mPeriod = new float[0];
        this.mPosition = new double[0];
        this.PI2 = 6.283185307179586d;
        this.mNormalized = false;
    }

    public void addPoint(double r5, float r7) {
        int r0 = this.mPeriod.length + 1;
        int r1 = Arrays.binarySearch(this.mPosition, r5);
        if (r1 >= 0) goto L5;
        r1 = (-r1) - 1;
    L5:
        this.mPosition = Arrays.copyOf(this.mPosition, r0);
        this.mPeriod = Arrays.copyOf(this.mPeriod, r0);
        this.mArea = new double[r0];
        double[] r2 = this.mPosition;
        System.arraycopy(r2, r1, r2, r1 + 1, (r0 - r1) - 1);
        this.mPosition[r1] = r5;
        this.mPeriod[r1] = r7;
        this.mNormalized = false;
    }

    public double getDP(double r8) {
        if (r8 > 0.0d) goto L6;
        r8 = 1.0E-5d;
    L8:
        int r2 = Arrays.binarySearch(this.mPosition, r8);
        if (r2 <= 0) goto L11;
        return 0.0d;
    L11:
        if (r2 == 0) goto L14;
        int r0 = -r2;
        int r1 = r0 - 1;
        float[] r3 = this.mPeriod;
        float r4 = r3[r1];
        int r5 = r0 - 2;
        float r6 = r3[r5];
        double[] r7 = this.mPosition;
        double r9 = r7[r1];
        double r10 = r7[r5];
        double r11 = ((double) (r4 - r6)) / (r9 - r10);
        return (((double) r6) - (r11 * r10)) + (r8 * r11);
    L14:
        return 0.0d;
    L6:
        if (r8 < 1.0d) goto L8;
        r8 = 0.999999d;
        goto L8
    }

    public double getP(double r13) {
        if (r13 >= 0.0d) goto L6;
        r13 = 0.0d;
    L8:
        int r2 = Arrays.binarySearch(this.mPosition, r13);
        if (r2 > 0) goto L14;
        if (r2 == 0) goto L15;
        int r0 = -r2;
        int r1 = r0 - 1;
        float[] r3 = this.mPeriod;
        float r4 = r3[r1];
        int r5 = r0 - 2;
        float r6 = r3[r5];
        double[] r7 = this.mPosition;
        double r8 = r7[r1];
        double r9 = r7[r5];
        double r10 = ((double) (r4 - r6)) / (r8 - r9);
        double r11 = (r13 - r9) * (((double) r6) - (r10 * r9));
        return ((((r13 * r13) - (r9 * r9)) * r10) / 2.0d) + (r11 + this.mArea[r5]);
    L15:
        return 0.0d;
    L14:
        return 1.0d;
    L6:
        if (r13 <= 1.0d) goto L8;
        r13 = 1.0d;
        goto L8
    }

    public double getSlope(double r7, double r9, double r11) {
        double r0 = getP(r7) + r9;
        double r8 = getDP(r7) + r11;
        switch(this.mType) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L11;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L4;
        };
    L4:
        double r10 = this.PI2;
        double r12 = r8 * r10;
        double r13 = Math.cos(r10 * r0);
    L6:
        return r13 * r12;
    L9:
        double r1 = (((r0 * 4.0d) + 2.0d) % 4.0d) - 2.0d;
        return r1 * (r8 * 4.0d);
    L11:
        double r14 = this.PI2;
        double r15 = (-r14) * r8;
        return Math.sin(r14 * r0) * r15;
    L17:
        r12 = r8 * 4.0d;
        r13 = Math.signum((((r0 * 4.0d) + 3.0d) % 4.0d) - 2.0d);
        goto L6
    L18:
        return 0.0d;
    L8:
        return this.mCustomCurve.getSlope(r0 % 1.0d, 0);
    L14:
        return (-r8) * 2.0d;
    L16:
        return r8 * 2.0d;
    }

    public double getValue(double r8, double r10) {
        double r9 = getP(r8) + r10;
        switch(this.mType) {
            case 1: goto L19;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L10;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L5;
        };
    L8:
        double r7 = 1.0d - Math.abs(((r9 * 4.0d) % 4.0d) - 2.0d);
        return 1.0d - (r7 * r7);
    L10:
        double r11 = r10 + r9;
        return Math.cos(r11 * this.PI2);
    L5:
        return Math.sin(this.PI2 * r9);
    L7:
        return this.mCustomCurve.getPos(r9 % 1.0d, 0);
    L13:
        return 1.0d - (((r9 * 2.0d) + 1.0d) % 2.0d);
    L15:
        return (((r9 * 2.0d) + 1.0d) % 2.0d) - 1.0d;
    L17:
        return 1.0d - Math.abs((((r9 * 4.0d) + 1.0d) % 4.0d) - 2.0d);
    L19:
        return Math.signum(0.5d - (r9 % 1.0d));
    }

    public void normalize() {
        double r5 = 0.0d;
        int r4 = 0;
    L3:
        float[] r7 = this.mPeriod;
        if (r4 >= r7.length) goto L6;
        r5 = r5 + ((double) r7[r4]);
        r4 = r4 + 1;
        goto L3
    L6:
        double r8 = 0.0d;
        int r9 = 1;
    L7:
        float[] r10 = this.mPeriod;
        if (r9 >= r10.length) goto L10;
        int r11 = r9 - 1;
        float r13 = (r10[r11] + r10[r9]) / 2.0f;
        double[] r12 = this.mPosition;
        r8 = r8 + ((r12[r9] - r12[r11]) * ((double) r13));
        r9 = r9 + 1;
        goto L7
    L10:
        int r14 = 0;
    L11:
        float[] r15 = this.mPeriod;
        if (r14 >= r15.length) goto L14;
        r15[r14] = (float) (((double) r15[r14]) * (r5 / r8));
        r14 = r14 + 1;
        goto L11
    L14:
        this.mArea[0] = 0.0d;
        int r1 = 1;
    L15:
        float[] r2 = this.mPeriod;
        if (r1 >= r2.length) goto L18;
        int r3 = r1 - 1;
        float r6 = (r2[r3] + r2[r1]) / 2.0f;
        double[] r16 = this.mPosition;
        double r17 = r16[r1] - r16[r3];
        double[] r18 = this.mArea;
        r18[r1] = (r17 * ((double) r6)) + r18[r3];
        r1 = r1 + 1;
        goto L15
    L18:
        this.mNormalized = true;
    }

    public void setType(int r1, String r2) {
        this.mType = r1;
        this.mCustomType = r2;
        if (r2 == null) goto L6;
        this.mCustomCurve = MonotonicCurveFit.buildWave(r2);
        return;
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.mPosition) + " period=" + Arrays.toString(this.mPeriod);
    }
}
