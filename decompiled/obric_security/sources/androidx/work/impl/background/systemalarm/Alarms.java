package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import androidx.work.Logger;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.SystemIdInfoKt;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.utils.IdGenerator;

/* JADX INFO: loaded from: classes.dex */
class Alarms {
    private static final String TAG = null;

    static class Api19Impl {
        private Api19Impl() {
        }

        static void setExact(AlarmManager alarmManager, int type, long triggerAtMillis, PendingIntent operation) {
            alarmManager.setExact(type, triggerAtMillis, operation);
        }
    }

    static {
        TAG = Logger.tagWithPrefix("Alarms");
    }

    public static void setAlarm(Context context, WorkDatabase workDatabase, WorkGenerationalId id, long triggerAtMillis) {
        SystemIdInfoDao r0 = workDatabase.systemIdInfoDao();
        SystemIdInfo r1 = r0.getSystemIdInfo(id);
        if (r1 == null) goto L5;
        cancelExactAlarm(context, id, r1.systemId);
        setExactAlarm(context, id, r1.systemId, triggerAtMillis);
        return;
    L5:
        int r3 = new IdGenerator(workDatabase).nextAlarmManagerId();
        r0.insertSystemIdInfo(SystemIdInfoKt.systemIdInfo(id, r3));
        setExactAlarm(context, id, r3, triggerAtMillis);
    }

    public static void cancelAlarm(Context context, WorkDatabase workDatabase, WorkGenerationalId id) {
        SystemIdInfoDao r4 = workDatabase.systemIdInfoDao();
        SystemIdInfo r0 = r4.getSystemIdInfo(id);
        if (r0 == null) goto L6;
        cancelExactAlarm(context, id, r0.systemId);
        Logger.get().debug(TAG, "Removing SystemIdInfo for workSpecId (" + id + ")");
        r4.removeSystemIdInfo(id);
        return;
    }

    private static void cancelExactAlarm(Context context, WorkGenerationalId id, int alarmId) {
        AlarmManager r0 = (AlarmManager) context.getSystemService("alarm");
        PendingIntent r5 = PendingIntent.getService(context, alarmId, CommandHandler.createDelayMetIntent(context, id), 603979776);
        if (r5 == null) goto L7;
        if (r0 == null) goto L8;
        Logger.get().debug(TAG, "Cancelling existing alarm with (workSpecId, systemId) (" + id + ", " + alarmId + ")");
        r0.cancel(r5);
        return;
    L8:
        return;
    }

    private static void setExactAlarm(Context context, WorkGenerationalId id, int alarmId, long triggerAtMillis) {
        AlarmManager r0 = (AlarmManager) context.getSystemService("alarm");
        PendingIntent r2 = PendingIntent.getService(context, alarmId, CommandHandler.createDelayMetIntent(context, id), 201326592);
        if (r0 == null) goto L6;
        Api19Impl.setExact(r0, 0, triggerAtMillis, r2);
        return;
    }

    private Alarms() {
    }
}
