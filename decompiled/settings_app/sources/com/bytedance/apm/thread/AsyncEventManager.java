package com.bytedance.apm.thread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.apm.constant.ReportConsts;
import com.bytedance.monitor.util.thread.AsyncTaskType;
import com.bytedance.monitor.util.thread.AsyncTaskUtil;
import com.bytedance.monitor.util.thread.IAsyncTaskManager;
import com.bytedance.monitor.util.thread.TaskRunnable;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
public class AsyncEventManager {
    public static long WAIT_INTERVAL_MS = 30000;
    private static long sPollingIntervalMs = 30000;
    private IAsyncTaskManager mAsyncTaskManager;
    private final TaskRunnable mControlledTimerRunnable;
    private volatile ExecutorService mExecutors;
    private volatile boolean mTaskSwitchOn;
    private final TaskRunnable mTimerRunnable;
    CopyOnWriteArraySet<IMonitorTimeTask> monitorControlledTimeTaskList;
    CopyOnWriteArraySet<IMonitorTimeTask> monitorTimeTaskList;

    private static final class Holder {
        static final AsyncEventManager INSTANCE = null;

        private Holder() {
        }

        static {
            INSTANCE = new AsyncEventManager(null);
        }
    }

    public interface IMonitorTimeTask {
        void onTimeEvent(long r1);
    }

    static {
    }

    private Handler getHandler() {
        return null;
    }

