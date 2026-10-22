package tmsdkobf;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import tmsdk.common.TMSDKContext;
import tmsdk.common.tcc.TccCryptor;

/* JADX INFO: loaded from: classes5.dex */
public abstract class mg {
    private static nf a(Context r4, String r5, String r6) {
        nf r0 = new nf();
        FileInputStream r1 = null;
        String r7 = z4.a(r4, r5, null);
        if (r7 != null) goto L5;
    L25:
        return r0;
    L5:
        if (r7.length() == 0) goto L25;
        File r8 = new File(r7);
        if (r8.exists() == true) goto L29;
        return r0;
    L29:
        FileInputStream r9 = new FileInputStream(r8);     // Catch: Throwable -> L27
        v4 r10 = w4.a(r9);     // Catch: Throwable -> L22
        byte[] r2 = new byte[r9.available()];     // Catch: Throwable -> L22
        r9.read(r2);     // Catch: Throwable -> L22
        if (c3.a(x8.a(r2)).equals(c3.a(r10.c)) == false) goto L34;
        byte[] r11 = TccCryptor.decrypt(r2, null);     // Catch: Throwable -> L22
        if (r6 != null) goto L18;
    L20:
        r0.a(r11);     // Catch: Throwable -> L22
        r9.close();     // Catch: Throwable -> L28
    L31:
        goto L25
    L18:
        if (r6.length() <= 0) goto L20;
        r0.c(r6);     // Catch: Throwable -> L22
        goto L20
    L34:
        r9.close();     // Catch: Throwable -> L26
    L14:
        return r0;
    L22:
        r1 = r9;
    L23:
        if (r1 == null) goto L25;
        r1.close();     // Catch: Throwable -> L28
        goto L31
    }

    private static nf b(Context r3, String r4, String r5) {
        nf r0 = new nf();
        Context r1 = TMSDKContext.getCurrentContext();
        if (r1 == null) goto L20;
        r3 = r1;
    L20:
        InputStream r6 = r3.getResources().getAssets().open(r4, 1);     // Catch: IOException -> L17
        v4 r7 = w4.a(r6);     // Catch: IOException -> L17
        byte[] r2 = new byte[r6.available()];     // Catch: IOException -> L17
        r6.read(r2);     // Catch: IOException -> L17
        if (c3.a(x8.a(r2)).equals(c3.a(r7.c)) == true) goto L10;
        return r0;
    L10:
        byte[] r8 = TccCryptor.decrypt(r2, null);     // Catch: IOException -> L17
        if (r5 != null) goto L13;
    L15:
        r0.a(r8);     // Catch: IOException -> L17
        return r0;
    L13:
        if (r5.length() <= 0) goto L15;
        r0.c(r5);     // Catch: IOException -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static Object a(Context r0, String r1, String r2, Object r3, String r4) {
        if (r1 == null) goto L16;
        if (r2 != null) goto L14;
        return r3;
    L14:
        Object r5 = a(r0, r1, r4).c(r2, r3);     // Catch: Exception -> L8
    L10:
        if (r5 != null) goto L13;
        return r3;
    L13:
        return r5;
    L8:
        e = move-exception;
        e.printStackTrace();
        q8.b("deepclean", "head error::" + e.toString());
        r5 = r3;
        goto L10
    L16:
        return r3;
    }

    public static Object b(Context r2, String r3, String r4, Object r5, String r6) {
        if (r3 == null) goto L20;
        if (r4 == null) goto L21;
        nf r0 = a(r2, r3, r6);
        if (r0 != null) goto L8;
    L9:
        r0 = b(r2, r3, r6);
    L18:
        Object r7 = r0.c(r4, r5);     // Catch: Exception -> L12
    L14:
        if (r7 != null) goto L17;
        return r5;
    L17:
        return r7;
    L12:
        e = move-exception;
        e.printStackTrace();
        r7 = r5;
        goto L14
    L8:
        if (r0.c() == false) goto L18;
    L21:
        return r5;
    L20:
        return r5;
    }
}
