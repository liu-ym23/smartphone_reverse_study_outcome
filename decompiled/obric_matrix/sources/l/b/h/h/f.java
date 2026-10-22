package l.b.h.h;

import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final g f22297a = null;

    static {
        f22297a = new g();
    }

    public static byte[] a(String r1, int r2, int r3) {
        return f22297a.b(r1, r2, r3);
    L4:
        e = move-exception;
        throw new c("exception decoding Hex string: " + e.getMessage(), e);
    }

    public static byte[] b(byte[] r2) {
        return c(r2, 0, r2.length);
    }

    public static byte[] c(byte[] r2, int r3, int r4) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        f22297a.a(r2, r3, r4, r0);     // Catch: Exception -> L6
        return r0.toByteArray();
    L6:
        e = move-exception;
        throw new e("exception encoding Hex string: " + e.getMessage(), e);
    }

    public static String d(byte[] r2) {
        return e(r2, 0, r2.length);
    }

    public static String e(byte[] r0, int r1, int r2) {
        return l.b.h.g.b(c(r0, r1, r2));
    }
}
