package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.Preference;

/* JADX INFO: loaded from: classes.dex */
public class PreferenceUtils {
    public static final String CREATE_PREFERENCE = "CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))";
    public static final String INSERT_PREFERENCE = "INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)";
    public static final String KEY_LAST_CANCEL_ALL_TIME_MS = "last_cancel_all_time_ms";
    private static final String KEY_LAST_FORCE_STOP_MS = "last_force_stop_ms";
    public static final String KEY_RESCHEDULE_NEEDED = "reschedule_needed";
    public static final String PREFERENCES_FILE_NAME = "androidx.work.util.preferences";
    private final WorkDatabase mWorkDatabase;

    public PreferenceUtils(WorkDatabase workDatabase) {
        this.mWorkDatabase = workDatabase;
    }

    public long getLastCancelAllTimeMillis() {
        Long r2 = this.mWorkDatabase.preferenceDao().getLongValue(KEY_LAST_CANCEL_ALL_TIME_MS);
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.longValue();
    }

    public LiveData<Long> getLastCancelAllTimeMillisLiveData() {
        return Transformations.map(this.mWorkDatabase.preferenceDao().getObservableLongValue(KEY_LAST_CANCEL_ALL_TIME_MS), new AnonymousClass1(this));
    }

    public void setLastCancelAllTimeMillis(final long timeMillis) {
        Preference r0 = new Preference(KEY_LAST_CANCEL_ALL_TIME_MS, Long.valueOf(timeMillis));
        this.mWorkDatabase.preferenceDao().insertPreference(r0);
    }

    public boolean getNeedsReschedule() {
        Long r4 = this.mWorkDatabase.preferenceDao().getLongValue(KEY_RESCHEDULE_NEEDED);
        if (r4 != null) goto L5;
    L7:
        return false;
    L5:
        if (r4.longValue() != 1) goto L7;
        return true;
    }

    public void setNeedsReschedule(boolean needsReschedule) {
        Preference r0 = new Preference(KEY_RESCHEDULE_NEEDED, needsReschedule);
        this.mWorkDatabase.preferenceDao().insertPreference(r0);
    }

    public void setLastForceStopEventMillis(long lastForceStopTimeMillis) {
        Preference r0 = new Preference(KEY_LAST_FORCE_STOP_MS, Long.valueOf(lastForceStopTimeMillis));
        this.mWorkDatabase.preferenceDao().insertPreference(r0);
    }

    public long getLastForceStopEventMillis() {
        Long r2 = this.mWorkDatabase.preferenceDao().getLongValue(KEY_LAST_FORCE_STOP_MS);
        if (r2 != null) goto L5;
        return 0;
    L5:
        return r2.longValue();
    }

    public static void migrateLegacyPreferences(Context context, SupportSQLiteDatabase sqLiteDatabase) {
        SharedPreferences r10 = context.getSharedPreferences(PREFERENCES_FILE_NAME, 0);
        if (r10.contains(KEY_RESCHEDULE_NEEDED) == false) goto L5;
    L6:
        long r5 = 0;
        long r7 = r10.getLong(KEY_LAST_CANCEL_ALL_TIME_MS, 0);
        if (r10.getBoolean(KEY_RESCHEDULE_NEEDED, false) == false) goto L9;
        r5 = 1;
    L9:
        sqLiteDatabase.beginTransaction();
        sqLiteDatabase.execSQL(INSERT_PREFERENCE, new Object[]{KEY_LAST_CANCEL_ALL_TIME_MS, Long.valueOf(r7)});     // Catch: Throwable -> L13
        sqLiteDatabase.execSQL(INSERT_PREFERENCE, new Object[]{KEY_RESCHEDULE_NEEDED, Long.valueOf(r5)});     // Catch: Throwable -> L13
        r10.edit().clear().apply();     // Catch: Throwable -> L13
        sqLiteDatabase.setTransactionSuccessful();     // Catch: Throwable -> L13
        sqLiteDatabase.endTransaction();
        return;
    L13:
        th = move-exception;
        sqLiteDatabase.endTransaction();
        throw th;
    L5:
        if (r10.contains(KEY_LAST_CANCEL_ALL_TIME_MS) == true) goto L6;
    }
}
