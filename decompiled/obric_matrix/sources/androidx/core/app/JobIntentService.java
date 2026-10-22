package androidx.core.app;

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
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
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

    final class CommandProcessor extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ JobIntentService this$0;

        CommandProcessor(JobIntentService r1) {
            this.this$0 = r1;
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Void doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Void doInBackground2(Void... r3) {
        L2:
            GenericWorkItem r4 = this.this$0.dequeueWork();
            if (r4 == null) goto L5;
            this.this$0.onHandleWork(r4.getIntent());
            r4.complete();
            goto L2
        L5:
            return null;
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onCancelled(Void r1) {
            onCancelled2(r1);
        }

        /* JADX INFO: renamed from: onCancelled, reason: avoid collision after fix types in other method */
        protected void onCancelled2(Void r1) {
            this.this$0.processorFinished();
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Void r1) {
            onPostExecute2(r1);
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Void r1) {
            this.this$0.processorFinished();
        }
    }

    interface CompatJobEngine {
        IBinder compatGetBinder();

        GenericWorkItem dequeueWork();
    }

    static final class CompatWorkEnqueuer extends WorkEnqueuer {
        private final Context mContext;
        private final PowerManager.WakeLock mLaunchWakeLock;
        boolean mLaunchingService;
        private final PowerManager.WakeLock mRunWakeLock;
        boolean mServiceProcessing;

        CompatWorkEnqueuer(Context r4, ComponentName r5) {
            super(r5);
            this.mContext = r4.getApplicationContext();
            PowerManager r6 = (PowerManager) r4.getSystemService("power");
            PowerManager.WakeLock r0 = r6.newWakeLock(1, r5.getClassName() + ":launch");
            this.mLaunchWakeLock = r0;
            r0.setReferenceCounted(false);
            PowerManager.WakeLock r7 = r6.newWakeLock(1, r5.getClassName() + ":run");
            this.mRunWakeLock = r7;
            r7.setReferenceCounted(false);
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        void enqueueWork(Intent r3) {
            Intent r0 = new Intent(r3);
            r0.setComponent(this.mComponentName);
            if (this.mContext.startService(r0) == null) goto L15;
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L6:
            if (this.mLaunchingService == true) goto L10;
            this.mLaunchingService = true;     // Catch: Throwable -> L12
            if (this.mServiceProcessing == true) goto L10;
            this.mLaunchWakeLock.acquire(60000);     // Catch: Throwable -> L12
        L10:
            monitor-exit(this);     // Catch: Throwable -> L12
            return;
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void serviceProcessingFinished() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.mServiceProcessing == true) goto L6;
        L9:
            monitor-exit(this);     // Catch: Throwable -> L11
            return;
        L6:
            if (this.mLaunchingService == false) goto L8;
            this.mLaunchWakeLock.acquire(60000);     // Catch: Throwable -> L11
        L8:
            this.mServiceProcessing = false;     // Catch: Throwable -> L11
            this.mRunWakeLock.release();     // Catch: Throwable -> L11
            goto L9
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void serviceProcessingStarted() {
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (this.mServiceProcessing == true) goto L6;
            this.mServiceProcessing = true;     // Catch: Throwable -> L8
            this.mRunWakeLock.acquire(600000);     // Catch: Throwable -> L8
            this.mLaunchWakeLock.release();     // Catch: Throwable -> L8
        L6:
            monitor-exit(this);     // Catch: Throwable -> L8
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

    final class CompatWorkItem implements GenericWorkItem {
        final Intent mIntent;
        final int mStartId;
        final /* synthetic */ JobIntentService this$0;

        CompatWorkItem(JobIntentService r1, Intent r2, int r3) {
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

    interface GenericWorkItem {
        void complete();

        Intent getIntent();
    }

    @RequiresApi(26)
    static final class JobServiceEngineImpl extends JobServiceEngine implements CompatJobEngine {
        static final boolean DEBUG = false;
        static final String TAG = "JobServiceEngineImpl";
        final Object mLock;
        JobParameters mParams;
        final JobIntentService mService;

        final class WrapperWorkItem implements GenericWorkItem {
            final JobWorkItem mJobWork;
            final /* synthetic */ JobServiceEngineImpl this$0;

            WrapperWorkItem(JobServiceEngineImpl r1, JobWorkItem r2) {
                this.this$0 = r1;
                this.mJobWork = r2;
            }

            @Override // androidx.core.app.JobIntentService.GenericWorkItem
            public void complete() {
                Object r0 = this.this$0.mLock;
                monitor-enter(r0);
                JobParameters r1 = this.this$0.mParams;     // Catch: Throwable -> L9
                if (r1 == null) goto L7;
                r1.completeWork(this.mJobWork);     // Catch: Throwable -> L9
            L7:
                monitor-exit(r0);     // Catch: Throwable -> L9
                return;
            L9:
                th = move-exception;
                throw th;
            }

            @Override // androidx.core.app.JobIntentService.GenericWorkItem
            public Intent getIntent() {
                return this.mJobWork.getIntent();
            }
        }

        JobServiceEngineImpl(JobIntentService r2) {
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
            JobParameters r1 = this.mParams;     // Catch: Throwable -> L14
            if (r1 != null) goto L8;
            monitor-exit(r0);     // Catch: Throwable -> L14
            return null;
        L8:
            JobWorkItem r2 = r1.dequeueWork();     // Catch: Throwable -> L14
            monitor-exit(r0);     // Catch: Throwable -> L14
            if (r2 == null) goto L13;
            r2.getIntent().setExtrasClassLoader(this.mService.getClassLoader());
            return new WrapperWorkItem(this, r2);
        L13:
            return null;
        L14:
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
    static final class JobWorkEnqueuer extends WorkEnqueuer {
        private final JobInfo mJobInfo;
        private final JobScheduler mJobScheduler;

        JobWorkEnqueuer(Context r3, ComponentName r4, int r5) {
            super(r4);
            ensureJobId(r5);
            this.mJobInfo = new JobInfo.Builder(r5, this.mComponentName).setOverrideDeadline(0).build();
            this.mJobScheduler = (JobScheduler) r3.getApplicationContext().getSystemService("jobscheduler");
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        void enqueueWork(Intent r3) {
            this.mJobScheduler.enqueue(this.mJobInfo, new JobWorkItem(r3));
        }
    }

    static abstract class WorkEnqueuer {
        final ComponentName mComponentName;
        boolean mHasJobId;
        int mJobId;

        WorkEnqueuer(ComponentName r1) {
            this.mComponentName = r1;
        }

        abstract void enqueueWork(Intent r1);

        void ensureJobId(int r4) {
            if (this.mHasJobId == true) goto L6;
            this.mHasJobId = true;
            this.mJobId = r4;
            return;
        L6:
            if (this.mJobId != r4) goto L9;
            return;
        L9:
            throw new IllegalArgumentException("Given job ID " + r4 + " is different than previous " + this.mJobId);
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
        if (Build.VERSION.SDK_INT < 26) goto L5;
        ArrayList<CompatWorkItem> r0 = null;
    L6:
        this.mCompatQueue = r0;
        return;
    L5:
        r0 = new ArrayList();
        goto L6
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

    public static void enqueueWork(@NonNull Context r1, @NonNull Class<?> r2, int r3, @NonNull Intent r4) {
        enqueueWork(r1, new ComponentName(r1, r2), r3, r4);
    }

    static WorkEnqueuer getWorkEnqueuer(Context r3, ComponentName r4, boolean r5, int r6) {
        HashMap<ComponentName, WorkEnqueuer> r0 = sClassWorkEnqueuer;
        WorkEnqueuer r1 = r0.get(r4);
        if (r1 == null) goto L5;
        return r1;
    L5:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        if (r5 == false) goto L9;
        WorkEnqueuer r7 = new JobWorkEnqueuer(r3, r4, r6);
    L11:
        WorkEnqueuer r2 = r7;
        r0.put(r4, r2);
        return r2;
    L9:
        throw new IllegalArgumentException("Can't be here without a job id");
    L10:
        r7 = new CompatWorkEnqueuer(r3, r4);
        goto L11
    }

    GenericWorkItem dequeueWork() {
        CompatJobEngine r0 = this.mJobImpl;
        if (r0 != null) goto L5;
        ArrayList<CompatWorkItem> r1 = this.mCompatQueue;
        monitor-enter(r1);
    L16:
        th = move-exception;
        throw th;
    L9:
        if (this.mCompatQueue.size() <= 0) goto L14;
        CompatWorkItem r2 = this.mCompatQueue.remove(0);     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        return r2;
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L16
        return null;
    L5:
        return r0.dequeueWork();
    }

    boolean doStopCurrentWork() {
        CommandProcessor r0 = this.mCurProcessor;
        if (r0 == null) goto L5;
        r0.cancel(this.mInterruptIfStopped);
    L5:
        this.mStopped = true;
        return onStopCurrentWork();
    }

    void ensureProcessorRunningLocked(boolean r2) {
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
        if (Build.VERSION.SDK_INT < 26) goto L5;
        this.mJobImpl = new JobServiceEngineImpl(this);
        this.mCompatWorkEnqueuer = null;
        return;
    L5:
        this.mJobImpl = null;
        this.mCompatWorkEnqueuer = getWorkEnqueuer(this, new ComponentName(this, getClass()), false, 0);
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

    protected abstract void onHandleWork(@NonNull Intent r1);

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

    void processorFinished() {
        ArrayList<CompatWorkItem> r0 = this.mCompatQueue;
        if (r0 == null) goto L19;
        monitor-enter(r0);
        this.mCurProcessor = null;     // Catch: Throwable -> L16
        ArrayList<CompatWorkItem> r1 = this.mCompatQueue;     // Catch: Throwable -> L16
        if (r1 == null) goto L12;
        if (r1.size() <= 0) goto L12;
        ensureProcessorRunningLocked(false);     // Catch: Throwable -> L16
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L12:
        if (this.mDestroyed == true) goto L14;
        this.mCompatWorkEnqueuer.serviceProcessingFinished();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public void setInterruptIfStopped(boolean r1) {
        this.mInterruptIfStopped = r1;
    }
}
