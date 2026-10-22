package com.obric.oui.panel;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes3.dex */
public class BottomSheetRLDragHelper {
    private static final int BASE_SETTLE_DURATION = 256;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final float RL_SLIDE_LEVEL = 1.2f;
    private static final Interpolator sInterpolator = null;
    private int activePointerId;
    private int initialX;
    private int initialY;
    private boolean isPortraitRLSliding;
    private boolean isSettling;
    private int lastX;
    private final ViewDragHelper.Callback mCallback;
    private final float mMaxVelocity;
    private final float mMinVelocity;
    private final ViewGroup mParentView;
    private final OverScroller mScroller;
    private final Runnable mSetIdleRunnable;
    private final float mTouchSlop;
    private int rlSlideDirection;

    static /* synthetic */ Runnable access$000(BottomSheetRLDragHelper r0) {
        return r0.mSetIdleRunnable;
    }

    static /* synthetic */ ViewGroup access$100(BottomSheetRLDragHelper r0) {
        return r0.mParentView;
    }

    static /* synthetic */ boolean access$202(BottomSheetRLDragHelper r0, boolean r1) {
        r0.isSettling = r1;
        return r1;
    }

    static {
        sInterpolator = new AnonymousClass1();
    }

    public BottomSheetRLDragHelper(Context r3, ViewGroup r4, ViewDragHelper.Callback r5) {
        this.isSettling = false;
        this.mSetIdleRunnable = new AnonymousClass2(this);
        this.mScroller = new OverScroller(r3, sInterpolator);
        this.mParentView = r4;
        this.mCallback = r5;
        ViewConfiguration r6 = ViewConfiguration.get(r3);
        this.mTouchSlop = r6.getScaledTouchSlop();
        this.mMaxVelocity = r6.getScaledMaximumFlingVelocity();
        this.mMinVelocity = r6.getScaledMinimumFlingVelocity();
    }

    public boolean shouInterceptRLSlideMotionEvent(View r6, MotionEvent r7) {
        this.lastX = (int) r7.getX();
        boolean r0 = false;
        this.isPortraitRLSliding = false;
        int r1 = r7.getActionMasked();
        if (r1 != 0) goto L5;
        this.initialX = (int) r7.getX();
        this.initialY = (int) r7.getY();
    L5:
        int r2 = ((int) r7.getX()) - this.initialX;
        int r8 = ((int) r7.getY()) - this.initialY;
        if (r1 == 2) goto L8;
    L12:
        if (r0 == false) goto L17;
        if (r2 <= 0) goto L15;
        int r9 = 1;
    L16:
        this.rlSlideDirection = r9;
        this.mCallback.onViewDragStateChanged(1);
        this.isPortraitRLSliding = true;
        goto L17
    L15:
        r9 = -1;
    L17:
        return r0;
    L8:
        if (isPortraitRLSliding(r2, r8) == false) goto L12;
        if (findCanScrollView(r6) != null) goto L12;
        r0 = true;
        goto L12
    }

    public boolean isPortraitRLSliding() {
        return this.isPortraitRLSliding;
    }

    public void processRLSlideTouchEvent(MotionEvent r9, View r10, int r11, VelocityTracker r12) {
        int r0 = r9.getActionMasked();
        if (r0 != 2) goto L6;
        int r13 = (int) r9.getX();
        int r1 = r13 - this.lastX;
        this.lastX = r13;
        int r7 = (int) ((r1 * (r10.getHeight() / r10.getWidth())) * 1.2f);
        dragTo(r10, r10.getLeft(), r10.getTop() + r7, 0, r7);
    L6:
        if (r0 != 1) goto L10;
        if (r11 != 1) goto L10;
        rlSlideReleaseInternal(r10, r12);
    L10:
        if (r0 != 3) goto L14;
        if (r11 != 1) goto L15;
        this.mCallback.onViewReleased(r10, 0.0f, 0.0f);
        return;
    L15:
        return;
    }

