package com.bytedance.framwork.core.sdklib.thread;

import android.os.Message;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public class AsyncEventManager {
    public static final String ASYNC_EVENT_MANAGER_THREAD = "AsyncEventManager-Thread";
    private static long WAIT_INTERVAL = 30000;
    private ThreadWithHandler mEventHandler;
    private final Runnable mTimerRunnable;
    private volatile boolean mTimerTaskSwitchOn;
    CopyOnWriteArraySet<IMonitorTimeTask> monitorTimeTaskList;

    private static final class Holder {
        static final AsyncEventManager INSTANCE = null;

        private Holder() {
        }

        static {
            INSTANCE = new AsyncEventManager(null);
        }
    }

    static {
    }

    /* synthetic */ AsyncEventManager(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ boolean access$100(AsyncEventManager r0) {
        return r0.mTimerTaskSwitchOn;
    }

    static /* synthetic */ long access$200() {
        return WAIT_INTERVAL;
    }

    static /* synthetic */ ThreadWithHandler access$300(AsyncEventManager r0) {
        return r0.mEventHandler;
    }

    private AsyncEventManager() {
        this.mTimerTaskSwitchOn = true;
        this.mTimerRunnable = new AnonymousClass1(this);
        this.monitorTimeTaskList = new CopyOnWriteArraySet();
        ThreadWithHandler r0 = new ThreadWithHandler("AsyncEventManager-Thread");
        this.mEventHandler = r0;
        r0.start();
    }

    public static AsyncEventManager getInstance() {
        return Holder.INSTANCE;
    }

    public void sendMessage(Message r1) {
        this.mEventHandler.sendMessage(r1);
    }

    public void post(Runnable r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.mEventHandler.post(r1);
    }

    public void postDelay(Runnable r1, long r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.mEventHandler.postDelayed(r1, r2);
    }

    public void removeCallbacks(Runnable r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.mEventHandler.removeCallbacks(r1);
    }

    public void addTimeTask(IMonitorTimeTask r3) {
        if (r3 == null) goto L10;
        this.monitorTimeTaskList.add(r3);     // Catch: Throwable -> L7
        if (this.mTimerTaskSwitchOn == false) goto L11;
        this.mEventHandler.removeCallbacks(this.mTimerRunnable);     // Catch: Throwable -> L7
        this.mEventHandler.postDelayed(this.mTimerRunnable, WAIT_INTERVAL);     // Catch: Throwable -> L7
        return;
    L11:
        return;
    L12:
        return;
    }

    public void removeTimeTask(IMonitorTimeTask r1) {
        if (r1 == null) goto L8;
        this.monitorTimeTaskList.remove(r1);     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public void stopLoop() {
        this.mTimerTaskSwitchOn = false;
        ThreadWithHandler r0 = this.mEventHandler;
        if (r0 == null) goto L6;
        r0.removeCallbacks(this.mTimerRunnable);
        return;
    }

    public void restore() {
        this.mTimerTaskSwitchOn = true;
        if (this.mEventHandler != null) goto L5;
        return;
    L5:
        if (this.monitorTimeTaskList.isEmpty() == true) goto L9;
        this.mEventHandler.removeCallbacks(this.mTimerRunnable);
        this.mEventHandler.postDelayed(this.mTimerRunnable, WAIT_INTERVAL);
        return;
    }
}
