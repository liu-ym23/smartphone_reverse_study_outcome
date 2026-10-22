package com.bytedance.platform.godzilla.launch.safe;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
final class CrashRecord {
    private static final String TAG = "CrashRecord";
    private static volatile CrashRecord instance;
    private SharedPreferences mSharedPreferences;

    private CrashRecord(Application r3) {
        this.mSharedPreferences = r3.getSharedPreferences("godzilla_launch_safe", 0);
    }

    public static String crashKeyGenerator(Thread r2, Throwable r3) {
        boolean r4 = "main".equals(r2.getName());
        StringBuilder r0 = new StringBuilder();
        r0.append(r4);
        r0.append("_");
        r0.append(r3.getClass().getName());
        r0.append("_");
        r0.append(r3.getMessage());
        r0.append("_");
        StackTraceElement[] r5 = r3.getStackTrace();
        if (r5 == null) goto L8;
        if (r5.length <= 0) goto L8;
        r0.append(r5[0].getClassName());
        r0.append(r5[0].getMethodName());
    L8:
        return r0.toString();
    }

    public static CrashRecord getInstance(Application r2) {
        if (instance != null) goto L16;
        monitor-enter(CrashRecord.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L11;
        instance = new CrashRecord(r2);     // Catch: Throwable -> L9
    L11:
        monitor-exit(CrashRecord.class);     // Catch: Throwable -> L9
    L16:
        return instance;
    }

    public synchronized void clearCrashCount() {
        monitor-enter(this);
        this.mSharedPreferences.edit().clear().apply();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @SuppressLint({"ApplySharedPref"})
    public synchronized int crashCountIncrement(Thread r4, Throwable r5) {
        monitor-enter(this);
        int r0 = getCrashCount(r4, r5) + 1;     // Catch: Throwable -> L6
        int r1 = getTotalCrashCount() + 1;     // Catch: Throwable -> L6
        this.mSharedPreferences.edit().putInt(crashKeyGenerator(r4, r5), r0).putInt("total_crash_count", r1).commit();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int getCrashCount(Thread r3, Throwable r4) {
        monitor-enter(this);
        int r5 = this.mSharedPreferences.getInt(crashKeyGenerator(r3, r4), 0);     // Catch: Throwable -> L7
        Log.i(TAG, "get crash count=" + r5);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r5;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized int getTotalCrashCount() {
        monitor-enter(this);
        int r1 = this.mSharedPreferences.getInt("total_crash_count", 0);     // Catch: Throwable -> L7
        Log.i(TAG, "get crash count=" + r1);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
