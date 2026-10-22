package androidx.work.impl;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.Data;
import androidx.work.InputMerger;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.WorkerParameters;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.PackageManagerHelper;
import androidx.work.impl.utils.SynchronousExecutor;
import androidx.work.impl.utils.WorkForegroundRunnable;
import androidx.work.impl.utils.WorkForegroundUpdater;
import androidx.work.impl.utils.WorkProgressUpdater;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class WorkerWrapper implements Runnable {
    static final String TAG = null;
    Context mAppContext;
    private Configuration mConfiguration;
    private DependencyDao mDependencyDao;
    private ForegroundProcessor mForegroundProcessor;
    SettableFuture<Boolean> mFuture;
    private volatile boolean mInterrupted;
    ListenableWorker.Result mResult;
    private WorkerParameters.RuntimeExtras mRuntimeExtras;
    private List<Scheduler> mSchedulers;
    private List<String> mTags;
    private WorkDatabase mWorkDatabase;
    private String mWorkDescription;
    WorkSpec mWorkSpec;
    private WorkSpecDao mWorkSpecDao;
    private final String mWorkSpecId;
    TaskExecutor mWorkTaskExecutor;
    ListenableWorker mWorker;
    final SettableFuture<ListenableWorker.Result> mWorkerResultFuture;

    public static class Builder {
        Context mAppContext;
        Configuration mConfiguration;
        ForegroundProcessor mForegroundProcessor;
        WorkerParameters.RuntimeExtras mRuntimeExtras;
        List<Scheduler> mSchedulers;
        private final List<String> mTags;
        WorkDatabase mWorkDatabase;
        WorkSpec mWorkSpec;
        TaskExecutor mWorkTaskExecutor;
        ListenableWorker mWorker;

        static /* synthetic */ List access$000(Builder r0) {
            return r0.mTags;
        }

        public Builder(Context context, Configuration configuration, TaskExecutor workTaskExecutor, ForegroundProcessor foregroundProcessor, WorkDatabase database, WorkSpec workSpec, List<String> tags) {
            this.mRuntimeExtras = new WorkerParameters.RuntimeExtras();
            this.mAppContext = context.getApplicationContext();
            this.mWorkTaskExecutor = workTaskExecutor;
            this.mForegroundProcessor = foregroundProcessor;
            this.mConfiguration = configuration;
            this.mWorkDatabase = database;
            this.mWorkSpec = workSpec;
            this.mTags = tags;
        }

        public Builder withSchedulers(List<Scheduler> schedulers) {
            this.mSchedulers = schedulers;
            return this;
        }

        public Builder withRuntimeExtras(WorkerParameters.RuntimeExtras runtimeExtras) {
            if (runtimeExtras == null) goto L4;
            this.mRuntimeExtras = runtimeExtras;
        L4:
            return this;
        }

        public Builder withWorker(ListenableWorker worker) {
            this.mWorker = worker;
            return this;
        }

        public WorkerWrapper build() {
            return new WorkerWrapper(this);
        }
    }

    static {
        TAG = Logger.tagWithPrefix("WorkerWrapper");
    }

    WorkerWrapper(Builder builder) {
        this.mResult = ListenableWorker.Result.failure();
        this.mFuture = SettableFuture.create();
        this.mWorkerResultFuture = SettableFuture.create();
        this.mAppContext = builder.mAppContext;
        this.mWorkTaskExecutor = builder.mWorkTaskExecutor;
        this.mForegroundProcessor = builder.mForegroundProcessor;
        WorkSpec r0 = builder.mWorkSpec;
        this.mWorkSpec = r0;
        this.mWorkSpecId = r0.id;
        this.mSchedulers = builder.mSchedulers;
        this.mRuntimeExtras = builder.mRuntimeExtras;
        this.mWorker = builder.mWorker;
        this.mConfiguration = builder.mConfiguration;
        WorkDatabase r1 = builder.mWorkDatabase;
        this.mWorkDatabase = r1;
        this.mWorkSpecDao = r1.workSpecDao();
        this.mDependencyDao = this.mWorkDatabase.dependencyDao();
        this.mTags = Builder.access$000(builder);
    }

    public WorkGenerationalId getWorkGenerationalId() {
        return WorkSpecKt.generationalId(this.mWorkSpec);
    }

    public ListenableFuture<Boolean> getFuture() {
        return this.mFuture;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mWorkDescription = createWorkDescription(this.mTags);
        runWorker();
    }

    public WorkSpec getWorkSpec() {
        return this.mWorkSpec;
    }

    private void runWorker() {
        if (tryCheckForInterruptionAndResolve() == false) goto L5;
        return;
    L5:
        this.mWorkDatabase.beginTransaction();
    L49:
        th = move-exception;
        this.mWorkDatabase.endTransaction();
        throw th;
    L7:
        if (this.mWorkSpec.state == WorkInfo.State.ENQUEUED) goto L12;
        resolveIncorrectStatus();     // Catch: Throwable -> L49
        this.mWorkDatabase.setTransactionSuccessful();     // Catch: Throwable -> L49
        Logger.get().debug(TAG, this.mWorkSpec.workerClassName + " is not in ENQUEUED state. Nothing more to do");     // Catch: Throwable -> L49
        this.mWorkDatabase.endTransaction();
        return;
    L12:
        if (this.mWorkSpec.isPeriodic() == true) goto L16;
        if (this.mWorkSpec.isBackedOff() == true) goto L16;
    L20:
        this.mWorkDatabase.setTransactionSuccessful();     // Catch: Throwable -> L49
        this.mWorkDatabase.endTransaction();
        if (this.mWorkSpec.isPeriodic() == false) goto L25;
        Data r0 = this.mWorkSpec.input;
    L30:
        WorkerParameters r1 = new WorkerParameters(UUID.fromString(this.mWorkSpecId), r0, this.mTags, this.mRuntimeExtras, this.mWorkSpec.runAttemptCount, this.mWorkSpec.getGeneration(), this.mConfiguration.getExecutor(), this.mWorkTaskExecutor, this.mConfiguration.getWorkerFactory(), new WorkProgressUpdater(this.mWorkDatabase, this.mWorkTaskExecutor), new WorkForegroundUpdater(this.mWorkDatabase, this.mForegroundProcessor, this.mWorkTaskExecutor));
        if (this.mWorker != null) goto L33;
        this.mWorker = this.mConfiguration.getWorkerFactory().createWorkerWithDefaultFallback(this.mAppContext, this.mWorkSpec.workerClassName, r1);
    L33:
        ListenableWorker r2 = this.mWorker;
        if (r2 != null) goto L38;
        Logger.get().error(TAG, "Could not create Worker " + this.mWorkSpec.workerClassName);
        setFailedAndResolve();
        return;
    L38:
        if (r2.isUsed() == false) goto L41;
        Logger.get().error(TAG, "Received an already-used Worker " + this.mWorkSpec.workerClassName + "; Worker Factory should return new instances");
        setFailedAndResolve();
        return;
    L41:
        this.mWorker.setUsed();
        if (trySetRunning() == true) goto L44;
        resolveIncorrectStatus();
        return;
    L44:
        if (tryCheckForInterruptionAndResolve() == false) goto L46;
        return;
    L46:
        WorkForegroundRunnable r3 = new WorkForegroundRunnable(this.mAppContext, this.mWorkSpec, this.mWorker, r1.getForegroundUpdater(), this.mWorkTaskExecutor);
        this.mWorkTaskExecutor.getMainThreadExecutor().execute(r3);
        final ListenableFuture<Void> r4 = r3.getFuture();
        this.mWorkerResultFuture.addListener(new WorkerWrapper$$ExternalSyntheticLambda0(this, r4), new SynchronousExecutor());
        r4.addListener(new AnonymousClass1(this, r4), this.mWorkTaskExecutor.getMainThreadExecutor());
        final String r5 = this.mWorkDescription;
        this.mWorkerResultFuture.addListener(new AnonymousClass2(this, r5), this.mWorkTaskExecutor.getSerialTaskExecutor());
        return;
    L25:
        InputMerger r6 = this.mConfiguration.getInputMergerFactory().createInputMergerWithDefaultFallback(this.mWorkSpec.inputMergerClassName);
        if (r6 != null) goto L29;
        Logger.get().error(TAG, "Could not create Input Merger " + this.mWorkSpec.inputMergerClassName);
        setFailedAndResolve();
        return;
    L29:
        ArrayList r7 = new ArrayList();
        r7.add(this.mWorkSpec.input);
        r7.addAll(this.mWorkSpecDao.getInputsFromPrerequisites(this.mWorkSpecId));
        r0 = r6.merge(r7);
    L16:
        if (System.currentTimeMillis() >= this.mWorkSpec.calculateNextRunTime()) goto L20;
        Logger.get().debug(TAG, String.format("Delaying execution for %s because it is being executed before schedule.", new Object[]{this.mWorkSpec.workerClassName}));     // Catch: Throwable -> L49
        resolve(true);     // Catch: Throwable -> L49
        this.mWorkDatabase.setTransactionSuccessful();     // Catch: Throwable -> L49
        this.mWorkDatabase.endTransaction();
    }

    /* JADX INFO: renamed from: lambda$runWorker$0$androidx-work-impl-WorkerWrapper, reason: not valid java name */
    /* synthetic */ void m65lambda$runWorker$0$androidxworkimplWorkerWrapper(ListenableFuture r1) {
        if (this.mWorkerResultFuture.isCancelled() == false) goto L6;
        r1.cancel(true);
        return;
    }

    void onWorkFinished() {
        if (tryCheckForInterruptionAndResolve() == true) goto L19;
        this.mWorkDatabase.beginTransaction();
        WorkInfo.State r0 = this.mWorkSpecDao.getState(this.mWorkSpecId);     // Catch: Throwable -> L16
        this.mWorkDatabase.workProgressDao().delete(this.mWorkSpecId);     // Catch: Throwable -> L16
        if (r0 != null) goto L9;
        resolve(false);     // Catch: Throwable -> L16
    L14:
        this.mWorkDatabase.setTransactionSuccessful();     // Catch: Throwable -> L16
        this.mWorkDatabase.endTransaction();
        goto L19
    L9:
        if (r0 != WorkInfo.State.RUNNING) goto L12;
        handleResult(this.mResult);     // Catch: Throwable -> L16
        goto L14
    L12:
        if (r0.isFinished() == true) goto L14;
        rescheduleAndResolve();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        this.mWorkDatabase.endTransaction();
        throw th;
    L19:
        List<Scheduler> r1 = this.mSchedulers;
        if (r1 == null) goto L30;
        Iterator<Scheduler> r2 = r1.iterator();
    L23:
        if (r2.hasNext() == false) goto L25;
        r2.next().cancel(this.mWorkSpecId);
        goto L23
    L25:
        Schedulers.schedule(this.mConfiguration, this.mWorkDatabase, this.mSchedulers);
        return;
    }

    public void interrupt() {
        this.mInterrupted = true;
        tryCheckForInterruptionAndResolve();
        this.mWorkerResultFuture.cancel(true);
        if (this.mWorker != null) goto L5;
    L7:
        Logger.get().debug(TAG, "WorkSpec " + this.mWorkSpec + " is already done. Not interrupting.");
        return;
    L5:
        if (this.mWorkerResultFuture.isCancelled() == false) goto L7;
        this.mWorker.stop();
    }

    private void resolveIncorrectStatus() {
        WorkInfo.State r0 = this.mWorkSpecDao.getState(this.mWorkSpecId);
        if (r0 != WorkInfo.State.RUNNING) goto L5;
        Logger.get().debug(TAG, "Status for " + this.mWorkSpecId + " is RUNNING; not doing any work and rescheduling for later execution");
        resolve(true);
        return;
    L5:
        Logger.get().debug(TAG, "Status for " + this.mWorkSpecId + " is " + r0 + " ; not doing any work");
        resolve(false);
    }

    private boolean tryCheckForInterruptionAndResolve() {
        if (this.mInterrupted == false) goto L9;
        Logger.get().debug(TAG, "Work interrupted for " + this.mWorkDescription);
        WorkInfo.State r0 = this.mWorkSpecDao.getState(this.mWorkSpecId);
        if (r0 != null) goto L7;
        resolve(false);
    L8:
        return true;
    L7:
        resolve(!r0.isFinished());
        goto L8
    L9:
        return false;
    }

    private void resolve(final boolean needsReschedule) {
        this.mWorkDatabase.beginTransaction();
    L18:
        th = move-exception;
        this.mWorkDatabase.endTransaction();
        throw th;
    L4:
        if (this.mWorkDatabase.workSpecDao().hasUnfinishedWork() == true) goto L6;
        PackageManagerHelper.setComponentEnabled(this.mAppContext, RescheduleReceiver.class, false);     // Catch: Throwable -> L18
    L6:
        if (needsReschedule == false) goto L9;
        this.mWorkSpecDao.setState(WorkInfo.State.ENQUEUED, this.mWorkSpecId);     // Catch: Throwable -> L18
        this.mWorkSpecDao.markWorkSpecScheduled(this.mWorkSpecId, -1);     // Catch: Throwable -> L18
    L9:
        if (this.mWorkSpec != null) goto L11;
    L15:
        this.mWorkDatabase.setTransactionSuccessful();     // Catch: Throwable -> L18
        this.mWorkDatabase.endTransaction();
        this.mFuture.set(Boolean.valueOf(needsReschedule));
        return;
    L11:
        if (this.mWorker == null) goto L15;
        if (this.mForegroundProcessor.isEnqueuedInForeground(this.mWorkSpecId) == false) goto L15;
        this.mForegroundProcessor.stopForeground(this.mWorkSpecId);     // Catch: Throwable -> L18
        goto L15
    }

    private void handleResult(ListenableWorker.Result result) {
        if ((result instanceof ListenableWorker.Result.Success) == false) goto L9;
        Logger.get().info(TAG, "Worker result SUCCESS for " + this.mWorkDescription);
        if (this.mWorkSpec.isPeriodic() == false) goto L7;
        resetPeriodicAndResolve();
        return;
    L7:
        setSucceededAndResolve();
        return;
    L9:
        if ((result instanceof ListenableWorker.Result.Retry) == false) goto L11;
        Logger.get().info(TAG, "Worker result RETRY for " + this.mWorkDescription);
        rescheduleAndResolve();
        return;
    L11:
        Logger.get().info(TAG, "Worker result FAILURE for " + this.mWorkDescription);
        if (this.mWorkSpec.isPeriodic() == false) goto L14;
        resetPeriodicAndResolve();
        return;
    L14:
        setFailedAndResolve();
    }

    private boolean trySetRunning() {
        this.mWorkDatabase.beginTransaction();
    L10:
        th = move-exception;
        this.mWorkDatabase.endTransaction();
        throw th;
    L4:
        if (this.mWorkSpecDao.getState(this.mWorkSpecId) != WorkInfo.State.ENQUEUED) goto L6;
        this.mWorkSpecDao.setState(WorkInfo.State.RUNNING, this.mWorkSpecId);     // Catch: Throwable -> L10
        this.mWorkSpecDao.incrementWorkSpecRunAttemptCount(this.mWorkSpecId);     // Catch: Throwable -> L10
        boolean r0 = true;
    L7:
        this.mWorkDatabase.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.mWorkDatabase.endTransaction();
        return r0;
    L6:
        r0 = false;
        goto L7
    }

    void setFailedAndResolve() {
        this.mWorkDatabase.beginTransaction();
        iterativelyFailWorkAndDependents(this.mWorkSpecId);     // Catch: Throwable -> L6
        Data r1 = ((ListenableWorker.Result.Failure) this.mResult).getOutputData();     // Catch: Throwable -> L6
        this.mWorkSpecDao.setOutput(this.mWorkSpecId, r1);     // Catch: Throwable -> L6
        this.mWorkDatabase.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.mWorkDatabase.endTransaction();
        resolve(false);
        return;
    L6:
        th = move-exception;
        this.mWorkDatabase.endTransaction();
        resolve(false);
        throw th;
    }

    private void iterativelyFailWorkAndDependents(String workSpecId) {
        LinkedList r0 = new LinkedList();
        r0.add(workSpecId);
    L4:
        if (r0.isEmpty() == true) goto L9;
        String r4 = (String) r0.remove();
        if (this.mWorkSpecDao.getState(r4) == WorkInfo.State.CANCELLED) goto L8;
        this.mWorkSpecDao.setState(WorkInfo.State.FAILED, r4);
    L8:
        r0.addAll(this.mDependencyDao.getDependentWorkIds(r4));
        goto L4
    }

    private void rescheduleAndResolve() {
        this.mWorkDatabase.beginTransaction();
        this.mWorkSpecDao.setState(WorkInfo.State.ENQUEUED, this.mWorkSpecId);     // Catch: Throwable -> L6
        this.mWorkSpecDao.setLastEnqueuedTime(this.mWorkSpecId, System.currentTimeMillis());     // Catch: Throwable -> L6
        this.mWorkSpecDao.markWorkSpecScheduled(this.mWorkSpecId, -1);     // Catch: Throwable -> L6
        this.mWorkDatabase.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.mWorkDatabase.endTransaction();
        resolve(true);
        return;
    L6:
        th = move-exception;
        this.mWorkDatabase.endTransaction();
        resolve(true);
        throw th;
    }

    private void resetPeriodicAndResolve() {
        this.mWorkDatabase.beginTransaction();
        this.mWorkSpecDao.setLastEnqueuedTime(this.mWorkSpecId, System.currentTimeMillis());     // Catch: Throwable -> L6
        this.mWorkSpecDao.setState(WorkInfo.State.ENQUEUED, this.mWorkSpecId);     // Catch: Throwable -> L6
        this.mWorkSpecDao.resetWorkSpecRunAttemptCount(this.mWorkSpecId);     // Catch: Throwable -> L6
        this.mWorkSpecDao.incrementPeriodCount(this.mWorkSpecId);     // Catch: Throwable -> L6
        this.mWorkSpecDao.markWorkSpecScheduled(this.mWorkSpecId, -1);     // Catch: Throwable -> L6
        this.mWorkDatabase.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.mWorkDatabase.endTransaction();
        resolve(false);
        return;
    L6:
        th = move-exception;
        this.mWorkDatabase.endTransaction();
        resolve(false);
        throw th;
    }

    private void setSucceededAndResolve() {
        this.mWorkDatabase.beginTransaction();
        this.mWorkSpecDao.setState(WorkInfo.State.SUCCEEDED, this.mWorkSpecId);     // Catch: Throwable -> L14
        this.mWorkSpecDao.setOutput(this.mWorkSpecId, ((ListenableWorker.Result.Success) this.mResult).getOutputData());     // Catch: Throwable -> L14
        long r1 = System.currentTimeMillis();     // Catch: Throwable -> L14
        Iterator<String> r3 = this.mDependencyDao.getDependentWorkIds(this.mWorkSpecId).iterator();     // Catch: Throwable -> L14
    L5:
        if (r3.hasNext() == false) goto L11;
        String r4 = r3.next();     // Catch: Throwable -> L14
        if (this.mWorkSpecDao.getState(r4) != WorkInfo.State.BLOCKED) goto L5;
        if (this.mDependencyDao.hasCompletedAllPrerequisites(r4) == false) goto L5;
        Logger.get().info(TAG, "Setting status to enqueued for " + r4);     // Catch: Throwable -> L14
        this.mWorkSpecDao.setState(WorkInfo.State.ENQUEUED, r4);     // Catch: Throwable -> L14
        this.mWorkSpecDao.setLastEnqueuedTime(r4, r1);     // Catch: Throwable -> L14
        goto L5
    L11:
        this.mWorkDatabase.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.mWorkDatabase.endTransaction();
        resolve(false);
        return;
    L14:
        th = move-exception;
        this.mWorkDatabase.endTransaction();
        resolve(false);
        throw th;
    }

    private String createWorkDescription(List<String> tags) {
        StringBuilder r3 = new StringBuilder("Work [ id=").append(this.mWorkSpecId).append(", tags={ ");
        Iterator<String> r4 = tags.iterator();
        boolean r0 = true;
    L4:
        if (r4.hasNext() == false) goto L10;
        String r1 = r4.next();
        if (r0 == false) goto L8;
        r0 = false;
    L9:
        r3.append(r1);
        goto L4
    L8:
        r3.append(", ");
        goto L9
    L10:
        r3.append(" } ]");
        return r3.toString();
    }
}
