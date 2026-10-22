package com.bytedanceos.cloud;

import android.content.Context;
import com.obric.olog.OLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class SecurityPackageWhiteListFile {
    private static final String FILE_NAME = "memory_clean_whitelist.json";
    public static final String TAG = "SecurityPackageWhiteListFile";

    public SecurityPackageWhiteListFile() {
    }

    public static void writeToFile(Context context, String jsonData) {
        FileOutputStream r2 = null;
        File r3 = new File(context.getFilesDir() + "/memory_clean_whitelist.json");     // Catch: Throwable -> L14 Exception -> L16
        if (r3.exists() == true) goto L6;
        r3.createNewFile();     // Catch: Throwable -> L14 Exception -> L16
    L6:
        FileOutputStream r5 = new FileOutputStream(r3);     // Catch: Throwable -> L14 Exception -> L16
        r5.write(jsonData.getBytes());     // Catch: Throwable -> L10 Exception -> L12
        r5.flush();     // Catch: Throwable -> L10 Exception -> L12
        r5.close();     // Catch: Exception -> L24
    L26:
        return;
    L12:
        e = move-exception;
        r2 = r5;
        e = e;
    L17:
        OLog.d(TAG, "write cloud json exception=" + e);     // Catch: Throwable -> L14
        if (r2 == null) goto L35;
        r2.close();     // Catch: Exception -> L24
        goto L26
    L35:
        return;
    L10:
        th = move-exception;
        r2 = r5;
        th = th;
    L21:
        if (r2 != null) goto L31;
    L23:
        throw th;
    L31:
        r2.close();     // Catch: Exception -> L25
    L16:
        e = e;
    L36:
        return;
    L14:
        th = th;
        goto L21
    }

    public static String getFromFile(Context r5) {
        StringBuilder r1 = new StringBuilder("");
        FileInputStream r2 = null;
        FileInputStream r3 = null;
        File r4 = new File(r5.getFilesDir() + "/memory_clean_whitelist.json");     // Catch: Throwable -> L18 Exception -> L20
        if (r4.exists() == true) goto L6;
        return null;
    L6:
        FileInputStream r6 = new FileInputStream(r4);     // Catch: Throwable -> L18 Exception -> L20
        byte[] r0 = new byte[1024];     // Catch: Throwable -> L14 Exception -> L16
        int r7 = r6.read(r0);     // Catch: Throwable -> L14 Exception -> L16
    L9:
        if (r7 <= 0) goto L12;
        r1.append(new String(r0, 0, r7));     // Catch: Throwable -> L14 Exception -> L16
        r7 = r6.read(r0);     // Catch: Throwable -> L14 Exception -> L16
    L12:
        r6.close();     // Catch: Exception -> L29
        r2 = r7;
    L31:
    L16:
        e = e;
        r3 = r6;
    L21:
        OLog.d(TAG, "read cloud json exception=" + e);     // Catch: Throwable -> L18
        r2 = r3;
        if (r3 == null) goto L31;
        r3.close();     // Catch: Exception -> L29
        r2 = r3;
    L14:
        th = th;
        r2 = r6;
    L26:
        if (r2 != null) goto L34;
    L28:
        throw th;
    L34:
        r2.close();     // Catch: Exception -> L30
    L18:
        th = th;
    L20:
        e = e;
    L25:
        return r1.toString();
    }
}
