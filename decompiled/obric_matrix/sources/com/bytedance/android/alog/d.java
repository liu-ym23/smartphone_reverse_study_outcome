package com.bytedance.android.alog;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import java.io.BufferedReader;
import java.io.FileReader;

/* JADX INFO: loaded from: classes.dex */
class d {
    static String a(Context r2) {
        String r3 = r2.getPackageManager().getPackageInfo(r2.getPackageName(), 0).versionName;     // Catch: Exception -> L4
    L6:
        if (TextUtils.isEmpty(r3) == false) goto L11;
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L11:
        return r3;
    L4:
        r3 = null;
        goto L6
    }

    static String b(Context r4) {
        BufferedReader r0 = new BufferedReader(new FileReader("/proc/self/cmdline"));     // Catch: Throwable -> L14 Exception -> L19
        String r1 = r0.readLine();     // Catch: Throwable -> L12 Exception -> L26
        if (TextUtils.isEmpty(r1) == true) goto L27;
        String r2 = r1.trim();     // Catch: Throwable -> L12 Exception -> L26
        if (TextUtils.isEmpty(r2) == true) goto L27;
        r0.close();     // Catch: Exception -> L23
    L9:
        return r2;
    L27:
        r0.close();     // Catch: Exception -> L24
    L22:
        return null;
    L12:
        Throwable th = th;
    L16:
        if (r0 != null) goto L29;
    L18:
        throw th;
    L29:
        r0.close();     // Catch: Exception -> L25
    L20:
        if (r0 == null) goto L22;
    L19:
        r0 = null;
    L14:
        th = move-exception;
        r0 = null;
        th = th;
        goto L16
    }
}
