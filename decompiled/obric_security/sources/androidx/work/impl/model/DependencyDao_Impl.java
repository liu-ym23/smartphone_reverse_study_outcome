package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class DependencyDao_Impl implements DependencyDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<Dependency> __insertionAdapterOfDependency;

    public DependencyDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfDependency = new AnonymousClass1(this, __db);
    }

    @Override // androidx.work.impl.model.DependencyDao
    public void insertDependency(final Dependency dependency) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfDependency.insert(dependency);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // androidx.work.impl.model.DependencyDao
    public boolean hasCompletedAllPrerequisites(final String id) {
        boolean r1 = true;
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
        if (id != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        boolean r2 = false;
        Cursor r3 = DBUtil.query(this.__db, r0, false, null);
    L16:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L8:
        if (r3.moveToFirst() == false) goto L14;
        if (r3.getInt(0) != 0) goto L13;
        r1 = false;
    L13:
        r2 = r1;
    L14:
        r3.close();
        r0.release();
        return r2;
    L5:
        r0.bindString(1, id);
        goto L6
    }

    @Override // androidx.work.impl.model.DependencyDao
    public List<String> getPrerequisites(final String id) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT prerequisite_id FROM dependency WHERE work_spec_id=?", 1);
        if (id != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r2 = new ArrayList(r4.getCount());     // Catch: Throwable -> L18
    L8:
        if (r4.moveToNext() == false) goto L16;
        if (r4.isNull(0) == false) goto L13;
        String r3 = null;
    L14:
        r2.add(r3);     // Catch: Throwable -> L18
        goto L8
    L13:
        r3 = r4.getString(0);     // Catch: Throwable -> L18
        goto L14
    L16:
        r4.close();
        r0.release();
        return r2;
    L18:
        th = move-exception;
        r4.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, id);
        goto L6
    }

    @Override // androidx.work.impl.model.DependencyDao
    public List<String> getDependentWorkIds(final String id) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
        if (id != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r2 = new ArrayList(r4.getCount());     // Catch: Throwable -> L18
    L8:
        if (r4.moveToNext() == false) goto L16;
        if (r4.isNull(0) == false) goto L13;
        String r3 = null;
    L14:
        r2.add(r3);     // Catch: Throwable -> L18
        goto L8
    L13:
        r3 = r4.getString(0);     // Catch: Throwable -> L18
        goto L14
    L16:
        r4.close();
        r0.release();
        return r2;
    L18:
        th = move-exception;
        r4.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, id);
        goto L6
    }

    @Override // androidx.work.impl.model.DependencyDao
    public boolean hasDependents(final String id) {
        boolean r1 = true;
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
        if (id != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        boolean r2 = false;
        Cursor r3 = DBUtil.query(this.__db, r0, false, null);
    L16:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L8:
        if (r3.moveToFirst() == false) goto L14;
        if (r3.getInt(0) != 0) goto L13;
        r1 = false;
    L13:
        r2 = r1;
    L14:
        r3.close();
        r0.release();
        return r2;
    L5:
        r0.bindString(1, id);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
