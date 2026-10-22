package androidx.work.impl;

import android.content.Context;
import android.os.PowerManager;
import androidx.core.content.ContextCompat;
import androidx.work.Configuration;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class Processor implements ExecutionListener, ForegroundProcessor {
    private static final String FOREGROUND_WAKELOCK_TAG = "ProcessorForegroundLck";
    private static final String TAG = null;
    private Context mAppContext;
    private Set<String> mCancelledIds;
    private Configuration mConfiguration;
    private Map<String, WorkerWrapper> mEnqueuedWorkMap;
    private PowerManager.WakeLock mForegroundLock;
    private Map<String, WorkerWrapper> mForegroundWorkMap;
    private final Object mLock;
    private final List<ExecutionListener> mOuterListeners;
    private List<Scheduler> mSchedulers;
    private WorkDatabase mWorkDatabase;
    private Map<String, Set<StartStopToken>> mWorkRuns;
    private TaskExecutor mWorkTaskExecutor;

    private static class FutureListener implements Runnable {
        private ExecutionListener mExecutionListener;
        private ListenableFuture<Boolean> mFuture;
        private final WorkGenerationalId mWorkGenerationalId;

        FutureListener(ExecutionListener executionListener, WorkGenerationalId workGenerationalId, ListenableFuture<Boolean> future) {
            this.mExecutionListener = executionListener;
            this.mWorkGenerationalId = workGenerationalId;
            this.mFuture = future;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean r0 = this.mFuture.get().booleanValue();     // Catch: Throwable -> L4
        L5:
            this.mExecutionListener.onExecuted(this.mWorkGenerationalId, r0);
            return;
        L4:
            r0 = true;
            goto L5
        }
    }

    static {
        TAG = Logger.tagWithPrefix("Processor");
    }

    public Processor(Context appContext, Configuration configuration, TaskExecutor workTaskExecutor, WorkDatabase workDatabase, List<Scheduler> schedulers) {
        this.mAppContext = appContext;
        this.mConfiguration = configuration;
        this.mWorkTaskExecutor = workTaskExecutor;
        this.mWorkDatabase = workDatabase;
        this.mEnqueuedWorkMap = new HashMap();
        this.mForegroundWorkMap = new HashMap();
        this.mSchedulers = schedulers;
        this.mCancelledIds = new HashSet();
        this.mOuterListeners = new ArrayList();
        this.mForegroundLock = null;
        this.mLock = new Object();
        this.mWorkRuns = new HashMap();
    }

    public boolean startWork(StartStopToken id) {
        return startWork(id, null);
    }

    public boolean startWork(StartStopToken startStopToken, WorkerParameters.RuntimeExtras runtimeExtras) {
        WorkGenerationalId r1 = startStopToken.getId();
        final String r2 = r1.getWorkSpecId();
        final ArrayList r10 = new ArrayList();
        WorkSpec r9 = (WorkSpec) this.mWorkDatabase.runInTransaction(new Processor$$ExternalSyntheticLambda0(this, r10, r2));
        if (r9 != null) goto L6;
        Logger.get().warning(TAG, "Didn't find WorkSpec for id " + r1);
        runOnExecuted(r1, false);
        return false;
    L6:
        Object r11 = this.mLock;
        monitor-enter(r11);
    L25:
        th = move-exception;
        throw th;
    L9:
        if (isEnqueued(r2) == false) goto L17;
        Set<StartStopToken> r14 = this.mWorkRuns.get(r2);     // Catch: Throwable -> L25
        if (r14.iterator().next().getId().getGeneration() != r1.getGeneration()) goto L13;
        r14.add(startStopToken);     // Catch: Throwable -> L25
        Logger.get().debug(TAG, "Work " + r1 + " is already enqueued for processing");     // Catch: Throwable -> L25
    L14:
        monitor-exit(r11);     // Catch: Throwable -> L25
        return false;
    L13:
        runOnExecuted(r1, false);     // Catch: Throwable -> L25
        goto L14
    L17:
        if (r9.getGeneration() == r1.getGeneration()) goto L21;
        runOnExecuted(r1, false);     // Catch: Throwable -> L25
        monitor-exit(r11);     // Catch: Throwable -> L25
        return false;
    L21:
        WorkerWrapper r15 = new WorkerWrapper.Builder(this.mAppContext, this.mConfiguration, this.mWorkTaskExecutor, this, this.mWorkDatabase, r9, r10).withSchedulers(this.mSchedulers).withRuntimeExtras(runtimeExtras).build();     // Catch: Throwable -> L25
        ListenableFuture<Boolean> r0 = r15.getFuture();     // Catch: Throwable -> L25
        r0.addListener(new FutureListener(this, startStopToken.getId(), r0), this.mWorkTaskExecutor.getMainThreadExecutor());     // Catch: Throwable -> L25
        this.mEnqueuedWorkMap.put(r2, r15);     // Catch: Throwable -> L25
        HashSet r3 = new HashSet();     // Catch: Throwable -> L25
        r3.add(startStopToken);     // Catch: Throwable -> L25
        this.mWorkRuns.put(r2, r3);     // Catch: Throwable -> L25
        monitor-exit(r11);     // Catch: Throwable -> L25
        this.mWorkTaskExecutor.getSerialTaskExecutor().execute(r15);
        Logger.get().debug(TAG, getClass().getSimpleName() + ": processing " + r1);
        return true;
    }

    /* JADX INFO: renamed from: lambda$startWork$0$androidx-work-impl-Processor, reason: not valid java name */
    /* synthetic */ WorkSpec m63lambda$startWork$0$androidxworkimplProcessor(ArrayList r2, String r3) throws Exception {
        r2.addAll(this.mWorkDatabase.workTagDao().getTagsForWorkSpecId(r3));
        return this.mWorkDatabase.workSpecDao().getWorkSpec(r3);
    }

    @Override // androidx.work.impl.foreground.ForegroundProcessor
    public void startForeground(String workSpecId, ForegroundInfo foregroundInfo) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        Logger.get().info(TAG, "Moving WorkSpec (" + workSpecId + ") to the foreground");     // Catch: Throwable -> L12
        WorkerWrapper r0 = this.mEnqueuedWorkMap.remove(workSpecId);     // Catch: Throwable -> L12
        if (r0 != null) goto L7;
    L10:
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L7:
        if (this.mForegroundLock != null) goto L9;
        PowerManager.WakeLock r2 = WakeLocks.newWakeLock(this.mAppContext, FOREGROUND_WAKELOCK_TAG);     // Catch: Throwable -> L12
        this.mForegroundLock = r2;     // Catch: Throwable -> L12
        r2.acquire();     // Catch: Throwable -> L12
    L9:
        this.mForegroundWorkMap.put(workSpecId, r0);     // Catch: Throwable -> L12
        ContextCompat.startForegroundService(this.mAppContext, SystemForegroundDispatcher.createStartForegroundIntent(this.mAppContext, r0.getWorkGenerationalId(), foregroundInfo));     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public boolean stopForegroundWork(StartStopToken token) {
        String r6 = token.getId().getWorkSpecId();
        Object r1 = this.mLock;
        monitor-enter(r1);
        Logger.get().debug(TAG, "Processor stopping foreground work " + r6);     // Catch: Throwable -> L10
        WorkerWrapper r0 = this.mForegroundWorkMap.remove(r6);     // Catch: Throwable -> L10
        if (r0 == null) goto L7;
        this.mWorkRuns.remove(r6);     // Catch: Throwable -> L10
    L7:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return interrupt(r6, r0);
    L10:
        th = move-exception;
        throw th;
    }

    public boolean stopWork(StartStopToken runId) {
        String r2 = runId.getId().getWorkSpecId();
        Object r3 = this.mLock;
        monitor-enter(r3);
        WorkerWrapper r4 = this.mEnqueuedWorkMap.remove(r2);     // Catch: Throwable -> L20
        if (r4 != null) goto L9;
        Logger.get().debug(TAG, "WorkerWrapper could not be found for " + r2);     // Catch: Throwable -> L20
        monitor-exit(r3);     // Catch: Throwable -> L20
        return false;
    L9:
        Set<StartStopToken> r1 = this.mWorkRuns.get(r2);     // Catch: Throwable -> L20
        if (r1 != null) goto L12;
    L18:
        monitor-exit(r3);     // Catch: Throwable -> L20
        return false;
    L12:
        if (r1.contains(runId) == false) goto L18;
        Logger.get().debug(TAG, "Processor stopping background work " + r2);     // Catch: Throwable -> L20
        this.mWorkRuns.remove(r2);     // Catch: Throwable -> L20
        monitor-exit(r3);     // Catch: Throwable -> L20
        return interrupt(r2, r4);
    L20:
        th = move-exception;
        throw th;
    }

    public boolean stopAndCancelWork(String id) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        Logger.get().debug(TAG, "Processor cancelling " + id);     // Catch: Throwable -> L17
        this.mCancelledIds.add(id);     // Catch: Throwable -> L17
        WorkerWrapper r0 = this.mForegroundWorkMap.remove(id);     // Catch: Throwable -> L17
        if (r0 == null) goto L7;
        boolean r2 = true;
    L8:
        if (r0 != null) goto L10;
        r0 = this.mEnqueuedWorkMap.remove(id);     // Catch: Throwable -> L17
    L10:
        if (r0 == null) goto L12;
        this.mWorkRuns.remove(id);     // Catch: Throwable -> L17
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L17
        boolean r6 = interrupt(id, r0);
        if (r2 == false) goto L16;
        stopForegroundService();
    L16:
        return r6;
    L7:
        r2 = false;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.impl.foreground.ForegroundProcessor
    public void stopForeground(String workSpecId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mForegroundWorkMap.remove(workSpecId);     // Catch: Throwable -> L7
        stopForegroundService();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isCancelled(String id) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mCancelledIds.contains(id);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean hasWork() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mEnqueuedWorkMap.isEmpty() == true) goto L7;
    L10:
        boolean r2 = true;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r2;
    L7:
        if (this.mForegroundWorkMap.isEmpty() == false) goto L10;
        r2 = false;
        goto L11
    }

    public boolean isEnqueued(String workSpecId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mEnqueuedWorkMap.containsKey(workSpecId) == false) goto L7;
    L10:
        boolean r2 = true;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r2;
    L7:
        if (this.mForegroundWorkMap.containsKey(workSpecId) == true) goto L10;
        r2 = false;
        goto L11
    }

    @Override // androidx.work.impl.foreground.ForegroundProcessor
    public boolean isEnqueuedInForeground(String workSpecId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mForegroundWorkMap.containsKey(workSpecId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void addExecutionListener(ExecutionListener executionListener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mOuterListeners.add(executionListener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeExecutionListener(ExecutionListener executionListener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mOuterListeners.remove(executionListener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(final WorkGenerationalId id, boolean needsReschedule) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        WorkerWrapper r1 = this.mEnqueuedWorkMap.get(id.getWorkSpecId());     // Catch: Throwable -> L15
        if (r1 != null) goto L7;
    L9:
        Logger.get().debug(TAG, getClass().getSimpleName() + " " + id.getWorkSpecId() + " executed; reschedule = " + needsReschedule);     // Catch: Throwable -> L15
        Iterator<ExecutionListener> r5 = this.mOuterListeners.iterator();     // Catch: Throwable -> L15
    L11:
        if (r5.hasNext() == false) goto L13;
        r5.next().onExecuted(id, needsReschedule);     // Catch: Throwable -> L15
        goto L11
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L7:
        if (id.equals(r1.getWorkGenerationalId()) == false) goto L9;
        this.mEnqueuedWorkMap.remove(id.getWorkSpecId());     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public WorkSpec getRunningWorkSpec(String workSpecId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        WorkerWrapper r1 = this.mForegroundWorkMap.get(workSpecId);     // Catch: Throwable -> L14
        if (r1 != null) goto L7;
        r1 = this.mEnqueuedWorkMap.get(workSpecId);     // Catch: Throwable -> L14
    L7:
        if (r1 == null) goto L11;
        WorkSpec r2 = r1.getWorkSpec();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r2;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return null;
    L14:
        th = move-exception;
        throw th;
    }

    private void runOnExecuted(final WorkGenerationalId id, final boolean needsReschedule) {
        this.mWorkTaskExecutor.getMainThreadExecutor().execute(new Processor$$ExternalSyntheticLambda1(this, id, needsReschedule));
    }

    /* JADX INFO: renamed from: lambda$runOnExecuted$1$androidx-work-impl-Processor, reason: not valid java name */
    /* synthetic */ void m62lambda$runOnExecuted$1$androidxworkimplProcessor(WorkGenerationalId r1, boolean r2) {
        onExecuted(r1, r2);
    }

    private void stopForegroundService() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if ((!this.mForegroundWorkMap.isEmpty()) == false) goto L21;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L21:
        this.mAppContext.startService(SystemForegroundDispatcher.createStopForegroundIntent(this.mAppContext));     // Catch: Throwable -> L9
    L11:
        PowerManager.WakeLock r1 = this.mForegroundLock;     // Catch: Throwable -> L16
        if (r1 == null) goto L14;
        r1.release();     // Catch: Throwable -> L16
        this.mForegroundLock = null;     // Catch: Throwable -> L16
        goto L14
    L9:
        th = move-exception;
        Logger.get().error(TAG, "Unable to stop foreground service", th);     // Catch: Throwable -> L16
        goto L11
    }

    private static boolean interrupt(String id, WorkerWrapper wrapper) {
        if (wrapper == null) goto L5;
        wrapper.interrupt();
        Logger.get().debug(TAG, "WorkerWrapper interrupted for " + id);
        return true;
    L5:
        Logger.get().debug(TAG, "WorkerWrapper could not be found for " + id);
        return false;
    }
}
