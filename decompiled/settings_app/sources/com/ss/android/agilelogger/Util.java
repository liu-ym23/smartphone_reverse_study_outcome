package com.ss.android.agilelogger;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;

/* JADX INFO: loaded from: classes5.dex */
public class Util {
    public Util() {
    }

    public static boolean isMainThread() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isMainProcess(Context r4) {
        String r0 = getProcessName(r4);
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.contains(":") == false) goto L9;
        return false;
    L9:
        if (r0.equals(r4.getPackageName()) == false) goto L12;
        return true;
    L12:
        if (r0.equals(r4.getApplicationInfo().processName) == false) goto L14;
        return true;
    L14:
        return false;
    }

    private static String getProcessName(Context r4) {
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
