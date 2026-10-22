package com.bytedance.applog.o;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.applog.IBDAccountCallback;
import com.bytedance.applog.util.j;
import com.bytedance.applog.util.n;
import com.bytedance.bdlocation.client.BDLocationConfig;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class h {
    public static volatile long n;
    public static volatile long o;
    public static volatile int p;
    public static volatile int q;
    public static volatile int r;
    private static long s;
    private static a t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f2286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.applog.w.h f2287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bytedance.applog.w.h f2288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f2289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile long f2290e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2291f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f2292g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f2293h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f2294i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f2295j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f2296k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile String f2297l;
    private volatile long m;

    static class a extends com.bytedance.applog.w.i {
        a() {
        }
    }

    static {
    }

    h(e r3) {
        this.f2292g = -1;
        this.f2286a = r3;
        this.m = r3.q().w();
    }

    public static void b(com.bytedance.applog.w.a r4, long r5) {
        IBDAccountCallback r0 = com.bytedance.applog.a.i();
        if (com.bytedance.applog.a.m() == false) goto L11;
        if (r0 == null) goto L11;
        Pair<Integer, Long> r6 = r0.getOdinUserInfo();
        if (((Long) r6.second).longValue() <= 0) goto L9;
        r4.f2447j = ((Long) r6.second).longValue();
        r4.p = 1;
        r4.q = 1;
        r4.o = ((Integer) r6.first).intValue();
        r4.f2448k = ((Long) r6.second).longValue();
    L12:
        r4.m = com.bytedance.applog.a.f(String.valueOf(r4.f2447j));
        return;
    L9:
        if (q != 0) goto L12;
        r4.f2448k = o;
        r4.o = p;
        r4.p = q;
        r4.q = r;
    L11:
        r4.f2447j = r5;
        goto L12
    }

    public static String c() {
        return UUID.randomUUID().toString();
    }

    static a h() {
        if (t != null) goto L5;
        t = new a();
    L5:
        t.t(0);
        return t;
    }

    static boolean k(com.bytedance.applog.w.a r1) {
        if ((r1 instanceof com.bytedance.applog.w.h) == true) goto L5;
        return false;
    L5:
        return ((com.bytedance.applog.w.h) r1).E();
    }

    public static long l() {
        long r0 = s + 1;
        s = r0;
        return r0;
    }

    public void a(com.bytedance.applog.w.a r3) {
        if (r3 == null) goto L5;
        b(r3, n);
        r3.f2449l = com.bytedance.applog.a.w();
        r3.f2446i = this.f2289d;
        r3.f2445h = l();
        r3.n = com.bytedance.common.utility.i.j(this.f2286a.r()).a();
        return;
    }

    public String d() {
        return this.f2289d;
    }

    public String e() {
        return this.f2297l;
    }

    public long f() {
        return this.m;
    }

    synchronized Bundle g(long r6, long r8) {
        monitor-enter(this);
        Bundle r0 = null;
        long r1 = this.f2290e;     // Catch: Throwable -> L15
        if (this.f2286a.q().H() == true) goto L7;
    L13:
        monitor-exit(this);
        return r0;
    L7:
        if (j() == false) goto L13;
        if (r1 <= 0) goto L13;
        long r2 = r6 - r1;     // Catch: Throwable -> L15
        if (r2 <= r8) goto L13;
        r0 = new Bundle();     // Catch: Throwable -> L15
        r0.putInt("session_no", this.f2295j);     // Catch: Throwable -> L15
        int r9 = this.f2291f + 1;     // Catch: Throwable -> L15
        this.f2291f = r9;     // Catch: Throwable -> L15
        r0.putInt("send_times", r9);     // Catch: Throwable -> L15
        r0.putLong("current_duration", r2 / 1000);     // Catch: Throwable -> L15
        r0.putString("session_start_time", com.bytedance.applog.w.a.e(this.f2292g));     // Catch: Throwable -> L15
        this.f2290e = r6;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public boolean i() {
        return this.f2293h;
    }

    boolean j() {
        if (i() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f2294i != 0) goto L7;
        return true;
    }

    boolean m(com.bytedance.applog.w.a r14, ArrayList<com.bytedance.applog.w.a> r15) {
        boolean r0 = r14 instanceof com.bytedance.applog.w.h;
        boolean r1 = k(r14);
        boolean r3 = true;
        if (this.f2292g != (-1)) goto L7;
        n.e("session process start session 1, data=" + r14 + ", isResume=" + r1);
        r1 = k(r14);
    L5:
        n(r14, r15, r1);
    L20:
        if (r0 == false) goto L43;
        com.bytedance.applog.w.h r2 = (com.bytedance.applog.w.h) r14;
        if (r2.E() == false) goto L35;
        this.f2294i = 0;
        r15.add(r14);
        if (TextUtils.isEmpty(r2.w) == false) goto L45;
        com.bytedance.applog.w.h r16 = this.f2288c;
        if (r16 != null) goto L28;
    L30:
        r16 = this.f2287b;
        if (r16 == null) goto L45;
        if (((r2.f2444g - r16.f2444g) - r16.v) >= 500) goto L45;
    L29:
        r2.w = r16.x;
        goto L45
    L28:
        if (((r2.f2444g - r16.f2444g) - r16.v) >= 500) goto L30;
    L45:
        a(r14);
        return r3;
    L35:
        Bundle r4 = g(r14.f2444g, 0);
        if (r4 == null) goto L38;
        com.bytedance.applog.a.E("play_session", r4);
    L38:
        this.f2294i = r2.f2444g;
        r15.add(r14);
        if (r2.D() == false) goto L41;
        this.f2287b = r2;
        goto L45
    L41:
        this.f2288c = r2;
        this.f2287b = null;
        goto L45
    L43:
        if ((r14 instanceof a) == true) goto L45;
        r15.add(r14);
        goto L45
    L7:
        if (this.f2293h == true) goto L10;
        if (r1 == false) goto L10;
        n.e("session process start session 2, data=" + r14 + ", isResume=" + r1);
        n(r14, r15, true);
    L10:
        long r7 = this.f2294i;
        if (r7 == 0) goto L16;
        if (r14.f2444g <= (r7 + this.f2286a.q().y())) goto L16;
        StringBuilder r5 = new StringBuilder();
        String r8 = "session process start session 3, data=";
    L18:
        r5.append(r8);
        r5.append(r14);
        r5.append(", isResume=");
        r5.append(r1);
        n.e(r5.toString());
    L16:
        if (this.f2292g <= (r14.f2444g + 7200000)) goto L19;
        r5 = new StringBuilder();
        r8 = "session process start session 4, data=";
        goto L18
    L19:
        r3 = false;
        goto L20
    }

    synchronized com.bytedance.applog.w.f n(com.bytedance.applog.w.a r9, ArrayList<com.bytedance.applog.w.a> r10, boolean r11) {
        monitor-enter(this);
        if (r9 != null) goto L46;
        long r4 = 0;
    L10:
        this.f2289d = c();     // Catch: Throwable -> L43
        if (r11 == false) goto L17;
        this.m = r4;     // Catch: Throwable -> L43
        this.f2286a.q().S(this.m);     // Catch: Throwable -> L43
        if (this.f2286a.x == true) goto L17;
        if (TextUtils.isEmpty(this.f2297l) == false) goto L17;
        this.f2297l = this.f2289d;     // Catch: Throwable -> L43
    L17:
        s = BDLocationConfig.sScanBleMaxInterval;     // Catch: Throwable -> L43
        this.f2292g = r4;     // Catch: Throwable -> L43
        this.f2293h = r11;     // Catch: Throwable -> L43
        this.f2294i = 0;     // Catch: Throwable -> L43
        this.f2290e = 0;     // Catch: Throwable -> L43
        boolean r12 = false;
        if (r11 == false) goto L27;
        Calendar r13 = Calendar.getInstance();     // Catch: Throwable -> L43
        String r14 = "" + r13.get(1) + r13.get(2) + r13.get(5);     // Catch: Throwable -> L43
        com.bytedance.applog.q.b r3 = this.f2286a.q();     // Catch: Throwable -> L43
        if (TextUtils.isEmpty(this.f2296k) == false) goto L23;
        this.f2296k = r3.v();     // Catch: Throwable -> L43
        this.f2295j = r3.z();     // Catch: Throwable -> L43
    L23:
        if (r14.equals(this.f2296k) == true) goto L25;
        this.f2296k = r14;     // Catch: Throwable -> L43
        this.f2295j = 1;     // Catch: Throwable -> L43
    L26:
        r3.R(r14, this.f2295j);     // Catch: Throwable -> L43
        this.f2291f = 0;     // Catch: Throwable -> L43
        this.f2290e = r4;     // Catch: Throwable -> L43
        goto L27
    L25:
        this.f2295j++;     // Catch: Throwable -> L43
    L27:
        com.bytedance.applog.w.f r15 = null;
        if (r4 == (-1)) goto L34;
        r15 = new com.bytedance.applog.w.f();     // Catch: Throwable -> L43
        r15.f2446i = this.f2289d;     // Catch: Throwable -> L43
        if (this.f2293h == true) goto L32;
        r12 = true;
    L32:
        r15.x = r12;     // Catch: Throwable -> L43
        r15.f2445h = l();     // Catch: Throwable -> L43
        r15.t(this.f2292g);     // Catch: Throwable -> L43
        r15.w = this.f2286a.t().j();     // Catch: Throwable -> L43
        r15.v = this.f2286a.t().i();     // Catch: Throwable -> L43
        b(r15, n);     // Catch: Throwable -> L43
        r15.f2449l = com.bytedance.applog.a.w();     // Catch: Throwable -> L43
        r10.add(r15);     // Catch: Throwable -> L43
        j.b().a(r15.f2446i, r15.f2444g, r15.x);     // Catch: Throwable -> L43
    L34:
        if (com.bytedance.applog.a.f2201d > 0) goto L36;
        com.bytedance.applog.a.f2201d = 6;     // Catch: Throwable -> L43
    L36:
        StringBuilder r16 = new StringBuilder();     // Catch: Throwable -> L43
        r16.append("startSession, ");     // Catch: Throwable -> L43
        if (this.f2293h == false) goto L39;
        String r17 = "fg";
    L40:
        r16.append(r17);     // Catch: Throwable -> L43
        r16.append(", ");     // Catch: Throwable -> L43
        r16.append(this.f2289d);     // Catch: Throwable -> L43
        r16.append(", ");     // Catch: Throwable -> L43
        r16.append(r4);     // Catch: Throwable -> L43
        n.e(r16.toString());     // Catch: Throwable -> L43
        monitor-exit(this);
        return r15;
    L43:
        th = move-exception;
        throw th;
    L39:
        r17 = "bg";
        goto L40
    L46:
        if ((r9 instanceof a) == false) goto L8;
        r4 = -1;
        goto L10
    L8:
        r4 = r9.f2444g;     // Catch: Throwable -> L43
        goto L10
    }
}
