package com.bytedance.platform.godzilla.anr.monitor.idletask;

import com.bytedance.platform.godzilla.anr.monitor.ITaskCostTimeCallback;

/* JADX INFO: loaded from: classes3.dex */
public final class IdleHandlerCostTimeMonitor {
    private static IdleHandlerCostTimeMonitor sInstance;
    private ITaskCostTimeCallback mITaskCostTimeCallback;

    private IdleHandlerCostTimeMonitor() {
    }

    public static IdleHandlerCostTimeMonitor getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(IdleHandlerCostTimeMonitor.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new IdleHandlerCostTimeMonitor();     // Catch: Throwable -> L11
    L9:
        monitor-exit(IdleHandlerCostTimeMonitor.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public void setIdleHandlerCostTimeCallback(ITaskCostTimeCallback r1) {
        this.mITaskCostTimeCallback = r1;
    }

    public ITaskCostTimeCallback getIdleHandlerCostTimeCallback() {
        return this.mITaskCostTimeCallback;
    }
}
