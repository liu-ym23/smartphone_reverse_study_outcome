package com.obric.matrix.opush.d.g;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.i0.r;
import kotlin.n0.d.o;
import os.teatracker.IBdInstall;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\bÀ\u0002\u0018\u00002\u00020\u0001:\u00018B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0005J\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)J\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)2\u0006\u0010,\u001a\u00020\u001cJ\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020*J/\u00100\u001a\u0004\u0018\u00010.2\u0006\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020\u001c2\u0006\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u001cH\u0002¢\u0006\u0002\u00105J\u001d\u00106\u001a\b\u0012\u0004\u0012\u00020*0)2\b\u0010,\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0002\u00107R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/obric/matrix/opush/base/message/ReceiptDataBaseHelper;", "", "()V", "COLS", "", "", "getCOLS", "()[Ljava/lang/String;", "[Ljava/lang/String;", "COL_APP_ID", "COL_CLIENT_VER", "COL_DEVICE_MODEL", "COL_DID", "COL_ENV", "COL_ID", "COL_MSG_ID", "COL_PUSH_TOKEN", "COL_RECEIPT_CODE", "COL_RECEIPT_ID", "COL_RECEIPT_STATUS", "COL_REQ_ID", "COL_REQ_TS", "COL_SESSION_ID", "COL_TAG", "COL_TIMESTAMP", "COL_VERSION", "DB_NAME", "DB_VERSION", "", "INDEX_APP_MSG_RECEIPT_CODE", "INDEX_RECEIPT_ID", "TABLE_NAME", "TAG", "mDb", "Landroid/database/sqlite/SQLiteDatabase;", "whereAppMsgReceiptCode", "whereReceiptId", "deleteReceipt", "", "receiptId", "getReceiptList", "", "Lcom/obric/matrix/opush/base/message/ReceiptInfo;", "getReceiptListByLimit", "limit", "insertReceipt", "", LocationMonitorConst.INFO, "queryExistingReceiptId", "db", "appId", "msgId", "receiptCode", "(Landroid/database/sqlite/SQLiteDatabase;ILjava/lang/String;I)Ljava/lang/Long;", "queryReceipts", "(Ljava/lang/Integer;)Ljava/util/List;", "OpenHelper", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f9360a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final SQLiteDatabase f9361b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f9362c = null;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/obric/matrix/opush/base/message/ReceiptDataBaseHelper$OpenHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "name", "", "(Landroid/content/Context;Ljava/lang/String;)V", "createIndices", "", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onCreate", "onUpgrade", "oldVersion", "", "newVersion", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class a extends SQLiteOpenHelper {
        public a(Context r3, String r4) {
            o.f(r3, "context");
            o.f(r4, "name");
            super(r3, r4, null, 6);
        }

        private final void a(SQLiteDatabase r1) {
            r1.execSQL("CREATE INDEX IF NOT EXISTS idx_receipt_id ON pending_receipt (receipt_id)");
            r1.execSQL("CREATE INDEX IF NOT EXISTS idx_app_msg_receipt_code ON pending_receipt (app_id, msg_id, receipt_code)");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r2) {
            o.f(r2, "db");
            r2.execSQL("CREATE TABLE pending_receipt (\n    _id INTEGER PRIMARY KEY AUTOINCREMENT,\n    receipt_id TEXT,\n    msg_id TEXT,\n    app_id INTEGER,\n    version INTEGER,\n    env TEXT,\n    did TEXT,\n    session_id BIGINT,\n    receipt_code INTEGER DEFAULT 1,\n    receipt_status TEXT,\n    req_id TEXT,\n    push_token TEXT,\n    tag TEXT,\n    timestamp BIGINT DEFAULT 0,\n    req_ts BIGINT DEFAULT 0,\n    client_ver TEXT,\n    device_model TEXT\n)");
            a(r2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r4, int r5, int r6) {
            o.f(r4, "db");
            if (r5 >= 3) goto L11;
            r4.execSQL("CREATE TABLE pending_receipt_temp (\n    _id INTEGER PRIMARY KEY AUTOINCREMENT,\n    receipt_id TEXT,\n    msg_id TEXT,\n    app_id INTEGER,\n    version INTEGER,\n    env TEXT,\n    did TEXT,\n    session_id BIGINT\n)");     // Catch: Throwable -> L6
            r4.execSQL("INSERT INTO pending_receipt_temp (\n    _id, receipt_id, msg_id, app_id, \n    version, env, did, session_id\n) SELECT \n    _id, receipt_id, msg_id, app_id, \n    version, env, did, session_id \nFROM pending_receipt");     // Catch: Throwable -> L6
            r4.execSQL("DROP TABLE pending_receipt");     // Catch: Throwable -> L6
            r4.execSQL("ALTER TABLE pending_receipt_temp RENAME TO pending_receipt");     // Catch: Throwable -> L6
            r4.execSQL("CREATE INDEX IF NOT EXISTS idx_receipt_id ON pending_receipt (receipt_id)");     // Catch: Throwable -> L6
        L6:
            th = th;
            String r1 = "upgrade error";
        L8:
            com.obric.matrix.r.c.c.g("ReceiptDataBaseHelper", r1, th);
            r4.execSQL("DROP TABLE IF EXISTS pending_receipt");
            onCreate(r4);
            return;
        L11:
            if (r5 >= 4) goto L17;
            r4.execSQL("ALTER TABLE pending_receipt ADD COLUMN receipt_code INTEGER DEFAULT 1");     // Catch: Throwable -> L14
            r4.execSQL("ALTER TABLE pending_receipt ADD COLUMN receipt_status TEXT");     // Catch: Throwable -> L14
            r4.execSQL("ALTER TABLE pending_receipt ADD COLUMN req_id TEXT");     // Catch: Throwable -> L14
            r4.execSQL("ALTER TABLE pending_receipt ADD COLUMN push_token TEXT");     // Catch: Throwable -> L14
            r4.execSQL("ALTER TABLE pending_receipt ADD COLUMN tag TEXT");     // Catch: Throwable -> L14
            r4.execSQL("ALTER TABLE pending_receipt ADD COLUMN timestamp BIGINT DEFAULT 0");     // Catch: Throwable -> L14
            r4.execSQL("ALTER TABLE pending_receipt ADD COLUMN req_ts BIGINT DEFAULT 0");     // Catch: Throwable -> L14
            r4.execSQL("ALTER TABLE pending_receipt ADD COLUMN client_ver TEXT");     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            com.obric.matrix.r.c.c.g("ReceiptDataBaseHelper", "upgrade to v4 error", th);
            r4.execSQL("DROP TABLE IF EXISTS pending_receipt");
            onCreate(r4);
        L17:
            if (r5 >= 5) goto L23;
            r4.execSQL("ALTER TABLE pending_receipt ADD COLUMN device_model TEXT");     // Catch: Throwable -> L20
        L20:
            th = th;
            r1 = "upgrade to v5 error";
        L23:
            if (r5 >= 6) goto L37;
            a(r4);     // Catch: Throwable -> L26
            return;
        L26:
            th = move-exception;
            com.obric.matrix.r.c.c.g("ReceiptDataBaseHelper", "upgrade to v6 error", th);
            r4.execSQL("DROP TABLE IF EXISTS pending_receipt");
            onCreate(r4);
            return;
        }
    }

    static {
        f9360a = new h();
        f9362c = new String[]{"_id", "receipt_id", "msg_id", IBdInstall.PARAM_APP_ID, "version", "env", "did", "session_id", "receipt_code", "receipt_status", "req_id", "push_token", LocationMonitorConst.TAG, "timestamp", "req_ts", "client_ver", "device_model"};
        Context r0 = com.bytedance.mpaas.app.a.b().createDeviceProtectedStorageContext();
        o.e(r0, "context");
        SQLiteDatabase r1 = new a(r0, "o_push_receipt.db").getWritableDatabase();     // Catch: Throwable -> L5
    L7:
        f9361b = r1;
        return;
    L5:
        th = move-exception;
        com.obric.matrix.r.c.c.g("ReceiptDataBaseHelper", "open db error", th);
        r1 = null;
        goto L7
    }

    private h() {
    }

    private final Long d(SQLiteDatabase r11, int r12, String r13, int r14) {
        Long r10 = null;
        boolean r15 = true;
        Cursor r16 = r11.query("pending_receipt", new String[]{"_id"}, "app_id = ? AND msg_id = ? AND receipt_code = ?", new String[]{String.valueOf(r12), r13, String.valueOf(r14)}, null, null, "_id ASC", LocationInfoConst.ALLOW_USE_LOCATION);     // Catch: Throwable -> L15
        if (r16 != null) goto L27;
    L10:
        r15 = false;
    L11:
        if (r15 == false) goto L13;
        r10 = Long.valueOf(r16.getLong(0));     // Catch: Throwable -> L8
    L8:
        th = th;
    L25:
        com.obric.matrix.r.c.c.g("ReceiptDataBaseHelper", "query existing receipt error", th);     // Catch: Throwable -> L21
        if (r16 != null) goto L14;
    L20:
        return r10;
    L14:
        r16.close();
    L21:
        th = move-exception;
        if (r16 == null) goto L24;
        r16.close();
    L24:
        throw th;
    L13:
        if (r16 == null) goto L20;
    L27:
        if (r16.moveToFirst() != true) goto L10;
    L15:
        th = th;
        r16 = null;
        goto L25
    }

    private final List<i> e(Integer r35) {
        SQLiteDatabase r1 = f9361b;
        if (r1 != null) goto L7;
        return r.g();
    L7:
        if (r1.isOpen() == false) goto L9;
        ArrayList r10 = new ArrayList();
        Cursor r11 = null;
        String[] r3 = f9362c;     // Catch: Throwable -> L61
        if (r35 == null) goto L14;
        String r9 = r35.toString();     // Catch: Throwable -> L61
    L15:
        r11 = r1.query("pending_receipt", r3, null, null, null, null, "_id ASC", r9);     // Catch: Throwable -> L61
    L17:
        if (r11 == null) goto L21;
        if (r11.moveToNext() != true) goto L21;
        boolean r2 = true;
    L22:
        if (r2 == false) goto L59;
        long r13 = r11.getLong(0);     // Catch: Throwable -> L61
        String r15 = r11.getString(1);     // Catch: Throwable -> L61
        o.e(r15, "cursor.getString(1)");     // Catch: Throwable -> L61
        String r0 = r11.getString(2);     // Catch: Throwable -> L61
        o.e(r0, "cursor.getString(2)");     // Catch: Throwable -> L61
        int r17 = r11.getInt(3);     // Catch: Throwable -> L61
        int r18 = r11.getInt(4);     // Catch: Throwable -> L61
        String r4 = r11.getString(5);     // Catch: Throwable -> L61
        if (r4 != null) goto L27;
        String r19 = "";
    L29:
        String r5 = r11.getString(6);     // Catch: Throwable -> L61
        if (r5 != null) goto L32;
        String r20 = "";
    L33:
        long r21 = r11.getLong(7);     // Catch: Throwable -> L61
        int r23 = r11.getInt(8);     // Catch: Throwable -> L61
        String r6 = r11.getString(9);     // Catch: Throwable -> L61
        if (r6 != null) goto L36;
        String r24 = "";
    L37:
        String r7 = r11.getString(10);     // Catch: Throwable -> L61
        if (r7 != null) goto L40;
        String r25 = "";
    L41:
        String r8 = r11.getString(11);     // Catch: Throwable -> L61
        if (r8 != null) goto L44;
        String r26 = "";
    L45:
        String r12 = r11.getString(12);     // Catch: Throwable -> L61
        if (r12 != null) goto L48;
        String r27 = "";
    L49:
        long r28 = r11.getLong(13);     // Catch: Throwable -> L61
        long r30 = r11.getLong(14);     // Catch: Throwable -> L61
        String r14 = r11.getString(15);     // Catch: Throwable -> L61
        if (r14 != null) goto L52;
        String r32 = "";
    L53:
        String r16 = r11.getString(16);     // Catch: Throwable -> L61
        if (r16 != null) goto L56;
        String r33 = "";
    L57:
        r10.add(new i(r13, r15, r0, r17, r18, r19, r20, r21, r23, r24, r25, r26, r27, r28, r30, r32, r33));     // Catch: Throwable -> L61
        goto L17
    L56:
        r33 = r16;
        goto L57
    L52:
        r32 = r14;
        goto L53
    L48:
        r27 = r12;
        goto L49
    L44:
        r26 = r8;
        goto L45
    L40:
        r25 = r7;
        goto L41
    L36:
        r24 = r6;
        goto L37
    L32:
        r20 = r5;
        goto L33
    L27:
        r19 = r4;
        goto L29
    L59:
        if (r11 == null) goto L65;
    L60:
        r11.close();
    L65:
        return r10;
    L21:
        r2 = false;
        goto L22
    L14:
        r9 = null;
    L61:
        th = move-exception;
        com.obric.matrix.r.c.c.g("ReceiptDataBaseHelper", "query error", th);     // Catch: Throwable -> L66
        if (r11 == null) goto L65;
    L66:
        th = move-exception;
        if (r11 == null) goto L69;
        r11.close();
    L69:
        throw th;
    L9:
        return r.g();
    }

    public final synchronized boolean a(String r7) {
        monitor-enter(this);
        o.f(r7, "receiptId");     // Catch: Throwable -> L19
        SQLiteDatabase r0 = f9361b;     // Catch: Throwable -> L19
        boolean r1 = false;
        if (r0 != null) goto L9;
        monitor-exit(this);
        return false;
    L9:
        if (r0.isOpen() == true) goto L23;
        monitor-exit(this);
        return false;
    L23:
        if (r0.delete("pending_receipt", "receipt_id = ?", new String[]{r7}) <= 0) goto L17;
        r1 = true;
    L17:
        monitor-exit(this);
        return r1;
    L15:
        th = move-exception;
        com.obric.matrix.r.c.c.g("ReceiptDataBaseHelper", "delete error", th);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public final synchronized List<i> b() {
        monitor-enter(this);
        List<i> r0 = e(null);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized long c(i r8) {
        monitor-enter(this);
        o.f(r8, LocationMonitorConst.INFO);     // Catch: Throwable -> L23
        SQLiteDatabase r0 = f9361b;     // Catch: Throwable -> L23
        long r1 = -1;
        if (r0 != null) goto L9;
        monitor-exit(this);
        return -1;
    L9:
        if (r0.isOpen() == true) goto L27;
        monitor-exit(this);
        return -1;
    L27:
        Long r3 = d(r0, r8.a(), r8.f(), r8.h());     // Catch: Throwable -> L19
        if (r3 == null) goto L17;
        com.obric.matrix.r.c.c.j("ReceiptDataBaseHelper", "skip duplicate receipt, appId=" + r8.a() + ", msgId=" + r8.f() + ", receiptCode=" + r8.h() + ", existingId=" + r3);     // Catch: Throwable -> L19
        long r2 = r3.longValue();     // Catch: Throwable -> L19
        monitor-exit(this);
        return r2;
    L17:
        ContentValues r4 = new ContentValues();     // Catch: Throwable -> L19
        r4.put("receipt_id", r8.i());     // Catch: Throwable -> L19
        r4.put("msg_id", r8.f());     // Catch: Throwable -> L19
        r4.put(IBdInstall.PARAM_APP_ID, Integer.valueOf(r8.a()));     // Catch: Throwable -> L19
        r4.put("version", Integer.valueOf(r8.p()));     // Catch: Throwable -> L19
        r4.put("env", r8.e());     // Catch: Throwable -> L19
        r4.put("did", r8.d());     // Catch: Throwable -> L19
        r4.put("session_id", Long.valueOf(r8.m()));     // Catch: Throwable -> L19
        r4.put("receipt_code", Integer.valueOf(r8.h()));     // Catch: Throwable -> L19
        r4.put("receipt_status", r8.j());     // Catch: Throwable -> L19
        r4.put("req_id", r8.k());     // Catch: Throwable -> L19
        r4.put("push_token", r8.g());     // Catch: Throwable -> L19
        r4.put(LocationMonitorConst.TAG, r8.n());     // Catch: Throwable -> L19
        r4.put("timestamp", Long.valueOf(r8.o()));     // Catch: Throwable -> L19
        r4.put("req_ts", Long.valueOf(r8.l()));     // Catch: Throwable -> L19
        r4.put("client_ver", r8.b());     // Catch: Throwable -> L19
        r4.put("device_model", r8.c());     // Catch: Throwable -> L19
        r1 = r0.insert("pending_receipt", null, r4);     // Catch: Throwable -> L19
    L21:
        monitor-exit(this);
        return r1;
    L19:
        th = move-exception;
        com.obric.matrix.r.c.c.g("ReceiptDataBaseHelper", "insert error", th);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }
}
