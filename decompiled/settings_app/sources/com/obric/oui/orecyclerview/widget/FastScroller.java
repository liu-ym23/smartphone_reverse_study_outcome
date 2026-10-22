package com.obric.oui.orecyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes3.dex */
class FastScroller extends RecyclerView.ItemDecoration implements RecyclerView.OnItemTouchListener {
    private static final int ANIMATION_STATE_FADING_IN = 1;
    private static final int ANIMATION_STATE_FADING_OUT = 3;
    private static final int ANIMATION_STATE_IN = 2;
    private static final int ANIMATION_STATE_OUT = 0;
    private static final int DRAG_NONE = 0;
    private static final int DRAG_X = 1;
    private static final int DRAG_Y = 2;
    private static final int[] EMPTY_STATE_SET = null;
    private static final int HIDE_DELAY_AFTER_DRAGGING_MS = 1200;
    private static final int HIDE_DELAY_AFTER_VISIBLE_MS = 1500;
    private static final int HIDE_DURATION_MS = 500;
    private static final int[] PRESSED_STATE_SET = null;
    private static final int SCROLLBAR_FULL_OPAQUE = 255;
    private static final int SHOW_DURATION_MS = 500;
    private static final int STATE_DRAGGING = 2;
    private static final int STATE_HIDDEN = 0;
    private static final int STATE_VISIBLE = 1;
    int mAnimationState;
    private int mDragState;
    private final Runnable mHideRunnable;
    float mHorizontalDragX;
    private final int[] mHorizontalRange;
    int mHorizontalThumbCenterX;
    private final StateListDrawable mHorizontalThumbDrawable;
    private final int mHorizontalThumbHeight;
    int mHorizontalThumbWidth;
    private final Drawable mHorizontalTrackDrawable;
    private final int mHorizontalTrackHeight;
    private final int mMargin;
    private boolean mNeedHorizontalScrollbar;
    private boolean mNeedVerticalScrollbar;
    private final RecyclerView.OnScrollListener mOnScrollListener;
    private RecyclerView mRecyclerView;
    private int mRecyclerViewHeight;
    private int mRecyclerViewWidth;
    private final int mScrollbarMinimumRange;
    final ValueAnimator mShowHideAnimator;
    private int mState;
    float mVerticalDragY;
    private final int[] mVerticalRange;
    int mVerticalThumbCenterY;
    final StateListDrawable mVerticalThumbDrawable;
    int mVerticalThumbHeight;
    private final int mVerticalThumbWidth;
    final Drawable mVerticalTrackDrawable;
    private final int mVerticalTrackWidth;

    private class AnimatorListener extends AnimatorListenerAdapter {
        private boolean mCanceled;
        final /* synthetic */ FastScroller this$0;

        AnimatorListener(FastScroller r1) {
            this.this$0 = r1;
            this.mCanceled = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r3) {
            if (this.mCanceled == false) goto L7;
            this.mCanceled = false;
            return;
        L7:
            if (((Float) this.this$0.mShowHideAnimator.getAnimatedValue()).floatValue() != 0.0f) goto L9;
            this.this$0.mAnimationState = 0;
            this.this$0.setState(0);
            return;
        L9:
            this.this$0.mAnimationState = 2;
            this.this$0.requestRedraw();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r1) {
            this.mCanceled = true;
        }
    }

    private class AnimatorUpdater implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ FastScroller this$0;

