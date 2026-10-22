package d.c.i.g;

import d.c.i.e.q;
import d.c.i.p.k0;
import d.c.i.p.t0;
import d.c.i.p.z0;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final CancellationException f16035i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f16036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.c.i.m.d f16037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.c.c.d.l<Boolean> f16038c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final q<d.c.b.a.d, d.c.i.l.c> f16039d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.c.i.e.f f16040e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d.c.c.d.l<Boolean> f16041f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AtomicLong f16042g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final d.c.c.d.l<Boolean> f16043h;

    class a implements d.c.c.d.l<d.c.d.c<d.c.c.h.a<d.c.i.l.c>>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.c.i.q.b f16044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f16045b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.c.i.q.b.EnumC0435b f16046c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ g f16047d;

        a(g r1, d.c.i.q.b r2, Object r3, d.c.i.q.b.EnumC0435b r4) {
            this.f16047d = r1;
            this.f16044a = r2;
            this.f16045b = r3;
            this.f16046c = r4;
        }

        public d.c.d.c<d.c.c.h.a<d.c.i.l.c>> a() {
            return this.f16047d.b(this.f16044a, this.f16045b, this.f16046c);
        }

        @Override // d.c.c.d.l
        public /* bridge */ /* synthetic */ d.c.d.c<d.c.c.h.a<d.c.i.l.c>> get() {
            return a();
        }

        public String toString() {
            d.c.c.d.h.b r0 = d.c.c.d.h.d(this);
            r0.b("uri", this.f16044a.v());
            return r0.toString();
        }
    }

    static {
        f16035i = new CancellationException("Prefetching is not enabled");
    }

    public g(m r1, Set<d.c.i.m.d> r2, d.c.c.d.l<Boolean> r3, q<d.c.b.a.d, d.c.i.l.c> r4, q<d.c.b.a.d, d.c.c.g.h> r5, d.c.i.e.e r6, d.c.i.e.e r7, HashMap<String, d.c.i.e.e> r8, d.c.i.e.f r9, z0 r10, d.c.c.d.l<Boolean> r11, d.c.c.d.l<Boolean> r12) {
        this.f16042g = new AtomicLong();
        this.f16036a = r1;
        this.f16037b = new d.c.i.m.c(r2);
        this.f16038c = r3;
        this.f16039d = r4;
        this.f16040e = r9;
        this.f16041f = r11;
        this.f16043h = r12;
    }

    private String e() {
        return String.valueOf(this.f16042g.getAndIncrement());
    }

    private d.c.i.f.e i(d.c.i.q.b r1) {
        if (r1 == null) goto L5;
        return r1.m();
    L5:
        return d.c.i.f.e.f16017h;
    }

    private <T> d.c.d.c<d.c.c.h.a<T>> m(k0<d.c.c.h.a<T>> r12, d.c.i.q.b r13, d.c.i.q.b.EnumC0435b r14, Object r15, d.c.i.m.d r16, d.c.i.f.e r17) {
        if (d.c.i.r.b.d() == false) goto L5;
        d.c.i.r.b.a("ImagePipeline#submitFetchRequest");
    L5:
        d.c.i.m.d r9 = j(r13, r16);
        d.c.i.q.b.EnumC0435b r5 = d.c.i.q.b.EnumC0435b.a(r13.i(), r14);     // Catch: Throwable -> L20 Exception -> L22
        String r2 = e();     // Catch: Throwable -> L20 Exception -> L22
        if (r13.o() == false) goto L9;
    L14:
        boolean r0 = true;
    L15:
        d.c.d.c<d.c.c.h.a<T>> r1 = d.c.i.h.c.B(r12, new t0(r13, r2, r9, r15, r5, false, r0, r17), r9);     // Catch: Throwable -> L20 Exception -> L22
    L17:
        if (d.c.i.r.b.d() == false) goto L19;
        d.c.i.r.b.b();
    L19:
        return r1;
    L9:
        if (r13.n() == true) goto L14;
        if (d.c.c.k.f.k(r13.v()) == false) goto L14;
        r0 = false;
    L20:
        th = move-exception;
        if (d.c.i.r.b.d() == false) goto L31;
        d.c.i.r.b.b();
    L31:
        throw th;
    L22:
        e = move-exception;
        d.c.d.c<d.c.c.h.a<T>> r3 = d.c.d.d.b(e);     // Catch: Throwable -> L20
        if (d.c.i.r.b.d() == false) goto L27;
        d.c.i.r.b.b();
    L27:
        return r3;
    }

    private d.c.d.c<Void> n(k0<Void> r11, d.c.i.q.b r12, d.c.i.q.b.EnumC0435b r13, Object r14, d.c.i.f.e r15) {
        d.c.i.m.d r0 = j(r12, null);
        d.c.i.q.b.EnumC0435b r6 = d.c.i.q.b.EnumC0435b.a(r12.i(), r13);     // Catch: Exception -> L5
        return d.c.i.h.d.A(r11, new t0(r12, e(), r0, r14, r6, true, false, d.c.i.f.e.c(r15, d.c.i.f.e.f16016g)), r0);
    L5:
        e = move-exception;
        return d.c.d.d.b(e);
    }

    public d.c.d.c<d.c.c.h.a<d.c.i.l.c>> a(d.c.i.q.b r2, Object r3) {
        return b(r2, r3, d.c.i.q.b.EnumC0435b.f16507g);
    }

    public d.c.d.c<d.c.c.h.a<d.c.i.l.c>> b(d.c.i.q.b r2, Object r3, d.c.i.q.b.EnumC0435b r4) {
        return c(r2, r3, r4, null);
    }

    public d.c.d.c<d.c.c.h.a<d.c.i.l.c>> c(d.c.i.q.b r7, Object r8, d.c.i.q.b.EnumC0435b r9, d.c.i.m.d r10) {
        return d(r7, r8, r9, r10, i(r7));
    }

    public d.c.d.c<d.c.c.h.a<d.c.i.l.c>> d(d.c.i.q.b r9, Object r10, d.c.i.q.b.EnumC0435b r11, d.c.i.m.d r12, d.c.i.f.e r13) {
        return m(this.f16036a.g(r9), r9, r11, r10, r12, r13);
    L4:
        e = move-exception;
        return d.c.d.d.b(e);
    }

    public q<d.c.b.a.d, d.c.i.l.c> f() {
        return this.f16039d;
    }

    public d.c.i.e.f g() {
        return this.f16040e;
    }

    public d.c.c.d.l<d.c.d.c<d.c.c.h.a<d.c.i.l.c>>> h(d.c.i.q.b r2, Object r3, d.c.i.q.b.EnumC0435b r4) {
        return new a(this, r2, r3, r4);
    }

    public d.c.i.m.d j(d.c.i.q.b r6, d.c.i.m.d r7) {
        if (r7 != null) goto L11;
        if (r6.q() != null) goto L9;
        return this.f16037b;
    L9:
        return new d.c.i.m.c(new d.c.i.m.d[]{this.f16037b, r6.q()});
    L11:
        if (r6.q() != null) goto L15;
        return new d.c.i.m.c(new d.c.i.m.d[]{this.f16037b, r7});
    L15:
        return new d.c.i.m.c(new d.c.i.m.d[]{this.f16037b, r7, r6.q()});
    }

    public d.c.d.c<Void> k(d.c.i.q.b r2, Object r3) {
        return l(r2, r3, i(r2));
    }

    public d.c.d.c<Void> l(d.c.i.q.b r8, Object r9, d.c.i.f.e r10) {
        if (this.f16038c.get().booleanValue() == false) goto L5;
        return n(this.f16036a.i(r8), r8, d.c.i.q.b.EnumC0435b.f16507g, r9, r10);
    L8:
        e = move-exception;
        return d.c.d.d.b(e);
    L5:
        return d.c.d.d.b(f16035i);
    }
}
