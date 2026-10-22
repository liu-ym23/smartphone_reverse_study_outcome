package com.bytedance.platform.godzilla.anr.monitor.idletask;

import com.bytedance.platform.godzilla.anr.monitor.ITaskCostTimeCallback;

/* JADX INFO: loaded from: classes.dex */
public final class IdleHandlerCostTimeMonitor {
    private static IdleHandlerCostTimeMonitor sInstance;
    private ITaskCostTimeCallback mITaskCostTimeCallback;

    private IdleHandlerCostTimeMonitor() {
    }

    public static IdleHandlerCostTimeMonitor getInstance() {
        if (sInstance != null) goto L16;
        monitor-enter(IdleHandlerCostTimeMonitor.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new IdleHandlerCostTimeMonitor();     // Catch: Throwable -> L9
    L11:
        monitor-exit(IdleHandlerCostTimeMonitor.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    public ITaskCostTimeCallback getIdleHandlerCostTimeCallback() {
        return this.mITaskCostTimeCallback;
    }

    public void setIdleHandlerCostTimeCallback(ITaskCostTimeCallback r1) {
        this.mITaskCostTimeCallback = r1;
    }
}
