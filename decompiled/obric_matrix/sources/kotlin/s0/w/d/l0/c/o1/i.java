package kotlin.s0.w.d.l0.c.o1;

import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class i {
    public static final g a(g r3, g r4) {
        o.f(r3, "first");
        o.f(r4, "second");
        if (r3.isEmpty() == false) goto L6;
        return r4;
    L6:
        if (r4.isEmpty() == false) goto L9;
        return r3;
    L9:
        return new k(new g[]{r3, r4});
    }
}
