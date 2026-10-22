package kotlin.s0.w.d.l0.l.b.f0;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public d() {
    }

    public final InputStream a(String r1) {
        o.f(r1, "path");
        ClassLoader r0 = d.class.getClassLoader();
        if (r0 == null) goto L5;
        URL r2 = r0.getResource(r1);
        if (r2 != null) goto L10;
        return null;
    L10:
        URLConnection r3 = r2.openConnection();
        r3.setUseCaches(false);
        return r3.getInputStream();
    L5:
        return ClassLoader.getSystemResourceAsStream(r1);
    }
}
