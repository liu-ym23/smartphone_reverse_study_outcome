package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.badge.BadgeDrawable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {
    private int overlayTop;
    final Rect tempRect1;
    final Rect tempRect2;
    private int verticalLayoutGap;

    public HeaderScrollingViewBehavior() {
        this.tempRect1 = new Rect();
        this.tempRect2 = new Rect();
        this.verticalLayoutGap = 0;
    }

    private static int resolveGravity(int r0) {
        if (r0 != 0) goto L5;
        return BadgeDrawable.TOP_START;
    L5:
        return r0;
    }

    @Nullable
    public abstract View findFirstDependency(List<View> r1);

    public final int getOverlapPixelsForOffset(View r3) {
        if (this.overlayTop == 0) goto L7;
        float r4 = getOverlapRatioForOffset(r3);
        int r2 = this.overlayTop;
        return MathUtils.clamp((int) (r4 * r2), 0, r2);
    L7:
        return 0;
    }

    public float getOverlapRatioForOffset(View r1) {
        return 1.0f;
    }

    public final int getOverlayTop() {
        return this.overlayTop;
    }

    public int getScrollRange(@NonNull View r1) {
        return r1.getMeasuredHeight();
    }

    public final int getVerticalLayoutGap() {
        return this.verticalLayoutGap;
    }

    @Override // com.google.android.material.appbar.ViewOffsetBehavior
    public void layoutChild(@NonNull CoordinatorLayout r9, @NonNull View r10, int r11) {
        View r0 = findFirstDependency(r9.getDependencies(r10));
        if (r0 == null) goto L12;
        CoordinatorLayout.LayoutParams r1 = (CoordinatorLayout.LayoutParams) r10.getLayoutParams();
        Rect r5 = this.tempRect1;
        r5.set(r9.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r1).leftMargin, r0.getBottom() + ((ViewGroup.MarginLayoutParams) r1).topMargin, (r9.getWidth() - r9.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) r1).rightMargin, ((r0.getBottom() + r9.getHeight()) - r9.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) r1).bottomMargin);
        WindowInsetsCompat r2 = r9.getLastWindowInsets();
        if (r2 != null) goto L7;
    L11:
        Rect r12 = this.tempRect2;
        GravityCompat.apply(resolveGravity(r1.gravity), r10.getMeasuredWidth(), r10.getMeasuredHeight(), r5, r12, r11);
        int r13 = getOverlapPixelsForOffset(r0);
        r10.layout(r12.left, r12.top - r13, r12.right, r12.bottom - r13);
        this.verticalLayoutGap = r12.top - r0.getBottom();
        return;
    L7:
        if (ViewCompat.getFitsSystemWindows(r9) == false) goto L11;
        if (ViewCompat.getFitsSystemWindows(r10) == true) goto L11;
        r5.left = r2.getSystemWindowInsetLeft() + r5.left;
        r5.right -= r2.getSystemWindowInsetRight();
        goto L11
    L12:
        super.layoutChild(r9, r10, r11);
        this.verticalLayoutGap = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(@NonNull CoordinatorLayout r7, @NonNull View r8, int r9, int r10, int r11, int r12) {
        int r0 = r8.getLayoutParams().height;
        if (r0 != (-1)) goto L5;
    L6:
        View r2 = findFirstDependency(r7.getDependencies(r8));
        if (r2 == null) goto L27;
        int r13 = View.MeasureSpec.getSize(r11);
        if (r13 > 0) goto L11;
        r13 = r7.getHeight();
    L16:
        int r14 = r13 + getScrollRange(r2);
        int r3 = r2.getMeasuredHeight();
        if (shouldHeaderOverlapScrollingChild() == false) goto L19;
        r8.setTranslationY(-r3);
    L20:
        if (r0 != (-1)) goto L22;
        int r6 = BasicMeasure.EXACTLY;
    L23:
        r7.onMeasureChild(r8, r9, r10, View.MeasureSpec.makeMeasureSpec(r14, r6), r12);
        return true;
    L22:
        r6 = Integer.MIN_VALUE;
        goto L23
    L19:
        r14 = r14 - r3;
        goto L20
    L11:
        if (ViewCompat.getFitsSystemWindows(r2) == false) goto L16;
        WindowInsetsCompat r4 = r7.getLastWindowInsets();
        if (r4 == null) goto L16;
        r13 = r13 + (r4.getSystemWindowInsetBottom() + r4.getSystemWindowInsetTop());
        goto L16
    L27:
        return false;
    L5:
        if (r0 == (-2)) goto L6;
        return false;
    }

    public final void setOverlayTop(int r1) {
        this.overlayTop = r1;
    }

    public boolean shouldHeaderOverlapScrollingChild() {
        return false;
    }

    public HeaderScrollingViewBehavior(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.tempRect1 = new Rect();
        this.tempRect2 = new Rect();
        this.verticalLayoutGap = 0;
    }
}
