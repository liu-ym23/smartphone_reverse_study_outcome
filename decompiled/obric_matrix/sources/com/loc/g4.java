package com.loc;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdlocation.client.BDLocationConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public final class g4 {
    static long A;
    public static HashMap<String, Long> B;
    public static long C;
    static int D;
    public static long E;
    static long w;
    static long x;
    static long y;
    public static long z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    WifiManager f7325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ArrayList<i3> f7326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ArrayList<i3> f7327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Context f7328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f7329e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    StringBuilder f7330f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f7331g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f7332h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f7333i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile WifiInfo f7334j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    String f7335k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    TreeMap<Integer, i3> f7336l;
    public boolean m;
    public boolean n;
    public boolean o;
    f4 p;
    String q;
    long r;
    ConnectivityManager s;
    private long t;
    private t3 u;
    volatile boolean v;

    static {
        B = new HashMap(36);
        C = 0;
        D = 0;
        E = 0;
    }

    public g4(Context r5, WifiManager r6, Handler r7) {
        this.f7326b = new ArrayList();
        this.f7327c = new ArrayList();
        this.f7329e = false;
        this.f7330f = null;
        this.f7331g = true;
        this.f7332h = true;
        this.f7333i = true;
        this.f7334j = null;
        this.f7335k = null;
        this.f7336l = null;
        this.m = true;
        this.n = true;
        this.o = false;
        this.q = "";
        this.r = 0;
        this.s = null;
        this.t = 30000;
        this.v = false;
        this.f7325a = r6;
        this.f7328d = r5;
        f4 r8 = new f4(r5, "wifiAgee", r7);
        this.p = r8;
        r8.c();
    }

    public static String A() {
        return String.valueOf(a5.A() - z);
    }

    private List<i3> C() {
        int r0 = Build.VERSION.SDK_INT;
        if (this.f7325a != null) goto L50;
    L49:
        return null;
    L50:
    L47:
        e = move-exception;
        this.f7335k = e.getMessage();
    L45:
        th = move-exception;
        this.f7335k = null;
        s4.h(th, "WifiManagerWrapper", "getScanResults");
        goto L49
    L5:
        if (a5.M(this.f7328d, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF") == false) goto L7;
        List<ScanResult> r1 = this.f7325a.getScanResults();     // Catch: Throwable -> L45 SecurityException -> L47
    L9:
        if (r0 < 17) goto L22;
        HashMap<String, Long> r4 = new HashMap(36);     // Catch: Throwable -> L45 SecurityException -> L47
        if (r1 == null) goto L17;
        Iterator<ScanResult> r5 = r1.iterator();     // Catch: Throwable -> L45 SecurityException -> L47
    L14:
        if (r5.hasNext() == false) goto L17;
        ScanResult r6 = r5.next();     // Catch: Throwable -> L45 SecurityException -> L47
        r4.put(r6.BSSID, Long.valueOf(r6.timestamp));     // Catch: Throwable -> L45 SecurityException -> L47
    L17:
        if (B.isEmpty() == false) goto L19;
    L20:
        B = r4;     // Catch: Throwable -> L45 SecurityException -> L47
        long r7 = a5.A();     // Catch: Throwable -> L45 SecurityException -> L47
    L21:
        C = r7;     // Catch: Throwable -> L45 SecurityException -> L47
    L23:
        this.f7335k = null;     // Catch: Throwable -> L45 SecurityException -> L47
        ArrayList r8 = new ArrayList();     // Catch: Throwable -> L45 SecurityException -> L47
        this.q = "";     // Catch: Throwable -> L45 SecurityException -> L47
        this.f7334j = x();     // Catch: Throwable -> L45 SecurityException -> L47
        if (i(this.f7334j) == false) goto L26;
        this.q = this.f7334j.getBSSID();     // Catch: Throwable -> L45 SecurityException -> L47
    L26:
        if (r1 != null) goto L28;
    L43:
        this.p.f(r8);     // Catch: Throwable -> L45 SecurityException -> L47
        return r8;
    L28:
        if (r1.size() <= 0) goto L43;
        int r9 = r1.size();     // Catch: Throwable -> L45 SecurityException -> L47
        int r10 = 0;
    L30:
        if (r10 >= r9) goto L43;
        ScanResult r11 = r1.get(r10);     // Catch: Throwable -> L45 SecurityException -> L47
        String r12 = r11.BSSID;     // Catch: Throwable -> L45 SecurityException -> L47
        if (TextUtils.isEmpty(this.q) == false) goto L34;
    L36:
        boolean r13 = false;
    L37:
        i3 r14 = new i3(r13);     // Catch: Throwable -> L45 SecurityException -> L47
        r14.f7374b = r11.SSID;     // Catch: Throwable -> L45 SecurityException -> L47
        r14.f7376d = r11.frequency;     // Catch: Throwable -> L45 SecurityException -> L47
        r14.f7377e = r11.timestamp;     // Catch: Throwable -> L45 SecurityException -> L47
        r14.f7373a = i3.a(r11.BSSID);     // Catch: Throwable -> L45 SecurityException -> L47
        r14.f7375c = (short) r11.level;     // Catch: Throwable -> L45 SecurityException -> L47
        if (r0 < 17) goto L42;
        short r15 = (short) ((SystemClock.elapsedRealtime() - (r11.timestamp / 1000)) / 1000);     // Catch: Throwable -> L45 SecurityException -> L47
        r14.f7379g = r15;     // Catch: Throwable -> L45 SecurityException -> L47
        if (r15 >= 0) goto L42;
        r14.f7379g = 0;     // Catch: Throwable -> L45 SecurityException -> L47
    L42:
        r14.f7378f = a5.A();     // Catch: Throwable -> L45 SecurityException -> L47
        r8.add(r14);     // Catch: Throwable -> L45 SecurityException -> L47
        r10 = r10 + 1;     // Catch: Throwable -> L45 SecurityException -> L47
        goto L30
    L34:
        if (this.q.equals(r12) == false) goto L36;
        r13 = true;
        goto L37
    L19:
        if (B.equals(r4) == true) goto L23;
    L22:
        r7 = a5.A();     // Catch: Throwable -> L45 SecurityException -> L47
        goto L21
    L7:
        s4.h(new Exception("gst_n_aws"), "OPENSDK_WMW", "gsr_n_aws");     // Catch: Throwable -> L45 SecurityException -> L47
        r1 = null;
        goto L9
    }

    private int D() {
        WifiManager r0 = this.f7325a;
        if (r0 != null) goto L5;
        return 4;
    L5:
        return r0.getWifiState();
    }

    private boolean E() {
        long r0 = a5.A() - w;
        if (r0 >= 4900) goto L6;
        return false;
    L6:
        if (F() == false) goto L11;
        if (r0 >= 9900) goto L11;
        return false;
    L11:
        if (D <= 1) goto L25;
        long r5 = this.t;
        if (r5 != 30000) goto L20;
        if (r4.F() == (-1)) goto L18;
        r5 = r4.F();
        goto L20
    L18:
        r5 = 30000;
    L20:
        if (Build.VERSION.SDK_INT < 28) goto L25;
        if (r0 >= r5) goto L25;
        return false;
    L25:
        if (this.f7325a == null) goto L34;
        w = a5.A();
        int r1 = D;
        if (r1 >= 2) goto L30;
        D = r1 + 1;
    L30:
        if (a5.M(this.f7328d, "WYW5kcm9pZC5wZXJtaXNzaW9uLkNIQU5HRV9XSUZJX1NUQVRF") == true) goto L32;
        s4.h(new Exception("n_cws"), "OPENSDK_WMW", "wfs_n_cws");
        goto L34
    L32:
        return this.f7325a.startScan();
    L34:
        return false;
    }

    private boolean F() {
        if (this.s != null) goto L6;
        this.s = (ConnectivityManager) a5.g(this.f7328d, "connectivity");
    L6:
        return h(this.s);
    }

    private boolean G() {
        if (this.f7325a != null) goto L7;
        return false;
    L7:
        return a5.X(this.f7328d);
    }

    private void H() {
        if (b() == false) goto L15;
        long r0 = a5.A();
        int r2 = 20;
        if ((r0 - x) < BDLocationConfig.sScanBleMaxInterval) goto L7;
        this.f7326b.clear();
        A = z;
    L7:
        I();
        if ((r0 - x) < BDLocationConfig.sScanBleMaxInterval) goto L22;
    L9:
        if (r2 <= 0) goto L23;
        if (z != A) goto L24;
        Thread.sleep(150);     // Catch: Throwable -> L16
    L14:
        r2 = r2 - 1;
        goto L9
    L24:
        return;
    L23:
        return;
    L22:
        return;
    }

    private void I() {
        if (b() == false) goto L14;
    L8:
        th = move-exception;
        s4.h(th, "WifiManager", "wifiScan");
        return;
    L5:
        if (E() == false) goto L13;
        y = a5.A();     // Catch: Throwable -> L8
        return;
    L13:
        return;
    }

    private void J() {
        if (A == z) goto L17;
        List<i3> r0 = null;
        r0 = C();     // Catch: Throwable -> L7
    L9:
        A = z;
        if (r0 == null) goto L13;
        this.f7326b.clear();
        this.f7326b.addAll(r0);
        return;
    L13:
        this.f7326b.clear();
        return;
    L7:
        th = move-exception;
        s4.h(th, "WifiManager", "updateScanResult");
        goto L9
    }

    private void K() {
        if (this.f7325a != null) goto L23;
        return;
    L23:
        int r1 = D();     // Catch: Throwable -> L8
    L11:
        if (this.f7326b != null) goto L13;
        this.f7326b = new ArrayList();     // Catch: Throwable -> L20
    L13:
        if (r1 != 0) goto L15;
    L18:
        r();     // Catch: Throwable -> L20
        return;
    L15:
        if (r1 == 1) goto L18;
        if (r1 == 4) goto L18;
        return;
    L8:
        th = move-exception;
        s4.h(th, "OPENSDK_WMW", "cwsc");     // Catch: Throwable -> L20
        r1 = 4;
    }

    private void a() {
    L6:
        u4.c();
        return;
    L3:
        if (a5.M(this.f7328d, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF") == false) goto L10;
        this.n = this.f7325a.isWifiEnabled();     // Catch: Throwable -> L6
        return;
    }

    private boolean b() {
        this.m = G();
        a();
        if (this.m == true) goto L6;
    L19:
        return false;
    L6:
        if (this.f7331g == false) goto L19;
        if (y != 0) goto L12;
        return true;
    L12:
        if ((a5.A() - y) < 4900) goto L19;
        if ((a5.A() - z) < 1500) goto L19;
        int r9 = ((a5.A() - z) > 4900 ? 1 : ((a5.A() - z) == 4900 ? 0 : -1));
        return true;
    }

    private static boolean g(int r3) {
        int r0 = 20;
        r0 = WifiManager.calculateSignalLevel(r3, 20);     // Catch: ArithmeticException -> L5
    L7:
        if (r0 <= 0) goto L10;
        return true;
    L10:
        return false;
    L5:
        e = move-exception;
        s4.h(e, "Aps", "wifiSigFine");
        goto L7
    }

    public static boolean i(WifiInfo r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r2.getSSID()) == false) goto L9;
        return false;
    L9:
        if (a5.r(r2.getBSSID()) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public static long j() {
        return ((a5.A() - C) / 1000) + 1;
    }

    private void o(boolean r6) {
        ArrayList<i3> r0 = this.f7326b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEmpty() == false) goto L8;
        return;
    L8:
        if ((a5.A() - z) <= 3600000) goto L11;
        r();
    L11:
        if (this.f7336l != null) goto L13;
        this.f7336l = new TreeMap(Collections.reverseOrder());
    L13:
        this.f7336l.clear();
        if (this.o == false) goto L17;
        if (r6 == false) goto L17;
        this.f7327c.clear();     // Catch: Throwable -> L50
    L17:
        int r1 = this.f7326b.size();
        this.r = 0;
        int r2 = 0;
    L18:
        if (r2 >= r1) goto L44;
        i3 r3 = this.f7326b.get(r2);
        if (r3.f7380h == false) goto L22;
        this.r = r3.f7378f;
    L22:
        if (r3 == null) goto L24;
        String r4 = i3.c(r3.f7373a);
    L26:
        if (a5.r(r4) == false) goto L43;
        if (r1 <= 20) goto L32;
        if (g(r3.f7375c) == false) goto L43;
    L32:
        if (this.o == false) goto L36;
        if (r6 == false) goto L36;
        this.f7327c.add(r3);
    L36:
        if (TextUtils.isEmpty(r3.f7374b) == false) goto L38;
        String r5 = "unkwn";
    L41:
        r3.f7374b = r5;
    L42:
        this.f7336l.put(Integer.valueOf((r3.f7375c * 25) + r2), r3);
        goto L43
    L38:
        if ("<unknown ssid>".equals(r3.f7374b) == true) goto L42;
        r5 = String.valueOf(r2);
    L43:
        r2 = r2 + 1;
        goto L18
    L24:
        r4 = "";
        goto L26
    L44:
        this.f7326b.clear();
        Iterator<i3> r7 = this.f7336l.values().iterator();
    L46:
        if (r7.hasNext() == false) goto L48;
        i3 r8 = r7.next();
        this.f7326b.add(r8);
        goto L46
    L48:
        this.f7336l.clear();
    }

    public final long B() {
        return this.r;
    }

    public final ArrayList<i3> c() {
        if (this.o == false) goto L5;
        k(true);
        return this.f7327c;
    L5:
        return this.f7327c;
    }

    public final void d(t3 r1) {
        this.u = r1;
    }

    public final void e(boolean r9) {
        Context r1 = this.f7328d;
        if (r4.E() == true) goto L5;
        return;
    L5:
        if (this.f7333i == true) goto L8;
        return;
    L8:
        if (this.f7325a == null) goto L27;
        if (r1 == null) goto L28;
        if (r9 == true) goto L13;
        return;
    L13:
        if (a5.J() > 17) goto L15;
        return;
    L15:
        ContentResolver r8 = r1.getContentResolver();
    L20:
        th = move-exception;
        s4.h(th, "WifiManagerWrapper", "enableWifiAlwaysScan");
        return;
    L17:
        if (((Integer) w4.e("android.provider.Settings$Global", "getInt", new Object[]{r8, "wifi_scan_always_enabled"}, new Class[]{ContentResolver.class, String.class})).intValue() != 0) goto L25;
        w4.e("android.provider.Settings$Global", "putInt", new Object[]{r8, "wifi_scan_always_enabled", 1}, new Class[]{ContentResolver.class, String.class, Integer.TYPE});     // Catch: Throwable -> L20
        return;
    L25:
        return;
    L28:
        return;
    }

    public final void f(boolean r1, boolean r2, boolean r3, long r4) {
        this.f7331g = r1;
        this.f7332h = r2;
        this.f7333i = r3;
        if (r4 >= BDLocationConfig.sScanBleMaxInterval) goto L6;
        this.t = BDLocationConfig.sScanBleMaxInterval;
        return;
    L6:
        this.t = r4;
    }

    public final boolean h(ConnectivityManager r3) {
    L8:
        th = move-exception;
        s4.h(th, "WifiManagerWrapper", "wifiAccess");
        return false;
    L4:
        if (a5.e(r3.getActiveNetworkInfo()) != 1) goto L13;
        if (i(l()) == true) goto L15;
        return false;
    L15:
        return true;
    L13:
        return false;
    }

    public final void k(boolean r6) {
        if (r6 == false) goto L4;
        H();
    L5:
        boolean r0 = false;
        if (this.v == false) goto L8;
        this.v = false;
        K();
    L8:
        J();
        if ((a5.A() - z) <= 20000) goto L11;
        this.f7326b.clear();
    L11:
        x = a5.A();
        if (this.f7326b.isEmpty() == false) goto L16;
        z = a5.A();
        List<i3> r7 = C();
        if (r7 == null) goto L16;
        this.f7326b.addAll(r7);
        r0 = true;
    L16:
        o(r0);
        return;
    L4:
        I();
        goto L5
    }

    public final WifiInfo l() {
    L11:
        th = move-exception;
        s4.h(th, "WifiManagerWrapper", "getConnectionInfo");
        return null;
    L4:
        if (this.f7325a != null) goto L6;
        return null;
    L6:
        if (a5.M(this.f7328d, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF") == true) goto L8;
        s4.h(new Exception("gci_n_aws"), "OPENSDK_WMW", "gci_n_aws");     // Catch: Throwable -> L11
        return null;
    L8:
        return this.f7325a.getConnectionInfo();
    }

    public final void m(boolean r2) {
        r();
        this.f7326b.clear();
        this.p.g(r2);
    }

    public final String n() {
        return this.f7335k;
    }

    public final ArrayList<i3> p() {
        if (this.f7326b != null) goto L6;
        return null;
    L6:
        ArrayList<i3> r0 = new ArrayList();
        if (this.f7326b.isEmpty() == true) goto L9;
        r0.addAll(this.f7326b);
    L9:
        return r0;
    }

    public final void q() {
        this.o = true;     // Catch: Throwable -> L8
        List<i3> r1 = C();     // Catch: Throwable -> L8
        if (r1 == null) goto L6;
        this.f7326b.clear();     // Catch: Throwable -> L8
        this.f7326b.addAll(r1);     // Catch: Throwable -> L8
    L6:
        o(true);     // Catch: Throwable -> L8
        return;
    }

    public final void r() {
        this.f7334j = null;
        this.f7326b.clear();
    }

    public final void s() {
        E = System.currentTimeMillis();
        t3 r2 = this.u;
        if (r2 == null) goto L6;
        r2.m();
        return;
    }

    public final void t() {
        if (this.f7325a != null) goto L6;
        return;
    L6:
        if ((a5.A() - z) <= 4900) goto L9;
        z = a5.A();
        return;
    }

    public final void u() {
        if (this.f7325a != null) goto L5;
        return;
    L5:
        this.v = true;
    }

    public final boolean v() {
        return this.m;
    }

    public final boolean w() {
        return this.n;
    }

    public final WifiInfo x() {
        this.f7334j = l();
        return this.f7334j;
    }

    public final boolean y() {
        return this.f7329e;
    }

    public final String z() {
        StringBuilder r0 = this.f7330f;
        if (r0 != null) goto L5;
        this.f7330f = new StringBuilder(TypedValues.TransitionType.TYPE_DURATION);
    L6:
        this.f7329e = false;
        int r1 = this.f7326b.size();
        int r2 = 0;
        boolean r3 = false;
        boolean r4 = false;
    L8:
        if (r2 >= r1) goto L22;
        String r6 = i3.c(this.f7326b.get(r2).f7373a);
        if (this.f7332h == true) goto L15;
        if ("<unknown ssid>".equals(this.f7326b.get(r2).f7374b) == true) goto L15;
        r3 = true;
    L15:
        if (TextUtils.isEmpty(this.q) == false) goto L17;
    L19:
        boolean r7 = r4;
        String r5 = "nb";
    L20:
        this.f7330f.append(String.format(Locale.US, "#%s,%s", new Object[]{r6, r5}));
        r2 = r2 + 1;
        r4 = r7;
        goto L8
    L17:
        if (this.q.equals(r6) == false) goto L19;
        r5 = "access";
        r7 = true;
        goto L20
    L22:
        if (this.f7326b.size() != 0) goto L25;
        r3 = true;
    L25:
        if (this.f7332h == true) goto L28;
        if (r3 == true) goto L28;
        this.f7329e = true;
    L28:
        if (r4 == true) goto L33;
        if (TextUtils.isEmpty(this.q) == true) goto L33;
        StringBuilder r8 = this.f7330f;
        r8.append("#");
        r8.append(this.q);
        this.f7330f.append(",access");
    L33:
        return this.f7330f.toString();
    L5:
        r0.delete(0, r0.length());
        goto L6
    }
}
