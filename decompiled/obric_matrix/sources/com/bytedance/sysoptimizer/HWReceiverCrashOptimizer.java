package com.bytedance.sysoptimizer;

import android.content.ContextWrapper;
import android.os.Build;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class HWReceiverCrashOptimizer {
    private static volatile boolean sHasFix;

    public HWReceiverCrashOptimizer() {
    }

    public static void fix(ContextWrapper r4) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 == 22) goto L7;
        if (r0 == 23) goto L7;
        return;
    L7:
        monitor-enter(HWReceiverCrashOptimizer.class);
    L16:
        th = move-exception;
        throw th;
    L9:
        if (sHasFix == false) goto L12;
        monitor-exit(HWReceiverCrashOptimizer.class);     // Catch: Throwable -> L16
        return;
    L12:
        sHasFix = true;     // Catch: Throwable -> L16
        Field r2 = Class.forName("android.app.ContextImpl").getDeclaredField("mPackageInfo");     // Catch: Exception -> L19 Throwable -> L16
        r2.setAccessible(true);     // Catch: Exception -> L19 Throwable -> L16
        Object r5 = r2.get(r4.getBaseContext());     // Catch: Exception -> L19 Throwable -> L16
        Field r3 = Class.forName("android.app.LoadedApk").getDeclaredField("mReceiverResource");     // Catch: Exception -> L19 Throwable -> L16
        r3.setAccessible(true);     // Catch: Exception -> L19 Throwable -> L16
        r3.set(r5, null);     // Catch: Exception -> L19 Throwable -> L16
    L14:
        monitor-exit(HWReceiverCrashOptimizer.class);     // Catch: Throwable -> L16
    }
}
