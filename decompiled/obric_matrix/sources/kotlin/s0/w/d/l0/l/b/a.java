package kotlin.s0.w.d.l0.l.b;

import java.util.Collection;
import java.util.List;
import kotlin.i0.t0;
import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.c.l0;
import kotlin.s0.w.d.l0.c.p0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.n f20684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u f20685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h0 f20686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected k f20687d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.h<kotlin.s0.w.d.l0.g.c, l0> f20688e;

    /* JADX INFO: renamed from: kotlin.s0.w.d.l0.l.b.a$a, reason: collision with other inner class name */
    static final class C0565a extends kotlin.n0.d.q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.g.c, l0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f20689f;

        C0565a(a r1) {
            this.f20689f = r1;
            super(1);
        }

        public final l0 a(kotlin.s0.w.d.l0.g.c r2) {
            kotlin.n0.d.o.f(r2, "fqName");
            p r3 = this.f20689f.d(r2);
            if (r3 == null) goto L5;
            r3.M0(this.f20689f.e());
            return r3;
        L5:
            return null;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ l0 invoke(kotlin.s0.w.d.l0.g.c r1) {
            return a(r1);
        }
    }

    public a(kotlin.s0.w.d.l0.m.n r2, u r3, h0 r4) {
        kotlin.n0.d.o.f(r2, "storageManager");
        kotlin.n0.d.o.f(r3, "finder");
        kotlin.n0.d.o.f(r4, "moduleDescriptor");
        this.f20684a = r2;
        this.f20685b = r3;
        this.f20686c = r4;
        this.f20688e = r2.i(new C0565a(this));
    }

    @Override // kotlin.s0.w.d.l0.c.m0
    public List<l0> a(kotlin.s0.w.d.l0.g.c r2) {
        kotlin.n0.d.o.f(r2, "fqName");
        return kotlin.i0.r.k(this.f20688e.invoke(r2));
    }

    @Override // kotlin.s0.w.d.l0.c.p0
    public void b(kotlin.s0.w.d.l0.g.c r2, Collection<l0> r3) {
        kotlin.n0.d.o.f(r2, "fqName");
        kotlin.n0.d.o.f(r3, "packageFragments");
        kotlin.s0.w.d.l0.p.a.a(r3, this.f20688e.invoke(r2));
    }

    @Override // kotlin.s0.w.d.l0.c.p0
    public boolean c(kotlin.s0.w.d.l0.g.c r2) {
        kotlin.n0.d.o.f(r2, "fqName");
        if (this.f20688e.k(r2) == false) goto L5;
        kotlin.s0.w.d.l0.c.o1.a r1 = (l0) this.f20688e.invoke(r2);
    L6:
        if (r1 != null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r1 = d(r2);
        goto L6
    }

    protected abstract p d(kotlin.s0.w.d.l0.g.c r1);

    protected final k e() {
        k r0 = this.f20687d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        kotlin.n0.d.o.v("components");
        throw null;
    }

    protected final u f() {
        return this.f20685b;
    }

    protected final h0 g() {
        return this.f20686c;
    }

    protected final kotlin.s0.w.d.l0.m.n h() {
        return this.f20684a;
    }

    protected final void i(k r2) {
        kotlin.n0.d.o.f(r2, "<set-?>");
        this.f20687d = r2;
    }

    @Override // kotlin.s0.w.d.l0.c.m0
    public Collection<kotlin.s0.w.d.l0.g.c> p(kotlin.s0.w.d.l0.g.c r1, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r2) {
        kotlin.n0.d.o.f(r1, "fqName");
        kotlin.n0.d.o.f(r2, "nameFilter");
        return t0.b();
    }
}
