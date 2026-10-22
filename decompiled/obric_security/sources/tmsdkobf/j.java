package tmsdkobf;

import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public abstract class j {
    public static void a(Closeable r0) {
        if (r0 == null) goto L8;
        r0.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public static long a(InputStream r5, OutputStream r6) {
        byte[] r0 = new byte[4096];
        long r1 = 0;
    L3:
        int r3 = r5.read(r0);
        if ((-1) == r3) goto L6;
        r6.write(r0, 0, r3);
        r1 = r1 + ((long) r3);
        goto L3
    L6:
        return r1;
    }
}
