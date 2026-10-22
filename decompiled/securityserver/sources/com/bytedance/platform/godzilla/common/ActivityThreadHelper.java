package com.bytedance.platform.godzilla.common;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.platform.godzilla.utils.MethodUtils;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityThreadHelper {
    private static final long WAIT_TIME = 5000;
    private static Object sActivityThread;
    private static Class sClassForActivityThread;

    private ActivityThreadHelper() {
    }

    public static /* synthetic */ Object access$002(Object r0) {
        sActivityThread = r0;
        return r0;
    }

    public static /* synthetic */ Class access$100() {
        return sClassForActivityThread;
    }

    public static Object currentActivityThread() {
        if (sActivityThread != null) goto L37;
        monitor-enter(ActivityThreadHelper.class);     // Catch: Exception -> L34
    L11:
        th = move-exception;
        throw th;     // Catch: Exception -> L34
    L7:
        if (sActivityThread != null) goto L15;
        if (sClassForActivityThread != null) goto L13;
        sClassForActivityThread = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L11
    L13:
        sActivityThread = MethodUtils.invokeStaticMethod(sClassForActivityThread, "currentActivityThread", new Object[0]);     // Catch: Throwable -> L11
    L15:
        if (sActivityThread == null) goto L17;
    L30:
        monitor-exit(ActivityThreadHelper.class);     // Catch: Throwable -> L11
        goto L37
    L17:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L30;
        final Object r1 = new Object();     // Catch: Throwable -> L11
        new Handler(Looper.getMainLooper()).post(new AnonymousClass1(r1));     // Catch: Throwable -> L11
        if (sActivityThread != null) goto L30;
        monitor-enter(r1);     // Catch: Throwable -> L11
        r1.wait(5000);     // Catch: Throwable -> L24 InterruptedException -> L38
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L26:
        monitor-exit(r1);     // Catch: Throwable -> L24
    L34:
        e = move-exception;
        e.printStackTrace();
    L37:
        return sActivityThread;
    }
}
