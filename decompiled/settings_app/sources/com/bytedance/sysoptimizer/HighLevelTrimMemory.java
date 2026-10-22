package com.bytedance.sysoptimizer;

import android.content.Context;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public class HighLevelTrimMemory {
    private static String TAG = "SYSOPTIMIZER";
    private static boolean mOptimized = false;

    static {
    }

    private static native boolean disable();

    private static boolean loadOptimizerOnNeed(Context r0) {
        return false;
    }

    private HighLevelTrimMemory() {
    }

    public static synchronized boolean optimize(Context r3) {
        monitor-enter(HighLevelTrimMemory.class);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (mOptimized == false) goto L10;
        monitor-exit(HighLevelTrimMemory.class);
        return true;
    L10:
        if (loadOptimizerOnNeed(r3) == true) goto L23;
    L16:
        monitor-exit(HighLevelTrimMemory.class);
        return false;
    L23:
        boolean r4 = disable();     // Catch: UnsatisfiedLinkError -> L14 Throwable -> L19
        mOptimized = r4;     // Catch: UnsatisfiedLinkError -> L14 Throwable -> L19
        monitor-exit(HighLevelTrimMemory.class);
        return r4;
    L14:
        e = move-exception;
        Log.e(TAG, "failed to optimize, UnsatisfiedLinkError", e);     // Catch: Throwable -> L19
        goto L16
    }
}
