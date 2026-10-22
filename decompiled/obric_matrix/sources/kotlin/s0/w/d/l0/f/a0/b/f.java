package kotlin.s0.w.d.l0.f.a0.b;

import java.util.List;
import java.util.Set;
import kotlin.i0.r;
import kotlin.i0.t0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends g {
    public f(kotlin.s0.w.d.l0.f.a0.a.e r3, String[] r4) {
        o.f(r3, "types");
        o.f(r4, "strings");
        List<Integer> r0 = r3.w();
        if (r0.isEmpty() == false) goto L5;
        Set r1 = t0.b();
    L6:
        List<kotlin.s0.w.d.l0.f.a0.a.e.c> r5 = r3.y();
        o.e(r5, "types.recordList");
        super(r4, r1, h.a(r5));
        return;
    L5:
        o.e(r0, "");
        r1 = r.D0(r0);
        goto L6
    }
}
