package d.c.i.p;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class h implements k0<d.c.c.h.a<d.c.i.l.c>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.c.i.e.q<d.c.b.a.d, d.c.i.l.c> f16271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.c.i.e.f f16272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final k0<d.c.c.h.a<d.c.i.l.c>> f16273c;

    class a extends n<d.c.c.h.a<d.c.i.l.c>, d.c.c.h.a<d.c.i.l.c>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.c.b.a.d f16274c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f16275d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ h f16276e;

        a(h r1, k r2, d.c.b.a.d r3, boolean r4) {
            this.f16276e = r1;
            this.f16274c = r3;
            this.f16275d = r4;
            super(r2);
        }

        @Override // d.c.i.p.b
        public /* bridge */ /* synthetic */ void i(Object r1, int r2) {
            q((d.c.c.h.a) r1, r2);
        }

        public void q(d.c.c.h.a<d.c.i.l.c> r7, int r8) {
        L59:
            th = move-exception;
            if (d.c.i.r.b.d() == false) goto L63;
            d.c.i.r.b.b();
        L63:
            throw th;
        L3:
            if (d.c.i.r.b.d() == false) goto L5;
            d.c.i.r.b.a("BitmapMemoryCacheProducer#onNewResultImpl");     // Catch: Throwable -> L59
        L5:
            boolean r0 = b.e(r8);     // Catch: Throwable -> L59
            d.c.c.h.a<d.c.i.l.c> r1 = null;
            if (r7 != null) goto L14;
            if (r0 == false) goto L10;
            p().d(null, r8);     // Catch: Throwable -> L59
        L10:
            if (d.c.i.r.b.d() == false) goto L69;
            d.c.i.r.b.b();
            return;
        L69:
            return;
        L14:
            if (r7.N().A() == false) goto L16;
        L54:
            p().d(r7, r8);     // Catch: Throwable -> L59
            if (d.c.i.r.b.d() == false) goto L72;
            d.c.i.r.b.b();
            return;
        L72:
            return;
        L16:
            if (b.n(r8, 8) == true) goto L54;
            if (r0 == true) goto L38;
            d.c.c.h.a<d.c.i.l.c> r2 = h.c(this.f16276e).get(this.f16274c);     // Catch: Throwable -> L59
            if (r2 == null) goto L38;
            d.c.i.l.i r3 = r7.N().s();     // Catch: Throwable -> L34
            d.c.i.l.i r4 = r2.N().s();     // Catch: Throwable -> L34
            if (r4.a() == false) goto L24;
        L28:
            p().d(r2, r8);     // Catch: Throwable -> L34
            d.c.c.h.a.L(r2);     // Catch: Throwable -> L59
            if (d.c.i.r.b.d() == false) goto L70;
            d.c.i.r.b.b();
            return;
        L70:
            return;
        L24:
            if (r4.c() >= r3.c()) goto L28;
            d.c.c.h.a.L(r2);     // Catch: Throwable -> L59
        L34:
            th = move-exception;
            d.c.c.h.a.L(r2);     // Catch: Throwable -> L59
            throw th;     // Catch: Throwable -> L59
        L38:
            if (this.f16275d == false) goto L40;
            r1 = h.c(this.f16276e).b(this.f16274c, r7);     // Catch: Throwable -> L59
        L40:
            if (r0 == true) goto L67;
        L42:
            k<d.c.c.h.a<d.c.i.l.c>> r6 = p();     // Catch: Throwable -> L51
            if (r1 == null) goto L45;
            r7 = r1;
        L45:
            r6.d(r7, r8);     // Catch: Throwable -> L51
            d.c.c.h.a.L(r1);     // Catch: Throwable -> L59
            if (d.c.i.r.b.d() == false) goto L71;
            d.c.i.r.b.b();
            return;
        L71:
            return;
        L51:
            th = move-exception;
            d.c.c.h.a.L(r1);     // Catch: Throwable -> L59
            throw th;     // Catch: Throwable -> L59
        L67:
            p().c(1.0f);     // Catch: Throwable -> L51
            goto L42
        }
    }

    public h(d.c.i.e.q<d.c.b.a.d, d.c.i.l.c> r1, d.c.i.e.f r2, k0<d.c.c.h.a<d.c.i.l.c>> r3) {
        this.f16271a = r1;
        this.f16272b = r2;
        this.f16273c = r3;
    }

    static /* synthetic */ d.c.i.e.q c(h r0) {
        return r0.f16271a;
    }

    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7, types: [boolean, int] */
    @Override // d.c.i.p.k0
    public void b(k<d.c.c.h.a<d.c.i.l.c>> r12, l0 r13) {
    L51:
        th = move-exception;
        if (d.c.i.r.b.d() == false) goto L55;
        d.c.i.r.b.b();
    L55:
        throw th;
    L3:
        if (d.c.i.r.b.d() == false) goto L5;
        d.c.i.r.b.a("BitmapMemoryCacheProducer#produceResults");     // Catch: Throwable -> L51
    L5:
        n0 r0 = r13.f();     // Catch: Throwable -> L51
        String r1 = r13.getId();     // Catch: Throwable -> L51
        r0.b(r1, d());     // Catch: Throwable -> L51
        d.c.b.a.d r2 = this.f16272b.a(r13.c(), r13.a());     // Catch: Throwable -> L51
        d.c.c.h.a<d.c.i.l.c> r3 = this.f16271a.get(r2);     // Catch: Throwable -> L51
        Map<String, String> r7 = null;
        if (r3 == null) goto L28;
        if (r3.N().s().a() == true) goto L11;
    L13:
        ?? r8 = 0;
    L14:
        if (r8 == 0) goto L20;
        String r9 = d();     // Catch: Throwable -> L51
        if (r0.f(r1) == false) goto L18;
        Map<String, String> r10 = d.c.c.d.f.of("cached_value_found", "true");     // Catch: Throwable -> L51
    L19:
        r0.i(r1, r9, r10);     // Catch: Throwable -> L51
        r0.e(r1, d(), true);     // Catch: Throwable -> L51
        r12.c(1.0f);     // Catch: Throwable -> L51
        goto L20
    L18:
        r10 = null;
    L20:
        b.l(r8);     // Catch: Throwable -> L51
        r12.d(r3, r8);     // Catch: Throwable -> L51
        r3.close();     // Catch: Throwable -> L51
        if (r8 == 0) goto L28;
        if (d.c.i.r.b.d() == false) goto L57;
        d.c.i.r.b.b();
        return;
    L57:
        return;
    L11:
        if (r3.N().C() == true) goto L13;
        r8 = 1;
    L28:
        if (r13.h().b() < d.c.i.q.b.EnumC0435b.f16510j.b()) goto L38;
        String r14 = d();     // Catch: Throwable -> L51
        if (r0.f(r1) == false) goto L32;
        Map<String, String> r4 = d.c.c.d.f.of("cached_value_found", "false");     // Catch: Throwable -> L51
    L33:
        r0.i(r1, r14, r4);     // Catch: Throwable -> L51
        r0.e(r1, d(), false);     // Catch: Throwable -> L51
        r12.d(null, 1);     // Catch: Throwable -> L51
        if (d.c.i.r.b.d() == false) goto L58;
        d.c.i.r.b.b();
        return;
    L58:
        return;
    L32:
        r4 = null;
        goto L33
    L38:
        k<d.c.c.h.a<d.c.i.l.c>> r15 = e(r12, r2, r13.c().z());     // Catch: Throwable -> L51
        String r5 = d();     // Catch: Throwable -> L51
        if (r0.f(r1) == false) goto L41;
        r7 = d.c.c.d.f.of("cached_value_found", "false");     // Catch: Throwable -> L51
    L41:
        r0.i(r1, r5, r7);     // Catch: Throwable -> L51
        if (d.c.i.r.b.d() == false) goto L44;
        d.c.i.r.b.a("mInputProducer.produceResult");     // Catch: Throwable -> L51
    L44:
        this.f16273c.b(r15, r13);     // Catch: Throwable -> L51
        if (d.c.i.r.b.d() == false) goto L48;
        d.c.i.r.b.b();     // Catch: Throwable -> L51
    L48:
        if (d.c.i.r.b.d() == false) goto L59;
        d.c.i.r.b.b();
        return;
    }

    protected String d() {
        return "BitmapMemoryCacheProducer";
    }

    protected k<d.c.c.h.a<d.c.i.l.c>> e(k<d.c.c.h.a<d.c.i.l.c>> r2, d.c.b.a.d r3, boolean r4) {
        return new a(this, r2, r3, r4);
    }
}
