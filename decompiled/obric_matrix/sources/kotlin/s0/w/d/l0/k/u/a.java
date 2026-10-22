package kotlin.s0.w.d.l0.k.u;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<f> f20602b;

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<? extends f> r2) {
        o.f(r2, "inner");
        this.f20602b = r2;
    }

    @Override // kotlin.s0.w.d.l0.k.u.f
    public List<kotlin.s0.w.d.l0.g.f> a(kotlin.s0.w.d.l0.c.e r3) {
        o.f(r3, "thisDescriptor");
        List<f> r2 = this.f20602b;
        ArrayList r0 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r.v(r0, ((f) r4.next()).a(r3));
        goto L4
    L6:
        return r0;
    }

    @Override // kotlin.s0.w.d.l0.k.u.f
    public void b(kotlin.s0.w.d.l0.c.e r2, kotlin.s0.w.d.l0.g.f r3, Collection<z0> r4) {
        o.f(r2, "thisDescriptor");
        o.f(r3, "name");
        o.f(r4, "result");
        Iterator<T> r1 = this.f20602b.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((f) r1.next()).b(r2, r3, r4);
        goto L4
    }

    @Override // kotlin.s0.w.d.l0.k.u.f
    public void c(kotlin.s0.w.d.l0.c.e r2, List<kotlin.s0.w.d.l0.c.d> r3) {
        o.f(r2, "thisDescriptor");
        o.f(r3, "result");
        Iterator<T> r1 = this.f20602b.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((f) r1.next()).c(r2, r3);
        goto L4
    }

    @Override // kotlin.s0.w.d.l0.k.u.f
    public List<kotlin.s0.w.d.l0.g.f> d(kotlin.s0.w.d.l0.c.e r3) {
        o.f(r3, "thisDescriptor");
        List<f> r2 = this.f20602b;
        ArrayList r0 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r.v(r0, ((f) r4.next()).d(r3));
        goto L4
    L6:
        return r0;
    }

    @Override // kotlin.s0.w.d.l0.k.u.f
    public void e(kotlin.s0.w.d.l0.c.e r2, kotlin.s0.w.d.l0.g.f r3, Collection<z0> r4) {
        o.f(r2, "thisDescriptor");
        o.f(r3, "name");
        o.f(r4, "result");
        Iterator<T> r1 = this.f20602b.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((f) r1.next()).e(r2, r3, r4);
        goto L4
    }
}
