package com.bytedance.apm.a0.k;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.util.y;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g extends com.bytedance.apm.a0.a {
    private static String t = "bg_never_front";
    private static com.bytedance.apm.w.g u;
    private static d.b.b.o.l.a<d.b.b.d.c.c> v;
    private static d.b.b.o.l.a<String> w;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f1242g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f1243h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f1244i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f1245j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f1246k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f1247l;
    private long m;
    private long n;
    private long o;
    private long p;
    private long q;
    private long r;
    private h s;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final g f1248a = null;

        static {
            f1248a = new g(null);
        }

        static /* synthetic */ g a() {
            return f1248a;
        }
    }

    static {
        v = new d.b.b.o.l.a(20);
        w = new d.b.b.o.l.a(20);
    }

    private g() {
        this.f1242g = 500000000;
        this.f1243h = 0;
        this.f1244i = 1;
        this.f1245j = -1;
        this.f1246k = 0;
        this.f1247l = 0;
        this.m = 0;
        this.n = 0;
        this.p = 0;
        this.f1122e = "traffic";
        h r0 = h.e();
        this.s = r0;
        r0.k(e());
    }

    /* synthetic */ g(f r1) {
        this();
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences o(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    public static g p() {
        return a.a();
    }

    private JSONArray q(Map<String, com.bytedance.apm.a0.k.a.c> r5, String r6, JSONArray r7) {
        if (r5 != null) goto L5;
    L17:
        return null;
    L5:
        if (r5.size() == 0) goto L17;
        Iterator<Map.Entry<String, com.bytedance.apm.a0.k.a.c>> r8 = r5.entrySet().iterator();     // Catch: Exception -> L18
    L9:
        if (r8.hasNext() == false) goto L16;
        JSONObject r1 = r8.next().getValue().c(this.f1243h);     // Catch: Exception -> L18
        if (TextUtils.isEmpty(r6) == true) goto L14;
        r1.put("traffic_category", r6);     // Catch: Exception -> L18
    L14:
        r7.put(r1);     // Catch: Exception -> L18
        goto L9
    L16:
        return r7;
    }

    public static void r(com.bytedance.apm.w.g r0) {
        u = r0;
    }

    @Override // com.bytedance.apm.a0.a
    protected void c(JSONObject r8) {
        super.c(r8);
        if (r8.optInt("cause_analysis", 0) != 1) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        com.bytedance.apm.a0.k.a.j().u();
        this.f1242g = (r8.optInt("exception_threshold_mb", 500) * 1000) * 1000;
        this.f1244i = (r8.optInt("exception_threshold_bg_mb", 500) * 1000) * 1000;
        this.q = r8.optInt("high_freq_threshold", 200);
        com.bytedance.apm.a0.k.a.j().s((r8.optDouble("large_usage_threshold_mb", 10.0d) * 1000.0d) * 1000.0d);
        com.bytedance.apm.a0.k.a.j().o(r8.optDouble("alog_record_threshold", 100.0d));
    L8:
        this.f1243h = r8.optLong("record_usage_kb", 1) * 1024;
        boolean r7 = com.bytedance.apm.d0.c.c(this.f1122e);
    L10:
        if (v.a() == true) goto L30;
        d.b.b.d.c.c r1 = v.b();
        String r3 = w.b();
        if (r7 == false) goto L14;
    L19:
        d.b.b.d.a.i(r1);
    L21:
        if (com.bytedance.apm.d.C() == false) goto L10;
        String[] r2 = new String[1];
        StringBuilder r4 = new StringBuilder();
        r4.append("isSample:key:");
        if (r7 == false) goto L25;
    L28:
        boolean r5 = true;
    L29:
        r4.append(r5);
        r2[0] = r4.toString();
        com.bytedance.apm.x.e.b("Traffic", r2);
        goto L10
    L25:
        if (r8.optInt(r3, 0) == 1) goto L28;
        r5 = false;
        goto L29
    L14:
        if (r8.optInt(r3, 0) == 1) goto L19;
        if (com.bytedance.apm.d.C() == false) goto L21;
        com.bytedance.apm.doctor.a.b(r1.a(), r1.d(), false);
        goto L21
    L30:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.apm.a0.a
    protected boolean f() {
        return true;
    }

    @Override // com.bytedance.apm.a0.a
    protected void h() {
        SharedPreferences r4 = o(com.bytedance.apm.d.h(), "traffic_monitor_info", 0);
        long r8 = r4.getLong("init", -1);
        long r13 = r4.getLong("init_ts", 0);
        if (r8 <= (-1)) goto L22;
        long r0 = r4.getLong("usage", 0);
        long r6 = r4.getLong("usage_ts", 0);
        long r2 = r0 - r8;
        if (r2 > 0) goto L27;
    L21:
        g r3 = this;
        String r5 = "usage";
    L23:
        r3.p = r3.s.h();
        SharedPreferences.Editor r1 = r4.edit();
        r1.putLong("init", r3.p);
        r1.putLong("init_ts", System.currentTimeMillis());
        r1.putLong(r5, 0);
        r1.apply();
        return;
    L27:
        JSONObject r11 = new JSONObject();     // Catch: JSONException -> L26
        r11.put("total_usage", r2);     // Catch: JSONException -> L26
        JSONObject r12 = new JSONObject();     // Catch: JSONException -> L26
        r12.put("total_usage_duration", ((r6 - r13) / 1000) / 60);     // Catch: JSONException -> L26
        JSONObject r7 = new JSONObject();     // Catch: JSONException -> L26
        r7.put("init_ts", r13);     // Catch: JSONException -> L26
        r7.put("usage_ts", r6);     // Catch: JSONException -> L26
        r7.put("biz_usage", r4.getLong("biz_usage", 0));     // Catch: JSONException -> L26
        r7.put("init", r8);     // Catch: JSONException -> L26
        r5 = "usage";
        r7.put(r5, r0);     // Catch: JSONException -> L20
        String r9 = r4.getString("biz_json", "");     // Catch: JSONException -> L20
        if (r9 == "") goto L11;
        JSONObject r10 = new JSONObject();     // Catch: JSONException -> L20
        r10.put(r5, new JSONArray(r9));     // Catch: JSONException -> L20
        r7.put("detail", r10);     // Catch: JSONException -> L20
    L11:
        com.bytedance.apm.t.d.e r14 = new com.bytedance.apm.t.d.e();     // Catch: JSONException -> L20
        r3 = this;
        r14.k(r3.f1122e);     // Catch: JSONException -> L25
        r14.i(r11);     // Catch: JSONException -> L25
        r14.h(r12);     // Catch: JSONException -> L25
        r14.g(r7);     // Catch: JSONException -> L25
        com.bytedance.apm.x.a.b("APM-Traffic-Detail ", "Init");     // Catch: JSONException -> L25
        if (com.bytedance.apm.x.a.e() == false) goto L16;
        com.bytedance.apm.x.a.b("APM-Traffic-Detail ", com.bytedance.apm.util.h.b(r14.c()).toString());     // Catch: JSONException -> L25
    L16:
        r3.k(r14);     // Catch: JSONException -> L25
        com.bytedance.apm.w.g r15 = u;     // Catch: JSONException -> L25
        if (r15 == null) goto L23;
        r15.b(r2);     // Catch: JSONException -> L25
    L20:
        r3 = this;
        goto L23
    L22:
        r3 = this;
        r5 = "usage";
        goto L23
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [com.bytedance.apm.t.d.e] */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.bytedance.apm.t.d.e] */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.lang.Object, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r4v15, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r4v9, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [com.bytedance.apm.a0.k.g] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [com.bytedance.apm.a0.a, com.bytedance.apm.a0.k.g] */
    @Override // com.bytedance.apm.a0.a
    protected void i() {
        super.i();
        if (e() == true) goto L5;
        t = "bg_ever_front";
    L5:
        long r5 = System.currentTimeMillis();
        long r7 = this.s.h();
        long r9 = this.s.f();
        long r11 = this.s.g();
        long r13 = this.s.i();
        String r17 = "APM-Traffic-Detail ";
        long r2 = this.s.j();
        if (this.f1245j != (-1)) goto L9;
        this.f1245j = r7;
        this.f1246k = r9;
        this.f1247l = r11;
        this.m = r13;
        this.n = r2;
        this.o = r5;
        return;
    L9:
        JSONArray r6 = new JSONArray();
        long r4 = r7 - this.f1245j;
        long r8 = r9 - this.f1246k;
        long r10 = r11 - this.f1247l;
        long r12 = r13 - this.m;
        long r14 = r2 - this.n;
        long r15 = this.f1242g;
        if (r15 > 0) goto L12;
    L15:
        long r16 = this.f1244i;
        if (r16 > 0) goto L18;
    L23:
        y<i> r18 = com.bytedance.apm.a0.k.a.j().k();
        if (r18 == null) goto L29;
        if (r18.c() <= 0) goto L29;
        r6.put("large_request");
    L29:
        if (c.d().e() <= this.q) goto L31;
        r6.put("high_feq_request");
    L31:
        this.f1245j = r7;
        this.n = r2;
        this.m = r13;
        this.f1246k = r9;
        this.f1247l = r11;
        JSONArray r3 = new JSONArray();
        com.bytedance.apm.d0.c.c(this.f1122e);
        q(com.bytedance.apm.a0.k.a.j().g(), "usage_10_minutes", r3);
        q(com.bytedance.apm.a0.k.a.j().i(), "wifi_front", r3);
        q(com.bytedance.apm.a0.k.a.j().h(), "wifi_back", r3);
        q(com.bytedance.apm.a0.k.a.j().f(), "mobile_front", r3);
        q(com.bytedance.apm.a0.k.a.j().e(), "mobile_back", r3);
        ?? r19 = new JSONObject();
        if (r3.length() > 0) goto L122;
    L120:
        JSONObject r20 = new JSONObject();     // Catch: JSONException -> L91
        r20.put("usage_10_minutes", r4);     // Catch: JSONException -> L91
        r20.put("mobile_back", r8);     // Catch: JSONException -> L91
        r20.put("mobile_front", r10);     // Catch: JSONException -> L91
        r20.put("wifi_back", r12);     // Catch: JSONException -> L91
        String r110 = "detail";
        r20.put("wifi_front", r14);     // Catch: JSONException -> L90
        com.bytedance.apm.w.g r21 = u;     // Catch: JSONException -> L90
        if (r21 == null) goto L39;
        r21.a(r4, r12, r14, r8, r10);     // Catch: JSONException -> L90
    L39:
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L90
        ?? r1 = new com.bytedance.apm.t.d.e();     // Catch: JSONException -> L90
        ?? r22 = new JSONObject();     // Catch: JSONException -> L90
        r22.put(r110, r19);     // Catch: JSONException -> L90
        String r23 = "biz_usage";
        r22.put(r23, com.bytedance.apm.a0.k.a.j().d());     // Catch: JSONException -> L88
        ?? r24 = this;
        r22.put("init_ts", r24.o);     // Catch: JSONException -> L113
        String r25 = "usage_ts";
        r22.put(r25, r5);     // Catch: JSONException -> L111
        r1.k(r24.f1122e);     // Catch: JSONException -> L111
        r1.h(r0);     // Catch: JSONException -> L111
        r1.i(r20);     // Catch: JSONException -> L111
        r1.g(r22);     // Catch: JSONException -> L111
        if (com.bytedance.apm.x.a.e() == true) goto L48;
        String r111 = r17;
    L51:
        r24.k(r1);     // Catch: JSONException -> L110
        r24.o = r5;     // Catch: JSONException -> L110
        if (r6.length() <= 0) goto L87;
        JSONObject r26 = new JSONObject();     // Catch: JSONException -> L110
        r26.put("exception", true);     // Catch: JSONException -> L110
        r26.put("exception_type", r6);     // Catch: JSONException -> L110
        Map<String, i> r27 = c.d().c();     // Catch: JSONException -> L110
        if (r27 == null) goto L69;
        Iterator<Map.Entry<String, i>> r28 = r27.entrySet().iterator();     // Catch: JSONException -> L110
        JSONArray r112 = new JSONArray();     // Catch: JSONException -> L110
    L57:
        if (r28.hasNext() == false) goto L65;
        Map.Entry<String, i> r113 = r28.next();     // Catch: JSONException -> L110
        String r114 = r111;
        String r115 = r110;
        JSONObject r116 = r0;
        JSONObject r117 = r26;
        if (r113.getValue().f1254i <= r24.q) goto L64;
        JSONObject r29 = new JSONObject();     // Catch: JSONException -> L111
        r29.put("path", r113.getValue().f1251f);     // Catch: JSONException -> L111
        r29.put("freq", r113.getValue().f1254i);     // Catch: JSONException -> L111
        r29.put("biz", r113.getValue().f1252g);     // Catch: JSONException -> L111
        r112.put(r29);     // Catch: JSONException -> L111
    L64:
        r0 = r116;
        r110 = r115;
        r111 = r114;
        r26 = r117;
        goto L57
    L65:
        JSONObject r118 = r0;
        JSONObject r119 = r26;
        r17 = r111;
        String r120 = r110;
        if (com.bytedance.apm.x.a.e() == false) goto L68;
        com.bytedance.apm.x.a.b("TrafficHighTreq", r112.toString());     // Catch: JSONException -> L111
    L68:
        r19.put("high_freq", r112);     // Catch: JSONException -> L111
    L70:
        if (r18 == null) goto L82;
        List r30 = r18.d();     // Catch: JSONException -> L111
        if (r30 == null) goto L82;
        if (r30.size() <= 0) goto L82;
        JSONArray r31 = new JSONArray();     // Catch: JSONException -> L111
        Iterator r32 = r30.iterator();     // Catch: JSONException -> L111
    L77:
        if (r32.hasNext() == false) goto L79;
        i r33 = (i) r32.next();     // Catch: JSONException -> L111
        JSONObject r121 = new JSONObject();     // Catch: JSONException -> L111
        r121.put("path", r33.f1251f);     // Catch: JSONException -> L111
        r121.put("usage", r33.f1253h);     // Catch: JSONException -> L111
        r121.put("biz", r33.f1252g);     // Catch: JSONException -> L111
        r31.put(r121);     // Catch: JSONException -> L111
        goto L77
    L79:
        r19.put("large_usage", r31);     // Catch: JSONException -> L111
        if (com.bytedance.apm.x.a.e() == false) goto L82;
        com.bytedance.apm.x.a.b("TrafficTopK", r31.toString());     // Catch: JSONException -> L111
    L82:
        ?? r34 = r119;
        r34.put(r23, com.bytedance.apm.a0.k.a.j().d());     // Catch: JSONException -> L111
        if (com.bytedance.apm.x.a.e() == false) goto L85;
        com.bytedance.apm.x.a.b("TrafficException", r34.toString());     // Catch: JSONException -> L111
    L85:
        r34.put(r120, r19);     // Catch: JSONException -> L111
        ?? r35 = new com.bytedance.apm.t.d.e();     // Catch: JSONException -> L111
        r35.k(r24.f1122e);     // Catch: JSONException -> L111
        r35.h(r118);     // Catch: JSONException -> L111
        r35.i(r20);     // Catch: JSONException -> L111
        r35.g(r34);     // Catch: JSONException -> L111
        r24.k(r35);     // Catch: JSONException -> L111
        goto L93
    L69:
        r118 = r0;
        r119 = r26;
        r17 = r111;
        r120 = r110;
    L87:
        r17 = r111;
        goto L93
    L48:
        r111 = r17;
        com.bytedance.apm.x.a.b(r111, com.bytedance.apm.util.h.b(r1.c()).toString());     // Catch: JSONException -> L110
    L93:
        SharedPreferences.Editor r36 = o(com.bytedance.apm.d.h(), "traffic_monitor_info", 0).edit();
        r36.putLong("usage", r7);
        long r37 = r24.r + com.bytedance.apm.a0.k.a.j().d();
        r24.r = r37;
        r36.putLong(r23, r37);
        r36.putLong(r25, System.currentTimeMillis());
        Map<String, com.bytedance.apm.a0.k.a.c> r38 = com.bytedance.apm.a0.k.a.j().l();
        if (r38 != null) goto L96;
    L104:
        r36.apply();
        if (com.bytedance.apm.d.C() == false) goto L107;
        String r39 = r17;
        Log.d(r39, "traffic since app boot: " + (r7 - r24.p));
        Log.d(r39, "traffic stats from biz (include ttnet/ok/httpurl plus trafficStats): " + com.bytedance.apm.a0.k.a.j().d());
    L107:
        com.bytedance.apm.a0.k.a.j().c();
        c.d().b();
        return;
    L96:
        if (r38.size() <= 0) goto L104;
        JSONArray r40 = new JSONArray();
        Iterator<Map.Entry<String, com.bytedance.apm.a0.k.a.c>> r41 = r38.entrySet().iterator();
    L99:
        if (r41.hasNext() == false) goto L103;
        JSONObject r42 = r41.next().getValue().b();
        r42.put("traffic_category", "total_usage");     // Catch: Exception -> L112
    L102:
        r40.put(r42);
        goto L99
    L103:
        r36.putString("biz_json", r40.toString());
    L89:
        r25 = "usage_ts";
    L88:
        r24 = this;
    L90:
        r24 = this;
    L92:
        r25 = "usage_ts";
        r23 = "biz_usage";
    L91:
        r24 = this;
        goto L92
    L122:
        r19.put("usage", r3);     // Catch: Exception -> L109
        goto L120
    L18:
        if ((r8 + r12) <= r16) goto L23;
        if (TextUtils.equals(t, "bg_never_front") == false) goto L22;
        String r122 = "never_front_usage_abnormal";
    L14:
        r6.put(r122);
        goto L23
    L22:
        r122 = "bg_usage_abnormal";
        goto L14
    L12:
        if (r4 <= r15) goto L15;
        r122 = "total_usage_abnormal";
        goto L14
    }

    @Override // com.bytedance.apm.a0.a
    protected long n() {
        return 600000;
    }

    @Override // com.bytedance.apm.a0.a, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onBackground(Activity r1) {
        super.onBackground(r1);
        this.s.k(true);
    }

    @Override // com.bytedance.apm.a0.a, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onFront(Activity r1) {
        super.onFront(r1);
        t = "bg_ever_front";
        this.s.k(false);
    }
}
