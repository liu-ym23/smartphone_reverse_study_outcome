package com.ss.android.k.c;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.k;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"NewApi", "CI_InlinedApi", "CI_NewApi", "InlinedApi"})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f11992a;

    static {
    }

    public static String a(Context r3) {
        String r0 = f11992a;
        if (k.c(r0) == true) goto L19;
        return r0;
    L19:
        int r1 = Process.myPid();     // Catch: Exception -> L15
        Iterator<ActivityManager.RunningAppProcessInfo> r4 = ((ActivityManager) r3.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L15
    L7:
        if (r4.hasNext() == false) goto L17;
        ActivityManager.RunningAppProcessInfo r2 = r4.next();     // Catch: Exception -> L15
        if (r2.pid != r1) goto L7;
        if (Logger.debug() == false) goto L13;
        Logger.d("Process", "processName = " + r2.processName);     // Catch: Exception -> L15
    L13:
        String r5 = r2.processName;     // Catch: Exception -> L15
        f11992a = r5;     // Catch: Exception -> L15
        return r5;
    L17:
        String r6 = b();
        f11992a = r6;
        return r6;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    private static String b() {
        BufferedReader r1 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L14
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L19
    L5:
        int r3 = r1.read();     // Catch: Throwable -> L19
        if (r3 <= 0) goto L9;
        r2.append((char) r3);     // Catch: Throwable -> L19
        goto L5
    L9:
        if (Logger.debug() == false) goto L11;
        Logger.d("Process", "get processName = " + r2.toString());     // Catch: Throwable -> L19
    L11:
        String r0 = r2.toString();     // Catch: Throwable -> L19
        r1.close();     // Catch: Exception -> L18
    L13:
        return r0;
    L15:
        if (r1 != null) goto L25;
    L17:
        return null;
    L25:
        r1.close();     // Catch: Exception -> L20
    L14:
        r1 = null;
        goto L15
    }

    public static boolean c(Context r3) {
        String r0 = a(r3);
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
}
