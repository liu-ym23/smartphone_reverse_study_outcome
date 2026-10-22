package com.bytedance.apm6.memory;

import com.bytedance.apm6.memory.listener.IMemoryDataListener;

/* JADX INFO: loaded from: classes3.dex */
public class ApmMemoryManager {
    private static volatile ApmMemoryManager singleton;

    private ApmMemoryManager() {
    }

    public static ApmMemoryManager getInstance() {
        if (singleton != null) goto L15;
        monitor-enter(ApmMemoryManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (singleton != null) goto L9;
        singleton = new ApmMemoryManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ApmMemoryManager.class);     // Catch: Throwable -> L11
    L15:
        return singleton;
    }

    public void addMemoryDataListener(IMemoryDataListener r1) {
        MemoryCollector.getInstance().addMemoryCallBackListener(r1);
    }

    public void removeMemoryDataListener(IMemoryDataListener r1) {
        MemoryCollector.getInstance().removeMemoryCallBackListener(r1);
    }
}
