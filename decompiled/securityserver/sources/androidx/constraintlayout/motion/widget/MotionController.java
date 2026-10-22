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

    public MotionController(View r5) {
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
        Iterator<MotionPaths> r10 = this.mMotionPaths.iterator();
        float r4 = Float.NaN;
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
        float r4 = (float) (Math.hypot(r15 - ((double) r1[1]), r13 - ((double) r1[0])) + ((double) r14));
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

    public void addKeys(ArrayList<Key> r1) {
        this.mKeyList.addAll(r1);
    }

    public void buildBounds(float[] r18, int r19) {
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
        Iterator<MotionPaths> r111 = this.mMotionPaths.iterator();
        float r112 = Float.NaN;
    L32:
        if (r111.hasNext() == false) goto L41;
        MotionPaths r113 = r111.next();
        Easing r114 = r113.mKeyFrameEasing;
        if (r114 == null) goto L32;
        float r115 = r113.time;
        if (r115 < r13) goto L37;
        if (Float.isNaN(r112) == false) goto L32;
        r112 = r113.time;
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
        if (Float.isNaN(r112) == false) goto L45;
        r112 = 1.0f;
    L45:
        float r116 = r112 - r15;
        r17 = (((float) r110.get((r13 - r15) / r116)) * r116) + r15;
        goto L46
    }

    public int buildKeyBounds(float[] r8, int[] r9) {
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

    public int buildKeyFrames(float[] r11, int[] r12) {
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

    public void buildPath(float[] r21, int r22) {
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
        if (r5 != null) goto L17;
    L16:
        ViewOscillator r14 = r3;
        int r7 = 0;
    L19:
        if (r7 >= r22) goto L64;
        float r6 = r7 * r10;
        float r8 = this.mStaggerScale;
        float r15 = 0.0f;
        if (r8 == r9) goto L30;
        float r16 = this.mStaggerOffset;
        if (r6 >= r16) goto L26;
        r6 = 0.0f;
    L26:
        if (r6 <= r16) goto L30;
        if (r6 >= 1.0d) goto L30;
        r6 = Math.min((r6 - r16) * r8, r9);
    L30:
        float r17 = r6;
        double r18 = r17;
        Easing r19 = this.mStartMotionPath.mKeyFrameEasing;
        Iterator<MotionPaths> r20 = this.mMotionPaths.iterator();
        float r110 = Float.NaN;
    L32:
        if (r20.hasNext() == false) goto L42;
        MotionPaths r23 = r20.next();
        Easing r111 = r23.mKeyFrameEasing;
        double r112 = r18;
        if (r111 == null) goto L41;
        float r24 = r23.time;
        if (r24 >= r17) goto L39;
        r15 = r24;
        r19 = r111;
        goto L41
    L39:
        if (Float.isNaN(r110) == false) goto L41;
        r110 = r23.time;
    L41:
        r18 = r112;
        goto L32
    L42:
        double r113 = r18;
        if (r19 != null) goto L45;
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
        r21[r114] = r13.get(r17) + r21[r114];
    L59:
        if (r14 == null) goto L61;
        int r116 = r114 + 1;
        r21[r116] = r14.get(r17) + r21[r116];
    L63:
        r7 = r115 + 1;
        r9 = 1.0f;
        goto L19
    L61:
        if (r12 == null) goto L63;
        int r117 = r114 + 1;
        r21[r117] = r12.get(r17) + r21[r117];
        goto L63
    L57:
        if (r11 == null) goto L59;
        r21[r114] = r11.get(r17) + r21[r114];
        goto L59
    L45:
        if (Float.isNaN(r110) == false) goto L47;
        r110 = 1.0f;
    L47:
        float r118 = r110 - r15;
        r25 = (((float) r19.get((r17 - r15) / r118)) * r118) + r15;
        goto L49
    L64:
        return;
    L17:
        r3 = r5.get("translationY");
        goto L16
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

    public void buildRect(float r4, float[] r5, int r6) {
        this.mSpline[0].getPos(getAdjustedPosition(r4, null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, r5, r6);
    }

    public void buildRectangles(float[] r8, int r9) {
        float r1 = 1.0f / (r9 - 1);
        int r2 = 0;
    L3:
        if (r2 >= r9) goto L5;
        this.mSpline[0].getPos(getAdjustedPosition(r2 * r1, null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, r8, r2 * 8);
        r2 = r2 + 1;
        goto L3
    }

    public void endTrigger(boolean r5) {
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

    public int getAttributeValues(String r1, float[] r2, int r3) {
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

    public void getDpDt(float r12, float r13, float r14, float[] r15) {
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
        float r7 = r19.width - r11.width;
        float r110 = (r19.height - r11.height) + r6;
        r15[0] = ((r7 + r5) * r13) + ((1.0f - r13) * r5);
        r15[1] = (r110 * r14) + ((1.0f - r14) * r6);
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

    public MotionPaths getKeyFrame(int r1) {
        return this.mMotionPaths.get(r1);
    }

    public int getKeyFrameInfo(int r14, int[] r15) {
        float[] r0 = new float[2];
        Iterator<Key> r8 = this.mKeyList.iterator();
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r8.hasNext() == false) goto L14;
        Key r12 = r8.next();
        int r1 = r12.mType;
        if (r1 == r14) goto L10;
        if (r14 == (-1)) goto L4;
    L10:
        r15[r11] = 0;
        r15[r11 + 1] = r1;
        int r2 = r12.mFramePosition;
        r15[r11 + 2] = r2;
        double r3 = r2 / 100.0f;
        this.mSpline[0].getPos(r3, this.mInterpolateData);
        this.mStartMotionPath.getCenter(r3, this.mInterpolateVariables, this.mInterpolateData, r0, 0);
        r15[r11 + 3] = Float.floatToIntBits(r0[0]);
        int r4 = r11 + 4;
        r15[r4] = Float.floatToIntBits(r0[1]);
        if ((r12 instanceof KeyPosition) == false) goto L13;
        KeyPosition r13 = (KeyPosition) r12;
        r15[r11 + 5] = r13.mPositionType;
        r15[r11 + 6] = Float.floatToIntBits(r13.mPercentX);
        r4 = r11 + 7;
        r15[r4] = Float.floatToIntBits(r13.mPercentY);
    L13:
        int r5 = r4 + 1;
        r15[r11] = r5 - r11;
        r10 = r10 + 1;
        r11 = r5;
        goto L4
    L14:
        return r10;
    }

    public float getKeyFrameParameter(int r10, float r11, float r12) {
        MotionPaths r0 = this.mEndMotionPath;
        float r1 = r0.x;
        MotionPaths r9 = this.mStartMotionPath;
        float r2 = r9.x;
        float r3 = r1 - r2;
        float r4 = r0.y;
        float r5 = r9.y;
        float r6 = r4 - r5;
        float r7 = (r9.width / 2.0f) + r2;
        float r13 = (r9.height / 2.0f) + r5;
        float r8 = (float) Math.hypot(r3, r6);
        if (r8 >= 1.0E-7d) goto L6;
        return Float.NaN;
    L6:
        float r14 = r11 - r7;
        float r15 = r12 - r13;
        if (((float) Math.hypot(r14, r15)) != 0.0f) goto L9;
        return 0.0f;
    L9:
        float r16 = (r15 * r6) + (r14 * r3);
        if (r10 == 0) goto L33;
        if (r10 == 1) goto L31;
        if (r10 == 2) goto L29;
        if (r10 == 3) goto L27;
        if (r10 == 4) goto L25;
        if (r10 == 5) goto L23;
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
        return (float) Math.sqrt((r8 * r8) - (r16 * r16));
    L33:
        return r16 / r8;
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

    public double[] getPos(double r4) {
        this.mSpline[0].getPos(r4, this.mInterpolateData);
        CurveFit r0 = this.mArcSpline;
        if (r0 == null) goto L8;
        double[] r1 = this.mInterpolateData;
        if (r1.length <= 0) goto L8;
        r0.getPos(r4, r1);
    L8:
        return this.mInterpolateData;
    }

    public KeyPositionBase getPositionKeyframe(int r11, int r12, float r13, float r14) {
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

    public void getPostLayoutDvDp(float r19, int r20, int r21, float r22, float r23, float[] r24) {
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
        float r30 = r116.width - r0.width;
        float r122 = (r116.height - r0.height) + r120;
        r24[0] = ((r30 + r118) * r22) + ((1.0f - r22) * r118);
        r24[1] = (r122 * r23) + ((1.0f - r23) * r120);
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

    public boolean interpolate(View r21, float r22, long r23, KeyCache r25) {
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
        r21.setVisibility(r33.visibility);
        goto L84
    L78:
        if (r14 < 1.0f) goto L81;
        r21.setVisibility(this.mEndPoint.visibility);
        goto L84
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
        float r41 = (this.mTransformPivotView.getBottom() + r40.getTop()) / 2.0f;
        float r42 = (this.mTransformPivotView.getRight() + this.mTransformPivotView.getLeft()) / 2.0f;
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
        float r48 = a.a.a(r47.x, r46, r14, r46);
        float r49 = r45.y;
        float r50 = a.a.a(r47.y, r49, r14, r49);
        float r51 = r45.width;
        float r52 = r47.width;
        float r53 = a.a.a(r52, r51, r14, r51);
        float r54 = r45.height;
        float r55 = r47.height;
        float r56 = r48 + 0.5f;
        int r111 = (int) r56;
        float r57 = r50 + 0.5f;
        int r58 = (int) r57;
        int r59 = (int) (r56 + r53);
        int r60 = (int) (r57 + a.a.a(r55, r54, r14, r54));
        int r61 = r59 - r111;
        int r62 = r60 - r58;
        if (r52 == r51) goto L92;
    L95:
        r21.measure(View.MeasureSpec.makeMeasureSpec(r61, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(r62, BasicMeasure.EXACTLY));
        this.mForceMeasure = false;
    L96:
        r21.layout(r111, r58, r59, r60);
        goto L97
    L92:
        if (r55 != r54) goto L95;
        if (this.mForceMeasure == false) goto L96;
    L31:
        r17 = null;
        r16 = false;
        goto L32
    }

    public String name() {
        return this.mView.getContext().getResources().getResourceEntryName(this.mView.getId());
    }

    public void positionKeyframe(View r9, KeyPositionBase r10, float r11, float r12, String[] r13, float[] r14) {
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

    public void rotate(Rect r2, Rect r3, int r4, int r5, int r6) {
        if (r4 == 1) goto L13;
        if (r4 != 2) goto L6;
        int r1 = r2.left + r2.right;
        int r7 = r2.top + r2.bottom;
        r3.left = r5 - ((r2.width() + r7) / 2);
        r3.top = (r1 - r2.height()) / 2;
        int r8 = r3.left;
        r3.right = r2.width() + r8;
        int r9 = r3.top;
        r3.bottom = r2.height() + r9;
        return;
    L6:
        if (r4 != 3) goto L8;
        int r10 = r2.left + r2.right;
        r3.left = ((r2.height() / 2) + r2.top) - (r10 / 2);
        r3.top = r6 - ((r2.height() + r10) / 2);
        int r11 = r3.left;
        r3.right = r2.width() + r11;
        int r12 = r3.top;
        r3.bottom = r2.height() + r12;
        return;
    L8:
        if (r4 != 4) goto L18;
        int r13 = r2.left + r2.right;
        int r14 = r2.bottom + r2.top;
        r3.left = r5 - ((r2.width() + r14) / 2);
        r3.top = (r13 - r2.height()) / 2;
        int r15 = r3.left;
        r3.right = r2.width() + r15;
        int r16 = r3.top;
        r3.bottom = r2.height() + r16;
        return;
    L18:
        return;
    L13:
        int r17 = r2.left + r2.right;
        r3.left = ((r2.top + r2.bottom) - r2.width()) / 2;
        r3.top = r6 - ((r2.height() + r17) / 2);
        int r18 = r3.left;
        r3.right = r2.width() + r18;
        int r19 = r3.top;
        r3.bottom = r2.height() + r19;
    }

    public void setBothStates(View r6) {
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

    public void setEndState(Rect r8, ConstraintSet r9, int r10, int r11) {
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

    public void setStartCurrentState(View r6) {
        MotionPaths r0 = this.mStartMotionPath;
        r0.time = 0.0f;
        r0.position = 0.0f;
        r0.setBounds(r6.getX(), r6.getY(), r6.getWidth(), r6.getHeight());
        this.mStartPoint.setState(r6);
    }

    public void setStartState(ViewState r5, View r6, int r7, int r8, int r9) {
        MotionPaths r0 = this.mStartMotionPath;
        r0.time = 0.0f;
        r0.position = 0.0f;
        Rect r1 = new Rect();
        if (r7 == 1) goto L7;
        if (r7 != 2) goto L8;
        int r10 = r5.left + r5.right;
        r1.left = r9 - ((r5.width() + (r5.top + r5.bottom)) / 2);
        r1.top = (r10 - r5.height()) / 2;
        r1.right = r5.width() + r1.left;
        r1.bottom = r5.height() + r1.top;
    L8:
        this.mStartMotionPath.setBounds(r1.left, r1.top, r1.width(), r1.height());
        this.mStartPoint.setState(r1, r6, r7, r5.rotation);
        return;
    L7:
        int r11 = r5.left + r5.right;
        r1.left = ((r5.top + r5.bottom) - r5.width()) / 2;
        r1.top = r8 - ((r5.height() + r11) / 2);
        r1.right = r5.width() + r1.left;
        r1.bottom = r5.height() + r1.top;
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

    public void setup(int r17, int r18, float r19, long r20) {
        new HashSet();
        HashSet<String> r1 = new HashSet();
        HashSet<String> r2 = new HashSet();
        HashSet<String> r3 = new HashSet();
        HashMap<String, Integer> r4 = new HashMap();
        int r5 = this.mPathMotionArc;
        if (r5 == Key.UNSET) goto L5;
        this.mStartMotionPath.mPathMotionArc = r5;
    L5:
        this.mStartPoint.different(this.mEndPoint, r2);
        ArrayList<Key> r6 = this.mKeyList;
        if (r6 == null) goto L27;
        Iterator<Key> r7 = r6.iterator();
        ArrayList r8 = null;
    L9:
        if (r7.hasNext() == false) goto L29;
        Key r9 = r7.next();
        if ((r9 instanceof KeyPosition) == true) goto L12;
        if ((r9 instanceof KeyCycle) == true) goto L17;
        if ((r9 instanceof KeyTimeCycle) == true) goto L20;
        if ((r9 instanceof KeyTrigger) == true) goto L23;
        r9.setInterpolation(r4);
        r9.getAttributeNames(r2);
        goto L9
    L23:
        if (r8 != null) goto L25;
        r8 = new ArrayList();
    L25:
        r8.add((KeyTrigger) r9);
        goto L9
    L20:
        r9.getAttributeNames(r1);
        goto L9
    L17:
        r9.getAttributeNames(r3);
        goto L9
    L12:
        KeyPosition r10 = (KeyPosition) r9;
        insertKey(new MotionPaths(r17, r18, r10, this.mStartMotionPath, this.mEndMotionPath));
        int r11 = r10.mCurveFit;
        if (r11 == Key.UNSET) goto L9;
        this.mCurveFitType = r11;
    L29:
        if (r8 == null) goto L31;
        this.mKeyTriggers = (KeyTrigger[]) r8.toArray(new KeyTrigger[0]);
    L31:
        char r12 = 1;
        if (r2.isEmpty() == true) goto L73;
        this.mAttributesMap = new HashMap();
        Iterator<String> r13 = r2.iterator();
    L35:
        if (r13.hasNext() == false) goto L52;
        String r14 = r13.next();
        if (r14.startsWith("CUSTOM,") == false) goto L48;
        SparseArray r15 = new SparseArray();
        String r16 = r14.split(",")[1];
        Iterator<Key> r110 = this.mKeyList.iterator();
    L40:
        if (r110.hasNext() == false) goto L47;
        Key r111 = r110.next();
        HashMap<String, ConstraintAttribute> r21 = r111.mCustomConstraints;
        if (r21 == null) goto L40;
        ConstraintAttribute r22 = r21.get(r16);
        if (r22 == null) goto L40;
        r15.append(r111.mFramePosition, r22);
        goto L40
    L47:
        ViewSpline r23 = ViewSpline.makeCustomSpline(r14, r15);
    L49:
        if (r23 == null) goto L35;
        r23.setType(r14);
        this.mAttributesMap.put(r14, r23);
        goto L35
    L48:
        r23 = ViewSpline.makeSpline(r14);
        goto L49
    L52:
        ArrayList<Key> r24 = this.mKeyList;
        if (r24 == null) goto L60;
        Iterator<Key> r25 = r24.iterator();
    L56:
        if (r25.hasNext() == false) goto L60;
        Key r26 = r25.next();
        if ((r26 instanceof KeyAttributes) == false) goto L56;
        r26.addValues(this.mAttributesMap);
    L60:
        this.mStartPoint.addValues(this.mAttributesMap, 0);
        this.mEndPoint.addValues(this.mAttributesMap, 100);
        Iterator<String> r27 = this.mAttributesMap.keySet().iterator();
    L62:
        if (r27.hasNext() == false) goto L73;
        String r28 = r27.next();
        if (r4.containsKey(r28) == false) goto L68;
        Integer r112 = r4.get(r28);
        if (r112 == null) goto L68;
        int r113 = r112.intValue();
    L69:
        ViewSpline r29 = this.mAttributesMap.get(r28);
        if (r29 == null) goto L62;
        r29.setup(r113);
    L68:
        r113 = 0;
    L73:
        if (r1.isEmpty() == false) goto L75;
    L115:
        int r30 = this.mMotionPaths.size();
        int r31 = r30 + 2;
        MotionPaths[] r32 = new MotionPaths[r31];
        r32[0] = this.mStartMotionPath;
        r32[r30 + 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0) goto L118;
    L120:
        Iterator<MotionPaths> r33 = this.mMotionPaths.iterator();
        int r34 = 1;
    L122:
        if (r33.hasNext() == false) goto L124;
        r32[r34] = r33.next();
        r34 = r34 + 1;
        goto L122
    L124:
        HashSet r35 = new HashSet();
        Iterator<String> r36 = this.mEndMotionPath.attributes.keySet().iterator();
    L126:
        if (r36.hasNext() == false) goto L132;
        String r37 = r36.next();
        if (this.mStartMotionPath.attributes.containsKey(r37) == false) goto L126;
        if (r2.contains("CUSTOM," + r37) == true) goto L126;
        r35.add(r37);
        goto L126
    L132:
        String[] r38 = (String[]) r35.toArray(new String[0]);
        this.mAttributeNames = r38;
        this.mAttributeInterpolatorCount = new int[r38.length];
        int r39 = 0;
    L133:
        String[] r40 = this.mAttributeNames;
        if (r39 >= r40.length) goto L145;
        String r41 = r40[r39];
        this.mAttributeInterpolatorCount[r39] = 0;
        int r42 = 0;
    L136:
        if (r42 >= r31) goto L143;
        if (r32[r42].attributes.containsKey(r41) == false) goto L142;
        ConstraintAttribute r43 = r32[r42].attributes.get(r41);
        if (r43 == null) goto L142;
        int[] r44 = this.mAttributeInterpolatorCount;
        r44[r39] = r43.numberOfInterpolatedValues() + r44[r39];
    L142:
        r42 = r42 + 1;
    L143:
        r39 = r39 + 1;
        goto L133
    L145:
        if (r32[0].mPathMotionArc == Key.UNSET) goto L147;
        boolean r45 = true;
    L148:
        int r46 = 18 + r40.length;
        boolean[] r47 = new boolean[r46];
        int r48 = 1;
    L149:
        if (r48 >= r31) goto L151;
        r32[r48].different(r32[r48 - 1], r47, this.mAttributeNames, r45);
        r48 = r48 + 1;
        goto L149
    L151:
        int r49 = 0;
        int r50 = 1;
    L152:
        if (r50 >= r46) goto L157;
        if (r47[r50] == false) goto L156;
        r49 = r49 + 1;
    L156:
        r50 = r50 + 1;
        goto L152
    L157:
        this.mInterpolateVariables = new int[r49];
        int r51 = 2;
        int r52 = Math.max(2, r49);
        this.mInterpolateData = new double[r52];
        this.mInterpolateVelocity = new double[r52];
        int r53 = 0;
        int r54 = 1;
    L158:
        if (r54 >= r46) goto L163;
        if (r47[r54] == false) goto L162;
        this.mInterpolateVariables[r53] = r54;
        r53 = r53 + 1;
    L162:
        r54 = r54 + 1;
        goto L158
    L163:
        double[][] r55 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r31, this.mInterpolateVariables.length});
        double[] r56 = new double[r31];
        int r57 = 0;
    L164:
        if (r57 >= r31) goto L166;
        r32[r57].fillStandard(r55[r57], this.mInterpolateVariables);
        r56[r57] = r32[r57].time;
        r57 = r57 + 1;
        goto L164
    L166:
        int r58 = 0;
    L167:
        int[] r59 = this.mInterpolateVariables;
        if (r58 >= r59.length) goto L175;
        if (r59[r58] >= MotionPaths.names.length) goto L174;
        String r60 = a.a.o(new StringBuilder(), MotionPaths.names[this.mInterpolateVariables[r58]], " [");
        int r114 = 0;
    L172:
        if (r114 >= r31) goto L174;
        StringBuilder r61 = a.a.q(r60);
        r61.append(r55[r114][r58]);
        r60 = r61.toString();
        r114 = r114 + 1;
    L174:
        r58 = r58 + 1;
        goto L167
    L175:
        this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
        int r62 = 0;
    L176:
        String[] r63 = this.mAttributeNames;
        if (r62 >= r63.length) goto L188;
        String r64 = r63[r62];
        int r115 = 0;
        int r116 = 0;
        double[] r117 = null;
        double[][] r118 = null;
    L179:
        if (r115 >= r31) goto L187;
        if (r32[r115].hasCustomData(r64) == false) goto L186;
        if (r118 != null) goto L184;
        r117 = new double[r31];
        int[] r119 = new int[r51];
        r119[r12] = r32[r115].getCustomDataCount(r64);
        r119[0] = r31;
        r118 = (double[][]) Array.newInstance(Double.TYPE, r119);
    L184:
        MotionPaths r120 = r32[r115];
        r117[r116] = r120.time;
        r120.getCustomData(r64, r118[r116], 0);
        r116 = r116 + 1;
    L186:
        r115 = r115 + 1;
        r55 = r55;
        r51 = 2;
        r12 = 1;
        goto L179
    L187:
        r62 = r62 + 1;
        this.mSpline[r62] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(r117, r116), (double[][]) Arrays.copyOf(r118, r116));
        r55 = r55;
        r51 = 2;
        r12 = 1;
        goto L176
    L188:
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, r56, r55);
        if (r32[0].mPathMotionArc == Key.UNSET) goto L194;
        int[] r65 = new int[r31];
        double[] r66 = new double[r31];
        double[][] r67 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r31, 2});
        int r68 = 0;
    L191:
        if (r68 >= r31) goto L193;
        MotionPaths r69 = r32[r68];
        r65[r68] = r69.mPathMotionArc;
        r66[r68] = r69.time;
        double[] r121 = r67[r68];
        r121[0] = r69.x;
        r121[1] = r69.y;
        r68 = r68 + 1;
        goto L191
    L193:
        this.mArcSpline = CurveFit.getArc(r65, r66, r67);
    L194:
        this.mCycleMap = new HashMap();
        if (this.mKeyList == null) goto L218;
        Iterator<String> r70 = r3.iterator();
        float r71 = Float.NaN;
    L198:
        if (r70.hasNext() == false) goto L208;
        String r72 = r70.next();
        ViewOscillator r73 = ViewOscillator.makeSpline(r72);
        if (r73 == null) goto L198;
        if (r73.variesByPath() == true) goto L205;
    L207:
        r73.setType(r72);
        this.mCycleMap.put(r72, r73);
        goto L198
    L205:
        if (Float.isNaN(r71) == false) goto L207;
        r71 = getPreCycleDistance();
        goto L207
    L208:
        Iterator<Key> r74 = this.mKeyList.iterator();
    L210:
        if (r74.hasNext() == false) goto L214;
        Key r75 = r74.next();
        if ((r75 instanceof KeyCycle) == false) goto L210;
        ((KeyCycle) r75).addCycleValues(this.mCycleMap);
        goto L210
    L214:
        Iterator<ViewOscillator> r0 = this.mCycleMap.values().iterator();
    L216:
        if (r0.hasNext() == false) goto L321;
        r0.next().setup(r71);
        goto L216
    L321:
        return;
    L218:
        return;
    L147:
        r45 = false;
        goto L148
    L118:
        if (this.mCurveFitType != (-1)) goto L120;
        this.mCurveFitType = 0;
        goto L120
    L75:
        if (this.mTimeCycleAttributesMap != null) goto L77;
        this.mTimeCycleAttributesMap = new HashMap();
    L77:
        Iterator<String> r76 = r1.iterator();
    L79:
        if (r76.hasNext() == false) goto L99;
        String r77 = r76.next();
        if (this.mTimeCycleAttributesMap.containsKey(r77) == true) goto L79;
        if (r77.startsWith("CUSTOM,") == false) goto L95;
        SparseArray r78 = new SparseArray();
        String r122 = r77.split(",")[1];
        Iterator<Key> r123 = this.mKeyList.iterator();
    L87:
        if (r123.hasNext() == false) goto L94;
        Key r124 = r123.next();
        HashMap<String, ConstraintAttribute> r125 = r124.mCustomConstraints;
        if (r125 == null) goto L87;
        ConstraintAttribute r126 = r125.get(r122);
        if (r126 == null) goto L87;
        r78.append(r124.mFramePosition, r126);
        goto L87
    L94:
        ViewTimeCycle r79 = ViewTimeCycle.makeCustomSpline(r77, r78);
    L96:
        if (r79 == null) goto L79;
        r79.setType(r77);
        this.mTimeCycleAttributesMap.put(r77, r79);
        goto L79
    L95:
        r79 = ViewTimeCycle.makeSpline(r77, r20);
        goto L96
    L99:
        ArrayList<Key> r80 = this.mKeyList;
        if (r80 == null) goto L107;
        Iterator<Key> r81 = r80.iterator();
    L103:
        if (r81.hasNext() == false) goto L107;
        Key r82 = r81.next();
        if ((r82 instanceof KeyTimeCycle) == false) goto L103;
        ((KeyTimeCycle) r82).addTimeValues(this.mTimeCycleAttributesMap);
    L107:
        Iterator<String> r83 = this.mTimeCycleAttributesMap.keySet().iterator();
    L109:
        if (r83.hasNext() == false) goto L115;
        String r84 = r83.next();
        if (r4.containsKey(r84) == false) goto L113;
        int r85 = r4.get(r84).intValue();
    L114:
        this.mTimeCycleAttributesMap.get(r84).setup(r85);
        goto L109
    L113:
        r85 = 0;
        goto L114
    L27:
        r8 = null;
        goto L29
    }

    public void setupRelative(MotionController r3) {
        this.mStartMotionPath.setupRelative(r3, r3.mStartMotionPath);
        this.mEndMotionPath.setupRelative(r3, r3.mEndMotionPath);
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.x + " y: " + this.mStartMotionPath.y + " end: x: " + this.mEndMotionPath.x + " y: " + this.mEndMotionPath.y;
    }

    public void setStartState(Rect r8, ConstraintSet r9, int r10, int r11) {
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
}
