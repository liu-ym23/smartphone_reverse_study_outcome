package d.c.i.p;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class y0<T> implements k0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k0<T> f16477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final z0 f16478b;

    class a extends u0<T> {
        final /* synthetic */ n0 m;
        final /* synthetic */ String n;
        final /* synthetic */ k o;
        final /* synthetic */ l0 p;
        final /* synthetic */ y0 q;

        a(y0 r1, k r2, n0 r3, String r4, String r5, n0 r6, String r7, k r8, l0 r9) {
            this.q = r1;
            this.m = r6;
            this.n = r7;
            this.o = r8;
            this.p = r9;
            super(r2, r3, r4, r5);
        }

        @Override // d.c.c.b.g
        protected void c(T r1) {
        }

        @Override // d.c.c.b.g
        protected T d() {
            return null;
        }

        @Override // d.c.i.p.w0, d.c.c.b.g
        protected void g(T r4) {
            n0 r0 = this.m;
            String r1 = this.n;
            if (r0.f(r1) == false) goto L5;
            Map<String, String> r5 = j(r4);
        L6:
            r0.i(r1, "BackgroundThreadHandoffProducer", r5);
            y0.c(this.q).b(this.o, this.p);
            return;
        L5:
            r5 = null;
            goto L6
        }

        @Override // d.c.i.p.w0
        protected Map<String, String> i(Exception r3) {
            long r2 = m();
            if (r2 > 0) goto L5;
            return null;
        L5:
            return d.c.c.d.f.of("pendingTime", String.valueOf(r2));
        }

        @Override // d.c.i.p.w0
        protected Map<String, String> j(T r3) {
            long r2 = m();
            if (r2 > 0) goto L5;
            return null;
        L5:
            return d.c.c.d.f.of("pendingTime", String.valueOf(r2));
        }
    }

    class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ w0 f16479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ y0 f16480b;

        b(y0 r1, w0 r2) {
            this.f16480b = r1;
            this.f16479a = r2;
        }

        @Override // d.c.i.p.m0
        public void a() {
            this.f16479a.b();
            y0.d(this.f16480b).b(this.f16479a);
        }
    }

    public y0(k0<T> r1, z0 r2) {
        d.c.c.d.i.g(r1);
        this.f16477a = r1;
        this.f16478b = r2;
    }

    static /* synthetic */ k0 c(y0 r0) {
        return r0.f16477a;
    }

    static /* synthetic */ z0 d(y0 r0) {
        return r0.f16478b;
    }

    @Override // d.c.i.p.k0
    public void b(k<T> r12, l0 r13) {
        n0 r6 = r13.f();
        String r7 = r13.getId();
        a r10 = new a(this, r12, r6, "BackgroundThreadHandoffProducer", r7, r6, r7, r12, r13);
        r13.d(new b(this, r10));
        this.f16478b.a(r10);
    }
}
