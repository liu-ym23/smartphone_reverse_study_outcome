package com.bytedance.sdk.account.settings.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.account.impl.g;
import com.ss.android.i.j;
import d.b.s.a.l0.m;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    @NonNull
    private static com.bytedance.sdk.account.settings.e.a A;
    private static int B;
    private static boolean C;
    private static String D;
    public static boolean E;
    private static boolean F;
    private static boolean G;
    private static String H;
    private static int I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static JSONObject f5735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static JSONObject f5736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f5737c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m f5738d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final m f5739e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final m f5740f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final m f5741g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final m f5742h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final m f5743i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final m f5744j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final m f5745k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final m f5746l = null;
    public static final m m = null;
    private static boolean n;
    private static boolean o;
    private static boolean p;
    private static boolean q;
    private static boolean r;
    private static boolean s;
    private static boolean t;
    private static boolean u;
    private static boolean v;
    private static boolean w;
    private static int x;
    public static boolean y;
    public static boolean z;

    static {
        f5738d = new m(null, true);
        f5739e = new m(null, false);
        f5740f = new m(null, true);
        f5741g = new m(null, true);
        f5742h = new m(null, false);
        f5743i = new m(null, true);
        f5744j = new m(null, true);
        f5745k = new m(null, false);
        f5746l = new m(null, true);
        m = new m(null, true);
        n = false;
        o = false;
        p = false;
        q = false;
        r = false;
        s = false;
        t = true;
        u = false;
        v = false;
        w = false;
        x = 1;
        y = false;
        z = true;
        A = com.bytedance.sdk.account.settings.e.a.c();
        B = 0;
        C = false;
        D = null;
        E = true;
        F = false;
        G = false;
        H = "--,.";
        I = 1;
    }

    private static boolean A(@NonNull String r2, m r3, m r4, m r5) {
        if (r5 == null) goto L8;
        if (r5.b().contains(r2) == false) goto L8;
        return false;
    L8:
        if (r3 != null) goto L10;
    L12:
        if (r4 == null) goto L21;
        Iterator<String> r6 = r4.b().iterator();
    L15:
        if (r6.hasNext() == false) goto L21;
        String r7 = r6.next();
        if (TextUtils.isEmpty(r2) == true) goto L15;
        if (r2.startsWith(r7) == false) goto L15;
        return true;
    L21:
        return false;
    L10:
        if (r3.b().contains(r2) == false) goto L12;
        return true;
    }

    public static boolean B(String r3) {
        return A(r3, f5741g, f5742h, f5743i);
    }

    public static boolean C(String r3) {
        return A(r3, f5744j, f5745k, f5746l);
    }

    public static boolean D(String r2) {
        return A(r2, m, null, null);
    }

    private static boolean a() {
        JSONObject r0 = c();
        if (f5735a == r0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L11;
        f5735a = r0;
        d.b.s.a.a0.a.a("CommonConfigManager", "common config settings = " + f5735a);
        JSONObject r2 = f5735a;
        if (r2 == null) goto L10;
        n = r2.optBoolean("enable_passport_full_path_track", false);
        o = f5735a.optBoolean("enable_net_request_monitor", false);
        f5738d.h(f5735a.optJSONArray("net_request_monitor_path"));
        f5739e.h(f5735a.optJSONArray("net_request_monitor_path_prefix"));
        f5740f.h(f5735a.optJSONArray("net_request_monitor_path_exclude"));
        p = f5735a.optBoolean("enable_request_retry_interceptor", false);
        f5741g.h(f5735a.optJSONArray("request_retry_interceptor_path"));
        f5742h.h(f5735a.optJSONArray("request_retry_interceptor_path_prefix"));
        f5743i.h(f5735a.optJSONArray("request_retry_interceptor_path_exclude"));
        q = f5735a.optBoolean("enable_request_retry_monitor", false);
        f5744j.h(f5735a.optJSONArray("request_retry_monitor_path"));
        f5745k.h(f5735a.optJSONArray("request_retry_monitor_path_prefix"));
        f5746l.h(f5735a.optJSONArray("request_retry_monitor_path_exclude"));
        r = f5735a.optBoolean("user_mix_enable_same_token_check", false);
        s = f5735a.optBoolean("user_mix_enable_info_reveal", false);
        t = f5735a.optBoolean("user_mix_enable_reveal_condition_filter", true);
        u = f5735a.optBoolean("user_mix_enable_stat_sync_reveal", false);
        v = f5735a.optBoolean("bd_account_uid_str_replace", false);
        m.h(f5735a.optJSONArray("user_mix_stat_sync_reveal_paths"));
        w = f5735a.optBoolean("enable_group_one_login_opt", false);
        f5735a.optBoolean("enable_group_one_login_pre_get_token", false);
        x = f5735a.optInt("common_request_parse_user_info_decision", 1);
        y = f5735a.optBoolean("enable_header_sessionid", false);
        f5735a.optBoolean("enable_third_party_bind_csrf_opt", false);
        A = com.bytedance.sdk.account.settings.e.a.a(f5735a.optJSONObject("request_use_cellular_config"));
        f5736b = f5735a.optJSONObject("error_code_transfer");
        z = f5735a.optBoolean("enable_account_badger", true);
        f5735a.optBoolean("enable_xaccount_inject_network_service", true);
        B = f5735a.optInt("device_transfer_logout_strategy", 0);
        C = f5735a.optBoolean("header_mix_monitor", false);
        D = f5735a.optString("header_mix_monitor_match_template", f5737c);
        E = f5735a.optBoolean("enable_ticket_guard_network_delegate", true);
        F = f5735a.optBoolean("enable_supplement_header_backup", false);
        G = f5735a.optBoolean("header_mix_monitor_token", false);
        H = f5735a.optString("header_mix_monitor_token_match_rule", "--,.");
        I = f5735a.optInt("save_platform_info_opt", 1);
        goto L11
    L10:
        n = false;
        o = false;
        f5738d.h(null);
        f5739e.h(null);
        f5740f.h(null);
        p = false;
        f5741g.h(null);
        f5742h.h(null);
        f5743i.h(null);
        q = false;
        f5744j.h(null);
        f5745k.h(null);
        f5746l.h(null);
        r = false;
        s = false;
        t = true;
        u = false;
        v = false;
        m.h(null);
        w = false;
        x = 1;
        y = false;
        A = com.bytedance.sdk.account.settings.e.a.c();
        z = true;
        f5736b = null;
        B = 0;
        C = false;
        D = f5737c;
        E = true;
        F = false;
        G = false;
        H = "--,.";
        I = 1;
    L11:
        return r1;
    L5:
        r1 = false;
        goto L6
    }

    public static int b() {
        a();
        return x;
    }

    protected static JSONObject c() {
        com.ss.android.d r0 = j.l();
        if (r0 != null) goto L5;
        return null;
    L5:
        JSONObject r1 = g.b(r0.e()).b();
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.optJSONObject("common_config");
    }

    public static JSONObject d() {
        a();
        return f5736b;
    }

    @Nullable
    public static String e() {
        a();
        return D;
    }

    @NonNull
    public static String f() {
        a();
        return H;
    }

    public static com.bytedance.sdk.account.settings.e.a g() {
        a();
        return A;
    }

    public static int h() {
        a();
        return I;
    }

    public static boolean i() {
        a();
        return v;
    }

    public static boolean j() {
        a();
        return z;
    }

    public static boolean k() {
        a();
        int r0 = B;
        if (r0 != 1) goto L5;
        return true;
    L5:
        if (r0 == 2) goto L9;
        return false;
    L9:
        return com.bytedance.sdk.account.settings.a.a().a();
    }

    public static boolean l() {
        a();
        return n;
    }

    public static boolean m() {
        a();
        return w;
    }

    public static boolean n() {
        a();
        return C;
    }

    public static boolean o() {
        a();
        return G;
    }

    public static boolean p() {
        a();
        return y;
    }

    public static boolean q() {
        a();
        return o;
    }

    public static boolean r() {
        a();
        return p;
    }

    public static boolean s() {
        a();
        return q;
    }

    public static boolean t() {
        a();
        return F;
    }

    public static boolean u() {
        a();
        return E;
    }

    public static boolean v() {
        a();
        return s;
    }

    public static boolean w() {
        a();
        return t;
    }

    public static boolean x() {
        a();
        return r;
    }

    public static boolean y() {
        a();
        return u;
    }

    public static boolean z(String r3) {
        return A(r3, f5738d, f5739e, f5740f);
    }
}
