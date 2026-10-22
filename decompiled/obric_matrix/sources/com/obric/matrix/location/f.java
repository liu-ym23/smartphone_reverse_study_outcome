package com.obric.matrix.location;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Network;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.callback.BDRestrictedMode;
import com.bytedance.bdlocation.client.BDLocationClient;
import com.bytedance.bdlocation.client.BDLocationClientOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.init.BDLocationAgent;
import com.bytedance.bdlocation.init.LocationInitConfig;
import com.bytedance.bdlocation.log.Printer;
import com.bytedance.bdlocation.utils.background.BackgroundProvider;
import com.obric.matrix.base.event.OutwardEventProvider;
import com.obric.matrix.location.receiver.LocationReceiver;
import com.obric.matrix.location.service.LocationService;
import com.obric.matrix.q.h.k;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final f f9172l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f9174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PendingIntent f9175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f9176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f9177e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f9178f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f9179g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f9180h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Handler f9181i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.obric.matrix.location.g f9182j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile BDLocation f9183k;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f9184f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f9185g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f9186h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f9187i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ f f9188j;

        a(f r1, boolean r2, boolean r3, boolean r4, String r5) {
            this.f9188j = r1;
            this.f9184f = r2;
            this.f9185g = r3;
            this.f9186h = r4;
            this.f9187i = r5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.m(this.f9188j) == true) goto L7;
            com.obric.matrix.r.c.c.f("LocationManager", "onNetworkEvent: mInited=false");
            return;
        L7:
            if (com.obric.matrix.r.e.h.a() == false) goto L11;
            com.obric.matrix.r.c.c.s("LocationManager", "skip retry when air plane mode is on");
            return;
        L11:
            if (LocationUtil.isLocationEnabled() == true) goto L14;
            com.obric.matrix.r.c.c.s("LocationManager", "skip retry when location is off");
            return;
        L14:
            com.obric.matrix.location.i r0 = new com.obric.matrix.location.i();
            r0.f9206a = this.f9184f;
            r0.f9207b = this.f9185g;
            r0.f9208c = this.f9186h;
            r0.f9209d = f.h(this.f9188j);
            r0.f9210e = this.f9187i;
            com.obric.matrix.r.c.c.j("LocationManager", "retryStartLocation: message sent: " + r0);
            Message r1 = f.c(this.f9188j).obtainMessage(1);
            r1.obj = r0;
            f.c(this.f9188j).removeMessages(1);
            if (this.f9185g == false) goto L17;
            f.c(this.f9188j).sendMessageDelayed(r1, Math.min(((long) f.j(this.f9188j)) * com.obric.matrix.location.e.f9167a, com.obric.matrix.location.e.f9168b));
            return;
        L17:
            f.i(this.f9188j, 0);
            f.c(this.f9188j).removeMessages(1);
            f.c(this.f9188j).sendMessage(r1);
        }
    }

    class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f9189a;

        b(f r1, Looper r2) {
            this.f9189a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message r3) {
            super.handleMessage(r3);
            if (r3.what != 1) goto L6;
            com.obric.matrix.location.i r4 = (com.obric.matrix.location.i) r3.obj;
            com.obric.matrix.r.c.c.j("LocationManager", "retryStartLocation: message received: " + r4.toString());
            f.a(this.f9189a, r4);
            return;
        }
    }

    class c implements com.obric.matrix.ostracker_api.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f9190a;

        c(f r1) {
            this.f9190a = r1;
        }

        @Override // com.obric.matrix.ostracker_api.a
        public void a(@Nullable String r3) {
            com.obric.matrix.r.c.c.j("LocationManager", "onDeviceIdLoaded: " + r3);
            f.b(this.f9190a);
        }

        @Override // com.obric.matrix.ostracker_api.a
        public void b(@Nullable String r1) {
        }
    }

    class d implements Printer {
        d(f r1) {
        }

        @Override // com.bytedance.bdlocation.log.Printer
        public void d(String r1, String r2, Throwable r3) {
            if (r2.contains("GisResult:") == false) goto L5;
            com.obric.matrix.r.c.e.a(r1, r2);
            return;
        L5:
            com.obric.matrix.r.c.c.b(r1, r2);
        }

        @Override // com.bytedance.bdlocation.log.Printer
        public void e(String r1, String r2, Throwable r3) {
            com.obric.matrix.r.c.c.g(r1, r2, r3);
        }

        @Override // com.bytedance.bdlocation.log.Printer
        public void i(String r1, String r2, Throwable r3) {
            if (r2.contains("NetworkRequestManager post networkResponse:") == false) goto L5;
        L8:
            com.obric.matrix.r.c.e.d(r1, r2);
            return;
        L5:
            if (r2.contains("LocationCache: cache is ") == true) goto L8;
            com.obric.matrix.r.c.c.j(r1, r2);
        }

        @Override // com.bytedance.bdlocation.log.Printer
        public void v(String r1, String r2, Throwable r3) {
            com.obric.matrix.r.c.c.q(r1, r2);
        }

        @Override // com.bytedance.bdlocation.log.Printer
        public void w(String r1, String r2, Throwable r3) {
            com.obric.matrix.r.c.c.s(r1, r2);
        }
    }

    class e implements BDRestrictedMode {
        e(f r1) {
        }

        @Override // com.bytedance.bdlocation.callback.BDRestrictedMode
        public int getRestrictedMode() {
            return 2;
        }
    }

    /* JADX INFO: renamed from: com.obric.matrix.location.f$f, reason: collision with other inner class name */
    class C0242f implements com.obric.matrix.q.h.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f9191a;

        C0242f(f r1) {
            this.f9191a = r1;
        }

        @Override // com.obric.matrix.q.h.d
        public void a(@NonNull Network r3) {
            com.obric.matrix.r.c.c.j("LocationManager", "network onAvailable: " + r3);
            f.d(this.f9191a);
        }
    }

    class g implements BDLocationCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.matrix.location.i f9192a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f9193b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f9194c;

        g(f r1, com.obric.matrix.location.i r2, long r3) {
            this.f9194c = r1;
            this.f9192a = r2;
            this.f9193b = r3;
        }

        @Override // com.bytedance.bdlocation.callback.BDLocationCallback
        public void onError(@Nullable BDLocationException r6) {
            f.e(this.f9194c, false);
            this.f9192a.onError(r6);
            f.f(this.f9194c).h(r6, this.f9192a);
            com.obric.matrix.r.c.c.f("LocationManager", "onError, cost: " + (System.currentTimeMillis() - this.f9193b) + " ms" + r6);
        }

        @Override // com.bytedance.bdlocation.callback.BDLocationCallback
        public void onLocationChanged(@Nullable BDLocation r7) {
            f.e(this.f9194c, false);
            this.f9192a.onLocationChanged(r7);
            f.f(this.f9194c).i(r7, this.f9192a);
            com.obric.matrix.r.c.c.j("LocationManager", "onLocationChanged, cost: " + (System.currentTimeMillis() - this.f9193b) + " ms");
            if (r7 != null) goto L6;
            com.obric.matrix.r.c.c.f("LocationManager", "onLocationChanged: location = null");
            return;
        L6:
            com.obric.matrix.r.c.e.d("LocationManager", "onLocationChanged: location = " + r7);
            f.g(this.f9194c, r7);
            f.i(this.f9194c, 0);
            OutwardEventProvider.b(f.k(this.f9194c), "/location/status");
        }
    }

    class h implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f9195f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Context f9196g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ f f9197h;

        h(f r1, boolean r2, Context r3) {
            this.f9197h = r1;
            this.f9195f = r2;
            this.f9196g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.l(this.f9197h, this.f9195f, this.f9196g);
        }
    }

    class i implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ f f9198f;

        i(f r1) {
            this.f9198f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.m(this.f9198f) == false) goto L6;
            com.obric.matrix.r.c.c.j("LocationManager", "onStartEvent: has been inited");
            return;
        L6:
            String r0 = com.obric.matrix.ostracker_api.b.c();
            if (TextUtils.isEmpty(r0) == false) goto L10;
            com.obric.matrix.r.c.c.j("LocationManager", "onStartEvent: did is empty");
            return;
        L10:
            com.obric.matrix.r.c.c.j("LocationManager", "onStartEvent: ");
            this.f9198f.t(r0);
            f r3 = this.f9198f;
            r3.B(true, f.k(r3));
        }
    }

    class j implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ f f9199f;

        j(f r1) {
            this.f9199f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.obric.matrix.r.c.c.j("LocationManager", "onLocationAlarmEvent: ");
            if (com.obric.matrix.r.e.j.c() == true) goto L6;
            com.obric.matrix.r.c.c.j("LocationManager", "onLocationAlarmEvent: screen is off, ignore location alarm");
            return;
        L6:
            this.f9199f.z(false, true, "repeating_location_alarm");
        }
    }

    static {
        f9172l = new f();
    }

    private f() {
        this.f9173a = 0;
        this.f9176d = false;
        this.f9177e = false;
        this.f9178f = new Object();
        this.f9179g = false;
        this.f9181i = null;
        this.f9182j = new com.obric.matrix.location.g();
    }

    private void C(boolean r9, Context r10) {
        com.obric.matrix.r.c.c.j("LocationManager", "setRepeatAlarmInternal: " + r9);
        PendingIntent r0 = this.f9175c;
        if (r0 != null) goto L5;
        r0 = r(r10);
    L5:
        if (r0 != null) goto L8;
        com.obric.matrix.r.c.c.f("LocationManager", "setRepeatAlarm: repeatingIntent is null");
        return;
    L8:
        AlarmManager r1 = (AlarmManager) r10.getSystemService(NotificationCompat.CATEGORY_ALARM);
        r1.cancel(r0);
        if (r9 == false) goto L12;
        long r11 = SystemClock.elapsedRealtime();
        long r5 = com.obric.matrix.location.e.f9170d;
        r1.setRepeating(2, r11 + r5, r5, this.f9175c);
        z(false, false, "first_location_alarm");
        return;
    }

    private void D(com.obric.matrix.location.i r5) {
        com.obric.matrix.r.c.c.j("LocationManager", "startLocation: force=" + r5.f9206a);
        boolean r0 = u();
        com.obric.matrix.r.c.c.j("LocationManager", "isNeedLocation = " + r0);
        if (r0 == true) goto L8;
        if (r5.f9206a == true) goto L8;
        return;
    L8:
        if (com.obric.matrix.r.e.h.d() == true) goto L11;
        com.obric.matrix.r.c.c.s("LocationManager", "startLocation: network is not connected，skip");
        return;
    L11:
        this.f9179g = true;
        this.f9182j.j(r5);
        this.f9180h = SystemClock.elapsedRealtime();
        q(this.f9174b, r5.f9208c).getLocation(new g(this, r5, System.currentTimeMillis()));
    }

    static /* synthetic */ void a(f r0, com.obric.matrix.location.i r1) {
        r0.D(r1);
    }

    static /* synthetic */ void b(f r0) {
        r0.x();
    }

    static /* synthetic */ Handler c(f r0) {
        return r0.f9181i;
    }

    static /* synthetic */ void d(f r0) {
        r0.w();
    }

    static /* synthetic */ boolean e(f r0, boolean r1) {
        r0.f9179g = r1;
        return r1;
    }

    static /* synthetic */ com.obric.matrix.location.g f(f r0) {
        return r0.f9182j;
    }

    static /* synthetic */ BDLocation g(f r0, BDLocation r1) {
        r0.f9183k = r1;
        return r1;
    }

    static /* synthetic */ int h(f r0) {
        return r0.f9173a;
    }

    static /* synthetic */ int i(f r0, int r1) {
        r0.f9173a = r1;
        return r1;
    }

    static /* synthetic */ int j(f r1) {
        int r0 = r1.f9173a + 1;
        r1.f9173a = r0;
        return r0;
    }

    static /* synthetic */ Context k(f r0) {
        return r0.f9174b;
    }

    static /* synthetic */ void l(f r0, boolean r1, Context r2) {
        r0.C(r1, r2);
    }

    static /* synthetic */ boolean m(f r0) {
        return r0.f9176d;
    }

    public static f o() {
        return f9172l;
    }

    private BDLocationClient q(Context r5, boolean r6) {
        BDLocationClient r4 = new BDLocationClient(r5);
        BDLocationClientOption r7 = new BDLocationClientOption();
        BDLocationClientOption r1 = r7.setCert(true).setUploadSource("local_test").setLocationTimeOut(com.obric.matrix.location.e.f9169c);
        if (r6 == false) goto L5;
        long r2 = 0;
    L6:
        r1.setMaxCacheTime(r2).setLocateType(3).setAccuracyLevel(4).setTriggerType(0).setLocationMode(2).setLatestAdminVersion(true).setUpload(true);
        r4.setClientOption(r7);
        return r4;
    L5:
        r2 = 600000;
        goto L6
    }

    private PendingIntent r(Context r3) {
        Intent r2 = new Intent(r3, LocationService.class);
        r2.setAction("obric.intent.action.location.LOCATION_ALARM");
        return PendingIntent.getService(r3, 0, r2, 201326592);
    }

    private boolean u() {
        if (this.f9176d == true) goto L7;
        com.obric.matrix.r.c.c.f("LocationManager", "isNeedLocation: mInited=false");
        return false;
    L7:
        if (this.f9179g == false) goto L28;
        if ((SystemClock.elapsedRealtime() - this.f9180h) >= com.obric.matrix.location.e.f9169c) goto L28;
        com.obric.matrix.r.c.c.f("LocationManager", "location is running and does not time out");
        return false;
    L28:
        BDLocation r9 = p();     // Catch: Exception -> L26
        if (r9 != null) goto L17;
        return true;
    L17:
        if (r9.getLocationMs() < System.currentTimeMillis()) goto L20;
        com.obric.matrix.r.c.c.s("LocationManager", "location time is large than current time");
        return true;
    L20:
        long r3 = System.currentTimeMillis() - r9.getLocationMs();
        boolean r10 = r9.hasAddress();
        com.obric.matrix.r.c.c.j("LocationManager", "diffLocationTime: " + r3 + ", hasDistrict: " + r10);
        if (r3 >= (com.obric.matrix.location.e.f9170d - com.obric.matrix.location.e.f9171e)) goto L25;
        if (r10 == false) goto L25;
        com.obric.matrix.r.c.c.j("LocationManager", "isNeedLocation: diffLocationTimeMs < ALARM_REPEAT_INTERVAL_MS && hasDistrict: true");
        return false;
    L25:
        return true;
    L26:
        com.obric.matrix.r.c.c.f("LocationManager", "BDLocationAgent.getLastKnownLocation error");
        return true;
    }

    private void w() {
        com.obric.matrix.r.c.c.j("LocationManager", "onNetworkEvent: ");
        z(false, true, "net_available");
    }

    private void x() {
        this.f9181i.post(new i(this));
    }

    private void y() {
        com.obric.matrix.ostracker_api.b.a(new c(this));
    }

    public void A(boolean r9, boolean r10, boolean r11, String r12) {
        this.f9181i.post(new a(this, r9, r10, r11, r12));
    }

    public void B(boolean r3, Context r4) {
        if (this.f9181i != null) goto L7;
        com.obric.matrix.r.c.c.f("LocationManager", "setRepeatAlarm: handler is null");
        return;
    L7:
        if (r4.getApplicationContext() == null) goto L9;
        r4 = r4.getApplicationContext();
    L9:
        this.f9181i.post(new h(this, r3, r4));
    }

    public BDLocation n(double r7, double r9) {
        return BDLocationAgent.geocode(r9, r7, 1, true);
    }

    public BDLocation p() {
        BDLocation r0 = BDLocationAgent.getLastKnownLocation(4, true);
        BDLocation r6 = this.f9183k;
        if (r6 != null) goto L7;
        String r7 = "appCachedLocation is null, use sdkCachedLocation";
    L5:
        com.obric.matrix.r.c.c.b("LocationManager", r7);
        return r0;
    L7:
        if (r0 != null) goto L11;
        String r1 = "sdkCachedLocation is null, use appCachedLocation";
    L9:
        com.obric.matrix.r.c.c.b("LocationManager", r1);
        return r6;
    L11:
        long r2 = r6.getLocationMs() - r0.getLocationMs();
        if (r2 <= 0) goto L14;
        r1 = "appCachedLocation is newer, [" + r2 + "] ms";
        goto L9
    L14:
        r7 = "sdkCachedLocation is newer, [" + r2 + "] ms";
        goto L5
    }

    public void s(Context r4) {
        Object r0 = this.f9178f;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.f9177e == false) goto L9;
        com.obric.matrix.r.c.c.j("LocationManager", "init: already started");     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L9:
        this.f9177e = true;     // Catch: Throwable -> L16
        com.obric.matrix.r.c.c.j("LocationManager", "init: ");     // Catch: Throwable -> L16
        this.f9174b = r4;     // Catch: Throwable -> L16
        HandlerThread r5 = new HandlerThread("LocationThread");     // Catch: RuntimeException -> L13 Throwable -> L16
        r5.start();     // Catch: RuntimeException -> L13 Throwable -> L16
        b r1 = new b(this, r5.getLooper());     // Catch: RuntimeException -> L13 Throwable -> L16
        this.f9181i = r1;     // Catch: RuntimeException -> L13 Throwable -> L16
        this.f9182j.c(r1);     // Catch: RuntimeException -> L13 Throwable -> L16
        y();     // Catch: RuntimeException -> L13 Throwable -> L16
        x();     // Catch: RuntimeException -> L13 Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L13:
        e = move-exception;
        this.f9177e = false;     // Catch: Throwable -> L16
        throw e;     // Catch: Throwable -> L16
    }

    public void t(String r6) {
        if (this.f9176d == false) goto L5;
        return;
    L5:
        com.obric.matrix.r.c.c.j("LocationManager", "initLocation: ");
        LocationReceiver.b(this.f9174b);
        this.f9175c = r(this.f9174b);
        BackgroundProvider r1 = new BackgroundProvider();
        r1.onAppBackgroundSwitch(false);
        BDLocationAgent.init(new LocationInitConfig.Builder(com.bytedance.mpaas.app.a.b()).setBaseUrl("https://i.snssdk.com").setRestrictedMode(new e(this)).setLocateType(3).setBackgroundProvider(r1).setALogPrinter(new d(this)).isPrivacyConfirmed(true).setWorldView("CN").setAppId("508474").setDid(r6).setBpeaCerts(null).setDebug(false).build());
        if (BDLocationAgent.isInit() == false) goto L8;
        com.obric.matrix.r.c.c.b("LocationManager", "initLocation: init success");
    L9:
        k.l(new C0242f(this));
        this.f9176d = true;
        return;
    L8:
        com.obric.matrix.r.c.c.f("LocationManager", "initLocation: init failed");
        goto L9
    }

    public void v() {
        Handler r0 = this.f9181i;
        if (r0 != null) goto L6;
        com.obric.matrix.r.c.c.f("LocationManager", "onLocationAlarmEvent: handler is null");
        return;
    L6:
        r0.post(new j(this));
    }

    public void z(boolean r2, boolean r3, String r4) {
        A(r2, r3, false, r4);
    }
}
