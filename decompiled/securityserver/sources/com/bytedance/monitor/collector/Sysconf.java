package com.bytedance.monitor.collector;

import android.system.Os;
import android.system.OsConstants;

/* JADX INFO: loaded from: classes.dex */
public class Sysconf {
    protected static final long DEFAULT_CLOCK_TICKS_PER_SECOND = 100;
    private static long sJiffyMills = -1;
    private static long sValue = -1;

    public Sysconf() {
    }

    private static long fromLibcore(String r4, long r5) {
        int r6 = Class.forName("libcore.io.OsConstants").getField(r4).getInt(null);     // Catch: Throwable -> L4
        Class<?> r1 = Class.forName("libcore.io.Libcore");     // Catch: Throwable -> L4
        Class<?> r2 = Class.forName("libcore.io.Os");     // Catch: Throwable -> L4
        Object r0 = r1.getField("os").get(null);     // Catch: Throwable -> L4
        return ((Long) r2.getMethod("sysconf", new Class[]{Integer.TYPE}).invoke(r0, new Object[]{Integer.valueOf(r6)})).longValue();
    L4:
        th = move-exception;
        th.printStackTrace();
        return r5;
    }

    public static long getJiffyMills() {
        if (sJiffyMills != (-1)) goto L6;
        sJiffyMills = 1000 / getScClkTck();
    L6:
        return sJiffyMills;
    }

    public static long getScClkTck() {
        return getScClkTck(100);
    }

    public static long getScClkTck(long r5) {
        long r0 = sValue;
        if (r0 <= 0) goto L5;
        return r0;
    L5:
        long r1 = Os.sysconf(OsConstants._SC_CLK_TCK);
        if (r1 <= 0) goto L8;
        r5 = r1;
    L8:
        sValue = r5;
        return r5;
    }
}
