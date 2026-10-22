package com.bytedance.android.sdk.bdticketguard.n1;

import android.os.Process;
import com.bytedance.android.sdk.bdticketguard.s0;
import kotlin.f0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class j {
    public static final void a(kotlin.n0.c.a<f0> r6) {
        o.g(r6, "func");
        int r1 = Process.myTid();
        Integer r2 = null;
        r2 = Integer.valueOf(Process.getThreadPriority(r1));     // Catch: Throwable -> L5
        Process.setThreadPriority(r1, r2.intValue() - 1);     // Catch: Throwable -> L5
    L7:
        r6.invoke();
        if (r2 == null) goto L18;
        Process.setThreadPriority(r1, r2.intValue());     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        s0.f1065a.c("InitTaskManager", "restoreThreadPriority failed", th);
        return;
    L18:
        return;
    L5:
        th = move-exception;
        s0.f1065a.c("InitTaskManager", "setThreadPriority failed", th);
        goto L7
    }
}
