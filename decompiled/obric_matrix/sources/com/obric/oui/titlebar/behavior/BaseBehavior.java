package com.obric.oui.titlebar.behavior;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.obric.oui.titlebar.OUnitedTitleBar;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BaseBehavior<T extends OUnitedTitleBar> extends HeaderBehavior<T> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f11547k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f11548l;
    private ValueAnimator m;
    private SavedState n;

    @Nullable
    private WeakReference<View> o;
    private e p;
    private boolean q;

    public static class Behavior extends BaseBehavior<OUnitedTitleBar> {
        public Behavior() {
        }

        public Behavior(Context r1, AttributeSet r2) {
            super(r1, r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ boolean canDragView(View r1) {
            return super.h((OUnitedTitleBar) r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ int getMaxDragOffset(@NonNull View r1) {
            return super.n((OUnitedTitleBar) r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ int getScrollRangeForDragFling(@NonNull View r1) {
            return super.o((OUnitedTitleBar) r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ void onFlingFinished(@NonNull CoordinatorLayout r1, @NonNull View r2) {
            super.q(r1, (OUnitedTitleBar) r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.a, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout r1, @NonNull View r2, int r3) {
            return super.r(r1, (OUnitedTitleBar) r2, r3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout r1, @NonNull View r2, int r3, int r4, int r5, int r6) {
            return super.s(r1, (OUnitedTitleBar) r2, r3, r4, r5, r6);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r1, @NonNull View r2, View r3, int r4, int r5, int[] r6, int r7) {
            super.t(r1, (OUnitedTitleBar) r2, r3, r4, r5, r6, r7);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout r1, @NonNull View r2, View r3, int r4, int r5, int r6, int r7, int r8) {
            super.u(r1, (OUnitedTitleBar) r2, r3, r4, r5, r6, r7, r8);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onRestoreInstanceState(@NonNull CoordinatorLayout r1, @NonNull View r2, Parcelable r3) {
            super.v(r1, (OUnitedTitleBar) r2, r3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(@NonNull CoordinatorLayout r1, @NonNull View r2) {
            return super.w(r1, (OUnitedTitleBar) r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(@NonNull CoordinatorLayout r1, @NonNull View r2, @NonNull View r3, View r4, int r5, int r6) {
            return super.x(r1, (OUnitedTitleBar) r2, r3, r4, r5, r6);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout r1, @NonNull View r2, View r3, int r4) {
            super.y(r1, (OUnitedTitleBar) r2, r3, r4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ int setHeaderTopBottomOffset(@NonNull CoordinatorLayout r1, @NonNull View r2, int r3, int r4, int r5) {
            return super.B(r1, (OUnitedTitleBar) r2, r3, r4, r5);
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f11549f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f11550g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f11551h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        float f11552i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f11553j;

        class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Nullable
            public SavedState a(@NonNull Parcel r2) {
                return new SavedState(r2, null);
            }

            @NonNull
            public SavedState b(@NonNull Parcel r1, ClassLoader r2) {
                return new SavedState(r1, r2);
            }

            @NonNull
            public SavedState[] c(int r1) {
                return new SavedState[r1];
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
            public /* bridge */ /* synthetic */ Object createFromParcel(@NonNull Parcel r1) {
                return a(r1);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            public /* bridge */ /* synthetic */ SavedState createFromParcel(@NonNull Parcel r1, ClassLoader r2) {
                return b(r1, r2);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public /* bridge */ /* synthetic */ Object[] newArray(int r1) {
                return c(r1);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(@NonNull Parcel r3, ClassLoader r4) {
            super(r3, r4);
            boolean r0 = true;
            if (r3.readByte() == 0) goto L5;
            boolean r5 = true;
        L6:
            this.f11549f = r5;
            if (r3.readByte() == 0) goto L9;
            boolean r6 = true;
        L10:
            this.f11550g = r6;
            this.f11551h = r3.readInt();
            this.f11552i = r3.readFloat();
            if (r3.readByte() != 0) goto L14;
            r0 = false;
        L14:
            this.f11553j = r0;
            return;
        L9:
            r6 = false;
            goto L10
        L5:
            r5 = false;
            goto L6
        }

        public SavedState(Parcelable r1) {
            super(r1);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeByte(this.f11549f ? 1 : 0);
            r1.writeByte(this.f11550g ? 1 : 0);
            r1.writeInt(this.f11551h);
            r1.writeFloat(this.f11552i);
            r1.writeByte(this.f11553j ? 1 : 0);
        }
    }

    class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CoordinatorLayout f11554a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OUnitedTitleBar f11555b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BaseBehavior f11556c;

        a(BaseBehavior r1, CoordinatorLayout r2, OUnitedTitleBar r3) {
            this.f11556c = r1;
            this.f11554a = r2;
            this.f11555b = r3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator r3) {
            this.f11556c.setHeaderTopBottomOffset(this.f11554a, this.f11555b, ((Integer) r3.getAnimatedValue()).intValue());
        }
    }

    class b extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseBehavior f11557a;

        b(BaseBehavior r1) {
            this.f11557a = r1;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r1, @NonNull AccessibilityNodeInfoCompat r2) {
            super.onInitializeAccessibilityNodeInfo(r1, r2);
            r2.setScrollable(BaseBehavior.b(this.f11557a));
            r2.setClassName(ScrollView.class.getName());
        }
    }

    class c implements AccessibilityViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CoordinatorLayout f11558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OUnitedTitleBar f11559b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f11560c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f11561d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ BaseBehavior f11562e;

        c(BaseBehavior r1, CoordinatorLayout r2, OUnitedTitleBar r3, View r4, int r5) {
            this.f11562e = r1;
            this.f11558a = r2;
            this.f11559b = r3;
            this.f11560c = r4;
            this.f11561d = r5;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // androidx.core.view.accessibility.AccessibilityViewCommand
        public boolean perform(@NonNull View r9, @Nullable AccessibilityViewCommand.CommandArguments r10) {
            this.f11562e.t(this.f11558a, this.f11559b, this.f11560c, 0, this.f11561d, new int[]{0, 0}, 1);
            return true;
        }
    }

    class d implements AccessibilityViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OUnitedTitleBar f11563a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f11564b;

        d(BaseBehavior r1, OUnitedTitleBar r2, boolean r3) {
            this.f11563a = r2;
            this.f11564b = r3;
        }

        @Override // androidx.core.view.accessibility.AccessibilityViewCommand
        public boolean perform(@NonNull View r1, @Nullable AccessibilityViewCommand.CommandArguments r2) {
            this.f11563a.setExpanded(this.f11564b);
            return true;
        }
    }

    public static abstract class e<T extends OUnitedTitleBar> {
        public abstract boolean a(@NonNull T r1);
    }

    public static abstract class f {
        public f() {
        }

        public abstract void a(@NonNull OUnitedTitleBar r1, @NonNull View r2, float r3);
    }

    public static class g extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Rect f11565a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Rect f11566b;

        public g() {
            this.f11565a = new Rect();
            this.f11566b = new Rect();
        }

        private static void b(Rect r0, OUnitedTitleBar r1, View r2) {
            r2.getDrawingRect(r0);
            r1.offsetDescendantRectToMyCoords(r2, r0);
            r0.offset(0, -r1.getTopInset());
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior.f
        public void a(@NonNull OUnitedTitleBar r4, @NonNull View r5, float r6) {
            b(this.f11565a, r4, r5);
            float r7 = this.f11565a.top - Math.abs(r6);
            if (r7 > 0.0f) goto L9;
            float r8 = 1.0f - MathUtils.clamp(Math.abs(r7 / this.f11565a.height()), 0.0f, 1.0f);
            float r9 = (-r7) - ((this.f11565a.height() * 0.3f) * (1.0f - (r8 * r8)));
            r5.setTranslationY(r9);
            r5.getDrawingRect(this.f11566b);
            this.f11566b.offset(0, (int) (-r9));
            if (r9 < this.f11566b.height()) goto L7;
            r5.setVisibility(4);
        L8:
            ViewCompat.setClipBounds(r5, this.f11566b);
            return;
        L7:
            r5.setVisibility(0);
            goto L8
        L9:
            ViewCompat.setClipBounds(r5, null);
            r5.setTranslationY(0.0f);
            r5.setVisibility(0);
        }
    }

    public static class h extends FrameLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11567a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private f f11568b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Interpolator f11569c;

        public h(Context r4, AttributeSet r5) {
            super(r4, r5);
            this.f11567a = 1;
            TypedArray r6 = r4.obtainStyledAttributes(r5, R.styleable.AppBarLayout_Layout);
            this.f11567a = r6.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            e(0);
            int r0 = R.styleable.AppBarLayout_Layout_layout_scrollInterpolator;
            if (r6.hasValue(r0) == false) goto L5;
            this.f11569c = AnimationUtils.loadInterpolator(r4, r6.getResourceId(r0, 0));
        L5:
            r6.recycle();
        }

        public h(ViewGroup.LayoutParams r1) {
            super(r1);
            this.f11567a = 1;
        }

        @Nullable
        private f a(int r1) {
            if (r1 == 1) goto L7;
            return null;
        L7:
            return new g();
        }

        @Nullable
        public f b() {
            return this.f11568b;
        }

        public int c() {
            return this.f11567a;
        }

        public Interpolator d() {
            return this.f11569c;
        }

        public void e(int r1) {
            this.f11568b = a(r1);
        }
    }

    public BaseBehavior() {
    }

    public BaseBehavior(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    private boolean C(@NonNull CoordinatorLayout r4, @NonNull T r5) {
        List<View> r3 = r4.getDependents(r5);
        int r6 = r3.size();
        int r0 = 0;
    L3:
        if (r0 >= r6) goto L11;
        CoordinatorLayout.Behavior r1 = ((CoordinatorLayout.LayoutParams) r3.get(r0).getLayoutParams()).getBehavior();
        if ((r1 instanceof ScrollingViewBehavior) == true) goto L7;
        r0 = r0 + 1;
        goto L3
    L7:
        if (((ScrollingViewBehavior) r1).getOverlayTop() == 0) goto L14;
        return true;
    L14:
        return false;
    L11:
        return false;
    }

    private void D(CoordinatorLayout r9, @NonNull T r10) {
        int r0 = r10.getTopInset() + r10.getPaddingTop();
        int r1 = getTopBottomOffsetForScrollingSibling() - r0;
        int r2 = l(r10, r1);
        if (r2 < 0) goto L27;
        View r3 = r10.getChildAt(r2);
        h r4 = (h) r3.getLayoutParams();
        int r5 = r4.c();
        if ((r5 & 17) != 17) goto L28;
        int r6 = -r3.getTop();
        int r7 = -r3.getBottom();
        if (r2 != 0) goto L14;
        if (ViewCompat.getFitsSystemWindows(r10) == false) goto L14;
        if (ViewCompat.getFitsSystemWindows(r3) == false) goto L14;
        r6 = r6 - r10.getTopInset();
    L14:
        if (checkFlag(r5, 2) == false) goto L17;
        r7 = r7 + ViewCompat.getMinimumHeight(r3);
    L23:
        if (checkFlag(r5, 32) == false) goto L25;
        r6 = r6 + ((FrameLayout.LayoutParams) r4).topMargin;
        r7 = r7 - ((FrameLayout.LayoutParams) r4).bottomMargin;
    L25:
        e(r9, r10, MathUtils.clamp(g(r1, r7, r6) + r0, -r10.getTotalScrollRange(), 0), 0.0f);
        return;
    L17:
        if (checkFlag(r5, 5) == false) goto L23;
        int r8 = ViewCompat.getMinimumHeight(r3) + r7;
        if (r1 >= r8) goto L21;
        r6 = r8;
        goto L23
    L21:
        r7 = r8;
        goto L23
    L28:
        return;
    }

    private void E(CoordinatorLayout r3, @NonNull T r4) {
        ViewCompat.removeAccessibilityAction(r3, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
        ViewCompat.removeAccessibilityAction(r3, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
        if (r4.getTotalScrollRange() != 0) goto L5;
        return;
    L5:
        View r0 = m(r3);
        if (r0 != null) goto L9;
        return;
    L9:
        if (j(r4) == true) goto L12;
        return;
    L12:
        if (ViewCompat.hasAccessibilityDelegate(r3) == true) goto L14;
        ViewCompat.setAccessibilityDelegate(r3, new b(this));
    L14:
        this.q = c(r3, r4, r0);
    }

    private void F(@NonNull CoordinatorLayout r6, @NonNull T r7, int r8, int r9, boolean r10) {
        View r0 = k(r7, r8);
        boolean r1 = false;
        if (r0 == null) goto L19;
        int r2 = ((h) r0.getLayoutParams()).c();
        if ((r2 & 1) == 0) goto L19;
        int r3 = ViewCompat.getMinimumHeight(r0);
        if (r9 <= 0) goto L14;
        if ((r2 & 12) == 0) goto L14;
        if ((-r8) < ((r0.getBottom() - r3) - r7.getTopInset())) goto L19;
    L12:
        r1 = true;
    L14:
        if ((r2 & 2) == 0) goto L19;
        if ((-r8) >= ((r0.getBottom() - r3) - r7.getTopInset())) goto L12;
    L19:
        if (r7.j() == false) goto L21;
        r1 = r7.m(findFirstScrollingChild(r6));
    L21:
        boolean r11 = r7.l(r1);
        if (r10 == true) goto L27;
        if (r11 == true) goto L25;
        return;
    L25:
        if (C(r6, r7) == true) goto L27;
        return;
    L27:
        if (r7.getBackground() == null) goto L29;
        r7.getBackground().jumpToCurrentState();
    L29:
        int r5 = Build.VERSION.SDK_INT;
        if (r5 < 23) goto L35;
        if (r7.getForeground() == null) goto L35;
        r7.getForeground().jumpToCurrentState();
    L35:
        if (r5 >= 21) goto L37;
        return;
    L37:
        if (r7.getStateListAnimator() == null) goto L43;
        r7.getStateListAnimator().jumpToCurrentState();
        return;
    }

    static /* synthetic */ boolean b(BaseBehavior r0) {
        return r0.q;
    }

    private boolean c(CoordinatorLayout r11, @NonNull T r12, @NonNull View r13) {
        boolean r2 = false;
        if (getTopBottomOffsetForScrollingSibling() == (-r12.getTotalScrollRange())) goto L6;
        d(r11, r12, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD, false);
        r2 = true;
    L6:
        if (getTopBottomOffsetForScrollingSibling() == 0) goto L14;
        if (r13.canScrollVertically(-1) == false) goto L12;
        int r9 = -r12.getDownNestedPreScrollRange();
        if (r9 == 0) goto L14;
        ViewCompat.replaceAccessibilityAction(r11, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, null, new c(this, r11, r12, r13, r9));
        return true;
    L12:
        d(r11, r12, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, true);
        return true;
    L14:
        return r2;
    }

    private static boolean checkFlag(int r0, int r1) {
        if ((r0 & r1) != r1) goto L5;
        return true;
    L5:
        return false;
    }

    private void d(CoordinatorLayout r2, @NonNull T r3, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat r4, boolean r5) {
        ViewCompat.replaceAccessibilityAction(r2, r4, null, new d(this, r3, r5));
    }

    private void e(CoordinatorLayout r3, @NonNull T r4, int r5, float r6) {
        int r0 = Math.abs(getTopBottomOffsetForScrollingSibling() - r5);
        float r7 = Math.abs(r6);
        if (r7 <= 0.0f) goto L5;
        int r8 = Math.round((r0 / r7) * 1000.0f) * 3;
    L6:
        f(r3, r4, r5, r8);
        return;
    L5:
        r8 = (int) (((r0 / r4.getHeight()) + 1.0f) * 150.0f);
        goto L6
    }

    @SuppressLint({"RestrictedApi"})
    private void f(CoordinatorLayout r4, T r5, int r6, int r7) {
        int r0 = getTopBottomOffsetForScrollingSibling();
        if (r0 != r6) goto L10;
        ValueAnimator r8 = this.m;
        if (r8 != null) goto L7;
        return;
    L7:
        if (r8.isRunning() == false) goto L17;
        this.m.cancel();
        return;
    L17:
        return;
    L10:
        ValueAnimator r1 = this.m;
        if (r1 != null) goto L13;
        ValueAnimator r2 = new ValueAnimator();
        this.m = r2;
        r2.setInterpolator(com.google.android.material.animation.AnimationUtils.DECELERATE_INTERPOLATOR);
        this.m.addUpdateListener(new a(this, r4, r5));
    L14:
        this.m.setDuration(Math.min(r7, 600));
        this.m.setIntValues(new int[]{r0, r6});
        this.m.start();
        return;
    L13:
        r1.cancel();
        goto L14
    }

    @Nullable
    private View findFirstScrollingChild(@NonNull CoordinatorLayout r4) {
        int r3 = r4.getChildCount();
        int r0 = 0;
    L3:
        if (r0 >= r3) goto L13;
        View r1 = r4.getChildAt(r0);
        if ((r1 instanceof NestedScrollingChild) == true) goto L12;
        if ((r1 instanceof AbsListView) == true) goto L12;
        if ((r1 instanceof ScrollView) == true) goto L12;
        r0 = r0 + 1;
    L12:
        return r1;
    L13:
        return null;
    }

    private int g(int r1, int r2, int r3) {
        if (r1 >= ((r2 + r3) / 2)) goto L6;
        return r2;
    L6:
        return r3;
    }

    private boolean i(@NonNull CoordinatorLayout r1, @NonNull T r2, @NonNull View r3) {
        if (r2.i() == true) goto L5;
    L7:
        return false;
    L5:
        if ((r1.getHeight() - r3.getHeight()) > r2.getHeight()) goto L7;
        return true;
    }

    private boolean j(OUnitedTitleBar r4) {
        int r3 = r4.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r3) goto L9;
        if (((h) r4.getChildAt(r1).getLayoutParams()).f11567a != 0) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    @Nullable
    private static View k(@NonNull OUnitedTitleBar r4, int r5) {
        int r6 = Math.abs(r5);
        int r0 = r4.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        View r2 = r4.getChildAt(r1);
        if (r6 < r2.getTop()) goto L9;
        if (r6 > r2.getBottom()) goto L9;
        return r2;
    L9:
        r1 = r1 + 1;
        goto L3
    L10:
        return null;
    }

    private int l(@NonNull T r7, int r8) {
        int r6 = r7.getChildCount();
        int r0 = 0;
    L3:
        if (r0 >= r6) goto L12;
        View r1 = r7.getChildAt(r0);
        int r2 = r1.getTop();
        int r3 = r1.getBottom();
        h r4 = (h) r1.getLayoutParams();
        if (checkFlag(r4.c(), 32) == false) goto L7;
        r2 = r2 - ((FrameLayout.LayoutParams) r4).topMargin;
        r3 = r3 + ((FrameLayout.LayoutParams) r4).bottomMargin;
    L7:
        int r5 = -r8;
        if (r2 > r5) goto L11;
        if (r3 < r5) goto L11;
        return r0;
    L11:
        r0 = r0 + 1;
        goto L3
    L12:
        return -1;
    }

    @Nullable
    private View m(CoordinatorLayout r4) {
        int r3 = r4.getChildCount();
        int r0 = 0;
    L3:
        if (r0 >= r3) goto L8;
        View r1 = r4.getChildAt(r0);
        if ((((CoordinatorLayout.LayoutParams) r1.getLayoutParams()).getBehavior() instanceof ScrollingViewBehavior) == true) goto L6;
        r0 = r0 + 1;
        goto L3
    L6:
        return r1;
    L8:
        return null;
    }

    private int p(@NonNull T r8, int r9) {
        int r7 = Math.abs(r9);
        int r0 = r8.getChildCount();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L21;
        View r3 = r8.getChildAt(r2);
        h r4 = (h) r3.getLayoutParams();
        Interpolator r5 = r4.d();
        if (r7 < r3.getTop()) goto L20;
        if (r7 > r3.getBottom()) goto L20;
        if (r5 == null) goto L21;
        int r6 = r4.c();
        if ((r6 & 1) == 0) goto L15;
        r1 = 0 + ((r3.getHeight() + ((FrameLayout.LayoutParams) r4).topMargin) + ((FrameLayout.LayoutParams) r4).bottomMargin);
        if ((r6 & 2) == 0) goto L15;
        r1 = r1 - ViewCompat.getMinimumHeight(r3);
    L15:
        if (ViewCompat.getFitsSystemWindows(r3) == false) goto L17;
        r1 = r1 - r8.getTopInset();
    L17:
        if (r1 <= 0) goto L21;
        float r10 = r1;
        return Integer.signum(r9) * (r3.getTop() + Math.round(r10 * r5.getInterpolation((r7 - r3.getTop()) / r10)));
    L20:
        r2 = r2 + 1;
    L21:
        return r9;
    }

    @Nullable
    SavedState A(@Nullable Parcelable r7, @NonNull T r8) {
        int r6 = getTopAndBottomOffset();
        int r0 = r8.getChildCount();
        boolean r1 = false;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L26;
        View r3 = r8.getChildAt(r2);
        int r4 = r3.getBottom() + r6;
        if ((r3.getTop() + r6) > 0) goto L25;
        if (r4 < 0) goto L25;
        if (r7 != null) goto L10;
        r7 = AbsSavedState.EMPTY_STATE;
    L10:
        SavedState r5 = new SavedState(r7);
        if (r6 != 0) goto L13;
        boolean r9 = true;
    L14:
        r5.f11550g = r9;
        if (r9 == false) goto L17;
    L19:
        boolean r10 = false;
    L20:
        r5.f11549f = r10;
        r5.f11551h = r2;
        if (r4 != (ViewCompat.getMinimumHeight(r3) + r8.getTopInset())) goto L23;
        r1 = true;
    L23:
        r5.f11553j = r1;
        r5.f11552i = r4 / r3.getHeight();
        return r5;
    L17:
        if ((-r6) < r8.getTotalScrollRange()) goto L19;
        r10 = true;
        goto L20
    L13:
        r9 = false;
    L25:
        r2 = r2 + 1;
        goto L3
    L26:
        return null;
    }

    public int B(@NonNull CoordinatorLayout r9, @NonNull T r10, int r11, int r12, int r13) {
        int r0 = getTopBottomOffsetForScrollingSibling();
        int r1 = 0;
        if (r12 == 0) goto L30;
        if (r0 < r12) goto L30;
        if (r0 > r13) goto L30;
        int r5 = MathUtils.clamp(r11, r12, r13);
        if (r0 != r5) goto L9;
    L31:
        E(r9, r10);
        return r1;
    L9:
        if (r10.h() == false) goto L11;
        int r14 = p(r10, r5);
    L12:
        boolean r15 = setTopAndBottomOffset(r14);
        int r16 = r0 - r5;
        this.f11547k = r5 - r14;
        int r17 = 1;
        if (r15 == true) goto L15;
    L22:
        if (r15 == false) goto L24;
    L26:
        r10.d(getTopAndBottomOffset());
        if (r5 >= r0) goto L29;
        r17 = -1;
    L29:
        F(r9, r10, r5, r17, false);
        r1 = r16;
        goto L31
    L24:
        if (r10.h() == false) goto L26;
        r9.dispatchDependentViewsChanged(r10);
    L15:
        if (r1 >= r10.getChildCount()) goto L22;
        h r2 = (h) r10.getChildAt(r1).getLayoutParams();
        f r3 = r2.b();
        if (r3 == null) goto L21;
        if ((r2.c() & 1) == 0) goto L21;
        r3.a(r10, r10.getChildAt(r1), getTopAndBottomOffset());
    L21:
        r1 = r1 + 1;
        goto L15
    L11:
        r14 = r5;
    L30:
        this.f11547k = 0;
        goto L31
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* bridge */ /* synthetic */ boolean canDragView(View r1) {
        return h((OUnitedTitleBar) r1);
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* bridge */ /* synthetic */ int getMaxDragOffset(@NonNull View r1) {
        return n((OUnitedTitleBar) r1);
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* bridge */ /* synthetic */ int getScrollRangeForDragFling(@NonNull View r1) {
        return o((OUnitedTitleBar) r1);
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset() + this.f11547k;
    }

    public boolean h(T r2) {
        e r0 = this.p;
        if (r0 != null) goto L5;
        WeakReference<View> r1 = this.o;
        if (r1 == null) goto L17;
        View r3 = r1.get();
        if (r3 != null) goto L11;
    L15:
        return false;
    L11:
        if (r3.isShown() == false) goto L15;
        if (r3.canScrollVertically(-1) == true) goto L15;
        return true;
    L17:
        return true;
    L5:
        return r0.a(r2);
    }

    public int n(@NonNull T r1) {
        return (-r1.getDownNestedScrollRange()) + r1.getTopInset();
    }

    public int o(@NonNull T r1) {
        return r1.getTotalScrollRange();
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* bridge */ /* synthetic */ void onFlingFinished(@NonNull CoordinatorLayout r1, @NonNull View r2) {
        q(r1, (OUnitedTitleBar) r2);
    }

    @Override // com.obric.oui.titlebar.behavior.a, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout r1, @NonNull View r2, int r3) {
        return r(r1, (OUnitedTitleBar) r2, r3);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout r1, @NonNull View r2, int r3, int r4, int r5, int r6) {
        return s(r1, (OUnitedTitleBar) r2, r3, r4, r5, r6);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r1, @NonNull View r2, View r3, int r4, int r5, int[] r6, int r7) {
        t(r1, (OUnitedTitleBar) r2, r3, r4, r5, r6, r7);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout r1, @NonNull View r2, View r3, int r4, int r5, int r6, int r7, int r8) {
        u(r1, (OUnitedTitleBar) r2, r3, r4, r5, r6, r7, r8);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ void onRestoreInstanceState(@NonNull CoordinatorLayout r1, @NonNull View r2, Parcelable r3) {
        v(r1, (OUnitedTitleBar) r2, r3);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(@NonNull CoordinatorLayout r1, @NonNull View r2) {
        return w(r1, (OUnitedTitleBar) r2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onStartNestedScroll(@NonNull CoordinatorLayout r1, @NonNull View r2, @NonNull View r3, View r4, int r5, int r6) {
        return x(r1, (OUnitedTitleBar) r2, r3, r4, r5, r6);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout r1, @NonNull View r2, View r3, int r4) {
        y(r1, (OUnitedTitleBar) r2, r3, r4);
    }

    public void q(@NonNull CoordinatorLayout r2, @NonNull T r3) {
        D(r2, r3);
        if (r3.j() == false) goto L6;
        r3.l(r3.m(findFirstScrollingChild(r2)));
        return;
    }

    public boolean r(@NonNull CoordinatorLayout r8, @NonNull T r9, int r10) {
        boolean r11 = super.onLayoutChild(r8, r9, r10);
        int r0 = r9.getPendingAction();
        SavedState r1 = this.n;
        if (r1 != null) goto L5;
    L18:
        if (r0 != 0) goto L20;
    L32:
        r9.k();
        this.n = null;
        setTopAndBottomOffset(MathUtils.clamp(getTopAndBottomOffset(), -r9.getTotalScrollRange(), 0));
        F(r8, r9, getTopAndBottomOffset(), 0, true);
        r9.d(getTopAndBottomOffset());
        E(r8, r9);
        return r11;
    L20:
        if ((r0 & 4) == 0) goto L22;
        boolean r2 = true;
    L24:
        if ((r0 & 1) == 0) goto L29;
        int r3 = -r9.getUpNestedPreScrollRange();
        if (r2 == true) goto L27;
    L9:
        setHeaderTopBottomOffset(r8, r9, r3);
        goto L32
    L27:
        e(r8, r9, r3, 0.0f);
        goto L32
    L29:
        if ((r0 & 16) == 0) goto L32;
        if (r2 == true) goto L31;
    L12:
        setHeaderTopBottomOffset(r8, r9, 0);
        goto L32
    L31:
        e(r8, r9, 0, 0.0f);
        goto L32
    L22:
        r2 = false;
        goto L24
    L5:
        if ((r0 & 8) != 0) goto L18;
        if (r1.f11549f == false) goto L11;
        r3 = -r9.getTotalScrollRange();
        goto L9
    L11:
        if (r1.f11550g == true) goto L12;
        View r4 = r9.getChildAt(r1.f11551h);
        int r5 = -r4.getBottom();
        if (this.n.f11553j == false) goto L16;
        int r6 = ViewCompat.getMinimumHeight(r4) + r9.getTopInset();
    L17:
        setHeaderTopBottomOffset(r8, r9, r5 + r6);
        goto L32
    L16:
        r6 = Math.round(r4.getHeight() * this.n.f11552i);
        goto L17
    }

    public boolean s(@NonNull CoordinatorLayout r7, @NonNull T r8, int r9, int r10, int r11, int r12) {
        if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) r8.getLayoutParams())).height != (-2)) goto L7;
        r7.onMeasureChild(r8, r9, r10, View.MeasureSpec.makeMeasureSpec(0, 0), r12);
        return true;
    L7:
        return super.onMeasureChild(r7, r8, r9, r10, r11, r12);
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* bridge */ /* synthetic */ int setHeaderTopBottomOffset(@NonNull CoordinatorLayout r1, @NonNull View r2, int r3, int r4, int r5) {
        return B(r1, (OUnitedTitleBar) r2, r3, r4, r5);
    }

    public void t(CoordinatorLayout r7, @NonNull T r8, View r9, int r10, int r11, int[] r12, int r13) {
        if (r11 == 0) goto L10;
        if (r11 >= 0) goto L5;
        int r14 = -r8.getTotalScrollRange();
        int r15 = r8.getDownNestedPreScrollRange() + r14;
    L6:
        int r4 = r14;
        int r5 = r15;
        if (r4 == r5) goto L10;
        r12[1] = scroll(r7, r8, r11, r4, r5);
        goto L10
    L5:
        r14 = -r8.getUpNestedPreScrollRange();
        r15 = 0;
    L10:
        if (r8.j() == false) goto L13;
        r8.l(r8.m(r9));
        return;
    }

    public void u(CoordinatorLayout r7, @NonNull T r8, View r9, int r10, int r11, int r12, int r13, int r14) {
        if (r13 >= 0) goto L4;
        scroll(r7, r8, r13, -r8.getDownNestedScrollRange(), 0);
    L4:
        if (r13 != 0) goto L7;
        E(r7, r8);
        return;
    }

    public void v(@NonNull CoordinatorLayout r2, @NonNull T r3, Parcelable r4) {
        if ((r4 instanceof SavedState) == false) goto L5;
        z((SavedState) r4, true);
        super.onRestoreInstanceState(r2, r3, this.n.getSuperState());
        return;
    L5:
        super.onRestoreInstanceState(r2, r3, r4);
        this.n = null;
    }

    public Parcelable w(@NonNull CoordinatorLayout r1, @NonNull T r2) {
        Parcelable r3 = super.onSaveInstanceState(r1, r2);
        SavedState r0 = A(r3, r2);
        if (r0 != null) goto L6;
        return r3;
    L6:
        return r0;
    }

    public boolean x(@NonNull CoordinatorLayout r1, @NonNull T r2, @NonNull View r3, View r4, int r5, int r6) {
        if ((r5 & 2) != 0) goto L5;
    L9:
        boolean r7 = false;
    L10:
        if (r7 == false) goto L14;
        ValueAnimator r8 = this.m;
        if (r8 == null) goto L14;
        r8.cancel();
    L14:
        this.o = null;
        this.f11548l = r6;
        return r7;
    L5:
        if (r2.j() == false) goto L7;
    L8:
        r7 = true;
        goto L10
    L7:
        if (i(r1, r2, r3) == false) goto L9;
        goto L8
    }

    public void y(CoordinatorLayout r2, @NonNull T r3, View r4, int r5) {
        if (this.f11548l != 0) goto L5;
    L6:
        D(r2, r3);
        if (r3.j() == false) goto L9;
        r3.l(r3.m(r4));
    L9:
        this.o = new WeakReference(r4);
        return;
    L5:
        if (r5 != 1) goto L9;
        goto L6
    }

    void z(@Nullable SavedState r2, boolean r3) {
        if (this.n == null) goto L5;
        if (r3 == true) goto L5;
        return;
    L5:
        this.n = r2;
    }
}
