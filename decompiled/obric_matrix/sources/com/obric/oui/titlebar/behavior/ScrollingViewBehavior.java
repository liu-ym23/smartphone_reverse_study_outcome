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
import com.obric.common.oui.k;
import com.obric.oui.titlebar.OUnitedTitleBar;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 *2\u00020\u0001:\u0001\u001dB\t\b\u0016¢\u0006\u0004\b#\u0010$B\u001b\b\u0016\u0012\u0006\u0010&\u001a\u00020%\u0012\b\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b#\u0010)J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0007J'\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ'\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\rJ'\u0010\u000f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001aH\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u0002H\u0014¢\u0006\u0004\b!\u0010\"¨\u0006+"}, d2 = {"Lcom/obric/oui/titlebar/behavior/ScrollingViewBehavior;", "Lcom/obric/oui/titlebar/behavior/HeaderScrollingViewBehavior;", "Landroid/view/View;", "child", "dependency", "Lkotlin/f0;", "offsetChildAsNeeded", "(Landroid/view/View;Landroid/view/View;)V", "updateLiftedStateIfNeeded", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "parent", "", "layoutDependsOn", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;)Z", "onDependentViewChanged", "onDependentViewRemoved", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;)V", "Landroid/graphics/Rect;", "rectangle", "immediate", "onRequestChildRectangleOnScreen", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/graphics/Rect;Z)Z", "header", "", "getOverlapRatioForOffset", "(Landroid/view/View;)F", "", "views", "Lcom/obric/oui/titlebar/OUnitedTitleBar;", "a", "(Ljava/util/List;)Lcom/obric/oui/titlebar/OUnitedTitleBar;", BaseSwitches.V, "", "getScrollRange", "(Landroid/view/View;)I", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "h", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class ScrollingViewBehavior extends HeaderScrollingViewBehavior {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f11584h = null;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g r1) {
            this();
        }

        public static final /* synthetic */ int a(a r0, OUnitedTitleBar r1) {
            return r0.b(r1);
        }

        private final int b(OUnitedTitleBar r1) {
            ViewGroup.LayoutParams r0 = r1.getLayoutParams();
            Objects.requireNonNull(r0, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
            CoordinatorLayout.Behavior r2 = ((CoordinatorLayout.LayoutParams) r0).getBehavior();
            if ((r2 instanceof OUnitedTitleBar.Behavior) == true) goto L7;
            return 0;
        L7:
            return ((OUnitedTitleBar.Behavior) r2).getTopBottomOffsetForScrollingSibling();
        }
    }

    static {
        f11584h = new a(null);
    }

    public ScrollingViewBehavior() {
    }

    public ScrollingViewBehavior(Context r2, AttributeSet r3) {
        o.f(r2, "context");
        super(r2, r3);
        TypedArray r4 = r2.obtainStyledAttributes(r3, k.J2);
        o.e(r4, "context.obtainStyledAttr…llingViewBehavior_Layout)");
        setOverlayTop(r4.getDimensionPixelSize(k.K2, 0));
        r4.recycle();
    }

    private final void offsetChildAsNeeded(View r4, View r5) {
        ViewGroup.LayoutParams r0 = r5.getLayoutParams();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        CoordinatorLayout.Behavior r1 = ((CoordinatorLayout.LayoutParams) r0).getBehavior();
        if ((r1 instanceof BaseBehavior) == false) goto L6;
        ViewCompat.offsetTopAndBottom(r4, (((r5.getBottom() - r4.getTop()) + ((BaseBehavior) r1).f11547k) + getVerticalLayoutGap()) - getOverlapPixelsForOffset(r5));
        return;
    }

    private final void updateLiftedStateIfNeeded(View r1, View r2) {
        boolean r0 = r2 instanceof OUnitedTitleBar;
    }

    protected OUnitedTitleBar a(List<? extends View> r4) {
        o.f(r4, "views");
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
    public /* bridge */ /* synthetic */ View findFirstDependency(List r1) {
        return a(r1);
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderScrollingViewBehavior
    protected float getOverlapRatioForOffset(View r4) {
        o.f(r4, "header");
        if ((r4 instanceof OUnitedTitleBar) == false) goto L13;
        OUnitedTitleBar r5 = (OUnitedTitleBar) r4;
        int r3 = r5.getTotalScrollRange();
        int r1 = r5.getDownNestedPreScrollRange();
        int r6 = a.a(f11584h, r5);
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
    protected int getScrollRange(View r2) {
        o.f(r2, BaseSwitches.V);
        if ((r2 instanceof OUnitedTitleBar) == false) goto L6;
        return ((OUnitedTitleBar) r2).getTotalScrollRange();
    L6:
        return super.getScrollRange(r2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean layoutDependsOn(CoordinatorLayout r1, View r2, View r3) {
        o.f(r1, "parent");
        o.f(r2, "child");
        o.f(r3, "dependency");
        return r3 instanceof OUnitedTitleBar;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onDependentViewChanged(CoordinatorLayout r2, View r3, View r4) {
        o.f(r2, "parent");
        o.f(r3, "child");
        o.f(r4, "dependency");
        offsetChildAsNeeded(r3, r4);
        updateLiftedStateIfNeeded(r3, r4);
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDependentViewRemoved(CoordinatorLayout r1, View r2, View r3) {
        o.f(r1, "parent");
        o.f(r2, "child");
        o.f(r3, "dependency");
        if ((r3 instanceof OUnitedTitleBar) == false) goto L6;
        AccessibilityNodeInfoCompat.AccessibilityActionCompat r0 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD;
        o.e(r0, "AccessibilityNodeInfoCom…pat.ACTION_SCROLL_FORWARD");
        ViewCompat.removeAccessibilityAction(r1, r0.getId());
        AccessibilityNodeInfoCompat.AccessibilityActionCompat r4 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD;
        o.e(r4, "AccessibilityNodeInfoCom…at.ACTION_SCROLL_BACKWARD");
        ViewCompat.removeAccessibilityAction(r1, r4.getId());
        ViewCompat.setAccessibilityDelegate(r1, null);
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onRequestChildRectangleOnScreen(CoordinatorLayout r3, View r4, Rect r5, boolean r6) {
        o.f(r3, "parent");
        o.f(r4, "child");
        o.f(r5, "rectangle");
        List<View> r7 = r3.getDependencies(r4);
        o.e(r7, "parent.getDependencies(child)");
        OUnitedTitleBar r8 = a(r7);
        if (r8 == null) goto L8;
        Rect r1 = new Rect(r5);
        r1.offset(r4.getLeft(), r4.getTop());
        Rect r2 = this.f11580d;
        r2.set(0, 0, r3.getWidth(), r3.getHeight());
        if (r2.contains(r1) == true) goto L8;
        r8.setExpanded(false);
        return true;
    L8:
        return false;
    }
}
