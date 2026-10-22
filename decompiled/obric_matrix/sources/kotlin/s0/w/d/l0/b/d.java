package kotlin.s0.w.d.l0.b;

import java.util.Set;
import kotlin.i0.r;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static final boolean a(c r1, kotlin.s0.w.d.l0.c.e r2) {
        kotlin.n0.d.o.f(r1, "<this>");
        kotlin.n0.d.o.f(r2, "classDescriptor");
        if (kotlin.s0.w.d.l0.k.d.x(r2) == false) goto L11;
        Set<kotlin.s0.w.d.l0.g.b> r3 = r1.b();
        kotlin.s0.w.d.l0.g.b r4 = kotlin.s0.w.d.l0.k.t.a.g(r2);
        if (r4 == null) goto L7;
        kotlin.s0.w.d.l0.g.b r5 = r4.g();
    L9:
        if (r.J(r3, r5) == false) goto L11;
        return true;
    L7:
        r5 = null;
    L11:
        return false;
    }
}
