package androidx.work.impl.utils;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.ApplicationExitInfo;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.util.Consumer;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabasePathHelper;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class ForceStopRunnable implements Runnable {
    static final String ACTION_FORCE_STOP_RESCHEDULE = "ACTION_FORCE_STOP_RESCHEDULE";
    private static final int ALARM_ID = -1;
    private static final long BACKOFF_DURATION_MS = 300;
    static final int MAX_ATTEMPTS = 3;
    private static final String TAG = null;
    private static final long TEN_YEARS = 0;
    private final Context mContext;
    private final PreferenceUtils mPreferenceUtils;
    private int mRetryCount;
    private final WorkManagerImpl mWorkManager;

    public static class BroadcastReceiver extends android.content.BroadcastReceiver {
        private static final String TAG = null;

        public BroadcastReceiver() {
        }

        static {
            TAG = Logger.tagWithPrefix("ForceStopRunnable$Rcvr");
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) goto L4;
            return;
        L4:
            if (ForceStopRunnable.ACTION_FORCE_STOP_RESCHEDULE.equals(intent.getAction()) == false) goto L8;
            Logger.get().verbose(TAG, "Rescheduling alarm that keeps track of force-stops.");
            ForceStopRunnable.setAlarm(context);
            return;
        }
    }

    static {
        TAG = Logger.tagWithPrefix("ForceStopRunnable");
        TEN_YEARS = TimeUnit.DAYS.toMillis(3650);
    }

    public ForceStopRunnable(Context context, WorkManagerImpl workManager) {
        this.mContext = context.getApplicationContext();
        this.mWorkManager = workManager;
        this.mPreferenceUtils = workManager.getPreferenceUtils();
        this.mRetryCount = 0;
    }

    @Override // java.lang.Runnable
    public void run() {
    L25:
        th = move-exception;
        this.mWorkManager.onForceStopRunnableCompleted();
        throw th;
    L3:
        if (multiProcessChecks() == true) goto L31;
        this.mWorkManager.onForceStopRunnableCompleted();
        return;
    L31:
        WorkDatabasePathHelper.migrateDatabase(this.mContext);     // Catch: SQLiteException -> L18 Throwable -> L25
        Logger.get().debug(TAG, "Performing cleanup operations.");     // Catch: Throwable -> L25
        forceStopRunnable();     // Catch: Throwable -> L10 Throwable -> L25
    L22:
        this.mWorkManager.onForceStopRunnableCompleted();
        return;
    L10:
        e = move-exception;
        int r1 = this.mRetryCount + 1;     // Catch: Throwable -> L25
        this.mRetryCount = r1;     // Catch: Throwable -> L25
        if (r1 >= 3) goto L13;
        Logger r5 = Logger.get();     // Catch: Throwable -> L25
        String r6 = TAG;     // Catch: Throwable -> L25
        StringBuilder r7 = new StringBuilder().append("Retrying after ");     // Catch: Throwable -> L25
        r5.debug(r6, r7.append(((long) r1) * 300).toString(), e);     // Catch: Throwable -> L25
        sleep(((long) this.mRetryCount) * 300);     // Catch: Throwable -> L25
        goto L31
    L13:
        Logger r2 = Logger.get();     // Catch: Throwable -> L25
        String r3 = TAG;     // Catch: Throwable -> L25
        r2.error(r3, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e);     // Catch: Throwable -> L25
        IllegalStateException r4 = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e);     // Catch: Throwable -> L25
        Consumer<Throwable> r0 = this.mWorkManager.getConfiguration().getInitializationExceptionHandler();     // Catch: Throwable -> L25
        if (r0 == null) goto L16;
        Logger.get().debug(r3, "Routing exception to the specified exception handler", r4);     // Catch: Throwable -> L25
        r0.accept(r4);     // Catch: Throwable -> L25
        goto L22
    L16:
        throw r4;     // Catch: Throwable -> L25
    L18:
        e = move-exception;
        Logger.get().error(TAG, "Unexpected SQLite exception during migrations");     // Catch: Throwable -> L25
        IllegalStateException r8 = new IllegalStateException("Unexpected SQLite exception during migrations", e);     // Catch: Throwable -> L25
        Consumer<Throwable> r9 = this.mWorkManager.getConfiguration().getInitializationExceptionHandler();     // Catch: Throwable -> L25
        if (r9 == null) goto L24;
        r9.accept(r8);     // Catch: Throwable -> L25
        goto L22
    L24:
        throw r8;     // Catch: Throwable -> L25
    }

    public boolean isForceStopped() {
    L25:
        e = move-exception;
        Logger.get().warning(TAG, "Ignoring exception", e);
        return true;
    L4:
        if (Build.VERSION.SDK_INT < 31) goto L6;
        int r1 = 570425344;
    L7:
        PendingIntent r2 = getPendingIntent(this.mContext, r1);     // Catch: Throwable -> L25
        if (r2 == null) goto L10;
        r2.cancel();     // Catch: Throwable -> L25
    L10:
        List<ApplicationExitInfo> r3 = ((ActivityManager) this.mContext.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);     // Catch: Throwable -> L25
        if (r3 != null) goto L13;
    L24:
        return false;
    L13:
        if (r3.isEmpty() == true) goto L24;
        long r4 = this.mPreferenceUtils.getLastForceStopEventMillis();     // Catch: Throwable -> L25
        int r8 = 0;
    L15:
        if (r8 >= r3.size()) goto L24;
        ApplicationExitInfo r5 = r3.get(r8);     // Catch: Throwable -> L25
        if (r5.getReason() != 10) goto L23;
        if (r5.getTimestamp() < r4) goto L23;
        return true;
    L23:
        r8 = r8 + 1;
        goto L15
    L6:
        r1 = 536870912;
        goto L7
    }

    public void forceStopRunnable() {
        boolean r0 = cleanUp();
        if (shouldRescheduleWorkers() == false) goto L6;
        Logger.get().debug(TAG, "Rescheduling Workers.");
        this.mWorkManager.rescheduleEligibleWork();
        this.mWorkManager.getPreferenceUtils().setNeedsReschedule(false);
        return;
    L6:
        if (isForceStopped() == false) goto L8;
        Logger.get().debug(TAG, "Application was force-stopped, rescheduling.");
        this.mWorkManager.rescheduleEligibleWork();
        this.mPreferenceUtils.setLastForceStopEventMillis(System.currentTimeMillis());
        return;
    L8:
        if (r0 == false) goto L13;
        Logger.get().debug(TAG, "Found unfinished work, scheduling it.");
        Schedulers.schedule(this.mWorkManager.getConfiguration(), this.mWorkManager.getWorkDatabase(), this.mWorkManager.getSchedulers());
        return;
    }

    public boolean cleanUp() {
        boolean r0 = SystemJobScheduler.reconcileJobs(this.mContext, this.mWorkManager);
        WorkDatabase r10 = this.mWorkManager.getWorkDatabase();
        WorkSpecDao r1 = r10.workSpecDao();
        WorkProgressDao r2 = r10.workProgressDao();
        r10.beginTransaction();
        List<WorkSpec> r3 = r1.getRunningWork();     // Catch: Throwable -> L21
        if (r3 != null) goto L6;
    L8:
        boolean r6 = false;
    L9:
        if (r6 == false) goto L14;
        Iterator<WorkSpec> r4 = r3.iterator();     // Catch: Throwable -> L21
    L12:
        if (r4.hasNext() == false) goto L14;
        WorkSpec r7 = r4.next();     // Catch: Throwable -> L21
        r1.setState(WorkInfo.State.ENQUEUED, r7.id);     // Catch: Throwable -> L21
        r1.markWorkSpecScheduled(r7.id, -1);     // Catch: Throwable -> L21
    L14:
        r2.deleteAll();     // Catch: Throwable -> L21
        r10.setTransactionSuccessful();     // Catch: Throwable -> L21
        r10.endTransaction();
        if (r6 == true) goto L27;
        if (r0 == false) goto L20;
        return true;
    L20:
        return false;
    L27:
        return true;
    L6:
        if (r3.isEmpty() == true) goto L8;
        r6 = true;
    L21:
        th = move-exception;
        r10.endTransaction();
        throw th;
    }

    public boolean shouldRescheduleWorkers() {
        return this.mWorkManager.getPreferenceUtils().getNeedsReschedule();
    }

    public boolean multiProcessChecks() {
        Configuration r0 = this.mWorkManager.getConfiguration();
        if (TextUtils.isEmpty(r0.getDefaultProcessName()) == false) goto L6;
        Logger.get().debug(TAG, "The default process name was not specified.");
        return true;
    L6:
        boolean r4 = ProcessUtils.isDefaultProcess(this.mContext, r0);
        Logger.get().debug(TAG, "Is default app process = " + r4);
        return r4;
    }

    public void sleep(long duration) {
        Thread.sleep(duration);     // Catch: InterruptedException -> L4
        return;
    }

    private static PendingIntent getPendingIntent(Context context, int flags) {
        return PendingIntent.getBroadcast(context, -1, getIntent(context), flags);
    }

    static Intent getIntent(Context context) {
        Intent r0 = new Intent();
        r0.setComponent(new ComponentName(context, BroadcastReceiver.class));
        r0.setAction(ACTION_FORCE_STOP_RESCHEDULE);
        return r0;
    }

    static void setAlarm(Context context) {
        AlarmManager r0 = (AlarmManager) context.getSystemService("alarm");
        if (Build.VERSION.SDK_INT < 31) goto L5;
        int r1 = 167772160;
    L6:
        PendingIntent r5 = getPendingIntent(context, r1);
        long r2 = System.currentTimeMillis() + TEN_YEARS;
        if (r0 == null) goto L10;
        r0.setExact(0, r2, r5);
        return;
    L10:
        return;
    L5:
        r1 = 134217728;
        goto L6
    }
}
