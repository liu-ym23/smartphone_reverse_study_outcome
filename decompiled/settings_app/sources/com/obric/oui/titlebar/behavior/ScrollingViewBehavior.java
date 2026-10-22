package com.obric.oui.titlebar.behavior;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.obric.common.oui.R;
import com.obric.oui.titlebar.OUnitedTitleBar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScorllingViewBehavior.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0014J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0014J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\fH\u0014J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0002J \u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0016J \u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0016J(\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0014H\u0016J\u0018\u0010!\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0002¨\u0006#"}, d2 = {"Lcom/obric/oui/titlebar/behavior/ScrollingViewBehavior;", "Lcom/obric/oui/titlebar/behavior/HeaderScrollingViewBehavior;", "()V", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "findFirstDependency", "Lcom/obric/oui/titlebar/OUnitedTitleBar;", "views", "", "Landroid/view/View;", "getOverlapRatioForOffset", "", "header", "getScrollRange", "", "v", "layoutDependsOn", "", "parent", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "child", "dependency", "offsetChildAsNeeded", "", "onDependentViewChanged", "onDependentViewRemoved", "onRequestChildRectangleOnScreen", "rectangle", "Landroid/graphics/Rect;", "immediate", "updateLiftedStateIfNeeded", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: ScorllingViewBehavior.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/titlebar/behavior/ScrollingViewBehavior$Companion;", "", "()V", "getOUnitedTitleBarOffset", "", "abl", "Lcom/obric/oui/titlebar/OUnitedTitleBar;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public static final /* synthetic */ int access$getOUnitedTitleBarOffset(Companion r0, OUnitedTitleBar r1) {
            return r0.getOUnitedTitleBarOffset(r1);
        }

        private final int getOUnitedTitleBarOffset(OUnitedTitleBar r1) {
            ViewGroup.LayoutParams r0 = r1.getLayoutParams();
            if (r0 == null) goto L10;
            CoordinatorLayout.Behavior r2 = ((CoordinatorLayout.LayoutParams) r0).getBehavior();
            if ((r2 instanceof OUnitedTitleBar.Behavior) == true) goto L11;
            return 0;
        L11:
            return ((OUnitedTitleBar.Behavior) r2).getTopBottomOffsetForScrollingSibling();
        L10:
            throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderScrollingViewBehavior
    public /* bridge */ /* synthetic */ View findFirstDependency(List r1) {
        return findFirstDependency(r1);
    }

    public ScrollingViewBehavior() {
    }

    public ScrollingViewBehavior(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        TypedArray r4 = r2.obtainStyledAttributes(r3, R.styleable.ScrollingViewBehavior_Layout);
        Intrinsics.checkNotNullExpressionValue(r4, "context.obtainStyledAttr…llingViewBehavior_Layout)");
        setOverlayTop(r4.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
        r4.recycle();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean layoutDependsOn(CoordinatorLayout r1, View r2, View r3) {
        Intrinsics.checkNotNullParameter(r1, "parent");
        Intrinsics.checkNotNullParameter(r2, "child");
        Intrinsics.checkNotNullParameter(r3, "dependency");
        return r3 instanceof OUnitedTitleBar;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onDependentViewChanged(CoordinatorLayout r2, View r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        Intrinsics.checkNotNullParameter(r3, "child");
        Intrinsics.checkNotNullParameter(r4, "dependency");
        offsetChildAsNeeded(r3, r4);
        updateLiftedStateIfNeeded(r3, r4);
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDependentViewRemoved(CoordinatorLayout r1, View r2, View r3) {
        Intrinsics.checkNotNullParameter(r1, "parent");
        Intrinsics.checkNotNullParameter(r2, "child");
        Intrinsics.checkNotNullParameter(r3, "dependency");
        if ((r3 instanceof OUnitedTitleBar) == false) goto L6;
        CoordinatorLayout r4 = r1;
        ViewCompat.removeAccessibilityAction(r4, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
        ViewCompat.removeAccessibilityAction(r4, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
        ViewCompat.setAccessibilityDelegate(r4, null);
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onRequestChildRectangleOnScreen(CoordinatorLayout r3, View r4, Rect r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        Intrinsics.checkNotNullParameter(r4, "child");
        Intrinsics.checkNotNullParameter(r5, "rectangle");
        List<View> r7 = r3.getDependencies(r4);
        Intrinsics.checkNotNullExpressionValue(r7, "parent.getDependencies(child)");
        OUnitedTitleBar r8 = findFirstDependency(r7);
        if (r8 == null) goto L8;
        Rect r1 = new Rect(r5);
        r1.offset(r4.getLeft(), r4.getTop());
        Rect r2 = this.tempRect1;
        r2.set(0, 0, r3.getWidth(), r3.getHeight());
        if (r2.contains(r1) == true) goto L8;
        r8.setExpanded(false);
        return true;
    L8:
        return false;
    }

    private final void offsetChildAsNeeded(View r4, View r5) {
        ViewGroup.LayoutParams r0 = r5.getLayoutParams();
        if (r0 == null) goto L9;
        CoordinatorLayout.Behavior r1 = ((CoordinatorLayout.LayoutParams) r0).getBehavior();
        if ((r1 instanceof BaseBehavior) == false) goto L10;
        ViewCompat.offsetTopAndBottom(r4, (((r5.getBottom() - r4.getTop()) + ((BaseBehavior) r1).offsetDelta) + getVerticalLayoutGap()) - getOverlapPixelsForOffset(r5));
        return;
    L10:
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderScrollingViewBehavior
    protected float getOverlapRatioForOffset(View r4) {
        Intrinsics.checkNotNullParameter(r4, "header");
        if ((r4 instanceof OUnitedTitleBar) == false) goto L13;
        OUnitedTitleBar r5 = (OUnitedTitleBar) r4;
        int r3 = r5.getTotalScrollRange();
        int r1 = r5.getDownNestedPreScrollRange();
        int r6 = Companion.access$getOUnitedTitleBarOffset(Companion, r5);
        if (r1 != 0) goto L7;
    L9:
        int r7 = r3 - r1;
        if (r7 == 0) goto L13;
        return (r6 / r7) + 1.0f;
    L7:
        if ((r3 + r6) > r1) goto L9;
        return 0.0f;
    L13:
        return 0.0f;
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderScrollingViewBehavior
    protected OUnitedTitleBar findFirstDependency(List<? extends View> r4) {
        Intrinsics.checkNotNullParameter(r4, "views");
        int r3 = r4.size();
        int r0 = 0;
    L3:
        if (r0 >= r3) goto L9;
        View r1 = r4.get(r0);
        if ((r1 instanceof OUnitedTitleBar) == true) goto L7;
        r0 = r0 + 1;
        goto L3
    L7:
        return (OUnitedTitleBar) r1;
    L9:
        return null;
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderScrollingViewBehavior
    protected int getScrollRange(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        if ((r2 instanceof OUnitedTitleBar) == false) goto L6;
        return ((OUnitedTitleBar) r2).getTotalScrollRange();
    L6:
        return super.getScrollRange(r2);
    }

    private final void updateLiftedStateIfNeeded(View r1, View r2) {
        boolean r0 = r2 instanceof OUnitedTitleBar;
    }
}
