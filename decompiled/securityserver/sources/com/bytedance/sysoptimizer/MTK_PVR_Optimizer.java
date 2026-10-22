package com.bytedance.sysoptimizer;

import android.content.Context;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class MTK_PVR_Optimizer {
    private static String TAG = "SYSOPTIMIZER";
    private static boolean mOptimized = false;
    private static boolean sAlwaysCatchSIGSEGV = false;
    private static boolean sCatchSIGSEGV = false;

    public MTK_PVR_Optimizer() {
    }

    public static synchronized void enable(Context r3) {
        monitor-enter(MTK_PVR_Optimizer.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (mOptimized == false) goto L9;
        monitor-exit(MTK_PVR_Optimizer.class);
        return;
    L9:
        if (loadOptimizerOnNeed(r3) == true) goto L29;
    L24:
        monitor-exit(MTK_PVR_Optimizer.class);
        return;
    L29:
    L18:
        e = move-exception;
        Log.e(TAG, "UnsatisfiedLinkError", e);     // Catch: Throwable -> L16
        goto L24
    L11:
        if (sAlwaysCatchSIGSEGV == false) goto L13;
    L20:
        boolean r4 = true;
    L21:
        setCatchOption(r4);     // Catch: Throwable -> L16 UnsatisfiedLinkError -> L18
        optimize();     // Catch: Throwable -> L16 UnsatisfiedLinkError -> L18
        mOptimized = true;     // Catch: Throwable -> L16 UnsatisfiedLinkError -> L18
    L13:
        if (sCatchSIGSEGV == true) goto L20;
        r4 = false;
        goto L21
    }

    private static boolean loadOptimizerOnNeed(Context r0) {
        return false;
    }

    private static native void optimize();

    public static synchronized void setAlwaysCatchSIGSEGV(boolean r2) {
        monitor-enter(MTK_PVR_Optimizer.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (sAlwaysCatchSIGSEGV != r2) goto L8;
        monitor-exit(MTK_PVR_Optimizer.class);
        return;
    L8:
        sAlwaysCatchSIGSEGV = r2;     // Catch: Throwable -> L15
        if (mOptimized == false) goto L19;
        if (r2 == false) goto L12;
    L17:
        boolean r3 = true;
    L18:
        setCatchOption(r3);     // Catch: Throwable -> L15
        goto L19
    L12:
        if (sCatchSIGSEGV == true) goto L17;
        r3 = false;
    L19:
        monitor-exit(MTK_PVR_Optimizer.class);
    }

    private static native void setCatchOption(boolean r0);

    public static synchronized void setCatchSIGSEGV(boolean r2) {
        monitor-enter(MTK_PVR_Optimizer.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (sCatchSIGSEGV != r2) goto L8;
        monitor-exit(MTK_PVR_Optimizer.class);
        return;
    L8:
        sCatchSIGSEGV = r2;     // Catch: Throwable -> L18
        if (mOptimized == true) goto L11;
    L20:
        monitor-exit(MTK_PVR_Optimizer.class);
        return;
    L11:
        if (sAlwaysCatchSIGSEGV == true) goto L15;
        if (r2 == true) goto L15;
        boolean r3 = false;
    L16:
        setCatchOption(r3);     // Catch: Throwable -> L18
    L15:
        r3 = true;
        goto L16
    }
}
