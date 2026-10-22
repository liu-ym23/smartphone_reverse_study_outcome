package tmsdkobf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

/* JADX INFO: loaded from: classes5.dex */
public abstract class oi {
    public static byte[] a(byte[] r2) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        DeflaterOutputStream r1 = new DeflaterOutputStream(r0);
        r1.write(r2);     // Catch: Throwable -> L6 Exception -> L9
        r1.finish();     // Catch: Throwable -> L6 Exception -> L9
        byte[] r3 = r0.toByteArray();     // Catch: Throwable -> L6 Exception -> L9
        r0.close();     // Catch: IOException -> L12
        r1.close();     // Catch: IOException -> L12
    L5:
        return r3;
    L9:
        r0.close();     // Catch: IOException -> L14
        r1.close();     // Catch: IOException -> L14
        return null;
    L6:
        th = move-exception;
        r0.close();     // Catch: IOException -> L13
        r1.close();     // Catch: IOException -> L13
    L8:
        throw th;
    L22:
        return null;
    }

    public static byte[] b(byte[] r5) {
        ByteArrayInputStream r0 = new ByteArrayInputStream(r5);
        InflaterInputStream r1 = new InflaterInputStream(r0);
        ByteArrayOutputStream r2 = new ByteArrayOutputStream();
        byte[] r6 = new byte[r5.length];     // Catch: Throwable -> L10 Exception -> L13
        int r3 = r1.read(r6);     // Catch: Throwable -> L10 Exception -> L13
    L5:
        if (r3 == (-1)) goto L7;
        r2.write(r6, 0, r3);     // Catch: Throwable -> L10 Exception -> L13
        r3 = r1.read(r6);     // Catch: Throwable -> L10 Exception -> L13
        goto L5
    L7:
        byte[] r7 = r2.toByteArray();     // Catch: Throwable -> L10 Exception -> L13
        r0.close();     // Catch: IOException -> L16
        r1.close();     // Catch: IOException -> L16
        r2.close();     // Catch: IOException -> L16
    L9:
        return r7;
    L13:
        r0.close();     // Catch: IOException -> L18
        r1.close();     // Catch: IOException -> L18
        r2.close();     // Catch: IOException -> L18
        return null;
    L10:
        th = move-exception;
        r0.close();     // Catch: IOException -> L17
        r1.close();     // Catch: IOException -> L17
        r2.close();     // Catch: IOException -> L17
    L12:
        throw th;
    L27:
        return null;
    }
}
