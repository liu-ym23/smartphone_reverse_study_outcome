package com.bytedance.apm.util;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.system.Os;
import android.system.OsConstants;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f2030a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f2031b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f2032c = -1;

    static {
    }

    private static long a(long r8) {
        int r0 = Class.forName("libcore.io.OsConstants").getField("_SC_CLK_TCK").getInt(null);     // Catch: Exception -> L4
        Class<?> r2 = Class.forName("libcore.io.Libcore");     // Catch: Exception -> L4
        Class<?> r3 = Class.forName("libcore.io.Os");     // Catch: Exception -> L4
        Object r1 = r2.getField("os").get(null);     // Catch: Exception -> L4
        return ((Long) r3.getMethod("sysconf", new Class[]{Integer.TYPE}).invoke(r1, new Object[]{Integer.valueOf(r0)})).longValue();
    L7:
        return r8;
    }

    public static long b() {
        return h(Process.myPid());
    }

    public static synchronized int c() {
        monitor-enter(b.class);
        int r1 = f2030a;     // Catch: Throwable -> L26
        if (r1 == 0) goto L8;
        monitor-exit(b.class);
        return r1;
    L8:
        int r2 = 0;
        BufferedReader r3 = new BufferedReader(new FileReader("/proc/cpuinfo"), 50);     // Catch: Throwable -> L18
    L30:
        String r4 = r3.readLine();     // Catch: Throwable -> L16
        if (r4 == null) goto L15;
        if (r4.startsWith("processor") == false) goto L30;
        r2 = r2 + 1;
        goto L30
    L15:
        r3.close();     // Catch: Throwable -> L29
        f2030a = r2;     // Catch: Throwable -> L29
    L16:
        Throwable th = th;
    L20:
        if (r3 == null) goto L42;
        r3.close();     // Catch: Throwable -> L29
        throw th;     // Catch: Throwable -> L29
    L42:
        throw th;     // Catch: Throwable -> L29
    L18:
        th = move-exception;
        r3 = null;
        th = th;
    L23:
        int r5 = f2030a;     // Catch: Throwable -> L26
        monitor-exit(b.class);
        return r5;
    L26:
        th = move-exception;
        throw th;
    }

    public static long d() {
        File r0 = Environment.getRootDirectory();
        return e() + g(r0);
    }

    protected static long e() {
        if ("mounted".equals(Environment.getExternalStorageState()) == false) goto L6;
        return g(e.e(com.bytedance.apm.d.h()));
    L6:
        return 0;
    L11:
        return 0;
    }

    public static long f(File r6) {
        File[] r7 = r6.listFiles();
        long r0 = 0;
        if (r7 != null) goto L5;
        return 0;
    L5:
        int r2 = r7.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L12;
        File r4 = r7[r3];
        if (r4.isDirectory() == false) goto L10;
        long r5 = f(r4);
    L11:
        r0 = r0 + r5;
        r3 = r3 + 1;
        goto L6
    L10:
        r5 = r4.length();
        goto L11
    L12:
        return r0;
    }

    public static long g(File r5) {
        StatFs r0 = new StatFs(r5.getPath());     // Catch: Throwable -> L9
        if (Build.VERSION.SDK_INT < 18) goto L8;
        return r0.getTotalBytes();
    L8:
        return ((long) r0.getBlockCount()) * r0.getBlockSize();
    L9:
        return 0;
    }

    public static long h(int r6) {
        BufferedReader r0 = null;
        BufferedReader r1 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + r6 + "/stat")), 1000);     // Catch: Throwable -> L10
        String r7 = r1.readLine();     // Catch: Throwable -> L7
        r1.close();     // Catch: Throwable -> L7
        String[] r8 = r7.split(" ");     // Catch: Throwable -> L7
        long r2 = ((Long.parseLong(r8[13]) + Long.parseLong(r8[14])) + Long.parseLong(r8[15])) + Long.parseLong(r8[16]);
        d.b.l.a.d.b(r1);
        return r2;
    L7:
        r0 = r1;
    L8:
        d.b.l.a.d.b(r0);
        return -1;
    }

    public static long i() {
        if (f2032c != (-1)) goto L6;
        f2032c = Runtime.getRuntime().maxMemory();     // Catch: Exception -> L7
    L6:
        return f2032c;
    }

    public static long j(long r4) {
        if (f2031b != (-1)) goto L16;
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 21) goto L8;
        long r1 = Os.sysconf(OsConstants._SC_CLK_TCK);
    L12:
        if (r1 <= 0) goto L14;
        r4 = r1;
    L14:
        f2031b = r4;
        goto L16
    L8:
        if (r0 < 14) goto L10;
        r1 = a(r4);
        goto L12
    L10:
        r1 = r4;
    L16:
        return f2031b;
    }

    public static long k() {
        int r0 = c();
        long r1 = -1;
        if (r0 > 0) goto L5;
        return -1;
    L5:
        int r3 = 0;
    L6:
        if (r3 >= r0) goto L26;
        BufferedReader r4 = null;
        BufferedReader r5 = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu" + r3 + "/cpufreq/stats/time_in_state"), 50);     // Catch: Throwable -> L22
    L30:
        String r6 = r5.readLine();     // Catch: Throwable -> L20
        if (r6 != null) goto L12;
    L28:
        r5.close();     // Catch: Throwable -> L27
        r3 = r3 + 1;     // Catch: Throwable -> L27
        goto L6
    L12:
        if (r6.isEmpty() == true) goto L28;
        String[] r7 = r6.split("\\s+");     // Catch: Throwable -> L20
        if (r7.length != 2) goto L30;
        r1 = r1 + Long.parseLong(r7[1]);
    L20:
        th = th;
        r4 = r5;
    L23:
        if (r4 == null) goto L25;
        r4.close();     // Catch: Throwable -> L27
    L25:
        throw th;     // Catch: Throwable -> L27
    L22:
        th = th;
    L26:
        return r1;
    }

    public static long l(Context r7) {
        if (r7 != null) goto L18;
        return -1;
    L18:
    L17:
        return -1;
    L6:
        if (TextUtils.isEmpty(r7.getPackageName()) == false) goto L8;
        return -1;
    L8:
        File r8 = r7.getCacheDir();     // Catch: Throwable -> L17
        long r3 = 0;
        if (r8.exists() == false) goto L11;
        long r5 = f(r8);     // Catch: Throwable -> L17
    L12:
        File r9 = com.bytedance.apm.d.h().getExternalCacheDir();     // Catch: Throwable -> L17
        if (r9.exists() == false) goto L16;
        r3 = f(r9);     // Catch: Throwable -> L17
    L16:
        return r5 + r3;
    L11:
        r5 = 0;
        goto L12
    }

    public static long m(Context r7) {
        if (r7 != null) goto L17;
        return -1;
    L17:
        File r2 = new File(r7.getFilesDir().getParent());     // Catch: Throwable -> L16
        if (r2.exists() == true) goto L8;
        return -1;
    L8:
        long r3 = f(r2);     // Catch: Throwable -> L16
        File r8 = r7.getExternalFilesDir(null);     // Catch: Throwable -> L16
        if (r8 == null) goto L15;
        File r9 = r8.getParentFile();     // Catch: Throwable -> L16
        long r4 = 0;
        if (r9.exists() == false) goto L14;
        r4 = f(r9);     // Catch: Throwable -> L16
    L14:
        return r3 + r4;
    L15:
        return -1;
    }
}
