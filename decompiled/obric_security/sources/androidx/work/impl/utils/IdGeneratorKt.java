package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.Preference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IdGenerator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a\u0014\u0010\f\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0002\u001a\u001c\u0010\u000f\u001a\u00020\u0007*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"INITIAL_ID", "", "NEXT_ALARM_MANAGER_ID_KEY", "", "NEXT_JOB_SCHEDULER_ID_KEY", "PREFERENCE_FILE_KEY", "migrateLegacyIdGenerator", "", "context", "Landroid/content/Context;", "sqLiteDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "nextId", "Landroidx/work/impl/WorkDatabase;", "key", "updatePreference", "value", "work-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class IdGeneratorKt {
    public static final int INITIAL_ID = 0;
    public static final String NEXT_ALARM_MANAGER_ID_KEY = "next_alarm_manager_id";
    public static final String NEXT_JOB_SCHEDULER_ID_KEY = "next_job_scheduler_id";
    public static final String PREFERENCE_FILE_KEY = "androidx.work.util.id";

    public static final /* synthetic */ int access$nextId(WorkDatabase r0, String r1) {
        return nextId(r0, r1);
    }

    public static final /* synthetic */ void access$updatePreference(WorkDatabase r0, String r1, int r2) {
        updatePreference(r0, r1, r2);
    }

    private static final int nextId(WorkDatabase r4, String r5) {
        Long r0 = r4.preferenceDao().getLongValue(r5);
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = (int) r0.longValue();
    L7:
        if (r2 == Integer.MAX_VALUE) goto L10;
        r1 = r2 + 1;
    L10:
        updatePreference(r4, r5, r1);
        return r2;
    L5:
        r2 = 0;
        goto L7
    }

    private static final void updatePreference(WorkDatabase r3, String r4, int r5) {
        r3.preferenceDao().insertPreference(new Preference(r4, Long.valueOf(r5)));
    }

    public static final void migrateLegacyIdGenerator(Context r8, SupportSQLiteDatabase r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "sqLiteDatabase");
        SharedPreferences r10 = r8.getSharedPreferences(PREFERENCE_FILE_KEY, 0);
        if (r10.contains(NEXT_JOB_SCHEDULER_ID_KEY) == false) goto L5;
    L6:
        int r3 = r10.getInt(NEXT_JOB_SCHEDULER_ID_KEY, 0);
        int r5 = r10.getInt(NEXT_ALARM_MANAGER_ID_KEY, 0);
        r9.beginTransaction();
        r9.execSQL(PreferenceUtils.INSERT_PREFERENCE, new Object[]{NEXT_JOB_SCHEDULER_ID_KEY, Integer.valueOf(r3)});     // Catch: Throwable -> L10
        r9.execSQL(PreferenceUtils.INSERT_PREFERENCE, new Object[]{NEXT_ALARM_MANAGER_ID_KEY, Integer.valueOf(r5)});     // Catch: Throwable -> L10
        r10.edit().clear().apply();     // Catch: Throwable -> L10
        r9.setTransactionSuccessful();     // Catch: Throwable -> L10
        r9.endTransaction();
        return;
    L10:
        th = move-exception;
        r9.endTransaction();
        throw th;
    L5:
        if (r10.contains(NEXT_JOB_SCHEDULER_ID_KEY) == true) goto L6;
    }
}
