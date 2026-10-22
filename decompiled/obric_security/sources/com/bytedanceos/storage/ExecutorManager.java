package com.bytedanceos.storage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class ExecutorManager {
    private static ExecutorService sCachedThreadExecutor;
    private static ExecutorService sSingleThreadExecutor;

    public ExecutorManager() {
    }

    static {
        sCachedThreadExecutor = Executors.newCachedThreadPool();
        sSingleThreadExecutor = Executors.newSingleThreadExecutor();
    }

    public static void execute(Runnable runnable) {
        sCachedThreadExecutor.execute(runnable);
    }

    public static void execute(Runnable runnable, boolean inSingleThreadPool) {
        if (inSingleThreadPool == false) goto L4;
        sSingleThreadExecutor.execute(runnable);
        return;
    L4:
        execute(runnable);
    }
}
