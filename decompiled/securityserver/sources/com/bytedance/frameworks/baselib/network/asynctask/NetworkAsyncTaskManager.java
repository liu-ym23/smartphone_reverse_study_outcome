package com.bytedance.frameworks.baselib.network.asynctask;

import com.bytedance.common.utility.Logger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class NetworkAsyncTaskManager {
    private static final String TAG = "NetworkAsyncTaskManager";
    private static final ConcurrentHashMap<NetworkAsyncTaskType, NetworkAsyncTaskManager> mExecutorMap = null;
    private final ScheduledThreadPoolExecutor mExecutor;
    private final NetworkAsyncTaskType mExecutorTaskType;
    private final ConcurrentHashMap<NetworkAsyncTask, ScheduledFuture> mFutureList;
    private final ConcurrentHashMap<NetworkAsyncTask, Runnable> mRunnableList;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class InnerRunnable implements Runnable {
        private final NetworkAsyncTask mTask;

        public /* synthetic */ InnerRunnable(NetworkAsyncTask r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            long r2 = System.currentTimeMillis();     // Catch: Throwable -> L7
            this.mTask.run();     // Catch: Throwable -> L7
            if (Logger.debug() == false) goto L10;
            Logger.d(NetworkAsyncTaskManager.access$100(), "Task execute time: " + (System.currentTimeMillis() - r2));     // Catch: Throwable -> L7
        L10:
            if (this.mTask.isLoop() == true) goto L16;
        L11:
            NetworkAsyncTaskManager.inst(this.mTask.getTaskType()).getRunnableList().remove(this.mTask);
            NetworkAsyncTaskManager.inst(this.mTask.getTaskType()).getFutureList().remove(this.mTask);
            return;
        L16:
            return;
        L7:
            th = move-exception;
            Logger.e(NetworkAsyncTaskManager.access$100(), "thread " + Thread.currentThread().getName() + " exception", th);     // Catch: Throwable -> L17
            if (this.mTask.isLoop() == false) goto L11;
            return;
        L17:
            th = move-exception;
            if (this.mTask.isLoop() == true) goto L21;
            NetworkAsyncTaskManager.inst(this.mTask.getTaskType()).getRunnableList().remove(this.mTask);
            NetworkAsyncTaskManager.inst(this.mTask.getTaskType()).getFutureList().remove(this.mTask);
        L21:
            throw th;
        }

        private InnerRunnable(NetworkAsyncTask r1) {
            this.mTask = r1;
        }
    }

    static {
        mExecutorMap = new ConcurrentHashMap();
    }

    private NetworkAsyncTaskManager(NetworkAsyncTaskType r3) {
        this.mFutureList = new ConcurrentHashMap();
        this.mRunnableList = new ConcurrentHashMap();
        this.mExecutorTaskType = r3;
        this.mExecutor = new ScheduledThreadPoolExecutor(1, new NetworkThreadFactory(r3.name()));
    }

    public static /* synthetic */ String access$100() {
        return TAG;
    }

    public static NetworkAsyncTaskManager inst(NetworkAsyncTaskType r3) {
        if (r3 == null) goto L19;
        ConcurrentHashMap<NetworkAsyncTaskType, NetworkAsyncTaskManager> r0 = mExecutorMap;
        if (r0.get(r3) != null) goto L17;
        monitor-enter(NetworkAsyncTaskManager.class);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (r0.get(r3) != null) goto L12;
        r0.put(r3, new NetworkAsyncTaskManager(r3));     // Catch: Throwable -> L10
    L12:
        monitor-exit(NetworkAsyncTaskManager.class);     // Catch: Throwable -> L10
    L17:
        return r0.get(r3);
    L19:
        throw new IllegalArgumentException("unsupported async task type");
    }

    public ConcurrentHashMap<?, ?> getFutureList() {
        return this.mFutureList;
    }

    public ConcurrentHashMap<?, ?> getRunnableList() {
        return this.mRunnableList;
    }

    public void postTask(NetworkAsyncTask r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        r9.setTaskType(this.mExecutorTaskType);
        InnerRunnable r0 = new InnerRunnable(r9, null);     // Catch: Throwable -> L8
        if (r9.isLoop() == false) goto L10;
        ScheduledFuture<?> r1 = this.mExecutor.scheduleWithFixedDelay(r0, r9.getInitialDelay(), r9.getLoopInterval(), r9.getTimeUnit());     // Catch: Throwable -> L8
    L11:
        this.mRunnableList.put(r9, r0);     // Catch: Throwable -> L8
        this.mFutureList.put(r9, r1);     // Catch: Throwable -> L8
        return;
    L10:
        r1 = this.mExecutor.schedule(r0, r9.getInitialDelay(), r9.getTimeUnit());     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        th.printStackTrace();
    }

    public void removeTask(NetworkAsyncTask r3) {
        Runnable r0 = this.mRunnableList.remove(r3);     // Catch: Throwable -> L5
        if (r0 == null) goto L7;
        this.mExecutor.remove(r0);     // Catch: Throwable -> L5
    L7:
        ScheduledFuture r2 = this.mFutureList.remove(r3);     // Catch: Throwable -> L5
        if (r2 == null) goto L15;
        r2.cancel(true);     // Catch: Throwable -> L5
        return;
    L15:
        return;
    L5:
        th = move-exception;
        Logger.e(TAG, "removeTask failed", th);
    }
}
