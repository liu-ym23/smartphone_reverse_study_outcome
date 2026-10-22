package com.obric.safecheck.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.obric.safecheck.database.entity.GxbAntiFraudRuleItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class GxbAntiFraudRuleDao_Impl implements GxbAntiFraudRuleDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<GxbAntiFraudRuleItem> __insertionAdapterOfGxbAntiFraudRuleItem;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByRuleNo;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByRuleNoIfVersionLE;

    public GxbAntiFraudRuleDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfGxbAntiFraudRuleItem = new AnonymousClass1(this, __db);
        this.__preparedStmtOfDeleteByRuleNo = new AnonymousClass2(this, __db);
        this.__preparedStmtOfDeleteByRuleNoIfVersionLE = new AnonymousClass3(this, __db);
        this.__preparedStmtOfDeleteAll = new AnonymousClass4(this, __db);
    }

    @Override // com.obric.safecheck.database.dao.GxbAntiFraudRuleDao
    public void insert(final GxbAntiFraudRuleItem item) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfGxbAntiFraudRuleItem.insert(item);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.safecheck.database.dao.GxbAntiFraudRuleDao
    public void insertAll(final List<GxbAntiFraudRuleItem> items) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfGxbAntiFraudRuleItem.insert(items);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.safecheck.database.dao.GxbAntiFraudRuleDao
    public int deleteByRuleNo(final String ruleNo) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteByRuleNo.acquire();
        if (ruleNo != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.beginTransaction();
        int r3 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByRuleNo.release(r0);
        return r3;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByRuleNo.release(r0);
        throw th;
    L5:
        r0.bindString(1, ruleNo);
        goto L6
    }

    @Override // com.obric.safecheck.database.dao.GxbAntiFraudRuleDao
    public int deleteByRuleNoIfVersionLE(final String ruleNo, final String delVersion) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteByRuleNoIfVersionLE.acquire();
        if (ruleNo != null) goto L5;
        r0.bindNull(1);
    L7:
        if (delVersion != null) goto L9;
        r0.bindNull(2);
    L10:
        this.__db.beginTransaction();
        int r3 = r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByRuleNoIfVersionLE.release(r0);
        return r3;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByRuleNoIfVersionLE.release(r0);
        throw th;
    L9:
        r0.bindString(2, delVersion);
        goto L10
    L5:
        r0.bindString(1, ruleNo);
        goto L7
    }

    @Override // com.obric.safecheck.database.dao.GxbAntiFraudRuleDao
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

    @Override // com.obric.safecheck.database.dao.GxbAntiFraudRuleDao
    public GxbAntiFraudRuleItem getByRuleNo(String r32) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM gxb_anti_fraud_rules WHERE rule_no = ? LIMIT 1", 1);
        if (r32 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        GxbAntiFraudRuleItem r3 = null;
        String r4 = null;
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, "rule_no");     // Catch: Throwable -> L52
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "rule_id");     // Catch: Throwable -> L52
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "app_md5");     // Catch: Throwable -> L52
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "area");     // Catch: Throwable -> L52
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "area_type");     // Catch: Throwable -> L52
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "dispose_time");     // Catch: Throwable -> L52
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "packet_name");     // Catch: Throwable -> L52
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "rule_state");     // Catch: Throwable -> L52
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "rule_type");     // Catch: Throwable -> L52
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "sign_md5");     // Catch: Throwable -> L52
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "sign_sha1");     // Catch: Throwable -> L52
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, "sign_sha256");     // Catch: Throwable -> L52
        int r16 = CursorUtil.getColumnIndexOrThrow(r1, "version");     // Catch: Throwable -> L52
        if (r1.moveToFirst() == true) goto L10;
    L50:
        r1.close();
        r2.release();
        return r3;
    L10:
        if (r1.isNull(r0) == false) goto L12;
        String r17 = null;
    L13:
        long r18 = r1.getLong(r5);     // Catch: Throwable -> L52
        if (r1.isNull(r6) == false) goto L16;
        String r20 = null;
    L18:
        if (r1.isNull(r7) == false) goto L20;
        String r21 = null;
    L22:
        if (r1.isNull(r8) == false) goto L24;
        String r22 = null;
    L26:
        if (r1.isNull(r9) == false) goto L28;
        String r23 = null;
    L30:
        if (r1.isNull(r10) == false) goto L32;
        String r24 = null;
    L33:
        int r25 = r1.getInt(r11);     // Catch: Throwable -> L52
        int r26 = r1.getInt(r12);     // Catch: Throwable -> L52
        if (r1.isNull(r13) == false) goto L36;
        String r27 = null;
    L38:
        if (r1.isNull(r14) == false) goto L40;
        String r28 = null;
    L42:
        if (r1.isNull(r15) == false) goto L44;
        String r29 = null;
    L46:
        if (r1.isNull(r16) == true) goto L49;
        r4 = r1.getString(r16);     // Catch: Throwable -> L52
    L49:
        r3 = new GxbAntiFraudRuleItem(r17, r18, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r4);     // Catch: Throwable -> L52
        goto L50
    L44:
        r29 = r1.getString(r15);     // Catch: Throwable -> L52
        goto L46
    L40:
        r28 = r1.getString(r14);     // Catch: Throwable -> L52
        goto L42
    L36:
        r27 = r1.getString(r13);     // Catch: Throwable -> L52
        goto L38
    L32:
        r24 = r1.getString(r10);     // Catch: Throwable -> L52
        goto L33
    L28:
        r23 = r1.getString(r9);     // Catch: Throwable -> L52
        goto L30
    L24:
        r22 = r1.getString(r8);     // Catch: Throwable -> L52
        goto L26
    L20:
        r21 = r1.getString(r7);     // Catch: Throwable -> L52
        goto L22
    L16:
        r20 = r1.getString(r6);     // Catch: Throwable -> L52
        goto L18
    L12:
        r17 = r1.getString(r0);     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        r1.close();
        r2.release();
        throw th;
    L5:
        r2.bindString(1, r32);
        goto L6
    }

    @Override // com.obric.safecheck.database.dao.GxbAntiFraudRuleDao
    public List<GxbAntiFraudRuleItem> getByPacketName(final String packetName) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM gxb_anti_fraud_rules WHERE packet_name = ?", 1);
        if (packetName != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, "rule_no");     // Catch: Throwable -> L58
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "rule_id");     // Catch: Throwable -> L58
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "app_md5");     // Catch: Throwable -> L58
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "area");     // Catch: Throwable -> L58
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "area_type");     // Catch: Throwable -> L58
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "dispose_time");     // Catch: Throwable -> L58
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "packet_name");     // Catch: Throwable -> L58
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "rule_state");     // Catch: Throwable -> L58
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "rule_type");     // Catch: Throwable -> L58
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "sign_md5");     // Catch: Throwable -> L58
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "sign_sha1");     // Catch: Throwable -> L58
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "sign_sha256");     // Catch: Throwable -> L58
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, "version");     // Catch: Throwable -> L58
        RoomSQLiteQuery r16 = r2;
        ArrayList r3 = new ArrayList(r1.getCount());     // Catch: Throwable -> L56
    L10:
        if (r1.moveToNext() == false) goto L54;
        if (r1.isNull(r0) == false) goto L15;
        String r18 = null;
    L16:
        long r19 = r1.getLong(r4);     // Catch: Throwable -> L56
        if (r1.isNull(r5) == false) goto L19;
        String r21 = null;
    L21:
        if (r1.isNull(r6) == false) goto L23;
        String r22 = null;
    L25:
        if (r1.isNull(r7) == false) goto L27;
        String r23 = null;
    L29:
        if (r1.isNull(r8) == false) goto L31;
        String r24 = null;
    L33:
        if (r1.isNull(r9) == false) goto L35;
        String r25 = null;
    L36:
        int r26 = r1.getInt(r10);     // Catch: Throwable -> L56
        int r27 = r1.getInt(r11);     // Catch: Throwable -> L56
        if (r1.isNull(r12) == false) goto L39;
        String r28 = null;
    L41:
        if (r1.isNull(r13) == false) goto L43;
        String r29 = null;
    L45:
        if (r1.isNull(r14) == false) goto L47;
        String r30 = null;
    L49:
        if (r1.isNull(r15) == false) goto L51;
        String r31 = null;
    L52:
        r3.add(new GxbAntiFraudRuleItem(r18, r19, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31));     // Catch: Throwable -> L56
        goto L10
    L51:
        r31 = r1.getString(r15);     // Catch: Throwable -> L56
        goto L52
    L47:
        r30 = r1.getString(r14);     // Catch: Throwable -> L56
        goto L49
    L43:
        r29 = r1.getString(r13);     // Catch: Throwable -> L56
        goto L45
    L39:
        r28 = r1.getString(r12);     // Catch: Throwable -> L56
        goto L41
    L35:
        r25 = r1.getString(r9);     // Catch: Throwable -> L56
        goto L36
    L31:
        r24 = r1.getString(r8);     // Catch: Throwable -> L56
        goto L33
    L27:
        r23 = r1.getString(r7);     // Catch: Throwable -> L56
        goto L29
    L23:
        r22 = r1.getString(r6);     // Catch: Throwable -> L56
        goto L25
    L19:
        r21 = r1.getString(r5);     // Catch: Throwable -> L56
        goto L21
    L15:
        r18 = r1.getString(r0);     // Catch: Throwable -> L56
        goto L16
    L54:
        r1.close();
        r16.release();
        return r3;
    L56:
        th = th;
    L60:
        r1.close();
        r16.release();
        throw th;
    L58:
        th = th;
        r16 = r2;
        goto L60
    L5:
        r2.bindString(1, packetName);
        goto L6
    }

    @Override // com.obric.safecheck.database.dao.GxbAntiFraudRuleDao
    public List<GxbAntiFraudRuleItem> getByPacketNames(final List<String> packetNames) {
        StringBuilder r1 = StringUtil.newStringBuilder();
        r1.append("SELECT * FROM gxb_anti_fraud_rules WHERE packet_name IN (");
        int r2 = packetNames.size();
        StringUtil.appendPlaceholders(r1, r2);
        r1.append(")");
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire(r1.toString(), r2 + 0);
        Iterator<String> r4 = packetNames.iterator();
        int r5 = 1;
    L4:
        if (r4.hasNext() == false) goto L10;
        String r6 = r4.next();
        if (r6 != null) goto L8;
        r3.bindNull(r5);
    L9:
        r5 = r5 + 1;
        goto L4
    L8:
        r3.bindString(r5, r6);
        goto L9
    L10:
        this.__db.assertNotSuspendingTransaction();
        Cursor r7 = DBUtil.query(this.__db, r3, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r7, "rule_no");     // Catch: Throwable -> L62
        int r8 = CursorUtil.getColumnIndexOrThrow(r7, "rule_id");     // Catch: Throwable -> L62
        int r9 = CursorUtil.getColumnIndexOrThrow(r7, "app_md5");     // Catch: Throwable -> L62
        int r10 = CursorUtil.getColumnIndexOrThrow(r7, "area");     // Catch: Throwable -> L62
        int r11 = CursorUtil.getColumnIndexOrThrow(r7, "area_type");     // Catch: Throwable -> L62
        int r12 = CursorUtil.getColumnIndexOrThrow(r7, "dispose_time");     // Catch: Throwable -> L62
        int r13 = CursorUtil.getColumnIndexOrThrow(r7, "packet_name");     // Catch: Throwable -> L62
        int r14 = CursorUtil.getColumnIndexOrThrow(r7, "rule_state");     // Catch: Throwable -> L62
        int r15 = CursorUtil.getColumnIndexOrThrow(r7, "rule_type");     // Catch: Throwable -> L62
        int r16 = CursorUtil.getColumnIndexOrThrow(r7, "sign_md5");     // Catch: Throwable -> L62
        int r17 = CursorUtil.getColumnIndexOrThrow(r7, "sign_sha1");     // Catch: Throwable -> L62
        int r18 = CursorUtil.getColumnIndexOrThrow(r7, "sign_sha256");     // Catch: Throwable -> L62
        int r19 = CursorUtil.getColumnIndexOrThrow(r7, "version");     // Catch: Throwable -> L62
        RoomSQLiteQuery r110 = r3;
        ArrayList r20 = new ArrayList(r7.getCount());     // Catch: Throwable -> L60
    L14:
        if (r7.moveToNext() == false) goto L58;
        if (r7.isNull(r0) == false) goto L19;
        String r111 = null;
    L20:
        long r112 = r7.getLong(r8);     // Catch: Throwable -> L60
        if (r7.isNull(r9) == false) goto L23;
        String r21 = null;
    L25:
        if (r7.isNull(r10) == false) goto L27;
        String r22 = null;
    L29:
        if (r7.isNull(r11) == false) goto L31;
        String r23 = null;
    L33:
        if (r7.isNull(r12) == false) goto L35;
        String r24 = null;
    L37:
        if (r7.isNull(r13) == false) goto L39;
        String r25 = null;
    L40:
        int r26 = r7.getInt(r14);     // Catch: Throwable -> L60
        int r27 = r7.getInt(r15);     // Catch: Throwable -> L60
        if (r7.isNull(r16) == false) goto L43;
        String r28 = null;
    L45:
        if (r7.isNull(r17) == false) goto L47;
        String r29 = null;
    L49:
        if (r7.isNull(r18) == false) goto L51;
        String r30 = null;
    L53:
        if (r7.isNull(r19) == false) goto L55;
        String r31 = null;
    L56:
        r20.add(new GxbAntiFraudRuleItem(r111, r112, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31));     // Catch: Throwable -> L60
        goto L14
    L55:
        r31 = r7.getString(r19);     // Catch: Throwable -> L60
        goto L56
    L51:
        r30 = r7.getString(r18);     // Catch: Throwable -> L60
        goto L53
    L47:
        r29 = r7.getString(r17);     // Catch: Throwable -> L60
        goto L49
    L43:
        r28 = r7.getString(r16);     // Catch: Throwable -> L60
        goto L45
    L39:
        r25 = r7.getString(r13);     // Catch: Throwable -> L60
        goto L40
    L35:
        r24 = r7.getString(r12);     // Catch: Throwable -> L60
        goto L37
    L31:
        r23 = r7.getString(r11);     // Catch: Throwable -> L60
        goto L33
    L27:
        r22 = r7.getString(r10);     // Catch: Throwable -> L60
        goto L29
    L23:
        r21 = r7.getString(r9);     // Catch: Throwable -> L60
        goto L25
    L19:
        r111 = r7.getString(r0);     // Catch: Throwable -> L60
        goto L20
    L58:
        r7.close();
        r110.release();
        return r20;
    L60:
        th = th;
    L64:
        r7.close();
        r110.release();
        throw th;
    L62:
        th = th;
        r110 = r3;
        goto L64
    }

    @Override // com.obric.safecheck.database.dao.GxbAntiFraudRuleDao
    public List<GxbAntiFraudRuleItem> getAll() {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM gxb_anti_fraud_rules", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "rule_no");     // Catch: Throwable -> L54
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "rule_id");     // Catch: Throwable -> L54
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "app_md5");     // Catch: Throwable -> L54
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "area");     // Catch: Throwable -> L54
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "area_type");     // Catch: Throwable -> L54
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "dispose_time");     // Catch: Throwable -> L54
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "packet_name");     // Catch: Throwable -> L54
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "rule_state");     // Catch: Throwable -> L54
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "rule_type");     // Catch: Throwable -> L54
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "sign_md5");     // Catch: Throwable -> L54
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "sign_sha1");     // Catch: Throwable -> L54
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "sign_sha256");     // Catch: Throwable -> L54
        int r15 = CursorUtil.getColumnIndexOrThrow(r2, "version");     // Catch: Throwable -> L54
        RoomSQLiteQuery r16 = r1;
        ArrayList r3 = new ArrayList(r2.getCount());     // Catch: Throwable -> L52
    L6:
        if (r2.moveToNext() == false) goto L50;
        if (r2.isNull(r0) == false) goto L11;
        String r18 = null;
    L12:
        long r19 = r2.getLong(r4);     // Catch: Throwable -> L52
        if (r2.isNull(r5) == false) goto L15;
        String r21 = null;
    L17:
        if (r2.isNull(r6) == false) goto L19;
        String r22 = null;
    L21:
        if (r2.isNull(r7) == false) goto L23;
        String r23 = null;
    L25:
        if (r2.isNull(r8) == false) goto L27;
        String r24 = null;
    L29:
        if (r2.isNull(r9) == false) goto L31;
        String r25 = null;
    L32:
        int r26 = r2.getInt(r10);     // Catch: Throwable -> L52
        int r27 = r2.getInt(r11);     // Catch: Throwable -> L52
        if (r2.isNull(r12) == false) goto L35;
        String r28 = null;
    L37:
        if (r2.isNull(r13) == false) goto L39;
        String r29 = null;
    L41:
        if (r2.isNull(r14) == false) goto L43;
        String r30 = null;
    L45:
        if (r2.isNull(r15) == false) goto L47;
        String r31 = null;
    L48:
        r3.add(new GxbAntiFraudRuleItem(r18, r19, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31));     // Catch: Throwable -> L52
        goto L6
    L47:
        r31 = r2.getString(r15);     // Catch: Throwable -> L52
        goto L48
    L43:
        r30 = r2.getString(r14);     // Catch: Throwable -> L52
        goto L45
    L39:
        r29 = r2.getString(r13);     // Catch: Throwable -> L52
        goto L41
    L35:
        r28 = r2.getString(r12);     // Catch: Throwable -> L52
        goto L37
    L31:
        r25 = r2.getString(r9);     // Catch: Throwable -> L52
        goto L32
    L27:
        r24 = r2.getString(r8);     // Catch: Throwable -> L52
        goto L29
    L23:
        r23 = r2.getString(r7);     // Catch: Throwable -> L52
        goto L25
    L19:
        r22 = r2.getString(r6);     // Catch: Throwable -> L52
        goto L21
    L15:
        r21 = r2.getString(r5);     // Catch: Throwable -> L52
        goto L17
    L11:
        r18 = r2.getString(r0);     // Catch: Throwable -> L52
        goto L12
    L50:
        r2.close();
        r16.release();
        return r3;
    L52:
        th = th;
    L56:
        r2.close();
        r16.release();
        throw th;
    L54:
        th = th;
        r16 = r1;
        goto L56
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
