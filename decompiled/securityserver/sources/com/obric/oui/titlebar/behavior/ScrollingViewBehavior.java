package com.obric.oui.titlebar.behavior;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.obric.common.oui.R;
import com.obric.oui.titlebar.OUnitedTitleBar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ScrollingViewBehavior extends HeaderScrollingViewBehavior {

    @Metadata
    public static final class Companion {
    }

    public ScrollingViewBehavior() {
    }

    public static OUnitedTitleBar a(List r4) {
        Intrinsics.f(r4, "views");
        int r0 = r4.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        View r2 = (View) r4.get(r1);
        if ((r2 instanceof OUnitedTitleBar) == true) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return (OUnitedTitleBar) r2;
    L9:
        return null;
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderScrollingViewBehavior
    public final /* bridge */ /* synthetic */ View findFirstDependency(List r1) {
        return a(r1);
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderScrollingViewBehavior
    public final float getOverlapRatioForOffset(View r4) {
        Intrinsics.f(r4, "header");
        if ((r4 instanceof OUnitedTitleBar) == false) goto L20;
        OUnitedTitleBar r5 = (OUnitedTitleBar) r4;
        int r3 = r5.getTotalScrollRange();
        int r1 = r5.getDownNestedPreScrollRange();
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L19;
        CoordinatorLayout.Behavior r7 = ((CoordinatorLayout.LayoutParams) r6).getBehavior();
        if ((r7 instanceof OUnitedTitleBar.Behavior) == false) goto L9;
        int r8 = ((OUnitedTitleBar.Behavior) r7).getTopAndBottomOffset();
    L10:
        if (r1 != 0) goto L12;
    L14:
        int r9 = r3 - r1;
        if (r9 == 0) goto L20;
        return (r8 / r9) + 1.0f;
    L12:
        if ((r3 + r8) > r1) goto L14;
        return 0.0f;
    L9:
        r8 = 0;
        goto L10
    L19:
        throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
    L20:
        return 0.0f;
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderScrollingViewBehavior
    public final int getScrollRange(View r1) {
        if ((r1 instanceof OUnitedTitleBar) == false) goto L6;
        return ((OUnitedTitleBar) r1).getTotalScrollRange();
    L6:
        return r1.getMeasuredHeight();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean layoutDependsOn(CoordinatorLayout r1, View r2, View r3) {
        Intrinsics.f(r1, "parent");
        Intrinsics.f(r2, "child");
        Intrinsics.f(r3, "dependency");
        return r3 instanceof OUnitedTitleBar;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onDependentViewChanged(CoordinatorLayout r4, View r5, View r6) {
        Intrinsics.f(r4, "parent");
        Intrinsics.f(r5, "child");
        Intrinsics.f(r6, "dependency");
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 == null) goto L14;
        CoordinatorLayout.Behavior r8 = ((CoordinatorLayout.LayoutParams) r7).getBehavior();
        if ((r8 instanceof BaseBehavior) == false) goto L11;
        int r0 = r6.getBottom() - r5.getTop();
        ((BaseBehavior) r8).getClass();
        int r1 = r0 + this.e;
        if (this.f != 0) goto L9;
        int r3 = 0;
    L10:
        ViewCompat.offsetTopAndBottom(r5, r1 - r3);
        goto L11
    L9:
        float r9 = getOverlapRatioForOffset(r6);
        int r10 = this.f;
        r3 = MathUtils.clamp((int) (r9 * r10), 0, r10);
    L11:
        boolean r11 = r6 instanceof OUnitedTitleBar;
        return false;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onDependentViewRemoved(CoordinatorLayout r1, View r2, View r3) {
        Intrinsics.f(r1, "parent");
        Intrinsics.f(r2, "child");
        Intrinsics.f(r3, "dependency");
        if ((r3 instanceof OUnitedTitleBar) == false) goto L6;
        AccessibilityNodeInfoCompat.AccessibilityActionCompat r0 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD;
        Intrinsics.e(r0, "AccessibilityNodeInfoCom…pat.ACTION_SCROLL_FORWARD");
        ViewCompat.removeAccessibilityAction(r1, r0.getId());
        AccessibilityNodeInfoCompat.AccessibilityActionCompat r4 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD;
        Intrinsics.e(r4, "AccessibilityNodeInfoCom…at.ACTION_SCROLL_BACKWARD");
        ViewCompat.removeAccessibilityAction(r1, r4.getId());
        ViewCompat.setAccessibilityDelegate(r1, null);
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onRequestChildRectangleOnScreen(CoordinatorLayout r3, View r4, Rect r5, boolean r6) {
        Intrinsics.f(r3, "parent");
        Intrinsics.f(r4, "child");
        Intrinsics.f(r5, "rectangle");
        List<View> r7 = r3.getDependencies(r4);
        Intrinsics.e(r7, "parent.getDependencies(child)");
        OUnitedTitleBar r8 = a(r7);
        if (r8 == null) goto L8;
        Rect r1 = new Rect(r5);
        r1.offset(r4.getLeft(), r4.getTop());
        int r9 = r3.getWidth();
        int r10 = r3.getHeight();
        Rect r2 = this.c;
        r2.set(0, 0, r9, r10);
        if (r2.contains(r1) == true) goto L8;
        r8.setExpanded(false);
        return true;
    L8:
        return false;
    }

    public ScrollingViewBehavior(@NotNull Context r2, @Nullable AttributeSet r3) {
        Intrinsics.f(r2, "context");
        super(r2, r3);
        TypedArray r4 = r2.obtainStyledAttributes(r3, R.styleable.x);
        Intrinsics.e(r4, "context.obtainStyledAttr…llingViewBehavior_Layout)");
        this.f = r4.getDimensionPixelSize(0, 0);
        r4.recycle();
    }
}
