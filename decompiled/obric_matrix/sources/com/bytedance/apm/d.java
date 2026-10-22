package com.bytedance.apm;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm.net.DefaultHttpServiceImpl;
import com.bytedance.apm.util.s;
import com.bytedance.apm.util.t;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.IMultipartUploader;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {
    static long A;
    static long B;
    static long C;
    static long D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f1479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f1480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f1481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f1482d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f1483e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static long f1484f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static long f1485g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static JSONObject f1486h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static com.bytedance.apm.core.b f1487i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Map<String, String> f1488j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static IHttpService f1489k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static long f1490l;
    private static volatile int m;
    private static boolean n;
    private static long o;
    private static long p;
    private static String q;
    private static boolean r;
    private static boolean s;
    private static boolean t;
    private static boolean u;
    private static List<String> v;
    private static String w;
    private static g x;
    private static e y;
    private static com.bytedance.apm.core.d z;

    static {
        f1486h = new JSONObject();
        f1487i = new com.bytedance.apm.core.a();
        f1488j = Collections.emptyMap();
        f1489k = new DefaultHttpServiceImpl();
        f1490l = -1;
        m = -1;
        n = false;
        u = true;
        z = null;
    }

    public static long A() {
        if (f1490l != (-1)) goto L6;
        f1490l = System.currentTimeMillis();
    L6:
        return f1490l;
    }

    public static String B(long r2) {
        long r3 = r2 - p;
        if (r3 >= 30000) goto L7;
        return "0 - 30s";
    L7:
        if (r3 >= 60000) goto L11;
        return "30s - 1min";
    L11:
        if (r3 >= 120000) goto L15;
        return "1min - 2min";
    L15:
        if (r3 >= 300000) goto L19;
        return "2min - 5min";
    L19:
        if (r3 >= 600000) goto L23;
        return "5min - 10min";
    L23:
        if (r3 >= 1800000) goto L27;
        return "10min - 30min";
    L27:
        if (r3 >= 3600000) goto L30;
        return "30min - 1h";
    L30:
        return "1h - ";
    }

    public static boolean C() {
        if (f1480b == false) goto L5;
    L8:
        return true;
    L5:
        if (f1482d == true) goto L8;
        return false;
    }

    public static boolean D() {
        return s;
    }

    public static boolean E() {
        return f1481c;
    }

    public static boolean F() {
        JSONObject r0 = f1486h;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.optString("channel") != null) goto L8;
        return false;
    L8:
        return f1486h.optString("channel").contains("local");
    }

    public static boolean G() {
        boolean r1 = true;
        if (r == false) goto L6;
        return true;
    L6:
        if (f1479a == null) goto L8;
        String r0 = i();
        if (r0 != null) goto L12;
    L14:
        if (r0 != null) goto L16;
    L18:
        r1 = false;
    L19:
        r = r1;
    L21:
        return r;
    L16:
        if (r0.equals(f1479a.getPackageName()) == false) goto L18;
    L12:
        if (r0.contains(":") == false) goto L14;
        r = false;
        goto L21
    L8:
        return H();
    }

    public static boolean H() {
        if (r == false) goto L5;
        return true;
    L5:
        String r0 = i();
        if (r0 != null) goto L8;
    L11:
        return true;
    L8:
        if (r0.contains(":") == false) goto L11;
        return false;
    }

    public static boolean I() {
        return u;
    }

    public static boolean J() {
        return n;
    }

    public static void K(String r0) {
        w = r0;
    }

    public static void L(long r4) {
        if (r4 > 0) goto L5;
        return;
    L5:
        long r2 = o;
        if (r2 != 0) goto L8;
    L9:
        o = r4;
        return;
    L8:
        if (r4 < r2) goto L9;
    }

    public static void M(Context r0) {
        if (r0 != null) goto L4;
        return;
    L4:
        f1479a = com.bytedance.apm.util.a.a(r0);
    }

    public static void N(String r0) {
        q = r0;
    }

    public static void O(boolean r0) {
        f1480b = r0;
        d.b.b.o.a.f(C());
    }

    public static void P(boolean r0) {
        s = r0;
    }

    public static synchronized void Q(com.bytedance.apm.core.b r4) {
        monitor-enter(d.class);
        f1487i = r4;     // Catch: Throwable -> L39
        Map<String, String> r5 = r4.getCommonParams();     // Catch: Throwable -> L39
        f1488j = r5;     // Catch: Throwable -> L39
        if (r5 != null) goto L8;
        f1488j = new HashMap();     // Catch: Throwable -> L39
    L8:
        if (f1488j.containsKey(WsConstants.KEY_APP_ID) == true) goto L11;
        f1488j.put(WsConstants.KEY_APP_ID, f1486h.optString(WsConstants.KEY_APP_ID));     // Catch: Throwable -> L39
    L11:
        if (f1488j.containsKey(WsConstants.KEY_DEVICE_ID) == true) goto L14;
        f1488j.put(WsConstants.KEY_DEVICE_ID, f1486h.optString(WsConstants.KEY_DEVICE_ID));     // Catch: Throwable -> L39
    L14:
        if (f1488j.containsKey("device_platform") == true) goto L16;
        f1488j.put("device_platform", "android");     // Catch: Throwable -> L39
    L16:
        f1488j.put("os", LocationInfoConst.SYSTEM);     // Catch: Throwable -> L39
        if (f1488j.containsKey("update_version_code") == true) goto L20;
        f1488j.put("update_version_code", f1486h.optString("update_version_code"));     // Catch: Throwable -> L39
    L20:
        if (f1488j.containsKey("version_code") == true) goto L23;
        f1488j.put("version_code", f1486h.optString("version_code"));     // Catch: Throwable -> L39
    L23:
        if (f1488j.containsKey("channel") == true) goto L26;
        f1488j.put("channel", f1486h.optString("channel"));     // Catch: Throwable -> L39
    L26:
        if (f1488j.containsKey("os_api") == true) goto L29;
        f1488j.put("os_api", Build.VERSION.SDK_INT + "");     // Catch: Throwable -> L39
    L29:
        if (C() == false) goto L34;
        if (f1488j.containsKey("_log_level") == true) goto L34;
        f1488j.put("_log_level", "debug");     // Catch: Throwable -> L39
    L34:
        if (x != null) goto L36;
        x = new g();     // Catch: Throwable -> L39
    L36:
        x.r(new HashMap(f1488j));     // Catch: Throwable -> L39
        monitor-exit(d.class);
        return;
    L39:
        th = move-exception;
        throw th;
    }

    public static synchronized void R(JSONObject r5) {
        monitor-enter(d.class);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (x != null) goto L7;
        x = new g();     // Catch: Throwable -> L23 Exception -> L76
    L7:
        r5.put("os", LocationInfoConst.SYSTEM);     // Catch: Throwable -> L23 Exception -> L76
        r5.put("device_platform", "android");     // Catch: Throwable -> L23 Exception -> L76
        r5.put("os_version", Build.VERSION.RELEASE);     // Catch: Throwable -> L23 Exception -> L76
        r5.put("os_api", Build.VERSION.SDK_INT);     // Catch: Throwable -> L23 Exception -> L76
        r5.put("device_model", Build.MODEL);     // Catch: Throwable -> L23 Exception -> L76
        r5.put("device_brand", Build.BRAND);     // Catch: Throwable -> L23 Exception -> L76
        r5.put("device_manufacturer", Build.MANUFACTURER);     // Catch: Throwable -> L23 Exception -> L76
        r5.put("process_name", com.bytedance.apm.util.a.b(Process.myPid()));     // Catch: Throwable -> L23 Exception -> L76
        r5.put(WsConstants.KEY_SESSION_ID, A());     // Catch: Throwable -> L23 Exception -> L76
        r5.put("phone_startup_time", t());     // Catch: Throwable -> L23 Exception -> L76
        r5.put("verify_info", t.a());     // Catch: Throwable -> L23 Exception -> L76
        r5.put("rom_version", s.l());     // Catch: Throwable -> L23 Exception -> L76
        PackageInfo r1 = null;
        if (r5.has("version_name") == true) goto L11;
        r1 = h().getPackageManager().getPackageInfo(h().getPackageName(), 0);     // Catch: Throwable -> L23 Exception -> L76
        r5.put("version_name", r1.versionName);     // Catch: Throwable -> L23 Exception -> L76
    L11:
        if (TextUtils.isEmpty(r5.optString(WsConstants.KEY_APP_VERSION)) == false) goto L14;
        r5.put(WsConstants.KEY_APP_VERSION, r5.optString("version_name"));     // Catch: Throwable -> L23 Exception -> L76
    L14:
        if (r5.has("version_code") == true) goto L19;
        if (r1 != null) goto L17;
        r1 = h().getPackageManager().getPackageInfo(h().getPackageName(), 0);     // Catch: Throwable -> L23 Exception -> L76
    L17:
        r5.put("version_code", r1.versionCode);     // Catch: Throwable -> L23 Exception -> L76
    L19:
        if (TextUtils.isEmpty(r5.optString("package")) == false) goto L21;
        r5.put("package", h().getPackageName());     // Catch: Throwable -> L23 Exception -> L76
    L21:
        r5.put("monitor_version", "5.0.21.21");     // Catch: Throwable -> L23 Exception -> L76
    L25:
        x.s(r5.optString("process_name"));     // Catch: Throwable -> L23
        x.p(r5.optString(WsConstants.KEY_DEVICE_ID));     // Catch: Throwable -> L23
        x.m(r5.optInt(WsConstants.KEY_APP_ID));     // Catch: Throwable -> L23 Exception -> L77
        x.o(r5.optString("channel"));     // Catch: Throwable -> L23 Exception -> L77
        if (r5.has("update_version_code") == false) goto L34;
        if ((r5.get("update_version_code") instanceof String) == false) goto L32;
        g r2 = x;     // Catch: Throwable -> L23 Exception -> L77
        int r3 = Integer.valueOf(r5.optString("update_version_code")).intValue();     // Catch: Throwable -> L23 Exception -> L77
    L31:
        r2.v(r3);     // Catch: Throwable -> L23 Exception -> L77
        goto L34
    L32:
        r2 = x;     // Catch: Throwable -> L23 Exception -> L77
        r3 = r5.optInt("update_version_code");     // Catch: Throwable -> L23 Exception -> L77
    L34:
        if (r5.has("version_name") == false) goto L37;
        x.x(r5.optString("version_name"));     // Catch: Throwable -> L23 Exception -> L77
    L37:
        if (r5.has("manifest_version_code") == false) goto L44;
        if ((r5.get("manifest_version_code") instanceof String) == false) goto L42;
        g r4 = x;     // Catch: Throwable -> L23 Exception -> L77
        int r6 = Integer.valueOf(r5.optString("manifest_version_code")).intValue();     // Catch: Throwable -> L23 Exception -> L77
    L41:
        r4.q(r6);     // Catch: Throwable -> L23 Exception -> L77
        goto L44
    L42:
        r4 = x;     // Catch: Throwable -> L23 Exception -> L77
        r6 = r5.optInt("manifest_version_code");     // Catch: Throwable -> L23 Exception -> L77
    L44:
        if (r5.has("version_code") == false) goto L51;
        if ((r5.get("version_code") instanceof String) == false) goto L49;
        g r7 = x;     // Catch: Throwable -> L23 Exception -> L77
        int r8 = Integer.valueOf(r5.optString("version_code")).intValue();     // Catch: Throwable -> L23 Exception -> L77
    L48:
        r7.w(r8);     // Catch: Throwable -> L23 Exception -> L77
        goto L51
    L49:
        r7 = x;     // Catch: Throwable -> L23 Exception -> L77
        r8 = r5.optInt("version_code");     // Catch: Throwable -> L23 Exception -> L77
    L51:
        if (r5.has(WsConstants.KEY_APP_VERSION) == false) goto L53;
        x.n(r5.optString(WsConstants.KEY_APP_VERSION));     // Catch: Throwable -> L23 Exception -> L77
    L53:
        String r9 = t.a();     // Catch: Throwable -> L23 Exception -> L77
        if (TextUtils.isEmpty(r9) == true) goto L60;
        if (r9.equals("null") == true) goto L60;
        r5.put("release_build", r9);     // Catch: Throwable -> L23 Exception -> L77
        g r10 = x;     // Catch: Throwable -> L23 Exception -> L77
        String r11 = r5.optString("release_build");     // Catch: Throwable -> L23 Exception -> L77
    L58:
        r10.t(r11);     // Catch: Throwable -> L23 Exception -> L77
    L60:
        if (t.a().isEmpty() == true) goto L63;
        r10 = x;     // Catch: Throwable -> L23 Exception -> L77
        r11 = t.a();     // Catch: Throwable -> L23 Exception -> L77
    L63:
        x.u(com.bytedance.apm.util.h.b(r5));     // Catch: Throwable -> L23
        if (f1486h != null) goto L66;
        f1486h = r5;     // Catch: Throwable -> L23
    L72:
        monitor-exit(d.class);
        return;
    L66:
        Iterator<String> r12 = r5.keys();     // Catch: Throwable -> L23
    L68:
        if (r12.hasNext() == false) goto L72;
        String r13 = r12.next();     // Catch: Throwable -> L23
        f1486h.put(r13, r5.get(r13));     // Catch: Throwable -> L23 JSONException -> L78
        goto L68
    }

    public static void S(IHttpService r0) {
        if (r0 == null) goto L5;
        f1489k = r0;
        return;
    }

    public static void T(long r0) {
        f1483e = r0;
    }

    public static void U(long r0) {
        A = r0;
    }

    public static void V(long r0) {
        B = r0;
    }

    public static void W(long r0) {
        C = r0;
    }

    public static void X(long r0) {
        D = r0;
    }

    public static void Y(long r0) {
        f1484f = r0;
    }

    public static void Z(long r0) {
        p = r0;
    }

    public static IMultipartUploader a(String r1, String r2, boolean r3) {
        return f1489k.buildMultipartUpload(r1, r2, r3);
    }

    public static void a0(long r0) {
    }

    public static IMultipartUploader b(String r1, String r2, boolean r3, Map<String, String> r4) {
        return f1489k.buildMultipartUpload(r1, r2, r3, r4);
    }

    public static void b0(boolean r0) {
        f1481c = r0;
    }

    public static HttpResponse c(String r1, Map<String, String> r2) {
        return f1489k.doGet(r1, r2);
    }

    public static void c0(boolean r0) {
    }

    public static HttpResponse d(String r1, byte[] r2, Map<String, String> r3) {
        return f1489k.doPost(r1, r2, r3);
    }

    public static void d0(int r0) {
        m = r0;
    }

    public static boolean e(String r2, String r3) {
        if (f1486h != null) goto L6;
        return false;
    L6:
        if (r2.equals("release_build") == false) goto L12;
        return false;
    L12:
        f1486h.put(r2, r3);     // Catch: JSONException -> L11
        return true;
    L11:
        return false;
    }

    public static synchronized void e0(com.bytedance.apm.core.d r1) {
        monitor-enter(d.class);
        z = r1;     // Catch: Throwable -> L7
        monitor-exit(d.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static String f() {
        return w;
    }

    public static void f0(List<String> r0) {
        v = r0;
    }

    public static long g() {
        return o;
    }

    public static void g0(long r0) {
        f1485g = r0;
    }

    public static Context h() {
        return f1479a;
    }

    public static void h0(long r0) {
    }

    public static String i() {
        if (TextUtils.isEmpty(q) == false) goto L6;
        q = com.bytedance.apm.util.a.b(Process.myPid());
    L6:
        return q;
    }

    public static void i0(boolean r0) {
        n = r0;
    }

    public static com.bytedance.apm.core.b j() {
        return f1487i;
    }

    public static void j0(boolean r0) {
        t = r0;
    }

    public static JSONObject k() {
        return new JSONObject(String.valueOf(f1486h));
    L5:
        return new JSONObject();
    }

    public static boolean k0() {
        return t;
    }

    @Deprecated
    public static JSONObject l() {
        return f1486h;
    }

    public static HttpResponse l0(String r1, List<File> r2, Map<String, String> r3) {
        return f1489k.uploadFiles(r1, r2, r3);
    }

    public static IHttpService m() {
        return f1489k;
    }

    public static long n() {
        return f1483e;
    }

    public static long o() {
        return f1484f;
    }

    public static long p() {
        return A;
    }

    public static long q() {
        return B;
    }

    public static long r() {
        return C;
    }

    public static long s() {
        return D;
    }

    public static long t() {
        if (p != 0) goto L6;
        p = System.currentTimeMillis();
    L6:
        return p;
    }

    public static int u() {
        return m;
    }

    public static synchronized g v() {
        monitor-enter(d.class);
        g r1 = x;     // Catch: Throwable -> L7
        monitor-exit(d.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized Map<String, String> w() {
        monitor-enter(d.class);
        com.bytedance.apm.core.d r1 = z;     // Catch: Throwable -> L25
        if (r1 == null) goto L17;
        Map<String, String> r2 = r1.a();     // Catch: Throwable -> L25
        if (r2 == null) goto L17;
        if (r2.size() <= 0) goto L17;
        if (x.f() == null) goto L15;
        HashMap r3 = new HashMap(x.f());     // Catch: Throwable -> L25
        r3.putAll(r2);     // Catch: Throwable -> L25
        monitor-exit(d.class);
        return r3;
    L15:
        monitor-exit(d.class);
        return r2;
    L17:
        g r4 = x;     // Catch: Throwable -> L25
        if (r4 == null) goto L23;
        Map<String, String> r5 = r4.f();     // Catch: Throwable -> L25
        monitor-exit(d.class);
        return r5;
    L23:
        monitor-exit(d.class);
        return null;
    L25:
        th = move-exception;
        throw th;
    }

    public static e x() {
        return y;
    }

    public static synchronized Map<String, String> y() {
        monitor-enter(d.class);
        com.bytedance.apm.core.d r1 = z;     // Catch: Throwable -> L16
        if (r1 == null) goto L13;
        Map<String, String> r2 = r1.a();     // Catch: Throwable -> L16
        if (r2 == null) goto L13;
        if (r2.size() <= 0) goto L13;
        HashMap r3 = new HashMap(f1488j);     // Catch: Throwable -> L16
        r3.putAll(r2);     // Catch: Throwable -> L16
        monitor-exit(d.class);
        return r3;
    L13:
        Map<String, String> r4 = f1488j;     // Catch: Throwable -> L16
        monitor-exit(d.class);
        return r4;
    L16:
        th = move-exception;
        throw th;
    }

    public static long z() {
        return f1485g;
    }
}
