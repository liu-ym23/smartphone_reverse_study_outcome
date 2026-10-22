package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.net.Network;
import android.net.Uri;
import android.os.PersistableBundle;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkGenerationalId;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class SystemJobService extends JobService implements ExecutionListener {
    private static final String TAG = null;
    private final Map<WorkGenerationalId, JobParameters> mJobParameters;
    private final StartStopTokens mStartStopTokens;
    private WorkManagerImpl mWorkManagerImpl;

    static class Api24Impl {
        private Api24Impl() {
        }

        static Uri[] getTriggeredContentUris(JobParameters jobParameters) {
            return jobParameters.getTriggeredContentUris();
        }

        static String[] getTriggeredContentAuthorities(JobParameters jobParameters) {
            return jobParameters.getTriggeredContentAuthorities();
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static Network getNetwork(JobParameters jobParameters) {
            return jobParameters.getNetwork();
        }
    }

    public SystemJobService() {
        this.mJobParameters = new HashMap();
        this.mStartStopTokens = new StartStopTokens();
    }

    static {
        TAG = Logger.tagWithPrefix("SystemJobService");
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        WorkManagerImpl r0 = WorkManagerImpl.getInstance(getApplicationContext());     // Catch: IllegalStateException -> L5
        this.mWorkManagerImpl = r0;     // Catch: IllegalStateException -> L5
        r0.getProcessor().addExecutionListener(this);     // Catch: IllegalStateException -> L5
        return;
    L6:
        if (Application.class.equals(getApplication().getClass()) == false) goto L10;
        Logger.get().warning(TAG, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.");
        return;
    L10:
        throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        WorkManagerImpl r0 = this.mWorkManagerImpl;
        if (r0 == null) goto L6;
        r0.getProcessor().removeExecutionListener(this);
        return;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters params) {
        if (this.mWorkManagerImpl != null) goto L6;
        Logger.get().debug(TAG, "WorkManager is not initialized; requesting retry.");
        jobFinished(params, true);
        return false;
    L6:
        WorkGenerationalId r2 = workGenerationalIdFromJobParameters(params);
        if (r2 != null) goto L10;
        Logger.get().error(TAG, "WorkSpec id not found!");
        return false;
    L10:
        Map<WorkGenerationalId, JobParameters> r5 = this.mJobParameters;
        monitor-enter(r5);
    L27:
        th = move-exception;
        throw th;
    L13:
        if (this.mJobParameters.containsKey(r2) == false) goto L17;
        Logger.get().debug(TAG, "Job is already being executed by SystemJobService: " + r2);     // Catch: Throwable -> L27
        monitor-exit(r5);     // Catch: Throwable -> L27
        return false;
    L17:
        Logger.get().debug(TAG, "onStartJob for " + r2);     // Catch: Throwable -> L27
        this.mJobParameters.put(r2, params);     // Catch: Throwable -> L27
        monitor-exit(r5);     // Catch: Throwable -> L27
        WorkerParameters.RuntimeExtras r0 = new WorkerParameters.RuntimeExtras();
        if (Api24Impl.getTriggeredContentUris(params) == null) goto L23;
        r0.triggeredContentUris = Arrays.asList(Api24Impl.getTriggeredContentUris(params));
    L23:
        if (Api24Impl.getTriggeredContentAuthorities(params) == null) goto L25;
        r0.triggeredContentAuthorities = Arrays.asList(Api24Impl.getTriggeredContentAuthorities(params));
    L25:
        r0.network = Api28Impl.getNetwork(params);
        this.mWorkManagerImpl.startWork(this.mStartStopTokens.tokenFor(r2), r0);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters params) {
        if (this.mWorkManagerImpl != null) goto L6;
        Logger.get().debug(TAG, "WorkManager is not initialized; requesting retry.");
        return true;
    L6:
        WorkGenerationalId r6 = workGenerationalIdFromJobParameters(params);
        if (r6 != null) goto L10;
        Logger.get().error(TAG, "WorkSpec id not found!");
        return false;
    L10:
        Logger.get().debug(TAG, "onStopJob for " + r6);
        Map<WorkGenerationalId, JobParameters> r0 = this.mJobParameters;
        monitor-enter(r0);
        this.mJobParameters.remove(r6);     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        StartStopToken r1 = this.mStartStopTokens.remove(r6);
        if (r1 == null) goto L18;
        this.mWorkManagerImpl.stopWork(r1);
    L18:
        return !this.mWorkManagerImpl.getProcessor().isCancelled(r6.getWorkSpecId());
    L19:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(WorkGenerationalId id, boolean needsReschedule) {
        Logger.get().debug(TAG, id.getWorkSpecId() + " executed on JobScheduler");
        Map<WorkGenerationalId, JobParameters> r0 = this.mJobParameters;
        monitor-enter(r0);
        JobParameters r1 = this.mJobParameters.remove(id);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        this.mStartStopTokens.remove(id);
        if (r1 == null) goto L15;
        jobFinished(r1, needsReschedule);
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private static WorkGenerationalId workGenerationalIdFromJobParameters(JobParameters parameters) {
        PersistableBundle r3 = parameters.getExtras();     // Catch: NullPointerException -> L11
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.containsKey("EXTRA_WORK_SPEC_ID") == false) goto L14;
        return new WorkGenerationalId(r3.getString("EXTRA_WORK_SPEC_ID"), r3.getInt("EXTRA_WORK_SPEC_GENERATION"));
    L14:
        return null;
    L15:
        return null;
    }
}
