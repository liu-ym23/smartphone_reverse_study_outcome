package d.c.i.p;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class p implements k0<d.c.i.l.e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.c.i.e.e f16368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.c.i.e.e f16369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap<String, d.c.i.e.e> f16370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.c.i.e.f f16371d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final k0<d.c.i.l.e> f16372e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d.c.c.g.i f16373f;

    static /* synthetic */ class a {
    }

    private static class b extends n<d.c.i.l.e, d.c.i.l.e> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final l0 f16374c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final d.c.i.e.e f16375d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final d.c.i.e.e f16376e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final HashMap<String, d.c.i.e.e> f16377f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final d.c.i.e.f f16378g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f16379h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f16380i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final d.c.c.g.i f16381j;

        private b(k<d.c.i.l.e> r1, l0 r2, d.c.i.e.e r3, d.c.i.e.e r4, HashMap<String, d.c.i.e.e> r5, d.c.i.e.f r6, boolean r7, d.c.c.g.i r8) {
            super(r1);
            this.f16374c = r2;
            this.f16375d = r3;
            this.f16376e = r4;
            this.f16377f = r5;
            this.f16378g = r6;
            this.f16379h = r7;
            this.f16381j = r8;
        }

        /* synthetic */ b(k r1, l0 r2, d.c.i.e.e r3, d.c.i.e.e r4, HashMap r5, d.c.i.e.f r6, boolean r7, d.c.c.g.i r8, a r9) {
            this(r1, r2, r3, r4, r5, r6, r7, r8);
        }

        private d.c.i.l.e q(d.c.i.l.e r5) {
            byte[] r0 = ((d.c.i.m.c) this.f16374c.f()).n(r5.O());
            if (r0 != null) goto L5;
        L17:
            return r5;
        L5:
            if (r0.length <= 0) goto L17;
            d.c.c.h.a r1 = null;
            d.c.c.g.k r4 = this.f16381j.f(r0.length);
            r4.write(r0, 0, r0.length);     // Catch: Throwable -> L10 IOException -> L12
            r1 = d.c.c.h.a.V(r4.a());     // Catch: Throwable -> L10 IOException -> L12
            d.c.i.l.e r6 = new d.c.i.l.e(r1);     // Catch: Throwable -> L10 IOException -> L12
            r6.l(r5);     // Catch: Throwable -> L10 IOException -> L12
            r6.r0();     // Catch: Throwable -> L10 IOException -> L12
            d.c.c.h.a.L(r1);
            return r6;
        L10:
            th = move-exception;
            d.c.c.h.a.L(r1);
            throw th;
        L12:
            e = move-exception;
            d.c.c.e.a.k("DiskCacheWriteProducer", "Construct decrypted data error", e);     // Catch: Throwable -> L10
            d.c.c.h.a.L(r1);
            goto L17
        }

        @Override // d.c.i.p.b
        public /* bridge */ /* synthetic */ void i(Object r1, int r2) {
            s((d.c.i.l.e) r1, r2);
        }

        public String r() {
            return this.f16380i;
        }

        public void s(d.c.i.l.e r8, int r9) {
            if (d.c.i.p.b.f(r9) == true) goto L35;
            if (r8 == null) goto L35;
            if (d.c.i.p.b.m(r9, 10) == true) goto L35;
            String r0 = this.f16374c.getId();
            this.f16374c.f().b(r0, "DiskCacheWriteProducer");
            d.c.i.l.e r1 = q(r8);
            this.f16380i = r1.N().a();     // Catch: Throwable -> L32
            if (r1.N() != d.c.h.d.f15831b) goto L15;
            p().d(r1, r9);     // Catch: Throwable -> L32
            d.c.i.l.e.g(r1);
            return;
        L15:
            if (this.f16379h == true) goto L19;
            n0 r10 = this.f16374c.f();     // Catch: Throwable -> L32
            this.f16374c.f().i(r0, "DiskCacheWriteProducer", p.c(r10, r0, r()));     // Catch: Throwable -> L32
            p().d(r1, r9);     // Catch: Throwable -> L32
            d.c.i.l.e.g(r1);
            return;
        L19:
            d.c.i.q.b r3 = this.f16374c.c();     // Catch: Throwable -> L32
            d.c.b.a.d r4 = this.f16378g.e(r3, this.f16374c.a());     // Catch: Throwable -> L32
            if (r3.d() != d.c.i.q.b.a.f16504g) goto L24;
            d.c.i.e.e r5 = this.f16376e;     // Catch: Throwable -> L32
        L22:
            r5.p(r4, r8);     // Catch: Throwable -> L32
        L29:
            n0 r11 = this.f16374c.f();     // Catch: Throwable -> L32
            this.f16374c.f().i(r0, "DiskCacheWriteProducer", p.c(r11, r0, r()));     // Catch: Throwable -> L32
            p().d(r1, r9);     // Catch: Throwable -> L32
            d.c.i.l.e.g(r1);
            return;
        L24:
            if (r3.d() != d.c.i.q.b.a.f16503f) goto L28;
            r5 = this.f16377f.get(r3.e());     // Catch: Throwable -> L32
            if (r5 == null) goto L29;
        L28:
            r5 = this.f16375d;     // Catch: Throwable -> L32
        L32:
            th = move-exception;
            d.c.i.l.e.g(r1);
            throw th;
        L35:
            p().d(r8, r9);
        }
    }

    public p(d.c.i.e.e r1, d.c.i.e.e r2, HashMap<String, d.c.i.e.e> r3, d.c.i.e.f r4, k0<d.c.i.l.e> r5, d.c.c.g.i r6) {
        this.f16368a = r1;
        this.f16369b = r2;
        this.f16370c = r3;
        this.f16371d = r4;
        this.f16372e = r5;
        this.f16373f = r6;
    }

    static Map<String, String> c(n0 r0, String r1, String r2) {
        if (r0.f(r1) == true) goto L7;
        return null;
    L7:
        return d.c.c.d.f.of("imageType", r2);
    }

    private void d(k<d.c.i.l.e> r12, l0 r13) {
        if (r13.h().b() < d.c.i.q.b.EnumC0435b.f16508h.b()) goto L5;
        r12.d(null, 1);
        return;
    L5:
        b r10 = new b(r12, r13, this.f16368a, this.f16369b, this.f16370c, this.f16371d, r13.c().y(), this.f16373f, null);
        this.f16372e.b(r10, r13);
    }

    @Override // d.c.i.p.k0
    public void b(k<d.c.i.l.e> r1, l0 r2) {
        d(r1, r2);
    }
}
