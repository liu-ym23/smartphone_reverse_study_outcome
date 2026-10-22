package com.bytedance.android.sdk.bdticketguard.q1;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.android.sdk.bdticketguard.s0;
import com.bytedance.android.sdk.bdticketguard.z0;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import kotlin.f0;
import kotlin.n0.d.b0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f1048a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Boolean f1049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f1050c = null;

    static {
        f1050c = new a();
    }

    private a() {
    }

    private final String a() {
        BufferedReader r2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L16
        b0 r3 = new b0();     // Catch: Throwable -> L14
        StringBuilder r4 = new StringBuilder();     // Catch: Throwable -> L14
    L5:
        int r5 = r2.read();     // Catch: Throwable -> L14
        r3.f18428f = r5;     // Catch: Throwable -> L14
        if (r5 <= 0) goto L8;
        r4.append((char) r5);     // Catch: Throwable -> L14
        goto L5
    L8:
        String r1 = r4.toString();     // Catch: Throwable -> L14
        r2.close();     // Catch: Exception -> L11
    L13:
        return r1;
    L11:
        e = move-exception;
        s0.f1065a.a("ProcessUtils", "getCurProcessNameFromProc, cmdlineReader.close() error, e=" + Log.getStackTraceString(e));
    L14:
        th = th;
    L34:
        s0.f1065a.c("ProcessUtils", "getCurProcessNameFromProc error", th);     // Catch: Throwable -> L25
        if (r2 != null) goto L38;
    L24:
        return null;
    L38:
        r2.close();     // Catch: Exception -> L22
    L22:
        e = move-exception;
        s0.f1065a.a("ProcessUtils", "getCurProcessNameFromProc, cmdlineReader.close() error, e=" + Log.getStackTraceString(e));
    L25:
        th = move-exception;
        if (r2 != null) goto L36;
    L31:
        throw th;
    L36:
        r2.close();     // Catch: Exception -> L29
    L29:
        e = move-exception;
        s0.f1065a.a("ProcessUtils", "getCurProcessNameFromProc, cmdlineReader.close() error, e=" + Log.getStackTraceString(e));
    L16:
        th = th;
        r2 = null;
        goto L34
    }

    private final String c(Context r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        int r0 = Process.myPid();
        Object r5 = r4.getSystemService("activity");
        if ((r5 instanceof ActivityManager) == true) goto L8;
        r5 = null;
    L8:
        ActivityManager r6 = (ActivityManager) r5;
        if (r6 == null) goto L22;
        List<ActivityManager.RunningAppProcessInfo> r7 = r6.getRunningAppProcesses();
        if (r7 == null) goto L23;
        Iterator<ActivityManager.RunningAppProcessInfo> r8 = r7.iterator();
    L14:
        if (r8.hasNext() == false) goto L24;
        ActivityManager.RunningAppProcessInfo r1 = r8.next();
        if (r1.pid != r0) goto L14;
        return r1.processName;
    L24:
        return null;
    L23:
        return null;
    L22:
        return null;
    }

    @SuppressLint({"DiscouragedPrivateApi", "PrivateApi"})
    private final String d() {
        Method r0 = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L7
        o.b(r0, "Class.forName(\"android.a…hod(\"currentProcessName\")");     // Catch: Throwable -> L7
        r0.setAccessible(true);     // Catch: Throwable -> L7
        Object r1 = r0.invoke(null, new Object[0]);     // Catch: Throwable -> L7
        if ((r1 instanceof String) == false) goto L12;
        return (String) r1;
    L12:
        return null;
    L7:
        th = move-exception;
        s0.f1065a.c("ProcessUtils", "getCurrentProcessNameByActivityThread exception", th);
        return null;
    }

    private final String e() {
        if (Build.VERSION.SDK_INT < 28) goto L12;
        return Application.getProcessName();
    L6:
        e = move-exception;
        s0.f1065a.c("ProcessUtils", "getCurrentProcessNameByApplication exception", e);
        return null;
    L12:
        return null;
    }

    private final String f(Context r2) {
        return r2.getPackageManager().getApplicationInfo(r2.getPackageName(), 128).processName;
    L4:
        th = move-exception;
        String r1 = Log.getStackTraceString(th);
        o.b(r1, "Log.getStackTraceString(e)");
        z0.t(r1);
        return null;
    }

    public final String b(Context r2) {
        o.g(r2, "context");
        if (TextUtils.isEmpty(f1048a) == false) goto L5;
        String r0 = e();
        f1048a = r0;
        if (TextUtils.isEmpty(r0) == false) goto L9;
        String r1 = d();
        f1048a = r1;
        if (TextUtils.isEmpty(r1) == false) goto L13;
        String r3 = a();
        f1048a = r3;
        if (TextUtils.isEmpty(r3) == false) goto L17;
        String r4 = c(r2);
        f1048a = r4;
        return r4;
    L17:
        return f1048a;
    L13:
        return f1048a;
    L9:
        return f1048a;
    L5:
        return f1048a;
    }

    public final boolean g(Context r6) {
        o.g(r6, "context");
        if (f1049b != null) goto L15;
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (f1049b != null) goto L8;
        a r0 = f1050c;     // Catch: Throwable -> L11
        String r1 = r0.b(r6);     // Catch: Throwable -> L11
        String r7 = r0.f(r6);     // Catch: Throwable -> L11
        s0.f1065a.a("ProcessUtils", "curProcessName=" + r1 + ", packageProcessName=" + r7);     // Catch: Throwable -> L11
        f1049b = Boolean.valueOf(TextUtils.equals(r1, r7));     // Catch: Throwable -> L11
    L8:
        f0 r8 = f0.f18324a;     // Catch: Throwable -> L11
        monitor-exit(this);
    L15:
        return o.a(f1049b, Boolean.TRUE);
    }
}
