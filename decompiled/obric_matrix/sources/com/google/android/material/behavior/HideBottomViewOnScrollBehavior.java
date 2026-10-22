package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.animation.AnimationUtils;

/* JADX INFO: loaded from: classes2.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    protected static final int ENTER_ANIMATION_DURATION = 225;
    protected static final int EXIT_ANIMATION_DURATION = 175;
    private static final int STATE_SCROLLED_DOWN = 1;
    private static final int STATE_SCROLLED_UP = 2;
    private int additionalHiddenOffsetY;

    @Nullable
    private ViewPropertyAnimator currentAnimator;
    private int currentState;
    private int height;

    public HideBottomViewOnScrollBehavior() {
        this.height = 0;
        this.currentState = 2;
        this.additionalHiddenOffsetY = 0;
    }

    public HideBottomViewOnScrollBehavior(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.height = 0;
        this.currentState = 2;
        this.additionalHiddenOffsetY = 0;
    }

    static /* synthetic */ ViewPropertyAnimator access$002(HideBottomViewOnScrollBehavior r0, ViewPropertyAnimator r1) {
        r0.currentAnimator = r1;
        return r1;
    }

    private void animateChildTo(@NonNull V r1, int r2, long r3, TimeInterpolator r5) {
        this.currentAnimator = r1.animate().translationY(r2).setInterpolator(r5).setDuration(r3).setListener(new AnonymousClass1(this));
    }

    public boolean isScrolledDown() {
        if (this.currentState == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isScrolledUp() {
        if (this.currentState != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout r3, @NonNull V r4, int r5) {
        ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) r4.getLayoutParams();
        this.height = r4.getMeasuredHeight() + r0.bottomMargin;
        return super.onLayoutChild(r3, r4, r5);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout r1, @NonNull V r2, @NonNull View r3, int r4, int r5, int r6, int r7, int r8, @NonNull int[] r9) {
        if (r5 <= 0) goto L4;
        slideDown(r2);
        return;
    L4:
        if (r5 >= 0) goto L8;
        slideUp(r2);
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout r1, @NonNull V r2, @NonNull View r3, @NonNull View r4, int r5, int r6) {
        if (r5 != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public void setAdditionalHiddenOffsetY(@NonNull V r3, @Dimension int r4) {
        this.additionalHiddenOffsetY = r4;
        if (this.currentState != 1) goto L6;
        r3.setTranslationY(this.height + r4);
        return;
    }

    public void slideDown(@NonNull V r2) {
        slideDown(r2, true);
    }

    public void slideDown(@NonNull V r9, boolean r10) {
        if (isScrolledDown() == false) goto L5;
        return;
    L5:
        ViewPropertyAnimator r0 = this.currentAnimator;
        if (r0 == null) goto L8;
        r0.cancel();
        r9.clearAnimation();
    L8:
        this.currentState = 1;
        int r4 = this.height + this.additionalHiddenOffsetY;
        if (r10 == false) goto L11;
        animateChildTo(r9, r4, 175, AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
        return;
    L11:
        r9.setTranslationY(r4);
    }

    public void slideUp(@NonNull V r2) {
        slideUp(r2, true);
    }

    public void slideUp(@NonNull V r8, boolean r9) {
        if (isScrolledUp() == false) goto L5;
        return;
    L5:
        ViewPropertyAnimator r0 = this.currentAnimator;
        if (r0 == null) goto L8;
        r0.cancel();
        r8.clearAnimation();
    L8:
        this.currentState = 2;
        if (r9 == false) goto L11;
        animateChildTo(r8, 0, 225, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        return;
    L11:
        r8.setTranslationY(0);
    }
}
