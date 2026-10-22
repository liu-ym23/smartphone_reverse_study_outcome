package kotlin.s0.w.d.l0.l.b.g0;

import java.util.Collection;
import java.util.List;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.e1;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.g1;
import kotlin.s0.w.d.l0.c.q1.i0;
import kotlin.s0.w.d.l0.c.u;
import kotlin.s0.w.d.l0.f.r;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.g0;
import kotlin.s0.w.d.l0.n.k1;
import kotlin.s0.w.d.l0.n.l1;
import kotlin.s0.w.d.l0.n.m0;
import kotlin.s0.w.d.l0.n.r1;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends kotlin.s0.w.d.l0.c.q1.d implements g {
    private final kotlin.s0.w.d.l0.m.n m;
    private final r n;
    private final kotlin.s0.w.d.l0.f.z.c o;
    private final kotlin.s0.w.d.l0.f.z.g p;
    private final kotlin.s0.w.d.l0.f.z.h q;
    private final f r;
    private Collection<? extends i0> s;
    private m0 t;
    private m0 u;
    private List<? extends f1> v;
    private m0 w;

    public l(kotlin.s0.w.d.l0.m.n r13, kotlin.s0.w.d.l0.c.m r14, kotlin.s0.w.d.l0.c.o1.g r15, kotlin.s0.w.d.l0.g.f r16, u r17, r r18, kotlin.s0.w.d.l0.f.z.c r19, kotlin.s0.w.d.l0.f.z.g r20, kotlin.s0.w.d.l0.f.z.h r21, f r22) {
        o.f(r13, "storageManager");
        o.f(r14, "containingDeclaration");
        o.f(r15, "annotations");
        o.f(r16, "name");
        o.f(r17, "visibility");
        o.f(r18, "proto");
        o.f(r19, "nameResolver");
        o.f(r20, "typeTable");
        o.f(r21, "versionRequirementTable");
        a1 r4 = a1.f18847a;
        o.e(r4, "NO_SOURCE");
        super(r14, r15, r16, r4, r17);
        this.m = r13;
        this.n = r18;
        this.o = r19;
        this.p = r20;
        this.q = r21;
        this.r = r22;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.d
    protected List<f1> N0() {
        List r0 = this.v;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.v("typeConstructorParameters");
        throw null;
    }

    public r P0() {
        return this.n;
    }

    public kotlin.s0.w.d.l0.f.z.h Q0() {
        return this.q;
    }

    public final void R0(List<? extends f1> r2, m0 r3, m0 r4) {
        o.f(r2, "declaredTypeParameters");
        o.f(r3, "underlyingType");
        o.f(r4, "expandedType");
        O0(r2);
        this.t = r3;
        this.u = r4;
        this.v = g1.d(this);
        this.w = F0();
        this.s = M0();
    }

    @Override // kotlin.s0.w.d.l0.l.b.g0.g
    public kotlin.s0.w.d.l0.f.z.g S() {
        return this.p;
    }

    public e1 S0(l1 r13) {
        o.f(r13, "substitutor");
        if (r13.k() == false) goto L5;
        return this;
    L5:
        kotlin.s0.w.d.l0.m.n r2 = h0();
        kotlin.s0.w.d.l0.c.m r3 = c();
        o.e(r3, "containingDeclaration");
        kotlin.s0.w.d.l0.c.o1.g r4 = getAnnotations();
        o.e(r4, "annotations");
        kotlin.s0.w.d.l0.g.f r5 = getName();
        o.e(r5, "name");
        l r0 = new l(r2, r3, r4, r5, getVisibility(), P0(), Z(), S(), Q0(), c0());
        List<f1> r1 = u();
        m0 r6 = g0();
        r1 r7 = r1.f21065h;
        e0 r8 = r13.n(r6, r7);
        o.e(r8, "substitutor.safeSubstitu…Type, Variance.INVARIANT)");
        m0 r9 = k1.a(r8);
        e0 r12 = r13.n(V(), r7);
        o.e(r12, "substitutor.safeSubstitu…Type, Variance.INVARIANT)");
        r0.R0(r1, r9, k1.a(r12));
        return r0;
    }

    @Override // kotlin.s0.w.d.l0.c.e1
    public m0 V() {
        m0 r0 = this.u;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.v("expandedType");
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.l.b.g0.g
    public kotlin.s0.w.d.l0.f.z.c Z() {
        return this.o;
    }

    @Override // kotlin.s0.w.d.l0.l.b.g0.g
    public f c0() {
        return this.r;
    }

    @Override // kotlin.s0.w.d.l0.c.c1
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.n d(l1 r1) {
        return S0(r1);
    }

    @Override // kotlin.s0.w.d.l0.c.e1
    public m0 g0() {
        m0 r0 = this.t;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.v("underlyingType");
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.d
    protected kotlin.s0.w.d.l0.m.n h0() {
        return this.m;
    }

    @Override // kotlin.s0.w.d.l0.c.e1
    public kotlin.s0.w.d.l0.c.e r() {
        if (g0.a(V()) == true) goto L10;
        kotlin.s0.w.d.l0.c.h r2 = V().O0().d();
        if ((r2 instanceof kotlin.s0.w.d.l0.c.e) == true) goto L8;
        return null;
    L8:
        return (kotlin.s0.w.d.l0.c.e) r2;
    L10:
        return null;
    }

    @Override // kotlin.s0.w.d.l0.c.h
    public m0 s() {
        m0 r0 = this.w;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.v("defaultTypeImpl");
        throw null;
    }
}
