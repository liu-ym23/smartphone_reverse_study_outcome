package tmsdkobf;

import android.content.Context;
import com.qq.taf.jce.JceStruct;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import tmsdk.common.tcc.TccCryptor;

/* JADX INFO: loaded from: classes5.dex */
public abstract class e3 {
    public static byte[] a(Context r1, byte[] r2, byte[] r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r3.length == 0) goto L16;
        byte[] r4 = TccCryptor.decrypt(r3, r2);     // Catch: Exception -> L12
        if (r4 != null) goto L11;
        return null;
    L11:
        return b(r4);
    L17:
        return null;
    L16:
        return null;
    }

    private static byte[] b(byte[] r4) {
        ByteArrayInputStream r0 = new ByteArrayInputStream(r4);
        InflaterInputStream r5 = new InflaterInputStream(r0);
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();
    L29:
        int r2 = r5.read();     // Catch: Throwable -> L12 IOException -> L14
        if (r2 == (-1)) goto L6;
        r1.write(r2);     // Catch: Throwable -> L12 IOException -> L14
        goto L29
    L6:
        byte[] r3 = r1.toByteArray();     // Catch: Throwable -> L12 IOException -> L14
        r0.close();     // Catch: IOException -> L9
        r5.close();     // Catch: IOException -> L9
        r1.close();     // Catch: IOException -> L9
    L11:
        return r3;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    L14:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L12
        r0.close();     // Catch: IOException -> L18
        r5.close();     // Catch: IOException -> L18
        r1.close();     // Catch: IOException -> L18
        return null;
    L18:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        th = move-exception;
        r0.close();     // Catch: IOException -> L24
        r5.close();     // Catch: IOException -> L24
        r1.close();     // Catch: IOException -> L24
    L26:
        throw th;
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L26
    }

    public static JceStruct a(Context r2, byte[] r3, byte[] r4, JceStruct r5, boolean r6) {
        if (r4 != null) goto L5;
    L12:
        return null;
    L5:
        if (r4.length == 0) goto L12;
        byte[] r7 = a(r2, r3, r4);
        if (r7 != null) goto L11;
        return null;
    L11:
        return z7.a(r7, r5, r6);
    }

    public static JceStruct a(byte[] r2, byte[] r3, JceStruct r4) {
        return a(null, r2, r3, r4, false);
    }

    private static byte[] a(byte[] r2) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        DeflaterOutputStream r1 = new DeflaterOutputStream(r0);
        r1.write(r2);     // Catch: Throwable -> L9 IOException -> L11
        r1.finish();     // Catch: Throwable -> L9 IOException -> L11
        byte[] r3 = r0.toByteArray();     // Catch: Throwable -> L9 IOException -> L11
    L30:
        r0.close();     // Catch: IOException -> L6
        r1.close();     // Catch: IOException -> L6
    L8:
        return r3;
    L6:
        e = move-exception;
        e.printStackTrace();
    L9:
        th = move-exception;
        r0.close();     // Catch: IOException -> L21
        r1.close();     // Catch: IOException -> L21
    L23:
        throw th;
    L21:
        e = move-exception;
        e.printStackTrace();
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L9
        r0.close();     // Catch: IOException -> L15
        r1.close();     // Catch: IOException -> L15
        return null;
    L15:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static byte[] a(Context r0, byte[] r1, JceStruct r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        byte[] r3 = a(r2);
        if (r3 != null) goto L9;
        return null;
    L9:
        return TccCryptor.encrypt(r3, r1);
    }

    public static byte[] a(byte[] r1, JceStruct r2) {
        return a(null, r1, r2);
    }

    public static int a(String r0, String r1) {
        if (r0 != null) goto L6;
        if (r1 != null) goto L6;
        return 0;
    L6:
        if (r0 != null) goto L9;
        return -1;
    L9:
        if (r1 != null) goto L13;
        return 1;
    L13:
        return r0.compareTo(r1);
    }

    public static byte[] a(JceStruct r1) {
        if (r1 != null) goto L5;
        return null;
    L5:
        byte[] r2 = a(z7.a(r1));
        if (r2 != null) goto L8;
        return null;
    L8:
        return r2;
    }
}
