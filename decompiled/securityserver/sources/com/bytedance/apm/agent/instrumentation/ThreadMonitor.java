package com.bytedance.apm.agent.instrumentation;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.util.AppUtils;
import com.bytedance.apm.util.ThreadUtils;

/* JADX INFO: loaded from: classes.dex */
public class ThreadMonitor {
    private static final String TAG = "ThreadMonitor";

    public ThreadMonitor() {
    }

    private static boolean isDebuggable() {
        return AppUtils.isDebug(ApmContext.getContext());
    }

    private static boolean isLocalChannel() {
        return ApmContext.isLocalChannel();
    }

    public static void sleepMonitor(long r2) {
        if (ThreadUtils.isMainThread() == true) goto L5;
    L9:
        Thread.sleep(r2);
        return;
    L5:
        if (r2 <= 10) goto L9;
        if (isDebuggable() == true) goto L9;
        isLocalChannel();
        goto L9
    }
}
