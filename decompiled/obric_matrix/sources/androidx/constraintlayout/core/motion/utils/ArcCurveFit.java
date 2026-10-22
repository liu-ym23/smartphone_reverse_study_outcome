package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ArcCurveFit extends CurveFit {
    public static final int ARC_START_FLIP = 3;
    public static final int ARC_START_HORIZONTAL = 2;
    public static final int ARC_START_LINEAR = 0;
    public static final int ARC_START_VERTICAL = 1;
    private static final int START_HORIZONTAL = 2;
    private static final int START_LINEAR = 3;
    private static final int START_VERTICAL = 1;
    Arc[] mArcs;
    private boolean mExtrapolate;
    private final double[] mTime;

    private static class Arc {
        private static final double EPSILON = 0.001d;
        private static final String TAG = "Arc";
        private static double[] ourPercent;
        boolean linear;
        double mArcDistance;
        double mArcVelocity;
        double mEllipseA;
        double mEllipseB;
        double mEllipseCenterX;
        double mEllipseCenterY;
        double[] mLut;
        double mOneOverDeltaTime;
        double mTime1;
        double mTime2;
        double mTmpCosAngle;
        double mTmpSinAngle;
        boolean mVertical;
        double mX1;
        double mX2;
        double mY1;
        double mY2;

        static {
            ourPercent = new double[91];
        }

        Arc(int r21, double r22, double r24, double r26, double r28, double r30, double r32) {
            boolean r14 = false;
            this.linear = false;
            int r15 = 1;
            if (r21 != 1) goto L5;
            r14 = true;
        L5:
            this.mVertical = r14;
            this.mTime1 = r22;
            this.mTime2 = r24;
            this.mOneOverDeltaTime = 1.0d / (r24 - r22);
            if (3 != r21) goto L8;
            this.linear = true;
        L8:
            double r0 = r30 - r26;
            double r2 = r32 - r28;
            if (this.linear == false) goto L11;
        L33:
            this.linear = true;
            this.mX1 = r26;
            this.mX2 = r30;
            this.mY1 = r28;
            this.mY2 = r32;
            double r4 = Math.hypot(r2, r0);
            this.mArcDistance = r4;
            this.mArcVelocity = r4 * this.mOneOverDeltaTime;
            double r5 = this.mTime2;
            double r6 = this.mTime1;
            this.mEllipseCenterX = r0 / (r5 - r6);
            this.mEllipseCenterY = r2 / (r5 - r6);
            return;
        L11:
            if (Math.abs(r0) < EPSILON) goto L33;
            if (Math.abs(r2) < EPSILON) goto L33;
            this.mLut = new double[101];
            boolean r7 = this.mVertical;
            if (r7 == false) goto L18;
            int r16 = -1;
        L19:
            this.mEllipseA = r0 * ((double) r16);
            if (r7 == true) goto L23;
            r15 = -1;
        L23:
            this.mEllipseB = r2 * ((double) r15);
            if (r7 == false) goto L26;
            double r1 = r30;
        L27:
            this.mEllipseCenterX = r1;
            if (r7 == false) goto L30;
            double r3 = r28;
        L31:
            this.mEllipseCenterY = r3;
            buildTable(r26, r28, r30, r32);
            this.mArcVelocity = this.mArcDistance * this.mOneOverDeltaTime;
            return;
        L30:
            r3 = r32;
            goto L31
        L26:
            r1 = r26;
            goto L27
        L18:
            r16 = 1;
            goto L19
        }

        private void buildTable(double r21, double r23, double r25, double r27) {
            double r1 = r25 - r21;
            double r3 = r23 - r27;
            int r8 = 0;
            double r9 = 0.0d;
            double r11 = 0.0d;
            double r13 = 0.0d;
        L3:
            double[] r15 = ourPercent;
            if (r8 >= r15.length) goto L10;
            double r24 = r9;
            double r5 = Math.toRadians((((double) r8) * 90.0d) / ((double) (r15.length - 1)));
            double r10 = Math.sin(r5) * r1;
            double r6 = Math.cos(r5) * r3;
            if (r8 <= 0) goto L8;
            double r12 = r24 + Math.hypot(r10 - r11, r6 - r13);
            ourPercent[r8] = r12;
        L9:
            r8 = r8 + 1;
            r13 = r6;
            r9 = r12;
            r11 = r10;
            goto L3
        L8:
            r12 = r24;
            goto L9
        L10:
            double r14 = r9;
            this.mArcDistance = r14;
            int r2 = 0;
        L11:
            double[] r4 = ourPercent;
            if (r2 >= r4.length) goto L14;
            r4[r2] = r4[r2] / r14;
            r2 = r2 + 1;
            goto L11
        L14:
            int r7 = 0;
        L15:
            double[] r16 = this.mLut;
            if (r7 >= r16.length) goto L25;
            double r17 = ((double) r7) / ((double) (r16.length - 1));
            int r18 = Arrays.binarySearch(ourPercent, r17);
            if (r18 < 0) goto L21;
            this.mLut[r7] = ((double) r18) / ((double) (ourPercent.length - 1));
        L24:
            r7 = r7 + 1;
            goto L15
        L21:
            if (r18 != (-1)) goto L23;
            this.mLut[r7] = 0.0d;
            goto L24
        L23:
            int r19 = -r18;
            int r20 = r19 - 2;
            double[] r110 = ourPercent;
            this.mLut[r7] = (((double) r20) + ((r17 - r110[r20]) / (r110[r19 - 1] - r110[r20]))) / ((double) (r110.length - 1));
            goto L24
        }

        double getDX() {
            double r0 = this.mEllipseA * this.mTmpCosAngle;
            double r2 = (-this.mEllipseB) * this.mTmpSinAngle;
            double r4 = this.mArcVelocity / Math.hypot(r0, r2);
            if (this.mVertical == false) goto L6;
            r0 = -r0;
        L6:
            return r0 * r4;
        }

        double getDY() {
            double r0 = this.mEllipseA * this.mTmpCosAngle;
            double r2 = (-this.mEllipseB) * this.mTmpSinAngle;
            double r4 = this.mArcVelocity / Math.hypot(r0, r2);
            if (this.mVertical == false) goto L6;
            return (-r2) * r4;
        L6:
            return r2 * r4;
        }

        public double getLinearDX(double r1) {
            return this.mEllipseCenterX;
        }

        public double getLinearDY(double r1) {
            return this.mEllipseCenterY;
        }

        public double getLinearX(double r5) {
            double r6 = (r5 - this.mTime1) * this.mOneOverDeltaTime;
            double r0 = this.mX1;
            return r0 + (r6 * (this.mX2 - r0));
        }

        public double getLinearY(double r5) {
            double r6 = (r5 - this.mTime1) * this.mOneOverDeltaTime;
            double r0 = this.mY1;
            return r0 + (r6 * (this.mY2 - r0));
        }

        double getX() {
            return this.mEllipseCenterX + (this.mEllipseA * this.mTmpSinAngle);
        }

        double getY() {
            return this.mEllipseCenterY + (this.mEllipseB * this.mTmpCosAngle);
        }

        double lookup(double r8) {
            if (r8 > 0.0d) goto L6;
            return 0.0d;
        L6:
            if (r8 < 1.0d) goto L8;
            return 1.0d;
        L8:
            double[] r7 = this.mLut;
            double r9 = r8 * ((double) (r7.length - 1));
            int r0 = (int) r9;
            return r7[r0] + ((r9 - ((double) r0)) * (r7[r0 + 1] - r7[r0]));
        }

        void setPoint(double r3) {
            if (this.mVertical == false) goto L5;
            double r0 = this.mTime2 - r3;
        L6:
            double r1 = lookup(r0 * this.mOneOverDeltaTime) * 1.5707963267948966d;
            this.mTmpSinAngle = Math.sin(r1);
            this.mTmpCosAngle = Math.cos(r1);
            return;
        L5:
            r0 = r3 - this.mTime1;
            goto L6
        }
    }

    public ArcCurveFit(int[] r25, double[] r26, double[][] r27) {
        this.mExtrapolate = true;
        this.mTime = r26;
        this.mArcs = new Arc[r26.length - 1];
        int r5 = 1;
        int r6 = 1;
        int r4 = 0;
    L3:
        Arc[] r7 = this.mArcs;
        if (r4 >= r7.length) goto L17;
        int r8 = r25[r4];
        if (r8 == 0) goto L15;
        if (r8 == 1) goto L13;
        if (r8 == 2) goto L12;
        if (r8 != 3) goto L16;
        if (r5 != 1) goto L13;
    L16:
        int r23 = r4 + 1;
        r7[r4] = new Arc(r6, r26[r4], r26[r23], r27[r4][0], r27[r4][1], r27[r23][0], r27[r23][1]);
        r4 = r23;
    L12:
        r5 = 2;
    L14:
        r6 = r5;
    L13:
        r5 = 1;
        goto L14
    L15:
        r6 = 3;
        goto L16
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double r7, int r9) {
        int r1 = 0;
        if (this.mExtrapolate == false) goto L25;
        Arc[] r0 = this.mArcs;
        if (r7 >= r0[0].mTime1) goto L20;
        double r2 = r0[0].mTime1;
        double r8 = r7 - r0[0].mTime1;
        if (r0[0].linear == false) goto L13;
        if (r9 != 0) goto L12;
        double r4 = r0[0].getLinearX(r2);
        double r3 = this.mArcs[0].getLinearDX(r2);
    L11:
        return r4 + (r8 * r3);
    L12:
        r4 = r0[0].getLinearY(r2);
        r3 = this.mArcs[0].getLinearDY(r2);
        goto L11
    L13:
        r0[0].setPoint(r2);
        if (r9 != 0) goto L18;
        double r5 = this.mArcs[0].getX();
        double r6 = this.mArcs[0].getDX();
    L17:
        return r5 + (r8 * r6);
    L18:
        r5 = this.mArcs[0].getY();
        r6 = this.mArcs[0].getDY();
        goto L17
    L20:
        if (r7 <= r0[r0.length - 1].mTime2) goto L31;
        double r10 = r0[r0.length - 1].mTime2;
        r8 = r7 - r10;
        int r11 = r0.length - 1;
        if (r9 != 0) goto L24;
        r4 = r0[r11].getLinearX(r10);
        r3 = this.mArcs[r11].getLinearDX(r10);
        goto L11
    L24:
        r4 = r0[r11].getLinearY(r10);
        r3 = this.mArcs[r11].getLinearDY(r10);
    L31:
        Arc[] r12 = this.mArcs;
        if (r1 >= r12.length) goto L49;
        if (r7 <= r12[r1].mTime2) goto L36;
        r1 = r1 + 1;
        goto L31
    L36:
        if (r12[r1].linear == false) goto L42;
        if (r9 != 0) goto L41;
        return r12[r1].getLinearX(r7);
    L41:
        return r12[r1].getLinearY(r7);
    L42:
        r12[r1].setPoint(r7);
        Arc[] r13 = this.mArcs;
        if (r9 != 0) goto L47;
        return r13[r1].getX();
    L47:
        return r13[r1].getY();
    L49:
        return Double.NaN;
    L25:
        Arc[] r14 = this.mArcs;
        if (r7 >= r14[0].mTime1) goto L29;
        r7 = r14[0].mTime1;
        goto L31
    L29:
        if (r7 <= r14[r14.length - 1].mTime2) goto L31;
        r7 = r14[r14.length - 1].mTime2;
        goto L31
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double r11, double[] r13) {
        if (this.mExtrapolate == false) goto L18;
        Arc[] r0 = this.mArcs;
        if (r11 >= r0[0].mTime1) goto L12;
        double r3 = r0[0].mTime1;
        double r12 = r11 - r0[0].mTime1;
        if (r0[0].linear == false) goto L9;
        r13[0] = r0[0].getLinearX(r3) + (this.mArcs[0].getLinearDX(r3) * r12);
        r13[1] = this.mArcs[0].getLinearY(r3) + (r12 * this.mArcs[0].getLinearDY(r3));
        return;
    L9:
        r0[0].setPoint(r3);
        r13[0] = this.mArcs[0].getX() + (this.mArcs[0].getDX() * r12);
        r13[1] = this.mArcs[0].getY() + (r12 * this.mArcs[0].getDY());
        return;
    L12:
        if (r11 <= r0[r0.length - 1].mTime2) goto L24;
        double r4 = r0[r0.length - 1].mTime2;
        double r5 = r11 - r4;
        int r7 = r0.length - 1;
        if (r0[r7].linear == false) goto L16;
        r13[0] = r0[r7].getLinearX(r4) + (this.mArcs[r7].getLinearDX(r4) * r5);
        r13[1] = this.mArcs[r7].getLinearY(r4) + (r5 * this.mArcs[r7].getLinearDY(r4));
        return;
    L16:
        r0[r7].setPoint(r11);
        r13[0] = this.mArcs[r7].getX() + (this.mArcs[r7].getDX() * r5);
        r13[1] = this.mArcs[r7].getY() + (r5 * this.mArcs[r7].getDY());
        return;
    L24:
        int r1 = 0;
    L25:
        Arc[] r6 = this.mArcs;
        if (r1 >= r6.length) goto L36;
        if (r11 <= r6[r1].mTime2) goto L30;
        r1 = r1 + 1;
        goto L25
    L30:
        if (r6[r1].linear == false) goto L33;
        r13[0] = r6[r1].getLinearX(r11);
        r13[1] = this.mArcs[r1].getLinearY(r11);
        return;
    L33:
        r6[r1].setPoint(r11);
        r13[0] = this.mArcs[r1].getX();
        r13[1] = this.mArcs[r1].getY();
        return;
    L36:
        return;
    L18:
        Arc[] r2 = this.mArcs;
        if (r11 >= r2[0].mTime1) goto L22;
        r11 = r2[0].mTime1;
    L22:
        if (r11 <= r2[r2.length - 1].mTime2) goto L24;
        r11 = r2[r2.length - 1].mTime2;
        goto L24
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double r11, float[] r13) {
        if (this.mExtrapolate == false) goto L18;
        Arc[] r0 = this.mArcs;
        if (r11 >= r0[0].mTime1) goto L12;
        double r3 = r0[0].mTime1;
        double r12 = r11 - r0[0].mTime1;
        if (r0[0].linear == false) goto L9;
        r13[0] = (float) (r0[0].getLinearX(r3) + (this.mArcs[0].getLinearDX(r3) * r12));
        r13[1] = (float) (this.mArcs[0].getLinearY(r3) + (r12 * this.mArcs[0].getLinearDY(r3)));
        return;
    L9:
        r0[0].setPoint(r3);
        r13[0] = (float) (this.mArcs[0].getX() + (this.mArcs[0].getDX() * r12));
        r13[1] = (float) (this.mArcs[0].getY() + (r12 * this.mArcs[0].getDY()));
        return;
    L12:
        if (r11 <= r0[r0.length - 1].mTime2) goto L24;
        double r4 = r0[r0.length - 1].mTime2;
        double r5 = r11 - r4;
        int r7 = r0.length - 1;
        if (r0[r7].linear == false) goto L16;
        r13[0] = (float) (r0[r7].getLinearX(r4) + (this.mArcs[r7].getLinearDX(r4) * r5));
        r13[1] = (float) (this.mArcs[r7].getLinearY(r4) + (r5 * this.mArcs[r7].getLinearDY(r4)));
        return;
    L16:
        r0[r7].setPoint(r11);
        r13[0] = (float) this.mArcs[r7].getX();
        r13[1] = (float) this.mArcs[r7].getY();
        return;
    L24:
        int r1 = 0;
    L25:
        Arc[] r6 = this.mArcs;
        if (r1 >= r6.length) goto L36;
        if (r11 <= r6[r1].mTime2) goto L30;
        r1 = r1 + 1;
        goto L25
    L30:
        if (r6[r1].linear == false) goto L33;
        r13[0] = (float) r6[r1].getLinearX(r11);
        r13[1] = (float) this.mArcs[r1].getLinearY(r11);
        return;
    L33:
        r6[r1].setPoint(r11);
        r13[0] = (float) this.mArcs[r1].getX();
        r13[1] = (float) this.mArcs[r1].getY();
        return;
    L36:
        return;
    L18:
        Arc[] r2 = this.mArcs;
        if (r11 >= r2[0].mTime1) goto L22;
        r11 = r2[0].mTime1;
        goto L24
    L22:
        if (r11 <= r2[r2.length - 1].mTime2) goto L24;
        r11 = r2[r2.length - 1].mTime2;
        goto L24
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double r5, int r7) {
        Arc[] r0 = this.mArcs;
        int r1 = 0;
        if (r5 >= r0[0].mTime1) goto L6;
        r5 = r0[0].mTime1;
    L6:
        if (r5 <= r0[r0.length - 1].mTime2) goto L8;
        r5 = r0[r0.length - 1].mTime2;
    L8:
        Arc[] r2 = this.mArcs;
        if (r1 >= r2.length) goto L26;
        if (r5 <= r2[r1].mTime2) goto L13;
        r1 = r1 + 1;
        goto L8
    L13:
        if (r2[r1].linear == false) goto L19;
        if (r7 != 0) goto L18;
        return r2[r1].getLinearDX(r5);
    L18:
        return r2[r1].getLinearDY(r5);
    L19:
        r2[r1].setPoint(r5);
        Arc[] r4 = this.mArcs;
        if (r7 != 0) goto L24;
        return r4[r1].getDX();
    L24:
        return r4[r1].getDY();
    L26:
        return Double.NaN;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getSlope(double r7, double[] r9) {
        Arc[] r0 = this.mArcs;
        if (r7 >= r0[0].mTime1) goto L6;
        r7 = r0[0].mTime1;
    L8:
        int r1 = 0;
    L9:
        Arc[] r2 = this.mArcs;
        if (r1 >= r2.length) goto L20;
        if (r7 <= r2[r1].mTime2) goto L14;
        r1 = r1 + 1;
        goto L9
    L14:
        if (r2[r1].linear == false) goto L17;
        r9[0] = r2[r1].getLinearDX(r7);
        r9[1] = this.mArcs[r1].getLinearDY(r7);
        return;
    L17:
        r2[r1].setPoint(r7);
        r9[0] = this.mArcs[r1].getDX();
        r9[1] = this.mArcs[r1].getDY();
        return;
    L20:
        return;
    L6:
        if (r7 <= r0[r0.length - 1].mTime2) goto L8;
        r7 = r0[r0.length - 1].mTime2;
        goto L8
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mTime;
    }
}
