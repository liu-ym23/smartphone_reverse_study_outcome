package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.R;
import androidx.core.widget.NestedScrollView;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
class TouchResponse {
    public static final int COMPLETE_MODE_CONTINUOUS_VELOCITY = 0;
    public static final int COMPLETE_MODE_SPRING = 1;
    private static final boolean DEBUG = false;
    private static final float EPSILON = 1.0E-7f;
    static final int FLAG_DISABLE_POST_SCROLL = 1;
    static final int FLAG_DISABLE_SCROLL = 2;
    static final int FLAG_SUPPORT_SCROLL_UP = 4;
    private static final int SEC_TO_MILLISECONDS = 1000;
    private static final int SIDE_BOTTOM = 3;
    private static final int SIDE_END = 6;
    private static final int SIDE_LEFT = 1;
    private static final int SIDE_MIDDLE = 4;
    private static final int SIDE_RIGHT = 2;
    private static final int SIDE_START = 5;
    private static final int SIDE_TOP = 0;
    private static final String TAG = "TouchResponse";
    private static final float[][] TOUCH_DIRECTION = null;
    private static final int TOUCH_DOWN = 1;
    private static final int TOUCH_END = 5;
    private static final int TOUCH_LEFT = 2;
    private static final int TOUCH_RIGHT = 3;
    private static final float[][] TOUCH_SIDES = null;
    private static final int TOUCH_START = 4;
    private static final int TOUCH_UP = 0;
    private float[] mAnchorDpDt;
    private int mAutoCompleteMode;
    private float mDragScale;
    private boolean mDragStarted;
    private float mDragThreshold;
    private int mFlags;
    boolean mIsRotateMode;
    private float mLastTouchX;
    private float mLastTouchY;
    private int mLimitBoundsTo;
    private float mMaxAcceleration;
    private float mMaxVelocity;
    private final MotionLayout mMotionLayout;
    private boolean mMoveWhenScrollAtTop;
    private int mOnTouchUp;
    float mRotateCenterX;
    float mRotateCenterY;
    private int mRotationCenterId;
    private int mSpringBoundary;
    private float mSpringDamping;
    private float mSpringMass;
    private float mSpringStiffness;
    private float mSpringStopThreshold;
    private int[] mTempLoc;
    private int mTouchAnchorId;
    private int mTouchAnchorSide;
    private float mTouchAnchorX;
    private float mTouchAnchorY;
    private float mTouchDirectionX;
    private float mTouchDirectionY;
    private int mTouchRegionId;
    private int mTouchSide;

