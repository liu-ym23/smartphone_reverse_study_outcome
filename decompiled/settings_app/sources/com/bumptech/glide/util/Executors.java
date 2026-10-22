package com.bumptech.glide.util;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class Executors {
    private static final Executor DIRECT_EXECUTOR = null;
    private static final Executor MAIN_THREAD_EXECUTOR = null;

    private Executors() {
    }

    static {
        MAIN_THREAD_EXECUTOR = new AnonymousClass1();
        DIRECT_EXECUTOR = new AnonymousClass2();
    }

    public static Executor mainThreadExecutor() {
        return MAIN_THREAD_EXECUTOR;
    }

    public static Executor directExecutor() {
        return DIRECT_EXECUTOR;
    }

    public static void shutdownAndAwaitTermination(ExecutorService r3) {
        r3.shutdownNow();
    L11:
        e = move-exception;
        r3.shutdownNow();
        Thread.currentThread().interrupt();
        throw new RuntimeException(e);
    L4:
        if (r3.awaitTermination(5, TimeUnit.SECONDS) == true) goto L10;
        r3.shutdownNow();     // Catch: InterruptedException -> L11
        if (r3.awaitTermination(5, TimeUnit.SECONDS) == false) goto L9;
        return;
    L9:
        throw new RuntimeException("Failed to shutdown");     // Catch: InterruptedException -> L11
    }
}
