package d.c.i.p;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class i0 implements k0<d.c.c.h.a<d.c.i.l.c>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.c.i.e.q<d.c.b.a.d, d.c.i.l.c> f16300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.c.i.e.f f16301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final k0<d.c.c.h.a<d.c.i.l.c>> f16302c;

    public static class a extends n<d.c.c.h.a<d.c.i.l.c>, d.c.c.h.a<d.c.i.l.c>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final d.c.b.a.d f16303c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f16304d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final d.c.i.e.q<d.c.b.a.d, d.c.i.l.c> f16305e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f16306f;

        public a(k<d.c.c.h.a<d.c.i.l.c>> r1, d.c.b.a.d r2, boolean r3, d.c.i.e.q<d.c.b.a.d, d.c.i.l.c> r4, boolean r5) {
            super(r1);
            this.f16303c = r2;
            this.f16304d = r3;
            this.f16305e = r4;
            this.f16306f = r5;
        }

        @Override // d.c.i.p.b
        protected /* bridge */ /* synthetic */ void i(Object r1, int r2) {
            q((d.c.c.h.a) r1, r2);
        }

        protected void q(d.c.c.h.a<d.c.i.l.c> r4, int r5) {
            d.c.c.h.a<d.c.i.l.c> r0 = null;
            if (r4 != null) goto L9;
            if (b.e(r5) == false) goto L27;
            p().d(null, r5);
            return;
        L27:
            return;
        L9:
            if (b.f(r5) == false) goto L14;
            if (this.f16304d == true) goto L14;
            return;
        L14:
            if (this.f16306f == false) goto L25;
            r0 = this.f16305e.b(this.f16303c, r4);
        L25:
            p().c(1.0f);     // Catch: Throwable -> L22
            k<d.c.c.h.a<d.c.i.l.c>> r3 = p();     // Catch: Throwable -> L22
            if (r0 == null) goto L19;
            r4 = r0;
        L19:
            r3.d(r4, r5);     // Catch: Throwable -> L22
            d.c.c.h.a.L(r0);
            return;
        L22:
            th = move-exception;
            d.c.c.h.a.L(r0);
            throw th;
        }
    }

    public i0(d.c.i.e.q<d.c.b.a.d, d.c.i.l.c> r1, d.c.i.e.f r2, k0<d.c.c.h.a<d.c.i.l.c>> r3) {
        this.f16300a = r1;
        this.f16301b = r2;
        this.f16302c = r3;
    }

    @Override // d.c.i.p.k0
    public void b(k<d.c.c.h.a<d.c.i.l.c>> r13, l0 r14) {
        n0 r0 = r14.f();
        String r1 = r14.getId();
        d.c.i.q.b r2 = r14.c();
        Object r3 = r14.a();
        d.c.i.q.d r4 = r2.j();
        if (r4 != null) goto L5;
    L18:
        this.f16302c.b(r13, r14);
        return;
    L5:
        if (r4.c() == null) goto L18;
        r0.b(r1, c());
        d.c.b.a.d r8 = this.f16301b.d(r2, r3);
        d.c.c.h.a<d.c.i.l.c> r5 = this.f16300a.get(r8);
        Map<String, String> r6 = null;
        if (r5 == null) goto L13;
        String r12 = c();
        if (r0.f(r1) == false) goto L12;
        r6 = d.c.c.d.f.of("cached_value_found", "true");
    L12:
        r0.i(r1, r12, r6);
        r0.e(r1, "PostprocessedBitmapMemoryCacheProducer", true);
        r13.c(1.0f);
        r13.d(r5, 1);
        r5.close();
        return;
    L13:
        boolean r11 = r14.c().z();
        a r7 = new a(r13, r8, r4 instanceof d.c.i.q.e, this.f16300a, r11);
        String r15 = c();
        if (r0.f(r1) == false) goto L16;
        r6 = d.c.c.d.f.of("cached_value_found", "false");
    L16:
        r0.i(r1, r15, r6);
        this.f16302c.b(r7, r14);
    }

    protected String c() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
