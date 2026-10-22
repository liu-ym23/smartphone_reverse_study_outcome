package com.obric.matrix.push.m.d;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001$B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J*\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001a0\u0019j\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001a`\u001b2\u0006\u0010\u001c\u001a\u00020\tJ\u001a\u0010\u001d\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001aJ\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/obric/matrix/push/base/event/EventDataBaseHelper;", "", "()V", "BD_NAME", "", "COL_EVENT_NAME", "COL_EVENT_PARAMS", "COL_ID", "DB_VERSION", "", "EVENT_COLS", "", "getEVENT_COLS", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE_NAME", "TAG", "mDb", "Landroid/database/sqlite/SQLiteDatabase;", "whereId", "deleteEvent", "", "id", "", "getEventsBatch", "Ljava/util/HashMap;", "Lorg/json/JSONObject;", "Lkotlin/collections/HashMap;", "maxCount", "insertEvent", "eventName", "eventParamsJson", "safeCloseCursor", "", "cursor", "Landroid/database/Cursor;", "OpenHelper", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9664a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final SQLiteDatabase f9665b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f9666c = null;

    /* JADX INFO: renamed from: com.obric.matrix.push.m.d.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016¨\u0006\u0010"}, d2 = {"Lcom/obric/matrix/push/base/event/EventDataBaseHelper$OpenHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "dbName", "", "(Landroid/content/Context;Ljava/lang/String;)V", "onCreate", "", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onUpgrade", "oldVersion", "", "newVersion", "Companion", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class C0266a extends SQLiteOpenHelper {
        static {
        }

        public C0266a(Context r3, String r4) {
            super(r3, r4, null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r3) {
            o.f(r3, "db");
            r3.execSQL("CREATE TABLE event ( _id INTEGER PRIMARY KEY AUTOINCREMENT, event TEXT, params TEXT )");     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            com.obric.matrix.push.n.c.c.e("EventDataBaseHelper", "create db exception " + th, null, 4, null);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r1, int r2, int r3) {
            o.f(r1, "db");
        }
    }

    static {
        f9664a = new a();
        f9666c = new String[]{"_id", NotificationCompat.CATEGORY_EVENT, "params"};
        f9665b = new C0266a(com.bytedance.mpaas.app.a.b(), "push_events.db").getWritableDatabase();
    }

    private a() {
    }

    private final void c(Cursor r1) {
        if (r1 == null) goto L10;
        if (r1.isClosed() == true) goto L11;
        r1.close();     // Catch: Exception -> L7
        return;
    L11:
        return;
    L12:
        return;
    }

    public final synchronized boolean a(long r5) {
        monitor-enter(this);
        SQLiteDatabase r0 = f9665b;     // Catch: Throwable -> L16
        boolean r1 = false;
        if (r0 != null) goto L6;
    L13:
        com.obric.matrix.push.n.c.c.l("EventDataBaseHelper", "db not establish and open", null, 4, null);     // Catch: Throwable -> L16
        monitor-exit(this);
        return false;
    L6:
        if (r0.isOpen() == false) goto L13;
        if (r0.delete(NotificationCompat.CATEGORY_EVENT, "_id = ?", new String[]{String.valueOf(r5)}) <= 0) goto L11;
        r1 = true;
    L11:
        monitor-exit(this);
        return r1;
    L16:
        th = move-exception;
        throw th;
    }

    public final synchronized HashMap<Long, JSONObject> b(int r12) {
        monitor-enter(this);
        String r8 = "" + r12;     // Catch: Throwable -> L17
        HashMap<Long, JSONObject> r13 = new HashMap();     // Catch: Throwable -> L17
        Cursor r9 = null;
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L17
        SQLiteDatabase r0 = f9665b;     // Catch: Throwable -> L20
        o.c(r0);     // Catch: Throwable -> L20
        r9 = r0.query(NotificationCompat.CATEGORY_EVENT, f9666c, null, null, null, null, "_id ASC", r8);     // Catch: Throwable -> L20
    L6:
        if (r9.moveToNext() == false) goto L14;
        long r1 = r9.getLong(0);     // Catch: Throwable -> L20
        String r2 = r9.getString(1);     // Catch: Throwable -> L20
        String r3 = r9.getString(2);     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(r2) == true) goto L6;
        if (TextUtils.isEmpty(r3) == true) goto L6;
        r10.add("" + r1);     // Catch: Throwable -> L20
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L20
        r4.put(NotificationCompat.CATEGORY_EVENT, r2);     // Catch: Throwable -> L20
        r4.put("params", new JSONObject(r3));     // Catch: Throwable -> L20
        r13.put(Long.valueOf(r1), r4);     // Catch: Throwable -> L20
    L14:
        c(r9);     // Catch: Throwable -> L17
        monitor-exit(this);
        return r13;
    L17:
        th = move-exception;
        throw th;
    }
}
