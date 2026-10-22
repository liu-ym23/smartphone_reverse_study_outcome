package com.obric.safecheck.dataSync;

import android.content.Context;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import com.obric.olog.OLog;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WorkManagerHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/obric/safecheck/dataSync/WorkManagerHelper;", "", "()V", "calculateInitialDelay", "", "initDailySyncWork", "", "context", "Landroid/content/Context;", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class WorkManagerHelper {
    public static final WorkManagerHelper INSTANCE = null;

    static {
        INSTANCE = new WorkManagerHelper();
    }

    private WorkManagerHelper() {
    }

    public final void initDailySyncWork(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        OLog.i("WorkManagerHelper_AntiFraud", "initDailySyncWork");
        WorkManager.getInstance(r10).cancelUniqueWork("DailyDataSyncWork");
        Constraints r9 = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).setRequiresBatteryNotLow(false).setRequiresCharging(true).build();
        PeriodicWorkRequest r11 = new PeriodicWorkRequest.Builder(DataSyncWorker.class, 1, TimeUnit.DAYS, 1, TimeUnit.DAYS).setConstraints(r9).setBackoffCriteria(BackoffPolicy.EXPONENTIAL, 10, TimeUnit.SECONDS).addTag("DATA_SYNC_WORK_TAG_2").build();
        WorkManager.getInstance(r10).enqueueUniquePeriodicWork("DailyDataSyncWork2", ExistingPeriodicWorkPolicy.KEEP, r11);
    }

    private final long calculateInitialDelay() {
        Calendar r6 = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(r6, "calendar");
        long r0 = r6.getTimeInMillis();
        r6.set(11, 4);
        r6.set(12, 0);
        r6.set(13, 0);
        r6.set(14, 0);
        long r2 = r6.getTimeInMillis();
        if (r2 > r0) goto L6;
        r2 = r2 + TimeUnit.DAYS.toMillis(1);
    L6:
        return r2 - r0;
    }
}
