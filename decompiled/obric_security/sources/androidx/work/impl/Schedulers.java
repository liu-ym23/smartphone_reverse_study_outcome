package androidx.work.impl;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.PackageManagerHelper;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Schedulers {
    public static final String GCM_SCHEDULER = "androidx.work.impl.background.gcm.GcmScheduler";
    private static final String TAG = null;

    static {
        TAG = Logger.tagWithPrefix("Schedulers");
    }

    public static void schedule(Configuration configuration, WorkDatabase workDatabase, List<Scheduler> schedulers) {
        if (schedulers != null) goto L4;
        return;
    L4:
        if (schedulers.size() == 0) goto L55;
        WorkSpecDao r0 = workDatabase.workSpecDao();
        workDatabase.beginTransaction();
        List<WorkSpec> r6 = r0.getEligibleWorkForScheduling(configuration.getMaxSchedulerLimit());     // Catch: Throwable -> L36
        List<WorkSpec> r1 = r0.getAllEligibleWorkSpecsForScheduling(200);     // Catch: Throwable -> L36
        if (r6 != null) goto L10;
    L15:
        workDatabase.setTransactionSuccessful();     // Catch: Throwable -> L36
        workDatabase.endTransaction();
        if (r6 != null) goto L19;
    L26:
        if (r1 != null) goto L28;
        return;
    L28:
        if (r1.size() <= 0) goto L53;
        WorkSpec[] r7 = (WorkSpec[]) r1.toArray(new WorkSpec[r1.size()]);
        Iterator<Scheduler> r8 = schedulers.iterator();
    L31:
        if (r8.hasNext() == false) goto L54;
        Scheduler r9 = r8.next();
        if (r9.hasLimitedSchedulingSlots() == true) goto L31;
        r9.schedule(r7);
        goto L31
    L54:
        return;
    L53:
        return;
    L19:
        if (r6.size() <= 0) goto L26;
        WorkSpec[] r10 = (WorkSpec[]) r6.toArray(new WorkSpec[r6.size()]);
        Iterator<Scheduler> r11 = schedulers.iterator();
    L22:
        if (r11.hasNext() == false) goto L26;
        Scheduler r2 = r11.next();
        if (r2.hasLimitedSchedulingSlots() == false) goto L22;
        r2.schedule(r10);
        goto L22
    L10:
        if (r6.size() <= 0) goto L15;
        long r3 = System.currentTimeMillis();     // Catch: Throwable -> L36
        Iterator<WorkSpec> r4 = r6.iterator();     // Catch: Throwable -> L36
    L13:
        if (r4.hasNext() == false) goto L15;
        r0.markWorkSpecScheduled(r4.next().id, r3);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        workDatabase.endTransaction();
        throw th;
    }

    static Scheduler createBestAvailableBackgroundScheduler(Context context, WorkManagerImpl workManager) {
        SystemJobScheduler r0 = new SystemJobScheduler(context, workManager);
        PackageManagerHelper.setComponentEnabled(context, SystemJobService.class, true);
        Logger.get().debug(TAG, "Created SystemJobScheduler and enabled SystemJobService");
        return r0;
    }

    private static Scheduler tryCreateGcmBasedScheduler(Context context) {
        Scheduler r5 = (Scheduler) Class.forName(GCM_SCHEDULER).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});     // Catch: Throwable -> L4
        Logger.get().debug(TAG, "Created androidx.work.impl.background.gcm.GcmScheduler");     // Catch: Throwable -> L4
        return r5;
    L4:
        th = move-exception;
        Logger.get().debug(TAG, "Unable to create GCM Scheduler", th);
        return null;
    }

    private Schedulers() {
    }
}
