package l.b.h.i;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f22302a = 4096;

    static {
    }

    public static void a(InputStream r4, OutputStream r5) {
        int r0 = f22302a;
        byte[] r1 = new byte[r0];
    L3:
        int r3 = r4.read(r1, 0, r0);
        if (r3 < 0) goto L6;
        r5.write(r1, 0, r3);
        goto L3
    }

    public static byte[] b(InputStream r1) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        a(r1, r0);
        return r0.toByteArray();
    }

    public static int c(InputStream r2, byte[] r3) {
        return d(r2, r3, 0, r3.length);
    }

    public static int d(InputStream r3, byte[] r4, int r5, int r6) {
        int r0 = 0;
    L3:
        if (r0 >= r6) goto L8;
        int r1 = r3.read(r4, r5 + r0, r6 - r0);
        if (r1 < 0) goto L8;
        r0 = r0 + r1;
    L8:
        return r0;
    }
}
