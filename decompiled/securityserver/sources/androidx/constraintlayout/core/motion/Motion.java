package androidx.constraintlayout.core.motion;

import a.a;
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

    public void addKeys(ArrayList<MotionKey> r1) {
        this.mKeyList.addAll(r1);
    }

    public void buildBounds(float[] r18, int r19) {
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
        if (r5 != null) goto L17;
    L16:
        KeyCycleOscillator r14 = r3;
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

    public void endTrigger(boolean r1) {
    }

    public int getAnimateRelativeTo() {
        return this.mStartMotionPath.mAnimateRelativeTo;
    }

    public int getAttributeValues(String r1, float[] r2, int r3) {
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

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String r1) {
        return 0;
    }

    public MotionPaths getKeyFrame(int r1) {
        return this.mMotionPaths.get(r1);
    }

    public int getKeyFrameInfo(int r14, int[] r15) {
        float[] r0 = new float[2];
        Iterator<MotionKey> r8 = this.mKeyList.iterator();
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r8.hasNext() == false) goto L14;
        MotionKey r12 = r8.next();
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
        if ((r12 instanceof MotionKeyPosition) == false) goto L13;
        MotionKeyPosition r13 = (MotionKeyPosition) r12;
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

    public MotionKeyPosition getPositionKeyframe(int r11, int r12, float r13, float r14) {
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

    public void getPostLayoutDvDp(float r19, int r20, int r21, float r22, float r23, float[] r24) {
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
        if (r10 == null) goto L65;
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
        if (r17.mVisibilityMode != 0) goto L60;
        if (r12 > 0.0f) goto L54;
        r18.setVisibility(r17.visibility);
        goto L60
    L54:
        if (r12 < 1.0f) goto L57;
        r18.setVisibility(this.mEndPoint.visibility);
        goto L60
    L57:
        if (this.mEndPoint.visibility == r17.visibility) goto L60;
        r18.setVisibility(4);
    L60:
        if (this.mKeyTriggers == null) goto L66;
        int r21 = 0;
    L62:
        MotionKeyTrigger[] r23 = this.mKeyTriggers;
        if (r21 >= r23.length) goto L66;
        r23[r21].conditionallyFire(r12, r18);
        r21 = r21 + 1;
    L66:
        HashMap<String, KeyCycleOscillator> r24 = this.mCycleMap;
        if (r24 == null) goto L75;
        Iterator<KeyCycleOscillator> r25 = r24.values().iterator();
    L70:
        if (r25.hasNext() == false) goto L86;
        KeyCycleOscillator r26 = r25.next();
        if ((r26 instanceof KeyCycleOscillator.PathRotateSet) == true) goto L73;
        r26.setProperty(r18, r12);
        goto L70
    L73:
        double[] r27 = this.mInterpolateVelocity;
        ((KeyCycleOscillator.PathRotateSet) r26).setPathRotate(r18, r12, r27[0], r27[1]);
        goto L70
    L86:
        return false;
    L75:
        return false;
    L35:
        if (this.mTransformPivotView != null) goto L37;
        this.mTransformPivotView = r18.getParent().findViewById(this.mTransformPivotTarget);
    L37:
        MotionWidget r28 = this.mTransformPivotView;
        if (r28 == null) goto L44;
        float r29 = (this.mTransformPivotView.getBottom() + r28.getTop()) / 2.0f;
        float r30 = (this.mTransformPivotView.getRight() + this.mTransformPivotView.getLeft()) / 2.0f;
        if ((r18.getRight() - r18.getLeft()) <= 0) goto L44;
        if ((r18.getBottom() - r18.getTop()) <= 0) goto L44;
        float r31 = r30 - r18.getLeft();
        float r32 = r29 - r18.getTop();
        r18.setPivotX(r31);
        r18.setPivotY(r32);
        goto L44
    L65:
        MotionPaths r33 = this.mStartMotionPath;
        float r34 = r33.x;
        MotionPaths r35 = this.mEndMotionPath;
        float r36 = a.a(r35.x, r34, r12, r34);
        float r37 = r33.y;
        float r38 = a.a(r35.y, r37, r12, r37);
        float r39 = r33.width;
        float r40 = a.a(r35.width, r39, r12, r39);
        float r41 = r33.height;
        float r42 = r36 + 0.5f;
        float r43 = r38 + 0.5f;
        r18.layout((int) r42, (int) r43, (int) (r42 + r40), (int) (r43 + a.a(r35.height, r41, r12, r41)));
        goto L66
    }

    public String name() {
        return this.mView.getName();
    }

    public void positionKeyframe(MotionWidget r9, MotionKeyPosition r10, float r11, float r12, String[] r13, float[] r14) {
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

    public void setBothStates(MotionWidget r6) {
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

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r1, float r2) {
        return false;
    }

    public void setView(MotionWidget r1) {
        this.mView = r1;
    }

    public void setup(int r20, int r21, float r22, long r23) {
        new HashSet();
        HashSet<String> r3 = new HashSet();
        HashSet<String> r4 = new HashSet();
        HashSet<String> r5 = new HashSet();
        HashMap<String, Integer> r6 = new HashMap();
        int r7 = this.mPathMotionArc;
        if (r7 == (-1)) goto L5;
        this.mStartMotionPath.mPathMotionArc = r7;
    L5:
        this.mStartPoint.different(this.mEndPoint, r4);
        ArrayList<MotionKey> r8 = this.mKeyList;
        if (r8 == null) goto L27;
        Iterator<MotionKey> r9 = r8.iterator();
        ArrayList r10 = null;
    L9:
        if (r9.hasNext() == false) goto L29;
        MotionKey r11 = r9.next();
        if ((r11 instanceof MotionKeyPosition) == true) goto L12;
        if ((r11 instanceof MotionKeyCycle) == true) goto L17;
        if ((r11 instanceof MotionKeyTimeCycle) == true) goto L20;
        if ((r11 instanceof MotionKeyTrigger) == true) goto L23;
        r11.setInterpolation(r6);
        r11.getAttributeNames(r4);
        goto L9
    L23:
        if (r10 != null) goto L25;
        r10 = new ArrayList();
    L25:
        r10.add((MotionKeyTrigger) r11);
        goto L9
    L20:
        r11.getAttributeNames(r3);
        goto L9
    L17:
        r11.getAttributeNames(r5);
        goto L9
    L12:
        MotionKeyPosition r12 = (MotionKeyPosition) r11;
        insertKey(new MotionPaths(r20, r21, r12, this.mStartMotionPath, this.mEndMotionPath));
        int r13 = r12.mCurveFit;
        if (r13 == (-1)) goto L9;
        this.mCurveFitType = r13;
    L29:
        if (r10 == null) goto L31;
        this.mKeyTriggers = (MotionKeyTrigger[]) r10.toArray(new MotionKeyTrigger[0]);
    L31:
        char r14 = 1;
        if (r4.isEmpty() == true) goto L73;
        this.mAttributesMap = new HashMap();
        Iterator<String> r15 = r4.iterator();
    L35:
        if (r15.hasNext() == false) goto L52;
        String r16 = r15.next();
        if (r16.startsWith("CUSTOM,") == false) goto L48;
        KeyFrameArray.CustomVar r17 = new KeyFrameArray.CustomVar();
        String r18 = r16.split(",")[r14];
        Iterator<MotionKey> r19 = this.mKeyList.iterator();
    L40:
        if (r19.hasNext() == false) goto L47;
        MotionKey r110 = r19.next();
        HashMap<String, CustomVariable> r24 = r110.mCustom;
        if (r24 == null) goto L40;
        CustomVariable r25 = r24.get(r18);
        if (r25 == null) goto L40;
        r17.append(r110.mFramePosition, r25);
        goto L40
    L47:
        SplineSet r26 = SplineSet.makeCustomSplineSet(r16, r17);
    L49:
        if (r26 == null) goto L50;
        r26.setType(r16);
        this.mAttributesMap.put(r16, r26);
    L50:
        r14 = 1;
        goto L35
    L48:
        r26 = SplineSet.makeSpline(r16, r23);
        goto L49
    L52:
        ArrayList<MotionKey> r27 = this.mKeyList;
        if (r27 == null) goto L60;
        Iterator<MotionKey> r28 = r27.iterator();
    L56:
        if (r28.hasNext() == false) goto L60;
        MotionKey r29 = r28.next();
        if ((r29 instanceof MotionKeyAttributes) == false) goto L56;
        r29.addValues(this.mAttributesMap);
    L60:
        this.mStartPoint.addValues(this.mAttributesMap, 0);
        this.mEndPoint.addValues(this.mAttributesMap, 100);
        Iterator<String> r30 = this.mAttributesMap.keySet().iterator();
    L62:
        if (r30.hasNext() == false) goto L73;
        String r31 = r30.next();
        if (r6.containsKey(r31) == false) goto L68;
        Integer r32 = r6.get(r31);
        if (r32 == null) goto L68;
        int r33 = r32.intValue();
    L69:
        SplineSet r34 = this.mAttributesMap.get(r31);
        if (r34 == null) goto L62;
        r34.setup(r33);
    L68:
        r33 = 0;
    L73:
        if (r3.isEmpty() == false) goto L75;
    L115:
        int r1 = this.mMotionPaths.size();
        int r2 = r1 + 2;
        MotionPaths[] r35 = new MotionPaths[r2];
        r35[0] = this.mStartMotionPath;
        r35[r1 + 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0) goto L118;
    L120:
        Iterator<MotionPaths> r36 = this.mMotionPaths.iterator();
        int r37 = 1;
    L122:
        if (r36.hasNext() == false) goto L124;
        r35[r37] = r36.next();
        r37 = r37 + 1;
        goto L122
    L124:
        HashSet r38 = new HashSet();
        Iterator<String> r39 = this.mEndMotionPath.customAttributes.keySet().iterator();
    L126:
        if (r39.hasNext() == false) goto L132;
        String r40 = r39.next();
        if (this.mStartMotionPath.customAttributes.containsKey(r40) == false) goto L126;
        if (r4.contains("CUSTOM," + r40) == true) goto L126;
        r38.add(r40);
        goto L126
    L132:
        String[] r41 = (String[]) r38.toArray(new String[0]);
        this.mAttributeNames = r41;
        this.mAttributeInterpolatorCount = new int[r41.length];
        int r42 = 0;
    L133:
        String[] r43 = this.mAttributeNames;
        if (r42 >= r43.length) goto L145;
        String r44 = r43[r42];
        this.mAttributeInterpolatorCount[r42] = 0;
        int r45 = 0;
    L136:
        if (r45 >= r2) goto L143;
        if (r35[r45].customAttributes.containsKey(r44) == false) goto L142;
        CustomVariable r46 = r35[r45].customAttributes.get(r44);
        if (r46 == null) goto L142;
        int[] r47 = this.mAttributeInterpolatorCount;
        r47[r42] = r46.numberOfInterpolatedValues() + r47[r42];
    L142:
        r45 = r45 + 1;
    L143:
        r42 = r42 + 1;
        goto L133
    L145:
        if (r35[0].mPathMotionArc == (-1)) goto L147;
        boolean r48 = true;
    L148:
        int r49 = 18 + r43.length;
        boolean[] r50 = new boolean[r49];
        int r51 = 1;
    L149:
        if (r51 >= r2) goto L151;
        r35[r51].different(r35[r51 - 1], r50, this.mAttributeNames, r48);
        r51 = r51 + 1;
        goto L149
    L151:
        int r52 = 1;
        int r53 = 0;
    L152:
        if (r52 >= r49) goto L157;
        if (r50[r52] == false) goto L156;
        r53 = r53 + 1;
    L156:
        r52 = r52 + 1;
        goto L152
    L157:
        this.mInterpolateVariables = new int[r53];
        int r54 = 2;
        int r55 = Math.max(2, r53);
        this.mInterpolateData = new double[r55];
        this.mInterpolateVelocity = new double[r55];
        int r56 = 1;
        int r57 = 0;
    L158:
        if (r56 >= r49) goto L163;
        if (r50[r56] == false) goto L162;
        this.mInterpolateVariables[r57] = r56;
        r57 = r57 + 1;
    L162:
        r56 = r56 + 1;
        goto L158
    L163:
        double[][] r58 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r2, this.mInterpolateVariables.length});
        double[] r59 = new double[r2];
        int r60 = 0;
    L164:
        if (r60 >= r2) goto L166;
        r35[r60].fillStandard(r58[r60], this.mInterpolateVariables);
        r59[r60] = r35[r60].time;
        r60 = r60 + 1;
        goto L164
    L166:
        int r61 = 0;
    L167:
        int[] r62 = this.mInterpolateVariables;
        if (r61 >= r62.length) goto L175;
        if (r62[r61] >= MotionPaths.names.length) goto L174;
        String r63 = a.o(new StringBuilder(), MotionPaths.names[this.mInterpolateVariables[r61]], " [");
        int r64 = 0;
    L172:
        if (r64 >= r2) goto L174;
        StringBuilder r65 = a.q(r63);
        r65.append(r58[r64][r61]);
        r63 = r65.toString();
        r64 = r64 + 1;
    L174:
        r61 = r61 + 1;
        goto L167
    L175:
        this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
        int r66 = 0;
    L176:
        String[] r67 = this.mAttributeNames;
        if (r66 >= r67.length) goto L189;
        String r68 = r67[r66];
        int r69 = 0;
        int r111 = 0;
        double[] r112 = null;
        double[][] r113 = null;
    L179:
        if (r69 >= r2) goto L188;
        if (r35[r69].hasCustomData(r68) == false) goto L187;
        if (r113 != null) goto L184;
        r112 = new double[r2];
        int[] r114 = new int[r54];
        r114[1] = r35[r69].getCustomDataCount(r68);
        int r115 = 0;
        r114[0] = r2;
        r113 = (double[][]) Array.newInstance(Double.TYPE, r114);
    L185:
        MotionPaths r116 = r35[r69];
        r112[r111] = r116.time;
        r116.getCustomData(r68, r113[r111], r115);
        r111 = r111 + 1;
        goto L187
    L184:
        r115 = 0;
    L187:
        r69 = r69 + 1;
        r2 = r2;
        r54 = 2;
        goto L179
    L188:
        r66 = r66 + 1;
        this.mSpline[r66] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(r112, r111), (double[][]) Arrays.copyOf(r113, r111));
        r2 = r2;
        r54 = 2;
        goto L176
    L189:
        int r210 = r2;
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, r59, r58);
        if (r35[0].mPathMotionArc == (-1)) goto L195;
        int[] r70 = new int[r210];
        double[] r71 = new double[r210];
        double[][] r72 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r210, 2});
        int r73 = 0;
    L192:
        if (r73 >= r210) goto L194;
        MotionPaths r74 = r35[r73];
        r70[r73] = r74.mPathMotionArc;
        r71[r73] = r74.time;
        double[] r75 = r72[r73];
        r75[0] = r74.x;
        r75[1] = r74.y;
        r73 = r73 + 1;
        goto L192
    L194:
        this.mArcSpline = CurveFit.getArc(r70, r71, r72);
    L195:
        this.mCycleMap = new HashMap();
        if (this.mKeyList == null) goto L219;
        Iterator<String> r76 = r5.iterator();
        float r77 = Float.NaN;
    L199:
        if (r76.hasNext() == false) goto L209;
        String r78 = r76.next();
        KeyCycleOscillator r79 = KeyCycleOscillator.makeWidgetCycle(r78);
        if (r79 == null) goto L199;
        if (r79.variesByPath() == true) goto L206;
    L208:
        r79.setType(r78);
        this.mCycleMap.put(r78, r79);
        goto L199
    L206:
        if (Float.isNaN(r77) == false) goto L208;
        r77 = getPreCycleDistance();
        goto L208
    L209:
        Iterator<MotionKey> r80 = this.mKeyList.iterator();
    L211:
        if (r80.hasNext() == false) goto L215;
        MotionKey r81 = r80.next();
        if ((r81 instanceof MotionKeyCycle) == false) goto L211;
        ((MotionKeyCycle) r81).addCycleValues(this.mCycleMap);
        goto L211
    L215:
        Iterator<KeyCycleOscillator> r0 = this.mCycleMap.values().iterator();
    L217:
        if (r0.hasNext() == false) goto L317;
        r0.next().setup(r77);
        goto L217
    L317:
        return;
    L219:
        return;
    L147:
        r48 = false;
        goto L148
    L118:
        if (this.mCurveFitType != MotionKey.UNSET) goto L120;
        this.mCurveFitType = 0;
        goto L120
    L75:
        if (this.mTimeCycleAttributesMap != null) goto L77;
        this.mTimeCycleAttributesMap = new HashMap();
    L77:
        Iterator<String> r82 = r3.iterator();
    L79:
        if (r82.hasNext() == false) goto L99;
        String r83 = r82.next();
        if (this.mTimeCycleAttributesMap.containsKey(r83) == true) goto L79;
        if (r83.startsWith("CUSTOM,") == false) goto L95;
        KeyFrameArray.CustomVar r84 = new KeyFrameArray.CustomVar();
        String r85 = r83.split(",")[1];
        Iterator<MotionKey> r117 = this.mKeyList.iterator();
    L87:
        if (r117.hasNext() == false) goto L94;
        MotionKey r118 = r117.next();
        HashMap<String, CustomVariable> r119 = r118.mCustom;
        if (r119 == null) goto L87;
        CustomVariable r120 = r119.get(r85);
        if (r120 == null) goto L87;
        r84.append(r118.mFramePosition, r120);
        goto L87
    L94:
        SplineSet r86 = SplineSet.makeCustomSplineSet(r83, r84);
    L96:
        if (r86 == null) goto L79;
        r86.setType(r83);
        goto L79
    L95:
        r86 = SplineSet.makeSpline(r83, r23);
        goto L96
    L99:
        ArrayList<MotionKey> r87 = this.mKeyList;
        if (r87 == null) goto L107;
        Iterator<MotionKey> r88 = r87.iterator();
    L103:
        if (r88.hasNext() == false) goto L107;
        MotionKey r89 = r88.next();
        if ((r89 instanceof MotionKeyTimeCycle) == false) goto L103;
        ((MotionKeyTimeCycle) r89).addTimeValues(this.mTimeCycleAttributesMap);
    L107:
        Iterator<String> r90 = this.mTimeCycleAttributesMap.keySet().iterator();
    L109:
        if (r90.hasNext() == false) goto L115;
        String r91 = r90.next();
        if (r6.containsKey(r91) == false) goto L113;
        int r92 = r6.get(r91).intValue();
    L114:
        this.mTimeCycleAttributesMap.get(r91).setup(r92);
        goto L109
    L113:
        r92 = 0;
        goto L114
    L27:
        r10 = null;
        goto L29
    }

    public void setupRelative(Motion r3) {
        this.mStartMotionPath.setupRelative(r3, r3.mStartMotionPath);
        this.mEndMotionPath.setupRelative(r3, r3.mEndMotionPath);
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.x + " y: " + this.mStartMotionPath.y + " end: x: " + this.mEndMotionPath.x + " y: " + this.mEndMotionPath.y;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r1, boolean r2) {
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
}
