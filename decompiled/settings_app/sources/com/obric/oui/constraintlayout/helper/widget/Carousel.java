package com.obric.oui.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.obric.oui.constraintlayout.motion.widget.MotionHelper;
import com.obric.oui.constraintlayout.motion.widget.MotionLayout;
import com.obric.oui.constraintlayout.motion.widget.MotionScene;
import com.obric.oui.constraintlayout.widget.ConstraintSet;
import com.obric.oui.constraintlayout.widget.R;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class Carousel extends MotionHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "Carousel";
    public static final int TOUCH_UP_CARRY_ON = 2;
    public static final int TOUCH_UP_IMMEDIATE_STOP = 1;
    private Adapter mAdapter;
    private int mAnimateTargetDelay;
    private int mBackwardTransition;
    private float mDampening;
    private int mEmptyViewBehavior;
    private int mFirstViewReference;
    private int mForwardTransition;
    private int mIndex;
    private boolean mInfiniteCarousel;
    int mLastStartId;
    private final ArrayList<View> mList;
    private MotionLayout mMotionLayout;
    private int mNextState;
    private int mPreviousIndex;
    private int mPreviousState;
    private int mStartIndex;
    private int mTargetIndex;
    private int mTouchUpMode;
    Runnable mUpdateRunnable;
    private float mVelocityThreshold;

    public interface Adapter {
        int count();

        void onNewItem(int r1);

        void populate(View r1, int r2);
    }

    static /* synthetic */ MotionLayout access$000(Carousel r0) {
        return r0.mMotionLayout;
    }

    static /* synthetic */ void access$100(Carousel r0) {
        r0.updateItems();
    }

    static /* synthetic */ int access$200(Carousel r0) {
        return r0.mIndex;
    }

    static /* synthetic */ Adapter access$300(Carousel r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ int access$400(Carousel r0) {
        return r0.mTouchUpMode;
    }

    static /* synthetic */ float access$500(Carousel r0) {
        return r0.mVelocityThreshold;
    }

    static /* synthetic */ float access$600(Carousel r0) {
        return r0.mDampening;
    }

    static /* synthetic */ int access$700(Carousel r0) {
        return r0.mPreviousIndex;
    }

    public Carousel(Context r3) {
        super(r3);
        this.mAdapter = null;
        this.mList = new ArrayList();
        this.mPreviousIndex = 0;
        this.mIndex = 0;
        this.mFirstViewReference = -1;
        this.mInfiniteCarousel = false;
        this.mBackwardTransition = -1;
        this.mForwardTransition = -1;
        this.mPreviousState = -1;
        this.mNextState = -1;
        this.mDampening = 0.9f;
        this.mStartIndex = 0;
        this.mEmptyViewBehavior = 4;
        this.mTouchUpMode = 1;
        this.mVelocityThreshold = 2.0f;
        this.mTargetIndex = -1;
        this.mAnimateTargetDelay = 200;
        this.mLastStartId = -1;
        this.mUpdateRunnable = new AnonymousClass1(this);
    }

    public Carousel(Context r4, AttributeSet r5) {
        super(r4, r5);
        this.mAdapter = null;
        this.mList = new ArrayList();
        this.mPreviousIndex = 0;
        this.mIndex = 0;
        this.mFirstViewReference = -1;
        this.mInfiniteCarousel = false;
        this.mBackwardTransition = -1;
        this.mForwardTransition = -1;
        this.mPreviousState = -1;
        this.mNextState = -1;
        this.mDampening = 0.9f;
        this.mStartIndex = 0;
        this.mEmptyViewBehavior = 4;
        this.mTouchUpMode = 1;
        this.mVelocityThreshold = 2.0f;
        this.mTargetIndex = -1;
        this.mAnimateTargetDelay = 200;
        this.mLastStartId = -1;
        this.mUpdateRunnable = new AnonymousClass1(this);
        init(r4, r5);
    }

    public Carousel(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        this.mAdapter = null;
        this.mList = new ArrayList();
        this.mPreviousIndex = 0;
        this.mIndex = 0;
        this.mFirstViewReference = -1;
        this.mInfiniteCarousel = false;
        this.mBackwardTransition = -1;
        this.mForwardTransition = -1;
        this.mPreviousState = -1;
        this.mNextState = -1;
        this.mDampening = 0.9f;
        this.mStartIndex = 0;
        this.mEmptyViewBehavior = 4;
        this.mTouchUpMode = 1;
        this.mVelocityThreshold = 2.0f;
        this.mTargetIndex = -1;
        this.mAnimateTargetDelay = 200;
        this.mLastStartId = -1;
        this.mUpdateRunnable = new AnonymousClass1(this);
        init(r3, r4);
    }

    private void init(Context r4, AttributeSet r5) {
        if (r5 == null) goto L50;
        TypedArray r6 = r4.obtainStyledAttributes(r5, R.styleable.Carousel);
        int r7 = r6.getIndexCount();
        int r0 = 0;
    L4:
        if (r0 >= r7) goto L36;
        int r1 = r6.getIndex(r0);
        if (r1 != R.styleable.Carousel_carousel_firstView) goto L9;
        this.mFirstViewReference = r6.getResourceId(r1, this.mFirstViewReference);
    L35:
        r0 = r0 + 1;
        goto L4
    L9:
        if (r1 != R.styleable.Carousel_carousel_backwardTransition) goto L12;
        this.mBackwardTransition = r6.getResourceId(r1, this.mBackwardTransition);
        goto L35
    L12:
        if (r1 != R.styleable.Carousel_carousel_forwardTransition) goto L15;
        this.mForwardTransition = r6.getResourceId(r1, this.mForwardTransition);
        goto L35
    L15:
        if (r1 != R.styleable.Carousel_carousel_emptyViewsBehavior) goto L18;
        this.mEmptyViewBehavior = r6.getInt(r1, this.mEmptyViewBehavior);
        goto L35
    L18:
        if (r1 != R.styleable.Carousel_carousel_previousState) goto L21;
        this.mPreviousState = r6.getResourceId(r1, this.mPreviousState);
        goto L35
    L21:
        if (r1 != R.styleable.Carousel_carousel_nextState) goto L24;
        this.mNextState = r6.getResourceId(r1, this.mNextState);
        goto L35
    L24:
        if (r1 != R.styleable.Carousel_carousel_touchUp_dampeningFactor) goto L27;
        this.mDampening = r6.getFloat(r1, this.mDampening);
        goto L35
    L27:
        if (r1 != R.styleable.Carousel_carousel_touchUpMode) goto L30;
        this.mTouchUpMode = r6.getInt(r1, this.mTouchUpMode);
        goto L35
    L30:
        if (r1 != R.styleable.Carousel_carousel_touchUp_velocityThreshold) goto L33;
        this.mVelocityThreshold = r6.getFloat(r1, this.mVelocityThreshold);
        goto L35
    L33:
        if (r1 != R.styleable.Carousel_carousel_infinite) goto L35;
        this.mInfiniteCarousel = r6.getBoolean(r1, this.mInfiniteCarousel);
        goto L35
    L36:
        r6.recycle();
        return;
    }

    public void setAdapter(Adapter r1) {
        this.mAdapter = r1;
    }

    public void setInfinite(boolean r1) {
        this.mInfiniteCarousel = r1;
    }

    public boolean isInfinite() {
        return this.mInfiniteCarousel;
    }

    public int getCount() {
        Adapter r0 = this.mAdapter;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.count();
    }

    public int getCurrentIndex() {
        return this.mIndex;
    }

    public void transitionToIndex(int r3, int r4) {
        this.mTargetIndex = Math.max(0, Math.min(getCount() - 1, r3));
        int r5 = Math.max(0, r4);
        this.mAnimateTargetDelay = r5;
        this.mMotionLayout.setTransitionDuration(r5);
        if (r3 >= this.mIndex) goto L5;
        this.mMotionLayout.transitionToState(this.mPreviousState, this.mAnimateTargetDelay);
        return;
    L5:
        this.mMotionLayout.transitionToState(this.mNextState, this.mAnimateTargetDelay);
    }

    public void jumpToIndex(int r2) {
        this.mIndex = Math.max(0, Math.min(getCount() - 1, r2));
        refresh();
    }

    public void refresh() {
        int r0 = this.mList.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        View r3 = this.mList.get(r2);
        if (this.mAdapter.count() != 0) goto L7;
        updateViewVisibility(r3, this.mEmptyViewBehavior);
    L8:
        r2 = r2 + 1;
        goto L3
    L7:
        updateViewVisibility(r3, 0);
        goto L8
    L9:
        this.mMotionLayout.rebuildScene();
        updateItems();
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.MotionHelper, com.obric.oui.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionChange(MotionLayout r1, int r2, int r3, float r4) {
        this.mLastStartId = r2;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.MotionHelper, com.obric.oui.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionCompleted(MotionLayout r2, int r3) {
        int r4 = this.mIndex;
        this.mPreviousIndex = r4;
        if (r3 != this.mNextState) goto L6;
        this.mIndex = r4 + 1;
    L9:
        if (this.mInfiniteCarousel == false) goto L17;
        if (this.mIndex < this.mAdapter.count()) goto L14;
        this.mIndex = 0;
    L14:
        if (this.mIndex >= 0) goto L23;
        this.mIndex = this.mAdapter.count() - 1;
    L23:
        if (this.mPreviousIndex == this.mIndex) goto L26;
        this.mMotionLayout.post(this.mUpdateRunnable);
        return;
    L26:
        return;
    L17:
        if (this.mIndex < this.mAdapter.count()) goto L20;
        this.mIndex = this.mAdapter.count() - 1;
    L20:
        if (this.mIndex >= 0) goto L23;
        this.mIndex = 0;
        goto L23
    L6:
        if (r3 != this.mPreviousState) goto L9;
        this.mIndex = r4 - 1;
        goto L9
    }

    private void enableAllTransitions(boolean r2) {
        Iterator<MotionScene.Transition> r1 = this.mMotionLayout.getDefinedTransitions().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().setEnabled(r2);
        goto L4
    }

    private boolean enableTransition(int r3, boolean r4) {
        if (r3 != (-1)) goto L5;
        return false;
    L5:
        MotionLayout r2 = this.mMotionLayout;
        if (r2 != null) goto L8;
        return false;
    L8:
        MotionScene.Transition r5 = r2.getTransition(r3);
        if (r5 != null) goto L12;
        return false;
    L12:
        if (r4 != r5.isEnabled()) goto L14;
        return false;
    L14:
        r5.setEnabled(r4);
        return true;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mList.clear();
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((getParent() instanceof MotionLayout) == false) goto L24;
        MotionLayout r0 = (MotionLayout) getParent();
        this.mList.clear();
        int r1 = 0;
    L6:
        if (r1 >= this.mCount) goto L11;
        int r2 = this.mIds[r1];
        View r3 = r0.getViewById(r2);
        if (this.mFirstViewReference != r2) goto L10;
        this.mStartIndex = r1;
    L10:
        this.mList.add(r3);
        r1 = r1 + 1;
        goto L6
    L11:
        this.mMotionLayout = r0;
        if (this.mTouchUpMode != 2) goto L19;
        MotionScene.Transition r4 = r0.getTransition(this.mForwardTransition);
        if (r4 == null) goto L16;
        r4.setOnTouchUp(5);
    L16:
        MotionScene.Transition r5 = this.mMotionLayout.getTransition(this.mBackwardTransition);
        if (r5 == null) goto L19;
        r5.setOnTouchUp(5);
    L19:
        updateItems();
        return;
    }

    private boolean updateViewVisibility(View r5, int r6) {
        MotionLayout r0 = this.mMotionLayout;
        int r1 = 0;
        if (r0 != null) goto L5;
        return false;
    L5:
        int[] r2 = r0.getConstraintSetIds();
        boolean r3 = false;
    L7:
        if (r1 >= r2.length) goto L9;
        r3 = r3 | updateViewVisibility(r2[r1], r5, r6);
        r1 = r1 + 1;
        goto L7
    L9:
        return r3;
    }

    private boolean updateViewVisibility(int r2, View r3, int r4) {
        ConstraintSet r1 = this.mMotionLayout.getConstraintSet(r2);
        if (r1 != null) goto L5;
        return false;
    L5:
        ConstraintSet.Constraint r5 = r1.getConstraint(r3.getId());
        if (r5 != null) goto L8;
        return false;
    L8:
        r5.propertySet.mVisibilityMode = 1;
        r3.setVisibility(r4);
        return true;
    }

    private void updateItems() {
        Adapter r0 = this.mAdapter;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.mMotionLayout != null) goto L9;
        return;
    L9:
        if (r0.count() != 0) goto L11;
        return;
    L11:
        int r1 = this.mList.size();
        int r2 = 0;
    L12:
        if (r2 >= r1) goto L46;
        View r3 = this.mList.get(r2);
        int r4 = (this.mIndex + r2) - this.mStartIndex;
        if (this.mInfiniteCarousel == true) goto L16;
        if (r4 >= 0) goto L42;
        updateViewVisibility(r3, this.mEmptyViewBehavior);
    L45:
        r2 = r2 + 1;
        goto L12
    L42:
        if (r4 < this.mAdapter.count()) goto L44;
        updateViewVisibility(r3, this.mEmptyViewBehavior);
        goto L45
    L44:
        updateViewVisibility(r3, 0);
        this.mAdapter.populate(r3, r4);
        goto L45
    L16:
        if (r4 >= 0) goto L26;
        int r6 = this.mEmptyViewBehavior;
        if (r6 == 4) goto L20;
        updateViewVisibility(r3, r6);
    L22:
        if ((r4 % this.mAdapter.count()) != 0) goto L24;
        this.mAdapter.populate(r3, 0);
        goto L45
    L24:
        Adapter r5 = this.mAdapter;
        r5.populate(r3, r5.count() + (r4 % this.mAdapter.count()));
        goto L45
    L20:
        updateViewVisibility(r3, 0);
        goto L22
    L26:
        if (r4 >= this.mAdapter.count()) goto L28;
        updateViewVisibility(r3, 0);
        this.mAdapter.populate(r3, r4);
        goto L45
    L28:
        if (r4 != this.mAdapter.count()) goto L31;
        r4 = 0;
    L33:
        int r7 = this.mEmptyViewBehavior;
        if (r7 == 4) goto L36;
        updateViewVisibility(r3, r7);
    L37:
        this.mAdapter.populate(r3, r4);
        goto L45
    L36:
        updateViewVisibility(r3, 0);
        goto L37
    L31:
        if (r4 <= this.mAdapter.count()) goto L33;
        r4 = r4 % this.mAdapter.count();
        goto L33
    L46:
        int r8 = this.mTargetIndex;
        if (r8 == (-1)) goto L52;
        if (r8 == this.mIndex) goto L52;
        this.mMotionLayout.post(new Carousel$$ExternalSyntheticLambda0(this));
    L55:
        if (this.mBackwardTransition != (-1)) goto L57;
    L71:
        Log.w(TAG, "No backward or forward transitions defined for Carousel!");
        return;
    L57:
        if (this.mForwardTransition == (-1)) goto L71;
        if (this.mInfiniteCarousel == false) goto L62;
        return;
    L62:
        int r9 = this.mAdapter.count();
        if (this.mIndex != 0) goto L65;
        enableTransition(this.mBackwardTransition, false);
    L67:
        if (this.mIndex != (r9 - 1)) goto L69;
        enableTransition(this.mForwardTransition, false);
        return;
    L69:
        enableTransition(this.mForwardTransition, true);
        this.mMotionLayout.setTransition(this.mForwardTransition);
        return;
    L65:
        enableTransition(this.mBackwardTransition, true);
        this.mMotionLayout.setTransition(this.mBackwardTransition);
    L52:
        if (r8 != this.mIndex) goto L55;
        this.mTargetIndex = -1;
        goto L55
    }

    /* JADX INFO: renamed from: lambda$updateItems$0$com-obric-oui-constraintlayout-helper-widget-Carousel, reason: not valid java name */
    /* synthetic */ void m1101x99e40fc8() {
        this.mMotionLayout.setTransitionDuration(this.mAnimateTargetDelay);
        if (this.mTargetIndex >= this.mIndex) goto L5;
        this.mMotionLayout.transitionToState(this.mPreviousState, this.mAnimateTargetDelay);
        return;
    L5:
        this.mMotionLayout.transitionToState(this.mNextState, this.mAnimateTargetDelay);
    }
}
