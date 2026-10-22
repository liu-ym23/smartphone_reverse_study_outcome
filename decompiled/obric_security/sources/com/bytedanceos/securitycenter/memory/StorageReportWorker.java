package com.bytedanceos.securitycenter.memory;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.bytedance.android.standard.tools.date.DateUtils;
import com.obric.olog.OLog;
import com.obric.securitycenter.api.TrackUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class StorageReportWorker extends Worker {
    private static final String EVENT_NAME = "security_storage_distribution";
    private static final String TAG = "StorageReportWorker";
    private static final String UNIQUE_WORK_NAME = "StorageDistributionReportWork";

    public StorageReportWorker(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        OLog.i(TAG, "doWork: start");
        Context r3 = getApplicationContext();
        SharedPreferences r5 = r3.getSharedPreferences("storage_report_prefs", 0);
        String r6 = new SimpleDateFormat(DateUtils.PATTERN_YEAR, Locale.getDefault()).format(new Date());
        StorageDistributionCollector.StorageData r7 = StorageDistributionCollector.collect(r3);     // Catch: Exception -> L10
        HashMap r8 = new HashMap();     // Catch: Exception -> L10
        r8.put("total_bytes", Long.valueOf(r7.totalBytes));     // Catch: Exception -> L10
        r8.put("avail_bytes", Long.valueOf(r7.availBytes));     // Catch: Exception -> L10
        r8.put("used_bytes", Long.valueOf(r7.usedBytes));     // Catch: Exception -> L10
        r8.put("app_bytes", Long.valueOf(r7.appBytes));     // Catch: Exception -> L10
        r8.put("image_bytes", Long.valueOf(r7.imageBytes));     // Catch: Exception -> L10
        r8.put("video_bytes", Long.valueOf(r7.videoBytes));     // Catch: Exception -> L10
        r8.put("audio_bytes", Long.valueOf(r7.audioBytes));     // Catch: Exception -> L10
        r8.put("download_bytes", Long.valueOf(r7.downloadBytes));     // Catch: Exception -> L10
        r8.put("other_file_bytes", Long.valueOf(r7.otherFileBytes));     // Catch: Exception -> L10
        r8.put("system_bytes", Long.valueOf(r7.systemBytes));     // Catch: Exception -> L10
        OLog.d(TAG, ">>> Event: security_storage_distribution for date: " + r6);     // Catch: Exception -> L10
        OLog.d(TAG, ">>> Event Params: " + r8.toString());     // Catch: Exception -> L10
        if (r7.totalBytes > 0) goto L7;
        OLog.e(TAG, "doWork: Invalid data collected (totalBytes <= 0). Retrying...");     // Catch: Exception -> L10
        return ListenableWorker.Result.retry();
    L7:
        TrackUtils.INSTANCE.trackEvent(EVENT_NAME, r8);     // Catch: Exception -> L10
        OLog.d(TAG, "doWork: Successfully collected data and saved date: " + r6 + " (Saved: " + r5.edit().putString("last_report_date", r6).commit() + ")");     // Catch: Exception -> L10
        scheduleNext(r3);
        OLog.i(TAG, "doWork: success");
        return ListenableWorker.Result.success();
    L10:
        e = move-exception;
        OLog.e(TAG, "doWork: Persistent error during collection", e);
        if (getRunAttemptCount() < 3) goto L16;
        OLog.e(TAG, "doWork: Crash limit reached (3). Giving up for today.");
        scheduleNext(r3);
        return ListenableWorker.Result.failure();
    L16:
        return ListenableWorker.Result.retry();
    }

    @Override // androidx.work.ListenableWorker
    public void onStopped() {
        super.onStopped();
        OLog.w(TAG, "onStopped: Worker was interrupted by system (timeout or app kill). WorkManager will retry this task later.");
    }

    public static void scheduleNext(Context context) {
        long r2 = System.currentTimeMillis();     // Catch: Throwable -> L8
        Calendar r4 = Calendar.getInstance();     // Catch: Throwable -> L8
        r4.setTimeInMillis(r2);     // Catch: Throwable -> L8
        r4.set(11, 8);     // Catch: Throwable -> L8
        r4.set(12, 0);     // Catch: Throwable -> L8
        r4.set(13, 0);     // Catch: Throwable -> L8
        r4.set(14, 0);     // Catch: Throwable -> L8
        if (r4.getTimeInMillis() > r2) goto L6;
        r4.add(6, 1);     // Catch: Throwable -> L8
    L6:
        long r5 = r4.getTimeInMillis() - r2;     // Catch: Throwable -> L8
        WorkManager.getInstance(context).enqueueUniqueWork(UNIQUE_WORK_NAME, ExistingWorkPolicy.REPLACE, new OneTimeWorkRequest.Builder(StorageReportWorker.class).setInitialDelay(r5, TimeUnit.MILLISECONDS).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).setBackoffCriteria(BackoffPolicy.LINEAR, 5, TimeUnit.MINUTES).addTag(TAG).build());     // Catch: Throwable -> L8
        long r6 = r5 / 1000;     // Catch: Throwable -> L8
        OLog.d(TAG, "ScheduleNext: Next report at fixed 8:00 AM, in " + r6 + "s (approx " + (r6 / 3600.0d) + "h)");     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        OLog.e(TAG, "ScheduleNext failed: " + th.getMessage());
    }

    public static void init(Context context) {
        Context r6 = context.getApplicationContext();
        OLog.i(TAG, "init: enqueueUniqueWork and scheduleNext");
        Constraints r0 = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
        OneTimeWorkRequest r1 = new OneTimeWorkRequest.Builder(StorageReportWorker.class).setConstraints(r0).setBackoffCriteria(BackoffPolicy.LINEAR, 5, TimeUnit.MINUTES).addTag(TAG).build();
        WorkManager.getInstance(r6).enqueueUniqueWork(UNIQUE_WORK_NAME, ExistingWorkPolicy.REPLACE, r1);
        scheduleNext(r6);
    }
}
