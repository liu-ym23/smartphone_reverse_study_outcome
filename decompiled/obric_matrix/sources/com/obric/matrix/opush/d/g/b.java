package com.obric.matrix.opush.d.g;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001'B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0019J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u0004J\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0 J\u0016\u0010!\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0019J\u0010\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/obric/matrix/opush/base/message/HistoryMessageDataBaseHelper;", "", "()V", "BD_NAME", "", "COL_ID", "COL_MSG_ID", "COL_TIME_STAMP", "DB_VERSION", "", "EVENT_COLS", "", "getEVENT_COLS", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE_NAME", "TAG", "mDb", "Landroid/database/sqlite/SQLiteDatabase;", "whereId", "whereMsgId", "whereTimeStampEarlier", "deleteExpiredMsg", "", "lastTimeStamp", "", "deleteMsg", "id", "getHistoryMsgWithId", "Lcom/obric/matrix/opush/base/message/HistoryMsgInfo;", "msgId", "getMsgList", "", "insertMsg", "timeStamp", "safeCloseCursor", "", "cursor", "Landroid/database/Cursor;", "OpenHelper", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f9305a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final SQLiteDatabase f9306b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f9307c = null;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016¨\u0006\u0010"}, d2 = {"Lcom/obric/matrix/opush/base/message/HistoryMessageDataBaseHelper$OpenHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "dbName", "", "(Landroid/content/Context;Ljava/lang/String;)V", "onCreate", "", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onUpgrade", "oldVersion", "", "newVersion", "Companion", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class a extends SQLiteOpenHelper {
        static {
        }

        public a(Context r3, String r4) {
            super(r3, r4, null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r7) {
            o.f(r7, "db");
            r7.execSQL("CREATE TABLE history_message ( _id INTEGER PRIMARY KEY AUTOINCREMENT, msg_id TEXT, time_stamp BIGINT )");     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            com.obric.matrix.opush.c.e(com.obric.matrix.opush.c.f9247a, "HistoryMessageDataBaseHelper", "create db exception " + th, null, 4, null);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r1, int r2, int r3) {
            o.f(r1, "db");
        }
    }

    static {
        f9305a = new b();
        f9307c = new String[]{"_id", "msg_id", "time_stamp"};
        f9306b = new a(com.bytedance.mpaas.app.a.b().createDeviceProtectedStorageContext(), "o_history_message.db").getWritableDatabase();
    }

    private b() {
    }

    public final synchronized boolean a(long r9) {
        monitor-enter(this);
        SQLiteDatabase r0 = f9306b;     // Catch: Throwable -> L16
        boolean r1 = false;
        if (r0 != null) goto L6;
    L13:
        com.obric.matrix.opush.c.j(com.obric.matrix.opush.c.f9247a, "HistoryMessageDataBaseHelper", "db not establish and open", null, 4, null);     // Catch: Throwable -> L16
        monitor-exit(this);
        return false;
    L6:
        if (r0.isOpen() == false) goto L13;
        com.obric.matrix.opush.c.f9247a.a("delete historyMsgInfo earlier than " + r9);     // Catch: Throwable -> L16
        if (r0.delete("history_message", "time_stamp <= ?", new String[]{String.valueOf(r9)}) <= 0) goto L11;
        r1 = true;
    L11:
        monitor-exit(this);
        return r1;
    L16:
        th = move-exception;
        throw th;
    }

    public final synchronized c b(String r13) {
        monitor-enter(this);
        o.f(r13, "msgId");     // Catch: Throwable -> L15
        c r0 = null;
        SQLiteDatabase r1 = f9306b;     // Catch: Throwable -> L12
        o.c(r1);     // Catch: Throwable -> L12
        Cursor r14 = r1.query("history_message", f9307c, "msg_id = ?", new String[]{r13.toString()}, null, null, null, null);     // Catch: Throwable -> L12
        if (r14.moveToNext() == false) goto L10;
        long r3 = r14.getLong(0);     // Catch: Throwable -> L18
        String r5 = r14.getString(1);     // Catch: Throwable -> L18
        long r6 = r14.getLong(2);     // Catch: Throwable -> L18
        o.e(r5, "msgId");     // Catch: Throwable -> L18
        r0 = new c(r3, r5, r6);     // Catch: Throwable -> L18
    L10:
        d(r14);     // Catch: Throwable -> L15
        monitor-exit(this);
        return r0;
    L12:
        r14 = null;
    L15:
        th = move-exception;
        throw th;
    }

    public final synchronized long c(String r7, long r8) {
        monitor-enter(this);
        o.f(r7, "msgId");     // Catch: Throwable -> L15
        SQLiteDatabase r0 = f9306b;     // Catch: Throwable -> L15
        if (r0 != null) goto L6;
    L11:
        com.obric.matrix.opush.c.j(com.obric.matrix.opush.c.f9247a, "HistoryMessageDataBaseHelper", "db not establish and open", null, 4, null);     // Catch: Throwable -> L15
        monitor-exit(this);
        return -1;
    L6:
        if (r0.isOpen() == false) goto L11;
        ContentValues r1 = new ContentValues();     // Catch: Throwable -> L15
        r1.put("msg_id", r7);     // Catch: Throwable -> L15
        r1.put("time_stamp", Long.valueOf(r8));     // Catch: Throwable -> L15
        long r9 = r0.insert("history_message", null, r1);     // Catch: Throwable -> L15
        monitor-exit(this);
        return r9;
    L15:
        th = move-exception;
        throw th;
    }

    public final void d(Cursor r1) {
        if (r1 == null) goto L10;
        if (r1.isClosed() == true) goto L11;
        r1.close();     // Catch: Exception -> L7
        return;
    L11:
        return;
    L12:
        return;
    }
}
