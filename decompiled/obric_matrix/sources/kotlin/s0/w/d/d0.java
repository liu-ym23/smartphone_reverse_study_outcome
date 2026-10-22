package kotlin.s0.w.d;

/* JADX INFO: loaded from: classes2.dex */
public class d0 extends kotlin.n0.d.f0 {
    public d0() {
    }

    private static i i(kotlin.n0.d.c r1) {
        kotlin.s0.f r2 = r1.getOwner();
        if ((r2 instanceof i) == false) goto L6;
        return (i) r2;
    L6:
        return b.f18501i;
    }

    @Override // kotlin.n0.d.f0
    public kotlin.s0.g a(kotlin.n0.d.l r4) {
        return new j(i(r4), r4.getName(), r4.getSignature(), r4.getBoundReceiver());
    }

    @Override // kotlin.n0.d.f0
    public kotlin.s0.d b(Class r1) {
        return g.a(r1);
    }

    @Override // kotlin.n0.d.f0
    public kotlin.s0.f c(Class r1, String r2) {
        return new o(r1, r2);
    }

    @Override // kotlin.n0.d.f0
    public kotlin.s0.h d(kotlin.n0.d.r r4) {
        return new l(i(r4), r4.getName(), r4.getSignature(), r4.getBoundReceiver());
    }

    @Override // kotlin.n0.d.f0
    public kotlin.s0.j e(kotlin.n0.d.v r4) {
        return new q(i(r4), r4.getName(), r4.getSignature(), r4.getBoundReceiver());
    }

    @Override // kotlin.n0.d.f0
    public kotlin.s0.k f(kotlin.n0.d.x r4) {
        return new r(i(r4), r4.getName(), r4.getSignature(), r4.getBoundReceiver());
    }

    @Override // kotlin.n0.d.f0
    public String g(kotlin.n0.d.k r2) {
        kotlin.s0.g r0 = kotlin.s0.w.c.a(r2);
        if (r0 == null) goto L9;
        j r1 = i0.b(r0);
        if (r1 == null) goto L9;
        return e0.f18529a.e(r1.H());
    L9:
        return super.g(r2);
    }

    @Override // kotlin.n0.d.f0
    public String h(kotlin.n0.d.q r1) {
        return g(r1);
    }
}
