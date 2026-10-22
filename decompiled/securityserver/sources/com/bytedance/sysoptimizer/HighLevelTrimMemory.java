package com.bytedance.sysoptimizer;

import android.content.Context;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class HighLevelTrimMemory {
    private static String TAG = "SYSOPTIMIZER";
    private static boolean mOptimized = false;

    private HighLevelTrimMemory() {
    }

    private static native boolean disable();

    private static boolean loadOptimizerOnNeed(Context r0) {
        return false;
    }

    public static synchronized boolean optimize(Context r3) {
        monitor-enter(HighLevelTrimMemory.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (mOptimized == false) goto L10;
        monitor-exit(HighLevelTrimMemory.class);
        return true;
    L10:
        if (loadOptimizerOnNeed(r3) == true) goto L23;
    L18:
        monitor-exit(HighLevelTrimMemory.class);
        return false;
    L23:
        boolean r4 = disable();     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
        mOptimized = r4;     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
        monitor-exit(HighLevelTrimMemory.class);
        return r4;
    L16:
        e = move-exception;
        Log.e(TAG, "failed to optimize, UnsatisfiedLinkError", e);     // Catch: Throwable -> L14
        goto L18
    }
}
