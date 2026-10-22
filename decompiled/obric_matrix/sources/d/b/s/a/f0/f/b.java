package d.b.s.a.f0.f;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.ss.android.i.j;
import d.b.s.a.f0.g.d;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d.b.s.a.f0.f.a f14752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SQLiteDatabase f14753b;

    static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: d.b.s.a.f0.f.b$b, reason: collision with other inner class name */
    private static class C0399b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final b f14754a = null;

        static {
            f14754a = new b(null);
        }
    }

    private b() {
        this.f14752a = new d.b.s.a.f0.f.a(j.k().e());
        this.f14753b = null;
    }

    /* synthetic */ b(a r1) {
        this();
    }

    private void a(StringBuilder r1, String r2) {
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.length() <= 0) goto L7;
        r1.append(" and ");
    L7:
        r1.append(r2);
        r1.append(" = ?");
    }

    public static b f() {
        return C0399b.f14754a;
    }

    public void b() {
        if (c() == false) goto L9;
        this.f14753b.beginTransaction();     // Catch: Exception -> L6
        return;
    L9:
        return;
    }

    public boolean c() {
        SQLiteDatabase r0 = this.f14753b;     // Catch: Exception -> L13
        if (r0 != null) goto L5;
    L7:
        d.b.s.a.f0.f.a r1 = this.f14752a;     // Catch: Exception -> L13
        if (r1 == null) goto L11;
        this.f14753b = r1.getWritableDatabase();     // Catch: Exception -> L13
        return true;
    L11:
        return false;
    L5:
        if (r0.isOpen() == false) goto L7;
        return true;
    L16:
        return false;
    }

    public boolean d() {
        if (c() == true) goto L6;
        return false;
    L6:
        if (this.f14753b.delete("login_info", "time in (select min(time) from login_info)", null) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public void e() {
        if (c() == true) goto L5;
        return;
    L5:
        if (this.f14753b.inTransaction() == false) goto L12;
        this.f14753b.endTransaction();     // Catch: Exception -> L8
        return;
    L12:
        return;
    }

    public boolean g(d.b.s.a.f0.g.c r7) {
        if (c() == true) goto L5;
        return false;
    L5:
        if (d.a(r7.i()) == true) goto L7;
        return false;
    L7:
        if (r7.c() != null) goto L9;
        return false;
    L9:
        if (r7.c().length() != 0) goto L11;
        return false;
    L11:
        if (r7.j() > 0) goto L13;
        return false;
    L13:
        if (TextUtils.isEmpty(r7.f()) == true) goto L25;
        ContentValues r0 = new ContentValues();
        r0.put("time", Long.valueOf(r7.h()));
        r0.put(WsConstants.KEY_CONNECTION_TYPE, Integer.valueOf(r7.i()));
        r0.put(LocationMonitorConst.INFO, r7.c());
        r0.put("uid", Long.valueOf(r7.j()));
        r0.put("avatar_url", r7.a());
        r0.put("screen_name", r7.f());
        r0.put("platform_avatar_url", r7.d());
        r0.put("platform_screen_name", r7.e());
        r0.put("sec_uid", r7.g());
        r0.put("ext", d.b.s.a.f0.g.b.b(r7.b()));
        if (this.f14753b.insert("login_info", null, r0) == (-1)) goto L24;
        return true;
    L24:
        return false;
    L25:
        return false;
    }

    public int h() {
        if (c() == true) goto L6;
        return -1;
    L6:
        int r1 = 0;
        Cursor r2 = null;
        Cursor r3 = this.f14753b.rawQuery("select count(*) from login_info", null);     // Catch: Throwable -> L20 Exception -> L27
        if (r3 != null) goto L30;
        r2 = r3;
    L18:
        if (r2 == null) goto L26;
    L19:
        r2.close();
    L26:
        return r1;
    L30:
        r3.moveToFirst();     // Catch: Throwable -> L14 Exception -> L16
        if (r3.getCount() <= 0) goto L12;
        r1 = r3.getInt(0);     // Catch: Throwable -> L14 Exception -> L16
    L12:
        r3.close();     // Catch: Throwable -> L14 Exception -> L16
    L16:
        r2 = r3;
    L14:
        th = th;
        r2 = r3;
    L21:
        if (r2 == null) goto L23;
        r2.close();
    L23:
        throw th;
    L20:
        th = th;
    L24:
        if (r2 == null) goto L26;
        goto L26
    }

    public d.b.s.a.f0.g.c i(int r27, Long r28, Integer r29, String r30, Long r31) {
        Cursor r4 = null;
        if (c() == true) goto L5;
        return null;
    L5:
        String[] r17 = {"time", WsConstants.KEY_CONNECTION_TYPE, LocationMonitorConst.INFO, "uid", "avatar_url", "screen_name", "platform_avatar_url", "platform_screen_name", "sec_uid", "ext"};
        StringBuilder r3 = new StringBuilder();
        if (r27 == 1) goto L59;
        if (r27 != 2) goto L9;
        r3.append("time");     // Catch: Throwable -> L54 Exception -> L56
        r3.append(" in (select min(");     // Catch: Throwable -> L54 Exception -> L56
        r3.append("time");     // Catch: Throwable -> L54 Exception -> L56
        r3.append(") from ");     // Catch: Throwable -> L54 Exception -> L56
        r3.append("login_info");     // Catch: Throwable -> L54 Exception -> L56
        r3.append(")");     // Catch: Throwable -> L54 Exception -> L56
        Cursor r0 = this.f14753b.query("login_info", r17, r3.toString(), null, null, null, null);     // Catch: Throwable -> L54 Exception -> L56
    L36:
        Cursor r1 = r0;
    L61:
        if (r1 != null) goto L84;
    L74:
        d.b.s.a.f0.g.c r2 = null;
        r4 = r1;
    L75:
        if (r4 == null) goto L80;
    L76:
        r4.close();
    L80:
        return r2;
    L84:
    L71:
        e = e;
        r2 = null;
    L73:
        r4 = r1;
    L77:
        com.bytedance.sdk.account.monitor.c.a(e);     // Catch: Throwable -> L54
        if (r4 == null) goto L80;
    L69:
        th = th;
        r4 = r1;
    L81:
        if (r4 == null) goto L83;
        r4.close();
    L83:
        throw th;
    L63:
        if (r1.getCount() <= 0) goto L74;
        r1.moveToFirst();     // Catch: Throwable -> L69 Exception -> L71
        r2 = new d.b.s.a.f0.g.c(r1.getLong(0), r1.getInt(1), r1.getString(2), r1.getLong(3), r1.getString(8), r1.getString(4), r1.getString(5), r1.getString(6), r1.getString(7), d.b.s.a.f0.g.b.a(r1.getString(9)));     // Catch: Throwable -> L69 Exception -> L71
        r1.close();     // Catch: Exception -> L67 Throwable -> L69
    L67:
        e = e;
        goto L73
    L9:
        if (r27 == 3) goto L37;
        if (r27 != 4) goto L52;
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L54 Exception -> L56
        if (r28 == null) goto L15;
        a(r3, "time");     // Catch: Throwable -> L54 Exception -> L56
        r5.add(String.valueOf(r28));     // Catch: Throwable -> L54 Exception -> L56
    L15:
        if (r29 == null) goto L17;
        a(r3, WsConstants.KEY_CONNECTION_TYPE);     // Catch: Throwable -> L54 Exception -> L56
        r5.add(String.valueOf(r29));     // Catch: Throwable -> L54 Exception -> L56
    L17:
        if (r31 != null) goto L19;
    L21:
        if (r30 != null) goto L23;
    L35:
        r0 = this.f14753b.query("login_info", r17, r3.toString(), (String[]) r5.toArray(new String[0]), null, null, "time desc", "0,1");     // Catch: Throwable -> L54 Exception -> L56
        goto L36
    L23:
        if (r30.length() == 0) goto L35;
        String[] r6 = r30.split("\\*");     // Catch: Throwable -> L54 Exception -> L56
        StringBuilder r7 = new StringBuilder();     // Catch: Throwable -> L54 Exception -> L56
        int r8 = r6.length;     // Catch: Throwable -> L54 Exception -> L56
        if (r8 == 0) goto L52;
        int r13 = 0;
    L29:
        if (r13 >= r8) goto L31;
        r7.append("%");     // Catch: Throwable -> L54 Exception -> L56
        r7.append(r6[r13]);     // Catch: Throwable -> L54 Exception -> L56
        r13 = r13 + 1;     // Catch: Throwable -> L54 Exception -> L56
        goto L29
    L31:
        r7.append("%");     // Catch: Throwable -> L54 Exception -> L56
        if (r3.length() <= 0) goto L34;
        r3.append(" and ");     // Catch: Throwable -> L54 Exception -> L56
    L34:
        r3.append(LocationMonitorConst.INFO);     // Catch: Throwable -> L54 Exception -> L56
        r3.append(" like ? ");     // Catch: Throwable -> L54 Exception -> L56
        r5.add(r7.toString());     // Catch: Throwable -> L54 Exception -> L56
        goto L35
    L19:
        if (r31.longValue() <= 0) goto L21;
        a(r3, "uid");     // Catch: Throwable -> L54 Exception -> L56
        r5.add(String.valueOf(r31));     // Catch: Throwable -> L54 Exception -> L56
    L52:
        r1 = null;
        goto L61
    L37:
        ArrayList r9 = new ArrayList();     // Catch: Throwable -> L54 Exception -> L56
        if (r28 == null) goto L40;
        a(r3, "time");     // Catch: Throwable -> L54 Exception -> L56
        r9.add(String.valueOf(r28));     // Catch: Throwable -> L54 Exception -> L56
    L40:
        if (r29 == null) goto L42;
        a(r3, WsConstants.KEY_CONNECTION_TYPE);     // Catch: Throwable -> L54 Exception -> L56
        r9.add(String.valueOf(r29));     // Catch: Throwable -> L54 Exception -> L56
    L42:
        if (r30 != null) goto L44;
    L46:
        if (r31 == null) goto L51;
        if (r31.longValue() <= 0) goto L51;
        a(r3, "uid");     // Catch: Throwable -> L54 Exception -> L56
        r9.add(String.valueOf(r31));     // Catch: Throwable -> L54 Exception -> L56
    L51:
        if (r3.length() == 0) goto L52;
        r0 = this.f14753b.query("login_info", r17, r3.toString(), (String[]) r9.toArray(new String[0]), null, null, "time desc", "0,1");     // Catch: Throwable -> L54 Exception -> L56
        goto L36
    L44:
        if (r30.length() == 0) goto L46;
        a(r3, LocationMonitorConst.INFO);     // Catch: Throwable -> L54 Exception -> L56
        r9.add(r30);     // Catch: Throwable -> L54 Exception -> L56
        goto L46
    L59:
        r3.append("time");     // Catch: Throwable -> L54 Exception -> L56
        r3.append(" in (select max(");     // Catch: Throwable -> L54 Exception -> L56
        r3.append("time");     // Catch: Throwable -> L54 Exception -> L56
        r3.append(") from ");     // Catch: Throwable -> L54 Exception -> L56
        r3.append("login_info");     // Catch: Throwable -> L54 Exception -> L56
        r3.append(")");     // Catch: Throwable -> L54 Exception -> L56
        r0 = this.f14753b.query("login_info", r17, r3.toString(), null, null, null, null);     // Catch: Throwable -> L54 Exception -> L56
    L54:
        th = th;
    L56:
        e = e;
        r2 = null;
        goto L77
    }

    public d.b.s.a.f0.g.c j(int r7, String r8, long r9) {
        return i(3, null, Integer.valueOf(r7), r8, Long.valueOf(r9));
    }

    public void k(c r2) {
        b();     // Catch: Throwable -> L4 Exception -> L9
        r2.a();     // Catch: Throwable -> L4 Exception -> L9
        l();     // Catch: Throwable -> L4 Exception -> L9
    L4:
        th = move-exception;
        e();
        r2.b();
        throw th;
    L7:
        e();
        r2.b();
    }

    public void l() {
        if (c() == true) goto L5;
        return;
    L5:
        if (this.f14753b.inTransaction() == false) goto L12;
        this.f14753b.setTransactionSuccessful();     // Catch: Exception -> L8
        return;
    L12:
        return;
    }

    public boolean m(d.b.s.a.f0.g.c r8) {
        if (c() == true) goto L5;
        return false;
    L5:
        if (d.a(r8.i()) == true) goto L7;
        return false;
    L7:
        if (r8.c() != null) goto L9;
        return false;
    L9:
        if (r8.c().length() != 0) goto L11;
        return false;
    L11:
        if (r8.j() <= 0) goto L52;
        ContentValues r0 = new ContentValues();
        if (r8.h() <= 0) goto L17;
        r0.put("time", Long.valueOf(r8.h()));
    L17:
        if (d.a(r8.i()) == false) goto L20;
        r0.put(WsConstants.KEY_CONNECTION_TYPE, Integer.valueOf(r8.i()));
    L20:
        if (TextUtils.isEmpty(r8.c()) == true) goto L23;
        r0.put(LocationMonitorConst.INFO, r8.c());
    L23:
        if (r8.j() <= 0) goto L26;
        r0.put("uid", Long.valueOf(r8.j()));
    L26:
        if (TextUtils.isEmpty(r8.a()) == true) goto L29;
        r0.put("avatar_url", r8.a());
    L29:
        if (TextUtils.isEmpty(r8.f()) == true) goto L32;
        r0.put("screen_name", r8.f());
    L32:
        if (TextUtils.isEmpty(r8.d()) == true) goto L35;
        r0.put("platform_avatar_url", r8.d());
    L35:
        if (TextUtils.isEmpty(r8.e()) == true) goto L38;
        r0.put("platform_screen_name", r8.e());
    L38:
        if (TextUtils.isEmpty(r8.g()) == true) goto L40;
        r0.put("sec_uid", r8.g());
    L40:
        String r2 = d.b.s.a.f0.g.b.b(r8.b());
        if (TextUtils.isEmpty(r2) == true) goto L44;
        r0.put("ext", r2);
    L44:
        if (this.f14753b.update("login_info", r0, "type = ? and info = ? and uid = ?", new String[]{String.valueOf(r8.i()), r8.c(), String.valueOf(r8.j())}) != 0) goto L46;
        return false;
    L46:
        return true;
    L52:
        return false;
    }

    public boolean n(String r5, String r6) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r6) == false) goto L7;
        return false;
    L7:
        if (c() == false) goto L16;
        ContentValues r0 = new ContentValues();
        r0.put("sec_uid", r6);
        if (this.f14753b.update("login_info", r0, "uid = ?", new String[]{r5}) != 0) goto L12;
        return false;
    L12:
        return true;
    L16:
        return false;
    }
}
