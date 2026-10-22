package d.c.i.p;

import java.io.InputStream;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a0 implements k0<d.c.i.l.e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f16207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.c.c.g.i f16208b;

    class a extends w0<d.c.i.l.e> {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ d.c.i.q.b f16209k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ n0 f16210l;
        final /* synthetic */ String m;
        final /* synthetic */ a0 n;

        a(a0 r1, k r2, n0 r3, String r4, String r5, d.c.i.q.b r6, n0 r7, String r8) {
            this.n = r1;
            this.f16209k = r6;
            this.f16210l = r7;
            this.m = r8;
            super(r2, r3, r4, r5);
        }

        @Override // d.c.c.b.g
        protected /* bridge */ /* synthetic */ void c(Object r1) {
            k((d.c.i.l.e) r1);
        }

        @Override // d.c.c.b.g
        protected /* bridge */ /* synthetic */ Object d() {
            return l();
        }

        protected void k(d.c.i.l.e r1) {
            d.c.i.l.e.g(r1);
        }

        protected d.c.i.l.e l() {
            d.c.i.l.e r0 = this.n.d(this.f16209k);
            if (r0 != null) goto L6;
            this.f16210l.e(this.m, this.n.f(), false);
            return null;
        L6:
            r0.r0();
            this.f16210l.e(this.m, this.n.f(), true);
            return r0;
        }
    }

    class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ w0 f16211a;

        b(a0 r1, w0 r2) {
            this.f16211a = r2;
        }

        @Override // d.c.i.p.m0
        public void a() {
            this.f16211a.b();
        }
    }

    protected a0(Executor r1, d.c.c.g.i r2) {
        this.f16207a = r1;
        this.f16208b = r2;
    }

    @Override // d.c.i.p.k0
    public void b(k<d.c.i.l.e> r11, l0 r12) {
        n0 r7 = r12.f();
        String r8 = r12.getId();
        d.c.i.q.b r6 = r12.c();
        a r9 = new a(this, r11, r7, f(), r8, r6, r7, r8);
        r12.d(new b(this, r9));
        this.f16207a.execute(r9);
    }

    protected d.c.i.l.e c(InputStream r2, int r3) {
        d.c.c.h.a r0 = null;
        if (r3 > 0) goto L5;
        d.c.c.g.h r1 = this.f16208b.d(r2);     // Catch: Throwable -> L9
    L6:
        r0 = d.c.c.h.a.V(r1);     // Catch: Throwable -> L9
        d.c.i.l.e r4 = new d.c.i.l.e(r0);     // Catch: Throwable -> L9
        d.c.c.d.b.b(r2);
        d.c.c.h.a.L(r0);
        return r4;
    L5:
        r1 = this.f16208b.e(r2, r3);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        d.c.c.d.b.b(r2);
        d.c.c.h.a.L(r0);
        throw th;
    }

    protected abstract d.c.i.l.e d(d.c.i.q.b r1);

    protected d.c.i.l.e e(InputStream r1, int r2) {
        return c(r1, r2);
    }

    protected abstract String f();
}
