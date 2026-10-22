package com.bytedance.apm.util;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class AppUtils {
    private static Boolean sDebuglabel;
    public static boolean sIsMainProcess;
    public static String sProcessName;

    static {
    }

    public AppUtils() {
    }

    public static Application getApplication(Context r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        if ((r1 instanceof Application) == true) goto L10;
        r1 = r1.getApplicationContext();
    L10:
        return (Application) r1;
    }

    public static String getProcessName(int r5) {
        if (TextUtils.isEmpty(sProcessName) == true) goto L39;
        return sProcessName;
    L39:
        BufferedReader r2 = new BufferedReader(new FileReader("/proc/" + r5 + "/cmdline"));     // Catch: Throwable -> L19
        String r6 = r2.readLine();     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r6) == true) goto L11;
        r6 = r6.trim();     // Catch: Throwable -> L17
    L11:
        sProcessName = r6;     // Catch: Throwable -> L17
        r2.close();     // Catch: IOException -> L14
    L16:
        return r6;
    L14:
        e = move-exception;
        e.printStackTrace();
    L17:
        th = th;
    L37:
        th.printStackTrace();     // Catch: Throwable -> L28
        if (r2 != null) goto L41;
    L27:
        return null;
    L41:
        r2.close();     // Catch: IOException -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
    L28:
        th = move-exception;
        if (r2 != null) goto L45;
    L34:
        throw th;
    L45:
        r2.close();     // Catch: IOException -> L32
    L32:
        e = move-exception;
        e.printStackTrace();
    L19:
        th = th;
        r2 = null;
        goto L37
    }

    public static boolean isMainProcess(Context r3) {
        String r0 = getProcessName(Process.myPid());
        if (r0 != null) goto L5;
    L7:
        if (r0 != null) goto L9;
        return false;
    L9:
        if (r0.equals(r3.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r0.contains(":") == false) goto L7;
        return false;
    }

    public static boolean isDebug(Context r1) {
        Boolean r0 = sDebuglabel;
        if (r0 == null) goto L7;
        return r0.booleanValue();
    L7:
        if (r1 != null) goto L16;
        return false;
    L16:
    L15:
        return false;
    L10:
        if ((r1.getApplicationInfo().flags & 2) == 0) goto L12;
        boolean r2 = true;
    L13:
        Boolean r3 = Boolean.valueOf(r2);     // Catch: Exception -> L15
        sDebuglabel = r3;     // Catch: Exception -> L15
        return r3.booleanValue();
    L12:
        r2 = false;
        goto L13
    }
}
