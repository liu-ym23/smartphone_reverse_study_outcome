package com.android.settings.utils;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class ThreadUtils {
    private static volatile Thread sMainThread;
    private static volatile Handler sMainThreadHandler;
    private static volatile ScheduledExecutorService sSingleThreadExecutor;

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

    public static void postOnBackgroundThread(Runnable r1) {
        ensureSingleThreadExecutor();
        sSingleThreadExecutor.execute(r1);
    }

    public static void postOnBackgroundThreadDelayed(Runnable r2, long r3) {
        ensureSingleThreadExecutor();
        sSingleThreadExecutor.schedule(r2, r3, TimeUnit.MILLISECONDS);
    }

    private static void ensureSingleThreadExecutor() {
        if (sSingleThreadExecutor == null) goto L5;
        return;
    L5:
        monitor-enter(ThreadUtils.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sSingleThreadExecutor != null) goto L9;
        sSingleThreadExecutor = Executors.newSingleThreadScheduledExecutor();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ThreadUtils.class);     // Catch: Throwable -> L11
    }

    public static void postOnMainThread(Runnable r1) {
        getUiThreadHandler().post(r1);
    }

    public static void postOnMainThread(Runnable r3, Long r4) {
        getUiThreadHandler().postAtTime(r3, r4.longValue());
    }
}
