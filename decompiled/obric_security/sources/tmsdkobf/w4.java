package tmsdkobf;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public abstract class w4 {
    public static v4 a(InputStream r3) {
        v4 r0 = new v4();
        byte[] r1 = new byte[4];
        r3.read(r1);     // Catch: IOException -> L5
        r0.f569a = c3.b(r1);     // Catch: IOException -> L5
        r3.read(r1);     // Catch: IOException -> L5
        r0.b = c3.b(r1);     // Catch: IOException -> L5
        byte[] r2 = new byte[16];     // Catch: IOException -> L5
        r3.read(r2);     // Catch: IOException -> L5
        r0.c = r2;     // Catch: IOException -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }
}
