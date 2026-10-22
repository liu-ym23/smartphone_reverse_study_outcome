package com.bytedance.apm.util;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f2029a;

    static {
    }

    public static Application a(Context r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        if ((r1 instanceof Application) == true) goto L10;
        r1 = r1.getApplicationContext();
    L10:
        return (Application) r1;
    }

    public static String b(int r5) {
        if (TextUtils.isEmpty(f2029a) == true) goto L39;
        return f2029a;
    L39:
        BufferedReader r1 = new BufferedReader(new FileReader("/proc/" + r5 + "/cmdline"));     // Catch: Throwable -> L19
        String r6 = r1.readLine();     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r6) == true) goto L11;
        r6 = r6.trim();     // Catch: Throwable -> L17
    L11:
        f2029a = r6;     // Catch: Throwable -> L17
        r1.close();     // Catch: IOException -> L14
    L16:
        return r6;
    L14:
        e = move-exception;
        e.printStackTrace();
    L17:
        th = th;
    L37:
        th.printStackTrace();     // Catch: Throwable -> L28
        if (r1 != null) goto L41;
    L27:
        return null;
    L41:
        r1.close();     // Catch: IOException -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
    L28:
        th = move-exception;
        if (r1 != null) goto L45;
    L34:
        throw th;
    L45:
        r1.close();     // Catch: IOException -> L32
    L32:
        e = move-exception;
        e.printStackTrace();
    L19:
        th = th;
        r1 = null;
        goto L37
    }

    public static boolean c(Context r3) {
        String r0 = b(Process.myPid());
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
