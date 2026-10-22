package com.bytedance.frameworks.baselib.network.http.util;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class AsyncIOTaskManager {
    private static final String TAG = "AsyncIOTaskManager";
    private static AsyncIOTaskManager sInstance;
    private ConcurrentHashMap<AsyncTask, ScheduledFuture> mFutureTasks;
    private ConcurrentHashMap<AsyncTask, Runnable> mRunnableTasks;
    private ScheduledThreadPoolExecutor mTaskExecutor;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.util.AsyncIOTaskManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class InnerRunnable implements Runnable {
        private AsyncTask task;
        final /* synthetic */ AsyncIOTaskManager this$0;

        public /* synthetic */ InnerRunnable(AsyncIOTaskManager r1, AsyncTask r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        @Override // java.lang.Runnable
        public void run() {
            long r2 = System.currentTimeMillis();     // Catch: Throwable -> L7
            this.task.run();     // Catch: Throwable -> L7
            if (Logger.debug() == false) goto L10;
            Logger.d(AsyncIOTaskManager.access$100(), "Task execute time: " + (System.currentTimeMillis() - r2));     // Catch: Throwable -> L7
        L10:
            if (this.task.isLoop() == true) goto L16;
        L11:
            AsyncIOTaskManager.access$200(this.this$0).remove(this.task);
            AsyncIOTaskManager.access$300(this.this$0).remove(this.task);
            return;
        L16:
            return;
        L7:
            th = move-exception;
            Logger.e(AsyncIOTaskManager.access$100(), "thread " + Thread.currentThread().getName() + " exception", th);     // Catch: Throwable -> L17
            if (this.task.isLoop() == false) goto L11;
            return;
        L17:
            th = move-exception;
            if (this.task.isLoop() == true) goto L21;
            AsyncIOTaskManager.access$200(this.this$0).remove(this.task);
            AsyncIOTaskManager.access$300(this.this$0).remove(this.task);
        L21:
            throw th;
        }

        private InnerRunnable(AsyncIOTaskManager r1, AsyncTask r2) {
            this.this$0 = r1;
            this.task = r2;
        }
    }

    private AsyncIOTaskManager() {
        this.mFutureTasks = new ConcurrentHashMap();
        this.mRunnableTasks = new ConcurrentHashMap();
        ScheduledThreadPoolExecutor r0 = new ScheduledThreadPoolExecutor(1, new ThreadFactory("ttnet-io"));
        this.mTaskExecutor = r0;
        r0.setRemoveOnCancelPolicy(true);
    }

    public static /* synthetic */ String access$100() {
        return TAG;
    }

    public static /* synthetic */ ConcurrentHashMap access$200(AsyncIOTaskManager r0) {
        return r0.mFutureTasks;
    }

    public static /* synthetic */ ConcurrentHashMap access$300(AsyncIOTaskManager r0) {
        return r0.mRunnableTasks;
    }

    public static AsyncIOTaskManager getInstance() {
        if (sInstance != null) goto L16;
        monitor-enter(AsyncIOTaskManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new AsyncIOTaskManager();     // Catch: Throwable -> L9
    L11:
        monitor-exit(AsyncIOTaskManager.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    public void postTask(AsyncTask r9) {
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

    public void removeTask(AsyncTask r3) {
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

    public void removeTaskById(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L25;
        return;
    L25:
        Iterator<Map.Entry<AsyncTask, Runnable>> r0 = this.mRunnableTasks.entrySet().iterator();     // Catch: Throwable -> L11
    L7:
        if (r0.hasNext() == false) goto L13;
        AsyncTask r1 = r0.next().getKey();     // Catch: Throwable -> L11
        if (r4.equals(r1.getTaskIdentifier()) == false) goto L7;
        r0.remove();     // Catch: Throwable -> L11
        this.mTaskExecutor.remove(r1);     // Catch: Throwable -> L11
        goto L7
    L13:
        Iterator<Map.Entry<AsyncTask, ScheduledFuture>> r3 = this.mFutureTasks.entrySet().iterator();     // Catch: Throwable -> L11
    L14:
        if (r3.hasNext() == false) goto L37;
        Map.Entry<AsyncTask, ScheduledFuture> r2 = r3.next();     // Catch: Throwable -> L11
        if (r4.equals(r2.getKey().getTaskIdentifier()) == false) goto L14;
        ScheduledFuture r5 = r2.getValue();     // Catch: Throwable -> L11
        if (r5 == null) goto L21;
        r5.cancel(true);     // Catch: Throwable -> L11
    L21:
        r3.remove();     // Catch: Throwable -> L11
        goto L14
    L37:
        return;
    L11:
        th = move-exception;
        Logger.e(TAG, "removeTask failed", th);
    }
}
