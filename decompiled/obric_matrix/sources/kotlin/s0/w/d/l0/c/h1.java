package kotlin.s0.w.d.l0.c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.s0.w.d.l0.n.w1.k;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h1<Type extends kotlin.s0.w.d.l0.n.w1.k> {
    private h1() {
    }

    public /* synthetic */ h1(kotlin.n0.d.g r1) {
        this();
    }

    public abstract List<kotlin.u<kotlin.s0.w.d.l0.g.f, Type>> a();

    public final <Other extends kotlin.s0.w.d.l0.n.w1.k> h1<Other> b(kotlin.n0.c.l<? super Type, ? extends Other> r4) {
        kotlin.n0.d.o.f(r4, "transform");
        if ((this instanceof z) == false) goto L6;
        z r3 = (z) this;
        return new z(r3.c(), r4.invoke(r3.d()));
    L6:
        if ((this instanceof i0) == false) goto L14;
        List<kotlin.u<kotlin.s0.w.d.l0.g.f, Type>> r5 = a();
        ArrayList r0 = new ArrayList(kotlin.i0.r.q(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L12;
        kotlin.u r1 = (kotlin.u) r6.next();
        r0.add(kotlin.a0.a((kotlin.s0.w.d.l0.g.f) r1.a(), r4.invoke((kotlin.s0.w.d.l0.n.w1.k) r1.b())));
        goto L9
    L12:
        return new i0(r0);
    L14:
        throw new kotlin.m();
    }
}
