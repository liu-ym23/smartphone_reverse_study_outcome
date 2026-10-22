package com.bytedance.ttnet.r;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.ttnet.g;
import com.bytedance.ttnet.j.k;
import com.bytedance.ttnet.p.i;
import d.b.h.a.a.h.o.b.x.e;
import d.b.h.a.a.h.o.b.z.l;
import d.b.h.a.a.h.s.h;
import d.b.r.k0.f;
import java.util.HashMap;
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
    private Context f6582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f6583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f6585d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f6586e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f6587f;

    public b(Context r2, boolean r3) {
        this.f6585d = "";
        this.f6586e = "";
        this.f6587f = "";
        this.f6582a = r2;
        this.f6584c = r3;
        this.f6583b = new a();
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    private String f() {
        if (TextUtils.isEmpty(c.k()) == false) goto L10;
        return null;
    L10:
        String r2 = new JSONObject(c.k()).getString("data");     // Catch: JSONException -> L7
        Logger.debug();     // Catch: JSONException -> L7
        return r2;
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private void i(JSONObject r2) {
        if (com.bytedance.ttnet.j.a.s(this.f6582a).i() == true) goto L6;
        e.q().x(r2);
        p000j.l0.a.j().m(r2);
    L6:
        if (h.h(this.f6582a) == false) goto L8;
        com.bytedance.ttnet.j.c.g(r2);
        k.l().q(r2);
        i.f().j(r2);
    L8:
        g.c().d(r2);
        d.b.h.a.a.h.p.e.c(r2);
        d.b.h.a.a.b.e(r2);
        d.b.h.a.a.j.e.f().g(r2);
        f.l(r2);
        d.b.h.a.a.h.s.c.i(r2);
        d.b.h.a.a.e.a.d(r2);
        d.b.h.a.a.e.b.g(r2);
        d.b.h.a.a.h.o.b.y.c.e(r2);
    }

    private a j(JSONObject r9) {
        l.m().g().clear();     // Catch: Throwable -> L48
        JSONObject r10 = r9.optJSONObject("tnc_config");     // Catch: Throwable -> L48
        a r4 = new a();     // Catch: Throwable -> L48
        if (r10 != null) goto L6;
        return r4;
    L6:
        boolean r6 = true;
        if (r10.has("local_enable") == false) goto L14;
        if (r10.getInt("local_enable") != 0) goto L11;
        boolean r2 = false;
    L12:
        r4.f6570a = r2;     // Catch: Throwable -> L48
        goto L14
    L11:
        r2 = true;
    L14:
        if (r10.has("probe_enable") == false) goto L20;
        if (r10.getInt("probe_enable") != 0) goto L18;
        r6 = false;
    L18:
        r4.f6571b = r6;     // Catch: Throwable -> L48
    L20:
        if (r10.has("local_host_filter") == false) goto L32;
        JSONArray r0 = r10.getJSONArray("local_host_filter");     // Catch: Throwable -> L48
        HashMap r1 = new HashMap();     // Catch: Throwable -> L48
        if (r0.length() <= 0) goto L31;
        int r3 = 0;
    L25:
        if (r3 >= r0.length()) goto L31;
        String r5 = r0.getString(r3);     // Catch: Throwable -> L48
        if (TextUtils.isEmpty(r5) == true) goto L30;
        r1.put(r5, 0);     // Catch: Throwable -> L48
    L30:
        r3 = r3 + 1;     // Catch: Throwable -> L48
    L31:
        r4.f6572c = r1;     // Catch: Throwable -> L48
    L34:
        if (r10.has("host_replace_map") == false) goto L46;
        JSONObject r8 = r10.getJSONObject("host_replace_map");     // Catch: Throwable -> L48
        if (r8.length() <= 0) goto L46;
        Iterator<String> r7 = r8.keys();     // Catch: Throwable -> L48
    L39:
        if (r7.hasNext() == false) goto L46;
        String r11 = r7.next();     // Catch: Throwable -> L48
        String r12 = r8.getString(r11);     // Catch: Throwable -> L48
        if (TextUtils.isEmpty(r11) == true) goto L39;
        if (TextUtils.isEmpty(r12) == true) goto L39;
        l.m().g().put(r11, r12);     // Catch: Throwable -> L48
    L46:
        r4.f6573d = r10.optInt("req_to_cnt", r4.f6573d);     // Catch: Throwable -> L48
        r4.f6574e = r10.optInt("req_to_api_cnt", r4.f6574e);     // Catch: Throwable -> L48
        r4.f6575f = r10.optInt("req_to_ip_cnt", r4.f6575f);     // Catch: Throwable -> L48
        r4.f6576g = r10.optInt("req_err_cnt", r4.f6576g);     // Catch: Throwable -> L48
        r4.f6577h = r10.optInt("req_err_api_cnt", r4.f6577h);     // Catch: Throwable -> L48
        r4.f6578i = r10.optInt("req_err_ip_cnt", r4.f6578i);     // Catch: Throwable -> L48
        r4.f6579j = r10.optInt("update_interval", r4.f6579j);     // Catch: Throwable -> L48
        r4.f6580k = r10.optInt("update_random_range", r4.f6580k);     // Catch: Throwable -> L48
        r4.f6581l = r10.optString("http_code_black", r4.f6581l);     // Catch: Throwable -> L48
        return r4;
    L32:
        r4.f6572c = null;     // Catch: Throwable -> L48
    L48:
        return null;
    }

    public String b() {
        return this.f6585d;
    }

    public String c() {
        return this.f6586e;
    }

    public a d() {
        return this.f6583b;
    }

    public boolean e(Object r17, c.d r18, String r19, String r20, long r21) {
        Logger.debug();
        if (this.f6584c == true) goto L6;
        Logger.debug();
        return false;
    L6:
        JSONObject r8 = com.bytedance.ttnet.j.e.f(r17);
        l.m().p(r8, r18.f6608f, r19, this.f6587f, r21);
        i(r8);
        a r6 = j(r8);     // Catch: Throwable -> L39
        if (Logger.debug() == false) goto L14;
        StringBuilder r7 = new StringBuilder();     // Catch: Throwable -> L39
        r7.append("handleConfigChanged, newConfig: ");     // Catch: Throwable -> L39
        if (r6 != null) goto L12;
        String r2 = "null";
    L13:
        r7.append(r2);     // Catch: Throwable -> L39
        Logger.d("TNCConfigHandler", r7.toString());     // Catch: Throwable -> L39
        goto L14
    L12:
        r2 = r6.toString();     // Catch: Throwable -> L39
    L14:
        if (r6 != null) goto L23;
        SharedPreferences.Editor r0 = a(this.f6582a, "ttnet_tnc_config", 0).edit();
        r0.putBoolean("is_full_config", false);
        r0.putString("tnc_config_str", "").apply();
        com.bytedance.ttnet.s.b.c(this.f6582a, 7, com.bytedance.ttnet.s.b.a(false));
        com.bytedance.ttnet.s.b.c(this.f6582a, 4, "");
        if (TextUtils.isEmpty(r19) == true) goto L19;
        r0.putString("ttnet_tnc_etag", r19).apply();
        com.bytedance.ttnet.s.b.c(this.f6582a, 5, r19);
    L19:
        if (TextUtils.isEmpty(this.f6587f) == false) goto L21;
        this.f6587f = "";
    L21:
        r0.putString("ttnet_tnc_abtest", this.f6587f).apply();
        com.bytedance.ttnet.s.b.c(this.f6582a, 6, this.f6587f);
        return false;
    L23:
        String r9 = "ttnet_tnc_abtest";
        this.f6583b = r6;     // Catch: Throwable -> L59
        if ((r17 instanceof com.bytedance.ttnet.j.e.b) == true) goto L66;
        String r1 = r8.toString();     // Catch: Throwable -> L59
        boolean r3 = false;
    L31:
        SharedPreferences.Editor r10 = a(this.f6582a, "ttnet_tnc_config", 0).edit();
        r10.putBoolean("is_full_config", r3);
        r10.putString("tnc_config_str", r1).apply();
        com.bytedance.ttnet.s.b.c(this.f6582a, 7, com.bytedance.ttnet.s.b.a(r3));
        com.bytedance.ttnet.s.b.c(this.f6582a, 4, r1);
        if (TextUtils.isEmpty(r19) == true) goto L35;
        r10.putString("ttnet_tnc_etag", r19).apply();
        com.bytedance.ttnet.s.b.c(this.f6582a, 5, r19);
    L35:
        if (TextUtils.isEmpty(this.f6587f) == false) goto L37;
        this.f6587f = "";
    L37:
        r10.putString(r9, this.f6587f).apply();
        com.bytedance.ttnet.s.b.c(this.f6582a, 6, this.f6587f);
        return true;
    L66:
        r1 = ((com.bytedance.ttnet.j.e.b) r17).c();     // Catch: Throwable -> L28
        r3 = true;
    L28:
        boolean r4 = true;
    L60:
        this.f6583b = new a();     // Catch: Throwable -> L50
        SharedPreferences.Editor r5 = a(this.f6582a, "ttnet_tnc_config", 0).edit();
        r5.putBoolean("is_full_config", r4);
        r5.putString("tnc_config_str", "").apply();
        com.bytedance.ttnet.s.b.c(this.f6582a, 7, com.bytedance.ttnet.s.b.a(r4));
        com.bytedance.ttnet.s.b.c(this.f6582a, 4, "");
        if (TextUtils.isEmpty(r19) == true) goto L46;
        r5.putString("ttnet_tnc_etag", r19).apply();
        com.bytedance.ttnet.s.b.c(this.f6582a, 5, r19);
    L46:
        if (TextUtils.isEmpty(this.f6587f) == false) goto L48;
        this.f6587f = "";
    L48:
        r5.putString(r9, this.f6587f).apply();
        com.bytedance.ttnet.s.b.c(this.f6582a, 6, this.f6587f);
        return false;
    L50:
        th = move-exception;
        SharedPreferences.Editor r11 = a(this.f6582a, "ttnet_tnc_config", 0).edit();
        r11.putBoolean("is_full_config", r4);
        r11.putString("tnc_config_str", "").apply();
        com.bytedance.ttnet.s.b.c(this.f6582a, 7, com.bytedance.ttnet.s.b.a(r4));
        com.bytedance.ttnet.s.b.c(this.f6582a, 4, "");
        if (TextUtils.isEmpty(r19) == true) goto L55;
        r11.putString("ttnet_tnc_etag", r19).apply();
        com.bytedance.ttnet.s.b.c(this.f6582a, 5, r19);
    L55:
        if (TextUtils.isEmpty(this.f6587f) == false) goto L57;
        this.f6587f = "";
    L57:
        r11.putString(r9, this.f6587f).apply();
        com.bytedance.ttnet.s.b.c(this.f6582a, 6, this.f6587f);
        throw th;
    L40:
        r4 = false;
    L39:
        r9 = "ttnet_tnc_abtest";
        goto L40
    }

    public void g(long r14) {
        Logger.debug();
        if (this.f6584c == true) goto L5;
        return;
    L5:
        boolean r2 = false;
        SharedPreferences r0 = a(this.f6582a, "ttnet_tnc_config", 0);
        boolean r1 = r0.getBoolean("is_full_config", false);
        String r3 = r0.getString("tnc_config_str", null);
        String r9 = r0.getString("ttnet_tnc_etag", null);
        String r10 = r0.getString("ttnet_tnc_abtest", null);
        if (TextUtils.isEmpty(r3) == false) goto L11;
        r3 = f();
        if (TextUtils.isEmpty(r3) == false) goto L30;
        Logger.debug();
        return;
    L30:
        JSONObject r4 = new JSONObject(r3);     // Catch: Throwable -> L28
        if (r2 == false) goto L17;
        JSONObject r5 = r4.optJSONObject("data");     // Catch: Throwable -> L28
        if (r5 == null) goto L17;
        r4 = r5;
    L17:
        JSONObject r7 = r4;
        l.m().p(r7, c.d.f6604i.f6608f, r9, r10, r14);     // Catch: Throwable -> L28
        i(r4);     // Catch: Throwable -> L28
        a r15 = j(r4);     // Catch: Throwable -> L28
        if (r15 == null) goto L21;
        this.f6583b = r15;     // Catch: Throwable -> L28
    L21:
        if (Logger.debug() == false) goto L32;
        StringBuilder r16 = new StringBuilder();     // Catch: Throwable -> L28
        r16.append("loadLocalConfig: ");     // Catch: Throwable -> L28
        if (r15 != null) goto L25;
        String r17 = "null";
    L26:
        r16.append(r17);     // Catch: Throwable -> L28
        Logger.d("TNCConfigHandler", r16.toString());     // Catch: Throwable -> L28
        return;
    L25:
        r17 = r15.toString();     // Catch: Throwable -> L28
        goto L26
    L32:
        return;
    L28:
        Logger.debug();
        return;
    L11:
        r2 = r1;
        goto L30
    }

    public void h(long r11) {
        boolean r0 = com.bytedance.ttnet.s.b.d(com.bytedance.ttnet.s.b.b(this.f6582a, 7));     // Catch: Throwable -> L23
        String r1 = com.bytedance.ttnet.s.b.b(this.f6582a, 4);     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r1) == false) goto L8;
        r0 = false;
        r1 = f();     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r1) == false) goto L8;
        Logger.debug();     // Catch: Throwable -> L23
        return;
    L8:
        JSONObject r2 = new JSONObject(r1);     // Catch: Throwable -> L23
        if (r0 == false) goto L13;
        JSONObject r3 = r2.optJSONObject("data");     // Catch: Throwable -> L23
        if (r3 == null) goto L13;
        r2 = r3;
    L13:
        a r4 = j(r2);     // Catch: Throwable -> L23
        String r6 = com.bytedance.ttnet.s.b.b(this.f6582a, 5);     // Catch: Throwable -> L23
        String r7 = com.bytedance.ttnet.s.b.b(this.f6582a, 6);     // Catch: Throwable -> L23
        JSONObject r5 = r2;
        l.m().p(r5, c.d.f6604i.f6608f, r6, r7, r11);     // Catch: Throwable -> L23
        i(r2);     // Catch: Throwable -> L23
        if (Logger.debug() == false) goto L20;
        StringBuilder r12 = new StringBuilder();     // Catch: Throwable -> L23
        r12.append("loadLocalConfigForOtherProcess, config: ");     // Catch: Throwable -> L23
        if (r4 != null) goto L18;
        String r8 = "null";
    L19:
        r12.append(r8);     // Catch: Throwable -> L23
        Logger.d("TNCConfigHandler", r12.toString());     // Catch: Throwable -> L23
        goto L20
    L18:
        r8 = r4.toString();     // Catch: Throwable -> L23
    L20:
        if (r4 == null) goto L26;
        this.f6583b = r4;     // Catch: Throwable -> L23
        return;
    L26:
        return;
    L23:
        Logger.debug();
    }

    public void k(String r1) {
        this.f6587f = r1;
        l.m().t(r1);
    }
}
