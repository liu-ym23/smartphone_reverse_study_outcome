package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class HighLevelTrimMemory {
    private static String TAG = "SYSOPTIMIZER";
    private static boolean mOptimized = false;

    static {
    }

    private HighLevelTrimMemory() {
    }

    private static native boolean disable();

    private static boolean loadOptimizerOnNeed(Context r2) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 21) goto L5;
        return false;
    L5:
        if (r0 <= 29) goto L8;
        return false;
    L8:
        return SysOptimizer.loadOptimizerLibrary(r2);
    }

    public static synchronized boolean optimize(Context r3) {
        monitor-enter(HighLevelTrimMemory.class);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (mOptimized == false) goto L10;
        boolean r4 = true;
    L7:
        monitor-exit(HighLevelTrimMemory.class);
        return r4;
    L10:
        if (loadOptimizerOnNeed(r3) == true) goto L21;
    L16:
        r4 = false;
        goto L7
    L21:
        boolean r5 = disable();     // Catch: UnsatisfiedLinkError -> L14 Throwable -> L17
        mOptimized = r5;     // Catch: UnsatisfiedLinkError -> L14 Throwable -> L17
        monitor-exit(HighLevelTrimMemory.class);
        return r5;
    L14:
        e = move-exception;
        Log.e(TAG, "failed to optimize, UnsatisfiedLinkError", e);     // Catch: Throwable -> L17
        goto L16
    }
}
