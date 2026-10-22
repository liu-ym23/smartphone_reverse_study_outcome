package com.bytedance.common.utility;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Pair;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f3275a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f3276b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static d.b.n.b f3277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static b f3278d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static a f3279e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f3280f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile long f3281g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static long f3282h;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f3283g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f3284h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f3285i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final a f3286j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final a f3287k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final a f3288l = null;
        public static final a m = null;
        public static final a n = null;
        public static final a o = null;
        public static final a p = null;
        public static final a q = null;
        public static final a r = null;
        private static final /* synthetic */ a[] s = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final int f3289f;

        static {
            a r0 = new a("UNKNOWN", 0, -1);
            f3283g = r0;
            a r1 = new a("NONE", 1, 0);
            f3284h = r1;
            a r3 = new a("MOBILE", 2, 1);
            f3285i = r3;
            a r5 = new a("MOBILE_2G", 3, 2);
            f3286j = r5;
            a r7 = new a("MOBILE_3G", 4, 3);
            f3287k = r7;
            a r9 = new a("WIFI", 5, 4);
            f3288l = r9;
            a r11 = new a("MOBILE_4G", 6, 5);
            m = r11;
            a r13 = new a("MOBILE_5G", 7, 6);
            n = r13;
            a r15 = new a("WIFI_24GHZ", 8, 7);
            o = r15;
            a r14 = new a("WIFI_5GHZ", 9, 8);
            p = r14;
            a r12 = new a("MOBILE_3G_H", 10, 9);
            q = r12;
            a r10 = new a("MOBILE_3G_HP", 11, 10);
            r = r10;
            s = new a[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10};
        }

        private a(String r1, int r2, int r3) {
            super(r1, r2);
            this.f3289f = r3;
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) s.clone();
        }

        public int a() {
            return this.f3289f;
        }

        public boolean b() {
            if (this != f3285i) goto L5;
        L8:
            return true;
        L5:
            if (this == f3286j) goto L8;
            return false;
        }

        public boolean c() {
            if (this != f3287k) goto L5;
        L14:
            return true;
        L5:
            if (this == q) goto L14;
            if (this == r) goto L14;
            if (this == m) goto L14;
            if (this == n) goto L14;
            return false;
        }

        public boolean g() {
            if (this != f3283g) goto L5;
        L7:
            return false;
        L5:
            if (this == f3284h) goto L7;
            return true;
        }
    }

    public interface b {
        a a();
    }

    static {
        f3279e = a.f3283g;
        f3280f = false;
        f3281g = 2000;
        f3282h = 0;
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent a(Context r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    private static void b(Context r4) {
        if ((System.currentTimeMillis() - f3282h) <= f3281g) goto L6;
        f3279e = k(r4);
        f3282h = System.currentTimeMillis();
        return;
    }

    private static void c(Context r2) {
        b r0 = f3278d;
        if (r0 != null) goto L5;
    L8:
        r(r2);
        if (f3279e != a.f3283g) goto L12;
        f3279e = k(r2);
        return;
    L12:
        return;
    L5:
        if (r0.a() == a.f3284h) goto L8;
        f3279e = f3278d.a();
    }

    private static String d(String r0, String r1) {
        if (r1 != null) goto L10;
        r1 = "ISO-8859-1";
    L10:
        return URLEncoder.encode(r0, r1);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static String e(List<Pair<String, String>> r4, String r5) {
        StringBuilder r0 = new StringBuilder();
        Iterator<Pair<String, String>> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L14;
        Pair<String, String> r1 = r6.next();
        String r2 = d((String) r1.first, r5);
        String r3 = (String) r1.second;
        if (r3 == null) goto L8;
        String r7 = d(r3, r5);
    L10:
        if (r0.length() <= 0) goto L12;
        r0.append("&");
    L12:
        r0.append(r2);
        r0.append("=");
        r0.append(r7);
        goto L4
    L8:
        r7 = "";
        goto L10
    L14:
        return r0.toString();
    }

    public static String f(Context r1) {
        if (f3277c != null) goto L6;
        f3277c = new d.b.n.b(r1);
    L6:
        return f3277c.a();
    }

    public static String g(Context r0) {
        return h(i(r0));
    }

    public static String h(a r1) {
        if (r1 != a.f3288l) goto L6;
        return "wifi";
    L6:
        if (r1 != a.o) goto L9;
        return "wifi24ghz";
    L9:
        if (r1 != a.p) goto L12;
        return "wifi5ghz";
    L12:
        if (r1 != a.f3286j) goto L15;
        return "2g";
    L15:
        if (r1 != a.f3287k) goto L18;
        return "3g";
    L18:
        if (r1 != a.q) goto L21;
        return "3gh";
    L21:
        if (r1 != a.r) goto L24;
        return "3ghp";
    L24:
        if (r1 != a.m) goto L27;
        return "4g";
    L27:
        if (r1 != a.n) goto L30;
        return "5g";
    L30:
        if (r1 != a.f3285i) goto L32;
        return "mobile";
    L32:
        return "";
    }

    public static a i(Context r1) {
        if (f3275a == false) goto L7;
        return j(r1);
    L7:
        return k(r1);
    }

    public static a j(Context r0) {
        c(r0);
        b(r0);
        return f3279e;
    }

    private static a k(Context r2) {
        if (f3276b == true) goto L5;
        NetworkInfo r0 = ((ConnectivityManager) r2.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L38
        if (r0 == null) goto L37;
        if (r0.isAvailable() == false) goto L37;
        int r1 = r0.getType();     // Catch: Throwable -> L38
        if (1 == r1) goto L14;
        if (r1 != 0) goto L35;
        int r3 = ((TelephonyManager) r2.getSystemService("phone")).getNetworkType();     // Catch: Throwable -> L38
        if (r3 == 3) goto L33;
        if (r3 == 20) goto L31;
        if (r3 == 5) goto L33;
        if (r3 == 6) goto L33;
        switch(r3) {
            case 8: goto L33;
            case 9: goto L33;
            case 10: goto L33;
            default: goto L25;
        };     // Catch: Throwable -> L38
    L25:
        switch(r3) {
            case 12: goto L33;
            case 13: goto L29;
            case 14: goto L33;
            case 15: goto L33;
            default: goto L27;
        };     // Catch: Throwable -> L38
    L27:
        return a.f3285i;
    L29:
        return a.m;
    L31:
        return a.n;
    L33:
        return a.f3287k;
    L35:
        return a.f3285i;
    L14:
        return a.f3288l;
    L37:
        return a.f3284h;
    L39:
        return a.f3285i;
    L5:
        return l(r2);
    }

    private static a l(Context r6) {
        String r0 = f(r6);     // Catch: Throwable -> L42
        boolean r1 = q(r0);     // Catch: Throwable -> L42
        if (r1 == true) goto L18;
        NetworkInfo r4 = ((ConnectivityManager) r6.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L42
        if (r4 == null) goto L16;
        if (r4.isAvailable() == false) goto L16;
        int r5 = r4.getType();     // Catch: Throwable -> L42
        if (1 != r5) goto L13;
        r0 = "WIFI";
        goto L18
    L13:
        if (r5 != 0) goto L18;
        r0 = "MOBILE";
    L16:
        return a.f3284h;
    L18:
        if ("WIFI".equals(r0) == false) goto L22;
        return a.f3288l;
    L22:
        if ("MOBILE".equals(r0) == false) goto L41;
        if (r1 == true) goto L25;
        int r2 = ((TelephonyManager) r6.getSystemService("phone")).getNetworkType();     // Catch: Throwable -> L42
    L26:
        switch(r2) {
            case 1: goto L39;
            case 2: goto L39;
            case 3: goto L37;
            case 4: goto L39;
            case 5: goto L37;
            case 6: goto L37;
            case 7: goto L39;
            case 8: goto L37;
            case 9: goto L37;
            case 10: goto L37;
            case 11: goto L39;
            case 12: goto L37;
            case 13: goto L31;
            case 14: goto L37;
            case 15: goto L37;
            case 16: goto L39;
            case 17: goto L37;
            case 18: goto L31;
            case 19: goto L31;
            case 20: goto L29;
            default: goto L45;
        };     // Catch: Throwable -> L42
    L45:
        return a.f3283g;
    L29:
        return a.n;
    L31:
        if (n(r6) == false) goto L35;
        return a.n;
    L35:
        return a.m;
    L37:
        return a.f3287k;
    L39:
        return a.f3286j;
    L25:
        r2 = m(r6);     // Catch: Throwable -> L42
        goto L26
    L41:
        return a.f3284h;
    L43:
        return a.f3284h;
    }

    public static int m(Context r1) {
        if (f3277c != null) goto L6;
        f3277c = new d.b.n.b(r1);
    L6:
        return f3277c.b();
    }

    public static boolean n(Context r1) {
        if (f3277c != null) goto L6;
        f3277c = new d.b.n.b(r1);
    L6:
        return f3277c.c();
    }

    public static boolean o(Context r2) {
        NetworkInfo r3 = ((ConnectivityManager) r2.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r3 == null) goto L12;
        if (r3.isConnected() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    public static boolean p(Context r0) {
        c(r0);
        b(r0);
        return f3279e.g();
    }

    private static boolean q(String r1) {
        if ("NOT_REGISTERED".equals(r1) == false) goto L5;
        return false;
    L5:
        if ("NOT_SUPPORTED".equals(r1) == false) goto L7;
        return false;
    L7:
        if ("DISCONNECTED".equals(r1) == true) goto L14;
        return true;
    L14:
        return false;
    }

    private static void r(Context r2) {
        if (f3280f == true) goto L7;
        if (r2 == null) goto L8;
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        r0.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        r0.addAction("android.net.wifi.STATE_CHANGE");
        a(r2.getApplicationContext(), new h(), r0);
        f3280f = true;
        return;
    L8:
        return;
    }

    static void s(a r0) {
        f3279e = r0;
    }
}
