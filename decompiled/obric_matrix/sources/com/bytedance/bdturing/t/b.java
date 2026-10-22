package com.bytedance.bdturing.t;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdturing.g;
import kotlin.f0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f3141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f3142b = null;

    static {
        f3142b = new b();
    }

    private b() {
    }

    private final SQLiteDatabase a() {
        a r0 = f3141a;     // Catch: SQLiteException -> L7
        if (r0 == null) goto L12;
        return r0.getWritableDatabase();
    L12:
        return null;
    L7:
        e = move-exception;
        g.e(e);
        return null;
    }

    private final long d(String r9, String r10) {
        monitor-enter(this);
        g.c("DbManager", "insertOrUpdate: " + r9);     // Catch: Throwable -> L23
        g.a("DbManager", "content: " + r10);     // Catch: Throwable -> L23
        ContentValues r0 = new ContentValues();     // Catch: Throwable -> L23
        r0.put("primary_key", r9);     // Catch: Throwable -> L23
        r0.put("time_stamp", Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L23
        r0.put("content", r10);     // Catch: Throwable -> L23
        SQLiteDatabase r11 = f3142b.a();     // Catch: Throwable -> L23
        long r1 = 0;
        Long r3 = null;
        if (r11 != null) goto L31;
        Long r12 = null;
    L9:
        if (r12 != null) goto L29;
    L19:
        if (r12 == null) goto L21;
        r1 = r12.longValue();     // Catch: Throwable -> L23
    L21:
        monitor-exit(this);
        return r1;
    L29:
    L16:
        r3 = r12;
    L17:
        g.b("DbManager", "insertOrUpdate fail!");     // Catch: Throwable -> L23
    L18:
        r12 = r3;
        goto L19
    L12:
        if (r12.longValue() != 0) goto L19;
        if (r11 == null) goto L18;
        r3 = Long.valueOf(r11.insert("h5_storage", null, r0));     // Catch: SQLException -> L16 Throwable -> L23
        goto L18
    L31:
        r12 = Long.valueOf(r11.update("h5_storage", r0, "primary_key=?", new String[]{r9}));     // Catch: SQLException -> L26 Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    private final String e(String r13) {
        monitor-enter(this);
        g.a("DbManager", "query");     // Catch: Throwable -> L29
        SQLiteDatabase r1 = f3142b.a();     // Catch: Throwable -> L29
        Cursor r11 = null;
        String r12 = null;
        r12 = null;
        r12 = null;
        r12 = null;
        if (r1 != null) goto L41;
        Cursor r14 = null;
    L12:
        if (r14 != null) goto L43;
    L25:
        if (r14 != null) goto L39;
    L27:
        monitor-exit(this);
        return r12;
    L39:
        r14.close();     // Catch: Throwable -> L32
        goto L27
    L43:
    L17:
        th = move-exception;
        r11 = r14;
        th = th;
    L19:
        if (r11 != null) goto L37;
    L21:
        throw th;     // Catch: Throwable -> L29
    L37:
        r11.close();     // Catch: Throwable -> L33
        goto L21
    L14:
        if (r14.moveToFirst() != true) goto L25;
        r12 = r14.getString(0);     // Catch: Throwable -> L17 Exception -> L34
    L22:
        if (r14 == null) goto L27;
    L41:
        r14 = r1.query("h5_storage", new String[]{"content"}, "primary_key=?", new String[]{r13}, null, null, null, LocationInfoConst.ALLOW_USE_LOCATION);     // Catch: Throwable -> L8 Exception -> L10
    L10:
        r14 = null;
    L8:
        th = th;
    L29:
        th = move-exception;
        throw th;
    }

    public final String b() {
        return e("settings");
    }

    public final void c(Context r2) {
        o.g(r2, "context");
        monitor-enter(this);
        f3141a = new a(r2);     // Catch: Throwable -> L7
        f0 r3 = f0.f18324a;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void f(String r2) {
        if (r2 == null) goto L5;
        d("settings", r2);
        return;
    }
}
