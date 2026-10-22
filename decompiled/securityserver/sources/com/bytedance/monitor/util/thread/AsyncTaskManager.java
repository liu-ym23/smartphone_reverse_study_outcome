package com.bytedance.monitor.util.thread;

import androidx.annotation.NonNull;
import com.bytedance.monitor.util.thread.inner.ApmInnerThreadFactory;
import com.bytedance.monitor.util.thread.inner.ApmInnerThreadPool;
import com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class AsyncTaskManager implements IAsyncTaskManager {
    private static final int CORE_POOL_SIZE_IO = 1;
    private static final int CORE_POOL_SIZE_LIGHT_WEIGHT = 1;
    private static final int CORE_POOL_SIZE_TIME_SENSITIVE = 1;
    private static final Object IO_LOCK = null;
    private static final Object LIGHT_WEIGHT_LOCK = null;
    public static final String TAG = "AsyncTaskManager";
    private static final String THREAD_NAME_IO_TASK = "io-task";
    private static final String THREAD_NAME_LIGHT_WEIGHT_TASK = "light-weight-task";
    private static final String THREAD_NAME_TIME_SENSITIVE_TASK = "time-sensitive-task";
    private static final Object TIME_SENSITIVE_LOCK = null;
    private IAsyncTaskManager.ExceptionListener mExceptionListener;
    private volatile ApmInnerThreadPool mIOTaskExecutor;
    private volatile ApmInnerThreadPool mLightWeightTaskHandler;
    private ThreadLogListener mLogListener;
    private volatile ApmInnerThreadPool mTimeSensitiveTaskHandler;
    private Map<AsyncTaskType, Long> mTypeThreadIdMap;

    public static final class Holder {
        static final AsyncTaskManager INSTANCE = null;

        static {
            INSTANCE = new AsyncTaskManager();
        }

        private Holder() {
        }
    }

    static {
        IO_LOCK = new Object();
        LIGHT_WEIGHT_LOCK = new Object();
        TIME_SENSITIVE_LOCK = new Object();
    }

    public AsyncTaskManager() {
        this.mTypeThreadIdMap = new ConcurrentHashMap(3);
    }

    public static /* synthetic */ Map access$000(AsyncTaskManager r0) {
        return r0.mTypeThreadIdMap;
    }

    @NonNull
    private IAsyncTaskHandler getHandlerByTaskType(TaskRunnable r2) {
        AsyncTaskType r3 = r2.getTaskType();
        if (r3 != AsyncTaskType.IO) goto L7;
        return getIOTaskExecutor();
    L7:
        if (r3 != AsyncTaskType.TIME_SENSITIVE) goto L11;
        return getTimeSensitiveHandlerThread();
    L11:
        return getLightWeightHandlerThread();
    }

    public static AsyncTaskManager getInstance() {
        return Holder.INSTANCE;
    }

    private void initIOTaskExecutor(ThreadLogListener r5) {
        Object r0 = IO_LOCK;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mIOTaskExecutor != null) goto L9;
        ApmInnerThreadFactory r1 = new ApmInnerThreadFactory(THREAD_NAME_IO_TASK);     // Catch: Throwable -> L7
        r1.setLogListener(r5);     // Catch: Throwable -> L7
        r1.setThreadIdCallback(new AnonymousClass1(this));     // Catch: Throwable -> L7
        ApmInnerThreadPool r2 = new ApmInnerThreadPool(1, r1);     // Catch: Throwable -> L7
        r2.setThreadLogListener(r5);     // Catch: Throwable -> L7
        this.mIOTaskExecutor = r2;     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private void initLightWeightTaskHandler(ThreadLogListener r5) {
        Object r0 = LIGHT_WEIGHT_LOCK;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mLightWeightTaskHandler != null) goto L9;
        ApmInnerThreadFactory r1 = new ApmInnerThreadFactory(THREAD_NAME_LIGHT_WEIGHT_TASK);     // Catch: Throwable -> L7
        r1.setLogListener(r5);     // Catch: Throwable -> L7
        r1.setThreadIdCallback(new AnonymousClass2(this));     // Catch: Throwable -> L7
        ApmInnerThreadPool r2 = new ApmInnerThreadPool(1, r1);     // Catch: Throwable -> L7
        r2.setThreadLogListener(r5);     // Catch: Throwable -> L7
        this.mLightWeightTaskHandler = r2;     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private void initTimeSensitiveHandlerThread(ThreadLogListener r5) {
        Object r0 = TIME_SENSITIVE_LOCK;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mTimeSensitiveTaskHandler != null) goto L9;
        ApmInnerThreadFactory r1 = new ApmInnerThreadFactory(THREAD_NAME_TIME_SENSITIVE_TASK);     // Catch: Throwable -> L7
        r1.setLogListener(r5);     // Catch: Throwable -> L7
        r1.setThreadIdCallback(new AnonymousClass3(this));     // Catch: Throwable -> L7
        ApmInnerThreadPool r2 = new ApmInnerThreadPool(1, r1);     // Catch: Throwable -> L7
        r2.setThreadLogListener(r5);     // Catch: Throwable -> L7
        this.mTimeSensitiveTaskHandler = r2;     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    @Override // com.bytedance.monitor.util.thread.IAsyncTaskManager
    public void directReportError(Throwable r1, String r2) {
        IAsyncTaskManager.ExceptionListener r0 = this.mExceptionListener;
        if (r0 == null) goto L6;
        r0.directReportError(r1, r2);
        return;
    }

    @Override // com.bytedance.monitor.util.thread.IAsyncTaskManager
    public ExecutorService getIOExecutor() {
        return getIOTaskExecutor();
    }

    public ApmInnerThreadPool getIOTaskExecutor() {
        if (this.mIOTaskExecutor != null) goto L16;
        Object r0 = IO_LOCK;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (this.mIOTaskExecutor != null) goto L11;
        initIOTaskExecutor(this.mLogListener);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
    L16:
        return this.mIOTaskExecutor;
    }

    public ApmInnerThreadPool getLightWeightHandlerThread() {
        if (this.mLightWeightTaskHandler != null) goto L16;
        Object r0 = LIGHT_WEIGHT_LOCK;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (this.mLightWeightTaskHandler != null) goto L11;
        initLightWeightTaskHandler(this.mLogListener);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
    L16:
        return this.mLightWeightTaskHandler;
    }

    @Override // com.bytedance.monitor.util.thread.IAsyncTaskManager
    public ThreadLogListener getThreadLogListener() {
        return this.mLogListener;
    }

    public ApmInnerThreadPool getTimeSensitiveHandlerThread() {
        if (this.mTimeSensitiveTaskHandler != null) goto L16;
        Object r0 = TIME_SENSITIVE_LOCK;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (this.mTimeSensitiveTaskHandler != null) goto L11;
        initTimeSensitiveHandlerThread(this.mLogListener);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
    L16:
        return this.mTimeSensitiveTaskHandler;
    }

    @Override // com.bytedance.monitor.util.thread.IAsyncTaskManager
    public long getWorkThreadId(AsyncTaskType r1) {
        Long r0 = this.mTypeThreadIdMap.get(r1);
        if (r0 != null) goto L5;
        return -1;
    L5:
        return r0.longValue();
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public boolean isPending(TaskRunnable r2) {
        return getHandlerByTaskType(r2).isPending(r2);
    L4:
        th = move-exception;
        directReportError(th, "Apm-Async-task-isPending");
        return false;
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void post(TaskRunnable r2) {
        if (r2 != null) goto L9;
        return;
    L9:
        getHandlerByTaskType(r2).post(r2);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        directReportError(th, "Apm-Async-task-post");
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void postDelayed(TaskRunnable r2, long r3) {
        if (r2 != null) goto L9;
        return;
    L9:
        getHandlerByTaskType(r2).postDelayed(r2, r3);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        directReportError(th, "Apm-Async-task-postDelayed");
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void release() {
        getIOTaskExecutor().release();     // Catch: Throwable -> L4
        getLightWeightHandlerThread().release();     // Catch: Throwable -> L4
        getTimeSensitiveHandlerThread().release();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        directReportError(th, "Apm-Async-task-release");
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void removeTask(TaskRunnable r2) {
        if (r2 != null) goto L9;
        return;
    L9:
        getHandlerByTaskType(r2).removeTask(r2);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        directReportError(th, "Apm-Async-task-removeTask");
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void scheduleWithFixedDelay(TaskRunnable r7, long r8, long r10) {
        if (r7 != null) goto L9;
        return;
    L9:
        getHandlerByTaskType(r7).scheduleWithFixedDelay(r7, r8, r10);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        directReportError(th, "Apm-Async-task-removeTask");
    }

    @Override // com.bytedance.monitor.util.thread.IAsyncTaskManager
    public void setExceptionListener(IAsyncTaskManager.ExceptionListener r1) {
        this.mExceptionListener = r1;
    }

    @Override // com.bytedance.monitor.util.thread.IAsyncTaskManager
    public void setIOExecutor(ExecutorService r1) {
        getIOTaskExecutor().setOuterExecutor(r1);
    }

    @Override // com.bytedance.monitor.util.thread.IAsyncTaskManager
    public void setTaskOverTime(AsyncTaskType r2, int r3) {
        if (r2 != AsyncTaskType.IO) goto L6;
        getIOTaskExecutor().setTaskOverTime(r3);
        return;
    L6:
        if (r2 != AsyncTaskType.TIME_SENSITIVE) goto L8;
        getTimeSensitiveHandlerThread().setTaskOverTime(r3);
        return;
    L8:
        getLightWeightHandlerThread().setTaskOverTime(r3);
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void setThreadLogListener(ThreadLogListener r2) {
        this.mLogListener = r2;
        getIOTaskExecutor().setThreadLogListener(r2);
        getLightWeightHandlerThread().setThreadLogListener(r2);
        getTimeSensitiveHandlerThread().setThreadLogListener(r2);
    }
}
