package androidx.core.app;

import a.a;
import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class JobIntentService extends Service {
    static final boolean DEBUG = false;
    static final String TAG = "JobIntentService";
    static final HashMap<ComponentName, WorkEnqueuer> sClassWorkEnqueuer = null;
    static final Object sLock = null;
    final ArrayList<CompatWorkItem> mCompatQueue;
    WorkEnqueuer mCompatWorkEnqueuer;
    CommandProcessor mCurProcessor;
    boolean mDestroyed;
    boolean mInterruptIfStopped;
    CompatJobEngine mJobImpl;
    boolean mStopped;

    public final class CommandProcessor extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ JobIntentService this$0;

        public CommandProcessor(JobIntentService r1) {
            this.this$0 = r1;
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ Void doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ void onCancelled(Void r1) {
            onCancelled2(r1);
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ void onPostExecute(Void r1) {
            onPostExecute2(r1);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        public Void doInBackground2(Void... r3) {
        L2:
            GenericWorkItem r4 = this.this$0.dequeueWork();
            if (r4 == null) goto L5;
            this.this$0.onHandleWork(r4.getIntent());
            r4.complete();
            goto L2
        L5:
            return null;
        }

        /* JADX INFO: renamed from: onCancelled, reason: avoid collision after fix types in other method */
        public void onCancelled2(Void r1) {
            this.this$0.processorFinished();
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        public void onPostExecute2(Void r1) {
            this.this$0.processorFinished();
        }
    }

    public interface CompatJobEngine {
        IBinder compatGetBinder();

        GenericWorkItem dequeueWork();
    }

    public static final class CompatWorkEnqueuer extends WorkEnqueuer {
        private final Context mContext;
        private final PowerManager.WakeLock mLaunchWakeLock;
        boolean mLaunchingService;
        private final PowerManager.WakeLock mRunWakeLock;
        boolean mServiceProcessing;

        public CompatWorkEnqueuer(Context r4, ComponentName r5) {
            super(r5);
            this.mContext = r4.getApplicationContext();
            PowerManager r6 = (PowerManager) r4.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
            PowerManager.WakeLock r0 = r6.newWakeLock(1, r5.getClassName() + ":launch");
            this.mLaunchWakeLock = r0;
            r0.setReferenceCounted(false);
            PowerManager.WakeLock r7 = r6.newWakeLock(1, r5.getClassName() + ":run");
            this.mRunWakeLock = r7;
            r7.setReferenceCounted(false);
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void enqueueWork(Intent r3) {
            Intent r0 = new Intent(r3);
            r0.setComponent(this.mComponentName);
            if (this.mContext.startService(r0) == null) goto L16;
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L6:
            if (this.mLaunchingService == true) goto L12;
            this.mLaunchingService = true;     // Catch: Throwable -> L10
            if (this.mServiceProcessing == true) goto L12;
            this.mLaunchWakeLock.acquire(60000);     // Catch: Throwable -> L10
        L12:
            monitor-exit(this);     // Catch: Throwable -> L10
            return;
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void serviceProcessingFinished() {
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (this.mServiceProcessing == true) goto L6;
        L11:
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L6:
            if (this.mLaunchingService == false) goto L10;
            this.mLaunchWakeLock.acquire(60000);     // Catch: Throwable -> L8
        L10:
            this.mServiceProcessing = false;     // Catch: Throwable -> L8
            this.mRunWakeLock.release();     // Catch: Throwable -> L8
            goto L11
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void serviceProcessingStarted() {
            monitor-enter(this);
        L6:
            th = move-exception;
            throw th;
        L4:
            if (this.mServiceProcessing == true) goto L8;
            this.mServiceProcessing = true;     // Catch: Throwable -> L6
            this.mRunWakeLock.acquire(600000);     // Catch: Throwable -> L6
            this.mLaunchWakeLock.release();     // Catch: Throwable -> L6
        L8:
            monitor-exit(this);     // Catch: Throwable -> L6
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void serviceStartReceived() {
            monitor-enter(this);
            this.mLaunchingService = false;     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public final class CompatWorkItem implements GenericWorkItem {
        final Intent mIntent;
        final int mStartId;
        final /* synthetic */ JobIntentService this$0;

        public CompatWorkItem(JobIntentService r1, Intent r2, int r3) {
            this.this$0 = r1;
            this.mIntent = r2;
            this.mStartId = r3;
        }

        @Override // androidx.core.app.JobIntentService.GenericWorkItem
        public void complete() {
            this.this$0.stopSelf(this.mStartId);
        }

        @Override // androidx.core.app.JobIntentService.GenericWorkItem
        public Intent getIntent() {
            return this.mIntent;
        }
    }

    public interface GenericWorkItem {
        void complete();

        Intent getIntent();
    }

    @RequiresApi(26)
    public static final class JobServiceEngineImpl extends JobServiceEngine implements CompatJobEngine {
        static final boolean DEBUG = false;
        static final String TAG = "JobServiceEngineImpl";
        final Object mLock;
        JobParameters mParams;
        final JobIntentService mService;

        public final class WrapperWorkItem implements GenericWorkItem {
            final JobWorkItem mJobWork;
            final /* synthetic */ JobServiceEngineImpl this$0;

            public WrapperWorkItem(JobServiceEngineImpl r1, JobWorkItem r2) {
                this.this$0 = r1;
                this.mJobWork = r2;
            }

            @Override // androidx.core.app.JobIntentService.GenericWorkItem
            public void complete() {
                Object r0 = this.this$0.mLock;
                monitor-enter(r0);
                JobParameters r1 = this.this$0.mParams;     // Catch: Throwable -> L7
                if (r1 == null) goto L9;
                r1.completeWork(this.mJobWork);     // Catch: Throwable -> L7
            L9:
                monitor-exit(r0);     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                throw th;
            }

            @Override // androidx.core.app.JobIntentService.GenericWorkItem
            public Intent getIntent() {
                return this.mJobWork.getIntent();
            }
        }

        public JobServiceEngineImpl(JobIntentService r2) {
            super(r2);
            this.mLock = new Object();
            this.mService = r2;
        }

        @Override // androidx.core.app.JobIntentService.CompatJobEngine
        public IBinder compatGetBinder() {
            return getBinder();
        }

        @Override // androidx.core.app.JobIntentService.CompatJobEngine
        public GenericWorkItem dequeueWork() {
            Object r0 = this.mLock;
            monitor-enter(r0);
            JobParameters r1 = this.mParams;     // Catch: Throwable -> L8
            if (r1 != null) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return null;
        L10:
            JobWorkItem r2 = r1.dequeueWork();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            if (r2 == null) goto L15;
            r2.getIntent().setExtrasClassLoader(this.mService.getClassLoader());
            return new WrapperWorkItem(this, r2);
        L15:
            return null;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(JobParameters r1) {
            this.mParams = r1;
            this.mService.ensureProcessorRunningLocked(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(JobParameters r3) {
            boolean r4 = this.mService.doStopCurrentWork();
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mParams = null;     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return r4;
        L8:
            th = move-exception;
            throw th;
        }
    }

    @RequiresApi(26)
    public static final class JobWorkEnqueuer extends WorkEnqueuer {
        private final JobInfo mJobInfo;
        private final JobScheduler mJobScheduler;

        public JobWorkEnqueuer(Context r3, ComponentName r4, int r5) {
            super(r4);
            ensureJobId(r5);
            this.mJobInfo = new JobInfo.Builder(r5, this.mComponentName).setOverrideDeadline(0).build();
            this.mJobScheduler = (JobScheduler) r3.getApplicationContext().getSystemService("jobscheduler");
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void enqueueWork(Intent r3) {
            this.mJobScheduler.enqueue(this.mJobInfo, new JobWorkItem(r3));
        }
    }

    public static abstract class WorkEnqueuer {
        final ComponentName mComponentName;
        boolean mHasJobId;
        int mJobId;

        public WorkEnqueuer(ComponentName r1) {
            this.mComponentName = r1;
        }

        public abstract void enqueueWork(Intent r1);

        public void ensureJobId(int r4) {
            if (this.mHasJobId == true) goto L6;
            this.mHasJobId = true;
            this.mJobId = r4;
            return;
        L6:
            if (this.mJobId == r4) goto L10;
            StringBuilder r5 = a.p(r4, "Given job ID ", " is different than previous ");
            r5.append(this.mJobId);
            throw new IllegalArgumentException(r5.toString());
        }

        public void serviceProcessingFinished() {
        }

        public void serviceProcessingStarted() {
        }

        public void serviceStartReceived() {
        }
    }

    static {
        sLock = new Object();
        sClassWorkEnqueuer = new HashMap();
    }

    public JobIntentService() {
        this.mInterruptIfStopped = false;
        this.mStopped = false;
        this.mDestroyed = false;
        this.mCompatQueue = null;
    }

    public static void enqueueWork(@NonNull Context r1, @NonNull Class<?> r2, int r3, @NonNull Intent r4) {
        enqueueWork(r1, new ComponentName(r1, r2), r3, r4);
    }

    public static WorkEnqueuer getWorkEnqueuer(Context r2, ComponentName r3, boolean r4, int r5) {
        HashMap<ComponentName, WorkEnqueuer> r0 = sClassWorkEnqueuer;
        WorkEnqueuer r1 = r0.get(r3);
        if (r1 != null) goto L8;
        if (r4 == false) goto L7;
        JobWorkEnqueuer r6 = new JobWorkEnqueuer(r2, r3, r5);
        r0.put(r3, r6);
        return r6;
    L7:
        throw new IllegalArgumentException("Can't be here without a job id");
    L8:
        return r1;
    }

    public GenericWorkItem dequeueWork() {
        CompatJobEngine r0 = this.mJobImpl;
        if (r0 != null) goto L5;
        ArrayList<CompatWorkItem> r1 = this.mCompatQueue;
        monitor-enter(r1);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (this.mCompatQueue.size() <= 0) goto L15;
        CompatWorkItem r2 = this.mCompatQueue.remove(0);     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return r2;
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L13
        return null;
    L5:
        return r0.dequeueWork();
    }

    public boolean doStopCurrentWork() {
        CommandProcessor r0 = this.mCurProcessor;
        if (r0 == null) goto L5;
        r0.cancel(this.mInterruptIfStopped);
    L5:
        this.mStopped = true;
        return onStopCurrentWork();
    }

    public void ensureProcessorRunningLocked(boolean r2) {
        if (this.mCurProcessor != null) goto L10;
        this.mCurProcessor = new CommandProcessor(this);
        WorkEnqueuer r0 = this.mCompatWorkEnqueuer;
        if (r0 == null) goto L8;
        if (r2 == false) goto L8;
        r0.serviceProcessingStarted();
    L8:
        this.mCurProcessor.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return;
    }

    public boolean isStopped() {
        return this.mStopped;
    }

    @Override // android.app.Service
    public IBinder onBind(@NonNull Intent r1) {
        CompatJobEngine r0 = this.mJobImpl;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.compatGetBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mJobImpl = new JobServiceEngineImpl(this);
        this.mCompatWorkEnqueuer = null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList<CompatWorkItem> r0 = this.mCompatQueue;
        if (r0 == null) goto L12;
        monitor-enter(r0);
        this.mDestroyed = true;     // Catch: Throwable -> L9
        this.mCompatWorkEnqueuer.serviceProcessingFinished();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public abstract void onHandleWork(@NonNull Intent r1);

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent r3, int r4, int r5) {
        if (this.mCompatQueue == null) goto L17;
        this.mCompatWorkEnqueuer.serviceStartReceived();
        ArrayList<CompatWorkItem> r6 = this.mCompatQueue;
        monitor-enter(r6);
        ArrayList<CompatWorkItem> r0 = this.mCompatQueue;     // Catch: Throwable -> L14
        if (r3 != null) goto L10;
        r3 = new Intent();     // Catch: Throwable -> L14
    L10:
        r0.add(new CompatWorkItem(this, r3, r5));     // Catch: Throwable -> L14
        ensureProcessorRunningLocked(true);     // Catch: Throwable -> L14
        monitor-exit(r6);     // Catch: Throwable -> L14
        return 3;
    L14:
        th = move-exception;
        throw th;
    L17:
        return 2;
    }

    public boolean onStopCurrentWork() {
        return true;
    }

    public void processorFinished() {
        ArrayList<CompatWorkItem> r0 = this.mCompatQueue;
        if (r0 == null) goto L20;
        monitor-enter(r0);
        this.mCurProcessor = null;     // Catch: Throwable -> L11
        ArrayList<CompatWorkItem> r1 = this.mCompatQueue;     // Catch: Throwable -> L11
        if (r1 == null) goto L14;
        if (r1.size() <= 0) goto L14;
        ensureProcessorRunningLocked(false);     // Catch: Throwable -> L11
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L14:
        if (this.mDestroyed == true) goto L16;
        this.mCompatWorkEnqueuer.serviceProcessingFinished();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setInterruptIfStopped(boolean r1) {
        this.mInterruptIfStopped = r1;
    }

    public static void enqueueWork(@NonNull Context r2, @NonNull ComponentName r3, int r4, @NonNull Intent r5) {
        if (r5 == null) goto L13;
        Object r0 = sLock;
        monitor-enter(r0);
        WorkEnqueuer r6 = getWorkEnqueuer(r2, r3, true, r4);     // Catch: Throwable -> L9
        r6.ensureJobId(r4);     // Catch: Throwable -> L9
        r6.enqueueWork(r5);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L13:
        throw new IllegalArgumentException("work must not be null");
    }
}
