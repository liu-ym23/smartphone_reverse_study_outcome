package d.b.r.k0;

import java.io.InputStream;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f14418a = null;

    static {
        f14418a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    private static char[] a(byte[] r7) {
        int r0 = r7.length;
        char[] r1 = new char[r0 << 1];
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L5;
        int r4 = r3 + 1;
        char[] r5 = f14418a;
        r1[r3] = r5[(r7[r2] & 240) >>> 4];
        r3 = r4 + 1;
        r1[r4] = r5[r7[r2] & 15];
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public static String b(InputStream r6) {
        MessageDigest r0 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L8
        byte[] r2 = new byte[1024];     // Catch: Throwable -> L8
        int r4 = r6.read(r2, 0, 1024);     // Catch: Throwable -> L8
    L4:
        if (r4 <= (-1)) goto L6;
        r0.update(r2, 0, r4);     // Catch: Throwable -> L8
        r4 = r6.read(r2, 0, 1024);     // Catch: Throwable -> L8
        goto L4
    L6:
        return new String(a(r0.digest()));
    L8:
        return null;
    }

    public static String c(byte[] r2) {
        return new String(a(MessageDigest.getInstance("MD5").digest(r2)));
    L4:
        return null;
    }
}
