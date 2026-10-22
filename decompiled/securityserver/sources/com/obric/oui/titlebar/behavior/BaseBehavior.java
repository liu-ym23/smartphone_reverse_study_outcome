package com.obric.oui.titlebar.behavior;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.animation.AnimationUtils;
import com.obric.oui.titlebar.OUnitedTitleBar;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class BaseBehavior<T extends OUnitedTitleBar> extends HeaderBehavior<T> {
    public int j;
    public ValueAnimator k;
    public SavedState l;
    public WeakReference m;
    public boolean n;

    public static abstract class BaseDragCallback<T extends OUnitedTitleBar> {
    }

    public static class Behavior extends BaseBehavior<OUnitedTitleBar> {

        public static abstract class DragCallback extends BaseDragCallback<OUnitedTitleBar> {
        }

        public Behavior() {
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public final boolean canDragView(View r2) {
            OUnitedTitleBar r3 = (OUnitedTitleBar) r2;
            WeakReference r1 = this.m;
            if (r1 == null) goto L13;
            View r4 = (View) r1.get();
            if (r4 != null) goto L7;
        L11:
            return false;
        L7:
            if (r4.isShown() == false) goto L11;
            if (r4.canScrollVertically(-1) == true) goto L11;
            return true;
        L13:
            return true;
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public final int getMaxDragOffset(View r1) {
            OUnitedTitleBar r2 = (OUnitedTitleBar) r1;
            int r0 = -r2.getDownNestedScrollRange();
            return r2.getTopInset() + r0;
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public final int getScrollRangeForDragFling(View r1) {
            return ((OUnitedTitleBar) r1).getTotalScrollRange();
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public final void onFlingFinished(CoordinatorLayout r1, View r2) {
            i(r1, (OUnitedTitleBar) r2);
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout r1, View r2, int r3) {
            b(r1, (OUnitedTitleBar) r2, r3);
            return true;
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout r1, View r2, int r3, int r4, int r5, int r6) {
            return c(r1, (OUnitedTitleBar) r2, r3, r4, r5, r6);
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r1, View r2, View r3, int r4, int r5, int[] r6, int r7) {
            d(r1, (OUnitedTitleBar) r2, r5, r6);
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void onNestedScroll(CoordinatorLayout r7, View r8, View r9, int r10, int r11, int r12, int r13, int r14) {
            OUnitedTitleBar r15 = (OUnitedTitleBar) r8;
            if (r13 >= 0) goto L5;
            int r4 = -r15.getDownNestedScrollRange();
            setHeaderTopBottomOffset(r7, r15, getTopBottomOffsetForScrollingSibling() - r13, r4, 0);
        L5:
            if (r13 != 0) goto L8;
            j(r7, r15);
            return;
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ void onRestoreInstanceState(CoordinatorLayout r1, View r2, Parcelable r3) {
            e(r1, (OUnitedTitleBar) r2, r3);
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(CoordinatorLayout r1, View r2) {
            return f(r1, (OUnitedTitleBar) r2);
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout r7, View r8, View r9, View r10, int r11, int r12) {
            return g(r7, (OUnitedTitleBar) r8, r9, r11, r12);
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void onStopNestedScroll(CoordinatorLayout r2, View r3, View r4, int r5) {
            OUnitedTitleBar r6 = (OUnitedTitleBar) r3;
            if (this.j != 0) goto L5;
        L6:
            i(r2, r6);
        L7:
            this.m = new WeakReference(r4);
            return;
        L5:
            if (r5 != 1) goto L7;
            goto L6
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public final /* bridge */ /* synthetic */ int setHeaderTopBottomOffset(CoordinatorLayout r1, View r2, int r3, int r4, int r5) {
            return h(r1, (OUnitedTitleBar) r2, r3, r4, r5);
        }

        public Behavior(Context r1, AttributeSet r2) {
            super(r1, r2);
        }
    }

    public static abstract class ChildScrollEffect {
    }

    public static class CompressChildScrollEffect extends ChildScrollEffect {
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f305a;
        public CompressChildScrollEffect b;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface ScrollEffect {
        }

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface ScrollFlags {
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public boolean b;
        public boolean c;
        public int e;
        public float f;
        public boolean i;

        /* JADX INFO: renamed from: com.obric.oui.titlebar.behavior.BaseBehavior$SavedState$1, reason: invalid class name */
        public class AnonymousClass1 implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel r1, ClassLoader r2) {
                return new SavedState(r1, r2);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int r1) {
                return new SavedState[r1];
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel r2) {
                return new SavedState(r2, null);
            }
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcel r3, ClassLoader r4) {
            super(r3, r4);
            boolean r0 = false;
            if (r3.readByte() == 0) goto L5;
            boolean r5 = true;
        L6:
            this.b = r5;
            if (r3.readByte() == 0) goto L9;
            boolean r6 = true;
        L10:
            this.c = r6;
            this.e = r3.readInt();
            this.f = r3.readFloat();
            if (r3.readByte() == 0) goto L13;
            r0 = true;
        L13:
            this.i = r0;
            return;
        L9:
            r6 = false;
            goto L10
        L5:
            r5 = false;
            goto L6
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeByte(this.b ? 1 : 0);
            r1.writeByte(this.c ? 1 : 0);
            r1.writeInt(this.e);
            r1.writeFloat(this.f);
            r1.writeByte(this.i ? 1 : 0);
        }
    }

    public BaseBehavior() {
    }

    public static void k(OUnitedTitleBar r4, int r5, int r6, boolean r7) {
        int r8 = Math.abs(r5);
        int r0 = r4.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        View r2 = r4.getChildAt(r1);
        if (r8 < r2.getTop()) goto L9;
        if (r8 > r2.getBottom()) goto L9;
    L11:
        if (r2 == null) goto L22;
        int r9 = ((LayoutParams) r2.getLayoutParams()).f305a;
        if ((r9 & 1) == 0) goto L22;
        ViewCompat.getMinimumHeight(r2);
        if (r6 <= 0) goto L20;
        if ((r9 & 12) == 0) goto L20;
        r2.getBottom();
        r4.getTopInset();
    L20:
        if ((r9 & 2) == 0) goto L22;
        r2.getBottom();
        r4.getTopInset();
    L22:
        if (r7 == true) goto L25;
        return;
    L25:
        if (r4.getBackground() == null) goto L28;
        r4.getBackground().jumpToCurrentState();
    L28:
        if (r4.getForeground() == null) goto L31;
        r4.getForeground().jumpToCurrentState();
    L31:
        if (r4.getStateListAnimator() == null) goto L38;
        r4.getStateListAnimator().jumpToCurrentState();
        return;
    L38:
        return;
    L9:
        r1 = r1 + 1;
        goto L3
    L10:
        r2 = null;
        goto L11
    }

    public final void a(final CoordinatorLayout r5, final OUnitedTitleBar r6, int r7) {
        int r0 = Math.abs(getTopAndBottomOffset() - r7);
        float r2 = Math.abs(0.0f);
        if (r2 <= 0.0f) goto L5;
        int r1 = Math.round((r0 / r2) * 1000.0f) * 3;
    L6:
        int r3 = getTopAndBottomOffset();
        if (r3 != r7) goto L13;
        ValueAnimator r8 = this.k;
        if (r8 != null) goto L11;
        return;
    L11:
        if (r8.isRunning() == false) goto L20;
        this.k.cancel();
        return;
    L20:
        return;
    L13:
        ValueAnimator r4 = this.k;
        if (r4 != null) goto L16;
        ValueAnimator r9 = new ValueAnimator();
        this.k = r9;
        r9.setInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
        this.k.addUpdateListener(new AnonymousClass1(this, r5, r6));
    L17:
        this.k.setDuration(Math.min(r1, 600));
        this.k.setIntValues(new int[]{r3, r7});
        this.k.start();
        return;
    L16:
        r4.cancel();
        goto L17
    L5:
        r1 = (int) (((r0 / r6.getHeight()) + 1.0f) * 150.0f);
        goto L6
    }

    public final boolean b(CoordinatorLayout r5, OUnitedTitleBar r6, int r7) {
        super.onLayoutChild(r5, r6, r7);
        int r8 = r6.getPendingAction();
        SavedState r0 = this.l;
        if (r0 != null) goto L5;
    L17:
        if (r8 != 0) goto L19;
    L33:
        r6.p = 0;
        this.l = null;
        int r9 = MathUtils.clamp(getTopAndBottomOffset(), -r6.getTotalScrollRange(), 0);
        ViewOffsetHelper r1 = this.f308a;
        if (r1 != null) goto L36;
        this.b = r9;
    L39:
        k(r6, getTopAndBottomOffset(), 0, true);
        j(r5, r6);
        return true;
    L36:
        if (r1.f310d == r9) goto L39;
        r1.f310d = r9;
        r1.a();
        goto L39
    L19:
        if ((r8 & 4) == 0) goto L21;
        boolean r2 = true;
    L23:
        if ((r8 & 1) == 0) goto L29;
        int r10 = -r6.getUpNestedPreScrollRange();
        if (r2 == false) goto L27;
        a(r5, r6, r10);
        goto L33
    L27:
        setHeaderTopBottomOffset(r5, r6, r10);
        goto L33
    L29:
        if ((r8 & 16) == 0) goto L33;
        if (r2 == false) goto L32;
        a(r5, r6, 0);
        goto L33
    L32:
        setHeaderTopBottomOffset(r5, r6, 0);
        goto L33
    L21:
        r2 = false;
        goto L23
    L5:
        if ((r8 & 8) != 0) goto L17;
        if (r0.b == false) goto L10;
        setHeaderTopBottomOffset(r5, r6, -r6.getTotalScrollRange());
        goto L33
    L10:
        if (r0.c == false) goto L12;
        setHeaderTopBottomOffset(r5, r6, 0);
        goto L33
    L12:
        View r11 = r6.getChildAt(r0.e);
        int r3 = -r11.getBottom();
        if (this.l.i == false) goto L15;
        int r4 = (r6.getTopInset() + ViewCompat.getMinimumHeight(r11)) + r3;
    L16:
        setHeaderTopBottomOffset(r5, r6, r4);
        goto L33
    L15:
        r4 = Math.round(r11.getHeight() * this.l.f) + r3;
        goto L16
    }

    public final boolean c(CoordinatorLayout r7, OUnitedTitleBar r8, int r9, int r10, int r11, int r12) {
        if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) r8.getLayoutParams())).height != (-2)) goto L7;
        r7.onMeasureChild(r8, r9, r10, View.MeasureSpec.makeMeasureSpec(0, 0), r12);
        return true;
    L7:
        return super.onMeasureChild(r7, r8, r9, r10, r11, r12);
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public boolean canDragView(View r2) {
        OUnitedTitleBar r3 = (OUnitedTitleBar) r2;
        WeakReference r1 = this.m;
        if (r1 == null) goto L13;
        View r4 = (View) r1.get();
        if (r4 != null) goto L7;
    L11:
        return false;
    L7:
        if (r4.isShown() == false) goto L11;
        if (r4.canScrollVertically(-1) == true) goto L11;
        return true;
    L13:
        return true;
    }

    public final void d(CoordinatorLayout r9, OUnitedTitleBar r10, int r11, int[] r12) {
        if (r11 == 0) goto L9;
        if (r11 >= 0) goto L6;
        int r0 = -r10.getTotalScrollRange();
        int r1 = r10.getDownNestedPreScrollRange() + r0;
    L5:
        int r6 = r0;
        int r7 = r1;
        if (r6 == r7) goto L9;
        r12[1] = setHeaderTopBottomOffset(r9, r10, getTopBottomOffsetForScrollingSibling() - r11, r6, r7);
        goto L9
    L6:
        r0 = -r10.getUpNestedPreScrollRange();
        r1 = 0;
    L9:
        r10.getClass();
    }

    public final void e(CoordinatorLayout r2, OUnitedTitleBar r3, Parcelable r4) {
        if ((r4 instanceof SavedState) == false) goto L5;
        SavedState r5 = (SavedState) r4;
        this.l = r5;
        super.onRestoreInstanceState(r2, r3, r5.getSuperState());
        return;
    L5:
        super.onRestoreInstanceState(r2, r3, r4);
        this.l = null;
    }

    public final Parcelable f(CoordinatorLayout r8, OUnitedTitleBar r9) {
        Parcelable r10 = super.onSaveInstanceState(r8, r9);
        int r7 = getTopAndBottomOffset();
        int r0 = r9.getChildCount();
        boolean r1 = false;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L26;
        View r3 = r9.getChildAt(r2);
        int r4 = r3.getBottom() + r7;
        if ((r3.getTop() + r7) > 0) goto L25;
        if (r4 < 0) goto L25;
        if (r10 != null) goto L10;
        Parcelable r5 = AbsSavedState.EMPTY_STATE;
    L11:
        SavedState r6 = new SavedState(r5);
        if (r7 != 0) goto L14;
        boolean r11 = true;
    L15:
        r6.c = r11;
        if (r11 == false) goto L18;
    L20:
        boolean r12 = false;
    L21:
        r6.b = r12;
        r6.e = r2;
        if (r4 != (r9.getTopInset() + ViewCompat.getMinimumHeight(r3))) goto L24;
        r1 = true;
    L24:
        r6.i = r1;
        r6.f = r4 / r3.getHeight();
    L27:
        if (r6 != null) goto L30;
        return r10;
    L30:
        return r6;
    L18:
        if ((-r7) < r9.getTotalScrollRange()) goto L20;
        r12 = true;
        goto L21
    L14:
        r11 = false;
        goto L15
    L10:
        r5 = r10;
    L25:
        r2 = r2 + 1;
        goto L3
    L26:
        r6 = null;
        goto L27
    }

    public final boolean g(CoordinatorLayout r1, OUnitedTitleBar r2, View r3, int r4, int r5) {
        if ((r4 & 2) == 0) goto L9;
        r2.getClass();
        if (r2.getTotalScrollRange() == 0) goto L9;
        if ((r1.getHeight() - r3.getHeight()) > r2.getHeight()) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == false) goto L14;
        ValueAnimator r7 = this.k;
        if (r7 == null) goto L14;
        r7.cancel();
    L14:
        this.m = null;
        this.j = r5;
        return r6;
    L9:
        r6 = false;
        goto L10
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public int getMaxDragOffset(View r1) {
        OUnitedTitleBar r2 = (OUnitedTitleBar) r1;
        int r0 = -r2.getDownNestedScrollRange();
        return r2.getTopInset() + r0;
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public int getScrollRangeForDragFling(View r1) {
        return ((OUnitedTitleBar) r1).getTotalScrollRange();
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public final int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset();
    }

    public final int h(CoordinatorLayout r6, OUnitedTitleBar r7, int r8, int r9, int r10) {
        int r0 = getTopAndBottomOffset();
        int r1 = 0;
        if (r9 == 0) goto L31;
        if (r0 < r9) goto L31;
        if (r0 > r10) goto L31;
        int r11 = MathUtils.clamp(r8, r9, r10);
        if (r0 == r11) goto L31;
        r7.getClass();
        ViewOffsetHelper r12 = this.f308a;
        int r13 = 1;
        if (r12 != null) goto L11;
        this.b = r11;
    L14:
        boolean r14 = false;
    L15:
        int r2 = r0 - r11;
        if (r14 == false) goto L28;
        int r15 = 0;
    L19:
        if (r15 >= r7.getChildCount()) goto L28;
        LayoutParams r3 = (LayoutParams) r7.getChildAt(r15).getLayoutParams();
        CompressChildScrollEffect r4 = r3.b;
        if (r4 == null) goto L27;
        if ((r3.f305a & 1) == 0) goto L27;
        View r5 = r7.getChildAt(r15);
        r4.getClass();
        r5.getDrawingRect(null);
        r7.offsetDescendantRectToMyCoords(r5, null);
        r7.getTopInset();
        throw null;
    L27:
        r15 = r15 + 1;
    L28:
        if (r11 >= r0) goto L30;
        r13 = -1;
    L30:
        k(r7, r11, r13, false);
        r1 = r2;
        goto L31
    L11:
        if (r12.f310d == r11) goto L14;
        r12.f310d = r11;
        r12.a();
        r14 = true;
    L31:
        j(r6, r7);
        return r1;
    }

    public final void i(CoordinatorLayout r13, OUnitedTitleBar r14) {
        int r1 = r14.getPaddingTop() + r14.getTopInset();
        int r0 = getTopAndBottomOffset() - r1;
        int r2 = r14.getChildCount();
        int r4 = 0;
    L4:
        if (r4 >= r2) goto L13;
        View r6 = r14.getChildAt(r4);
        int r7 = r6.getTop();
        int r8 = r6.getBottom();
        LayoutParams r9 = (LayoutParams) r6.getLayoutParams();
        if ((r9.f305a & 32) != 32) goto L8;
        r7 = r7 - ((FrameLayout.LayoutParams) r9).topMargin;
        r8 = r8 + ((FrameLayout.LayoutParams) r9).bottomMargin;
    L8:
        int r10 = -r0;
        if (r7 > r10) goto L12;
        if (r8 < r10) goto L12;
    L14:
        if (r4 < 0) goto L45;
        View r3 = r14.getChildAt(r4);
        LayoutParams r11 = (LayoutParams) r3.getLayoutParams();
        int r12 = r11.f305a;
        if ((r12 & 17) != 17) goto L46;
        int r15 = -r3.getTop();
        int r16 = -r3.getBottom();
        if (r4 != 0) goto L25;
        if (ViewCompat.getFitsSystemWindows(r14) == false) goto L25;
        if (ViewCompat.getFitsSystemWindows(r3) == false) goto L25;
        r15 = r15 - r14.getTopInset();
    L25:
        if ((r12 & 2) != 2) goto L28;
        r16 = r16 + ViewCompat.getMinimumHeight(r3);
    L34:
        if ((r12 & 32) != 32) goto L37;
        r15 = r15 + ((FrameLayout.LayoutParams) r11).topMargin;
        r16 = r16 - ((FrameLayout.LayoutParams) r11).bottomMargin;
    L37:
        if (r0 >= ((r16 + r15) / 2)) goto L39;
        r15 = r16;
    L39:
        a(r13, r14, MathUtils.clamp(r15 + r1, -r14.getTotalScrollRange(), 0));
        return;
    L28:
        if ((r12 & 5) != 5) goto L34;
        int r5 = ViewCompat.getMinimumHeight(r3) + r16;
        if (r0 >= r5) goto L32;
        r15 = r5;
        goto L34
    L32:
        r16 = r5;
        goto L34
    L46:
        return;
    L45:
        return;
    L12:
        r4 = r4 + 1;
        goto L4
    L13:
        r4 = -1;
        goto L14
    }

    public final void j(final CoordinatorLayout r12, final OUnitedTitleBar r13) {
        ViewCompat.removeAccessibilityAction(r12, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
        ViewCompat.removeAccessibilityAction(r12, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
        if (r13.getTotalScrollRange() != 0) goto L5;
        return;
    L5:
        int r0 = r12.getChildCount();
        final boolean r1 = false;
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L12;
        View r4 = r12.getChildAt(r2);
        if ((((CoordinatorLayout.LayoutParams) r4.getLayoutParams()).getBehavior() instanceof ScrollingViewBehavior) == true) goto L10;
        r2 = r2 + 1;
        goto L7
    L10:
        final View r8 = r4;
    L13:
        if (r8 != null) goto L15;
        return;
    L15:
        int r3 = r13.getChildCount();
        int r5 = 0;
    L16:
        if (r5 >= r3) goto L37;
        if (((LayoutParams) r13.getChildAt(r5).getLayoutParams()).f305a != 0) goto L20;
        r5 = r5 + 1;
        goto L16
    L20:
        if (ViewCompat.hasAccessibilityDelegate(r12) == true) goto L22;
        ViewCompat.setAccessibilityDelegate(r12, new AnonymousClass2(this));
    L22:
        final boolean r10 = true;
        if (getTopAndBottomOffset() == (-r13.getTotalScrollRange())) goto L26;
        ViewCompat.replaceAccessibilityAction(r12, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD, null, new AnonymousClass4(r13, r1));
        r1 = true;
    L26:
        if (getTopAndBottomOffset() != 0) goto L28;
    L33:
        r10 = r1;
    L34:
        this.n = r10;
        return;
    L28:
        if (r8.canScrollVertically(-1) == false) goto L32;
        final int r9 = -r13.getDownNestedPreScrollRange();
        if (r9 == 0) goto L33;
        ViewCompat.replaceAccessibilityAction(r12, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, null, new AnonymousClass3(this, r12, r13, r8, r9));
        goto L34
    L32:
        ViewCompat.replaceAccessibilityAction(r12, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, null, new AnonymousClass4(r13, r10));
        goto L34
    L37:
        return;
    L12:
        r8 = null;
        goto L13
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public void onFlingFinished(CoordinatorLayout r1, View r2) {
        i(r1, (OUnitedTitleBar) r2);
    }

    @Override // com.obric.oui.titlebar.behavior.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout r1, View r2, int r3) {
        b(r1, (OUnitedTitleBar) r2, r3);
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout r1, View r2, int r3, int r4, int r5, int r6) {
        return c(r1, (OUnitedTitleBar) r2, r3, r4, r5, r6);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r1, View r2, View r3, int r4, int r5, int[] r6, int r7) {
        d(r1, (OUnitedTitleBar) r2, r5, r6);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout r7, View r8, View r9, int r10, int r11, int r12, int r13, int r14) {
        OUnitedTitleBar r15 = (OUnitedTitleBar) r8;
        if (r13 >= 0) goto L5;
        int r4 = -r15.getDownNestedScrollRange();
        setHeaderTopBottomOffset(r7, r15, getTopBottomOffsetForScrollingSibling() - r13, r4, 0);
    L5:
        if (r13 != 0) goto L8;
        j(r7, r15);
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ void onRestoreInstanceState(CoordinatorLayout r1, View r2, Parcelable r3) {
        e(r1, (OUnitedTitleBar) r2, r3);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(CoordinatorLayout r1, View r2) {
        return f(r1, (OUnitedTitleBar) r2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout r7, View r8, View r9, View r10, int r11, int r12) {
        return g(r7, (OUnitedTitleBar) r8, r9, r11, r12);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(CoordinatorLayout r2, View r3, View r4, int r5) {
        OUnitedTitleBar r6 = (OUnitedTitleBar) r3;
        if (this.j != 0) goto L5;
    L6:
        i(r2, r6);
    L7:
        this.m = new WeakReference(r4);
        return;
    L5:
        if (r5 != 1) goto L7;
        goto L6
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* bridge */ /* synthetic */ int setHeaderTopBottomOffset(CoordinatorLayout r1, View r2, int r3, int r4, int r5) {
        return h(r1, (OUnitedTitleBar) r2, r3, r4, r5);
    }

    public BaseBehavior(Context r1, AttributeSet r2) {
        super(r1, r2);
    }
}
