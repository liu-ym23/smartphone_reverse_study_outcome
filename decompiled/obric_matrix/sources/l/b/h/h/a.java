package l.b.h.h;

import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final d f22291a = null;

    static {
        f22291a = new b();
    }

    public static byte[] a(byte[] r2) {
        return b(r2, 0, r2.length);
    }

    public static byte[] b(byte[] r2, int r3, int r4) {
        ByteArrayOutputStream r1 = new ByteArrayOutputStream(((r4 + 2) / 3) * 4);
        f22291a.a(r2, r3, r4, r1);     // Catch: Exception -> L6
        return r1.toByteArray();
    L6:
        e = move-exception;
        throw new e("exception encoding base64 string: " + e.getMessage(), e);
    }
}
