package d.c.i.p;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class s implements k0<d.c.i.l.e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.c.i.e.q<d.c.b.a.d, d.c.c.g.h> f16398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.c.i.e.f f16399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final k0<d.c.i.l.e> f16400c;

    private static class a extends n<d.c.i.l.e, d.c.i.l.e> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final d.c.i.e.q<d.c.b.a.d, d.c.c.g.h> f16401c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final d.c.b.a.d f16402d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f16403e;

        public a(k<d.c.i.l.e> r1, d.c.i.e.q<d.c.b.a.d, d.c.c.g.h> r2, d.c.b.a.d r3, boolean r4) {
            super(r1);
            this.f16401c = r2;
            this.f16402d = r3;
            this.f16403e = r4;
        }

        @Override // d.c.i.p.b
        public /* bridge */ /* synthetic */ void i(Object r1, int r2) {
            q((d.c.i.l.e) r1, r2);
        }

        public void q(d.c.i.l.e r4, int r5) {
        L48:
            th = move-exception;
            if (d.c.i.r.b.d() == false) goto L52;
            d.c.i.r.b.b();
        L52:
            throw th;
        L3:
            if (d.c.i.r.b.d() == false) goto L6;
            d.c.i.r.b.a("EncodedMemoryCacheProducer#onNewResultImpl");     // Catch: Throwable -> L48
        L6:
            if (b.f(r5) == true) goto L43;
            if (r4 == null) goto L43;
            if (b.m(r5, 10) == true) goto L43;
            if (r4.N() == d.c.h.d.f15831b) goto L43;
            d.c.c.h.a<d.c.c.g.h> r0 = r4.s();     // Catch: Throwable -> L48
            if (r0 == null) goto L38;
            d.c.c.h.a<d.c.c.g.h> r1 = null;
        L35:
            th = move-exception;
            d.c.c.h.a.L(r0);     // Catch: Throwable -> L48
            throw th;     // Catch: Throwable -> L48
        L17:
            if (this.f16403e == false) goto L19;
            r1 = this.f16401c.b(this.f16402d, r0);     // Catch: Throwable -> L35
        L19:
            d.c.c.h.a.L(r0);     // Catch: Throwable -> L48
            if (r1 == null) goto L38;
            d.c.i.l.e r2 = new d.c.i.l.e(r1);     // Catch: Throwable -> L32
            r2.l(r4);     // Catch: Throwable -> L32
            d.c.c.h.a.L(r1);     // Catch: Throwable -> L48
            p().c(1.0f);     // Catch: Throwable -> L29
            p().d(r2, r5);     // Catch: Throwable -> L29
            d.c.i.l.e.g(r2);     // Catch: Throwable -> L48
            if (d.c.i.r.b.d() == false) goto L60;
            d.c.i.r.b.b();
            return;
        L60:
            return;
        L29:
            th = move-exception;
            d.c.i.l.e.g(r2);     // Catch: Throwable -> L48
            throw th;     // Catch: Throwable -> L48
        L32:
            th = move-exception;
            d.c.c.h.a.L(r1);     // Catch: Throwable -> L48
            throw th;     // Catch: Throwable -> L48
        L38:
            p().d(r4, r5);     // Catch: Throwable -> L48
            if (d.c.i.r.b.d() == false) goto L61;
            d.c.i.r.b.b();
            return;
        L61:
            return;
        L43:
            p().d(r4, r5);     // Catch: Throwable -> L48
            if (d.c.i.r.b.d() == false) goto L62;
            d.c.i.r.b.b();
            return;
        }
    }

    public s(d.c.i.e.q<d.c.b.a.d, d.c.c.g.h> r1, d.c.i.e.f r2, k0<d.c.i.l.e> r3) {
        this.f16398a = r1;
        this.f16399b = r2;
        this.f16400c = r3;
    }

    @Override // d.c.i.p.k0
    public void b(k<d.c.i.l.e> r12, l0 r13) {
    L48:
        th = move-exception;
        if (d.c.i.r.b.d() == false) goto L52;
        d.c.i.r.b.b();
    L52:
        throw th;
    L4:
        if (d.c.i.r.b.d() == false) goto L6;
        d.c.i.r.b.a("EncodedMemoryCacheProducer#produceResults");     // Catch: Throwable -> L48
    L6:
        String r1 = r13.getId();     // Catch: Throwable -> L48
        n0 r2 = r13.f();     // Catch: Throwable -> L48
        r2.b(r1, "EncodedMemoryCacheProducer");     // Catch: Throwable -> L48
        d.c.b.a.d r3 = this.f16399b.e(r13.c(), r13.a());     // Catch: Throwable -> L48
        d.c.c.h.a<d.c.c.g.h> r4 = this.f16398a.get(r3);     // Catch: Throwable -> L48
        Map<String, String> r7 = null;
        if (r4 == null) goto L25;
        d.c.i.l.e r11 = new d.c.i.l.e(r4);     // Catch: Throwable -> L45
    L20:
        th = move-exception;
        d.c.i.l.e.g(r11);     // Catch: Throwable -> L45
        throw th;     // Catch: Throwable -> L45
    L11:
        if (r2.f(r1) == false) goto L13;
        r7 = d.c.c.d.f.of("cached_value_found", "true");     // Catch: Throwable -> L20
    L13:
        r2.i(r1, "EncodedMemoryCacheProducer", r7);     // Catch: Throwable -> L20
        r2.e(r1, "EncodedMemoryCacheProducer", true);     // Catch: Throwable -> L20
        r12.c(1.0f);     // Catch: Throwable -> L20
        r12.d(r11, 1);     // Catch: Throwable -> L20
        d.c.i.l.e.g(r11);     // Catch: Throwable -> L45
        d.c.c.h.a.L(r4);     // Catch: Throwable -> L48
        if (d.c.i.r.b.d() == false) goto L57;
        d.c.i.r.b.b();
        return;
    L57:
        return;
    L25:
        if (r13.h().b() >= d.c.i.q.b.EnumC0435b.f16509i.b()) goto L27;
        a r8 = new a(r12, this.f16398a, r3, r13.c().z());     // Catch: Throwable -> L45
        if (r2.f(r1) == false) goto L39;
        r7 = d.c.c.d.f.of("cached_value_found", "false");     // Catch: Throwable -> L45
    L39:
        r2.i(r1, "EncodedMemoryCacheProducer", r7);     // Catch: Throwable -> L45
        this.f16400c.b(r8, r13);     // Catch: Throwable -> L45
        d.c.c.h.a.L(r4);     // Catch: Throwable -> L48
        if (d.c.i.r.b.d() == false) goto L59;
        d.c.i.r.b.b();
        return;
    L59:
        return;
    L27:
        if (r2.f(r1) == false) goto L29;
        Map<String, String> r14 = d.c.c.d.f.of("cached_value_found", "false");     // Catch: Throwable -> L45
    L30:
        r2.i(r1, "EncodedMemoryCacheProducer", r14);     // Catch: Throwable -> L45
        r2.e(r1, "EncodedMemoryCacheProducer", false);     // Catch: Throwable -> L45
        r12.d(null, 1);     // Catch: Throwable -> L45
        d.c.c.h.a.L(r4);     // Catch: Throwable -> L48
        if (d.c.i.r.b.d() == false) goto L58;
        d.c.i.r.b.b();
        return;
    L58:
        return;
    L29:
        r14 = null;
    L45:
        th = move-exception;
        d.c.c.h.a.L(r4);     // Catch: Throwable -> L48
        throw th;     // Catch: Throwable -> L48
    }
}
