package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import androidx.core.util.Consumer;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoKt;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.IdGenerator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class SystemJobScheduler implements Scheduler {
    private static final String TAG = null;
    private final Context mContext;
    private final JobScheduler mJobScheduler;
    private final SystemJobInfoConverter mSystemJobInfoConverter;
    private final WorkManagerImpl mWorkManager;

    @Override // androidx.work.impl.Scheduler
    public boolean hasLimitedSchedulingSlots() {
        return true;
    }

    static {
        TAG = Logger.tagWithPrefix("SystemJobScheduler");
    }

    public SystemJobScheduler(Context context, WorkManagerImpl workManager) {
        this(context, workManager, (JobScheduler) context.getSystemService("jobscheduler"), new SystemJobInfoConverter(context));
    }

    public SystemJobScheduler(Context context, WorkManagerImpl workManager, JobScheduler jobScheduler, SystemJobInfoConverter systemJobInfoConverter) {
        this.mContext = context;
        this.mWorkManager = workManager;
        this.mJobScheduler = jobScheduler;
        this.mSystemJobInfoConverter = systemJobInfoConverter;
    }

    @Override // androidx.work.impl.Scheduler
    public void schedule(WorkSpec... workSpecs) {
        WorkDatabase r0 = this.mWorkManager.getWorkDatabase();
        IdGenerator r1 = new IdGenerator(r0);
        int r2 = workSpecs.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L25;
        WorkSpec r4 = workSpecs[r3];
        r0.beginTransaction();
        WorkSpec r5 = r0.workSpecDao().getWorkSpec(r4.id);     // Catch: Throwable -> L22
        if (r5 != null) goto L11;
        Logger.get().warning(TAG, "Skipping scheduling " + r4.id + " because it's no longer in the DB");     // Catch: Throwable -> L22
        r0.setTransactionSuccessful();     // Catch: Throwable -> L22
    L9:
        r0.endTransaction();
        r3 = r3 + 1;
        goto L3
    L11:
        if (r5.state == WorkInfo.State.ENQUEUED) goto L13;
        Logger.get().warning(TAG, "Skipping scheduling " + r4.id + " because it is no longer enqueued");     // Catch: Throwable -> L22
        r0.setTransactionSuccessful();     // Catch: Throwable -> L22
        goto L9
    L13:
        WorkGenerationalId r6 = WorkSpecKt.generationalId(r4);     // Catch: Throwable -> L22
        SystemIdInfo r7 = r0.systemIdInfoDao().getSystemIdInfo(r6);     // Catch: Throwable -> L22
        if (r7 == null) goto L16;
        int r8 = r7.systemId;     // Catch: Throwable -> L22
    L17:
        if (r7 != null) goto L19;
        this.mWorkManager.getWorkDatabase().systemIdInfoDao().insertSystemIdInfo(SystemIdInfoKt.systemIdInfo(r6, r8));     // Catch: Throwable -> L22
    L19:
        scheduleInternal(r4, r8);     // Catch: Throwable -> L22
        r0.setTransactionSuccessful();     // Catch: Throwable -> L22
        goto L9
    L16:
        r8 = r1.nextJobSchedulerIdWithRange(this.mWorkManager.getConfiguration().getMinJobSchedulerId(), this.mWorkManager.getConfiguration().getMaxJobSchedulerId());     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        r0.endTransaction();
        throw th;
    }

    public void scheduleInternal(WorkSpec workSpec, int jobId) {
        JobInfo r1 = this.mSystemJobInfoConverter.convert(workSpec, jobId);
        Logger r2 = Logger.get();
        String r3 = TAG;
        r2.debug(r3, "Scheduling work ID " + workSpec.id + "Job ID " + jobId);
    L13:
        e = move-exception;
        List<JobInfo> r8 = getPendingJobs(this.mContext, this.mJobScheduler);
        if (r8 == null) goto L17;
        int r9 = r8.size();
    L18:
        String r10 = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", new Object[]{Integer.valueOf(r9), Integer.valueOf(this.mWorkManager.getWorkDatabase().workSpecDao().getScheduledWork().size()), Integer.valueOf(this.mWorkManager.getConfiguration().getMaxSchedulerLimit())});
        Logger.get().error(TAG, r10);
        IllegalStateException r0 = new IllegalStateException(r10, e);
        Consumer<Throwable> r6 = this.mWorkManager.getConfiguration().getSchedulingExceptionHandler();
        if (r6 == null) goto L22;
        r6.accept(r0);
        return;
    L22:
        throw r0;
    L17:
        r9 = 0;
    L11:
        th = move-exception;
        Logger.get().error(TAG, "Unable to schedule " + workSpec, th);
        return;
    L4:
        if (this.mJobScheduler.schedule(r1) != 0) goto L25;
        Logger.get().warning(r3, "Unable to schedule work ID " + workSpec.id);     // Catch: Throwable -> L11 IllegalStateException -> L13
        if (workSpec.expedited == true) goto L8;
        return;
    L8:
        if (workSpec.outOfQuotaPolicy != OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST) goto L27;
        workSpec.expedited = false;     // Catch: Throwable -> L11 IllegalStateException -> L13
        Logger.get().debug(r3, String.format("Scheduling a non-expedited job (work ID %s)", new Object[]{workSpec.id}));     // Catch: Throwable -> L11 IllegalStateException -> L13
        scheduleInternal(workSpec, jobId);     // Catch: Throwable -> L11 IllegalStateException -> L13
    L29:
        return;
    L27:
        return;
    }

    @Override // androidx.work.impl.Scheduler
    public void cancel(String workSpecId) {
        List<Integer> r0 = getPendingJobIds(this.mContext, this.mJobScheduler, workSpecId);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEmpty() == true) goto L14;
        Iterator<Integer> r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        int r2 = r1.next().intValue();
        cancelJobById(this.mJobScheduler, r2);
        goto L8
    L10:
        this.mWorkManager.getWorkDatabase().systemIdInfoDao().removeSystemIdInfo(workSpecId);
        return;
    }

    private static void cancelJobById(JobScheduler jobScheduler, int id) {
        jobScheduler.cancel(id);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Logger.get().error(TAG, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", new Object[]{Integer.valueOf(id)}), th);
    }

    public static void cancelAll(Context context) {
        JobScheduler r0 = (JobScheduler) context.getSystemService("jobscheduler");
        if (r0 == null) goto L12;
        List<JobInfo> r2 = getPendingJobs(context, r0);
        if (r2 != null) goto L7;
        return;
    L7:
        if (r2.isEmpty() == true) goto L15;
        Iterator<JobInfo> r3 = r2.iterator();
    L10:
        if (r3.hasNext() == false) goto L16;
        cancelJobById(r0, r3.next().getId());
        goto L10
    L16:
        return;
    L15:
        return;
    }

    public static boolean reconcileJobs(Context context, WorkManagerImpl workManager) {
        JobScheduler r0 = (JobScheduler) context.getSystemService("jobscheduler");
        List<JobInfo> r6 = getPendingJobs(context, r0);
        List<String> r1 = workManager.getWorkDatabase().systemIdInfoDao().getWorkSpecIds();
        boolean r2 = false;
        if (r6 == null) goto L5;
        int r3 = r6.size();
    L6:
        HashSet r4 = new HashSet(r3);
        if (r6 != null) goto L9;
    L17:
        Iterator<String> r7 = r1.iterator();
    L19:
        if (r7.hasNext() == false) goto L23;
        if (r4.contains(r7.next()) == true) goto L19;
        Logger.get().debug(TAG, "Reconciling jobs");
        r2 = true;
    L23:
        if (r2 == false) goto L34;
        WorkDatabase r8 = workManager.getWorkDatabase();
        r8.beginTransaction();
        WorkSpecDao r9 = r8.workSpecDao();     // Catch: Throwable -> L31
        Iterator<String> r5 = r1.iterator();     // Catch: Throwable -> L31
    L27:
        if (r5.hasNext() == false) goto L29;
        r9.markWorkSpecScheduled(r5.next(), -1);     // Catch: Throwable -> L31
        goto L27
    L29:
        r8.setTransactionSuccessful();     // Catch: Throwable -> L31
        r8.endTransaction();
    L31:
        th = move-exception;
        r8.endTransaction();
        throw th;
    L34:
        return r2;
    L9:
        if (r6.isEmpty() == true) goto L17;
        Iterator<JobInfo> r10 = r6.iterator();
    L12:
        if (r10.hasNext() == false) goto L17;
        JobInfo r11 = r10.next();
        WorkGenerationalId r12 = getWorkGenerationalIdFromJobInfo(r11);
        if (r12 != null) goto L15;
        cancelJobById(r0, r11.getId());
        goto L12
    L15:
        r4.add(r12.getWorkSpecId());
        goto L12
    L5:
        r3 = 0;
        goto L6
    }

    private static List<JobInfo> getPendingJobs(Context context, JobScheduler jobScheduler) {
        List<JobInfo> r5 = jobScheduler.getAllPendingJobs();     // Catch: Throwable -> L5
    L7:
        if (r5 != null) goto L9;
        return null;
    L9:
        ArrayList r0 = new ArrayList(r5.size());
        ComponentName r1 = new ComponentName(context, SystemJobService.class);
        Iterator<JobInfo> r4 = r5.iterator();
    L11:
        if (r4.hasNext() == false) goto L15;
        JobInfo r6 = r4.next();
        if (r1.equals(r6.getService()) == false) goto L11;
        r0.add(r6);
        goto L11
    L15:
        return r0;
    L5:
        th = move-exception;
        Logger.get().error(TAG, "getAllPendingJobs() is not reliable on this device.", th);
        r5 = null;
        goto L7
    }

    private static List<Integer> getPendingJobIds(Context context, JobScheduler jobScheduler, String workSpecId) {
        List<JobInfo> r2 = getPendingJobs(context, jobScheduler);
        if (r2 != null) goto L6;
        return null;
    L6:
        ArrayList r3 = new ArrayList(2);
        Iterator<JobInfo> r4 = r2.iterator();
    L8:
        if (r4.hasNext() == false) goto L14;
        JobInfo r0 = r4.next();
        WorkGenerationalId r1 = getWorkGenerationalIdFromJobInfo(r0);
        if (r1 == null) goto L8;
        if (workSpecId.equals(r1.getWorkSpecId()) == false) goto L8;
        r3.add(Integer.valueOf(r0.getId()));
        goto L8
    L14:
        return r3;
    }

    private static WorkGenerationalId getWorkGenerationalIdFromJobInfo(JobInfo jobInfo) {
        PersistableBundle r3 = jobInfo.getExtras();
        if (r3 != null) goto L11;
        return null;
    L11:
        if (r3.containsKey("EXTRA_WORK_SPEC_ID") == false) goto L13;
        int r1 = r3.getInt("EXTRA_WORK_SPEC_GENERATION", 0);     // Catch: NullPointerException -> L10
        return new WorkGenerationalId(r3.getString("EXTRA_WORK_SPEC_ID"), r1);
    L13:
        return null;
    L14:
        return null;
    }
}
