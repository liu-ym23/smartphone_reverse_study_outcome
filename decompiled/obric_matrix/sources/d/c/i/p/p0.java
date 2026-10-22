package d.c.i.p;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class p0 implements k0<d.c.i.l.e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f16382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.c.c.g.i f16383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final k0<d.c.i.l.e> f16384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f16385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.c.i.s.c f16386e;

    private class a extends n<d.c.i.l.e, d.c.i.l.e> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f16387c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final d.c.i.s.c f16388d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final l0 f16389e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f16390f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final v f16391g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ p0 f16392h;

        /* JADX INFO: renamed from: d.c.i.p.p0$a$a, reason: collision with other inner class name */
        class C0433a extends v.h {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f16393b;

            C0433a(a r1, d.c.i.f.e r2, p0 r3) {
                this.f16393b = r1;
                super(r2);
            }

            @Override // d.c.i.p.v.e
            public void a(d.c.i.l.e r4, int r5) {
                a r0 = this.f16393b;
                d.c.i.s.b r3 = a.r(r0).a(r4.N(), a.q(this.f16393b));
                d.c.c.d.i.g(r3);
                a.s(r0, r4, r5, r3);
            }
        }

        class b extends e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ k f16394a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f16395b;

            b(a r1, p0 r2, k r3) {
                this.f16395b = r1;
                this.f16394a = r3;
            }

            @Override // d.c.i.p.m0
            public void a() {
                a.u(this.f16395b).c();
                a.v(this.f16395b, true);
                this.f16394a.b();
            }

            @Override // d.c.i.p.e, d.c.i.p.m0
            public void b() {
                if (a.t(this.f16395b).g() == false) goto L6;
                a.u(this.f16395b).h();
                return;
            }
        }

        a(p0 r3, k<d.c.i.l.e> r4, l0 r5, boolean r6, d.c.i.s.c r7) {
            this.f16392h = r3;
            super(r4);
            this.f16390f = false;
            this.f16389e = r5;
            this.f16387c = r6;
            this.f16388d = r7;
            C0433a r8 = new C0433a(this, r5.b(), r3);
            this.f16391g = new v(p0.c(r3), r8, 100);
            r5.d(new b(this, r3, r4));
        }

        static /* synthetic */ boolean q(a r0) {
            return r0.f16387c;
        }

        static /* synthetic */ d.c.i.s.c r(a r0) {
            return r0.f16388d;
        }

        static /* synthetic */ void s(a r0, d.c.i.l.e r1, int r2, d.c.i.s.b r3) {
            r0.w(r1, r2, r3);
        }

        static /* synthetic */ l0 t(a r0) {
            return r0.f16389e;
        }

        static /* synthetic */ v u(a r0) {
            return r0.f16391g;
        }

        static /* synthetic */ boolean v(a r0, boolean r1) {
            r0.f16390f = r1;
            return r1;
        }

        private void w(d.c.i.l.e r12, int r13, d.c.i.s.b r14) {
            this.f16389e.f().b(this.f16389e.getId(), "ResizeAndRotateProducer");
            d.c.i.q.b r0 = this.f16389e.c();
            d.c.c.g.k r1 = p0.e(this.f16392h).a();
            d.c.i.s.a r3 = r14.c(r12, r1, r0.s(), r0.r(), null, 85);     // Catch: Throwable -> L23 Exception -> L25
            if (r3.a() == 2) goto L22;
            Map<String, String> r10 = x(r12, r0.r(), r3, r14.a());     // Catch: Throwable -> L23 Exception -> L25
            d.c.c.h.a r15 = d.c.c.h.a.V(r1.a());     // Catch: Throwable -> L23 Exception -> L25
            d.c.i.l.e r16 = new d.c.i.l.e(r15);     // Catch: Throwable -> L18
            r16.D0(d.c.h.c.f15819a);     // Catch: Throwable -> L18
            r16.r0();     // Catch: Throwable -> L15
            this.f16389e.f().i(this.f16389e.getId(), "ResizeAndRotateProducer", r10);     // Catch: Throwable -> L15
            if (r3.a() == 1) goto L10;
            r13 = r13 | 16;     // Catch: Throwable -> L15
        L10:
            p().d(r16, r13);     // Catch: Throwable -> L15
            d.c.i.l.e.g(r16);     // Catch: Throwable -> L18
            d.c.c.h.a.L(r15);     // Catch: Throwable -> L23 Exception -> L25
            r1.close();
            return;
        L15:
            th = move-exception;
            d.c.i.l.e.g(r16);     // Catch: Throwable -> L18
            throw th;     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            d.c.c.h.a.L(r15);     // Catch: Throwable -> L23 Exception -> L25
            throw th;     // Catch: Throwable -> L23 Exception -> L25
        L22:
            throw new RuntimeException("Error while transcoding the image");     // Catch: Throwable -> L23 Exception -> L25
        L25:
            e = move-exception;
            this.f16389e.f().j(this.f16389e.getId(), "ResizeAndRotateProducer", e, null);     // Catch: Throwable -> L23
            if (d.c.i.p.b.e(r13) == false) goto L29;
            p().a(e);     // Catch: Throwable -> L23
        L29:
            r1.close();
            return;
        L23:
            th = move-exception;
            r1.close();
            throw th;
        }

        private Map<String, String> x(d.c.i.l.e r5, d.c.i.f.f r6, d.c.i.s.a r7, String r8) {
            if (this.f16389e.f().f(this.f16389e.getId()) == true) goto L6;
            return null;
        L6:
            String r0 = r5.Y() + "x" + r5.M();
            if (r6 == null) goto L9;
            String r9 = r6.f16021a + "x" + r6.f16022b;
        L10:
            HashMap r1 = new HashMap();
            r1.put("Image format", String.valueOf(r5.N()));
            r1.put("Original size", r0);
            r1.put("Requested size", r9);
            r1.put("queueTime", String.valueOf(this.f16391g.f()));
            r1.put("Transcoder id", r8);
            r1.put("Transcoding result", String.valueOf(r7));
            return d.c.c.d.f.a(r1);
        L9:
            r9 = "Unspecified";
            goto L10
        }

        private d.c.i.l.e y(d.c.i.l.e r1) {
            d.c.i.l.e r0 = d.c.i.l.e.b(r1);
            r1.close();
            return r0;
        }

        @Override // d.c.i.p.b
        protected /* bridge */ /* synthetic */ void i(Object r1, int r2) {
            z((d.c.i.l.e) r1, r2);
        }

        protected void z(d.c.i.l.e r6, int r7) {
            if (this.f16390f == false) goto L5;
            return;
        L5:
            boolean r0 = d.c.i.p.b.e(r7);
            if (r6 != null) goto L10;
            if (r0 == false) goto L36;
            p().d(null, 1);
            return;
        L36:
            return;
        L10:
            d.c.i.q.b r1 = this.f16389e.c();
            d.c.i.s.b r2 = this.f16388d.a(r6.N(), this.f16387c);
            d.c.c.d.i.g(r2);
            d.c.c.k.e r3 = p0.d(r1, r6, r2);
            if (r0 == true) goto L16;
            if (r3 != d.c.c.k.e.f15444h) goto L16;
            return;
        L16:
            if (r3 == d.c.c.k.e.f15442f) goto L29;
            if (this.f16389e.c().s().c() == false) goto L20;
        L26:
            p().d(r6, r7);
            return;
        L20:
            if (r6.S() == 0) goto L26;
            if (r6.S() == (-1)) goto L26;
            if (r6.N() == com.facebook.imageutils.a.a()) goto L26;
            r6 = y(r6);
            r6.G0(0);
            goto L26
        L29:
            if (this.f16391g.k(r6, r7) == true) goto L31;
            return;
        L31:
            if (r0 == false) goto L33;
        L34:
            this.f16391g.h();
            return;
        L33:
            if (this.f16389e.g() == true) goto L34;
        }
    }

    public p0(Executor r1, d.c.c.g.i r2, k0<d.c.i.l.e> r3, boolean r4, d.c.i.s.c r5) {
        d.c.c.d.i.g(r1);
        this.f16382a = r1;
        d.c.c.d.i.g(r2);
        this.f16383b = r2;
        d.c.c.d.i.g(r3);
        this.f16384c = r3;
        d.c.c.d.i.g(r5);
        this.f16386e = r5;
        this.f16385d = r4;
    }

    static /* synthetic */ Executor c(p0 r0) {
        return r0.f16382a;
    }

    static /* synthetic */ d.c.c.k.e d(d.c.i.q.b r0, d.c.i.l.e r1, d.c.i.s.b r2) {
        return h(r0, r1, r2);
    }

    static /* synthetic */ d.c.c.g.i e(p0 r0) {
        return r0.f16383b;
    }

    private static boolean f(d.c.i.f.g r1, d.c.i.l.e r2) {
        if (r1.c() == false) goto L5;
    L9:
        return false;
    L5:
        if (d.c.i.s.d.e(r1, r2) == 0) goto L7;
    L8:
        return true;
    L7:
        if (g(r1, r2) == false) goto L9;
        goto L8
    }

    private static boolean g(d.c.i.f.g r1, d.c.i.l.e r2) {
        if (r1.f() == true) goto L5;
    L9:
        r2.A0(0);
        return false;
    L5:
        if (r1.c() == true) goto L9;
        return d.c.i.s.d.f16527a.contains(Integer.valueOf(r2.E()));
    }

    private static d.c.c.k.e h(d.c.i.q.b r2, d.c.i.l.e r3, d.c.i.s.b r4) {
        if (r3 == null) goto L20;
        if (r3.N() == d.c.h.d.f15831b) goto L20;
        if (r4.d(r3.N()) == true) goto L11;
        return d.c.c.k.e.f15443g;
    L11:
        if (f(r2.s(), r3) == false) goto L13;
    L16:
        boolean r5 = true;
    L18:
        return d.c.c.k.e.a(r5);
    L13:
        if (r4.b(r3, r2.s(), r2.r()) == true) goto L16;
        r5 = false;
    L20:
        return d.c.c.k.e.f15444h;
    }

    @Override // d.c.i.p.k0
    public void b(k<d.c.i.l.e> r9, l0 r10) {
        this.f16384c.b(new a(this, r9, r10, this.f16385d, this.f16386e), r10);
    }
}
