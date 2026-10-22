package com.bytedance.applog.q;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.applog.util.k;
import com.bytedance.applog.util.n;
import com.bytedance.applog.util.p;
import com.bytedance.bdinstall.d1.q;
import com.bytedance.bdinstall.i0;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.wschannel.WsConstants;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.applog.n.c f2318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f2319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f2320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    private volatile JSONObject f2321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SharedPreferences f2322e;

    public c(b r1, com.bytedance.applog.n.c r2) {
        this.f2320c = r1;
        this.f2318a = r2;
        this.f2322e = r1.A();
        this.f2321d = new JSONObject();
    }

    @NonNull
    private JSONObject c() {
        return this.f2321d;
    }

    private Set<String> f(String r5) {
        HashSet r4 = new HashSet();
        if (TextUtils.isEmpty(r5) == true) goto L14;
        String[] r6 = r5.split(",");
        if (r6 == null) goto L14;
        if (r6.length <= 0) goto L14;
        int r0 = r6.length;
        int r1 = 0;
    L9:
        if (r1 >= r0) goto L14;
        String r2 = r6[r1];
        if (TextUtils.isEmpty(r2) == true) goto L13;
        r4.add(r2);
    L13:
        r1 = r1 + 1;
    L14:
        return r4;
    }

    private String g(Set<String> r2) {
        StringBuilder r1 = new StringBuilder();
        Iterator<String> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        r1.append(r3.next());
        if (r3.hasNext() == false) goto L4;
        r1.append(",");
        goto L4
    L9:
        return r1.toString();
    }

    private void n(JSONObject r4) {
        boolean r0 = k.a();
        if (r0 == false) goto L6;
        String r2 = "Harmony";
    L18:
        r4.put(WsConstants.KEY_PLATFORM, r2);     // Catch: JSONException -> L9
    L11:
        if (r0 == true) goto L20;
        return;
    L20:
        r4.put("harmony_os_api", q.a("hw_sc.build.os.apiversion"));     // Catch: Throwable -> L15
        r4.put("harmony_os_version", q.a("hw_sc.build.platform.version"));     // Catch: Throwable -> L15
        r4.put("harmony_release_type", q.a("hw_sc.build.os.releasetype"));     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        n.c("loadHarmonyInfo", th);
        return;
    L9:
        e = move-exception;
        n.c("loadHarmonyInfo", e);
        goto L11
    L6:
        r2 = LocationInfoConst.SYSTEM;
        goto L18
    }

    private void o(String r2, String r3) {
        if (this.f2320c.D() == true) goto L5;
        return;
    L5:
        if (this.f2320c.t().G() == false) goto L9;
        Set<String> r4 = f(r2);
        r4.removeAll(f(r3));
        com.bytedance.applog.util.a.g().d(g(r4), r3);
        return;
    }

    private void q(String r2) {
        if (u("ab_sdk_version", r2) == false) goto L6;
        this.f2320c.M(r2);
        return;
    }

    private synchronized void s(JSONObject r7) {
        monitor-enter(this);
        if (r7 == null) goto L28;
    L5:
        String r0 = c().optString("ab_sdk_version");     // Catch: Throwable -> L25
        if (TextUtils.isEmpty(r0) == true) goto L23;
        Set<String> r1 = f(r0);     // Catch: Throwable -> L25
        HashSet r2 = new HashSet();     // Catch: Throwable -> L25
        if (r7 == null) goto L20;
        Iterator<String> r3 = r7.keys();     // Catch: Throwable -> L25
    L11:
        if (r3.hasNext() == false) goto L20;
        String r4 = r3.next();     // Catch: Throwable -> L25
        if ((r4 instanceof String) == false) goto L11;
        String r5 = r4;     // Catch: Throwable -> L25
        if (TextUtils.isEmpty(r5) == true) goto L11;
        r2.add(r7.getJSONObject(r5).optString("vid"));     // Catch: JSONException -> L18 Throwable -> L25
    L18:
        e = move-exception;
        n.i(e);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    L20:
        String r8 = this.f2320c.s();     // Catch: Throwable -> L25
        r2.addAll(f(r8));     // Catch: Throwable -> L25
        r1.retainAll(r2);     // Catch: Throwable -> L25
        String r6 = g(r1);     // Catch: Throwable -> L25
        q(r6);     // Catch: Throwable -> L25
        if (TextUtils.equals(r0, r6) == true) goto L23;
        o(r6, r8);     // Catch: Throwable -> L25
    L23:
        monitor-exit(this);
        return;
    L28:
        n.h("null abconfig", null);     // Catch: Throwable -> L25
        goto L5
    }

    private boolean u(String r4, Object r5) {
        Object r0 = c().opt(r4);
        if (r5 != null) goto L5;
    L6:
        if (r5 != null) goto L19;
        if (r0 == null) goto L19;
    L8:
        monitor-enter(this);
        JSONObject r1 = this.f2321d;     // Catch: Throwable -> L11 JSONException -> L13
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L11 JSONException -> L13
        p.c(r2, r1);     // Catch: Throwable -> L11 JSONException -> L13
        r2.put(r4, r5);     // Catch: Throwable -> L11 JSONException -> L13
        this.f2321d = r2;     // Catch: Throwable -> L11 JSONException -> L13
    L15:
        monitor-exit(this);     // Catch: Throwable -> L11
        boolean r3 = true;
    L20:
        n.b("updateHeader, " + r4 + ", " + r0 + ", " + r5, null);
        return r3;
    L11:
        th = move-exception;
        throw th;
    L13:
        e = move-exception;
        n.i(e);     // Catch: Throwable -> L11
    L19:
        r3 = false;
        goto L20
    L5:
        if (r5.equals(r0) == false) goto L8;
        goto L6
    }

    public void a() {
        q(null);
        r("");
        p(null);
    }

    public String b() {
        return this.f2320c.g();
    }

    @Nullable
    public JSONObject d() {
        return c();
    }

    public long e() {
        return this.f2322e.getLong("version_code", 0);
    L5:
        long r1 = this.f2322e.getInt("version_code", 0);
        this.f2322e.edit().putLong("version_code", r1).apply();
        return r1;
    }

    public String h() {
        if (this.f2319b == true) goto L9;
        b r2 = this.f2320c;
        if (r2 != null) goto L8;
        return "";
    L8:
        return r2.C();
    L9:
        return c().optString("user_unique_id", "");
    }

    public long i() {
        i0 r2 = this.f2318a.c();
        if (r2 != null) goto L5;
        return 0;
    L5:
        return r2.J();
    }

    public String j() {
        i0 r0 = this.f2318a.c();
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0.I();
    }

    public boolean k() {
        if (this.f2319b == true) goto L5;
    L7:
        return false;
    L5:
        if (l() == false) goto L7;
        return true;
    }

    public boolean l() {
        return m(this.f2321d);
    }

    public boolean m(JSONObject r4) {
        if (r4 == null) goto L10;
        String r0 = r4.optString(WsConstants.KEY_DEVICE_ID, "");
        String r5 = r4.optString("install_id", "");
        if (p.a(r0) == true) goto L7;
        return false;
    L7:
        if (p.a(r5) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public void p(JSONObject r2) {
        this.f2320c.L(r2);
        s(r2);
    }

    public synchronized void r(String r4) {
        monitor-enter(this);
        Set<String> r0 = f(this.f2320c.s());     // Catch: Throwable -> L6
        Set<String> r1 = f(c().optString("ab_sdk_version"));     // Catch: Throwable -> L6
        r1.removeAll(r0);     // Catch: Throwable -> L6
        r1.addAll(f(r4));     // Catch: Throwable -> L6
        this.f2320c.Q(r4);     // Catch: Throwable -> L6
        q(g(r1));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void t(JSONObject r6) {
        n.a("updateHeader = " + r6);
        JSONObject r0 = new JSONObject();
        String r1 = com.bytedance.applog.a.e();
        monitor-enter(this);
        p.c(r0, this.f2321d);     // Catch: Throwable -> L26
        Iterator<String> r2 = r6.keys();     // Catch: Throwable -> L26
    L6:
        if (r2.hasNext() == false) goto L31;
        String r3 = r2.next();     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r3) == true) goto L6;
        r0.put(r3, r6.opt(r3));     // Catch: JSONException -> L12 Throwable -> L26
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L26
        goto L6
    L31:
        r0.put("sdk_version", 5052090);     // Catch: JSONException -> L20 Throwable -> L26
        r0.put("sdk_version_code", n.f2432d);     // Catch: JSONException -> L20 Throwable -> L26
        r0.put("sdk_version_name", "5.5.20");     // Catch: JSONException -> L20 Throwable -> L26
        if (TextUtils.isEmpty(r1) == true) goto L18;
        r0.put("ab_sdk_version", r1);     // Catch: JSONException -> L20 Throwable -> L26
    L18:
        n(r0);     // Catch: JSONException -> L20 Throwable -> L26
    L22:
        this.f2321d = r0;     // Catch: Throwable -> L26
        this.f2319b = true;     // Catch: Throwable -> L26
        monitor-exit(this);     // Catch: Throwable -> L26
        SharedPreferences.Editor r7 = this.f2322e.edit();
        r7.putLong("version_code", this.f2321d.optLong("version_code", 0));
        r7.putString("channel", this.f2321d.optString("channel", ""));
        r7.apply();
        return;
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }
}
