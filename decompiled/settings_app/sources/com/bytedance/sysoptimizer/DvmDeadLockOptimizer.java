package com.bytedance.sysoptimizer;

import android.content.Context;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public class DvmDeadLockOptimizer {
    private static String TAG = "SYSOPTIMIZER";
    private static boolean mOptimized = false;

    static {
    }

    private static boolean loadOptimizerOnNeed(Context r0) {
        return false;
    }

    private static native boolean optimize();

    private DvmDeadLockOptimizer() {
    }

    public static synchronized boolean optimize(Context r3) {
        monitor-enter(DvmDeadLockOptimizer.class);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (mOptimized == false) goto L10;
        monitor-exit(DvmDeadLockOptimizer.class);
        return true;
    L10:
        if (loadOptimizerOnNeed(r3) == true) goto L23;
    L16:
        monitor-exit(DvmDeadLockOptimizer.class);
        return false;
    L23:
        boolean r4 = optimize();     // Catch: UnsatisfiedLinkError -> L14 Throwable -> L19
        mOptimized = r4;     // Catch: UnsatisfiedLinkError -> L14 Throwable -> L19
        monitor-exit(DvmDeadLockOptimizer.class);
        return r4;
    L14:
        e = move-exception;
        Log.e(TAG, "failed to optimize, UnsatisfiedLinkError", e);     // Catch: Throwable -> L19
        goto L16
    }
}
