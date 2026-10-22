package com.loc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class b5 {
    private static String r = "CoarseLocation";
    private static long s = 0;
    private static boolean t = false;
    private static boolean u = false;
    private static boolean v = false;
    private static boolean w = false;
    public static volatile AMapLocation x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f7196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f7197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private w3 f7199d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f7200e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f7201f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f7202g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Handler f7203h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Context f7204i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f7205j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f7206k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private LocationManager f7207l;
    private AMapLocationClientOption m;
    private Object n;
    private boolean o;
    private AMapLocationClientOption.e p;
    private LocationListener q;

    static class a implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private b5 f7208a;

        a(b5 r1) {
            this.f7208a = r1;
        }

        final void a() {
            this.f7208a = null;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location r1) {
            b5 r0 = this.f7208a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            b5.l(r0, r1);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String r1) {
            b5 r0 = this.f7208a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            b5.j(r0);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String r1) {
            if ("gps".equalsIgnoreCase(r1) == false) goto L6;
            u4.a();
            return;
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String r1, int r2, Bundle r3) {
            b5 r0 = this.f7208a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            b5.k(r0, r2);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }
    }

    static {
    }

    public b5(Context r6, Handler r7) {
        this.f7196a = 0;
        this.f7197b = false;
        this.f7198c = 0;
        this.f7199d = null;
        this.f7200e = 240;
        this.f7201f = 80;
        this.f7202g = 0;
        this.f7205j = 0;
        this.f7206k = 0;
        this.n = new Object();
        this.o = true;
        this.p = AMapLocationClientOption.e.f500f;
        this.q = null;
        this.f7204i = r6;
        this.f7203h = r7;
        this.f7207l = (LocationManager) r6.getSystemService(LocationMonitorConst.LOCATION);     // Catch: Throwable -> L5
    L7:
        this.f7199d = new w3();
        return;
    L5:
        th = move-exception;
        s4.h(th, r, "<init>");
        goto L7
    }

    private void A() {
        u4.a();     // Catch: Throwable -> L4
        this.f7202g = 0;     // Catch: Throwable -> L4
        return;
    }

    private static void B(AMapLocation r7) {
        if (a5.p(r7) == true) goto L6;
        return;
    L6:
        if (r4.J() == false) goto L11;
        long r0 = r7.getTime();
        long r2 = System.currentTimeMillis();
        long r4 = t4.c(r0, r2, r4.K());
        if (r4 == r0) goto L12;
        r7.setTime(r4);
        y4.b(r0, r2);
        return;
    L12:
        return;
    }

    private static ew a(int r2, String r3) {
        ew r0 = new ew("");
        r0.E0(r2);
        r0.J0(r3);
        return r0;
    }

    private void c(int r1) {
        if (r1 != 0) goto L8;
        u4.a();     // Catch: Throwable -> L5
        this.f7202g = 0;     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    private void d(int r4, String r5, long r6) {
    L6:
        u4.c();
        return;
    L3:
        if (this.f7203h == null) goto L10;
        Message r0 = Message.obtain();     // Catch: Throwable -> L6
        AMapLocation r1 = new AMapLocation("");     // Catch: Throwable -> L6
        r1.E0(20);     // Catch: Throwable -> L6
        r1.J0(r5);     // Catch: Throwable -> L6
        r1.L0(11);     // Catch: Throwable -> L6
        r0.obj = r1;     // Catch: Throwable -> L6
        r0.what = r4;     // Catch: Throwable -> L6
        this.f7203h.sendMessageDelayed(r0, r6);     // Catch: Throwable -> L6
        return;
    }

    private void e(Location r10) {
        Handler r0 = this.f7203h;
        if (r0 == null) goto L5;
        r0.removeMessages(100);
    L5:
        if (r10 != null) goto L57;
        return;
    L57:
        AMapLocation r1 = new AMapLocation(r10);     // Catch: Throwable -> L46
        if (a5.p(r1) == true) goto L11;
        return;
    L11:
        if ("gps".equals(r10.getProvider()) == false) goto L14;
        String r2 = "gps_coarse";
    L13:
        r1.setProvider(r2);     // Catch: Throwable -> L46
        r1.L0(11);     // Catch: Throwable -> L46
        if (this.f7197b == false) goto L18;
    L20:
        Boolean r3 = Boolean.FALSE;     // Catch: Throwable -> L46
        if (Build.VERSION.SDK_INT < 18) goto L27;
        Boolean r4 = (Boolean) w4.c(r10, "isFromMockProvider", new Object[0]);     // Catch: Throwable -> L50
        "CoarseLocation | isFromMock=".concat(String.valueOf(r4));     // Catch: Throwable -> L49
        u4.a();     // Catch: Throwable -> L49
    L25:
        r3 = r4;
    L27:
        if (r3.booleanValue() == false) goto L36;
        r1.setMock(true);     // Catch: Throwable -> L46
        r1.T0(4);     // Catch: Throwable -> L46
        if (this.m.K() == true) goto L37;
        int r11 = this.f7206k;     // Catch: Throwable -> L46
        if (r11 <= 3) goto L34;
        y4.p(null, 2152);     // Catch: Throwable -> L46
        r1.E0(15);     // Catch: Throwable -> L46
        r1.J0("CoarseLocation has been mocked!#2007");     // Catch: Throwable -> L46
        r1.setLatitude(0.0d);     // Catch: Throwable -> L46
        r1.setLongitude(0.0d);     // Catch: Throwable -> L46
        r1.setAltitude(0.0d);     // Catch: Throwable -> L46
        r1.setSpeed(0.0f);     // Catch: Throwable -> L46
        r1.setAccuracy(0.0f);     // Catch: Throwable -> L46
        r1.setBearing(0.0f);     // Catch: Throwable -> L46
        r1.setExtras(null);     // Catch: Throwable -> L46
        s(r1);     // Catch: Throwable -> L46
        return;
    L34:
        this.f7206k = r11 + 1;     // Catch: Throwable -> L46
        return;
    L37:
        int r12 = o(r10);     // Catch: Throwable -> L46
        this.f7202g = r12;     // Catch: Throwable -> L46
        r1.R0(r12);     // Catch: Throwable -> L46
        x(r1);     // Catch: Throwable -> L46
        B(r1);     // Catch: Throwable -> L46
        AMapLocation r13 = y(r1);     // Catch: Throwable -> L46
        g(r13);     // Catch: Throwable -> L46
        p(r13);     // Catch: Throwable -> L46
        Object r5 = this.n;     // Catch: Throwable -> L46
        monitor-enter(r5);     // Catch: Throwable -> L46
        h(r13, x);     // Catch: Throwable -> L43
        monitor-exit(r5);     // Catch: Throwable -> L43
        s(r13);     // Catch: Throwable -> L46
        return;
    L43:
        th = move-exception;
        throw th;     // Catch: Throwable -> L46
    L36:
        this.f7206k = 0;     // Catch: Throwable -> L46
        goto L37
    L18:
        if (a5.p(r1) == false) goto L20;
        y4.v(this.f7204i, a5.A() - this.f7196a, s4.i(r1.getLatitude(), r1.getLongitude()));     // Catch: Throwable -> L46
        this.f7197b = true;     // Catch: Throwable -> L46
        goto L20
    L14:
        r2 = "network_coarse";
    L46:
        th = move-exception;
        s4.h(th, "CoarseLocation", "onLocationChanged");
    }

    private void g(AMapLocation r1) {
        if (a5.p(r1) == true) goto L5;
        return;
    L5:
        this.f7198c++;
    }

    private void h(AMapLocation r2, AMapLocation r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (this.m.L() == true) goto L6;
        return;
    L6:
        if (a5.c(r2, r3) >= this.f7200e) goto L11;
        s4.b(r2, r3);
        return;
    }

    static /* synthetic */ void j(b5 r0) {
        r0.A();
    }

    static /* synthetic */ void k(b5 r0, int r1) {
        r0.c(r1);
    }

    static /* synthetic */ void l(b5 r0, Location r1) {
        r0.e(r1);
    }

    private static boolean m(LocationManager r2) {
    L14:
        th = move-exception;
        String r0 = "CoarseLocation | hasProvider error: " + th.getMessage();
        u4.a();
        return u;
    L3:
        if (t == true) goto L5;
        List<String> r3 = r2.getAllProviders();     // Catch: Throwable -> L14
        if (r3 != null) goto L9;
    L11:
        u = false;     // Catch: Throwable -> L14
    L12:
        t = true;     // Catch: Throwable -> L14
        return u;
    L9:
        if (r3.size() <= 0) goto L11;
        u = r3.contains("gps");     // Catch: Throwable -> L14
        goto L12
    L5:
        return u;
    }

    private static int o(Location r1) {
        Bundle r2 = r1.getExtras();
        if (r2 == null) goto L5;
        int r3 = r2.getInt("satellites");
    L6:
        u4.c();
        return r3;
    L5:
        r3 = 0;
        goto L6
    }

    private void p(AMapLocation r7) {
        if (a5.p(r7) == true) goto L6;
        return;
    L6:
        if (this.f7203h == null) goto L25;
        long r0 = a5.A();
        if (this.m.y() > 8000) goto L10;
    L11:
        Bundle r1 = new Bundle();
        r1.putDouble("lat", r7.getLatitude());
        r1.putDouble("lon", r7.getLongitude());
        r1.putFloat("radius", r7.getAccuracy());
        r1.putLong("time", r7.getTime());
        Message r2 = Message.obtain();
        r2.setData(r1);
        r2.what = 102;
        Object r3 = this.n;
        monitor-enter(r3);
    L22:
        th = move-exception;
        throw th;
    L14:
        if (x != null) goto L18;
        Handler r6 = this.f7203h;     // Catch: Throwable -> L22
    L16:
        r6.sendMessage(r2);     // Catch: Throwable -> L22
    L20:
        monitor-exit(r3);     // Catch: Throwable -> L22
        return;
    L18:
        if (a5.c(r7, x) <= this.f7201f) goto L20;
        r6 = this.f7203h;     // Catch: Throwable -> L22
        goto L16
    L10:
        if ((r0 - this.f7205j) > (this.m.y() - 8000)) goto L11;
        return;
    }

    private static boolean r(LocationManager r2) {
    L8:
        th = move-exception;
        String r0 = "CoarseLocation | hasProvider error: " + th.getMessage();
        u4.a();
        return w;
    L3:
        if (v == true) goto L5;
        boolean r3 = r2.isProviderEnabled("network");     // Catch: Throwable -> L8
        w = r3;     // Catch: Throwable -> L8
        v = true;     // Catch: Throwable -> L8
        return r3;
    L5:
        return w;
    }

    private void s(AMapLocation r7) {
        if (this.m.B().equals(AMapLocationClientOption.b.f490g) == false) goto L9;
        if (this.m.p() <= 0.0f) goto L9;
        v(r7);
        return;
    L9:
        if ((a5.A() - this.f7205j) < (this.m.y() - 200)) goto L12;
        this.f7205j = a5.A();
        v(r7);
        return;
    }

    private boolean t() {
        boolean r0 = true;
    L16:
        u4.a();
    L18:
        return r0;
    L4:
        if (a5.J() < 28) goto L10;
        if (this.f7207l != null) goto L8;
        this.f7207l = (LocationManager) this.f7204i.getApplicationContext().getSystemService(LocationMonitorConst.LOCATION);     // Catch: Throwable -> L16
    L8:
        r0 = ((Boolean) w4.c(this.f7207l, "isLocationEnabled", new Object[0])).booleanValue();     // Catch: Throwable -> L16
    L10:
        if (a5.J() < 24) goto L18;
        if (a5.J() >= 28) goto L18;
        if (Settings.Secure.getInt(this.f7204i.getContentResolver(), LocationMonitorConst.LOCATION_MODE, 0) != 0) goto L18;
        return false;
    }

    private void u() {
        s(a(12, "定位服务没有开启，请在设置中打开定位服务开关#1206"));
    }

    private void v(AMapLocation r2) {
        if (this.f7203h == null) goto L6;
        u4.a();
        Message r0 = Message.obtain();
        r0.obj = r2;
        r0.what = 101;
        this.f7203h.sendMessage(r0);
        return;
    }

    private void w() {
        s(a(20, "模糊权限下不支持连续定位#2006"));
    }

    private void x(AMapLocation r9) {
    L11:
        th = move-exception;
        r9.N0(false);
        r9.A0("WGS84");
        String r0 = "CoarseLocation | offset error: " + th.getMessage();
        u4.a();
        return;
    L4:
        if (s4.i(r9.getLatitude(), r9.getLongitude()) == true) goto L6;
    L9:
        r9.N0(false);     // Catch: Throwable -> L11
        r9.A0("WGS84");     // Catch: Throwable -> L11
        return;
    L6:
        if (this.m.M() == false) goto L9;
        DPoint r2 = v4.d(this.f7204i, new DPoint(r9.getLatitude(), r9.getLongitude()));     // Catch: Throwable -> L11
        r9.setLatitude(r2.b());     // Catch: Throwable -> L11
        r9.setLongitude(r2.d());     // Catch: Throwable -> L11
        r9.N0(this.m.M());     // Catch: Throwable -> L11
        r9.A0("GCJ02");     // Catch: Throwable -> L11
    }

    private AMapLocation y(AMapLocation r4) {
        if (a5.p(r4) == true) goto L6;
        return r4;
    L6:
        if (this.f7198c >= 3) goto L9;
        return r4;
    L9:
        if (r4.getAccuracy() >= 0.0f) goto L11;
    L12:
        r4.setAccuracy(0.0f);
    L14:
        if (r4.getSpeed() >= 0.0f) goto L16;
    L17:
        r4.setSpeed(0.0f);
    L19:
        return this.f7199d.a(r4);
    L16:
        if (r4.getSpeed() != Float.MAX_VALUE) goto L19;
    L11:
        if (r4.getAccuracy() != Float.MAX_VALUE) goto L14;
        goto L12
    }

    private void z() {
        if (this.f7207l != null) goto L50;
        return;
    L50:
        this.o = true;     // Catch: Throwable -> L41 SecurityException -> L44
        Looper r0 = Looper.myLooper();     // Catch: Throwable -> L41 SecurityException -> L44
        if (r0 != null) goto L9;
        r0 = this.f7204i.getMainLooper();     // Catch: Throwable -> L41 SecurityException -> L44
    L9:
        this.f7196a = a5.A();     // Catch: Throwable -> L41 SecurityException -> L44
        if (r(this.f7207l) == false) goto L16;
        if (this.q != null) goto L14;
        this.q = new a(this);     // Catch: Throwable -> L41 SecurityException -> L44
    L14:
        this.f7207l.requestLocationUpdates("network", this.m.y(), this.m.p(), this.q, r0);     // Catch: Throwable -> L41 SecurityException -> L44
    L16:
        if (m(this.f7207l) == false) goto L31;
    L24:
        th = move-exception;
        String r1 = "CoarseLocation | sendExtraCommand error: " + th.getMessage();     // Catch: Throwable -> L41 SecurityException -> L44
        u4.a();     // Catch: Throwable -> L41 SecurityException -> L44
    L27:
        if (this.q != null) goto L29;
        this.q = new a(this);     // Catch: Throwable -> L41 SecurityException -> L44
    L29:
        this.f7207l.requestLocationUpdates("gps", this.m.y(), this.m.p(), this.q, r0);     // Catch: Throwable -> L41 SecurityException -> L44
        u4.a();     // Catch: Throwable -> L41 SecurityException -> L44
        goto L31
    L18:
        if ((a5.f() - s) >= 259200000) goto L20;
    L47:
        goto L27
    L20:
        if (a5.M(this.f7204i, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==") == false) goto L22;
        this.f7207l.sendExtraCommand("gps", "force_xtra_injection", null);     // Catch: Throwable -> L24
        s = a5.f();     // Catch: Throwable -> L24
        SharedPreferences.Editor r4 = z4.d(this.f7204i, "pref");     // Catch: Throwable -> L24
        z4.j(r4, "lagt", s);     // Catch: Throwable -> L24
        z4.g(r4);     // Catch: Throwable -> L24
        u4.a();     // Catch: Throwable -> L24
        goto L47
    L22:
        s4.h(new Exception("n_alec"), "OPENSDK_CL", "rlu_n_alec");     // Catch: Throwable -> L24
    L31:
        if (u == false) goto L33;
    L34:
        d(100, "系统返回定位结果超时#2002", this.m.w());     // Catch: Throwable -> L41 SecurityException -> L44
    L36:
        if (u == false) goto L38;
        return;
    L38:
        if (w == true) goto L53;
        u4.a();     // Catch: Throwable -> L41 SecurityException -> L44
        d(100, "系统定位当前不可用#2003", 0);     // Catch: Throwable -> L41 SecurityException -> L44
        return;
    L53:
        return;
    L33:
        if (w == false) goto L36;
    L44:
        e = move-exception;
        u4.a();
        this.o = false;
        y4.p(null, 2121);
        d(101, e.getMessage() + "#2004", 0);
        return;
    L41:
        th = move-exception;
        String r2 = "CoarseLocation | requestLocationUpdates error: " + th.getMessage();
        u4.a();
        s4.h(th, "CoarseLocation", "requestLocationUpdates part2");
    }

    public final void b() {
        u4.a();
        LocationManager r0 = this.f7207l;
        if (r0 != null) goto L19;
        return;
    L19:
        LocationListener r1 = this.q;     // Catch: Throwable -> L9
        if (r1 == null) goto L17;
        r0.removeUpdates(r1);     // Catch: Throwable -> L9
        ((a) this.q).a();     // Catch: Throwable -> L9
        this.q = null;     // Catch: Throwable -> L9
        u4.a();     // Catch: Throwable -> L9
    L17:
        Handler r2 = this.f7203h;     // Catch: Throwable -> L16
        if (r2 == null) goto L14;
        r2.removeMessages(100);     // Catch: Throwable -> L16
    L14:
        this.f7202g = 0;
        this.f7196a = 0;
        this.f7205j = 0;
        this.f7198c = 0;
        this.f7206k = 0;
        this.f7199d.c();
        return;
    L9:
        th = move-exception;
        String r3 = "CoarseLocation | removeUpdates error " + th.getMessage();
        u4.a();
        goto L17
    }

    public final void f(Bundle r2) {
        if (r2 == null) goto L20;
        r2.setClassLoader(AMapLocation.class.getClassLoader());     // Catch: Throwable -> L13
        this.f7200e = r2.getInt("I_MAX_GEO_DIS");     // Catch: Throwable -> L13
        this.f7201f = r2.getInt("I_MIN_GEO_DIS");     // Catch: Throwable -> L13
        AMapLocation r3 = (AMapLocation) r2.getParcelable("loc");     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r3.K()) == true) goto L21;
        Object r1 = this.n;     // Catch: Throwable -> L13
        monitor-enter(r1);     // Catch: Throwable -> L13
        x = r3;     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L21:
        return;
    L13:
        th = move-exception;
        s4.h(th, "CoarseLocation", "setLastGeoLocation");
        return;
    }

    public final void i(AMapLocationClientOption r5) {
        this.m = r5;
        if (r5 != null) goto L5;
        this.m = new AMapLocationClientOption();
    L5:
        String r0 = "option: " + this.m.toString();
        u4.a();
        if (this.m.N() == true) goto L10;
        w();
        return;
    L10:
        if (t() == true) goto L17;
        u();
        return;
    L17:
        s = z4.c(this.f7204i, "pref", "lagt", s);     // Catch: Throwable -> L16
    L14:
        z();
    }

    @SuppressLint({"NewApi"})
    public final int n() {
        LocationManager r0 = this.f7207l;
        if (r0 != null) goto L6;
        return 1;
    L6:
        if (m(r0) == true) goto L9;
        return 1;
    L9:
        if (Build.VERSION.SDK_INT < 19) goto L11;
        int r1 = Settings.Secure.getInt(this.f7204i.getContentResolver(), LocationMonitorConst.LOCATION_MODE, 0);
        if (r1 != 0) goto L16;
        return 2;
    L16:
        if (r1 != 2) goto L20;
        return 3;
    L20:
        if (this.o == true) goto L23;
        return 4;
    L23:
        return 0;
    L11:
        if (this.f7207l.isProviderEnabled("gps") == true) goto L20;
        return 2;
    }

    public final void q(AMapLocationClientOption r2) {
        if (r2 != null) goto L4;
        r2 = new AMapLocationClientOption();
    L4:
        this.m = r2;
        String r0 = "option: " + this.m.toString();
        u4.a();
        this.f7203h.removeMessages(100);
        if (this.p == this.m.q()) goto L15;
        Object r3 = this.n;
        monitor-enter(r3);
        x = null;     // Catch: Throwable -> L12
        monitor-exit(r3);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L15:
        this.p = this.m.q();
    }
}
