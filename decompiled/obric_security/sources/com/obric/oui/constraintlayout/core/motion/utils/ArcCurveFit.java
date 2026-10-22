package com.obric.oui.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class ArcCurveFit extends CurveFit {
    public static final int ARC_ABOVE = 5;
    public static final int ARC_BELOW = 4;
    public static final int ARC_START_FLIP = 3;
    public static final int ARC_START_HORIZONTAL = 2;
    public static final int ARC_START_LINEAR = 0;
    public static final int ARC_START_VERTICAL = 1;
    private static final int DOWN_ARC = 4;
    private static final int START_HORIZONTAL = 2;
    private static final int START_LINEAR = 3;
    private static final int START_VERTICAL = 1;
    private static final int UP_ARC = 5;
    Arc[] mArcs;
    private boolean mExtrapolate;
    private final double[] mTime;

    private static class Arc {
        private static final double EPSILON = 0.001d;
        private static final String TAG = "Arc";
        private static double[] sOurPercent;
        double mArcDistance;
        double mArcVelocity;
        double mEllipseA;
        double mEllipseB;
        double mEllipseCenterX;
        double mEllipseCenterY;
        boolean mLinear;
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
            sOurPercent = new double[91];
        }

        Arc(int r20, double r21, double r23, double r25, double r27, double r29, double r31) {
            this.mLinear = false;
            double r14 = r29 - r25;
            double r10 = r31 - r27;
            int r12 = 1;
            if (r20 != 1) goto L5;
            this.mVertical = true;
        L18:
            this.mTime1 = r21;
            this.mTime2 = r23;
            this.mOneOverDeltaTime = 1.0d / (r23 - r21);
            if (3 != r20) goto L22;
            this.mLinear = true;
        L22:
            if (this.mLinear == false) goto L24;
        L46:
            this.mLinear = true;
            this.mX1 = r25;
            this.mX2 = r29;
            this.mY1 = r27;
            this.mY2 = r31;
            double r0 = Math.hypot(r10, r14);
            this.mArcDistance = r0;
            this.mArcVelocity = r0 * this.mOneOverDeltaTime;
            double r1 = this.mTime2;
            double r4 = this.mTime1;
            this.mEllipseCenterX = r14 / (r1 - r4);
            this.mEllipseCenterY = r10 / (r1 - r4);
            return;
        L24:
            if (Math.abs(r14) < EPSILON) goto L46;
            if (Math.abs(r10) < EPSILON) goto L46;
            this.mLut = new double[101];
            boolean r2 = this.mVertical;
            if (r2 == false) goto L31;
            int r3 = -1;
        L32:
            this.mEllipseA = r14 * ((double) r3);
            if (r2 == true) goto L36;
            r12 = -1;
        L36:
            this.mEllipseB = r10 * ((double) r12);
            if (r2 == false) goto L39;
            double r5 = r29;
        L40:
            this.mEllipseCenterX = r5;
            if (r2 == false) goto L43;
            double r6 = r27;
        L44:
            this.mEllipseCenterY = r6;
            buildTable(r25, r27, r29, r31);
            this.mArcVelocity = this.mArcDistance * this.mOneOverDeltaTime;
            return;
        L43:
            r6 = r31;
            goto L44
        L39:
            r5 = r25;
            goto L40
        L31:
            r3 = 1;
            goto L32
        L5:
            if (r20 != 4) goto L7;
            boolean r13 = false;
            if (r10 <= 0.0d) goto L16;
            r13 = true;
        L16:
            this.mVertical = r13;
            goto L18
        L7:
            if (r20 == 5) goto L9;
            this.mVertical = false;
            goto L18
        L9:
            boolean r15 = false;
            if (r10 >= 0.0d) goto L12;
            r15 = true;
        L12:
            this.mVertical = r15;
            goto L18
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

        double getX() {
            return this.mEllipseCenterX + (this.mEllipseA * this.mTmpSinAngle);
        }

        double getY() {
            return this.mEllipseCenterY + (this.mEllipseB * this.mTmpCosAngle);
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

        public double getLinearDX(double r1) {
            return this.mEllipseCenterX;
        }

        public double getLinearDY(double r1) {
            return this.mEllipseCenterY;
        }

        double lookup(double r6) {
            if (r6 > 0.0d) goto L6;
            return 0.0d;
        L6:
            if (r6 < 1.0d) goto L8;
            return 1.0d;
        L8:
            double[] r5 = this.mLut;
            double r7 = r6 * ((double) (r5.length - 1));
            int r0 = (int) r7;
            double r8 = r7 - ((double) r0);
            double r1 = r5[r0];
            return r1 + (r8 * (r5[r0 + 1] - r1));
        }

        private void buildTable(double r21, double r23, double r25, double r27) {
            double r1 = r25 - r21;
            double r3 = r23 - r27;
            int r8 = 0;
            double r9 = 0.0d;
            double r11 = 0.0d;
            double r13 = 0.0d;
        L3:
            double[] r15 = sOurPercent;
            if (r8 >= r15.length) goto L10;
            double r24 = r9;
            double r5 = Math.toRadians((((double) r8) * 90.0d) / ((double) (r15.length - 1)));
            double r10 = Math.sin(r5) * r1;
            double r6 = Math.cos(r5) * r3;
            if (r8 <= 0) goto L8;
            double r12 = Math.hypot(r10 - r11, r6 - r13) + r24;
            sOurPercent[r8] = r12;
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
            double[] r4 = sOurPercent;
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
            int r18 = Arrays.binarySearch(sOurPercent, r17);
            if (r18 < 0) goto L21;
            this.mLut[r7] = ((double) r18) / ((double) (sOurPercent.length - 1));
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
            double[] r110 = sOurPercent;
            double r111 = r110[r20];
            this.mLut[r7] = (((double) r20) + ((r17 - r111) / (r110[r19 - 1] - r111))) / ((double) (r110.length - 1));
            goto L24
        }
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double r11, double[] r13) {
        if (this.mExtrapolate == false) goto L19;
        if (r11 >= this.mArcs[0].mTime1) goto L11;
        double r3 = this.mArcs[0].mTime1;
        double r12 = r11 - this.mArcs[0].mTime1;
        if (this.mArcs[0].mLinear == false) goto L9;
        r13[0] = this.mArcs[0].getLinearX(r3) + (this.mArcs[0].getLinearDX(r3) * r12);
        r13[1] = this.mArcs[0].getLinearY(r3) + (r12 * this.mArcs[0].getLinearDY(r3));
        return;
    L9:
        this.mArcs[0].setPoint(r3);
        r13[0] = this.mArcs[0].getX() + (this.mArcs[0].getDX() * r12);
        r13[1] = this.mArcs[0].getY() + (r12 * this.mArcs[0].getDY());
        return;
    L11:
        Arc[] r0 = this.mArcs;
        if (r11 <= r0[r0.length - 1].mTime2) goto L24;
        Arc[] r1 = this.mArcs;
        double r4 = r1[r1.length - 1].mTime2;
        double r5 = r11 - r4;
        Arc[] r2 = this.mArcs;
        int r7 = r2.length - 1;
        if (r2[r7].mLinear == false) goto L16;
        r13[0] = this.mArcs[r7].getLinearX(r4) + (this.mArcs[r7].getLinearDX(r4) * r5);
        r13[1] = this.mArcs[r7].getLinearY(r4) + (r5 * this.mArcs[r7].getLinearDY(r4));
        return;
    L16:
        this.mArcs[r7].setPoint(r11);
        r13[0] = this.mArcs[r7].getX() + (this.mArcs[r7].getDX() * r5);
        r13[1] = this.mArcs[r7].getY() + (r5 * this.mArcs[r7].getDY());
        return;
    L24:
        int r6 = 0;
    L25:
        Arc[] r8 = this.mArcs;
        if (r6 >= r8.length) goto L36;
        if (r11 <= r8[r6].mTime2) goto L30;
        r6 = r6 + 1;
        goto L25
    L30:
        if (this.mArcs[r6].mLinear == false) goto L33;
        r13[0] = this.mArcs[r6].getLinearX(r11);
        r13[1] = this.mArcs[r6].getLinearY(r11);
        return;
    L33:
        this.mArcs[r6].setPoint(r11);
        r13[0] = this.mArcs[r6].getX();
        r13[1] = this.mArcs[r6].getY();
        return;
    L36:
        return;
    L19:
        if (r11 >= this.mArcs[0].mTime1) goto L21;
        r11 = this.mArcs[0].mTime1;
    L21:
        Arc[] r9 = this.mArcs;
        if (r11 <= r9[r9.length - 1].mTime2) goto L24;
        Arc[] r14 = this.mArcs;
        r11 = r14[r14.length - 1].mTime2;
        goto L24
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double r11, float[] r13) {
        if (this.mExtrapolate == false) goto L19;
        if (r11 >= this.mArcs[0].mTime1) goto L11;
        double r3 = this.mArcs[0].mTime1;
        double r12 = r11 - this.mArcs[0].mTime1;
        if (this.mArcs[0].mLinear == false) goto L9;
        r13[0] = (float) (this.mArcs[0].getLinearX(r3) + (this.mArcs[0].getLinearDX(r3) * r12));
        r13[1] = (float) (this.mArcs[0].getLinearY(r3) + (r12 * this.mArcs[0].getLinearDY(r3)));
        return;
    L9:
        this.mArcs[0].setPoint(r3);
        r13[0] = (float) (this.mArcs[0].getX() + (this.mArcs[0].getDX() * r12));
        r13[1] = (float) (this.mArcs[0].getY() + (r12 * this.mArcs[0].getDY()));
        return;
    L11:
        Arc[] r0 = this.mArcs;
        if (r11 <= r0[r0.length - 1].mTime2) goto L24;
        Arc[] r1 = this.mArcs;
        double r4 = r1[r1.length - 1].mTime2;
        double r5 = r11 - r4;
        Arc[] r2 = this.mArcs;
        int r7 = r2.length - 1;
        if (r2[r7].mLinear == false) goto L16;
        r13[0] = (float) (this.mArcs[r7].getLinearX(r4) + (this.mArcs[r7].getLinearDX(r4) * r5));
        r13[1] = (float) (this.mArcs[r7].getLinearY(r4) + (r5 * this.mArcs[r7].getLinearDY(r4)));
        return;
    L16:
        this.mArcs[r7].setPoint(r11);
        r13[0] = (float) this.mArcs[r7].getX();
        r13[1] = (float) this.mArcs[r7].getY();
        return;
    L24:
        int r6 = 0;
    L25:
        Arc[] r8 = this.mArcs;
        if (r6 >= r8.length) goto L36;
        if (r11 <= r8[r6].mTime2) goto L30;
        r6 = r6 + 1;
        goto L25
    L30:
        if (this.mArcs[r6].mLinear == false) goto L33;
        r13[0] = (float) this.mArcs[r6].getLinearX(r11);
        r13[1] = (float) this.mArcs[r6].getLinearY(r11);
        return;
    L33:
        this.mArcs[r6].setPoint(r11);
        r13[0] = (float) this.mArcs[r6].getX();
        r13[1] = (float) this.mArcs[r6].getY();
        return;
    L36:
        return;
    L19:
        if (r11 >= this.mArcs[0].mTime1) goto L21;
        r11 = this.mArcs[0].mTime1;
        goto L24
    L21:
        Arc[] r9 = this.mArcs;
        if (r11 <= r9[r9.length - 1].mTime2) goto L24;
        Arc[] r14 = this.mArcs;
        r11 = r14[r14.length - 1].mTime2;
        goto L24
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.CurveFit
    public void getSlope(double r6, double[] r8) {
        if (r6 >= this.mArcs[0].mTime1) goto L5;
        r6 = this.mArcs[0].mTime1;
    L8:
        int r0 = 0;
    L9:
        Arc[] r3 = this.mArcs;
        if (r0 >= r3.length) goto L20;
        if (r6 <= r3[r0].mTime2) goto L14;
        r0 = r0 + 1;
        goto L9
    L14:
        if (this.mArcs[r0].mLinear == false) goto L17;
        r8[0] = this.mArcs[r0].getLinearDX(r6);
        r8[1] = this.mArcs[r0].getLinearDY(r6);
        return;
    L17:
        this.mArcs[r0].setPoint(r6);
        r8[0] = this.mArcs[r0].getDX();
        r8[1] = this.mArcs[r0].getDY();
        return;
    L20:
        return;
    L5:
        Arc[] r1 = this.mArcs;
        if (r6 <= r1[r1.length - 1].mTime2) goto L8;
        Arc[] r7 = this.mArcs;
        r6 = r7[r7.length - 1].mTime2;
        goto L8
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double r7, int r9) {
        int r1 = 0;
        if (this.mExtrapolate == false) goto L26;
        if (r7 >= this.mArcs[0].mTime1) goto L19;
        double r2 = this.mArcs[0].mTime1;
        double r8 = r7 - this.mArcs[0].mTime1;
        if (this.mArcs[0].mLinear == false) goto L13;
        if (r9 != 0) goto L12;
        double r4 = this.mArcs[0].getLinearX(r2);
        double r0 = this.mArcs[0].getLinearDX(r2);
    L11:
        return r4 + (r8 * r0);
    L12:
        r4 = this.mArcs[0].getLinearY(r2);
        r0 = this.mArcs[0].getLinearDY(r2);
        goto L11
    L13:
        this.mArcs[0].setPoint(r2);
        if (r9 != 0) goto L18;
        double r3 = this.mArcs[0].getX();
        double r5 = this.mArcs[0].getDX();
    L17:
        return r3 + (r8 * r5);
    L18:
        r3 = this.mArcs[0].getY();
        r5 = this.mArcs[0].getDY();
        goto L17
    L19:
        Arc[] r6 = this.mArcs;
        if (r7 <= r6[r6.length - 1].mTime2) goto L31;
        Arc[] r10 = this.mArcs;
        double r11 = r10[r10.length - 1].mTime2;
        r8 = r7 - r11;
        Arc[] r12 = this.mArcs;
        int r13 = r12.length - 1;
        if (r9 != 0) goto L24;
        r4 = r12[r13].getLinearX(r11);
        r0 = this.mArcs[r13].getLinearDX(r11);
        goto L11
    L24:
        r4 = r12[r13].getLinearY(r11);
        r0 = this.mArcs[r13].getLinearDY(r11);
    L31:
        Arc[] r14 = this.mArcs;
        if (r1 >= r14.length) goto L49;
        if (r7 <= r14[r1].mTime2) goto L36;
        r1 = r1 + 1;
        goto L31
    L36:
        if (this.mArcs[r1].mLinear == false) goto L42;
        if (r9 != 0) goto L41;
        return this.mArcs[r1].getLinearX(r7);
    L41:
        return this.mArcs[r1].getLinearY(r7);
    L42:
        this.mArcs[r1].setPoint(r7);
        if (r9 != 0) goto L47;
        return this.mArcs[r1].getX();
    L47:
        return this.mArcs[r1].getY();
    L49:
        return Double.NaN;
    L26:
        if (r7 >= this.mArcs[0].mTime1) goto L28;
        r7 = this.mArcs[0].mTime1;
        goto L31
    L28:
        Arc[] r15 = this.mArcs;
        if (r7 <= r15[r15.length - 1].mTime2) goto L31;
        Arc[] r16 = this.mArcs;
        r7 = r16[r16.length - 1].mTime2;
        goto L31
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double r5, int r7) {
        int r1 = 0;
        if (r5 >= this.mArcs[0].mTime1) goto L5;
        r5 = this.mArcs[0].mTime1;
    L5:
        Arc[] r0 = this.mArcs;
        if (r5 <= r0[r0.length - 1].mTime2) goto L8;
        Arc[] r6 = this.mArcs;
        r5 = r6[r6.length - 1].mTime2;
    L8:
        Arc[] r2 = this.mArcs;
        if (r1 >= r2.length) goto L26;
        if (r5 <= r2[r1].mTime2) goto L13;
        r1 = r1 + 1;
        goto L8
    L13:
        if (this.mArcs[r1].mLinear == false) goto L19;
        if (r7 != 0) goto L18;
        return this.mArcs[r1].getLinearDX(r5);
    L18:
        return this.mArcs[r1].getLinearDY(r5);
    L19:
        this.mArcs[r1].setPoint(r5);
        if (r7 != 0) goto L24;
        return this.mArcs[r1].getDX();
    L24:
        return this.mArcs[r1].getDY();
    L26:
        return Double.NaN;
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mTime;
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
        if (r4 >= r7.length) goto L22;
        int r8 = r25[r4];
        int r9 = 3;
        if (r8 == 0) goto L20;
        if (r8 != 1) goto L9;
    L18:
        r5 = 1;
    L19:
        r6 = r5;
    L21:
        double r10 = r26[r4];
        int r23 = r4 + 1;
        double r12 = r26[r23];
        double[] r11 = r27[r4];
        double r14 = r11[0];
        double r16 = r11[1];
        double[] r13 = r27[r23];
        r7[r4] = new Arc(r6, r10, r12, r14, r16, r13[0], r13[1]);
        r4 = r23;
        goto L3
    L9:
        if (r8 == 2) goto L17;
        if (r8 == 3) goto L16;
        r9 = 4;
        if (r8 == 4) goto L20;
        r9 = 5;
        if (r8 == 5) goto L20;
    L16:
        if (r5 != 1) goto L18;
    L17:
        r5 = 2;
    L20:
        r6 = r9;
        goto L21
    }
}
