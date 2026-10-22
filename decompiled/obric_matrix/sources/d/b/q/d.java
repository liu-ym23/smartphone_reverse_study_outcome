package d.b.q;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static byte[] a(File r1, int r2) {
        Map<Integer, ByteBuffer> r3 = b(r1);
        if (r3 != null) goto L5;
        return null;
    L5:
        ByteBuffer r4 = r3.get(Integer.valueOf(r2));
        if (r4 != null) goto L9;
        return null;
    L9:
        return c(r4);
    }

    private static Map<Integer, ByteBuffer> b(File r3) {
        Map<Integer, ByteBuffer> r0 = null;
        RandomAccessFile r1 = new RandomAccessFile(r3, "r");     // Catch: Throwable -> L15 IOException -> L22
        FileChannel r4 = r1.getChannel();     // Catch: Throwable -> L12 IOException -> L14
        r0 = a.f(a.b(r4).a());     // Catch: Throwable -> L10 IOException -> L32
        if (r4 != null) goto L41;
    L8:
        r1.close();     // Catch: Throwable -> L29
        goto L27
    L41:
        r4.close();     // Catch: IOException -> L28 Throwable -> L29
        goto L8
    L10:
        th = th;
    L17:
        if (r4 != null) goto L37;
    L19:
        if (r1 == null) goto L48;
        r1.close();     // Catch: IOException -> L31 Throwable -> L29
        throw th;     // Catch: Throwable -> L29
    L49:
        throw th;     // Catch: Throwable -> L29
    L48:
        throw th;     // Catch: Throwable -> L29
    L37:
        r4.close();     // Catch: IOException -> L30 Throwable -> L29
    L23:
        if (r4 != null) goto L39;
    L25:
        if (r1 == null) goto L27;
    L39:
        r4.close();     // Catch: IOException -> L33 Throwable -> L29
        goto L25
    L14:
        r4 = null;
    L12:
        th = th;
        r4 = null;
        goto L17
    L22:
        r4 = null;
        r1 = null;
    L15:
        th = th;
        r4 = null;
        r1 = null;
    L27:
        return r0;
    }

    private static byte[] c(ByteBuffer r3) {
        byte[] r0 = r3.array();
        int r1 = r3.arrayOffset();
        return Arrays.copyOfRange(r0, r3.position() + r1, r1 + r3.limit());
    }

    public static String d(File r2, int r3) {
        byte[] r4 = a(r2, r3);
        if (r4 != null) goto L10;
        return null;
    L10:
        return new String(r4, "UTF-8");
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
