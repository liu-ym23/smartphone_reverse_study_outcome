package com.obric.oui.constraintlayout.motion.widget;

import android.view.View;
import com.obric.oui.constraintlayout.core.motion.utils.Easing;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import com.obric.oui.constraintlayout.widget.ConstraintSet;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: loaded from: classes4.dex */
class MotionPaths implements Comparable<MotionPaths> {
    static final int CARTESIAN = 0;
    public static final boolean DEBUG = false;
    static final int OFF_HEIGHT = 4;
    static final int OFF_PATH_ROTATE = 5;
    static final int OFF_POSITION = 0;
    static final int OFF_WIDTH = 3;
    static final int OFF_X = 1;
    static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    static final int PERPENDICULAR = 1;
    static final int SCREEN = 2;
    public static final String TAG = "MotionPaths";
    static String[] sNames;
    int mAnimateCircleAngleTo;
    int mAnimateRelativeTo;
    LinkedHashMap<String, ConstraintAttribute> mAttributes;
    int mDrawPath;
    float mHeight;
    Easing mKeyFrameEasing;
    int mMode;
    int mPathMotionArc;
    float mPathRotate;
    float mPosition;
    float mProgress;
    float mRelativeAngle;
    MotionController mRelativeToController;
    double[] mTempDelta;
    double[] mTempValue;
    float mTime;
    float mWidth;
    float mX;
    float mY;

    private static float xRotate(float r0, float r1, float r2, float r3, float r4, float r5) {
        return (((r4 - r2) * r1) - ((r5 - r3) * r0)) + r2;
    }

