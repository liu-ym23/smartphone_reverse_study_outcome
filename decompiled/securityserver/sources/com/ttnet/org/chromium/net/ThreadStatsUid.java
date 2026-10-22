package com.ttnet.org.chromium.net;

import android.net.TrafficStats;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class ThreadStatsUid {
    private static final Method sClearThreadStatsUid = null;
    private static final Method sSetThreadStatsUid = null;

    static {
        sSetThreadStatsUid = TrafficStats.class.getMethod("setThreadStatsUid", new Class[]{Integer.TYPE});     // Catch: Throwable -> L5
        sClearThreadStatsUid = TrafficStats.class.getMethod("clearThreadStatsUid", null);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        throw new RuntimeException("Unable to get TrafficStats methods", e);
    }

    public ThreadStatsUid() {
    }

    public static void clear() {
        sClearThreadStatsUid.invoke(null, null);     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L7
        return;
    L7:
        e = move-exception;
        throw new RuntimeException("TrafficStats.clearThreadStatsUid failed", e);
    L5:
        e = move-exception;
        throw new RuntimeException("TrafficStats.clearThreadStatsUid failed", e);
    }

    public static void set(int r3) {
        sSetThreadStatsUid.invoke(null, new Object[]{Integer.valueOf(r3)});     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L7
        return;
    L7:
        e = move-exception;
        throw new RuntimeException("TrafficStats.setThreadStatsUid failed", e);
    L5:
        e = move-exception;
        throw new RuntimeException("TrafficStats.setThreadStatsUid failed", e);
    }
}