    static {
        TOUCH_SIDES = new float[][]{new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
        TOUCH_DIRECTION = new float[][]{new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
    }

    TouchResponse(Context context, MotionLayout layout, XmlPullParser parser) {
        this.mTouchAnchorSide = 0;
        this.mTouchSide = 0;
        this.mOnTouchUp = 0;
        this.mTouchAnchorId = -1;
        this.mTouchRegionId = -1;
        this.mLimitBoundsTo = -1;
        this.mTouchAnchorY = 0.5f;
        this.mTouchAnchorX = 0.5f;
        this.mRotateCenterX = 0.5f;
        this.mRotateCenterY = 0.5f;
        this.mRotationCenterId = -1;
        this.mIsRotateMode = false;
        this.mTouchDirectionX = 0.0f;
        this.mTouchDirectionY = 1.0f;
        this.mDragStarted = false;
        this.mAnchorDpDt = new float[2];
        this.mTempLoc = new int[2];
        this.mMaxVelocity = 4.0f;
        this.mMaxAcceleration = 1.2f;
        this.mMoveWhenScrollAtTop = true;
        this.mDragScale = 1.0f;
        this.mFlags = 0;
        this.mDragThreshold = 10.0f;
        this.mSpringDamping = 10.0f;
        this.mSpringMass = 1.0f;
        this.mSpringStiffness = Float.NaN;
        this.mSpringStopThreshold = Float.NaN;
        this.mSpringBoundary = 0;
        this.mAutoCompleteMode = 0;
        this.mMotionLayout = layout;
        fillFromAttributeList(context, Xml.asAttributeSet(parser));
    }

    public TouchResponse(MotionLayout layout, OnSwipe onSwipe) {
        this.mTouchAnchorSide = 0;
        this.mTouchSide = 0;
        this.mOnTouchUp = 0;
        this.mTouchAnchorId = -1;
        this.mTouchRegionId = -1;
        this.mLimitBoundsTo = -1;
        this.mTouchAnchorY = 0.5f;
        this.mTouchAnchorX = 0.5f;
        this.mRotateCenterX = 0.5f;
        this.mRotateCenterY = 0.5f;
        this.mRotationCenterId = -1;
        this.mIsRotateMode = false;
        this.mTouchDirectionX = 0.0f;
        this.mTouchDirectionY = 1.0f;
        this.mDragStarted = false;
        this.mAnchorDpDt = new float[2];
        this.mTempLoc = new int[2];
        this.mMaxVelocity = 4.0f;
        this.mMaxAcceleration = 1.2f;
        this.mMoveWhenScrollAtTop = true;
        this.mDragScale = 1.0f;
        this.mFlags = 0;
        this.mDragThreshold = 10.0f;
        this.mSpringDamping = 10.0f;
        this.mSpringMass = 1.0f;
        this.mSpringStiffness = Float.NaN;
        this.mSpringStopThreshold = Float.NaN;
        this.mSpringBoundary = 0;
        this.mAutoCompleteMode = 0;
        this.mMotionLayout = layout;
        this.mTouchAnchorId = onSwipe.getTouchAnchorId();
        int r6 = onSwipe.getTouchAnchorSide();
        this.mTouchAnchorSide = r6;
        if (r6 == (-1)) goto L5;
        float[] r7 = TOUCH_SIDES[r6];
        this.mTouchAnchorX = r7[0];
        this.mTouchAnchorY = r7[1];
    L5:
        int r8 = onSwipe.getDragDirection();
        this.mTouchSide = r8;
        float[][] r1 = TOUCH_DIRECTION;
        if (r8 >= r1.length) goto L8;
        float[] r9 = r1[r8];
        this.mTouchDirectionX = r9[0];
        this.mTouchDirectionY = r9[1];
    L9:
        this.mMaxVelocity = onSwipe.getMaxVelocity();
        this.mMaxAcceleration = onSwipe.getMaxAcceleration();
        this.mMoveWhenScrollAtTop = onSwipe.getMoveWhenScrollAtTop();
        this.mDragScale = onSwipe.getDragScale();
        this.mDragThreshold = onSwipe.getDragThreshold();
        this.mTouchRegionId = onSwipe.getTouchRegionId();
        this.mOnTouchUp = onSwipe.getOnTouchUp();
        this.mFlags = onSwipe.getNestedScrollFlags();
        this.mLimitBoundsTo = onSwipe.getLimitBoundsTo();
        this.mRotationCenterId = onSwipe.getRotationCenterId();
        this.mSpringBoundary = onSwipe.getSpringBoundary();
        this.mSpringDamping = onSwipe.getSpringDamping();
        this.mSpringMass = onSwipe.getSpringMass();
        this.mSpringStiffness = onSwipe.getSpringStiffness();
        this.mSpringStopThreshold = onSwipe.getSpringStopThreshold();
        this.mAutoCompleteMode = onSwipe.getAutoCompleteMode();
        return;
    L8:
        this.mTouchDirectionY = Float.NaN;
        this.mTouchDirectionX = Float.NaN;
        this.mIsRotateMode = true;
        goto L9
    }

    public void setRTL(boolean rtl) {
        if (rtl == false) goto L5;
        float[][] r8 = TOUCH_DIRECTION;
        r8[4] = r8[3];
        r8[5] = r8[2];
        float[][] r9 = TOUCH_SIDES;
        r9[5] = r9[2];
        r9[6] = r9[1];
    L6:
        float[] r10 = TOUCH_SIDES[this.mTouchAnchorSide];
        this.mTouchAnchorX = r10[0];
        this.mTouchAnchorY = r10[1];
        int r11 = this.mTouchSide;
        float[][] r1 = TOUCH_DIRECTION;
        if (r11 < r1.length) goto L9;
        return;
    L9:
        float[] r12 = r1[r11];
        this.mTouchDirectionX = r12[0];
        this.mTouchDirectionY = r12[1];
        return;
    L5:
        float[][] r13 = TOUCH_DIRECTION;
        r13[4] = r13[2];
        r13[5] = r13[3];
        float[][] r14 = TOUCH_SIDES;
        r14[5] = r14[1];
        r14[6] = r14[2];
        goto L6
    }

    private void fillFromAttributeList(Context context, AttributeSet attrs) {
        TypedArray r2 = context.obtainStyledAttributes(attrs, R.styleable.OnSwipe);
        fill(r2);
        r2.recycle();
    }

    private void fill(TypedArray a2) {
        int r0 = a2.getIndexCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L65;
        int r3 = a2.getIndex(r2);
        if (r3 != R.styleable.OnSwipe_touchAnchorId) goto L8;
        this.mTouchAnchorId = a2.getResourceId(r3, this.mTouchAnchorId);
    L64:
        r2 = r2 + 1;
        goto L3
    L8:
        if (r3 != R.styleable.OnSwipe_touchAnchorSide) goto L11;
        int r4 = a2.getInt(r3, this.mTouchAnchorSide);
        this.mTouchAnchorSide = r4;
        float[] r5 = TOUCH_SIDES[r4];
        this.mTouchAnchorX = r5[0];
        this.mTouchAnchorY = r5[1];
        goto L64
    L11:
        if (r3 != R.styleable.OnSwipe_dragDirection) goto L17;
        int r6 = a2.getInt(r3, this.mTouchSide);
        this.mTouchSide = r6;
        float[][] r7 = TOUCH_DIRECTION;
        if (r6 >= r7.length) goto L15;
        float[] r8 = r7[r6];
        this.mTouchDirectionX = r8[0];
        this.mTouchDirectionY = r8[1];
        goto L64
    L15:
        this.mTouchDirectionY = Float.NaN;
        this.mTouchDirectionX = Float.NaN;
        this.mIsRotateMode = true;
        goto L64
    L17:
        if (r3 != R.styleable.OnSwipe_maxVelocity) goto L20;
        this.mMaxVelocity = a2.getFloat(r3, this.mMaxVelocity);
        goto L64
    L20:
        if (r3 != R.styleable.OnSwipe_maxAcceleration) goto L23;
        this.mMaxAcceleration = a2.getFloat(r3, this.mMaxAcceleration);
        goto L64
    L23:
        if (r3 != R.styleable.OnSwipe_moveWhenScrollAtTop) goto L26;
        this.mMoveWhenScrollAtTop = a2.getBoolean(r3, this.mMoveWhenScrollAtTop);
        goto L64
    L26:
        if (r3 != R.styleable.OnSwipe_dragScale) goto L29;
        this.mDragScale = a2.getFloat(r3, this.mDragScale);
        goto L64
    L29:
        if (r3 != R.styleable.OnSwipe_dragThreshold) goto L32;
        this.mDragThreshold = a2.getFloat(r3, this.mDragThreshold);
        goto L64
    L32:
        if (r3 != R.styleable.OnSwipe_touchRegionId) goto L35;
        this.mTouchRegionId = a2.getResourceId(r3, this.mTouchRegionId);
        goto L64
    L35:
        if (r3 != R.styleable.OnSwipe_onTouchUp) goto L38;
        this.mOnTouchUp = a2.getInt(r3, this.mOnTouchUp);
        goto L64
    L38:
        if (r3 != R.styleable.OnSwipe_nestedScrollFlags) goto L41;
        this.mFlags = a2.getInteger(r3, 0);
        goto L64
    L41:
        if (r3 != R.styleable.OnSwipe_limitBoundsTo) goto L44;
        this.mLimitBoundsTo = a2.getResourceId(r3, 0);
        goto L64
    L44:
        if (r3 != R.styleable.OnSwipe_rotationCenterId) goto L47;
        this.mRotationCenterId = a2.getResourceId(r3, this.mRotationCenterId);
        goto L64
    L47:
        if (r3 != R.styleable.OnSwipe_springDamping) goto L50;
        this.mSpringDamping = a2.getFloat(r3, this.mSpringDamping);
        goto L64
    L50:
        if (r3 != R.styleable.OnSwipe_springMass) goto L53;
        this.mSpringMass = a2.getFloat(r3, this.mSpringMass);
        goto L64
    L53:
        if (r3 != R.styleable.OnSwipe_springStiffness) goto L56;
        this.mSpringStiffness = a2.getFloat(r3, this.mSpringStiffness);
        goto L64
    L56:
        if (r3 != R.styleable.OnSwipe_springStopThreshold) goto L59;
        this.mSpringStopThreshold = a2.getFloat(r3, this.mSpringStopThreshold);
        goto L64
    L59:
        if (r3 != R.styleable.OnSwipe_springBoundary) goto L62;
        this.mSpringBoundary = a2.getInt(r3, this.mSpringBoundary);
        goto L64
    L62:
        if (r3 != R.styleable.OnSwipe_autoCompleteMode) goto L64;
        this.mAutoCompleteMode = a2.getInt(r3, this.mAutoCompleteMode);
        goto L64
    }

    void setUpTouchEvent(float lastTouchX, float lastTouchY) {
        this.mLastTouchX = lastTouchX;
        this.mLastTouchY = lastTouchY;
        this.mDragStarted = false;
    }

    void processTouchRotateEvent(MotionEvent event, MotionLayout.MotionTracker velocityTracker, int currentState, MotionScene motionScene) {
        velocityTracker.addMovement(event);
        int r3 = event.getAction();
        boolean r4 = false;
        if (r3 != 0) goto L5;
        this.mLastTouchX = event.getRawX();
        this.mLastTouchY = event.getRawY();
        this.mDragStarted = false;
        return;
    L5:
        if (r3 != 1) goto L7;
        this.mDragStarted = false;
        velocityTracker.computeCurrentVelocity(16);
        float r6 = velocityTracker.getXVelocity();
        float r1 = velocityTracker.getYVelocity();
        float r7 = this.mMotionLayout.getProgress();
        float r8 = this.mMotionLayout.getWidth() / 2.0f;
        float r11 = this.mMotionLayout.getHeight() / 2.0f;
        int r12 = this.mRotationCenterId;
        if (r12 == (-1)) goto L52;
        View r9 = this.mMotionLayout.findViewById(r12);
        this.mMotionLayout.getLocationOnScreen(this.mTempLoc);
        float r5 = this.mTempLoc[0] + ((r9.getLeft() + r9.getRight()) / 2.0f);
        float r13 = this.mTempLoc[1];
        int r14 = r9.getTop();
        int r10 = r9.getBottom();
    L51:
        r11 = r13 + ((r14 + r10) / 2.0f);
        r8 = r5;
    L55:
        float r15 = event.getRawX() - r8;
        float r2 = event.getRawY() - r11;
        double r16 = Math.toDegrees(Math.atan2(r2, r15));
        int r17 = this.mTouchAnchorId;
        if (r17 == (-1)) goto L58;
        this.mMotionLayout.getAnchorDpDt(r17, r7, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float[] r18 = this.mAnchorDpDt;
        r18[1] = (float) Math.toDegrees(r18[1]);
    L59:
        float r19 = ((float) (Math.toDegrees(Math.atan2(r1 + r2, r6 + r15)) - r16)) * 62.5f;
        if (Float.isNaN(r19) == true) goto L62;
        float r20 = (((r19 * 3.0f) * this.mDragScale) / this.mAnchorDpDt[1]) + r7;
    L64:
        if (r20 == 0.0f) goto L91;
        if (r20 == 1.0f) goto L91;
        int r21 = this.mOnTouchUp;
        if (r21 == 3) goto L91;
        float r22 = (r19 * this.mDragScale) / this.mAnchorDpDt[1];
        if (r20 >= 0.5d) goto L72;
        float r23 = 0.0f;
    L74:
        if (r21 != 6) goto L80;
        if ((r7 + r22) >= 0.0f) goto L78;
        r22 = Math.abs(r22);
    L78:
        r23 = 1.0f;
    L80:
        if (this.mOnTouchUp == 7) goto L82;
    L85:
        this.mMotionLayout.touchAnimateTo(this.mOnTouchUp, r23, r22 * 3.0f);
        if (0.0f < r7) goto L88;
    L89:
        this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
        return;
    L88:
        if (1.0f <= r7) goto L89;
        return;
    L82:
        if ((r7 + r22) <= 1.0f) goto L84;
        r22 = -Math.abs(r22);
    L84:
        r23 = 0.0f;
        goto L85
    L72:
        r23 = 1.0f;
    L91:
        if (0.0f < r20) goto L93;
    L94:
        this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
        return;
    L93:
        if (1.0f <= r20) goto L94;
        return;
    L62:
        r20 = r7;
        goto L64
    L58:
        this.mAnchorDpDt[1] = 360.0f;
        goto L59
    L52:
        int r110 = this.mTouchAnchorId;
        if (r110 == (-1)) goto L55;
        View r24 = this.mMotionLayout.findViewById(this.mMotionLayout.getMotionController(r110).getAnimateRelativeTo());
        this.mMotionLayout.getLocationOnScreen(this.mTempLoc);
        r5 = this.mTempLoc[0] + ((r24.getLeft() + r24.getRight()) / 2.0f);
        r13 = this.mTempLoc[1];
        r14 = r24.getTop();
        r10 = r24.getBottom();
        goto L51
    L7:
        if (r3 != 2) goto L103;
        event.getRawY();
        event.getRawX();
        float r25 = this.mMotionLayout.getWidth() / 2.0f;
        float r111 = this.mMotionLayout.getHeight() / 2.0f;
        int r112 = this.mRotationCenterId;
        if (r112 == (-1)) goto L12;
        View r26 = this.mMotionLayout.findViewById(r112);
        this.mMotionLayout.getLocationOnScreen(this.mTempLoc);
        float r113 = this.mTempLoc[0] + ((r26.getLeft() + r26.getRight()) / 2.0f);
        r111 = ((r26.getTop() + r26.getBottom()) / 2.0f) + this.mTempLoc[1];
        r25 = r113;
    L18:
        float r27 = event.getRawX() - r25;
        float r114 = event.getRawY() - r111;
        double r28 = Math.atan2(event.getRawY() - r111, event.getRawX() - r25);
        float r29 = (float) (((r28 - Math.atan2(this.mLastTouchY - r111, this.mLastTouchX - r25)) * 180.0d) / 3.141592653589793d);
        if (r29 <= 330.0f) goto L22;
        r29 = r29 - 360.0f;
    L25:
        if (Math.abs(r29) <= 0.01d) goto L27;
    L28:
        float r30 = this.mMotionLayout.getProgress();
        if (this.mDragStarted == true) goto L31;
        this.mDragStarted = true;
        this.mMotionLayout.setProgress(r30);
    L31:
        int r115 = this.mTouchAnchorId;
        if (r115 == (-1)) goto L34;
        this.mMotionLayout.getAnchorDpDt(r115, r30, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float[] r31 = this.mAnchorDpDt;
        r31[1] = (float) Math.toDegrees(r31[1]);
    L35:
        float r32 = Math.max(Math.min(r30 + ((r29 * this.mDragScale) / this.mAnchorDpDt[1]), 1.0f), 0.0f);
        float r33 = this.mMotionLayout.getProgress();
        if (r32 != r33) goto L38;
        this.mMotionLayout.mLastVelocity = 0.0f;
    L47:
        this.mLastTouchX = event.getRawX();
        this.mLastTouchY = event.getRawY();
        return;
    L38:
        if (r33 != 0.0f) goto L40;
    L41:
        MotionLayout r34 = this.mMotionLayout;
        if (r33 != 0.0f) goto L44;
        r4 = true;
    L44:
        r34.endTrigger(r4);
    L45:
        this.mMotionLayout.setProgress(r32);
        velocityTracker.computeCurrentVelocity(1000);
        float r35 = velocityTracker.getXVelocity();
        double r36 = velocityTracker.getYVelocity();
        double r37 = r35;
        float r38 = (float) ((Math.hypot(r36, r37) * Math.sin(Math.atan2(r36, r37) - r28)) / Math.hypot(r27, r114));
        this.mMotionLayout.mLastVelocity = (float) Math.toDegrees(r38);
        goto L47
    L40:
        if (r33 != 1.0f) goto L45;
    L34:
        this.mAnchorDpDt[1] = 360.0f;
        goto L35
    L27:
        if (this.mDragStarted == true) goto L28;
        return;
    L22:
        if (r29 >= (-330.0f)) goto L25;
        r29 = r29 + 360.0f;
        goto L25
    L12:
        int r116 = this.mTouchAnchorId;
        if (r116 == (-1)) goto L18;
        View r117 = this.mMotionLayout.findViewById(this.mMotionLayout.getMotionController(r116).getAnimateRelativeTo());
        if (r117 != null) goto L17;
        Log.e(TAG, "could not find view to animate to");
        goto L18
    L17:
        this.mMotionLayout.getLocationOnScreen(this.mTempLoc);
        r25 = this.mTempLoc[0] + ((r117.getLeft() + r117.getRight()) / 2.0f);
        r111 = this.mTempLoc[1] + ((r117.getTop() + r117.getBottom()) / 2.0f);
        goto L18
    }

    void processTouchEvent(MotionEvent event, MotionLayout.MotionTracker velocityTracker, int currentState, MotionScene motionScene) {
        if (this.mIsRotateMode == false) goto L6;
        processTouchRotateEvent(event, velocityTracker, currentState, motionScene);
        return;
    L6:
        velocityTracker.addMovement(event);
        int r3 = event.getAction();
        if (r3 != 0) goto L9;
        this.mLastTouchX = event.getRawX();
        this.mLastTouchY = event.getRawY();
        this.mDragStarted = false;
        return;
    L9:
        if (r3 != 1) goto L11;
        this.mDragStarted = false;
        velocityTracker.computeCurrentVelocity(1000);
        float r2 = velocityTracker.getXVelocity();
        float r1 = velocityTracker.getYVelocity();
        float r4 = this.mMotionLayout.getProgress();
        int r13 = this.mTouchAnchorId;
        if (r13 == (-1)) goto L58;
        this.mMotionLayout.getAnchorDpDt(r13, r4, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
    L59:
        float r5 = this.mTouchDirectionX;
        float[] r7 = this.mAnchorDpDt;
        float r6 = r7[0];
        float r8 = r7[1];
        if (r5 == 0.0f) goto L62;
        float r9 = r2 / r6;
    L64:
        if (Float.isNaN(r9) == true) goto L66;
        float r10 = (r9 / 3.0f) + r4;
    L68:
        if (r10 == 0.0f) goto L94;
        if (r10 == 1.0f) goto L94;
        int r11 = this.mOnTouchUp;
        if (r11 == 3) goto L94;
        if (r10 >= 0.5d) goto L76;
        float r12 = 0.0f;
    L77:
        if (r11 != 6) goto L83;
        if ((r4 + r9) >= 0.0f) goto L81;
        r9 = Math.abs(r9);
    L81:
        r12 = 1.0f;
    L83:
        if (this.mOnTouchUp == 7) goto L85;
    L88:
        this.mMotionLayout.touchAnimateTo(this.mOnTouchUp, r12, r9);
        if (0.0f < r4) goto L91;
    L92:
        this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
        return;
    L91:
        if (1.0f <= r4) goto L92;
        return;
    L85:
        if ((r4 + r9) <= 1.0f) goto L87;
        r9 = -Math.abs(r9);
    L87:
        r12 = 0.0f;
        goto L88
    L76:
        r12 = 1.0f;
    L94:
        if (0.0f < r10) goto L96;
    L97:
        this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
        return;
    L96:
        if (1.0f <= r10) goto L97;
        return;
    L66:
        r10 = r4;
        goto L68
    L62:
        r9 = r1 / r8;
        goto L64
    L58:
        float r14 = Math.min(this.mMotionLayout.getWidth(), this.mMotionLayout.getHeight());
        float[] r15 = this.mAnchorDpDt;
        r15[1] = this.mTouchDirectionY * r14;
        r15[0] = r14 * this.mTouchDirectionX;
        goto L59
    L11:
        if (r3 != 2) goto L106;
        float r16 = event.getRawY() - this.mLastTouchY;
        float r17 = event.getRawX() - this.mLastTouchX;
        if (Math.abs((this.mTouchDirectionX * r17) + (this.mTouchDirectionY * r16)) <= this.mDragThreshold) goto L16;
    L17:
        float r18 = this.mMotionLayout.getProgress();
        if (this.mDragStarted == true) goto L20;
        this.mDragStarted = true;
        this.mMotionLayout.setProgress(r18);
    L20:
        int r19 = this.mTouchAnchorId;
        if (r19 == (-1)) goto L23;
        this.mMotionLayout.getAnchorDpDt(r19, r18, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
    L24:
        float r20 = this.mTouchDirectionX;
        float[] r21 = this.mAnchorDpDt;
        if (Math.abs(((r20 * r21[0]) + (this.mTouchDirectionY * r21[1])) * this.mDragScale) >= 0.01d) goto L28;
        float[] r22 = this.mAnchorDpDt;
        r22[0] = 0.01f;
        r22[1] = 0.01f;
    L28:
        if (this.mTouchDirectionX == 0.0f) goto L30;
        float r110 = r17 / this.mAnchorDpDt[0];
    L31:
        float r23 = Math.max(Math.min(r18 + r110, 1.0f), 0.0f);
        if (this.mOnTouchUp != 6) goto L35;
        r23 = Math.max(r23, 0.01f);
    L35:
        if (this.mOnTouchUp != 7) goto L37;
        r23 = Math.min(r23, 0.99f);
    L37:
        float r24 = this.mMotionLayout.getProgress();
        if (r23 != r24) goto L40;
        this.mMotionLayout.mLastVelocity = 0.0f;
    L54:
        this.mLastTouchX = event.getRawX();
        this.mLastTouchY = event.getRawY();
        return;
    L40:
        if (r24 != 0.0f) goto L42;
    L43:
        MotionLayout r25 = this.mMotionLayout;
        if (r24 != 0.0f) goto L46;
        boolean r26 = true;
    L47:
        r25.endTrigger(r26);
    L48:
        this.mMotionLayout.setProgress(r23);
        velocityTracker.computeCurrentVelocity(1000);
        float r27 = velocityTracker.getXVelocity();
        float r28 = velocityTracker.getYVelocity();
        if (this.mTouchDirectionX == 0.0f) goto L51;
        float r29 = r27 / this.mAnchorDpDt[0];
    L52:
        this.mMotionLayout.mLastVelocity = r29;
        goto L54
    L51:
        r29 = r28 / this.mAnchorDpDt[1];
        goto L52
    L46:
        r26 = false;
        goto L47
    L42:
        if (r24 != 1.0f) goto L48;
    L30:
        r110 = r16 / this.mAnchorDpDt[1];
        goto L31
    L23:
        float r30 = Math.min(this.mMotionLayout.getWidth(), this.mMotionLayout.getHeight());
        float[] r31 = this.mAnchorDpDt;
        r31[1] = this.mTouchDirectionY * r30;
        r31[0] = r30 * this.mTouchDirectionX;
        goto L24
    L16:
        if (this.mDragStarted == true) goto L17;
        return;
    }

    void setDown(float lastTouchX, float lastTouchY) {
        this.mLastTouchX = lastTouchX;
        this.mLastTouchY = lastTouchY;
    }

    float getProgressDirection(float dx, float dy) {
        float r3 = this.mMotionLayout.getProgress();
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, r3, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float r0 = this.mTouchDirectionX;
        if (r0 == 0.0f) goto L8;
        float[] r7 = this.mAnchorDpDt;
        if (r7[0] != 0.0f) goto L13;
        r7[0] = 1.0E-7f;
    L13:
        return (dx * r0) / r7[0];
    L8:
        float[] r8 = this.mAnchorDpDt;
        if (r8[1] != 0.0f) goto L12;
        r8[1] = 1.0E-7f;
    L12:
        return (dy * this.mTouchDirectionY) / r8[1];
    }

    void scrollUp(float dx, float dy) {
        boolean r0 = false;
        this.mDragStarted = false;
        float r1 = this.mMotionLayout.getProgress();
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, r1, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float r2 = this.mTouchDirectionX;
        float[] r3 = this.mAnchorDpDt;
        float r4 = r3[0];
        float r5 = this.mTouchDirectionY;
        float r6 = r3[1];
        float r7 = 0.0f;
        if (r2 == 0.0f) goto L5;
        float r10 = (dx * r2) / r4;
    L7:
        if (Float.isNaN(r10) == true) goto L10;
        r1 = r1 + (r10 / 3.0f);
    L10:
        if (r1 != 0.0f) goto L12;
        return;
    L12:
        if (r1 == 1.0f) goto L14;
        boolean r8 = true;
    L15:
        int r9 = this.mOnTouchUp;
        if (r9 == 3) goto L19;
        r0 = true;
    L19:
        if ((r0 & r8) == false) goto L27;
        MotionLayout r11 = this.mMotionLayout;
        if (r1 < 0.5d) goto L24;
        r7 = 1.0f;
    L24:
        r11.touchAnimateTo(r9, r7, r10);
        return;
    L27:
        return;
    L14:
        r8 = false;
        goto L15
    L5:
        r10 = (dy * r5) / r6;
        goto L7
    }

    void scrollMove(float dx, float dy) {
        float r0 = this.mMotionLayout.getProgress();
        if (this.mDragStarted == true) goto L5;
        this.mDragStarted = true;
        this.mMotionLayout.setProgress(r0);
    L5:
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, r0, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float r1 = this.mTouchDirectionX;
        float[] r2 = this.mAnchorDpDt;
        if (Math.abs((r1 * r2[0]) + (this.mTouchDirectionY * r2[1])) >= 0.01d) goto L8;
        float[] r3 = this.mAnchorDpDt;
        r3[0] = 0.01f;
        r3[1] = 0.01f;
    L8:
        float r4 = this.mTouchDirectionX;
        if (r4 == 0.0f) goto L11;
        float r9 = (dx * r4) / this.mAnchorDpDt[0];
    L12:
        float r10 = Math.max(Math.min(r0 + r9, 1.0f), 0.0f);
        if (r10 == this.mMotionLayout.getProgress()) goto L16;
        this.mMotionLayout.setProgress(r10);
        return;
    L16:
        return;
    L11:
        r9 = (dy * this.mTouchDirectionY) / this.mAnchorDpDt[1];
        goto L12
    }

    void setupTouch() {
        int r0 = this.mTouchAnchorId;
        if (r0 == (-1)) goto L7;
        View r1 = this.mMotionLayout.findViewById(r0);
        if (r1 != null) goto L9;
        Log.e(TAG, "cannot find TouchAnchorId @id/" + Debug.getName(this.mMotionLayout.getContext(), this.mTouchAnchorId));
    L9:
        if ((r1 instanceof NestedScrollView) == false) goto L12;
        NestedScrollView r2 = (NestedScrollView) r1;
        r2.setOnTouchListener(new AnonymousClass1(this));
        r2.setOnScrollChangeListener(new AnonymousClass2(this));
        return;
    L12:
        return;
    L7:
        r1 = null;
        goto L9
    }

    public void setAnchorId(int id) {
        this.mTouchAnchorId = id;
    }

    public int getAnchorId() {
        return this.mTouchAnchorId;
    }

    public void setTouchAnchorLocation(float x, float y) {
        this.mTouchAnchorX = x;
        this.mTouchAnchorY = y;
    }

    public void setMaxVelocity(float velocity) {
        this.mMaxVelocity = velocity;
    }

    public void setMaxAcceleration(float acceleration) {
        this.mMaxAcceleration = acceleration;
    }

    float getMaxAcceleration() {
        return this.mMaxAcceleration;
    }

    public float getMaxVelocity() {
        return this.mMaxVelocity;
    }

    boolean getMoveWhenScrollAtTop() {
        return this.mMoveWhenScrollAtTop;
    }

    public int getAutoCompleteMode() {
        return this.mAutoCompleteMode;
    }

    void setAutoCompleteMode(int autoCompleteMode) {
        this.mAutoCompleteMode = autoCompleteMode;
    }

    RectF getTouchRegion(ViewGroup layout, RectF rect) {
        int r2 = this.mTouchRegionId;
        if (r2 != (-1)) goto L5;
        return null;
    L5:
        View r3 = layout.findViewById(r2);
        if (r3 != null) goto L8;
        return null;
    L8:
        rect.set(r3.getLeft(), r3.getTop(), r3.getRight(), r3.getBottom());
        return rect;
    }

    int getTouchRegionId() {
        return this.mTouchRegionId;
    }

    RectF getLimitBoundsTo(ViewGroup layout, RectF rect) {
        int r2 = this.mLimitBoundsTo;
        if (r2 != (-1)) goto L5;
        return null;
    L5:
        View r3 = layout.findViewById(r2);
        if (r3 != null) goto L8;
        return null;
    L8:
        rect.set(r3.getLeft(), r3.getTop(), r3.getRight(), r3.getBottom());
        return rect;
    }

    int getLimitBoundsToId() {
        return this.mLimitBoundsTo;
    }

    float dot(float dx, float dy) {
        return (dx * this.mTouchDirectionX) + (dy * this.mTouchDirectionY);
    }

    public String toString() {
        if (Float.isNaN(this.mTouchDirectionX) == false) goto L6;
        return "rotation";
    L6:
        return this.mTouchDirectionX + " , " + this.mTouchDirectionY;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public void setTouchUpMode(int touchUpMode) {
        this.mOnTouchUp = touchUpMode;
    }

    public float getSpringStiffness() {
        return this.mSpringStiffness;
    }

    public float getSpringMass() {
        return this.mSpringMass;
    }

    public float getSpringDamping() {
        return this.mSpringDamping;
    }

    public float getSpringStopThreshold() {
        return this.mSpringStopThreshold;
    }

    public int getSpringBoundary() {
        return this.mSpringBoundary;
    }

    boolean isDragStarted() {
        return this.mDragStarted;
    }
}
