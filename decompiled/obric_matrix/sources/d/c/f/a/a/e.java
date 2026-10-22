package d.c.f.a.a;

import android.content.Context;
import android.net.Uri;
import d.c.c.d.l;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class e extends d.c.f.c.b<e, d.c.i.q.b, d.c.c.h.a<d.c.i.l.c>, d.c.i.l.f> {
    private final d.c.i.g.g u;
    private final g v;
    private d.c.c.d.e<d.c.i.j.a> w;
    private d.c.f.a.a.i.b x;
    private d.c.f.a.a.i.f y;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f15495a = null;

        static {
            int[] r0 = new int[d.c.f.c.b.c.values().length];
            f15495a = r0;
            r0[d.c.f.c.b.c.f15594f.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f15495a[d.c.f.c.b.c.f15595g.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f15495a[d.c.f.c.b.c.f15596h.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public e(Context r1, g r2, d.c.i.g.g r3, Set<d.c.f.c.d> r4) {
        super(r1, r4);
        this.u = r3;
        this.v = r2;
        C(r2.a());
    }

    public static d.c.i.q.b.EnumC0435b I(d.c.f.c.b.c r3) {
        int r0 = a.f15495a[r3.ordinal()];
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L13;
        if (r0 != 3) goto L11;
        return d.c.i.q.b.EnumC0435b.f16510j;
    L11:
        throw new RuntimeException("Cache level" + r3 + "is not supported. ");
    L13:
        return d.c.i.q.b.EnumC0435b.f16508h;
    L15:
        return d.c.i.q.b.EnumC0435b.f16507g;
    }

    private d.c.b.a.d J() {
        d.c.i.q.b r0 = m();
        d.c.i.e.f r1 = this.u.g();
        if (r1 == null) goto L9;
        if (r0 == null) goto L9;
        d.c.i.q.d r2 = r0.j();
        Object r3 = f();
        if (r2 == null) goto L12;
        return r1.d(r0, r3);
    L12:
        return r1.a(r0, r3);
    L9:
        return null;
    }

    protected d.c.d.c<d.c.c.h.a<d.c.i.l.c>> K(d.c.f.h.a r7, String r8, d.c.i.q.b r9, Object r10, d.c.f.c.b.c r11) {
        d.c.i.g.g r0 = this.u;
        d.c.i.q.b.EnumC0435b r3 = I(r11);
        d.c.i.m.d r4 = L(r7);
        d.c.i.f.e r6 = d.c.i.f.e.f16017h;
        if (r9 == null) goto L5;
        d.c.i.f.e r12 = r9.m();
    L7:
        return r0.d(r9, r10, r3, r4, d.c.i.f.e.a(r6, r12));
    L5:
        r12 = r6;
        goto L7
    }

    protected d.c.i.m.d L(d.c.f.h.a r1) {
        if ((r1 instanceof d) == true) goto L5;
        return null;
    L5:
        return ((d) r1).c0();
    }

    protected d M() {
        if (d.c.i.r.b.d() == false) goto L19;
        d.c.i.r.b.a("PipelineDraweeControllerBuilder#obtainController");
    L19:
        d.c.f.h.a r0 = n();     // Catch: Throwable -> L14
        String r3 = d.c.f.c.b.e();     // Catch: Throwable -> L14
        if ((r0 instanceof d) == false) goto L8;
        d r1 = (d) r0;     // Catch: Throwable -> L14
    L9:
        r1.R(p());     // Catch: Throwable -> L14
        l<d.c.d.c<d.c.c.h.a<d.c.i.l.c>>> r2 = w(r1, r3);     // Catch: Throwable -> L14
        d.c.b.a.d r4 = J();     // Catch: Throwable -> L14
        Object r5 = f();     // Catch: Throwable -> L14
        d.c.c.d.e<d.c.i.j.a> r6 = this.w;     // Catch: Throwable -> L14
        d.c.f.a.a.i.b r7 = this.x;     // Catch: Throwable -> L14
        d.c.i.q.b r8 = (d.c.i.q.b) m();     // Catch: Throwable -> L14
        r1.e0(r2, r3, r4, r5, r6, r7, r8);     // Catch: Throwable -> L14
        r1.f0(this.y);     // Catch: Throwable -> L14
        if (d.c.i.r.b.d() == false) goto L13;
        d.c.i.r.b.b();
    L13:
        return r1;
    L8:
        r1 = this.v.d();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        if (d.c.i.r.b.d() == false) goto L18;
        d.c.i.r.b.b();
    L18:
        throw th;
    }

    public e N(Uri r2) {
        if (r2 != null) goto L6;
        d.c.i.q.b r3 = null;
    L4:
        super.D(r3);
        return this;
    L6:
        d.c.i.q.c r4 = d.c.i.q.c.x(r2);
        r4.J(d.c.i.f.g.b());
        r3 = r4.a();
        goto L4
    }

    @Override // d.c.f.h.d
    public /* bridge */ /* synthetic */ d.c.f.h.d a(Uri r1) {
        return N(r1);
    }

    @Override // d.c.f.c.b
    protected /* bridge */ /* synthetic */ d.c.d.c<d.c.c.h.a<d.c.i.l.c>> i(d.c.f.h.a r1, String r2, d.c.i.q.b r3, Object r4, d.c.f.c.b.c r5) {
        return K(r1, r2, r3, r4, r5);
    }

    @Override // d.c.f.c.b
    protected /* bridge */ /* synthetic */ d.c.f.c.a v() {
        return M();
    }
}
