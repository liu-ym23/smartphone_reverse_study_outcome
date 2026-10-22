package com.bytedance.sysoptimizer;

import android.content.Context;
import android.util.Log;
import com.bytedance.librarian.Librarian;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class SysOptimizer {
    private static final String TAG = "SYSOPTIMIZER";
    private static boolean mHookRefreshed = false;
    private static ArrayList<UnsatisfiedLinkError> mLoadError = null;
    private static volatile boolean mOptimzerLibLoaded = false;

    private static native void refreshHook();

    public SysOptimizer() {
    }

    static {
        mLoadError = new ArrayList();
        mHookRefreshed = false;
    }

    public static boolean loadOptimizerLibrary(Context r4) {
        if (mOptimzerLibLoaded == false) goto L6;
        return true;
    L6:
        monitor-enter(SysOptimizer.class);
    L26:
        th = move-exception;
        throw th;
    L8:
        if (mOptimzerLibLoaded == false) goto L30;
        monitor-exit(SysOptimizer.class);     // Catch: Throwable -> L26
        return true;
    L30:
        if (r4 != null) goto L14;
        System.loadLibrary("sysoptimizer");     // Catch: OverlappingFileLockException -> L18 UnsatisfiedLinkError -> L22 Throwable -> L26
    L15:
        Log.d(TAG, "load SYSOPTIMIZER success");     // Catch: OverlappingFileLockException -> L18 UnsatisfiedLinkError -> L22 Throwable -> L26
        mOptimzerLibLoaded = true;     // Catch: OverlappingFileLockException -> L18 UnsatisfiedLinkError -> L22 Throwable -> L26
        monitor-exit(SysOptimizer.class);     // Catch: Throwable -> L26
        return true;
    L14:
        Librarian.loadLibraryForModule("sysoptimizer", r4);     // Catch: OverlappingFileLockException -> L18 UnsatisfiedLinkError -> L22 Throwable -> L26
    L22:
        e = move-exception;
        Log.e(TAG, "failed to load SYSOPTIMIZER");     // Catch: Throwable -> L26
        Log.e(TAG, "", e);     // Catch: Throwable -> L26
        mLoadError.add(e);     // Catch: Throwable -> L26
        return false;
    L18:
        e = move-exception;
        Log.e(TAG, "failed to load so caused by OverlappingFileLockException:", e);     // Catch: Throwable -> L26
        return false;
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
}
