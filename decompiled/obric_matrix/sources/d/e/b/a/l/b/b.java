package d.e.b.a.l.b;

import d.e.b.a.g;
import d.e.b.a.h;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Logger f16639b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f16640a;

    static {
        f16639b = Logger.getLogger(b.class.getName());
    }

    private b(boolean r1) {
        this.f16640a = r1;
    }

    private void a(InputStream r3) {
        r3.close();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        f16639b.log(Level.WARNING, "Error closing input stream (ignored)", e);
    }

    private List<g> b() {
        if (this.f16640a == true) goto L7;
        return Collections.emptyList();
    L7:
        throw new IllegalArgumentException("Source cannot be null");
    }

    public static b c() {
        return new b(false);
    }

    public Collection<g> d(InputStream r6) {
        if (r6 != null) goto L27;
        return b();
    L27:
        ObjectInputStream r1 = new ObjectInputStream(r6);     // Catch: Throwable -> L16 IOException -> L18
        h r0 = new h();     // Catch: IOException -> L14 Throwable -> L22
        r0.readExternal(r1);     // Catch: IOException -> L14 Throwable -> L22
        if (r0.b().isEmpty() == true) goto L13;
        List<g> r7 = r0.b();     // Catch: IOException -> L14 Throwable -> L22
        a(r1);
        return r7;
    L13:
        throw new IllegalStateException("Empty metadata");     // Catch: IOException -> L14 Throwable -> L22
    L14:
        IOException e2 = e;
    L21:
        throw new IllegalStateException("Unable to parse metadata file", e2);     // Catch: Throwable -> L22
    L22:
        Throwable th = th;
    L23:
        if (0 == 0) goto L25;
        a(null);
    L26:
        throw th;
    L25:
        a(r6);
    L18:
        e = move-exception;
        e2 = e;
    L16:
        th = move-exception;
        th = th;
        goto L23
    }
}
