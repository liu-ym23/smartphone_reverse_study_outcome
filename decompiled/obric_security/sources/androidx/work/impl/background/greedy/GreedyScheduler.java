package androidx.work.impl.background.greedy;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Scheduler;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.WorkConstraintsTrackerImpl;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.ProcessUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class GreedyScheduler implements Scheduler, WorkConstraintsCallback, ExecutionListener {
    private static final String TAG = null;
    private final Set<WorkSpec> mConstrainedWorkSpecs;
    private final Context mContext;
    private DelayedWorkTracker mDelayedWorkTracker;
    Boolean mInDefaultProcess;
    private final Object mLock;
    private boolean mRegisteredExecutionListener;
    private final StartStopTokens mStartStopTokens;
    private final WorkConstraintsTracker mWorkConstraintsTracker;
    private final WorkManagerImpl mWorkManagerImpl;

    @Override // androidx.work.impl.Scheduler
    public boolean hasLimitedSchedulingSlots() {
        return false;
    }

    static {
        TAG = Logger.tagWithPrefix("GreedyScheduler");
    }

    public GreedyScheduler(Context context, Configuration configuration, Trackers trackers, WorkManagerImpl workManagerImpl) {
        this.mConstrainedWorkSpecs = new HashSet();
        this.mStartStopTokens = new StartStopTokens();
        this.mContext = context;
        this.mWorkManagerImpl = workManagerImpl;
        this.mWorkConstraintsTracker = new WorkConstraintsTrackerImpl(trackers, this);
        this.mDelayedWorkTracker = new DelayedWorkTracker(this, configuration.getRunnableScheduler());
        this.mLock = new Object();
    }

    public GreedyScheduler(Context context, WorkManagerImpl workManagerImpl, WorkConstraintsTracker workConstraintsTracker) {
        this.mConstrainedWorkSpecs = new HashSet();
        this.mStartStopTokens = new StartStopTokens();
        this.mContext = context;
        this.mWorkManagerImpl = workManagerImpl;
        this.mWorkConstraintsTracker = workConstraintsTracker;
        this.mLock = new Object();
    }

    public void setDelayedWorkTracker(DelayedWorkTracker delayedWorkTracker) {
        this.mDelayedWorkTracker = delayedWorkTracker;
    }

    @Override // androidx.work.impl.Scheduler
    public void schedule(WorkSpec... workSpecs) {
        if (this.mInDefaultProcess != null) goto L6;
        checkDefaultProcess();
    L6:
        if (this.mInDefaultProcess.booleanValue() == true) goto L9;
        Logger.get().info(TAG, "Ignoring schedule request in a secondary process");
        return;
    L9:
        registerExecutionListenerIfNeeded();
        HashSet r0 = new HashSet();
        HashSet r1 = new HashSet();
        int r2 = workSpecs.length;
        int r3 = 0;
    L10:
        if (r3 >= r2) goto L34;
        WorkSpec r4 = workSpecs[r3];
        if (this.mStartStopTokens.contains(WorkSpecKt.generationalId(r4)) == true) goto L33;
        long r5 = r4.calculateNextRunTime();
        long r7 = System.currentTimeMillis();
        if (r4.state != WorkInfo.State.ENQUEUED) goto L33;
        if (r7 >= r5) goto L22;
        DelayedWorkTracker r6 = this.mDelayedWorkTracker;
        if (r6 == null) goto L33;
        r6.schedule(r4);
        goto L33
    L22:
        if (r4.hasConstraints() == false) goto L31;
        if (r4.constraints.requiresDeviceIdle() == false) goto L27;
        Logger.get().debug(TAG, "Ignoring " + r4 + ". Requires device idle.");
        goto L33
    L27:
        if (r4.constraints.hasContentUriTriggers() == false) goto L29;
        Logger.get().debug(TAG, "Ignoring " + r4 + ". Requires ContentUri triggers.");
        goto L33
    L29:
        r0.add(r4);
        r1.add(r4.id);
        goto L33
    L31:
        if (this.mStartStopTokens.contains(WorkSpecKt.generationalId(r4)) == true) goto L33;
        Logger.get().debug(TAG, "Starting work for " + r4.id);
        this.mWorkManagerImpl.startWork(this.mStartStopTokens.tokenFor(r4));
    L33:
        r3 = r3 + 1;
        goto L10
    L34:
        Object r12 = this.mLock;
        monitor-enter(r12);
    L41:
        th = move-exception;
        throw th;
    L37:
        if (r0.isEmpty() == true) goto L39;
        Logger.get().debug(TAG, "Starting tracking for " + TextUtils.join(",", r1));     // Catch: Throwable -> L41
        this.mConstrainedWorkSpecs.addAll(r0);     // Catch: Throwable -> L41
        this.mWorkConstraintsTracker.replace(this.mConstrainedWorkSpecs);     // Catch: Throwable -> L41
    L39:
        monitor-exit(r12);     // Catch: Throwable -> L41
    }

    private void checkDefaultProcess() {
        Configuration r0 = this.mWorkManagerImpl.getConfiguration();
        this.mInDefaultProcess = Boolean.valueOf(ProcessUtils.isDefaultProcess(this.mContext, r0));
    }

    @Override // androidx.work.impl.Scheduler
    public void cancel(String workSpecId) {
        if (this.mInDefaultProcess != null) goto L6;
        checkDefaultProcess();
    L6:
        if (this.mInDefaultProcess.booleanValue() == true) goto L9;
        Logger.get().info(TAG, "Ignoring schedule request in non-main process");
        return;
    L9:
        registerExecutionListenerIfNeeded();
        Logger.get().debug(TAG, "Cancelling work ID " + workSpecId);
        DelayedWorkTracker r0 = this.mDelayedWorkTracker;
        if (r0 == null) goto L12;
        r0.unschedule(workSpecId);
    L12:
        Iterator<StartStopToken> r5 = this.mStartStopTokens.remove(workSpecId).iterator();
    L14:
        if (r5.hasNext() == false) goto L16;
        this.mWorkManagerImpl.stopWork(r5.next());
        goto L14
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsMet(List<WorkSpec> workSpecs) {
        Iterator<WorkSpec> r6 = workSpecs.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        WorkGenerationalId r0 = WorkSpecKt.generationalId(r6.next());
        if (this.mStartStopTokens.contains(r0) == true) goto L4;
        Logger.get().debug(TAG, "Constraints met: Scheduling work ID " + r0);
        this.mWorkManagerImpl.startWork(this.mStartStopTokens.tokenFor(r0));
        goto L4
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsNotMet(List<WorkSpec> workSpecs) {
        Iterator<WorkSpec> r6 = workSpecs.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        WorkGenerationalId r0 = WorkSpecKt.generationalId(r6.next());
        Logger.get().debug(TAG, "Constraints not met: Cancelling work ID " + r0);
        StartStopToken r1 = this.mStartStopTokens.remove(r0);
        if (r1 == null) goto L4;
        this.mWorkManagerImpl.stopWork(r1);
        goto L4
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(WorkGenerationalId id, boolean needsReschedule) {
        this.mStartStopTokens.remove(id);
        removeConstraintTrackingFor(id);
    }

    private void removeConstraintTrackingFor(WorkGenerationalId id) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Iterator<WorkSpec> r1 = this.mConstrainedWorkSpecs.iterator();     // Catch: Throwable -> L12
    L6:
        if (r1.hasNext() == false) goto L10;
        WorkSpec r2 = r1.next();     // Catch: Throwable -> L12
        if (WorkSpecKt.generationalId(r2).equals(id) == false) goto L6;
        Logger.get().debug(TAG, "Stopping tracking for " + id);     // Catch: Throwable -> L12
        this.mConstrainedWorkSpecs.remove(r2);     // Catch: Throwable -> L12
        this.mWorkConstraintsTracker.replace(this.mConstrainedWorkSpecs);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private void registerExecutionListenerIfNeeded() {
        if (this.mRegisteredExecutionListener == true) goto L6;
        this.mWorkManagerImpl.getProcessor().addExecutionListener(this);
        this.mRegisteredExecutionListener = true;
        return;
    }
}
