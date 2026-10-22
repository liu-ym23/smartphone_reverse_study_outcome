package com.obric.safecheck.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.obric.safecheck.database.entity.UrlDomainItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class UrlDomainDao_Impl implements UrlDomainDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<UrlDomainItem> __insertionAdapterOfUrlDomainItem;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteDataBeforeDate;

    public UrlDomainDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfUrlDomainItem = new AnonymousClass1(this, __db);
        this.__preparedStmtOfDeleteDataBeforeDate = new AnonymousClass2(this, __db);
        this.__preparedStmtOfDeleteAll = new AnonymousClass3(this, __db);
    }

    @Override // com.obric.safecheck.database.dao.UrlDomainDao
    public void insert(final UrlDomainItem items) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfUrlDomainItem.insert(items);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.safecheck.database.dao.UrlDomainDao
    public void insertAll(final List<UrlDomainItem> items) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfUrlDomainItem.insert(items);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.safecheck.database.dao.UrlDomainDao
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

    @Override // com.obric.safecheck.database.dao.UrlDomainDao
    public void deleteAll() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteAll.acquire();
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAll.release(r0);
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAll.release(r0);
        throw th;
    }

    @Override // com.obric.safecheck.database.dao.UrlDomainDao
    public UrlDomainItem getByDomain(String r9) {
        boolean r1 = true;
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM url_domain_items WHERE domain_origin = ? LIMIT 1", 1);
        if (r9 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        UrlDomainItem r2 = null;
        String r3 = null;
        Cursor r8 = DBUtil.query(this.__db, r0, false, null);
        int r4 = CursorUtil.getColumnIndexOrThrow(r8, "domain");     // Catch: Throwable -> L29
        int r5 = CursorUtil.getColumnIndexOrThrow(r8, "domain_origin");     // Catch: Throwable -> L29
        int r6 = CursorUtil.getColumnIndexOrThrow(r8, "timestamp");     // Catch: Throwable -> L29
        int r7 = CursorUtil.getColumnIndexOrThrow(r8, "is_blacklist");     // Catch: Throwable -> L29
        if (r8.moveToFirst() == true) goto L10;
    L27:
        r8.close();
        r0.release();
        return r2;
    L10:
        if (r8.isNull(r4) == false) goto L12;
        String r10 = null;
    L14:
        if (r8.isNull(r5) == false) goto L16;
        String r11 = null;
    L18:
        if (r8.isNull(r6) == true) goto L22;
        r3 = r8.getString(r6);     // Catch: Throwable -> L29
    L22:
        if (r8.getInt(r7) != 0) goto L25;
        r1 = false;
    L25:
        r2 = new UrlDomainItem(r10, r11, r3, r1);     // Catch: Throwable -> L29
        goto L27
    L16:
        r11 = r8.getString(r5);     // Catch: Throwable -> L29
        goto L18
    L12:
        r10 = r8.getString(r4);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        r8.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, r9);
        goto L6
    }

    @Override // com.obric.safecheck.database.dao.UrlDomainDao
    public List<UrlDomainItem> getAllBlacklistedDomains() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM url_domain_items WHERE is_blacklist = 1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r13 = DBUtil.query(this.__db, r0, false, null);
        int r3 = CursorUtil.getColumnIndexOrThrow(r13, "domain");     // Catch: Throwable -> L26
        int r4 = CursorUtil.getColumnIndexOrThrow(r13, "domain_origin");     // Catch: Throwable -> L26
        int r5 = CursorUtil.getColumnIndexOrThrow(r13, "timestamp");     // Catch: Throwable -> L26
        int r6 = CursorUtil.getColumnIndexOrThrow(r13, "is_blacklist");     // Catch: Throwable -> L26
        ArrayList r7 = new ArrayList(r13.getCount());     // Catch: Throwable -> L26
    L4:
        if (r13.moveToNext() == false) goto L24;
        if (r13.isNull(r3) == false) goto L9;
        String r8 = null;
    L11:
        if (r13.isNull(r4) == false) goto L13;
        String r9 = null;
    L15:
        if (r13.isNull(r5) == false) goto L17;
        String r10 = null;
    L19:
        if (r13.getInt(r6) == 0) goto L21;
        boolean r11 = true;
    L22:
        r7.add(new UrlDomainItem(r8, r9, r10, r11));     // Catch: Throwable -> L26
        goto L4
    L21:
        r11 = false;
        goto L22
    L17:
        r10 = r13.getString(r5);     // Catch: Throwable -> L26
        goto L19
    L13:
        r9 = r13.getString(r4);     // Catch: Throwable -> L26
        goto L15
    L9:
        r8 = r13.getString(r3);     // Catch: Throwable -> L26
        goto L11
    L24:
        r13.close();
        r0.release();
        return r7;
    L26:
        th = move-exception;
        r13.close();
        r0.release();
        throw th;
    }

    @Override // com.obric.safecheck.database.dao.UrlDomainDao
    public List<UrlDomainItem> queryDataBeforeDate(final String targetDate) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM url_domain_items WHERE timestamp < ?", 1);
        if (targetDate != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r13 = DBUtil.query(this.__db, r0, false, null);
        int r3 = CursorUtil.getColumnIndexOrThrow(r13, "domain");     // Catch: Throwable -> L30
        int r4 = CursorUtil.getColumnIndexOrThrow(r13, "domain_origin");     // Catch: Throwable -> L30
        int r5 = CursorUtil.getColumnIndexOrThrow(r13, "timestamp");     // Catch: Throwable -> L30
        int r6 = CursorUtil.getColumnIndexOrThrow(r13, "is_blacklist");     // Catch: Throwable -> L30
        ArrayList r7 = new ArrayList(r13.getCount());     // Catch: Throwable -> L30
    L8:
        if (r13.moveToNext() == false) goto L28;
        if (r13.isNull(r3) == false) goto L13;
        String r8 = null;
    L15:
        if (r13.isNull(r4) == false) goto L17;
        String r9 = null;
    L19:
        if (r13.isNull(r5) == false) goto L21;
        String r10 = null;
    L23:
        if (r13.getInt(r6) == 0) goto L25;
        boolean r11 = true;
    L26:
        r7.add(new UrlDomainItem(r8, r9, r10, r11));     // Catch: Throwable -> L30
        goto L8
    L25:
        r11 = false;
        goto L26
    L21:
        r10 = r13.getString(r5);     // Catch: Throwable -> L30
        goto L23
    L17:
        r9 = r13.getString(r4);     // Catch: Throwable -> L30
        goto L19
    L13:
        r8 = r13.getString(r3);     // Catch: Throwable -> L30
        goto L15
    L28:
        r13.close();
        r0.release();
        return r7;
    L30:
        th = move-exception;
        r13.close();
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
