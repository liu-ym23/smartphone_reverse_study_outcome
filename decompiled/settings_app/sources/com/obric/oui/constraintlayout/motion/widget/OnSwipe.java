package com.obric.oui.constraintlayout.motion.widget;

/* JADX INFO: loaded from: classes4.dex */
public class OnSwipe {
    public static final int COMPLETE_MODE_CONTINUOUS_VELOCITY = 0;
    public static final int COMPLETE_MODE_SPRING = 1;
    public static final int DRAG_ANTICLOCKWISE = 7;
    public static final int DRAG_CLOCKWISE = 6;
    public static final int DRAG_DOWN = 1;
    public static final int DRAG_END = 5;
    public static final int DRAG_LEFT = 2;
    public static final int DRAG_RIGHT = 3;
    public static final int DRAG_START = 4;
    public static final int DRAG_UP = 0;
    public static final int FLAG_DISABLE_POST_SCROLL = 1;
    public static final int FLAG_DISABLE_SCROLL = 2;
    public static final int ON_UP_AUTOCOMPLETE = 0;
    public static final int ON_UP_AUTOCOMPLETE_TO_END = 2;
    public static final int ON_UP_AUTOCOMPLETE_TO_START = 1;
    public static final int ON_UP_DECELERATE = 4;
    public static final int ON_UP_DECELERATE_AND_COMPLETE = 5;
    public static final int ON_UP_NEVER_TO_END = 7;
    public static final int ON_UP_NEVER_TO_START = 6;
    public static final int ON_UP_STOP = 3;
    public static final int SIDE_BOTTOM = 3;
    public static final int SIDE_END = 6;
    public static final int SIDE_LEFT = 1;
    public static final int SIDE_MIDDLE = 4;
    public static final int SIDE_RIGHT = 2;
    public static final int SIDE_START = 5;
    public static final int SIDE_TOP = 0;
    public static final int SPRING_BOUNDARY_BOUNCEBOTH = 3;
    public static final int SPRING_BOUNDARY_BOUNCEEND = 2;
    public static final int SPRING_BOUNDARY_BOUNCESTART = 1;
    public static final int SPRING_BOUNDARY_OVERSHOOT = 0;
    private int mAutoCompleteMode;
    private int mDragDirection;
    private float mDragScale;
    private float mDragThreshold;
    private int mFlags;
    private int mLimitBoundsTo;
    private float mMaxAcceleration;
    private float mMaxVelocity;
    private boolean mMoveWhenScrollAtTop;
    private int mOnTouchUp;
    private int mRotationCenterId;
    private int mSpringBoundary;
    private float mSpringDamping;
    private float mSpringMass;
    private float mSpringStiffness;
    private float mSpringStopThreshold;
    private int mTouchAnchorId;
    private int mTouchAnchorSide;
    private int mTouchRegionId;

    public OnSwipe() {
        this.mDragDirection = 0;
        this.mTouchAnchorSide = 0;
        this.mTouchAnchorId = -1;
        this.mTouchRegionId = -1;
        this.mLimitBoundsTo = -1;
        this.mOnTouchUp = 0;
        this.mRotationCenterId = -1;
        this.mMaxVelocity = 4.0f;
        this.mMaxAcceleration = 1.2f;
        this.mMoveWhenScrollAtTop = true;
        this.mDragScale = 1.0f;
        this.mFlags = 0;
        this.mDragThreshold = 10.0f;
        this.mSpringDamping = Float.NaN;
        this.mSpringMass = 1.0f;
        this.mSpringStiffness = Float.NaN;
        this.mSpringStopThreshold = Float.NaN;
        this.mSpringBoundary = 0;
        this.mAutoCompleteMode = 0;
    }

    public OnSwipe setTouchAnchorId(int r1) {
        this.mTouchAnchorId = r1;
        return this;
    }

    public int getTouchAnchorId() {
        return this.mTouchAnchorId;
    }

    public OnSwipe setTouchAnchorSide(int r1) {
        this.mTouchAnchorSide = r1;
        return this;
    }

    public int getTouchAnchorSide() {
        return this.mTouchAnchorSide;
    }

    public OnSwipe setDragDirection(int r1) {
        this.mDragDirection = r1;
        return this;
    }

    public int getDragDirection() {
        return this.mDragDirection;
    }

    public OnSwipe setMaxVelocity(int r1) {
        this.mMaxVelocity = r1;
        return this;
    }

    public float getMaxVelocity() {
        return this.mMaxVelocity;
    }

    public OnSwipe setMaxAcceleration(int r1) {
        this.mMaxAcceleration = r1;
        return this;
    }

    public float getMaxAcceleration() {
        return this.mMaxAcceleration;
    }

    public OnSwipe setMoveWhenScrollAtTop(boolean r1) {
        this.mMoveWhenScrollAtTop = r1;
        return this;
    }

    public boolean getMoveWhenScrollAtTop() {
        return this.mMoveWhenScrollAtTop;
    }

    public OnSwipe setDragScale(int r1) {
        this.mDragScale = r1;
        return this;
    }

    public float getDragScale() {
        return this.mDragScale;
    }

    public OnSwipe setDragThreshold(int r1) {
        this.mDragThreshold = r1;
        return this;
    }

    public float getDragThreshold() {
        return this.mDragThreshold;
    }

    public OnSwipe setTouchRegionId(int r1) {
        this.mTouchRegionId = r1;
        return this;
    }

    public int getTouchRegionId() {
        return this.mTouchRegionId;
    }

    public OnSwipe setOnTouchUp(int r1) {
        this.mOnTouchUp = r1;
        return this;
    }

    public int getOnTouchUp() {
        return this.mOnTouchUp;
    }

    public OnSwipe setNestedScrollFlags(int r1) {
        this.mFlags = r1;
        return this;
    }

    public int getNestedScrollFlags() {
        return this.mFlags;
    }

    public OnSwipe setLimitBoundsTo(int r1) {
        this.mLimitBoundsTo = r1;
        return this;
    }

    public int getLimitBoundsTo() {
        return this.mLimitBoundsTo;
    }

    public OnSwipe setRotateCenter(int r1) {
        this.mRotationCenterId = r1;
        return this;
    }

    public int getRotationCenterId() {
        return this.mRotationCenterId;
    }

    public float getSpringDamping() {
        return this.mSpringDamping;
    }

    public OnSwipe setSpringDamping(float r1) {
        this.mSpringDamping = r1;
        return this;
    }

    public float getSpringMass() {
        return this.mSpringMass;
    }

    public OnSwipe setSpringMass(float r1) {
        this.mSpringMass = r1;
        return this;
    }

    public float getSpringStiffness() {
        return this.mSpringStiffness;
    }

    public OnSwipe setSpringStiffness(float r1) {
        this.mSpringStiffness = r1;
        return this;
    }

    public float getSpringStopThreshold() {
        return this.mSpringStopThreshold;
    }

    public OnSwipe setSpringStopThreshold(float r1) {
        this.mSpringStopThreshold = r1;
        return this;
    }

    public int getSpringBoundary() {
        return this.mSpringBoundary;
    }

    public OnSwipe setSpringBoundary(int r1) {
        this.mSpringBoundary = r1;
        return this;
    }

    public int getAutoCompleteMode() {
        return this.mAutoCompleteMode;
    }

    public void setAutoCompleteMode(int r1) {
        this.mAutoCompleteMode = r1;
    }
}
