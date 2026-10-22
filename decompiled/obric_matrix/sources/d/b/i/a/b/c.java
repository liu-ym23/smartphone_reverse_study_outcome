package d.b.i.a.b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import androidx.annotation.Nullable;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static boolean f13830f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static boolean f13831g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static long f13832h = 5000;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final String[] f13833i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static c f13834j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static String f13835k = "SELECT count(*) FROM monitor_log WHERE aid = ?";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static String f13836l = "SELECT count(*) FROM monitor_log";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Integer> f13837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f13839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SQLiteDatabase f13840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f13841e;

    static {
        f13833i = new String[]{"_id", "data"};
    }

    private c(Context r3) {
        this.f13837a = new HashMap(2);
        this.f13838b = 0;
        this.f13841e = "INSERT INTO monitor_log(aid,type,type2,time,data) VALUES ( ?, ?, ?, ?, ?)";
        this.f13839c = r3;
        this.f13840d = a.a(r3).getWritableDatabase();
    }

    private void a(String r3, int r4) {
        if (this.f13837a.containsKey(r3) == true) goto L6;
        if (r4 <= 0) goto L6;
    L7:
        this.f13837a.put(r3, Integer.valueOf(r4));
        return;
    L6:
        r4 = Math.max(0, r4 + this.f13837a.get(r3).intValue());
        goto L7
    }

    private void b(String r2) {
        File r1 = this.f13839c.getDatabasePath(r2 + ".db");     // Catch: Exception -> L6
        if (r1.exists() == false) goto L9;
        r1.delete();     // Catch: Exception -> L6
        return;
    L9:
        return;
    }

    private void c() {
        b("psdkmon");
    }

    public static c e(Context r2) {
        if (f13834j != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f13834j != null) goto L9;
        f13834j = new c(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f13834j;
    }

    private synchronized int g() {
        monitor-enter(this);
        SQLiteDatabase r0 = this.f13840d;     // Catch: Throwable -> L20
        int r1 = -1;
        if (r0 != null) goto L6;
    L18:
        monitor-exit(this);
        return -1;
    L6:
        if (r0.isOpen() == false) goto L18;
        Cursor r2 = null;
        r2 = this.f13840d.rawQuery(f13836l, null);     // Catch: Exception -> L23 Throwable -> L13
        if (r2.moveToNext() == false) goto L12;
        r1 = r2.getInt(0);     // Catch: Exception -> L23 Throwable -> L13
    L13:
        th = move-exception;
        k(r2);     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L12:
        k(r2);     // Catch: Throwable -> L20
        monitor-exit(this);
        return r1;
    L20:
        th = move-exception;
        throw th;
    }

    private synchronized int h(String r7) {
        monitor-enter(this);
        SQLiteDatabase r0 = this.f13840d;     // Catch: Throwable -> L21
        int r1 = -1;
        if (r0 != null) goto L6;
    L19:
        monitor-exit(this);
        return -1;
    L6:
        if (r0.isOpen() == false) goto L19;
        Cursor r2 = null;
        r2 = this.f13840d.rawQuery(f13835k, new String[]{r7});     // Catch: Exception -> L24 Throwable -> L14
        if (r2.moveToNext() == false) goto L13;
        r1 = r2.getInt(0);     // Catch: Exception -> L24 Throwable -> L14
        goto L13
    L14:
        th = move-exception;
        k(r2);     // Catch: Throwable -> L21
        throw th;     // Catch: Throwable -> L21
    L13:
        k(r2);     // Catch: Throwable -> L21
        monitor-exit(this);
        return r1;
    L21:
        th = move-exception;
        throw th;
    }

    protected static void k(Cursor r1) {
        if (r1 == null) goto L10;
        if (r1.isClosed() == true) goto L11;
        r1.close();     // Catch: Exception -> L7
        return;
    L11:
        return;
    L12:
        return;
    }

    private synchronized void l() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (f13831g == true) goto L9;
        f13831g = true;     // Catch: Throwable -> L13
        if (g() < f13832h) goto L9;
        m(500);     // Catch: Throwable -> L13
    L9:
        if (f13830f == true) goto L11;
        f13830f = true;     // Catch: Throwable -> L13
        c();     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
    }

    public synchronized int d(String r4, long r5) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f13840d != null) goto L6;
    L11:
        monitor-exit(this);
        return -1;
    L6:
        if (r5 < 0) goto L11;
        int r6 = this.f13840d.delete("monitor_log", "aid = ? AND _id<= ? ", new String[]{r4, String.valueOf(r5)});     // Catch: Throwable -> L14
        a(r4, r6 * (-1));     // Catch: Throwable -> L14
        monitor-exit(this);
        return r6;
    }

    public synchronized int f(String r4) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.f13838b <= 10) goto L6;
    L9:
        int r0 = h(r4);     // Catch: Throwable -> L13
        this.f13837a.put(r4, Integer.valueOf(r0));     // Catch: Throwable -> L13
        this.f13838b = 0;     // Catch: Throwable -> L13
        int r5 = r0;
    L11:
        monitor-exit(this);
        return r5;
    L6:
        if (this.f13837a.containsKey(r4) == false) goto L9;
        r5 = this.f13837a.get(r4).intValue();     // Catch: Throwable -> L13
        this.f13838b++;     // Catch: Throwable -> L13
        goto L11
    }

    @Nullable
    public List<d.b.i.a.b.f.a> i(int r11, int r12) {
        Cursor r0 = null;
        Cursor r10 = this.f13840d.query("monitor_log", f13833i, "aid= ?", new String[]{String.valueOf(r11)}, null, null, "_id ASC ", r12 + "");     // Catch: Throwable -> L18
    L15:
        r0 = r10;
        goto L16
    L5:
        if (r10.getCount() != 0) goto L8;
        k(r10);
        return null;
    L8:
        LinkedList r13 = new LinkedList();     // Catch: Throwable -> L15
    L10:
        if (r10.moveToNext() == false) goto L13;
        r13.add(new d.b.i.a.b.f.a(r10.getLong(r10.getColumnIndex("_id")), r10.getString(r10.getColumnIndex("data"))));     // Catch: Throwable -> L15
        goto L10
    L13:
        k(r10);
        return r13;
    L16:
        k(r0);
        return Collections.emptyList();
    }

    public synchronized void j(String r7, List<d.b.i.a.b.f.a> r8) {
        monitor-enter(this);
    L38:
        th = move-exception;
        throw th;
    L4:
        if (this.f13840d != null) goto L6;
    L36:
        monitor-exit(this);
        return;
    L6:
        if (d.b.i.a.b.i.c.a(r8) == true) goto L36;
        l();     // Catch: Throwable -> L38
        this.f13840d.beginTransaction();     // Catch: Throwable -> L38
        SQLiteStatement r0 = this.f13840d.compileStatement(this.f13841e);     // Catch: Throwable -> L26 Exception -> L28
        Iterator<d.b.i.a.b.f.a> r1 = r8.iterator();     // Catch: Throwable -> L26 Exception -> L28
    L11:
        if (r1.hasNext() == false) goto L22;
        d.b.i.a.b.f.a r2 = r1.next();     // Catch: Throwable -> L26 Exception -> L28
        r0.bindString(1, String.valueOf(r2.f13850b));     // Catch: Throwable -> L26 Exception -> L28
        String r4 = r2.f13851c;     // Catch: Throwable -> L26 Exception -> L28
        if (r4 != null) goto L15;
        r4 = "";
    L15:
        r0.bindString(2, r4);     // Catch: Throwable -> L26 Exception -> L28
        String r5 = r2.f13852d;     // Catch: Throwable -> L26 Exception -> L28
        if (r5 != null) goto L18;
        r5 = "";
    L18:
        r0.bindString(3, r5);     // Catch: Throwable -> L26 Exception -> L28
        r0.bindLong(4, r2.f13854f);     // Catch: Throwable -> L26 Exception -> L28
        String r3 = r2.f13853e;     // Catch: Throwable -> L26 Exception -> L28
        if (r3 != null) goto L21;
        r3 = "";
    L21:
        r0.bindString(5, r3);     // Catch: Throwable -> L26 Exception -> L28
        r0.executeInsert();     // Catch: Throwable -> L26 Exception -> L28
        goto L11
    L22:
        this.f13840d.setTransactionSuccessful();     // Catch: Throwable -> L26 Exception -> L28
        a(r7, r8.size());     // Catch: Throwable -> L26 Exception -> L28
        SQLiteDatabase r9 = this.f13840d;     // Catch: Throwable -> L38
    L24:
        r9.endTransaction();     // Catch: Throwable -> L38
        monitor-exit(this);
        return;
    L26:
        th = move-exception;
        this.f13840d.endTransaction();     // Catch: Throwable -> L38
        throw th;     // Catch: Throwable -> L38
    L28:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L26
        r9 = this.f13840d;     // Catch: Throwable -> L38
        goto L24
    }

    public synchronized void m(long r3) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.f13840d != null) goto L6;
    L14:
        monitor-exit(this);
        return;
    L6:
        if (r3 <= 0) goto L14;
        this.f13840d.execSQL(" DELETE FROM monitor_log WHERE _id IN (SELECT _id FROM monitor_log ORDER BY _id ASC LIMIT " + r3 + ")");     // Catch: Exception -> L10 Throwable -> L16
    L12:
        monitor-exit(this);
        return;
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L16
        goto L12
    }
}
