package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.key.MotionKey;
import androidx.constraintlayout.core.motion.key.MotionKeyAttributes;
import androidx.constraintlayout.core.motion.key.MotionKeyCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.key.MotionKeyTimeCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyTrigger;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.DifferentialInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.FloatRect;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import androidx.constraintlayout.core.motion.utils.Rect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.motion.utils.Utils;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.core.motion.utils.ViewState;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class Motion implements TypedValues {
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
    private HashMap<String, SplineSet> mAttributesMap;
    String mConstraintTag;
    float mCurrentCenterX;
    float mCurrentCenterY;
    private int mCurveFitType;
    private HashMap<String, KeyCycleOscillator> mCycleMap;
    private MotionPaths mEndMotionPath;
    private MotionConstrainedPoint mEndPoint;
    int mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private ArrayList<MotionKey> mKeyList;
    private MotionKeyTrigger[] mKeyTriggers;
    private ArrayList<MotionPaths> mMotionPaths;
    float mMotionStagger;
    private boolean mNoMovement;
    private int mPathMotionArc;
    private DifferentialInterpolator mQuantizeMotionInterpolator;
    private float mQuantizeMotionPhase;
    private int mQuantizeMotionSteps;
    private CurveFit[] mSpline;
    float mStaggerOffset;
    float mStaggerScale;
    private MotionPaths mStartMotionPath;
    private MotionConstrainedPoint mStartPoint;
    Rect mTempRect;
    private HashMap<String, TimeCycleSplineSet> mTimeCycleAttributesMap;
    private int mTransformPivotTarget;
    private MotionWidget mTransformPivotView;
    private float[] mValuesBuff;
    private float[] mVelocity;
    MotionWidget mView;

    public Motion(MotionWidget r4) {
        this.mTempRect = new Rect();
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
        this.mPathMotionArc = -1;
        this.mTransformPivotTarget = -1;
        this.mTransformPivotView = null;
        this.mQuantizeMotionSteps = -1;
        this.mQuantizeMotionPhase = Float.NaN;
        this.mQuantizeMotionInterpolator = null;
        this.mNoMovement = false;
        setView(r4);
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

    private static DifferentialInterpolator getInterpolator(int r0, String r1, int r2) {
        if (r0 == (-1)) goto L6;
        return null;
    L6:
        final Easing r3 = Easing.getInterpolator(r1);
        return new AnonymousClass1(r3);
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

    private void insertKey(MotionPaths r6) {
        Iterator<MotionPaths> r0 = this.mMotionPaths.iterator();
        MotionPaths r1 = null;
    L4:
        if (r0.hasNext() == false) goto L8;
        MotionPaths r2 = r0.next();
        if (r6.position != r2.position) goto L4;
        r1 = r2;
        goto L4
    L8:
        if (r1 == null) goto L10;
        this.mMotionPaths.remove(r1);
    L10:
        int r3 = Collections.binarySearch(this.mMotionPaths, r6);
        if (r3 != 0) goto L13;
        Utils.loge(TAG, " KeyPath position \"" + r6.position + "\" outside of range");
    L13:
        this.mMotionPaths.add((-r3) - 1, r6);
    }

    private void readView(MotionPaths r4) {
        r4.setBounds(this.mView.getX(), this.mView.getY(), this.mView.getWidth(), this.mView.getHeight());
    }

    public void addKey(MotionKey r1) {
        this.mKeyList.add(r1);
    }

    void addKeys(ArrayList<MotionKey> r1) {
        this.mKeyList.addAll(r1);
    }

    void buildBounds(float[] r18, int r19) {
        float r2 = 1.0f / (r19 - 1);
        HashMap<String, SplineSet> r4 = this.mAttributesMap;
        if (r4 == null) goto L6;
        SplineSet r5 = r4.get("translationX");
    L6:
        HashMap<String, SplineSet> r6 = this.mAttributesMap;
        if (r6 == null) goto L10;
        SplineSet r7 = r6.get("translationY");
    L10:
        HashMap<String, KeyCycleOscillator> r8 = this.mCycleMap;
        if (r8 == null) goto L14;
        KeyCycleOscillator r9 = r8.get("translationX");
    L14:
        HashMap<String, KeyCycleOscillator> r10 = this.mCycleMap;
        if (r10 == null) goto L18;
        KeyCycleOscillator r11 = r10.get("translationY");
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

    public int buildKeyFrames(float[] r10, int[] r11, int[] r12) {
        if (r10 == null) goto L21;
        double[] r1 = this.mSpline[0].getTimePoints();
        if (r11 == null) goto L10;
        Iterator<MotionPaths> r2 = this.mMotionPaths.iterator();
        int r3 = 0;
    L8:
        if (r2.hasNext() == false) goto L10;
        r11[r3] = r2.next().mMode;
        r3 = r3 + 1;
    L10:
        if (r12 == null) goto L15;
        Iterator<MotionPaths> r13 = this.mMotionPaths.iterator();
        int r4 = 0;
    L13:
        if (r13.hasNext() == false) goto L15;
        r12[r4] = (int) (r13.next().position * 100.0f);
        r4 = r4 + 1;
    L15:
        int r14 = 0;
        int r15 = 0;
    L17:
        if (r14 >= r1.length) goto L20;
        this.mSpline[0].getPos(r1[r14], this.mInterpolateData);
        this.mStartMotionPath.getCenter(r1[r14], this.mInterpolateVariables, this.mInterpolateData, r10, r15);
        r15 = r15 + 2;
        r14 = r14 + 1;
        goto L17
    L20:
        return r15 / 2;
    L21:
        return 0;
    }

    public void buildPath(float[] r21, int r22) {
        float r9 = 1.0f;
        float r10 = 1.0f / (r22 - 1);
        HashMap<String, SplineSet> r1 = this.mAttributesMap;
        KeyCycleOscillator r3 = null;
        if (r1 != null) goto L5;
        SplineSet r11 = null;
    L6:
        HashMap<String, SplineSet> r2 = this.mAttributesMap;
        if (r2 != null) goto L9;
        SplineSet r12 = null;
    L10:
        HashMap<String, KeyCycleOscillator> r4 = this.mCycleMap;
        if (r4 != null) goto L13;
        KeyCycleOscillator r13 = null;
    L14:
        HashMap<String, KeyCycleOscillator> r5 = this.mCycleMap;
        if (r5 == null) goto L18;
        r3 = r5.get("translationY");
    L18:
        KeyCycleOscillator r14 = r3;
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

    public void buildRect(float r4, float[] r5, int r6) {
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

    void endTrigger(boolean r1) {
    }

    public int getAnimateRelativeTo() {
        return this.mStartMotionPath.mAnimateRelativeTo;
    }

    int getAttributeValues(String r1, float[] r2, int r3) {
        SplineSet r0 = this.mAttributesMap.get(r1);
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

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String r1) {
        return 0;
    }

    public MotionPaths getKeyFrame(int r1) {
        return this.mMotionPaths.get(r1);
    }

    public int getKeyFrameInfo(int r18, int[] r19) {
        float[] r2 = new float[2];
        Iterator<MotionKey> r10 = this.mKeyList.iterator();
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r10.hasNext() == false) goto L14;
        MotionKey r14 = r10.next();
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
        if ((r14 instanceof MotionKeyPosition) == false) goto L13;
        MotionKeyPosition r15 = (MotionKeyPosition) r14;
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
        Iterator<MotionKey> r0 = this.mKeyList.iterator();
        int r2 = 0;
        int r10 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        MotionKey r3 = r0.next();
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

    MotionKeyPosition getPositionKeyframe(int r11, int r12, float r13, float r14) {
        FloatRect r7 = new FloatRect();
        MotionPaths r0 = this.mStartMotionPath;
        float r1 = r0.x;
        r7.left = r1;
        float r2 = r0.y;
        r7.top = r2;
        r7.right = r1 + r0.width;
        r7.bottom = r2 + r0.height;
        FloatRect r8 = new FloatRect();
        MotionPaths r3 = this.mEndMotionPath;
        float r4 = r3.x;
        r8.left = r4;
        float r5 = r3.y;
        r8.top = r5;
        r8.right = r4 + r3.width;
        r8.bottom = r5 + r3.height;
        Iterator<MotionKey> r10 = this.mKeyList.iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        MotionKey r6 = r10.next();
        if ((r6 instanceof MotionKeyPosition) == false) goto L4;
        MotionKeyPosition r9 = (MotionKeyPosition) r6;
        if (r9.intersects(r11, r12, r7, r8, r13, r14) == false) goto L4;
        return r9;
    L10:
        return null;
    }

    void getPostLayoutDvDp(float r19, int r20, int r21, float r22, float r23, float[] r24) {
        float r1 = getAdjustedPosition(r19, this.mVelocity);
        HashMap<String, SplineSet> r2 = this.mAttributesMap;
        KeyCycleOscillator r4 = null;
        if (r2 != null) goto L5;
        SplineSet r3 = null;
    L6:
        HashMap<String, SplineSet> r5 = this.mAttributesMap;
        if (r5 != null) goto L9;
        SplineSet r6 = null;
    L10:
        HashMap<String, SplineSet> r7 = this.mAttributesMap;
        if (r7 != null) goto L13;
        SplineSet r8 = null;
    L14:
        HashMap<String, SplineSet> r9 = this.mAttributesMap;
        if (r9 != null) goto L17;
        SplineSet r10 = null;
    L18:
        HashMap<String, SplineSet> r11 = this.mAttributesMap;
        if (r11 != null) goto L21;
        SplineSet r12 = null;
    L22:
        HashMap<String, KeyCycleOscillator> r13 = this.mCycleMap;
        if (r13 != null) goto L25;
        KeyCycleOscillator r14 = null;
    L26:
        HashMap<String, KeyCycleOscillator> r15 = this.mCycleMap;
        if (r15 != null) goto L29;
        KeyCycleOscillator r16 = null;
    L30:
        HashMap<String, KeyCycleOscillator> r17 = this.mCycleMap;
        if (r17 != null) goto L33;
        KeyCycleOscillator r18 = null;
    L34:
        HashMap<String, KeyCycleOscillator> r110 = this.mCycleMap;
        if (r110 != null) goto L37;
        KeyCycleOscillator r111 = null;
    L38:
        HashMap<String, KeyCycleOscillator> r112 = this.mCycleMap;
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
        KeyCycleOscillator r119 = r4;
        float r120 = r116.y - r0.y;
        KeyCycleOscillator r121 = r111;
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
        r18 = r17.get("rotationZ");
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
        r8 = r7.get("rotationZ");
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

    public MotionWidget getView() {
        return this.mView;
    }

    public boolean interpolate(MotionWidget r18, float r19, long r20, KeyCache r22) {
        float r1 = getAdjustedPosition(r19, null);
        int r2 = this.mQuantizeMotionSteps;
        if (r2 == (-1)) goto L15;
        float r3 = 1.0f / r2;
        float r4 = ((float) Math.floor(r1 / r3)) * r3;
        float r5 = (r1 % r3) / r3;
        if (Float.isNaN(this.mQuantizeMotionPhase) == true) goto L7;
        r5 = (r5 + this.mQuantizeMotionPhase) % 1.0f;
    L7:
        DifferentialInterpolator r6 = this.mQuantizeMotionInterpolator;
        if (r6 == null) goto L11;
        float r7 = r6.getInterpolation(r5);
    L14:
        r1 = (r7 * r3) + r4;
        goto L15
    L11:
        if (r5 <= 0.5d) goto L13;
        r7 = 1.0f;
        goto L14
    L13:
        r7 = 0.0f;
    L15:
        float r12 = r1;
        HashMap<String, SplineSet> r8 = this.mAttributesMap;
        if (r8 == null) goto L21;
        Iterator<SplineSet> r9 = r8.values().iterator();
    L19:
        if (r9.hasNext() == false) goto L21;
        r9.next().setProperty(r18, r12);
    L21:
        CurveFit[] r10 = this.mSpline;
        if (r10 == null) goto L66;
        double r11 = r12;
        r10[0].getPos(r11, this.mInterpolateData);
        this.mSpline[0].getSlope(r11, this.mInterpolateVelocity);
        CurveFit r13 = this.mArcSpline;
        if (r13 == null) goto L29;
        double[] r14 = this.mInterpolateData;
        if (r14.length <= 0) goto L29;
        r13.getPos(r11, r14);
        this.mArcSpline.getSlope(r11, this.mInterpolateVelocity);
    L29:
        if (this.mNoMovement == true) goto L33;
        this.mStartMotionPath.setView(r12, r18, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null);
    L33:
        if (this.mTransformPivotTarget != (-1)) goto L35;
    L44:
        int r15 = 1;
    L45:
        CurveFit[] r16 = this.mSpline;
        if (r15 >= r16.length) goto L48;
        r16[r15].getPos(r11, this.mValuesBuff);
        this.mStartMotionPath.customAttributes.get(this.mAttributeNames[r15 - 1]).setInterpolatedValue(r18, this.mValuesBuff);
        r15 = r15 + 1;
        goto L45
    L48:
        MotionConstrainedPoint r17 = this.mStartPoint;
        if (r17.mVisibilityMode != 0) goto L61;
        if (r12 > 0.0f) goto L55;
    L52:
        int r21 = r17.visibility;
    L53:
        r18.setVisibility(r21);
        goto L61
    L55:
        if (r12 < 1.0f) goto L58;
        r17 = this.mEndPoint;
        goto L52
    L58:
        if (this.mEndPoint.visibility == r17.visibility) goto L61;
        r21 = 4;
    L61:
        if (this.mKeyTriggers == null) goto L67;
        int r23 = 0;
    L63:
        MotionKeyTrigger[] r24 = this.mKeyTriggers;
        if (r23 >= r24.length) goto L67;
        r24[r23].conditionallyFire(r12, r18);
        r23 = r23 + 1;
    L67:
        HashMap<String, KeyCycleOscillator> r25 = this.mCycleMap;
        if (r25 == null) goto L76;
        Iterator<KeyCycleOscillator> r26 = r25.values().iterator();
    L71:
        if (r26.hasNext() == false) goto L87;
        KeyCycleOscillator r27 = r26.next();
        if ((r27 instanceof KeyCycleOscillator.PathRotateSet) == true) goto L74;
        r27.setProperty(r18, r12);
        goto L71
    L74:
        double[] r28 = this.mInterpolateVelocity;
        ((KeyCycleOscillator.PathRotateSet) r27).setPathRotate(r18, r12, r28[0], r28[1]);
        goto L71
    L87:
        return false;
    L76:
        return false;
    L35:
        if (this.mTransformPivotView != null) goto L37;
        this.mTransformPivotView = r18.getParent().findViewById(this.mTransformPivotTarget);
    L37:
        MotionWidget r29 = this.mTransformPivotView;
        if (r29 == null) goto L44;
        float r30 = (r29.getTop() + this.mTransformPivotView.getBottom()) / 2.0f;
        float r31 = (this.mTransformPivotView.getLeft() + this.mTransformPivotView.getRight()) / 2.0f;
        if ((r18.getRight() - r18.getLeft()) <= 0) goto L44;
        if ((r18.getBottom() - r18.getTop()) <= 0) goto L44;
        float r32 = r31 - r18.getLeft();
        float r33 = r30 - r18.getTop();
        r18.setPivotX(r32);
        r18.setPivotY(r33);
        goto L44
    L66:
        MotionPaths r34 = this.mStartMotionPath;
        float r35 = r34.x;
        MotionPaths r36 = this.mEndMotionPath;
        float r37 = r35 + ((r36.x - r35) * r12);
        float r38 = r34.y;
        float r39 = r38 + ((r36.y - r38) * r12);
        float r40 = r34.width;
        float r41 = r40 + ((r36.width - r40) * r12);
        float r42 = r34.height;
        float r43 = r37 + 0.5f;
        float r44 = r39 + 0.5f;
        r18.layout((int) r43, (int) r44, (int) (r43 + r41), (int) (r44 + (r42 + ((r36.height - r42) * r12))));
        goto L67
    }

    String name() {
        return this.mView.getName();
    }

    void positionKeyframe(MotionWidget r9, MotionKeyPosition r10, float r11, float r12, String[] r13, float[] r14) {
        FloatRect r2 = new FloatRect();
        MotionPaths r0 = this.mStartMotionPath;
        float r1 = r0.x;
        r2.left = r1;
        float r3 = r0.y;
        r2.top = r3;
        r2.right = r1 + r0.width;
        r2.bottom = r3 + r0.height;
        FloatRect r4 = new FloatRect();
        MotionPaths r8 = this.mEndMotionPath;
        float r5 = r8.x;
        r4.left = r5;
        float r6 = r8.y;
        r4.top = r6;
        r4.right = r5 + r8.width;
        r4.bottom = r6 + r8.height;
        r10.positionAttributes(r9, r2, r4, r11, r12, r13, r14);
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

    void setBothStates(MotionWidget r6) {
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

    public void setEnd(MotionWidget r6) {
        MotionPaths r0 = this.mEndMotionPath;
        r0.time = 1.0f;
        r0.position = 1.0f;
        readView(r0);
        this.mEndMotionPath.setBounds(r6.getLeft(), r6.getTop(), r6.getWidth(), r6.getHeight());
        this.mEndMotionPath.applyParameters(r6);
        this.mEndPoint.setState(r6);
    }

    public void setPathMotionArc(int r1) {
        this.mPathMotionArc = r1;
    }

    public void setStart(MotionWidget r6) {
        MotionPaths r0 = this.mStartMotionPath;
        r0.time = 0.0f;
        r0.position = 0.0f;
        r0.setBounds(r6.getX(), r6.getY(), r6.getWidth(), r6.getHeight());
        this.mStartMotionPath.applyParameters(r6);
        this.mStartPoint.setState(r6);
    }

    public void setStartState(ViewState r5, MotionWidget r6, int r7, int r8, int r9) {
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

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r1, float r2) {
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r3, int r4) {
        if (r3 != 509) goto L5;
        setPathMotionArc(r4);
        return true;
    L5:
        if (r3 == 704) goto L8;
        return false;
    L8:
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r4, String r5) {
        if (705 != r4) goto L5;
        System.out.println("TYPE_INTERPOLATOR  " + r5);
        this.mQuantizeMotionInterpolator = getInterpolator(-1, r5, 0);
    L5:
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r1, boolean r2) {
        return false;
    }

    public void setView(MotionWidget r1) {
        this.mView = r1;
    }

    public void setup(int r21, int r22, float r23, long r24) {
        Class<double> r3 = double.class;
        new HashSet();
        HashSet<String> r4 = new HashSet();
        HashSet<String> r5 = new HashSet();
        HashSet<String> r6 = new HashSet();
        HashMap<String, Integer> r7 = new HashMap();
        int r8 = this.mPathMotionArc;
        if (r8 == (-1)) goto L5;
        this.mStartMotionPath.mPathMotionArc = r8;
    L5:
        this.mStartPoint.different(this.mEndPoint, r5);
        ArrayList<MotionKey> r9 = this.mKeyList;
        if (r9 == null) goto L27;
        Iterator<MotionKey> r10 = r9.iterator();
        ArrayList r11 = null;
    L9:
        if (r10.hasNext() == false) goto L29;
        MotionKey r12 = r10.next();
        if ((r12 instanceof MotionKeyPosition) == true) goto L12;
        if ((r12 instanceof MotionKeyCycle) == true) goto L17;
        if ((r12 instanceof MotionKeyTimeCycle) == true) goto L20;
        if ((r12 instanceof MotionKeyTrigger) == true) goto L23;
        r12.setInterpolation(r7);
        r12.getAttributeNames(r5);
        goto L9
    L23:
        if (r11 != null) goto L25;
        r11 = new ArrayList();
    L25:
        r11.add((MotionKeyTrigger) r12);
        goto L9
    L20:
        r12.getAttributeNames(r4);
        goto L9
    L17:
        r12.getAttributeNames(r6);
        goto L9
    L12:
        MotionKeyPosition r13 = (MotionKeyPosition) r12;
        insertKey(new MotionPaths(r21, r22, r13, this.mStartMotionPath, this.mEndMotionPath));
        int r14 = r13.mCurveFit;
        if (r14 == (-1)) goto L9;
        this.mCurveFitType = r14;
    L29:
        if (r11 == null) goto L31;
        this.mKeyTriggers = (MotionKeyTrigger[]) r11.toArray(new MotionKeyTrigger[0]);
    L31:
        char r15 = 1;
        if (r5.isEmpty() == true) goto L74;
        this.mAttributesMap = new HashMap();
        Iterator<String> r16 = r5.iterator();
    L35:
        if (r16.hasNext() == false) goto L53;
        String r17 = r16.next();
        if (r17.startsWith("CUSTOM,") == false) goto L48;
        KeyFrameArray.CustomVar r18 = new KeyFrameArray.CustomVar();
        String r19 = r17.split(",")[r15];
        Iterator<MotionKey> r110 = this.mKeyList.iterator();
    L40:
        if (r110.hasNext() == false) goto L47;
        MotionKey r20 = r110.next();
        Iterator<String> r111 = r16;
        HashMap<String, CustomVariable> r112 = r20.mCustom;
        if (r112 == null) goto L43;
        CustomVariable r113 = r112.get(r19);
        if (r113 == null) goto L43;
        r18.append(r20.mFramePosition, r113);
    L43:
        r16 = r111;
        goto L40
    L47:
        Iterator<String> r114 = r16;
        SplineSet r25 = SplineSet.makeCustomSplineSet(r17, r18);
    L49:
        if (r25 == null) goto L52;
        r25.setType(r17);
        this.mAttributesMap.put(r17, r25);
    L52:
        r16 = r114;
        r15 = 1;
        goto L35
    L48:
        r114 = r16;
        r25 = SplineSet.makeSpline(r17, r24);
        goto L49
    L53:
        ArrayList<MotionKey> r26 = this.mKeyList;
        if (r26 == null) goto L61;
        Iterator<MotionKey> r27 = r26.iterator();
    L57:
        if (r27.hasNext() == false) goto L61;
        MotionKey r28 = r27.next();
        if ((r28 instanceof MotionKeyAttributes) == false) goto L57;
        r28.addValues(this.mAttributesMap);
    L61:
        this.mStartPoint.addValues(this.mAttributesMap, 0);
        this.mEndPoint.addValues(this.mAttributesMap, 100);
        Iterator<String> r29 = this.mAttributesMap.keySet().iterator();
    L63:
        if (r29.hasNext() == false) goto L74;
        String r30 = r29.next();
        if (r7.containsKey(r30) == false) goto L69;
        Integer r115 = r7.get(r30);
        if (r115 == null) goto L69;
        int r116 = r115.intValue();
    L70:
        SplineSet r31 = this.mAttributesMap.get(r30);
        if (r31 == null) goto L63;
        r31.setup(r116);
    L69:
        r116 = 0;
    L74:
        if (r4.isEmpty() == false) goto L76;
    L116:
        int r2 = 2;
        int r1 = this.mMotionPaths.size() + 2;
        MotionPaths[] r32 = new MotionPaths[r1];
        r32[0] = this.mStartMotionPath;
        r32[r1 - 1] = this.mEndMotionPath;
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
        Iterator<String> r36 = this.mEndMotionPath.customAttributes.keySet().iterator();
    L127:
        if (r36.hasNext() == false) goto L133;
        String r117 = r36.next();
        if (this.mStartMotionPath.customAttributes.containsKey(r117) == false) goto L127;
        if (r5.contains("CUSTOM," + r117) == true) goto L127;
        r35.add(r117);
        goto L127
    L133:
        String[] r37 = (String[]) r35.toArray(new String[0]);
        this.mAttributeNames = r37;
        this.mAttributeInterpolatorCount = new int[r37.length];
        int r38 = 0;
    L134:
        String[] r39 = this.mAttributeNames;
        if (r38 >= r39.length) goto L146;
        String r40 = r39[r38];
        this.mAttributeInterpolatorCount[r38] = 0;
        int r41 = 0;
    L137:
        if (r41 >= r1) goto L144;
        if (r32[r41].customAttributes.containsKey(r40) == false) goto L143;
        CustomVariable r118 = r32[r41].customAttributes.get(r40);
        if (r118 == null) goto L143;
        int[] r42 = this.mAttributeInterpolatorCount;
        r42[r38] = r42[r38] + r118.numberOfInterpolatedValues();
    L143:
        r41 = r41 + 1;
    L144:
        r38 = r38 + 1;
        goto L134
    L146:
        if (r32[0].mPathMotionArc == (-1)) goto L148;
        boolean r43 = true;
    L149:
        int r44 = 18 + r39.length;
        boolean[] r45 = new boolean[r44];
        int r46 = 1;
    L150:
        if (r46 >= r1) goto L152;
        r32[r46].different(r32[r46 - 1], r45, this.mAttributeNames, r43);
        r46 = r46 + 1;
        goto L150
    L152:
        int r47 = 1;
        int r48 = 0;
    L153:
        if (r47 >= r44) goto L158;
        if (r45[r47] == false) goto L157;
        r48 = r48 + 1;
    L157:
        r47 = r47 + 1;
        goto L153
    L158:
        this.mInterpolateVariables = new int[r48];
        int r49 = Math.max(2, r48);
        this.mInterpolateData = new double[r49];
        this.mInterpolateVelocity = new double[r49];
        int r50 = 1;
        int r51 = 0;
    L159:
        if (r50 >= r44) goto L164;
        if (r45[r50] == false) goto L163;
        this.mInterpolateVariables[r51] = r50;
        r51 = r51 + 1;
    L163:
        r50 = r50 + 1;
        goto L159
    L164:
        double[][] r52 = (double[][]) Array.newInstance(r3, new int[]{r1, this.mInterpolateVariables.length});
        double[] r53 = new double[r1];
        int r54 = 0;
    L165:
        if (r54 >= r1) goto L167;
        r32[r54].fillStandard(r52[r54], this.mInterpolateVariables);
        r53[r54] = r32[r54].time;
        r54 = r54 + 1;
        goto L165
    L167:
        int r55 = 0;
    L168:
        int[] r56 = this.mInterpolateVariables;
        if (r55 >= r56.length) goto L176;
        if (r56[r55] >= MotionPaths.names.length) goto L175;
        String r119 = MotionPaths.names[this.mInterpolateVariables[r55]] + " [";
        int r57 = 0;
    L173:
        if (r57 >= r1) goto L175;
        r119 = r119 + r52[r57][r55];
        r57 = r57 + 1;
    L175:
        r55 = r55 + 1;
        goto L168
    L176:
        this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
        int r58 = 0;
    L177:
        String[] r59 = this.mAttributeNames;
        if (r58 >= r59.length) goto L190;
        String r60 = r59[r58];
        int r120 = 0;
        int r121 = 0;
        double[] r122 = null;
        double[][] r123 = null;
    L180:
        if (r120 >= r1) goto L189;
        if (r32[r120].hasCustomData(r60) == false) goto L188;
        if (r123 != null) goto L185;
        r122 = new double[r1];
        int[] r124 = new int[r2];
        r124[1] = r32[r120].getCustomDataCount(r60);
        int r125 = 0;
        r124[0] = r1;
        r123 = (double[][]) Array.newInstance(r3, r124);
    L186:
        r122[r121] = r32[r120].time;
        r32[r120].getCustomData(r60, r123[r121], r125);
        r121 = r121 + 1;
        goto L188
    L185:
        r125 = 0;
    L188:
        r120 = r120 + 1;
        r3 = r3;
        r2 = 2;
        goto L180
    L189:
        r58 = r58 + 1;
        this.mSpline[r58] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(r122, r121), (double[][]) Arrays.copyOf(r123, r121));
        r3 = r3;
        r2 = 2;
        goto L177
    L190:
        Class<double> r126 = r3;
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, r53, r52);
        if (r32[0].mPathMotionArc == (-1)) goto L196;
        int[] r61 = new int[r1];
        double[] r62 = new double[r1];
        double[][] r63 = (double[][]) Array.newInstance(r126, new int[]{r1, 2});
        int r127 = 0;
    L193:
        if (r127 >= r1) goto L195;
        r61[r127] = r32[r127].mPathMotionArc;
        r62[r127] = r32[r127].time;
        r63[r127][0] = r32[r127].x;
        r63[r127][1] = r32[r127].y;
        r127 = r127 + 1;
        goto L193
    L195:
        this.mArcSpline = CurveFit.getArc(r61, r62, r63);
    L196:
        float r64 = Float.NaN;
        this.mCycleMap = new HashMap();
        if (this.mKeyList == null) goto L220;
        Iterator<String> r65 = r6.iterator();
    L200:
        if (r65.hasNext() == false) goto L210;
        String r66 = r65.next();
        KeyCycleOscillator r67 = KeyCycleOscillator.makeWidgetCycle(r66);
        if (r67 == null) goto L200;
        if (r67.variesByPath() == true) goto L207;
    L209:
        r67.setType(r66);
        this.mCycleMap.put(r66, r67);
        goto L200
    L207:
        if (Float.isNaN(r64) == false) goto L209;
        r64 = getPreCycleDistance();
        goto L209
    L210:
        Iterator<MotionKey> r68 = this.mKeyList.iterator();
    L212:
        if (r68.hasNext() == false) goto L216;
        MotionKey r69 = r68.next();
        if ((r69 instanceof MotionKeyCycle) == false) goto L212;
        ((MotionKeyCycle) r69).addCycleValues(this.mCycleMap);
        goto L212
    L216:
        Iterator<KeyCycleOscillator> r0 = this.mCycleMap.values().iterator();
    L218:
        if (r0.hasNext() == false) goto L318;
        r0.next().setup(r64);
        goto L218
    L318:
        return;
    L220:
        return;
    L148:
        r43 = false;
        goto L149
    L119:
        if (this.mCurveFitType != MotionKey.UNSET) goto L121;
        this.mCurveFitType = 0;
        goto L121
    L76:
        if (this.mTimeCycleAttributesMap != null) goto L78;
        this.mTimeCycleAttributesMap = new HashMap();
    L78:
        Iterator<String> r70 = r4.iterator();
    L80:
        if (r70.hasNext() == false) goto L100;
        String r71 = r70.next();
        if (this.mTimeCycleAttributesMap.containsKey(r71) == true) goto L80;
        if (r71.startsWith("CUSTOM,") == false) goto L96;
        KeyFrameArray.CustomVar r72 = new KeyFrameArray.CustomVar();
        String r128 = r71.split(",")[1];
        Iterator<MotionKey> r129 = this.mKeyList.iterator();
    L88:
        if (r129.hasNext() == false) goto L95;
        MotionKey r130 = r129.next();
        HashMap<String, CustomVariable> r131 = r130.mCustom;
        if (r131 == null) goto L88;
        CustomVariable r132 = r131.get(r128);
        if (r132 == null) goto L88;
        r72.append(r130.mFramePosition, r132);
        goto L88
    L95:
        SplineSet r73 = SplineSet.makeCustomSplineSet(r71, r72);
    L97:
        if (r73 == null) goto L80;
        r73.setType(r71);
        goto L80
    L96:
        r73 = SplineSet.makeSpline(r71, r24);
        goto L97
    L100:
        ArrayList<MotionKey> r74 = this.mKeyList;
        if (r74 == null) goto L108;
        Iterator<MotionKey> r75 = r74.iterator();
    L104:
        if (r75.hasNext() == false) goto L108;
        MotionKey r76 = r75.next();
        if ((r76 instanceof MotionKeyTimeCycle) == false) goto L104;
        ((MotionKeyTimeCycle) r76).addTimeValues(this.mTimeCycleAttributesMap);
    L108:
        Iterator<String> r77 = this.mTimeCycleAttributesMap.keySet().iterator();
    L110:
        if (r77.hasNext() == false) goto L116;
        String r78 = r77.next();
        if (r7.containsKey(r78) == false) goto L114;
        int r79 = r7.get(r78).intValue();
    L115:
        this.mTimeCycleAttributesMap.get(r78).setup(r79);
        goto L110
    L114:
        r79 = 0;
        goto L115
    L27:
        r11 = null;
        goto L29
    }

    public void setupRelative(Motion r3) {
        this.mStartMotionPath.setupRelative(r3, r3.mStartMotionPath);
        this.mEndMotionPath.setupRelative(r3, r3.mEndMotionPath);
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.x + " y: " + this.mStartMotionPath.y + " end: x: " + this.mEndMotionPath.x + " y: " + this.mEndMotionPath.y;
    }
}
