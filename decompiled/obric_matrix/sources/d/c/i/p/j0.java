package d.c.i.p;

import android.graphics.Bitmap;
import android.graphics.Rect;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class j0 implements k0<d.c.c.h.a<d.c.i.l.c>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k0<d.c.c.h.a<d.c.i.l.c>> f16311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.c.i.d.f f16312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f16313c;

    static /* synthetic */ class a {
    }

    private class b extends n<d.c.c.h.a<d.c.i.l.c>, d.c.c.h.a<d.c.i.l.c>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final n0 f16314c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f16315d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final d.c.i.q.d f16316e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final l0 f16317f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f16318g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private d.c.c.h.a<d.c.i.l.c> f16319h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f16320i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f16321j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f16322k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ j0 f16323l;

        class a extends e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f16324a;

            a(b r1, j0 r2) {
                this.f16324a = r1;
            }

            @Override // d.c.i.p.m0
            public void a() {
                b.q(this.f16324a);
            }
        }

        /* JADX INFO: renamed from: d.c.i.p.j0$b$b, reason: collision with other inner class name */
        class C0432b extends d.c.c.b.a {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ b f16325f;

            C0432b(b r1, int r2) {
                this.f16325f = r1;
                super(r2);
            }

            @Override // java.lang.Runnable
            public void run() {
                b r0 = this.f16325f;
                monitor-enter(r0);
                d.c.c.h.a r1 = b.r(this.f16325f);     // Catch: Throwable -> L15
                int r2 = b.t(this.f16325f);     // Catch: Throwable -> L15
                b.s(this.f16325f, null);     // Catch: Throwable -> L15
                b.u(this.f16325f, false);     // Catch: Throwable -> L15
                monitor-exit(r0);     // Catch: Throwable -> L15
                if (d.c.c.h.a.S(r1) == true) goto L20;
            L13:
                b.w(this.f16325f);
                return;
            L20:
                b.v(this.f16325f, r1, r2);     // Catch: Throwable -> L10
                d.c.c.h.a.L(r1);
            L10:
                th = move-exception;
                d.c.c.h.a.L(r1);
                throw th;
            L15:
                th = move-exception;
                throw th;
            }
        }

        public b(j0 r1, k<d.c.c.h.a<d.c.i.l.c>> r2, n0 r3, String r4, d.c.i.q.d r5, l0 r6) {
            this.f16323l = r1;
            super(r2);
            this.f16319h = null;
            this.f16320i = 0;
            this.f16321j = false;
            this.f16322k = false;
            this.f16314c = r3;
            this.f16315d = r4;
            this.f16316e = r5;
            this.f16317f = r6;
            r6.d(new a(this, r1));
        }

        private Map<String, String> A(n0 r1, String r2, d.c.i.q.d r3, Map<String, String> r4) {
            if (r1.f(r2) == true) goto L6;
            return null;
        L6:
            r4.put("Postprocessor", r3.getName());
            return Collections.unmodifiableMap(r4);
        }

        private synchronized boolean B() {
            monitor-enter(this);
            boolean r0 = this.f16318g;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        private void C() {
            if (y() == false) goto L6;
            p().b();
            return;
        }

        private void D(Throwable r2) {
            if (y() == false) goto L6;
            p().a(r2);
            return;
        }

        private void E(d.c.c.h.a<d.c.i.l.c> r3, int r4) {
            boolean r0 = d.c.i.p.b.e(r4);
            if (r0 == false) goto L5;
        L6:
            if (r0 == true) goto L8;
            return;
        L8:
            if (y() == false) goto L12;
        L9:
            p().d(r3, r4);
            return;
        L12:
            return;
        L5:
            if (B() == false) goto L9;
            goto L6
        }

        private d.c.c.h.a<d.c.i.l.c> G(d.c.i.l.c r10, Map<String, String> r11) {
            d.c.i.l.d r0 = (d.c.i.l.d) r10;
            Bitmap r1 = r0.E();
            d.c.i.q.d r2 = this.f16316e;
            if ((r2 instanceof d.c.i.q.a) == false) goto L5;
            d.c.c.h.a<Bitmap> r9 = ((d.c.i.q.a) r2).e(r1, j0.d(this.f16323l), r11);
        L6:
            int r4 = r0.S();
            int r5 = r0.O();
            Rect r6 = r0.Q();
            Rect r7 = r0.X();
            int r8 = r0.V();
            d.c.c.h.a<Bitmap> r3 = r9;
            d.c.c.h.a<d.c.i.l.c> r12 = d.c.c.h.a.V(new d.c.i.l.d(r3, r10.s(), r4, r5, r6, r7, r8));     // Catch: Throwable -> L10
            d.c.c.h.a.L(r9);
            return r12;
        L10:
            th = move-exception;
            d.c.c.h.a.L(r9);
            throw th;
        L5:
            r9 = r2.b(r1, j0.d(this.f16323l));
            goto L6
        }

        private synchronized boolean H() {
            monitor-enter(this);
        L17:
            th = move-exception;
            throw th;
        L4:
            if (this.f16318g == true) goto L15;
            if (this.f16321j == false) goto L15;
            if (this.f16322k == true) goto L15;
            if (d.c.c.h.a.S(this.f16319h) == false) goto L15;
            this.f16322k = true;     // Catch: Throwable -> L17
            monitor-exit(this);
            return true;
        L15:
            monitor-exit(this);
            return false;
        }

        private boolean I(d.c.i.l.c r1) {
            return r1 instanceof d.c.i.l.d;
        }

        private void J() {
            j0.c(this.f16323l).execute(new C0432b(this, d.c.i.f.e.b(this.f16317f.b())));
        }

        private void K(d.c.c.h.a<d.c.i.l.c> r2, int r3) {
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L4:
            if (this.f16318g == false) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L13
            return;
        L7:
            d.c.c.h.a<d.c.i.l.c> r0 = this.f16319h;     // Catch: Throwable -> L13
            this.f16319h = d.c.c.h.a.E(r2);     // Catch: Throwable -> L13
            this.f16320i = r3;     // Catch: Throwable -> L13
            this.f16321j = true;     // Catch: Throwable -> L13
            boolean r4 = H();     // Catch: Throwable -> L13
            monitor-exit(this);     // Catch: Throwable -> L13
            d.c.c.h.a.L(r0);
            if (r4 == false) goto L17;
            J();
            return;
        }

        static /* synthetic */ void q(b r0) {
            r0.C();
        }

        static /* synthetic */ d.c.c.h.a r(b r0) {
            return r0.f16319h;
        }

        static /* synthetic */ d.c.c.h.a s(b r0, d.c.c.h.a r1) {
            r0.f16319h = r1;
            return r1;
        }

        static /* synthetic */ int t(b r0) {
            return r0.f16320i;
        }

        static /* synthetic */ boolean u(b r0, boolean r1) {
            r0.f16321j = r1;
            return r1;
        }

        static /* synthetic */ void v(b r0, d.c.c.h.a r1, int r2) {
            r0.z(r1, r2);
        }

        static /* synthetic */ void w(b r0) {
            r0.x();
        }

        private void x() {
            monitor-enter(this);
            this.f16322k = false;     // Catch: Throwable -> L9
            boolean r0 = H();     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            if (r0 == false) goto L14;
            J();
            return;
        L14:
            return;
        L9:
            th = move-exception;
            throw th;
        }

        private boolean y() {
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (this.f16318g == true) goto L6;
            d.c.c.h.a<d.c.i.l.c> r0 = this.f16319h;     // Catch: Throwable -> L12
            this.f16319h = null;     // Catch: Throwable -> L12
            this.f16318g = true;     // Catch: Throwable -> L12
            monitor-exit(this);     // Catch: Throwable -> L12
            d.c.c.h.a.L(r0);
            return true;
        L6:
            monitor-exit(this);     // Catch: Throwable -> L12
            return false;
        }

        private void z(d.c.c.h.a<d.c.i.l.c> r6, int r7) {
            d.c.c.d.i.b(d.c.c.h.a.S(r6));
            if (I(r6.N()) == true) goto L6;
            E(r6, r7);
            return;
        L6:
            HashMap r0 = new HashMap();
            this.f16314c.b(this.f16315d, "PostprocessorProducer");
            d.c.c.h.a<d.c.i.l.c> r1 = G(r6.N(), r0);     // Catch: Throwable -> L11 Exception -> L13
            n0 r8 = this.f16314c;     // Catch: Throwable -> L11
            String r2 = this.f16315d;     // Catch: Throwable -> L11
            r8.i(r2, "PostprocessorProducer", A(r8, r2, this.f16316e, r0));     // Catch: Throwable -> L11
            E(r1, r7);     // Catch: Throwable -> L11
            d.c.c.h.a.L(r1);
            return;
        L11:
            th = move-exception;
            d.c.c.h.a.L(null);
            throw th;
        L13:
            e = move-exception;
            n0 r9 = this.f16314c;     // Catch: Throwable -> L11
            String r3 = this.f16315d;     // Catch: Throwable -> L11
            r9.j(r3, "PostprocessorProducer", e, A(r9, r3, this.f16316e, r0));     // Catch: Throwable -> L11
            D(e);     // Catch: Throwable -> L11
            d.c.c.h.a.L(null);
        }

        protected void F(d.c.c.h.a<d.c.i.l.c> r2, int r3) {
            if (d.c.c.h.a.S(r2) == false) goto L5;
            K(r2, r3);
            return;
        L5:
            if (d.c.i.p.b.e(r3) == false) goto L10;
            E(null, r3);
            return;
        }

        @Override // d.c.i.p.n, d.c.i.p.b
        protected void g() {
            C();
        }

        @Override // d.c.i.p.n, d.c.i.p.b
        protected void h(Throwable r1) {
            D(r1);
        }

        @Override // d.c.i.p.b
        protected /* bridge */ /* synthetic */ void i(Object r1, int r2) {
            F((d.c.c.h.a) r1, r2);
        }
    }

    class c extends n<d.c.c.h.a<d.c.i.l.c>, d.c.c.h.a<d.c.i.l.c>> implements d.c.i.q.f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f16326c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private d.c.c.h.a<d.c.i.l.c> f16327d;

        class a extends e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ c f16328a;

            a(c r1, j0 r2) {
                this.f16328a = r1;
            }

            @Override // d.c.i.p.m0
            public void a() {
                if (c.q(this.f16328a) == false) goto L6;
                this.f16328a.p().b();
                return;
            }
        }

        private c(j0 r1, b r2, d.c.i.q.e r3, l0 r4) {
            super(r2);
            this.f16326c = false;
            this.f16327d = null;
            r3.a(this);
            r4.d(new a(this, r1));
        }

        /* synthetic */ c(j0 r1, b r2, d.c.i.q.e r3, l0 r4, a r5) {
            this(r1, r2, r3, r4);
        }

        static /* synthetic */ boolean q(c r0) {
            return r0.r();
        }

        private boolean r() {
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (this.f16326c == true) goto L6;
            d.c.c.h.a<d.c.i.l.c> r0 = this.f16327d;     // Catch: Throwable -> L12
            this.f16327d = null;     // Catch: Throwable -> L12
            this.f16326c = true;     // Catch: Throwable -> L12
            monitor-exit(this);     // Catch: Throwable -> L12
            d.c.c.h.a.L(r0);
            return true;
        L6:
            monitor-exit(this);     // Catch: Throwable -> L12
            return false;
        }

        private void t(d.c.c.h.a<d.c.i.l.c> r2) {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.f16326c == false) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L11
            return;
        L7:
            d.c.c.h.a<d.c.i.l.c> r0 = this.f16327d;     // Catch: Throwable -> L11
            this.f16327d = d.c.c.h.a.E(r2);     // Catch: Throwable -> L11
            monitor-exit(this);     // Catch: Throwable -> L11
            d.c.c.h.a.L(r0);
        }

        private void u() {
            monitor-enter(this);
        L15:
            th = move-exception;
            throw th;
        L4:
            if (this.f16326c == false) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L15
            return;
        L7:
            d.c.c.h.a<d.c.i.l.c> r0 = d.c.c.h.a.E(this.f16327d);     // Catch: Throwable -> L15
            monitor-exit(this);     // Catch: Throwable -> L15
            p().d(r0, 0);     // Catch: Throwable -> L12
            d.c.c.h.a.L(r0);
            return;
        L12:
            th = move-exception;
            d.c.c.h.a.L(r0);
            throw th;
        }

        @Override // d.c.i.p.n, d.c.i.p.b
        protected void g() {
            if (r() == false) goto L6;
            p().b();
            return;
        }

        @Override // d.c.i.p.n, d.c.i.p.b
        protected void h(Throwable r2) {
            if (r() == false) goto L6;
            p().a(r2);
            return;
        }

        @Override // d.c.i.p.b
        protected /* bridge */ /* synthetic */ void i(Object r1, int r2) {
            s((d.c.c.h.a) r1, r2);
        }

        protected void s(d.c.c.h.a<d.c.i.l.c> r1, int r2) {
            if (d.c.i.p.b.f(r2) == false) goto L5;
            return;
        L5:
            t(r1);
            u();
        }
    }

    class d extends n<d.c.c.h.a<d.c.i.l.c>, d.c.c.h.a<d.c.i.l.c>> {
        private d(j0 r1, b r2) {
            super(r2);
        }

        /* synthetic */ d(j0 r1, b r2, a r3) {
            this(r1, r2);
        }

        @Override // d.c.i.p.b
        protected /* bridge */ /* synthetic */ void i(Object r1, int r2) {
            q((d.c.c.h.a) r1, r2);
        }

        protected void q(d.c.c.h.a<d.c.i.l.c> r2, int r3) {
            if (d.c.i.p.b.f(r3) == false) goto L5;
            return;
        L5:
            p().d(r2, r3);
        }
    }

    public j0(k0<d.c.c.h.a<d.c.i.l.c>> r1, d.c.i.d.f r2, Executor r3) {
        d.c.c.d.i.g(r1);
        this.f16311a = r1;
        this.f16312b = r2;
        d.c.c.d.i.g(r3);
        this.f16313c = r3;
    }

    static /* synthetic */ Executor c(j0 r0) {
        return r0.f16313c;
    }

    static /* synthetic */ d.c.i.d.f d(j0 r0) {
        return r0.f16312b;
    }

    @Override // d.c.i.p.k0
    public void b(k<d.c.c.h.a<d.c.i.l.c>> r10, l0 r11) {
        n0 r3 = r11.f();
        d.c.i.q.d r7 = r11.c().j();
        b r8 = new b(this, r10, r3, r11.getId(), r7, r11);
        if ((r7 instanceof d.c.i.q.e) == false) goto L5;
        k<d.c.c.h.a<d.c.i.l.c>> r6 = new c(this, r8, (d.c.i.q.e) r7, r11, null);
    L6:
        this.f16311a.b(r6, r11);
        return;
    L5:
        r6 = new d(this, r8, null);
        goto L6
    }
}
