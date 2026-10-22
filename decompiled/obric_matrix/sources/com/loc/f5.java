package com.loc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
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
import androidx.lifecycle.CoroutineLiveDataKt;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.lego.init.IdleTaskConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class f5 {
    static AMapLocation D = null;
    static long E = 0;
    static Object F = null;
    static long G = 0;
    static boolean H = false;
    static boolean I = false;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static volatile AMapLocation f7286J;
    private boolean A;
    private int B;
    private boolean C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Handler f7287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f7288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    LocationManager f7289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    AMapLocationClientOption f7290d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f7291e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f7292f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f7293g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f7294h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    w3 f7295i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f7296j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f7297k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    AMapLocation f7298l;
    long m;
    float n;
    Object o;
    Object p;
    private int q;
    private GpsStatus r;
    private GpsStatus.Listener s;
    private GnssStatus.Callback t;
    AMapLocationClientOption.e u;
    boolean v;
    long w;
    int x;
    LocationListener y;
    private String z;

    final class a extends GnssStatus.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f5 f7299a;

        a(f5 r1) {
            this.f7299a = r1;
        }

        @Override // android.location.GnssStatus.Callback
        public final void onFirstFix(int r1) {
            f5.I();
        }

        @Override // android.location.GnssStatus.Callback
        public final void onSatelliteStatusChanged(GnssStatus r1) {
            f5.n(this.f7299a, r1);
        }

        @Override // android.location.GnssStatus.Callback
        public final void onStarted() {
            f5.H();
        }

        @Override // android.location.GnssStatus.Callback
        public final void onStopped() {
            f5.l(this.f7299a);
        }
    }

    final class b implements GpsStatus.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f5 f7300a;

        b(f5 r1) {
            this.f7300a = r1;
        }

        @Override // android.location.GpsStatus.Listener
        public final void onGpsStatusChanged(int r4) {
            f5 r0 = this.f7300a;     // Catch: Throwable -> L22
            LocationManager r1 = r0.f7289c;     // Catch: Throwable -> L22
            if (r1 != null) goto L5;
            return;
        L5:
            f5.a(r0, r1.getGpsStatus(f5.s(r0)));     // Catch: Throwable -> L22
            if (r4 != 1) goto L8;
            f5.H();     // Catch: Throwable -> L22
            return;
        L8:
            if (r4 != 2) goto L10;
            f5.l(this.f7300a);     // Catch: Throwable -> L22
            return;
        L10:
            if (r4 != 3) goto L12;
            f5.I();     // Catch: Throwable -> L22
            return;
        L12:
            if (r4 != 4) goto L26;
            f5.z(this.f7300a);     // Catch: Throwable -> L22
            return;
        L26:
            return;
        L22:
            th = move-exception;
            String r2 = "GpsLocation | onGpsStatusChanged error: " + th.getMessage();
            u4.a();
            s4.h(th, "GpsLocation", "onGpsStatusChanged");
        }
    }

    static class c implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private f5 f7301a;

        c(f5 r1) {
            this.f7301a = r1;
        }

        final void a() {
            this.f7301a = null;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location r4) {
            String r0 = "tid=" + Thread.currentThread().getId();     // Catch: Throwable -> L6
            u4.a();     // Catch: Throwable -> L6
            f5 r3 = this.f7301a;     // Catch: Throwable -> L6
            if (r3 == null) goto L9;
            f5.o(r3, r4);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String r1) {
            f5 r0 = this.f7301a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            f5.p(r0, r1);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String r1) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String r1, int r2, Bundle r3) {
            f5 r0 = this.f7301a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            f5.m(r0, r2);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }
    }

    static {
        F = new Object();
    }

    public f5(Context r6, Handler r7) {
        this.f7291e = 0;
        this.f7292f = 0;
        this.f7293g = false;
        this.f7294h = 0;
        this.f7295i = null;
        this.f7296j = 240;
        this.f7297k = 80;
        this.f7298l = null;
        this.m = 0;
        this.n = 0.0f;
        this.o = new Object();
        this.p = new Object();
        this.q = 0;
        this.r = null;
        this.s = null;
        this.u = AMapLocationClientOption.e.f500f;
        this.v = true;
        this.w = 0;
        this.x = 0;
        this.y = null;
        this.z = null;
        this.A = false;
        this.B = 0;
        this.C = false;
        this.f7288b = r6;
        this.f7287a = r7;
        this.f7289c = (LocationManager) r6.getSystemService(LocationMonitorConst.LOCATION);     // Catch: Throwable -> L5
    L7:
        this.f7295i = new w3();
        return;
    L5:
        th = move-exception;
        s4.h(th, "GpsLocation", "<init>");
        goto L7
    }

    private void B(AMapLocation r2) {
        if (this.f7287a == null) goto L6;
        Message r0 = Message.obtain();
        r0.obj = r2;
        r0.what = 2;
        this.f7287a.sendMessage(r0);
        return;
    }

    private void D(AMapLocation r9) {
    L11:
        r9.N0(false);
        r9.A0("WGS84");
        return;
    L4:
        if (s4.i(r9.getLatitude(), r9.getLongitude()) == true) goto L6;
    L9:
        r9.N0(false);     // Catch: Throwable -> L11
        r9.A0("WGS84");     // Catch: Throwable -> L11
        return;
    L6:
        if (this.f7290d.M() == false) goto L9;
        DPoint r2 = v4.d(this.f7288b, new DPoint(r9.getLatitude(), r9.getLongitude()));     // Catch: Throwable -> L11
        r9.setLatitude(r2.b());     // Catch: Throwable -> L11
        r9.setLongitude(r2.d());     // Catch: Throwable -> L11
        r9.N0(this.f7290d.M());     // Catch: Throwable -> L11
        r9.A0("GCJ02");     // Catch: Throwable -> L11
    }

    private void E(AMapLocation r2) {
        int r1 = this.q;     // Catch: Throwable -> L11
        if (r1 < 4) goto L6;
        r2.I0(1);     // Catch: Throwable -> L11
        return;
    L6:
        if (r1 != 0) goto L9;
        r2.I0(-1);     // Catch: Throwable -> L11
        return;
    L9:
        r2.I0(0);     // Catch: Throwable -> L11
        return;
    }

    private AMapLocation G(AMapLocation r4) {
        if (a5.p(r4) == true) goto L6;
        return r4;
    L6:
        if (this.f7294h >= 3) goto L9;
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
        return this.f7295i.a(r4);
    L16:
        if (r4.getSpeed() != Float.MAX_VALUE) goto L19;
    L11:
        if (r4.getAccuracy() != Float.MAX_VALUE) goto L14;
        goto L12
    }

    static /* synthetic */ void H() {
        L();
    }

    static /* synthetic */ void I() {
        N();
    }

    private static void J(AMapLocation r7) {
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

    private void K() {
        if (this.f7289c != null) goto L47;
        return;
    L47:
        P();     // Catch: Throwable -> L38 SecurityException -> L41
        this.v = true;     // Catch: Throwable -> L38 SecurityException -> L41
        Looper r1 = Looper.myLooper();     // Catch: Throwable -> L38 SecurityException -> L41
        if (r1 != null) goto L9;
        r1 = this.f7288b.getMainLooper();     // Catch: Throwable -> L38 SecurityException -> L41
    L9:
        Looper r8 = r1;
        this.f7291e = a5.A();     // Catch: Throwable -> L38 SecurityException -> L41
        if (r(this.f7289c) == true) goto L45;
        u4.a();     // Catch: Throwable -> L38 SecurityException -> L41
        e(8, 14, "no gps provider#1402", 0);     // Catch: Throwable -> L38 SecurityException -> L41
        return;
    L45:
    L18:
        th = move-exception;
        String r0 = "GpsLocation | sendExtraCommand error: " + th.getMessage();     // Catch: Throwable -> L38 SecurityException -> L41
        u4.a();     // Catch: Throwable -> L38 SecurityException -> L41
    L21:
        if (this.y != null) goto L24;
        this.y = new c(this);     // Catch: Throwable -> L38 SecurityException -> L41
    L24:
        if (this.f7290d.B().equals(AMapLocationClientOption.b.f490g) == true) goto L26;
    L29:
        LocationManager r2 = this.f7289c;     // Catch: Throwable -> L38 SecurityException -> L41
        String r3 = "gps";
        long r4 = 900;
        float r6 = 0.0f;
        LocationListener r7 = this.y;     // Catch: Throwable -> L38 SecurityException -> L41
    L28:
        r2.requestLocationUpdates(r3, r4, r6, r7, r8);     // Catch: Throwable -> L38 SecurityException -> L41
        if (Build.VERSION.SDK_INT < 24) goto L33;
        a r5 = new a(this);     // Catch: Throwable -> L38 SecurityException -> L41
        this.t = r5;     // Catch: Throwable -> L38 SecurityException -> L41
        this.f7289c.registerGnssStatusCallback(r5);     // Catch: Throwable -> L38 SecurityException -> L41
    L34:
        e(8, 14, "no enough satellites#1401", this.f7290d.w());     // Catch: Throwable -> L38 SecurityException -> L41
        return;
    L33:
        b r9 = new b(this);     // Catch: Throwable -> L38 SecurityException -> L41
        this.s = r9;     // Catch: Throwable -> L38 SecurityException -> L41
        this.f7289c.addGpsStatusListener(r9);     // Catch: Throwable -> L38 SecurityException -> L41
        u4.a();     // Catch: Throwable -> L38 SecurityException -> L41
        goto L34
    L26:
        if (this.f7290d.p() <= 0.0f) goto L29;
        r2 = this.f7289c;     // Catch: Throwable -> L38 SecurityException -> L41
        r3 = "gps";
        r4 = this.f7290d.y();     // Catch: Throwable -> L38 SecurityException -> L41
        r6 = this.f7290d.p();     // Catch: Throwable -> L38 SecurityException -> L41
        r7 = this.y;     // Catch: Throwable -> L38 SecurityException -> L41
        goto L28
    L12:
        if ((a5.f() - G) >= 259200000) goto L14;
    L44:
        goto L21
    L14:
        if (a5.M(this.f7288b, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==") == false) goto L16;
        this.f7289c.sendExtraCommand("gps", "force_xtra_injection", null);     // Catch: Throwable -> L18
        G = a5.f();     // Catch: Throwable -> L18
        SharedPreferences.Editor r10 = z4.d(this.f7288b, "pref");     // Catch: Throwable -> L18
        z4.j(r10, "lagt", G);     // Catch: Throwable -> L18
        z4.g(r10);     // Catch: Throwable -> L18
        u4.a();     // Catch: Throwable -> L18
        goto L44
    L16:
        s4.h(new Exception("n_alec"), "OPENSDK_GL", "rlu_n_alec");     // Catch: Throwable -> L18
    L41:
        e = move-exception;
        u4.a();
        this.v = false;
        y4.p(null, 2121);
        e(2, 12, e.getMessage() + "#1201", 0);
        return;
    L38:
        th = move-exception;
        String r11 = "GpsLocation | requestLocationUpdates error: " + th.getMessage();
        u4.a();
        s4.h(th, "GpsLocation", "requestLocationUpdates part2");
    }

    private static void L() {
        u4.a();
    }

    private void M() {
        u4.a();
        this.q = 0;
    }

    private static void N() {
        u4.a();
    }

    private void O() {
        int r0 = 0;
        GpsStatus r1 = this.r;     // Catch: Throwable -> L14
        if (r1 == null) goto L16;
        Iterable<GpsSatellite> r2 = r1.getSatellites();     // Catch: Throwable -> L14
        if (r2 == null) goto L16;
        Iterator<GpsSatellite> r3 = r2.iterator();     // Catch: Throwable -> L14
        int r4 = this.r.getMaxSatellites();     // Catch: Throwable -> L14
    L9:
        if (r3.hasNext() == false) goto L16;
        if (r0 >= r4) goto L16;
        if (r3.next().usedInFix() == false) goto L9;
        r0 = r0 + 1;
    L16:
        this.q = r0;
        return;
    L14:
        th = move-exception;
        s4.h(th, "GpsLocation", "GPS_EVENT_SATELLITE_STATUS");
        goto L16
    }

    private void P() {
        if ((a5.A() - E) <= CoroutineLiveDataKt.DEFAULT_TIMEOUT) goto L5;
        return;
    L5:
        if (a5.p(D) == true) goto L7;
        return;
    L7:
        if (this.f7290d.K() == false) goto L9;
    L11:
        this.f7292f = a5.A();
        y(D);
        return;
    L9:
        if (D.isMock() == false) goto L11;
    }

    private static boolean Q() {
        return ((Boolean) w4.e(u5.u("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), u5.u("UaXNOYXZpU3RhcnRlZA=="), null, null)).booleanValue();
    L4:
        return false;
    }

    private AMapLocation R() {
        if (a5.p(this.f7298l) == true) goto L7;
        return null;
    L7:
        if (r4.B() == true) goto L10;
        return null;
    L10:
        if (Q() == false) goto L37;
        JSONObject r2 = new JSONObject((String) w4.e(u5.u("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), u5.u("UZ2V0TmF2aUxvY2F0aW9u"), null, null));     // Catch: Throwable -> L39
        long r3 = r2.optLong("time");     // Catch: Throwable -> L39
        if (this.C == true) goto L15;
        this.C = true;     // Catch: Throwable -> L39
        y4.q("useNaviLoc", "use NaviLoc");     // Catch: Throwable -> L39
    L15:
        if ((a5.f() - r3) > 5500) goto L37;
        double r7 = r2.optDouble("lat", 0.0d);     // Catch: Throwable -> L39
        double r9 = r2.optDouble("lng", 0.0d);     // Catch: Throwable -> L39
        float r1 = 0.0f;
        float r11 = Float.parseFloat(r2.optString(LocationMonitorConst.ACCURACY, BDLocationException.ERROR_TIMEOUT));     // Catch: NumberFormatException -> L20 Throwable -> L39
    L21:
        double r5 = r2.optDouble("altitude", 0.0d);     // Catch: Throwable -> L39
        float r12 = Float.parseFloat(r2.optString("bearing", BDLocationException.ERROR_TIMEOUT));     // Catch: NumberFormatException -> L24 Throwable -> L39
    L42:
        r1 = (Float.parseFloat(r2.optString("speed", BDLocationException.ERROR_TIMEOUT)) * 10.0f) / 36.0f;
    L27:
        AMapLocation r4 = new AMapLocation("lbs");     // Catch: Throwable -> L39
        r4.L0(9);     // Catch: Throwable -> L39
        r4.setLatitude(r7);     // Catch: Throwable -> L39
        r4.setLongitude(r9);     // Catch: Throwable -> L39
        r4.setAccuracy(r11);     // Catch: Throwable -> L39
        r4.setAltitude(r5);     // Catch: Throwable -> L39
        r4.setBearing(r12);     // Catch: Throwable -> L39
        r4.setSpeed(r1);     // Catch: Throwable -> L39
        r4.setTime(r3);     // Catch: Throwable -> L39
        r4.A0("GCJ02");     // Catch: Throwable -> L39
        if (a5.c(r4, this.f7298l) > 300.0f) goto L37;
        Object r6 = this.p;     // Catch: Throwable -> L39
        monitor-enter(r6);     // Catch: Throwable -> L39
        this.f7298l.setLongitude(r9);     // Catch: Throwable -> L34
        this.f7298l.setLatitude(r7);     // Catch: Throwable -> L34
        this.f7298l.setAccuracy(r11);     // Catch: Throwable -> L34
        this.f7298l.setBearing(r12);     // Catch: Throwable -> L34
        this.f7298l.setSpeed(r1);     // Catch: Throwable -> L34
        this.f7298l.setTime(r3);     // Catch: Throwable -> L34
        this.f7298l.A0("GCJ02");     // Catch: Throwable -> L34
        monitor-exit(r6);     // Catch: Throwable -> L34
        return r4;
    L34:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L24:
        r12 = 0.0f;
    L20:
        r11 = 0.0f;
    L37:
        return null;
    }

    static /* synthetic */ GpsStatus a(f5 r0, GpsStatus r1) {
        r0.r = r1;
        return r1;
    }

    private void d(int r3) {
        if (r3 == 0) goto L7;
        return;
    L7:
        this.f7292f = 0;     // Catch: Throwable -> L6
        this.q = 0;     // Catch: Throwable -> L6
        return;
    }

    private void e(int r4, int r5, String r6, long r7) {
        if (this.f7287a != null) goto L5;
        return;
    L5:
        if (this.f7290d.B() != AMapLocationClientOption.b.f490g) goto L12;
        Message r0 = Message.obtain();     // Catch: Throwable -> L8
        AMapLocation r1 = new AMapLocation("");     // Catch: Throwable -> L8
        r1.setProvider("gps");     // Catch: Throwable -> L8
        r1.E0(r5);     // Catch: Throwable -> L8
        r1.J0(r6);     // Catch: Throwable -> L8
        r1.L0(1);     // Catch: Throwable -> L8
        r0.obj = r1;     // Catch: Throwable -> L8
        r0.what = r4;     // Catch: Throwable -> L8
        this.f7287a.sendMessageDelayed(r0, r7);     // Catch: Throwable -> L8
        return;
    L12:
        return;
    }

    private void f(GnssStatus r5) {
        int r0 = 0;
        if (r5 != null) goto L20;
    L18:
        this.q = r0;
        return;
    L20:
    L16:
        th = th;
    L17:
        s4.h(th, "GpsLocation_Gnss", "GPS_EVENT_SATELLITE_STATUS");
        goto L18
    L5:
        if (Build.VERSION.SDK_INT < 24) goto L18;
        int r1 = r5.getSatelliteCount();     // Catch: Throwable -> L16
        int r2 = 0;
    L8:
        if (r0 >= r1) goto L15;
        if (r5.usedInFix(r0) == false) goto L12;
        r2 = r2 + 1;
    L12:
        r0 = r0 + 1;
    L13:
        th = th;
        r0 = r2;
        goto L17
    L15:
        r0 = r2;
        goto L18
    }

    private void g(Location r10) {
        Handler r0 = this.f7287a;
        if (r0 == null) goto L5;
        r0.removeMessages(8);
    L5:
        if (r10 != null) goto L58;
        return;
    L58:
        AMapLocation r1 = new AMapLocation(r10);     // Catch: Throwable -> L51
        if (a5.p(r1) == true) goto L10;
        return;
    L10:
        r1.setProvider("gps");     // Catch: Throwable -> L51
        r1.L0(1);     // Catch: Throwable -> L51
        if (this.f7293g == true) goto L16;
        if (a5.p(r1) == false) goto L16;
        y4.f(this.f7288b, a5.A() - this.f7291e, s4.i(r1.getLatitude(), r1.getLongitude()));     // Catch: Throwable -> L51
        this.f7293g = true;     // Catch: Throwable -> L51
    L16:
        if (a5.o(r1, this.q) == false) goto L25;
        r1.setMock(true);     // Catch: Throwable -> L51
        r1.T0(4);     // Catch: Throwable -> L51
        if (this.f7290d.K() == true) goto L26;
        int r11 = this.x;     // Catch: Throwable -> L51
        if (r11 <= 3) goto L23;
        y4.p(null, 2152);     // Catch: Throwable -> L51
        r1.E0(15);     // Catch: Throwable -> L51
        r1.J0("GpsLocation has been mocked!#1501");     // Catch: Throwable -> L51
        r1.setLatitude(0.0d);     // Catch: Throwable -> L51
        r1.setLongitude(0.0d);     // Catch: Throwable -> L51
        r1.setAltitude(0.0d);     // Catch: Throwable -> L51
        r1.setSpeed(0.0f);     // Catch: Throwable -> L51
        r1.setAccuracy(0.0f);     // Catch: Throwable -> L51
        r1.setBearing(0.0f);     // Catch: Throwable -> L51
        r1.setExtras(null);     // Catch: Throwable -> L51
        y(r1);     // Catch: Throwable -> L51
        return;
    L23:
        this.x = r11 + 1;     // Catch: Throwable -> L51
        return;
    L26:
        r1.R0(this.q);     // Catch: Throwable -> L51
        D(r1);     // Catch: Throwable -> L51
        E(r1);     // Catch: Throwable -> L51
        J(r1);     // Catch: Throwable -> L51
        AMapLocation r2 = G(r1);     // Catch: Throwable -> L51
        i(r2);     // Catch: Throwable -> L51
        t(r2);     // Catch: Throwable -> L51
        Object r3 = this.o;     // Catch: Throwable -> L51
        monitor-enter(r3);     // Catch: Throwable -> L51
        j(r2, f7286J);     // Catch: Throwable -> L48
        monitor-exit(r3);     // Catch: Throwable -> L48
    L59:
    L44:
        th = move-exception;
        s4.h(th, "GpsLocation", "onLocationChangedLast");     // Catch: Throwable -> L51
    L46:
        y(r2);     // Catch: Throwable -> L51
        return;
    L31:
        if (a5.p(r2) == false) goto L46;
        if (this.f7298l == null) goto L35;
        this.m = r10.getTime() - this.f7298l.getTime();     // Catch: Throwable -> L44
        this.n = a5.c(this.f7298l, r2);     // Catch: Throwable -> L44
    L35:
        Object r12 = this.p;     // Catch: Throwable -> L44
        monitor-enter(r12);     // Catch: Throwable -> L44
        this.f7298l = r2.z();     // Catch: Throwable -> L41
        monitor-exit(r12);     // Catch: Throwable -> L41
        this.z = null;     // Catch: Throwable -> L44
        this.A = false;     // Catch: Throwable -> L44
        this.B = 0;     // Catch: Throwable -> L44
        goto L46
    L41:
        th = move-exception;
        throw th;     // Catch: Throwable -> L44
    L48:
        th = move-exception;
        throw th;     // Catch: Throwable -> L51
    L25:
        this.x = 0;     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        s4.h(th, "GpsLocation", "onLocationChanged");
    }

    private void i(AMapLocation r4) {
        if (a5.p(r4) == true) goto L5;
        return;
    L5:
        this.f7292f = a5.A();
        Object r0 = F;
        monitor-enter(r0);
        E = a5.A();     // Catch: Throwable -> L11
        D = r4.z();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        this.f7294h++;
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void j(AMapLocation r2, AMapLocation r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (this.f7290d.L() == true) goto L6;
        return;
    L6:
        if (a5.c(r2, r3) >= this.f7296j) goto L11;
        s4.b(r2, r3);
        return;
    }

    static /* synthetic */ void l(f5 r0) {
        r0.M();
    }

    static /* synthetic */ void m(f5 r0, int r1) {
        r0.d(r1);
    }

    static /* synthetic */ void n(f5 r0, GnssStatus r1) {
        r0.f(r1);
    }

    static /* synthetic */ void o(f5 r0, Location r1) {
        r0.g(r1);
    }

    static /* synthetic */ void p(f5 r0, String r1) {
        r0.q(r1);
    }

    private void q(String r3) {
        if ("gps".equalsIgnoreCase(r3) == false) goto L9;
        this.f7292f = 0;     // Catch: Throwable -> L6
        this.q = 0;     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    private static boolean r(LocationManager r2) {
    L14:
        th = move-exception;
        String r0 = "GpsLocation | hasProvider error: " + th.getMessage();
        u4.a();
        return I;
    L3:
        if (H == true) goto L5;
        List<String> r3 = r2.getAllProviders();     // Catch: Throwable -> L14
        if (r3 != null) goto L9;
    L11:
        I = false;     // Catch: Throwable -> L14
    L12:
        H = true;     // Catch: Throwable -> L14
        return I;
    L9:
        if (r3.size() <= 0) goto L11;
        I = r3.contains("gps");     // Catch: Throwable -> L14
        goto L12
    L5:
        return I;
    }

    static /* synthetic */ GpsStatus s(f5 r0) {
        return r0.r;
    }

    private void t(AMapLocation r7) {
        if (a5.p(r7) == true) goto L6;
        return;
    L6:
        if (this.f7287a == null) goto L25;
        long r0 = a5.A();
        if (this.f7290d.y() > 8000) goto L10;
    L11:
        Bundle r1 = new Bundle();
        r1.putDouble("lat", r7.getLatitude());
        r1.putDouble("lon", r7.getLongitude());
        r1.putFloat("radius", r7.getAccuracy());
        r1.putLong("time", r7.getTime());
        Message r2 = Message.obtain();
        r2.setData(r1);
        r2.what = 5;
        Object r3 = this.o;
        monitor-enter(r3);
    L22:
        th = move-exception;
        throw th;
    L14:
        if (f7286J != null) goto L18;
        Handler r6 = this.f7287a;     // Catch: Throwable -> L22
    L16:
        r6.sendMessage(r2);     // Catch: Throwable -> L22
    L20:
        monitor-exit(r3);     // Catch: Throwable -> L22
        return;
    L18:
        if (a5.c(r7, f7286J) <= this.f7297k) goto L20;
        r6 = this.f7287a;     // Catch: Throwable -> L22
        goto L16
    L10:
        if ((r0 - this.w) > (this.f7290d.y() - 8000)) goto L11;
        return;
    }

    private boolean w(String r5) {
        ArrayList<String> r1 = a5.D(r5);     // Catch: Throwable -> L10
        ArrayList<String> r2 = a5.D(this.z);     // Catch: Throwable -> L10
        if (r1.size() >= 8) goto L6;
        return false;
    L6:
        if (r2.size() < 8) goto L14;
        return a5.s(this.z, r5);
    L14:
        return false;
    L15:
        return false;
    }

    private void y(AMapLocation r7) {
        if (r7.U() != 15) goto L8;
        if (AMapLocationClientOption.b.f490g.equals(this.f7290d.B()) == true) goto L8;
        return;
    L8:
        if (this.f7290d.B().equals(AMapLocationClientOption.b.f490g) == false) goto L14;
        if (this.f7290d.p() <= 0.0f) goto L14;
        B(r7);
        return;
    L14:
        if ((a5.A() - this.w) < (this.f7290d.y() - 200)) goto L17;
        this.w = a5.A();
        B(r7);
        return;
    }

    static /* synthetic */ void z(f5 r0) {
        r0.O();
    }

    @SuppressLint({"NewApi"})
    public final int A() {
        LocationManager r0 = this.f7289c;
        if (r0 != null) goto L6;
        return 1;
    L6:
        if (r(r0) == true) goto L9;
        return 1;
    L9:
        if (Build.VERSION.SDK_INT < 19) goto L11;
        int r1 = Settings.Secure.getInt(this.f7288b.getContentResolver(), LocationMonitorConst.LOCATION_MODE, 0);
        if (r1 != 0) goto L16;
        return 2;
    L16:
        if (r1 != 2) goto L20;
        return 3;
    L20:
        if (this.v == true) goto L23;
        return 4;
    L23:
        return 0;
    L11:
        if (this.f7289c.isProviderEnabled("gps") == true) goto L20;
        return 2;
    }

    public final int C() {
        return this.q;
    }

    public final boolean F() {
        AMapLocationClientOption r0 = this.f7290d;
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (r0.N() == true) goto L11;
        if ((a5.A() - this.f7292f) <= 300000) goto L11;
        return true;
    }

    public final AMapLocation b(AMapLocation r17, String r18) {
        if (this.f7298l != null) goto L6;
        return r17;
    L6:
        if (this.f7290d.K() == true) goto L11;
        if (this.f7298l.isMock() == false) goto L11;
        return r17;
    L11:
        if (a5.p(this.f7298l) == true) goto L13;
        return r17;
    L13:
        AMapLocation r2 = R();
        if (r2 != null) goto L16;
    L19:
        float r3 = this.f7298l.getSpeed();
        if (r3 != 0.0f) goto L29;
        long r8 = this.m;
        if (r8 <= 0) goto L29;
        if (r8 >= 8) goto L29;
        float r5 = this.n;
        if (r5 <= 0.0f) goto L29;
        r3 = r5 / r8;
    L29:
        if (r17 != null) goto L31;
    L48:
        long r10 = 30000;
    L49:
        long r12 = a5.A() - this.f7292f;
        if (r12 <= 30000) goto L53;
        return r17;
    L53:
        if (r12 < r10) goto L70;
        if (this.A == true) goto L57;
    L60:
        this.z = null;
        this.B = 0;
        Object r4 = this.p;
        monitor-enter(r4);
        this.f7298l = null;     // Catch: Throwable -> L66
        monitor-exit(r4);     // Catch: Throwable -> L66
        this.m = 0;
        this.n = 0.0f;
        return r17;
    L66:
        th = move-exception;
        throw th;
    L57:
        if (w(r18) == false) goto L60;
        AMapLocation r0 = this.f7298l.z();
        r0.T0(3);
        return r0;
    L70:
        if (this.z == null) goto L72;
    L74:
        AMapLocation r1 = this.f7298l.z();
        r1.T0(2);
        return r1;
    L72:
        if (this.B < 2) goto L74;
        this.z = r18;
        goto L74
    L31:
        if (a5.p(r17) == false) goto L48;
        if (r17.getAccuracy() >= 200.0f) goto L43;
        int r11 = this.B + 1;
        this.B = r11;
        if (this.z != null) goto L39;
        if (r11 < 2) goto L39;
        this.A = true;
    L39:
        if (r3 <= 5.0f) goto L41;
        r10 = BDLocationConfig.sScanBleMaxInterval;
        goto L49
    L41:
        r10 = IdleTaskConfig.IDLE_START_TIME_OUT;
        goto L49
    L43:
        if (TextUtils.isEmpty(this.z) == true) goto L46;
        this.A = false;
        this.B = 0;
    L46:
        if (r3 <= 5.0f) goto L48;
        r10 = 20000;
        goto L49
    L16:
        if (a5.p(r2) == false) goto L19;
        r2.T0(2);
        return r2;
    }

    public final void c() {
        LocationManager r0 = this.f7289c;
        if (r0 != null) goto L26;
        return;
    L26:
        LocationListener r2 = this.y;     // Catch: Throwable -> L20
        if (r2 == null) goto L30;
        r0.removeUpdates(r2);     // Catch: Throwable -> L20
        ((c) this.y).a();     // Catch: Throwable -> L20
        this.y = null;     // Catch: Throwable -> L20
    L30:
        GpsStatus.Listener r1 = this.s;     // Catch: Throwable -> L21
        if (r1 == null) goto L28;
        this.f7289c.removeGpsStatusListener(r1);     // Catch: Throwable -> L21
    L28:
        GnssStatus.Callback r3 = this.t;     // Catch: Throwable -> L22
        if (r3 == null) goto L24;
        this.f7289c.unregisterGnssStatusCallback(r3);     // Catch: Throwable -> L22
    L24:
        Handler r4 = this.f7287a;     // Catch: Throwable -> L23
        if (r4 == null) goto L18;
        r4.removeMessages(8);     // Catch: Throwable -> L23
    L18:
        this.q = 0;
        this.f7291e = 0;
        this.w = 0;
        this.f7292f = 0;
        this.f7294h = 0;
        this.x = 0;
        this.f7295i.c();
        this.f7298l = null;
        this.m = 0;
        this.n = 0.0f;
        this.z = null;
        this.C = false;
    }

    public final void h(Bundle r2) {
        if (r2 == null) goto L20;
        r2.setClassLoader(AMapLocation.class.getClassLoader());     // Catch: Throwable -> L13
        this.f7296j = r2.getInt("I_MAX_GEO_DIS");     // Catch: Throwable -> L13
        this.f7297k = r2.getInt("I_MIN_GEO_DIS");     // Catch: Throwable -> L13
        AMapLocation r3 = (AMapLocation) r2.getParcelable("loc");     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r3.K()) == true) goto L21;
        Object r1 = this.o;     // Catch: Throwable -> L13
        monitor-enter(r1);     // Catch: Throwable -> L13
        f7286J = r3;     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L21:
        return;
    L13:
        th = move-exception;
        s4.h(th, "GpsLocation", "setLastGeoLocation");
        return;
    }

    public final void k(AMapLocationClientOption r5) {
        this.f7290d = r5;
        if (r5 != null) goto L9;
        this.f7290d = new AMapLocationClientOption();
    L9:
        G = z4.c(this.f7288b, "pref", "lagt", G);     // Catch: Throwable -> L8
    L6:
        K();
    }

    public final void u(AMapLocationClientOption r2) {
        if (r2 != null) goto L4;
        r2 = new AMapLocationClientOption();
    L4:
        this.f7290d = r2;
        if (r2.B() == AMapLocationClientOption.b.f490g) goto L10;
        Handler r3 = this.f7287a;
        if (r3 == null) goto L10;
        r3.removeMessages(8);
    L10:
        if (this.u == this.f7290d.q()) goto L20;
        Object r4 = this.o;
        monitor-enter(r4);
        f7286J = null;     // Catch: Throwable -> L17
        monitor-exit(r4);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    L20:
        this.u = this.f7290d.q();
    }

    public final boolean v() {
        if ((a5.A() - this.f7292f) <= 2800) goto L6;
        return false;
    L6:
        return true;
    }

    public final void x() {
        this.x = 0;
    }
}
