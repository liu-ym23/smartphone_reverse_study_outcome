package androidx.work.impl.model;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class PreferenceDao_Impl implements PreferenceDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<Preference> __insertionAdapterOfPreference;

    static /* synthetic */ RoomDatabase access$000(PreferenceDao_Impl r0) {
        return r0.__db;
    }

    public PreferenceDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfPreference = new AnonymousClass1(this, __db);
    }

    @Override // androidx.work.impl.model.PreferenceDao
    public void insertPreference(final Preference preference) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfPreference.insert(preference);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // androidx.work.impl.model.PreferenceDao
    public Long getLongValue(final String key) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT long_value FROM Preference where `key`=?", 1);
        if (key != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Long r1 = null;
        Cursor r3 = DBUtil.query(this.__db, r0, false, null);
    L15:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L8:
        if (r3.moveToFirst() == true) goto L10;
    L13:
        r3.close();
        r0.release();
        return r1;
    L10:
        if (r3.isNull(0) == true) goto L13;
        r1 = Long.valueOf(r3.getLong(0));     // Catch: Throwable -> L15
        goto L13
    L5:
        r0.bindString(1, key);
        goto L6
    }

    @Override // androidx.work.impl.model.PreferenceDao
    public LiveData<Long> getObservableLongValue(final String key) {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT long_value FROM Preference where `key`=?", 1);
        if (key != null) goto L5;
        r0.bindNull(1);
    L7:
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"Preference"}, false, new AnonymousClass2(this, r0));
    L5:
        r0.bindString(1, key);
        goto L7
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
