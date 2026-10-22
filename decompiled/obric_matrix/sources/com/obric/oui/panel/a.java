package com.obric.oui.panel;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static final Interpolator o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OverScroller f11202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c.AbstractC0294c f11203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f11204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f11205d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f11206e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ViewGroup f11207f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f11208g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f11209h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f11210i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f11211j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f11212k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f11213l;
    private boolean m;
    private final Runnable n;

    /* JADX INFO: renamed from: com.obric.oui.panel.a$a, reason: collision with other inner class name */
    class InterpolatorC0293a implements Interpolator {
        InterpolatorC0293a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float r2) {
            float r3 = r2 - 1.0f;
            return ((((r3 * r3) * r3) * r3) * r3) + 1.0f;
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f11214f;

        b(a r1) {
            this.f11214f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.b(this.f11214f).removeCallbacks(a.a(this.f11214f));
            a.c(this.f11214f, false);
        }
    }

    static {
        o = new InterpolatorC0293a();
    }

    public a(Context r3, ViewGroup r4, c.AbstractC0294c r5) {
        this.m = false;
        this.n = new b(this);
        this.f11202a = new OverScroller(r3, o);
        this.f11207f = r4;
        this.f11203b = r5;
        ViewConfiguration r6 = ViewConfiguration.get(r3);
        this.f11206e = r6.getScaledTouchSlop();
        this.f11204c = r6.getScaledMaximumFlingVelocity();
        this.f11205d = r6.getScaledMinimumFlingVelocity();
    }

    static /* synthetic */ Runnable a(a r0) {
        return r0.n;
    }

    static /* synthetic */ ViewGroup b(a r0) {
        return r0.f11207f;
    }

    static /* synthetic */ boolean c(a r0, boolean r1) {
        r0.m = r1;
        return r1;
    }

    private float d(float r2, float r3, float r4) {
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

    private int e(int r1, int r2, int r3) {
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

    private int f(int r4, int r5, int r6) {
        if (r4 != 0) goto L5;
        return 0;
    L5:
        int r0 = this.f11207f.getWidth();
        float r1 = r0 / 2;
        float r2 = r1 + (i(Math.min(1.0f, Math.abs(r4) / r0)) * r1);
        int r3 = Math.abs(r5);
        if (r3 <= 0) goto L8;
        int r7 = Math.round(Math.abs(r2 / r3) * 1000.0f) * 4;
    L10:
        return Math.min(r7, 600);
    L8:
        r7 = (int) (((Math.abs(r4) / r6) + 1.0f) * 256.0f);
        goto L10
    }

    private int g(View r7, int r8, int r9, int r10, int r11) {
        int r12 = e(r10, (int) this.f11205d, (int) this.f11204c);
        int r13 = e(r11, (int) this.f11205d, (int) this.f11204c);
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
        return (int) ((f(r8, r12, this.f11203b.d(r7)) * r15) + (f(r9, r13, this.f11203b.e(r7)) * r18));
    L9:
        r16 = r1;
        r17 = r5;
        goto L10
    L5:
        r6 = r0;
        r14 = r5;
        goto L6
    }

    private float i(float r1) {
        return (float) Math.sin((r1 - 0.5f) * 0.47123894f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View k(@Nullable View r5) {
        if (r5 != 0) goto L6;
        return null;
    L6:
        if (r5.canScrollHorizontally(-this.f11213l) == false) goto L8;
    L21:
        return r5;
    L8:
        if ((r5 instanceof com.obric.oui.panel.b) == false) goto L13;
        if (((com.obric.oui.panel.b) r5).a(-this.f11213l) == true) goto L21;
    L13:
        if ((r5 instanceof ViewGroup) == false) goto L20;
        ViewGroup r6 = (ViewGroup) r5;
        int r1 = 0;
        int r2 = r6.getChildCount();
    L15:
        if (r1 >= r2) goto L20;
        View r3 = k(r6.getChildAt(r1));
        if (r3 != null) goto L18;
        r1 = r1 + 1;
        goto L15
    L18:
        return r3;
    L20:
        return null;
    }

    private boolean l(View r10, int r11, int r12, int r13, int r14) {
        int r1 = r10.getLeft();
        int r2 = r10.getTop();
        int r15 = r11 - r1;
        int r16 = r12 - r2;
        if (r15 != 0) goto L7;
        if (r16 != 0) goto L7;
        this.f11202a.abortAnimation();
        return false;
    L7:
        int r5 = g(r10, r15, r16, r13, r14);
        this.f11202a.startScroll(r1, r2, r15, r16, r5);
        this.m = true;
        return true;
    }

    private float m(VelocityTracker r3) {
        if (r3 != null) goto L5;
        return 0.0f;
    L5:
        r3.computeCurrentVelocity(1000, this.f11204c);
        return r3.getXVelocity(this.f11211j);
    }

    private boolean o(float r2, float r3) {
        if (Math.abs(r2) > this.f11206e) goto L5;
    L7:
        return false;
    L5:
        if ((Math.abs(r2) * 0.5f) <= Math.abs(r3)) goto L7;
        return true;
    }

    public boolean h(View r10, boolean r11) {
        if (this.m == false) goto L24;
        boolean r0 = this.f11202a.computeScrollOffset();
        int r1 = this.f11202a.getCurrX();
        int r8 = this.f11202a.getCurrY();
        int r6 = r1 - r10.getLeft();
        int r7 = r8 - r10.getTop();
        if (r6 == 0) goto L7;
        ViewCompat.offsetLeftAndRight(r10, r6);
    L7:
        if (r7 == 0) goto L9;
        ViewCompat.offsetTopAndBottom(r10, r7);
    L9:
        if (r6 != 0) goto L11;
        if (r7 != 0) goto L11;
    L13:
        if (r0 == true) goto L15;
    L19:
        if (r0 == true) goto L24;
        if (r11 == false) goto L22;
        this.f11207f.post(this.n);
        goto L24
    L22:
        this.m = false;
        goto L24
    L15:
        if (r1 != this.f11202a.getFinalX()) goto L19;
        if (r8 != this.f11202a.getFinalY()) goto L19;
        this.f11202a.abortAnimation();
        r0 = false;
    L11:
        this.f11203b.k(r10, r1, r8, r6, r7);
    L24:
        return this.m;
    }

    public void j(View r10, int r11, int r12, int r13, int r14) {
        int r0 = r10.getLeft();
        int r1 = r10.getTop();
        if (r13 == 0) goto L5;
        r11 = this.f11203b.a(r10, r11, r13);
        ViewCompat.offsetLeftAndRight(r10, r11 - r0);
    L5:
        int r5 = r11;
        if (r14 == 0) goto L8;
        r12 = this.f11203b.b(r10, r12, r14);
        ViewCompat.offsetTopAndBottom(r10, r12 - r1);
    L8:
        int r6 = r12;
        if (r13 != 0) goto L11;
        if (r14 != 0) goto L11;
        return;
    L11:
        c.AbstractC0294c r3 = this.f11203b;
        r3.k(r10, r5, r6, r5 - r0, r6 - r1);
    }

    public boolean n() {
        return this.f11212k;
    }

    public void p(MotionEvent r9, View r10, int r11, VelocityTracker r12) {
        int r0 = r9.getActionMasked();
        if (r0 != 2) goto L6;
        int r13 = (int) r9.getX();
        int r1 = r13 - this.f11210i;
        this.f11210i = r13;
        int r7 = (int) ((r1 * (r10.getHeight() / r10.getWidth())) * 1.2f);
        j(r10, r10.getLeft(), r10.getTop() + r7, 0, r7);
    L6:
        if (r0 != 1) goto L10;
        if (r11 != 1) goto L10;
        q(r10, r12);
    L10:
        if (r0 != 3) goto L14;
        if (r11 != 1) goto L15;
        this.f11203b.l(r10, 0.0f, 0.0f);
        return;
    L15:
        return;
    }

    public void q(View r3, VelocityTracker r4) {
        r4.computeCurrentVelocity(1000, this.f11204c);
        float r5 = d(m(r4), this.f11205d, this.f11204c);
        this.f11203b.l(r3, 0.0f, r5);
    }

    public boolean r(View r1, int r2, int r3, int r4, int r5) {
        return l(r1, r2, r3, r4, r5);
    }

    public boolean s(View r6, MotionEvent r7) {
        this.f11210i = (int) r7.getX();
        boolean r0 = false;
        this.f11212k = false;
        int r1 = r7.getActionMasked();
        if (r1 != 0) goto L5;
        this.f11208g = (int) r7.getX();
        this.f11209h = (int) r7.getY();
    L5:
        int r2 = ((int) r7.getX()) - this.f11208g;
        int r8 = ((int) r7.getY()) - this.f11209h;
        if (r1 == 2) goto L8;
    L12:
        if (r0 == false) goto L17;
        if (r2 <= 0) goto L15;
        int r9 = 1;
    L16:
        this.f11213l = r9;
        this.f11203b.j(1);
        this.f11212k = true;
        goto L17
    L15:
        r9 = -1;
    L17:
        return r0;
    L8:
        if (o(r2, r8) == false) goto L12;
        if (k(r6) != null) goto L12;
        r0 = true;
        goto L12
    }
}
