package com.bytedance.sysoptimizer;

import android.content.Context;
import android.util.Log;
import com.bytedance.librarian.Librarian;
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
    L11:
        th = move-exception;
        throw th;
    L5:
        if (mOptimzerLibLoaded == true) goto L7;
    L16:
        monitor-exit(SysOptimizer.class);
        return;
    L7:
        if (mHookRefreshed == true) goto L16;
        refreshHook();     // Catch: Throwable -> L11 UnsatisfiedLinkError -> L13
        mHookRefreshed = true;     // Catch: Throwable -> L11 UnsatisfiedLinkError -> L13
    L14:
        monitor-exit(SysOptimizer.class);
        return;
    L13:
        Log.e(TAG, "refresh xhook failed.");     // Catch: Throwable -> L11
        goto L14
    }

    public static boolean loadOptimizerLibrary(Context r4) {
        if (mOptimzerLibLoaded == false) goto L6;
        return true;
    L6:
        monitor-enter(SysOptimizer.class);
    L11:
        th = move-exception;
        throw th;
    L8:
        if (mOptimzerLibLoaded == false) goto L33;
        monitor-exit(SysOptimizer.class);     // Catch: Throwable -> L11
        return true;
    L33:
        if (r4 != null) goto L20;
        System.loadLibrary("sysoptimizer");     // Catch: Throwable -> L11 OverlappingFileLockException -> L16 UnsatisfiedLinkError -> L18
    L21:
        Log.d(TAG, "load SYSOPTIMIZER success");     // Catch: Throwable -> L11 OverlappingFileLockException -> L16 UnsatisfiedLinkError -> L18
        mOptimzerLibLoaded = true;     // Catch: Throwable -> L11 OverlappingFileLockException -> L16 UnsatisfiedLinkError -> L18
        monitor-exit(SysOptimizer.class);     // Catch: Throwable -> L11
        return true;
    L20:
        Librarian.loadLibraryForModule("sysoptimizer", r4);     // Catch: Throwable -> L11 OverlappingFileLockException -> L16 UnsatisfiedLinkError -> L18
    L18:
        e = move-exception;
        Log.e(TAG, "failed to load SYSOPTIMIZER");     // Catch: Throwable -> L11
        Log.e(TAG, "", e);     // Catch: Throwable -> L11
        mLoadError.add(e);     // Catch: Throwable -> L11
        return false;
    L16:
        e = move-exception;
        Log.e(TAG, "failed to load so caused by OverlappingFileLockException:", e);     // Catch: Throwable -> L11
        return false;
    }

    private static native void refreshHook();
}