    private static float yRotate(float r0, float r1, float r2, float r3, float r4, float r5) {
        return (((r4 - r2) * r0) + ((r5 - r3) * r1)) + r3;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(MotionPaths r1) {
        return compareTo2(r1);
    }

    static {
        sNames = new String[]{"position", MaterialConfigFormatNames.X, "y", MaterialConfigFormatNames.WIDTH, MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "pathRotate"};
    }

    MotionPaths() {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = Key.UNSET;
        this.mAnimateRelativeTo = Key.UNSET;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.mAttributes = new LinkedHashMap();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    void initCartesian(KeyPosition r18, MotionPaths r19, MotionPaths r20) {
        float r4 = r18.mFramePosition / 100.0f;
        this.mTime = r4;
        this.mDrawPath = r18.mDrawPath;
        if (Float.isNaN(r18.mPercentWidth) == false) goto L5;
        float r5 = r4;
    L7:
        if (Float.isNaN(r18.mPercentHeight) == false) goto L9;
        float r6 = r4;
    L10:
        float r7 = r20.mWidth;
        float r8 = r19.mWidth;
        float r10 = r20.mHeight;
        float r11 = r19.mHeight;
        this.mPosition = this.mTime;
        float r13 = r19.mX;
        float r1 = r19.mY;
        float r2 = r20.mX + (r7 / 2.0f);
        float r3 = r2 - ((r8 / 2.0f) + r13);
        float r9 = (r20.mY + (r10 / 2.0f)) - (r1 + (r11 / 2.0f));
        float r12 = (r7 - r8) * r5;
        float r14 = r12 / 2.0f;
        this.mX = (int) ((r13 + (r3 * r4)) - r14);
        float r15 = (r10 - r11) * r6;
        float r16 = r15 / 2.0f;
        this.mY = (int) ((r1 + (r9 * r4)) - r16);
        this.mWidth = (int) (r8 + r12);
        this.mHeight = (int) (r11 + r15);
        if (Float.isNaN(r18.mPercentX) == false) goto L13;
        float r17 = r4;
    L14:
        float r21 = 0.0f;
        if (Float.isNaN(r18.mAltPercentY) == false) goto L17;
        float r22 = 0.0f;
    L19:
        if (Float.isNaN(r18.mPercentY) == true) goto L23;
        r4 = r18.mPercentY;
    L23:
        if (Float.isNaN(r18.mAltPercentX) == true) goto L26;
        r21 = r18.mAltPercentX;
    L26:
        this.mMode = 0;
        this.mX = (int) (((r19.mX + (r17 * r3)) + (r21 * r9)) - r14);
        this.mY = (int) (((r19.mY + (r3 * r22)) + (r9 * r4)) - r16);
        this.mKeyFrameEasing = Easing.getInterpolator(r18.mTransitionEasing);
        this.mPathMotionArc = r18.mPathMotionArc;
        return;
    L17:
        r22 = r18.mAltPercentY;
        goto L19
    L13:
        r17 = r18.mPercentX;
        goto L14
    L9:
        r6 = r18.mPercentHeight;
        goto L10
    L5:
        r5 = r18.mPercentWidth;
        goto L7
    }

    void initAxis(KeyPosition r19, MotionPaths r20, MotionPaths r21) {
        float r4 = r19.mFramePosition / 100.0f;
        this.mTime = r4;
        this.mDrawPath = r19.mDrawPath;
        if (Float.isNaN(r19.mPercentWidth) == false) goto L5;
        float r5 = r4;
    L7:
        if (Float.isNaN(r19.mPercentHeight) == false) goto L9;
        float r6 = r4;
    L10:
        float r7 = r21.mWidth;
        float r8 = r20.mWidth;
        float r9 = r7 - r8;
        float r10 = r21.mHeight;
        float r11 = r20.mHeight;
        float r12 = r10 - r11;
        this.mPosition = this.mTime;
        float r13 = r20.mX;
        float r15 = (r8 / 2.0f) + r13;
        float r1 = r20.mY;
        float r16 = r1 + (r11 / 2.0f);
        float r2 = r21.mX + (r7 / 2.0f);
        float r3 = r21.mY + (r10 / 2.0f);
        if (r15 <= r2) goto L14;
        r15 = r2;
        r2 = r15;
    L14:
        if (r16 > r3) goto L17;
        r16 = r3;
        r3 = r16;
    L17:
        float r14 = r2 - r15;
        float r17 = r16 - r3;
        float r18 = r9 * r5;
        float r22 = r18 / 2.0f;
        this.mX = (int) ((r13 + (r14 * r4)) - r22);
        float r110 = r12 * r6;
        float r23 = r110 / 2.0f;
        this.mY = (int) ((r1 + (r17 * r4)) - r23);
        this.mWidth = (int) (r8 + r18);
        this.mHeight = (int) (r11 + r110);
        if (Float.isNaN(r19.mPercentX) == false) goto L20;
        float r24 = r4;
    L21:
        float r25 = 0.0f;
        if (Float.isNaN(r19.mAltPercentY) == false) goto L24;
        float r26 = 0.0f;
    L26:
        if (Float.isNaN(r19.mPercentY) == true) goto L30;
        r4 = r19.mPercentY;
    L30:
        if (Float.isNaN(r19.mAltPercentX) == true) goto L33;
        r25 = r19.mAltPercentX;
    L33:
        this.mMode = 0;
        this.mX = (int) (((r20.mX + (r24 * r14)) + (r25 * r17)) - r22);
        this.mY = (int) (((r20.mY + (r14 * r26)) + (r17 * r4)) - r23);
        this.mKeyFrameEasing = Easing.getInterpolator(r19.mTransitionEasing);
        this.mPathMotionArc = r19.mPathMotionArc;
        return;
    L24:
        r26 = r19.mAltPercentY;
        goto L26
    L20:
        r24 = r19.mPercentX;
        goto L21
    L9:
        r6 = r19.mPercentHeight;
        goto L10
    L5:
        r5 = r19.mPercentWidth;
        goto L7
    }

    MotionPaths(int r4, int r5, KeyPosition r6, MotionPaths r7, MotionPaths r8) {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = Key.UNSET;
        this.mAnimateRelativeTo = Key.UNSET;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.mAttributes = new LinkedHashMap();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        if (r7.mAnimateRelativeTo == Key.UNSET) goto L6;
        initPolar(r4, r5, r6, r7, r8);
        return;
    L6:
        int r0 = r6.mPositionType;
        if (r0 != 1) goto L9;
        initPath(r6, r7, r8);
        return;
    L9:
        if (r0 != 2) goto L11;
        initScreen(r4, r5, r6, r7, r8);
        return;
    L11:
        if (r0 == 3) goto L14;
        initCartesian(r6, r7, r8);
        return;
    L14:
        initAxis(r6, r7, r8);
    }

    void initPolar(int r7, int r8, KeyPosition r9, MotionPaths r10, MotionPaths r11) {
        float r12 = r9.mFramePosition / 100.0f;
        this.mTime = r12;
        this.mDrawPath = r9.mDrawPath;
        this.mMode = r9.mPositionType;
        if (Float.isNaN(r9.mPercentWidth) == false) goto L5;
        float r13 = r12;
    L7:
        if (Float.isNaN(r9.mPercentHeight) == false) goto L9;
        float r0 = r12;
    L10:
        float r1 = r11.mWidth;
        float r2 = r10.mWidth;
        float r3 = r11.mHeight;
        float r4 = r10.mHeight;
        this.mPosition = this.mTime;
        this.mWidth = (int) (r2 + ((r1 - r2) * r13));
        this.mHeight = (int) (r4 + ((r3 - r4) * r0));
        if (r9.mPositionType == 2) goto L22;
        if (Float.isNaN(r9.mPercentX) == false) goto L15;
        float r14 = r12;
    L16:
        float r5 = r11.mX;
        float r6 = r10.mX;
        this.mX = (r14 * (r5 - r6)) + r6;
        if (Float.isNaN(r9.mPercentY) == true) goto L20;
        r12 = r9.mPercentY;
    L20:
        float r15 = r11.mY;
        float r16 = r10.mY;
        this.mY = (r12 * (r15 - r16)) + r16;
    L30:
        this.mAnimateRelativeTo = r10.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(r9.mTransitionEasing);
        this.mPathMotionArc = r9.mPathMotionArc;
        return;
    L15:
        r14 = r9.mPercentX;
        goto L16
    L22:
        if (Float.isNaN(r9.mPercentX) == false) goto L24;
        float r17 = r11.mX;
        float r18 = r10.mX;
        float r19 = ((r17 - r18) * r12) + r18;
    L25:
        this.mX = r19;
        if (Float.isNaN(r9.mPercentY) == false) goto L28;
        float r20 = r11.mY;
        float r110 = r10.mY;
        float r21 = (r12 * (r20 - r110)) + r110;
    L29:
        this.mY = r21;
        goto L30
    L28:
        r21 = r9.mPercentY;
        goto L29
    L24:
        r19 = Math.min(r0, r13) * r9.mPercentX;
        goto L25
    L9:
        r0 = r9.mPercentHeight;
        goto L10
    L5:
        r13 = r9.mPercentWidth;
        goto L7
    }

    public void setupRelative(MotionController r6, MotionPaths r7) {
        double r0 = ((this.mX + (this.mWidth / 2.0f)) - r7.mX) - (r7.mWidth / 2.0f);
        double r2 = ((this.mY + (this.mHeight / 2.0f)) - r7.mY) - (r7.mHeight / 2.0f);
        this.mRelativeToController = r6;
        this.mX = (float) Math.hypot(r2, r0);
        if (Float.isNaN(this.mRelativeAngle) == false) goto L5;
        this.mY = (float) (Math.atan2(r2, r0) + 1.5707963267948966d);
        return;
    L5:
        this.mY = (float) Math.toRadians(this.mRelativeAngle);
    }

    void initScreen(int r18, int r19, KeyPosition r20, MotionPaths r21, MotionPaths r22) {
        float r4 = r20.mFramePosition / 100.0f;
        this.mTime = r4;
        this.mDrawPath = r20.mDrawPath;
        if (Float.isNaN(r20.mPercentWidth) == false) goto L5;
        float r5 = r4;
    L7:
        if (Float.isNaN(r20.mPercentHeight) == false) goto L9;
        float r6 = r4;
    L10:
        float r7 = r22.mWidth;
        float r8 = r21.mWidth;
        float r10 = r22.mHeight;
        float r11 = r21.mHeight;
        this.mPosition = this.mTime;
        float r13 = r21.mX;
        float r2 = r21.mY;
        float r1 = r22.mX + (r7 / 2.0f);
        float r3 = r22.mY + (r10 / 2.0f);
        float r9 = (r7 - r8) * r5;
        this.mX = (int) ((r13 + ((r1 - ((r8 / 2.0f) + r13)) * r4)) - (r9 / 2.0f));
        float r12 = (r10 - r11) * r6;
        this.mY = (int) ((r2 + ((r3 - (r2 + (r11 / 2.0f))) * r4)) - (r12 / 2.0f));
        this.mWidth = (int) (r8 + r9);
        this.mHeight = (int) (r11 + r12);
        this.mMode = 2;
        if (Float.isNaN(r20.mPercentX) == true) goto L14;
        this.mX = (int) (r20.mPercentX * (r18 - ((int) this.mWidth)));
    L14:
        if (Float.isNaN(r20.mPercentY) == true) goto L16;
        this.mY = (int) (r20.mPercentY * (r19 - ((int) this.mHeight)));
    L16:
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(r20.mTransitionEasing);
        this.mPathMotionArc = r20.mPathMotionArc;
        return;
    L9:
        r6 = r20.mPercentHeight;
        goto L10
    L5:
        r5 = r20.mPercentWidth;
        goto L7
    }

    void initPath(KeyPosition r17, MotionPaths r18, MotionPaths r19) {
        float r4 = r17.mFramePosition / 100.0f;
        this.mTime = r4;
        this.mDrawPath = r17.mDrawPath;
        if (Float.isNaN(r17.mPercentWidth) == false) goto L5;
        float r5 = r4;
    L7:
        if (Float.isNaN(r17.mPercentHeight) == false) goto L9;
        float r6 = r4;
    L10:
        float r7 = r19.mWidth - r18.mWidth;
        float r8 = r19.mHeight - r18.mHeight;
        this.mPosition = this.mTime;
        if (Float.isNaN(r17.mPercentX) == true) goto L14;
        r4 = r17.mPercentX;
    L14:
        float r9 = r18.mX;
        float r10 = r18.mWidth;
        float r13 = r18.mY;
        float r14 = r18.mHeight;
        float r2 = r19.mX + (r19.mWidth / 2.0f);
        float r3 = r2 - ((r10 / 2.0f) + r9);
        float r1 = (r19.mY + (r19.mHeight / 2.0f)) - ((r14 / 2.0f) + r13);
        float r11 = r3 * r4;
        float r12 = r7 * r5;
        float r15 = r12 / 2.0f;
        this.mX = (int) ((r9 + r11) - r15);
        float r16 = r4 * r1;
        float r20 = r8 * r6;
        float r21 = r20 / 2.0f;
        this.mY = (int) ((r13 + r16) - r21);
        this.mWidth = (int) (r10 + r12);
        this.mHeight = (int) (r14 + r20);
        if (Float.isNaN(r17.mPercentY) == false) goto L17;
        float r22 = 0.0f;
    L18:
        this.mMode = 1;
        float r23 = (int) ((r18.mX + r11) - r15);
        this.mX = r23;
        float r24 = (int) ((r18.mY + r16) - r21);
        this.mX = r23 + ((-r1) * r22);
        this.mY = r24 + (r3 * r22);
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(r17.mTransitionEasing);
        this.mPathMotionArc = r17.mPathMotionArc;
        return;
    L17:
        r22 = r17.mPercentY;
        goto L18
    L9:
        r6 = r17.mPercentHeight;
        goto L10
    L5:
        r5 = r17.mPercentWidth;
        goto L7
    }

    private boolean diff(float r3, float r4) {
        if (Float.isNaN(r3) == true) goto L13;
        if (Float.isNaN(r4) == true) goto L13;
        if (Math.abs(r3 - r4) <= 1.0E-6f) goto L11;
        return true;
    L11:
        return false;
    L13:
        if (Float.isNaN(r3) == Float.isNaN(r4)) goto L16;
        return true;
    L16:
        return false;
    }

    void different(MotionPaths r6, boolean[] r7, String[] r8, boolean r9) {
        boolean r10 = diff(this.mX, r6.mX);
        boolean r0 = diff(this.mY, r6.mY);
        r7[0] = r7[0] | diff(this.mPosition, r6.mPosition);
        boolean r11 = (r10 | r0) | r9;
        r7[1] = r7[1] | r11;
        r7[2] = r11 | r7[2];
        r7[3] = r7[3] | diff(this.mWidth, r6.mWidth);
        boolean r12 = r7[4];
        r7[4] = diff(this.mHeight, r6.mHeight) | r12;
    }

    void getCenter(double r16, int[] r18, double[] r19, float[] r20, int r21) {
        float r2 = this.mX;
        float r3 = this.mY;
        float r4 = this.mWidth;
        float r5 = this.mHeight;
        int r7 = 0;
    L4:
        if (r7 >= r18.length) goto L18;
        float r8 = (float) r19[r7];
        int r11 = r18[r7];
        if (r11 == 1) goto L16;
        if (r11 != 2) goto L9;
        r3 = r8;
    L17:
        r7 = r7 + 1;
        goto L4
    L9:
        if (r11 != 3) goto L11;
        r4 = r8;
        goto L17
    L11:
        if (r11 != 4) goto L17;
        r5 = r8;
        goto L17
    L16:
        r2 = r8;
        goto L17
    L18:
        MotionController r0 = this.mRelativeToController;
        if (r0 == null) goto L21;
        float[] r9 = new float[2];
        r0.getCenter(r16, r9, new float[2]);
        float r1 = r9[0];
        float r6 = r9[1];
        double r12 = r2;
        double r10 = r3;
        float r13 = (float) ((((double) r1) + (Math.sin(r10) * r12)) - ((double) (r4 / 2.0f)));
        r3 = (float) ((((double) r6) - (r12 * Math.cos(r10))) - ((double) (r5 / 2.0f)));
        r2 = r13;
    L21:
        r20[r21] = (r2 + (r4 / 2.0f)) + 0.0f;
        r20[r21 + 1] = (r3 + (r5 / 2.0f)) + 0.0f;
    }

    void getCenter(double r20, int[] r22, double[] r23, float[] r24, double[] r25, float[] r26) {
        float r2 = this.mX;
        float r3 = this.mY;
        float r4 = this.mWidth;
        float r5 = this.mHeight;
        int r8 = 0;
        float r9 = 0.0f;
        float r10 = 0.0f;
        float r11 = 0.0f;
        float r12 = 0.0f;
    L4:
        if (r8 >= r22.length) goto L19;
        float r6 = (float) r23[r8];
        float r13 = (float) r25[r8];
        int r14 = r22[r8];
        if (r14 != 1) goto L8;
        r2 = r6;
        r9 = r13;
    L18:
        r8 = r8 + 1;
        goto L4
    L8:
        if (r14 != 2) goto L10;
        r3 = r6;
        r11 = r13;
        goto L18
    L10:
        if (r14 != 3) goto L12;
        r4 = r6;
        r10 = r13;
        goto L18
    L12:
        if (r14 != 4) goto L18;
        r5 = r6;
        r12 = r13;
        goto L18
    L19:
        float r15 = (r10 / 2.0f) + r9;
        float r16 = (r12 / 2.0f) + r11;
        MotionController r0 = this.mRelativeToController;
        if (r0 == null) goto L22;
        float[] r7 = new float[2];
        float[] r17 = new float[2];
        r0.getCenter(r20, r7, r17);
        float r18 = r7[0];
        float r19 = r7[1];
        float r110 = r17[0];
        float r1 = r17[1];
        double r21 = r2;
        double r111 = r3;
        float r27 = (float) ((((double) r18) + (Math.sin(r111) * r21)) - ((double) (r4 / 2.0f)));
        float r28 = (float) ((((double) r19) - (r21 * Math.cos(r111))) - ((double) (r5 / 2.0f)));
        double r29 = r9;
        double r30 = r11;
        float r31 = (float) ((((double) r110) + (Math.sin(r111) * r29)) + (Math.cos(r111) * r30));
        r16 = (float) ((((double) r1) - (r29 * Math.cos(r111))) + (Math.sin(r111) * r30));
        r2 = r27;
        r3 = r28;
        r15 = r31;
        float r32 = 2.0f;
    L23:
        r24[0] = (r2 + (r4 / r32)) + 0.0f;
        r24[1] = (r3 + (r5 / r32)) + 0.0f;
        r26[0] = r15;
        r26[1] = r16;
        return;
    L22:
        r32 = 2.0f;
        goto L23
    }

    void getCenterVelocity(double r16, int[] r18, double[] r19, float[] r20, int r21) {
        float r2 = this.mX;
        float r3 = this.mY;
        float r4 = this.mWidth;
        float r5 = this.mHeight;
        int r7 = 0;
    L4:
        if (r7 >= r18.length) goto L18;
        float r8 = (float) r19[r7];
        int r11 = r18[r7];
        if (r11 == 1) goto L16;
        if (r11 != 2) goto L9;
        r3 = r8;
    L17:
        r7 = r7 + 1;
        goto L4
    L9:
        if (r11 != 3) goto L11;
        r4 = r8;
        goto L17
    L11:
        if (r11 != 4) goto L17;
        r5 = r8;
        goto L17
    L16:
        r2 = r8;
        goto L17
    L18:
        MotionController r0 = this.mRelativeToController;
        if (r0 == null) goto L21;
        float[] r9 = new float[2];
        r0.getCenter(r16, r9, new float[2]);
        float r1 = r9[0];
        float r6 = r9[1];
        double r12 = r2;
        double r10 = r3;
        float r13 = (float) ((((double) r1) + (Math.sin(r10) * r12)) - ((double) (r4 / 2.0f)));
        r3 = (float) ((((double) r6) - (r12 * Math.cos(r10))) - ((double) (r5 / 2.0f)));
        r2 = r13;
    L21:
        r20[r21] = (r2 + (r4 / 2.0f)) + 0.0f;
        r20[r21 + 1] = (r3 + (r5 / 2.0f)) + 0.0f;
    }

    void getBounds(int[] r6, double[] r7, float[] r8, int r9) {
        float r0 = this.mWidth;
        float r5 = this.mHeight;
        int r1 = 0;
    L4:
        if (r1 >= r6.length) goto L13;
        float r2 = (float) r7[r1];
        int r3 = r6[r1];
        if (r3 != 3) goto L8;
        r0 = r2;
    L12:
        r1 = r1 + 1;
        goto L4
    L8:
        if (r3 != 4) goto L12;
        r5 = r2;
        goto L12
    L13:
        r8[r9] = r0;
        r8[r9 + 1] = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void setView(float r21, View r22, int[] r23, double[] r24, double[] r25, double[] r26, boolean r27) {
        float r4 = this.mX;
        float r5 = this.mY;
        float r6 = this.mWidth;
        float r7 = this.mHeight;
        if (r23.length != 0) goto L5;
    L7:
        Arrays.fill(this.mTempValue, Double.NaN);
        int r10 = 0;
    L9:
        if (r10 >= r23.length) goto L11;
        double[] r11 = this.mTempValue;
        int r12 = r23[r10];
        r11[r12] = r24[r10];
        this.mTempDelta[r12] = r25[r10];
        r10 = r10 + 1;
        goto L9
    L11:
        float r13 = Float.NaN;
        int r14 = 0;
        float r15 = 0.0f;
        float r16 = 0.0f;
        float r17 = 0.0f;
        float r18 = 0.0f;
    L12:
        double[] r2 = this.mTempValue;
        if (r14 >= r2.length) goto L43;
        double r19 = 0.0d;
        if (Double.isNaN(r2[r14]) == false) goto L20;
        if (r26 != null) goto L18;
    L19:
        float r28 = r13;
    L36:
        r13 = r28;
    L42:
        r14 = r14 + 1;
        goto L12
    L18:
        if (r26[r14] == 0.0d) goto L19;
    L20:
        if (r26 == null) goto L23;
        r19 = r26[r14];
    L23:
        if (Double.isNaN(this.mTempValue[r14]) == true) goto L26;
        r19 = this.mTempValue[r14] + r19;
    L26:
        r28 = r13;
        float r8 = (float) r19;
        float r9 = (float) this.mTempDelta[r14];
        if (r14 != 1) goto L29;
        r13 = r28;
        r4 = r8;
        r15 = r9;
        goto L42
    L29:
        if (r14 != 2) goto L31;
        r13 = r28;
        r5 = r8;
        r16 = r9;
        goto L42
    L31:
        if (r14 != 3) goto L33;
        r13 = r28;
        r6 = r8;
        r17 = r9;
        goto L42
    L33:
        if (r14 != 4) goto L35;
        r13 = r28;
        r7 = r8;
        r18 = r9;
        goto L42
    L35:
        if (r14 != 5) goto L36;
        r13 = r8;
        goto L42
    L43:
        float r29 = r13;
        MotionController r0 = this.mRelativeToController;
        if (r0 == null) goto L53;
        float[] r20 = new float[2];
        float[] r110 = new float[2];
        r0.getCenter(r21, r20, r110);
        float r111 = r20[0];
        float r30 = r20[1];
        float r112 = r110[0];
        float r1 = r110[1];
        double r3 = r4;
        double r31 = r5;
        float r32 = (float) ((((double) r111) + (Math.sin(r31) * r3)) - ((double) (r6 / 2.0f)));
        float r113 = r7;
        float r33 = (float) ((((double) r30) - (Math.cos(r31) * r3)) - ((double) (r7 / 2.0f)));
        double r114 = r15;
        double r115 = r16;
        float r34 = (float) ((((double) r112) + (Math.sin(r31) * r114)) + ((Math.cos(r31) * r3) * r115));
        float r35 = (float) ((((double) r1) - (r114 * Math.cos(r31))) + ((r3 * Math.sin(r31)) * r115));
        if (r25.length < 2) goto L48;
        boolean r36 = false;
        r25[0] = r34;
        boolean r116 = true;
        r25[1] = r35;
    L50:
        if (Float.isNaN(r29) == true) goto L52;
        r22.setRotation((float) (((double) r29) + Math.toDegrees(Math.atan2(r35, r34))));
    L52:
        r4 = r32;
        r5 = r33;
    L57:
        if ((r22 instanceof FloatLayout) == false) goto L60;
        ((FloatLayout) r22).layout(r4, r5, r6 + r4, r5 + r113);
        return;
    L60:
        float r37 = r4 + 0.5f;
        int r38 = (int) r37;
        float r39 = r5 + 0.5f;
        int r40 = (int) r39;
        int r41 = (int) (r37 + r6);
        int r42 = (int) (r39 + r113);
        int r43 = r41 - r38;
        int r44 = r42 - r40;
        if (r43 == r22.getMeasuredWidth()) goto L63;
    L64:
        r36 = r116;
    L65:
        if (r36 == true) goto L67;
        if (r27 == true) goto L67;
    L68:
        r22.layout(r38, r40, r41, r42);
        return;
    L67:
        r22.measure(View.MeasureSpec.makeMeasureSpec(r43, 1073741824), View.MeasureSpec.makeMeasureSpec(r44, 1073741824));
        goto L68
    L63:
        if (r44 == r22.getMeasuredHeight()) goto L65;
    L48:
        r36 = false;
        r116 = true;
        goto L50
    L53:
        r113 = r7;
        r36 = false;
        r116 = true;
        if (Float.isNaN(r29) == true) goto L57;
        r22.setRotation((((float) Math.toDegrees(Math.atan2(r16 + (r18 / 2.0f), r15 + (r17 / 2.0f)))) + r29) + 0.0f);
        goto L57
    L5:
        if (this.mTempValue.length > r23[r23.length - 1]) goto L7;
        int r45 = r23[r23.length - 1] + 1;
        this.mTempValue = new double[r45];
        this.mTempDelta = new double[r45];
        goto L7
    }

    void getRect(int[] r10, double[] r11, float[] r12, int r13) {
        float r0 = this.mX;
        float r1 = this.mY;
        float r2 = this.mWidth;
        float r3 = this.mHeight;
        int r4 = 0;
    L4:
        if (r4 >= r10.length) goto L19;
        float r5 = (float) r11[r4];
        int r6 = r10[r4];
        if (r6 != 1) goto L8;
        r0 = r5;
    L18:
        r4 = r4 + 1;
        goto L4
    L8:
        if (r6 != 2) goto L10;
        r1 = r5;
        goto L18
    L10:
        if (r6 != 3) goto L12;
        r2 = r5;
        goto L18
    L12:
        if (r6 != 4) goto L18;
        r3 = r5;
        goto L18
    L19:
        MotionController r14 = this.mRelativeToController;
        if (r14 == null) goto L22;
        float r15 = r14.getCenterX();
        float r9 = this.mRelativeToController.getCenterY();
        double r7 = r0;
        double r8 = r1;
        float r16 = (float) ((((double) r15) + (Math.sin(r8) * r7)) - ((double) (r2 / 2.0f)));
        r1 = (float) ((((double) r9) - (r7 * Math.cos(r8))) - ((double) (r3 / 2.0f)));
        r0 = r16;
    L22:
        float r17 = r2 + r0;
        float r18 = r3 + r1;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        int r19 = r13 + 1;
        r12[r13] = r0 + 0.0f;
        int r110 = r19 + 1;
        r12[r19] = r1 + 0.0f;
        int r20 = r110 + 1;
        r12[r110] = r17 + 0.0f;
        int r111 = r20 + 1;
        r12[r20] = r1 + 0.0f;
        int r21 = r111 + 1;
        r12[r111] = r17 + 0.0f;
        int r112 = r21 + 1;
        r12[r21] = r18 + 0.0f;
        r12[r112] = r0 + 0.0f;
        r12[r112 + 1] = r18 + 0.0f;
    }

    void setDpDt(float r13, float r14, float[] r15, int[] r16, double[] r17, double[] r18) {
        float r4 = 0.0f;
        float r5 = 0.0f;
        float r6 = 0.0f;
        float r7 = 0.0f;
        int r3 = 0;
    L4:
        if (r3 >= r16.length) goto L19;
        float r8 = (float) r17[r3];
        double r10 = r18[r3];
        int r11 = r16[r3];
        if (r11 != 1) goto L8;
        r4 = r8;
    L18:
        r3 = r3 + 1;
        goto L4
    L8:
        if (r11 != 2) goto L10;
        r6 = r8;
        goto L18
    L10:
        if (r11 != 3) goto L12;
        r5 = r8;
        goto L18
    L12:
        if (r11 != 4) goto L18;
        r7 = r8;
        goto L18
    L19:
        float r9 = r4 - ((0.0f * r5) / 2.0f);
        float r12 = r6 - ((0.0f * r7) / 2.0f);
        r15[0] = ((r9 * (1.0f - r13)) + (((r5 * 1.0f) + r9) * r13)) + 0.0f;
        r15[1] = ((r12 * (1.0f - r14)) + (((r7 * 1.0f) + r12) * r14)) + 0.0f;
    }

    void fillStandard(double[] r8, int[] r9) {
        int r3 = 0;
        float[] r1 = {this.mPosition, this.mX, this.mY, this.mWidth, this.mHeight, this.mPathRotate};
        int r7 = 0;
    L4:
        if (r3 >= r9.length) goto L9;
        int r2 = r9[r3];
        if (r2 >= 6) goto L8;
        r8[r7] = r1[r2];
        r7 = r7 + 1;
    L8:
        r3 = r3 + 1;
        goto L4
    }

    boolean hasCustomData(String r1) {
        return this.mAttributes.containsKey(r1);
    }

    int getCustomDataCount(String r1) {
        ConstraintAttribute r0 = this.mAttributes.get(r1);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.numberOfInterpolatedValues();
    }

    int getCustomData(String r5, double[] r6, int r7) {
        ConstraintAttribute r4 = this.mAttributes.get(r5);
        int r8 = 0;
        if (r4 != null) goto L6;
        return 0;
    L6:
        if (r4.numberOfInterpolatedValues() != 1) goto L9;
        r6[r7] = r4.getValueToInterpolate();
        return 1;
    L9:
        int r0 = r4.numberOfInterpolatedValues();
        float[] r1 = new float[r0];
        r4.getValuesToInterpolate(r1);
    L10:
        if (r8 >= r0) goto L12;
        r6[r7] = r1[r8];
        r8 = r8 + 1;
        r7 = r7 + 1;
        goto L10
    L12:
        return r0;
    }

    void setBounds(float r1, float r2, float r3, float r4) {
        this.mX = r1;
        this.mY = r2;
        this.mWidth = r3;
        this.mHeight = r4;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(MotionPaths r1) {
        return Float.compare(this.mPosition, r1.mPosition);
    }

    public void applyParameters(ConstraintSet.Constraint r5) {
        this.mKeyFrameEasing = Easing.getInterpolator(r5.motion.mTransitionEasing);
        this.mPathMotionArc = r5.motion.mPathMotionArc;
        this.mAnimateRelativeTo = r5.motion.mAnimateRelativeTo;
        this.mPathRotate = r5.motion.mPathRotate;
        this.mDrawPath = r5.motion.mDrawPath;
        this.mAnimateCircleAngleTo = r5.motion.mAnimateCircleAngleTo;
        this.mProgress = r5.propertySet.mProgress;
        this.mRelativeAngle = r5.layout.circleAngle;
        Iterator<String> r0 = r5.mCustomConstraints.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        String r1 = r0.next();
        ConstraintAttribute r2 = r5.mCustomConstraints.get(r1);
        if (r2 == null) goto L4;
        if (r2.isContinuous() == false) goto L4;
        this.mAttributes.put(r1, r2);
        goto L4
    }

    public void configureRelativeTo(MotionController r3) {
        r3.getPos(this.mProgress);
    }
}
