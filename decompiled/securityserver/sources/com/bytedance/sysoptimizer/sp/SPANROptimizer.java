package com.bytedance.sysoptimizer.sp;

import android.content.Context;
import com.bytedance.services.apm.api.EnsureManager;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class SPANROptimizer {
    private static boolean hasFixed;

    public SPANROptimizer() {
    }

    public static synchronized void fix(Context r3) {
        monitor-enter(SPANROptimizer.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (hasFixed == false) goto L9;
        monitor-exit(SPANROptimizer.class);
        return;
    L9:
        hasFixed = true;     // Catch: Throwable -> L16
        Field r1 = Class.forName("android.app.QueuedWork").getDeclaredField("sFinishers");     // Catch: Throwable -> L12
        r1.setAccessible(true);     // Catch: Throwable -> L12
        r1.set(null, new SPLinkedList());     // Catch: Throwable -> L12
    L14:
        monitor-exit(SPANROptimizer.class);
        return;
    L12:
        th = move-exception;
        EnsureManager.ensureNotReachHere(th, "FIX SP ANR FAIL");     // Catch: Throwable -> L16
        goto L14
    }
}
