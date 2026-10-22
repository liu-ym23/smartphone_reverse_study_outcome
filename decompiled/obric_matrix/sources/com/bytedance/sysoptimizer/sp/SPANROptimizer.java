package com.bytedance.sysoptimizer.sp;

import android.content.Context;
import android.os.Build;
import com.bytedance.services.apm.api.EnsureManager;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class SPANROptimizer {
    private static boolean hasFixed;

    public SPANROptimizer() {
    }

    public static synchronized void fix(Context r5) {
        monitor-enter(SPANROptimizer.class);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (hasFixed == false) goto L9;
        monitor-exit(SPANROptimizer.class);
        return;
    L9:
        hasFixed = true;     // Catch: Throwable -> L20
        Class<?> r1 = Class.forName("android.app.QueuedWork");     // Catch: Throwable -> L16
        if (Build.VERSION.SDK_INT < 26) goto L14;
        Field r2 = r1.getDeclaredField("sFinishers");     // Catch: Throwable -> L16
        r2.setAccessible(true);     // Catch: Throwable -> L16
        Object r0 = new SPLinkedList();     // Catch: Throwable -> L16
    L13:
        r2.set(null, r0);     // Catch: Throwable -> L16
    L18:
        monitor-exit(SPANROptimizer.class);
        return;
    L14:
        r2 = r1.getDeclaredField("sPendingWorkFinishers");     // Catch: Throwable -> L16
        r2.setAccessible(true);     // Catch: Throwable -> L16
        r0 = new SPConcurrentLinkedQueue();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        EnsureManager.ensureNotReachHere(th, "FIX SP ANR FAIL");     // Catch: Throwable -> L20
        goto L18
    }
}
