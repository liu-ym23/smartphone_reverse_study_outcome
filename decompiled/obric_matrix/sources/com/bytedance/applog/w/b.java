package com.bytedance.applog.w;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.location.LocationRequestCompat;
import com.bytedance.applog.util.m;
import com.bytedance.applog.util.n;
import com.bytedance.applog.util.p;
import com.bytedance.common.wschannel.WsConstants;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final HashMap<String, com.bytedance.applog.w.a> f2450d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final com.bytedance.applog.w.a[] f2451e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final C0076b[] f2452f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.applog.o.e f2453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f2454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f2455c;

    private static class a extends SQLiteOpenHelper {
        a(@Nullable Context r1, @Nullable String r2, @Nullable SQLiteDatabase.CursorFactory r3, int r4) {
            super(r1, r2, r3, r4);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r2) {
            r2.beginTransaction();     // Catch: Throwable -> L10
            Iterator<com.bytedance.applog.w.a> r1 = b.f2450d.values().iterator();     // Catch: Throwable -> L10
        L4:
            if (r1.hasNext() == false) goto L8;
            String r0 = r1.next().c();     // Catch: Throwable -> L10
            if (r0 == null) goto L4;
            r2.execSQL(r0);     // Catch: Throwable -> L10
            goto L4
        L8:
            r2.setTransactionSuccessful();     // Catch: Throwable -> L10
        L12:
            p.e(r2);
            return;
        L10:
            th = move-exception;
            n.i(th);     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            p.e(r2);
            throw th;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase r1, int r2, int r3) {
            onUpgrade(r1, r2, r3);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r3, int r4, int r5) {
            n.f("onUpgrade, " + r4 + ", " + r5, null);
            r3.beginTransaction();     // Catch: Throwable -> L9
            Iterator<com.bytedance.applog.w.a> r6 = b.f2450d.values().iterator();     // Catch: Throwable -> L9
        L5:
            if (r6.hasNext() == false) goto L7;
            r3.execSQL("DROP TABLE IF EXISTS " + r6.next().n());     // Catch: Throwable -> L9
            goto L5
        L7:
            r3.setTransactionSuccessful();     // Catch: Throwable -> L9
        L11:
            p.e(r3);
            onCreate(r3);
            return;
        L9:
            th = move-exception;
            n.c("", th);     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            p.e(r3);
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.applog.w.b$b, reason: collision with other inner class name */
    static class C0076b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f2456a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2457b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f2458c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f2459d;

        C0076b() {
        }

        static /* synthetic */ void a() {
            e();
        }

        static /* synthetic */ void b(C0076b r0, com.bytedance.applog.w.a r1, int r2) {
            r0.c(r1, r2);
        }

        private void c(com.bytedance.applog.w.a r4, int r5) {
            String r0 = r4.i();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.length() <= this.f2457b) goto L8;
            this.f2456a = r4.j();
            this.f2457b = r0.length();
        L8:
            if (r0.length() < 50000) goto L10;
            com.bytedance.applog.o.b.d(b.a(r5), com.bytedance.applog.r.b.d.H);
        L10:
            this.f2459d += r0.length();
        }

        public static void d(Throwable r6, int r7) {
            StringBuilder r0 = new StringBuilder();
            int r1 = 0;
            boolean r2 = false;
        L3:
            C0076b[] r3 = b.f2452f;
            if (r1 >= r3.length) goto L12;
            if (r3[r1] == null) goto L11;
            if (r3[r1].f2457b < 50000) goto L10;
            r2 = true;
        L10:
            r0.append(r3[r1].toString());
            r0.append(";");
        L11:
            r1 = r1 + 1;
            goto L3
        L12:
            com.bytedance.applog.o.b.d(com.bytedance.applog.r.b.a.n, com.bytedance.applog.r.b.d.q);
            if (r7 >= 995000) goto L17;
            if (r2 == true) goto L17;
            return;
        L17:
            throw new RuntimeException(r0.toString(), r6);
        }

        private static void e() {
            C0076b[] r0 = b.f2452f;
            int r1 = r0.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L5;
            C0076b r4 = r0[r3];
            r4.f2456a = "";
            r4.f2457b = 0;
            r4.f2458c = 0;
            r4.f2459d = 0;
            r3 = r3 + 1;
            goto L3
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder(this.f2458c);
            r0.append("-");
            r0.append(this.f2459d);
            r0.append("-");
            r0.append(this.f2456a);
            r0.append("-");
            r0.append(this.f2457b);
            return r0.toString();
        }
    }

    static {
        f2450d = new HashMap();
        x(new h());
        x(new f());
        x(new i());
        x(new g());
        com.bytedance.applog.w.a[] r1 = {new c(), new e(null, false, null), new d("", new JSONObject())};
        f2451e = r1;
        int r2 = r1.length;
        int r6 = 0;
    L3:
        if (r6 >= r2) goto L5;
        x(r1[r6]);
        r6 = r6 + 1;
        goto L3
    L5:
        f2452f = new C0076b[]{new C0076b(), new C0076b(), new C0076b()};
    }

    public b(com.bytedance.applog.o.e r5, String r6) {
        this.f2454b = new a(r5.r(), r6, null, 46);
        this.f2453a = r5;
    }

    private String A(int r2) {
        return "SELECT * FROM launch ORDER BY _id DESC LIMIT " + r2;
    }

    private String B(int r4, com.bytedance.applog.s.b r5) {
        StringBuilder r3 = new StringBuilder("SELECT * FROM pack");
        if (r5 == null) goto L9;
        int r0 = r5.f();
        if ((-1) != r0) goto L7;
        String r6 = " WHERE priority=" + r0 + " OR priority>" + r5.e();
    L8:
        r3.append(r6);
        goto L9
    L7:
        r6 = " WHERE priority=" + r0;
    L9:
        r3.append(" ORDER BY _id DESC LIMIT " + r4);
        return r3.toString();
    }

    private String C(String r2, boolean r3) {
        StringBuilder r1 = new StringBuilder();
        r1.append("SELECT * FROM page WHERE session_id");
        if (r3 == false) goto L5;
        String r0 = "='";
    L6:
        r1.append(r0);
        r1.append(r2);
        r1.append("' ORDER BY ");
        if (r3 == false) goto L9;
        String r4 = "session_id,";
    L10:
        r1.append(r4);
        r1.append(TypedValues.TransitionType.S_DURATION);
        r1.append(" DESC LIMIT 1000");
        return r1.toString();
    L9:
        r4 = "";
        goto L10
    L5:
        r0 = "!='";
        goto L6
    }

    private void E(com.bytedance.applog.r.b.a r4) {
        Field r3 = CursorWindow.class.getDeclaredField("sCursorWindowSize");     // Catch: Throwable -> L10
        r3.setAccessible(true);     // Catch: Throwable -> L10
        int r1 = r3.getInt(null);     // Catch: Throwable -> L10
        if (r1 > 0) goto L5;
    L8:
        com.bytedance.applog.r.b.d r5 = com.bytedance.applog.r.b.d.g0;     // Catch: Throwable -> L10
    L7:
        com.bytedance.applog.o.b.d(r4, r5);     // Catch: Throwable -> L10
        return;
    L5:
        if (r1 > 8388608) goto L8;
        r3.setInt(null, r1 * 2);     // Catch: Throwable -> L10
        r5 = com.bytedance.applog.r.b.d.f0;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        n.c("tryIncreaseCursorWindowSize", th);
    }

    static /* synthetic */ com.bytedance.applog.r.b.a a(int r0) {
        return k(r0);
    }

    private void b(HashMap<String, JSONObject> r4) {
        if (r4.isEmpty() == true) goto L15;
        Iterator<Map.Entry<String, JSONObject>> r3 = r4.entrySet().iterator();
    L6:
        if (r3.hasNext() == false) goto L21;
        Map.Entry<String, JSONObject> r5 = r3.next();
        int r0 = 0;
        JSONObject r1 = r5.getValue();
        if (r1 == null) goto L14;
        JSONArray r2 = r1.optJSONArray("item_impression");
        if (r2 == null) goto L14;
        if (r2.length() <= 0) goto L14;
        r0 = r2.length();
    L14:
        n.e("lost impression for launch: " + r5.getKey() + ", count: " + r0);
        com.bytedance.applog.o.b.f(com.bytedance.applog.r.b.a.n, com.bytedance.applog.r.b.d.O, r0);
        goto L6
    L21:
        return;
    }

    private JSONObject c(f r5, JSONObject r6) {
        if (TextUtils.equals(r5.w, this.f2453a.t().j()) == true) goto L5;
    L11:
        JSONObject r4 = new JSONObject();     // Catch: JSONException -> L8
        p.c(r4, r6);     // Catch: JSONException -> L8
        r4.put(WsConstants.KEY_APP_VERSION, r5.w);     // Catch: JSONException -> L8
        r4.put("version_code", r5.v);     // Catch: JSONException -> L8
        return r4;
    L8:
        e = move-exception;
        n.i(e);
        return r6;
    L5:
        if (r5.v != this.f2453a.t().i()) goto L11;
        return r6;
    }

    private void e(SQLiteDatabase r5, HashMap<String, JSONObject> r6, com.bytedance.applog.s.b r7) {
        if (r7 != null) goto L4;
    L6:
        f r8 = (f) f2450d.get("launch");
        if (r8 != null) goto L9;
        return;
    L9:
        Cursor r1 = null;
        r1 = r5.rawQuery(A(3), null);     // Catch: Throwable -> L22
        boolean r4 = r1.moveToLast();     // Catch: Throwable -> L22
    L11:
        if (r4 == false) goto L19;
        r8.o(r1);     // Catch: Throwable -> L22
        JSONObject r9 = new JSONObject();     // Catch: Throwable -> L22
        m.c().a(r8.f2443f, r8.f2446i, r9);     // Catch: Throwable -> L15
    L17:
        r6.put(r8.f2446i, r9);     // Catch: Throwable -> L22
        r4 = r1.moveToPrevious();     // Catch: Throwable -> L22
    L15:
        th = move-exception;
        n.i(th);     // Catch: Throwable -> L22
        goto L17
    L19:
        if (r1 == null) goto L48;
        r1.close();     // Catch: Throwable -> L27
        return;
    L48:
        return;
    L27:
        th = move-exception;
        n.i(th);
        return;
    L22:
        th = move-exception;
        n.i(th);     // Catch: Throwable -> L30
        if (r1 == null) goto L49;
        r1.close();     // Catch: Throwable -> L27
        return;
    L49:
        return;
    L30:
        th = move-exception;
        if (r1 != null) goto L37;
    L36:
        throw th;
    L37:
        r1.close();     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        n.i(th);
        goto L36
    L4:
        if (r7.f() == (-1)) goto L6;
    }

    private String f(String r3, String r4, boolean r5, long r6, com.bytedance.applog.s.b r8) {
        StringBuilder r2 = new StringBuilder("DELETE FROM " + r3 + " WHERE session_id");
        if (r5 == false) goto L5;
        String r7 = "='";
    L6:
        r2.append(r7);
        r2.append(r4 + "' AND _id<=" + r6);
        if (r8 == null) goto L14;
        int r9 = r8.f();
        if ((-1) != r9) goto L11;
        StringBuilder r10 = new StringBuilder();
        r10.append(" AND (priority=");
        r10.append(r9);
        r10.append(" OR ");
        r10.append("priority");
        r10.append(">");
        r10.append(r8.e());
        r10.append(")");
    L12:
        r2.append(r10.toString());
        goto L14
    L11:
        r10 = new StringBuilder();
        r10.append(" AND priority=");
        r10.append(r9);
    L14:
        return r2.toString();
    L5:
        r7 = "!='";
        goto L6
    }

    private String g(String r2, boolean r3) {
        StringBuilder r1 = new StringBuilder();
        r1.append("DELETE FROM page WHERE session_id");
        if (r3 == false) goto L5;
        String r4 = "='";
    L6:
        r1.append(r4);
        r1.append(r2);
        r1.append("'");
        return r1.toString();
    L5:
        r4 = "!='";
        goto L6
    }

    private String i(long r2, int r4) {
        return "UPDATE pack SET _fail=" + r4 + " WHERE _id=" + r2;
    }

    private JSONArray j(String r2, HashMap<String, JSONObject> r3, com.bytedance.applog.s.b r4) {
        JSONArray r1 = null;
        if (r4 != null) goto L5;
    L7:
        JSONObject r5 = r3.remove(r2);
        if (r5 == null) goto L15;
        JSONArray r6 = r5.optJSONArray("item_impression");
        if (r6 != null) goto L12;
    L14:
        r1 = r6;
        goto L15
    L12:
        if (r6.length() != 0) goto L14;
    L15:
        if (r1 == null) goto L20;
        if (r1.length() == 0) goto L20;
        com.bytedance.applog.o.b.f(com.bytedance.applog.r.b.a.f2334j, com.bytedance.applog.r.b.d.f2346g, r1.length());
    L20:
        if (com.bytedance.applog.util.g.c() == false) goto L23;
        if (r1 == null) goto L23;
        com.bytedance.applog.util.g.d("item_impression", r1);
    L23:
        return r1;
    L5:
        if (r4.f() == (-1)) goto L7;
        return null;
    }

    private static com.bytedance.applog.r.b.a k(int r2) {
        com.bytedance.applog.r.b.a r0 = com.bytedance.applog.r.b.a.f2332h;
        if (r2 == 0) goto L9;
        if (r2 == 2) goto L10;
        return r0;
    L10:
        return com.bytedance.applog.r.b.a.f2333i;
    L9:
        return com.bytedance.applog.r.b.a.f2331g;
    }

    private boolean l(long[] r7) {
        if (r7[0] > 0) goto L9;
        if (r7[1] > 0) goto L9;
        if (r7[2] > 0) goto L9;
        return false;
    L9:
        return true;
    }

    private boolean m(String r3, com.bytedance.applog.s.b r4, boolean r5) {
        StringBuilder r0 = new StringBuilder();
        r0.append("needLaunch, ");
        r0.append(this.f2455c);
        r0.append(", ");
        r0.append(r3);
        r0.append(", ");
        r0.append(r5);
        r0.append(", ");
        if (r4 == null) goto L5;
        Object r1 = Integer.valueOf(r4.f());
    L6:
        r0.append(r1);
        n.e(r0.toString());
        if (r4 == null) goto L15;
        int r6 = r4.f();
        if (r6 != 0) goto L11;
    L13:
        return false;
    L11:
        if ((-1) == r6) goto L15;
        if (r5 == false) goto L13;
    L15:
        if (TextUtils.equals(r3, this.f2455c) == true) goto L18;
        this.f2455c = r3;
        return true;
    L18:
        return false;
    L5:
        r1 = "null";
        goto L6
    }

    private void p(JSONObject r22, f r23, g r24, SQLiteDatabase r25, JSONArray[] r26, long[] r27, HashMap<String, JSONObject> r28, com.bytedance.applog.s.b r29, int r30) {
        long[] r15 = r27;
        com.bytedance.applog.s.b r14 = r29;
        n.e("packCurrentData, " + r23.f2446i);
        int r6 = t(0, r25, r23.f2446i, true, r26, r27, r29);
        boolean r0 = m(r23.f2446i, r14, l(r15));
        JSONArray r17 = j(r23.f2446i, r28, r14);
        if (r0 == false) goto L5;
    L9:
        if (r0 == false) goto L11;
        f r12 = r23;
    L12:
        r24.N(r22, r12, null, null, r26, r27, r17, r29, r30);
        r15 = r15;
        h(r24, true, r25, true, r29);
    L13:
        int r1 = r6;
        if (r1 >= f2451e.length) goto L23;
        com.bytedance.applog.s.b r16 = r14;
        r6 = t(r1, r25, r23.f2446i, true, r26, r27, r29);
        if (l(r15) == false) goto L22;
        if (m(r23.f2446i, r16, true) == false) goto L20;
        f r13 = r23;
    L21:
        r24.N(r22, r13, null, null, r26, r27, null, r29, r30);
        h(r24, true, r25, true, r29);
        goto L22
    L20:
        r13 = null;
    L22:
        r15 = r27;
        r14 = r29;
        goto L13
    L23:
        return;
    L11:
        r12 = null;
        goto L12
    L5:
        if (l(r15) == true) goto L9;
        if (r17 == null) goto L13;
        goto L9
    }

    private void q(JSONObject r21, f r22, g r23, h r24, i r25, SQLiteDatabase r26, JSONArray[] r27, long[] r28, HashMap<String, JSONObject> r29, com.bytedance.applog.s.b r30, int r31) {
        n.e("packHistoryData, " + r22.f2446i);
        int r19 = t(0, r26, r22.f2446i, true, r27, r28, r30);
        boolean r2 = true;
        JSONArray r0 = v(r22, true, r25, r24, r26, r30, l(r28));
        if (r0.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        r22.x = r1;
        JSONArray r16 = j(r22.f2446i, r29, r30);
        if (r22.x == true) goto L9;
        long[] r7 = r28;
        f r6 = r22;
        r23.N(r21, null, r25, r0, r27, r28, r16, r30, r31);
    L20:
        if (r2 == false) goto L22;
        h(r23, true, r26, true, r30);
    L22:
        int r3 = r19;
    L24:
        if (r3 >= f2451e.length) goto L29;
        int r8 = t(r3, r26, r6.f2446i, true, r27, r28, r30);
        if (l(r7) == false) goto L28;
        r23.N(r21, null, null, null, r27, r28, null, r30, r31);
        h(r23, true, r26, true, r30);
    L28:
        r7 = r28;
        r3 = r8;
        r6 = r22;
        goto L24
    L29:
        return;
    L9:
        if (m(r22.f2446i, r30, l(r28)) == false) goto L11;
        r7 = r28;
        r6 = r22;
        r23.N(r21, r22, null, null, r27, r28, r16, r30, r31);
        goto L20
    L11:
        r7 = r28;
        r6 = r22;
        if (l(r7) == true) goto L18;
        if (r16 != null) goto L15;
    L17:
        r2 = false;
        goto L20
    L15:
        if (r16.length() <= 0) goto L17;
    L18:
        r23.N(r21, null, null, null, r27, r28, r16, r30, r31);
        goto L20
    L5:
        r1 = false;
        goto L6
    }

    private void r(JSONObject r23, f r24, i r25, h r26, g r27, SQLiteDatabase r28, String r29, JSONArray[] r30, long[] r31, com.bytedance.applog.s.b r32, int r33) {
        n.e("packLostData, " + r29);
        r24.f2446i = r29;
        r27.f2446i = r29;
        int r21 = t(0, r28, r29, false, r30, r31, r32);
        JSONArray r0 = v(r24, false, r25, r26, r28, r32, l(r31));
        if (r0.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        r24.x = r1;
        if (l(r31) == false) goto L9;
    L12:
        boolean r2 = r24.x;
        if (r2 == true) goto L15;
        i r3 = r25;
    L16:
        if (r2 == false) goto L19;
        r0 = null;
    L19:
        r27.N(r23, null, r3, r0, r30, r31, null, r32, r33);
        h(r27, false, r28, true, r32);
    L20:
        int r4 = r21;
    L22:
        if (r4 >= f2451e.length) goto L27;
        int r6 = t(r4, r28, r29, false, r30, r31, r32);
        if (l(r31) == false) goto L26;
        r27.N(r23, null, null, null, r30, r31, null, r32, r33);
        h(r27, false, r28, true, r32);
    L26:
        r4 = r6;
        goto L22
    L27:
        return;
    L15:
        r3 = null;
        goto L16
    L9:
        if (r24.x == true) goto L20;
    L5:
        r1 = false;
        goto L6
    }

    private void s(SQLiteDatabase r13, String r14, int r15, int r16, boolean r17, JSONArray[] r18, long[] r19, com.bytedance.applog.s.b r20) {
        com.bytedance.applog.w.a r0 = f2451e[r16];
        JSONArray r8 = new JSONArray();
        Cursor r9 = null;
        long r10 = 0;
        Cursor r2 = r13.rawQuery(z(r0, r14, r17, r15, r20), null);     // Catch: Throwable -> L21
        int r3 = 0;
    L36:
        if (r2.moveToNext() == false) goto L17;
        if (r3 > 200) goto L17;
        r0.o(r2);     // Catch: Throwable -> L19
        C0076b.b(f2452f[r16], r0, r16);     // Catch: Throwable -> L19
        if (n.f2430b == false) goto L12;
        n.b("queryEvent, " + r0, null);     // Catch: Throwable -> L19
    L12:
        r8.put(r0.v());     // Catch: Throwable -> L19
        long r4 = r0.f2443f;     // Catch: Throwable -> L19
        if (r4 <= r10) goto L16;
        r10 = r4;
    L16:
        r3 = r3 + 1;
    L17:
        if (r2 == null) goto L28;
        r2.close();
    L28:
        r18[r16] = r8;
        r19[r16] = r10;
        return;
    L19:
        th = th;
        r9 = r2;
    L34:
    L30:
        th = move-exception;
        if (r9 == null) goto L33;
        r9.close();
    L33:
        throw th;
    L23:
        if ((th instanceof SQLiteBlobTooBigException) == false) goto L25;
        E(k(r16));     // Catch: Throwable -> L30
    L25:
        n.i(th);     // Catch: Throwable -> L30
        if (r9 == null) goto L28;
        r9.close();
    L21:
        th = th;
        goto L34
    }

    private int t(int r16, SQLiteDatabase r17, String r18, boolean r19, JSONArray[] r20, long[] r21, com.bytedance.applog.s.b r22) {
        C0076b.a();
        int r0 = 0;
    L4:
        if (r0 >= r16) goto L6;
        r20[r0] = null;
        r21[r0] = 0;
        r0 = r0 + 1;
        goto L4
    L6:
        int r13 = r0;
        int r14 = 200;
    L7:
        if (r14 <= 0) goto L13;
        if (r13 >= f2451e.length) goto L13;
        s(r17, r18, r14, r13, r19, r20, r21, r22);
        int r1 = r20[r13].length();
        r14 = r14 - r1;
        f2452f[r13].f2458c = r1;
        if (r14 <= 0) goto L7;
        r13 = r13 + 1;
    L13:
        int r2 = r13 + 1;
    L15:
        if (r2 >= r20.length) goto L17;
        r20[r2] = null;
        r21[r2] = 0;
        r2 = r2 + 1;
        goto L15
    L17:
        return r13;
    }

    private JSONArray v(f r18, boolean r19, i r20, h r21, SQLiteDatabase r22, com.bytedance.applog.s.b r23, boolean r24) {
        JSONArray r4 = new JSONArray();
        if (r23 == null) goto L10;
        int r5 = r23.f();
        if (r5 != 0) goto L7;
    L9:
        return r4;
    L7:
        if ((-1) == r5) goto L10;
        if (r24 == false) goto L9;
    L10:
        long r7 = 1000;
        Cursor r10 = r22.rawQuery(C(r18.f2446i, r19), null);     // Catch: Throwable -> L46
        HashMap r11 = new HashMap(8);     // Catch: Throwable -> L44
        String r14 = null;
        String r15 = null;
        long r12 = 0;
    L75:
        if (r10.moveToNext() == false) goto L40;
        r21.o(r10);     // Catch: Throwable -> L42
        if (n.f2430b == false) goto L20;
        n.b("queryPage, " + r21, null);     // Catch: Throwable -> L42
    L21:
        Integer r6 = (Integer) r11.get(r21.x);     // Catch: Throwable -> L42
        int r16 = 1;
        if (r21.E() == false) goto L23;
        if (r6 != null) goto L34;
        r21.v = 1000;     // Catch: Throwable -> L42
        r12 = r12 + 1000;     // Catch: Throwable -> L42
        r4.put(r21.v());     // Catch: Throwable -> L42
        goto L75
    L34:
        Integer r8 = Integer.valueOf(r6.intValue() - 1);     // Catch: Throwable -> L42
        if (r8.intValue() > 0) goto L36;
        r11.remove(r21.x);     // Catch: Throwable -> L42
        goto L75
    L36:
        r11.put(r21.x, r8);     // Catch: Throwable -> L42
        goto L75
    L23:
        String r9 = r21.x;     // Catch: Throwable -> L42
        if (r6 == null) goto L26;
        r16 = r6.intValue() + 1;     // Catch: Throwable -> L42
    L26:
        r11.put(r9, Integer.valueOf(r16));     // Catch: Throwable -> L42
        long r13 = r21.v;     // Catch: Throwable -> L42
        if (r13 < 1000) goto L29;
        r12 = r12 + r13;     // Catch: Throwable -> L42
    L30:
        r4.put(r21.v());     // Catch: Throwable -> L42
        if (TextUtils.isEmpty(r21.z) == true) goto L75;
        r14 = r21.z;     // Catch: Throwable -> L42
        r15 = r21.f2449l;     // Catch: Throwable -> L42
        goto L75
    L29:
        r12 = r12 + 1000;     // Catch: Throwable -> L42
        goto L30
    L20:
        n.f("queryPage, " + r21, null);     // Catch: Throwable -> L42
        goto L21
    L40:
        if (r10 == null) goto L53;
    L41:
        r10.close();
    L53:
        if (r4.length() > 0) goto L55;
    L67:
        return r4;
    L55:
        if (r12 <= 1000) goto L57;
        r7 = r12;
    L57:
        r20.v = r7;
        if (r19 == false) goto L60;
        r20.f2446i = r18.f2446i;
        long r17 = r18.f2444g;
    L61:
        r20.t(r17);
        com.bytedance.applog.o.h.b(r20, r18.f2447j);
        r20.f2449l = r18.f2449l;
        r20.w = r20.f2444g + r7;
        r20.f2445h = com.bytedance.applog.o.h.l();
        r20.x = null;
        if (TextUtils.isEmpty(r18.y) == true) goto L65;
        r20.x = r18.y;
        goto L67
    L65:
        if (TextUtils.isEmpty(r14) == true) goto L67;
        r20.x = r14;
        r20.f2449l = r15;
        goto L67
    L60:
        r20.f2446i = UUID.randomUUID().toString();
        r17 = 0;
    L42:
        th = th;
    L79:
        n.i(th);     // Catch: Throwable -> L68
        if (r10 == null) goto L53;
    L68:
        th = move-exception;
        if (r10 == null) goto L95;
        r10.close();
        throw th;
    L95:
        throw th;
    L44:
        th = th;
        r14 = null;
    L48:
        r15 = r14;
        r12 = 0;
    L46:
        th = th;
        r10 = null;
        r14 = null;
        goto L48
    }

    private void w(Throwable r1) {
        if ((r1 instanceof SQLiteException) == false) goto L6;
        com.bytedance.applog.o.b.d(com.bytedance.applog.r.b.a.o, com.bytedance.applog.r.b.d.N);
        return;
    }

    private static void x(com.bytedance.applog.w.a r2) {
        f2450d.put(r2.n(), r2);
    }

    private String z(com.bytedance.applog.w.a r3, String r4, boolean r5, int r6, com.bytedance.applog.s.b r7) {
        StringBuilder r2 = new StringBuilder("SELECT * FROM " + r3.n() + " WHERE session_id");
        if (r5 == false) goto L5;
        String r8 = "='";
    L6:
        r2.append(r8);
        r2.append(r4);
        if (r7 == null) goto L13;
        int r9 = r7.f();
        if ((-1) != r9) goto L11;
        StringBuilder r10 = new StringBuilder();
        r10.append("' AND (priority=");
        r10.append(r9);
        r10.append(" OR ");
        r10.append("priority");
        r10.append(">");
        r10.append(r7.e());
        r10.append(")");
    L12:
        String r11 = r10.toString();
    L14:
        r2.append(r11);
        r2.append(" ORDER BY _id LIMIT " + r6);
        return r2.toString();
    L11:
        r10 = new StringBuilder();
        r10.append("' AND priority=");
        r10.append(r9);
        goto L12
    L13:
        r11 = "'";
        goto L14
    L5:
        r8 = "!='";
        goto L6
    }

    public void D(ArrayList<g> r10, ArrayList<g> r11) {
        SQLiteDatabase r1 = null;
        n.f("setResult, " + r10 + ", " + r11, null);
        Iterator<g> r0 = r11.iterator();
        ArrayList r2 = new ArrayList();
    L4:
        if (r0.hasNext() == false) goto L8;
        g r3 = r0.next();
        if (Math.abs(System.currentTimeMillis() - r3.f2444g) <= 1209600000) goto L4;
        r10.add(r3);
        r2.add(r3);
        r0.remove();
        goto L4
    L8:
        com.bytedance.applog.o.b.h(r2, com.bytedance.applog.r.b.d.L);
        Iterator r4 = r2.iterator();
    L10:
        if (r4.hasNext() == false) goto L36;
        g.M(com.bytedance.applog.r.b.a.C, (g) r4.next());
        goto L10
    L36:
        SQLiteDatabase r5 = this.f2454b.getWritableDatabase();     // Catch: Throwable -> L27
        r5.beginTransaction();     // Catch: Throwable -> L25
        Iterator<g> r12 = r10.iterator();     // Catch: Throwable -> L25
    L15:
        if (r12.hasNext() == false) goto L19;
        g r6 = r12.next();     // Catch: Throwable -> L25
        int r7 = r5.delete("pack", "_id = ?", new String[]{String.valueOf(r6.f2443f)});     // Catch: Throwable -> L25
        if (r7 > 0) goto L15;
        com.bytedance.applog.o.b.g(r6, com.bytedance.applog.r.b.d.m);     // Catch: Throwable -> L25
        n.c("delete from db failed, pack: " + r6 + ", rows: " + r7, null);     // Catch: Throwable -> L25
        goto L15
    L19:
        Iterator<g> r13 = r11.iterator();     // Catch: Throwable -> L25
    L21:
        if (r13.hasNext() == false) goto L23;
        g r14 = r13.next();     // Catch: Throwable -> L25
        long r8 = r14.f2443f;     // Catch: Throwable -> L25
        int r9 = r14.w + 1;     // Catch: Throwable -> L25
        r14.w = r9;     // Catch: Throwable -> L25
        r5.execSQL(i(r8, r9));     // Catch: Throwable -> L25
        goto L21
    L23:
        r5.setTransactionSuccessful();     // Catch: Throwable -> L25
        p.e(r5);
        return;
    L25:
        th = th;
        r1 = r5;
    L38:
        w(th);     // Catch: Throwable -> L31
        n.i(th);     // Catch: Throwable -> L31
        p.e(r1);
        return;
    L31:
        th = move-exception;
        p.e(r1);
        throw th;
    L27:
        th = th;
        goto L38
    }

    public void F(long r6, ContentValues r8) {
        if (r6 < 0) goto L13;
        if (r8 == null) goto L14;
        this.f2454b.getWritableDatabase().update("pack", r8, "_id = ?", new String[]{String.valueOf(r6)});     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        w(th);
        n.i(th);
        return;
    L14:
        return;
    }

    public void d() {
        SQLiteDatabase r4 = this.f2454b.getWritableDatabase();     // Catch: Throwable -> L12
        r4.beginTransaction();     // Catch: Throwable -> L10
        Iterator<com.bytedance.applog.w.a> r1 = f2450d.values().iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L8;
        r4.delete(r1.next().n(), null, null);     // Catch: Throwable -> L10
        goto L6
    L8:
        r4.setTransactionSuccessful();     // Catch: Throwable -> L10
    L15:
        p.e(r4);
        return;
    L10:
        Throwable th = th;
    L20:
        n.i(th);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        p.e(r4);
        throw th;
    L12:
        th = move-exception;
        th = th;
        r4 = null;
        goto L20
    }

    public void h(g r16, boolean r17, SQLiteDatabase r18, boolean r19, com.bytedance.applog.s.b r20) {
        boolean r2 = false;
        if (r18 == null) goto L64;
        SQLiteDatabase r9 = r18;
        boolean r10 = false;
    L9:
        if (r10 == false) goto L14;
        r9.beginTransaction();     // Catch: Throwable -> L11
    L11:
        th = th;
        r2 = r10;
    L66:
        w(th);     // Catch: Throwable -> L60
        n.i(th);     // Catch: Throwable -> L60
        if (r2 == false) goto L71;
    L58:
        p.e(r9);
        return;
    L71:
        return;
    L60:
        th = move-exception;
        if (r2 == false) goto L63;
        p.e(r9);
    L63:
        throw th;
    L14:
        if (r19 == false) goto L43;
        com.bytedance.applog.r.b.a r3 = com.bytedance.applog.r.b.a.n;     // Catch: Throwable -> L11
        com.bytedance.applog.o.b.d(r3, com.bytedance.applog.r.b.d.f2346g);     // Catch: Throwable -> L11
        long r5 = r9.insert("pack", null, r16.w(null));     // Catch: Throwable -> L11
        if (r5 >= 0) goto L35;
        if (r16.C == null) goto L23;
        m(null, r20, true);     // Catch: Throwable -> L11
        if (r16.C.x == true) goto L23;
        com.bytedance.applog.o.b.d(com.bytedance.applog.r.b.a.f2335k, com.bytedance.applog.r.b.d.f2351l);     // Catch: Throwable -> L11
    L23:
        if (r16.E == null) goto L29;
        JSONArray r1 = r16.D;     // Catch: Throwable -> L11
        if (r1 == null) goto L29;
        if (r1.length() <= 0) goto L29;
        com.bytedance.applog.o.b.d(com.bytedance.applog.r.b.a.f2336l, com.bytedance.applog.r.b.d.f2351l);     // Catch: Throwable -> L11
    L29:
        com.bytedance.applog.o.b.d(r3, com.bytedance.applog.r.b.d.f2351l);     // Catch: Throwable -> L11
        g.M(com.bytedance.applog.r.b.a.w, r16);     // Catch: Throwable -> L11
        n.c("insert to db failed, pack: " + r16 + ", result: " + r5, null);     // Catch: Throwable -> L11
        if (r10 == false) goto L69;
        p.e(r9);
        return;
    L69:
        return;
    L35:
        if (r16.E == null) goto L43;
        JSONArray r4 = r16.D;     // Catch: Throwable -> L11
        if (r4 == null) goto L43;
        if (r4.length() <= 0) goto L43;
        r9.execSQL(g(r16.f2446i, r17));     // Catch: Throwable -> L11
    L43:
        long r6 = r16.z;     // Catch: Throwable -> L11
        if (r6 <= 0) goto L46;
        r9.execSQL(f(NotificationCompat.CATEGORY_EVENT, r16.f2446i, r17, r6, r20));     // Catch: Throwable -> L11
    L46:
        long r7 = r16.B;     // Catch: Throwable -> L11
        if (r7 <= 0) goto L49;
        r9.execSQL(f("eventv3", r16.f2446i, r17, r7, r20));     // Catch: Throwable -> L11
    L49:
        long r8 = r16.H;     // Catch: Throwable -> L11
        if (r8 <= 0) goto L52;
        r9.execSQL(f("event_misc", r16.f2446i, r17, r8, r20));     // Catch: Throwable -> L11
    L52:
        if (r10 == false) goto L54;
        r9.setTransactionSuccessful();     // Catch: Throwable -> L11
    L54:
        if (r10 == true) goto L58;
        return;
    L64:
        r10 = true;
        r9 = this.f2454b.getWritableDatabase();     // Catch: Throwable -> L6
    L6:
        th = th;
        r9 = r18;
        goto L66
    }

    public void n(ArrayList<com.bytedance.applog.w.a> r10) {
        Iterator<com.bytedance.applog.w.a> r9 = r10.iterator();     // Catch: Throwable -> L16
    L3:
        if (r9.hasNext() == false) goto L29;
        com.bytedance.applog.w.a r11 = r9.next();     // Catch: Throwable -> L16
        if (NotificationCompat.CATEGORY_EVENT.equals(r11.n()) == true) goto L7;
        if ("eventv3".equals(r11.n()) == false) goto L3;
        e r12 = (e) r11;     // Catch: Throwable -> L16
        com.bytedance.applog.util.f r0 = com.bytedance.applog.util.f.b();     // Catch: Throwable -> L16
        String r1 = r12.x;     // Catch: Throwable -> L16
        if (r12.v == null) goto L13;
        JSONObject r2 = new JSONObject(r12.v);     // Catch: Throwable -> L16
    L14:
        r0.onEventV3(r1, r2);     // Catch: Throwable -> L16
        goto L3
    L13:
        r2 = null;
        goto L14
    L7:
        c r13 = (c) r11;     // Catch: Throwable -> L16
        com.bytedance.applog.util.f.b().a(r13.v, r13.w, r13.x, r13.z, r13.A, r13.y);     // Catch: Throwable -> L16
        goto L3
    L29:
        return;
    L16:
        th = move-exception;
        n.i(th);
    }

    public synchronized void o(JSONObject r34, com.bytedance.applog.s.b r35, int r36) {
        monitor-enter(this);
        HashMap<String, com.bytedance.applog.w.a> r0 = f2450d;     // Catch: Throwable -> L97
        f r14 = (f) r0.get("launch");     // Catch: Throwable -> L97
        i r15 = (i) r0.get("terminate");     // Catch: Throwable -> L97
        h r16 = (h) r0.get("page");     // Catch: Throwable -> L97
        g r1 = (g) r0.get("pack");     // Catch: Throwable -> L97
        Cursor r2 = null;
        JSONArray[] r12 = new JSONArray[3];     // Catch: Throwable -> L75
        long[] r11 = new long[3];     // Catch: Throwable -> L75
        HashMap<String, JSONObject> r10 = new HashMap();     // Catch: Throwable -> L75
        n.e("DbStore pack before collect impression.");     // Catch: Throwable -> L75
        SQLiteDatabase r9 = this.f2454b.getWritableDatabase();     // Catch: Throwable -> L75
        e(r9, r10, r35);     // Catch: Throwable -> L73
        n.e("DbStore pack after collect impression.");     // Catch: Throwable -> L73
        r9.beginTransaction();     // Catch: Throwable -> L73
        Cursor r6 = r9.rawQuery(A(5), null);     // Catch: Throwable -> L73
        com.bytedance.applog.o.h r3 = this.f2453a.x();     // Catch: Throwable -> L70
        String r5 = r3.d();     // Catch: Throwable -> L70
        boolean r17 = r3.i();     // Catch: Throwable -> L70
        boolean r4 = r6.moveToLast();     // Catch: Throwable -> L70
        JSONObject r7 = r34;
        long r24 = Long.MIN_VALUE;
        long r22 = Long.MAX_VALUE;
    L11:
        boolean r8 = true;
        if (r4 == false) goto L35;
        r14.o(r6);     // Catch: Throwable -> L32
        r1.f2446i = r14.f2446i;     // Catch: Throwable -> L32
        JSONObject r26 = c(r14, r34);     // Catch: Throwable -> L32
        if (TextUtils.equals(r14.f2446i, r5) == false) goto L21;
        if (r17 == false) goto L18;
        r8 = false;
    L18:
        r14.x = r8;     // Catch: Throwable -> L32
        Cursor r28 = r6;
        SQLiteDatabase r29 = r9;
        HashMap<String, JSONObject> r30 = r10;
        p(r26, r14, r1, r9, r12, r11, r10, r35, r36);     // Catch: Throwable -> L30
    L28:
        r4 = r28.moveToPrevious();     // Catch: Throwable -> L30
        r7 = r26;
        r5 = r5;
        r6 = r28;
        r9 = r29;
        r10 = r30;
        r11 = r11;
        r12 = r12;
    L30:
        th = th;
    L34:
        r2 = r28;
        SQLiteDatabase r18 = r29;
    L123:
        w(th);     // Catch: Throwable -> L87
        n.i(th);     // Catch: Throwable -> L87
        if (r2 != null) goto L113;
    L62:
        p.e(r18);     // Catch: Throwable -> L97
        monitor-exit(this);
        return;
    L113:
        r2.close();     // Catch: Throwable -> L81
    L81:
        th = move-exception;
        n.i(th);     // Catch: Throwable -> L97
        goto L62
    L87:
        th = move-exception;
        if (r2 != null) goto L102;
    L95:
        p.e(r18);     // Catch: Throwable -> L97
        throw th;     // Catch: Throwable -> L97
    L102:
        r2.close();     // Catch: Throwable -> L92
    L92:
        th = move-exception;
        n.i(th);     // Catch: Throwable -> L97
        goto L95
    L21:
        r28 = r6;
        r29 = r9;
        r30 = r10;
        long r13 = r14.f2443f;     // Catch: Throwable -> L30
        if (r13 >= r22) goto L25;
        r22 = r13;
    L25:
        if (r13 <= r24) goto L27;
        r24 = r13;
    L27:
        q(r26, r14, r1, r16, r15, r29, r12, r11, r30, r35, r36);     // Catch: Throwable -> L30
    L32:
        th = th;
        r28 = r6;
        r29 = r9;
        goto L34
    L35:
        String r27 = r5;
        Cursor r210 = r6;
        SQLiteDatabase r211 = r9;
        long[] r31 = r11;
        JSONArray[] r32 = r12;
        b(r10);     // Catch: Throwable -> L68
        if (r22 != LocationRequestCompat.PASSIVE_INTERVAL) goto L40;
    L46:
        SQLiteDatabase r19 = r211;
    L48:
        if (r210.getCount() < 5) goto L50;
    L54:
        r18 = r19;
    L55:
        r18.setTransactionSuccessful();     // Catch: Throwable -> L64
        if (r210 == null) goto L62;
        r210.close();     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        n.i(th);     // Catch: Throwable -> L97
    L64:
        th = th;
    L72:
        r2 = r210;
        goto L123
    L50:
        if (TextUtils.isEmpty(r27) == true) goto L54;
        f r20 = (f) r14.a();     // Catch: Throwable -> L66
        r18 = r19;
        r(r7, r20, r15, r16, r1, r19, r27, r32, r31, r35, r36);     // Catch: Throwable -> L64
    L66:
        th = th;
    L67:
        r18 = r19;
        goto L72
    L40:
        if (r24 == Long.MIN_VALUE) goto L46;
        r19 = r211;
        r19.execSQL("DELETE FROM launch WHERE _id>=? AND _id<=?", new String[]{String.valueOf(r22), String.valueOf(r24)});     // Catch: Throwable -> L66
    L44:
        th = th;
        r19 = r211;
    L68:
        th = th;
        r18 = r211;
    L70:
        th = th;
        r210 = r6;
        r18 = r9;
    L73:
        th = th;
        r18 = r9;
    L75:
        th = th;
        r18 = null;
    L97:
        th = move-exception;
        throw th;
    }

    @NonNull
    public ArrayList<g> u(com.bytedance.applog.s.b r6) {
        ArrayList<g> r0 = new ArrayList();
        g r1 = (g) f2450d.get("pack");
        Cursor r7 = this.f2454b.getWritableDatabase().rawQuery(B(8, r6), null);     // Catch: Throwable -> L13
    L29:
    L11:
        th = th;
    L27:
        boolean r3 = th instanceof SQLiteBlobTooBigException;     // Catch: Throwable -> L23
        w(th);     // Catch: Throwable -> L23
        n.i(th);     // Catch: Throwable -> L23
        if (r7 == null) goto L18;
        r7.close();
    L18:
        boolean r8 = r3;
    L19:
        if (r8 == false) goto L21;
        E(com.bytedance.applog.r.b.a.n);
    L21:
        n.f("queryPack, " + r0, null);
        return r0;
    L23:
        th = move-exception;
        if (r7 == null) goto L26;
        r7.close();
    L26:
        throw th;
    L5:
        if (r7.moveToNext() == false) goto L8;
        r1 = (g) r1.a();     // Catch: Throwable -> L11
        r1.o(r7);     // Catch: Throwable -> L11
        r0.add(r1);     // Catch: Throwable -> L11
        goto L29
    L8:
        if (r7 == null) goto L10;
        r7.close();
    L10:
        r8 = false;
    L13:
        th = th;
        r7 = null;
        goto L27
    }

    public void y(@NonNull ArrayList<com.bytedance.applog.w.a> r19) {
        ArrayList r2 = new ArrayList(4);
        ArrayList<com.bytedance.applog.w.a> r3 = new ArrayList(4);
        int r4 = r19.size();
        String r5 = null;
        int r6 = 0;
        SQLiteDatabase r7 = this.f2454b.getWritableDatabase();     // Catch: Throwable -> L38
        r7.beginTransaction();     // Catch: Throwable -> L36
        Iterator<com.bytedance.applog.w.a> r0 = r19.iterator();     // Catch: Throwable -> L36
        ContentValues r12 = null;
        int r8 = 0;
        int r9 = 0;
        int r10 = 0;
        int r11 = 0;
    L60:
    L34:
        th = th;
        SQLiteDatabase r13 = r7;
        r6 = r8;
    L58:
        w(th);     // Catch: Throwable -> L51
        n.i(th);     // Catch: Throwable -> L51
        p.e(r13);
        r8 = r6;
    L42:
        n.e("save, " + r4 + ", " + r8 + ", " + r9 + ", " + r10 + ", " + r11);
        n(r3);
        Iterator r1 = r2.iterator();     // Catch: Throwable -> L48
    L45:
        if (r1.hasNext() == false) goto L69;
        f r14 = (f) r1.next();     // Catch: Throwable -> L48
        m.c().b(r14.f2443f, r14.f2446i);     // Catch: Throwable -> L48
        goto L45
    L69:
        return;
    L48:
        th = move-exception;
        n.i(th);
        return;
    L51:
        th = move-exception;
        p.e(r13);
        throw th;
    L7:
        if (r0.hasNext() == false) goto L32;
        com.bytedance.applog.w.a r15 = r0.next();     // Catch: Throwable -> L34
        String r16 = r15.n();     // Catch: Throwable -> L34
        r12 = r15.w(r12);     // Catch: Throwable -> L34
        long r17 = r7.insert(r16, r5, r12);     // Catch: Throwable -> L34
        r15.f2443f = r17;     // Catch: Throwable -> L34
        if (r17 < 0) goto L11;
        boolean r18 = true;
    L13:
        if (NotificationCompat.CATEGORY_EVENT.equals(r15.n()) == false) goto L19;
        r3.add(r15);     // Catch: Throwable -> L34
        if (r18 == false) goto L17;
    L16:
        r8 = r8 + 1;     // Catch: Throwable -> L34
    L29:
        if (r18 == true) goto L31;
        com.bytedance.applog.o.b.e(r15, com.bytedance.applog.r.b.d.f2351l);     // Catch: Throwable -> L34
        com.bytedance.applog.o.b.i(com.bytedance.applog.r.b.a.w, com.bytedance.applog.o.b.a(r15));     // Catch: Throwable -> L34
    L31:
        r5 = null;
    L17:
        r9 = r9 + 1;     // Catch: Throwable -> L34
        goto L29
    L19:
        if ("eventv3".equals(r15.n()) == false) goto L24;
        r3.add(r15);     // Catch: Throwable -> L34
        if (r18 == false) goto L17;
    L24:
        if ((r15 instanceof f) == false) goto L29;
        r2.add((f) r15);     // Catch: Throwable -> L34
        if (r18 == false) goto L28;
        r10 = r10 + 1;     // Catch: Throwable -> L34
        goto L29
    L28:
        r11 = r11 + 1;     // Catch: Throwable -> L34
        goto L29
    L11:
        r18 = false;
        goto L13
    L32:
        r7.setTransactionSuccessful();     // Catch: Throwable -> L34
        p.e(r7);
    L36:
        th = th;
        r9 = 0;
        r10 = 0;
        r11 = 0;
        r13 = r7;
    L38:
        th = th;
        r9 = 0;
        r10 = 0;
        r11 = 0;
        r13 = null;
        goto L58
    }
}
