package com.bytedance.sysoptimizer;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class FdSanFatalSwitch {
    private static final String TAG = "FdSanFatalSwitch";
    private static volatile boolean mFdSanFatalSwitch = false;

    public FdSanFatalSwitch() {
    }

    private static boolean loadOptimizerOnNeed(Context r0) {
        return SysOptimizer.loadOptimizerLibrary(r0);
    }

    private static native void openAndroidQFdsan();

    public static synchronized void openAndroidQFdsan(Context r2) {
        monitor-enter(FdSanFatalSwitch.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (mFdSanFatalSwitch == false) goto L7;
    L12:
        monitor-exit(FdSanFatalSwitch.class);
        return;
    L7:
        if (loadOptimizerOnNeed(r2) == false) goto L12;
        openAndroidQFdsan();     // Catch: Throwable -> L10
        mFdSanFatalSwitch = true;     // Catch: Throwable -> L10
        goto L12
    }
}
