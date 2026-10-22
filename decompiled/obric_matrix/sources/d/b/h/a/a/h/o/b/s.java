package d.b.h.a.a.h.o.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.bdlocation.client.LocationInfoConst;
import d.b.r.y;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Locale;
import p000j.a0;

/* JADX INFO: loaded from: classes.dex */
public class s extends d.b.h.a.a.h.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile s f13531c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f13532d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile int f13533e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile String f13534f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile Proxy f13535g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Object f13536h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static int f13537i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile String f13538j = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static String f13539k = "tt-ok/3.10.0.2";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static volatile d.b.h.a.a.h.o.a f13540l;
    private static Context m;
    private static i n;
    private static g o;

    class a implements d.b.h.a.a.h.o.b.x.h {
        a(s r1) {
        }

        @Override // d.b.h.a.a.h.o.b.x.h
        public String a() {
            if (s.g() != null) goto L5;
            return null;
        L5:
            return s.g().a();
        }

        @Override // d.b.h.a.a.h.o.b.x.h
        public String[] b() {
            if (s.g() != null) goto L5;
            return null;
        L5:
            return s.g().b();
        }

        @Override // d.b.h.a.a.h.o.b.x.h
        public String[] c() {
            if (s.g() != null) goto L5;
            return null;
        L5:
            return s.g().c();
        }

        @Override // d.b.h.a.a.h.o.b.x.h
        public String getAppId() {
            if (s.g() != null) goto L5;
            return null;
        L5:
            return String.valueOf(s.g().getAid());
        }

        @Override // d.b.h.a.a.h.o.b.x.h
        public Context getContext() {
            return s.f();
        }
    }

    static {
        f13536h = new Object();
    }

    private s(Context r5) {
        String r0 = null;
        r0 = p000j.k0.d.a();     // Catch: Throwable -> L5
    L5:
        Field r1 = Class.forName("j.k0.c").getDeclaredField("userAgent");     // Catch: Throwable -> L16
        r1.setAccessible(true);     // Catch: Throwable -> L16
        r0 = (String) r1.get(null);     // Catch: Throwable -> L16
    L8:
        if (TextUtils.isEmpty(r0) == false) goto L10;
    L14:
        m = r5.getApplicationContext();
        n = new i();
        d.b.h.a.a.h.o.b.z.l.m().o(m);
        d.b.h.a.a.h.o.b.x.e.q().B(new a(this));
        return;
    L10:
        if (r0.startsWith("okhttp/") == false) goto L12;
        String r2 = r0.replaceFirst("okhttp/", "tt-ok/");
    L13:
        f13539k = r2;
        goto L14
    L12:
        r2 = "tt-ok/" + r0;
        goto L13
    }

    static /* synthetic */ Context f() {
        return m;
    }

    static /* synthetic */ d.b.h.a.a.h.o.a g() {
        return f13540l;
    }

    public static a0 h() {
        return n.a(false);
    }

    public static Context i() {
        return m;
    }

    public static String j() {
        if (TextUtils.isEmpty(f13538j) == false) goto L12;
        StringBuilder r0 = new StringBuilder();
        r0.append(m.getPackageName());
        r0.append('/');
        r0.append(y(m));
        r0.append(" (Linux; U; Android ");
        r0.append(Build.VERSION.RELEASE);
        r0.append("; ");
        r0.append(Locale.getDefault().toString());
        String r2 = Build.MODEL;
        if (r2.length() <= 0) goto L7;
        r0.append("; ");
        r0.append(r2);
    L7:
        String r1 = Build.ID;
        if (r1.length() <= 0) goto L10;
        r0.append("; Build/");
        r0.append(r1);
    L10:
        r0.append(";");
        r0.append(f13539k);
        r0.append(')');
        f13538j = r0.toString();
    L12:
        return f13538j;
    }

    public static String k() {
        return f13534f;
    }

    public static int l() {
        return f13533e;
    }

    public static String m(d.b.r.h0.c r4) {
        if (r4 != null) goto L4;
        return "null-metrics";
    L4:
        if (r4.z() != null) goto L7;
        return "null-metrics";
    L7:
        return "fallback_reason=" + f13533e + ",fallback-message=" + Base64.encodeToString(f13534f.getBytes(), 2) + ",request-fallback-reason=" + r4.z().f14621h + ",request-fallback-message=" + Base64.encodeToString(r4.z().f14622i.getBytes(), 2);
    }

    public static boolean n() {
        return f13532d;
    }

    public static g o() {
        return o;
    }

    public static d.b.h.a.a.h.o.a p() {
        return f13540l;
    }

    public static String q() {
        return f13539k;
    }

    public static Proxy r() {
        return f13535g;
    }

    public static void s(d.b.h.a.a.h.o.a r0) {
        f13540l = r0;
    }

    public static s t(Context r2) {
        if (f13531c != null) goto L15;
        monitor-enter(s.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f13531c != null) goto L9;
        f13531c = new s(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(s.class);     // Catch: Throwable -> L11
    L15:
        return f13531c;
    }

    public static void u(String r0) {
        f13534f = r0;
    }

    public static void v(int r0) {
        f13533e = r0;
    }

    public static void x(String r7) {
        if (r7 != null) goto L5;
        f13535g = null;
        return;
    L5:
        String[] r0 = r7.split(";");
        if (r0.length <= 0) goto L31;
        String[] r1 = r0[0].trim().split("=");
        if (r1.length != 2) goto L29;
        String r3 = r1[0].trim().toLowerCase();
        String[] r2 = r1[1].trim().split(":");
        if (r2.length != 2) goto L27;
        InetSocketAddress r4 = new InetSocketAddress(r2[0], Integer.parseInt(r2[1]));
        if (r3.equals("http") == false) goto L14;
    L23:
        Proxy r8 = new Proxy(Proxy.Type.HTTP, r4);
    L24:
        f13535g = r8;
        return;
    L14:
        if (r3.equals(LocationInfoConst.HTTPS) == true) goto L23;
        if (r3.equals("socks") == false) goto L19;
    L22:
        r8 = new Proxy(Proxy.Type.SOCKS, r4);
        goto L24
    L19:
        if (r3.equals("socks4") == true) goto L22;
        if (r3.equals("socks5") == true) goto L22;
        return;
    L27:
        throw new IllegalArgumentException("Invalid proxy rule:" + r7);
    L29:
        throw new IllegalArgumentException("Invalid proxy rule:" + r7);
    L31:
        throw new IllegalArgumentException("Invalid proxy rule:" + r7);
    }

    private static int y(Context r3) {
        Object r0 = f13536h;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (f13537i == 0) goto L16;
    L9:
        int r4 = f13537i;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r4;
    L16:
        f13537i = r3.getPackageManager().getPackageInfo(r3.getPackageName(), 0).versionCode;     // Catch: PackageManager.NameNotFoundException -> L15 Throwable -> L12
        goto L9
    }

    @Override // d.b.r.h0.a
    public d.b.r.h0.e a(d.b.r.h0.c r6) {
        d.b.r.h0.c r5 = d.b.h.a.a.h.r.b.n().d(r6);     // Catch: Throwable -> L12
        if (r5 == null) goto L5;
        r6 = r5;
    L5:
        long r0 = SystemClock.uptimeMillis();
        d.b.r.h0.c r7 = d.b.h.a.a.j.d.f().e(r6);
        if (r6.z() == null) goto L8;
        y r2 = r6.z();
        r2.g0 = SystemClock.uptimeMillis() - r0;
    L8:
        if (r7 == null) goto L11;
        r6 = r7;
    L11:
        return new f(r6);
    }

    public void w(g r1) {
        o = r1;
    }
}
