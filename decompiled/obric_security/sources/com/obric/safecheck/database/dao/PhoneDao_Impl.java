package com.obric.safecheck.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.obric.safecheck.database.entity.PhoneItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class PhoneDao_Impl implements PhoneDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<PhoneItem> __insertionAdapterOfPhoneItem;
    private final SharedSQLiteStatement __preparedStmtOfDeleteDataBeforeDate;

    public PhoneDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfPhoneItem = new AnonymousClass1(this, __db);
        this.__preparedStmtOfDeleteDataBeforeDate = new AnonymousClass2(this, __db);
    }

    @Override // com.obric.safecheck.database.dao.PhoneDao
    public void insert(final PhoneItem phoneItems) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfPhoneItem.insert(phoneItems);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.safecheck.database.dao.PhoneDao
    public void insertAll(final List<PhoneItem> phoneItems) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfPhoneItem.insert(phoneItems);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.safecheck.database.dao.PhoneDao
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

    @Override // com.obric.safecheck.database.dao.PhoneDao
    public PhoneItem getPhoneItemByNumber(String r8) {
        boolean r1 = true;
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM phone_items WHERE phone = ? LIMIT 1", 1);
        if (r8 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        PhoneItem r2 = null;
        String r3 = null;
        Cursor r7 = DBUtil.query(this.__db, r0, false, null);
        int r4 = CursorUtil.getColumnIndexOrThrow(r7, "phone");     // Catch: Throwable -> L25
        int r5 = CursorUtil.getColumnIndexOrThrow(r7, "timestamp");     // Catch: Throwable -> L25
        int r6 = CursorUtil.getColumnIndexOrThrow(r7, "is_blacklist");     // Catch: Throwable -> L25
        if (r7.moveToFirst() == true) goto L10;
    L23:
        r7.close();
        r0.release();
        return r2;
    L10:
        if (r7.isNull(r4) == false) goto L12;
        String r9 = null;
    L14:
        if (r7.isNull(r5) == true) goto L18;
        r3 = r7.getString(r5);     // Catch: Throwable -> L25
    L18:
        if (r7.getInt(r6) != 0) goto L21;
        r1 = false;
    L21:
        r2 = new PhoneItem(r9, r3, r1);     // Catch: Throwable -> L25
        goto L23
    L12:
        r9 = r7.getString(r4);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        r7.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, r8);
        goto L6
    }

    @Override // com.obric.safecheck.database.dao.PhoneDao
    public List<PhoneItem> getAllBlacklistedPhones() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM phone_items WHERE is_blacklist = 1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r11 = DBUtil.query(this.__db, r0, false, null);
        int r3 = CursorUtil.getColumnIndexOrThrow(r11, "phone");     // Catch: Throwable -> L22
        int r4 = CursorUtil.getColumnIndexOrThrow(r11, "timestamp");     // Catch: Throwable -> L22
        int r5 = CursorUtil.getColumnIndexOrThrow(r11, "is_blacklist");     // Catch: Throwable -> L22
        ArrayList r6 = new ArrayList(r11.getCount());     // Catch: Throwable -> L22
    L4:
        if (r11.moveToNext() == false) goto L20;
        if (r11.isNull(r3) == false) goto L9;
        String r7 = null;
    L11:
        if (r11.isNull(r4) == false) goto L13;
        String r8 = null;
    L15:
        if (r11.getInt(r5) == 0) goto L17;
        boolean r9 = true;
    L18:
        r6.add(new PhoneItem(r7, r8, r9));     // Catch: Throwable -> L22
        goto L4
    L17:
        r9 = false;
        goto L18
    L13:
        r8 = r11.getString(r4);     // Catch: Throwable -> L22
        goto L15
    L9:
        r7 = r11.getString(r3);     // Catch: Throwable -> L22
        goto L11
    L20:
        r11.close();
        r0.release();
        return r6;
    L22:
        th = move-exception;
        r11.close();
        r0.release();
        throw th;
    }

    @Override // com.obric.safecheck.database.dao.PhoneDao
    public List<PhoneItem> queryDataBeforeDate(final String targetDate) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM phone_items WHERE timestamp < ?", 1);
        if (targetDate != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r11 = DBUtil.query(this.__db, r0, false, null);
        int r3 = CursorUtil.getColumnIndexOrThrow(r11, "phone");     // Catch: Throwable -> L26
        int r4 = CursorUtil.getColumnIndexOrThrow(r11, "timestamp");     // Catch: Throwable -> L26
        int r5 = CursorUtil.getColumnIndexOrThrow(r11, "is_blacklist");     // Catch: Throwable -> L26
        ArrayList r6 = new ArrayList(r11.getCount());     // Catch: Throwable -> L26
    L8:
        if (r11.moveToNext() == false) goto L24;
        if (r11.isNull(r3) == false) goto L13;
        String r7 = null;
    L15:
        if (r11.isNull(r4) == false) goto L17;
        String r8 = null;
    L19:
        if (r11.getInt(r5) == 0) goto L21;
        boolean r9 = true;
    L22:
        r6.add(new PhoneItem(r7, r8, r9));     // Catch: Throwable -> L26
        goto L8
    L21:
        r9 = false;
        goto L22
    L17:
        r8 = r11.getString(r4);     // Catch: Throwable -> L26
        goto L19
    L13:
        r7 = r11.getString(r3);     // Catch: Throwable -> L26
        goto L15
    L24:
        r11.close();
        r0.release();
        return r6;
    L26:
        th = move-exception;
        r11.close();
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
