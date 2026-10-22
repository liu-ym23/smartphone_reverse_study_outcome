package com.bytedance.apm.util;

import android.os.Looper;

/* JADX INFO: loaded from: classes3.dex */
public class ThreadUtils {
    public ThreadUtils() {
    }

    public static boolean isMainThread() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }

    public static void sleepSafely(long r0) {
        Thread.sleep(r0);     // Catch: InterruptedException -> L4
        return;
    }
}
