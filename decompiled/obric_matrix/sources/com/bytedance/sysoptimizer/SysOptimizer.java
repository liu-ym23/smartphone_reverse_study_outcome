package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import d.b.j.a;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class SysOptimizer {
    private static final String TAG = "SYSOPTIMIZER";
    private static boolean mHookRefreshed = false;
    private static ArrayList<UnsatisfiedLinkError> mLoadError = null;
    private static volatile boolean mOptimzerLibLoaded = false;

    static {
        mLoadError = new ArrayList();
        mHookRefreshed = false;
    }

    public SysOptimizer() {
    }

    public static ArrayList<UnsatisfiedLinkError> getLoadLibraryError() {
        return mLoadError;
    }

    public static synchronized void hookOptimizerEnable() {
        monitor-enter(SysOptimizer.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (mOptimzerLibLoaded == true) goto L7;
    L14:
        monitor-exit(SysOptimizer.class);
        return;
    L7:
        if (mHookRefreshed == true) goto L14;
        refreshHook();     // Catch: UnsatisfiedLinkError -> L11 Throwable -> L16
        mHookRefreshed = true;     // Catch: UnsatisfiedLinkError -> L11 Throwable -> L16
    L12:
        monitor-exit(SysOptimizer.class);
        return;
    L11:
        Log.e(TAG, "refresh xhook failed.");     // Catch: Throwable -> L16
        goto L12
    }

    public static boolean loadOptimizerLibrary(Context r5) {
        int r0 = Build.VERSION.SDK_INT;
        if (mOptimzerLibLoaded == false) goto L6;
        return true;
    L6:
        monitor-enter(SysOptimizer.class);
    L30:
        th = move-exception;
        throw th;
    L8:
        if (mOptimzerLibLoaded == false) goto L34;
        monitor-exit(SysOptimizer.class);     // Catch: Throwable -> L30
        return true;
    L34:
        if (r5 != null) goto L16;
        if (r0 > 17) goto L15;
        System.loadLibrary("npth_dl");     // Catch: OverlappingFileLockException -> L22 UnsatisfiedLinkError -> L26 Throwable -> L30
    L15:
        System.loadLibrary("sysoptimizer");     // Catch: OverlappingFileLockException -> L22 UnsatisfiedLinkError -> L26 Throwable -> L30
    L19:
        Log.d(TAG, "load SYSOPTIMIZER success");     // Catch: OverlappingFileLockException -> L22 UnsatisfiedLinkError -> L26 Throwable -> L30
        mOptimzerLibLoaded = true;     // Catch: OverlappingFileLockException -> L22 UnsatisfiedLinkError -> L26 Throwable -> L30
        monitor-exit(SysOptimizer.class);     // Catch: Throwable -> L30
        return true;
    L16:
        if (r0 > 17) goto L18;
        a.b("npth_dl", r5);     // Catch: OverlappingFileLockException -> L22 UnsatisfiedLinkError -> L26 Throwable -> L30
    L18:
        a.b("sysoptimizer", r5);     // Catch: OverlappingFileLockException -> L22 UnsatisfiedLinkError -> L26 Throwable -> L30
    L26:
        e = move-exception;
        Log.e(TAG, "failed to load SYSOPTIMIZER");     // Catch: Throwable -> L30
        Log.e(TAG, "", e);     // Catch: Throwable -> L30
        mLoadError.add(e);     // Catch: Throwable -> L30
        return false;
    L22:
        e = move-exception;
        Log.e(TAG, "failed to load so caused by OverlappingFileLockException:", e);     // Catch: Throwable -> L30
        return false;
    }

    private static native void refreshHook();
}
