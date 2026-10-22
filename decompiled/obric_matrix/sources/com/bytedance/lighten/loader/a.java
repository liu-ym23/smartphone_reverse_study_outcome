package com.bytedance.lighten.loader;

import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.text.TextUtils;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d.c.i.e.h<d.c.b.a.d, d.c.i.l.c> f4916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private i f4917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4918c;

    /* JADX INFO: renamed from: com.bytedance.lighten.loader.a$a, reason: collision with other inner class name */
    class CallableC0151a implements Callable<Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d.c.c.h.a f4919f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f4920g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ a f4921h;

        CallableC0151a(a r1, d.c.c.h.a r2, String r3) {
            this.f4921h = r1;
            this.f4919f = r2;
            this.f4920g = r3;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            if (this.f4919f.Q() == false) goto L7;
            Bitmap r0 = (Bitmap) this.f4919f.N();
            d.c.c.h.a<Bitmap> r1 = d.c.i.g.j.o().r().g(r0);
            d.c.c.h.a r2 = d.c.c.h.a.V(new d.c.i.l.d(r1, d.c.i.l.g.f16188d, 0));
            d.c.c.h.a r4 = a.a(this.f4921h).b(new d.c.b.a.j(this.f4920g), r2);
            d.c.c.h.a.L(r1);
            d.c.c.h.a.L(r4);
            d.c.c.h.a.L(r2);
            return null;
        L7:
            return null;
        }
    }

    class b implements d.c.i.e.x<d.c.i.l.c> {
        b(a r1) {
        }

        @Override // d.c.i.e.x
        public /* bridge */ /* synthetic */ int a(d.c.i.l.c r1) {
            return b(r1);
        }

        public int b(d.c.i.l.c r1) {
            return r1.x();
        }
    }

    class c extends d.c.i.e.i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f4922b;

        c(a r1, ActivityManager r2) {
            this.f4922b = r1;
            super(r2);
        }

        @Override // d.c.i.e.i
        public d.c.i.e.r a() {
            return new d.c.i.e.r(a.b(this.f4922b), Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        @Override // d.c.i.e.i, d.c.c.d.l
        public /* bridge */ /* synthetic */ d.c.i.e.r get() {
            return a();
        }
    }

    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f4923a = null;

        static {
            f4923a = new a(null);
        }

        static /* synthetic */ a a() {
            return f4923a;
        }
    }

    private a() {
        this.f4918c = x.a(d.b.k.a.h.a());
        i();
        h();
    }

    /* synthetic */ a(CallableC0151a r1) {
        this();
    }

    static /* synthetic */ d.c.i.e.h a(a r0) {
        return r0.f4916a;
    }

    static /* synthetic */ int b(a r0) {
        return r0.f4918c;
    }

    private d.c.c.h.a<Bitmap> d(d.c.c.h.a<d.c.i.l.c> r1) {
    L13:
        th = move-exception;
        d.c.c.h.a.L(r1);
        throw th;
    L3:
        if (d.c.c.h.a.S(r1) == true) goto L5;
    L11:
        d.c.c.h.a.L(r1);
        return null;
    L5:
        if ((r1.N() instanceof d.c.i.l.d) == false) goto L11;
        d.c.i.l.d r0 = (d.c.i.l.d) r1.N();     // Catch: Throwable -> L13
        if (r0 == null) goto L11;
        d.c.c.h.a<Bitmap> r2 = r0.F();     // Catch: Throwable -> L13
        d.c.c.h.a.L(r1);
        return r2;
    }

    public static a f() {
        return d.a();
    }

    private void h() {
        com.ss.android.m.a.a.h.b r1 = com.ss.android.m.a.a.h.a(com.ss.android.m.a.a.k.f12175j);
        r1.j("bitmap-cache");
        this.f4917b = new i(com.ss.android.m.a.a.f.a(r1.h()), 10);
    }

    private void i() {
        this.f4916a = new d.c.i.e.h(new b(this), new d.c.i.e.d(), new c(this, (ActivityManager) d.b.k.a.h.a().getSystemService("activity")));
    }

    public void c(String r2, d.c.i.l.a r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        if (r3 != null) goto L7;
        return;
    L7:
        if (r3.F() == null) goto L15;
        d.c.c.h.a<Bitmap> r4 = r3.F().f();
        if (r4 != null) goto L11;
        return;
    L11:
        if (r4.Q() == false) goto L17;
        c.f.b(new CallableC0151a(this, r4, r2), this.f4917b);
        return;
    L17:
        return;
    }

    public void e() {
        d.c.i.e.h<d.c.b.a.d, d.c.i.l.c> r0 = this.f4916a;
        if (r0 == null) goto L11;
        r0.f();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public d.c.c.h.a<Bitmap> g(String r3) {
        d.c.c.h.a<d.c.i.l.c> r4 = this.f4916a.get(new d.c.b.a.j(r3));
        if (r4 != null) goto L5;
        return null;
    L5:
        return d(r4);
    }
}
