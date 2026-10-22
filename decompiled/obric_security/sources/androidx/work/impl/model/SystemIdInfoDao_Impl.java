package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class SystemIdInfoDao_Impl implements SystemIdInfoDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<SystemIdInfo> __insertionAdapterOfSystemIdInfo;
    private final SharedSQLiteStatement __preparedStmtOfRemoveSystemIdInfo;
    private final SharedSQLiteStatement __preparedStmtOfRemoveSystemIdInfo_1;

    public SystemIdInfoDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfSystemIdInfo = new AnonymousClass1(this, __db);
        this.__preparedStmtOfRemoveSystemIdInfo = new AnonymousClass2(this, __db);
        this.__preparedStmtOfRemoveSystemIdInfo_1 = new AnonymousClass3(this, __db);
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public void insertSystemIdInfo(final SystemIdInfo systemIdInfo) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfSystemIdInfo.insert(systemIdInfo);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public void removeSystemIdInfo(final String workSpecId, final int generation) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfRemoveSystemIdInfo.acquire();
        if (workSpecId != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, generation);
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfRemoveSystemIdInfo.release(r0);
        return;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfRemoveSystemIdInfo.release(r0);
        throw th;
    L5:
        r0.bindString(1, workSpecId);
        goto L6
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public void removeSystemIdInfo(final String workSpecId) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfRemoveSystemIdInfo_1.acquire();
        if (workSpecId != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfRemoveSystemIdInfo_1.release(r0);
        return;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfRemoveSystemIdInfo_1.release(r0);
        throw th;
    L5:
        r0.bindString(1, workSpecId);
        goto L6
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public SystemIdInfo getSystemIdInfo(String r5, int r6) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM SystemIdInfo WHERE work_spec_id=? AND generation=?", 2);
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r6);
        this.__db.assertNotSuspendingTransaction();
        SystemIdInfo r7 = null;
        String r8 = null;
        Cursor r4 = DBUtil.query(this.__db, r0, false, null);
        int r9 = CursorUtil.getColumnIndexOrThrow(r4, "work_spec_id");     // Catch: Throwable -> L17
        int r1 = CursorUtil.getColumnIndexOrThrow(r4, "generation");     // Catch: Throwable -> L17
        int r2 = CursorUtil.getColumnIndexOrThrow(r4, "system_id");     // Catch: Throwable -> L17
        if (r4.moveToFirst() == true) goto L10;
    L15:
        r4.close();
        r0.release();
        return r7;
    L10:
        if (r4.isNull(r9) == true) goto L13;
        r8 = r4.getString(r9);     // Catch: Throwable -> L17
    L13:
        r7 = new SystemIdInfo(r8, r4.getInt(r1), r4.getInt(r2));     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r4.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, r5);
        goto L6
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public List<String> getWorkSpecIds() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT DISTINCT work_spec_id FROM SystemIdInfo", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r3 = new ArrayList(r5.getCount());     // Catch: Throwable -> L14
    L4:
        if (r5.moveToNext() == false) goto L12;
        if (r5.isNull(0) == false) goto L9;
        String r4 = null;
    L10:
        r3.add(r4);     // Catch: Throwable -> L14
        goto L4
    L9:
        r4 = r5.getString(0);     // Catch: Throwable -> L14
        goto L10
    L12:
        r5.close();
        r0.release();
        return r3;
    L14:
        th = move-exception;
        r5.close();
        r0.release();
        throw th;
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public SystemIdInfo getSystemIdInfo(final WorkGenerationalId id) {
        return SystemIdInfoDao.DefaultImpls.getSystemIdInfo(this, id);
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public void removeSystemIdInfo(final WorkGenerationalId id) {
        SystemIdInfoDao.DefaultImpls.removeSystemIdInfo(this, id);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
