package tmsdkobf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

/* JADX INFO: loaded from: classes5.dex */
public abstract class kl {
    public static byte[] a(byte[] r2) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        DeflaterOutputStream r1 = new DeflaterOutputStream(r0);
        r1.write(r2);     // Catch: Throwable -> L9 Exception -> L15
        r1.finish();     // Catch: Throwable -> L9 Exception -> L15
        byte[] r3 = r0.toByteArray();     // Catch: Throwable -> L9 Exception -> L15
        r0.close();     // Catch: IOException -> L6
        r1.close();     // Catch: IOException -> L6
    L8:
        return r3;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    L15:
        r0.close();     // Catch: IOException -> L17
        r1.close();     // Catch: IOException -> L17
        return null;
    L9:
        th = move-exception;
        r0.close();     // Catch: IOException -> L12
        r1.close();     // Catch: IOException -> L12
    L14:
        throw th;
    L12:
        e = move-exception;
        e.printStackTrace();
    L17:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static byte[] b(byte[] r4) {
        ByteArrayInputStream r0 = new ByteArrayInputStream(r4);
        InflaterInputStream r5 = new InflaterInputStream(r0);
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();
    L28:
        int r2 = r5.read();     // Catch: Throwable -> L12 Exception -> L18
        if (r2 == (-1)) goto L6;
        r1.write(r2);     // Catch: Throwable -> L12 Exception -> L18
        goto L28
    L6:
        byte[] r3 = r1.toByteArray();     // Catch: Throwable -> L12 Exception -> L18
        r0.close();     // Catch: IOException -> L9
        r5.close();     // Catch: IOException -> L9
        r1.close();     // Catch: IOException -> L9
    L11:
        return r3;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    L18:
        r0.close();     // Catch: IOException -> L20
        r5.close();     // Catch: IOException -> L20
        r1.close();     // Catch: IOException -> L20
        return null;
    L12:
        th = move-exception;
        r0.close();     // Catch: IOException -> L15
        r5.close();     // Catch: IOException -> L15
        r1.close();     // Catch: IOException -> L15
    L17:
        throw th;
    L15:
        e = move-exception;
        e.printStackTrace();
    L20:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
