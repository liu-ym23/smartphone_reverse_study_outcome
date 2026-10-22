package com.bytedance.monitor.util.thread.inner;

import android.util.Pair;
import com.bytedance.monitor.util.thread.AsyncTaskUtil;
import com.bytedance.monitor.util.thread.TaskRunnable;
import com.bytedance.monitor.util.thread.ThreadLogListener;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class ApmInnerThreadPool extends ScheduledThreadPoolExecutor implements IAsyncTaskHandler {
    public final String TAG;
    private ThreadLogListener mDebugLogListener;
    private final Map<ScheduledFuture<?>, Pair<Integer, Boolean>> mFutureTaskMap;
    private ThreadPoolExecutor mOuterExecutorOriginal;
    private ExecutorService mOuterExecutorProxy;
    private RunningTask mRunningTask;
    private final Map<Integer, List<ScheduledFuture<?>>> mTaskFutureMap;
    private int mTaskOverTime;
    private boolean mTestDebug;

    public class RunningTask {
        public Runnable runnable;
        public long startTime;
        public int taskOverTime;
        final /* synthetic */ ApmInnerThreadPool this$0;
        public Thread thread;

        public RunningTask(ApmInnerThreadPool r1, Runnable r2, Thread r3, int r4) {
            this.this$0 = r1;
            this.runnable = r2;
            this.thread = r3;
            this.startTime = System.currentTimeMillis();
            this.taskOverTime = r4;
        }

        public boolean isOverTime() {
            if ((System.currentTimeMillis() - this.startTime) <= this.taskOverTime) goto L5;
            return true;
        L5:
            return false;
        }

        public void cancel() {
            Runnable r0 = this.runnable;
            if (r0 != null) goto L6;
            return;
        L6:
            if ((r0 instanceof FutureTask) == false) goto L11;
            boolean r1 = ((FutureTask) r0).cancel(true);
            if (ApmInnerThreadPool.access$000(this.this$0) == false) goto L12;
            ApmInnerThreadPool.access$100(this.this$0, "TimeSensitive + mCancelOverTimeTaskRunnable run ------------ cancel FutureTask, canceled?" + r1);
            return;
        L12:
            return;
        }
    }

    static /* synthetic */ boolean access$000(ApmInnerThreadPool r0) {
        return r0.openDebug();
    }

    static /* synthetic */ void access$100(ApmInnerThreadPool r0, String r1) {
        r0.log(r1);
    }

    public ApmInnerThreadPool(int r1, ThreadFactory r2) {
        super(r1, r2);
        this.TAG = "ApmInnerThreadPool";
        this.mTestDebug = false;
        this.mTaskFutureMap = new ConcurrentHashMap();
        this.mFutureTaskMap = new ConcurrentHashMap();
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable r3) {
        if (this.mOuterExecutorProxy == null) goto L10;
        if (openDebug() == false) goto L8;
        log("submit task to outer-executor: " + getTaskName(r3));
    L8:
        return this.mOuterExecutorProxy.submit(r3);
    L10:
        return super.submit(r3);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> r3) {
        if (this.mOuterExecutorProxy == null) goto L10;
        if (openDebug() == false) goto L8;
        log("submit task to outer-executor: " + r3);
    L8:
        return this.mOuterExecutorProxy.submit(r3);
    L10:
        return super.submit(r3);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable r3, T r4) {
        if (this.mOuterExecutorProxy == null) goto L10;
        if (openDebug() == false) goto L8;
        log("submit task to outer-executor: " + getTaskName(r3));
    L8:
        return this.mOuterExecutorProxy.submit(r3, r4);
    L10:
        return super.submit(r3, r4);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void beforeExecute(Thread r2, Runnable r3) {
        checkTaskOverTime(true, r3, r2);
        super.beforeExecute(r2, r3);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable r4, Throwable r5) {
        super.afterExecute(r4, r5);
        checkTaskOverTime(false, r4, null);
        if ((r4 instanceof ScheduledFuture) == false) goto L18;
        ScheduledFuture r6 = (ScheduledFuture) r4;
        Pair<Integer, Boolean> r0 = this.mFutureTaskMap.get(r6);
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.first == null) goto L20;
        int r1 = ((Integer) r0.first).intValue();
        Boolean r2 = (Boolean) r0.second;
        if (r2 != null) goto L11;
        return;
    L11:
        if (r2.booleanValue() == false) goto L14;
        return;
    L14:
        if (openDebug() == false) goto L16;
        log("z-debug postDelay or scheduled task: " + r4 + ", taskHashCode: " + r1 + ", in map? " + this.mTaskFutureMap.containsKey(Integer.valueOf(r1)));
    L16:
        removeMapRecord(Integer.valueOf(r1), r6);
        return;
    L20:
        return;
    }

    private void checkTaskOverTime(boolean r2, Runnable r3, Thread r4) {
        if (needCheckTaskOverTime() == true) goto L5;
        return;
    L5:
        if (r2 == false) goto L7;
        this.mRunningTask = new RunningTask(this, r3, r4, this.mTaskOverTime);
        return;
    L7:
        this.mRunningTask = null;
    }

    private boolean needCheckTaskOverTime() {
        if (this.mTaskOverTime <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void terminated() {
        super.terminated();
    }

    private boolean openDebug() {
        if (this.mTestDebug == false) goto L9;
        ThreadLogListener r1 = this.mDebugLogListener;
        if (r1 == null) goto L9;
        if (r1.isDebug() == false) goto L9;
        return true;
    L9:
        return false;
    }

    public void setOuterExecutor(final ExecutorService r5) {
        if (r5 != null) goto L6;
        this.mOuterExecutorProxy = null;
        this.mOuterExecutorOriginal = null;
        return;
    L6:
        if ((r5 instanceof ThreadPoolExecutor) == false) goto L8;
        this.mOuterExecutorOriginal = (ThreadPoolExecutor) r5;
    L8:
        this.mOuterExecutorProxy = (ExecutorService) Proxy.newProxyInstance(r5.getClass().getClassLoader(), new Class[]{ExecutorService.class}, new AnonymousClass1(this, r5));
    }

    private String getTaskName(Runnable r1) {
        if ((r1 instanceof TaskRunnable) == true) goto L5;
        if (r1 != null) goto L10;
        return "null";
    L10:
        return r1.toString();
    L5:
        return ((TaskRunnable) r1).getTaskName();
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void post(TaskRunnable r3) {
        if (openDebug() == false) goto L5;
        log("post " + AsyncTaskUtil.getTaskInfo(r3));
    L5:
        submit(r3);
        cancelRunningTaskIfOverTime();
        if (this.mOuterExecutorProxy == null) goto L8;
        return;
    L8:
        if (openDebug() == false) goto L12;
        log("current task count: " + getQueue().size());
        return;
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void removeTask(TaskRunnable r3) {
        ThreadPoolExecutor r0 = this.mOuterExecutorOriginal;
        if (r0 == null) goto L6;
        r0.remove(r3);
    L6:
        if (cancelByFuture(r3) == false) goto L8;
        return;
    L8:
        if (openDebug() == false) goto L12;
        log("z-debug-removeTask " + AsyncTaskUtil.getTaskInfo(r3) + ", remove failed");
        return;
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void release() {
        ExecutorService r0 = this.mOuterExecutorProxy;
        if (r0 == null) goto L5;
        r0.shutdown();
    L5:
        shutdown();
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void postDelayed(TaskRunnable r3, long r4) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (openDebug() == false) goto L7;
        log("postDelayed " + AsyncTaskUtil.getTaskInfo(r3));
    L7:
        saveToMap(schedule(r3, r4, TimeUnit.MILLISECONDS), r3.hashCode(), false);
        cancelRunningTaskIfOverTime();
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void scheduleWithFixedDelay(TaskRunnable r9, long r10, long r12) {
        if (r9 != null) goto L5;
        return;
    L5:
        if (openDebug() == false) goto L7;
        log("scheduleWithFixedDelay " + AsyncTaskUtil.getTaskInfo(r9) + ", initialDelay: " + r10 + ", delayInMillis: " + r12 + "\n task count: " + getQueue().size());
    L7:
        cancelByFuture(r9);
        saveToMap(scheduleWithFixedDelay(r9, r10, r12, TimeUnit.MILLISECONDS), r9.hashCode(), true);
        cancelRunningTaskIfOverTime();
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void setThreadLogListener(ThreadLogListener r1) {
        this.mDebugLogListener = r1;
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public boolean isPending(TaskRunnable r4) {
        ThreadPoolExecutor r0 = this.mOuterExecutorOriginal;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = getQueue().contains(r4);
        List<ScheduledFuture<?>> r3 = this.mTaskFutureMap.get(Integer.valueOf(r4.hashCode()));
        if (r3 != null) goto L10;
    L17:
        boolean r5 = false;
    L18:
        if (r1 == true) goto L26;
        if (r5 == false) goto L22;
        return true;
    L22:
        return false;
    L26:
        return true;
    L10:
        if (r3.isEmpty() == true) goto L17;
        Iterator<ScheduledFuture<?>> r6 = r3.iterator();
    L13:
        if (r6.hasNext() == false) goto L17;
        if (r6.next().isCancelled() == true) goto L13;
        r5 = true;
        goto L18
    L5:
        if (r0.getQueue().contains(r4) == false) goto L7;
        return true;
    }

    private void log(String r2) {
        AsyncTaskUtil.logd(this.mDebugLogListener, "ApmInnerThreadPool", r2);
    }

    public void setTaskOverTime(int r1) {
        this.mTaskOverTime = r1;
    }

    private void cancelRunningTaskIfOverTime() {
        RunningTask r0 = this.mRunningTask;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isOverTime() == false) goto L9;
        this.mRunningTask.cancel();
        this.mRunningTask = null;
        return;
    }

    private boolean cancelByFuture(TaskRunnable r7) {
        boolean r0 = false;
        if (r7 != null) goto L5;
        return false;
    L5:
        int r1 = r7.hashCode();
        List<ScheduledFuture<?>> r2 = this.mTaskFutureMap.get(Integer.valueOf(r1));
        StringBuilder r3 = new StringBuilder("z-debug scheduledFutures in ?");
        if (r2 == null) goto L8;
        boolean r5 = true;
    L9:
        log(r3.append(r5).toString());
        if (r2 != null) goto L12;
    L25:
        return r0;
    L12:
        if (r2.isEmpty() == true) goto L25;
        if (openDebug() == false) goto L16;
        log("z-debug-removeTask from mTaskFutureMap" + AsyncTaskUtil.getTaskInfo(r7));
        log("z-debug scheduledFutures size:" + r2.size());
    L16:
        Iterator<ScheduledFuture<?>> r8 = r2.iterator();
    L18:
        if (r8.hasNext() == false) goto L25;
        ScheduledFuture<?> r4 = r8.next();
        if (r4.isCancelled() == true) goto L18;
        if (r4.cancel(true) == false) goto L24;
        r0 = true;
    L24:
        removeMapRecord(Integer.valueOf(r1), r4);
        goto L18
    L8:
        r5 = false;
        goto L9
    }

    private void saveToMap(ScheduledFuture<?> r4, int r5, boolean r6) {
        List<ScheduledFuture<?>> r0 = this.mTaskFutureMap.get(Integer.valueOf(r5));
        if (r0 != null) goto L5;
        r0 = new CopyOnWriteArrayList();
        this.mTaskFutureMap.put(Integer.valueOf(r5), r0);
    L5:
        r0.add(r4);
        this.mFutureTaskMap.put(r4, new Pair(Integer.valueOf(r5), Boolean.valueOf(r6)));
        if (openDebug() == false) goto L9;
        log("z-debug saveToMap -current task count: " + getQueue().size() + ", thread-count; " + getActiveCount());
        log("z-debug saveToMap >>>>>> mTaskFutureMap size: " + this.mTaskFutureMap.size() + ", mFutureTaskMap size: " + this.mFutureTaskMap.size());
        log("z-debug saveToMap >>>>>> sameHashCodeFutures size: " + r0.size());
        return;
    }

    private void removeMapRecord(Integer r3, ScheduledFuture r4) {
        List<ScheduledFuture<?>> r0 = this.mTaskFutureMap.get(r3);
        if (r0 == null) goto L7;
        boolean r1 = r0.remove(r4);
        if (r0.isEmpty() == false) goto L8;
        this.mTaskFutureMap.remove(r3);
    L8:
        this.mFutureTaskMap.remove(r4);
        if (openDebug() == false) goto L12;
        log("z-debug removeMapRecord: " + r4 + ", removed: " + r1);
        return;
    L12:
        return;
    L7:
        r1 = false;
        goto L8
    }

    public void setTestDebug(boolean r1) {
        this.mTestDebug = r1;
    }
}
