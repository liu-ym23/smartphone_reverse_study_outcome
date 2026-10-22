package d.b.h.a.a.h.q;

import android.os.SystemClock;
import d.b.h.a.a.h.g;
import d.b.r.d0;
import d.b.r.y;

/* JADX INFO: loaded from: classes.dex */
public final class b implements d.b.r.j0.a {
    public b() {
    }

    private d.b.r.h0.c b(d.b.r.h0.c r2) {
        if (r2 != null) goto L5;
        return r2;
    L5:
        if (r2.N() == false) goto L7;
        return r2;
    L7:
        return c(r2);
    }

    private d.b.r.h0.c c(d.b.r.h0.c r7) {
        String r6 = r7.G();     // Catch: Throwable -> L7
        Long r0 = Long.valueOf(SystemClock.uptimeMillis());     // Catch: Throwable -> L7
        String r8 = g.a0(r6, r7.I(), new Object[]{r7.s()});     // Catch: Throwable -> L7
        if (r7.z() == null) goto L5;
        r7.z().W = SystemClock.uptimeMillis() - r0.longValue();     // Catch: Throwable -> L7
    L5:
        d.b.r.h0.c.a r1 = r7.O();     // Catch: Throwable -> L7
        r1.h(r8);     // Catch: Throwable -> L7
        return r1.a();
    L7:
        return r7;
    }

    @Override // d.b.r.j0.a
    public d0 a(d.b.r.j0.a.InterfaceC0391a r7) {
        y r0 = r7.a();
        Long r1 = Long.valueOf(SystemClock.uptimeMillis());
        d.b.r.h0.c r6 = b(r7.b());
        if (r0 == null) goto L6;
        r0.S.put("RequestVerifyInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r1.longValue()));
    L6:
        if (d.b.r.j0.b.e() == false) goto L9;
        return r7.d(r6);
    L9:
        return r7.c(r6);
    }
}
