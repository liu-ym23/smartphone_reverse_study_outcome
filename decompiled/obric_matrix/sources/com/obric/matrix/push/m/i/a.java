package com.obric.matrix.push.m.i;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.obric.matrix.push.r.j;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.v;
import kotlin.w;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001*B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0019J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u0004J\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0 J\u0016\u0010!\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0019J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u0010\u0010'\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010)R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/obric/matrix/push/base/message/HistoryMessageDataBaseHelper;", "", "()V", "BD_NAME", "", "COL_ID", "COL_MSG_ID", "COL_TIME_STAMP", "DB_VERSION", "", "EVENT_COLS", "", "getEVENT_COLS", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE_NAME", "TAG", "mDb", "Landroid/database/sqlite/SQLiteDatabase;", "whereId", "whereMsgId", "whereTimeStampEarlier", "deleteExpiredMsg", "", "lastTimeStamp", "", "deleteMsg", "id", "getHistoryMsgWithId", "Lcom/obric/matrix/push/base/message/HistoryMsgInfo;", "msgId", "getMsgList", "", "insertMsg", "timeStamp", "migrate", "", "context", "Landroid/content/Context;", "safeCloseCursor", "cursor", "Landroid/database/Cursor;", "OpenHelper", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9696a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final SQLiteDatabase f9697b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f9698c = null;

    /* JADX INFO: renamed from: com.obric.matrix.push.m.i.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class C0271a extends q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final C0271a f9699f = null;

        static {
            f9699f = new C0271a();
        }

        C0271a() {
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            a r2 = a.f9696a;
            Application r0 = com.bytedance.mpaas.app.a.b();
            o.e(r0, "getInstance()");
            r2.d(r0);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016¨\u0006\u0010"}, d2 = {"Lcom/obric/matrix/push/base/message/HistoryMessageDataBaseHelper$OpenHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "dbName", "", "(Landroid/content/Context;Ljava/lang/String;)V", "onCreate", "", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onUpgrade", "oldVersion", "", "newVersion", "Companion", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class b extends SQLiteOpenHelper {
        static {
        }

        public b(Context r3, String r4) {
            super(r3, r4, null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r3) {
            o.f(r3, "db");
            r3.execSQL("CREATE TABLE history_message ( _id INTEGER PRIMARY KEY AUTOINCREMENT, msg_id TEXT, time_stamp BIGINT )");     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            com.obric.matrix.push.n.c.c.e("HistoryMessageDataBaseHelper", "create db exception " + th, null, 4, null);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r1, int r2, int r3) {
            o.f(r1, "db");
        }
    }

    static {
        f9696a = new a();
        f9698c = new String[]{"_id", "msg_id", "time_stamp"};
        f9697b = new b(com.bytedance.mpaas.app.a.b().createDeviceProtectedStorageContext(), "history_message.db").getWritableDatabase();
        if (com.obric.matrix.r.b.f9910a.d() == false) goto L6;
        j.f9798a.j(C0271a.f9699f);
        return;
    }

    private a() {
    }

    public final synchronized boolean a(long r7) {
        monitor-enter(this);
        SQLiteDatabase r0 = f9697b;     // Catch: Throwable -> L16
        boolean r1 = false;
        if (r0 != null) goto L6;
    L13:
        com.obric.matrix.push.n.c.c.l("HistoryMessageDataBaseHelper", "db not establish and open", null, 4, null);     // Catch: Throwable -> L16
        monitor-exit(this);
        return false;
    L6:
        if (r0.isOpen() == false) goto L13;
        com.obric.matrix.push.n.c.c.a("delete historyMsgInfo earlier than " + r7);     // Catch: Throwable -> L16
        if (r0.delete("history_message", "time_stamp <= ?", new String[]{String.valueOf(r7)}) <= 0) goto L11;
        r1 = true;
    L11:
        monitor-exit(this);
        return r1;
    L16:
        th = move-exception;
        throw th;
    }

    public final synchronized com.obric.matrix.push.m.i.b b(String r13) {
        monitor-enter(this);
        o.f(r13, "msgId");     // Catch: Throwable -> L15
        com.obric.matrix.push.m.i.b r0 = null;
        SQLiteDatabase r1 = f9697b;     // Catch: Throwable -> L12
        o.c(r1);     // Catch: Throwable -> L12
        Cursor r14 = r1.query("history_message", f9698c, "msg_id = ?", new String[]{r13.toString()}, null, null, null, null);     // Catch: Throwable -> L12
        if (r14.moveToNext() == false) goto L10;
        long r3 = r14.getLong(0);     // Catch: Throwable -> L18
        String r5 = r14.getString(1);     // Catch: Throwable -> L18
        long r6 = r14.getLong(2);     // Catch: Throwable -> L18
        o.e(r5, "msgId");     // Catch: Throwable -> L18
        r0 = new com.obric.matrix.push.m.i.b(r3, r5, r6);     // Catch: Throwable -> L18
    L10:
        e(r14);     // Catch: Throwable -> L15
        monitor-exit(this);
        return r0;
    L12:
        r14 = null;
    L15:
        th = move-exception;
        throw th;
    }

    public final synchronized long c(String r5, long r6) {
        monitor-enter(this);
        o.f(r5, "msgId");     // Catch: Throwable -> L15
        SQLiteDatabase r0 = f9697b;     // Catch: Throwable -> L15
        if (r0 != null) goto L6;
    L11:
        com.obric.matrix.push.n.c.c.l("HistoryMessageDataBaseHelper", "db not establish and open", null, 4, null);     // Catch: Throwable -> L15
        monitor-exit(this);
        return -1;
    L6:
        if (r0.isOpen() == false) goto L11;
        ContentValues r2 = new ContentValues();     // Catch: Throwable -> L15
        r2.put("msg_id", r5);     // Catch: Throwable -> L15
        r2.put("time_stamp", Long.valueOf(r6));     // Catch: Throwable -> L15
        long r7 = r0.insert("history_message", null, r2);     // Catch: Throwable -> L15
        monitor-exit(this);
        return r7;
    L15:
        th = move-exception;
        throw th;
    }

    public final synchronized void d(Context r6) {
        monitor-enter(this);
        o.f(r6, "context");     // Catch: Throwable -> L28
        v.a r0 = v.f21457g;     // Catch: Throwable -> L21
        SQLiteDatabase r1 = f9697b;     // Catch: Throwable -> L21
        if (r1 != null) goto L7;
    L18:
        com.obric.matrix.push.n.c.c.l("HistoryMessageDataBaseHelper", "dc db not establish and open", null, 4, null);     // Catch: Throwable -> L21
    L19:
        Object r7 = f0.f18324a;     // Catch: Throwable -> L21
        v.b(r7);     // Catch: Throwable -> L21
    L23:
        Throwable r8 = v.d(r7);     // Catch: Throwable -> L28
        if (r8 == null) goto L26;
        com.obric.matrix.push.n.c.c.d("HistoryMessageDataBaseHelper", "migrate data failed2", r8);     // Catch: Throwable -> L28
    L26:
        monitor-exit(this);
        return;
    L7:
        if (r1.isOpen() == false) goto L18;
        long r2 = System.currentTimeMillis();     // Catch: Throwable -> L21
        r1.execSQL("ATTACH DATABASE '" + r6.getDatabasePath("history_message") + "' AS src_db");     // Catch: Throwable -> L21
        r1.execSQL("INSERT INTO history_message(msg_id, time_stamp) SELECT s.msg_id, s.time_stamp FROM src_db.history_message s WHERE NOT EXISTS (SELECT 1 FROM history_message t WHERE t.msg_id = s.msg_id)");     // Catch: Throwable -> L12
        r1.execSQL("DELETE FROM src_db.history_message");     // Catch: Throwable -> L12
        Object r9 = f0.f18324a;     // Catch: Throwable -> L12
        v.b(r9);     // Catch: Throwable -> L12
    L14:
        Throwable r10 = v.d(r9);     // Catch: Throwable -> L21
        if (r10 == null) goto L17;
        com.obric.matrix.push.n.c.c.d("HistoryMessageDataBaseHelper", "migrate data failed", r10);     // Catch: Throwable -> L21
    L17:
        r1.execSQL("DETACH DATABASE src_db");     // Catch: Throwable -> L21
        com.obric.matrix.push.n.c.c.i("HistoryMessageDataBaseHelper", "migrate data success, cost " + (System.currentTimeMillis() - r2) + " ms");     // Catch: Throwable -> L21
        goto L19
    L12:
        th = move-exception;
        v.a r3 = v.f21457g;     // Catch: Throwable -> L21
        r9 = w.a(th);     // Catch: Throwable -> L21
        v.b(r9);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        v.a r4 = v.f21457g;     // Catch: Throwable -> L28
        r7 = w.a(th);     // Catch: Throwable -> L28
        v.b(r7);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    }

    public final void e(Cursor r1) {
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
