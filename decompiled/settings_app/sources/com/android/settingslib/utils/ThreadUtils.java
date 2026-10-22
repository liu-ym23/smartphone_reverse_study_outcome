package com.android.settingslib.utils;

import android.os.Handler;
import android.os.Looper;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class ThreadUtils {
    private static volatile ListeningExecutorService sListeningService;
    private static volatile Thread sMainThread;
    private static volatile Handler sMainThreadHandler;

    public ThreadUtils() {
    }

    public static boolean isMainThread() {
        if (sMainThread != null) goto L6;
        sMainThread = Looper.getMainLooper().getThread();
    L6:
        if (Thread.currentThread() != sMainThread) goto L8;
        return true;
    L8:
        return false;
    }

    public static Handler getUiThreadHandler() {
        if (sMainThreadHandler != null) goto L6;
        sMainThreadHandler = new Handler(Looper.getMainLooper());
    L6:
        return sMainThreadHandler;
    }

    public static void ensureMainThread() {
        if (isMainThread() == false) goto L6;
        return;
    L6:
        throw new RuntimeException("Must be called on the UI thread");
    }

    public static ListenableFuture postOnBackgroundThread(Runnable r1) {
        return getBackgroundExecutor().submit(r1);
    }

    public static <T> ListenableFuture<T> postOnBackgroundThread(Callable<T> r1) {
        return getBackgroundExecutor().submit(r1);
    }

    @Deprecated
    public static void postOnMainThread(Runnable r1) {
        getUiThreadHandler().post(r1);
    }

    public static synchronized ListeningExecutorService getBackgroundExecutor() {
        monitor-enter(ThreadUtils.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sListeningService != null) goto L7;
        sListeningService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()));     // Catch: Throwable -> L10
    L7:
        ListeningExecutorService r1 = sListeningService;     // Catch: Throwable -> L10
        monitor-exit(ThreadUtils.class);
        return r1;
    }
}
