package kotlin.s0.w.d.l0.f.a0.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class h {
    public static final List<kotlin.s0.w.d.l0.f.a0.a.e.c> a(List<kotlin.s0.w.d.l0.f.a0.a.e.c> r4) {
        o.f(r4, "<this>");
        ArrayList r0 = new ArrayList();
        r0.ensureCapacity(r4.size());
        Iterator<kotlin.s0.w.d.l0.f.a0.a.e.c> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        kotlin.s0.w.d.l0.f.a0.a.e.c r1 = r5.next();
        int r2 = r1.F();
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L4;
        r0.add(r1);
        r3 = r3 + 1;
        goto L6
    L8:
        r0.trimToSize();
        return r0;
    }
}