        AnimatorUpdater(FastScroller r1) {
            this.this$0 = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator r2) {
            int r3 = (int) (((Float) r2.getAnimatedValue()).floatValue() * 255.0f);
            this.this$0.mVerticalThumbDrawable.setAlpha(r3);
            this.this$0.mVerticalTrackDrawable.setAlpha(r3);
            this.this$0.requestRedraw();
        }
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean r1) {
    }

    static {
        PRESSED_STATE_SET = new int[]{R.attr.state_pressed};
        EMPTY_STATE_SET = new int[0];
    }

    FastScroller(RecyclerView r4, StateListDrawable r5, Drawable r6, StateListDrawable r7, Drawable r8, int r9, int r10, int r11) {
        this.mRecyclerViewWidth = 0;
        this.mRecyclerViewHeight = 0;
        this.mNeedVerticalScrollbar = false;
        this.mNeedHorizontalScrollbar = false;
        this.mState = 0;
        this.mDragState = 0;
        this.mVerticalRange = new int[2];
        this.mHorizontalRange = new int[2];
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.mShowHideAnimator = r1;
        this.mAnimationState = 0;
        this.mHideRunnable = new AnonymousClass1(this);
        this.mOnScrollListener = new AnonymousClass2(this);
        this.mVerticalThumbDrawable = r5;
        this.mVerticalTrackDrawable = r6;
        this.mHorizontalThumbDrawable = r7;
        this.mHorizontalTrackDrawable = r8;
        this.mVerticalThumbWidth = Math.max(r9, r5.getIntrinsicWidth());
        this.mVerticalTrackWidth = Math.max(r9, r6.getIntrinsicWidth());
        this.mHorizontalThumbHeight = Math.max(r9, r7.getIntrinsicWidth());
        this.mHorizontalTrackHeight = Math.max(r9, r8.getIntrinsicWidth());
        this.mScrollbarMinimumRange = r10;
        this.mMargin = r11;
        r5.setAlpha(255);
        r6.setAlpha(255);
        r1.addListener(new AnimatorListener(this));
        r1.addUpdateListener(new AnimatorUpdater(this));
        attachToRecyclerView(r4);
    }

    public void attachToRecyclerView(RecyclerView r2) {
        RecyclerView r0 = this.mRecyclerView;
        if (r0 != r2) goto L5;
        return;
    L5:
        if (r0 == null) goto L7;
        destroyCallbacks();
    L7:
        this.mRecyclerView = r2;
        if (r2 == null) goto L11;
        setupCallbacks();
        return;
    }

    private void setupCallbacks() {
        this.mRecyclerView.addItemDecoration(this);
        this.mRecyclerView.addOnItemTouchListener(this);
        this.mRecyclerView.addOnScrollListener(this.mOnScrollListener);
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeItemDecoration(this);
        this.mRecyclerView.removeOnItemTouchListener(this);
        this.mRecyclerView.removeOnScrollListener(this.mOnScrollListener);
        cancelHide();
    }

    void requestRedraw() {
        this.mRecyclerView.invalidate();
    }

    void setState(int r4) {
        if (r4 == 2) goto L5;
    L7:
        if (r4 != 0) goto L9;
        requestRedraw();
    L11:
        if (this.mState != 2) goto L15;
        if (r4 == 2) goto L15;
        this.mVerticalThumbDrawable.setState(EMPTY_STATE_SET);
        resetHideDelay(HIDE_DELAY_AFTER_DRAGGING_MS);
    L17:
        this.mState = r4;
        return;
    L15:
        if (r4 != 1) goto L17;
        resetHideDelay(1500);
        goto L17
    L9:
        show();
        goto L11
    L5:
        if (this.mState == 2) goto L7;
        this.mVerticalThumbDrawable.setState(PRESSED_STATE_SET);
        cancelHide();
        goto L7
    }

    private boolean isLayoutRTL() {
        if (ViewCompat.getLayoutDirection(this.mRecyclerView) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isDragging() {
        if (this.mState != 2) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isVisible() {
        if (this.mState == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public void show() {
        int r0 = this.mAnimationState;
        if (r0 != 0) goto L5;
    L8:
        this.mAnimationState = 1;
        ValueAnimator r1 = this.mShowHideAnimator;
        r1.setFloatValues(new float[]{((Float) r1.getAnimatedValue()).floatValue(), 1.0f});
        this.mShowHideAnimator.setDuration(500);
        this.mShowHideAnimator.setStartDelay(0);
        this.mShowHideAnimator.start();
        return;
    L5:
        if (r0 != 3) goto L10;
        this.mShowHideAnimator.cancel();
        goto L8
    }

    void hide(int r6) {
        int r0 = this.mAnimationState;
        if (r0 == 1) goto L6;
        if (r0 != 2) goto L9;
    L7:
        this.mAnimationState = 3;
        ValueAnimator r1 = this.mShowHideAnimator;
        r1.setFloatValues(new float[]{((Float) r1.getAnimatedValue()).floatValue(), 0.0f});
        this.mShowHideAnimator.setDuration(r6);
        this.mShowHideAnimator.start();
        return;
    L9:
        return;
    L6:
        this.mShowHideAnimator.cancel();
        goto L7
    }

    private void cancelHide() {
        this.mRecyclerView.removeCallbacks(this.mHideRunnable);
    }

    private void resetHideDelay(int r4) {
        cancelHide();
        this.mRecyclerView.postDelayed(this.mHideRunnable, r4);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas r1, RecyclerView r2, RecyclerView.State r3) {
        if (this.mRecyclerViewWidth == this.mRecyclerView.getWidth()) goto L5;
    L16:
        this.mRecyclerViewWidth = this.mRecyclerView.getWidth();
        this.mRecyclerViewHeight = this.mRecyclerView.getHeight();
        setState(0);
        return;
    L5:
        if (this.mRecyclerViewHeight != this.mRecyclerView.getHeight()) goto L16;
        if (this.mAnimationState != 0) goto L10;
        return;
    L10:
        if (this.mNeedVerticalScrollbar == false) goto L13;
        drawVerticalScrollbar(r1);
    L13:
        if (this.mNeedHorizontalScrollbar == false) goto L19;
        drawHorizontalScrollbar(r1);
        return;
    }

    private void drawVerticalScrollbar(Canvas r7) {
        int r0 = this.mRecyclerViewWidth;
        int r1 = this.mVerticalThumbWidth;
        int r2 = r0 - r1;
        int r3 = this.mVerticalThumbCenterY;
        int r4 = this.mVerticalThumbHeight;
        int r5 = r3 - (r4 / 2);
        this.mVerticalThumbDrawable.setBounds(0, 0, r1, r4);
        this.mVerticalTrackDrawable.setBounds(0, 0, this.mVerticalTrackWidth, this.mRecyclerViewHeight);
        if (isLayoutRTL() == false) goto L5;
        this.mVerticalTrackDrawable.draw(r7);
        r7.translate(this.mVerticalThumbWidth, r5);
        r7.scale(-1.0f, 1.0f);
        this.mVerticalThumbDrawable.draw(r7);
        r7.scale(-1.0f, 1.0f);
        r7.translate(-this.mVerticalThumbWidth, -r5);
        return;
    L5:
        r7.translate(r2, 0.0f);
        this.mVerticalTrackDrawable.draw(r7);
        r7.translate(0.0f, r5);
        this.mVerticalThumbDrawable.draw(r7);
        r7.translate(-r2, -r5);
    }

    private void drawHorizontalScrollbar(Canvas r7) {
        int r0 = this.mRecyclerViewHeight;
        int r1 = this.mHorizontalThumbHeight;
        int r2 = r0 - r1;
        int r3 = this.mHorizontalThumbCenterX;
        int r4 = this.mHorizontalThumbWidth;
        int r5 = r3 - (r4 / 2);
        this.mHorizontalThumbDrawable.setBounds(0, 0, r4, r1);
        this.mHorizontalTrackDrawable.setBounds(0, 0, this.mRecyclerViewWidth, this.mHorizontalTrackHeight);
        r7.translate(0.0f, r2);
        this.mHorizontalTrackDrawable.draw(r7);
        r7.translate(r5, 0.0f);
        this.mHorizontalThumbDrawable.draw(r7);
        r7.translate(-r5, -r2);
    }

    void updateScrollPosition(int r9, int r10) {
        int r0 = this.mRecyclerView.computeVerticalScrollRange();
        int r1 = this.mRecyclerViewHeight;
        if ((r0 - r1) > 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        this.mNeedVerticalScrollbar = r2;
        int r3 = this.mRecyclerView.computeHorizontalScrollRange();
        int r5 = this.mRecyclerViewWidth;
        if ((r3 - r5) > 0) goto L11;
    L13:
        boolean r6 = false;
    L14:
        this.mNeedHorizontalScrollbar = r6;
        boolean r7 = this.mNeedVerticalScrollbar;
        if (r7 == true) goto L22;
        if (r6 == true) goto L22;
        if (this.mState == 0) goto L32;
        setState(0);
        return;
    L32:
        return;
    L22:
        if (r7 == false) goto L25;
        float r8 = r1;
        this.mVerticalThumbCenterY = (int) ((r8 * (r10 + (r8 / 2.0f))) / r0);
        this.mVerticalThumbHeight = Math.min(r1, (r1 * r1) / r0);
    L25:
        if (this.mNeedHorizontalScrollbar == false) goto L27;
        float r11 = r5;
        this.mHorizontalThumbCenterX = (int) ((r11 * (r9 + (r11 / 2.0f))) / r3);
        this.mHorizontalThumbWidth = Math.min(r5, (r5 * r5) / r3);
    L27:
        int r12 = this.mState;
        if (r12 == 0) goto L30;
        if (r12 == 1) goto L30;
        return;
    L30:
        setState(1);
        return;
    L11:
        if (r5 < this.mScrollbarMinimumRange) goto L13;
        r6 = true;
        goto L14
    L5:
        if (r1 < this.mScrollbarMinimumRange) goto L7;
        r2 = true;
        goto L8
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView r6, MotionEvent r7) {
        int r8 = this.mState;
        if (r8 != 1) goto L13;
        boolean r9 = isPointInsideVerticalThumb(r7.getX(), r7.getY());
        boolean r3 = isPointInsideHorizontalThumb(r7.getX(), r7.getY());
        if (r7.getAction() != 0) goto L16;
        if (r9 == true) goto L8;
        if (r3 == true) goto L8;
        return false;
    L8:
        if (r3 == false) goto L10;
        this.mDragState = 1;
        this.mHorizontalDragX = (int) r7.getX();
    L12:
        setState(2);
    L15:
        return true;
    L10:
        if (r9 == false) goto L12;
        this.mDragState = 2;
        this.mVerticalDragY = (int) r7.getY();
        goto L12
    L16:
        return false;
    L13:
        if (r8 == 2) goto L15;
        return false;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView r5, MotionEvent r6) {
        if (this.mState != 0) goto L6;
        return;
    L6:
        if (r6.getAction() != 0) goto L16;
        boolean r7 = isPointInsideVerticalThumb(r6.getX(), r6.getY());
        boolean r2 = isPointInsideHorizontalThumb(r6.getX(), r6.getY());
        if (r7 == true) goto L10;
        if (r2 == true) goto L10;
        return;
    L10:
        if (r2 == false) goto L12;
        this.mDragState = 1;
        this.mHorizontalDragX = (int) r6.getX();
    L14:
        setState(2);
        return;
    L12:
        if (r7 == false) goto L14;
        this.mDragState = 2;
        this.mVerticalDragY = (int) r6.getY();
        goto L14
    L16:
        if (r6.getAction() != 1) goto L21;
        if (this.mState != 2) goto L21;
        this.mVerticalDragY = 0.0f;
        this.mHorizontalDragX = 0.0f;
        setState(1);
        this.mDragState = 0;
        return;
    L21:
        if (r6.getAction() == 2) goto L23;
        return;
    L23:
        if (this.mState != 2) goto L35;
        show();
        if (this.mDragState != 1) goto L28;
        horizontalScrollTo(r6.getX());
    L28:
        if (this.mDragState != 2) goto L36;
        verticalScrollTo(r6.getY());
        return;
    L36:
        return;
    }

    private void verticalScrollTo(float r9) {
        int[] r3 = getVerticalRange();
        float r10 = Math.max(r3[0], Math.min(r3[1], r9));
        if (Math.abs(this.mVerticalThumbCenterY - r10) >= 2.0f) goto L5;
        return;
    L5:
        int r0 = scrollTo(this.mVerticalDragY, r10, r3, this.mRecyclerView.computeVerticalScrollRange(), this.mRecyclerView.computeVerticalScrollOffset(), this.mRecyclerViewHeight);
        if (r0 == 0) goto L8;
        this.mRecyclerView.scrollBy(0, r0);
    L8:
        this.mVerticalDragY = r10;
    }

    private void horizontalScrollTo(float r9) {
        int[] r3 = getHorizontalRange();
        float r10 = Math.max(r3[0], Math.min(r3[1], r9));
        if (Math.abs(this.mHorizontalThumbCenterX - r10) >= 2.0f) goto L5;
        return;
    L5:
        int r0 = scrollTo(this.mHorizontalDragX, r10, r3, this.mRecyclerView.computeHorizontalScrollRange(), this.mRecyclerView.computeHorizontalScrollOffset(), this.mRecyclerViewWidth);
        if (r0 == 0) goto L8;
        this.mRecyclerView.scrollBy(r0, 0);
    L8:
        this.mHorizontalDragX = r10;
    }

    private int scrollTo(float r2, float r3, int[] r4, int r5, int r6, int r7) {
        int r1 = r4[1] - r4[0];
        if (r1 != 0) goto L5;
        return 0;
    L5:
        int r8 = r5 - r7;
        int r9 = (int) (((r3 - r2) / r1) * r8);
        int r10 = r6 + r9;
        if (r10 >= r8) goto L9;
        if (r10 < 0) goto L9;
        return r9;
    L9:
        return 0;
    }

    boolean isPointInsideVerticalThumb(float r3, float r4) {
        if (isLayoutRTL() == false) goto L8;
        if (r3 <= this.mVerticalThumbWidth) goto L9;
    L14:
        return false;
    L9:
        int r5 = this.mVerticalThumbCenterY;
        int r2 = this.mVerticalThumbHeight;
        if (r4 < (r5 - (r2 / 2))) goto L14;
        if (r4 > (r5 + (r2 / 2))) goto L14;
        return true;
    L8:
        if (r3 < (this.mRecyclerViewWidth - this.mVerticalThumbWidth)) goto L14;
        goto L9
    }

    boolean isPointInsideHorizontalThumb(float r3, float r4) {
        if (r4 < (this.mRecyclerViewHeight - this.mHorizontalThumbHeight)) goto L9;
        int r5 = this.mHorizontalThumbCenterX;
        int r2 = this.mHorizontalThumbWidth;
        if (r3 < (r5 - (r2 / 2))) goto L9;
        if (r3 > (r5 + (r2 / 2))) goto L9;
        return true;
    L9:
        return false;
    }

    Drawable getHorizontalTrackDrawable() {
        return this.mHorizontalTrackDrawable;
    }

    Drawable getHorizontalThumbDrawable() {
        return this.mHorizontalThumbDrawable;
    }

    Drawable getVerticalTrackDrawable() {
        return this.mVerticalTrackDrawable;
    }

    Drawable getVerticalThumbDrawable() {
        return this.mVerticalThumbDrawable;
    }

    private int[] getVerticalRange() {
        int[] r0 = this.mVerticalRange;
        int r1 = this.mMargin;
        r0[0] = r1;
        r0[1] = this.mRecyclerViewHeight - r1;
        return r0;
    }

    private int[] getHorizontalRange() {
        int[] r0 = this.mHorizontalRange;
        int r1 = this.mMargin;
        r0[0] = r1;
        r0[1] = this.mRecyclerViewWidth - r1;
        return r0;
    }
}
