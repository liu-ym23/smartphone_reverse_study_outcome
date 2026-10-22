package com.bytedance.sysoptimizer.fake.name;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bytedance.sysoptimizer.SysOptimizer;

/* JADX INFO: loaded from: classes.dex */
public class SmFakeNameHandler {
    private static String TAG = "SYSOPTIMIZER";
    private static volatile boolean inited = false;

    static {
    }

    public SmFakeNameHandler() {
    }

    private static boolean inAndroid5x() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 != 22) goto L5;
    L8:
        return true;
    L5:
        if (r0 == 21) goto L8;
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
    L25:
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
        inited = true;     // Catch: Throwable -> L25
        if (SysOptimizer.loadOptimizerLibrary(r3) == true) goto L29;
    L23:
        monitor-exit(SmFakeNameHandler.class);
        return;
    L29:
        replace(Build.VERSION.SDK_INT);     // Catch: NoSuchMethodError -> L17 UnsatisfiedLinkError -> L20 Throwable -> L25
    L20:
        e = e;
        String r1 = TAG;     // Catch: Throwable -> L25
        String r2 = "UnsatisfiedLinkError";
    L19:
        Log.e(r1, r2, e);     // Catch: Throwable -> L25
    L17:
        e = e;
        r1 = TAG;     // Catch: Throwable -> L25
        r2 = "NoSuchMethodError";
        goto L19
    }
}
