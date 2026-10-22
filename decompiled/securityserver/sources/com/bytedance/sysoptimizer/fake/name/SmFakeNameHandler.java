package com.bytedance.sysoptimizer.fake.name;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bytedance.sysoptimizer.SysOptimizer;

/* JADX INFO: loaded from: classes.dex */
public class SmFakeNameHandler {
    private static String TAG = "SYSOPTIMIZER";
    private static volatile boolean inited = false;

    public SmFakeNameHandler() {
    }

    private static boolean inAndroid5x() {
        return false;
    }

    private static native void replace(int r0);

    private static boolean shouldFix() {
        if (inAndroid5x() == true) goto L5;
    L7:
        return false;
    L5:
        if (Build.MODEL.startsWith("SM-") == false) goto L7;
        return true;
    }

    public static synchronized void start(Context r3) {
        monitor-enter(SmFakeNameHandler.class);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (shouldFix() == true) goto L9;
        monitor-exit(SmFakeNameHandler.class);
        return;
    L9:
        if (inited == false) goto L13;
        monitor-exit(SmFakeNameHandler.class);
        return;
    L13:
        inited = true;     // Catch: Throwable -> L17
        if (SysOptimizer.loadOptimizerLibrary(r3) == true) goto L30;
    L25:
        monitor-exit(SmFakeNameHandler.class);
        return;
    L30:
        replace(Build.VERSION.SDK_INT);     // Catch: Throwable -> L17 NoSuchMethodError -> L19 UnsatisfiedLinkError -> L21
    L19:
        e = move-exception;
        Log.e(TAG, "NoSuchMethodError", e);     // Catch: Throwable -> L17
    L21:
        e = move-exception;
        Log.e(TAG, "UnsatisfiedLinkError", e);     // Catch: Throwable -> L17
        goto L25
    }
}
