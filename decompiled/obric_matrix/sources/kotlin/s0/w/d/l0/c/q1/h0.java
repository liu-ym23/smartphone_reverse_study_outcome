package kotlin.s0.w.d.l0.c.q1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.i0.t0;
import kotlin.s0.w.d.l0.c.q0;

/* JADX INFO: loaded from: classes2.dex */
public class h0 extends kotlin.s0.w.d.l0.k.w.i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.c.h0 f19000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.g.c f19001c;

    public h0(kotlin.s0.w.d.l0.c.h0 r2, kotlin.s0.w.d.l0.g.c r3) {
        kotlin.n0.d.o.f(r2, "moduleDescriptor");
        kotlin.n0.d.o.f(r3, "fqName");
        this.f19000b = r2;
        this.f19001c = r3;
    }

    @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.h
    public Set<kotlin.s0.w.d.l0.g.f> e() {
        return t0.b();
    }

    @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.k
    public Collection<kotlin.s0.w.d.l0.c.m> g(kotlin.s0.w.d.l0.k.w.d r4, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r5) {
        kotlin.n0.d.o.f(r4, "kindFilter");
        kotlin.n0.d.o.f(r5, "nameFilter");
        if (r4.a(kotlin.s0.w.d.l0.k.w.d.f20623c.f()) == true) goto L7;
        return kotlin.i0.r.g();
    L7:
        if (this.f19001c.d() == true) goto L9;
    L12:
        Collection<kotlin.s0.w.d.l0.g.c> r6 = this.f19000b.p(this.f19001c, r5);
        ArrayList r0 = new ArrayList(r6.size());
        Iterator<kotlin.s0.w.d.l0.g.c> r7 = r6.iterator();
    L14:
        if (r7.hasNext() == false) goto L18;
        kotlin.s0.w.d.l0.g.f r1 = r7.next().g();
        kotlin.n0.d.o.e(r1, "subFqName.shortName()");
        if (r5.invoke(r1).booleanValue() == false) goto L14;
        kotlin.s0.w.d.l0.p.a.a(r0, h(r1));
        goto L14
    L18:
        return r0;
    L9:
        if (r4.l().contains(kotlin.s0.w.d.l0.k.w.c.b.f20622a) == false) goto L12;
        return kotlin.i0.r.g();
    }

    protected final q0 h(kotlin.s0.w.d.l0.g.f r3) {
        kotlin.n0.d.o.f(r3, "name");
        if (r3.l() == false) goto L5;
        return null;
    L5:
        kotlin.s0.w.d.l0.c.h0 r0 = this.f19000b;
        kotlin.s0.w.d.l0.g.c r2 = this.f19001c.c(r3);
        kotlin.n0.d.o.e(r2, "fqName.child(name)");
        q0 r4 = r0.N(r2);
        if (r4.isEmpty() == false) goto L8;
        return null;
    L8:
        return r4;
    }

    public String toString() {
        return "subpackages of " + this.f19001c + " from " + this.f19000b;
    }
}
