package com.bytedance.sdk.account.ticketguard;

import androidx.annotation.NonNull;
import com.ss.android.i.j;
import com.ss.android.token.n;
import d.b.s.a.l0.m;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f {
    public static final m A = null;
    public static final m B = null;
    public static final m C = null;
    public static final m D = null;
    private static boolean E;
    public static final m F = null;
    public static final m G = null;
    public static final m H = null;
    public static final m I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final m f5783J = null;
    public static final m K = null;
    public static final m L = null;
    public static final m M = null;
    public static boolean N;
    public static boolean O;
    public static final g P = null;
    private static volatile g Q;
    public static final m R = null;
    public static final m S = null;
    public static final m T = null;
    public static final m U = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static JSONObject f5784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f5785b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f5786c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m f5787d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final m f5788e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f5789f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile boolean f5790g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile boolean f5791h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f5792i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static boolean f5793j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static boolean f5794k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static volatile boolean f5795l;
    private static volatile boolean m;
    private static int n;
    private static boolean o;
    private static boolean p;
    private static long q;
    private static boolean r;
    private static long s;
    private static long t;
    private static boolean u;
    private static long v;
    private static final HashSet<String> w = null;
    public static final m x = null;
    public static final m y = null;
    public static final m z = null;

    static {
        f5785b = new m(new HashSet(), true);
        f5786c = new m(new HashSet(Arrays.asList(new String[]{"/passport/"})), false);
        f5787d = new m(new HashSet(), true);
        f5788e = new m(new HashSet(), false);
        f5789f = "<default>";
        f5790g = false;
        f5791h = f5790g;
        f5792i = false;
        f5793j = false;
        f5794k = false;
        f5795l = false;
        m = f5795l;
        n = 1000;
        o = false;
        p = true;
        q = 540;
        r = true;
        s = -1;
        t = 30;
        u = false;
        v = 1800;
        HashSet<String> r0 = new HashSet(Arrays.asList(new String[]{"/passport/account/info/v2/", "/passport/token/beat/v2/"}));
        w = r0;
        x = new m(r0, true);
        y = new m(null, false);
        z = new m(null, true);
        A = new m(null, false);
        B = new m(null, true);
        C = new m(null, true);
        D = new m(null, false);
        E = false;
        F = new m(r0, true);
        G = new m(null, false);
        H = new m(null, true);
        I = new m(null, false);
        f5783J = new m(r0, true);
        K = new m(null, false);
        L = new m(null, true);
        M = new m(null, false);
        N = false;
        O = false;
        g r1 = new g();
        P = r1;
        Q = r1;
        R = new m(r0, true);
        S = new m(null, false);
        T = new m(null, true);
        U = new m(null, false);
    }

    private static boolean A(@NonNull String r1, m r2, m r3, m r4, m r5) {
        if (r4.b().contains(r1) == false) goto L5;
        return false;
    L5:
        Iterator<String> r6 = r5.b().iterator();
    L7:
        if (r6.hasNext() == false) goto L12;
        if (r1.startsWith(r6.next()) == false) goto L7;
        return false;
    L12:
        if (r2.b().contains(r1) == false) goto L14;
        return true;
    L14:
        Iterator<String> r7 = r3.b().iterator();
    L16:
        if (r7.hasNext() == false) goto L20;
        if (r1.startsWith(r7.next()) == false) goto L16;
        return true;
    L20:
        return false;
    }

    private static boolean a() {
        JSONObject r0 = h();
        if (f5784a == r0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L11;
        f5784a = r0;
        d.b.s.a.a0.a.a("TokenGuardSettingManage", "settings=" + f5784a);
        JSONObject r2 = f5784a;
        if (r2 == null) goto L10;
        f5789f = r2.optString("config_version", "<no version>");
        x.h(f5784a.optJSONArray("token_guard_paths"));
        y.h(f5784a.optJSONArray("token_guard_path_prefix"));
        z.h(f5784a.optJSONArray("exclude_token_guard_paths"));
        A.h(f5784a.optJSONArray("exclude_token_guard_path_prefix"));
        f5791h = f5784a.optBoolean("enable_token_guard", f5790g);
        B.h(f5784a.optJSONArray("exclude_get_token_domains"));
        C.h(f5784a.optJSONArray("exclude_get_token_paths"));
        D.h(f5784a.optJSONArray("exclude_get_token_prefix"));
        f5792i = f5784a.optBoolean("enable_full_path_track", false);
        f5793j = f5784a.optBoolean("enable_token_launch", false);
        f5794k = f5784a.optBoolean("enable_waiting_init", false);
        n = f5784a.optInt("waiting_timeout", 1000);
        m = f5784a.optBoolean("enable_temp_fallback_config", f5795l);
        E = f5784a.optBoolean("use_tee_ree_config", false);
        F.h(f5784a.optJSONArray("tee_token_guard_paths"));
        G.h(f5784a.optJSONArray("tee_token_guard_path_prefix"));
        H.h(f5784a.optJSONArray("tee_exclude_token_guard_paths"));
        I.h(f5784a.optJSONArray("tee_exclude_token_guard_path_prefix"));
        f5783J.h(f5784a.optJSONArray("ree_token_guard_paths"));
        K.h(f5784a.optJSONArray("ree_token_guard_path_prefix"));
        L.h(f5784a.optJSONArray("ree_exclude_token_guard_paths"));
        M.h(f5784a.optJSONArray("ree_exclude_token_guard_path_prefix"));
        N = f5784a.optBoolean("enable_symmetric_encryption", false);
        R.h(f5784a.optJSONArray("symmetric_encryption_path"));
        S.h(f5784a.optJSONArray("symmetric_encryption_prefix_path"));
        T.h(f5784a.optJSONArray("symmetric_encryption_exclude_path"));
        U.h(f5784a.optJSONArray("symmetric_encryption_exclude_prefix_path"));
        O = f5784a.optBoolean("ree_hmac_use_standardized_algorithm", false);
        f5784a.optBoolean("token_guard_get_time_with_loose_mode", false);
        o = f5784a.optBoolean("token_guard_get_time_with_hibernate_detection", false);
        p = f5784a.optBoolean("enable_ts_sign_compensate_fix", true);
        Q = g.i(f5784a.optJSONObject("token_guard_init_opt_config"), P);
        u = f5784a.optBoolean("enable_attest_sign", false);
        f5785b.h(f5784a.optJSONArray("attest_sign_path"));
        f5786c.h(f5784a.optJSONArray("attest_sign_path_prefix"));
        f5787d.h(f5784a.optJSONArray("attest_sign_exclude_path"));
        f5788e.h(f5784a.optJSONArray("attest_sign_exclude_path_prefix"));
        v = f5784a.optLong("sec_time_refresh_window", 1800);
        q = f5784a.optLong("attest_sign_min_refresh_interval", 540);
        r = f5784a.optBoolean("enable_sec_time_timestamp", true);
        s = f5784a.optLong("token_guard_get_time_periodic_execute_interval_seconds", -1);
        t = f5784a.optLong("sec_time_request_min_interval", 30);
        goto L11
    L10:
        f5789f = "<default>";
        x.h(null);
        y.h(null);
        z.h(null);
        A.h(null);
        f5791h = f5790g;
        B.h(null);
        C.h(null);
        D.h(null);
        f5792i = false;
        f5793j = false;
        f5794k = false;
        n = 1000;
        m = f5795l;
        E = false;
        F.h(null);
        G.h(null);
        H.h(null);
        I.h(null);
        f5783J.h(null);
        K.h(null);
        L.h(null);
        M.h(null);
        N = false;
        R.h(null);
        S.h(null);
        T.h(null);
        U.h(null);
        O = false;
        o = false;
        p = true;
        Q = P;
        u = false;
        f5785b.h(null);
        f5786c.h(null);
        f5787d.h(null);
        f5788e.h(null);
        v = 1800;
        q = 540;
        r = true;
        s = -1;
        t = 30;
    L11:
        return r1;
    L5:
        r1 = false;
        goto L6
    }

    public static long b() {
        a();
        return q;
    }

    public static String c() {
        return String.valueOf(f5784a);
    }

    public static String d() {
        return f5789f;
    }

    public static long e() {
        a();
        return s;
    }

    public static long f() {
        a();
        return v;
    }

    public static long g() {
        a();
        return t;
    }

    private static JSONObject h() {
        com.ss.android.d r0 = j.l();
        if (r0 != null) goto L5;
        return null;
    L5:
        JSONObject r1 = com.bytedance.sdk.account.impl.g.b(r0.e()).b();
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.optJSONObject("token_guard_config");
    }

    public static int i(@NonNull String r7) {
        a();
        if (E == false) goto L9;
        boolean r0 = A(r7, F, G, H, I);
        if (A(r7, f5783J, K, L, M) == false) goto L7;
        boolean r8 = true;
    L13:
        if (r0 == false) goto L17;
        if (r8 == false) goto L17;
        return 3;
    L17:
        if (r0 == false) goto L19;
        return 1;
    L19:
        if (r8 == false) goto L22;
        return 2;
    L22:
        return 0;
    L7:
        r8 = false;
        goto L13
    L9:
        if (A(r7, x, y, z, A) == false) goto L11;
        r8 = true;
    L12:
        r0 = r8;
        goto L13
    L11:
        r8 = false;
        goto L12
    }

    public static g j() {
        a();
        return Q;
    }

    public static int k() {
        a();
        return n;
    }

    public static void l() {
        if (a() == false) goto L6;
        n.k();
        return;
    }

    public static boolean m() {
        a();
        return u;
    }

    public static boolean n() {
        a();
        return f5792i;
    }

    public static boolean o() {
        a();
        return r;
    }

    public static boolean p() {
        a();
        return O;
    }

    public static boolean q() {
        a();
        return N;
    }

    public static boolean r() {
        a();
        return m;
    }

    public static boolean s() {
        a();
        return f5791h;
    }

    public static boolean t() {
        a();
        return f5793j;
    }

    public static boolean u() {
        a();
        return p;
    }

    public static boolean v() {
        a();
        return f5794k;
    }

    public static boolean w() {
        a();
        return o;
    }

    public static boolean x(String r3, String r4) {
        d.b.s.a.a0.a.a("TokenGuardSettingManage", "isPathGetToken: domain=" + r3 + ", path=" + r4);
        a();
        if (B.b().contains(r3) == false) goto L8;
        String r5 = "isPathGetToken: exclude domain";
    L5:
        d.b.s.a.a0.a.a("TokenGuardSettingManage", r5);
        return false;
    L8:
        if (C.b().contains(r4) == false) goto L10;
        r5 = "isPathGetToken: exclude paths";
        goto L5
    L10:
        Iterator<String> r6 = D.b().iterator();
    L12:
        if (r6.hasNext() == false) goto L16;
        if (r4.startsWith(r6.next()) == false) goto L12;
        r5 = "isPathGetToken: exclude prefix";
        goto L5
    L16:
        return true;
    }

    public static boolean y(@NonNull String r4) {
        a();
        return A(r4, f5785b, f5786c, f5787d, f5788e);
    }

    public static boolean z(@NonNull String r4) {
        a();
        return A(r4, R, S, T, U);
    }
}
