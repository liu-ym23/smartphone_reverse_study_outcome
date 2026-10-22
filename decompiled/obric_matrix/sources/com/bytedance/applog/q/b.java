package com.bytedance.applog.q;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.applog.l;
import com.bytedance.applog.o.e;
import com.bytedance.applog.util.n;
import com.bytedance.applog.util.p;
import com.bytedance.bdlocation.client.BDLocationConfig;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f2306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l f2307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SharedPreferences f2308c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SharedPreferences f2309d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SharedPreferences f2310e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile JSONObject f2311f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile String f2312g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile JSONObject f2313h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final HashSet<String> f2314i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final HashSet<String> f2315j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile HashSet<String> f2316k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f2317l;
    private volatile com.bytedance.applog.s.a m;
    private com.bytedance.applog.y.a n;

    public b(Context r4, l r5) {
        this.f2317l = 0;
        this.f2306a = r4;
        this.f2307b = r5;
        this.f2310e = a(r4, r5.y(), 0);
        this.f2308c = a(r4, "header_custom", 0);
        this.f2309d = a(r4, "last_sp_session", 0);
        this.f2314i = new HashSet();
        this.f2315j = new HashSet();
        this.n = new com.bytedance.applog.y.a(this, p());
        if (com.bytedance.applog.a.B() == false) goto L6;
        P(com.bytedance.applog.s.c.b(this), false);
        return;
    }

    private boolean I(long r3) {
        if (r3 >= BDLocationConfig.sScanBleMaxInterval) goto L5;
    L7:
        return false;
    L5:
        if (r3 > 300000) goto L7;
        return true;
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    private HashSet<String> x() {
        HashSet<String> r0 = this.f2316k;
        if (r0 != null) goto L19;
        JSONArray r1 = new JSONArray(this.f2310e.getString("real_time_events", "[]"));     // Catch: Throwable -> L11
        int r5 = r1.length();     // Catch: Throwable -> L11
        HashSet<String> r2 = new HashSet();     // Catch: Throwable -> L11
        int r3 = 0;
    L5:
        if (r3 >= r5) goto L20;
        String r4 = r1.getString(r3);     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r4) == true) goto L9;
        r2.add(r4);     // Catch: Throwable -> L11
    L9:
        r3 = r3 + 1;
        goto L5
    L20:
        return r2;
    L11:
        th = move-exception;
        n.i(th);
        return new HashSet();
    L19:
        return r0;
    }

    public SharedPreferences A() {
        return this.f2310e;
    }

    String B() {
        return this.f2307b.z();
    }

    String C() {
        return this.f2308c.getString("user_unique_id", null);
    }

    public boolean D() {
        return this.f2310e.getBoolean("bav_ab_config", false);
    }

    public boolean E() {
        return this.f2310e.getBoolean("bav_log_collect", false);
    }

    public boolean F() {
        return this.f2307b.J();
    }

    public boolean G() {
        if (this.f2307b.u() != 0) goto L6;
        this.f2307b.U(!p.g(this.f2306a).contains(":"));
    L6:
        if (this.f2307b.u() == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean H() {
        return this.f2307b.O();
    }

    public void J(@NonNull JSONObject r5) {
        this.n.c(r5, p(), null);
        com.bytedance.applog.s.c.e(r5, this.m);
    }

    public void K(@NonNull JSONObject r5) {
        this.f2317l = r5.optLong("batch_event_interval", 0) * 1000;
        n.a("parseCommonConfigFromResp mEventIntervalFromLogResp: " + this.f2317l);
    }

    void L(JSONObject r4) {
        if (r4 != null) goto L4;
        String r5 = "";
    L6:
        if (n.f2430b == false) goto L8;
        String r0 = "setAbConfig, " + r5;
    L9:
        n.b(r0, null);
        this.f2308c.edit().putString("ab_configure", r5).apply();
        this.f2311f = null;
        return;
    L8:
        r0 = "setAbConfig";
        goto L9
    L4:
        r5 = r4.toString();
        goto L6
    }

    void M(String r2) {
        this.f2308c.edit().putString("ab_sdk_version", r2).apply();
    }

    public void N(JSONObject r18) {
        if (n.f2430b == false) goto L5;
        n.b("setConfig, " + r18.toString(), null);
    L5:
        this.f2313h = r18;
        long r4 = System.currentTimeMillis();
        SharedPreferences.Editor r2 = this.f2310e.edit();
        long r8 = r18.optInt("session_interval", 0);
        if (r8 > 0) goto L8;
    L10:
        r2.remove("session_interval");
    L11:
        long r9 = ((long) r18.optInt("batch_event_interval", 60)) * 1000;
        if (I(r9) == false) goto L14;
        r2.putLong("batch_event_interval", r9);
    L15:
        int r10 = r18.optInt("send_launch_timely", 0);
        if (r10 > 0) goto L18;
    L20:
        r2.remove("send_launch_timely");
    L21:
        long r11 = r18.optInt("abtest_fetch_interval", 0);
        if (r11 > 20) goto L24;
    L26:
        r2.remove("abtest_fetch_interval");
    L27:
        boolean r6 = r18.optBoolean("bav_log_collect", F());
        boolean r12 = true;
        if (r6 == false) goto L30;
        r2.putBoolean("bav_log_collect", true);
    L31:
        O(r6);
        if (r18.optBoolean("bav_ab_config", false) == false) goto L34;
        r2.putBoolean("bav_ab_config", true);
    L35:
        JSONArray r13 = r18.optJSONArray("real_time_events");
        if (r13 != null) goto L38;
    L40:
        r2.remove("real_time_events");
    L41:
        this.f2316k = null;
        int r3 = r18.optInt("http_monitor_port", 0);
        if (r3 <= 0) goto L44;
        r2.putInt("http_monitor_port", r3);
    L44:
        r2.putLong("app_log_last_config_time", r4);
        int r0 = r18.optInt("forbid_report_phone_detail_info", -1);
        if (r0 < 0) goto L50;
        if (r0 > 0) goto L49;
        r12 = false;
    L49:
        r2.putBoolean("forbid_report_phone_detail_info", r12);
    L50:
        long r5 = r18.optLong("fetch_interval", 21600) * 1000;
        if (r5 >= 1800000) goto L53;
    L54:
        r5 = 21600000;
    L55:
        r2.putLong("fetch_interval", r5);
        r2.putInt("content_encode_method", r18.optInt("content_encode_method", 0));
        r2.apply();
        return;
    L53:
        if (r5 <= 172800000) goto L55;
    L38:
        if (r13.length() <= 0) goto L40;
        r2.putString("real_time_events", r13.toString());
        goto L41
    L34:
        r2.remove("bav_ab_config");
        goto L35
    L30:
        r2.remove("bav_log_collect");
        goto L31
    L24:
        if (r11 > 604800) goto L26;
        r2.putLong("abtest_fetch_interval", r11 * 1000);
        goto L27
    L18:
        if (r10 > 604800) goto L20;
        r2.putInt("send_launch_timely", r10);
        goto L21
    L14:
        r2.remove("batch_event_interval");
        goto L15
    L8:
        if (r8 > 604800) goto L10;
        r2.putLong("session_interval", r8 * 1000);
        goto L11
    }

    public void O(boolean r1) {
    }

    public void P(com.bytedance.applog.s.a r1, boolean r2) {
        this.m = r1;
        if (r2 == false) goto L6;
        e.Q();
        return;
    }

    void Q(String r4) {
        n.b("setExternalAbVersion, " + r4, null);
        this.f2308c.edit().putString("external_ab_version", r4).apply();
        this.f2312g = null;
    }

    public void R(String r2, int r3) {
        this.f2309d.edit().putString("session_last_day", r2).putInt("session_order", r3).apply();
    }

    public void S(long r2) {
        this.f2309d.edit().putLong("latest_forground_session_time", r2).apply();
    }

    public void T(HashSet<String> r2, HashSet<String> r3) {
        if (r2 == null) goto L4;
        this.f2314i.addAll(r2);
    L4:
        if (r3 == null) goto L7;
        this.f2315j.addAll(r3);
        return;
    }

    public void U(com.bytedance.applog.s.b r1, int r2) {
        e.P(r1, r2);
    }

    public boolean b() {
        return this.f2307b.a();
    }

    public boolean c(ArrayList<com.bytedance.applog.w.a> r5) {
        if (r5 != null) goto L5;
    L30:
        return true;
    L5:
        if (r5.size() == 0) goto L30;
        if (this.f2314i.size() == 0) goto L10;
    L12:
        Iterator<com.bytedance.applog.w.a> r6 = r5.iterator();
    L14:
        if (r6.hasNext() == false) goto L30;
        com.bytedance.applog.w.a r1 = r6.next();
        if ((r1 instanceof com.bytedance.applog.w.c) == true) goto L17;
        if ((r1 instanceof com.bytedance.applog.w.e) == false) goto L14;
        com.bytedance.applog.w.e r2 = (com.bytedance.applog.w.e) r1;
        if (this.f2315j.contains(r2.D()) == false) goto L14;
        r6.remove();
        com.bytedance.applog.o.b.d(com.bytedance.applog.r.b.a.f2332h, com.bytedance.applog.r.b.d.f2349j);
        com.bytedance.applog.r.b.a r3 = com.bytedance.applog.r.b.a.v;
        String r4 = r2.D();
    L24:
        com.bytedance.applog.o.b.i(r3, r4);
        goto L14
    L17:
        com.bytedance.applog.w.c r7 = (com.bytedance.applog.w.c) r1;
        StringBuilder r8 = new StringBuilder();
        r8.append(r7.w);
        if (TextUtils.isEmpty(r7.x) == true) goto L20;
        String r9 = r7.x;
    L21:
        r8.append(r9);
        r4 = r8.toString();
        if (this.f2314i.contains(r4) == false) goto L14;
        r6.remove();
        com.bytedance.applog.o.b.d(com.bytedance.applog.r.b.a.f2331g, com.bytedance.applog.r.b.d.f2349j);
        r3 = com.bytedance.applog.r.b.a.v;
        goto L24
    L20:
        r9 = "";
        goto L21
    L10:
        if (this.f2315j.size() != 0) goto L12;
        return true;
    }

    public ArrayList<com.bytedance.applog.w.a> d(ArrayList<com.bytedance.applog.w.a> r5) {
        Iterator<com.bytedance.applog.w.a> r6 = r5.iterator();
        ArrayList<com.bytedance.applog.w.a> r0 = null;
    L4:
        if (r6.hasNext() == false) goto L15;
        com.bytedance.applog.w.a r1 = r6.next();
        if ((r1 instanceof com.bytedance.applog.w.e) == false) goto L4;
        com.bytedance.applog.w.e r2 = (com.bytedance.applog.w.e) r1;
        if (r2.m() == 0) goto L11;
        if (x().contains(r2.D()) == false) goto L4;
    L11:
        r6.remove();
        if (r0 != null) goto L14;
        r0 = new ArrayList();
    L14:
        r0.add(r1);
        goto L4
    L15:
        return r0;
    }

    public JSONObject e() {
        JSONObject r0 = this.f2311f;
        if (r0 != null) goto L16;
        monitor-enter(this);
        r0 = new JSONObject(this.f2308c.getString("ab_configure", ""));     // Catch: Throwable -> L7 JSONException -> L17
    L7:
        th = move-exception;
        throw th;
    L9:
        if (r0 != null) goto L11;
        r0 = new JSONObject();     // Catch: Throwable -> L7
    L11:
        this.f2311f = r0;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
    L16:
        return r0;
    }

    public long f() {
        return this.f2310e.getLong("abtest_fetch_interval", 0);
    }

    String g() {
        return this.f2308c.getString("ab_sdk_version", "");
    }

    public String h() {
        return this.f2307b.d();
    }

    public String i() {
        String r0 = this.f2307b.i();
        if (TextUtils.isEmpty(r0) == false) goto L6;
        r0 = B();
    L6:
        if (TextUtils.isEmpty(r0) == false) goto L16;
        Bundle r3 = this.f2306a.getPackageManager().getApplicationInfo(this.f2306a.getPackageName(), 128).metaData;     // Catch: Throwable -> L11
        if (TextUtils.isEmpty("UMENG_CHANNEL") == true) goto L17;
        return r3.getString("UMENG_CHANNEL");
    L17:
        return r0;
    L11:
        th = move-exception;
        n.c("getChannel", th);
        return r0;
    L16:
        return r0;
    }

    public JSONObject j() {
        return this.f2313h;
    }

    public long k() {
        return this.f2310e.getLong("fetch_interval", 21600000);
    }

    public long l() {
        return this.f2310e.getLong("app_log_last_config_time", 0);
    }

    public Context m() {
        return this.f2306a;
    }

    public com.bytedance.applog.y.a n() {
        return this.n;
    }

    public int o() {
        return this.f2310e.getInt("content_encode_method", 0);
    }

    public long p() {
        if (I(this.f2317l) == false) goto L7;
        return this.f2317l;
    L7:
        return this.f2310e.getLong("batch_event_interval", 60000);
    }

    public com.bytedance.applog.s.a q() {
        return this.m;
    }

    public com.bytedance.applog.s.b r(int r1) {
        com.bytedance.applog.s.a r0 = this.m;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.a(r1);
    }

    String s() {
        String r0 = this.f2312g;
        if (TextUtils.isEmpty(r0) == false) goto L11;
        monitor-enter(this);
        r0 = this.f2308c.getString("external_ab_version", "");     // Catch: Throwable -> L8
        this.f2312g = r0;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    L11:
        return r0;
    }

    public l t() {
        return this.f2307b;
    }

    public String u() {
        return this.f2310e.getString("channel", "");
    }

    public String v() {
        return this.f2309d.getString("session_last_day", "");
    }

    public long w() {
        return this.f2309d.getLong("latest_forground_session_time", 0);
    }

    public long y() {
        return this.f2310e.getLong("session_interval", 30000);
    }

    public int z() {
        return this.f2309d.getInt("session_order", 0);
    }
}