    private boolean isPortraitRLSliding(float r2, float r3) {
        if (Math.abs(r2) > this.mTouchSlop) goto L5;
    L7:
        return false;
    L5:
        if ((Math.abs(r2) * 0.5f) <= Math.abs(r3)) goto L7;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View findCanScrollView(View r5) {
        if (r5 != 0) goto L6;
        return null;
    L6:
        if (r5.canScrollHorizontally(-this.rlSlideDirection) == false) goto L8;
    L21:
        return r5;
    L8:
        if ((r5 instanceof IRLSlideView) == false) goto L13;
        if (((IRLSlideView) r5).canSlide(-this.rlSlideDirection) == true) goto L21;
    L13:
        if ((r5 instanceof ViewGroup) == false) goto L20;
        ViewGroup r6 = (ViewGroup) r5;
        int r1 = r6.getChildCount();
        int r2 = 0;
    L15:
        if (r2 >= r1) goto L20;
        View r3 = findCanScrollView(r6.getChildAt(r2));
        if (r3 != null) goto L18;
        r2 = r2 + 1;
        goto L15
    L18:
        return r3;
    L20:
        return null;
    }

    public void dragTo(View r10, int r11, int r12, int r13, int r14) {
        int r0 = r10.getLeft();
        int r1 = r10.getTop();
        if (r13 == 0) goto L5;
        r11 = this.mCallback.clampViewPositionHorizontal(r10, r11, r13);
        ViewCompat.offsetLeftAndRight(r10, r11 - r0);
    L5:
        int r5 = r11;
        if (r14 == 0) goto L8;
        r12 = this.mCallback.clampViewPositionVertical(r10, r12, r14);
        ViewCompat.offsetTopAndBottom(r10, r12 - r1);
    L8:
        int r6 = r12;
        if (r13 != 0) goto L11;
        if (r14 != 0) goto L11;
        return;
    L11:
        ViewDragHelper.Callback r3 = this.mCallback;
        r3.onViewPositionChanged(r10, r5, r6, r5 - r0, r6 - r1);
    }

    public void rlSlideReleaseInternal(View r3, VelocityTracker r4) {
        r4.computeCurrentVelocity(1000, this.mMaxVelocity);
        float r5 = clampMag(getXVelocity(r4), this.mMinVelocity, this.mMaxVelocity);
        this.mCallback.onViewReleased(r3, 0.0f, r5);
    }

    private float getXVelocity(VelocityTracker r3) {
        if (r3 != null) goto L5;
        return 0.0f;
    L5:
        r3.computeCurrentVelocity(1000, this.mMaxVelocity);
        return r3.getXVelocity(this.activePointerId);
    }

    public boolean settleCapturedViewAt(View r1, int r2, int r3, int r4, int r5) {
        return forceSettleCapturedViewAt(r1, r2, r3, r4, r5);
    }

    private boolean forceSettleCapturedViewAt(View r10, int r11, int r12, int r13, int r14) {
        int r1 = r10.getLeft();
        int r2 = r10.getTop();
        int r15 = r11 - r1;
        int r16 = r12 - r2;
        if (r15 != 0) goto L7;
        if (r16 != 0) goto L7;
        this.mScroller.abortAnimation();
        return false;
    L7:
        int r5 = computeSettleDuration(r10, r15, r16, r13, r14);
        this.mScroller.startScroll(r1, r2, r15, r16, r5);
        this.isSettling = true;
        return true;
    }

    private int computeSettleDuration(View r7, int r8, int r9, int r10, int r11) {
        int r12 = clampMag(r10, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int r13 = clampMag(r11, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int r0 = Math.abs(r8);
        int r1 = Math.abs(r9);
        int r2 = Math.abs(r12);
        int r3 = Math.abs(r13);
        int r4 = r2 + r3;
        int r5 = r0 + r1;
        if (r12 == 0) goto L5;
        float r6 = r2;
        float r14 = r4;
    L6:
        float r15 = r6 / r14;
        if (r13 == 0) goto L9;
        float r16 = r3;
        float r17 = r4;
    L10:
        float r18 = r16 / r17;
        return (int) ((computeAxisDuration(r8, r12, this.mCallback.getViewHorizontalDragRange(r7)) * r15) + (computeAxisDuration(r9, r13, this.mCallback.getViewVerticalDragRange(r7)) * r18));
    L9:
        r16 = r1;
        r17 = r5;
        goto L10
    L5:
        r6 = r0;
        r14 = r5;
        goto L6
    }

    private int clampMag(int r1, int r2, int r3) {
        int r0 = Math.abs(r1);
        if (r0 >= r2) goto L6;
        return 0;
    L6:
        if (r0 <= r3) goto L11;
        if (r1 <= 0) goto L10;
        return r3;
    L10:
        return -r3;
    L11:
        return r1;
    }

    private float clampMag(float r2, float r3, float r4) {
        float r1 = Math.abs(r2);
        if (r1 >= r3) goto L6;
        return 0.0f;
    L6:
        if (r1 > r4) goto L8;
        return r2;
    L8:
        if (r2 <= 0.0f) goto L11;
        return r4;
    L11:
        return -r4;
    }

    private int computeAxisDuration(int r4, int r5, int r6) {
        if (r4 != 0) goto L5;
        return 0;
    L5:
        int r0 = this.mParentView.getWidth();
        float r1 = r0 / 2;
        float r2 = r1 + (distanceInfluenceForSnapDuration(Math.min(1.0f, Math.abs(r4) / r0)) * r1);
        int r3 = Math.abs(r5);
        if (r3 <= 0) goto L8;
        int r7 = Math.round(Math.abs(r2 / r3) * 1000.0f) * 4;
    L10:
        return Math.min(r7, 600);
    L8:
        r7 = (int) (((Math.abs(r4) / r6) + 1.0f) * 256.0f);
        goto L10
    }

    private float distanceInfluenceForSnapDuration(float r1) {
        return (float) Math.sin((r1 - 0.5f) * 0.47123894f);
    }

    public boolean continueSettling(View r10, boolean r11) {
        if (this.isSettling == false) goto L24;
        boolean r0 = this.mScroller.computeScrollOffset();
        int r1 = this.mScroller.getCurrX();
        int r8 = this.mScroller.getCurrY();
        int r6 = r1 - r10.getLeft();
        int r7 = r8 - r10.getTop();
        if (r6 == 0) goto L7;
        ViewCompat.offsetLeftAndRight(r10, r6);
    L7:
        if (r7 == 0) goto L9;
        ViewCompat.offsetTopAndBottom(r10, r7);
    L9:
        if (r6 != 0) goto L11;
        if (r7 != 0) goto L11;
    L13:
        if (r0 == true) goto L15;
    L19:
        if (r0 == true) goto L24;
        if (r11 == false) goto L22;
        this.mParentView.post(this.mSetIdleRunnable);
        goto L24
    L22:
        this.isSettling = false;
        goto L24
    L15:
        if (r1 != this.mScroller.getFinalX()) goto L19;
        if (r8 != this.mScroller.getFinalY()) goto L19;
        this.mScroller.abortAnimation();
        r0 = false;
    L11:
        this.mCallback.onViewPositionChanged(r10, r1, r8, r6, r7);
    L24:
        return this.isSettling;
    }
}
