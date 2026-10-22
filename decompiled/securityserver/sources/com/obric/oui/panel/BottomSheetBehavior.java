package com.obric.oui.panel;

import a.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.OverScroller;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public int A;
    public int B;
    public boolean C;
    public HashMap D;
    public boolean E;
    public boolean F;
    public boolean G;
    public final int H;
    public final ViewDragHelper.Callback I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final ViewDragHelper.Callback f240J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f241a;
    public boolean b;
    public int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f242d;
    public int e;
    public boolean f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public boolean l;
    public boolean m;
    public final boolean n;
    public int o;
    public int p;
    public ViewDragHelper q;
    public BottomSheetRLDragHelper r;
    public boolean s;
    public int t;
    public boolean u;
    public int v;
    public WeakReference w;
    public WeakReference x;
    public final ArrayList y;
    public VelocityTracker z;

    public static abstract class BottomSheetCallback {
        public abstract void a(View r1, float r2);

        public abstract void b(View r1, int r2);
    }

    public interface InterceptTouchEvent {
    }

    public class RLSettleRunnable implements Runnable {
        public final View b;
        public final int c;
        public final /* synthetic */ BottomSheetBehavior e;

        public RLSettleRunnable(BottomSheetBehavior r1, View r2, int r3) {
            this.e = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BottomSheetBehavior r0 = this.e;
            BottomSheetRLDragHelper r1 = r0.r;
            if (r1 == null) goto L25;
            boolean r2 = r1.l;
            View r9 = this.b;
            if (r2 == false) goto L23;
            OverScroller r3 = r1.f248a;
            boolean r10 = r3.computeScrollOffset();
            int r11 = r3.getCurrX();
            int r12 = r3.getCurrY();
            int r7 = r11 - r9.getLeft();
            int r8 = r12 - r9.getTop();
            if (r7 == 0) goto L9;
            ViewCompat.offsetLeftAndRight(r9, r7);
        L9:
            if (r8 == 0) goto L11;
            ViewCompat.offsetTopAndBottom(r9, r8);
        L11:
            if (r7 != 0) goto L13;
            if (r8 != 0) goto L13;
        L14:
            if (r10 == true) goto L16;
        L20:
            if (r10 == true) goto L23;
            Runnable r4 = r1.m;
            r1.f.post(r4);
            goto L23
        L16:
            if (r11 != r3.getFinalX()) goto L20;
            if (r12 != r3.getFinalY()) goto L20;
            r3.abortAnimation();
            r10 = false;
        L13:
            r1.b.e(r9, r11, r12, r7, r8);
        L23:
            if (r1.l == false) goto L25;
            ViewCompat.postOnAnimation(r9, this);
            return;
        L25:
            r0.setStateInternal(this.c);
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public final int b;

        /* JADX INFO: renamed from: com.obric.oui.panel.BottomSheetBehavior$SavedState$1, reason: invalid class name */
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

        public SavedState(Parcel r1, ClassLoader r2) {
            super(r1, r2);
            this.b = r1.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.b);
        }

        public SavedState(Parcelable r1, int r2) {
            super(r1);
            this.b = r2;
        }
    }

    public class SettleRunnable implements Runnable {
        public final View b;
        public final int c;
        public final /* synthetic */ BottomSheetBehavior e;

        public SettleRunnable(BottomSheetBehavior r1, View r2, int r3) {
            this.e = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BottomSheetBehavior r0 = this.e;
            ViewDragHelper r1 = r0.q;
            if (r1 == null) goto L27;
            boolean r3 = false;
            if (r1.f252a != 2) goto L23;
            OverScroller r2 = r1.p;
            boolean r5 = r2.computeScrollOffset();
            int r12 = r2.getCurrX();
            int r13 = r2.getCurrY();
            int r10 = r12 - r1.r.getLeft();
            int r11 = r13 - r1.r.getTop();
            if (r10 == 0) goto L9;
            ViewCompat.offsetLeftAndRight(r1.r, r10);
        L9:
            if (r11 == 0) goto L11;
            ViewCompat.offsetTopAndBottom(r1.r, r11);
        L11:
            if (r10 != 0) goto L13;
            if (r11 != 0) goto L13;
        L14:
            if (r5 == true) goto L16;
        L20:
            if (r5 == true) goto L23;
            r1.t.post(r1.v);
            goto L23
        L16:
            if (r12 != r2.getFinalX()) goto L20;
            if (r13 != r2.getFinalY()) goto L20;
            r2.abortAnimation();
            r5 = false;
        L13:
            r1.q.e(r1.r, r12, r13, r10, r11);
        L23:
            if (r1.f252a != 2) goto L25;
            r3 = true;
        L25:
            if (r3 == false) goto L27;
            ViewCompat.postOnAnimation(this.b, this);
            return;
        L27:
            r0.setStateInternal(this.c);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface State {
    }

    public BottomSheetBehavior() {
        this.f241a = true;
        this.b = false;
        this.c = -1;
        this.m = true;
        this.n = false;
        this.o = 4;
        this.p = 4;
        this.y = new ArrayList();
        this.E = true;
        this.F = false;
        this.G = true;
        this.H = 600;
        this.I = new AnonymousClass2(this);
        this.f240J = new AnonymousClass3(this);
    }

    public static int[] a(BottomSheetBehavior r6, View r7, float r8, float r9) {
        int r2 = 0;
        int r3 = 6;
        int r4 = 3;
        if (r9 >= 0.0f) goto L15;
        r6.getClass();
        if (Math.abs(r9) <= 1500.0f) goto L15;
        if (r6.f241a == false) goto L9;
        int r10 = r6.i;
    L47:
        return new int[]{r10, r4};
    L9:
        int r11 = r7.getTop();
        int r12 = r6.j;
        if (r11 <= r12) goto L12;
        r2 = r12;
    L13:
        r10 = r2;
        r4 = r3;
    L12:
        r3 = 3;
    L15:
        if (r6.l == false) goto L24;
        if (r6.shouldHide(r7, r9) == false) goto L24;
        if (r7.getTop() <= r6.k) goto L21;
    L22:
        r10 = r6.v;
        r4 = 5;
        goto L47
    L21:
        if (Math.abs(r8) < Math.abs(r9)) goto L22;
    L24:
        if (r9 != 0.0f) goto L26;
    L29:
        int r13 = r7.getTop();
        if (r6.f241a == true) goto L32;
        int r14 = r6.j;
        if (r13 >= r14) goto L43;
        if (r13 < Math.abs(r13 - r6.k)) goto L12;
        r2 = r6.j;
        goto L13
    L43:
        if (Math.abs(r13 - r14) >= Math.abs(r13 - r6.k)) goto L45;
        r2 = r6.j;
        goto L13
    L45:
        r2 = r6.k;
    L35:
        r3 = 4;
        goto L13
    L32:
        if (Math.abs(r13 - r6.i) >= Math.abs(r13 - r6.k)) goto L34;
        r2 = r6.i;
        goto L12
    L34:
        r2 = r6.k;
        goto L35
    L26:
        if (Math.abs(r8) > Math.abs(r9)) goto L29;
        r10 = r6.k;
        r4 = 4;
        goto L47
    }

    public final int b() {
        if (this.f241a == true) goto L7;
        return 0;
    L7:
        return this.i;
    }

    public final void c(View r5, int r6) {
        if (r6 != 4) goto L6;
        int r0 = this.k;
    L19:
        ViewDragHelper r1 = this.q;
        int r2 = r5.getLeft();
        r1.r = r5;
        r1.c = -1;
        boolean r3 = r1.f(r2, r0, 0, 0);
        if (r3 == false) goto L22;
    L26:
        if (r3 == false) goto L28;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r5, new SettleRunnable(this, r5, r6));
        return;
    L28:
        setStateInternal(r6);
        return;
    L22:
        if (r1.f252a != 0) goto L26;
        if (r1.r == null) goto L26;
        r1.r = null;
        goto L26
    L6:
        if (r6 != 6) goto L12;
        r0 = this.j;
        if (this.f241a == false) goto L19;
        int r4 = this.i;
        if (r0 > r4) goto L19;
        r6 = 3;
        r0 = r4;
        goto L19
    L12:
        if (r6 != 3) goto L15;
        r0 = b();
        goto L19
    L15:
        if (this.l == false) goto L31;
        if (r6 != 5) goto L31;
        r0 = this.v;
    L31:
        throw new IllegalArgumentException(a.e(r6, "Illegal state argument: "));
    }

    public void calculateCollapsedOffset() {
        if (this.f241a == false) goto L5;
        this.k = Math.max(this.v - this.h, this.i);
        return;
    L5:
        this.k = this.v - this.h;
    }

    public final void dispatchOnSlide(int r8) {
        View r0 = (View) this.w.get();
        if (r0 == null) goto L14;
        ArrayList r1 = this.y;
        if (r1.isEmpty() == true) goto L17;
        int r3 = 0;
        if (r8 <= this.k) goto L12;
    L9:
        if (r3 >= r1.size()) goto L18;
        BottomSheetCallback r2 = (BottomSheetCallback) r1.get(r3);
        int r4 = this.k;
        r2.a(r0, (r4 - r8) / (this.v - r4));
        r3 = r3 + 1;
        goto L9
    L18:
        return;
    L12:
        if (r3 >= r1.size()) goto L19;
        BottomSheetCallback r5 = (BottomSheetCallback) r1.get(r3);
        int r6 = this.k;
        r5.a(r0, (r6 - r8) / (r6 - b()));
        r3 = r3 + 1;
        goto L12
    L19:
        return;
    L17:
        return;
    }

    public final View findScrollingChild(View r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (ViewCompat.isNestedScrollingEnabled(r5) == false) goto L9;
        return r5;
    L9:
        if ((r5 instanceof ViewGroup) == false) goto L16;
        ViewGroup r6 = (ViewGroup) r5;
        int r1 = r6.getChildCount();
        int r2 = 0;
    L11:
        if (r2 >= r1) goto L16;
        View r3 = findScrollingChild(r6.getChildAt(r2));
        if (r3 != null) goto L14;
        r2 = r2 + 1;
        goto L11
    L14:
        return r3;
    L16:
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout r17, View r18, MotionEvent r19) {
        boolean r5 = false;
        boolean r6 = true;
        if (r18.isShown() == false) goto L155;
        if (this.m == false) goto L155;
        int r4 = r19.getActionMasked();
        int r8 = -1;
        if (r4 != 0) goto L13;
        this.A = -1;
        VelocityTracker r9 = this.z;
        if (r9 == null) goto L13;
        r9.recycle();
        this.z = null;
    L13:
        if (this.z != null) goto L15;
        this.z = VelocityTracker.obtain();
    L15:
        this.z.addMovement(r19);
        if (r4 == 0) goto L24;
        if (r4 == 1) goto L20;
        if (r4 == 3) goto L20;
    L40:
        if (this.F == false) goto L65;
        if (this.s == true) goto L65;
        BottomSheetRLDragHelper r10 = this.r;
        if (r10 == null) goto L65;
        r10.i = (int) r19.getX();
        r10.j = false;
        int r12 = r19.getActionMasked();
        if (r12 != 0) goto L48;
        r10.g = (int) r19.getX();
        r10.h = (int) r19.getY();
    L48:
        int r13 = ((int) r19.getX()) - r10.g;
        int r14 = ((int) r19.getY()) - r10.h;
        if (r12 != 2) goto L57;
        float r15 = r13;
        float r16 = r14;
        if (Math.abs(r15) <= r10.e) goto L57;
        if ((Math.abs(r15) * 0.5f) <= Math.abs(r16)) goto L57;
        if (r10.b(r18) != null) goto L57;
        boolean r2 = true;
    L58:
        if (r2 == false) goto L62;
        if (r13 <= 0) goto L61;
        r8 = 1;
    L61:
        r10.k = r8;
        r10.b.d(1);
        r10.j = true;
    L62:
        if (r2 == false) goto L65;
        return true;
    L57:
        r2 = false;
    L65:
        if (this.s == true) goto L135;
        ViewDragHelper r3 = this.q;
        if (r3 == null) goto L135;
        int r7 = r19.getActionMasked();
        int r11 = r19.getActionIndex();
        if (r7 != 0) goto L72;
        r3.a();
    L72:
        if (r3.l != null) goto L74;
        r3.l = VelocityTracker.obtain();
    L74:
        r3.l.addMovement(r19);
        if (r7 == 0) goto L126;
        if (r7 == 1) goto L125;
        if (r7 == 2) goto L93;
        if (r7 == 3) goto L125;
        if (r7 != 5) goto L82;
        int r20 = r19.getPointerId(r11);
        float r21 = r19.getX(r11);
        float r22 = r19.getY(r11);
        r3.i(r21, r22, r20);
        int r110 = r3.f252a;
        if (r110 != 0) goto L88;
        int r23 = r3.h[r20];
    L133:
        if (r3.f252a != 1) goto L135;
        return true;
    L88:
        if (r110 != 2) goto L133;
        View r24 = r3.e((int) r21, (int) r22);
        if (r24 != r3.r) goto L133;
        r3.l(r24, r20);
        goto L133
    L82:
        if (r7 != 6) goto L133;
        r3.c(r19.getPointerId(r11));
        goto L133
    L93:
        if (r3.f253d == null) goto L133;
        if (r3.e == null) goto L133;
        int r25 = r19.getPointerCount();
        int r26 = 0;
    L98:
        if (r26 >= r25) goto L124;
        int r27 = r19.getPointerId(r26);
        if (r3.g(r27) == false) goto L123;
        float r111 = r19.getX(r26);
        float r112 = r19.getY(r26);
        float r113 = r111 - r3.f253d[r27];
        float r114 = r112 - r3.e[r27];
        View r115 = r3.e((int) r111, (int) r112);
        ViewDragHelper.Callback r116 = r3.q;
        if (r115 == null) goto L109;
        r116.getClass();
        if (r116.c(r115) <= 0) goto L109;
        if (Math.abs(r114) <= r3.b) goto L109;
        boolean r117 = r6;
    L110:
        if (r117 == false) goto L116;
        int r28 = (int) r113;
        r116.a(r115, r115.getLeft() + r28, r28);
        int r29 = r115.getTop();
        int r118 = (int) r114;
        int r30 = r116.b(r115, r29 + r118, r118);
        int r119 = r116.c(r115);
        if (r119 == 0) goto L124;
        if (r119 <= 0) goto L116;
        if (r30 == r29) goto L124;
    L116:
        Math.abs(r113);
        Math.abs(r114);
        int r31 = r3.h[r27];
        Math.abs(r114);
        Math.abs(r113);
        int r32 = r3.h[r27];
        Math.abs(r113);
        Math.abs(r114);
        int r33 = r3.h[r27];
        Math.abs(r114);
        Math.abs(r113);
        int r34 = r3.h[r27];
        if (r3.f252a == 1) goto L124;
        if (r117 == false) goto L123;
        if (r3.l(r115, r27) == false) goto L123;
    L109:
        r117 = r5;
    L123:
        r26 = r26 + 1;
        r5 = false;
        r6 = true;
    L124:
        r3.j(r19);
    L125:
        r3.a();
        goto L133
    L126:
        float r35 = r19.getX();
        float r36 = r19.getY();
        int r37 = r19.getPointerId(0);
        r3.i(r35, r36, r37);
        View r38 = r3.e((int) r35, (int) r36);
        if (r38 == r3.r) goto L129;
    L131:
        int r39 = r3.h[r37];
        goto L133
    L129:
        if (r3.f252a != 2) goto L131;
        r3.l(r38, r37);
    L135:
        WeakReference r40 = this.x;
        if (r40 == null) goto L138;
        View r41 = (View) r40.get();
        int r42 = 2;
    L139:
        if (r4 != r42) goto L153;
        if (r41 == null) goto L153;
        if (this.s == true) goto L153;
        if (this.o == 1) goto L153;
        if (r17.isPointInChildBounds(r41, (int) r19.getX(), (int) r19.getY()) == true) goto L153;
        if (this.q == null) goto L153;
        if (Math.abs(this.B - r19.getY()) <= this.q.b) goto L153;
        return true;
    L153:
        return false;
    L138:
        r42 = 2;
        r41 = null;
    L20:
        this.C = false;
        this.A = -1;
        if (this.s == false) goto L40;
        this.s = false;
        return false;
    L24:
        int r120 = (int) r19.getX();
        this.B = (int) r19.getY();
        WeakReference r121 = this.x;
        if (r121 == null) goto L27;
        View r122 = (View) r121.get();
    L28:
        if (r122 == null) goto L33;
        if (r17.isPointInChildBounds(r122, r120, this.B) == false) goto L33;
        this.A = r19.getPointerId(r19.getActionIndex());
        this.C = true;
    L33:
        if (this.A == (-1)) goto L35;
    L37:
        boolean r123 = false;
    L38:
        this.s = r123;
        goto L40
    L35:
        if (r17.isPointInChildBounds(r18, r120, this.B) == true) goto L37;
        r123 = true;
        goto L38
    L27:
        r122 = null;
    L155:
        this.s = true;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout r9, View r10, int r11) {
        if (this.E == true) goto L5;
    L9:
        int r0 = r10.getTop();
        r9.onLayoutChild(r10, r11);
        this.v = r9.getHeight();
        if (this.f == true) goto L12;
        this.h = this.e;
    L29:
        if (this.c <= 0) goto L33;
        int r12 = r10.getHeight();
        int r3 = this.c;
        if (r12 <= r3) goto L33;
        this.i = Math.max(0, this.v - r3);
    L34:
        this.j = this.v / 2;
        calculateCollapsedOffset();
        int r13 = this.o;
        if (r13 != 3) goto L38;
        ViewCompat.offsetTopAndBottom(r10, b());
    L52:
        if (this.q != null) goto L55;
        ViewDragHelper r14 = new ViewDragHelper(r9.getContext(), r9, this.I);
        this.q = r14;
        r14.u = this.H;
    L55:
        if (this.F == true) goto L57;
    L59:
        this.w = new WeakReference(r10);
        this.x = new WeakReference(findScrollingChild(r10));
        return true;
    L57:
        if (this.r != null) goto L59;
        this.r = new BottomSheetRLDragHelper(r9.getContext(), r9, this.f240J);
        goto L59
    L38:
        if (r13 != 6) goto L41;
        ViewCompat.offsetTopAndBottom(r10, this.j);
        goto L52
    L41:
        if (this.l == false) goto L46;
        if (r13 != 5) goto L46;
        ViewCompat.offsetTopAndBottom(r10, this.v);
    L46:
        if (r13 != 4) goto L48;
        ViewCompat.offsetTopAndBottom(r10, this.k);
        goto L52
    L48:
        if (r13 == 1) goto L50;
        if (r13 != 2) goto L52;
    L50:
        ViewCompat.offsetTopAndBottom(r10, r0 - r10.getTop());
    L33:
        this.i = Math.max(0, this.v - r10.getHeight());
        goto L34
    L12:
        if (this.g != 0) goto L14;
        this.g = r9.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
    L14:
        float r15 = r9.getContext().getResources().getConfiguration().fontScale;
        String r2 = "check fontScale:" + r15;
        if (r2 != null) goto L18;
        r2 = "null";
    L18:
        Log.d("debugging", r2);
        if (this.G == false) goto L21;
        double r4 = 0.6d;
    L22:
        double r5 = this.g;
        int r6 = this.c;
        if (r6 <= 0) goto L25;
        double r7 = r6;
    L26:
        this.h = (int) Math.max(r5, r7);
        goto L29
    L25:
        r7 = ((double) r15) * (((double) this.v) * r4);
        goto L26
    L21:
        r4 = 1.0d;
        goto L22
    L5:
        if (ViewCompat.getFitsSystemWindows(r9) == false) goto L9;
        if (ViewCompat.getFitsSystemWindows(r10) == true) goto L9;
        r10.setFitsSystemWindows(true);
        goto L9
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onNestedPreFling(CoordinatorLayout r3, View r4, View r5, float r6, float r7) {
        if (r5 == this.x.get()) goto L5;
    L9:
        return false;
    L5:
        if (this.o == 3) goto L7;
    L8:
        return true;
    L7:
        if (super.onNestedPreFling(r3, r4, r5, r6, r7) == false) goto L9;
        goto L8
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedPreScroll(CoordinatorLayout r2, View r3, View r4, int r5, int r6, int[] r7, int r8) {
        if (r8 != 1) goto L6;
        return;
    L6:
        if (r4 == ((View) this.x.get())) goto L8;
        return;
    L8:
        int r9 = r3.getTop();
        int r10 = r9 - r6;
        if (r6 > 0) goto L11;
        if (r6 < 0) goto L19;
    L30:
        dispatchOnSlide(r3.getTop());
        this.t = r6;
        this.u = true;
        return;
    L19:
        if (r4.canScrollVertically(-1) == true) goto L30;
        int r11 = this.k;
        if (r10 <= r11) goto L27;
        if (this.l == true) goto L27;
        int r12 = r9 - r11;
        r7[1] = r12;
        ViewCompat.offsetTopAndBottom(r3, -r12);
        setStateInternal(4);
    L27:
        if (this.m == true) goto L29;
        return;
    L29:
        r7[1] = r6;
        ViewCompat.offsetTopAndBottom(r3, -r6);
        setStateInternal(1);
        goto L30
    L11:
        if (r10 >= b()) goto L14;
        int r13 = r9 - b();
        r7[1] = r13;
        ViewCompat.offsetTopAndBottom(r3, -r13);
        setStateInternal(3);
        goto L30
    L14:
        if (this.m == true) goto L16;
        return;
    L16:
        r7[1] = r6;
        ViewCompat.offsetTopAndBottom(r3, -r6);
        setStateInternal(1);
        goto L30
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onRestoreInstanceState(CoordinatorLayout r2, View r3, Parcelable r4) {
        SavedState r5 = (SavedState) r4;
        super.onRestoreInstanceState(r2, r3, r5.getSuperState());
        int r6 = r5.b;
        if (r6 != 1) goto L5;
    L8:
        this.o = 4;
        return;
    L5:
        if (r6 == 2) goto L8;
        this.o = r6;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final Parcelable onSaveInstanceState(CoordinatorLayout r2, View r3) {
        return new SavedState(super.onSaveInstanceState(r2, r3), this.o);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout r1, View r2, View r3, View r4, int r5, int r6) {
        this.t = 0;
        this.u = false;
        if ((r5 & 2) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onStopNestedScroll(CoordinatorLayout r4, View r5, View r6, int r7) {
        int r0 = 3;
        if (r5.getTop() != b()) goto L7;
        setStateInternal(3);
        return;
    L7:
        if (r6 == this.x.get()) goto L9;
        return;
    L9:
        if (this.u == true) goto L12;
        return;
    L12:
        if (this.t <= 0) goto L15;
        int r8 = b();
    L44:
        this.p = r0;
        ViewDragHelper r9 = this.q;
        int r1 = r5.getLeft();
        r9.r = r5;
        r9.c = -1;
        boolean r10 = r9.f(r1, r8, 0, 0);
        if (r10 == false) goto L47;
    L51:
        if (r10 == false) goto L53;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r5, new SettleRunnable(this, r5, r0));
    L54:
        this.u = false;
        return;
    L53:
        setStateInternal(r0);
        goto L54
    L47:
        if (r9.f252a != 0) goto L51;
        if (r9.r == null) goto L51;
        r9.r = null;
        goto L51
    L15:
        if (this.l == false) goto L24;
        VelocityTracker r11 = this.z;
        if (r11 != null) goto L19;
        float r12 = 0.0f;
    L21:
        if (shouldHide(r5, r12) == false) goto L24;
        r8 = this.v;
        r0 = 5;
        goto L44
    L19:
        r11.computeCurrentVelocity(1000, this.f242d);
        r12 = this.z.getYVelocity(this.A);
    L24:
        if (this.t != 0) goto L42;
        int r13 = r5.getTop();
        if (this.f241a == true) goto L28;
        int r2 = this.j;
        if (r13 >= r2) goto L39;
        if (r13 >= Math.abs(r13 - this.k)) goto L36;
        r8 = 0;
        goto L44
    L36:
        r8 = this.j;
    L37:
        r0 = 6;
        goto L44
    L39:
        if (Math.abs(r13 - r2) >= Math.abs(r13 - this.k)) goto L41;
        r8 = this.j;
        goto L37
    L41:
        r8 = this.k;
    L43:
        r0 = 4;
        goto L44
    L28:
        if (Math.abs(r13 - this.i) >= Math.abs(r13 - this.k)) goto L30;
        r8 = this.i;
        goto L44
    L30:
        r8 = this.k;
        goto L43
    L42:
        r8 = this.k;
        goto L43
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout r22, View r23, MotionEvent r24) {
        int r9 = 0;
        if (r23.isShown() == true) goto L5;
        return false;
    L5:
        int r10 = r24.getActionMasked();
        if (this.o != 1) goto L10;
        if (r10 != 0) goto L10;
        return true;
    L10:
        if (r10 != 0) goto L15;
        this.A = -1;
        VelocityTracker r2 = this.z;
        if (r2 == null) goto L15;
        r2.recycle();
        this.z = null;
    L15:
        if (this.z != null) goto L17;
        this.z = VelocityTracker.obtain();
    L17:
        this.z.addMovement(r24);
        if (this.F == false) goto L52;
        BottomSheetRLDragHelper r15 = this.r;
        if (r15 == null) goto L52;
        if (r15.j == false) goto L52;
        int r6 = this.o;
        VelocityTracker r5 = this.z;
        int r4 = r24.getActionMasked();
        ViewDragHelper.Callback r3 = r15.b;
        if (r4 != 2) goto L32;
        int r1 = (int) r24.getX();
        int r7 = r1 - r15.i;
        r15.i = r1;
        float r8 = (r7 * (r23.getHeight() / r23.getWidth())) * 1.2f;
        int r14 = r23.getLeft();
        int r11 = (int) r8;
        int r12 = r23.getTop() + r11;
        int r16 = r23.getLeft();
        int r17 = r23.getTop();
        if (r11 == 0) goto L28;
        r12 = r3.b(r23, r12, r11);
        ViewCompat.offsetTopAndBottom(r23, r12 - r17);
    L28:
        int r13 = r12;
        if (r11 == 0) goto L32;
        r15.b.e(r23, r14, r13, r14 - r16, r13 - r17);
    L32:
        if (r4 != 1) goto L48;
        if (r6 != 1) goto L48;
        float r18 = r15.c;
        r5.computeCurrentVelocity(1000, r18);
        r5.computeCurrentVelocity(1000, r18);
        float r19 = r5.getXVelocity(0);
        float r20 = Math.abs(r19);
        if (r20 >= r15.f249d) goto L38;
        r19 = 0.0f;
        float r21 = 0.0f;
    L46:
        r3.f(r23, r21, r19);
    L49:
        if (r4 != 3) goto L158;
        if (r6 != 1) goto L158;
        r3.f(r23, r21, r21);
    L158:
        if (this.F == false) goto L166;
        BottomSheetRLDragHelper r25 = this.r;
        if (r25 == null) goto L166;
        if (r25.j == false) goto L166;
        return !this.s;
    L166:
        if (r10 != 2) goto L173;
        if (this.s == true) goto L173;
        float r26 = Math.abs(this.B - r24.getY());
        ViewDragHelper r27 = this.q;
        if (r26 <= r27.b) goto L173;
        r27.b(r23, r24.getPointerId(r24.getActionIndex()));
    L173:
        return !this.s;
    L38:
        if (r20 <= r18) goto L45;
        r21 = 0.0f;
        if (r19 <= 0.0f) goto L42;
        float r110 = r18;
    L43:
        r19 = r110;
        goto L46
    L42:
        r110 = -r18;
        goto L43
    L45:
        r21 = 0.0f;
    L48:
        r3 = r3;
        r21 = 0.0f;
    L52:
        ViewDragHelper r28 = this.q;
        if (r28 == null) goto L158;
        int r29 = r24.getActionMasked();
        int r30 = r24.getActionIndex();
        if (r29 != 0) goto L58;
        r28.a();
    L58:
        if (r28.l != null) goto L60;
        r28.l = VelocityTracker.obtain();
    L60:
        r28.l.addMovement(r24);
        if (r29 == 0) goto L156;
        if (r29 == 1) goto L153;
        ViewDragHelper.Callback r31 = r28.q;
        if (r29 == 2) goto L115;
        if (r29 == 3) goto L109;
        if (r29 != 5) goto L70;
        int r32 = r24.getPointerId(r30);
        float r33 = r24.getX(r30);
        float r34 = r24.getY(r30);
        r28.i(r33, r34, r32);
        if (r28.f252a != 0) goto L94;
        r28.l(r28.e((int) r33, (int) r34), r32);
        int r35 = r28.h[r32];
        goto L158
    L94:
        int r36 = (int) r33;
        int r37 = (int) r34;
        View r38 = r28.r;
        if (r38 != null) goto L98;
    L106:
        if (r9 == 0) goto L158;
        r28.l(r28.r, r32);
        goto L158
    L98:
        if (r36 < r38.getLeft()) goto L106;
        if (r36 >= r38.getRight()) goto L106;
        if (r37 < r38.getTop()) goto L106;
        if (r37 >= r38.getBottom()) goto L106;
        r9 = 1;
        goto L106
    L70:
        if (r29 != 6) goto L158;
        int r39 = r24.getPointerId(r30);
        if (r28.f252a == 1) goto L75;
    L90:
        r28.c(r39);
        goto L158
    L75:
        if (r39 != r28.c) goto L90;
        int r40 = r24.getPointerCount();
    L77:
        if (r9 >= r40) goto L87;
        int r41 = r24.getPointerId(r9);
        if (r41 == r28.c) goto L86;
        View r42 = r28.e((int) r24.getX(r9), (int) r24.getY(r9));
        View r111 = r28.r;
        if (r42 != r111) goto L86;
        if (r28.l(r111, r41) == false) goto L86;
        int r43 = r28.c;
    L88:
        if (r43 != (-1)) goto L90;
        r28.h();
    L86:
        r9 = r9 + 1;
        goto L77
    L87:
        r43 = -1;
        goto L88
    L109:
        if (r28.f252a != 1) goto L113;
        r28.s = true;
        r31.f(r28.r, 0.0f, 0.0f);
        r28.s = false;
        if (r28.f252a != 1) goto L113;
        r28.k(0);
    L113:
        r28.a();
        goto L158
    L115:
        if (r28.f252a == 1) goto L117;
        int r44 = r24.getPointerCount();
        int r45 = 0;
    L131:
        if (r45 >= r44) goto L151;
        int r46 = r24.getPointerId(r45);
        if (r28.g(r46) == false) goto L150;
        float r47 = r24.getX(r45);
        float r112 = r24.getY(r45);
        float r113 = r47 - r28.f253d[r46];
        float r114 = r112 - r28.e[r46];
        Math.abs(r113);
        Math.abs(r114);
        int r115 = r28.h[r46];
        Math.abs(r114);
        Math.abs(r113);
        int r116 = r28.h[r46];
        Math.abs(r113);
        Math.abs(r114);
        int r117 = r28.h[r46];
        Math.abs(r114);
        Math.abs(r113);
        int r118 = r28.h[r46];
        if (r28.f252a == 1) goto L151;
        View r48 = r28.e((int) r47, (int) r112);
        if (r48 != null) goto L141;
    L140:
        boolean r119 = false;
    L146:
        if (r119 == false) goto L150;
        if (r28.l(r48, r46) == false) goto L150;
    L141:
        r31.getClass();
        if (r31.c(r48) <= 0) goto L140;
        if (Math.abs(r114) <= r28.b) goto L140;
        r119 = true;
    L150:
        r45 = r45 + 1;
    L151:
        r28.j(r24);
        goto L158
    L117:
        if (r28.g(r28.c) == false) goto L158;
        int r49 = r24.findPointerIndex(r28.c);
        float r50 = r24.getX(r49);
        float r51 = r24.getY(r49);
        float[] r52 = r28.f;
        int r53 = r28.c;
        int r54 = (int) (r50 - r52[r53]);
        int r55 = (int) (r51 - r28.g[r53]);
        int r56 = r28.r.getLeft() + r54;
        int r57 = r28.r.getTop() + r55;
        int r58 = r28.r.getLeft();
        int r120 = r28.r.getTop();
        if (r54 == 0) goto L122;
        r56 = r31.a(r28.r, r56, r54);
        ViewCompat.offsetLeftAndRight(r28.r, r56 - r58);
    L122:
        int r121 = r56;
        if (r55 == 0) goto L125;
        r57 = r31.b(r28.r, r57, r55);
        ViewCompat.offsetTopAndBottom(r28.r, r57 - r120);
    L125:
        int r122 = r57;
        if (r54 != 0) goto L128;
        if (r55 != 0) goto L128;
    L129:
        r28.j(r24);
    L128:
        r28.q.e(r28.r, r121, r122, r121 - r58, r122 - r120);
        goto L129
    L153:
        if (r28.f252a != 1) goto L155;
        r28.h();
    L155:
        r28.a();
        goto L158
    L156:
        float r59 = r24.getX();
        float r60 = r24.getY();
        int r61 = r24.getPointerId(0);
        View r62 = r28.e((int) r59, (int) r60);
        r28.i(r59, r60, r61);
        r28.l(r62, r61);
        int r63 = r28.h[r61];
        goto L158
    }

    public final void setPeekHeight(int r2) {
        if (r2 != (-1)) goto L8;
        if (this.f == true) goto L20;
        this.f = true;
    L13:
        if (this.o != 4) goto L22;
        WeakReference r1 = this.w;
        if (r1 == null) goto L23;
        View r3 = (View) r1.get();
        if (r3 == null) goto L24;
        r3.requestLayout();
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L20:
        return;
    L8:
        if (this.f == false) goto L10;
    L11:
        this.f = false;
        this.e = Math.max(0, r2);
        this.k = this.v - r2;
        goto L13
    L10:
        if (this.e != r2) goto L11;
    }

    public final void setState(final int r3) {
        if (r3 != this.o) goto L5;
        return;
    L5:
        WeakReference r0 = this.w;
        if (r0 == null) goto L8;
        final View r1 = (View) r0.get();
        if (r1 != null) goto L22;
        return;
    L22:
        ViewParent r2 = r1.getParent();
        if (r2 != null) goto L25;
    L29:
        c(r1, r3);
        return;
    L25:
        if (r2.isLayoutRequested() == false) goto L29;
        if (ViewCompat.isAttachedToWindow(r1) == false) goto L29;
        r1.post(new AnonymousClass1(this, r1, r3));
        return;
    L8:
        if (r3 != 4) goto L10;
    L17:
        this.o = r3;
        return;
    L10:
        if (r3 == 3) goto L17;
        if (r3 == 6) goto L17;
        if (this.l == true) goto L16;
        return;
    L16:
        if (r3 == 5) goto L17;
    }

    public final void setStateInternal(int r5) {
        if (this.o != r5) goto L5;
        return;
    L5:
        this.o = r5;
        int r1 = 0;
        if (r5 != 6) goto L8;
    L15:
        updateImportantForAccessibility(true);
    L16:
        View r0 = (View) this.w.get();
    L17:
        ArrayList r2 = this.y;
        if (r1 >= r2.size()) goto L20;
        ((BottomSheetCallback) r2.get(r1)).b(r0, r5);
        r1 = r1 + 1;
        goto L17
    L20:
        return;
    L8:
        if (r5 == 3) goto L15;
        if (r5 != 5) goto L13;
    L14:
        updateImportantForAccessibility(false);
        goto L16
    L13:
        if (r5 != 4) goto L16;
        goto L14
    }

    public final boolean shouldHide(View r5, float r6) {
        if (this.n == false) goto L6;
        return true;
    L6:
        if (r6 != 0.0f) goto L18;
        if (this.b == true) goto L10;
        int r7 = this.v - b();
        if (r5.getTop() <= (b() + (r7 / 2))) goto L16;
        return true;
    L16:
        return false;
    L10:
        if (r5.getTop() <= ((this.h / 2) + this.k)) goto L12;
        return true;
    L12:
        return false;
    L18:
        if (this.p != 4) goto L27;
        if (this.e <= (OUnitExtensionKt.b(r5.getContext()) / 2)) goto L27;
        if (r6 <= (this.f242d * 0.08f)) goto L25;
        return true;
    L25:
        return false;
    L27:
        if ((Math.abs(((r6 * 0.1f) + r5.getTop()) - this.k) / this.e) <= 0.5f) goto L30;
        return true;
    L30:
        return false;
    }

    public final void updateImportantForAccessibility(boolean r7) {
        WeakReference r0 = this.w;
        if (r0 != null) goto L5;
        return;
    L5:
        ViewParent r1 = ((View) r0.get()).getParent();
        if ((r1 instanceof CoordinatorLayout) == true) goto L8;
        return;
    L8:
        CoordinatorLayout r2 = (CoordinatorLayout) r1;
        int r3 = r2.getChildCount();
        if (r7 == true) goto L11;
    L14:
        int r4 = 0;
    L15:
        if (r4 >= r3) goto L27;
        View r5 = r2.getChildAt(r4);
        if (r5 == this.w.get()) goto L26;
        if (r7 == true) goto L25;
        HashMap r6 = this.D;
        if (r6 == null) goto L26;
        if (r6.containsKey(r5) == false) goto L26;
        ViewCompat.setImportantForAccessibility(r5, ((Integer) this.D.get(r5)).intValue());
        goto L26
    L25:
        this.D.put(r5, Integer.valueOf(r5.getImportantForAccessibility()));
        ViewCompat.setImportantForAccessibility(r5, 4);
    L26:
        r4 = r4 + 1;
        goto L15
    L27:
        if (r7 == true) goto L36;
        this.D = null;
        return;
    L36:
        return;
    L11:
        if (this.D != null) goto L13;
        this.D = new HashMap(r3);
        goto L14
    }

    public BottomSheetBehavior(Context r5, AttributeSet r6) {
        super(r5, r6);
        this.f241a = true;
        this.b = false;
        this.c = -1;
        this.m = true;
        this.n = false;
        this.o = 4;
        this.p = 4;
        this.y = new ArrayList();
        this.E = true;
        this.F = false;
        this.G = true;
        this.H = 600;
        this.I = new AnonymousClass2(this);
        this.f240J = new AnonymousClass3(this);
        TypedArray r7 = r5.obtainStyledAttributes(r6, R.styleable.BottomSheetBehavior_Layout);
        TypedValue r3 = r7.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (r3 == null) goto L7;
        int r4 = r3.data;
        if (r4 != (-1)) goto L7;
        setPeekHeight(r4);
    L8:
        this.l = r7.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false);
        boolean r0 = r7.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true);
        if (this.f241a == r0) goto L21;
        this.f241a = r0;
        if (this.w == null) goto L15;
        calculateCollapsedOffset();
    L15:
        if (this.f241a == true) goto L17;
    L19:
        int r1 = this.o;
    L20:
        setStateInternal(r1);
        goto L21
    L17:
        if (this.o != 6) goto L19;
        r1 = 3;
    L21:
        this.n = r7.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false);
        r7.recycle();
        this.f242d = ViewConfiguration.get(r5).getScaledMaximumFlingVelocity();
        return;
    L7:
        setPeekHeight(r7.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        goto L8
    }
}
