package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class DvmDeadLockOptimizer {
    private static String TAG = "SYSOPTIMIZER";
    private static boolean mOptimized = false;

    static {
    }

    private DvmDeadLockOptimizer() {
    }

    private static boolean loadOptimizerOnNeed(Context r2) {
        if (Build.VERSION.SDK_INT == 19) goto L7;
        return false;
    L7:
        return SysOptimizer.loadOptimizerLibrary(r2);
    }

    private static native boolean optimize();

    public static synchronized boolean optimize(Context r3) {
        monitor-enter(DvmDeadLockOptimizer.class);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (mOptimized == false) goto L10;
        boolean r4 = true;
    L7:
        monitor-exit(DvmDeadLockOptimizer.class);
        return r4;
    L10:
        if (loadOptimizerOnNeed(r3) == true) goto L21;
    L16:
        r4 = false;
        goto L7
    L21:
        boolean r5 = optimize();     // Catch: UnsatisfiedLinkError -> L14 Throwable -> L17
        mOptimized = r5;     // Catch: UnsatisfiedLinkError -> L14 Throwable -> L17
        monitor-exit(DvmDeadLockOptimizer.class);
        return r5;
    L14:
        e = move-exception;
        Log.e(TAG, "failed to optimize, UnsatisfiedLinkError", e);     // Catch: Throwable -> L17
        goto L16
    }
}
