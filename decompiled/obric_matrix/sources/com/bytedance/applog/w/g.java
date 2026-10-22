package com.bytedance.applog.w;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.room.RoomDatabase;
import com.bytedance.applog.util.n;
import com.bytedance.applog.util.p;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g extends a {
    private static final SimpleDateFormat R = null;
    JSONArray A;
    long B;
    f C;
    JSONArray D;
    i E;
    private JSONObject F;
    JSONArray G;
    long H;
    private JSONArray I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private String f2460J;
    private String K;
    private String L;
    private String M;
    public int N;
    public String O;
    private int P;
    private int Q;
    public byte[] v;
    int w;
    public int x;
    JSONArray y;
    long z;

    static {
        R = com.bytedance.applog.util.b.a();
    }

    public g() {
        this.P = 0;
        this.Q = 0;
    }

    private static String C(ArrayList<Long> r2, ArrayList<Long> r3, ArrayList<Long> r4, ArrayList<Long> r5, ArrayList<Long> r6, ArrayList<Long> r7, ArrayList<Long> r8) {
        JSONObject r0 = new JSONObject();
        K(r0, "JSON_PARAM_LAUNCH_COUNT", r2);
        K(r0, "JSON_PARAM_TERMINATE_COUNT", r3);
        K(r0, "JSON_PARAM_PAGE_COUNT", r4);
        K(r0, "JSON_PARAM_EVENT_V1_COUNT", r5);
        K(r0, "JSON_PARAM_EVENT_V3_COUNT", r6);
        K(r0, "JSON_PARAM_MISC_COUNT", r7);
        K(r0, "JSON_PARAM_IMPRESSION_COUNT", r8);
        return r0.toString();
    }

    private static ArrayList<Long> J(JSONArray r4, long r5) {
        ArrayList<Long> r0 = new ArrayList();
        if (r4 == null) goto L12;
        int r1 = 0;
    L6:
        if (r1 >= r4.length()) goto L12;
        Object r2 = r4.get(r1);
        if ((r2 instanceof JSONObject) == false) goto L10;
        Long r3 = Long.valueOf(((JSONObject) r2).optLong("local_time_ms", r5));
    L11:
        r0.add(r3);
        r1 = r1 + 1;
        goto L6
    L10:
        r3 = Long.valueOf(r5);
    L12:
        return r0;
    }

    private static <T> void K(JSONObject r1, String r2, ArrayList<T> r3) {
        r1.put(r2, new JSONArray(r3));
    }

    public static g L(ArrayList<a> r11, JSONObject r12, com.bytedance.applog.s.b r13) {
        g r10 = new g();
        JSONArray[] r5 = {null, new JSONArray(), null};     // Catch: Throwable -> L12
        long[] r6 = new long[3];     // Catch: Throwable -> L12
        Iterator<a> r14 = r11.iterator();     // Catch: Throwable -> L12
    L5:
        if (r14.hasNext() == false) goto L10;
        a r0 = r14.next();     // Catch: Throwable -> L12
        JSONObject r1 = r0.v();     // Catch: Throwable -> L12
        if (r1 != null) goto L8;
        com.bytedance.applog.o.b.d(com.bytedance.applog.r.b.a.m, com.bytedance.applog.r.b.d.n);     // Catch: Throwable -> L12
        com.bytedance.applog.o.b.i(com.bytedance.applog.r.b.a.x, com.bytedance.applog.o.b.a(r0));     // Catch: Throwable -> L12
        goto L5
    L8:
        r5[1].put(r1);     // Catch: Throwable -> L12
        goto L5
    L10:
        r10.N(r12, null, null, null, r5, r6, null, r13, 8);     // Catch: Throwable -> L12
        r10.O();     // Catch: Throwable -> L12
    L14:
        return r10;
    L12:
        th = move-exception;
        n.i(th);
        goto L14
    }

    public static void M(com.bytedance.applog.r.b.a r5, g r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        com.bytedance.applog.o.b.i(r5, com.bytedance.applog.o.b.a(r6));
        if (r6.C == null) goto L8;
        com.bytedance.applog.o.b.i(r5, "launch");
    L8:
        if (r6.E == null) goto L10;
        com.bytedance.applog.o.b.i(r5, "terminate");
    L10:
        int r2 = 0;
        if (r6.y == null) goto L21;
        int r0 = 0;
    L14:
        if (r0 >= r6.y.length()) goto L21;
        JSONObject r3 = r6.y.optJSONObject(r0);
        if (r3 == null) goto L19;
        com.bytedance.applog.o.b.i(r5, r3.optString(LocationMonitorConst.TAG, ""));
    L19:
        r0 = r0 + 1;
    L21:
        if (r6.G == null) goto L31;
        int r1 = 0;
    L24:
        if (r1 >= r6.G.length()) goto L31;
        JSONObject r4 = r6.G.optJSONObject(r1);
        if (r4 == null) goto L29;
        com.bytedance.applog.o.b.i(r5, r4.optString("log_type", ""));
    L29:
        r1 = r1 + 1;
    L31:
        if (r6.A != null) goto L33;
        return;
    L33:
        if (r2 >= r6.A.length()) goto L49;
        JSONObject r7 = r6.A.optJSONObject(r2);
        if (r7 == null) goto L38;
        com.bytedance.applog.o.b.i(r5, r7.optString(NotificationCompat.CATEGORY_EVENT, ""));
    L38:
        r2 = r2 + 1;
        goto L33
    }

    @Override // com.bytedance.applog.w.a
    protected JSONObject B() {
        JSONObject r1 = new JSONObject();
        r1.put("magic_tag", "ss_app_log");
        r1.put("header", this.F);
        Object r2 = com.bytedance.applog.v.a.f2436b;
        if (r2 == null) goto L5;
        r1.put("time_sync", r2);
    L5:
        r1.put("_gen_time", System.currentTimeMillis());
        ArrayList r5 = new ArrayList();
        if (this.C == null) goto L10;
        JSONArray r3 = new JSONArray();
        r3.put(this.C.v());
        r1.put("launch", r3);
        f r4 = this.C;
        if (r4.x == true) goto L10;
        this.M = "foreground_launch";
        r5.add(Long.valueOf(r4.f2444g));
        com.bytedance.applog.o.b.d(com.bytedance.applog.r.b.a.f2335k, com.bytedance.applog.r.b.d.f2346g);
    L10:
        ArrayList r6 = new ArrayList();
        i r7 = this.E;
        int r8 = 0;
        if (r7 == null) goto L25;
        JSONObject r9 = r7.v();
        JSONObject r10 = new JSONObject();
        r10.put("terminate", r9);
        this.M = r10.toString();
        JSONArray r11 = this.D;
        if (r11 == null) goto L15;
        int r12 = r11.length();
    L16:
        JSONArray r13 = new JSONArray();
        int r14 = 0;
    L17:
        if (r14 >= r12) goto L19;
        JSONArray r15 = new JSONArray();
        JSONObject r16 = new JSONObject(new JSONObject(this.D.optString(r14)).optString("params"));
        r15.put(0, r16.optString("page_key", ""));
        r15.put(1, (r16.optInt(TypedValues.TransitionType.S_DURATION, 0) + RoomDatabase.MAX_BIND_PARAMETER_CNT) / 1000);
        r13.put(r15);
        r14 = r14 + 1;
        goto L17
    L19:
        if (r12 <= 0) goto L21;
        r9.put("activites", r13);
    L21:
        int r17 = com.bytedance.applog.a.f2201d;
        if (r17 <= 0) goto L24;
        r9.put("launch_from", r17);
        com.bytedance.applog.a.f2201d = 0;
    L24:
        JSONArray r18 = new JSONArray();
        r18.put(r9);
        r1.put("terminate", r18);
        r6.add(Long.valueOf(this.E.f2444g));
        com.bytedance.applog.o.b.d(com.bytedance.applog.r.b.a.f2336l, com.bytedance.applog.r.b.d.f2346g);
        goto L25
    L15:
        r12 = 0;
    L25:
        JSONArray r19 = this.y;
        if (r19 == null) goto L28;
        int r20 = r19.length();
    L29:
        if (r20 <= 0) goto L31;
        r1.put(NotificationCompat.CATEGORY_EVENT, this.y);
    L31:
        JSONArray r21 = this.D;
        if (r21 == null) goto L34;
        int r110 = r21.length();
    L35:
        JSONArray r22 = this.A;
        if (r22 == null) goto L38;
        int r111 = r22.length();
    L39:
        if (r111 <= 0) goto L41;
        r1.put("event_v3", this.A);
    L41:
        JSONArray r23 = this.G;
        if (r23 == null) goto L44;
        int r112 = r23.length();
    L45:
        if (r112 <= 0) goto L47;
        r1.put("log_data", this.G);
    L47:
        JSONArray r24 = this.I;
        if (r24 == null) goto L50;
        r8 = r24.length();
    L50:
        if (r8 <= 0) goto L52;
        r1.put("item_impression", this.I);
    L52:
        com.bytedance.applog.v.a.e(r1, true, null);
        this.K = r1.optString("key");
        this.L = r1.optString("iv");
        if (com.bytedance.applog.a.B() == false) goto L55;
        r1.put("priority_enable", 1);
        r1.put("priority_version", this.P);
        r1.put("priority_value", this.s);
        r1.put("request_from", this.Q);
    L55:
        int r113 = r112;
        this.f2460J = C(r5, r6, J(this.D, this.f2444g), J(this.y, this.f2444g), J(this.A, this.f2444g), J(this.G, this.f2444g), J(this.I, this.f2444g));
        StringBuilder r25 = new StringBuilder("pack {");
        r25.append("ts:");
        r25.append(this.f2444g);
        r25.append(", la:");
        Object r26 = this.C;
        Object r27 = BDLocationException.ERROR_TIMEOUT;
        if (r26 != null) goto L59;
        r26 = BDLocationException.ERROR_TIMEOUT;
    L59:
        r25.append(r26);
        r25.append(", te:");
        i r0 = this.E;
        if (r0 == null) goto L62;
        r27 = r0;
    L62:
        r25.append(r27);
        r25.append(", p:");
        r25.append(r110);
        r25.append(", v1:");
        r25.append(r20);
        r25.append(", v3:");
        r25.append(r111);
        r25.append(", m:");
        r25.append(r113);
        r25.append(", imp:");
        r25.append(r8);
        r25.append("}");
        n.e(r25.toString());
        return r1;
    L44:
        r112 = 0;
        goto L45
    L38:
        r111 = 0;
        goto L39
    L34:
        r110 = 0;
        goto L35
    L28:
        r20 = 0;
        goto L29
    }

    public String D() {
        return this.f2460J;
    }

    public long E() {
        return this.f2443f;
    }

    public String[] F() {
        return new String[]{this.K, this.L};
    }

    public boolean G() {
        return "foreground_launch".equalsIgnoreCase(this.M);
    }

    public boolean H() {
        if (TextUtils.isEmpty(this.M) == false) goto L5;
        return false;
    L5:
        JSONObject r0 = null;
        r0 = new JSONObject(this.M);     // Catch: JSONException -> L15
    L8:
        if (r0 != null) goto L10;
    L14:
        return false;
    L10:
        if (r0.isNull("terminate") == true) goto L14;
        return true;
    }

    public boolean I(com.bytedance.applog.o.h r8) {
        if (TextUtils.isEmpty(this.M) == false) goto L5;
        return false;
    L5:
        JSONObject r0 = null;
        r0 = new JSONObject(this.M);     // Catch: JSONException -> L29
    L8:
        if (r0 != null) goto L10;
    L28:
        return false;
    L10:
        if (r0.isNull("terminate") == true) goto L28;
        JSONObject r7 = r0.optJSONObject("terminate");
        if (r7 != null) goto L15;
        return false;
    L15:
        SimpleDateFormat r1 = R;
        String r2 = r1.format(new Date(System.currentTimeMillis()));
        if (r2.equals(r1.format(Long.valueOf(r8.f()))) == false) goto L18;
        return false;
    L18:
        long r3 = r7.optLong("local_time_ms", -1);
        if (r3 < 0) goto L28;
        if (r1.format(new Date(r3)).startsWith(r2) == true) goto L28;
        if (r2.equals(r1.format(new Date(r7.optLong("stop_timestamp") * 1000))) == false) goto L26;
        return false;
    L26:
        com.bytedance.applog.o.b.d(com.bytedance.applog.r.b.a.n, com.bytedance.applog.r.b.d.w);
        return true;
    }

    public void N(JSONObject r3, f r4, i r5, JSONArray r6, JSONArray[] r7, long[] r8, JSONArray r9, com.bytedance.applog.s.b r10, int r11) {
        t(0);
        this.F = r3;
        this.C = r4;
        this.E = r5;
        this.D = r6;
        this.y = r7[0];
        this.z = r8[0];
        this.A = r7[1];
        this.B = r8[1];
        this.G = r7[2];
        this.H = r8[2];
        this.I = r9;
        if (r10 == null) goto L7;
        this.P = r10.h();
        this.s = r10.f();
        if (TextUtils.isEmpty(r10.d()) == true) goto L8;
        q(1);
    L8:
        this.Q = r11;
        return;
    L7:
        this.P = 0;
        this.s = -1;
        goto L8
    }

    public byte[] O() {
        int r0 = 0;
        String r1 = v().toString();     // Catch: OutOfMemoryError -> L5
        r0 = r1.length();     // Catch: OutOfMemoryError -> L5
        return P(r1);
    L5:
        e = move-exception;
        b.C0076b.d(e, r0);
        M(com.bytedance.applog.r.b.a.z, this);
        return null;
    }

    public byte[] P(String r3) {
        this.v = null;
        if (TextUtils.isEmpty(r3) == true) goto L25;
        this.v = r3.getBytes("UTF-8");     // Catch: Throwable -> L13
        if (com.bytedance.applog.a.n() == true) goto L7;
    L19:
        byte[] r4 = this.v;
        if (r4 != null) goto L22;
    L23:
        com.bytedance.applog.o.b.d(com.bytedance.applog.r.b.a.n, com.bytedance.applog.r.b.d.q);
        goto L25
    L22:
        if (r4.length != 0) goto L25;
    L7:
        if (com.bytedance.applog.a.t() == null) goto L10;
        com.bytedance.applog.c r0 = com.bytedance.applog.a.t().a(this.v);     // Catch: Throwable -> L13
        this.v = r0.a();     // Catch: Throwable -> L13
        this.N = r0.b();     // Catch: Throwable -> L13
        String r1 = p.k(r0.c());     // Catch: Throwable -> L13
    L9:
        this.O = r1;     // Catch: Throwable -> L13
        this.v = com.bytedance.applog.util.e.c(this.v);     // Catch: Throwable -> L13
        goto L19
    L10:
        this.v = com.bytedance.applog.util.e.e(this.v);     // Catch: Throwable -> L13
        this.N = 0;     // Catch: Throwable -> L13
        r1 = p.k(Collections.singletonMap("log-encode-type", "gzip"));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        com.bytedance.applog.r.b.a r2 = com.bytedance.applog.r.b.a.n;
        if (r3 != null) goto L17;
        com.bytedance.applog.r.b.d r5 = com.bytedance.applog.r.b.d.r;
    L18:
        com.bytedance.applog.o.b.d(r2, r5);
        n.i(th);
        goto L19
    L17:
        r5 = com.bytedance.applog.r.b.d.s;
    L25:
        return this.v;
    }

    @Override // com.bytedance.applog.w.a
    protected List<String> h() {
        return Arrays.asList(new String[]{"_id", "integer primary key autoincrement", "local_time_ms", TypedValues.Custom.S_INT, "_data", "blob", "session_id", "varchar", "_fail", TypedValues.Custom.S_INT, "event_count", "varchar", "key", "varchar", "iv", "varchar", "data_json", "text", "encode_type", TypedValues.Custom.S_INT, "encode_headers", "varchar", "priority", TypedValues.Custom.S_INT, "forward", TypedValues.Custom.S_INT});
    }

    @Override // com.bytedance.applog.w.a
    protected String j() {
        return String.valueOf(this.f2443f);
    }

    @Override // com.bytedance.applog.w.a
    @NonNull
    String n() {
        return "pack";
    }

    @Override // com.bytedance.applog.w.a
    public int o(@NonNull Cursor r3) {
        this.f2443f = r3.getLong(0);
        this.f2444g = r3.getLong(1);
        this.v = r3.getBlob(2);
        this.f2446i = r3.getString(3);
        this.w = r3.getInt(4);
        this.f2460J = r3.getString(5);
        this.K = r3.getString(6);
        this.L = r3.getString(7);
        this.M = r3.getString(8);
        this.N = r3.getInt(9);
        this.O = r3.getString(10);
        this.s = r3.getInt(11);
        this.t = r3.getInt(12);
        this.F = null;
        this.C = null;
        this.E = null;
        this.D = null;
        this.y = null;
        this.A = null;
        this.G = null;
        this.I = null;
        return 13;
    }

    @Override // com.bytedance.applog.w.a
    protected a p(@NonNull JSONObject r1) {
        n.i(null);
        return null;
    }

    @Override // com.bytedance.applog.w.a
    protected void y(@NonNull ContentValues r4) {
        r4.put("local_time_ms", Long.valueOf(this.f2444g));     // Catch: OutOfMemoryError -> L4
        r4.put("_data", O());     // Catch: OutOfMemoryError -> L4
        r4.put("session_id", this.f2446i);     // Catch: OutOfMemoryError -> L4
        r4.put("event_count", this.f2460J);     // Catch: OutOfMemoryError -> L4
        r4.put("key", this.K);     // Catch: OutOfMemoryError -> L4
        r4.put("iv", this.L);     // Catch: OutOfMemoryError -> L4
        r4.put("encode_type", Integer.valueOf(this.N));     // Catch: OutOfMemoryError -> L4
        r4.put("encode_headers", this.O);     // Catch: OutOfMemoryError -> L4
        r4.put("data_json", this.M);     // Catch: OutOfMemoryError -> L4
        r4.put("priority", Integer.valueOf(this.s));     // Catch: OutOfMemoryError -> L4
        r4.put("forward", Integer.valueOf(this.t));     // Catch: OutOfMemoryError -> L4
        return;
    }

    @Override // com.bytedance.applog.w.a
    protected void z(@NonNull JSONObject r1) {
        n.i(null);
    }
}
