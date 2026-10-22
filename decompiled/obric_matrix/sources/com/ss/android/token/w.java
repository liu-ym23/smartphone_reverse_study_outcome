package com.ss.android.token;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f12314a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f12315b = false;

    static {
    }

    public static String a(Context r3) {
        if (TextUtils.isEmpty(f12314a) == false) goto L5;
        f12314a = e();
        d.b.s.a.a0.a.a("Process", "getCurProcessName: " + f12314a);
        if (TextUtils.isEmpty(f12314a) == false) goto L9;
        f12314a = d();
        d.b.s.a.a0.a.a("Process", "getCurrentProcessNameByActivityThread: " + f12314a);
        if (TextUtils.isEmpty(f12314a) == false) goto L13;
        f12314a = b();
        d.b.s.a.a0.a.a("Process", "getCurProcessNameFromProc: " + f12314a);
        if (TextUtils.isEmpty(f12314a) == false) goto L17;
        f12314a = c(r3);
        d.b.s.a.a0.a.a("Process", "getCurrentProcessNameByActivityManager: " + f12314a);
        return f12314a;
    L17:
        return f12314a;
    L13:
        return f12314a;
    L9:
        return f12314a;
    L5:
        return f12314a;
    }

    private static String b() {
        BufferedReader r1 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L16
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L14
    L5:
        int r3 = r1.read();     // Catch: Throwable -> L14
        if (r3 <= 0) goto L8;
        r2.append((char) r3);     // Catch: Throwable -> L14
        goto L5
    L8:
        d.b.s.a.a0.a.a("Process", "get processName = " + r2.toString());     // Catch: Throwable -> L14
        String r0 = r2.toString();     // Catch: Throwable -> L14
        r1.close();     // Catch: Exception -> L11
    L13:
        return r0;
    L11:
        e = move-exception;
        o.f(e);
    L14:
        th = th;
    L40:
        o.f(th);     // Catch: Throwable -> L25
        if (r1 != null) goto L32;
    L24:
        return null;
    L32:
        r1.close();     // Catch: Exception -> L22
    L22:
        e = move-exception;
        o.f(e);
    L25:
        th = move-exception;
        if (r1 != null) goto L38;
    L31:
        throw th;
    L38:
        r1.close();     // Catch: Exception -> L29
    L29:
        e = move-exception;
        o.f(e);
    L16:
        th = th;
        r1 = null;
        goto L40
    }

    private static String c(Context r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        int r1 = Process.myPid();
        ActivityManager r5 = (ActivityManager) r4.getSystemService("activity");
        if (r5 == null) goto L16;
        List<ActivityManager.RunningAppProcessInfo> r6 = r5.getRunningAppProcesses();
        if (r6 == null) goto L16;
        Iterator<ActivityManager.RunningAppProcessInfo> r7 = r6.iterator();
    L11:
        if (r7.hasNext() == false) goto L16;
        ActivityManager.RunningAppProcessInfo r2 = r7.next();
        if (r2.pid != r1) goto L11;
        return r2.processName;
    L16:
        return null;
    }

    private static String d() {
        Method r1 = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L7
        r1.setAccessible(true);     // Catch: Throwable -> L7
        Object r2 = r1.invoke(null, new Object[0]);     // Catch: Throwable -> L7
        if ((r2 instanceof String) == false) goto L12;
        return (String) r2;
    L12:
        return null;
    L7:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    private static String e() {
        if (Build.VERSION.SDK_INT < 28) goto L12;
        return Application.getProcessName();
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        return null;
    }

    public static String f(String r3) {
        String r0 = "";
        r0 = new URI(r3).getHost().toLowerCase();     // Catch: Exception -> L7
        Matcher r4 = Pattern.compile("[^\\.]+(\\.com|\\.net|\\.org|\\.cc|\\.me|\\.tel|\\.mobi|\\.asia|\\.biz|\\.info|\\.name|\\.tv|\\.app|\\.edu)").matcher(r0);     // Catch: Exception -> L7
        if (r4.find() == false) goto L21;
        return r4.group();
    L21:
    L17:
        e = move-exception;
        o.f(e);
        return null;
    L10:
        if (TextUtils.isEmpty(r0) == true) goto L25;
        String[] r5 = r0.split("\\.");     // Catch: Exception -> L17
        if (r5 != null) goto L14;
        return null;
    L14:
        if (r5.length <= 1) goto L27;
        return r5[r5.length - 2] + "." + r5[r5.length - 1];
    L27:
        return null;
    L25:
        return null;
    L7:
        e = move-exception;
        o.f(e);
        goto L21
    }

    @NonNull
    public static String g(@Nullable Context r3) {
        if (r3 != null) goto L5;
        return "";
    L5:
        String r1 = f12314a;
        if (com.bytedance.common.utility.k.c(r1) == true) goto L9;
        return r1;
    L9:
        if (f12315b == true) goto L12;
        f12315b = true;
        return a(r3);
    L12:
        return "";
    }

    public static boolean h(String r1, Set<String> r2) {
        if (TextUtils.isEmpty(r1) == true) goto L10;
        if (r2 != null) goto L6;
        return false;
    L6:
        if (r2.isEmpty() == false) goto L9;
        return false;
    L9:
        return i(r1, r2);
    L10:
        return false;
    }

    private static boolean i(String r4, Set<String> r5) {
        Iterator<String> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L17;
        String r0 = r6.next();
        if (TextUtils.isEmpty(r0) == true) goto L4;
        if (r4.equals(r0) == true) goto L10;
        if (r0.startsWith(".") == true) goto L15;
        r0 = "." + r0;
    L15:
        if (r4.endsWith(r0) == false) goto L4;
        return true;
    L10:
        return true;
    L17:
        return false;
    }

    public static boolean j(Context r5) {
        String r0 = a(r5);
        if (TextUtils.isEmpty(r0) == false) goto L14;
        return false;
    L14:
        return r0.equals(r5.getPackageManager().getApplicationInfo(r5.getPackageName(), 128).processName);
    L7:
        th = move-exception;
        d.b.s.a.a0.a.a("Process", "isMainProcess exception" + Log.getStackTraceString(th));
        if (r0.contains(":") == false) goto L11;
        return false;
    L11:
        if (r0.equals(r5.getPackageName()) == false) goto L17;
        return true;
    L17:
        return false;
    }
}
