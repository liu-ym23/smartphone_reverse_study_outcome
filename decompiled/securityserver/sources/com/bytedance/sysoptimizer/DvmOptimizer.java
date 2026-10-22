package com.bytedance.sysoptimizer;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class DvmOptimizer {
    private DvmOptimizer() {
    }

    public static void hookDvmLinearAllocFunc(Context r0) {
        if (loadOptimizerOnNeed(r0) == false) goto L6;
        startHookDvmFunc();
        return;
    }

    private static boolean loadOptimizerOnNeed(Context r0) {
        return false;
    }

    public static void optDvmLinearAllocBuffer(Context r0) {
        if (loadOptimizerOnNeed(r0) == false) goto L6;
        optLinearAllocBuffer();
        return;
    }

    private static native void optLinearAllocBuffer();

    private static native void startHookDvmFunc();
}
