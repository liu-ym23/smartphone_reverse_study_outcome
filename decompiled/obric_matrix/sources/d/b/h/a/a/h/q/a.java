package d.b.h.a.a.h.q;

import android.os.Looper;
import android.os.SystemClock;
import d.b.h.a.a.h.g;
import d.b.r.d0;
import d.b.r.y;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public class a implements d.b.r.j0.a {
    public a() {
    }

    private String d(String r1) {
        return g.c(r1, true);
    L8:
        return r1;
    }

    @Override // d.b.r.j0.a
    public d0 a(d.b.r.j0.a.InterfaceC0391a r9) {
        Long r0 = Long.valueOf(SystemClock.uptimeMillis());
        d.b.r.h0.c r1 = r9.b();
        URL r3 = new URL(r1.G());     // Catch: MalformedURLException -> L17
        if (r3.getProtocol().equals("http") == false) goto L6;
        g.z(r3.getHost(), r3.getPath(), false);     // Catch: MalformedURLException -> L17
    L6:
        d.b.r.h0.c r2 = b(r1);
        if (r2.z() == null) goto L10;
        r2.z().S.put("BaseSsInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r0.longValue()));
    L10:
        if (d.b.r.j0.b.e() == false) goto L12;
        d0 r10 = r9.d(r2);
    L13:
        Long r4 = Long.valueOf(SystemClock.uptimeMillis());
        c(r2, r10);
        if (r2.z() == null) goto L16;
        r2.z().T.put("BaseSsInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r4.longValue()));
    L16:
        return r10;
    L12:
        r10 = r9.c(r2);
        goto L13
    }

    protected d.b.r.h0.c b(d.b.r.h0.c r8) {
        if (g.n() == true) goto L5;
    L9:
        if (r8 != null) goto L11;
        return r8;
    L11:
        Long r0 = Long.valueOf(SystemClock.uptimeMillis());
        String r1 = r8.G();
        if ((r8.t() instanceof d.b.h.a.a.h.c) == false) goto L14;
        g.f(r1, (d.b.h.a.a.h.c) r8.t());
    L16:
        if (r8.z() == null) goto L19;
        y r2 = r8.z();
        r2.U = SystemClock.uptimeMillis() - r0.longValue();
    L19:
        if (r8.G().startsWith("https:") == true) goto L21;
    L23:
        Long r3 = Long.valueOf(SystemClock.uptimeMillis());
        if (r8.I() == false) goto L31;
        d.b.h.a.a.h.k.a r4 = d.b.h.a.a.h.k.b.b().a();
        if (r4 != null) goto L28;
        r1 = d(r1);
        goto L31
    L28:
        r4.a();
        throw null;
    L31:
        if (r8.z() == null) goto L33;
        y r7 = r8.z();
        r7.V = SystemClock.uptimeMillis() - r3.longValue();
    L33:
        d.b.r.h0.c.a r9 = r8.O();
        r9.h(r1);
        return r9.a();
    L21:
        if (r1.startsWith("http:") == false) goto L23;
        URL r5 = new URL(r1);     // Catch: Throwable -> L35
        g.z(r5.getHost(), r5.getPath(), true);     // Catch: Throwable -> L35
        goto L23
    L14:
        g.e(r1);
        goto L16
    L5:
        if (Looper.getMainLooper() != Looper.myLooper()) goto L9;
        throw new IOException("You must not send request on main thread");
    }

    protected void c(d.b.r.h0.c r1, d0 r2) {
    }
}
