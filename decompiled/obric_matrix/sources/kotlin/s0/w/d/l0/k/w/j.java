package kotlin.s0.w.d.l0.k.w;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.i0.r;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class j {
    public static final Set<kotlin.s0.w.d.l0.g.f> a(Iterable<? extends h> r2) {
        o.f(r2, "<this>");
        HashSet r0 = new HashSet();
        Iterator<? extends h> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L12;
        Set<kotlin.s0.w.d.l0.g.f> r1 = r3.next().e();
        if (r1 == null) goto L7;
        r.v(r0, r1);
        goto L4
    L7:
        return null;
    L12:
        return r0;
    }
}
