package d.b.b.i.c;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.apm.w.e;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IHttpService;
import d.b.b.n.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends d.b.b.o.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static b f12956d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f12957e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Boolean f12958f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f12959g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static int f12960h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f12961i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static int f12962j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static String f12963k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static String f12964l = null;
    private static long m = -1;
    private static long n = 0;
    private static int o = -1;
    private static JSONObject p = null;
    private static Map<String, String> q = null;
    private static long r = -1;
    private static e s;

    static {
    }

    public a() {
    }

    public static boolean A() {
        if (f12958f != null) goto L26;
        monitor-enter(a.class);
    L22:
        th = move-exception;
        throw th;
    L7:
        if (f12958f != null) goto L20;
        String r1 = m();     // Catch: Throwable -> L22
        if (r1 != null) goto L11;
    L14:
        if (r1 != null) goto L16;
    L18:
        boolean r2 = false;
    L19:
        Boolean r3 = Boolean.valueOf(r2);     // Catch: Throwable -> L22
    L13:
        f12958f = r3;     // Catch: Throwable -> L22
        goto L20
    L16:
        if (r1.equals(d.b.b.o.a.b().getPackageName()) == false) goto L18;
        r2 = true;
        goto L19
    L11:
        if (r1.contains(":") == false) goto L14;
        r3 = Boolean.FALSE;     // Catch: Throwable -> L22
    L20:
        monitor-exit(a.class);     // Catch: Throwable -> L22
    L26:
        return f12958f.booleanValue();
    }

    public static void B(b r1) {
        if (r1 == null) goto L6;
        f12956d = r1;
        d.b.b.o.a.e(r1.getContext());
        return;
    L6:
        throw new IllegalArgumentException("apmAdapter cannot be null!");
    }

    public static void C(long r0) {
        r = r0;
    }

    public static void D(long r0) {
        n = r0;
    }

    public static void E(e r0) {
        s = r0;
    }

    public static void F(long r0) {
        m = r0;
    }

    public static HttpResponse g(String r1, Map<String, String> r2, byte[] r3) {
        return ((IHttpService) c.a(IHttpService.class)).doPost(r1, r3, r2);
    }

    public static int h() {
        return f12956d.getAid();
    }

    public static b i() {
        return f12956d;
    }

    public static String j() {
        if (TextUtils.isEmpty(f12963k) == false) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (TextUtils.isEmpty(f12963k) == false) goto L9;
        f12963k = f12956d.a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f12963k;
    }

    public static String k() {
        if (f12959g != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f12959g != null) goto L9;
        f12959g = f12956d.getChannel();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f12959g;
    }

    public static long l() {
        return r;
    }

    public static String m() {
        if (f12957e != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f12957e != null) goto L9;
        f12957e = f12956d.f();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f12957e;
    }

    public static String n() {
        return f12956d.getDeviceId();
    }

    public static long o() {
        if (n > 0) goto L6;
        n = System.currentTimeMillis();
    L6:
        return n;
    }

    public static String p() {
        if (o != (-1)) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (o != (-1)) goto L9;
        o = f12956d.getManifestVersionCode();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return String.valueOf(o);
    }

    public static e q() {
        return s;
    }

    public static String r() {
        if (TextUtils.isEmpty(f12964l) == false) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (TextUtils.isEmpty(f12964l) == false) goto L9;
        f12964l = f12956d.g();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f12964l;
    }

    public static String s() {
        return f12956d.getSessionId();
    }

    public static JSONObject t() {
        if (p != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (p != null) goto L9;
        p = f12956d.c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return p;
    }

    public static long u() {
        if (m >= 0) goto L6;
        m = System.currentTimeMillis();
    L6:
        return m;
    }

    public static int v() {
        if (f12960h != (-1)) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f12960h != (-1)) goto L9;
        f12960h = f12956d.getUpdateVersionCode();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f12960h;
    }

    public static Map<String, String> w() {
        if (q != null) goto L5;
        HashMap r0 = new HashMap();
        q = r0;
        r0.put(WsConstants.KEY_APP_ID, String.valueOf(h()));
        q.put("os", LocationInfoConst.SYSTEM);
        q.put("device_platform", "android");
        q.put("os_api", Build.VERSION.SDK_INT + "");
        q.put("update_version_code", String.valueOf(v()));
        q.put("version_code", j());
        q.put("channel", k());
        q.put("device_model", Build.MODEL);
        q.put("device_brand", Build.BRAND);
    L5:
        q.put(WsConstants.KEY_DEVICE_ID, n());
        if (d.b.b.o.a.c() == false) goto L20;
        q.put("_log_level", "debug");
    L20:
        Map<String, String> r1 = i().b();     // Catch: Throwable -> L19
        if (r1 == null) goto L18;
        if (r1.size() <= 0) goto L18;
        Iterator<Map.Entry<String, String>> r2 = r1.entrySet().iterator();     // Catch: Throwable -> L19
    L14:
        if (r2.hasNext() == false) goto L18;
        Map.Entry<String, String> r3 = r2.next();     // Catch: Throwable -> L19
        q.put(r3.getKey(), r3.getValue());     // Catch: Throwable -> L19
    L18:
        return q;
    }

    public static long x() {
        return f12956d.getUid();
    }

    public static int y() {
        if (f12962j != (-1)) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f12962j != (-1)) goto L9;
        f12962j = f12956d.getVersionCode();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f12962j;
    }

    public static String z() {
        if (TextUtils.isEmpty(f12961i) == false) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (TextUtils.isEmpty(f12961i) == false) goto L9;
        f12961i = f12956d.getVersionName();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f12961i;
    }
}
