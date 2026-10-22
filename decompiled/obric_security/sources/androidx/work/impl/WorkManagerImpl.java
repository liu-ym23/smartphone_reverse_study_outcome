package androidx.work.impl;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.work.Configuration;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.PeriodicWorkRequest;
import androidx.work.R;
import androidx.work.WorkContinuation;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkQuery;
import androidx.work.WorkRequest;
import androidx.work.WorkerParameters;
import androidx.work.impl.background.greedy.GreedyScheduler;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.CancelWorkRunnable;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.impl.utils.LiveDataUtils;
import androidx.work.impl.utils.PreferenceUtils;
import androidx.work.impl.utils.PruneWorkRunnable;
import androidx.work.impl.utils.RawQueries;
import androidx.work.impl.utils.StartWorkRunnable;
import androidx.work.impl.utils.StatusRunnable;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import androidx.work.multiprocess.RemoteWorkManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class WorkManagerImpl extends WorkManager {
    public static final int MAX_PRE_JOB_SCHEDULER_API_LEVEL = 22;
    public static final int MIN_JOB_SCHEDULER_API_LEVEL = 23;
    public static final String REMOTE_WORK_MANAGER_CLIENT = "androidx.work.multiprocess.RemoteWorkManagerClient";
    private static final String TAG = null;
    private static WorkManagerImpl sDefaultInstance;
    private static WorkManagerImpl sDelegatedInstance;
    private static final Object sLock = null;
    private Configuration mConfiguration;
    private Context mContext;
    private boolean mForceStopRunnableCompleted;
    private PreferenceUtils mPreferenceUtils;
    private Processor mProcessor;
    private volatile RemoteWorkManager mRemoteWorkManager;
    private BroadcastReceiver.PendingResult mRescheduleReceiverResult;
    private List<Scheduler> mSchedulers;
    private final Trackers mTrackers;
    private WorkDatabase mWorkDatabase;
    private TaskExecutor mWorkTaskExecutor;

    static class Api24Impl {
        private Api24Impl() {
        }

        static boolean isDeviceProtectedStorage(Context context) {
            return context.isDeviceProtectedStorage();
        }
    }

    static {
        TAG = Logger.tagWithPrefix("WorkManagerImpl");
        sDelegatedInstance = null;
        sDefaultInstance = null;
        sLock = new Object();
    }

    public static void setDelegate(WorkManagerImpl delegate) {
        Object r0 = sLock;
        monitor-enter(r0);
        sDelegatedInstance = delegate;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public static WorkManagerImpl getInstance() {
        Object r0 = sLock;
        monitor-enter(r0);
        WorkManagerImpl r1 = sDelegatedInstance;     // Catch: Throwable -> L11
        if (r1 == null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L8:
        WorkManagerImpl r2 = sDefaultInstance;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r2;
    L11:
        th = move-exception;
        throw th;
    }

    public static boolean isInitialized() {
        if (getInstance() == null) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static WorkManagerImpl getInstance(Context context) {
        Object r0 = sLock;
        monitor-enter(r0);
        WorkManagerImpl r1 = getInstance();     // Catch: Throwable -> L13
        if (r1 != null) goto L11;
        Context r2 = context.getApplicationContext();     // Catch: Throwable -> L13
        if ((r2 instanceof Configuration.Provider) == false) goto L10;
        initialize(r2, ((Configuration.Provider) r2).getWorkManagerConfiguration());     // Catch: Throwable -> L13
        r1 = getInstance(r2);     // Catch: Throwable -> L13
        goto L11
    L10:
        throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r1;
    L13:
        th = move-exception;
        throw th;
    }

    public static void initialize(Context context, Configuration configuration) {
        Object r0 = sLock;
        monitor-enter(r0);
        WorkManagerImpl r1 = sDelegatedInstance;     // Catch: Throwable -> L18
        if (r1 != null) goto L7;
    L11:
        if (r1 != null) goto L16;
        Context r4 = context.getApplicationContext();     // Catch: Throwable -> L18
        if (sDefaultInstance != null) goto L15;
        sDefaultInstance = new WorkManagerImpl(r4, configuration, new WorkManagerTaskExecutor(configuration.getTaskExecutor()));     // Catch: Throwable -> L18
    L15:
        sDelegatedInstance = sDefaultInstance;     // Catch: Throwable -> L18
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L7:
        if (sDefaultInstance == null) goto L11;
        throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public WorkManagerImpl(Context context, Configuration configuration, TaskExecutor workTaskExecutor) {
        this(context, configuration, workTaskExecutor, context.getResources().getBoolean(R.bool.workmanager_test_configuration));
    }

    public WorkManagerImpl(Context context, Configuration configuration, TaskExecutor workTaskExecutor, boolean useTestDatabase) {
        this(context, configuration, workTaskExecutor, WorkDatabase.create(context.getApplicationContext(), workTaskExecutor.getSerialTaskExecutor(), useTestDatabase));
    }

    public WorkManagerImpl(Context context, Configuration configuration, TaskExecutor workTaskExecutor, WorkDatabase database) {
        Context r0 = context.getApplicationContext();
        Logger.setLogger(new Logger.LogcatLogger(configuration.getMinimumLoggingLevel()));
        Trackers r1 = new Trackers(r0, workTaskExecutor);
        this.mTrackers = r1;
        List<Scheduler> r2 = createSchedulers(r0, configuration, r1);
        internalInit(context, configuration, workTaskExecutor, database, r2, new Processor(context, configuration, workTaskExecutor, database, r2));
    }

    public WorkManagerImpl(Context context, Configuration configuration, TaskExecutor workTaskExecutor, WorkDatabase workDatabase, List<Scheduler> schedulers, Processor processor) {
        this(context, configuration, workTaskExecutor, workDatabase, schedulers, processor, new Trackers(context.getApplicationContext(), workTaskExecutor));
    }

    public WorkManagerImpl(Context context, Configuration configuration, TaskExecutor workTaskExecutor, WorkDatabase workDatabase, List<Scheduler> schedulers, Processor processor, Trackers trackers) {
        this.mTrackers = trackers;
        internalInit(context, configuration, workTaskExecutor, workDatabase, schedulers, processor);
    }

    public Context getApplicationContext() {
        return this.mContext;
    }

    public WorkDatabase getWorkDatabase() {
        return this.mWorkDatabase;
    }

    @Override // androidx.work.WorkManager
    public Configuration getConfiguration() {
        return this.mConfiguration;
    }

    public List<Scheduler> getSchedulers() {
        return this.mSchedulers;
    }

    public Processor getProcessor() {
        return this.mProcessor;
    }

    public TaskExecutor getWorkTaskExecutor() {
        return this.mWorkTaskExecutor;
    }

    public PreferenceUtils getPreferenceUtils() {
        return this.mPreferenceUtils;
    }

    public Trackers getTrackers() {
        return this.mTrackers;
    }

    @Override // androidx.work.WorkManager
    public Operation enqueue(List<? extends WorkRequest> requests) {
        if (requests.isEmpty() == true) goto L7;
        return new WorkContinuationImpl(this, requests).enqueue();
    L7:
        throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
    }

    @Override // androidx.work.WorkManager
    public WorkContinuation beginWith(List<OneTimeWorkRequest> work) {
        if (work.isEmpty() == true) goto L7;
        return new WorkContinuationImpl(this, work);
    L7:
        throw new IllegalArgumentException("beginWith needs at least one OneTimeWorkRequest.");
    }

    @Override // androidx.work.WorkManager
    public WorkContinuation beginUniqueWork(String uniqueWorkName, ExistingWorkPolicy existingWorkPolicy, List<OneTimeWorkRequest> work) {
        if (work.isEmpty() == true) goto L7;
        return new WorkContinuationImpl(this, uniqueWorkName, existingWorkPolicy, work);
    L7:
        throw new IllegalArgumentException("beginUniqueWork needs at least one OneTimeWorkRequest.");
    }

    @Override // androidx.work.WorkManager
    public Operation enqueueUniqueWork(String uniqueWorkName, ExistingWorkPolicy existingWorkPolicy, List<OneTimeWorkRequest> work) {
        return new WorkContinuationImpl(this, uniqueWorkName, existingWorkPolicy, work).enqueue();
    }

    @Override // androidx.work.WorkManager
    public Operation enqueueUniquePeriodicWork(String uniqueWorkName, ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, PeriodicWorkRequest periodicWork) {
        if (existingPeriodicWorkPolicy != ExistingPeriodicWorkPolicy.UPDATE) goto L7;
        return WorkerUpdater.enqueueUniquelyNamedPeriodic(this, uniqueWorkName, periodicWork);
    L7:
        return createWorkContinuationForUniquePeriodicWork(uniqueWorkName, existingPeriodicWorkPolicy, periodicWork).enqueue();
    }

    public WorkContinuationImpl createWorkContinuationForUniquePeriodicWork(String uniqueWorkName, ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, PeriodicWorkRequest periodicWork) {
        if (existingPeriodicWorkPolicy != ExistingPeriodicWorkPolicy.KEEP) goto L5;
        ExistingWorkPolicy r3 = ExistingWorkPolicy.KEEP;
    L7:
        return new WorkContinuationImpl(this, uniqueWorkName, r3, Collections.singletonList(periodicWork));
    L5:
        r3 = ExistingWorkPolicy.REPLACE;
        goto L7
    }

    @Override // androidx.work.WorkManager
    public Operation cancelWorkById(UUID id) {
        CancelWorkRunnable r1 = CancelWorkRunnable.forId(id, this);
        this.mWorkTaskExecutor.executeOnTaskThread(r1);
        return r1.getOperation();
    }

    @Override // androidx.work.WorkManager
    public Operation cancelAllWorkByTag(final String tag) {
        CancelWorkRunnable r1 = CancelWorkRunnable.forTag(tag, this);
        this.mWorkTaskExecutor.executeOnTaskThread(r1);
        return r1.getOperation();
    }

    @Override // androidx.work.WorkManager
    public Operation cancelUniqueWork(String uniqueWorkName) {
        CancelWorkRunnable r2 = CancelWorkRunnable.forName(uniqueWorkName, this, true);
        this.mWorkTaskExecutor.executeOnTaskThread(r2);
        return r2.getOperation();
    }

    @Override // androidx.work.WorkManager
    public Operation cancelAllWork() {
        CancelWorkRunnable r0 = CancelWorkRunnable.forAll(this);
        this.mWorkTaskExecutor.executeOnTaskThread(r0);
        return r0.getOperation();
    }

    @Override // androidx.work.WorkManager
    public PendingIntent createCancelPendingIntent(UUID id) {
        Intent r3 = SystemForegroundDispatcher.createCancelWorkIntent(this.mContext, id.toString());
        if (Build.VERSION.SDK_INT < 31) goto L5;
        int r0 = 167772160;
    L7:
        return PendingIntent.getService(this.mContext, 0, r3, r0);
    L5:
        r0 = 134217728;
        goto L7
    }

    @Override // androidx.work.WorkManager
    public LiveData<Long> getLastCancelAllTimeMillisLiveData() {
        return this.mPreferenceUtils.getLastCancelAllTimeMillisLiveData();
    }

    @Override // androidx.work.WorkManager
    public ListenableFuture<Long> getLastCancelAllTimeMillis() {
        final SettableFuture r0 = SettableFuture.create();
        final PreferenceUtils r1 = this.mPreferenceUtils;
        this.mWorkTaskExecutor.executeOnTaskThread(new AnonymousClass1(this, r0, r1));
        return r0;
    }

    @Override // androidx.work.WorkManager
    public Operation pruneWork() {
        PruneWorkRunnable r0 = new PruneWorkRunnable(this);
        this.mWorkTaskExecutor.executeOnTaskThread(r0);
        return r0.getOperation();
    }

    @Override // androidx.work.WorkManager
    public LiveData<WorkInfo> getWorkInfoByIdLiveData(UUID id) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForIds(Collections.singletonList(id.toString())), new AnonymousClass2(this), this.mWorkTaskExecutor);
    }

    @Override // androidx.work.WorkManager
    public ListenableFuture<WorkInfo> getWorkInfoById(UUID id) {
        StatusRunnable<WorkInfo> r1 = StatusRunnable.forUUID(this, id);
        this.mWorkTaskExecutor.getSerialTaskExecutor().execute(r1);
        return r1.getFuture();
    }

    @Override // androidx.work.WorkManager
    public LiveData<List<WorkInfo>> getWorkInfosByTagLiveData(String tag) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForTag(tag), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    @Override // androidx.work.WorkManager
    public ListenableFuture<List<WorkInfo>> getWorkInfosByTag(String tag) {
        StatusRunnable<List<WorkInfo>> r1 = StatusRunnable.forTag(this, tag);
        this.mWorkTaskExecutor.getSerialTaskExecutor().execute(r1);
        return r1.getFuture();
    }

    @Override // androidx.work.WorkManager
    public LiveData<List<WorkInfo>> getWorkInfosForUniqueWorkLiveData(String uniqueWorkName) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForName(uniqueWorkName), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    @Override // androidx.work.WorkManager
    public ListenableFuture<List<WorkInfo>> getWorkInfosForUniqueWork(String uniqueWorkName) {
        StatusRunnable<List<WorkInfo>> r1 = StatusRunnable.forUniqueWork(this, uniqueWorkName);
        this.mWorkTaskExecutor.getSerialTaskExecutor().execute(r1);
        return r1.getFuture();
    }

    @Override // androidx.work.WorkManager
    public LiveData<List<WorkInfo>> getWorkInfosLiveData(WorkQuery workQuery) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.rawWorkInfoDao().getWorkInfoPojosLiveData(RawQueries.toRawQuery(workQuery)), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    @Override // androidx.work.WorkManager
    public ListenableFuture<List<WorkInfo>> getWorkInfos(WorkQuery workQuery) {
        StatusRunnable<List<WorkInfo>> r1 = StatusRunnable.forWorkQuerySpec(this, workQuery);
        this.mWorkTaskExecutor.getSerialTaskExecutor().execute(r1);
        return r1.getFuture();
    }

    @Override // androidx.work.WorkManager
    public ListenableFuture<WorkManager.UpdateResult> updateWork(WorkRequest request) {
        return WorkerUpdater.updateWorkImpl(this, request);
    }

    LiveData<List<WorkInfo>> getWorkInfosById(List<String> workSpecIds) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForIds(workSpecIds), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    public RemoteWorkManager getRemoteWorkManager() {
        if (this.mRemoteWorkManager != null) goto L21;
        Object r0 = sLock;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L7:
        if (this.mRemoteWorkManager != null) goto L15;
        tryInitializeMultiProcessSupport();     // Catch: Throwable -> L17
        if (this.mRemoteWorkManager != null) goto L15;
        if (TextUtils.isEmpty(this.mConfiguration.getDefaultProcessName()) == true) goto L15;
        throw new IllegalStateException("Invalid multiprocess configuration. Define an `implementation` dependency on :work:work-multiprocess library");     // Catch: Throwable -> L17
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L17
    L21:
        return this.mRemoteWorkManager;
    }

    public void startWork(StartStopToken workSpecId) {
        startWork(workSpecId, null);
    }

    public void startWork(StartStopToken workSpecId, WorkerParameters.RuntimeExtras runtimeExtras) {
        this.mWorkTaskExecutor.executeOnTaskThread(new StartWorkRunnable(this, workSpecId, runtimeExtras));
    }

    public void stopWork(StartStopToken workSpecId) {
        this.mWorkTaskExecutor.executeOnTaskThread(new StopWorkRunnable(this, workSpecId, false));
    }

    public void stopForegroundWork(WorkGenerationalId id) {
        this.mWorkTaskExecutor.executeOnTaskThread(new StopWorkRunnable(this, new StartStopToken(id), true));
    }

    public void rescheduleEligibleWork() {
        SystemJobScheduler.cancelAll(getApplicationContext());
        getWorkDatabase().workSpecDao().resetScheduledState();
        Schedulers.schedule(getConfiguration(), getWorkDatabase(), getSchedulers());
    }

    public void onForceStopRunnableCompleted() {
        Object r0 = sLock;
        monitor-enter(r0);
        this.mForceStopRunnableCompleted = true;     // Catch: Throwable -> L10
        BroadcastReceiver.PendingResult r1 = this.mRescheduleReceiverResult;     // Catch: Throwable -> L10
        if (r1 == null) goto L8;
        r1.finish();     // Catch: Throwable -> L10
        this.mRescheduleReceiverResult = null;     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void setReschedulePendingResult(BroadcastReceiver.PendingResult rescheduleReceiverResult) {
        Object r0 = sLock;
        monitor-enter(r0);
        BroadcastReceiver.PendingResult r1 = this.mRescheduleReceiverResult;     // Catch: Throwable -> L12
        if (r1 == null) goto L7;
        r1.finish();     // Catch: Throwable -> L12
    L7:
        this.mRescheduleReceiverResult = rescheduleReceiverResult;     // Catch: Throwable -> L12
        if (this.mForceStopRunnableCompleted == false) goto L10;
        rescheduleReceiverResult.finish();     // Catch: Throwable -> L12
        this.mRescheduleReceiverResult = null;     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private void internalInit(Context context, Configuration configuration, TaskExecutor workTaskExecutor, WorkDatabase workDatabase, List<Scheduler> schedulers, Processor processor) {
        Context r1 = context.getApplicationContext();
        this.mContext = r1;
        this.mConfiguration = configuration;
        this.mWorkTaskExecutor = workTaskExecutor;
        this.mWorkDatabase = workDatabase;
        this.mSchedulers = schedulers;
        this.mProcessor = processor;
        this.mPreferenceUtils = new PreferenceUtils(workDatabase);
        this.mForceStopRunnableCompleted = false;
        if (Api24Impl.isDeviceProtectedStorage(r1) == true) goto L7;
        this.mWorkTaskExecutor.executeOnTaskThread(new ForceStopRunnable(r1, this));
        return;
    L7:
        throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
    }

    public List<Scheduler> createSchedulers(Context context, Configuration configuration, Trackers trackers) {
        return Arrays.asList(new Scheduler[]{Schedulers.createBestAvailableBackgroundScheduler(context, this), new GreedyScheduler(context, configuration, trackers, this)});
    }

    private void tryInitializeMultiProcessSupport() {
        this.mRemoteWorkManager = (RemoteWorkManager) Class.forName(REMOTE_WORK_MANAGER_CLIENT).getConstructor(new Class[]{Context.class, WorkManagerImpl.class}).newInstance(new Object[]{this.mContext, this});     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Logger.get().debug(TAG, "Unable to initialize multi-process support", th);
    }
}