    /* synthetic */ AsyncEventManager(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ boolean access$100(AsyncEventManager r0) {
        return r0.mTaskSwitchOn;
    }

    static /* synthetic */ long access$200() {
        return sPollingIntervalMs;
    }

    private AsyncEventManager() {
        this.mTaskSwitchOn = true;
        this.mTimerRunnable = new AnonymousClass1(this);
        this.mControlledTimerRunnable = new AnonymousClass2(this);
        this.monitorTimeTaskList = new CopyOnWriteArraySet();
        this.monitorControlledTimeTaskList = new CopyOnWriteArraySet();
        this.mAsyncTaskManager = AsyncTaskUtil.getAsyncTaskManagerInstance();
    }

    public static AsyncEventManager getInstance() {
        return Holder.INSTANCE;
    }

    public static void setPollingIntervalMs(long r2) {
        sPollingIntervalMs = Math.max(r2, ReportConsts.MIN_POLLING_INTERVAL_LIMIT_MS);
    }

    public boolean inWorkThread() {
        if (this.mAsyncTaskManager != null) goto L5;
    L7:
        return false;
    L5:
        if (Thread.currentThread().getId() != this.mAsyncTaskManager.getWorkThreadId(AsyncTaskType.LIGHT_WEIGHT)) goto L7;
        return true;
    }

    public Looper getLooper() {
        if (getHandler() != null) goto L5;
        return null;
    L5:
        return getHandler().getLooper();
    }

    public void sendMessage(Message r2) {
        if (getHandler() == null) goto L6;
        getHandler().sendMessage(r2);
        return;
    }

    public void post(Runnable r3) {
        if (this.mAsyncTaskManager == null) goto L10;
        if (r3 != null) goto L6;
        return;
    L6:
        if (this.mTaskSwitchOn == false) goto L12;
        this.mAsyncTaskManager.post(wrapLightWeightTaskRunnable(r3, CozeCloudExt.API_KEY_HTTP_POST_METHOD));
        return;
    L12:
        return;
    }

    public void forcePost(Runnable r3) {
        IAsyncTaskManager r0 = this.mAsyncTaskManager;
        if (r0 == null) goto L8;
        if (r3 == null) goto L9;
        r0.post(wrapLightWeightTaskRunnable(r3, CozeCloudExt.API_KEY_HTTP_POST_METHOD));
        return;
    L9:
        return;
    }

    public void postDelay(Runnable r3, long r4) {
        if (this.mAsyncTaskManager == null) goto L10;
        if (r3 != null) goto L6;
        return;
    L6:
        if (this.mTaskSwitchOn == false) goto L12;
        this.mAsyncTaskManager.postDelayed(wrapLightWeightTaskRunnable(r3, "postDelayed"), r4);
        return;
    L12:
        return;
    }

    public void postDelay(TaskRunnable r2, long r3) {
        if (this.mAsyncTaskManager == null) goto L10;
        if (r2 != null) goto L6;
        return;
    L6:
        if (this.mTaskSwitchOn == false) goto L12;
        this.mAsyncTaskManager.postDelayed(r2, r3);
        return;
    L12:
        return;
    }

    public void forcePostDelay(TaskRunnable r1, long r2) {
        IAsyncTaskManager r0 = this.mAsyncTaskManager;
        if (r0 == null) goto L8;
        if (r1 == null) goto L9;
        r0.postDelayed(r1, r2);
        return;
    L9:
        return;
    }

    public void removeCallbacks(TaskRunnable r1) {
        IAsyncTaskManager r0 = this.mAsyncTaskManager;
        if (r0 == null) goto L8;
        if (r1 == null) goto L9;
        r0.removeTask(r1);
        return;
    L9:
        return;
    }

    public void addTimeTask(IMonitorTimeTask r3) {
        if (r3 == null) goto L12;
        if (this.mTaskSwitchOn == true) goto L6;
        return;
    L6:
        if (this.monitorTimeTaskList.contains(r3) == true) goto L14;
        this.monitorTimeTaskList.add(r3);     // Catch: Throwable -> L9
        removeCallbacks(this.mTimerRunnable);     // Catch: Throwable -> L9
        postDelay(this.mTimerRunnable, WAIT_INTERVAL_MS);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L15:
        return;
    }

    public void removeTimeTask(IMonitorTimeTask r1) {
        if (r1 == null) goto L8;
        this.monitorTimeTaskList.remove(r1);     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public void addControlledTimeTask(IMonitorTimeTask r3) {
        if (r3 == null) goto L10;
        if (this.mTaskSwitchOn == false) goto L11;
        this.monitorControlledTimeTaskList.add(r3);     // Catch: Throwable -> L7
        removeCallbacks(this.mControlledTimerRunnable);     // Catch: Throwable -> L7
        postDelay(this.mControlledTimerRunnable, sPollingIntervalMs);     // Catch: Throwable -> L7
        return;
    L11:
        return;
    L12:
        return;
    }

    public void removeControlledTimeTask(IMonitorTimeTask r2) {
        if (r2 == null) goto L10;
        this.monitorControlledTimeTaskList.remove(r2);     // Catch: Throwable -> L7
        if (this.monitorControlledTimeTaskList.isEmpty() == false) goto L11;
        removeCallbacks(this.mControlledTimerRunnable);     // Catch: Throwable -> L7
        return;
    L11:
        return;
    L12:
        return;
    }

    public void stopTimer() {
        this.mTaskSwitchOn = false;
        removeCallbacks(this.mTimerRunnable);
        removeCallbacks(this.mControlledTimerRunnable);
    }

    public void resumeTimer() {
        this.mTaskSwitchOn = true;
        if (this.monitorTimeTaskList.isEmpty() == true) goto L6;
        removeCallbacks(this.mTimerRunnable);
        postDelay(this.mTimerRunnable, WAIT_INTERVAL_MS);
    L6:
        if (this.monitorControlledTimeTaskList.isEmpty() == true) goto L9;
        removeCallbacks(this.mControlledTimerRunnable);
        postDelay(this.mControlledTimerRunnable, sPollingIntervalMs);
        return;
    }

    public void injectExecutor(ExecutorService r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        monitor-enter(this);
        this.mExecutors = r2;     // Catch: Throwable -> L10
        IAsyncTaskManager r0 = this.mAsyncTaskManager;     // Catch: Throwable -> L10
        if (r0 == null) goto L8;
        r0.setIOExecutor(r2);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void submitTask(Runnable r3) {
        if (this.mExecutors != null) goto L16;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L6:
        if (this.mExecutors != null) goto L11;
        IAsyncTaskManager r0 = this.mAsyncTaskManager;     // Catch: Throwable -> L13
        if (r0 == null) goto L10;
        this.mExecutors = r0.getIOExecutor();     // Catch: Throwable -> L13
        goto L11
    L10:
        this.mExecutors = Executors.newFixedThreadPool(1, new AnonymousClass3(this));     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);     // Catch: Throwable -> L13
    L16:
        this.mExecutors.submit(r3);
    }

    private TaskRunnable wrapLightWeightTaskRunnable(Runnable r2, String r3) {
        return AsyncTaskUtil.wrapLightWeightTask("AsyncEventManager-" + r3, r2);
    }
}
