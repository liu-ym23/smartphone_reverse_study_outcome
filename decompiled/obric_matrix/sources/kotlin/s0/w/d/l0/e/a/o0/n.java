package kotlin.s0.w.d.l0.e.a.o0;

import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.e.a.x;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.n1;
import kotlin.s0.w.d.l0.n.p1;

/* JADX INFO: loaded from: classes2.dex */
final class n extends a<kotlin.s0.w.d.l0.c.o1.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.c.o1.a f19618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f19619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.e.a.l0.g f19620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.e.a.b f19621d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f19622e;

    public n(kotlin.s0.w.d.l0.c.o1.a r2, boolean r3, kotlin.s0.w.d.l0.e.a.l0.g r4, kotlin.s0.w.d.l0.e.a.b r5, boolean r6) {
        kotlin.n0.d.o.f(r4, "containerContext");
        kotlin.n0.d.o.f(r5, "containerApplicabilityType");
        this.f19618a = r2;
        this.f19619b = r3;
        this.f19620c = r4;
        this.f19621d = r5;
        this.f19622e = r6;
    }

    public /* synthetic */ n(kotlin.s0.w.d.l0.c.o1.a r7, boolean r8, kotlin.s0.w.d.l0.e.a.l0.g r9, kotlin.s0.w.d.l0.e.a.b r10, boolean r11, int r12, kotlin.n0.d.g r13) {
        if ((r12 & 16) == 0) goto L5;
        r11 = false;
    L5:
        this(r7, r8, r9, r10, r11);
    }

    @Override // kotlin.s0.w.d.l0.e.a.o0.a
    public boolean A(kotlin.s0.w.d.l0.n.w1.i r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        return ((e0) r1).R0() instanceof g;
    }

    public kotlin.s0.w.d.l0.e.a.d D() {
        return this.f19620c.a().a();
    }

    public e0 E(kotlin.s0.w.d.l0.n.w1.i r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        return p1.a((e0) r1);
    }

    public boolean F(kotlin.s0.w.d.l0.c.o1.c r2) {
        kotlin.n0.d.o.f(r2, "<this>");
        if ((r2 instanceof kotlin.s0.w.d.l0.e.a.k0.g) == false) goto L7;
        if (((kotlin.s0.w.d.l0.e.a.k0.g) r2).g() == false) goto L7;
    L14:
        return true;
    L7:
        if ((r2 instanceof kotlin.s0.w.d.l0.e.a.l0.l.e) == true) goto L9;
    L15:
        return false;
    L9:
        if (o() == true) goto L15;
        if (((kotlin.s0.w.d.l0.e.a.l0.l.e) r2).l() == true) goto L14;
        if (l() != kotlin.s0.w.d.l0.e.a.b.f19220k) goto L15;
        goto L14
    }

    public kotlin.s0.w.d.l0.n.w1.r G() {
        return kotlin.s0.w.d.l0.n.t1.q.f21107a;
    }

    @Override // kotlin.s0.w.d.l0.e.a.o0.a
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.e.a.a<kotlin.s0.w.d.l0.c.o1.c> h() {
        return D();
    }

    @Override // kotlin.s0.w.d.l0.e.a.o0.a
    public Iterable<kotlin.s0.w.d.l0.c.o1.c> i(kotlin.s0.w.d.l0.n.w1.i r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        return ((e0) r1).getAnnotations();
    }

    @Override // kotlin.s0.w.d.l0.e.a.o0.a
    public Iterable<kotlin.s0.w.d.l0.c.o1.c> k() {
        kotlin.s0.w.d.l0.c.o1.a r0 = this.f19618a;
        if (r0 == null) goto L8;
        kotlin.s0.w.d.l0.c.o1.g r1 = r0.getAnnotations();
        if (r1 == null) goto L8;
        return r1;
    L8:
        return kotlin.i0.r.g();
    }

    @Override // kotlin.s0.w.d.l0.e.a.o0.a
    public kotlin.s0.w.d.l0.e.a.b l() {
        return this.f19621d;
    }

    @Override // kotlin.s0.w.d.l0.e.a.o0.a
    public x m() {
        return this.f19620c.b();
    }

    @Override // kotlin.s0.w.d.l0.e.a.o0.a
    public boolean n() {
        kotlin.s0.w.d.l0.c.o1.a r1 = this.f19618a;
        if ((r1 instanceof j1) == true) goto L5;
    L7:
        return false;
    L5:
        if (((j1) r1).l0() == null) goto L7;
        return true;
    }

    @Override // kotlin.s0.w.d.l0.e.a.o0.a
    public boolean o() {
        return this.f19620c.a().q().c();
    }

    @Override // kotlin.s0.w.d.l0.e.a.o0.a
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.n.w1.i p(kotlin.s0.w.d.l0.n.w1.i r1) {
        return E(r1);
    }

    @Override // kotlin.s0.w.d.l0.e.a.o0.a
    public /* bridge */ /* synthetic */ boolean r(kotlin.s0.w.d.l0.c.o1.c r1) {
        return F(r1);
    }

    @Override // kotlin.s0.w.d.l0.e.a.o0.a
    public kotlin.s0.w.d.l0.g.d s(kotlin.s0.w.d.l0.n.w1.i r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        kotlin.s0.w.d.l0.c.e r0 = n1.f((e0) r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return kotlin.s0.w.d.l0.k.d.m(r0);
    }

    @Override // kotlin.s0.w.d.l0.e.a.o0.a
    public boolean u() {
        return this.f19622e;
    }

    @Override // kotlin.s0.w.d.l0.e.a.o0.a
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.n.w1.p v() {
        return G();
    }

    @Override // kotlin.s0.w.d.l0.e.a.o0.a
    public boolean w(kotlin.s0.w.d.l0.n.w1.i r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        return kotlin.s0.w.d.l0.b.h.e0((e0) r1);
    }

    @Override // kotlin.s0.w.d.l0.e.a.o0.a
    public boolean x() {
        return this.f19619b;
    }

    @Override // kotlin.s0.w.d.l0.e.a.o0.a
    public boolean y(kotlin.s0.w.d.l0.n.w1.i r2, kotlin.s0.w.d.l0.n.w1.i r3) {
        kotlin.n0.d.o.f(r2, "<this>");
        kotlin.n0.d.o.f(r3, "other");
        return this.f19620c.a().k().b((e0) r2, (e0) r3);
    }

    @Override // kotlin.s0.w.d.l0.e.a.o0.a
    public boolean z(kotlin.s0.w.d.l0.n.w1.o r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        return r1 instanceof kotlin.s0.w.d.l0.e.a.l0.l.m;
    }
}
