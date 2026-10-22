package com.obric.oui.panel;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    int A;
    private int B;
    boolean C;
    private Map<View, Integer> D;
    boolean E;
    private e F;
    private boolean G;
    private boolean H;
    private int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final com.obric.oui.panel.c.AbstractC0294c f11154J;
    private final com.obric.oui.panel.c.AbstractC0294c K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f11155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f11156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f11157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f11158d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f11159e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f11160f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f11161g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected int f11162h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f11163i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f11164j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected int f11165k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    boolean f11166l;
    private boolean m;
    private boolean n;
    int o;
    int p;
    com.obric.oui.panel.c q;
    com.obric.oui.panel.a r;
    private boolean s;
    private int t;
    private boolean u;
    protected int v;
    WeakReference<V> w;
    WeakReference<View> x;

    @NonNull
    private final ArrayList<d> y;
    private VelocityTracker z;

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final int f11167f;

        class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            public SavedState a(Parcel r2) {
                return new SavedState(r2, null);
            }

            public SavedState b(Parcel r1, ClassLoader r2) {
                return new SavedState(r1, r2);
            }

            public SavedState[] c(int r1) {
                return new SavedState[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r1) {
                return a(r1);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public /* bridge */ /* synthetic */ SavedState createFromParcel(Parcel r1, ClassLoader r2) {
                return b(r1, r2);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object[] newArray(int r1) {
                return c(r1);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r1, ClassLoader r2) {
            super(r1, r2);
            this.f11167f = r1.readInt();
        }

        public SavedState(Parcelable r1, int r2) {
            super(r1);
            this.f11167f = r2;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.f11167f);
        }
    }

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f11168f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f11169g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f11170h;

        a(BottomSheetBehavior r1, View r2, int r3) {
            this.f11170h = r1;
            this.f11168f = r2;
            this.f11169g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11170h.n(this.f11168f, this.f11169g);
        }
    }

    class b extends com.obric.oui.panel.c.AbstractC0294c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f11171a;

        b(BottomSheetBehavior r1) {
            this.f11171a = r1;
        }

        @Override // com.obric.oui.panel.c.AbstractC0294c
        public int a(@NonNull View r1, int r2, int r3) {
            return r1.getLeft();
        }

        @Override // com.obric.oui.panel.c.AbstractC0294c
        public int b(@NonNull View r1, int r2, int r3) {
            int r4 = BottomSheetBehavior.c(this.f11171a);
            BottomSheetBehavior r0 = this.f11171a;
            if (r0.f11166l == false) goto L5;
            int r5 = r0.v;
        L7:
            return MathUtils.clamp(r2, r4, r5);
        L5:
            r5 = r0.f11165k;
            goto L7
        }

        @Override // com.obric.oui.panel.c.AbstractC0294c
        public int e(@NonNull View r1) {
            BottomSheetBehavior r0 = this.f11171a;
            if (r0.f11166l == false) goto L7;
            return r0.v;
        L7:
            return r0.f11165k;
        }

        @Override // com.obric.oui.panel.c.AbstractC0294c
        public void j(int r2) {
            if (r2 == 1) goto L5;
            return;
        L5:
            if (BottomSheetBehavior.a(this.f11171a) == false) goto L9;
            this.f11171a.setStateInternal(1);
            return;
        }

        @Override // com.obric.oui.panel.c.AbstractC0294c
        public void k(@NonNull View r1, int r2, int r3, int r4, int r5) {
            this.f11171a.dispatchOnSlide(r3);
        }

        @Override // com.obric.oui.panel.c.AbstractC0294c
        public void l(@NonNull View r3, float r4, float r5) {
            int[] r6 = BottomSheetBehavior.b(this.f11171a, r3, r4, r5);
            int r7 = r6[0];
            int r8 = r6[1];
            BottomSheetBehavior r0 = this.f11171a;
            r0.p = r8;
            if (r0.q.G(r3.getLeft(), r7) == false) goto L5;
            this.f11171a.setStateInternal(2);
            ViewCompat.postOnAnimation(r3, new g(this.f11171a, r3, r8));
            return;
        L5:
            this.f11171a.setStateInternal(r8);
        }

        @Override // com.obric.oui.panel.c.AbstractC0294c
        public boolean m(@NonNull View r6, int r7) {
            BottomSheetBehavior r0 = this.f11171a;
            int r1 = r0.o;
            if (r1 != 1) goto L6;
            return false;
        L6:
            if (r0.C == false) goto L9;
            return false;
        L9:
            if (r1 == 3) goto L11;
        L17:
            WeakReference<V> r5 = this.f11171a.w;
            if (r5 == null) goto L23;
            if (r5.get() != r6) goto L23;
            return true;
        L23:
            return false;
        L11:
            if (r0.A != r7) goto L17;
            View r8 = r0.x.get();
            if (r8 == null) goto L17;
            if (r8.canScrollVertically(-1) == false) goto L17;
            return false;
        }
    }

    class c extends com.obric.oui.panel.c.AbstractC0294c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f11172a;

        c(BottomSheetBehavior r1) {
            this.f11172a = r1;
        }

        @Override // com.obric.oui.panel.c.AbstractC0294c
        public int a(@NonNull View r1, int r2, int r3) {
            return BottomSheetBehavior.d(this.f11172a).a(r1, r2, r3);
        }

        @Override // com.obric.oui.panel.c.AbstractC0294c
        public int b(@NonNull View r1, int r2, int r3) {
            return BottomSheetBehavior.d(this.f11172a).b(r1, r2, r3);
        }

        @Override // com.obric.oui.panel.c.AbstractC0294c
        public int e(@NonNull View r1) {
            return BottomSheetBehavior.d(this.f11172a).e(r1);
        }

        @Override // com.obric.oui.panel.c.AbstractC0294c
        public void j(int r1) {
            BottomSheetBehavior.d(this.f11172a).j(r1);
        }

        @Override // com.obric.oui.panel.c.AbstractC0294c
        public void k(@NonNull View r7, int r8, int r9, int r10, int r11) {
            BottomSheetBehavior.d(this.f11172a).k(r7, r8, r9, r10, r11);
        }

        @Override // com.obric.oui.panel.c.AbstractC0294c
        public void l(@NonNull View r9, float r10, float r11) {
            int[] r0 = BottomSheetBehavior.b(this.f11172a, r9, r10, r11);
            int r5 = r0[0];
            int r1 = r0[1];
            BottomSheetBehavior r2 = this.f11172a;
            r2.p = r1;
            if (r2.r.r(r9, r9.getLeft(), r5, (int) r10, (int) r11) == false) goto L5;
            this.f11172a.setStateInternal(2);
            ViewCompat.postOnAnimation(r9, new f(this.f11172a, r9, r1));
            return;
        L5:
            this.f11172a.setStateInternal(r1);
        }

        @Override // com.obric.oui.panel.c.AbstractC0294c
        public boolean m(@NonNull View r1, int r2) {
            return BottomSheetBehavior.d(this.f11172a).m(r1, r2);
        }
    }

    public static abstract class d {
        public d() {
        }

        public void a(float r1) {
        }

        public void b(float r1) {
        }

        public abstract void c(@NonNull View r1, float r2);

        public abstract void d(@NonNull View r1, int r2);
    }

    public interface e {
        boolean a(MotionEvent r1, int r2, int r3);
    }

    private class f implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final View f11173f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f11174g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f11175h;

        f(BottomSheetBehavior r1, View r2, int r3) {
            this.f11175h = r1;
            this.f11173f = r2;
            this.f11174g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.obric.oui.panel.a r0 = this.f11175h.r;
            if (r0 != null) goto L5;
        L7:
            this.f11175h.setStateInternal(this.f11174g);
            return;
        L5:
            if (r0.h(this.f11173f, true) == false) goto L7;
            ViewCompat.postOnAnimation(this.f11173f, this);
        }
    }

    private class g implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final View f11176f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f11177g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f11178h;

        g(BottomSheetBehavior r1, View r2, int r3) {
            this.f11178h = r1;
            this.f11176f = r2;
            this.f11177g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.obric.oui.panel.c r0 = this.f11178h.q;
            if (r0 != null) goto L5;
        L7:
            this.f11178h.setStateInternal(this.f11177g);
            return;
        L5:
            if (r0.k(true) == false) goto L7;
            ViewCompat.postOnAnimation(this.f11176f, this);
        }
    }

    public BottomSheetBehavior() {
        this.f11155a = true;
        this.f11156b = false;
        this.f11157c = -1;
        this.m = true;
        this.n = false;
        this.o = 4;
        this.p = 4;
        this.y = new ArrayList();
        this.E = true;
        this.G = false;
        this.H = true;
        this.I = 600;
        this.f11154J = new b(this);
        this.K = new c(this);
    }

    public BottomSheetBehavior(Context r6, AttributeSet r7) {
        super(r6, r7);
        this.f11155a = true;
        this.f11156b = false;
        this.f11157c = -1;
        this.m = true;
        this.n = false;
        this.o = 4;
        this.p = 4;
        this.y = new ArrayList();
        this.E = true;
        this.G = false;
        this.H = true;
        this.I = 600;
        this.f11154J = new b(this);
        this.K = new c(this);
        TypedArray r8 = r6.obtainStyledAttributes(r7, R.styleable.BottomSheetBehavior_Layout);
        int r3 = R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight;
        TypedValue r4 = r8.peekValue(r3);
        if (r4 == null) goto L7;
        int r5 = r4.data;
        if (r5 != (-1)) goto L7;
        setPeekHeight(r5);
    L8:
        setHideable(r8.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setFitToContents(r8.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        setSkipCollapsed(r8.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        r8.recycle();
        this.f11158d = ViewConfiguration.get(r6).getScaledMaximumFlingVelocity();
        return;
    L7:
        setPeekHeight(r8.getDimensionPixelSize(r3, -1));
        goto L8
    }

    static /* synthetic */ boolean a(BottomSheetBehavior r0) {
        return r0.m;
    }

    static /* synthetic */ int[] b(BottomSheetBehavior r0, View r1, float r2, float r3) {
        return r0.g(r1, r2, r3);
    }

    static /* synthetic */ int c(BottomSheetBehavior r0) {
        return r0.getExpandedOffset();
    }

    static /* synthetic */ com.obric.oui.panel.c.AbstractC0294c d(BottomSheetBehavior r0) {
        return r0.f11154J;
    }

    public static <V extends View> BottomSheetBehavior<V> f(V r1) {
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof CoordinatorLayout.LayoutParams) == false) goto L11;
        CoordinatorLayout.Behavior r3 = ((CoordinatorLayout.LayoutParams) r2).getBehavior();
        if ((r3 instanceof BottomSheetBehavior) == false) goto L9;
        return (BottomSheetBehavior) r3;
    L9:
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    L11:
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private int[] g(@NonNull View r8, float r9, float r10) {
        int r2 = 6;
        int r4 = 4;
        if (r10 >= 0.0f) goto L16;
        if (Math.abs(r10) <= 1500.0f) goto L16;
        if (this.f11155a == false) goto L9;
        int r7 = this.f11163i;
        r4 = 3;
    L45:
        return new int[]{r7, r4};
    L9:
        int r11 = r8.getTop();
        r7 = this.f11164j;
        if (r11 > r7) goto L14;
        r7 = 0;
    L13:
        r2 = 3;
    L14:
        r4 = r2;
    L16:
        if (this.f11166l == false) goto L25;
        if (shouldHide(r8, r10) == false) goto L25;
        if (r8.getTop() <= this.f11165k) goto L22;
    L23:
        r7 = this.v;
        r4 = 5;
        goto L45
    L22:
        if (Math.abs(r9) < Math.abs(r10)) goto L23;
    L25:
        if (r10 != 0.0f) goto L27;
    L30:
        int r12 = r8.getTop();
        if (this.f11155a == true) goto L33;
        int r13 = this.f11164j;
        if (r12 >= r13) goto L42;
        if (r12 >= Math.abs(r12 - this.f11165k)) goto L43;
        r7 = 0;
    L43:
        r7 = this.f11164j;
        goto L14
    L42:
        if (Math.abs(r12 - r13) < Math.abs(r12 - this.f11165k)) goto L43;
    L35:
        r7 = this.f11165k;
        r2 = 4;
        goto L14
    L33:
        if (Math.abs(r12 - this.f11163i) >= Math.abs(r12 - this.f11165k)) goto L35;
        r7 = this.f11163i;
        goto L13
    L27:
        if (Math.abs(r9) > Math.abs(r10)) goto L30;
        r7 = this.f11165k;
        goto L45
    }

    private int getExpandedOffset() {
        if (this.f11155a == true) goto L7;
        return 0;
    L7:
        return this.f11163i;
    }

    private float getYVelocity() {
        VelocityTracker r0 = this.z;
        if (r0 != null) goto L6;
        return 0.0f;
    L6:
        r0.computeCurrentVelocity(1000, this.f11158d);
        return this.z.getYVelocity(this.A);
    }

    private void reset() {
        this.A = -1;
        VelocityTracker r0 = this.z;
        if (r0 == null) goto L6;
        r0.recycle();
        this.z = null;
        return;
    }

    private void updateImportantForAccessibility(boolean r9) {
        int r0 = Build.VERSION.SDK_INT;
        WeakReference<V> r1 = this.w;
        if (r1 != null) goto L5;
        return;
    L5:
        ViewParent r2 = r1.get().getParent();
        if ((r2 instanceof CoordinatorLayout) == true) goto L8;
        return;
    L8:
        CoordinatorLayout r3 = (CoordinatorLayout) r2;
        int r4 = r3.getChildCount();
        if (r0 < 16) goto L15;
        if (r9 == false) goto L15;
        if (this.D != null) goto L14;
        this.D = new HashMap(r4);
        goto L15
    L14:
        return;
    L15:
        int r5 = 0;
    L16:
        if (r5 >= r4) goto L31;
        View r6 = r3.getChildAt(r5);
        if (r6 == this.w.get()) goto L30;
        if (r9 == true) goto L26;
        Map<View, Integer> r7 = this.D;
        if (r7 == null) goto L30;
        if (r7.containsKey(r6) == false) goto L30;
        int r8 = this.D.get(r6).intValue();
    L29:
        ViewCompat.setImportantForAccessibility(r6, r8);
        goto L30
    L26:
        if (r0 < 16) goto L28;
        this.D.put(r6, Integer.valueOf(r6.getImportantForAccessibility()));
    L28:
        r8 = 4;
    L30:
        r5 = r5 + 1;
        goto L16
    L31:
        if (r9 == true) goto L39;
        this.D = null;
        return;
    }

    protected void calculateCollapsedOffset() {
        if (this.f11155a == false) goto L5;
        int r0 = Math.max(this.v - this.f11162h, this.f11163i);
    L6:
        this.f11165k = r0;
        return;
    L5:
        r0 = this.v - this.f11162h;
        goto L6
    }

    void dispatchOnSlide(int r7) {
        V r0 = this.w.get();
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.y.isEmpty() == true) goto L17;
        int r2 = 0;
        if (r7 <= this.f11165k) goto L12;
    L9:
        if (r2 >= this.y.size()) goto L18;
        d r1 = this.y.get(r2);
        int r3 = this.f11165k;
        r1.c(r0, (r3 - r7) / (this.v - r3));
        r2 = r2 + 1;
        goto L9
    L18:
        return;
    L12:
        if (r2 >= this.y.size()) goto L19;
        d r4 = this.y.get(r2);
        int r5 = this.f11165k;
        r4.c(r0, (r5 - r7) / (r5 - getExpandedOffset()));
        r2 = r2 + 1;
        goto L12
    L19:
        return;
    }

    public void e(@NonNull d r2) {
        if (this.y.contains(r2) == true) goto L6;
        this.y.add(r2);
        return;
    }

    @Nullable
    @VisibleForTesting
    View findScrollingChild(@Nullable View r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (ViewCompat.isNestedScrollingEnabled(r5) == false) goto L9;
        return r5;
    L9:
        if ((r5 instanceof ViewGroup) == false) goto L16;
        ViewGroup r6 = (ViewGroup) r5;
        int r1 = 0;
        int r2 = r6.getChildCount();
    L11:
        if (r1 >= r2) goto L16;
        View r3 = findScrollingChild(r6.getChildAt(r1));
        if (r3 != null) goto L14;
        r1 = r1 + 1;
        goto L11
    L14:
        return r3;
    L16:
        return null;
    }

    public final int getState() {
        return this.o;
    }

    public void h(@NonNull d r1) {
        this.y.remove(r1);
    }

    public void i(boolean r1) {
        this.G = r1;
    }

    public boolean isHideable() {
        return this.f11166l;
    }

    public void j(boolean r1) {
        this.H = r1;
    }

    @Deprecated
    public void k(d r3) {
        Log.w("BottomSheetBehavior", "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.y.clear();
        if (r3 == null) goto L6;
        this.y.add(r3);
        return;
    }

    public void l(boolean r1) {
        this.f11156b = r1;
    }

    public void m(int r1) {
        this.f11157c = r1;
    }

    void n(View r4, int r5) {
        if (r5 != 4) goto L6;
        int r0 = this.f11165k;
    L21:
        if (this.q.I(r4, r4.getLeft(), r0) == false) goto L23;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r4, new g(this, r4, r5));
        return;
    L23:
        setStateInternal(r5);
        return;
    L6:
        if (r5 != 6) goto L13;
        int r1 = this.f11164j;
        if (this.f11155a == false) goto L12;
        int r2 = this.f11163i;
        if (r1 > r2) goto L12;
        r5 = 3;
        r0 = r2;
    L12:
        r0 = r1;
        goto L21
    L13:
        if (r5 != 3) goto L16;
        r0 = getExpandedOffset();
        goto L21
    L16:
        if (this.f11166l == false) goto L26;
        if (r5 != 5) goto L26;
        r0 = this.v;
    L26:
        throw new IllegalArgumentException("Illegal state argument: " + r5);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout r9, V r10, MotionEvent r11) {
        if (r10.isShown() == true) goto L5;
    L76:
        this.s = true;
        return false;
    L5:
        if (this.m == false) goto L76;
        int r0 = r11.getActionMasked();
        if (r0 != 0) goto L11;
        reset();
    L11:
        if (this.z != null) goto L13;
        this.z = VelocityTracker.obtain();
    L13:
        this.z.addMovement(r11);
        View r3 = null;
        if (r0 == 0) goto L23;
        if (r0 != 1) goto L17;
    L19:
        this.C = false;
        this.A = -1;
        if (this.s == false) goto L39;
        this.s = false;
        return false;
    L39:
        if (this.G == false) goto L48;
        if (this.s == true) goto L48;
        com.obric.oui.panel.a r4 = this.r;
        if (r4 == null) goto L48;
        if (r4.s(r10, r11) == false) goto L48;
        return true;
    L48:
        if (this.s == true) goto L54;
        com.obric.oui.panel.c r12 = this.q;
        if (r12 == null) goto L54;
        if (r12.H(r11) == false) goto L54;
        return true;
    L54:
        WeakReference<View> r13 = this.x;
        if (r13 == null) goto L58;
        r3 = r13.get();
    L58:
        if (r0 != 2) goto L70;
        if (r3 == null) goto L70;
        if (this.s == true) goto L70;
        if (this.o == 1) goto L70;
        if (r9.isPointInChildBounds(r3, (int) r11.getX(), (int) r11.getY()) == true) goto L70;
        if (this.q == null) goto L70;
        if (Math.abs(this.B - r11.getY()) <= this.q.u()) goto L70;
    L75:
        return true;
    L70:
        e r14 = this.F;
        if (r14 != null) goto L73;
        return false;
    L73:
        if (r14.a(r11, this.o, this.p) == true) goto L75;
        return false;
    L17:
        if (r0 == 3) goto L19;
    L23:
        int r5 = (int) r11.getX();
        this.B = (int) r11.getY();
        WeakReference<View> r6 = this.x;
        if (r6 == null) goto L26;
        View r7 = r6.get();
    L27:
        if (r7 == null) goto L32;
        if (r9.isPointInChildBounds(r7, r5, this.B) == false) goto L32;
        this.A = r11.getPointerId(r11.getActionIndex());
        this.C = true;
    L32:
        if (this.A == (-1)) goto L34;
    L36:
        boolean r8 = false;
    L37:
        this.s = r8;
        goto L39
    L34:
        if (r9.isPointInChildBounds(r10, r5, this.B) == true) goto L36;
        r8 = true;
        goto L37
    L26:
        r7 = null;
        goto L27
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout r9, V r10, int r11) {
        if (this.E == true) goto L5;
    L9:
        int r0 = r10.getTop();
        r9.onLayoutChild(r10, r11);
        this.v = r9.getHeight();
        if (this.f11160f == true) goto L12;
        int r12 = this.f11159e;
    L24:
        this.f11162h = r12;
        if (this.f11157c <= 0) goto L29;
        int r13 = r10.getHeight();
        int r3 = this.f11157c;
        if (r13 <= r3) goto L29;
        int r14 = this.v;
    L30:
        this.f11163i = Math.max(0, r14 - r3);
        this.f11164j = this.v / 2;
        calculateCollapsedOffset();
        int r15 = this.o;
        if (r15 != 3) goto L35;
        int r16 = getExpandedOffset();
    L33:
        ViewCompat.offsetTopAndBottom(r10, r16);
    L49:
        if (this.q != null) goto L52;
        com.obric.oui.panel.c r17 = com.obric.oui.panel.c.l(r9, this.f11154J);
        this.q = r17;
        r17.F(this.I);
    L52:
        if (this.G == true) goto L54;
    L56:
        this.w = new WeakReference(r10);
        this.x = new WeakReference(findScrollingChild(r10));
        return true;
    L54:
        if (this.r != null) goto L56;
        this.r = new com.obric.oui.panel.a(r9.getContext(), r9, this.K);
        goto L56
    L35:
        if (r15 != 6) goto L38;
        r16 = this.f11164j;
        goto L33
    L38:
        if (this.f11166l == false) goto L43;
        if (r15 != 5) goto L43;
        r16 = this.v;
    L43:
        if (r15 != 4) goto L45;
        r16 = this.f11165k;
        goto L33
    L45:
        if (r15 == 1) goto L47;
        if (r15 != 2) goto L49;
    L47:
        ViewCompat.offsetTopAndBottom(r10, r0 - r10.getTop());
    L29:
        r14 = this.v;
        r3 = r10.getHeight();
        goto L30
    L12:
        if (this.f11161g != 0) goto L14;
        this.f11161g = r9.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
    L14:
        float r18 = r9.getContext().getResources().getConfiguration().fontScale;
        com.obric.oui.common.util.e.a("check fontScale:" + r18);
        if (this.H == false) goto L17;
        double r2 = 0.6d;
    L18:
        double r4 = this.f11161g;
        int r6 = this.f11157c;
        if (r6 <= 0) goto L21;
        double r5 = r6;
    L22:
        r12 = (int) Math.max(r4, r5);
        goto L24
    L21:
        r5 = ((double) r18) * (((double) this.v) * r2);
        goto L22
    L17:
        r2 = 1.0d;
        goto L18
    L5:
        if (ViewCompat.getFitsSystemWindows(r9) == false) goto L9;
        if (ViewCompat.getFitsSystemWindows(r10) == true) goto L9;
        r10.setFitsSystemWindows(true);
        goto L9
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout r3, @NonNull V r4, @NonNull View r5, float r6, float r7) {
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
    public void onNestedPreScroll(@NonNull CoordinatorLayout r2, @NonNull V r3, @NonNull View r4, int r5, int r6, @NonNull int[] r7, int r8) {
        if (r8 != 1) goto L6;
        return;
    L6:
        if (r4 == this.x.get()) goto L8;
        return;
    L8:
        int r9 = r3.getTop();
        int r10 = r9 - r6;
        if (r6 > 0) goto L11;
        if (r6 < 0) goto L21;
    L32:
        dispatchOnSlide(r3.getTop());
        this.t = r6;
        this.u = true;
        return;
    L21:
        if (r4.canScrollVertically(-1) == true) goto L32;
        int r11 = this.f11165k;
        if (r10 <= r11) goto L29;
        if (this.f11166l == true) goto L29;
        r7[1] = r9 - r11;
        ViewCompat.offsetTopAndBottom(r3, -r7[1]);
        int r12 = 4;
    L13:
        setStateInternal(r12);
    L29:
        if (this.m == true) goto L31;
        return;
    L31:
        r7[1] = r6;
    L18:
        ViewCompat.offsetTopAndBottom(r3, -r6);
        setStateInternal(1);
        goto L32
    L11:
        if (r10 >= getExpandedOffset()) goto L15;
        r7[1] = r9 - getExpandedOffset();
        ViewCompat.offsetTopAndBottom(r3, -r7[1]);
        r12 = 3;
        goto L13
    L15:
        if (this.m == true) goto L17;
        return;
    L17:
        r7[1] = r6;
        goto L18
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(CoordinatorLayout r2, V r3, Parcelable r4) {
        SavedState r5 = (SavedState) r4;
        super.onRestoreInstanceState(r2, r3, r5.getSuperState());
        int r6 = r5.f11167f;
        if (r6 != 1) goto L5;
    L6:
        r6 = 4;
    L7:
        this.o = r6;
        return;
    L5:
        if (r6 != 2) goto L7;
        goto L6
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public Parcelable onSaveInstanceState(CoordinatorLayout r2, V r3) {
        return new SavedState(super.onSaveInstanceState(r2, r3), this.o);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout r1, @NonNull V r2, @NonNull View r3, @NonNull View r4, int r5, int r6) {
        this.t = 0;
        this.u = false;
        if ((r5 & 2) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(@NonNull CoordinatorLayout r4, @NonNull V r5, @NonNull View r6, int r7) {
        int r0 = 3;
        if (r5.getTop() != getExpandedOffset()) goto L7;
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
        int r8 = getExpandedOffset();
    L35:
        this.p = r0;
        if (this.q.I(r5, r5.getLeft(), r8) == false) goto L38;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r5, new g(this, r5, r0));
    L39:
        this.u = false;
        return;
    L38:
        setStateInternal(r0);
        goto L39
    L15:
        if (this.f11166l == false) goto L20;
        if (shouldHide(r5, getYVelocity()) == false) goto L20;
        r8 = this.v;
        r0 = 5;
    L20:
        if (this.t != 0) goto L34;
        int r9 = r5.getTop();
        if (this.f11155a == true) goto L24;
        int r1 = this.f11164j;
        if (r9 >= r1) goto L32;
        if (r9 >= Math.abs(r9 - this.f11165k)) goto L33;
        r8 = 0;
    L33:
        r8 = this.f11164j;
        r0 = 6;
        goto L35
    L32:
        if (Math.abs(r9 - r1) >= Math.abs(r9 - this.f11165k)) goto L34;
    L24:
        if (Math.abs(r9 - this.f11163i) >= Math.abs(r9 - this.f11165k)) goto L34;
        r8 = this.f11163i;
    L34:
        r8 = this.f11165k;
        r0 = 4;
        goto L35
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout r5, V r6, MotionEvent r7) {
        if (r6.isShown() == true) goto L6;
        return false;
    L6:
        int r8 = r7.getActionMasked();
        if (this.o != 1) goto L10;
        if (r8 != 0) goto L10;
        return true;
    L10:
        if (r8 != 0) goto L13;
        reset();
    L13:
        if (this.z != null) goto L15;
        this.z = VelocityTracker.obtain();
    L15:
        this.z.addMovement(r7);
        if (this.G == false) goto L22;
        com.obric.oui.panel.a r0 = this.r;
        if (r0 == null) goto L22;
        if (r0.n() == false) goto L22;
        this.r.p(r7, r6, this.o, this.z);
    L26:
        if (this.G == false) goto L34;
        com.obric.oui.panel.a r1 = this.r;
        if (r1 == null) goto L34;
        if (r1.n() == false) goto L34;
        return !this.s;
    L34:
        if (r8 != 2) goto L41;
        if (this.s == true) goto L41;
        if (Math.abs(this.B - r7.getY()) <= this.q.u()) goto L41;
        this.q.b(r6, r7.getPointerId(r7.getActionIndex()));
    L41:
        return !this.s;
    L22:
        com.obric.oui.panel.c r2 = this.q;
        if (r2 == null) goto L26;
        r2.z(r7);
        goto L26
    }

    public void setDraggable(boolean r1) {
        this.m = r1;
    }

    public void setFitToContents(boolean r2) {
        if (this.f11155a != r2) goto L5;
        return;
    L5:
        this.f11155a = r2;
        if (this.w == null) goto L9;
        calculateCollapsedOffset();
    L9:
        if (this.f11155a == true) goto L11;
    L13:
        int r3 = this.o;
    L14:
        setStateInternal(r3);
        return;
    L11:
        if (this.o != 6) goto L13;
        r3 = 3;
        goto L14
    }

    public void setHideable(boolean r1) {
        this.f11166l = r1;
    }

    public final void setPeekHeight(int r4) {
        boolean r0 = true;
        if (r4 != (-1)) goto L8;
        if (this.f11160f == true) goto L12;
        this.f11160f = true;
    L14:
        if (r0 == true) goto L16;
        return;
    L16:
        if (this.o != 4) goto L24;
        WeakReference<V> r3 = this.w;
        if (r3 == null) goto L25;
        V r5 = r3.get();
        if (r5 == null) goto L26;
        r5.requestLayout();
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L12:
        r0 = false;
        goto L14
    L8:
        if (this.f11160f == false) goto L10;
    L13:
        this.f11160f = false;
        this.f11159e = Math.max(0, r4);
        this.f11165k = this.v - r4;
        goto L14
    L10:
        if (this.f11159e == r4) goto L12;
        goto L12
    }

    public void setSkipCollapsed(boolean r1) {
        this.n = r1;
    }

    public final void setState(int r3) {
        if (r3 != this.o) goto L5;
        return;
    L5:
        WeakReference<V> r0 = this.w;
        if (r0 == null) goto L8;
        V r1 = r0.get();
        if (r1 != null) goto L22;
        return;
    L22:
        ViewParent r2 = r1.getParent();
        if (r2 != null) goto L25;
    L29:
        n(r1, r3);
        return;
    L25:
        if (r2.isLayoutRequested() == false) goto L29;
        if (ViewCompat.isAttachedToWindow(r1) == false) goto L29;
        r1.post(new a(this, r1, r3));
        return;
    L8:
        if (r3 != 4) goto L10;
    L17:
        this.o = r3;
        return;
    L10:
        if (r3 == 3) goto L17;
        if (r3 == 6) goto L17;
        if (this.f11166l == true) goto L16;
        return;
    L16:
        if (r3 == 5) goto L17;
    }

    void setStateInternal(int r4) {
        if (this.o != r4) goto L5;
        return;
    L5:
        this.o = r4;
        int r1 = 0;
        if (r4 != 6) goto L8;
    L15:
        updateImportantForAccessibility(true);
    L16:
        V r0 = this.w.get();
    L18:
        if (r1 >= this.y.size()) goto L20;
        this.y.get(r1).d(r0, r4);
        r1 = r1 + 1;
        goto L18
    L20:
        return;
    L8:
        if (r4 == 3) goto L15;
        if (r4 != 5) goto L13;
    L14:
        updateImportantForAccessibility(false);
        goto L16
    L13:
        if (r4 != 4) goto L16;
        goto L14
    }

    boolean shouldHide(View r5, float r6) {
        if (this.n == false) goto L6;
        return true;
    L6:
        if (r6 != 0.0f) goto L18;
        if (this.f11156b == false) goto L14;
        if (r5.getTop() <= (this.f11165k + (this.f11162h / 2))) goto L12;
        return true;
    L12:
        return false;
    L14:
        if (r5.getTop() <= (((this.v - getExpandedOffset()) / 2) + getExpandedOffset())) goto L16;
        return true;
    L16:
        return false;
    L18:
        if (this.p != 4) goto L27;
        if (this.f11159e <= (com.obric.oui.common.util.f.b(r5.getContext()) / 2)) goto L27;
        if (r6 <= (this.f11158d * 0.08f)) goto L25;
        return true;
    L25:
        return false;
    L27:
        if ((Math.abs((r5.getTop() + (r6 * 0.1f)) - this.f11165k) / this.f11159e) <= 0.5f) goto L30;
        return true;
    L30:
        return false;
    }
}
