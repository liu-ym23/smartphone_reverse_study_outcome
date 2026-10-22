package com.obric.oui.constraintlayout.core.state;

import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm.trace.fps.RealFpsTracer;
import com.obric.oui.constraintlayout.core.motion.CustomVariable;
import com.obric.oui.constraintlayout.core.motion.Motion;
import com.obric.oui.constraintlayout.core.motion.MotionWidget;
import com.obric.oui.constraintlayout.core.motion.key.MotionKeyAttributes;
import com.obric.oui.constraintlayout.core.motion.key.MotionKeyCycle;
import com.obric.oui.constraintlayout.core.motion.key.MotionKeyPosition;
import com.obric.oui.constraintlayout.core.motion.utils.Easing;
import com.obric.oui.constraintlayout.core.motion.utils.KeyCache;
import com.obric.oui.constraintlayout.core.motion.utils.SpringStopEngine;
import com.obric.oui.constraintlayout.core.motion.utils.StopEngine;
import com.obric.oui.constraintlayout.core.motion.utils.StopLogicEngine;
import com.obric.oui.constraintlayout.core.motion.utils.TypedBundle;
import com.obric.oui.constraintlayout.core.motion.utils.TypedValues;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class Transition implements TypedValues {
    static final int ANTICIPATE = 6;
    static final int BOUNCE = 4;
    private static final boolean DEBUG = false;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    public static final int END = 1;
    public static final int INTERPOLATED = 2;
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    static final int LINEAR = 3;
    static final int OVERSHOOT = 5;
    private static final int SPLINE_STRING = -1;
    public static final int START = 0;
    private int mAutoTransition;
    private TypedBundle mBundle;
    private int mDefaultInterpolator;
    private String mDefaultInterpolatorString;
    private int mDuration;
    private Easing mEasing;
    private HashMap<Integer, HashMap<String, KeyPosition>> mKeyPositions;
    private OnSwipe mOnSwipe;
    int mParentEndHeight;
    int mParentEndWidth;
    int mParentInterpolateHeight;
    int mParentInterpolatedWidth;
    int mParentStartHeight;
    int mParentStartWidth;
    private float mStagger;
    private HashMap<String, WidgetState> mState;
    final CorePixelDp mToPixel;
    boolean mWrap;

    static class KeyPosition {
        int mFrame;
        String mTarget;
        int mType;
        float mX;
        float mY;

        KeyPosition(String r1, int r2, int r3, float r4, float r5) {
            this.mTarget = r1;
            this.mFrame = r2;
            this.mType = r3;
            this.mX = r4;
            this.mY = r5;
        }
    }

    static class OnSwipe {
        public static final int ANCHOR_SIDE_BOTTOM = 3;
        public static final int ANCHOR_SIDE_END = 6;
        public static final int ANCHOR_SIDE_LEFT = 1;
        public static final int ANCHOR_SIDE_MIDDLE = 4;
        public static final int ANCHOR_SIDE_RIGHT = 2;
        public static final int ANCHOR_SIDE_START = 5;
        public static final int ANCHOR_SIDE_TOP = 0;
        public static final String[] BOUNDARY = null;
        public static final int BOUNDARY_BOUNCE_BOTH = 3;
        public static final int BOUNDARY_BOUNCE_END = 2;
        public static final int BOUNDARY_BOUNCE_START = 1;
        public static final int BOUNDARY_OVERSHOOT = 0;
        public static final String[] DIRECTIONS = null;
        public static final int DRAG_ANTICLOCKWISE = 7;
        public static final int DRAG_CLOCKWISE = 6;
        public static final int DRAG_DOWN = 1;
        public static final int DRAG_END = 5;
        public static final int DRAG_LEFT = 2;
        public static final int DRAG_RIGHT = 3;
        public static final int DRAG_START = 4;
        public static final int DRAG_UP = 0;
        public static final String[] MODE = null;
        public static final int MODE_CONTINUOUS_VELOCITY = 0;
        public static final int MODE_SPRING = 1;
        public static final int ON_UP_AUTOCOMPLETE = 0;
        public static final int ON_UP_AUTOCOMPLETE_TO_END = 2;
        public static final int ON_UP_AUTOCOMPLETE_TO_START = 1;
        public static final int ON_UP_DECELERATE = 4;
        public static final int ON_UP_DECELERATE_AND_COMPLETE = 5;
        public static final int ON_UP_NEVER_COMPLETE_TO_END = 7;
        public static final int ON_UP_NEVER_COMPLETE_TO_START = 6;
        public static final int ON_UP_STOP = 3;
        public static final String[] SIDES = null;
        private static final float[][] TOUCH_DIRECTION = null;
        private static final float[][] TOUCH_SIDES = null;
        public static final String[] TOUCH_UP = null;
        String mAnchorId;
        private int mAnchorSide;
        private int mAutoCompleteMode;
        private float mDestination;
        private int mDragDirection;
        private float mDragScale;
        private float mDragThreshold;
        private boolean mDragVertical;
        private StopEngine mEngine;
        String mLimitBoundsTo;
        private float mMaxAcceleration;
        private float mMaxVelocity;
        private int mOnTouchUp;
        private String mRotationCenterId;
        private int mSpringBoundary;
        private float mSpringDamping;
        private float mSpringMass;
        private float mSpringStiffness;
        private float mSpringStopThreshold;
        private long mStart;

        OnSwipe() {
            this.mDragVertical = true;
            this.mDragDirection = 0;
            this.mDragScale = 1.0f;
            this.mDragThreshold = 10.0f;
            this.mAutoCompleteMode = 0;
            this.mMaxVelocity = 4.0f;
            this.mMaxAcceleration = 1.2f;
            this.mOnTouchUp = 0;
            this.mSpringMass = 1.0f;
            this.mSpringStiffness = 400.0f;
            this.mSpringDamping = 10.0f;
            this.mSpringStopThreshold = 0.01f;
            this.mDestination = 0.0f;
            this.mSpringBoundary = 0;
        }

        static {
            SIDES = new String[]{"top", "left", "right", "bottom", "middle", "start", TraceStatsConsts.STATS_KEY_END};
            TOUCH_SIDES = new float[][]{new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
            DIRECTIONS = new String[]{"up", "down", "left", "right", "start", TraceStatsConsts.STATS_KEY_END, "clockwise", "anticlockwise"};
            MODE = new String[]{RealFpsTracer.SCROLL_VELOCITY, "spring"};
            TOUCH_UP = new String[]{"autocomplete", "toStart", "toEnd", "stop", "decelerate", "decelerateComplete", "neverCompleteStart", "neverCompleteEnd"};
            BOUNDARY = new String[]{"overshoot", "bounceStart", "bounceEnd", "bounceBoth"};
            TOUCH_DIRECTION = new float[][]{new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
        }

        float getScale() {
            return this.mDragScale;
        }

        float[] getDirection() {
            return TOUCH_DIRECTION[this.mDragDirection];
        }

        float[] getSide() {
            return TOUCH_SIDES[this.mAnchorSide];
        }

        void setAnchorId(String r1) {
            this.mAnchorId = r1;
        }

        void setAnchorSide(int r1) {
            this.mAnchorSide = r1;
        }

        void setRotationCenterId(String r1) {
            this.mRotationCenterId = r1;
        }

        void setLimitBoundsTo(String r1) {
            this.mLimitBoundsTo = r1;
        }

        void setDragDirection(int r2) {
            this.mDragDirection = r2;
            if (r2 >= 2) goto L5;
            boolean r3 = true;
        L6:
            this.mDragVertical = r3;
            return;
        L5:
            r3 = false;
            goto L6
        }

        void setDragScale(float r2) {
            if (Float.isNaN(r2) == false) goto L5;
            return;
        L5:
            this.mDragScale = r2;
        }

        void setDragThreshold(float r2) {
            if (Float.isNaN(r2) == false) goto L5;
            return;
        L5:
            this.mDragThreshold = r2;
        }

        void setAutoCompleteMode(int r1) {
            this.mAutoCompleteMode = r1;
        }

        void setMaxVelocity(float r2) {
            if (Float.isNaN(r2) == false) goto L5;
            return;
        L5:
            this.mMaxVelocity = r2;
        }

        void setMaxAcceleration(float r2) {
            if (Float.isNaN(r2) == false) goto L5;
            return;
        L5:
            this.mMaxAcceleration = r2;
        }

        void setOnTouchUp(int r1) {
            this.mOnTouchUp = r1;
        }

        void setSpringMass(float r2) {
            if (Float.isNaN(r2) == false) goto L5;
            return;
        L5:
            this.mSpringMass = r2;
        }

        void setSpringStiffness(float r2) {
            if (Float.isNaN(r2) == false) goto L5;
            return;
        L5:
            this.mSpringStiffness = r2;
        }

        void setSpringDamping(float r2) {
            if (Float.isNaN(r2) == false) goto L5;
            return;
        L5:
            this.mSpringDamping = r2;
        }

        void setSpringStopThreshold(float r2) {
            if (Float.isNaN(r2) == false) goto L5;
            return;
        L5:
            this.mSpringStopThreshold = r2;
        }

        void setSpringBoundary(int r1) {
            this.mSpringBoundary = r1;
        }

        float getDestinationPosition(float r5, float r6, float r7) {
            float r8 = (((Math.abs(r6) * 0.5f) * r6) / this.mMaxAcceleration) + r5;
            switch(this.mOnTouchUp) {
                case 1: goto L27;
                case 2: goto L23;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L10;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L5;
            };
        L7:
            return 0.0f;
        L8:
            return 1.0f;
        L20:
            return Float.NaN;
        L5:
            if (r8 > 0.5d) goto L31;
            return 0.0f;
        L31:
            return 1.0f;
        L10:
            if (r8 <= 0.2f) goto L15;
            if (r8 >= 0.8f) goto L15;
            return r8;
        L15:
            if (r8 > 0.5f) goto L17;
            return 0.0f;
        L17:
            return 1.0f;
        L19:
            return Math.max(0.0f, Math.min(1.0f, r8));
        L23:
            if (r5 > 0.0f) goto L25;
            return 0.0f;
        L25:
            return 1.0f;
        L27:
            if (r5 < 1.0f) goto L32;
            return 1.0f;
        L32:
            return 0.0f;
        }

        void config(float r10, float r11, long r12, float r14) {
            this.mStart = r12;
            float r13 = Math.abs(r11);
            float r15 = this.mMaxVelocity;
            if (r13 <= r15) goto L5;
            r11 = Math.signum(r11) * r15;
        L5:
            float r3 = r11;
            float r16 = getDestinationPosition(r10, r3, r14);
            this.mDestination = r16;
            if (r16 != r10) goto L10;
            this.mEngine = null;
            return;
        L10:
            if (this.mOnTouchUp != 4) goto L20;
            if (this.mAutoCompleteMode != 0) goto L20;
            StopEngine r17 = this.mEngine;
            if ((r17 instanceof StopLogicEngine.Decelerate) == false) goto L16;
            StopLogicEngine.Decelerate r18 = (StopLogicEngine.Decelerate) r17;
        L17:
            r18.config(r10, this.mDestination, r3);
            return;
        L16:
            r18 = new StopLogicEngine.Decelerate();
            this.mEngine = r18;
        L20:
            if (this.mAutoCompleteMode != 0) goto L27;
            StopEngine r19 = this.mEngine;
            if ((r19 instanceof StopLogicEngine) == false) goto L24;
            StopLogicEngine r110 = (StopLogicEngine) r19;
        L25:
            r110.config(r10, this.mDestination, r3, r14, this.mMaxAcceleration, this.mMaxVelocity);
            return;
        L24:
            r110 = new StopLogicEngine();
            this.mEngine = r110;
            goto L25
        L27:
            StopEngine r111 = this.mEngine;
            if ((r111 instanceof SpringStopEngine) == false) goto L30;
            SpringStopEngine r112 = (SpringStopEngine) r111;
        L31:
            r112.springConfig(r10, this.mDestination, r3, this.mSpringMass, this.mSpringStiffness, this.mSpringDamping, this.mSpringStopThreshold, this.mSpringBoundary);
            return;
        L30:
            r112 = new SpringStopEngine();
            this.mEngine = r112;
            goto L31
        }

        public float getTouchUpProgress(long r3) {
            float r4 = this.mEngine.getInterpolation((r3 - this.mStart) * 1.0E-9f);
            if (this.mEngine.isStopped() == true) goto L5;
            return r4;
        L5:
            return this.mDestination;
        }

        public void printInfo() {
            if (this.mAutoCompleteMode != 0) goto L5;
            System.out.println("velocity = " + this.mEngine.getVelocity());
            System.out.println("mMaxAcceleration = " + this.mMaxAcceleration);
            System.out.println("mMaxVelocity = " + this.mMaxVelocity);
            return;
        L5:
            System.out.println("mSpringMass          = " + this.mSpringMass);
            System.out.println("mSpringStiffness     = " + this.mSpringStiffness);
            System.out.println("mSpringDamping       = " + this.mSpringDamping);
            System.out.println("mSpringStopThreshold = " + this.mSpringStopThreshold);
            System.out.println("mSpringBoundary      = " + this.mSpringBoundary);
        }

        public boolean isNotDone(float r3) {
            if (this.mOnTouchUp != 3) goto L5;
            return false;
        L5:
            StopEngine r2 = this.mEngine;
            if (r2 != null) goto L8;
            return false;
        L8:
            if (r2.isStopped() == true) goto L12;
            return true;
        L12:
            return false;
        }
    }

    public static class WidgetState {
        WidgetFrame mEnd;
        WidgetFrame mInterpolated;
        KeyCache mKeyCache;
        Motion mMotionControl;
        MotionWidget mMotionWidgetEnd;
        MotionWidget mMotionWidgetInterpolated;
        MotionWidget mMotionWidgetStart;
        boolean mNeedSetup;
        int mParentHeight;
        int mParentWidth;
        WidgetFrame mStart;

        public WidgetState() {
            this.mNeedSetup = true;
            this.mKeyCache = new KeyCache();
            this.mParentHeight = -1;
            this.mParentWidth = -1;
            this.mStart = new WidgetFrame();
            this.mEnd = new WidgetFrame();
            this.mInterpolated = new WidgetFrame();
            this.mMotionWidgetStart = new MotionWidget(this.mStart);
            this.mMotionWidgetEnd = new MotionWidget(this.mEnd);
            this.mMotionWidgetInterpolated = new MotionWidget(this.mInterpolated);
            Motion r0 = new Motion(this.mMotionWidgetStart);
            this.mMotionControl = r0;
            r0.setStart(this.mMotionWidgetStart);
            this.mMotionControl.setEnd(this.mMotionWidgetEnd);
        }

        public void setKeyPosition(TypedBundle r2) {
            MotionKeyPosition r0 = new MotionKeyPosition();
            r2.applyDelta(r0);
            this.mMotionControl.addKey(r0);
        }

        public void setKeyAttribute(TypedBundle r2) {
            MotionKeyAttributes r0 = new MotionKeyAttributes();
            r2.applyDelta(r0);
            this.mMotionControl.addKey(r0);
        }

        public void setKeyAttribute(TypedBundle r5, CustomVariable[] r6) {
            MotionKeyAttributes r0 = new MotionKeyAttributes();
            r5.applyDelta(r0);
            if (r6 == null) goto L8;
            int r7 = 0;
        L6:
            if (r7 >= r6.length) goto L8;
            r0.mCustom.put(r6[r7].getName(), r6[r7]);
            r7 = r7 + 1;
        L8:
            this.mMotionControl.addKey(r0);
        }

        public void setKeyCycle(TypedBundle r2) {
            MotionKeyCycle r0 = new MotionKeyCycle();
            r2.applyDelta(r0);
            this.mMotionControl.addKey(r0);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void update(ConstraintWidget r2, int r3) {
            if (r3 != 0) goto L5;
            this.mStart.update(r2);
            MotionWidget r4 = this.mMotionWidgetStart;
            r4.updateMotion(r4);
            this.mMotionControl.setStart(this.mMotionWidgetStart);
            this.mNeedSetup = true;
        L7:
            this.mParentWidth = -1;
            return;
        L5:
            if (r3 != 1) goto L7;
            this.mEnd.update(r2);
            this.mMotionControl.setEnd(this.mMotionWidgetEnd);
            this.mNeedSetup = true;
            goto L7
        }

        String getPathRelativeId() {
            return this.mMotionControl.getAnimateRelativeTo();
        }

        public WidgetFrame getFrame(int r2) {
            if (r2 != 0) goto L6;
            return this.mStart;
        L6:
            if (r2 != 1) goto L10;
            return this.mEnd;
        L10:
            return this.mInterpolated;
        }

        public void interpolate(int r9, int r10, float r11, Transition r12) {
            this.mParentHeight = r10;
            this.mParentWidth = r9;
            if (this.mNeedSetup == false) goto L5;
            this.mMotionControl.setup(r9, r10, 1.0f, System.nanoTime());
            this.mNeedSetup = false;
        L5:
            WidgetFrame.interpolate(r9, r10, this.mInterpolated, this.mStart, this.mEnd, r12, r11);
            this.mInterpolated.interpolatedPos = r11;
            this.mMotionControl.interpolate(this.mMotionWidgetInterpolated, r11, System.nanoTime(), this.mKeyCache);
        }

        public void setPathRelative(WidgetState r1) {
            this.mMotionControl.setupRelative(r1.mMotionControl);
        }
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.TypedValues
    public int getId(String r1) {
        return 0;
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r1, int r2) {
        return false;
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r1, boolean r2) {
        return false;
    }

    public Transition(CorePixelDp r3) {
        this.mKeyPositions = new HashMap();
        this.mState = new HashMap();
        this.mBundle = new TypedBundle();
        this.mDefaultInterpolator = 0;
        this.mDefaultInterpolatorString = null;
        this.mEasing = null;
        this.mAutoTransition = 0;
        this.mDuration = 400;
        this.mStagger = 0.0f;
        this.mOnSwipe = null;
        this.mToPixel = r3;
    }

    OnSwipe createOnSwipe() {
        OnSwipe r0 = new OnSwipe();
        this.mOnSwipe = r0;
        return r0;
    }

    public boolean hasOnSwipe() {
        if (this.mOnSwipe == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isFirstDownAccepted(float r4, float r5) {
        OnSwipe r0 = this.mOnSwipe;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.mLimitBoundsTo == null) goto L21;
        WidgetState r3 = this.mState.get(this.mOnSwipe.mLimitBoundsTo);
        if (r3 != null) goto L11;
        System.err.println("mLimitBoundsTo target is null");
        return false;
    L11:
        WidgetFrame r6 = r3.getFrame(2);
        if (r4 >= r6.left) goto L14;
        return false;
    L14:
        if (r4 < r6.right) goto L16;
        return false;
    L16:
        if (r5 >= r6.top) goto L18;
        return false;
    L18:
        if (r5 < r6.bottom) goto L20;
        return false;
    L20:
        return true;
    L21:
        return true;
    }

    public float dragToProgress(float r8, int r9, int r10, float r11, float r12) {
        Iterator<WidgetState> r0 = this.mState.values().iterator();
        if (r0.hasNext() == false) goto L5;
        WidgetState r1 = r0.next();
    L6:
        OnSwipe r2 = this.mOnSwipe;
        if (r2 == null) goto L24;
        if (r1 == null) goto L24;
        if (r2.mAnchorId != null) goto L19;
        float[] r13 = this.mOnSwipe.getDirection();
        float r14 = r1.mParentHeight;
        float r15 = r1.mParentHeight;
        float r3 = r13[0];
        if (r3 == 0.0f) goto L15;
        float r16 = (r11 * Math.abs(r3)) / r14;
    L16:
        float r7 = this.mOnSwipe.getScale();
    L18:
        return r16 * r7;
    L15:
        r16 = (r12 * Math.abs(r13[1])) / r15;
        goto L16
    L19:
        WidgetState r4 = this.mState.get(this.mOnSwipe.mAnchorId);
        float[] r5 = this.mOnSwipe.getDirection();
        float[] r6 = this.mOnSwipe.getSide();
        float[] r17 = new float[2];
        r4.interpolate(r9, r10, r8, this);
        r4.mMotionControl.getDpDt(r8, r6[0], r6[1], r17);
        float r18 = r5[0];
        if (r18 == 0.0f) goto L22;
        r16 = (r11 * Math.abs(r18)) / r17[0];
    L23:
        r7 = this.mOnSwipe.getScale();
        goto L18
    L22:
        r16 = (r12 * Math.abs(r5[1])) / r17[1];
    L24:
        if (r1 != null) goto L26;
        return 1.0f;
    L26:
        return (-r12) / r1.mParentHeight;
    L5:
        r1 = null;
        goto L6
    }

    public void setTouchUp(float r15, long r16, float r18, float r19) {
        OnSwipe r1 = this.mOnSwipe;
        if (r1 == null) goto L13;
        WidgetState r2 = this.mState.get(r1.mAnchorId);
        float[] r3 = new float[2];
        float[] r4 = this.mOnSwipe.getDirection();
        float[] r5 = this.mOnSwipe.getSide();
        r2.mMotionControl.getDpDt(r15, r5[0], r5[1], r3);
        if (Math.abs((r4[0] * r3[0]) + (r4[1] * r3[1])) >= 0.01d) goto L8;
        r3[0] = 0.01f;
        r3[1] = 0.01f;
    L8:
        if (r4[0] == 0.0f) goto L10;
        float r6 = r18 / r3[0];
    L11:
        this.mOnSwipe.config(r15, r6 * this.mOnSwipe.getScale(), r16, this.mDuration * 0.001f);
        return;
    L10:
        r6 = r19 / r3[1];
        goto L11
    }

    public float getTouchUpProgress(long r1) {
        OnSwipe r0 = this.mOnSwipe;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        return r0.getTouchUpProgress(r1);
    }

    public boolean isTouchNotDone(float r1) {
        return this.mOnSwipe.isNotDone(r1);
    }

    static /* synthetic */ float lambda$getInterpolator$0(String r2, float r3) {
        return (float) Easing.getInterpolator(r2).get(r3);
    }

    static /* synthetic */ float lambda$getInterpolator$1(float r3) {
        return (float) Easing.getInterpolator("standard").get(r3);
    }

    static /* synthetic */ float lambda$getInterpolator$2(float r3) {
        return (float) Easing.getInterpolator("accelerate").get(r3);
    }

    static /* synthetic */ float lambda$getInterpolator$3(float r3) {
        return (float) Easing.getInterpolator("decelerate").get(r3);
    }

    static /* synthetic */ float lambda$getInterpolator$4(float r3) {
        return (float) Easing.getInterpolator("linear").get(r3);
    }

    public static Interpolator getInterpolator(int r0, final String r1) {
        switch(r0) {
            case -1: goto L20;
            case 0: goto L18;
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return new Transition$$ExternalSyntheticLambda5();
    L8:
        return new Transition$$ExternalSyntheticLambda6();
    L10:
        return new Transition$$ExternalSyntheticLambda7();
    L12:
        return new Transition$$ExternalSyntheticLambda4();
    L14:
        return new Transition$$ExternalSyntheticLambda3();
    L16:
        return new Transition$$ExternalSyntheticLambda2();
    L18:
        return new Transition$$ExternalSyntheticLambda1();
    L20:
        return new Transition$$ExternalSyntheticLambda0(r1);
    }

    static /* synthetic */ float lambda$getInterpolator$5(float r3) {
        return (float) Easing.getInterpolator("anticipate").get(r3);
    }

    static /* synthetic */ float lambda$getInterpolator$6(float r3) {
        return (float) Easing.getInterpolator("overshoot").get(r3);
    }

    static /* synthetic */ float lambda$getInterpolator$7(float r3) {
        return (float) Easing.getInterpolator("spline(0.0, 0.2, 0.4, 0.6, 0.8 ,1.0, 0.8, 1.0, 0.9, 1.0)").get(r3);
    }

    public KeyPosition findPreviousPosition(String r3, int r4) {
    L2:
        if (r4 < 0) goto L9;
        HashMap<String, KeyPosition> r0 = this.mKeyPositions.get(Integer.valueOf(r4));
        if (r0 == null) goto L8;
        KeyPosition r1 = r0.get(r3);
        if (r1 == null) goto L8;
        return r1;
    L8:
        r4 = r4 - 1;
        goto L2
    L9:
        return null;
    }

    public KeyPosition findNextPosition(String r3, int r4) {
    L3:
        if (r4 > 100) goto L10;
        HashMap<String, KeyPosition> r0 = this.mKeyPositions.get(Integer.valueOf(r4));
        if (r0 == null) goto L9;
        KeyPosition r1 = r0.get(r3);
        if (r1 == null) goto L9;
        return r1;
    L9:
        r4 = r4 + 1;
        goto L3
    L10:
        return null;
    }

    public int getNumberKeyPositions(WidgetFrame r5) {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 > 100) goto L11;
        HashMap<String, KeyPosition> r2 = this.mKeyPositions.get(Integer.valueOf(r0));
        if (r2 == null) goto L10;
        if (r2.get(r5.widget.stringId) == null) goto L10;
        r1 = r1 + 1;
    L10:
        r0 = r0 + 1;
        goto L4
    L11:
        return r1;
    }

    public Motion getMotion(String r3) {
        return getWidgetState(r3, null, 0).mMotionControl;
    }

    public void fillKeyPositions(WidgetFrame r5, float[] r6, float[] r7, float[] r8) {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 > 100) goto L11;
        HashMap<String, KeyPosition> r2 = this.mKeyPositions.get(Integer.valueOf(r0));
        if (r2 == null) goto L10;
        KeyPosition r3 = r2.get(r5.widget.stringId);
        if (r3 == null) goto L10;
        r6[r1] = r3.mX;
        r7[r1] = r3.mY;
        r8[r1] = r3.mFrame;
        r1 = r1 + 1;
    L10:
        r0 = r0 + 1;
        goto L4
    }

    public boolean hasPositionKeyframes() {
        if (this.mKeyPositions.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void setTransitionProperties(TypedBundle r2) {
        r2.applyDelta(this.mBundle);
        r2.applyDelta(this);
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r2, float r3) {
        if (r2 != 706) goto L7;
        this.mStagger = r3;
        return false;
    L7:
        return false;
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r2, String r3) {
        if (r2 != 705) goto L7;
        this.mDefaultInterpolatorString = r3;
        this.mEasing = Easing.getInterpolator(r3);
        return false;
    L7:
        return false;
    }

    public boolean isEmpty() {
        return this.mState.isEmpty();
    }

    public void clear() {
        this.mState.clear();
    }

    void resetProperties() {
        this.mOnSwipe = null;
        this.mBundle.clear();
    }

    public boolean contains(String r1) {
        return this.mState.containsKey(r1);
    }

    public void addKeyPosition(String r3, TypedBundle r4) {
        getWidgetState(r3, null, 0).setKeyPosition(r4);
    }

    public void addKeyAttribute(String r3, TypedBundle r4) {
        getWidgetState(r3, null, 0).setKeyAttribute(r4);
    }

    public void addKeyAttribute(String r3, TypedBundle r4, CustomVariable[] r5) {
        getWidgetState(r3, null, 0).setKeyAttribute(r4, r5);
    }

    public void addKeyCycle(String r3, TypedBundle r4) {
        getWidgetState(r3, null, 0).setKeyCycle(r4);
    }

    public void addKeyPosition(String r9, int r10, int r11, float r12, float r13) {
        TypedBundle r0 = new TypedBundle();
        r0.add(510, 2);
        r0.add(100, r10);
        r0.add(506, r12);
        r0.add(507, r13);
        getWidgetState(r9, null, 0).setKeyPosition(r0);
        KeyPosition r1 = new KeyPosition(r9, r10, r11, r12, r13);
        HashMap<String, KeyPosition> r14 = this.mKeyPositions.get(Integer.valueOf(r10));
        if (r14 != null) goto L5;
        r14 = new HashMap();
        this.mKeyPositions.put(Integer.valueOf(r10), r14);
    L5:
        r14.put(r9, r1);
    }

    public void addCustomFloat(int r2, String r3, String r4, float r5) {
        getWidgetState(r3, null, r2).getFrame(r2).addCustomFloat(r4, r5);
    }

    public void addCustomColor(int r2, String r3, String r4, int r5) {
        getWidgetState(r3, null, r2).getFrame(r2).addCustomColor(r4, r5);
    }

    private void calculateParentDimensions(float r5) {
        int r0 = this.mParentStartWidth;
        this.mParentInterpolatedWidth = (int) ((r0 + 0.5f) + ((this.mParentEndWidth - r0) * r5));
        int r1 = this.mParentStartHeight;
        this.mParentInterpolateHeight = (int) ((r1 + 0.5f) + ((this.mParentEndHeight - r1) * r5));
    }

    public int getInterpolatedWidth() {
        return this.mParentInterpolatedWidth;
    }

    public int getInterpolatedHeight() {
        return this.mParentInterpolateHeight;
    }

    public void updateFrom(ConstraintWidgetContainer r7, int r8) {
        int r1 = 0;
        boolean r3 = true;
        if (r7.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L5;
        boolean r0 = true;
    L6:
        this.mWrap = r0;
        if (r7.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L10;
        r3 = false;
    L10:
        this.mWrap = r0 | r3;
        if (r8 != 0) goto L13;
        int r2 = r7.getWidth();
        this.mParentStartWidth = r2;
        this.mParentInterpolatedWidth = r2;
        int r4 = r7.getHeight();
        this.mParentStartHeight = r4;
        this.mParentInterpolateHeight = r4;
    L14:
        ArrayList<ConstraintWidget> r9 = r7.getChildren();
        int r5 = r9.size();
        WidgetState[] r6 = new WidgetState[r5];
    L15:
        if (r1 >= r5) goto L20;
        ConstraintWidget r10 = r9.get(r1);
        WidgetState r11 = getWidgetState(r10.stringId, null, r8);
        r6[r1] = r11;
        r11.update(r10, r8);
        String r12 = r11.getPathRelativeId();
        if (r12 == null) goto L19;
        r11.setPathRelative(getWidgetState(r12, null, r8));
    L19:
        r1 = r1 + 1;
        goto L15
    L20:
        calcStagger();
        return;
    L13:
        this.mParentEndWidth = r7.getWidth();
        this.mParentEndHeight = r7.getHeight();
        goto L14
    L5:
        r0 = false;
        goto L6
    }

    public void interpolate(int r4, int r5, float r6) {
        if (this.mWrap == false) goto L5;
        calculateParentDimensions(r6);
    L5:
        Easing r0 = this.mEasing;
        if (r0 == null) goto L8;
        r6 = (float) r0.get(r6);
    L8:
        Iterator<String> r1 = this.mState.keySet().iterator();
    L10:
        if (r1.hasNext() == false) goto L12;
        this.mState.get(r1.next()).interpolate(r4, r5, r6, this);
        goto L10
    }

    public WidgetFrame getStart(String r1) {
        WidgetState r0 = this.mState.get(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mStart;
    }

    public WidgetFrame getEnd(String r1) {
        WidgetState r0 = this.mState.get(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mEnd;
    }

    public WidgetFrame getInterpolated(String r1) {
        WidgetState r0 = this.mState.get(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mInterpolated;
    }

    public float[] getPath(String r2) {
        WidgetState r1 = this.mState.get(r2);
        float[] r3 = new float[124];
        r1.mMotionControl.buildPath(r3, 62);
        return r3;
    }

    public int getKeyFrames(String r1, float[] r2, int[] r3, int[] r4) {
        return this.mState.get(r1).mMotionControl.buildKeyFrames(r2, r3, r4);
    }

    private WidgetState getWidgetState(String r1) {
        return this.mState.get(r1);
    }

    public WidgetState getWidgetState(String r4, ConstraintWidget r5, int r6) {
        WidgetState r0 = this.mState.get(r4);
        if (r0 != null) goto L7;
        r0 = new WidgetState();
        this.mBundle.applyDelta(r0.mMotionControl);
        r0.mMotionWidgetStart.updateMotion(r0.mMotionControl);
        this.mState.put(r4, r0);
        if (r5 == null) goto L7;
        r0.update(r5, r6);
    L7:
        return r0;
    }

    public WidgetFrame getStart(ConstraintWidget r3) {
        return getWidgetState(r3.stringId, null, 0).mStart;
    }

    public WidgetFrame getEnd(ConstraintWidget r3) {
        return getWidgetState(r3.stringId, null, 1).mEnd;
    }

    public WidgetFrame getInterpolated(ConstraintWidget r3) {
        return getWidgetState(r3.stringId, null, 2).mInterpolated;
    }

    public Interpolator getInterpolator() {
        return getInterpolator(this.mDefaultInterpolator, this.mDefaultInterpolatorString);
    }

    public int getAutoTransition() {
        return this.mAutoTransition;
    }

    public void calcStagger() {
        float r0 = this.mStagger;
        if (r0 != 0.0f) goto L5;
        return;
    L5:
        boolean r2 = true;
        if (r0 >= 0.0d) goto L8;
        boolean r1 = true;
    L9:
        float r3 = Math.abs(r0);
        Iterator<String> r4 = this.mState.keySet().iterator();
    L11:
        if (r4.hasNext() == false) goto L15;
        if (Float.isNaN(this.mState.get(r4.next()).mMotionControl.getMotionStagger()) == true) goto L11;
    L16:
        float r5 = Float.MAX_VALUE;
        float r6 = -3.4028235E38f;
        if (r2 == false) goto L33;
        Iterator<String> r7 = this.mState.keySet().iterator();
    L20:
        if (r7.hasNext() == false) goto L24;
        float r8 = this.mState.get(r7.next()).mMotionControl.getMotionStagger();
        if (Float.isNaN(r8) == true) goto L20;
        r5 = Math.min(r5, r8);
        r6 = Math.max(r6, r8);
        goto L20
    L24:
        Iterator<String> r9 = this.mState.keySet().iterator();
    L26:
        if (r9.hasNext() == false) goto L44;
        Motion r10 = this.mState.get(r9.next()).mMotionControl;
        float r11 = r10.getMotionStagger();
        if (Float.isNaN(r11) == true) goto L26;
        float r12 = 1.0f / (1.0f - r3);
        float r13 = r6 - r5;
        float r14 = r3 - (((r11 - r5) * r3) / r13);
        if (r1 == false) goto L32;
        r14 = r3 - (((r6 - r11) / r13) * r3);
    L32:
        r10.setStaggerScale(r12);
        r10.setStaggerOffset(r14);
        goto L26
    L44:
        return;
    L33:
        Iterator<String> r15 = this.mState.keySet().iterator();
    L35:
        if (r15.hasNext() == false) goto L37;
        Motion r16 = this.mState.get(r15.next()).mMotionControl;
        float r17 = r16.getFinalX() + r16.getFinalY();
        r5 = Math.min(r5, r17);
        r6 = Math.max(r6, r17);
        goto L35
    L37:
        Iterator<String> r18 = this.mState.keySet().iterator();
    L39:
        if (r18.hasNext() == false) goto L62;
        Motion r19 = this.mState.get(r18.next()).mMotionControl;
        float r20 = r19.getFinalX() + r19.getFinalY();
        float r21 = r6 - r5;
        float r22 = r3 - (((r20 - r5) * r3) / r21);
        if (r1 == false) goto L43;
        r22 = r3 - (((r6 - r20) / r21) * r3);
    L43:
        r19.setStaggerScale(1.0f / (1.0f - r3));
        r19.setStaggerOffset(r22);
        goto L39
    L62:
        return;
    L15:
        r2 = false;
        goto L16
    L8:
        r1 = false;
        goto L9
    }
}
