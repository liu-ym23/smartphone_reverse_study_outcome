package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class Carousel extends MotionHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "Carousel";
    public static final int TOUCH_UP_CARRY_ON = 2;
    public static final int TOUCH_UP_IMMEDIATE_STOP = 1;
    private int backwardTransition;
    private float dampening;
    private int emptyViewBehavior;
    private int firstViewReference;
    private int forwardTransition;
    private boolean infiniteCarousel;
    private Adapter mAdapter;
    private int mAnimateTargetDelay;
    private int mIndex;
    int mLastStartId;
    private final ArrayList<View> mList;
    private MotionLayout mMotionLayout;
    private int mPreviousIndex;
    private int mTargetIndex;
    Runnable mUpdateRunnable;
    private int nextState;
    private int previousState;
    private int startIndex;
    private int touchUpMode;
    private float velocityThreshold;

    public interface Adapter {
        int count();

        void onNewItem(int index);

        void populate(View view, int index);
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
        return r0.touchUpMode;
    }

    static /* synthetic */ float access$500(Carousel r0) {
        return r0.velocityThreshold;
    }

    static /* synthetic */ float access$600(Carousel r0) {
        return r0.dampening;
    }

    static /* synthetic */ int access$700(Carousel r0) {
        return r0.mPreviousIndex;
    }

    public Carousel(Context context) {
        super(context);
        this.mAdapter = null;
        this.mList = new ArrayList();
        this.mPreviousIndex = 0;
        this.mIndex = 0;
        this.firstViewReference = -1;
        this.infiniteCarousel = false;
        this.backwardTransition = -1;
        this.forwardTransition = -1;
        this.previousState = -1;
        this.nextState = -1;
        this.dampening = 0.9f;
        this.startIndex = 0;
        this.emptyViewBehavior = 4;
        this.touchUpMode = 1;
        this.velocityThreshold = 2.0f;
        this.mTargetIndex = -1;
        this.mAnimateTargetDelay = 200;
        this.mLastStartId = -1;
        this.mUpdateRunnable = new AnonymousClass1(this);
    }

    public Carousel(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mAdapter = null;
        this.mList = new ArrayList();
        this.mPreviousIndex = 0;
        this.mIndex = 0;
        this.firstViewReference = -1;
        this.infiniteCarousel = false;
        this.backwardTransition = -1;
        this.forwardTransition = -1;
        this.previousState = -1;
        this.nextState = -1;
        this.dampening = 0.9f;
        this.startIndex = 0;
        this.emptyViewBehavior = 4;
        this.touchUpMode = 1;
        this.velocityThreshold = 2.0f;
        this.mTargetIndex = -1;
        this.mAnimateTargetDelay = 200;
        this.mLastStartId = -1;
        this.mUpdateRunnable = new AnonymousClass1(this);
        init(context, attrs);
    }

    public Carousel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mAdapter = null;
        this.mList = new ArrayList();
        this.mPreviousIndex = 0;
        this.mIndex = 0;
        this.firstViewReference = -1;
        this.infiniteCarousel = false;
        this.backwardTransition = -1;
        this.forwardTransition = -1;
        this.previousState = -1;
        this.nextState = -1;
        this.dampening = 0.9f;
        this.startIndex = 0;
        this.emptyViewBehavior = 4;
        this.touchUpMode = 1;
        this.velocityThreshold = 2.0f;
        this.mTargetIndex = -1;
        this.mAnimateTargetDelay = 200;
        this.mLastStartId = -1;
        this.mUpdateRunnable = new AnonymousClass1(this);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs == null) goto L50;
        TypedArray r4 = context.obtainStyledAttributes(attrs, R.styleable.Carousel);
        int r5 = r4.getIndexCount();
        int r0 = 0;
    L4:
        if (r0 >= r5) goto L36;
        int r1 = r4.getIndex(r0);
        if (r1 != R.styleable.Carousel_carousel_firstView) goto L9;
        this.firstViewReference = r4.getResourceId(r1, this.firstViewReference);
    L35:
        r0 = r0 + 1;
        goto L4
    L9:
        if (r1 != R.styleable.Carousel_carousel_backwardTransition) goto L12;
        this.backwardTransition = r4.getResourceId(r1, this.backwardTransition);
        goto L35
    L12:
        if (r1 != R.styleable.Carousel_carousel_forwardTransition) goto L15;
        this.forwardTransition = r4.getResourceId(r1, this.forwardTransition);
        goto L35
    L15:
        if (r1 != R.styleable.Carousel_carousel_emptyViewsBehavior) goto L18;
        this.emptyViewBehavior = r4.getInt(r1, this.emptyViewBehavior);
        goto L35
    L18:
        if (r1 != R.styleable.Carousel_carousel_previousState) goto L21;
        this.previousState = r4.getResourceId(r1, this.previousState);
        goto L35
    L21:
        if (r1 != R.styleable.Carousel_carousel_nextState) goto L24;
        this.nextState = r4.getResourceId(r1, this.nextState);
        goto L35
    L24:
        if (r1 != R.styleable.Carousel_carousel_touchUp_dampeningFactor) goto L27;
        this.dampening = r4.getFloat(r1, this.dampening);
        goto L35
    L27:
        if (r1 != R.styleable.Carousel_carousel_touchUpMode) goto L30;
        this.touchUpMode = r4.getInt(r1, this.touchUpMode);
        goto L35
    L30:
        if (r1 != R.styleable.Carousel_carousel_touchUp_velocityThreshold) goto L33;
        this.velocityThreshold = r4.getFloat(r1, this.velocityThreshold);
        goto L35
    L33:
        if (r1 != R.styleable.Carousel_carousel_infinite) goto L35;
        this.infiniteCarousel = r4.getBoolean(r1, this.infiniteCarousel);
        goto L35
    L36:
        r4.recycle();
        return;
    }

    public void setAdapter(Adapter adapter) {
        this.mAdapter = adapter;
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

    public void transitionToIndex(int index, int delay) {
        this.mTargetIndex = Math.max(0, Math.min(getCount() - 1, index));
        int r4 = Math.max(0, delay);
        this.mAnimateTargetDelay = r4;
        this.mMotionLayout.setTransitionDuration(r4);
        if (index >= this.mIndex) goto L5;
        this.mMotionLayout.transitionToState(this.previousState, this.mAnimateTargetDelay);
        return;
    L5:
        this.mMotionLayout.transitionToState(this.nextState, this.mAnimateTargetDelay);
    }

    public void jumpToIndex(int index) {
        this.mIndex = Math.max(0, Math.min(getCount() - 1, index));
        refresh();
    }

    public void refresh() {
        int r0 = this.mList.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        View r3 = this.mList.get(r2);
        if (this.mAdapter.count() != 0) goto L7;
        updateViewVisibility(r3, this.emptyViewBehavior);
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

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionChange(MotionLayout motionLayout, int startId, int endId, float progress) {
        this.mLastStartId = startId;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionCompleted(MotionLayout motionLayout, int currentId) {
        int r2 = this.mIndex;
        this.mPreviousIndex = r2;
        if (currentId != this.nextState) goto L6;
        this.mIndex = r2 + 1;
    L9:
        if (this.infiniteCarousel == false) goto L17;
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
        if (currentId != this.previousState) goto L9;
        this.mIndex = r2 - 1;
        goto L9
    }

    private void enableAllTransitions(boolean enable) {
        Iterator<MotionScene.Transition> r1 = this.mMotionLayout.getDefinedTransitions().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().setEnabled(enable);
        goto L4
    }

    private boolean enableTransition(int transitionID, boolean enable) {
        if (transitionID != (-1)) goto L5;
        return false;
    L5:
        MotionLayout r2 = this.mMotionLayout;
        if (r2 != null) goto L8;
        return false;
    L8:
        MotionScene.Transition r3 = r2.getTransition(transitionID);
        if (r3 != null) goto L12;
        return false;
    L12:
        if (enable != r3.isEnabled()) goto L14;
        return false;
    L14:
        r3.setEnabled(enable);
        return true;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((getParent() instanceof MotionLayout) == false) goto L24;
        MotionLayout r0 = (MotionLayout) getParent();
        int r1 = 0;
    L6:
        if (r1 >= this.mCount) goto L11;
        int r2 = this.mIds[r1];
        View r3 = r0.getViewById(r2);
        if (this.firstViewReference != r2) goto L10;
        this.startIndex = r1;
    L10:
        this.mList.add(r3);
        r1 = r1 + 1;
        goto L6
    L11:
        this.mMotionLayout = r0;
        if (this.touchUpMode != 2) goto L19;
        MotionScene.Transition r4 = r0.getTransition(this.forwardTransition);
        if (r4 == null) goto L16;
        r4.setOnTouchUp(5);
    L16:
        MotionScene.Transition r5 = this.mMotionLayout.getTransition(this.backwardTransition);
        if (r5 == null) goto L19;
        r5.setOnTouchUp(5);
    L19:
        updateItems();
        return;
    }

    private boolean updateViewVisibility(View view, int visibility) {
        MotionLayout r0 = this.mMotionLayout;
        int r1 = 0;
        if (r0 != null) goto L5;
        return false;
    L5:
        int[] r2 = r0.getConstraintSetIds();
        boolean r3 = false;
    L7:
        if (r1 >= r2.length) goto L9;
        r3 = r3 | updateViewVisibility(r2[r1], view, visibility);
        r1 = r1 + 1;
        goto L7
    L9:
        return r3;
    }

    private boolean updateViewVisibility(int constraintSetId, View view, int visibility) {
        ConstraintSet r1 = this.mMotionLayout.getConstraintSet(constraintSetId);
        if (r1 != null) goto L5;
        return false;
    L5:
        ConstraintSet.Constraint r2 = r1.getConstraint(view.getId());
        if (r2 != null) goto L8;
        return false;
    L8:
        r2.propertySet.mVisibilityMode = 1;
        view.setVisibility(visibility);
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
        int r4 = (this.mIndex + r2) - this.startIndex;
        if (this.infiniteCarousel == true) goto L16;
        if (r4 >= 0) goto L42;
        updateViewVisibility(r3, this.emptyViewBehavior);
    L45:
        r2 = r2 + 1;
        goto L12
    L42:
        if (r4 < this.mAdapter.count()) goto L44;
        updateViewVisibility(r3, this.emptyViewBehavior);
        goto L45
    L44:
        updateViewVisibility(r3, 0);
        this.mAdapter.populate(r3, r4);
        goto L45
    L16:
        if (r4 >= 0) goto L26;
        int r6 = this.emptyViewBehavior;
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
        int r7 = this.emptyViewBehavior;
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
        if (this.backwardTransition != (-1)) goto L57;
    L71:
        Log.w(TAG, "No backward or forward transitions defined for Carousel!");
        return;
    L57:
        if (this.forwardTransition == (-1)) goto L71;
        if (this.infiniteCarousel == false) goto L62;
        return;
    L62:
        int r9 = this.mAdapter.count();
        if (this.mIndex != 0) goto L65;
        enableTransition(this.backwardTransition, false);
    L67:
        if (this.mIndex != (r9 - 1)) goto L69;
        enableTransition(this.forwardTransition, false);
        return;
    L69:
        enableTransition(this.forwardTransition, true);
        this.mMotionLayout.setTransition(this.forwardTransition);
        return;
    L65:
        enableTransition(this.backwardTransition, true);
        this.mMotionLayout.setTransition(this.backwardTransition);
    L52:
        if (r8 != this.mIndex) goto L55;
        this.mTargetIndex = -1;
        goto L55
    }

    /* JADX INFO: renamed from: lambda$updateItems$0$androidx-constraintlayout-helper-widget-Carousel, reason: not valid java name */
    /* synthetic */ void m11xc943cdea() {
        this.mMotionLayout.setTransitionDuration(this.mAnimateTargetDelay);
        if (this.mTargetIndex >= this.mIndex) goto L5;
        this.mMotionLayout.transitionToState(this.previousState, this.mAnimateTargetDelay);
        return;
    L5:
        this.mMotionLayout.transitionToState(this.nextState, this.mAnimateTargetDelay);
    }
}
