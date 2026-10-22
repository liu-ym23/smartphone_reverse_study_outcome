package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.os.PowerManager;
import androidx.work.Logger;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTrackerImpl;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class DelayMetCommandHandler implements WorkConstraintsCallback, WorkTimer.TimeLimitExceededListener {
    private static final int STATE_INITIAL = 0;
    private static final int STATE_START_REQUESTED = 1;
    private static final int STATE_STOP_REQUESTED = 2;
    private static final String TAG = null;
    private final Context mContext;
    private int mCurrentState;
    private final SystemAlarmDispatcher mDispatcher;
    private boolean mHasConstraints;
    private final Object mLock;
    private final Executor mMainThreadExecutor;
    private final Executor mSerialExecutor;
    private final int mStartId;
    private final StartStopToken mToken;
    private PowerManager.WakeLock mWakeLock;
    private final WorkConstraintsTrackerImpl mWorkConstraintsTracker;
    private final WorkGenerationalId mWorkGenerationalId;

    public static /* synthetic */ void $r8$lambda$eO2qKQGv6m2bOk3OWPYOjoDKq0o(DelayMetCommandHandler r0) {
        r0.startWork();
    }

    public static /* synthetic */ void $r8$lambda$zaVpSTkR_s413bgOQo09yONkKkY(DelayMetCommandHandler r0) {
        r0.stopWork();
    }

    static {
        TAG = Logger.tagWithPrefix("DelayMetCommandHandler");
    }

    DelayMetCommandHandler(Context context, int startId, SystemAlarmDispatcher dispatcher, StartStopToken startStopToken) {
        this.mContext = context;
        this.mStartId = startId;
        this.mDispatcher = dispatcher;
        this.mWorkGenerationalId = startStopToken.getId();
        this.mToken = startStopToken;
        Trackers r1 = dispatcher.getWorkManager().getTrackers();
        this.mSerialExecutor = dispatcher.getTaskExecutor().getSerialTaskExecutor();
        this.mMainThreadExecutor = dispatcher.getTaskExecutor().getMainThreadExecutor();
        this.mWorkConstraintsTracker = new WorkConstraintsTrackerImpl(r1, this);
        this.mHasConstraints = false;
        this.mCurrentState = 0;
        this.mLock = new Object();
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsMet(List<WorkSpec> workSpecs) {
        Iterator<WorkSpec> r3 = workSpecs.iterator();
    L4:
        if (r3.hasNext() == false) goto L12;
        if (WorkSpecKt.generationalId(r3.next()).equals(this.mWorkGenerationalId) == false) goto L4;
        this.mSerialExecutor.execute(new DelayMetCommandHandler$$ExternalSyntheticLambda1(this));
        return;
    }

    private void startWork() {
        if (this.mCurrentState != 0) goto L8;
        this.mCurrentState = 1;
        Logger.get().debug(TAG, "onAllConstraintsMet for " + this.mWorkGenerationalId);
        if (this.mDispatcher.getProcessor().startWork(this.mToken) == false) goto L7;
        this.mDispatcher.getWorkTimer().startTimer(this.mWorkGenerationalId, 600000, this);
        return;
    L7:
        cleanUp();
        return;
    L8:
        Logger.get().debug(TAG, "Already started work for " + this.mWorkGenerationalId);
    }

    void onExecuted(boolean needsReschedule) {
        Logger.get().debug(TAG, "onExecuted " + this.mWorkGenerationalId + ", " + needsReschedule);
        cleanUp();
        if (needsReschedule == false) goto L6;
        this.mMainThreadExecutor.execute(new SystemAlarmDispatcher.AddRunnable(this.mDispatcher, CommandHandler.createScheduleWorkIntent(this.mContext, this.mWorkGenerationalId), this.mStartId));
    L6:
        if (this.mHasConstraints == false) goto L9;
        this.mMainThreadExecutor.execute(new SystemAlarmDispatcher.AddRunnable(this.mDispatcher, CommandHandler.createConstraintsChangedIntent(this.mContext), this.mStartId));
        return;
    }

    @Override // androidx.work.impl.utils.WorkTimer.TimeLimitExceededListener
    public void onTimeLimitExceeded(WorkGenerationalId id) {
        Logger.get().debug(TAG, "Exceeded time limits on execution for " + id);
        this.mSerialExecutor.execute(new DelayMetCommandHandler$$ExternalSyntheticLambda0(this));
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsNotMet(List<WorkSpec> workSpecs) {
        this.mSerialExecutor.execute(new DelayMetCommandHandler$$ExternalSyntheticLambda0(this));
    }

    void handleProcessWork() {
        String r0 = this.mWorkGenerationalId.getWorkSpecId();
        this.mWakeLock = WakeLocks.newWakeLock(this.mContext, r0 + " (" + this.mStartId + ")");
        Logger r1 = Logger.get();
        String r2 = TAG;
        r1.debug(r2, "Acquiring wakelock " + this.mWakeLock + "for WorkSpec " + r0);
        this.mWakeLock.acquire();
        WorkSpec r3 = this.mDispatcher.getWorkManager().getWorkDatabase().workSpecDao().getWorkSpec(r0);
        if (r3 != null) goto L6;
        this.mSerialExecutor.execute(new DelayMetCommandHandler$$ExternalSyntheticLambda0(this));
        return;
    L6:
        boolean r4 = r3.hasConstraints();
        this.mHasConstraints = r4;
        if (r4 == true) goto L9;
        Logger.get().debug(r2, "No constraints for " + r0);
        onAllConstraintsMet(Collections.singletonList(r3));
        return;
    L9:
        this.mWorkConstraintsTracker.replace(Collections.singletonList(r3));
    }

    private void stopWork() {
        String r0 = this.mWorkGenerationalId.getWorkSpecId();
        if (this.mCurrentState >= 2) goto L8;
        this.mCurrentState = 2;
        Logger r1 = Logger.get();
        String r2 = TAG;
        r1.debug(r2, "Stopping work for WorkSpec " + r0);
        this.mMainThreadExecutor.execute(new SystemAlarmDispatcher.AddRunnable(this.mDispatcher, CommandHandler.createStopWorkIntent(this.mContext, this.mWorkGenerationalId), this.mStartId));
        if (this.mDispatcher.getProcessor().isEnqueued(this.mWorkGenerationalId.getWorkSpecId()) == false) goto L7;
        Logger.get().debug(r2, "WorkSpec " + r0 + " needs to be rescheduled");
        this.mMainThreadExecutor.execute(new SystemAlarmDispatcher.AddRunnable(this.mDispatcher, CommandHandler.createScheduleWorkIntent(this.mContext, this.mWorkGenerationalId), this.mStartId));
        return;
    L7:
        Logger.get().debug(r2, "Processor does not have WorkSpec " + r0 + ". No need to reschedule");
        return;
    L8:
        Logger.get().debug(TAG, "Already stopped work for " + r0);
    }

    private void cleanUp() {
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mWorkConstraintsTracker.reset();     // Catch: Throwable -> L11
        this.mDispatcher.getWorkTimer().stopTimer(this.mWorkGenerationalId);     // Catch: Throwable -> L11
        PowerManager.WakeLock r2 = this.mWakeLock;     // Catch: Throwable -> L11
        if (r2 != null) goto L7;
    L9:
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L7:
        if (r2.isHeld() == false) goto L9;
        Logger.get().debug(TAG, "Releasing wakelock " + this.mWakeLock + "for WorkSpec " + this.mWorkGenerationalId);     // Catch: Throwable -> L11
        this.mWakeLock.release();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
