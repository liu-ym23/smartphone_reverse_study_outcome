package d.c.i.p;

import java.io.InputStream;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class e1 implements k0<d.c.i.l.e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f16257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.c.c.g.i f16258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final k0<d.c.i.l.e> f16259c;

    class a extends v0<d.c.i.l.e> {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ d.c.i.l.e f16260k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ e1 f16261l;

        a(e1 r7, k r8, n0 r9, String r10, String r11, int r12, d.c.i.l.e r13) {
            this.f16261l = r7;
            this.f16260k = r13;
            super(r8, r9, r10, r11, r12);
        }

        @Override // d.c.c.b.g
        protected /* bridge */ /* synthetic */ void c(Object r1) {
            k((d.c.i.l.e) r1);
        }

        @Override // d.c.c.b.g
        protected /* bridge */ /* synthetic */ Object d() {
            return l();
        }

        @Override // d.c.i.p.w0, d.c.c.b.g
        protected void e() {
            d.c.i.l.e.g(this.f16260k);
            super.e();
        }

        @Override // d.c.i.p.w0, d.c.c.b.g
        protected void f(Exception r2) {
            d.c.i.l.e.g(this.f16260k);
            super.f(r2);
        }

        @Override // d.c.i.p.w0, d.c.c.b.g
        protected /* bridge */ /* synthetic */ void g(Object r1) {
            m((d.c.i.l.e) r1);
        }

        protected void k(d.c.i.l.e r1) {
            d.c.i.l.e.g(r1);
        }

        protected d.c.i.l.e l() {
            d.c.c.g.k r0 = e1.e(this.f16261l).a();
            e1.f(this.f16260k, r0);     // Catch: Throwable -> L11
            d.c.c.h.a r1 = d.c.c.h.a.V(r0.a());     // Catch: Throwable -> L11
            d.c.i.l.e r2 = new d.c.i.l.e(r1);     // Catch: Throwable -> L8
            r2.l(this.f16260k);     // Catch: Throwable -> L8
            d.c.c.h.a.L(r1);     // Catch: Throwable -> L11
            r0.close();
            return r2;
        L8:
            th = move-exception;
            d.c.c.h.a.L(r1);     // Catch: Throwable -> L11
            throw th;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            r0.close();
            throw th;
        }

        protected void m(d.c.i.l.e r2) {
            d.c.i.l.e.g(this.f16260k);
            super.g(r2);
        }
    }

    private class b extends n<d.c.i.l.e, d.c.i.l.e> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final l0 f16262c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private d.c.c.k.e f16263d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ e1 f16264e;

        public b(e1 r1, k<d.c.i.l.e> r2, l0 r3) {
            this.f16264e = r1;
            super(r2);
            this.f16262c = r3;
            this.f16263d = d.c.c.k.e.f15444h;
        }

        @Override // d.c.i.p.b
        protected /* bridge */ /* synthetic */ void i(Object r1, int r2) {
            q((d.c.i.l.e) r1, r2);
        }

        protected void q(d.c.i.l.e r3, int r4) {
            if (this.f16263d != d.c.c.k.e.f15444h) goto L7;
            if (r3 == null) goto L7;
            this.f16263d = e1.c(r3);
        L7:
            if (this.f16263d != d.c.c.k.e.f15443g) goto L11;
            p().d(r3, r4);
            return;
        L11:
            if (d.c.i.p.b.e(r4) == true) goto L13;
            return;
        L13:
            if (this.f16263d != d.c.c.k.e.f15442f) goto L16;
            if (r3 == null) goto L16;
            e1.d(this.f16264e, r3, p(), this.f16262c);
            return;
        L16:
            p().d(r3, r4);
        }
    }

    public e1(Executor r1, d.c.c.g.i r2, k0<d.c.i.l.e> r3) {
        d.c.c.d.i.g(r1);
        this.f16257a = r1;
        d.c.c.d.i.g(r2);
        this.f16258b = r2;
        d.c.c.d.i.g(r3);
        this.f16259c = r3;
    }

    static /* synthetic */ d.c.c.k.e c(d.c.i.l.e r0) {
        return h(r0);
    }

    static /* synthetic */ void d(e1 r0, d.c.i.l.e r1, k r2, l0 r3) {
        r0.i(r1, r2, r3);
    }

    static /* synthetic */ d.c.c.g.i e(e1 r0) {
        return r0.f16258b;
    }

    static /* synthetic */ void f(d.c.i.l.e r0, d.c.c.g.k r1) {
        g(r0, r1);
    }

    private static void g(d.c.i.l.e r3, d.c.c.g.k r4) {
        InputStream r0 = r3.O();
        d.c.h.d r1 = d.c.h.e.c(r0);
        if (r1 != d.c.h.c.f15824f) goto L5;
    L15:
        com.facebook.imagepipeline.nativecode.f.a().a(r0, r4, 80);
        d.c.h.d r5 = d.c.h.c.f15819a;
    L16:
        r3.D0(r5);
        return;
    L5:
        if (r1 == d.c.h.c.f15826h) goto L15;
        if (r1 != d.c.h.c.f15825g) goto L10;
    L14:
        com.facebook.imagepipeline.nativecode.f.a().b(r0, r4);
        r5 = d.c.h.c.f15820b;
        goto L16
    L10:
        if (r1 == d.c.h.c.f15827i) goto L14;
        throw new IllegalArgumentException("Wrong image format");
    }

    private static d.c.c.k.e h(d.c.i.l.e r1) {
        d.c.c.d.i.g(r1);
        d.c.h.d r2 = d.c.h.e.c(r1.O());
        if (d.c.h.c.f(r2) == false) goto L11;
        com.facebook.imagepipeline.nativecode.e r0 = com.facebook.imagepipeline.nativecode.f.a();
        if (r0 != null) goto L9;
        return d.c.c.k.e.f15443g;
    L9:
        return d.c.c.k.e.a(!r0.c(r2));
    L11:
        if (r2 != d.c.h.d.f15831b) goto L15;
        return d.c.c.k.e.f15444h;
    L15:
        return d.c.c.k.e.f15443g;
    }

    private void i(d.c.i.l.e r9, k<d.c.i.l.e> r10, l0 r11) {
        d.c.c.d.i.g(r9);
        d.c.i.l.e r7 = d.c.i.l.e.b(r9);
        a r12 = new a(this, r10, r11.f(), "WebpTranscodeProducer", r11.getId(), d.c.i.f.e.b(r11.b()), r7);
        this.f16257a.execute(r12);
    }

    @Override // d.c.i.p.k0
    public void b(k<d.c.i.l.e> r3, l0 r4) {
        this.f16259c.b(new b(this, r3, r4), r4);
    }
}
