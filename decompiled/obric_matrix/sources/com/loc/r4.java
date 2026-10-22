package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.ss.ttuploader.TTVideoUploader;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class r4 {
    private static boolean A = false;
    private static String B = null;
    private static long C = 0;
    public static boolean D = false;
    public static boolean E = false;
    public static int F = 0;
    public static int G = 0;
    public static boolean H = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f7730a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f7731b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f7732c = 1000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f7733d = 200;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f7734e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f7735f = 20;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int f7736g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile int f7737h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile boolean f7738i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static boolean f7739j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static long f7740k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static boolean f7741l;
    private static double m;
    private static boolean n;
    private static int o;
    private static int p;
    static long q;
    private static boolean r;
    private static boolean s;
    static boolean t;
    private static boolean u;
    private static long v;
    private static boolean w;
    private static int x;
    private static boolean y;
    private static int z;

    final class a implements j5.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f7742a;

        a(Context r1) {
            this.f7742a = r1;
        }

        @Override // com.loc.j5.b
        public final void a(j5.c r1) {
            r4.g(this.f7742a, r1);
        }
    }

    static {
        new ArrayList();
        new ArrayList();
        f7738i = false;
        f7739j = true;
        f7740k = 300000;
        f7741l = false;
        m = 0.618d;
        n = true;
        o = 80;
        p = 5;
        q = 3600000;
        r = true;
        s = false;
        t = false;
        u = true;
        v = -1;
        w = true;
        x = 1;
        y = false;
        z = 5;
        A = false;
        B = "CMjAzLjEwNy4xLjEvMTU0MDgxL2Q";
        C = 0;
        D = false;
        E = false;
        F = 20480;
        G = 10800000;
        H = false;
    }

    public static int A() {
        return p;
    }

    public static boolean B() {
        return r;
    }

    public static boolean C() {
        return s;
    }

    public static boolean D() {
        return t;
    }

    public static boolean E() {
        return u;
    }

    public static long F() {
        return v;
    }

    public static boolean G() {
        return A;
    }

    public static boolean H() {
        return y;
    }

    public static String I() {
        return u5.u(B);
    }

    public static boolean J() {
        if (w == true) goto L5;
        return false;
    L5:
        if (x <= 0) goto L10;
        return true;
    L10:
        return false;
    }

    public static int K() {
        return x;
    }

    public static long L() {
        return C;
    }

    public static void a(Context r3) {
        if (f7730a == false) goto L5;
        return;
    L5:
        f7730a = true;
        j5.g(r3, s4.q(), s4.s(), new a(r3));
    }

    private static void b(Context r5, JSONObject r6, SharedPreferences.Editor r7) {
        JSONObject r8 = r6.optJSONObject("13S");     // Catch: Throwable -> L23
        if (r8 == null) goto L38;
        long r2 = (r8.optInt("at", 123) * 60) * 1000;     // Catch: Throwable -> L7
        q = r2;     // Catch: Throwable -> L7
        z4.j(r7, "13S_at", r2);     // Catch: Throwable -> L7
    L9:
        q(r8, r7);     // Catch: Throwable -> L23
        boolean r3 = j5.v(r8.optString("nla"), true);     // Catch: Throwable -> L26
        r = r3;     // Catch: Throwable -> L26
        z4.l(r7, "13S_nla", r3);     // Catch: Throwable -> L26
    L34:
        boolean r1 = j5.v(r8.optString("asw"), true);     // Catch: Throwable -> L27
        u = r1;     // Catch: Throwable -> L27
        z4.l(r7, "asw", r1);     // Catch: Throwable -> L27
    L31:
        JSONArray r9 = r8.optJSONArray("mlpl");     // Catch: Throwable -> L28
        if (r9 != null) goto L17;
    L21:
        s = false;     // Catch: Throwable -> L28
        z4.h(r7, "13S_mlpl");     // Catch: Throwable -> L28
        return;
    L17:
        if (r9.length() <= 0) goto L21;
        if (r5 == null) goto L21;
        z4.k(r7, "13S_mlpl", u5.q(r9.toString()));     // Catch: Throwable -> L28
        s = h(r5, r9);     // Catch: Throwable -> L28
        return;
    L39:
        return;
    L7:
        th = move-exception;
        s4.h(th, "AuthUtil", "requestSdkAuthInterval");     // Catch: Throwable -> L23
        goto L9
    L38:
        return;
    L23:
        th = move-exception;
        s4.h(th, "AuthUtil", "loadConfigAbleStatus");
    }

    private static void c(j5.c r9, SharedPreferences.Editor r10) {
        j5.c.a r11 = r9.f7442e;     // Catch: Throwable -> L16
        if (r11 == null) goto L21;
        boolean r0 = r11.f7445a;     // Catch: Throwable -> L16
        f7731b = r0;     // Catch: Throwable -> L16
        z4.l(r10, "exception", r0);     // Catch: Throwable -> L16
        JSONObject r12 = r11.f7446b;     // Catch: Throwable -> L16
        if (r12 == null) goto L14;
        f7732c = r12.optInt("fn", f7732c);     // Catch: Throwable -> L16
        int r6 = r12.optInt("mpn", f7733d);     // Catch: Throwable -> L16
        f7733d = r6;     // Catch: Throwable -> L16
        if (r6 <= 500) goto L11;
        f7733d = 500;     // Catch: Throwable -> L16
    L11:
        if (f7733d >= 30) goto L13;
        f7733d = 30;     // Catch: Throwable -> L16
    L13:
        f7734e = j5.v(r12.optString("igu"), false);     // Catch: Throwable -> L16
        f7735f = r12.optInt("ms", f7735f);     // Catch: Throwable -> L16
        f7737h = r12.optInt("rot", 0);     // Catch: Throwable -> L16
        f7736g = r12.optInt("pms", 0);     // Catch: Throwable -> L16
    L14:
        y0.b(f7732c, f7734e, f7735f, f7736g);     // Catch: Throwable -> L16
        a1.f(f7734e, f7736g);     // Catch: Throwable -> L16
        z4.i(r10, "fn", f7732c);     // Catch: Throwable -> L16
        z4.i(r10, "mpn", f7733d);     // Catch: Throwable -> L16
        z4.l(r10, "igu", f7734e);     // Catch: Throwable -> L16
        z4.i(r10, "ms", f7735f);     // Catch: Throwable -> L16
        z4.i(r10, "rot", f7737h);     // Catch: Throwable -> L16
        z4.i(r10, "pms", f7736g);     // Catch: Throwable -> L16
        return;
    L21:
        return;
    L16:
        th = move-exception;
        s4.h(th, "AuthUtil", "loadConfigDataUploadException");
    }

    private static void d(JSONObject r7, SharedPreferences.Editor r8) {
        JSONObject r9 = r7.optJSONObject("11G");     // Catch: Throwable -> L9
        if (r9 == null) goto L14;
        boolean r0 = j5.v(r9.optString("able"), true);     // Catch: Throwable -> L9
        f7739j = r0;     // Catch: Throwable -> L9
        if (r0 == false) goto L7;
        f7740k = r9.optInt("c", TTVideoUploader.KeyIsGetTosKey) * 1000;     // Catch: Throwable -> L9
    L7:
        f7741l = j5.v(r9.optString("fa"), false);     // Catch: Throwable -> L9
        m = Math.min(1.0d, Math.max(0.2d, r9.optDouble("ms", 0.618d)));     // Catch: Throwable -> L9
        z4.l(r8, "ca", f7739j);     // Catch: Throwable -> L9
        z4.j(r8, "ct", f7740k);     // Catch: Throwable -> L9
        z4.l(r8, "11G_fa", f7741l);     // Catch: Throwable -> L9
        z4.k(r8, "11G_ms", String.valueOf(m));     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        th = move-exception;
        s4.h(th, "AuthUtil", "loadConfigDataCacheAble");
    }

    public static boolean e() {
        return f7731b;
    }

    public static boolean f(long r6) {
        if (f7739j == true) goto L5;
        return false;
    L5:
        long r2 = a5.f() - r6;
        long r7 = f7740k;
        if (r7 >= 0) goto L8;
        return true;
    L8:
        if (r2 < r7) goto L13;
        return false;
    L13:
        return true;
    }

    static boolean g(Context r2, j5.c r3) {
        SharedPreferences.Editor r0 = z4.d(r2, "pref");     // Catch: Throwable -> L13
        c(r3, r0);     // Catch: Throwable -> L20
        m(r2);     // Catch: Throwable -> L20
        JSONObject r4 = r3.f7441d;     // Catch: Throwable -> L20
        if (r4 != null) goto L9;
        if (r0 != null) goto L22;
    L8:
        return true;
    L22:
        z4.g(r0);     // Catch: Throwable -> L18
        goto L8
    L9:
        b(r2, r4, r0);     // Catch: Throwable -> L20
        d(r4, r0);     // Catch: Throwable -> L20
        p(r4, r0);     // Catch: Throwable -> L20
        s(r4, r0);     // Catch: Throwable -> L20
        w(r4, r0);     // Catch: Throwable -> L20
        v(r4, r0);     // Catch: Throwable -> L20
        z(r4, r0);     // Catch: Throwable -> L20
        k(r4, r0);     // Catch: Throwable -> L20
        n(r4, r0);     // Catch: Throwable -> L20
        if (r0 != null) goto L24;
    L12:
        return true;
    L24:
        z4.g(r0);     // Catch: Throwable -> L19
    L14:
        if (r0 == null) goto L32;
        z4.g(r0);     // Catch: Throwable -> L21
        return false;
    L33:
        return false;
    L32:
        return false;
    L13:
        r0 = null;
        goto L14
    }

    private static boolean h(Context r3, JSONArray r4) {
        if (r4 != null) goto L17;
    L15:
        return false;
    L17:
        if (r4.length() <= 0) goto L15;
        if (r3 == null) goto L15;
        int r1 = 0;
    L9:
        if (r1 >= r4.length()) goto L15;
        if (a5.E(r3, r4.getString(r1)) == true) goto L12;
        r1 = r1 + 1;
        goto L9
    L12:
        return true;
    }

    public static int i() {
        return f7733d;
    }

    public static void j(Context r8) {
        if (f7738i == false) goto L5;
        return;
    L5:
        f7738i = true;
        f7731b = z4.m(r8, "pref", "exception", f7731b);     // Catch: Throwable -> L8
        m(r8);     // Catch: Throwable -> L8
    L10:
        int r3 = 0;
        f7732c = z4.b(r8, "pref", "fn", f7732c);     // Catch: Throwable -> L13
        f7733d = z4.b(r8, "pref", "mpn", f7733d);     // Catch: Throwable -> L13
        f7734e = z4.m(r8, "pref", "igu", f7734e);     // Catch: Throwable -> L13
        f7735f = z4.b(r8, "pref", "ms", f7735f);     // Catch: Throwable -> L13
        f7737h = z4.b(r8, "pref", "rot", 0);     // Catch: Throwable -> L13
        int r4 = z4.b(r8, "pref", "pms", 0);     // Catch: Throwable -> L13
        f7736g = r4;     // Catch: Throwable -> L13
        y0.b(f7732c, f7734e, f7735f, r4);     // Catch: Throwable -> L13
        a1.f(f7734e, f7736g);     // Catch: Throwable -> L13
    L73:
        f7739j = z4.m(r8, "pref", "ca", f7739j);     // Catch: Throwable -> L17
        f7740k = z4.c(r8, "pref", "ct", f7740k);     // Catch: Throwable -> L17
        f7741l = z4.m(r8, "pref", "11G_fa", f7741l);     // Catch: Throwable -> L17
        double r5 = Double.valueOf(z4.f(r8, "pref", "11G_ms", String.valueOf(m))).doubleValue();     // Catch: Throwable -> L17
        m = r5;     // Catch: Throwable -> L17
        m = Math.max(0.2d, r5);     // Catch: Throwable -> L17
    L77:
        t = z4.m(r8, "pref", "fr", t);     // Catch: Throwable -> L21
    L79:
        u = z4.m(r8, "pref", "asw", u);     // Catch: Throwable -> L25
    L81:
        v = z4.c(r8, "pref", "awsi", v);     // Catch: Throwable -> L29
    L87:
        w = z4.m(r8, "pref", "15ua", w);     // Catch: Throwable -> L33
        x = z4.b(r8, "pref", "15un", x);     // Catch: Throwable -> L33
        C = z4.c(r8, "pref", "15ust", C);     // Catch: Throwable -> L33
    L95:
        y = z4.m(r8, "pref", "ok9", y);     // Catch: Throwable -> L37
        z = z4.b(r8, "pref", "ok10", z);     // Catch: Throwable -> L37
        B = z4.f(r8, "pref", "ok11", B);     // Catch: Throwable -> L37
    L71:
        D = z4.m(r8, "pref", "17ya", false);     // Catch: Throwable -> L41
        E = z4.m(r8, "pref", "17ym", false);     // Catch: Throwable -> L41
        G = ((z4.b(r8, "pref", "17yi", 2) * 60) * 60) * 1000;     // Catch: Throwable -> L41
        F = z4.b(r8, "pref", "17yx", 100) * 1024;     // Catch: Throwable -> L41
    L93:
        a5.A();     // Catch: Throwable -> L45
        q = z4.c(r8, "pref", "13S_at", q);     // Catch: Throwable -> L45
        r = z4.m(r8, "pref", "13S_nla", r);     // Catch: Throwable -> L45
        n = z4.m(r8, "pref", "13J_able", n);     // Catch: Throwable -> L45
        o = z4.b(r8, "pref", "13J_c", o);     // Catch: Throwable -> L45
        p = z4.b(r8, "pref", "13J_t", p);     // Catch: Throwable -> L45
    L47:
        j5.B(r8);
        String r6 = z4.f(r8, "pref", "13S_mlpl", null);     // Catch: Throwable -> L52
        if (TextUtils.isEmpty(r6) == true) goto L83;
        s = h(r8, new JSONArray(u5.u(r6)));     // Catch: Throwable -> L52
    L83:
        boolean r7 = z4.m(r8, "pref", "197a", false);     // Catch: Throwable -> L64
        String r9 = z4.f(r8, "pref", "197dv", "");     // Catch: Throwable -> L64
        String r0 = z4.f(r8, "pref", "197tv", "");     // Catch: Throwable -> L64
        if (r7 == true) goto L57;
    L85:
        H = z4.m(r8, "pref", "1A6", H);     // Catch: Throwable -> L68
        return;
    L68:
        th = move-exception;
        s4.h(th, "AuthUtil", "loadSdkEnableConfig p13");
        return;
    L57:
        if (s4.f7768a.equals(r9) == false) goto L85;
        String[] r10 = s4.f7769b;     // Catch: Throwable -> L64
        int r11 = r10.length;     // Catch: Throwable -> L64
    L59:
        if (r3 >= r11) goto L85;
        if (r10[r3].equals(r0) == false) goto L63;
        s4.f7768a = r0;     // Catch: Throwable -> L64
    L63:
        r3 = r3 + 1;
    L64:
        th = move-exception;
        s4.h(th, "AuthUtil", "loadLastAbleState p12");
    L52:
        th = move-exception;
        s4.h(th, "AuthUtil", "loadLastAbleState p11");
    L45:
        th = move-exception;
        s4.h(th, "AuthUtil", "loadLastAbleState p10");
    L41:
        th = move-exception;
        s4.h(th, "AuthUtil", "loadLastAbleState p9");
    L37:
        th = move-exception;
        s4.h(th, "AuthUtil", "loadLastAbleState p8");
    L33:
        th = move-exception;
        s4.h(th, "AuthUtil", "loadLastAbleState p7");
    L29:
        th = move-exception;
        s4.h(th, "AuthUtil", "loadLastAbleState p6");
    L25:
        th = move-exception;
        s4.h(th, "AuthUtil", "loadLastAbleState p5");
    L21:
        th = move-exception;
        s4.h(th, "AuthUtil", "loadLastAbleState p4");
    L17:
        th = move-exception;
        s4.h(th, "AuthUtil", "loadLastAbleState p3");
    L13:
        th = move-exception;
        s4.h(th, "AuthUtil", "loadLastAbleState p2");
    L8:
        th = move-exception;
        s4.h(th, "AuthUtil", "loadLastAbleState p1");
        goto L10
    }

    private static void k(JSONObject r4, SharedPreferences.Editor r5) {
        if (r4 != null) goto L14;
        return;
    L14:
        JSONObject r6 = r4.getJSONObject("197");     // Catch: Throwable -> L13
        if (r6 == null) goto L15;
        boolean r0 = j5.v(r6.optString("able"), false);     // Catch: Throwable -> L13
        z4.l(r5, "197a", r0);     // Catch: Throwable -> L13
        if (r0 == false) goto L11;
        z4.k(r5, "197dv", r6.optString("sv", ""));     // Catch: Throwable -> L13
        z4.k(r5, "197tv", r6.optString("tv", ""));     // Catch: Throwable -> L13
        return;
    L11:
        z4.k(r5, "197dv", "");     // Catch: Throwable -> L13
        z4.k(r5, "197tv", "");     // Catch: Throwable -> L13
        return;
    L15:
        return;
    }

    public static int l() {
        if (f7737h >= 0) goto L6;
        f7737h = 0;
    L6:
        return f7737h;
    }

    public static void m(Context r2) {
        t5 r0 = s4.q();     // Catch: Throwable -> L4
        r0.c(f7731b);     // Catch: Throwable -> L4
        v.g(r2, r0);     // Catch: Throwable -> L4
        return;
    }

    private static void n(JSONObject r2, SharedPreferences.Editor r3) {
        if (r2 != null) goto L10;
        return;
    L10:
        JSONObject r4 = r2.getJSONObject("1A6");     // Catch: Throwable -> L9
        if (r4 == null) goto L12;
        boolean r5 = j5.v(r4.optString("ic"), false);     // Catch: Throwable -> L9
        z4.l(r3, "1A6", r5);     // Catch: Throwable -> L9
        H = r5;     // Catch: Throwable -> L9
        return;
    L12:
        return;
    }

    public static long o() {
        return f7740k;
    }

    private static void p(JSONObject r2, SharedPreferences.Editor r3) {
        JSONObject r4 = r2.optJSONObject("13J");     // Catch: Throwable -> L9
        if (r4 == null) goto L14;
        boolean r0 = j5.v(r4.optString("able"), true);     // Catch: Throwable -> L9
        n = r0;     // Catch: Throwable -> L9
        if (r0 == false) goto L7;
        o = r4.optInt("c", o);     // Catch: Throwable -> L9
        p = r4.optInt("t", p);     // Catch: Throwable -> L9
    L7:
        z4.l(r3, "13J_able", n);     // Catch: Throwable -> L9
        z4.i(r3, "13J_c", o);     // Catch: Throwable -> L9
        z4.i(r3, "13J_t", p);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        th = move-exception;
        s4.h(th, "AuthUtil", "loadConfigDataGpsGeoAble");
    }

    private static void q(JSONObject r1, SharedPreferences.Editor r2) {
        if (r1 != null) goto L9;
        return;
    L9:
        boolean r3 = j5.v(r1.optString("re"), false);     // Catch: Throwable -> L6
        t = r3;     // Catch: Throwable -> L6
        z4.l(r2, "fr", r3);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        s4.h(th, "AuthUtil", "checkReLocationAble");
    }

    public static boolean r() {
        return f7739j;
    }

    private static void s(JSONObject r2, SharedPreferences.Editor r3) {
        JSONObject r4 = r2.optJSONObject("15O");     // Catch: Throwable -> L16
        if (r4 != null) goto L5;
        return;
    L5:
        if (j5.v(r4.optString("able"), false) == false) goto L13;
        JSONArray r0 = r4.optJSONArray("fl");     // Catch: Throwable -> L16
        if (r0 != null) goto L9;
    L12:
        v = r4.optInt("iv", 30) * 1000;     // Catch: Throwable -> L16
    L14:
        z4.j(r3, "awsi", v);     // Catch: Throwable -> L16
        return;
    L9:
        if (r0.length() <= 0) goto L12;
        if (r0.toString().contains(Build.MANUFACTURER) == true) goto L12;
    L13:
        v = -1;     // Catch: Throwable -> L16
    }

    public static boolean t() {
        return f7741l;
    }

    public static double u() {
        return m;
    }

    private static void v(JSONObject r3, SharedPreferences.Editor r4) {
        if (r3 != null) goto L14;
        return;
    L14:
        JSONObject r5 = r3.getJSONObject("17Y");     // Catch: Throwable -> L13
        if (r5 == null) goto L16;
        boolean r0 = j5.v(r5.optString("able"), false);     // Catch: Throwable -> L13
        D = r0;     // Catch: Throwable -> L13
        z4.l(r4, "17ya", r0);     // Catch: Throwable -> L13
        boolean r1 = j5.v(r5.optString("mup"), false);     // Catch: Throwable -> L13
        E = r1;     // Catch: Throwable -> L13
        z4.l(r4, "17ym", r1);     // Catch: Throwable -> L13
        int r2 = r5.optInt("max", 20);     // Catch: Throwable -> L13
        if (r2 <= 0) goto L9;
        z4.i(r4, "17yx", r2);     // Catch: Throwable -> L13
        F = r2 * 1024;     // Catch: Throwable -> L13
    L9:
        int r6 = r5.optInt("inv", 3);     // Catch: Throwable -> L13
        if (r6 <= 0) goto L17;
        z4.i(r4, "17yi", r6);     // Catch: Throwable -> L13
        G = ((r6 * 60) * 60) * 1000;     // Catch: Throwable -> L13
        return;
    L17:
        return;
    L16:
        return;
    }

    private static void w(JSONObject r5, SharedPreferences.Editor r6) {
        JSONObject r7 = r5.optJSONObject("15U");     // Catch: Throwable -> L6
        if (r7 == null) goto L9;
        boolean r0 = j5.v(r7.optString("able"), true);     // Catch: Throwable -> L6
        int r1 = r7.optInt("yn", x);     // Catch: Throwable -> L6
        C = r7.optLong("sysTime", C);     // Catch: Throwable -> L6
        z4.l(r6, "15ua", r0);     // Catch: Throwable -> L6
        z4.i(r6, "15un", r1);     // Catch: Throwable -> L6
        z4.j(r6, "15ust", C);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public static boolean x() {
        return n;
    }

    public static int y() {
        return o;
    }

    private static void z(JSONObject r4, SharedPreferences.Editor r5) {
        if (r4 != null) goto L17;
        return;
    L17:
        JSONObject r6 = r4.optJSONObject("17J");     // Catch: Throwable -> L16
        if (r6 == null) goto L19;
        boolean r0 = j5.v(r6.optString("able"), false);     // Catch: Throwable -> L16
        y = r0;     // Catch: Throwable -> L16
        z4.l(r5, "ok9", r0);     // Catch: Throwable -> L16
        if (r0 == false) goto L20;
        String r1 = r6.optString("auth");     // Catch: Throwable -> L16
        String r2 = r6.optString("ht");     // Catch: Throwable -> L16
        B = r2;     // Catch: Throwable -> L16
        z4.k(r5, "ok11", r2);     // Catch: Throwable -> L16
        j5.v(r1, false);     // Catch: Throwable -> L16
        A = j5.v(r6.optString(LocationInfoConst.NR), false);     // Catch: Throwable -> L16
        String r7 = r6.optString("tm");     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r7) == true) goto L21;
        int r8 = Integer.parseInt(r7);     // Catch: Throwable -> L16
        if (r8 > 0) goto L13;
        return;
    L13:
        if (r8 >= 20) goto L23;
        z = r8;     // Catch: Throwable -> L16
        z4.i(r5, "ok10", r8);     // Catch: Throwable -> L16
        return;
    L23:
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }
}
