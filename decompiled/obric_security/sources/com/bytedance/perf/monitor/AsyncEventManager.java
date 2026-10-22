package com.bytedance.perf.monitor;

import android.os.Looper;
import android.os.Message;
import com.bytedance.apm.thread.ThreadWithHandler;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class AsyncEventManager {
    public static final String ASYNC_EVENT_MANAGER_THREAD = "AsyncEventManager-Thread";
    private static final long MIN_POLLING_INTERVAL_LIMIT_MS = 5000;
    public static long WAIT_INTERVAL_MS = 30000;
    private static long sPollingIntervalMs = 30000;
    private final Runnable mControlledTimerRunnable;
    private ThreadWithHandler mEventHandler;
    private volatile ExecutorService mExecutors;
    private volatile boolean mTaskSwitchOn;
    private final Runnable mTimerRunnable;
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

    /* synthetic */ AsyncEventManager(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ boolean access$100(AsyncEventManager r0) {
        return r0.mTaskSwitchOn;
    }

    static /* synthetic */ ThreadWithHandler access$200(AsyncEventManager r0) {
        return r0.mEventHandler;
    }

    static /* synthetic */ long access$300() {
        return sPollingIntervalMs;
    }

    private AsyncEventManager() {
        this.mTaskSwitchOn = true;
        this.mTimerRunnable = new AnonymousClass1(this);
        this.mControlledTimerRunnable = new AnonymousClass2(this);
        this.monitorTimeTaskList = new CopyOnWriteArraySet();
        this.monitorControlledTimeTaskList = new CopyOnWriteArraySet();
        ThreadWithHandler r0 = new ThreadWithHandler("AsyncEventManager-Thread");
        this.mEventHandler = r0;
        r0.start();
    }

    public static AsyncEventManager getInstance() {
        return Holder.INSTANCE;
    }

    public static void setPollingIntervalMs(long r2) {
        sPollingIntervalMs = Math.max(r2, 5000);
    }

    public Looper getLooper() {
        ThreadWithHandler r0 = this.mEventHandler;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getLooper();
    }

    public void sendMessage(Message r1) {
        this.mEventHandler.sendMessage(r1);
    }

    public void post(Runnable r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (this.mTaskSwitchOn == false) goto L9;
        this.mEventHandler.post(r2);
        return;
    }

    public void postDelay(Runnable r2, long r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (this.mTaskSwitchOn == false) goto L9;
        this.mEventHandler.postDelayed(r2, r3);
        return;
    }

    public void removeCallbacks(Runnable r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.mEventHandler.removeCallbacks(r1);
    }

    public void addTimeTask(IMonitorTimeTask r3) {
        if (r3 == null) goto L12;
        if (this.mTaskSwitchOn == true) goto L6;
        return;
    L6:
        if (this.monitorTimeTaskList.contains(r3) == true) goto L14;
        this.monitorTimeTaskList.add(r3);     // Catch: Throwable -> L9
        this.mEventHandler.removeCallbacks(this.mTimerRunnable);     // Catch: Throwable -> L9
        this.mEventHandler.postDelayed(this.mTimerRunnable, WAIT_INTERVAL_MS);     // Catch: Throwable -> L9
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
        this.mEventHandler.removeCallbacks(this.mControlledTimerRunnable);     // Catch: Throwable -> L7
        this.mEventHandler.postDelayed(this.mControlledTimerRunnable, sPollingIntervalMs);     // Catch: Throwable -> L7
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
        this.mEventHandler.removeCallbacks(this.mControlledTimerRunnable);     // Catch: Throwable -> L7
        return;
    L11:
        return;
    L12:
        return;
    }

    public void stopTimer() {
        this.mTaskSwitchOn = false;
        ThreadWithHandler r0 = this.mEventHandler;
        if (r0 == null) goto L6;
        r0.removeCallbacks(this.mTimerRunnable);
        this.mEventHandler.removeCallbacks(this.mControlledTimerRunnable);
        return;
    }

    public void resumeTimer() {
        this.mTaskSwitchOn = true;
        if (this.mEventHandler == null) goto L8;
        if (this.monitorTimeTaskList.isEmpty() == true) goto L8;
        this.mEventHandler.removeCallbacks(this.mTimerRunnable);
        this.mEventHandler.postDelayed(this.mTimerRunnable, WAIT_INTERVAL_MS);
    L8:
        if (this.mEventHandler != null) goto L10;
        return;
    L10:
        if (this.monitorControlledTimeTaskList.isEmpty() == true) goto L14;
        this.mEventHandler.removeCallbacks(this.mControlledTimerRunnable);
        this.mEventHandler.postDelayed(this.mControlledTimerRunnable, sPollingIntervalMs);
        return;
    }

    public void injectExecutor(ExecutorService r1) {
        this.mExecutors = r1;
    }

    public void submitTask(Runnable r3) {
        if (this.mExecutors != null) goto L13;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mExecutors != null) goto L8;
        this.mExecutors = Executors.newFixedThreadPool(1, new AnonymousClass3(this));     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L13:
        this.mExecutors.submit(r3);
    }
}
