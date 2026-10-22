package com.obric.safecheck.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import com.obric.safecheck.database.entity.EndDataEntity;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class EndDataDao_Impl implements EndDataDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<EndDataEntity> __insertionAdapterOfEndDataEntity;

    public EndDataDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfEndDataEntity = new AnonymousClass1(this, __db);
    }

    @Override // com.obric.safecheck.database.dao.EndDataDao
    public void updateEndData(final EndDataEntity endDataEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfEndDataEntity.insert(endDataEntity);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.safecheck.database.dao.EndDataDao
    public String getEndData() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT enddata FROM end_data_table WHERE id = 1", 0);
        this.__db.assertNotSuspendingTransaction();
        String r2 = null;
        Cursor r4 = DBUtil.query(this.__db, r0, false, null);
    L11:
        th = move-exception;
        r4.close();
        r0.release();
        throw th;
    L4:
        if (r4.moveToFirst() == true) goto L6;
    L9:
        r4.close();
        r0.release();
        return r2;
    L6:
        if (r4.isNull(0) == true) goto L9;
        r2 = r4.getString(0);     // Catch: Throwable -> L11
        goto L9
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
