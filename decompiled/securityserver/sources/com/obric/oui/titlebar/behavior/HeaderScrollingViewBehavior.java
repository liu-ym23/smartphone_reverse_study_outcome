package com.obric.oui.titlebar.behavior;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.badge.BadgeDrawable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {
    public final Rect c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f307d;
    public int e;
    public int f;

    public HeaderScrollingViewBehavior() {
        this.c = new Rect();
        this.f307d = new Rect();
        this.e = 0;
    }

    public abstract View findFirstDependency(List r1);

    public float getOverlapRatioForOffset(View r1) {
        return 1.0f;
    }

    public int getScrollRange(View r1) {
        return r1.getMeasuredHeight();
    }

    @Override // com.obric.oui.titlebar.behavior.ViewOffsetBehavior
    public final void layoutChild(CoordinatorLayout r16, View r17, int r18) {
        View r1 = findFirstDependency(r16.getDependencies(r17));
        int r2 = 0;
        if (r1 == null) goto L19;
        CoordinatorLayout.LayoutParams r3 = (CoordinatorLayout.LayoutParams) r17.getLayoutParams();
        int r4 = r16.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r3).leftMargin;
        int r5 = r1.getBottom() + ((ViewGroup.MarginLayoutParams) r3).topMargin;
        int r6 = (r16.getWidth() - r16.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) r3).rightMargin;
        int r8 = ((r1.getBottom() + r16.getHeight()) - r16.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) r3).bottomMargin;
        Rect r12 = this.c;
        r12.set(r4, r5, r6, r8);
        WindowInsetsCompat r7 = r16.getLastWindowInsets();
        if (r7 != null) goto L7;
    L11:
        int r9 = r3.gravity;
        if (r9 != 0) goto L14;
        r9 = BadgeDrawable.TOP_START;
    L14:
        int r10 = r9;
        int r11 = r17.getMeasuredWidth();
        int r13 = r17.getMeasuredHeight();
        Rect r14 = this.f307d;
        GravityCompat.apply(r10, r11, r13, r12, r14, r18);
        if (this.f == 0) goto L18;
        float r15 = getOverlapRatioForOffset(r1);
        int r19 = this.f;
        r2 = MathUtils.clamp((int) (r15 * r19), 0, r19);
    L18:
        r17.layout(r14.left, r14.top - r2, r14.right, r14.bottom - r2);
        this.e = r14.top - r1.getBottom();
        return;
    L7:
        if (ViewCompat.getFitsSystemWindows(r16) == false) goto L11;
        if (ViewCompat.getFitsSystemWindows(r17) == true) goto L11;
        r12.left = r7.getSystemWindowInsetLeft() + r12.left;
        r12.right -= r7.getSystemWindowInsetRight();
        goto L11
    L19:
        r16.onLayoutChild(r17, r18);
        this.e = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onMeasureChild(CoordinatorLayout r7, View r8, int r9, int r10, int r11, int r12) {
        int r0 = r8.getLayoutParams().height;
        if (r0 != (-1)) goto L5;
    L6:
        View r2 = findFirstDependency(r7.getDependencies(r8));
        if (r2 == null) goto L24;
        int r13 = View.MeasureSpec.getSize(r11);
        if (r13 > 0) goto L11;
        r13 = r7.getHeight();
    L16:
        int r6 = getScrollRange(r2) + r13;
        int r14 = r2.getMeasuredHeight();
        r8.setTranslationY(0.0f);
        int r15 = r6 - r14;
        if (r0 != (-1)) goto L19;
        int r16 = BasicMeasure.EXACTLY;
    L20:
        r7.onMeasureChild(r8, r9, r10, View.MeasureSpec.makeMeasureSpec(r15, r16), r12);
        return true;
    L19:
        r16 = Integer.MIN_VALUE;
        goto L20
    L11:
        if (ViewCompat.getFitsSystemWindows(r2) == false) goto L16;
        WindowInsetsCompat r3 = r7.getLastWindowInsets();
        if (r3 == null) goto L16;
        int r4 = r3.getSystemWindowInsetTop();
        r13 = r13 + (r3.getSystemWindowInsetBottom() + r4);
        goto L16
    L24:
        return false;
    L5:
        if (r0 == (-2)) goto L6;
        return false;
    }

    public HeaderScrollingViewBehavior(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.c = new Rect();
        this.f307d = new Rect();
        this.e = 0;
    }
}
