package p000j.k0.g;

import java.net.Proxy;
import p000j.d0;
import p000j.w;

/* JADX INFO: loaded from: classes2.dex */
public final class i {
    public static String a(d0 r2, Proxy.Type r3) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r2.f());
        r0.append(' ');
        boolean r4 = b(r2, r3);
        w r5 = r2.k();
        if (r4 == false) goto L5;
        r0.append(r5);
    L6:
        r0.append(" HTTP/1.1");
        return r0.toString();
    L5:
        r0.append(c(r5));
        goto L6
    }

    private static boolean b(d0 r0, Proxy.Type r1) {
        if (r0.e() == false) goto L5;
    L7:
        return false;
    L5:
        if (r1 != Proxy.Type.HTTP) goto L7;
        return true;
    }

    public static String c(w r2) {
        String r0 = r2.h();
        String r3 = r2.j();
        if (r3 != null) goto L5;
        return r0;
    L5:
        return r0 + '?' + r3;
    }
}
