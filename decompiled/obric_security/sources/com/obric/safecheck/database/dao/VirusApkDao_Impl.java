package com.obric.safecheck.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.obric.safecheck.database.entity.VirusApkItem;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class VirusApkDao_Impl implements VirusApkDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<VirusApkItem> __insertionAdapterOfVirusApkItem;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByPkg;
    private final SharedSQLiteStatement __preparedStmtOfUpdateRiskControlState;
    private final SharedSQLiteStatement __preparedStmtOfUpdateVirusResult;

    public VirusApkDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfVirusApkItem = new AnonymousClass1(this, __db);
        this.__preparedStmtOfUpdateVirusResult = new AnonymousClass2(this, __db);
        this.__preparedStmtOfUpdateRiskControlState = new AnonymousClass3(this, __db);
        this.__preparedStmtOfDeleteAll = new AnonymousClass4(this, __db);
        this.__preparedStmtOfDeleteByPkg = new AnonymousClass5(this, __db);
    }

    @Override // com.obric.safecheck.database.dao.VirusApkDao
    public long insertIfAbsent(final VirusApkItem item) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfVirusApkItem.insertAndReturnId(item);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.safecheck.database.dao.VirusApkDao
    public void insert(final VirusApkItem item) {
        this.__db.beginTransaction();
        VirusApkDao.DefaultImpls.insert(this, item);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.safecheck.database.dao.VirusApkDao
    public void upsertVirusResult(final VirusApkItem item) {
        this.__db.beginTransaction();
        VirusApkDao.DefaultImpls.upsertVirusResult(this, item);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.safecheck.database.dao.VirusApkDao
    public void upsertRiskControlState(final String pkg, final String virusType, final int virusTypeCode, final String virusName, final String virusDescription, final String timestamp, final String riskControlState) {
        this.__db.beginTransaction();
        VirusApkDao.DefaultImpls.upsertRiskControlState(this, pkg, virusType, virusTypeCode, virusName, virusDescription, timestamp, riskControlState);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.safecheck.database.dao.VirusApkDao
    public int updateVirusResult(final String pkg, final String virusType, final int virusTypeCode, final String virusName, final String virusDescription, final String timestamp) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfUpdateVirusResult.acquire();
        if (virusType != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, virusTypeCode);
        if (virusName != null) goto L9;
        r0.bindNull(3);
    L11:
        if (virusDescription != null) goto L13;
        r0.bindNull(4);
    L15:
        if (timestamp != null) goto L17;
        r0.bindNull(5);
    L19:
        if (pkg != null) goto L21;
        r0.bindNull(6);
    L22:
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L26
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L26
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateVirusResult.release(r0);
        return r4;
    L26:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateVirusResult.release(r0);
        throw th;
    L21:
        r0.bindString(6, pkg);
        goto L22
    L17:
        r0.bindString(5, timestamp);
        goto L19
    L13:
        r0.bindString(4, virusDescription);
        goto L15
    L9:
        r0.bindString(3, virusName);
        goto L11
    L5:
        r0.bindString(1, virusType);
        goto L6
    }

    @Override // com.obric.safecheck.database.dao.VirusApkDao
    public int updateRiskControlState(final String pkg, final String riskControlState, final String virusDescription) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfUpdateRiskControlState.acquire();
        if (riskControlState != null) goto L5;
        r0.bindNull(1);
    L7:
        if (virusDescription != null) goto L9;
        r0.bindNull(2);
    L11:
        if (pkg != null) goto L13;
        r0.bindNull(3);
    L14:
        this.__db.beginTransaction();
        int r3 = r0.executeUpdateDelete();     // Catch: Throwable -> L18
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L18
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateRiskControlState.release(r0);
        return r3;
    L18:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateRiskControlState.release(r0);
        throw th;
    L13:
        r0.bindString(3, pkg);
        goto L14
    L9:
        r0.bindString(2, virusDescription);
        goto L11
    L5:
        r0.bindString(1, riskControlState);
        goto L7
    }

    @Override // com.obric.safecheck.database.dao.VirusApkDao
    public int deleteAll() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteAll.acquire();
        this.__db.beginTransaction();
        int r1 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAll.release(r0);
        return r1;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAll.release(r0);
        throw th;
    }

    @Override // com.obric.safecheck.database.dao.VirusApkDao
    public int deleteByPkg(final String pkg) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteByPkg.acquire();
        if (pkg != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.beginTransaction();
        int r3 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByPkg.release(r0);
        return r3;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByPkg.release(r0);
        throw th;
    L5:
        r0.bindString(1, pkg);
        goto L6
    }

    @Override // com.obric.safecheck.database.dao.VirusApkDao
    public List<VirusApkItem> getAll() {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM virus_apk_items", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, ApkVirusCheckProvider.KEY_PKG);     // Catch: Throwable -> L34
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "virus_type");     // Catch: Throwable -> L34
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "virus_type_code");     // Catch: Throwable -> L34
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "virus_name");     // Catch: Throwable -> L34
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "virus_description");     // Catch: Throwable -> L34
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L34
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "risk_control_state");     // Catch: Throwable -> L34
        ArrayList r10 = new ArrayList(r2.getCount());     // Catch: Throwable -> L34
    L4:
        if (r2.moveToNext() == false) goto L32;
        if (r2.isNull(r0) == false) goto L9;
        String r13 = null;
    L11:
        if (r2.isNull(r4) == false) goto L13;
        String r14 = null;
    L14:
        int r15 = r2.getInt(r5);     // Catch: Throwable -> L34
        if (r2.isNull(r6) == false) goto L17;
        String r16 = null;
    L19:
        if (r2.isNull(r7) == false) goto L21;
        String r17 = null;
    L23:
        if (r2.isNull(r8) == false) goto L25;
        String r18 = null;
    L27:
        if (r2.isNull(r9) == false) goto L29;
        String r19 = null;
    L30:
        r10.add(new VirusApkItem(r13, r14, r15, r16, r17, r18, r19));     // Catch: Throwable -> L34
        goto L4
    L29:
        r19 = r2.getString(r9);     // Catch: Throwable -> L34
        goto L30
    L25:
        r18 = r2.getString(r8);     // Catch: Throwable -> L34
        goto L27
    L21:
        r17 = r2.getString(r7);     // Catch: Throwable -> L34
        goto L23
    L17:
        r16 = r2.getString(r6);     // Catch: Throwable -> L34
        goto L19
    L13:
        r14 = r2.getString(r4);     // Catch: Throwable -> L34
        goto L14
    L9:
        r13 = r2.getString(r0);     // Catch: Throwable -> L34
        goto L11
    L32:
        r2.close();
        r1.release();
        return r10;
    L34:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.safecheck.database.dao.VirusApkDao
    public List<VirusApkItem> getByPkg(final String pkg) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM virus_apk_items WHERE pkg = ?", 1);
        if (pkg != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, ApkVirusCheckProvider.KEY_PKG);     // Catch: Throwable -> L38
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "virus_type");     // Catch: Throwable -> L38
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "virus_type_code");     // Catch: Throwable -> L38
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "virus_name");     // Catch: Throwable -> L38
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "virus_description");     // Catch: Throwable -> L38
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "timestamp");     // Catch: Throwable -> L38
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "risk_control_state");     // Catch: Throwable -> L38
        ArrayList r10 = new ArrayList(r1.getCount());     // Catch: Throwable -> L38
    L8:
        if (r1.moveToNext() == false) goto L36;
        if (r1.isNull(r0) == false) goto L13;
        String r13 = null;
    L15:
        if (r1.isNull(r4) == false) goto L17;
        String r14 = null;
    L18:
        int r15 = r1.getInt(r5);     // Catch: Throwable -> L38
        if (r1.isNull(r6) == false) goto L21;
        String r16 = null;
    L23:
        if (r1.isNull(r7) == false) goto L25;
        String r17 = null;
    L27:
        if (r1.isNull(r8) == false) goto L29;
        String r18 = null;
    L31:
        if (r1.isNull(r9) == false) goto L33;
        String r19 = null;
    L34:
        r10.add(new VirusApkItem(r13, r14, r15, r16, r17, r18, r19));     // Catch: Throwable -> L38
        goto L8
    L33:
        r19 = r1.getString(r9);     // Catch: Throwable -> L38
        goto L34
    L29:
        r18 = r1.getString(r8);     // Catch: Throwable -> L38
        goto L31
    L25:
        r17 = r1.getString(r7);     // Catch: Throwable -> L38
        goto L27
    L21:
        r16 = r1.getString(r6);     // Catch: Throwable -> L38
        goto L23
    L17:
        r14 = r1.getString(r4);     // Catch: Throwable -> L38
        goto L18
    L13:
        r13 = r1.getString(r0);     // Catch: Throwable -> L38
        goto L15
    L36:
        r1.close();
        r2.release();
        return r10;
    L38:
        th = move-exception;
        r1.close();
        r2.release();
        throw th;
    L5:
        r2.bindString(1, pkg);
        goto L6
    }

    @Override // com.obric.safecheck.database.dao.VirusApkDao
    public List<VirusApkItem> listRiskControlled() {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM virus_apk_items WHERE risk_control_state LIKE '%:1' ORDER BY timestamp DESC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, ApkVirusCheckProvider.KEY_PKG);     // Catch: Throwable -> L34
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "virus_type");     // Catch: Throwable -> L34
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "virus_type_code");     // Catch: Throwable -> L34
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "virus_name");     // Catch: Throwable -> L34
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "virus_description");     // Catch: Throwable -> L34
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L34
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "risk_control_state");     // Catch: Throwable -> L34
        ArrayList r10 = new ArrayList(r2.getCount());     // Catch: Throwable -> L34
    L4:
        if (r2.moveToNext() == false) goto L32;
        if (r2.isNull(r0) == false) goto L9;
        String r13 = null;
    L11:
        if (r2.isNull(r4) == false) goto L13;
        String r14 = null;
    L14:
        int r15 = r2.getInt(r5);     // Catch: Throwable -> L34
        if (r2.isNull(r6) == false) goto L17;
        String r16 = null;
    L19:
        if (r2.isNull(r7) == false) goto L21;
        String r17 = null;
    L23:
        if (r2.isNull(r8) == false) goto L25;
        String r18 = null;
    L27:
        if (r2.isNull(r9) == false) goto L29;
        String r19 = null;
    L30:
        r10.add(new VirusApkItem(r13, r14, r15, r16, r17, r18, r19));     // Catch: Throwable -> L34
        goto L4
    L29:
        r19 = r2.getString(r9);     // Catch: Throwable -> L34
        goto L30
    L25:
        r18 = r2.getString(r8);     // Catch: Throwable -> L34
        goto L27
    L21:
        r17 = r2.getString(r7);     // Catch: Throwable -> L34
        goto L23
    L17:
        r16 = r2.getString(r6);     // Catch: Throwable -> L34
        goto L19
    L13:
        r14 = r2.getString(r4);     // Catch: Throwable -> L34
        goto L14
    L9:
        r13 = r2.getString(r0);     // Catch: Throwable -> L34
        goto L11
    L32:
        r2.close();
        r1.release();
        return r10;
    L34:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
