package com.bytedance.monitor.collector;

import android.os.Build;
import android.system.Os;
import android.system.OsConstants;

/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f5220a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f5221b = -1;

    static {
    }

    private static long a(String r7, long r8) {
        int r9 = Class.forName("libcore.io.OsConstants").getField(r7).getInt(null);     // Catch: Throwable -> L4
        Class<?> r1 = Class.forName("libcore.io.Libcore");     // Catch: Throwable -> L4
        Class<?> r2 = Class.forName("libcore.io.Os");     // Catch: Throwable -> L4
        Object r0 = r1.getField("os").get(null);     // Catch: Throwable -> L4
        return ((Long) r2.getMethod("sysconf", new Class[]{Integer.TYPE}).invoke(r0, new Object[]{Integer.valueOf(r9)})).longValue();
    L4:
        th = move-exception;
        th.printStackTrace();
        return r8;
    }

    public static long b() {
        if (f5221b != (-1)) goto L6;
        f5221b = 1000 / c();
    L6:
        return f5221b;
    }

    public static long c() {
        return d(100);
    }

    public static long d(long r5) {
        long r0 = f5220a;
        if (r0 <= 0) goto L5;
        return r0;
    L5:
        int r1 = Build.VERSION.SDK_INT;
        if (r1 < 21) goto L9;
        long r2 = Os.sysconf(OsConstants._SC_CLK_TCK);
    L13:
        if (r2 <= 0) goto L15;
        r5 = r2;
    L15:
        f5220a = r5;
        return r5;
    L9:
        if (r1 < 14) goto L11;
        r2 = a("_SC_CLK_TCK", r5);
        goto L13
    L11:
        r2 = r5;
        goto L13
    }
}
