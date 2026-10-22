package com.bytedance.sysoptimizer;

import android.content.Context;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public class MTK_PVR_Optimizer {
    private static String TAG = "SYSOPTIMIZER";
    private static boolean mOptimized = false;
    private static boolean sAlwaysCatchSIGSEGV = false;
    private static boolean sCatchSIGSEGV = false;

    static {
    }

    private static boolean loadOptimizerOnNeed(Context r0) {
        return false;
    }

    private static native void optimize();

    private static native void setCatchOption(boolean r0);

    public MTK_PVR_Optimizer() {
    }

    public static synchronized void setCatchSIGSEGV(boolean r2) {
        monitor-enter(MTK_PVR_Optimizer.class);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (sCatchSIGSEGV != r2) goto L8;
        monitor-exit(MTK_PVR_Optimizer.class);
        return;
    L8:
        sCatchSIGSEGV = r2;     // Catch: Throwable -> L19
        if (mOptimized == true) goto L11;
    L17:
        monitor-exit(MTK_PVR_Optimizer.class);
        return;
    L11:
        if (sAlwaysCatchSIGSEGV == true) goto L15;
        if (r2 == true) goto L15;
        boolean r3 = false;
    L16:
        setCatchOption(r3);     // Catch: Throwable -> L19
    L15:
        r3 = true;
        goto L16
    }

    public static synchronized void setAlwaysCatchSIGSEGV(boolean r2) {
        monitor-enter(MTK_PVR_Optimizer.class);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (sAlwaysCatchSIGSEGV != r2) goto L8;
        monitor-exit(MTK_PVR_Optimizer.class);
        return;
    L8:
        sAlwaysCatchSIGSEGV = r2;     // Catch: Throwable -> L19
        if (mOptimized == false) goto L17;
        if (r2 == false) goto L12;
    L15:
        boolean r3 = true;
    L16:
        setCatchOption(r3);     // Catch: Throwable -> L19
        goto L17
    L12:
        if (sCatchSIGSEGV == true) goto L15;
        r3 = false;
    L17:
        monitor-exit(MTK_PVR_Optimizer.class);
    }

    public static synchronized void enable(Context r3) {
        monitor-enter(MTK_PVR_Optimizer.class);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (mOptimized == false) goto L9;
        monitor-exit(MTK_PVR_Optimizer.class);
        return;
    L9:
        if (loadOptimizerOnNeed(r3) == true) goto L26;
    L21:
        monitor-exit(MTK_PVR_Optimizer.class);
        return;
    L26:
    L19:
        e = move-exception;
        Log.e(TAG, "UnsatisfiedLinkError", e);     // Catch: Throwable -> L23
        goto L21
    L11:
        if (sAlwaysCatchSIGSEGV == false) goto L13;
    L16:
        boolean r4 = true;
    L17:
        setCatchOption(r4);     // Catch: UnsatisfiedLinkError -> L19 Throwable -> L23
        optimize();     // Catch: UnsatisfiedLinkError -> L19 Throwable -> L23
        mOptimized = true;     // Catch: UnsatisfiedLinkError -> L19 Throwable -> L23
    L13:
        if (sCatchSIGSEGV == true) goto L16;
        r4 = false;
        goto L17
    }
}
