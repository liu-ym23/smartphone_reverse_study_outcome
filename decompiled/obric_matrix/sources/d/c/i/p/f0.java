package d.c.i.p;

import android.os.SystemClock;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class f0 implements k0<d.c.i.l.e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.c.c.g.i f16265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.c.c.g.a f16266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g0 f16267c;

    class a implements g0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ t f16268a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ f0 f16269b;

        a(f0 r1, t r2) {
            this.f16269b = r1;
            this.f16268a = r2;
        }

        @Override // d.c.i.p.g0.a
        public void a(Throwable r2) {
            f0.c(this.f16269b, this.f16268a, r2);
        }

        @Override // d.c.i.p.g0.a
        public void b() {
            f0.d(this.f16269b, this.f16268a);
        }

        @Override // d.c.i.p.g0.a
        public void c(InputStream r2, int r3) {
            if (d.c.i.r.b.d() == false) goto L5;
            d.c.i.r.b.a("NetworkFetcher->onResponse");
        L5:
            this.f16269b.p(this.f16268a, r2, r3);
            if (d.c.i.r.b.d() == false) goto L9;
            d.c.i.r.b.b();
            return;
        }
    }

    public f0(d.c.c.g.i r1, d.c.c.g.a r2, g0 r3) {
        this.f16265a = r1;
        this.f16266b = r2;
        this.f16267c = r3;
    }

    static /* synthetic */ void c(f0 r0, t r1, Throwable r2) {
        r0.o(r1, r2);
    }

    static /* synthetic */ void d(f0 r0, t r1) {
        r0.n(r1);
    }

    public static String e(byte[] r6) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r6.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        int r4 = r6[r3] & 255;
        if (r4 >= 16) goto L7;
        r0.append(0);
    L7:
        r0.append(Integer.toHexString(r4));
        r3 = r3 + 1;
        goto L3
    L9:
        return r0.toString();
    }

    protected static float f(int r4, int r5) {
        if (r5 <= 0) goto L6;
        return r4 / r5;
    L6:
        return 1.0f - ((float) Math.exp(((double) (-r4)) / 50000.0d));
    }

    private Map<String, String> g(t r3, int r4) {
        if (r3.g().f(r3.e()) == true) goto L7;
        return null;
    L7:
        return this.f16267c.c(r3, r4);
    }

    private long h(d.c.i.q.b r1) {
        if (r1.D() == false) goto L6;
        return 10;
    L6:
        return 100;
    }

    private boolean k(t r2) {
        d.c.i.q.b r1 = r2.c().c();
        if (r1.d() != d.c.i.q.b.a.f16504g) goto L8;
        d.c.i.e.e r3 = d.c.i.g.j.o().v();
    L6:
        return r3.o();
    L8:
        if (r1.d() != d.c.i.q.b.a.f16503f) goto L10;
        r3 = d.c.i.g.j.o().h().get(r1.e());
        goto L6
    L10:
        r3 = d.c.i.g.j.o().p();
        goto L6
    }

    protected static void m(d.c.c.g.k r2, int r3, d.c.i.f.a r4, k<d.c.i.l.e> r5, Map<String, String> r6) {
        d.c.c.h.a r7 = d.c.c.h.a.V(r2.a());
        d.c.i.l.e r0 = null;
        d.c.i.l.e r1 = new d.c.i.l.e(r7);     // Catch: Throwable -> L9
        r1.B0(r6);     // Catch: Throwable -> L7
        r1.y0(r4);     // Catch: Throwable -> L7
        r1.r0();     // Catch: Throwable -> L7
        r1.F0();     // Catch: Throwable -> L7
        r5.d(r1, r3);     // Catch: Throwable -> L7
        d.c.i.l.e.g(r1);
        d.c.c.h.a.L(r7);
        return;
    L7:
        th = th;
        r0 = r1;
    L10:
        d.c.i.l.e.g(r0);
        d.c.c.h.a.L(r7);
        throw th;
    L9:
        th = th;
        goto L10
    }

    private void n(t r4) {
        Map<String, String> r3 = g(r4, -1);
        r4.g().d(r4.e(), "NetworkFetchProducer", r3);
        r4.b().b();
    }

    private void o(t r4, Throwable r5) {
        Map<String, String> r0 = g(r4, -1);
        if (r0 != null) goto L6;
        r0 = new HashMap(1);
    L6:
        if (this.f16267c != null) goto L8;
        String r3 = "null";
    L9:
        r0.put("NetworkFetcher", r3);
        r4.g().j(r4.e(), "NetworkFetchProducer", r5, r0);
        r4.g().e(r4.e(), "NetworkFetchProducer", false);
        r4.b().a(r5);
        return;
    L8:
        r3 = this.f16267c.getClass().getName() + ", " + this.f16267c.toString();
        goto L9
    }

    private boolean q(t r2) {
        if (r2.c().g() == true) goto L7;
        return false;
    L7:
        return this.f16267c.b(r2);
    }

    @Override // d.c.i.p.k0
    public void b(k<d.c.i.l.e> r4, l0 r5) {
        r5.f().b(r5.getId(), "NetworkFetchProducer");
        t r6 = this.f16267c.e(r4, r5);
        this.f16267c.d(r6, new a(this, r6));
    }

    protected void i(d.c.c.g.k r4, t r5) {
        Map<String, String> r3 = g(r5, r4.size());
        n0 r0 = r5.g();
        r0.i(r5.e(), "NetworkFetchProducer", r3);
        r0.e(r5.e(), "NetworkFetchProducer", true);
        m(r4, r5.h() | 1, r5.i(), r5.b(), r5.d());
    }

    protected void j(d.c.c.g.k r8, t r9) {
        long r0 = SystemClock.uptimeMillis();
        d.c.i.q.b r2 = r9.c().c();
        if (q(r9) == true) goto L5;
        return;
    L5:
        if ((r0 - r9.f()) < h(r2)) goto L9;
        r9.m(r0);
        r9.g().h(r9.e(), "NetworkFetchProducer", "intermediate_result");
        m(r8, r9.h(), r9.i(), r9.b(), r9.d());
        return;
    }

    protected boolean l(t r1) {
        if ("http".equals(r1.j().getScheme()) == false) goto L6;
        return true;
    L6:
        return false;
    }

    protected void p(t r9, InputStream r10, int r11) {
        boolean r0 = k(r9);
        if (l(r9) == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        MessageDigest r3 = null;
        if (r1 == true) goto L42;
        if (r0 == true) goto L42;
    L12:
        d.c.c.g.i r4 = this.f16265a;
        if (r11 <= 0) goto L15;
        d.c.c.g.k r5 = r4.f(r11);
    L16:
        byte[] r6 = this.f16266b.get(16384);
    L40:
        int r7 = r10.read(r6);     // Catch: Throwable -> L36
        if (r7 < 0) goto L24;
        if (r7 <= 0) goto L40;
        r5.write(r6, 0, r7);     // Catch: Throwable -> L36
        if (r3 == null) goto L23;
        r3.update(r6, 0, r7);     // Catch: Throwable -> L36
    L23:
        j(r5, r9);     // Catch: Throwable -> L36
        r9.b().c(f(r5.size(), r11));     // Catch: Throwable -> L36
        goto L40
    L24:
        if (r3 == null) goto L33;
        String r12 = e(r3.digest());     // Catch: Throwable -> L36
        if (r1 == false) goto L28;
        r9.n(r12);     // Catch: Throwable -> L36
    L28:
        if (r0 == false) goto L33;
        String r13 = r9.c().c().v().toString();     // Catch: Throwable -> L36
        Map<String, String> r2 = r9.d();     // Catch: Throwable -> L36
        if (r2 != null) goto L32;
        r2 = new HashMap();     // Catch: Throwable -> L36
    L32:
        r2.put(r13, r12);     // Catch: Throwable -> L36
        r9.l(r2);     // Catch: Throwable -> L36
    L33:
        this.f16267c.a(r9, r5.size());     // Catch: Throwable -> L36
        i(r5, r9);     // Catch: Throwable -> L36
        this.f16266b.release(r6);
        r5.close();
        return;
    L36:
        th = move-exception;
        this.f16266b.release(r6);
        r5.close();
        throw th;
    L15:
        r5 = r4.a();
    L42:
        r3 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L39
        goto L12
    L5:
        if (r9.k() == false) goto L7;
        r1 = true;
        goto L8
    }
}
