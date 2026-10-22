package kotlin.s0.w.d.l0.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class o0 {
    public static final void a(m0 r1, kotlin.s0.w.d.l0.g.c r2, Collection<l0> r3) {
        kotlin.n0.d.o.f(r1, "<this>");
        kotlin.n0.d.o.f(r2, "fqName");
        kotlin.n0.d.o.f(r3, "packageFragments");
        if ((r1 instanceof p0) == false) goto L5;
        ((p0) r1).b(r2, r3);
        return;
    L5:
        r3.addAll(r1.a(r2));
    }

    public static final boolean b(m0 r1, kotlin.s0.w.d.l0.g.c r2) {
        kotlin.n0.d.o.f(r1, "<this>");
        kotlin.n0.d.o.f(r2, "fqName");
        if ((r1 instanceof p0) == false) goto L6;
        return ((p0) r1).c(r2);
    L6:
        return c(r1, r2).isEmpty();
    }

    public static final List<l0> c(m0 r1, kotlin.s0.w.d.l0.g.c r2) {
        kotlin.n0.d.o.f(r1, "<this>");
        kotlin.n0.d.o.f(r2, "fqName");
        ArrayList r0 = new ArrayList();
        a(r1, r2, r0);
        return r0;
    }
}
