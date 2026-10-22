package com.obric.oui.titlebar;

import a.a;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.apm.battery.config.BatteryDetectConfig;
import com.google.android.material.R;
import com.obric.oui.titlebar.behavior.BaseBehavior;
import com.obric.oui.titlebar.behavior.HeaderBehavior;
import d.b;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OUnitedTitleBar extends FrameLayout implements CoordinatorLayout.AttachedBehavior {
    public static final int s = 0;
    public static final int t = 0;
    public ViewGroup b;
    public ViewGroup c;
    public TextView e;
    public TextView f;
    public View i;
    public String j;
    public Drawable k;
    public Drawable l;
    public View m;
    public OnHeaderFlingUnConsumedListener n;
    public int o;
    public int p;
    public boolean q;
    public int r;

    @Metadata
    public static final class Behavior extends HeaderBehavior<OUnitedTitleBar> {
        public ValueAnimator j;
        public boolean k;
        public WeakReference l;
        public boolean m;
        public boolean n;
        public int o;
        public int p;
        public int q;

        public Behavior() {
        }

        public final void a(final CoordinatorLayout r6, final OUnitedTitleBar r7) {
            int r0 = getTopAndBottomOffset();
            Intrinsics.c(r7);
            int r1 = -OUnitedTitleBar.b(r7);
            if (r0 <= r1) goto L24;
            if (r0 < 0) goto L6;
            return;
        L6:
            if (r0 < (r1 / 2)) goto L9;
            r1 = 0;
        L9:
            int r2 = Math.abs(getTopAndBottomOffset() - r1);
            float r3 = Math.abs(0.0f);
            if (r3 <= 0) goto L12;
            int r4 = Math.round((r2 / r3) * 1000);
        L13:
            int r5 = getTopAndBottomOffset();
            if (r5 != r1) goto L18;
            ValueAnimator r8 = this.j;
            if (r8 == null) goto L18;
            r8.cancel();
        L18:
            ValueAnimator r9 = this.j;
            if (r9 != null) goto L21;
            ValueAnimator r10 = new ValueAnimator();
            this.j = r10;
            r10.setInterpolator(new AccelerateDecelerateInterpolator());
            ValueAnimator r11 = this.j;
            Intrinsics.c(r11);
            r11.addUpdateListener(new OUnitedTitleBar$Behavior$animateToOffset$1(this, r6, r7));
        L22:
            ValueAnimator r12 = this.j;
            Intrinsics.c(r12);
            r12.setDuration(r4);
            ValueAnimator r13 = this.j;
            Intrinsics.c(r13);
            r13.setIntValues(new int[]{r5, r1});
            ValueAnimator r14 = this.j;
            Intrinsics.c(r14);
            r14.start();
            return;
        L21:
            r9.cancel();
            goto L22
        L12:
            r4 = (int) (((r2 / r7.getHeight()) + 1) * 150);
            goto L13
        }

        public final boolean b(CoordinatorLayout r8, OUnitedTitleBar r9, int r10, float r11) {
            Intrinsics.f(r9, "layout");
            int r0 = 0;
            if (r11 >= 0) goto L6;
            this.n = true;
            this.o = 0;
            this.p = r10;
            this.q = 0;
            r10 = Integer.MIN_VALUE;
            r0 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        L6:
            return super.fling(r8, r9, r10, r0, r11);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public final boolean canDragView(View r4) {
            OUnitedTitleBar r5 = (OUnitedTitleBar) r4;
            WeakReference r0 = this.l;
            if (r0 == null) goto L15;
            View r1 = (View) r0.get();
            if (r1 != null) goto L7;
        L13:
            return false;
        L7:
            if (r1.isShown() == false) goto L13;
            if (ViewCompat.canScrollVertically(r1, -1) == true) goto L13;
            int r3 = getTopAndBottomOffset();
            Intrinsics.c(r5);
            if (r3 <= (-OUnitedTitleBar.a(r5))) goto L13;
            return true;
        L15:
            return true;
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public final /* bridge */ /* synthetic */ boolean fling(CoordinatorLayout r1, View r2, int r3, int r4, float r5) {
            return b(r1, (OUnitedTitleBar) r2, r3, r5);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public final int getMaxDragOffset(View r1) {
            OUnitedTitleBar r2 = (OUnitedTitleBar) r1;
            Intrinsics.f(r2, "view");
            return -OUnitedTitleBar.a(r2);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public final int getScrollRangeForDragFling(View r1) {
            OUnitedTitleBar r2 = (OUnitedTitleBar) r1;
            Intrinsics.f(r2, "view");
            return OUnitedTitleBar.a(r2);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public final void onFlingFinished(CoordinatorLayout r2, View r3) {
            this.n = false;
            a(r2, (OUnitedTitleBar) r3);
        }

        @Override // com.obric.oui.titlebar.behavior.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onLayoutChild(CoordinatorLayout r2, View r3, int r4) {
            OUnitedTitleBar r5 = (OUnitedTitleBar) r3;
            Intrinsics.f(r2, "parent");
            Intrinsics.f(r5, "child");
            super.onLayoutChild(r2, r5, r4);
            int r6 = r5.p;
            if (r6 != 0) goto L5;
            return true;
        L5:
            if ((r6 & 1) == 0) goto L8;
            setHeaderTopBottomOffset(r2, r5, -OUnitedTitleBar.a(r5));
            return true;
        L8:
            if ((r6 & 16) == 0) goto L14;
            setHeaderTopBottomOffset(r2, r5, 0);
            return true;
        L14:
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onNestedFling(CoordinatorLayout r1, View r2, View r3, float r4, float r5, boolean r6) {
            Intrinsics.f(r1, "coordinatorLayout");
            Intrinsics.f((OUnitedTitleBar) r2, "child");
            Intrinsics.f(r3, TypedValues.AttributesType.S_TARGET);
            this.m = true;
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onNestedPreFling(CoordinatorLayout r2, View r3, View r4, float r5, float r6) {
            OUnitedTitleBar r7 = (OUnitedTitleBar) r3;
            Intrinsics.f(r2, "coordinatorLayout");
            Intrinsics.f(r7, "child");
            Intrinsics.f(r4, TypedValues.AttributesType.S_TARGET);
            if (r6 > 0) goto L5;
            return false;
        L5:
            if (getTopAndBottomOffset() <= (-OUnitedTitleBar.a(r7))) goto L9;
            b(r2, r7, -OUnitedTitleBar.a(r7), -r6);
            this.m = true;
            return true;
        L9:
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void onNestedPreScroll(CoordinatorLayout r7, View r8, View r9, int r10, int r11, int[] r12) {
            OUnitedTitleBar r2 = (OUnitedTitleBar) r8;
            Intrinsics.f(r7, "coordinatorLayout");
            Intrinsics.f(r2, "child");
            Intrinsics.f(r9, TypedValues.AttributesType.S_TARGET);
            Intrinsics.f(r12, "consumed");
            if (r11 > 0) goto L5;
            return;
        L5:
            if (this.k == true) goto L9;
            int r4 = -OUnitedTitleBar.a(r2);
            r12[1] = setHeaderTopBottomOffset(r7, r2, getTopBottomOffsetForScrollingSibling() - r11, r4, 0);
            return;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void onNestedScroll(CoordinatorLayout r1, View r2, View r3, int r4, int r5, int r6, int r7) {
            OUnitedTitleBar r8 = (OUnitedTitleBar) r2;
            Intrinsics.f(r1, "coordinatorLayout");
            Intrinsics.f(r8, "child");
            Intrinsics.f(r3, TypedValues.AttributesType.S_TARGET);
            if (r7 >= 0) goto L5;
            int r9 = -OUnitedTitleBar.a(r8);
            setHeaderTopBottomOffset(r1, r8, getTopBottomOffsetForScrollingSibling() - r7, r9, 0);
            boolean r10 = true;
        L6:
            this.k = r10;
            return;
        L5:
            r10 = false;
            goto L6
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onStartNestedScroll(CoordinatorLayout r2, View r3, View r4, View r5, int r6) {
            OUnitedTitleBar r7 = (OUnitedTitleBar) r3;
            Intrinsics.f(r2, "coordinatorLayout");
            Intrinsics.f(r7, "child");
            Intrinsics.f(r4, "directTargetChild");
            Intrinsics.f(r5, TypedValues.AttributesType.S_TARGET);
            if ((r6 & 2) > 0) goto L5;
        L9:
            boolean r8 = false;
        L10:
            if (r8 == false) goto L14;
            ValueAnimator r9 = this.j;
            if (r9 == null) goto L14;
            r9.cancel();
        L14:
            this.l = null;
            this.m = false;
            this.n = false;
            OverScroller r1 = this.f306d;
            if (r1 == null) goto L17;
            r1.abortAnimation();
        L17:
            return r8;
        L5:
            if (OUnitedTitleBar.a(r7) <= 0) goto L9;
            if ((r2.getHeight() - r4.getHeight()) > r7.getHeight()) goto L9;
            r8 = true;
            goto L10
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void onStopNestedScroll(CoordinatorLayout r2, View r3, View r4) {
            OUnitedTitleBar r5 = (OUnitedTitleBar) r3;
            Intrinsics.f(r2, "coordinatorLayout");
            Intrinsics.f(r5, "child");
            Intrinsics.f(r4, TypedValues.AttributesType.S_TARGET);
            if (this.m == true) goto L5;
            a(r2, r5);
        L5:
            this.k = false;
            this.l = new WeakReference(r4);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public final int setHeaderTopBottomOffset(CoordinatorLayout r8, View r9, int r10, int r11, int r12) {
            OUnitedTitleBar r13 = (OUnitedTitleBar) r9;
            int r6 = getTopAndBottomOffset();
            if (this.n == false) goto L5;
            r11 = Math.max(this.p, r11);
            r12 = Math.min(this.q, r12);
        L5:
            int r14 = super.setHeaderTopBottomOffset(r8, r13, r10, r11, r12);
            int r15 = 0;
            if (this.n == false) goto L16;
            if (r13 == null) goto L9;
            OnHeaderFlingUnConsumedListener r16 = r13.getMOnHeaderFlingUnConsumedListener();
        L10:
            if (r16 == null) goto L16;
            if ((((r10 - r6) + r14) - this.o) == 0) goto L14;
            Intrinsics.c(r13);
            OnHeaderFlingUnConsumedListener r17 = r13.getMOnHeaderFlingUnConsumedListener();
            Intrinsics.c(r17);
            r15 = r17.a();
        L14:
            this.o += -r15;
            goto L16
        L9:
            r16 = null;
        L16:
            return r14 + r15;
        }

        public Behavior(@Nullable Context r1, @Nullable AttributeSet r2) {
            super(r1, r2);
        }
    }

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public interface OnHeaderFlingUnConsumedListener {
        int a();
    }

    @Metadata
    public interface OnOffsetChangeListener {
    }

    static {
        s = a.d("Resources.getSystem()", 1, 56);
        t = a.d("Resources.getSystem()", 1, BatteryDetectConfig.MAX_TOTAL_LOC_REQUEST_TIME_10_MINS_SECOND);
        b.b("Resources.getSystem()", 1, 12);
        b.b("Resources.getSystem()", 1, 92);
        b.b("Resources.getSystem()", 1, 17);
        b.b("Resources.getSystem()", 1, 14);
    }

    public static final /* synthetic */ int a(OUnitedTitleBar r0) {
        return r0.getScrollRange();
    }

    public static final /* synthetic */ int b(OUnitedTitleBar r0) {
        return r0.getSnapRange();
    }

    private final int getScrollRange() {
        return t - s;
    }

    private final int getSnapRange() {
        return a.d("Resources.getSystem()", 1, 56);
    }

    public final BaseBehavior.LayoutParams c(AttributeSet r4) {
        Context r3 = getContext();
        BaseBehavior.LayoutParams r0 = new BaseBehavior.LayoutParams(r3, r4);
        r0.f305a = 1;
        TypedArray r5 = r3.obtainStyledAttributes(r4, R.styleable.AppBarLayout_Layout);
        r0.f305a = r5.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
        r0.b = null;
        if (r5.hasValue(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator) == false) goto L5;
        AnimationUtils.loadInterpolator(r3, r5.getResourceId(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
    L5:
        r5.recycle();
        return r0;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return c(r1);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NotNull
    public CoordinatorLayout.Behavior<?> getBehavior() {
        return new BaseBehavior.Behavior();
    }

    @Nullable
    public final View getBottomAction() {
        return this.i;
    }

    @Nullable
    public final View getDivider() {
        return this.m;
    }

    public final int getDownNestedPreScrollRange() {
        return 0;
    }

    public final int getDownNestedScrollRange() {
        return getTotalScrollRange();
    }

    public final int getINVALID_SCROLL_RANGE() {
        return 0;
    }

    public final boolean getInDebug() {
        return this.q;
    }

    @Nullable
    public final ViewGroup getLeftAction() {
        return this.b;
    }

    @Nullable
    public final Drawable getLeftActionSrc() {
        return this.k;
    }

    public final int getMCollapsePosition() {
        return this.o;
    }

    @Nullable
    public final OnHeaderFlingUnConsumedListener getMOnHeaderFlingUnConsumedListener() {
        return this.n;
    }

    @Nullable
    public final TextView getMTvSubTitle() {
        return this.f;
    }

    @Nullable
    public final TextView getMTvTitle() {
        return this.e;
    }

    public final int getPendingAction() {
        return this.p;
    }

    @Nullable
    public final ViewGroup getRightAction() {
        return this.c;
    }

    @Nullable
    public final Drawable getRightActionSrc() {
        return this.l;
    }

    public final int getTextInitPos() {
        return this.r;
    }

    @Nullable
    public final String getTitleText() {
        return this.j;
    }

    public final int getTopInset() {
        return 0;
    }

    public final int getTotalScrollRange() {
        return t - s;
    }

    public final int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public final void setBottomAction(@Nullable View r1) {
        this.i = r1;
    }

    public final void setDivider(@Nullable View r1) {
        this.m = r1;
    }

    public final void setExpanded(boolean r1) {
        if (r1 == false) goto L4;
        int r2 = 16;
    L5:
        this.p = r2;
        requestLayout();
        return;
    L4:
        r2 = 1;
        goto L5
    }

    public final void setInDebug(boolean r1) {
        this.q = r1;
    }

    public final void setLeftAction(@Nullable ViewGroup r1) {
        this.b = r1;
    }

    public final void setLeftActionSrc(@Nullable Drawable r1) {
        this.k = r1;
    }

    public final void setMCollapsePosition(int r1) {
        this.o = r1;
    }

    public final void setMOnHeaderFlingUnConsumedListener(@Nullable OnHeaderFlingUnConsumedListener r1) {
        this.n = r1;
    }

    public final void setMTvSubTitle(@Nullable TextView r1) {
        this.f = r1;
    }

    public final void setMTvTitle(@Nullable TextView r1) {
        this.e = r1;
    }

    public final void setOnHeaderFlingUnConsumedListener(@NotNull OnHeaderFlingUnConsumedListener r2) {
        Intrinsics.f(r2, "onHeaderFlingUnConsumedListener");
        this.n = r2;
    }

    public final void setRightAction(@Nullable ViewGroup r1) {
        this.c = r1;
    }

    public final void setRightActionSrc(@Nullable Drawable r1) {
        this.l = r1;
    }

    public final void setTextInitPos(int r1) {
        this.r = r1;
    }

    public final void setTitleText(@Nullable String r1) {
        this.j = r1;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ FrameLayout.LayoutParams generateLayoutParams(AttributeSet r1) {
        return c(r1);
    }

    public final void setLeftAction(@NotNull View r2) {
        Intrinsics.f(r2, "view");
        ViewGroup r0 = this.b;
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        ViewGroup r1 = this.b;
        if (r1 == null) goto L9;
        r1.addView(r2);
        return;
    }

    public final void setRightAction(@NotNull View r2) {
        Intrinsics.f(r2, "view");
        ViewGroup r0 = this.c;
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        ViewGroup r1 = this.c;
        if (r1 == null) goto L9;
        r1.addView(r2);
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        BaseBehavior.LayoutParams r0 = new BaseBehavior.LayoutParams(r1);
        r0.f305a = 1;
        return r0;
    }
}
