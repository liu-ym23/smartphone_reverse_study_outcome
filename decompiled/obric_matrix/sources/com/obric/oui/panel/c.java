package com.obric.oui.panel;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    private static final Interpolator x = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f11217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float[] f11218d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float[] f11219e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float[] f11220f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float[] f11221g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int[] f11222h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int[] f11223i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int[] f11224j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f11225k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private VelocityTracker f11226l;
    private float m;
    private float n;
    private int o;
    private int p;
    private OverScroller q;
    private final AbstractC0294c r;
    private View s;
    private boolean t;
    private final ViewGroup u;
    private int v;
    private final Runnable w;

    class a implements Interpolator {
        a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float r2) {
            float r3 = r2 - 1.0f;
            return ((((r3 * r3) * r3) * r3) * r3) + 1.0f;
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f11227f;

        b(c r1) {
            this.f11227f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11227f.E(0);
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.panel.c$c, reason: collision with other inner class name */
    public static abstract class AbstractC0294c {
        public AbstractC0294c() {
        }

        public abstract int a(@NonNull View r1, int r2, int r3);

        public abstract int b(@NonNull View r1, int r2, int r3);

        public int c(int r1) {
            return r1;
        }

        public int d(@NonNull View r1) {
            return 0;
        }

        public abstract int e(@NonNull View r1);

        public void f(int r1, int r2) {
        }

        public boolean g(int r1) {
            return false;
        }

        public void h(int r1, int r2) {
        }

        public void i(@NonNull View r1, int r2) {
        }

        public abstract void j(int r1);

        public abstract void k(@NonNull View r1, int r2, int r3, @Px int r4, @Px int r5);

        public abstract void l(@NonNull View r1, float r2, float r3);

        public abstract boolean m(@NonNull View r1, int r2);
    }

    static {
        x = new a();
    }

    private c(@NonNull Context r2, @NonNull ViewGroup r3, @NonNull AbstractC0294c r4) {
        this.f11217c = -1;
        this.v = 600;
        this.w = new b(this);
        if (r3 == null) goto L10;
        if (r4 == null) goto L8;
        this.u = r3;
        this.r = r4;
        ViewConfiguration r5 = ViewConfiguration.get(r2);
        this.o = (int) ((r2.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f11216b = r5.getScaledTouchSlop();
        this.m = r5.getScaledMaximumFlingVelocity();
        this.n = r5.getScaledMinimumFlingVelocity();
        this.q = new OverScroller(r2, x);
        return;
    L8:
        throw new IllegalArgumentException("Callback may not be null");
    L10:
        throw new IllegalArgumentException("Parent view may not be null");
    }

    private void A() {
        this.f11226l.computeCurrentVelocity(1000, this.m);
        m(e(this.f11226l.getXVelocity(this.f11217c), this.n, this.m), e(this.f11226l.getYVelocity(this.f11217c), this.n, this.m));
    }

    private void B(float r3, float r4, int r5) {
        int r0 = 1;
        if (c(r3, r4, r5, 1) == true) goto L7;
        r0 = 0;
    L7:
        if (c(r4, r3, r5, 4) == false) goto L10;
        r0 = r0 | 4;
    L10:
        if (c(r3, r4, r5, 2) == false) goto L13;
        r0 = r0 | 2;
    L13:
        if (c(r4, r3, r5, 8) == false) goto L15;
        r0 = r0 | 8;
    L15:
        if (r0 == 0) goto L18;
        int[] r6 = this.f11223i;
        r6[r5] = r6[r5] | r0;
        this.r.f(r0, r5);
        return;
    }

    private void C(float r3, float r4, int r5) {
        p(r5);
        float[] r0 = this.f11218d;
        this.f11220f[r5] = r3;
        r0[r5] = r3;
        float[] r1 = this.f11219e;
        this.f11221g[r5] = r4;
        r1[r5] = r4;
        this.f11222h[r5] = s((int) r3, (int) r4);
        this.f11225k |= 1 << r5;
    }

    private void D(MotionEvent r7) {
        int r0 = r7.getPointerCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        int r2 = r7.getPointerId(r1);
        if (x(r2) == false) goto L8;
        float r3 = r7.getX(r1);
        float r4 = r7.getY(r1);
        this.f11220f[r2] = r3;
        this.f11221g[r2] = r4;
    L8:
        r1 = r1 + 1;
        goto L3
    }

    private boolean c(float r4, float r5, int r6, int r7) {
        float r8 = Math.abs(r4);
        float r9 = Math.abs(r5);
        if ((this.f11222h[r6] & r7) == r7) goto L5;
        return false;
    L5:
        if ((this.p & r7) != 0) goto L7;
        return false;
    L7:
        if ((this.f11224j[r6] & r7) != r7) goto L9;
        return false;
    L9:
        if ((this.f11223i[r6] & r7) == r7) goto L30;
        int r0 = this.f11216b;
        if (r8 > r0) goto L16;
        if (r9 > r0) goto L16;
        return false;
    L16:
        if (r8 >= (r9 * 0.5f)) goto L22;
        if (this.r.g(r7) == false) goto L22;
        int[] r3 = this.f11224j;
        r3[r6] = r3[r6] | r7;
        return false;
    L22:
        if ((this.f11223i[r6] & r7) == 0) goto L24;
        return false;
    L24:
        if (r8 <= this.f11216b) goto L32;
        return true;
    L32:
        return false;
    L30:
        return false;
    }

    private boolean d(View r5, float r6, float r7) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (this.r.d(r5) <= 0) goto L8;
        boolean r1 = true;
    L10:
        if (this.r.e(r5) <= 0) goto L12;
        boolean r8 = true;
    L13:
        if (r1 == false) goto L19;
        if (r8 == false) goto L19;
        float r9 = (r6 * r6) + (r7 * r7);
        int r4 = this.f11216b;
        if (r9 > (r4 * r4)) goto L18;
        return false;
    L18:
        return true;
    L19:
        if (r1 == true) goto L21;
        if (r8 == true) goto L26;
        return false;
    L26:
        if (Math.abs(r7) > this.f11216b) goto L28;
        return false;
    L28:
        return true;
    L21:
        if (Math.abs(r6) > this.f11216b) goto L23;
        return false;
    L23:
        return true;
    L12:
        r8 = false;
        goto L13
    L8:
        r1 = false;
        goto L10
    }

    private float e(float r2, float r3, float r4) {
        float r1 = Math.abs(r2);
        if (r1 >= r3) goto L6;
        return 0.0f;
    L6:
        if (r1 > r4) goto L8;
        return r2;
    L8:
        if (r2 <= 0.0f) goto L11;
        return r4;
    L11:
        return -r4;
    }

    private int f(int r1, int r2, int r3) {
        int r0 = Math.abs(r1);
        if (r0 >= r2) goto L6;
        return 0;
    L6:
        if (r0 <= r3) goto L11;
        if (r1 <= 0) goto L10;
        return r3;
    L10:
        return -r3;
    L11:
        return r1;
    }

    private void g() {
        float[] r0 = this.f11218d;
        if (r0 != null) goto L5;
        return;
    L5:
        Arrays.fill(r0, 0.0f);
        Arrays.fill(this.f11219e, 0.0f);
        Arrays.fill(this.f11220f, 0.0f);
        Arrays.fill(this.f11221g, 0.0f);
        Arrays.fill(this.f11222h, 0);
        Arrays.fill(this.f11223i, 0);
        Arrays.fill(this.f11224j, 0);
        this.f11225k = 0;
    }

    private void h(int r3) {
        if (this.f11218d != null) goto L5;
        return;
    L5:
        if (w(r3) == false) goto L10;
        this.f11218d[r3] = 0.0f;
        this.f11219e[r3] = 0.0f;
        this.f11220f[r3] = 0.0f;
        this.f11221g[r3] = 0.0f;
        this.f11222h[r3] = 0;
        this.f11223i[r3] = 0;
        this.f11224j[r3] = 0;
        int r0 = this.f11225k;
        this.f11225k = (~(1 << r3)) & r0;
        return;
    }

    private int i(int r4, int r5, int r6) {
        if (r4 != 0) goto L5;
        return 0;
    L5:
        int r0 = this.u.getWidth();
        float r1 = r0 / 2;
        float r2 = r1 + (n(Math.min(1.0f, Math.abs(r4) / r0)) * r1);
        int r7 = Math.abs(r5);
        if (r7 <= 0) goto L8;
        int r8 = Math.round(Math.abs(r2 / r7) * 1000.0f) * 4;
    L10:
        return Math.min(r8, t());
    L8:
        r8 = (int) (((Math.abs(r4) / r6) + 1.0f) * 256.0f);
        goto L10
    }

    private int j(View r7, int r8, int r9, int r10, int r11) {
        int r12 = f(r10, (int) this.n, (int) this.m);
        int r13 = f(r11, (int) this.n, (int) this.m);
        int r0 = Math.abs(r8);
        int r1 = Math.abs(r9);
        int r2 = Math.abs(r12);
        int r3 = Math.abs(r13);
        int r4 = r2 + r3;
        int r5 = r0 + r1;
        if (r12 == 0) goto L5;
        float r6 = r2;
        float r14 = r4;
    L6:
        float r15 = r6 / r14;
        if (r13 == 0) goto L9;
        float r16 = r3;
        float r17 = r4;
    L10:
        float r18 = r16 / r17;
        return (int) ((i(r8, r12, this.r.d(r7)) * r15) + (i(r9, r13, this.r.e(r7)) * r18));
    L9:
        r16 = r1;
        r17 = r5;
        goto L10
    L5:
        r6 = r0;
        r14 = r5;
        goto L6
    }

    public static c l(@NonNull ViewGroup r2, @NonNull AbstractC0294c r3) {
        return new c(r2.getContext(), r2, r3);
    }

    private void m(float r4, float r5) {
        this.t = true;
        this.r.l(this.s, r4, r5);
        this.t = false;
        if (this.f11215a != 1) goto L6;
        E(0);
        return;
    }

    private float n(float r1) {
        return (float) Math.sin((r1 - 0.5f) * 0.47123894f);
    }

    private void o(int r11, int r12, int r13, int r14) {
        int r0 = this.s.getLeft();
        int r1 = this.s.getTop();
        if (r13 == 0) goto L5;
        r11 = this.r.a(this.s, r11, r13);
        ViewCompat.offsetLeftAndRight(this.s, r11 - r0);
    L5:
        int r6 = r11;
        if (r14 == 0) goto L8;
        r12 = this.r.b(this.s, r12, r14);
        ViewCompat.offsetTopAndBottom(this.s, r12 - r1);
    L8:
        int r7 = r12;
        if (r13 != 0) goto L11;
        if (r14 != 0) goto L11;
        return;
    L11:
        AbstractC0294c r4 = this.r;
        View r5 = this.s;
        r4.k(r5, r6, r7, r6 - r0, r7 - r1);
    }

    private void p(int r10) {
        float[] r0 = this.f11218d;
        if (r0 != null) goto L5;
    L6:
        int r11 = r10 + 1;
        float[] r1 = new float[r11];
        float[] r2 = new float[r11];
        float[] r3 = new float[r11];
        float[] r4 = new float[r11];
        int[] r5 = new int[r11];
        int[] r6 = new int[r11];
        int[] r12 = new int[r11];
        if (r0 == null) goto L9;
        System.arraycopy(r0, 0, r1, 0, r0.length);
        float[] r7 = this.f11219e;
        System.arraycopy(r7, 0, r2, 0, r7.length);
        float[] r8 = this.f11220f;
        System.arraycopy(r8, 0, r3, 0, r8.length);
        float[] r9 = this.f11221g;
        System.arraycopy(r9, 0, r4, 0, r9.length);
        int[] r13 = this.f11222h;
        System.arraycopy(r13, 0, r5, 0, r13.length);
        int[] r14 = this.f11223i;
        System.arraycopy(r14, 0, r6, 0, r14.length);
        int[] r15 = this.f11224j;
        System.arraycopy(r15, 0, r12, 0, r15.length);
    L9:
        this.f11218d = r1;
        this.f11219e = r2;
        this.f11220f = r3;
        this.f11221g = r4;
        this.f11222h = r5;
        this.f11223i = r6;
        this.f11224j = r12;
        return;
    L5:
        if (r0.length <= r10) goto L6;
    }

    private boolean r(int r11, int r12, int r13, int r14) {
        int r2 = this.s.getLeft();
        int r3 = this.s.getTop();
        int r15 = r11 - r2;
        int r16 = r12 - r3;
        if (r15 != 0) goto L7;
        if (r16 != 0) goto L7;
        this.q.abortAnimation();
        E(0);
        return false;
    L7:
        int r6 = j(this.s, r15, r16, r13, r14);
        this.q.startScroll(r2, r3, r15, r16, r6);
        E(2);
        return true;
    }

    private int s(int r4, int r5) {
        if (r4 >= (this.u.getLeft() + this.o)) goto L5;
        int r0 = 1;
    L7:
        if (r5 >= (this.u.getTop() + this.o)) goto L10;
        r0 = r0 | 4;
    L10:
        if (r4 <= (this.u.getRight() - this.o)) goto L13;
        r0 = r0 | 2;
    L13:
        if (r5 > (this.u.getBottom() - this.o)) goto L15;
        return r0;
    L15:
        return r0 | 8;
    L5:
        r0 = 0;
        goto L7
    }

    private boolean x(int r2) {
        if (w(r2) == true) goto L6;
        Log.e("ViewDragHelper", "Ignoring pointerId=" + r2 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    L6:
        return true;
    }

    void E(int r3) {
        this.u.removeCallbacks(this.w);
        if (this.f11215a == r3) goto L8;
        this.f11215a = r3;
        this.r.j(r3);
        if (this.f11215a != 0) goto L9;
        this.s = null;
        return;
    L9:
        return;
    }

    public void F(int r1) {
        this.v = r1;
    }

    public boolean G(int r4, int r5) {
        if (this.t == false) goto L7;
        return r(r4, r5, (int) this.f11226l.getXVelocity(this.f11217c), (int) this.f11226l.getYVelocity(this.f11217c));
    L7:
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    public boolean H(@NonNull MotionEvent r17) {
        int r2 = r17.getActionMasked();
        int r3 = r17.getActionIndex();
        if (r2 != 0) goto L6;
        a();
    L6:
        if (this.f11226l != null) goto L8;
        this.f11226l = VelocityTracker.obtain();
    L8:
        this.f11226l.addMovement(r17);
        if (r2 == 0) goto L64;
        if (r2 == 1) goto L63;
        if (r2 == 2) goto L30;
        if (r2 == 3) goto L63;
        if (r2 != 5) goto L17;
        int r4 = r17.getPointerId(r3);
        float r7 = r17.getX(r3);
        float r1 = r17.getY(r3);
        C(r7, r1, r4);
        int r5 = this.f11215a;
        if (r5 != 0) goto L25;
        int r6 = this.f11222h[r4];
        int r8 = this.p;
        if ((r6 & r8) != 0) goto L24;
    L18:
        boolean r9 = false;
    L73:
        if (this.f11215a == 1) goto L75;
        return r9;
    L75:
        return true;
    L24:
        this.r.h(r6 & r8, r4);
        goto L18
    L25:
        if (r5 != 2) goto L18;
        View r10 = q((int) r7, (int) r1);
        if (r10 != this.s) goto L18;
        J(r10, r4);
        goto L18
    L17:
        if (r2 != 6) goto L18;
        h(r17.getPointerId(r3));
        goto L18
    L30:
        if (this.f11218d == null) goto L18;
        if (this.f11219e == null) goto L18;
        int r11 = r17.getPointerCount();
        int r12 = 0;
    L35:
        if (r12 >= r11) goto L62;
        int r13 = r17.getPointerId(r12);
        if (x(r13) == false) goto L61;
        float r14 = r17.getX(r12);
        float r15 = r17.getY(r12);
        float r16 = r14 - this.f11218d[r13];
        float r18 = r15 - this.f11219e[r13];
        View r19 = q((int) r14, (int) r15);
        if (r19 != null) goto L42;
    L44:
        boolean r20 = false;
    L45:
        if (r20 == false) goto L54;
        int r110 = r19.getLeft();
        int r111 = (int) r16;
        int r112 = this.r.a(r19, r110 + r111, r111);
        int r113 = r19.getTop();
        int r114 = (int) r18;
        int r21 = this.r.b(r19, r113 + r114, r114);
        int r115 = this.r.d(r19);
        int r116 = this.r.e(r19);
        if (r115 == 0) goto L50;
        if (r115 <= 0) goto L54;
        if (r112 != r110) goto L54;
    L50:
        if (r116 == 0) goto L62;
        if (r116 <= 0) goto L54;
        if (r21 == r113) goto L62;
    L54:
        B(r16, r18, r13);
        if (this.f11215a == 1) goto L62;
        if (r20 == false) goto L61;
        if (J(r19, r13) == false) goto L61;
    L42:
        if (d(r19, r16, r18) == false) goto L44;
        r20 = true;
    L61:
        r12 = r12 + 1;
    L62:
        D(r17);
    L63:
        a();
        goto L18
    L64:
        float r22 = r17.getX();
        float r23 = r17.getY();
        r9 = false;
        int r24 = r17.getPointerId(0);
        C(r22, r23, r24);
        View r25 = q((int) r22, (int) r23);
        if (r25 == this.s) goto L67;
    L69:
        int r26 = this.f11222h[r24];
        int r27 = this.p;
        if ((r26 & r27) == 0) goto L73;
        this.r.h(r26 & r27, r24);
        goto L73
    L67:
        if (this.f11215a != 2) goto L69;
        J(r25, r24);
        goto L69
    }

    public boolean I(@NonNull View r1, int r2, int r3) {
        this.s = r1;
        this.f11217c = -1;
        boolean r4 = r(r2, r3, 0, 0);
        if (r4 == false) goto L5;
    L9:
        return r4;
    L5:
        if (this.f11215a != 0) goto L9;
        if (this.s == null) goto L9;
        this.s = null;
        goto L9
    }

    boolean J(View r3, int r4) {
        if (r3 == this.s) goto L5;
    L7:
        if (r3 != null) goto L9;
        return false;
    L9:
        if (this.r.m(r3, r4) == false) goto L14;
        this.f11217c = r4;
        b(r3, r4);
        return true;
    L14:
        return false;
    L5:
        if (this.f11217c != r4) goto L7;
        return true;
    }

    public void a() {
        this.f11217c = -1;
        g();
        VelocityTracker r0 = this.f11226l;
        if (r0 == null) goto L6;
        r0.recycle();
        this.f11226l = null;
        return;
    }

    public void b(@NonNull View r3, int r4) {
        if (r3.getParent() != this.u) goto L7;
        this.s = r3;
        this.f11217c = r4;
        this.r.i(r3, r4);
        E(1);
        return;
    L7:
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.u + ")");
    }

    public boolean k(boolean r12) {
        if (this.f11215a != 2) goto L23;
        boolean r0 = this.q.computeScrollOffset();
        int r3 = this.q.getCurrX();
        int r10 = this.q.getCurrY();
        int r8 = r3 - this.s.getLeft();
        int r9 = r10 - this.s.getTop();
        if (r8 == 0) goto L7;
        ViewCompat.offsetLeftAndRight(this.s, r8);
    L7:
        if (r9 == 0) goto L9;
        ViewCompat.offsetTopAndBottom(this.s, r9);
    L9:
        if (r8 != 0) goto L11;
        if (r9 != 0) goto L11;
    L12:
        if (r0 == true) goto L14;
    L18:
        if (r0 == true) goto L23;
        if (r12 == false) goto L21;
        this.u.post(this.w);
        goto L23
    L21:
        E(0);
        goto L23
    L14:
        if (r3 != this.q.getFinalX()) goto L18;
        if (r10 != this.q.getFinalY()) goto L18;
        this.q.abortAnimation();
        r0 = false;
    L11:
        this.r.k(this.s, r3, r10, r8, r9);
    L23:
        if (this.f11215a != 2) goto L26;
        return true;
    L26:
        return false;
    }

    @Nullable
    public View q(int r4, int r5) {
        int r0 = this.u.getChildCount() - 1;
    L3:
        if (r0 < 0) goto L14;
        ViewGroup r1 = this.u;
        this.r.c(r0);
        View r2 = r1.getChildAt(r0);
        if (r4 < r2.getLeft()) goto L13;
        if (r4 >= r2.getRight()) goto L13;
        if (r5 < r2.getTop()) goto L13;
        if (r5 >= r2.getBottom()) goto L13;
        return r2;
    L13:
        r0 = r0 - 1;
        goto L3
    L14:
        return null;
    }

    public int t() {
        return this.v;
    }

    @Px
    public int u() {
        return this.f11216b;
    }

    public boolean v(int r2, int r3) {
        return y(this.s, r2, r3);
    }

    public boolean w(int r2) {
        if ((this.f11225k & (1 << r2)) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean y(@Nullable View r2, int r3, int r4) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (r3 >= r2.getLeft()) goto L8;
        return false;
    L8:
        if (r3 < r2.getRight()) goto L10;
        return false;
    L10:
        if (r4 >= r2.getTop()) goto L12;
        return false;
    L12:
        if (r4 >= r2.getBottom()) goto L18;
        return true;
    L18:
        return false;
    }

    public void z(@NonNull MotionEvent r10) {
        int r0 = r10.getActionMasked();
        int r1 = r10.getActionIndex();
        if (r0 != 0) goto L6;
        a();
    L6:
        if (this.f11226l != null) goto L8;
        this.f11226l = VelocityTracker.obtain();
    L8:
        this.f11226l.addMovement(r10);
        int r2 = 0;
        if (r0 != 0) goto L11;
        float r3 = r10.getX();
        float r4 = r10.getY();
        int r11 = r10.getPointerId(0);
        View r5 = q((int) r3, (int) r4);
        C(r3, r4, r11);
        J(r5, r11);
        int r6 = this.f11222h[r11];
        int r7 = this.p;
        if ((r6 & r7) == 0) goto L99;
        this.r.h(r6 & r7, r11);
        return;
    L99:
        return;
    L11:
        if (r0 == 1) goto L74;
        if (r0 == 2) goto L53;
        if (r0 == 3) goto L50;
        if (r0 != 5) goto L19;
        int r8 = r10.getPointerId(r1);
        float r9 = r10.getX(r1);
        float r12 = r10.getY(r1);
        C(r9, r12, r8);
        if (this.f11215a != 0) goto L47;
        J(q((int) r9, (int) r12), r8);
        int r13 = this.f11222h[r8];
        int r14 = this.p;
        if ((r13 & r14) == 0) goto L93;
        this.r.h(r13 & r14, r8);
        return;
    L93:
        return;
    L47:
        if (v((int) r9, (int) r12) == false) goto L95;
        J(this.s, r8);
        return;
    L95:
        return;
    L19:
        if (r0 != 6) goto L100;
        int r15 = r10.getPointerId(r1);
        if (this.f11215a == 1) goto L24;
    L40:
        h(r15);
        return;
    L24:
        if (r15 != this.f11217c) goto L40;
        int r16 = r10.getPointerCount();
    L27:
        if (r2 >= r16) goto L37;
        int r17 = r10.getPointerId(r2);
        if (r17 == this.f11217c) goto L36;
        View r18 = q((int) r10.getX(r2), (int) r10.getY(r2));
        View r19 = this.s;
        if (r18 != r19) goto L36;
        if (J(r19, r17) == false) goto L36;
        int r110 = this.f11217c;
    L38:
        if (r110 != (-1)) goto L40;
        A();
    L36:
        r2 = r2 + 1;
        goto L27
    L37:
        r110 = -1;
        goto L38
    L100:
        return;
    L50:
        if (this.f11215a != 1) goto L76;
        m(0.0f, 0.0f);
    L76:
        a();
        return;
    L53:
        if (this.f11215a == 1) goto L55;
        int r20 = r10.getPointerCount();
    L60:
        if (r2 >= r20) goto L58;
        int r21 = r10.getPointerId(r2);
        if (x(r21) == false) goto L72;
        float r22 = r10.getX(r2);
        float r23 = r10.getY(r2);
        float r24 = r22 - this.f11218d[r21];
        float r25 = r23 - this.f11219e[r21];
        B(r24, r25, r21);
        if (this.f11215a == 1) goto L58;
        View r26 = q((int) r22, (int) r23);
        if (d(r26, r24, r25) == false) goto L72;
        if (J(r26, r21) == true) goto L58;
    L72:
        r2 = r2 + 1;
    L58:
        D(r10);
        return;
    L55:
        if (x(this.f11217c) == false) goto L101;
        int r27 = r10.findPointerIndex(this.f11217c);
        float r28 = r10.getX(r27);
        float r29 = r10.getY(r27);
        float[] r30 = this.f11220f;
        int r31 = this.f11217c;
        int r32 = (int) (r28 - r30[r31]);
        int r33 = (int) (r29 - this.f11221g[r31]);
        o(this.s.getLeft() + r32, this.s.getTop() + r33, r32, r33);
        goto L58
    L101:
        return;
    L74:
        if (this.f11215a != 1) goto L76;
        A();
        goto L76
    }
}
