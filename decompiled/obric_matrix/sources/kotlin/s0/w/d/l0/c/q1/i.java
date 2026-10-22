package kotlin.s0.w.d.l0.c.q1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.s0.w.d.l0.c.o0;
import kotlin.s0.w.d.l0.c.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<kotlin.s0.w.d.l0.c.m0> f19002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19003b;

    /* JADX WARN: Multi-variable type inference failed */
    public i(List<? extends kotlin.s0.w.d.l0.c.m0> r2, String r3) {
        kotlin.n0.d.o.f(r2, "providers");
        kotlin.n0.d.o.f(r3, "debugName");
        this.f19002a = r2;
        this.f19003b = r3;
        r2.size();
        kotlin.i0.r.D0(r2).size();
    }

    @Override // kotlin.s0.w.d.l0.c.m0
    public List<kotlin.s0.w.d.l0.c.l0> a(kotlin.s0.w.d.l0.g.c r3) {
        kotlin.n0.d.o.f(r3, "fqName");
        ArrayList r0 = new ArrayList();
        Iterator<kotlin.s0.w.d.l0.c.m0> r2 = this.f19002a.iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        o0.a(r2.next(), r3, r0);
        goto L4
    L7:
        return kotlin.i0.r.z0(r0);
    }

    @Override // kotlin.s0.w.d.l0.c.p0
    public void b(kotlin.s0.w.d.l0.g.c r2, Collection<kotlin.s0.w.d.l0.c.l0> r3) {
        kotlin.n0.d.o.f(r2, "fqName");
        kotlin.n0.d.o.f(r3, "packageFragments");
        Iterator<kotlin.s0.w.d.l0.c.m0> r1 = this.f19002a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        o0.a(r1.next(), r2, r3);
        goto L4
    }

    @Override // kotlin.s0.w.d.l0.c.p0
    public boolean c(kotlin.s0.w.d.l0.g.c r3) {
        kotlin.n0.d.o.f(r3, "fqName");
        List<kotlin.s0.w.d.l0.c.m0> r2 = this.f19002a;
        if ((r2 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L18;
        if (o0.b((kotlin.s0.w.d.l0.c.m0) r4.next(), r3) == true) goto L9;
        return false;
    L18:
        return true;
    L5:
        if (r2.isEmpty() == false) goto L7;
        return true;
    }

    @Override // kotlin.s0.w.d.l0.c.m0
    public Collection<kotlin.s0.w.d.l0.g.c> p(kotlin.s0.w.d.l0.g.c r3, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r4) {
        kotlin.n0.d.o.f(r3, "fqName");
        kotlin.n0.d.o.f(r4, "nameFilter");
        HashSet r0 = new HashSet();
        Iterator<kotlin.s0.w.d.l0.c.m0> r2 = this.f19002a.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r0.addAll(r2.next().p(r3, r4));
        goto L4
    L6:
        return r0;
    }

    public String toString() {
        return this.f19003b;
    }
}
