package com.obric.safecheck.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.obric.safecheck.database.entity.PkgSignItem;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class PkgSignDao_Impl implements PkgSignDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<PkgSignItem> __insertionAdapterOfPkgSignItem;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllPkgSignItems;
    private final SharedSQLiteStatement __preparedStmtOfDeleteDataBeforeDate;
    private final SharedSQLiteStatement __preparedStmtOfDeletePkgSignItemByPkg;

    public PkgSignDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfPkgSignItem = new AnonymousClass1(this, __db);
        this.__preparedStmtOfDeletePkgSignItemByPkg = new AnonymousClass2(this, __db);
        this.__preparedStmtOfDeleteAllPkgSignItems = new AnonymousClass3(this, __db);
        this.__preparedStmtOfDeleteDataBeforeDate = new AnonymousClass4(this, __db);
    }

    @Override // com.obric.safecheck.database.dao.PkgSignDao
    public void insertPkgSignItem(final PkgSignItem item) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfPkgSignItem.insert(item);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.safecheck.database.dao.PkgSignDao
    public void insertAll(final List<PkgSignItem> items) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfPkgSignItem.insert(items);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.safecheck.database.dao.PkgSignDao
    public void insertAllPkgSignItems(final List<PkgSignItem> items) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfPkgSignItem.insert(items);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.safecheck.database.dao.PkgSignDao
    public void deletePkgSignItemByPkg(final String pkgName) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeletePkgSignItemByPkg.acquire();
        if (pkgName != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfDeletePkgSignItemByPkg.release(r0);
        return;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeletePkgSignItemByPkg.release(r0);
        throw th;
    L5:
        r0.bindString(1, pkgName);
        goto L6
    }

    @Override // com.obric.safecheck.database.dao.PkgSignDao
    public void deleteAllPkgSignItems() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteAllPkgSignItems.acquire();
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAllPkgSignItems.release(r0);
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAllPkgSignItems.release(r0);
        throw th;
    }

    @Override // com.obric.safecheck.database.dao.PkgSignDao
    public int deleteDataBeforeDate(final String targetDate) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteDataBeforeDate.acquire();
        if (targetDate != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.beginTransaction();
        int r3 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteDataBeforeDate.release(r0);
        return r3;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteDataBeforeDate.release(r0);
        throw th;
    L5:
        r0.bindString(1, targetDate);
        goto L6
    }

    @Override // com.obric.safecheck.database.dao.PkgSignDao
    public List<PkgSignItem> getAllPkgSignItems() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM pkg_sign_items", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r14 = DBUtil.query(this.__db, r0, false, null);
        int r3 = CursorUtil.getColumnIndexOrThrow(r14, "umd5");     // Catch: Throwable -> L42
        int r4 = CursorUtil.getColumnIndexOrThrow(r14, ApkVirusCheckProvider.KEY_PKG);     // Catch: Throwable -> L42
        int r5 = CursorUtil.getColumnIndexOrThrow(r14, "risk_level");     // Catch: Throwable -> L42
        int r6 = CursorUtil.getColumnIndexOrThrow(r14, "tmd5");     // Catch: Throwable -> L42
        int r7 = CursorUtil.getColumnIndexOrThrow(r14, "tsha1");     // Catch: Throwable -> L42
        int r8 = CursorUtil.getColumnIndexOrThrow(r14, "tsha256");     // Catch: Throwable -> L42
        int r9 = CursorUtil.getColumnIndexOrThrow(r14, "is_blacklist");     // Catch: Throwable -> L42
        int r10 = CursorUtil.getColumnIndexOrThrow(r14, "timestamp");     // Catch: Throwable -> L42
        ArrayList r11 = new ArrayList(r14.getCount());     // Catch: Throwable -> L42
    L4:
        if (r14.moveToNext() == false) goto L40;
        PkgSignItem r12 = new PkgSignItem();     // Catch: Throwable -> L42
        if (r14.isNull(r3) == false) goto L9;
        String r13 = null;
    L10:
        r12.setUmd5(r13);     // Catch: Throwable -> L42
        if (r14.isNull(r4) == false) goto L13;
        String r15 = null;
    L14:
        r12.setPkg(r15);     // Catch: Throwable -> L42
        if (r14.isNull(r5) == false) goto L17;
        String r16 = null;
    L18:
        r12.setRiskLevel(r16);     // Catch: Throwable -> L42
        if (r14.isNull(r6) == false) goto L21;
        String r17 = null;
    L22:
        r12.setTmd5(r17);     // Catch: Throwable -> L42
        if (r14.isNull(r7) == false) goto L25;
        String r18 = null;
    L26:
        r12.setTsha1(r18);     // Catch: Throwable -> L42
        if (r14.isNull(r8) == false) goto L29;
        String r19 = null;
    L30:
        r12.setTsha256(r19);     // Catch: Throwable -> L42
        if (r14.getInt(r9) == 0) goto L33;
        boolean r110 = true;
    L34:
        r12.setBlacklist(r110);     // Catch: Throwable -> L42
        if (r14.isNull(r10) == false) goto L37;
        String r111 = null;
    L38:
        r12.setTimestamp(r111);     // Catch: Throwable -> L42
        r11.add(r12);     // Catch: Throwable -> L42
        goto L4
    L37:
        r111 = r14.getString(r10);     // Catch: Throwable -> L42
        goto L38
    L33:
        r110 = false;
        goto L34
    L29:
        r19 = r14.getString(r8);     // Catch: Throwable -> L42
        goto L30
    L25:
        r18 = r14.getString(r7);     // Catch: Throwable -> L42
        goto L26
    L21:
        r17 = r14.getString(r6);     // Catch: Throwable -> L42
        goto L22
    L17:
        r16 = r14.getString(r5);     // Catch: Throwable -> L42
        goto L18
    L13:
        r15 = r14.getString(r4);     // Catch: Throwable -> L42
        goto L14
    L9:
        r13 = r14.getString(r3);     // Catch: Throwable -> L42
        goto L10
    L40:
        r14.close();
        r0.release();
        return r11;
    L42:
        th = move-exception;
        r14.close();
        r0.release();
        throw th;
    }

    @Override // com.obric.safecheck.database.dao.PkgSignDao
    public List<PkgSignItem> getPkgSignItemsByPkg(final String pkgName) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM pkg_sign_items WHERE pkg = ?", 1);
        if (pkgName != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r14 = DBUtil.query(this.__db, r0, false, null);
        int r3 = CursorUtil.getColumnIndexOrThrow(r14, "umd5");     // Catch: Throwable -> L46
        int r4 = CursorUtil.getColumnIndexOrThrow(r14, ApkVirusCheckProvider.KEY_PKG);     // Catch: Throwable -> L46
        int r5 = CursorUtil.getColumnIndexOrThrow(r14, "risk_level");     // Catch: Throwable -> L46
        int r6 = CursorUtil.getColumnIndexOrThrow(r14, "tmd5");     // Catch: Throwable -> L46
        int r7 = CursorUtil.getColumnIndexOrThrow(r14, "tsha1");     // Catch: Throwable -> L46
        int r8 = CursorUtil.getColumnIndexOrThrow(r14, "tsha256");     // Catch: Throwable -> L46
        int r9 = CursorUtil.getColumnIndexOrThrow(r14, "is_blacklist");     // Catch: Throwable -> L46
        int r10 = CursorUtil.getColumnIndexOrThrow(r14, "timestamp");     // Catch: Throwable -> L46
        ArrayList r11 = new ArrayList(r14.getCount());     // Catch: Throwable -> L46
    L8:
        if (r14.moveToNext() == false) goto L44;
        PkgSignItem r12 = new PkgSignItem();     // Catch: Throwable -> L46
        if (r14.isNull(r3) == false) goto L13;
        String r13 = null;
    L14:
        r12.setUmd5(r13);     // Catch: Throwable -> L46
        if (r14.isNull(r4) == false) goto L17;
        String r15 = null;
    L18:
        r12.setPkg(r15);     // Catch: Throwable -> L46
        if (r14.isNull(r5) == false) goto L21;
        String r16 = null;
    L22:
        r12.setRiskLevel(r16);     // Catch: Throwable -> L46
        if (r14.isNull(r6) == false) goto L25;
        String r17 = null;
    L26:
        r12.setTmd5(r17);     // Catch: Throwable -> L46
        if (r14.isNull(r7) == false) goto L29;
        String r18 = null;
    L30:
        r12.setTsha1(r18);     // Catch: Throwable -> L46
        if (r14.isNull(r8) == false) goto L33;
        String r19 = null;
    L34:
        r12.setTsha256(r19);     // Catch: Throwable -> L46
        if (r14.getInt(r9) == 0) goto L37;
        boolean r110 = true;
    L38:
        r12.setBlacklist(r110);     // Catch: Throwable -> L46
        if (r14.isNull(r10) == false) goto L41;
        String r111 = null;
    L42:
        r12.setTimestamp(r111);     // Catch: Throwable -> L46
        r11.add(r12);     // Catch: Throwable -> L46
        goto L8
    L41:
        r111 = r14.getString(r10);     // Catch: Throwable -> L46
        goto L42
    L37:
        r110 = false;
        goto L38
    L33:
        r19 = r14.getString(r8);     // Catch: Throwable -> L46
        goto L34
    L29:
        r18 = r14.getString(r7);     // Catch: Throwable -> L46
        goto L30
    L25:
        r17 = r14.getString(r6);     // Catch: Throwable -> L46
        goto L26
    L21:
        r16 = r14.getString(r5);     // Catch: Throwable -> L46
        goto L22
    L17:
        r15 = r14.getString(r4);     // Catch: Throwable -> L46
        goto L18
    L13:
        r13 = r14.getString(r3);     // Catch: Throwable -> L46
        goto L14
    L44:
        r14.close();
        r0.release();
        return r11;
    L46:
        th = move-exception;
        r14.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, pkgName);
        goto L6
    }

    @Override // com.obric.safecheck.database.dao.PkgSignDao
    public List<PkgSignItem> queryDataBeforeDate(final String targetDate) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM pkg_sign_items WHERE timestamp < ?", 1);
        if (targetDate != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r14 = DBUtil.query(this.__db, r0, false, null);
        int r3 = CursorUtil.getColumnIndexOrThrow(r14, "umd5");     // Catch: Throwable -> L46
        int r4 = CursorUtil.getColumnIndexOrThrow(r14, ApkVirusCheckProvider.KEY_PKG);     // Catch: Throwable -> L46
        int r5 = CursorUtil.getColumnIndexOrThrow(r14, "risk_level");     // Catch: Throwable -> L46
        int r6 = CursorUtil.getColumnIndexOrThrow(r14, "tmd5");     // Catch: Throwable -> L46
        int r7 = CursorUtil.getColumnIndexOrThrow(r14, "tsha1");     // Catch: Throwable -> L46
        int r8 = CursorUtil.getColumnIndexOrThrow(r14, "tsha256");     // Catch: Throwable -> L46
        int r9 = CursorUtil.getColumnIndexOrThrow(r14, "is_blacklist");     // Catch: Throwable -> L46
        int r10 = CursorUtil.getColumnIndexOrThrow(r14, "timestamp");     // Catch: Throwable -> L46
        ArrayList r11 = new ArrayList(r14.getCount());     // Catch: Throwable -> L46
    L8:
        if (r14.moveToNext() == false) goto L44;
        PkgSignItem r12 = new PkgSignItem();     // Catch: Throwable -> L46
        if (r14.isNull(r3) == false) goto L13;
        String r13 = null;
    L14:
        r12.setUmd5(r13);     // Catch: Throwable -> L46
        if (r14.isNull(r4) == false) goto L17;
        String r15 = null;
    L18:
        r12.setPkg(r15);     // Catch: Throwable -> L46
        if (r14.isNull(r5) == false) goto L21;
        String r16 = null;
    L22:
        r12.setRiskLevel(r16);     // Catch: Throwable -> L46
        if (r14.isNull(r6) == false) goto L25;
        String r17 = null;
    L26:
        r12.setTmd5(r17);     // Catch: Throwable -> L46
        if (r14.isNull(r7) == false) goto L29;
        String r18 = null;
    L30:
        r12.setTsha1(r18);     // Catch: Throwable -> L46
        if (r14.isNull(r8) == false) goto L33;
        String r19 = null;
    L34:
        r12.setTsha256(r19);     // Catch: Throwable -> L46
        if (r14.getInt(r9) == 0) goto L37;
        boolean r110 = true;
    L38:
        r12.setBlacklist(r110);     // Catch: Throwable -> L46
        if (r14.isNull(r10) == false) goto L41;
        String r111 = null;
    L42:
        r12.setTimestamp(r111);     // Catch: Throwable -> L46
        r11.add(r12);     // Catch: Throwable -> L46
        goto L8
    L41:
        r111 = r14.getString(r10);     // Catch: Throwable -> L46
        goto L42
    L37:
        r110 = false;
        goto L38
    L33:
        r19 = r14.getString(r8);     // Catch: Throwable -> L46
        goto L34
    L29:
        r18 = r14.getString(r7);     // Catch: Throwable -> L46
        goto L30
    L25:
        r17 = r14.getString(r6);     // Catch: Throwable -> L46
        goto L26
    L21:
        r16 = r14.getString(r5);     // Catch: Throwable -> L46
        goto L22
    L17:
        r15 = r14.getString(r4);     // Catch: Throwable -> L46
        goto L18
    L13:
        r13 = r14.getString(r3);     // Catch: Throwable -> L46
        goto L14
    L44:
        r14.close();
        r0.release();
        return r11;
    L46:
        th = move-exception;
        r14.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, targetDate);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
