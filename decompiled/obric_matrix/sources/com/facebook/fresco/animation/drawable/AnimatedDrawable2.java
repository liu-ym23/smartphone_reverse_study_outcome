package com.facebook.fresco.animation.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import androidx.annotation.Keep;
import d.c.g.a.c.c;
import d.c.h.d;

/* JADX INFO: loaded from: classes.dex */
public class AnimatedDrawable2 extends Drawable implements Animatable, d.c.e.a.a {
    private static final Class<?> A = null;
    private static final com.facebook.fresco.animation.drawable.a B = null;
    private static c C;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private d.c.g.a.a.a f6626f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private d.c.g.a.c.b f6627g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private d.c.g.a.b.b f6628h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private d f6629i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Object f6630j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile boolean f6631k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f6632l;
    private long m;
    private long n;
    private int o;
    private long p;
    private long q;
    private int r;
    private volatile boolean s;
    private long t;
    private long u;
    private int v;
    private volatile com.facebook.fresco.animation.drawable.a w;
    private volatile b x;
    private d.c.f.e.c y;
    private final Runnable z;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ AnimatedDrawable2 f6633f;

        a(AnimatedDrawable2 r1) {
            this.f6633f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            AnimatedDrawable2 r0 = this.f6633f;
            r0.unscheduleSelf(AnimatedDrawable2.b(r0));
            this.f6633f.invalidateSelf();
        }
    }

    public interface b {
        void a(AnimatedDrawable2 r1, d.c.g.a.c.b r2, int r3, boolean r4, boolean r5, long r6, long r8, long r10, long r12, long r14, long r16, long r18);
    }

    static {
        A = AnimatedDrawable2.class;
        B = new com.facebook.fresco.animation.drawable.b();
    }

    public AnimatedDrawable2() {
        this(null, null);
    }

    public AnimatedDrawable2(d.c.g.a.a.a r3, Object r4) {
        this.f6629i = d.f15831b;
        this.t = 8;
        this.u = 0;
        this.w = B;
        this.x = null;
        this.z = new a(this);
        this.f6626f = r3;
        this.f6627g = c(r3, r4, 0, this.f6629i);
        this.f6630j = r4;
    }

    public AnimatedDrawable2(d.c.g.a.a.a r3, Object r4, d.c.g.a.b.b r5, int r6, d r7) {
        this.f6629i = d.f15831b;
        this.t = 8;
        this.u = 0;
        this.w = B;
        this.x = null;
        this.z = new a(this);
        this.f6626f = r3;
        this.f6629i = r7;
        this.f6627g = c(r3, r4, r6, r7);
        this.f6628h = r5;
        this.f6630j = r4;
    }

    static /* synthetic */ Runnable b(AnimatedDrawable2 r0) {
        return r0.z;
    }

    private static d.c.g.a.c.b c(d.c.g.a.a.a r1, Object r2, int r3, d r4) {
        if (r1 != null) goto L6;
        return null;
    L6:
        if (d.c.h.c.e(r4) == true) goto L8;
        c r0 = C;
        if (r0 == null) goto L15;
        d.c.g.a.c.b r5 = r0.a(r1, r2, r4, r3);
        if (r5 == null) goto L15;
        return r5;
    L15:
        return new d.c.g.a.c.d(r1, r3);
    L8:
        return new d.c.g.a.c.a(r1, r3);
    }

    private long f() {
        return SystemClock.uptimeMillis();
    }

    private void g() {
        this.v++;
        if (d.c.c.e.a.p(2) == false) goto L6;
        d.c.c.e.a.s(A, "Dropped a frame. Count: %s", Integer.valueOf(this.v));
        return;
    }

    private void h(long r3) {
        long r0 = this.f6632l + r3;
        this.n = r0;
        scheduleSelf(this.z, r0);
    }

    public static void i(c r0) {
        C = r0;
    }

    @Override // d.c.e.a.a
    public void a() {
        d.c.g.a.a.a r0 = this.f6626f;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    public d.c.g.a.a.a d() {
        return this.f6626f;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r24) {
        if (this.f6626f != null) goto L5;
        return;
    L5:
        if (this.f6627g == null) goto L40;
        long r12 = f();
        if (this.f6631k == false) goto L10;
        long r0 = (r12 - this.f6632l) + this.u;
    L11:
        long r8 = r0;
        int r1 = this.f6627g.c(r8, this.m);
        if (r1 != (-1)) goto L14;
        r1 = this.f6626f.a() - 1;
        this.w.c(this);
        this.f6631k = false;
    L20:
        int r3 = r1;
        boolean r4 = this.f6626f.k(this, r24, r3);
        if (r4 == false) goto L23;
        this.w.d(this, r3);
        this.o = r3;
    L23:
        if (r4 == true) goto L25;
        g();
    L25:
        long r15 = f();
        if (this.f6631k == false) goto L32;
        this.f6627g.d(this.f6632l);
        long r5 = this.f6627g.a(r15 - this.f6632l);
        if (r5 == (-1)) goto L30;
        long r2 = this.t + r5;
        h(r2);
        long r19 = r2;
    L31:
        long r17 = r5;
    L33:
        b r6 = this.x;
        if (r6 == null) goto L36;
        r6.a(this, this.f6627g, r3, r4, this.f6631k, this.f6632l, r8, this.m, r12, r15, r17, r19);
        long r7 = r8;
    L37:
        this.m = r7;
        return;
    L36:
        r7 = r8;
        goto L37
    L30:
        r19 = -1;
        goto L31
    L32:
        r17 = -1;
        r19 = -1;
        goto L33
    L14:
        if (r1 != 0) goto L20;
        if (this.o == (-1)) goto L20;
        if (r12 < this.n) goto L20;
        this.w.a(this);
        goto L20
    L10:
        r0 = Math.max(this.m, 0);
        goto L11
    }

    public d.c.g.a.b.b e() {
        return this.f6628h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        d.c.g.a.a.a r0 = this.f6626f;
        if (r0 != null) goto L7;
        return super.getIntrinsicHeight();
    L7:
        return r0.c();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        d.c.g.a.a.a r0 = this.f6626f;
        if (r0 != null) goto L7;
        return super.getIntrinsicWidth();
    L7:
        return r0.e();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f6631k;
    }

    public void j(d.c.g.a.a.a r2, Object r3, int r4) {
        this.f6626f = r2;
        if (this.f6627g == null) goto L9;
        d.c.g.a.c.b r5 = c(r2, r3, r4, this.f6629i);
        d.c.g.a.c.b r6 = this.f6627g.b(r5);
        if (r6 == null) goto L7;
        r5 = r6;
    L7:
        this.f6627g = r5;
        return;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r1) {
        super.onBoundsChange(r1);
        d.c.g.a.a.a r0 = this.f6626f;
        if (r0 == null) goto L6;
        r0.d(r1);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int r7) {
        if (this.f6631k == false) goto L5;
        return false;
    L5:
        long r4 = r7;
        if (this.m == r4) goto L9;
        this.m = r4;
        invalidateSelf();
        return true;
    L9:
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        if (this.y != null) goto L5;
        this.y = new d.c.f.e.c();
    L5:
        this.y.b(r2);
        d.c.g.a.a.a r1 = this.f6626f;
        if (r1 == null) goto L9;
        r1.j(r2);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        if (this.y != null) goto L5;
        this.y = new d.c.f.e.c();
    L5:
        this.y.c(r2);
        d.c.g.a.a.a r1 = this.f6626f;
        if (r1 == null) goto L9;
        r1.h(r2);
        return;
    }

    @Keep
    public void setPrivateFrameScheduler(d.c.g.a.c.b r1) {
        if (r1 == null) goto L5;
        this.f6627g = r1;
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.f6631k == true) goto L5;
    L6:
        d.c.g.a.a.a r0 = this.f6626f;
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.a() <= 1) goto L18;
        this.f6631k = true;
        long r1 = f();
        this.f6632l = r1;
        this.n = r1;
        this.m = -1;
        this.o = -1;
        if (this.s == false) goto L14;
        long r2 = f();
        long r3 = r2 - this.p;
        this.f6632l = r3;
        this.n = r3;
        this.m = r2 - this.q;
        this.o = this.r;
        this.s = false;
    L14:
        invalidateSelf();
        this.w.b(this);
        return;
    L18:
        return;
    L5:
        if (this.s == true) goto L6;
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.f6631k == true) goto L5;
        return;
    L5:
        this.f6631k = false;
        this.f6632l = 0;
        this.n = 0;
        this.m = -1;
        this.o = -1;
        this.s = false;
        unscheduleSelf(this.z);
        this.w.c(this);
    }
}
