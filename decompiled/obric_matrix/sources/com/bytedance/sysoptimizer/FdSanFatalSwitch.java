package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class FdSanFatalSwitch {
    private static final String TAG = "FdSanFatalSwitch";
    private static volatile boolean mFdSanFatalSwitch = false;

    static {
    }

    public FdSanFatalSwitch() {
    }

    private static boolean loadOptimizerOnNeed(Context r2) {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        return false;
    L5:
        return SysOptimizer.loadOptimizerLibrary(r2);
    }

    private static native void openAndroidQFdsan();

    public static synchronized void openAndroidQFdsan(Context r2) {
        monitor-enter(FdSanFatalSwitch.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (mFdSanFatalSwitch == false) goto L7;
    L9:
        monitor-exit(FdSanFatalSwitch.class);
        return;
    L7:
        if (loadOptimizerOnNeed(r2) == false) goto L9;
        openAndroidQFdsan();     // Catch: Throwable -> L11
        mFdSanFatalSwitch = true;     // Catch: Throwable -> L11
        goto L9
    }
}
