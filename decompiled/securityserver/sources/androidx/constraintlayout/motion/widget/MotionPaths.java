package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
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
    static String[] names;
    LinkedHashMap<String, ConstraintAttribute> attributes;
    float height;
    int mAnimateCircleAngleTo;
    int mAnimateRelativeTo;
    int mDrawPath;
    Easing mKeyFrameEasing;
    int mMode;
    int mPathMotionArc;
    float mPathRotate;
    float mProgress;
    float mRelativeAngle;
    MotionController mRelativeToController;
    double[] mTempDelta;
    double[] mTempValue;
    float position;
    float time;
    float width;
    float x;
    float y;

    static {
        names = new String[]{"position", "x", "y", "width", "height", "pathRotate"};
    }

    public MotionPaths() {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        int r2 = Key.UNSET;
        this.mPathMotionArc = r2;
        this.mAnimateRelativeTo = r2;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.attributes = new LinkedHashMap();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    private boolean diff(float r3, float r4) {
        if (Float.isNaN(r3) == true) goto L12;
        if (Float.isNaN(r4) == true) goto L12;
        if (Math.abs(r3 - r4) > 1.0E-6f) goto L10;
        return false;
    L10:
        return true;
    L12:
        if (Float.isNaN(r3) != Float.isNaN(r4)) goto L14;
        return false;
    L14:
        return true;
    }

    private static final float xRotate(float r0, float r1, float r2, float r3, float r4, float r5) {
        return (((r4 - r2) * r1) - ((r5 - r3) * r0)) + r2;
    }

    private static final float yRotate(float r0, float r1, float r2, float r3, float r4, float r5) {
        float r6 = (r5 - r3) * r1;
        return (r6 + ((r4 - r2) * r0)) + r3;
    }

    public void applyParameters(ConstraintSet.Constraint r5) {
        this.mKeyFrameEasing = Easing.getInterpolator(r5.motion.mTransitionEasing);
        ConstraintSet.Motion r0 = r5.motion;
        this.mPathMotionArc = r0.mPathMotionArc;
        this.mAnimateRelativeTo = r0.mAnimateRelativeTo;
        this.mPathRotate = r0.mPathRotate;
        this.mDrawPath = r0.mDrawPath;
        this.mAnimateCircleAngleTo = r0.mAnimateCircleAngleTo;
        this.mProgress = r5.propertySet.mProgress;
        this.mRelativeAngle = r5.layout.circleAngle;
        Iterator<String> r1 = r5.mCustomConstraints.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        String r2 = r1.next();
        ConstraintAttribute r3 = r5.mCustomConstraints.get(r2);
        if (r3 == null) goto L4;
        if (r3.isContinuous() == false) goto L4;
        this.attributes.put(r2, r3);
        goto L4
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(@NonNull MotionPaths r1) {
        return compareTo2(r1);
    }

    public void configureRelativeTo(MotionController r3) {
        r3.getPos(this.mProgress);
    }

    public void different(MotionPaths r6, boolean[] r7, String[] r8, boolean r9) {
        boolean r10 = diff(this.x, r6.x);
        boolean r0 = diff(this.y, r6.y);
        r7[0] = r7[0] | diff(this.position, r6.position);
        boolean r11 = (r10 | r0) | r9;
        r7[1] = r7[1] | r11;
        r7[2] = r11 | r7[2];
        r7[3] = r7[3] | diff(this.width, r6.width);
        boolean r12 = r7[4];
        r7[4] = diff(this.height, r6.height) | r12;
    }

    public void fillStandard(double[] r9, int[] r10) {
        int r7 = 0;
        float[] r6 = {this.position, this.x, this.y, this.width, this.height, this.mPathRotate};
        int r8 = 0;
    L4:
        if (r7 >= r10.length) goto L9;
        int r1 = r10[r7];
        if (r1 >= 6) goto L8;
        r9[r8] = r6[r1];
        r8 = r8 + 1;
    L8:
        r7 = r7 + 1;
        goto L4
    }

    public void getBounds(int[] r6, double[] r7, float[] r8, int r9) {
        float r0 = this.width;
        float r5 = this.height;
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

    public void getCenter(double r16, int[] r18, double[] r19, float[] r20, int r21) {
        float r2 = this.x;
        float r3 = this.y;
        float r4 = this.width;
        float r5 = this.height;
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
        double r13 = Math.sin(r10) * r12;
        r3 = (float) ((((double) r6) - (Math.cos(r10) * r12)) - ((double) (r5 / 2.0f)));
        r2 = (float) ((r13 + ((double) r1)) - ((double) (r4 / 2.0f)));
    L21:
        r20[r21] = ((r4 / 2.0f) + r2) + 0.0f;
        r20[r21 + 1] = ((r5 / 2.0f) + r3) + 0.0f;
    }

    public void getCenterVelocity(double r16, int[] r18, double[] r19, float[] r20, int r21) {
        float r2 = this.x;
        float r3 = this.y;
        float r4 = this.width;
        float r5 = this.height;
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
        double r13 = Math.sin(r10) * r12;
        r3 = (float) ((((double) r6) - (Math.cos(r10) * r12)) - ((double) (r5 / 2.0f)));
        r2 = (float) ((r13 + ((double) r1)) - ((double) (r4 / 2.0f)));
    L21:
        r20[r21] = ((r4 / 2.0f) + r2) + 0.0f;
        r20[r21 + 1] = ((r5 / 2.0f) + r3) + 0.0f;
    }

    public int getCustomData(String r5, double[] r6, int r7) {
        ConstraintAttribute r4 = this.attributes.get(r5);
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

    public int getCustomDataCount(String r1) {
        ConstraintAttribute r0 = this.attributes.get(r1);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.numberOfInterpolatedValues();
    }

    public void getRect(int[] r11, double[] r12, float[] r13, int r14) {
        float r0 = this.x;
        float r1 = this.y;
        float r2 = this.width;
        float r3 = this.height;
        int r4 = 0;
    L4:
        if (r4 >= r11.length) goto L19;
        float r5 = (float) r12[r4];
        int r6 = r11[r4];
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
        MotionController r15 = this.mRelativeToController;
        if (r15 == null) goto L22;
        float r16 = r15.getCenterX();
        float r10 = this.mRelativeToController.getCenterY();
        double r7 = r0;
        double r8 = r1;
        float r17 = (float) (((Math.sin(r8) * r7) + ((double) r16)) - ((double) (r2 / 2.0f)));
        r1 = (float) ((((double) r10) - (Math.cos(r8) * r7)) - ((double) (r3 / 2.0f)));
        r0 = r17;
    L22:
        float r9 = r2 + r0;
        float r18 = r3 + r1;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        r13[r14] = r0 + 0.0f;
        r13[r14 + 1] = r1 + 0.0f;
        r13[r14 + 2] = r9 + 0.0f;
        r13[r14 + 3] = r1 + 0.0f;
        r13[r14 + 4] = r9 + 0.0f;
        int r19 = r14 + 6;
        r13[r14 + 5] = r18 + 0.0f;
        r13[r19] = r0 + 0.0f;
        r13[r14 + 7] = r18 + 0.0f;
    }

    public boolean hasCustomData(String r1) {
        return this.attributes.containsKey(r1);
    }

    public void initCartesian(KeyPosition r18, MotionPaths r19, MotionPaths r20) {
        float r4 = r18.mFramePosition / 100.0f;
        this.time = r4;
        this.mDrawPath = r18.mDrawPath;
        if (Float.isNaN(r18.mPercentWidth) == false) goto L5;
        float r5 = r4;
    L7:
        if (Float.isNaN(r18.mPercentHeight) == false) goto L9;
        float r6 = r4;
    L10:
        float r7 = r20.width;
        float r8 = r19.width;
        float r9 = r7 - r8;
        float r10 = r20.height;
        float r11 = r19.height;
        float r12 = r10 - r11;
        this.position = this.time;
        float r13 = r19.x;
        float r1 = r19.y;
        float r14 = (r7 / 2.0f) + r20.x;
        float r15 = r14 - ((r8 / 2.0f) + r13);
        float r16 = ((r10 / 2.0f) + r20.y) - ((r11 / 2.0f) + r1);
        float r17 = r9 * r5;
        float r3 = r17 / 2.0f;
        this.x = (int) (((r15 * r4) + r13) - r3);
        float r2 = (r16 * r4) + r1;
        float r110 = r12 * r6;
        float r21 = r110 / 2.0f;
        this.y = (int) (r2 - r21);
        this.width = (int) (r8 + r17);
        this.height = (int) (r11 + r110);
        if (Float.isNaN(r18.mPercentX) == false) goto L13;
        float r22 = r4;
    L14:
        float r23 = 0.0f;
        if (Float.isNaN(r18.mAltPercentY) == false) goto L17;
        float r24 = 0.0f;
    L19:
        if (Float.isNaN(r18.mPercentY) == true) goto L23;
        r4 = r18.mPercentY;
    L23:
        if (Float.isNaN(r18.mAltPercentX) == true) goto L26;
        r23 = r18.mAltPercentX;
    L26:
        this.mMode = 0;
        float r25 = r23 * r16;
        this.x = (int) ((r25 + ((r22 * r15) + r19.x)) - r3);
        float r111 = r16 * r4;
        this.y = (int) ((r111 + ((r15 * r24) + r19.y)) - r21);
        this.mKeyFrameEasing = Easing.getInterpolator(r18.mTransitionEasing);
        this.mPathMotionArc = r18.mPathMotionArc;
        return;
    L17:
        r24 = r18.mAltPercentY;
        goto L19
    L13:
        r22 = r18.mPercentX;
        goto L14
    L9:
        r6 = r18.mPercentHeight;
        goto L10
    L5:
        r5 = r18.mPercentWidth;
        goto L7
    }

    public void initPath(KeyPosition r17, MotionPaths r18, MotionPaths r19) {
        float r4 = r17.mFramePosition / 100.0f;
        this.time = r4;
        this.mDrawPath = r17.mDrawPath;
        if (Float.isNaN(r17.mPercentWidth) == false) goto L5;
        float r5 = r4;
    L7:
        if (Float.isNaN(r17.mPercentHeight) == false) goto L9;
        float r6 = r4;
    L10:
        float r7 = r19.width - r18.width;
        float r8 = r19.height - r18.height;
        this.position = this.time;
        if (Float.isNaN(r17.mPercentX) == true) goto L14;
        r4 = r17.mPercentX;
    L14:
        float r9 = r18.x;
        float r10 = r18.width;
        float r13 = r18.y;
        float r14 = r18.height;
        float r1 = (r19.width / 2.0f) + r19.x;
        float r2 = r1 - ((r10 / 2.0f) + r9);
        float r3 = ((r19.height / 2.0f) + r19.y) - ((r14 / 2.0f) + r13);
        float r11 = r2 * r4;
        float r12 = r7 * r5;
        float r15 = r12 / 2.0f;
        this.x = (int) ((r9 + r11) - r15);
        float r16 = r4 * r3;
        float r20 = r8 * r6;
        float r21 = r20 / 2.0f;
        this.y = (int) ((r13 + r16) - r21);
        this.width = (int) (r10 + r12);
        this.height = (int) (r14 + r20);
        if (Float.isNaN(r17.mPercentY) == false) goto L17;
        float r22 = 0.0f;
    L18:
        this.mMode = 1;
        float r23 = (int) ((r18.x + r11) - r15);
        float r24 = (int) ((r18.y + r16) - r21);
        this.x = r23 + ((-r3) * r22);
        this.y = r24 + (r2 * r22);
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

    public void initPolar(int r7, int r8, KeyPosition r9, MotionPaths r10, MotionPaths r11) {
        float r12 = r9.mFramePosition / 100.0f;
        this.time = r12;
        this.mDrawPath = r9.mDrawPath;
        this.mMode = r9.mPositionType;
        if (Float.isNaN(r9.mPercentWidth) == false) goto L5;
        float r13 = r12;
    L7:
        if (Float.isNaN(r9.mPercentHeight) == false) goto L9;
        float r0 = r12;
    L10:
        float r1 = r11.width;
        float r2 = r10.width;
        float r3 = r11.height;
        float r4 = r10.height;
        this.position = this.time;
        this.width = (int) (((r1 - r2) * r13) + r2);
        this.height = (int) (((r3 - r4) * r0) + r4);
        int r5 = r9.mPositionType;
        if (r5 == 1) goto L33;
        if (r5 == 2) goto L24;
        if (Float.isNaN(r9.mPercentX) == false) goto L17;
        float r14 = r12;
    L18:
        float r6 = r11.x;
        float r15 = r10.x;
        this.x = a.a.a(r6, r15, r14, r15);
        if (Float.isNaN(r9.mPercentY) == true) goto L22;
        r12 = r9.mPercentY;
    L22:
        float r16 = r11.y;
        float r17 = r10.y;
        this.y = a.a.a(r16, r17, r12, r17);
    L41:
        this.mAnimateRelativeTo = r10.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(r9.mTransitionEasing);
        this.mPathMotionArc = r9.mPathMotionArc;
        return;
    L17:
        r14 = r9.mPercentX;
        goto L18
    L24:
        if (Float.isNaN(r9.mPercentX) == false) goto L26;
        float r18 = r11.x;
        float r19 = r10.x;
        float r20 = a.a.a(r18, r19, r12, r19);
    L27:
        this.x = r20;
        if (Float.isNaN(r9.mPercentY) == false) goto L30;
        float r21 = r11.y;
        float r110 = r10.y;
        float r22 = a.a.a(r21, r110, r12, r110);
    L31:
        this.y = r22;
        goto L41
    L30:
        r22 = r9.mPercentY;
        goto L31
    L26:
        r20 = Math.min(r0, r13) * r9.mPercentX;
        goto L27
    L33:
        if (Float.isNaN(r9.mPercentX) == false) goto L35;
        float r23 = r12;
    L36:
        float r24 = r11.x;
        float r25 = r10.x;
        this.x = a.a.a(r24, r25, r23, r25);
        if (Float.isNaN(r9.mPercentY) == true) goto L40;
        r12 = r9.mPercentY;
    L40:
        float r26 = r11.y;
        float r111 = r10.y;
        this.y = a.a.a(r26, r111, r12, r111);
        goto L41
    L35:
        r23 = r9.mPercentX;
        goto L36
    L9:
        r0 = r9.mPercentHeight;
        goto L10
    L5:
        r13 = r9.mPercentWidth;
        goto L7
    }

    public void initScreen(int r18, int r19, KeyPosition r20, MotionPaths r21, MotionPaths r22) {
        float r4 = r20.mFramePosition / 100.0f;
        this.time = r4;
        this.mDrawPath = r20.mDrawPath;
        if (Float.isNaN(r20.mPercentWidth) == false) goto L5;
        float r5 = r4;
    L7:
        if (Float.isNaN(r20.mPercentHeight) == false) goto L9;
        float r6 = r4;
    L10:
        float r7 = r22.width;
        float r8 = r21.width;
        float r9 = r7 - r8;
        float r10 = r22.height;
        float r11 = r21.height;
        float r12 = r10 - r11;
        this.position = this.time;
        float r13 = r21.x;
        float r2 = r21.y;
        float r14 = (r7 / 2.0f) + r22.x;
        float r15 = (r10 / 2.0f) + r22.y;
        float r16 = r9 * r5;
        this.x = (int) ((((r14 - ((r8 / 2.0f) + r13)) * r4) + r13) - (r16 / 2.0f));
        float r17 = r12 * r6;
        this.y = (int) ((((r15 - ((r11 / 2.0f) + r2)) * r4) + r2) - (r17 / 2.0f));
        this.width = (int) (r8 + r16);
        this.height = (int) (r11 + r17);
        this.mMode = 2;
        if (Float.isNaN(r20.mPercentX) == true) goto L14;
        this.x = (int) (r20.mPercentX * ((int) (r18 - this.width)));
    L14:
        if (Float.isNaN(r20.mPercentY) == true) goto L16;
        this.y = (int) (r20.mPercentY * ((int) (r19 - this.height)));
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

    public void setBounds(float r1, float r2, float r3, float r4) {
        this.x = r1;
        this.y = r2;
        this.width = r3;
        this.height = r4;
    }

    public void setDpDt(float r13, float r14, float[] r15, int[] r16, double[] r17, double[] r18) {
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
        r15[0] = ((((r5 * 1.0f) + r9) * r13) + ((1.0f - r13) * r9)) + 0.0f;
        r15[1] = ((((r7 * 1.0f) + r12) * r14) + ((1.0f - r14) * r12)) + 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setView(float r21, View r22, int[] r23, double[] r24, double[] r25, double[] r26, boolean r27) {
        float r4 = this.x;
        float r5 = this.y;
        float r6 = this.width;
        float r7 = this.height;
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
        if (Double.isNaN(this.mTempValue[r14]) == false) goto L25;
    L24:
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
    L25:
        r19 = this.mTempValue[r14] + r19;
        goto L24
    L43:
        float r29 = r13;
        MotionController r0 = this.mRelativeToController;
        if (r0 == null) goto L52;
        float[] r20 = new float[2];
        float[] r110 = new float[2];
        r0.getCenter(r21, r20, r110);
        float r111 = r20[0];
        float r30 = r20[1];
        float r112 = r110[0];
        float r1 = r110[1];
        double r3 = r4;
        double r31 = r5;
        float r113 = (float) (((Math.sin(r31) * r3) + ((double) r111)) - ((double) (r6 / 2.0f)));
        float r32 = (float) ((((double) r30) - (Math.cos(r31) * r3)) - ((double) (r7 / 2.0f)));
        double r114 = r15;
        double r115 = r16;
        float r33 = (float) (((Math.cos(r31) * r3) * r115) + ((Math.sin(r31) * r114) + ((double) r112)));
        float r116 = r7;
        float r34 = (float) (((Math.sin(r31) * r3) * r115) + (((double) r1) - (Math.cos(r31) * r114)));
        if (r25.length < 2) goto L49;
        r25[0] = r33;
        r25[1] = r34;
    L49:
        if (Float.isNaN(r29) == true) goto L51;
        r22.setRotation((float) (Math.toDegrees(Math.atan2(r34, r33)) + ((double) r29)));
    L51:
        r4 = r113;
        r5 = r32;
    L56:
        if ((r22 instanceof FloatLayout) == false) goto L59;
        ((FloatLayout) r22).layout(r4, r5, r6 + r4, r5 + r116);
        return;
    L59:
        float r35 = r4 + 0.5f;
        int r36 = (int) r35;
        float r37 = r5 + 0.5f;
        int r38 = (int) r37;
        int r39 = (int) (r35 + r6);
        int r40 = (int) (r37 + r116);
        int r41 = r39 - r36;
        int r42 = r40 - r38;
        if (r41 == r22.getMeasuredWidth()) goto L62;
    L65:
        r22.measure(View.MeasureSpec.makeMeasureSpec(r41, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(r42, BasicMeasure.EXACTLY));
    L66:
        r22.layout(r36, r38, r39, r40);
        return;
    L62:
        if (r42 != r22.getMeasuredHeight()) goto L65;
        if (r27 == false) goto L66;
    L52:
        r116 = r7;
        if (Float.isNaN(r29) == true) goto L56;
        r22.setRotation((float) ((Math.toDegrees(Math.atan2((r18 / 2.0f) + r16, (r17 / 2.0f) + r15)) + ((double) r29)) + ((double) 0.0f)));
        goto L56
    L5:
        if (this.mTempValue.length > r23[r23.length - 1]) goto L7;
        int r43 = r23[r23.length - 1] + 1;
        this.mTempValue = new double[r43];
        this.mTempDelta = new double[r43];
        goto L7
    }

    public void setupRelative(MotionController r6, MotionPaths r7) {
        double r0 = (((this.width / 2.0f) + this.x) - r7.x) - (r7.width / 2.0f);
        double r2 = (((this.height / 2.0f) + this.y) - r7.y) - (r7.height / 2.0f);
        this.mRelativeToController = r6;
        this.x = (float) Math.hypot(r2, r0);
        if (Float.isNaN(this.mRelativeAngle) == false) goto L5;
        this.y = (float) (Math.atan2(r2, r0) + 1.5707963267948966d);
        return;
    L5:
        this.y = (float) Math.toRadians(this.mRelativeAngle);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(@NonNull MotionPaths r1) {
        return Float.compare(this.position, r1.position);
    }

    public MotionPaths(int r4, int r5, KeyPosition r6, MotionPaths r7, MotionPaths r8) {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        int r2 = Key.UNSET;
        this.mPathMotionArc = r2;
        this.mAnimateRelativeTo = r2;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.attributes = new LinkedHashMap();
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
        if (r0 == 2) goto L12;
        initCartesian(r6, r7, r8);
        return;
    L12:
        initScreen(r4, r5, r6, r7, r8);
    }

    public void getCenter(double r19, int[] r21, double[] r22, float[] r23, double[] r24, float[] r25) {
        float r2 = this.x;
        float r3 = this.y;
        float r4 = this.width;
        float r5 = this.height;
        int r8 = 0;
        float r9 = 0.0f;
        float r10 = 0.0f;
        float r11 = 0.0f;
        float r12 = 0.0f;
    L4:
        if (r8 >= r21.length) goto L19;
        float r6 = (float) r22[r8];
        float r13 = (float) r24[r8];
        int r14 = r21[r8];
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
        r0.getCenter(r19, r7, r17);
        float r18 = r7[0];
        float r20 = r7[1];
        float r110 = r17[0];
        float r1 = r17[1];
        double r26 = r2;
        double r111 = r3;
        float r27 = (float) (((Math.sin(r111) * r26) + ((double) r18)) - ((double) (r4 / 2.0f)));
        r3 = (float) ((((double) r20) - (Math.cos(r111) * r26)) - ((double) (r5 / 2.0f)));
        double r28 = r9;
        double r29 = r11;
        float r30 = (float) ((Math.cos(r111) * r29) + ((Math.sin(r111) * r28) + ((double) r110)));
        r16 = (float) ((Math.sin(r111) * r29) + (((double) r1) - (Math.cos(r111) * r28)));
        r15 = r30;
        r2 = r27;
        float r31 = 2.0f;
    L23:
        r23[0] = ((r4 / r31) + r2) + 0.0f;
        r23[1] = ((r5 / r31) + r3) + 0.0f;
        r25[0] = r15;
        r25[1] = r16;
        return;
    L22:
        r31 = 2.0f;
        goto L23
    }
}
