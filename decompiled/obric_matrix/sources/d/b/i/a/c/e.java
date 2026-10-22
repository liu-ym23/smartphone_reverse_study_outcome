package d.b.i.a.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.wschannel.WsConstants;

/* JADX INFO: loaded from: classes.dex */
class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final String[] f13927b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static e f13928c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SQLiteDatabase f13929a;

    static {
        f13927b = new String[]{"_id", "value", WsConstants.KEY_CONNECTION_TYPE, "timestamp", "retry_count", "retry_time"};
    }

    private e(Context r1) {
        if (r1 != null) goto L8;
        return;
    L8:
        this.f13929a = d.b.i.a.b.a.a(r1).getWritableDatabase();     // Catch: Throwable -> L7
        return;
    }

    static e c(Context r2) {
        if (f13928c != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f13928c != null) goto L9;
        f13928c = new e(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f13928c;
    }

    static void i(Cursor r1) {
        if (r1 == null) goto L10;
        if (r1.isClosed() == true) goto L11;
        r1.close();     // Catch: Exception -> L7
        return;
    L11:
        return;
    L12:
        return;
    }

    synchronized void a(String r5, int r6, long r7) {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L4:
        if (f() == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        long r0 = System.currentTimeMillis() - r7;     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r5) == false) goto L10;
        String r8 = "timestamp <= ? ";
        String[] r9 = {String.valueOf(r0)};     // Catch: Throwable -> L18
    L21:
        this.f13929a.delete("queue", r8, r9);     // Catch: Exception -> L14 Throwable -> L18
    L16:
        monitor-exit(this);
        return;
    L14:
        e = move-exception;
        d.f("delete expire log error:" + e);     // Catch: Throwable -> L18
        goto L16
    L10:
        String r10 = "(timestamp <= ? OR retry_count > " + r6 + ") and " + WsConstants.KEY_CONNECTION_TYPE + " = ?";     // Catch: Throwable -> L18
        String[] r11 = {String.valueOf(r0), r5};     // Catch: Throwable -> L18
        r8 = r10;
        r9 = r11;
        goto L21
    }

    synchronized long b(String r6) {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L4:
        long r1 = 0;
        if (f() == true) goto L8;
        monitor-exit(this);
        return 0;
    L8:
        Cursor r0 = null;
        String r3 = "select count(*) from queue";
        if (TextUtils.isEmpty(r6) == true) goto L12;
        r3 = "select count(*) from queue " + r6;     // Catch: Throwable -> L21
    L12:
        r0 = this.f13929a.rawQuery(r3, null);     // Catch: Throwable -> L21
        if (r0.moveToNext() == false) goto L15;
        r1 = r0.getLong(0);     // Catch: Throwable -> L21
    L15:
        i(r0);     // Catch: Throwable -> L18
        monitor-exit(this);
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v3, types: [d.b.i.a.c.b] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    synchronized b d(long r12) {
        monitor-enter(this);
    L34:
        th = move-exception;
        throw th;
    L4:
        ?? r1 = 0;
        b r2 = null;
        Cursor r3 = null;
        if (f() == true) goto L43;
        monitor-exit(this);
        return null;
    L43:
        Cursor r13 = this.f13929a.query("queue", f13927b, "_id > ?", new String[]{String.valueOf(r12)}, null, null, "_id ASC", LocationInfoConst.ALLOW_USE_LOCATION);     // Catch: Throwable -> L23 Exception -> L25
    L18:
        th = th;
        r1 = r13;
    L32:
        i(r1);     // Catch: Throwable -> L34
        throw th;     // Catch: Throwable -> L34
    L20:
        e = e;
        b r4 = null;
    L22:
        r3 = r13;
    L27:
        d.f("getLog exception " + e);     // Catch: Throwable -> L23
        i(r3);     // Catch: Throwable -> L34
        r1 = r4;
    L30:
        monitor-exit(this);
        return r1;
    L10:
        if (r13.moveToNext() == false) goto L16;
        r4 = new b();     // Catch: Throwable -> L18 Exception -> L20
        r4.f13914a = r13.getLong(0);     // Catch: Exception -> L14 Throwable -> L18
        r4.f13915b = r13.getBlob(1);     // Catch: Exception -> L14 Throwable -> L18
        r4.f13918e = r13.getString(2);     // Catch: Exception -> L14 Throwable -> L18
        r13.getLong(3);     // Catch: Exception -> L14 Throwable -> L18
        r4.f13916c = r13.getInt(4);     // Catch: Exception -> L14 Throwable -> L18
        r4.f13917d = r13.getLong(5);     // Catch: Exception -> L14 Throwable -> L18
        r2 = r4;
        goto L16
    L14:
        e = e;
    L16:
        i(r13);     // Catch: Throwable -> L34
        r1 = r2;
    L25:
        e = e;
        r4 = null;
    L23:
        th = th;
        goto L32
    }

    synchronized long e(String r4, byte[] r5) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (f() == false) goto L13;
        if (r5 == null) goto L13;
        if (r5.length <= 0) goto L13;
        ContentValues r0 = new ContentValues();     // Catch: Throwable -> L15
        r0.put("value", r5);     // Catch: Throwable -> L15
        r0.put(WsConstants.KEY_CONNECTION_TYPE, r4);     // Catch: Throwable -> L15
        r0.put("timestamp", Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L15
        r0.put("retry_count", 0);     // Catch: Throwable -> L15
        r0.put("retry_time", 0L);     // Catch: Throwable -> L15
        long r6 = this.f13929a.insert("queue", null, r0);     // Catch: Throwable -> L15
        monitor-exit(this);
        return r6;
    L13:
        monitor-exit(this);
        return -1;
    }

    synchronized boolean f() {
        monitor-enter(this);
        SQLiteDatabase r0 = this.f13929a;     // Catch: Throwable -> L13
        if (r0 != null) goto L6;
    L11:
        d.f("db not establish and open");     // Catch: Throwable -> L13
        boolean r1 = false;
    L9:
        monitor-exit(this);
        return r1;
    L6:
        if (r0.isOpen() == false) goto L11;
        r1 = true;
    L13:
        th = move-exception;
        throw th;
    }

    synchronized boolean g(long r16, boolean r18, long r19, int r21) {
        monitor-enter(this);
    L43:
        th = move-exception;
        throw th;
    L5:
        if (f() == true) goto L7;
    L41:
        monitor-exit(this);
        return false;
    L7:
        if (r16 <= 0) goto L41;
        boolean r0 = true;
        String[] r13 = {String.valueOf(r16)};     // Catch: Throwable -> L43
        if (r18 == true) goto L34;
        Cursor r14 = null;
        r14 = this.f13929a.query("queue", new String[]{"timestamp", "retry_count"}, "_id = ?", r13, null, null, null);     // Catch: Throwable -> L27 Exception -> L29
        if (r14.moveToNext() == true) goto L17;
        i(r14);     // Catch: Throwable -> L43
        monitor-exit(this);
        return false;
    L17:
        long r5 = r14.getLong(0);     // Catch: Throwable -> L27 Exception -> L29
        int r7 = r14.getInt(1);     // Catch: Throwable -> L27 Exception -> L29
        long r8 = System.currentTimeMillis();     // Catch: Throwable -> L27 Exception -> L29
        if ((r8 - r5) < r19) goto L20;
    L25:
        i(r14);     // Catch: Throwable -> L43
        goto L34
    L20:
        if (r7 >= r21) goto L25;
        ContentValues r6 = new ContentValues();     // Catch: Throwable -> L27 Exception -> L29
        r6.put("retry_count", Integer.valueOf(r7 + 1));     // Catch: Throwable -> L27 Exception -> L29
        r6.put("retry_time", Long.valueOf(r8));     // Catch: Throwable -> L27 Exception -> L29
        this.f13929a.update("queue", r6, "_id = ?", r13);     // Catch: Throwable -> L27 Exception -> L29
        i(r14);     // Catch: Throwable -> L43
        monitor-exit(this);
        return true;
    L27:
        th = move-exception;
        i(r14);     // Catch: Throwable -> L43
        throw th;     // Catch: Throwable -> L43
    L29:
        e = move-exception;
        d.f("onLogSent exception: " + e);     // Catch: Throwable -> L27
        i(r14);     // Catch: Throwable -> L43
        r0 = false;
    L34:
        if (r0 == true) goto L49;
        monitor-exit(this);
        return false;
    L49:
        this.f13929a.delete("queue", "_id = ?", r13);     // Catch: Throwable -> L46
    L36:
        d.f("delete app_log: " + r16);     // Catch: Throwable -> L43
        monitor-exit(this);
        return false;
    }

    synchronized void h() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (f() == true) goto L16;
        monitor-exit(this);
        return;
    L16:
        this.f13929a.execSQL("DROP TABLE IF EXISTS queue");     // Catch: Exception -> L9 Throwable -> L13
        this.f13929a.execSQL("CREATE TABLE queue ( _id INTEGER PRIMARY KEY AUTOINCREMENT, value BLOB, type TEXT, timestamp INTEGER, retry_count INTEGER, retry_time INTEGER )");     // Catch: Exception -> L9 Throwable -> L13
    L11:
        monitor-exit(this);
        return;
    L9:
        e = move-exception;
        d.f("recreateTableQueue db exception " + e);     // Catch: Throwable -> L13
        goto L11
    }
}
