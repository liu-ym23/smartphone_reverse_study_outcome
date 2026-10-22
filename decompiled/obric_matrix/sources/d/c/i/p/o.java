package d.c.i.p;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class o implements k0<d.c.i.l.e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.c.i.e.e f16355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.c.i.e.e f16356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap<String, d.c.i.e.e> f16357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.c.i.e.f f16358d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final k0<d.c.i.l.e> f16359e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d.c.c.g.i f16360f;

    class a implements c.d<d.c.i.l.e, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ n0 f16361a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16362b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f16363c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ l0 f16364d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ o f16365e;

        a(o r1, n0 r2, String r3, k r4, l0 r5) {
            this.f16365e = r1;
            this.f16361a = r2;
            this.f16362b = r3;
            this.f16363c = r4;
            this.f16364d = r5;
        }

        private d.c.i.l.e b(d.c.i.l.e r4, l0 r5) {
            byte[] r6 = ((d.c.i.m.c) r5.f()).n(r4.O());
            if (r6 != null) goto L5;
        L17:
            return r4;
        L5:
            if (r6.length <= 0) goto L17;
            d.c.c.h.a r0 = null;
            d.c.c.g.k r3 = o.e(this.f16365e).f(r6.length);
            r3.write(r6, 0, r6.length);     // Catch: Throwable -> L10 IOException -> L12
            r0 = d.c.c.h.a.V(r3.a());     // Catch: Throwable -> L10 IOException -> L12
            d.c.i.l.e r7 = new d.c.i.l.e(r0);     // Catch: Throwable -> L10 IOException -> L12
            r7.l(r4);     // Catch: Throwable -> L10 IOException -> L12
            r7.r0();     // Catch: Throwable -> L10 IOException -> L12
            d.c.c.h.a.L(r0);
            return r7;
        L10:
            th = move-exception;
            d.c.c.h.a.L(r0);
            throw th;
        L12:
            e = move-exception;
            d.c.c.e.a.k("DiskCacheProducer", "Construct decrypted data error", e);     // Catch: Throwable -> L10
            d.c.c.h.a.L(r0);
            goto L17
        }

        @Override // c.d
        public /* bridge */ /* synthetic */ Void a(c.f<d.c.i.l.e> r1) {
            return c(r1);
        }

        public Void c(c.f<d.c.i.l.e> r8) {
            if (o.c(r8) == false) goto L6;
            this.f16361a.d(this.f16362b, "DiskCacheProducer", null);
            this.f16363c.b();
        L13:
            return null;
        L6:
            if (r8.n() == false) goto L9;
            this.f16361a.j(this.f16362b, "DiskCacheProducer", r8.i(), null);
        L8:
            o.d(this.f16365e).b(this.f16363c, this.f16364d);
            goto L13
        L9:
            d.c.i.l.e r9 = r8.j();
            if (r9 == null) goto L12;
            d.c.i.l.e r0 = b(r9, this.f16364d);
            r0.g0();
            n0 r3 = this.f16361a;
            String r4 = this.f16362b;
            r3.i(r4, "DiskCacheProducer", o.f(r3, r4, true, r0.X()));
            this.f16361a.e(this.f16362b, "DiskCacheProducer", true);
            this.f16363c.c(1.0f);
            this.f16363c.d(r0, 1);
            r9.close();
            r0.close();
            goto L13
        L12:
            n0 r10 = this.f16361a;
            String r1 = this.f16362b;
            r10.i(r1, "DiskCacheProducer", o.f(r10, r1, false, 0));
            goto L8
        }
    }

    class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f16366a;

        b(o r1, AtomicBoolean r2) {
            this.f16366a = r2;
        }

        @Override // d.c.i.p.m0
        public void a() {
            this.f16366a.set(true);
        }
    }

    public o(d.c.i.e.e r1, d.c.i.e.e r2, HashMap<String, d.c.i.e.e> r3, d.c.i.e.f r4, k0<d.c.i.l.e> r5, d.c.c.g.i r6) {
        this.f16355a = r1;
        this.f16356b = r2;
        this.f16357c = r3;
        this.f16358d = r4;
        this.f16359e = r5;
        this.f16360f = r6;
    }

    static /* synthetic */ boolean c(c.f r0) {
        return i(r0);
    }

    static /* synthetic */ k0 d(o r0) {
        return r0.f16359e;
    }

    static /* synthetic */ d.c.c.g.i e(o r0) {
        return r0.f16360f;
    }

    static Map<String, String> f(n0 r0, String r1, boolean r2, int r3) {
        if (r0.f(r1) == true) goto L6;
        return null;
    L6:
        String r4 = String.valueOf(r2);
        if (r2 == false) goto L11;
        return d.c.c.d.f.of("cached_value_found", r4, "encodedImageSize", String.valueOf(r3));
    L11:
        return d.c.c.d.f.of("cached_value_found", r4);
    }

    private static boolean i(c.f<?> r1) {
        if (r1.l() == false) goto L5;
    L10:
        return true;
    L5:
        if (r1.n() == true) goto L7;
    L9:
        return false;
    L7:
        if ((r1.i() instanceof CancellationException) == false) goto L9;
        goto L9
    }

    private void j(k<d.c.i.l.e> r3, l0 r4) {
        if (r4.h().b() < d.c.i.q.b.EnumC0435b.f16508h.b()) goto L6;
        r3.d(null, 1);
        return;
    L6:
        this.f16359e.b(r3, r4);
    }

    private c.d<d.c.i.l.e, Void> k(k<d.c.i.l.e> r8, l0 r9) {
        String r3 = r9.getId();
        return new a(this, r9.f(), r3, r8, r9);
    }

    private void l(AtomicBoolean r2, l0 r3) {
        r3.d(new b(this, r2));
    }

    @Override // d.c.i.p.k0
    public void b(k<d.c.i.l.e> r8, l0 r9) {
        d.c.i.q.b r0 = r9.c();
        if (h(r9) == true) goto L6;
        j(r8, r9);
        return;
    L6:
        r9.f().b(r9.getId(), "DiskCacheProducer");
        d.c.b.a.d r1 = g(this.f16358d, r9);
        boolean r4 = true;
        if (r0.d() != d.c.i.q.b.a.f16504g) goto L9;
        boolean r2 = true;
    L11:
        if (r0.d() == d.c.i.q.b.a.f16503f) goto L14;
        r4 = false;
    L14:
        d.c.i.e.e r3 = null;
        if (r4 == false) goto L17;
        r3 = this.f16357c.get(r0.e());
    L17:
        if (r3 != null) goto L22;
        if (r2 == false) goto L20;
        d.c.i.e.e r5 = this.f16356b;
    L21:
        r3 = r5;
        goto L22
    L20:
        r5 = this.f16355a;
    L22:
        AtomicBoolean r6 = new AtomicBoolean(false);
        r3.m(r1, r6).e(k(r8, r9));
        l(r6, r9);
        return;
    L9:
        r2 = false;
        goto L11
    }

    protected d.c.b.a.d g(d.c.i.e.f r1, l0 r2) {
        return r1.e(r2.c(), r2.a());
    }

    protected boolean h(l0 r1) {
        return r1.c().y();
    }
}
