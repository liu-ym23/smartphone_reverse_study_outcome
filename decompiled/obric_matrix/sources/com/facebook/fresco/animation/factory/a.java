package com.facebook.fresco.animation.factory;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import d.c.b.a.d;
import d.c.c.d.l;
import d.c.i.c.a.e;
import d.c.i.c.c.b;
import d.c.i.d.f;
import d.c.i.e.h;
import d.c.i.l.c;
import d.c.i.l.g;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class a implements d.c.i.j.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f6650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ScheduledExecutorService f6651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ExecutorService f6652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.facebook.common.time.b f6653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final f f6654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final h<d, c> f6655f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final l<Integer> f6656g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final l<Integer> f6657h;

    /* JADX INFO: renamed from: com.facebook.fresco.animation.factory.a$a, reason: collision with other inner class name */
    public static class C0204a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6658a;

        public C0204a(int r3) {
            this.f6658a = "anim://" + r3;
        }

        @Override // d.c.b.a.d
        public String a() {
            return this.f6658a;
        }

        @Override // d.c.b.a.d
        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L18:
            return false;
        L8:
            if (C0204a.class != r5.getClass()) goto L18;
            C0204a r6 = (C0204a) r5;
            String r4 = this.f6658a;
            if (r4 == null) goto L14;
            return r4.equals(r6.f6658a);
        L14:
            if (r6.f6658a != null) goto L17;
            return true;
        L17:
            return false;
        }

        @Override // d.c.b.a.d
        public int hashCode() {
            String r0 = this.f6658a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        @Override // d.c.b.a.d
        public String toString() {
            return this.f6658a;
        }
    }

    public a(b r1, ScheduledExecutorService r2, ExecutorService r3, com.facebook.common.time.b r4, f r5, h<d, c> r6, l<Integer> r7, l<Integer> r8) {
        this.f6650a = r1;
        this.f6651b = r2;
        this.f6652c = r3;
        this.f6653d = r4;
        this.f6654e = r5;
        this.f6655f = r6;
        this.f6656g = r7;
        this.f6657h = r8;
    }

    private void d(d.c.i.c.c.c r4, int r5, d.c.c.h.a<Bitmap> r6) {
        d.c.c.h.a<c> r3 = null;
        r3 = d.c.c.h.a.V(new d.c.i.l.d(r6, g.f16188d, 0));     // Catch: Throwable -> L6
        r4.b(r5, r3);     // Catch: Throwable -> L6
        d.c.c.h.a.L(r3);
        return;
    L6:
        th = move-exception;
        d.c.c.h.a.L(r3);
        throw th;
    }

    private d.c.i.c.a.a e(e r5) {
        d.c.i.c.a.c r0 = r5.e();
        Rect r1 = new Rect(0, 0, r0.getWidth(), r0.getHeight());
        return this.f6650a.a(r5, r1);
    }

    private d.c.i.c.c.c f(e r5) {
        d.c.i.c.c.c r0 = new d.c.i.c.c.c(new C0204a(r5.hashCode()), this.f6655f);
        int r1 = r5.d();
        if (r1 <= 0) goto L10;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L10;
        if (r5.g(r2) == false) goto L9;
        d(r0, r2, r5.c(r2));
    L9:
        r2 = r2 + 1;
    L10:
        return r0;
    }

    private d.c.g.a.a.a g(d.c.i.l.a r10, d.c.g.a.b.b r11) {
        d.c.i.c.a.a r0 = e(r10.F());
        d.c.g.a.b.f.b r5 = new d.c.g.a.b.f.b(r11, r0);
        int r1 = r10.L().f15993c;
        if (r1 > 0) goto L7;
        r1 = this.f6657h.get().intValue();
    L7:
        if (r1 > 0) goto L9;
    L11:
        d.c.g.a.b.e.d r6 = null;
        d.c.g.a.b.e.b r7 = null;
    L12:
        d.c.g.a.b.a r8 = new d.c.g.a.b.a(this.f6654e, r11, new d.c.g.a.b.f.a(r0), r5, r6, r7);
        r8.p(r10.L().f15998h);
        return d.c.g.a.a.c.r(r10.E().d(), r8, this.f6653d, this.f6651b);
    L9:
        if (d.c.h.c.e(r10.l()) == true) goto L11;
        d.c.g.a.b.e.d r2 = new d.c.g.a.b.e.d(r1);
        r7 = i(r5, r10.L().f15998h);
        r6 = r2;
        goto L12
    }

    private d.c.g.a.b.b h(e r3) {
        int r0 = this.f6656g.get().intValue();
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L13;
        if (r0 == 3) goto L11;
        return new d.c.g.a.b.d.c();
    L11:
        return new d.c.g.a.b.d.b();
    L13:
        return new d.c.g.a.b.d.a(f(r3), false);
    L15:
        return new d.c.g.a.b.d.a(f(r3), true);
    }

    private d.c.g.a.b.e.b i(d.c.g.a.b.c r3, Bitmap.Config r4) {
        return new d.c.g.a.b.e.c(this.f6654e, r3, r4, this.f6652c);
    }

    private boolean k(AnimatedDrawable2 r1, d.c.i.c.a.c r2) {
        d.c.g.a.a.a r0 = r1.d();
        if ((r0 instanceof d.c.g.a.a.b) == false) goto L14;
        d.c.g.a.a.a r3 = ((d.c.g.a.a.b) r0).g();
        if ((r3 instanceof d.c.g.a.b.a) == false) goto L16;
        e r4 = ((d.c.g.a.b.f.a) ((d.c.g.a.b.a) r3).n()).g().i();
        if (r4 == null) goto L17;
        d.c.i.c.a.c r5 = r4.e();
        if (r5 == null) goto L18;
        if (r2 == null) goto L19;
        if (r2 == r5) goto L20;
        r5.dispose();
        return true;
    L20:
        return false;
    L19:
        return false;
    L18:
        return false;
    L17:
        return false;
    L16:
        return false;
    L14:
        return false;
    }

    @Override // d.c.i.j.a
    public Drawable a(c r11, Drawable r12) {
        d.c.i.l.a r0 = (d.c.i.l.a) r11;
        e r1 = r0.F();
        int r2 = r1.e().h();
        if (r1.e().a() > 0) goto L6;
        return r12;
    L6:
        if ((r12 instanceof AnimatedDrawable2) == false) goto L23;
        if (r2 != 2) goto L10;
    L11:
        AnimatedDrawable2 r13 = (AnimatedDrawable2) r12;
        d.c.g.a.b.b r5 = r13.e();
        if (k(r13, r1.e()) == true) goto L14;
        return r13;
    L14:
        d.c.i.c.a.a r3 = e(r1);
        d.c.g.a.b.f.b r7 = new d.c.g.a.b.f.b(r5, r3);
        int r4 = this.f6657h.get().intValue();
        if (r4 > 0) goto L17;
    L19:
        d.c.g.a.b.e.d r8 = null;
        d.c.g.a.b.e.b r9 = null;
    L20:
        d.c.g.a.b.a r14 = new d.c.g.a.b.a(this.f6654e, r5, new d.c.g.a.b.f.a(r3), r7, r8, r9);
        r14.p(r0.L().f15998h);
        r13.j(d.c.g.a.a.c.p(r14, this.f6653d, this.f6651b), r0.L().f16001k, r2);
        return r13;
    L17:
        if (d.c.h.c.e(r11.l()) == true) goto L19;
        r8 = new d.c.g.a.b.e.d(r4);
        r9 = i(r7, r0.L().f15998h);
        goto L20
    L10:
        if (r2 == 3) goto L11;
    L23:
        return j(r11);
    }

    @Override // d.c.i.j.a
    public boolean b(c r1) {
        return r1 instanceof d.c.i.l.a;
    }

    @Override // d.c.i.j.a
    public /* bridge */ /* synthetic */ Drawable c(c r1) {
        return j(r1);
    }

    public AnimatedDrawable2 j(c r7) {
        d.c.i.l.a r8 = (d.c.i.l.a) r7;
        e r0 = r8.F();
        if (r0.e().a() > 0) goto L6;
        return null;
    L6:
        d.c.g.a.b.b r3 = h(r0);
        int r4 = r0.e().h();
        return new AnimatedDrawable2(g(r8, r3), r8.L().f16001k, r3, r4, r0.e().d());
    }
}
