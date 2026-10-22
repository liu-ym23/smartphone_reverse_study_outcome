package d.c.c.d;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Logger f15377a = null;

    static {
        f15377a = Logger.getLogger(b.class.getName());
    }

    private b() {
    }

    public static void a(Closeable r2, boolean r3) {
        if (r2 != null) goto L11;
        return;
    L11:
        r2.close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        if (r3 == false) goto L10;
        f15377a.log(Level.WARNING, "IOException thrown while closing Closeable.", e);
        return;
    L10:
        throw e;
    }

    public static void b(InputStream r1) {
        a(r1, true);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        throw new AssertionError(e);
    }
}
