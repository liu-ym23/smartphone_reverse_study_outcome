package com.bytedance.common.wschannel.utils;

import com.bytedance.common.utility.Logger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class WsAsyncIOTaskManager {
    private static final String TAG = "WsAsyncIOTaskManager";
    private static WsAsyncIOTaskManager sInstance;
    private ConcurrentHashMap<WsAsyncTask, ScheduledFuture> mFutureTasks;
    private ConcurrentHashMap<WsAsyncTask, Runnable> mRunnableTasks;
    private ScheduledThreadPoolExecutor mTaskExecutor;

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.utils.WsAsyncIOTaskManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class InnerRunnable implements Runnable {
        private WsAsyncTask task;
        final /* synthetic */ WsAsyncIOTaskManager this$0;

        public /* synthetic */ InnerRunnable(WsAsyncIOTaskManager r1, WsAsyncTask r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        @Override // java.lang.Runnable
        public void run() {
            long r2 = System.currentTimeMillis();     // Catch: Throwable -> L7
            this.task.run();     // Catch: Throwable -> L7
            if (Logger.debug() == false) goto L10;
            Logger.d(WsAsyncIOTaskManager.access$100(), "Task execute time: " + (System.currentTimeMillis() - r2));     // Catch: Throwable -> L7
        L10:
            if (this.task.isLoop() == true) goto L16;
        L11:
            WsAsyncIOTaskManager.access$200(this.this$0).remove(this.task);
            WsAsyncIOTaskManager.access$300(this.this$0).remove(this.task);
            return;
        L16:
            return;
        L7:
            th = move-exception;
            Logger.e(WsAsyncIOTaskManager.access$100(), "thread " + Thread.currentThread().getName() + " exception", th);     // Catch: Throwable -> L17
            if (this.task.isLoop() == false) goto L11;
            return;
        L17:
            th = move-exception;
            if (this.task.isLoop() == true) goto L21;
            WsAsyncIOTaskManager.access$200(this.this$0).remove(this.task);
            WsAsyncIOTaskManager.access$300(this.this$0).remove(this.task);
        L21:
            throw th;
        }

        private InnerRunnable(WsAsyncIOTaskManager r1, WsAsyncTask r2) {
            this.this$0 = r1;
            this.task = r2;
        }
    }

    private WsAsyncIOTaskManager() {
        this.mFutureTasks = new ConcurrentHashMap();
        this.mRunnableTasks = new ConcurrentHashMap();
        this.mTaskExecutor = new ScheduledThreadPoolExecutor(1, new WsThreadFactory("frontier"));
    }

    public static /* synthetic */ String access$100() {
        return TAG;
    }

    public static /* synthetic */ ConcurrentHashMap access$200(WsAsyncIOTaskManager r0) {
        return r0.mFutureTasks;
    }

    public static /* synthetic */ ConcurrentHashMap access$300(WsAsyncIOTaskManager r0) {
        return r0.mRunnableTasks;
    }

    public static WsAsyncIOTaskManager getInstance() {
        if (sInstance != null) goto L16;
        monitor-enter(WsAsyncIOTaskManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new WsAsyncIOTaskManager();     // Catch: Throwable -> L9
    L11:
        monitor-exit(WsAsyncIOTaskManager.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    public void postTask(WsAsyncTask r9) {
        if (r9 != null) goto L14;
        return;
    L14:
        InnerRunnable r7 = new InnerRunnable(this, r9, null);     // Catch: Throwable -> L7
        if (r9.isLoop() == false) goto L9;
        ScheduledFuture<?> r0 = this.mTaskExecutor.scheduleWithFixedDelay(r7, r9.getInitialDelay(), r9.getLoopInterval(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L7
    L10:
        this.mRunnableTasks.put(r9, r7);     // Catch: Throwable -> L7
        this.mFutureTasks.put(r9, r0);     // Catch: Throwable -> L7
        return;
    L9:
        r0 = this.mTaskExecutor.schedule(r7, r9.getInitialDelay(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        Logger.e(TAG, "sendTask failed.", th);
    }

    public void removeTask(WsAsyncTask r3) {
        this.mTaskExecutor.remove(this.mRunnableTasks.remove(r3));     // Catch: Throwable -> L6
        ScheduledFuture r2 = this.mFutureTasks.remove(r3);     // Catch: Throwable -> L6
        if (r2 == null) goto L11;
        r2.cancel(true);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        Logger.e(TAG, "removeTask failed", th);
    }
}
