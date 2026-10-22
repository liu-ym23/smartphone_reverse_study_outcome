package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class DvmOptimizer {
    private DvmOptimizer() {
    }

    public static void hookDvmLinearAllocFunc(Context r0) {
        if (loadOptimizerOnNeed(r0) == false) goto L6;
        startHookDvmFunc();
        return;
    }

    private static boolean loadOptimizerOnNeed(Context r2) {
        if (Build.VERSION.SDK_INT <= 19) goto L5;
        return false;
    L5:
        return SysOptimizer.loadOptimizerLibrary(r2);
    }

    public static void optDvmLinearAllocBuffer(Context r0) {
        if (loadOptimizerOnNeed(r0) == false) goto L6;
        optLinearAllocBuffer();
        return;
    }

    private static native void optLinearAllocBuffer();

    private static native void startHookDvmFunc();
}
