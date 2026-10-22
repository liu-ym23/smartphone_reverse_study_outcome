package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.motion.utils.CustomSupport;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.motion.utils.ViewState;
import androidx.constraintlayout.motion.utils.ViewTimeCycle;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class MotionController {
    static final int BOUNCE = 4;
    private static final boolean DEBUG = false;
    public static final int DRAW_PATH_AS_CONFIGURED = 4;
    public static final int DRAW_PATH_BASIC = 1;
    public static final int DRAW_PATH_CARTESIAN = 3;
    public static final int DRAW_PATH_NONE = 0;
    public static final int DRAW_PATH_RECTANGLE = 5;
    public static final int DRAW_PATH_RELATIVE = 2;
    public static final int DRAW_PATH_SCREEN = 6;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final boolean FAVOR_FIXED_SIZE_VIEWS = false;
    public static final int HORIZONTAL_PATH_X = 2;
    public static final int HORIZONTAL_PATH_Y = 3;
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    private static final int INTERPOLATOR_UNDEFINED = -3;
    static final int LINEAR = 3;
    static final int OVERSHOOT = 5;
    public static final int PATH_PERCENT = 0;
    public static final int PATH_PERPENDICULAR = 1;
    public static final int ROTATION_LEFT = 2;
    public static final int ROTATION_RIGHT = 1;
    private static final int SPLINE_STRING = -1;
    private static final String TAG = "MotionController";
    public static final int VERTICAL_PATH_X = 4;
    public static final int VERTICAL_PATH_Y = 5;
    private int MAX_DIMENSION;
    String[] attributeTable;
    private CurveFit mArcSpline;
    private int[] mAttributeInterpolatorCount;
    private String[] mAttributeNames;
    private HashMap<String, ViewSpline> mAttributesMap;
    String mConstraintTag;
    float mCurrentCenterX;
    float mCurrentCenterY;
    private int mCurveFitType;
    private HashMap<String, ViewOscillator> mCycleMap;
    private MotionPaths mEndMotionPath;
    private MotionConstrainedPoint mEndPoint;
    boolean mForceMeasure;
    int mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private ArrayList<Key> mKeyList;
    private KeyTrigger[] mKeyTriggers;
    private ArrayList<MotionPaths> mMotionPaths;
    float mMotionStagger;
    private boolean mNoMovement;
    private int mPathMotionArc;
    private Interpolator mQuantizeMotionInterpolator;
    private float mQuantizeMotionPhase;
    private int mQuantizeMotionSteps;
    private CurveFit[] mSpline;
    float mStaggerOffset;
    float mStaggerScale;
    private MotionPaths mStartMotionPath;
    private MotionConstrainedPoint mStartPoint;
    Rect mTempRect;
    private HashMap<String, ViewTimeCycle> mTimeCycleAttributesMap;
    private int mTransformPivotTarget;
    private View mTransformPivotView;
    private float[] mValuesBuff;
    private float[] mVelocity;
    View mView;

    MotionController(View r5) {
        this.mTempRect = new Rect();
        this.mForceMeasure = false;
        this.mCurveFitType = -1;
        this.mStartMotionPath = new MotionPaths();
        this.mEndMotionPath = new MotionPaths();
        this.mStartPoint = new MotionConstrainedPoint();
        this.mEndPoint = new MotionConstrainedPoint();
        this.mMotionStagger = Float.NaN;
        this.mStaggerOffset = 0.0f;
        this.mStaggerScale = 1.0f;
        this.MAX_DIMENSION = 4;
        this.mValuesBuff = new float[4];
        this.mMotionPaths = new ArrayList();
        this.mVelocity = new float[1];
        this.mKeyList = new ArrayList();
        int r2 = Key.UNSET;
        this.mPathMotionArc = r2;
        this.mTransformPivotTarget = r2;
        this.mTransformPivotView = null;
        this.mQuantizeMotionSteps = r2;
        this.mQuantizeMotionPhase = Float.NaN;
        this.mQuantizeMotionInterpolator = null;
        this.mNoMovement = false;
        setView(r5);
    }

    private float getAdjustedPosition(float r11, float[] r12) {
        float r0 = 0.0f;
        float r2 = 1.0f;
        if (r12 == null) goto L5;
        r12[0] = 1.0f;
    L15:
        Easing r3 = this.mStartMotionPath.mKeyFrameEasing;
        float r4 = Float.NaN;
        Iterator<MotionPaths> r10 = this.mMotionPaths.iterator();
    L17:
        if (r10.hasNext() == false) goto L26;
        MotionPaths r5 = r10.next();
        Easing r6 = r5.mKeyFrameEasing;
        if (r6 == null) goto L17;
        float r7 = r5.time;
        if (r7 < r11) goto L22;
        if (Float.isNaN(r4) == false) goto L17;
        r4 = r5.time;
        goto L17
    L22:
        r3 = r6;
        r0 = r7;
        goto L17
    L26:
        if (r3 != null) goto L28;
        return r11;
    L28:
        if (Float.isNaN(r4) == true) goto L31;
        r2 = r4;
    L31:
        float r8 = r2 - r0;
        double r13 = (r11 - r0) / r8;
        float r1 = r0 + (((float) r3.get(r13)) * r8);
        if (r12 == null) goto L35;
        r12[0] = (float) r3.getDiff(r13);
    L35:
        return r1;
    L5:
        float r9 = this.mStaggerScale;
        if (r9 == 1.0d) goto L15;
        float r14 = this.mStaggerOffset;
        if (r11 >= r14) goto L11;
        r11 = 0.0f;
    L11:
        if (r11 <= r14) goto L15;
        if (r11 >= 1.0d) goto L15;
        r11 = Math.min((r11 - r14) * r9, 1.0f);
        goto L15
    }

    private static Interpolator getInterpolator(Context r1, int r2, String r3, int r4) {
        if (r2 == (-2)) goto L30;
        if (r2 == (-1)) goto L27;
        if (r2 == 0) goto L26;
        if (r2 == 1) goto L24;
        if (r2 == 2) goto L22;
        if (r2 == 4) goto L20;
        if (r2 == 5) goto L18;
        return null;
    L18:
        return new OvershootInterpolator();
    L20:
        return new BounceInterpolator();
    L22:
        return new DecelerateInterpolator();
    L24:
        return new AccelerateInterpolator();
    L26:
        return new AccelerateDecelerateInterpolator();
    L27:
        final Easing r5 = Easing.getInterpolator(r3);
        return new AnonymousClass1(r5);
    L30:
        return AnimationUtils.loadInterpolator(r1, r4);
    }

    private float getPreCycleDistance() {
        float[] r1 = new float[2];
        float r10 = 1.0f / 99;
        double r13 = 0.0d;
        double r15 = 0.0d;
        float r7 = 0.0f;
        int r8 = 0;
    L4:
        if (r8 >= 100) goto L28;
        float r2 = r8 * r10;
        double r3 = r2;
        Easing r5 = this.mStartMotionPath.mKeyFrameEasing;
        Iterator<MotionPaths> r6 = this.mMotionPaths.iterator();
        float r17 = Float.NaN;
        float r18 = 0.0f;
    L7:
        if (r6.hasNext() == false) goto L17;
        MotionPaths r9 = r6.next();
        Easing r11 = r9.mKeyFrameEasing;
        if (r11 == null) goto L7;
        float r12 = r9.time;
        if (r12 >= r2) goto L14;
        r5 = r11;
        r18 = r12;
        goto L7
    L14:
        if (Float.isNaN(r17) == false) goto L7;
        r17 = r9.time;
        goto L7
    L17:
        if (r5 != null) goto L19;
    L22:
        this.mSpline[0].getPos(r3, this.mInterpolateData);
        float r14 = r7;
        int r16 = r8;
        this.mStartMotionPath.getCenter(r3, this.mInterpolateVariables, this.mInterpolateData, r1, 0);
        if (r16 <= 0) goto L25;
        char r19 = 0;
        float r4 = (float) (((double) r14) + Math.hypot(r15 - ((double) r1[1]), r13 - ((double) r1[0])));
    L26:
        r13 = r1[r19];
        r8 = r16 + 1;
        r7 = r4;
        r15 = r1[1];
        goto L4
    L25:
        r19 = 0;
        r4 = r14;
        goto L26
    L19:
        if (Float.isNaN(r17) == false) goto L21;
        r17 = 1.0f;
    L21:
        float r110 = r17 - r18;
        r3 = (((float) r5.get((r2 - r18) / r110)) * r110) + r18;
        goto L22
    L28:
        return r7;
    }

    private void insertKey(MotionPaths r4) {
        int r0 = Collections.binarySearch(this.mMotionPaths, r4);
        if (r0 != 0) goto L5;
        Log.e(TAG, " KeyPath position \"" + r4.position + "\" outside of range");
    L5:
        this.mMotionPaths.add((-r0) - 1, r4);
    }

    private void readView(MotionPaths r4) {
        r4.setBounds((int) this.mView.getX(), (int) this.mView.getY(), this.mView.getWidth(), this.mView.getHeight());
    }

    public void addKey(Key r1) {
        this.mKeyList.add(r1);
    }

    void addKeys(ArrayList<Key> r1) {
        this.mKeyList.addAll(r1);
    }

    void buildBounds(float[] r18, int r19) {
        float r2 = 1.0f / (r19 - 1);
        HashMap<String, ViewSpline> r4 = this.mAttributesMap;
        if (r4 == null) goto L6;
        ViewSpline r5 = r4.get("translationX");
    L6:
        HashMap<String, ViewSpline> r6 = this.mAttributesMap;
        if (r6 == null) goto L10;
        ViewSpline r7 = r6.get("translationY");
    L10:
        HashMap<String, ViewOscillator> r8 = this.mCycleMap;
        if (r8 == null) goto L14;
        ViewOscillator r9 = r8.get("translationX");
    L14:
        HashMap<String, ViewOscillator> r10 = this.mCycleMap;
        if (r10 == null) goto L18;
        ViewOscillator r11 = r10.get("translationY");
    L18:
        int r12 = 0;
    L19:
        if (r12 >= r19) goto L52;
        float r13 = r12 * r2;
        float r14 = this.mStaggerScale;
        float r15 = 0.0f;
        if (r14 == 1.0f) goto L30;
        float r16 = this.mStaggerOffset;
        if (r13 >= r16) goto L26;
        r13 = 0.0f;
    L26:
        if (r13 <= r16) goto L30;
        if (r13 >= 1.0d) goto L30;
        r13 = Math.min((r13 - r16) * r14, 1.0f);
    L30:
        double r17 = r13;
        Easing r110 = this.mStartMotionPath.mKeyFrameEasing;
        float r111 = Float.NaN;
        Iterator<MotionPaths> r112 = this.mMotionPaths.iterator();
    L32:
        if (r112.hasNext() == false) goto L41;
        MotionPaths r113 = r112.next();
        Easing r114 = r113.mKeyFrameEasing;
        if (r114 == null) goto L32;
        float r115 = r113.time;
        if (r115 < r13) goto L37;
        if (Float.isNaN(r111) == false) goto L32;
        r111 = r113.time;
        goto L32
    L37:
        r110 = r114;
        r15 = r115;
        goto L32
    L41:
        if (r110 != null) goto L43;
    L46:
        this.mSpline[0].getPos(r17, this.mInterpolateData);
        CurveFit r20 = this.mArcSpline;
        if (r20 == null) goto L51;
        double[] r21 = this.mInterpolateData;
        if (r21.length <= 0) goto L51;
        r20.getPos(r17, r21);
    L51:
        this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, r18, r12 * 2);
        r12 = r12 + 1;
        goto L19
    L43:
        if (Float.isNaN(r111) == false) goto L45;
        r111 = 1.0f;
    L45:
        float r116 = r111 - r15;
        r17 = (((float) r110.get((r13 - r15) / r116)) * r116) + r15;
        goto L46
    }

    int buildKeyBounds(float[] r8, int[] r9) {
        if (r8 == null) goto L16;
        double[] r1 = this.mSpline[0].getTimePoints();
        if (r9 == null) goto L10;
        Iterator<MotionPaths> r2 = this.mMotionPaths.iterator();
        int r3 = 0;
    L8:
        if (r2.hasNext() == false) goto L10;
        r9[r3] = r2.next().mMode;
        r3 = r3 + 1;
    L10:
        int r10 = 0;
        int r4 = 0;
    L12:
        if (r10 >= r1.length) goto L15;
        this.mSpline[0].getPos(r1[r10], this.mInterpolateData);
        this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, r8, r4);
        r4 = r4 + 2;
        r10 = r10 + 1;
        goto L12
    L15:
        return r4 / 2;
    L16:
        return 0;
    }

    int buildKeyFrames(float[] r11, int[] r12) {
        if (r11 == null) goto L16;
        double[] r1 = this.mSpline[0].getTimePoints();
        if (r12 == null) goto L10;
        Iterator<MotionPaths> r2 = this.mMotionPaths.iterator();
        int r3 = 0;
    L8:
        if (r2.hasNext() == false) goto L10;
        r12[r3] = r2.next().mMode;
        r3 = r3 + 1;
    L10:
        int r13 = 0;
        int r9 = 0;
    L12:
        if (r13 >= r1.length) goto L15;
        this.mSpline[0].getPos(r1[r13], this.mInterpolateData);
        this.mStartMotionPath.getCenter(r1[r13], this.mInterpolateVariables, this.mInterpolateData, r11, r9);
        r9 = r9 + 2;
        r13 = r13 + 1;
        goto L12
    L15:
        return r9 / 2;
    L16:
        return 0;
    }

    void buildPath(float[] r21, int r22) {
        float r9 = 1.0f;
        float r10 = 1.0f / (r22 - 1);
        HashMap<String, ViewSpline> r1 = this.mAttributesMap;
        ViewOscillator r3 = null;
        if (r1 != null) goto L5;
        ViewSpline r11 = null;
    L6:
        HashMap<String, ViewSpline> r2 = this.mAttributesMap;
        if (r2 != null) goto L9;
        ViewSpline r12 = null;
    L10:
        HashMap<String, ViewOscillator> r4 = this.mCycleMap;
        if (r4 != null) goto L13;
        ViewOscillator r13 = null;
    L14:
        HashMap<String, ViewOscillator> r5 = this.mCycleMap;
        if (r5 == null) goto L18;
        r3 = r5.get("translationY");
    L18:
        ViewOscillator r14 = r3;
        int r7 = 0;
    L19:
        if (r7 >= r22) goto L64;
        float r6 = r7 * r10;
        float r8 = this.mStaggerScale;
        if (r8 == r9) goto L30;
        float r15 = this.mStaggerOffset;
        if (r6 >= r15) goto L26;
        r6 = 0.0f;
    L26:
        if (r6 <= r15) goto L30;
        if (r6 >= 1.0d) goto L30;
        r6 = Math.min((r6 - r15) * r8, r9);
    L30:
        float r16 = r6;
        double r17 = r16;
        Easing r18 = this.mStartMotionPath.mKeyFrameEasing;
        float r19 = Float.NaN;
        Iterator<MotionPaths> r20 = this.mMotionPaths.iterator();
        float r110 = 0.0f;
    L32:
        if (r20.hasNext() == false) goto L42;
        MotionPaths r23 = r20.next();
        Easing r111 = r23.mKeyFrameEasing;
        double r112 = r17;
        if (r111 == null) goto L41;
        float r24 = r23.time;
        if (r24 >= r16) goto L39;
        r110 = r24;
        r18 = r111;
        goto L41
    L39:
        if (Float.isNaN(r19) == false) goto L41;
        r19 = r23.time;
    L41:
        r17 = r112;
        goto L32
    L42:
        double r113 = r17;
        if (r18 != null) goto L45;
        double r25 = r113;
    L49:
        this.mSpline[0].getPos(r25, this.mInterpolateData);
        CurveFit r26 = this.mArcSpline;
        if (r26 == null) goto L54;
        double[] r27 = this.mInterpolateData;
        if (r27.length <= 0) goto L54;
        r26.getPos(r25, r27);
    L54:
        int r114 = r7 * 2;
        int r115 = r7;
        this.mStartMotionPath.getCenter(r25, this.mInterpolateVariables, this.mInterpolateData, r21, r114);
        if (r13 == null) goto L57;
        r21[r114] = r21[r114] + r13.get(r16);
    L59:
        if (r14 == null) goto L61;
        int r116 = r114 + 1;
        r21[r116] = r21[r116] + r14.get(r16);
    L63:
        r7 = r115 + 1;
        r9 = 1.0f;
        goto L19
    L61:
        if (r12 == null) goto L63;
        int r117 = r114 + 1;
        r21[r117] = r21[r117] + r12.get(r16);
        goto L63
    L57:
        if (r11 == null) goto L59;
        r21[r114] = r21[r114] + r11.get(r16);
        goto L59
    L45:
        if (Float.isNaN(r19) == false) goto L47;
        r19 = 1.0f;
    L47:
        float r28 = r19 - r110;
        r25 = (((float) r18.get((r16 - r110) / r28)) * r28) + r110;
        goto L49
    L64:
        return;
    L13:
        r13 = r4.get("translationX");
        goto L14
    L9:
        r12 = r2.get("translationY");
        goto L10
    L5:
        r11 = r1.get("translationX");
        goto L6
    }

    void buildRect(float r4, float[] r5, int r6) {
        this.mSpline[0].getPos(getAdjustedPosition(r4, null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, r5, r6);
    }

    void buildRectangles(float[] r8, int r9) {
        float r1 = 1.0f / (r9 - 1);
        int r2 = 0;
    L3:
        if (r2 >= r9) goto L5;
        this.mSpline[0].getPos(getAdjustedPosition(r2 * r1, null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, r8, r2 * 8);
        r2 = r2 + 1;
        goto L3
    }

    void endTrigger(boolean r5) {
        if ("button".equals(Debug.getName(this.mView)) == true) goto L5;
        return;
    L5:
        if (this.mKeyTriggers == null) goto L18;
        int r0 = 0;
    L7:
        KeyTrigger[] r1 = this.mKeyTriggers;
        if (r0 >= r1.length) goto L19;
        KeyTrigger r2 = r1[r0];
        if (r5 == false) goto L12;
        float r3 = -100.0f;
    L13:
        r2.conditionallyFire(r3, this.mView);
        r0 = r0 + 1;
        goto L7
    L12:
        r3 = 100.0f;
        goto L13
    L19:
        return;
    }

    public int getAnimateRelativeTo() {
        return this.mStartMotionPath.mAnimateRelativeTo;
    }

    int getAttributeValues(String r1, float[] r2, int r3) {
        ViewSpline r0 = this.mAttributesMap.get(r1);
        if (r0 != null) goto L6;
        return -1;
    L6:
        int r4 = 0;
    L8:
        if (r4 >= r2.length) goto L11;
        r2[r4] = r0.get(r4 / (r2.length - 1));
        r4 = r4 + 1;
        goto L8
    L11:
        return r2.length;
    }

    public void getCenter(double r10, float[] r12, float[] r13) {
        double[] r5 = new double[4];
        double[] r7 = new double[4];
        this.mSpline[0].getPos(r10, r5);
        this.mSpline[0].getSlope(r10, r7);
        Arrays.fill(r13, 0.0f);
        this.mStartMotionPath.getCenter(r10, this.mInterpolateVariables, r5, r12, r7, r13);
    }

    public float getCenterX() {
        return this.mCurrentCenterX;
    }

    public float getCenterY() {
        return this.mCurrentCenterY;
    }

    void getDpDt(float r12, float r13, float r14, float[] r15) {
        float r16 = getAdjustedPosition(r12, this.mVelocity);
        CurveFit[] r0 = this.mSpline;
        int r1 = 0;
        if (r0 == null) goto L16;
        double r2 = r16;
        r0[0].getSlope(r2, this.mInterpolateVelocity);
        this.mSpline[0].getPos(r2, this.mInterpolateData);
        float r17 = this.mVelocity[0];
    L5:
        double[] r9 = this.mInterpolateVelocity;
        if (r1 >= r9.length) goto L8;
        r9[r1] = r9[r1] * ((double) r17);
        r1 = r1 + 1;
        goto L5
    L8:
        CurveFit r18 = this.mArcSpline;
        if (r18 == null) goto L14;
        double[] r3 = this.mInterpolateData;
        if (r3.length <= 0) goto L19;
        r18.getPos(r2, r3);
        this.mArcSpline.getSlope(r2, this.mInterpolateVelocity);
        this.mStartMotionPath.setDpDt(r13, r14, r15, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
        return;
    L19:
        return;
    L14:
        this.mStartMotionPath.setDpDt(r13, r14, r15, this.mInterpolateVariables, r9, this.mInterpolateData);
        return;
    L16:
        MotionPaths r19 = this.mEndMotionPath;
        float r4 = r19.x;
        MotionPaths r11 = this.mStartMotionPath;
        float r5 = r4 - r11.x;
        float r6 = r19.y - r11.y;
        float r7 = (r19.width - r11.width) + r5;
        float r110 = (r19.height - r11.height) + r6;
        r15[0] = (r5 * (1.0f - r13)) + (r7 * r13);
        r15[1] = (r6 * (1.0f - r14)) + (r110 * r14);
    }

    public int getDrawPath() {
        int r0 = this.mStartMotionPath.mDrawPath;
        Iterator<MotionPaths> r1 = this.mMotionPaths.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        r0 = Math.max(r0, r1.next().mDrawPath);
        goto L4
    L7:
        return Math.max(r0, this.mEndMotionPath.mDrawPath);
    }

    public float getFinalHeight() {
        return this.mEndMotionPath.height;
    }

    public float getFinalWidth() {
        return this.mEndMotionPath.width;
    }

    public float getFinalX() {
        return this.mEndMotionPath.x;
    }

    public float getFinalY() {
        return this.mEndMotionPath.y;
    }

    MotionPaths getKeyFrame(int r1) {
        return this.mMotionPaths.get(r1);
    }

    public int getKeyFrameInfo(int r18, int[] r19) {
        float[] r2 = new float[2];
        Iterator<Key> r10 = this.mKeyList.iterator();
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r10.hasNext() == false) goto L14;
        Key r14 = r10.next();
        int r3 = r14.mType;
        if (r3 == r18) goto L10;
        if (r18 == (-1)) goto L4;
    L10:
        r19[r13] = 0;
        int r4 = r13 + 1;
        r19[r4] = r3;
        int r16 = r4 + 1;
        int r5 = r14.mFramePosition;
        r19[r16] = r5;
        double r6 = r5 / 100.0f;
        this.mSpline[0].getPos(r6, this.mInterpolateData);
        this.mStartMotionPath.getCenter(r6, this.mInterpolateVariables, this.mInterpolateData, r2, 0);
        int r17 = r16 + 1;
        r19[r17] = Float.floatToIntBits(r2[0]);
        int r110 = r17 + 1;
        r19[r110] = Float.floatToIntBits(r2[1]);
        if ((r14 instanceof KeyPosition) == false) goto L13;
        KeyPosition r15 = (KeyPosition) r14;
        int r111 = r110 + 1;
        r19[r111] = r15.mPositionType;
        int r112 = r111 + 1;
        r19[r112] = Float.floatToIntBits(r15.mPercentX);
        r110 = r112 + 1;
        r19[r110] = Float.floatToIntBits(r15.mPercentY);
    L13:
        int r113 = r110 + 1;
        r19[r13] = r113 - r13;
        r12 = r12 + 1;
        r13 = r113;
        goto L4
    L14:
        return r12;
    }

    float getKeyFrameParameter(int r9, float r10, float r11) {
        MotionPaths r0 = this.mEndMotionPath;
        float r1 = r0.x;
        MotionPaths r8 = this.mStartMotionPath;
        float r2 = r8.x;
        float r3 = r1 - r2;
        float r4 = r0.y;
        float r5 = r8.y;
        float r6 = r4 - r5;
        float r7 = r2 + (r8.width / 2.0f);
        float r12 = r5 + (r8.height / 2.0f);
        float r13 = (float) Math.hypot(r3, r6);
        if (r13 >= 1.0E-7d) goto L6;
        return Float.NaN;
    L6:
        float r14 = r10 - r7;
        float r15 = r11 - r12;
        if (((float) Math.hypot(r14, r15)) != 0.0f) goto L9;
        return 0.0f;
    L9:
        float r16 = (r14 * r3) + (r15 * r6);
        if (r9 == 0) goto L33;
        if (r9 == 1) goto L31;
        if (r9 == 2) goto L29;
        if (r9 == 3) goto L27;
        if (r9 == 4) goto L25;
        if (r9 == 5) goto L23;
        return 0.0f;
    L23:
        return r15 / r6;
    L25:
        return r14 / r6;
    L27:
        return r15 / r3;
    L29:
        return r14 / r3;
    L31:
        return (float) Math.sqrt((r13 * r13) - (r16 * r16));
    L33:
        return r16 / r13;
    }

    public int getKeyFramePositions(int[] r13, float[] r14) {
        Iterator<Key> r0 = this.mKeyList.iterator();
        int r2 = 0;
        int r10 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        Key r3 = r0.next();
        int r4 = r3.mFramePosition;
        r13[r2] = (r3.mType * 1000) + r4;
        double r5 = r4 / 100.0f;
        this.mSpline[0].getPos(r5, this.mInterpolateData);
        this.mStartMotionPath.getCenter(r5, this.mInterpolateVariables, this.mInterpolateData, r14, r10);
        r10 = r10 + 2;
        r2 = r2 + 1;
        goto L4
    L6:
        return r2;
    }

    double[] getPos(double r4) {
        this.mSpline[0].getPos(r4, this.mInterpolateData);
        CurveFit r0 = this.mArcSpline;
        if (r0 == null) goto L8;
        double[] r1 = this.mInterpolateData;
        if (r1.length <= 0) goto L8;
        r0.getPos(r4, r1);
    L8:
        return this.mInterpolateData;
    }

    KeyPositionBase getPositionKeyframe(int r11, int r12, float r13, float r14) {
        RectF r7 = new RectF();
        MotionPaths r0 = this.mStartMotionPath;
        float r1 = r0.x;
        r7.left = r1;
        float r2 = r0.y;
        r7.top = r2;
        r7.right = r1 + r0.width;
        r7.bottom = r2 + r0.height;
        RectF r8 = new RectF();
        MotionPaths r3 = this.mEndMotionPath;
        float r4 = r3.x;
        r8.left = r4;
        float r5 = r3.y;
        r8.top = r5;
        r8.right = r4 + r3.width;
        r8.bottom = r5 + r3.height;
        Iterator<Key> r10 = this.mKeyList.iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        Key r6 = r10.next();
        if ((r6 instanceof KeyPositionBase) == false) goto L4;
        KeyPositionBase r9 = (KeyPositionBase) r6;
        if (r9.intersects(r11, r12, r7, r8, r13, r14) == false) goto L4;
        return r9;
    L10:
        return null;
    }

    void getPostLayoutDvDp(float r19, int r20, int r21, float r22, float r23, float[] r24) {
        float r1 = getAdjustedPosition(r19, this.mVelocity);
        HashMap<String, ViewSpline> r2 = this.mAttributesMap;
        ViewOscillator r4 = null;
        if (r2 != null) goto L5;
        ViewSpline r3 = null;
    L6:
        HashMap<String, ViewSpline> r5 = this.mAttributesMap;
        if (r5 != null) goto L9;
        ViewSpline r6 = null;
    L10:
        HashMap<String, ViewSpline> r7 = this.mAttributesMap;
        if (r7 != null) goto L13;
        ViewSpline r8 = null;
    L14:
        HashMap<String, ViewSpline> r9 = this.mAttributesMap;
        if (r9 != null) goto L17;
        ViewSpline r10 = null;
    L18:
        HashMap<String, ViewSpline> r11 = this.mAttributesMap;
        if (r11 != null) goto L21;
        ViewSpline r12 = null;
    L22:
        HashMap<String, ViewOscillator> r13 = this.mCycleMap;
        if (r13 != null) goto L25;
        ViewOscillator r14 = null;
    L26:
        HashMap<String, ViewOscillator> r15 = this.mCycleMap;
        if (r15 != null) goto L29;
        ViewOscillator r16 = null;
    L30:
        HashMap<String, ViewOscillator> r17 = this.mCycleMap;
        if (r17 != null) goto L33;
        ViewOscillator r18 = null;
    L34:
        HashMap<String, ViewOscillator> r110 = this.mCycleMap;
        if (r110 != null) goto L37;
        ViewOscillator r111 = null;
    L38:
        HashMap<String, ViewOscillator> r112 = this.mCycleMap;
        if (r112 == null) goto L42;
        r4 = r112.get("scaleY");
    L42:
        VelocityMatrix r113 = new VelocityMatrix();
        r113.clear();
        r113.setRotationVelocity(r8, r1);
        r113.setTranslationVelocity(r3, r6, r1);
        r113.setScaleVelocity(r10, r12, r1);
        r113.setRotationVelocity(r18, r1);
        r113.setTranslationVelocity(r14, r16, r1);
        r113.setScaleVelocity(r111, r4, r1);
        CurveFit r114 = this.mArcSpline;
        if (r114 == null) goto L49;
        double[] r25 = this.mInterpolateData;
        if (r25.length <= 0) goto L47;
        double r26 = r1;
        r114.getPos(r26, r25);
        this.mArcSpline.getSlope(r26, this.mInterpolateVelocity);
        this.mStartMotionPath.setDpDt(r22, r23, r24, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
    L47:
        r113.applyTransform(r22, r23, r20, r21, r24);
        return;
    L49:
        int r115 = 0;
        if (this.mSpline == null) goto L57;
        double r27 = getAdjustedPosition(r1, this.mVelocity);
        this.mSpline[0].getSlope(r27, this.mInterpolateVelocity);
        this.mSpline[0].getPos(r27, this.mInterpolateData);
        float r28 = this.mVelocity[0];
    L52:
        double[] r29 = this.mInterpolateVelocity;
        if (r115 >= r29.length) goto L55;
        r29[r115] = r29[r115] * ((double) r28);
        r115 = r115 + 1;
        goto L52
    L55:
        this.mStartMotionPath.setDpDt(r22, r23, r24, this.mInterpolateVariables, r29, this.mInterpolateData);
        r113.applyTransform(r22, r23, r20, r21, r24);
        return;
    L57:
        MotionPaths r116 = this.mEndMotionPath;
        float r117 = r116.x;
        MotionPaths r0 = this.mStartMotionPath;
        float r118 = r117 - r0.x;
        ViewOscillator r119 = r4;
        float r120 = r116.y - r0.y;
        ViewOscillator r121 = r111;
        float r30 = (r116.width - r0.width) + r118;
        float r122 = (r116.height - r0.height) + r120;
        r24[0] = (r118 * (1.0f - r22)) + (r30 * r22);
        r24[1] = (r120 * (1.0f - r23)) + (r122 * r23);
        r113.clear();
        r113.setRotationVelocity(r8, r1);
        r113.setTranslationVelocity(r3, r6, r1);
        r113.setScaleVelocity(r10, r12, r1);
        r113.setRotationVelocity(r18, r1);
        r113.setTranslationVelocity(r14, r16, r1);
        r113.setScaleVelocity(r121, r119, r1);
        r113.applyTransform(r22, r23, r20, r21, r24);
        return;
    L37:
        r111 = r110.get("scaleX");
        goto L38
    L33:
        r18 = r17.get(Key.ROTATION);
        goto L34
    L29:
        r16 = r15.get("translationY");
        goto L30
    L25:
        r14 = r13.get("translationX");
        goto L26
    L21:
        r12 = r11.get("scaleY");
        goto L22
    L17:
        r10 = r9.get("scaleX");
        goto L18
    L13:
        r8 = r7.get(Key.ROTATION);
        goto L14
    L9:
        r6 = r5.get("translationY");
        goto L10
    L5:
        r3 = r2.get("translationX");
        goto L6
    }

    public float getStartHeight() {
        return this.mStartMotionPath.height;
    }

    public float getStartWidth() {
        return this.mStartMotionPath.width;
    }

    public float getStartX() {
        return this.mStartMotionPath.x;
    }

    public float getStartY() {
        return this.mStartMotionPath.y;
    }

    public int getTransformPivotTarget() {
        return this.mTransformPivotTarget;
    }

    public View getView() {
        return this.mView;
    }

    boolean interpolate(View r21, float r22, long r23, KeyCache r25) {
        float r2 = getAdjustedPosition(r22, null);
        int r3 = this.mQuantizeMotionSteps;
        if (r3 == Key.UNSET) goto L15;
        float r4 = 1.0f / r3;
        float r5 = ((float) Math.floor(r2 / r4)) * r4;
        float r6 = (r2 % r4) / r4;
        if (Float.isNaN(this.mQuantizeMotionPhase) == true) goto L7;
        r6 = (r6 + this.mQuantizeMotionPhase) % 1.0f;
    L7:
        Interpolator r7 = this.mQuantizeMotionInterpolator;
        if (r7 == null) goto L11;
        float r8 = r7.getInterpolation(r6);
    L14:
        r2 = (r8 * r4) + r5;
        goto L15
    L11:
        if (r6 <= 0.5d) goto L13;
        r8 = 1.0f;
        goto L14
    L13:
        r8 = 0.0f;
    L15:
        float r14 = r2;
        HashMap<String, ViewSpline> r9 = this.mAttributesMap;
        if (r9 == null) goto L21;
        Iterator<ViewSpline> r10 = r9.values().iterator();
    L19:
        if (r10.hasNext() == false) goto L21;
        r10.next().setProperty(r21, r14);
    L21:
        HashMap<String, ViewTimeCycle> r11 = this.mTimeCycleAttributesMap;
        if (r11 == null) goto L31;
        Iterator<ViewTimeCycle> r12 = r11.values().iterator();
        ViewTimeCycle.PathRotate r13 = null;
        boolean r15 = false;
    L25:
        if (r12.hasNext() == false) goto L30;
        ViewTimeCycle r1 = r12.next();
        if ((r1 instanceof ViewTimeCycle.PathRotate) == true) goto L28;
        r15 = r15 | r1.setProperty(r21, r14, r23, r25);
        goto L25
    L28:
        r13 = (ViewTimeCycle.PathRotate) r1;
        goto L25
    L30:
        boolean r16 = r15;
        ViewTimeCycle.PathRotate r17 = r13;
    L32:
        CurveFit[] r18 = this.mSpline;
        int r19 = 1;
        if (r18 == null) goto L89;
        double r20 = r14;
        r18[0].getPos(r20, this.mInterpolateData);
        this.mSpline[0].getSlope(r20, this.mInterpolateVelocity);
        CurveFit r24 = this.mArcSpline;
        if (r24 == null) goto L40;
        double[] r26 = this.mInterpolateData;
        if (r26.length <= 0) goto L40;
        r24.getPos(r20, r26);
        this.mArcSpline.getSlope(r20, this.mInterpolateVelocity);
    L40:
        if (this.mNoMovement == true) goto L44;
        this.mStartMotionPath.setView(r14, r21, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null, this.mForceMeasure);
        this.mForceMeasure = false;
    L44:
        if (this.mTransformPivotTarget != Key.UNSET) goto L46;
    L55:
        HashMap<String, ViewSpline> r27 = this.mAttributesMap;
        if (r27 == null) goto L65;
        Iterator<ViewSpline> r28 = r27.values().iterator();
    L59:
        if (r28.hasNext() == false) goto L65;
        ViewSpline r29 = r28.next();
        if ((r29 instanceof ViewSpline.PathRotate) == false) goto L59;
        double[] r30 = this.mInterpolateVelocity;
        if (r30.length <= 1) goto L59;
        ((ViewSpline.PathRotate) r29).setPathRotate(r21, r14, r30[0], r30[1]);
    L65:
        if (r17 == null) goto L68;
        double[] r31 = this.mInterpolateVelocity;
        r16 = r16 | r17.setPathRotate(r21, r25, r14, r23, r31[0], r31[1]);
    L68:
        int r110 = r19;
    L69:
        CurveFit[] r32 = this.mSpline;
        if (r110 >= r32.length) goto L72;
        r32[r110].getPos(r20, this.mValuesBuff);
        CustomSupport.setInterpolatedValue(this.mStartMotionPath.attributes.get(this.mAttributeNames[r110 - 1]), r21, this.mValuesBuff);
        r110 = r110 + 1;
        goto L69
    L72:
        MotionConstrainedPoint r33 = this.mStartPoint;
        if (r33.mVisibilityMode != 0) goto L84;
        if (r14 > 0.0f) goto L78;
    L76:
        r21.setVisibility(r33.visibility);
        goto L84
    L78:
        if (r14 < 1.0f) goto L81;
        r33 = this.mEndPoint;
        goto L76
    L81:
        if (this.mEndPoint.visibility == r33.visibility) goto L84;
        r21.setVisibility(0);
    L84:
        if (this.mKeyTriggers == null) goto L97;
        int r34 = 0;
    L86:
        KeyTrigger[] r35 = this.mKeyTriggers;
        if (r34 >= r35.length) goto L97;
        r35[r34].conditionallyFire(r14, r21);
        r34 = r34 + 1;
    L97:
        HashMap<String, ViewOscillator> r36 = this.mCycleMap;
        if (r36 == null) goto L106;
        Iterator<ViewOscillator> r37 = r36.values().iterator();
    L101:
        if (r37.hasNext() == false) goto L106;
        ViewOscillator r38 = r37.next();
        if ((r38 instanceof ViewOscillator.PathRotateSet) == true) goto L104;
        r38.setProperty(r21, r14);
        goto L101
    L104:
        double[] r39 = this.mInterpolateVelocity;
        ((ViewOscillator.PathRotateSet) r38).setPathRotate(r21, r14, r39[0], r39[r19]);
    L106:
        return r16;
    L46:
        if (this.mTransformPivotView != null) goto L48;
        this.mTransformPivotView = ((View) r21.getParent()).findViewById(this.mTransformPivotTarget);
    L48:
        View r40 = this.mTransformPivotView;
        if (r40 == null) goto L55;
        float r41 = (r40.getTop() + this.mTransformPivotView.getBottom()) / 2.0f;
        float r42 = (this.mTransformPivotView.getLeft() + this.mTransformPivotView.getRight()) / 2.0f;
        if ((r21.getRight() - r21.getLeft()) <= 0) goto L55;
        if ((r21.getBottom() - r21.getTop()) <= 0) goto L55;
        float r43 = r42 - r21.getLeft();
        float r44 = r41 - r21.getTop();
        r21.setPivotX(r43);
        r21.setPivotY(r44);
        goto L55
    L89:
        r19 = 1;
        MotionPaths r45 = this.mStartMotionPath;
        float r46 = r45.x;
        MotionPaths r47 = this.mEndMotionPath;
        float r48 = r46 + ((r47.x - r46) * r14);
        float r49 = r45.y;
        float r50 = r49 + ((r47.y - r49) * r14);
        float r51 = r45.width;
        float r52 = r47.width;
        float r53 = r45.height;
        float r54 = r47.height;
        float r55 = r48 + 0.5f;
        int r111 = (int) r55;
        float r56 = r50 + 0.5f;
        int r57 = (int) r56;
        int r58 = (int) (r55 + (((r52 - r51) * r14) + r51));
        int r59 = (int) (r56 + (((r54 - r53) * r14) + r53));
        int r60 = r58 - r111;
        int r61 = r59 - r57;
        if (r52 == r51) goto L92;
    L95:
        r21.measure(View.MeasureSpec.makeMeasureSpec(r60, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(r61, BasicMeasure.EXACTLY));
        this.mForceMeasure = false;
    L96:
        r21.layout(r111, r57, r58, r59);
        goto L97
    L92:
        if (r54 != r53) goto L95;
        if (this.mForceMeasure == false) goto L96;
    L31:
        r17 = null;
        r16 = false;
        goto L32
    }

    String name() {
        return this.mView.getContext().getResources().getResourceEntryName(this.mView.getId());
    }

    void positionKeyframe(View r9, KeyPositionBase r10, float r11, float r12, String[] r13, float[] r14) {
        RectF r2 = new RectF();
        MotionPaths r0 = this.mStartMotionPath;
        float r1 = r0.x;
        r2.left = r1;
        float r3 = r0.y;
        r2.top = r3;
        r2.right = r1 + r0.width;
        r2.bottom = r3 + r0.height;
        RectF r4 = new RectF();
        MotionPaths r8 = this.mEndMotionPath;
        float r5 = r8.x;
        r4.left = r5;
        float r6 = r8.y;
        r4.top = r6;
        r4.right = r5 + r8.width;
        r4.bottom = r6 + r8.height;
        r10.positionAttributes(r9, r2, r4, r11, r12, r13, r14);
    }

    public void remeasure() {
        this.mForceMeasure = true;
    }

    void rotate(Rect r2, Rect r3, int r4, int r5, int r6) {
        if (r4 == 1) goto L14;
        if (r4 != 2) goto L6;
        int r1 = r2.left + r2.right;
        int r7 = r2.top;
        int r8 = r2.bottom;
    L13:
        r3.left = r5 - (((r7 + r8) + r2.width()) / 2);
        r3.top = (r1 - r2.height()) / 2;
    L16:
        r3.right = r3.left + r2.width();
        r3.bottom = r3.top + r2.height();
        return;
    L6:
        if (r4 != 3) goto L8;
        int r9 = r2.left + r2.right;
        int r10 = r2.top;
        int r11 = r2.bottom;
        int r12 = ((r2.height() / 2) + r2.top) - (r9 / 2);
    L15:
        r3.left = r12;
        r3.top = r6 - ((r9 + r2.height()) / 2);
        goto L16
    L8:
        if (r4 != 4) goto L18;
        r1 = r2.left + r2.right;
        r7 = r2.bottom;
        r8 = r2.top;
        goto L13
    L18:
        return;
    L14:
        r9 = r2.left + r2.right;
        r12 = ((r2.top + r2.bottom) - r2.width()) / 2;
        goto L15
    }

    void setBothStates(View r6) {
        MotionPaths r0 = this.mStartMotionPath;
        r0.time = 0.0f;
        r0.position = 0.0f;
        this.mNoMovement = true;
        r0.setBounds(r6.getX(), r6.getY(), r6.getWidth(), r6.getHeight());
        this.mEndMotionPath.setBounds(r6.getX(), r6.getY(), r6.getWidth(), r6.getHeight());
        this.mStartPoint.setState(r6);
        this.mEndPoint.setState(r6);
    }

    public void setDrawPath(int r1) {
        this.mStartMotionPath.mDrawPath = r1;
    }

    void setEndState(Rect r8, ConstraintSet r9, int r10, int r11) {
        int r6 = r9.mRotate;
        if (r6 == 0) goto L5;
        rotate(r8, this.mTempRect, r6, r10, r11);
        r8 = this.mTempRect;
    L5:
        MotionPaths r12 = this.mEndMotionPath;
        r12.time = 1.0f;
        r12.position = 1.0f;
        readView(r12);
        this.mEndMotionPath.setBounds(r8.left, r8.top, r8.width(), r8.height());
        this.mEndMotionPath.applyParameters(r9.getParameters(this.mId));
        this.mEndPoint.setState(r8, r9, r6, this.mId);
    }

    public void setPathMotionArc(int r1) {
        this.mPathMotionArc = r1;
    }

    void setStartCurrentState(View r6) {
        MotionPaths r0 = this.mStartMotionPath;
        r0.time = 0.0f;
        r0.position = 0.0f;
        r0.setBounds(r6.getX(), r6.getY(), r6.getWidth(), r6.getHeight());
        this.mStartPoint.setState(r6);
    }

    void setStartState(Rect r8, ConstraintSet r9, int r10, int r11) {
        int r6 = r9.mRotate;
        if (r6 == 0) goto L5;
        rotate(r8, this.mTempRect, r6, r10, r11);
    L5:
        MotionPaths r12 = this.mStartMotionPath;
        r12.time = 0.0f;
        r12.position = 0.0f;
        readView(r12);
        this.mStartMotionPath.setBounds(r8.left, r8.top, r8.width(), r8.height());
        ConstraintSet.Constraint r13 = r9.getParameters(this.mId);
        this.mStartMotionPath.applyParameters(r13);
        this.mMotionStagger = r13.motion.mMotionStagger;
        this.mStartPoint.setState(r8, r9, r6, this.mId);
        this.mTransformPivotTarget = r13.transform.transformPivotTarget;
        ConstraintSet.Motion r14 = r13.motion;
        this.mQuantizeMotionSteps = r14.mQuantizeMotionSteps;
        this.mQuantizeMotionPhase = r14.mQuantizeMotionPhase;
        Context r15 = this.mView.getContext();
        ConstraintSet.Motion r16 = r13.motion;
        this.mQuantizeMotionInterpolator = getInterpolator(r15, r16.mQuantizeInterpolatorType, r16.mQuantizeInterpolatorString, r16.mQuantizeInterpolatorID);
    }

    public void setStartState(ViewState r5, View r6, int r7, int r8, int r9) {
        MotionPaths r0 = this.mStartMotionPath;
        r0.time = 0.0f;
        r0.position = 0.0f;
        Rect r1 = new Rect();
        if (r7 == 1) goto L7;
        if (r7 != 2) goto L9;
        int r10 = r5.left + r5.right;
        r1.left = r9 - (((r5.top + r5.bottom) + r5.width()) / 2);
        int r11 = (r10 - r5.height()) / 2;
    L8:
        r1.top = r11;
        r1.right = r1.left + r5.width();
        r1.bottom = r1.top + r5.height();
    L9:
        this.mStartMotionPath.setBounds(r1.left, r1.top, r1.width(), r1.height());
        this.mStartPoint.setState(r1, r6, r7, r5.rotation);
        return;
    L7:
        int r12 = r5.left + r5.right;
        r1.left = ((r5.top + r5.bottom) - r5.width()) / 2;
        r11 = r8 - ((r12 + r5.height()) / 2);
        goto L8
    }

    public void setTransformPivotTarget(int r1) {
        this.mTransformPivotTarget = r1;
        this.mTransformPivotView = null;
    }

    public void setView(View r2) {
        this.mView = r2;
        this.mId = r2.getId();
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if ((r3 instanceof ConstraintLayout.LayoutParams) == false) goto L6;
        this.mConstraintTag = ((ConstraintLayout.LayoutParams) r3).getConstraintTag();
        return;
    }

    public void setup(int r18, int r19, float r20, long r21) {
        new HashSet();
        HashSet<String> r2 = new HashSet();
        HashSet<String> r3 = new HashSet();
        HashSet<String> r4 = new HashSet();
        HashMap<String, Integer> r5 = new HashMap();
        int r6 = this.mPathMotionArc;
        if (r6 == Key.UNSET) goto L5;
        this.mStartMotionPath.mPathMotionArc = r6;
    L5:
        this.mStartPoint.different(this.mEndPoint, r3);
        ArrayList<Key> r7 = this.mKeyList;
        if (r7 == null) goto L27;
        Iterator<Key> r8 = r7.iterator();
        ArrayList r9 = null;
    L9:
        if (r8.hasNext() == false) goto L28;
        Key r10 = r8.next();
        if ((r10 instanceof KeyPosition) == true) goto L12;
        if ((r10 instanceof KeyCycle) == true) goto L17;
        if ((r10 instanceof KeyTimeCycle) == true) goto L20;
        if ((r10 instanceof KeyTrigger) == true) goto L23;
        r10.setInterpolation(r5);
        r10.getAttributeNames(r3);
        goto L9
    L23:
        if (r9 != null) goto L25;
        r9 = new ArrayList();
    L25:
        r9.add((KeyTrigger) r10);
        goto L9
    L20:
        r10.getAttributeNames(r2);
        goto L9
    L17:
        r10.getAttributeNames(r4);
        goto L9
    L12:
        KeyPosition r11 = (KeyPosition) r10;
        insertKey(new MotionPaths(r18, r19, r11, this.mStartMotionPath, this.mEndMotionPath));
        int r12 = r11.mCurveFit;
        if (r12 == Key.UNSET) goto L9;
        this.mCurveFitType = r12;
    L28:
        int r13 = 0;
        if (r9 == null) goto L31;
        this.mKeyTriggers = (KeyTrigger[]) r9.toArray(new KeyTrigger[0]);
    L31:
        char r14 = 1;
        if (r3.isEmpty() == true) goto L74;
        this.mAttributesMap = new HashMap();
        Iterator<String> r15 = r3.iterator();
    L35:
        if (r15.hasNext() == false) goto L53;
        String r16 = r15.next();
        if (r16.startsWith("CUSTOM,") == false) goto L48;
        SparseArray r17 = new SparseArray();
        String r110 = r16.split(",")[r14];
        Iterator<Key> r111 = this.mKeyList.iterator();
    L40:
        if (r111.hasNext() == false) goto L47;
        Key r22 = r111.next();
        HashMap<String, ConstraintAttribute> r112 = r22.mCustomConstraints;
        if (r112 == null) goto L40;
        ConstraintAttribute r113 = r112.get(r110);
        if (r113 == null) goto L40;
        r17.append(r22.mFramePosition, r113);
        goto L40
    L47:
        ViewSpline r23 = ViewSpline.makeCustomSpline(r16, r17);
    L49:
        if (r23 == null) goto L52;
        r23.setType(r16);
        this.mAttributesMap.put(r16, r23);
    L52:
        r14 = 1;
        goto L35
    L48:
        r23 = ViewSpline.makeSpline(r16);
        goto L49
    L53:
        ArrayList<Key> r24 = this.mKeyList;
        if (r24 == null) goto L61;
        Iterator<Key> r25 = r24.iterator();
    L57:
        if (r25.hasNext() == false) goto L61;
        Key r26 = r25.next();
        if ((r26 instanceof KeyAttributes) == false) goto L57;
        r26.addValues(this.mAttributesMap);
    L61:
        this.mStartPoint.addValues(this.mAttributesMap, 0);
        this.mEndPoint.addValues(this.mAttributesMap, 100);
        Iterator<String> r27 = this.mAttributesMap.keySet().iterator();
    L63:
        if (r27.hasNext() == false) goto L74;
        String r28 = r27.next();
        if (r5.containsKey(r28) == false) goto L69;
        Integer r114 = r5.get(r28);
        if (r114 == null) goto L69;
        int r115 = r114.intValue();
    L70:
        ViewSpline r29 = this.mAttributesMap.get(r28);
        if (r29 == null) goto L63;
        r29.setup(r115);
    L69:
        r115 = 0;
    L74:
        if (r2.isEmpty() == false) goto L76;
    L116:
        int r30 = 2;
        int r31 = this.mMotionPaths.size() + 2;
        MotionPaths[] r32 = new MotionPaths[r31];
        r32[0] = this.mStartMotionPath;
        r32[r31 - 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0) goto L119;
    L121:
        Iterator<MotionPaths> r33 = this.mMotionPaths.iterator();
        int r34 = 1;
    L123:
        if (r33.hasNext() == false) goto L125;
        r32[r34] = r33.next();
        r34 = r34 + 1;
        goto L123
    L125:
        HashSet r35 = new HashSet();
        Iterator<String> r116 = this.mEndMotionPath.attributes.keySet().iterator();
    L127:
        if (r116.hasNext() == false) goto L133;
        String r117 = r116.next();
        if (this.mStartMotionPath.attributes.containsKey(r117) == false) goto L127;
        if (r3.contains("CUSTOM," + r117) == true) goto L127;
        r35.add(r117);
        goto L127
    L133:
        String[] r36 = (String[]) r35.toArray(new String[0]);
        this.mAttributeNames = r36;
        this.mAttributeInterpolatorCount = new int[r36.length];
        int r37 = 0;
    L134:
        String[] r38 = this.mAttributeNames;
        if (r37 >= r38.length) goto L146;
        String r39 = r38[r37];
        this.mAttributeInterpolatorCount[r37] = 0;
        int r118 = 0;
    L137:
        if (r118 >= r31) goto L144;
        if (r32[r118].attributes.containsKey(r39) == false) goto L143;
        ConstraintAttribute r119 = r32[r118].attributes.get(r39);
        if (r119 == null) goto L143;
        int[] r40 = this.mAttributeInterpolatorCount;
        r40[r37] = r40[r37] + r119.numberOfInterpolatedValues();
    L143:
        r118 = r118 + 1;
    L144:
        r37 = r37 + 1;
        goto L134
    L146:
        if (r32[0].mPathMotionArc == Key.UNSET) goto L148;
        boolean r41 = true;
    L149:
        int r42 = 18 + r38.length;
        boolean[] r43 = new boolean[r42];
        int r120 = 1;
    L150:
        if (r120 >= r31) goto L152;
        r32[r120].different(r32[r120 - 1], r43, this.mAttributeNames, r41);
        r120 = r120 + 1;
        goto L150
    L152:
        int r121 = 0;
        int r44 = 1;
    L153:
        if (r44 >= r42) goto L158;
        if (r43[r44] == false) goto L157;
        r121 = r121 + 1;
    L157:
        r44 = r44 + 1;
        goto L153
    L158:
        this.mInterpolateVariables = new int[r121];
        int r45 = Math.max(2, r121);
        this.mInterpolateData = new double[r45];
        this.mInterpolateVelocity = new double[r45];
        int r122 = 0;
        int r46 = 1;
    L159:
        if (r46 >= r42) goto L164;
        if (r43[r46] == false) goto L163;
        this.mInterpolateVariables[r122] = r46;
        r122 = r122 + 1;
    L163:
        r46 = r46 + 1;
        goto L159
    L164:
        double[][] r47 = (double[][]) Array.newInstance(double.class, new int[]{r31, this.mInterpolateVariables.length});
        double[] r48 = new double[r31];
        int r49 = 0;
    L165:
        if (r49 >= r31) goto L167;
        r32[r49].fillStandard(r47[r49], this.mInterpolateVariables);
        r48[r49] = r32[r49].time;
        r49 = r49 + 1;
        goto L165
    L167:
        int r50 = 0;
    L168:
        int[] r123 = this.mInterpolateVariables;
        if (r50 >= r123.length) goto L176;
        if (r123[r50] >= MotionPaths.names.length) goto L175;
        String r124 = MotionPaths.names[this.mInterpolateVariables[r50]] + " [";
        int r125 = 0;
    L173:
        if (r125 >= r31) goto L175;
        r124 = r124 + r47[r125][r50];
        r125 = r125 + 1;
    L175:
        r50 = r50 + 1;
        goto L168
    L176:
        this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
        int r51 = 0;
    L177:
        String[] r126 = this.mAttributeNames;
        if (r51 >= r126.length) goto L188;
        String r127 = r126[r51];
        int r128 = r13;
        int r129 = r128;
        double[] r130 = null;
        double[][] r131 = null;
    L180:
        if (r128 >= r31) goto L187;
        if (r32[r128].hasCustomData(r127) == false) goto L186;
        if (r131 != null) goto L185;
        r130 = new double[r31];
        int[] r132 = new int[r30];
        r132[1] = r32[r128].getCustomDataCount(r127);
        r132[r13] = r31;
        r131 = (double[][]) Array.newInstance(double.class, r132);
    L185:
        r130[r129] = r32[r128].time;
        r32[r128].getCustomData(r127, r131[r129], 0);
        r129 = r129 + 1;
    L186:
        r128 = r128 + 1;
        r30 = 2;
        r13 = 0;
        goto L180
    L187:
        r51 = r51 + 1;
        this.mSpline[r51] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(r130, r129), (double[][]) Arrays.copyOf(r131, r129));
        r30 = 2;
        r13 = 0;
        goto L177
    L188:
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, r48, r47);
        if (r32[0].mPathMotionArc == Key.UNSET) goto L194;
        int[] r52 = new int[r31];
        double[] r53 = new double[r31];
        double[][] r1 = (double[][]) Array.newInstance(double.class, new int[]{r31, 2});
        int r133 = 0;
    L191:
        if (r133 >= r31) goto L193;
        r52[r133] = r32[r133].mPathMotionArc;
        r53[r133] = r32[r133].time;
        r1[r133][0] = r32[r133].x;
        r1[r133][1] = r32[r133].y;
        r133 = r133 + 1;
        goto L191
    L193:
        this.mArcSpline = CurveFit.getArc(r52, r53, r1);
    L194:
        float r54 = Float.NaN;
        this.mCycleMap = new HashMap();
        if (this.mKeyList == null) goto L218;
        Iterator<String> r55 = r4.iterator();
    L198:
        if (r55.hasNext() == false) goto L208;
        String r56 = r55.next();
        ViewOscillator r57 = ViewOscillator.makeSpline(r56);
        if (r57 == null) goto L198;
        if (r57.variesByPath() == true) goto L205;
    L207:
        r57.setType(r56);
        this.mCycleMap.put(r56, r57);
        goto L198
    L205:
        if (Float.isNaN(r54) == false) goto L207;
        r54 = getPreCycleDistance();
        goto L207
    L208:
        Iterator<Key> r58 = this.mKeyList.iterator();
    L210:
        if (r58.hasNext() == false) goto L214;
        Key r59 = r58.next();
        if ((r59 instanceof KeyCycle) == false) goto L210;
        ((KeyCycle) r59).addCycleValues(this.mCycleMap);
        goto L210
    L214:
        Iterator<ViewOscillator> r0 = this.mCycleMap.values().iterator();
    L216:
        if (r0.hasNext() == false) goto L316;
        r0.next().setup(r54);
        goto L216
    L316:
        return;
    L218:
        return;
    L148:
        r41 = false;
        goto L149
    L119:
        if (this.mCurveFitType != (-1)) goto L121;
        this.mCurveFitType = 0;
        goto L121
    L76:
        if (this.mTimeCycleAttributesMap != null) goto L78;
        this.mTimeCycleAttributesMap = new HashMap();
    L78:
        Iterator<String> r60 = r2.iterator();
    L80:
        if (r60.hasNext() == false) goto L100;
        String r61 = r60.next();
        if (this.mTimeCycleAttributesMap.containsKey(r61) == true) goto L80;
        if (r61.startsWith("CUSTOM,") == false) goto L96;
        SparseArray r62 = new SparseArray();
        String r134 = r61.split(",")[1];
        Iterator<Key> r135 = this.mKeyList.iterator();
    L88:
        if (r135.hasNext() == false) goto L95;
        Key r136 = r135.next();
        HashMap<String, ConstraintAttribute> r137 = r136.mCustomConstraints;
        if (r137 == null) goto L88;
        ConstraintAttribute r138 = r137.get(r134);
        if (r138 == null) goto L88;
        r62.append(r136.mFramePosition, r138);
        goto L88
    L95:
        ViewTimeCycle r63 = ViewTimeCycle.makeCustomSpline(r61, r62);
    L97:
        if (r63 == null) goto L80;
        r63.setType(r61);
        this.mTimeCycleAttributesMap.put(r61, r63);
        goto L80
    L96:
        r63 = ViewTimeCycle.makeSpline(r61, r21);
        goto L97
    L100:
        ArrayList<Key> r64 = this.mKeyList;
        if (r64 == null) goto L108;
        Iterator<Key> r65 = r64.iterator();
    L104:
        if (r65.hasNext() == false) goto L108;
        Key r66 = r65.next();
        if ((r66 instanceof KeyTimeCycle) == false) goto L104;
        ((KeyTimeCycle) r66).addTimeValues(this.mTimeCycleAttributesMap);
    L108:
        Iterator<String> r67 = this.mTimeCycleAttributesMap.keySet().iterator();
    L110:
        if (r67.hasNext() == false) goto L116;
        String r68 = r67.next();
        if (r5.containsKey(r68) == false) goto L114;
        int r69 = r5.get(r68).intValue();
    L115:
        this.mTimeCycleAttributesMap.get(r68).setup(r69);
        goto L110
    L114:
        r69 = 0;
        goto L115
    L27:
        r9 = null;
        goto L28
    }

    public void setupRelative(MotionController r3) {
        this.mStartMotionPath.setupRelative(r3, r3.mStartMotionPath);
        this.mEndMotionPath.setupRelative(r3, r3.mEndMotionPath);
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.x + " y: " + this.mStartMotionPath.y + " end: x: " + this.mEndMotionPath.x + " y: " + this.mEndMotionPath.y;
    }
}
