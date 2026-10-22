package com.bytedance.common.utility.n;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static void a(Closeable r0) {
        if (r0 != null) goto L7;
        return;
    L7:
        r0.close();     // Catch: IOException -> L6
        return;
    }

    public static void b(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return;
    L5:
        File r0 = new File(r1);
        if (r0.exists() == true) goto L8;
        return;
    L8:
        if (r0.isFile() == false) goto L13;
        r0.delete();
        return;
    }

    public static void c(String r7) {
        File r0 = new File(r7);
        if (r0.exists() == true) goto L6;
        return;
    L6:
        if (r0.isFile() == false) goto L9;
        r0.delete();
        return;
    L9:
        String[] r1 = r0.list();
        if (r1 != null) goto L12;
        return;
    L12:
        int r2 = r1.length;
        int r3 = 0;
    L13:
        if (r3 >= r2) goto L28;
        String r4 = r1[r3];
        if (r4 == null) goto L27;
        String r5 = File.separator;
        if (r7.endsWith(r5) == false) goto L20;
        String r6 = r7 + r4;
    L21:
        File r8 = new File(r6);
        if (r8.isFile() == false) goto L25;
        r8.delete();
    L25:
        if (r8.isDirectory() == false) goto L27;
        c(r6);
        goto L27
    L20:
        r6 = r7 + r5 + r4;
    L27:
        r3 = r3 + 1;
        goto L13
    L28:
        r0.delete();
    }

    public static boolean d(String r1, String r2) {
        File r0 = new File(r1);
        File r3 = new File(r2);
        if (r0.exists() == true) goto L7;
        return false;
    L7:
        return r0.renameTo(r3);
    }
}
