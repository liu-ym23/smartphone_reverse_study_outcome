package d.b.n;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final Object s = null;
    private static a t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f14162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f14163c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f14164d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14165e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f14166f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f14167g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Object f14168h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Object f14169i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Object f14170j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Object f14171k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Object f14172l;
    private TelephonyManager m;
    private ConnectivityManager n;
    private c o;
    private b p;
    private int q;
    private Handler r;

    /* JADX INFO: renamed from: d.b.n.a$a, reason: collision with other inner class name */
    class HandlerC0380a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f14173a;

        HandlerC0380a(a r1, Looper r2) {
            this.f14173a = r1;
            super(r2);
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

        @Override // android.os.Handler
        public void handleMessage(Message r3) {
            if (r3 != null) goto L4;
            return;
        L4:
            super.handleMessage(r3);
            a.e(this.f14173a, new c(this.f14173a));
            a.g(this.f14173a, new b(this.f14173a));
            IntentFilter r4 = new IntentFilter();
            r4.addAction("android.net.wifi.RSSI_CHANGED");
            r4.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            a(a.h(this.f14173a), a.f(this.f14173a), r4);
            a.p(this.f14173a);
        }
    }

    class b extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f14174a;

        b(a r1) {
            this.f14174a = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r3, Intent r4) {
        L38:
            e = move-exception;
            e.printStackTrace();
            return;
        L3:
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r4.getAction()) == false) goto L29;
            NetworkInfo r5 = a.l(this.f14174a).getActiveNetworkInfo();     // Catch: Exception -> L38
            Object r6 = a.m(this.f14174a);     // Catch: Exception -> L38
            monitor-enter(r6);     // Catch: Exception -> L38
            if (r5 == null) goto L45;
        L10:
            if (r5 != null) goto L12;
        L14:
            a.o(this.f14174a, "DISCONNECTED");     // Catch: Throwable -> L8
        L15:
            monitor-exit(r6);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;     // Catch: Exception -> L38
        L17:
            if ("DISCONNECTED".equals(a.n(this.f14174a)) == false) goto L48;
            Object r7 = a.q(this.f14174a);     // Catch: Exception -> L38
            monitor-enter(r7);     // Catch: Exception -> L38
            a.b(this.f14174a, -1);     // Catch: Throwable -> L23
            monitor-exit(r7);     // Catch: Throwable -> L23
        L49:
            return;
        L23:
            th = move-exception;
            throw th;     // Catch: Exception -> L38
        L48:
            return;
        L12:
            if (r5.isConnected() == false) goto L14;
            a.p(this.f14174a);     // Catch: Throwable -> L8
            a.o(this.f14174a, r5.getTypeName());     // Catch: Throwable -> L8
            goto L15
        L45:
            a.o(this.f14174a, "DISCONNECTED");     // Catch: Throwable -> L8
            goto L10
        L29:
            if ("android.net.wifi.RSSI_CHANGED".equals(r4.getAction()) == false) goto L50;
            Object r8 = a.q(this.f14174a);     // Catch: Exception -> L38
            monitor-enter(r8);     // Catch: Exception -> L38
            int r9 = r4.getIntExtra("newRssi", -70);     // Catch: Throwable -> L35
            a r2 = this.f14174a;     // Catch: Throwable -> L35
            a.b(r2, a.d(r2, r9));     // Catch: Throwable -> L35
            monitor-exit(r8);     // Catch: Throwable -> L35
        L51:
            return;
        L35:
            th = move-exception;
            throw th;     // Catch: Exception -> L38
        }
    }

    class c extends PhoneStateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f14175a;

        c(a r1) {
            this.f14175a = r1;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int r1, int r2) {
            super.onDataConnectionStateChanged(r1, r2);
            Object r3 = a.a(this.f14175a);
            monitor-enter(r3);
            a r0 = this.f14175a;     // Catch: Throwable -> L6 Exception -> L8
            r0.f14161a = r2;     // Catch: Throwable -> L6 Exception -> L8
            a.c(r0, a.u(r2));     // Catch: Throwable -> L6 Exception -> L8
        L10:
            monitor-exit(r3);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        L8:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L6
            goto L10
        }

        @Override // android.telephony.PhoneStateListener
        public void onServiceStateChanged(ServiceState r1) {
            super.onServiceStateChanged(r1);
            a.i(this.f14175a, r1.toString());     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength r4) {
            super.onSignalStrengthsChanged(r4);
            Object r0 = a.j(this.f14175a);
            monitor-enter(r0);
        L13:
            th = move-exception;
            throw th;
        L6:
            if (Build.VERSION.SDK_INT >= 23) goto L18;
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L13
            return;
        L18:
            a.k(this.f14175a, r4.getLevel());     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L13
            goto L11
        }
    }

    static {
        s = new Object();
    }

    private a(Context r4) {
        this.f14161a = -1;
        this.f14162b = null;
        this.f14163c = "NOT_REGISTERED";
        this.f14164d = "NOT_REGISTERED";
        this.f14165e = -1;
        this.f14166f = -1;
        this.f14167g = false;
        this.f14168h = new Object();
        this.f14169i = new Object();
        this.f14170j = new Object();
        this.f14171k = new Object();
        this.f14172l = new Object();
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = -1;
        this.r = null;
        this.f14162b = r4;     // Catch: Exception -> L5
        this.m = (TelephonyManager) r4.getSystemService("phone");     // Catch: Exception -> L5
        this.n = (ConnectivityManager) this.f14162b.getSystemService("connectivity");     // Catch: Exception -> L5
        WifiManager r5 = (WifiManager) this.f14162b.getApplicationContext().getSystemService("wifi");     // Catch: Exception -> L5
        v();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    static /* synthetic */ Object a(a r0) {
        return r0.f14168h;
    }

    static /* synthetic */ int b(a r0, int r1) {
        r0.f14166f = r1;
        return r1;
    }

    static /* synthetic */ String c(a r0, String r1) {
        r0.f14163c = r1;
        return r1;
    }

    static /* synthetic */ int d(a r0, int r1) {
        return r0.r(r1);
    }

    static /* synthetic */ c e(a r0, c r1) {
        r0.o = r1;
        return r1;
    }

    static /* synthetic */ b f(a r0) {
        return r0.p;
    }

    static /* synthetic */ b g(a r0, b r1) {
        r0.p = r1;
        return r1;
    }

    static /* synthetic */ Context h(a r0) {
        return r0.f14162b;
    }

    static /* synthetic */ boolean i(a r0, String r1) {
        return r0.x(r1);
    }

    static /* synthetic */ Object j(a r0) {
        return r0.f14169i;
    }

    static /* synthetic */ int k(a r0, int r1) {
        r0.f14165e = r1;
        return r1;
    }

    static /* synthetic */ ConnectivityManager l(a r0) {
        return r0.n;
    }

    static /* synthetic */ Object m(a r0) {
        return r0.f14170j;
    }

    static /* synthetic */ String n(a r0) {
        return r0.f14164d;
    }

    static /* synthetic */ String o(a r0, String r1) {
        r0.f14164d = r1;
        return r1;
    }

    static /* synthetic */ boolean p(a r0) {
        return r0.y();
    }

    static /* synthetic */ Object q(a r0) {
        return r0.f14171k;
    }

    private int r(int r3) {
        if (r3 > (-88)) goto L7;
        return 0;
    L7:
        if (r3 < (-55)) goto L10;
        return 4;
    L10:
        return ((r3 - (-88)) * 4) / 33;
    }

    public static a s(Context r2) {
        Object r0 = s;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (t != null) goto L7;
        t = new a(r2);     // Catch: Throwable -> L10
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return t;
    }

    public static String u(int r0) {
        switch(r0) {
            case 1: goto L43;
            case 2: goto L41;
            case 3: goto L39;
            case 4: goto L37;
            case 5: goto L35;
            case 6: goto L33;
            case 7: goto L31;
            case 8: goto L29;
            case 9: goto L27;
            case 10: goto L25;
            case 11: goto L23;
            case 12: goto L21;
            case 13: goto L19;
            case 14: goto L17;
            case 15: goto L15;
            case 16: goto L13;
            case 17: goto L11;
            case 18: goto L9;
            case 19: goto L7;
            case 20: goto L5;
            default: goto L3;
        };
    L3:
        return "UNKNOWN";
    L5:
        return "NR";
    L7:
        return "LTE_CA";
    L9:
        return "IWLAN";
    L11:
        return "TD_SCDMA";
    L13:
        return "GSM";
    L15:
        return "HSPA+";
    L17:
        return "CDMA - eHRPD";
    L19:
        return "LTE";
    L21:
        return "CDMA - EvDo rev. B";
    L23:
        return "iDEN";
    L25:
        return "HSPA";
    L27:
        return "HSUPA";
    L29:
        return "HSDPA";
    L31:
        return "CDMA - 1xRTT";
    L33:
        return "CDMA - EvDo rev. A";
    L35:
        return "CDMA - EvDo rev. 0";
    L37:
        return "CDMA";
    L39:
        return "UMTS";
    L41:
        return "EDGE";
    L43:
        return "GPRS";
    }

    private void v() {
        HandlerThread r0 = new HandlerThread("listener_thread");
        r0.start();
        HandlerC0380a r1 = new HandlerC0380a(this, r0.getLooper());
        this.r = r1;
        r1.sendEmptyMessage(0);
    }

    private boolean x(String r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        Object r1 = this.f14172l;
        monitor-enter(r1);
        this.f14167g = false;     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r3) == false) goto L10;
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L17
        return this.f14167g;
    L10:
        if (r3.contains("nrState=NOT_RESTRICTED") == false) goto L12;
    L13:
        this.f14167g = true;     // Catch: Throwable -> L17
        goto L14
    L12:
        if (r3.contains("nrState=CONNECTED") == false) goto L14;
    L17:
        th = move-exception;
        throw th;
    }

    private boolean y() {
        if (Build.VERSION.SDK_INT >= 24) goto L13;
        return false;
    L13:
        int r0 = SubscriptionManager.getDefaultDataSubscriptionId();     // Catch: Exception -> L10
        if (this.q == r0) goto L15;
        TelephonyManager r2 = this.m.createForSubscriptionId(r0);     // Catch: Exception -> L10
        this.m = r2;     // Catch: Exception -> L10
        r2.listen(this.o, 321);     // Catch: Exception -> L10
        this.q = r0;     // Catch: Exception -> L10
        return true;
    L15:
        return true;
    L10:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public String t() {
        if (Build.VERSION.SDK_INT >= 24) goto L6;
        return "NOT_SUPPORTED";
    L6:
        Object r0 = this.f14170j;
        monitor-enter(r0);
        String r2 = this.f14164d;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r2;
    L11:
        th = move-exception;
        throw th;
    }

    public String toString() {
        return "NetworkQualityCollect{mGSMType='" + this.f14163c + "', mNetworkType='" + this.f14164d + "', mDataLevel=" + this.f14165e + ", mWifiLevel=" + this.f14166f + ", lastDataSim=" + this.q + ", getIpAvailableType=" + d.b.n.c.a(this.f14162b) + '}';
    }

    public boolean w() {
        if (Build.VERSION.SDK_INT >= 24) goto L6;
        return false;
    L6:
        if (this.f14167g == false) goto L8;
        return true;
    L8:
        if ("NR".equals(this.f14163c) == true) goto L13;
        return false;
    L13:
        return true;
    }
}
