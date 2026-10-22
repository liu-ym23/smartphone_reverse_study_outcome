package androidx.work.impl.utils;

import androidx.work.Logger;
import androidx.work.RunnableScheduler;
import androidx.work.impl.model.WorkGenerationalId;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class WorkTimer {
    private static final String TAG = null;
    final Map<WorkGenerationalId, TimeLimitExceededListener> mListeners;
    final Object mLock;
    final RunnableScheduler mRunnableScheduler;
    final Map<WorkGenerationalId, WorkTimerRunnable> mTimerMap;

    public interface TimeLimitExceededListener {
        void onTimeLimitExceeded(WorkGenerationalId id);
    }

    public static class WorkTimerRunnable implements Runnable {
        static final String TAG = "WrkTimerRunnable";
        private final WorkGenerationalId mWorkGenerationalId;
        private final WorkTimer mWorkTimer;

        WorkTimerRunnable(WorkTimer workTimer, WorkGenerationalId id) {
            this.mWorkTimer = workTimer;
            this.mWorkGenerationalId = id;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r0 = this.mWorkTimer.mLock;
            monitor-enter(r0);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (this.mWorkTimer.mTimerMap.remove(this.mWorkGenerationalId) == null) goto L9;
            TimeLimitExceededListener r1 = this.mWorkTimer.mListeners.remove(this.mWorkGenerationalId);     // Catch: Throwable -> L12
            if (r1 == null) goto L10;
            r1.onTimeLimitExceeded(this.mWorkGenerationalId);     // Catch: Throwable -> L12
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L9:
            Logger.get().debug(TAG, String.format("Timer with %s is already marked as complete.", new Object[]{this.mWorkGenerationalId}));     // Catch: Throwable -> L12
            goto L10
        }
    }

    static {
        TAG = Logger.tagWithPrefix("WorkTimer");
    }

    public WorkTimer(RunnableScheduler scheduler) {
        this.mTimerMap = new HashMap();
        this.mListeners = new HashMap();
        this.mLock = new Object();
        this.mRunnableScheduler = scheduler;
    }

    public void startTimer(final WorkGenerationalId id, long processingTimeMillis, TimeLimitExceededListener listener) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        Logger.get().debug(TAG, "Starting timer for " + id);     // Catch: Throwable -> L7
        stopTimer(id);     // Catch: Throwable -> L7
        WorkTimerRunnable r0 = new WorkTimerRunnable(this, id);     // Catch: Throwable -> L7
        this.mTimerMap.put(id, r0);     // Catch: Throwable -> L7
        this.mListeners.put(id, listener);     // Catch: Throwable -> L7
        this.mRunnableScheduler.scheduleWithDelay(processingTimeMillis, r0);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void stopTimer(final WorkGenerationalId id) {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mTimerMap.remove(id) == null) goto L7;
        Logger.get().debug(TAG, "Stopping timer for " + id);     // Catch: Throwable -> L9
        this.mListeners.remove(id);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r1);     // Catch: Throwable -> L9
    }

    public Map<WorkGenerationalId, WorkTimerRunnable> getTimerMap() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Map<WorkGenerationalId, WorkTimerRunnable> r1 = this.mTimerMap;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public Map<WorkGenerationalId, TimeLimitExceededListener> getListeners() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Map<WorkGenerationalId, TimeLimitExceededListener> r1 = this.mListeners;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
