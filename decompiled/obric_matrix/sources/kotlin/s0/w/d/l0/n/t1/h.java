package kotlin.s0.w.d.l0.n.t1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.s0.w.d.l0.c.g0;
import kotlin.s0.w.d.l0.n.e0;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final g0<p<x>> f21081a = null;

    static {
        f21081a = new g0("KotlinTypeRefiner");
    }

    public static final g0<p<x>> a() {
        return f21081a;
    }

    public static final List<e0> b(g r2, Iterable<? extends e0> r3) {
        kotlin.n0.d.o.f(r2, "<this>");
        kotlin.n0.d.o.f(r3, "types");
        ArrayList r0 = new ArrayList(kotlin.i0.r.q(r3, 10));
        Iterator<? extends e0> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r0.add(r2.h(r4.next()));
        goto L4
    L6:
        return r0;
    }
}
