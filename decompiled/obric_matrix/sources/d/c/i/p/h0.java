package d.c.i.p;

import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class h0 implements k0<d.c.i.l.e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.c.i.e.e f16277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.c.i.e.f f16278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.c.c.g.i f16279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.c.c.g.a f16280d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final k0<d.c.i.l.e> f16281e;

    class a implements c.d<d.c.i.l.e, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ n0 f16282a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16283b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f16284c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ l0 f16285d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ d.c.b.a.d f16286e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ h0 f16287f;

        a(h0 r1, n0 r2, String r3, k r4, l0 r5, d.c.b.a.d r6) {
            this.f16287f = r1;
            this.f16282a = r2;
            this.f16283b = r3;
            this.f16284c = r4;
            this.f16285d = r5;
            this.f16286e = r6;
        }

        @Override // c.d
        public /* bridge */ /* synthetic */ Void a(c.f<d.c.i.l.e> r1) {
            return b(r1);
        }

        public Void b(c.f<d.c.i.l.e> r8) {
            if (h0.c(r8) == false) goto L6;
            this.f16282a.d(this.f16283b, "PartialDiskCacheProducer", null);
            this.f16284c.b();
        L15:
            return null;
        L6:
            if (r8.n() == false) goto L8;
            this.f16282a.j(this.f16283b, "PartialDiskCacheProducer", r8.i(), null);
            h0.d(this.f16287f, this.f16284c, this.f16285d, this.f16286e, null);
            goto L15
        L8:
            d.c.i.l.e r9 = r8.j();
            n0 r0 = this.f16282a;
            String r3 = this.f16283b;
            if (r9 == null) goto L14;
            r0.i(r3, "PartialDiskCacheProducer", h0.f(r0, r3, true, r9.X()));
            d.c.i.f.a r1 = d.c.i.f.a.c(r9.X() - 1);
            r9.y0(r1);
            int r4 = r9.X();
            d.c.i.q.b r5 = this.f16285d.c();
            if (r1.a(r5.c()) == false) goto L13;
            this.f16282a.e(this.f16283b, "PartialDiskCacheProducer", true);
            this.f16284c.d(r9, 9);
            goto L15
        L13:
            this.f16284c.d(r9, 8);
            d.c.i.q.c r2 = d.c.i.q.c.b(r5);
            r2.z(d.c.i.f.a.b(r4 - 1));
            t0 r6 = new t0(r2.a(), this.f16285d);
            h0.d(this.f16287f, this.f16284c, r6, this.f16286e, r9);
            goto L15
        L14:
            r0.i(r3, "PartialDiskCacheProducer", h0.f(r0, r3, false, 0));
            h0.d(this.f16287f, this.f16284c, this.f16285d, this.f16286e, r9);
            goto L15
        }
    }

    class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f16288a;

        b(h0 r1, AtomicBoolean r2) {
            this.f16288a = r2;
        }

        @Override // d.c.i.p.m0
        public void a() {
            this.f16288a.set(true);
        }
    }

    private static class c extends n<d.c.i.l.e, d.c.i.l.e> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final d.c.i.e.e f16289c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final d.c.b.a.d f16290d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final d.c.c.g.i f16291e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final d.c.c.g.a f16292f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final d.c.i.l.e f16293g;

        private c(k<d.c.i.l.e> r1, d.c.i.e.e r2, d.c.b.a.d r3, d.c.c.g.i r4, d.c.c.g.a r5, d.c.i.l.e r6) {
            super(r1);
            this.f16289c = r2;
            this.f16290d = r3;
            this.f16291e = r4;
            this.f16292f = r5;
            this.f16293g = r6;
        }

        /* synthetic */ c(k r1, d.c.i.e.e r2, d.c.b.a.d r3, d.c.c.g.i r4, d.c.c.g.a r5, d.c.i.l.e r6, a r7) {
            this(r1, r2, r3, r4, r5, r6);
        }

        private void q(InputStream r6, OutputStream r7, int r8) {
            byte[] r0 = this.f16292f.get(16384);
            int r2 = r8;
        L4:
            if (r2 <= 0) goto L13;
            int r4 = r6.read(r0, 0, Math.min(16384, r2));     // Catch: Throwable -> L10
            if (r4 < 0) goto L13;
            if (r4 <= 0) goto L4;
            r7.write(r0, 0, r4);     // Catch: Throwable -> L10
            r2 = r2 - r4;
        L10:
            th = move-exception;
            this.f16292f.release(r0);
            throw th;
        L13:
            this.f16292f.release(r0);
            if (r2 > 0) goto L17;
            return;
        L17:
            throw new IOException(String.format(null, "Failed to read %d bytes - finished %d short", new Object[]{Integer.valueOf(r8), Integer.valueOf(r2)}));
        }

        private d.c.c.g.k r(d.c.i.l.e r3, d.c.i.l.e r4) {
            int r0 = r4.X() + r4.x().f15987a;
            d.c.c.g.k r1 = this.f16291e.f(r0);
            int r2 = r4.x().f15987a;
            q(r3.O(), r1, r2);
            q(r4.O(), r1, r4.X());
            return r1;
        }

        private void t(d.c.c.g.k r3) {
            d.c.c.h.a r4 = d.c.c.h.a.V(r3.a());
            d.c.i.l.e r0 = null;
            d.c.i.l.e r1 = new d.c.i.l.e(r4);     // Catch: Throwable -> L9
            r1.r0();     // Catch: Throwable -> L7
            p().d(r1, 1);     // Catch: Throwable -> L7
            d.c.i.l.e.g(r1);
            d.c.c.h.a.L(r4);
            return;
        L7:
            th = th;
            r0 = r1;
        L10:
            d.c.i.l.e.g(r0);
            d.c.c.h.a.L(r4);
            throw th;
        L9:
            th = th;
            goto L10
        }

        @Override // d.c.i.p.b
        public /* bridge */ /* synthetic */ void i(Object r1, int r2) {
            s((d.c.i.l.e) r1, r2);
        }

        public void s(d.c.i.l.e r3, int r4) {
            if (d.c.i.p.b.f(r4) == false) goto L6;
            return;
        L6:
            if (this.f16293g == null) goto L20;
            if (r3.x() == null) goto L20;
            t(r(this.f16293g, r3));     // Catch: Throwable -> L11 IOException -> L13
        L10:
            r3.close();
            r3 = this.f16293g;
            r3.close();
            this.f16289c.s(this.f16290d);
            return;
        L13:
            e = move-exception;
            d.c.c.e.a.k("PartialDiskCacheProducer", "Error while merging image data", e);     // Catch: Throwable -> L11
            p().a(e);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            r3.close();
            this.f16293g.close();
            throw th;
        L20:
            if (d.c.i.p.b.n(r4, 8) == true) goto L22;
        L26:
            p().d(r3, r4);
            return;
        L22:
            if (d.c.i.p.b.e(r4) == false) goto L26;
            if (r3.N() == d.c.h.d.f15831b) goto L26;
            this.f16289c.p(this.f16290d, r3);
            goto L26
        }
    }

    public h0(d.c.i.e.e r1, d.c.i.e.f r2, d.c.c.g.i r3, d.c.c.g.a r4, k0<d.c.i.l.e> r5) {
        this.f16277a = r1;
        this.f16278b = r2;
        this.f16279c = r3;
        this.f16280d = r4;
        this.f16281e = r5;
    }

    static /* synthetic */ boolean c(c.f r0) {
        return g(r0);
    }

    static /* synthetic */ void d(h0 r0, k r1, l0 r2, d.c.b.a.d r3, d.c.i.l.e r4) {
        r0.i(r1, r2, r3, r4);
    }

    private static Uri e(d.c.i.q.b r2) {
        return r2.v().buildUpon().appendQueryParameter("fresco_partial", "true").build();
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

    private static boolean g(c.f<?> r1) {
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

    private c.d<d.c.i.l.e, Void> h(k<d.c.i.l.e> r9, l0 r10, d.c.b.a.d r11) {
        String r3 = r10.getId();
        return new a(this, r10.f(), r3, r9, r10, r11);
    }

    private void i(k<d.c.i.l.e> r10, l0 r11, d.c.b.a.d r12, d.c.i.l.e r13) {
        c r8 = new c(r10, this.f16277a, r12, this.f16279c, this.f16280d, r13, null);
        this.f16281e.b(r8, r11);
    }

    private void j(AtomicBoolean r2, l0 r3) {
        r3.d(new b(this, r2));
    }

    @Override // d.c.i.p.k0
    public void b(k<d.c.i.l.e> r5, l0 r6) {
        d.c.i.q.b r0 = r6.c();
        if (r0.y() == true) goto L6;
        this.f16281e.b(r5, r6);
        return;
    L6:
        r6.f().b(r6.getId(), "PartialDiskCacheProducer");
        Uri r1 = e(r0);
        d.c.b.a.d r2 = this.f16278b.c(r0, r1, r6.a());
        AtomicBoolean r3 = new AtomicBoolean(false);
        this.f16277a.m(r2, r3).e(h(r5, r6, r2));
        j(r3, r6);
    }
}
