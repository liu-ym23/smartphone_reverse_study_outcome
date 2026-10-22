package kotlin.s0.w.d.l0.e.a.l0;

import java.util.Collection;
import java.util.List;
import kotlin.i0.r;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.s0.w.d.l0.c.l0;
import kotlin.s0.w.d.l0.c.p0;
import kotlin.s0.w.d.l0.e.a.n0.u;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f19369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.a<kotlin.s0.w.d.l0.g.c, kotlin.s0.w.d.l0.e.a.l0.l.h> f19370b;

    static final class a extends q implements kotlin.n0.c.a<kotlin.s0.w.d.l0.e.a.l0.l.h> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ f f19371f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ u f19372g;

        a(f r1, u r2) {
            this.f19371f = r1;
            this.f19372g = r2;
            super(0);
        }

        public final kotlin.s0.w.d.l0.e.a.l0.l.h a() {
            return new kotlin.s0.w.d.l0.e.a.l0.l.h(f.d(this.f19371f), this.f19372g);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.e.a.l0.l.h invoke() {
            return a();
        }
    }

    public f(b r4) {
        o.f(r4, "components");
        g r0 = new g(r4, k.a.f19385a, kotlin.i.c(null));
        this.f19369a = r0;
        this.f19370b = r0.e().b();
    }

    public static final /* synthetic */ g d(f r0) {
        return r0.f19369a;
    }

    private final kotlin.s0.w.d.l0.e.a.l0.l.h e(kotlin.s0.w.d.l0.g.c r5) {
        u r0 = kotlin.s0.w.d.l0.e.a.o.a.a(this.f19369a.a().d(), r5, false, 2, null);
        if (r0 != null) goto L6;
        return null;
    L6:
        return this.f19370b.a(r5, new a(this, r0));
    }

    @Override // kotlin.s0.w.d.l0.c.m0
    public List<kotlin.s0.w.d.l0.e.a.l0.l.h> a(kotlin.s0.w.d.l0.g.c r2) {
        o.f(r2, "fqName");
        return r.k(e(r2));
    }

    @Override // kotlin.s0.w.d.l0.c.p0
    public void b(kotlin.s0.w.d.l0.g.c r2, Collection<l0> r3) {
        o.f(r2, "fqName");
        o.f(r3, "packageFragments");
        kotlin.s0.w.d.l0.p.a.a(r3, e(r2));
    }

    @Override // kotlin.s0.w.d.l0.c.p0
    public boolean c(kotlin.s0.w.d.l0.g.c r4) {
        o.f(r4, "fqName");
        if (kotlin.s0.w.d.l0.e.a.o.a.a(this.f19369a.a().d(), r4, false, 2, null) != null) goto L6;
        return true;
    L6:
        return false;
    }

    public List<kotlin.s0.w.d.l0.g.c> f(kotlin.s0.w.d.l0.g.c r2, l<? super kotlin.s0.w.d.l0.g.f, Boolean> r3) {
        o.f(r2, "fqName");
        o.f(r3, "nameFilter");
        kotlin.s0.w.d.l0.e.a.l0.l.h r1 = e(r2);
        if (r1 == null) goto L5;
        List<kotlin.s0.w.d.l0.g.c> r4 = r1.P0();
    L6:
        if (r4 == null) goto L8;
        return r4;
    L8:
        return r.g();
    L5:
        r4 = null;
        goto L6
    }

    @Override // kotlin.s0.w.d.l0.c.m0
    public /* bridge */ /* synthetic */ Collection p(kotlin.s0.w.d.l0.g.c r1, l r2) {
        return f(r1, r2);
    }

    public String toString() {
        return "LazyJavaPackageFragmentProvider of module " + this.f19369a.a().m();
    }
}
