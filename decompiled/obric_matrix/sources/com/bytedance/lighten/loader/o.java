package com.bytedance.lighten.loader;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.Nullable;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
class o implements d.b.k.a.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d.b.k.a.c f4952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ExecutorService f4953b;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Uri f4954f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d.b.k.a.y.g f4955g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ o f4956h;

        a(o r1, Uri r2, d.b.k.a.y.g r3) {
            this.f4956h = r1;
            this.f4954f = r2;
            this.f4955g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            File r0 = o.a(this.f4956h).a(this.f4954f);
            Log.d("Lighten:", "download: onCompleted, tid=" + Thread.currentThread() + " image path=" + r0);
            this.f4955g.b(r0);
        }
    }

    class b extends d.c.d.b<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Uri f4957a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.b.k.a.y.g f4958b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ o f4959c;

        b(o r1, Uri r2, d.b.k.a.y.g r3) {
            this.f4959c = r1;
            this.f4957a = r2;
            this.f4958b = r3;
        }

        @Override // d.c.d.b
        protected void e(d.c.d.c<Void> r3) {
            Log.d("Lighten:", "download: onFailed, tid=" + Thread.currentThread() + " ex=" + r3.c());
            this.f4958b.a(r3.c());
        }

        @Override // d.c.d.b
        protected void f(d.c.d.c<Void> r3) {
            if (r3.b() == true) goto L5;
            return;
        L5:
            File r4 = o.a(this.f4959c).a(this.f4957a);
            Log.d("Lighten:", "download: onCompleted, tid=" + Thread.currentThread() + " image path=" + r4);
            this.f4958b.b(r4);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f4960f;

        c(o r1, int r2) {
            this.f4960f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.d("Lighten:", String.format("before trim, main-disk picture_count:%d, picture_size:%dkb, small-disk picture_count:%d, picture_size:%dkb", new Object[]{Long.valueOf(d.c.f.a.a.c.b().q().getCount()), Long.valueOf(d.c.f.a.a.c.b().q().a() / 1024), Long.valueOf(d.c.f.a.a.c.b().w().getCount()), Long.valueOf(d.c.f.a.a.c.b().w().a() / 1024)}));
            int r10 = this.f4960f;
            if (r10 == 1) goto L7;
            if (r10 != 2) goto L8;
            d.c.f.a.a.c.b().q().d();
            d.c.f.a.a.c.b().w().d();
        L8:
            Log.d("Lighten:", String.format("after trim, main-disk picture_count:%d, picture_size:%dkb, small-disk picture_count:%d, picture_size:%dkb", new Object[]{Long.valueOf(d.c.f.a.a.c.b().q().getCount()), Long.valueOf(d.c.f.a.a.c.b().q().a() / 1024), Long.valueOf(d.c.f.a.a.c.b().w().getCount()), Long.valueOf(d.c.f.a.a.c.b().w().a() / 1024)}));
            return;
        L7:
            d.c.f.a.a.c.b().q().e();
            d.c.f.a.a.c.b().w().e();
            goto L8
        }
    }

    class d extends d.c.i.h.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.c.d.c f4961a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.b.k.a.s f4962b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.b.k.a.y.i f4963c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ o f4964d;

        class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ Bitmap f4965f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ d f4966g;

            a(d r1, Bitmap r2) {
                this.f4966g = r1;
                this.f4965f = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.d("Lighten:", "loadBitmap onCompleted, tid=" + Thread.currentThread());
                this.f4966g.f4963c.b(this.f4965f);
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ d f4967f;

            b(d r1) {
                this.f4967f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.d("Lighten:", "loadBitmap onFailed, tid=" + Thread.currentThread() + "ex=" + this.f4967f.f4961a.c());
                d r2 = this.f4967f;
                r2.f4963c.a(r2.f4961a.c());
            }
        }

        class c implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ Throwable f4968f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ d f4969g;

            c(d r1, Throwable r2) {
                this.f4969g = r1;
                this.f4968f = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.d("Lighten:", "loadBitmap onCompleted, tid=" + Thread.currentThread());
                this.f4969g.f4963c.a(this.f4968f);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.lighten.loader.o$d$d, reason: collision with other inner class name */
        class RunnableC0152d implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ float f4970f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ d f4971g;

            RunnableC0152d(d r1, float r2) {
                this.f4971g = r1;
                this.f4970f = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.d("Lighten:", "loadBitmap onProgressUpdate, tid=" + Thread.currentThread());
                this.f4971g.f4963c.onProgress(this.f4970f);
            }
        }

        class e implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ d f4972f;

            e(d r1) {
                this.f4972f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.d("Lighten:", "loadBitmap onCanceled, tid=" + Thread.currentThread());
                this.f4972f.f4963c.c();
            }
        }

        d(o r1, d.c.d.c r2, d.b.k.a.s r3, d.b.k.a.y.i r4) {
            this.f4964d = r1;
            this.f4961a = r2;
            this.f4962b = r3;
            this.f4963c = r4;
        }

        @Override // d.c.d.b, d.c.d.e
        public void a(d.c.d.c<d.c.c.h.a<d.c.i.l.c>> r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            r2.close();
            o.b(this.f4964d, this.f4962b).execute(new e(this));
        }

        @Override // d.c.d.b, d.c.d.e
        public void d(d.c.d.c<d.c.c.h.a<d.c.i.l.c>> r3) {
            if (r3 != null) goto L4;
            return;
        L4:
            float r4 = r3.getProgress();
            o.b(this.f4964d, this.f4962b).execute(new RunnableC0152d(this, r4));
        }

        @Override // d.c.d.b
        protected void e(d.c.d.c<d.c.c.h.a<d.c.i.l.c>> r3) {
            if (r3 != null) goto L4;
            return;
        L4:
            Throwable r4 = r3.c();
            o.b(this.f4964d, this.f4962b).execute(new c(this, r4));
        }

        @Override // d.c.i.h.b
        protected void g(@Nullable Bitmap r3) {
            if (this.f4961a.b() == false) goto L9;
            if (r3 == null) goto L9;
            Bitmap.Config r0 = r3.getConfig();
            if (r0 != null) goto L8;
            r0 = Bitmap.Config.ARGB_8888;
        L8:
            Bitmap r4 = r3.copy(r0, true);
            this.f4961a.close();
            o.b(this.f4964d, this.f4962b).execute(new a(this, r4));
            return;
        L9:
            o.b(this.f4964d, this.f4962b).execute(new b(this));
        }
    }

    o(d.b.k.a.c r2) {
        this.f4952a = r2;
        com.ss.android.m.a.a.h.b r3 = com.ss.android.m.a.a.h.a(com.ss.android.m.a.a.k.f12176k);
        r3.j("fresco-loader-io");
        r3.i(2);
        this.f4953b = com.ss.android.m.a.a.f.a(r3.h());
    }

    static /* synthetic */ d.b.k.a.c a(o r0) {
        return r0.f4952a;
    }

    static /* synthetic */ Executor b(o r0, d.b.k.a.s r1) {
        return r0.n(r1);
    }

    private static void c(d.c.i.q.c r0, d.b.k.a.s r1) {
        d.b.k.a.b r2 = r1.f();
        if (r2 != null) goto L5;
        return;
    L5:
        r2.a();
        throw null;
    }

    private static void d(d.b.k.a.s r2) {
        if (r2.j() != null) goto L5;
        return;
    L5:
        w r0 = (w) r2.D();
        if (r0 != null) goto L8;
        return;
    L8:
        d.b.k.a.e r3 = r2.j();
        if (r0.getHierarchy().m() == null) goto L11;
        d.c.f.f.d r1 = r0.getHierarchy().m();
    L12:
        r0.getHierarchy().H(l(r1, r3));
        return;
    L11:
        r1 = new d.c.f.f.d();
        goto L12
    }

    private static void e(d.c.i.q.c r1, d.b.k.a.s r2) {
        if (r2.k() == null) goto L6;
        r1.E(new com.bytedance.lighten.loader.d(r2.k()));
        return;
    }

    private static d.c.i.f.c f(d.b.k.a.s r4) {
        d.c.i.f.d r0 = d.c.i.f.c.b();
        if (r4.e() == null) goto L5;
        r0.p(r4.e());
    L5:
        r0.q(r4.J());
        if (r4.w() < 0) goto L9;
        r0.t(r4.w());
    L9:
        if (r4.b() == d.b.k.a.a.f13976c.b()) goto L15;
        HashMap r1 = new HashMap();
        r1.put("frame_scheduler_id", Integer.valueOf(r4.b()));
        if (r4.o() == null) goto L13;
        r1.put("frame_scheduler_listener", r4.o());
    L13:
        r0.r(r1);
    L15:
        return r0.a();
    }

    static d.c.i.q.b g(d.b.k.a.s r0, Uri r1) {
        return p(r0, r1).a();
    }

    static d.c.i.q.b[] h(d.b.k.a.s r3) {
        List<String> r0 = o(r3);
        ArrayList r1 = new ArrayList();
        Iterator<String> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        r1.add(p(r3, d.b.k.a.z.c.a(r2.next())).a());
        goto L4
    L7:
        if (r1.size() != 0) goto L11;
        return new d.c.i.q.b[0];
    L11:
        return (d.c.i.q.b[]) r1.toArray(new d.c.i.q.b[r1.size()]);
    }

    private static void i(d.c.i.q.c r0, d.b.k.a.s r1) {
        if (r1.A() != null) goto L5;
        return;
    L5:
        r1.A().a();
        throw null;
    }

    private static d.c.i.f.e j(d.b.k.a.s r1) {
        d.b.k.a.p r2 = r1.x();
        if (r2 != d.b.k.a.p.f14015f) goto L6;
        return d.c.i.f.e.f16015f;
    L6:
        if (r2 != d.b.k.a.p.f14017h) goto L9;
        return d.c.i.f.e.f16017h;
    L9:
        return d.c.i.f.e.f16016g;
    }

    private static d.c.i.f.f k(d.b.k.a.s r2) {
        return new d.c.i.f.f(r2.E(), r2.p());
    }

    static d.c.f.f.d l(d.c.f.f.d r1, d.b.k.a.e r2) {
        if (r2 != null) goto L4;
        return r1;
    L4:
        if (r1 != null) goto L7;
        r1 = new d.c.f.f.d();
    L7:
        if (r2.c() != null) goto L10;
        r1.l(r2.d());
        r1.o(r2.h());
        r1.k(r2.b());
        r1.j(r2.a());
        r1.m(r2.e());
        r1.n(r2.f());
        r1.p(x.d(r2.g()));
        return r1;
    L10:
        r2.c().a();
        throw null;
    }

    private void m(d.c.d.c<d.c.c.h.a<d.c.i.l.c>> r3, d.b.k.a.s r4) {
        d.b.k.a.y.i r0 = r4.s();
        if (r0 != null) goto L5;
        return;
    L5:
        r3.f(new d(this, r3, r4, r0), this.f4953b);
    }

    private Executor n(d.b.k.a.s r2) {
        d.b.k.a.z.b r1 = d.b.k.a.z.b.a();
        if (r2.h() != null) goto L5;
        return r1;
    L5:
        return r2.h();
    }

    private static List<String> o(d.b.k.a.s r1) {
        if (r1.C() == null) goto L10;
        if (r1.C().b() == true) goto L10;
        return r1.C().a();
    L10:
        return Collections.emptyList();
    }

    private static d.c.i.q.c p(d.b.k.a.s r2, Uri r3) {
        d.c.i.q.c r4 = d.c.i.q.c.x(r3);
        r4.F(r2.K());
        r4.y(r2.H());
        if (r2.g() != d.b.k.a.d.f13979f) goto L5;
        r4.A(d.c.i.q.b.a.f16504g);
    L5:
        e(r4, r2);
        i(r4, r2);
        c(r4, r2);
        d(r2);
        d.c.i.f.e r0 = j(r2);
        r4.B(f(r2));
        r4.H(r0);
        r4.y(r2.H());
        if (r2.E() <= 0) goto L8;
    L9:
        r4.I(k(r2));
    L10:
        q(r2);
        r(r2);
        return r4;
    L8:
        if (r2.p() <= 0) goto L10;
        goto L9
    }

    private static void q(d.b.k.a.s r3) {
        if (r3.F() == false) goto L5;
        return;
    L5:
        w r0 = (w) r3.D();
        if (r0 != null) goto L8;
        return;
    L8:
        Drawable r4 = r3.c();
        if (r4 != null) goto L11;
        r0.getHierarchy().r(null);
        return;
    L11:
        r0.getHierarchy().r(new d.c.f.e.o(r4, d.c.f.e.p.b.f15668g));
    }

    private static void r(d.b.k.a.s r4) {
        w r0 = (w) r4.D();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r4.t() <= 0) goto L12;
        if (r4.v() == null) goto L10;
        r0.getHierarchy().z(r4.t(), u.a(r4.v()));
    L15:
        if (r4.m() <= 0) goto L21;
        if (r4.n() == null) goto L19;
        r0.getHierarchy().v(r4.m(), u.a(r4.n()));
        goto L21
    L19:
        r0.getHierarchy().u(r4.m());
    L21:
        if (r4.a() == null) goto L24;
        r0.getHierarchy().q(u.a(r4.a()));
    L24:
        if (r4.y() <= 0) goto L30;
        if (r4.z() == null) goto L28;
        r0.getHierarchy().E(r4.y(), u.a(r4.z()));
        goto L30
    L28:
        r0.getHierarchy().D(r4.y());
    L30:
        if (r4.l() <= 0) goto L33;
        r0.getHierarchy().t(r4.l());
        return;
    L33:
        return;
    L10:
        r0.getHierarchy().y(r4.t());
        goto L15
    L12:
        if (r4.u() == null) goto L15;
        r0.getHierarchy().A(r4.u());
        goto L15
    }

    @Override // d.b.k.a.i
    public void display(d.b.k.a.s r1) {
        if ((r1.D() instanceof v) == false) goto L6;
        ((v) r1.D()).q(r1);
        return;
    L6:
        if ((r1.D() instanceof w) == false) goto L9;
        ((w) r1.D()).q(r1);
        return;
    L9:
        if (r1.d() == null) goto L13;
        j.b(r1.d(), r1);
        return;
    L13:
        throw new IllegalArgumentException("Lighten:needs SmartImageView or ImageView to display, use with(view)");
    }

    @Override // d.b.k.a.i
    public void download(d.b.k.a.s r6) {
        List<String> r0 = o(r6);
        if (r0.isEmpty() == false) goto L5;
        Uri r1 = r6.B();
    L6:
        d.b.k.a.y.g r2 = r6.r();
        if (this.f4952a.b(r1) == false) goto L11;
        if (r2 == null) goto L17;
        n(r6).execute(new a(this, r1, r2));
        return;
    L17:
        return;
    L11:
        d.c.i.q.b r3 = d.c.i.q.b.a(r1);
        d.c.i.g.g r4 = d.c.i.g.j.o().m();
        if (r2 != null) goto L15;
        r4.k(r3, null);
        return;
    L15:
        r4.k(r3, null).f(new b(this, r1, r2), n(r6));
        return;
    L5:
        r1 = Uri.parse(r0.get(0));
        goto L6
    }

    @Override // d.b.k.a.i
    public void loadBitmap(d.b.k.a.s r10) {
        Log.d("Lighten:", "loadBitmap");
        if (r10.C() != null) goto L5;
    L23:
        d.c.i.q.b r0 = g(r10, r10.B());
        m(d.c.i.g.j.o().m().a(r0, null), r10);
        return;
    L5:
        if (r10.C().b() == true) goto L23;
        d.c.i.q.b[] r1 = h(r10);
        if (r1.length != 0) goto L11;
        Log.d("Lighten:", "loadBitmap, url is empty");
        return;
    L11:
        ArrayList r3 = new ArrayList();
        int r4 = r1.length;
        int r5 = 0;
    L12:
        if (r5 >= r4) goto L18;
        d.c.i.q.b r6 = r1[r5];
        if (r6 == null) goto L16;
        r3.add(d.c.f.a.a.c.a().h(r6, null, d.c.i.q.b.EnumC0435b.f16507g));
    L16:
        r5 = r5 + 1;
        goto L12
    L18:
        if (r3.isEmpty() == false) goto L21;
        Log.d("Lighten:", "loadBitmap, suppliers is empty");
        return;
    L21:
        m(d.c.d.f.b(r3).c(), r10);
    }

    @Override // d.b.k.a.i
    public void trimDisk(int r3) {
        Log.d("Lighten:", "trimDisk: level=" + r3);
        this.f4953b.submit(new c(this, r3));
    }

    @Override // d.b.k.a.i
    public void trimMemory(int r2) {
        Log.d("Lighten:", "trimMemory: level=" + r2);
        if (r2 != 5) goto L5;
        p r1 = p.b();
        d.c.c.g.b r3 = d.c.c.g.b.f15397i;
    L12:
        r1.c(r3);
        com.bytedance.lighten.loader.a.f().e();
        return;
    L5:
        if (r2 != 10) goto L7;
        r1 = p.b();
        r3 = d.c.c.g.b.f15395g;
        goto L12
    L7:
        if (r2 != 40) goto L15;
        p.b().c(d.c.c.g.b.f15398j);
        return;
    }
}
