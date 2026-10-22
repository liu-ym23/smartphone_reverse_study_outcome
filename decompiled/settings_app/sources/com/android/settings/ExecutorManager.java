package com.android.settings;

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

    public static void execute(Runnable r1) {
        sCachedThreadExecutor.execute(r1);
    }

    public static void execute(Runnable r0, boolean r1) {
        if (r1 == false) goto L4;
        sSingleThreadExecutor.execute(r0);
        return;
    L4:
        execute(r0);
    }
}
