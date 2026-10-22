package kotlin.s0.w.d.l0.n.t1;

import kotlin.s0.w.d.l0.n.d1;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.q1;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g f21102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final f f21103d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.k.j f21104e;

    public m(g r2, f r3) {
        kotlin.n0.d.o.f(r2, "kotlinTypeRefiner");
        kotlin.n0.d.o.f(r3, "kotlinTypePreparator");
        this.f21102c = r2;
        this.f21103d = r3;
        kotlin.s0.w.d.l0.k.j r4 = kotlin.s0.w.d.l0.k.j.m(c());
        kotlin.n0.d.o.e(r4, "createWithTypeRefiner(kotlinTypeRefiner)");
        this.f21104e = r4;
    }

    public /* synthetic */ m(g r1, f r2, int r3, kotlin.n0.d.g r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = f.a.f21079a;
    L5:
        this(r1, r2);
    }

    @Override // kotlin.s0.w.d.l0.n.t1.l
    public kotlin.s0.w.d.l0.k.j a() {
        return this.f21104e;
    }

    @Override // kotlin.s0.w.d.l0.n.t1.e
    public boolean b(e0 r9, e0 r10) {
        kotlin.n0.d.o.f(r9, "a");
        kotlin.n0.d.o.f(r10, "b");
        g r5 = c();
        return e(a.b(false, false, null, f(), r5, 6, null), r9.R0(), r10.R0());
    }

    @Override // kotlin.s0.w.d.l0.n.t1.l
    public g c() {
        return this.f21102c;
    }

    @Override // kotlin.s0.w.d.l0.n.t1.e
    public boolean d(e0 r9, e0 r10) {
        kotlin.n0.d.o.f(r9, "subtype");
        kotlin.n0.d.o.f(r10, "supertype");
        g r5 = c();
        return g(a.b(true, false, null, f(), r5, 6, null), r9.R0(), r10.R0());
    }

    public final boolean e(d1 r1, q1 r2, q1 r3) {
        kotlin.n0.d.o.f(r1, "<this>");
        kotlin.n0.d.o.f(r2, "a");
        kotlin.n0.d.o.f(r3, "b");
        return kotlin.s0.w.d.l0.n.f.f20979a.k(r1, r2, r3);
    }

    public f f() {
        return this.f21103d;
    }

    public final boolean g(d1 r8, q1 r9, q1 r10) {
        kotlin.n0.d.o.f(r8, "<this>");
        kotlin.n0.d.o.f(r9, "subType");
        kotlin.n0.d.o.f(r10, "superType");
        return kotlin.s0.w.d.l0.n.f.t(kotlin.s0.w.d.l0.n.f.f20979a, r8, r9, r10, false, 8, null);
    }
}
