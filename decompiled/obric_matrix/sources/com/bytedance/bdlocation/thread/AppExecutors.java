package com.bytedance.bdlocation.thread;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class AppExecutors {
    private static volatile AppExecutors instance;
    private final Executor DISK_IO;
    private final Executor MAIN_THREAD;
    private final Executor NETWORK_IO;

    /* JADX INFO: renamed from: com.bytedance.bdlocation.thread.AppExecutors$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class MainThreadExecutor implements Executor {
        private Handler mMainThreadHandler;

        private MainThreadExecutor() {
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        }

        /* synthetic */ MainThreadExecutor(AnonymousClass1 r1) {
            this();
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable r1) {
            this.mMainThreadHandler.post(r1);
        }
    }

    private AppExecutors(Executor r1, Executor r2, Executor r3) {
        this.DISK_IO = r1;
        this.NETWORK_IO = r2;
        this.MAIN_THREAD = r3;
    }

    public static AppExecutors getInstance() {
        if (instance != null) goto L15;
        monitor-enter(AppExecutors.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new AppExecutors(Executors.newSingleThreadExecutor(), LocationFixedThreadPool.newFixedThreadPool(3), new MainThreadExecutor(null));     // Catch: Throwable -> L11
    L9:
        monitor-exit(AppExecutors.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    public Executor diskIO() {
        return this.DISK_IO;
    }

    public boolean isMainThread() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }

    public Executor mainThread() {
        return this.MAIN_THREAD;
    }

    public Executor networkIO() {
        return this.NETWORK_IO;
    }
}
