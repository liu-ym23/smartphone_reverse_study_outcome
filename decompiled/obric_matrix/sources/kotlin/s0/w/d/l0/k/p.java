package kotlin.s0.w.d.l0.k;

import java.util.Collection;
import java.util.Iterator;
import kotlin.s0.w.d.l0.c.t;

/* JADX INFO: loaded from: classes2.dex */
public final class p {
    public static final kotlin.s0.w.d.l0.c.b a(Collection<? extends kotlin.s0.w.d.l0.c.b> r4) {
        kotlin.n0.d.o.f(r4, "descriptors");
        r4.isEmpty();
        kotlin.s0.w.d.l0.c.b r0 = null;
        Iterator<? extends kotlin.s0.w.d.l0.c.b> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L13;
        kotlin.s0.w.d.l0.c.b r1 = r5.next();
        if (r0 == null) goto L12;
        Integer r2 = t.d(r0.getVisibility(), r1.getVisibility());
        if (r2 == null) goto L4;
        if (r2.intValue() >= 0) goto L4;
    L12:
        r0 = r1;
        goto L4
    L13:
        kotlin.n0.d.o.c(r0);
        return r0;
    }
}
