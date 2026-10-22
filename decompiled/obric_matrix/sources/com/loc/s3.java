package com.loc;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import java.util.ArrayList;
import java.util.Locale;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"NewApi"})
public final class s3 {
    public static String[] O = null;
    public static String P = "android.permission.ACCESS_BACKGROUND_LOCATION";
    private static volatile boolean Q = false;
    boolean A;
    int B;
    private boolean C;
    y3 D;
    boolean E;
    w3 F;
    String G;
    private Handler H;
    private e4 I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    boolean f7753J;
    IntentFilter K;
    LocationManager L;
    private String M;
    private t3 N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f7754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ConnectivityManager f7755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    g4 f7756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    c4 f7757d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    i4 f7758e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    p4 f7759f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ArrayList<i3> f7760g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    b f7761h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    AMapLocationClientOption f7762i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    ew f7763j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    long f7764k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f7765l;
    q4 m;
    boolean n;
    private String o;
    n4 p;
    StringBuilder q;
    boolean r;
    boolean s;
    AMapLocationClientOption.e t;
    boolean u;
    boolean v;
    WifiInfo w;
    boolean x;
    private String y;
    StringBuilder z;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7766a = null;

        static {
            int[] r0 = new int[AMapLocationClientOption.e.values().length];
            f7766a = r0;
            r0[AMapLocationClientOption.e.f500f.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f7766a[AMapLocationClientOption.e.f501g.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f7766a[AMapLocationClientOption.e.f502h.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    class b extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ s3 f7767a;

        b(s3 r1) {
            this.f7767a = r1;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r2, Intent r3) {
            if (r2 == null) goto L40;
            if (r3 == null) goto L41;
            String r4 = r3.getAction();     // Catch: Throwable -> L27
            if (TextUtils.isEmpty(r4) == false) goto L9;
            return;
        L9:
            if (r4.equals("android.net.wifi.SCAN_RESULTS") == false) goto L22;
            g4 r5 = this.f7767a.f7756c;     // Catch: Throwable -> L27
            if (r5 == null) goto L32;
            r5.t();     // Catch: Throwable -> L27
        L32:
            if (r3.getExtras() != null) goto L16;
            return;
        L16:
            if (r3.getExtras().getBoolean("resultsUpdated", true) == false) goto L35;
            g4 r1 = this.f7767a.f7756c;     // Catch: Throwable -> L30
            if (r1 == null) goto L36;
            r1.s();     // Catch: Throwable -> L30
            return;
        L36:
            return;
        L35:
            return;
        L37:
            return;
        L22:
            if (r4.equals("android.net.wifi.WIFI_STATE_CHANGED") == false) goto L38;
            g4 r6 = this.f7767a.f7756c;     // Catch: Throwable -> L27
            if (r6 == null) goto L39;
            r6.u();     // Catch: Throwable -> L27
            return;
        L39:
            return;
        L38:
            return;
        L27:
            th = move-exception;
            s4.h(th, "Aps", "onReceive");
            return;
        L41:
            return;
        }
    }

    static {
        O = new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
    }

    public s3(boolean r5) {
        this.f7754a = null;
        this.f7755b = null;
        this.f7756c = null;
        this.f7757d = null;
        this.f7758e = null;
        this.f7759f = null;
        this.f7760g = new ArrayList();
        this.f7761h = null;
        this.f7762i = new AMapLocationClientOption();
        this.f7763j = null;
        this.f7764k = 0;
        this.f7765l = 0;
        this.m = null;
        this.n = false;
        this.o = null;
        this.p = null;
        this.q = new StringBuilder();
        this.r = true;
        this.s = true;
        this.t = AMapLocationClientOption.e.f500f;
        this.u = true;
        this.v = false;
        this.w = null;
        this.x = true;
        this.y = null;
        this.z = null;
        this.A = false;
        this.B = 12;
        this.C = true;
        this.D = null;
        this.E = false;
        this.F = null;
        this.G = null;
        this.f7753J = false;
        this.K = null;
        this.L = null;
        this.f7753J = r5;
    }

    private void E() {
        if (this.p == null) goto L16;
        if (this.f7762i != null) goto L7;
        this.f7762i = new AMapLocationClientOption();     // Catch: Throwable -> L13
    L7:
        int r0 = F();     // Catch: Throwable -> L13
        n4 r1 = this.p;     // Catch: Throwable -> L13
        long r2 = this.f7762i.w();     // Catch: Throwable -> L13
        if (this.f7762i.C().equals(AMapLocationClientOption.c.f494g) == false) goto L10;
        boolean r5 = true;
    L11:
        r1.e(r2, r5, r0);     // Catch: Throwable -> L13
        return;
    L10:
        r5 = false;
    L17:
        return;
    }

    private int F() {
        if (this.f7762i.q() == null) goto L12;
        int r4 = a.f7766a[this.f7762i.q().ordinal()];
        if (r4 == 1) goto L12;
        if (r4 == 2) goto L14;
        if (r4 != 3) goto L12;
        return 2;
    L14:
        return 1;
    L12:
        return 0;
    }

    private void G() {
        AMapLocationClientOption.e r0 = AMapLocationClientOption.e.f500f;
        boolean r1 = true;
        r0 = this.f7762i.q();     // Catch: Throwable -> L17
        boolean r2 = this.f7762i.L();     // Catch: Throwable -> L17
        boolean r3 = this.f7762i.M();     // Catch: Throwable -> L16
        r1 = this.f7762i.H();     // Catch: Throwable -> L15
        this.v = this.f7762i.O();     // Catch: Throwable -> L15
        this.E = this.f7762i.R();     // Catch: Throwable -> L15
        if (r3 == this.s) goto L8;
    L13:
        N();     // Catch: Throwable -> L15
    L19:
        this.s = r3;
        this.r = r2;
        this.u = r1;
        this.t = r0;
        return;
    L8:
        if (r2 != this.r) goto L13;
        if (r1 != this.u) goto L13;
        if (r0 == this.t) goto L19;
    L15:
        boolean r4 = r1;
        r1 = r3;
    L18:
        boolean r5 = r4;
        r3 = r1;
        r1 = r5;
    L16:
        r4 = true;
    L17:
        r2 = true;
        r4 = true;
        goto L18
    }

    private void H() {
    L10:
        th = move-exception;
        s4.h(th, "Aps", "initBroadcastListener");
        return;
    L3:
        if (this.f7761h != null) goto L6;
        this.f7761h = new b(this);     // Catch: Throwable -> L10
    L6:
        if (this.K != null) goto L8;
        IntentFilter r0 = new IntentFilter();     // Catch: Throwable -> L10
        this.K = r0;     // Catch: Throwable -> L10
        r0.addAction("android.net.wifi.WIFI_STATE_CHANGED");     // Catch: Throwable -> L10
        this.K.addAction("android.net.wifi.SCAN_RESULTS");     // Catch: Throwable -> L10
    L8:
        a(this.f7754a, this.f7761h, this.K);     // Catch: Throwable -> L10
    }

    private byte[] I() {
        if (this.m != null) goto L6;
        this.m = new q4();
    L6:
        if (this.f7762i != null) goto L8;
        this.f7762i = new AMapLocationClientOption();
    L8:
        this.m.b(this.f7754a, this.f7762i.L(), this.f7762i.M(), this.f7757d, this.f7756c, this.f7755b, this.G, this.I);
        return this.m.e();
    }

    private boolean J() {
        if (this.f7764k != 0) goto L6;
        return true;
    L6:
        if ((a5.A() - this.f7764k) <= 20000) goto L8;
        return true;
    L8:
        return false;
    }

    private void K() {
        g4 r0 = this.f7756c;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.e(this.n);
    }

    private boolean L() {
        ArrayList<i3> r0 = this.f7756c.p();
        this.f7760g = r0;
        if (r0 != null) goto L5;
    L7:
        return true;
    L5:
        if (r0.size() <= 0) goto L7;
        return false;
    }

    private void M() {
        if (this.y == null) goto L5;
        this.y = null;
    L5:
        StringBuilder r2 = this.z;
        if (r2 == null) goto L9;
        r2.delete(0, r2.length());
        return;
    }

    private void N() {
        i4 r0 = this.f7758e;     // Catch: Throwable -> L9
        if (r0 == null) goto L5;
        r0.f();     // Catch: Throwable -> L9
    L5:
        z(null);     // Catch: Throwable -> L9
        this.C = false;     // Catch: Throwable -> L9
        w3 r2 = this.F;     // Catch: Throwable -> L9
        if (r2 == null) goto L14;
        r2.c();     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        th = move-exception;
        s4.h(th, "Aps", "cleanCache");
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

    private static ew c(int r2, String r3) {
        ew r0 = new ew("");
        r0.E0(r2);
        r0.J0(r3);
        if (r2 != 15) goto L5;
        y4.p(null, 2151);
    L5:
        return r0;
    }

    private ew f(ew r7, u0 r8, eq r9) {
        if (r8 != null) goto L31;
    L24:
        r7.E0(4);     // Catch: Throwable -> L28
        this.q.append("网络异常,请求异常#0403");     // Catch: Throwable -> L28
        r9.y("#0403");     // Catch: Throwable -> L28
        r7.q1(this.z.toString());     // Catch: Throwable -> L28
        r7.J0(this.q.toString());     // Catch: Throwable -> L28
        if (r8 == null) goto L27;
        y4.p(r8.f7859d, 2041);     // Catch: Throwable -> L28
    L27:
        return r7;
    L31:
        byte[] r2 = r8.f7856a;     // Catch: Throwable -> L28
        if (r2 == null) goto L24;
        if (r2.length == 0) goto L24;
        p4 r3 = new p4();     // Catch: Throwable -> L28
        String r4 = new String(r8.f7856a, "UTF-8");     // Catch: Throwable -> L28
        if (r4.contains("\"status\":\"0\"") == false) goto L14;
        ew r10 = r3.c(r4, this.f7754a, r8, r9);     // Catch: Throwable -> L28
        r10.q1(this.z.toString());     // Catch: Throwable -> L28
        return r10;
    L14:
        if (r4.contains("</body></html>") == false) goto L23;
        r7.E0(5);     // Catch: Throwable -> L28
        g4 r11 = this.f7756c;     // Catch: Throwable -> L28
        if (r11 != null) goto L18;
    L20:
        r9.y("#0502");     // Catch: Throwable -> L28
        this.q.append("请求可能被劫持了#0502");     // Catch: Throwable -> L28
        y4.p(null, 2052);     // Catch: Throwable -> L28
    L21:
        r7.J0(this.q.toString());     // Catch: Throwable -> L28
        return r7;
    L18:
        if (r11.h(this.f7755b) == false) goto L20;
        r9.y("#0501");     // Catch: Throwable -> L28
        this.q.append("您连接的是一个需要登录的网络，请确认已经登入网络#0501");     // Catch: Throwable -> L28
        y4.p(null, 2051);     // Catch: Throwable -> L28
        goto L21
    L23:
        return null;
    L28:
        th = move-exception;
        r7.E0(4);
        s4.h(th, "Aps", "checkResponseEntity");
        r9.y("#0403");
        this.q.append("check response exception ex is" + th.getMessage() + "#0403");
        r7.J0(this.q.toString());
        return r7;
    }

    private StringBuilder i(StringBuilder r3) {
        if (r3 != null) goto L4;
        r3 = new StringBuilder(TypedValues.TransitionType.TYPE_DURATION);
    L5:
        r3.append(this.f7757d.H());
        r3.append(this.f7756c.z());
        return r3;
    L4:
        r3.delete(0, r3.length());
        goto L5
    }

    private boolean p(long r6) {
        if (this.C == true) goto L7;
        this.C = true;
        return false;
    L7:
        if ((a5.A() - r6) >= 800) goto L15;
        long r7 = 0;
        if (a5.q(this.f7763j) == false) goto L12;
        r7 = a5.f() - this.f7763j.getTime();
    L12:
        if (r7 > BDLocationConfig.sScanBleMaxInterval) goto L15;
        return true;
    L15:
        return false;
    }

    @SuppressLint({"NewApi"})
    private ew q(boolean r12, eq r13) {
        if (TextUtils.isEmpty(this.M) == false) goto L6;
        this.M = u5.q(l5.p(this.f7754a) + "," + l5.F(this.f7754a));     // Catch: Throwable -> L99
    L6:
        StringBuilder r1 = this.q;     // Catch: Throwable -> L99
        r1.append("#id:");     // Catch: Throwable -> L99
        r1.append(this.M);     // Catch: Throwable -> L99
    L7:
        String r2 = "";
        ew r3 = new ew("");
        String r4 = null;
        byte[] r6 = I();     // Catch: Throwable -> L96
        long r5 = a5.A();
        this.f7764k = r5;
        r13.d(r5);
        s4.r(this.f7754a);     // Catch: Throwable -> L75
        o4 r14 = this.p.c(this.f7754a, r6, s4.d(), s4.n(), r12);     // Catch: Throwable -> L75
        r14.j();     // Catch: Throwable -> L75
        String r7 = r14.m();     // Catch: Throwable -> L75
        j5.e(this.f7754a);     // Catch: Throwable -> L75
        if (TextUtils.isEmpty(r7) == false) goto L13;
    L15:
        boolean r8 = false;
    L16:
        int r9 = l4.f7515j;     // Catch: Throwable -> L75
        if (j5.t() == false) goto L23;
        if (j5.I() == false) goto L23;
        if (r8 == false) goto L23;
        r9 = l4.f7516k;     // Catch: Throwable -> L75
    L23:
        if (j5.E() == true) goto L26;
        r4 = l4.d(this.f7754a).e(r14, r9);     // Catch: Throwable -> L75
    L26:
        if (r9 != l4.f7516k) goto L28;
        String r10 = "v6";
    L29:
        r13.e(r10);     // Catch: Throwable -> L75
        u0 r15 = this.p.a(r14);     // Catch: Throwable -> L75
        long r11 = a5.A();     // Catch: Throwable -> L75
        if (TextUtils.isEmpty(r4) == true) goto L36;
        if (r15.f7861f == true) goto L34;
        l4.d(this.f7754a).g(true, r9);     // Catch: Throwable -> L75
        goto L36
    L34:
        l4.d(this.f7754a).g(false, r9);     // Catch: Throwable -> L75
        l4.d(this.f7754a).f(r9);     // Catch: Throwable -> L75
    L36:
        if (r15 != null) goto L38;
    L43:
        r13.s("SUCCESS");     // Catch: Throwable -> L75
    L44:
        t3 r16 = this.N;     // Catch: Throwable -> L75
        if (r16 == null) goto L47;
        r16.s();     // Catch: Throwable -> L75
    L47:
        r13.g(r11);
        if (r15 != null) goto L50;
        String r0 = "";
    L54:
        ew r17 = f(r3, r15, r13);
        if (r17 == null) goto L57;
        return r17;
    L57:
        byte[] r18 = h4.g(r15.f7856a);
        if (r18 != null) goto L61;
        r3.E0(5);
        r13.y("#0503");
        this.q.append("解密数据失败#0503");
        r3.J0(this.q.toString());
        y4.p(r0, 2053);
        return r3;
    L61:
        ew r19 = this.f7759f.a(r3, r18, r13);
        if (a5.q(r19) == true) goto L73;
        String r20 = r19.c1();
        this.o = r20;
        if (TextUtils.isEmpty(r20) == true) goto L66;
        int r21 = 2062;
    L67:
        y4.p(r0, r21);
        r19.E0(6);
        r13.y("#0601");
        StringBuilder r110 = this.q;
        StringBuilder r22 = new StringBuilder("location faile retype:");
        r22.append(r19.h1());
        r22.append(" rdesc:");
        if (TextUtils.isEmpty(this.o) == true) goto L71;
        r2 = this.o;
    L71:
        r22.append(r2);
        r22.append("#0601");
        r110.append(r22.toString());
        r19.q1(this.z.toString());
        r19.J0(this.q.toString());
        return r19;
    L66:
        r21 = 2061;
        goto L67
    L73:
        x(r19);
        r19.N0(this.s);
        r19.b1(this.r);
        r19.m1(String.valueOf(this.t));
        r19.k1("new");
        r19.J0(this.q.toString());
        this.G = r19.X0();
        return r19;
    L50:
        if (TextUtils.isEmpty(r15.f7858c) == true) goto L52;
        this.q.append("#csid:" + r15.f7858c);
    L52:
        r0 = r15.f7859d;
        r3.q1(this.z.toString());
        goto L54
    L38:
        if (TextUtils.isEmpty(r4) == true) goto L43;
        if (r15.f7861f == true) goto L42;
        r13.h(r4);     // Catch: Throwable -> L75
        r13.l("SUCCESS");     // Catch: Throwable -> L75
        goto L44
    L42:
        r13.h(r4);     // Catch: Throwable -> L75
        r13.l("FAIL");     // Catch: Throwable -> L75
        goto L43
    L28:
        r10 = "v4";
        goto L29
    L13:
        if (r7.contains("dualstack") == false) goto L15;
        r8 = true;
    L75:
        th = move-exception;
        a5.A();
        r13.s("FAIL");
        l4.d(this.f7754a).g(false, l4.f7515j);
        s4.h(th, "Aps", "getApsLoc req");
        y4.s("/mobile/binary", th);
        if (a5.P(this.f7754a) == true) goto L81;
        r13.y("#0401");
        StringBuilder r111 = this.q;
        String r112 = "网络异常，未连接到网络，请连接网络#0401";
    L79:
        r111.append(r112);
    L94:
        ew r113 = c(4, this.q.toString());
        r113.q1(this.z.toString());
        return r113;
    L81:
        if ((th instanceof h5) == false) goto L92;
        h5 r23 = th;
        if (r23.a().contains("网络异常状态码") == false) goto L86;
        r13.y("#0404");
        StringBuilder r114 = this.q;
        r114.append("网络异常，状态码错误#0404");
        r114.append(r23.h());
        goto L94
    L86:
        if (r23.h() != 23) goto L88;
    L91:
        r13.y("#0402");
        r111 = this.q;
        r112 = "网络异常，连接超时#0402";
        goto L79
    L88:
        if (Math.abs((a5.A() - this.f7764k) - this.f7762i.w()) < 500) goto L91;
        StringBuilder r24 = new StringBuilder("#0403,");
    L93:
        r24.append(th.getMessage());
        r13.y(r24.toString());
        this.q.append("网络异常,请求异常#0403");
        goto L94
    L92:
        r24 = new StringBuilder("#0403,");
    L96:
        th = move-exception;
        r13.y("#0301");
        this.q.append("get parames error:" + th.getMessage() + "#0301");
        y4.p(null, 2031);
        ew r115 = c(3, this.q.toString());
        r115.q1(this.z.toString());
        return r115;
    }

    private void s(Context r2) {
        if (r2.checkCallingOrSelfPermission(u5.u("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFQ1VSRV9TRVRUSU5HUw==")) != 0) goto L9;
        this.n = true;     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    private String v(eq r17) {
        int r2 = this.f7757d.C();
        b4 r3 = this.f7757d.z();
        b4 r4 = this.f7757d.A();
        ArrayList<i3> r5 = this.f7760g;
        if (r5 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        String r8 = "";
        if (r3 != null) goto L84;
        if (r4 != null) goto L84;
        if (r6 == false) goto L84;
        if (this.f7755b != null) goto L17;
        this.f7755b = (ConnectivityManager) a5.g(this.f7754a, "connectivity");
    L17:
        if (a5.J() < 31) goto L25;
        if (a5.m(this.f7754a) == false) goto L31;
        if (this.f7756c.w() == true) goto L31;
        this.B = 18;
        this.q.append("飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关#1802");
        y4.p(null, 2132);
        r17.y("#1802");
        return "";
    L31:
        if (a5.J() < 28) goto L40;
        if (this.L != null) goto L36;
        this.L = (LocationManager) this.f7754a.getApplicationContext().getSystemService(LocationMonitorConst.LOCATION);
    L36:
        if (((Boolean) w4.c(this.L, "isLocationEnabled", new Object[0])).booleanValue() == true) goto L40;
        this.B = 12;
        this.q.append("定位服务没有开启，请在设置中打开定位服务开关#1206");
        r17.y("#1206");
        y4.p(null, 2121);
        return "";
    L40:
        if (a5.T(this.f7754a) == true) goto L44;
        this.B = 12;
        this.q.append("定位权限被禁用,请授予应用定位权限#1201");
        r17.y("#1201");
        y4.p(null, 2121);
        return "";
    L44:
        if (a5.J() >= 24) goto L46;
    L51:
        String r7 = this.f7757d.F();
        String r9 = this.f7756c.n();
        if (this.f7756c.h(this.f7755b) == false) goto L56;
        if (r9 == null) goto L56;
        this.B = 12;
        r17.y("#1202");
        this.q.append("获取基站与获取WIFI的权限都被禁用，请在安全软件中打开应用的定位权限#1202");
        y4.p(null, 2121);
        return "";
    L56:
        if (r7 == null) goto L64;
        this.B = 12;
        if (this.f7756c.v() == true) goto L60;
        r17.y("#1204");
        StringBuilder r0 = this.q;
        String r1 = "WIFI开关关闭，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限或者打开WIFI开关#1204";
    L61:
        r0.append(r1);
        y4.p(null, 2121);
        return "";
    L60:
        r17.y("#1205");
        r0 = this.q;
        r1 = "获取的WIFI列表为空，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限#1205";
        goto L61
    L64:
        if (this.f7756c.v() == true) goto L70;
        if (this.f7757d.I() == true) goto L70;
        this.B = 19;
        r17.y("#1901");
        this.q.append("没有检查到SIM卡，并且WIFI开关关闭，请打开WIFI开关或者插入SIM卡#1901");
        y4.p(null, 2133);
        return "";
    L70:
        if (this.f7756c.v() == true) goto L73;
        r17.y("#1301");
        StringBuilder r10 = this.q;
        String r11 = "获取到的基站为空，并且关闭了WIFI开关，请您打开WIFI开关再发起定位#1301";
    L72:
        r10.append(r11);
        this.B = 13;
        y4.p(null, 2131);
        return "";
    L73:
        r11 = "#1302";
        r17.y("#1302");
        if (this.f7756c.l() == null) goto L78;
        this.q.append("获取到的基站和WIFI信息均为空，请检查是否授予APP定位权限");
        if (a5.V(this.f7754a) == false) goto L80;
    L81:
        r10 = this.q;
    L80:
        this.q.append("或后台运行没有后台定位权限");
        goto L81
    L78:
        this.q.append("获取到的基站和WIFI信息均为空，请移动到有WIFI的区域，若确定当前区域有WIFI，请检查是否授予APP定位权限");
        if (a5.V(this.f7754a) == true) goto L81;
    L46:
        if (a5.J() >= 28) goto L51;
        if (Settings.Secure.getInt(this.f7754a.getContentResolver(), LocationMonitorConst.LOCATION_MODE, 0) != 0) goto L51;
        this.B = 12;
        r17.y("#1206");
        this.q.append("定位服务没有开启，请在设置中打开定位服务开关#1206");
        y4.p(null, 2121);
        return "";
    L25:
        if (a5.m(this.f7754a) == false) goto L31;
        if (this.f7756c.v() == true) goto L31;
        this.B = 18;
        this.q.append("飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关#1801");
        y4.p(null, 2132);
        r17.y("#1801");
        return "";
    L84:
        WifiInfo r12 = this.f7756c.x();
        this.w = r12;
        this.x = g4.i(r12);
        String r13 = "cgi";
        if (r2 == 0) goto L103;
        if (r2 == 1) goto L95;
        if (r2 == 2) goto L89;
        this.B = 11;
        y4.p(null, 2111);
        r17.y("#1101");
        this.q.append("get cgi failure#1101");
    L146:
        if (TextUtils.isEmpty(r8) == false) goto L148;
        return r8;
    L148:
        if (r8.startsWith("#") == true) goto L151;
        r8 = "#" + r8;
    L151:
        return a5.S() + r8;
    L89:
        if (r3 == null) goto L146;
        StringBuilder r14 = new StringBuilder();
        r14.append(r3.f7184a);
        r14.append("#");
        r14.append(r3.f7185b);
        r14.append("#");
        r14.append(r3.f7191h);
        r14.append("#");
        r14.append(r3.f7192i);
        r14.append("#");
        r14.append(r3.f7193j);
        r14.append("#");
        r14.append("network");
        r14.append("#");
        if (this.f7760g.isEmpty() == true) goto L93;
    L94:
        r13 = "cgiwifi";
    L101:
        r14.append(r13);
        r8 = r14.toString();
        goto L146
    L93:
        if (this.x == false) goto L101;
    L95:
        if (r3 == null) goto L146;
        r14 = new StringBuilder();
        r14.append(r3.f7184a);
        r14.append("#");
        r14.append(r3.f7185b);
        r14.append("#");
        r14.append(r3.f7186c);
        r14.append("#");
        r14.append(r3.f7187d);
        r14.append("#");
        r14.append("network");
        r14.append("#");
        if (this.f7760g.isEmpty() == false) goto L94;
        if (this.x == false) goto L101;
    L103:
        if (this.f7760g.isEmpty() == true) goto L105;
    L108:
        boolean r15 = true;
    L109:
        if (r4 == null) goto L111;
        boolean r16 = true;
    L113:
        if (r16 == false) goto L115;
    L130:
        String r18 = String.format(Locale.US, "#%s#", new Object[]{"network"});
        if (r16 == false) goto L138;
        r14 = new StringBuilder();
        r14.append(r4.b());
        if (this.f7760g.isEmpty() == true) goto L135;
    L136:
        r13 = "cgiwifi";
    L137:
        r14.append("network");
        r14.append("#");
        goto L101
    L135:
        if (this.x == false) goto L137;
    L138:
        if (r15 == false) goto L140;
        r8 = r18 + "wifi";
        goto L146
    L140:
        this.B = 2;
        if (this.f7756c.v() == true) goto L143;
        r17.y("#0203");
        StringBuilder r19 = this.q;
        String r20 = "当前基站为伪基站,并且关闭了WIFI开关，请在设置中打开WIFI开关#0203";
    L144:
        r19.append(r20);
        y4.p(null, 2022);
        goto L146
    L143:
        r17.y("#0204");
        r19 = this.q;
        r20 = "当前基站为伪基站,并且没有搜索到WIFI，请移动到WIFI比较丰富的区域#0204";
        goto L144
    L115:
        if (this.x == false) goto L121;
        if (this.f7760g.isEmpty() == false) goto L121;
        this.B = 2;
        r17.y("#0201");
        this.q.append("当前基站为伪基站，并且WIFI权限被禁用，请在安全软件中打开应用的定位权限#0201");
        y4.p(null, 2021);
        return "";
    L121:
        if (this.f7760g.size() != 1) goto L130;
        this.B = 2;
        if (this.x == true) goto L127;
        r17.y("#0202");
        this.q.append("当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202");
        y4.p(null, 2022);
        return "";
    L127:
        if (this.f7760g.get(0).f7380h == false) goto L130;
        r17.y("#0202");
        this.q.append("当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202");
        y4.p(null, 2021);
        return "";
    L111:
        r16 = false;
        goto L113
    L105:
        if (this.x == true) goto L108;
        r15 = false;
        goto L109
    L5:
        if (r5.isEmpty() == true) goto L8;
        r6 = false;
        goto L9
    }

    private static void x(ew r2) {
        if (r2.U() == 0) goto L5;
        return;
    L5:
        if (r2.Y() == 0) goto L7;
        return;
    L7:
        if ("-5".equals(r2.h1()) == false) goto L9;
    L20:
        r2.L0(5);
        return;
    L9:
        if (LocationInfoConst.ALLOW_USE_LOCATION.equals(r2.h1()) == true) goto L20;
        if ("2".equals(r2.h1()) == true) goto L20;
        if ("14".equals(r2.h1()) == true) goto L20;
        if (BDLocationException.ERROR_UNKNOWN.equals(r2.h1()) == true) goto L20;
        if ("-1".equals(r2.h1()) == true) goto L20;
        r2.L0(6);
    }

    private void z(ew r1) {
        if (r1 == null) goto L5;
        this.f7763j = r1;
        return;
    }

    @SuppressLint({"NewApi"})
    public final void A() {
        this.G = null;
        this.A = false;
        i4 r1 = this.f7758e;
        if (r1 == null) goto L5;
        r1.t(this.f7754a);
    L5:
        w3 r2 = this.F;
        if (r2 == null) goto L9;
        r2.c();
    L9:
        if (this.f7759f == null) goto L11;
        this.f7759f = null;
    L11:
        e4 r3 = this.I;
        if (r3 == null) goto L40;
        r3.d(this.f7753J);
    L40:
        Context r4 = this.f7754a;     // Catch: Throwable -> L20
        if (r4 == null) goto L19;
        b r5 = this.f7761h;     // Catch: Throwable -> L20
        if (r5 == null) goto L19;
        r4.unregisterReceiver(r5);     // Catch: Throwable -> L20
    L19:
        this.f7761h = null;
        c4 r6 = this.f7757d;
        if (r6 == null) goto L26;
        r6.n(this.f7753J);
    L26:
        g4 r7 = this.f7756c;
        if (r7 == null) goto L29;
        r7.m(this.f7753J);
    L29:
        ArrayList<i3> r8 = this.f7760g;
        if (r8 == null) goto L32;
        r8.clear();
    L32:
        y3 r9 = this.D;
        if (r9 == null) goto L35;
        r9.i();
    L35:
        this.f7763j = null;
        this.f7754a = null;
        this.z = null;
        this.L = null;
        return;
    L20:
        th = move-exception;
        s4.h(th, "Aps", "destroy");     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        this.f7761h = null;
        throw th;
    }

    public final void B() {
        t3 r0 = this.N;
        if (r0 == null) goto L6;
        r0.s();
        return;
    }

    public final void C() {
    L10:
        th = move-exception;
        v.m(th, "as", "stc");
        return;
    L3:
        if (this.f7754a != null) goto L6;
        return;
    L6:
        if (this.N != null) goto L8;
        this.N = new t3(this.f7754a);     // Catch: Throwable -> L10
    L8:
        this.N.h(this.f7757d, this.f7756c, this.H);     // Catch: Throwable -> L10
    }

    public final void D() {
        t3 r0 = this.N;
        if (r0 == null) goto L6;
        r0.e();
        return;
    }

    public final ew b(double r7, double r9) {
        String r0 = this.p.d(this.f7754a, r7, r9);     // Catch: Throwable -> L8
        if (r0.contains("\"status\":\"1\"") == false) goto L6;
        ew r6 = this.f7759f.b(r0);     // Catch: Throwable -> L8
        r6.setLatitude(r7);     // Catch: Throwable -> L8
        r6.setLongitude(r9);     // Catch: Throwable -> L8
        return r6;
    L6:
        return null;
    L11:
        return null;
    }

    public final ew d(eq r18) {
        y();
        r18.w("conitue");
        if (this.f7754a != null) goto L6;
        r18.y("#0101");
        this.q.append("context is null#0101");
        return c(1, this.q.toString());
    L6:
        int r0 = this.f7765l + 1;
        this.f7765l = r0;
        if (r0 != 1) goto L10;
        K();
    L10:
        if (p(this.f7764k) == true) goto L12;
    L20:
        y3 r1 = this.D;
        if (r1 == null) goto L88;
        if (this.E == false) goto L25;
        r1.a();
        goto L88
    L25:
        r1.c();
    L88:
    L36:
        th = move-exception;
        s4.h(th, "Aps", "getLocation getScanResultsParam");
    L86:
        this.f7757d.o(false, L());     // Catch: Throwable -> L40
    L42:
        String r2 = v(r18);
        this.y = r2;
        if (TextUtils.isEmpty(r2) == true) goto L45;
        this.z = i(this.z);
        if (this.f7756c.y() == false) goto L50;
        ew r3 = c(15, "networkLocation has been mocked!#1502");
        r18.y("#1502");
        r3.setMock(true);
        r3.T0(4);
        return r3;
    L50:
        ew r4 = this.f7758e.b(this.f7757d, J(), this.f7763j, this.f7756c, this.z, this.y, this.f7754a, false);
        if (a5.q(r4) == false) goto L54;
        r4.T0(2);
    L53:
        z(r4);
    L85:
        if (this.f7756c == null) goto L73;
        if (r4 == null) goto L73;
        long r7 = g4.j();     // Catch: Throwable -> L84
        if (r7 > 15) goto L67;
        r4.T0(1);     // Catch: Throwable -> L84
        goto L73
    L67:
        if (r7 > 120) goto L70;
        r4.T0(2);     // Catch: Throwable -> L84
        goto L73
    L70:
        if (r7 > 600) goto L72;
        r4.T0(3);     // Catch: Throwable -> L84
        goto L73
    L72:
        r4.T0(4);     // Catch: Throwable -> L84
    L73:
        this.f7758e.m(this.y, this.z, r4, this.f7754a, true);
        a5.q(r4);
        StringBuilder r5 = this.z;
        r5.delete(0, r5.length());
        if (r4 != null) goto L76;
    L82:
        z(r4);
        return this.f7763j;
    L76:
        if (this.E == false) goto L80;
        y3 r6 = this.D;
        if (r6 == null) goto L80;
        r4.setAltitude(r6.e());
        r4.setBearing(this.D.g());
        float r8 = (float) this.D.h();
    L81:
        r4.setSpeed(r8);
    L80:
        r4.setAltitude(0.0d);
        r8 = 0.0f;
        r4.setBearing(0.0f);
        goto L81
    L54:
        r4 = q(true, r18);
        if (a5.q(r4) == false) goto L57;
        r4.k1("new");
        this.f7758e.k(this.z.toString());
        this.f7758e.j(this.f7757d.z());
        goto L53
    L57:
        ew r9 = this.f7758e.b(this.f7757d, false, this.f7763j, this.f7756c, this.z, this.y, this.f7754a, true);
        if (a5.q(r9) == false) goto L85;
        r18.y("#0001");
        r9.T0(2);
        z(r9);
        r4 = r9;
        goto L85
    L45:
        return c(this.B, this.q.toString());
    L40:
        th = move-exception;
        s4.h(th, "Aps", "getLocation getCgiListParam");
        goto L42
    L28:
        if (this.f7762i.O() == false) goto L30;
    L33:
        boolean r10 = true;
    L34:
        this.f7756c.k(r10);     // Catch: Throwable -> L36
        this.f7760g = this.f7756c.p();     // Catch: Throwable -> L36
        goto L86
    L30:
        if (this.f7762i.N() == false) goto L33;
        r10 = false;
        goto L34
    L12:
        if (a5.q(this.f7763j) == false) goto L20;
        if (this.u == false) goto L19;
        if (r4.f(this.f7763j.getTime()) == false) goto L19;
        this.f7763j.L0(2);
    L19:
        return this.f7763j;
    }

    public final ew e(ew r3) {
        this.F.d(this.u);
        return this.F.b(r3);
    }

    public final ew g(boolean r7) {
        if (this.f7756c.y() == false) goto L7;
        return c(15, "networkLocation has been mocked!#1502");
    L7:
        if (TextUtils.isEmpty(this.y) == true) goto L9;
        ew r8 = this.f7758e.a(this.f7754a, this.y, this.z, true, r7);
        if (a5.q(r8) == false) goto L13;
        z(r8);
    L13:
        return r8;
    L9:
        return c(this.B, this.q.toString());
    }

    public final ew h(boolean r3, eq r4) {
        if (r3 == false) goto L4;
        String r0 = "statics";
    L5:
        r4.w(r0);
        if (this.f7754a != null) goto L10;
        r4.y("#0101");
        this.q.append("context is null#0101");
        y4.p(null, 2011);
        return c(1, this.q.toString());
    L10:
        if (this.f7756c.y() == false) goto L13;
        r4.y("#1502");
        return c(15, "networkLocation has been mocked!#1502");
    L13:
        r();
        if (TextUtils.isEmpty(this.y) == true) goto L16;
        ew r5 = q(r3, r4);
        if (a5.q(r5) == true) goto L20;
    L22:
        Q = true;
        return r5;
    L20:
        if (Q == true) goto L22;
        this.f7758e.k(this.z.toString());
        this.f7758e.j(this.f7757d.z());
        z(r5);
        goto L22
    L16:
        return c(this.B, this.q.toString());
    L4:
        r0 = "first";
        goto L5
    }

    public final void j() {
        c4 r0 = this.f7757d;
        if (r0 == null) goto L6;
        r0.r();
        return;
    }

    public final void k(Context r5) {
    L18:
        th = move-exception;
        th.printStackTrace();
        s4.h(th, "Aps", "initBase");
        return;
    L3:
        if (this.f7754a == null) goto L5;
        return;
    L5:
        this.F = new w3();     // Catch: Throwable -> L18
        Context r0 = r5.getApplicationContext();     // Catch: Throwable -> L18
        this.f7754a = r0;     // Catch: Throwable -> L18
        a5.C(r0);     // Catch: Throwable -> L18
        if (this.f7756c != null) goto L9;
        WifiManager r1 = (WifiManager) a5.g(this.f7754a, "wifi");     // Catch: Throwable -> L18
        this.f7756c = new g4(this.f7754a, r1, this.H);     // Catch: Throwable -> L18
    L9:
        if (this.f7757d != null) goto L11;
        this.f7757d = new c4(this.f7754a, this.H);     // Catch: Throwable -> L18
    L11:
        this.I = new e4(r5, this.H);     // Catch: Throwable -> L18
        if (this.f7758e != null) goto L15;
        this.f7758e = new i4();     // Catch: Throwable -> L18
    L15:
        if (this.f7759f != null) goto L23;
        this.f7759f = new p4();     // Catch: Throwable -> L18
        return;
    }

    public final void l(Handler r1) {
        this.H = r1;
    }

    public final void m(AMapLocation r4) {
        if (r4.U() == 0) goto L5;
        return;
    L5:
        d4 r0 = new d4();
        r0.f7240a = r4.Y();
        r0.f7243d = r4.getTime();
        r0.f7244e = (int) r4.getAccuracy();
        r0.f7241b = r4.getLatitude();
        r0.f7242c = r4.getLongitude();
        if (r4.Y() != 1) goto L9;
        this.I.c(r0);
        return;
    }

    public final void n(AMapLocationClientOption r8) {
        this.f7762i = r8;
        if (r8 != null) goto L5;
        this.f7762i = new AMapLocationClientOption();
    L5:
        g4 r1 = this.f7756c;
        if (r1 == null) goto L8;
        this.f7762i.S();
        r1.f(this.f7762i.T(), this.f7762i.K(), AMapLocationClientOption.P(), r8.D());
    L8:
        E();
        i4 r9 = this.f7758e;
        if (r9 == null) goto L11;
        r9.i(this.f7762i);
    L11:
        p4 r10 = this.f7759f;
        if (r10 == null) goto L14;
        r10.d(this.f7762i);
    L14:
        G();
    }

    public final void o(ew r4, int r5) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.U() == 0) goto L7;
        return;
    L7:
        d4 r0 = new d4();
        r0.f7243d = r4.getTime();
        r0.f7244e = (int) r4.getAccuracy();
        r0.f7241b = r4.getLatitude();
        r0.f7242c = r4.getLongitude();
        r0.f7240a = r5;
        r0.f7246g = Integer.parseInt(r4.h1());
        r0.f7247h = r4.w1();
        this.I.g(r0);
    }

    public final void r() {
        this.p = n4.b(this.f7754a);
        E();
        if (this.f7755b != null) goto L6;
        this.f7755b = (ConnectivityManager) a5.g(this.f7754a, "connectivity");
    L6:
        if (this.m != null) goto L9;
        this.m = new q4();
        return;
    }

    public final void t(eq r4) {
    L13:
        th = move-exception;
        s4.h(th, "Aps", "initFirstLocateParam");
    L15:
        this.A = true;
        return;
    L4:
        if (this.A == false) goto L6;
        return;
    L6:
        M();     // Catch: Throwable -> L13
        if (this.v == false) goto L9;
        H();     // Catch: Throwable -> L13
    L9:
        this.f7756c.k(this.v);     // Catch: Throwable -> L13
        this.f7760g = this.f7756c.p();     // Catch: Throwable -> L13
        this.f7757d.o(true, L());     // Catch: Throwable -> L13
        String r5 = v(r4);     // Catch: Throwable -> L13
        this.y = r5;     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r5) == true) goto L15;
        this.z = i(this.z);     // Catch: Throwable -> L13
        goto L15
    }

    public final void u(ew r8) {
        if (a5.q(r8) == false) goto L6;
        this.f7758e.m(this.y, this.z, r8, this.f7754a, true);
        return;
    }

    public final void w() {
        if (this.D != null) goto L5;
        this.D = new y3(this.f7754a);
    L5:
        H();
        this.f7756c.k(false);
        this.f7760g = this.f7756c.p();
        this.f7757d.o(false, L());
        this.f7758e.g(this.f7754a);
        s(this.f7754a);
    }

    public final void y() {
        if (this.q.length() <= 0) goto L6;
        StringBuilder r2 = this.q;
        r2.delete(0, r2.length());
        return;
    }
}
