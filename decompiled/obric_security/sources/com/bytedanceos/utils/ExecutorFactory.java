package com.bytedanceos.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes2.dex */
public class ExecutorFactory {
    private static int counter;
    private static ExecutorService sDefaultExecutor;
    private static ThreadFactory sFactory;

    public ExecutorFactory() {
    }

    static /* synthetic */ int access$008() {
        int r0 = counter;
        counter = r0 + 1;
        return r0;
    }

    static {
        sFactory = new AnonymousClass1();
    }

    public static Executor getDefaultExecutor() {
        if (sDefaultExecutor != null) goto L6;
        sDefaultExecutor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors(), sFactory);
    L6:
        return sDefaultExecutor;
    }
}
