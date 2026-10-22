package kotlin.s0.w.d.l0.f.y;

import java.io.InputStream;
import kotlin.a0;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.f.m;
import kotlin.s0.w.d.l0.i.g;
import kotlin.u;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final u<m, a> a(InputStream r3) {
        o.f(r3, "<this>");
        a r0 = a.f20210f.a(r3);     // Catch: Throwable -> L10
        if (r0.h() == false) goto L6;
        g r1 = g.d();     // Catch: Throwable -> L10
        b.a(r1);     // Catch: Throwable -> L10
        m r2 = m.W(r3, r1);     // Catch: Throwable -> L10
    L7:
        u<m, a> r4 = a0.a(r2, r0);     // Catch: Throwable -> L10
        kotlin.m0.b.a(r3, null);
        return r4;
    L6:
        r2 = null;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        kotlin.m0.b.a(r3, th);
        throw th;
    }
}
