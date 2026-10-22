package com.bytedance.apm6.memory;

import com.bytedance.apm6.memory.listener.IMemoryDataListener;

/* JADX INFO: loaded from: classes.dex */
public class ApmMemoryManager {
    private static volatile ApmMemoryManager singleton;

    private ApmMemoryManager() {
    }

    public static ApmMemoryManager getInstance() {
        if (singleton != null) goto L16;
        monitor-enter(ApmMemoryManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (singleton != null) goto L11;
        singleton = new ApmMemoryManager();     // Catch: Throwable -> L9
    L11:
        monitor-exit(ApmMemoryManager.class);     // Catch: Throwable -> L9
    L16:
        return singleton;
    }

    public void addMemoryDataListener(IMemoryDataListener r1) {
        MemoryCollector.getInstance().addMemoryCallBackListener(r1);
    }

    public void removeMemoryDataListener(IMemoryDataListener r1) {
        MemoryCollector.getInstance().removeMemoryCallBackListener(r1);
    }
}
