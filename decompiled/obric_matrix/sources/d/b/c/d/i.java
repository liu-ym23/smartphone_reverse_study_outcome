package d.b.c.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.network.response.LocInfoRspData;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.scan.networklistener.NetworkManager;
import com.bytedance.bdlocation.sensor.SensorInfoManager;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.store.LocationCache;
import com.bytedance.bdlocation.thread.ThreadLooperManager;
import com.bytedance.bdlocation.utils.background.ActivityLifecycleUtil;
import com.bytedance.bdlocation.utils.background.BackgroundProvider;
import com.bytedance.bdlocation.utils.background.DefaultBackgroundProvider;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static i f13142i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f13143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Looper f13144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f13145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f13146d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f13147e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f13148f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f13149g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private BroadcastReceiver f13150h;

    class a implements Runnable {
        a(i r1) {
        }

        @Override // java.lang.Runnable
        public void run() {
            BDLocationConfig.setRequestLocation(true);
        }
    }

    class b implements BackgroundProvider.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f13151a;

        b(i r1) {
            this.f13151a = r1;
        }

        @Override // com.bytedance.bdlocation.utils.background.BackgroundProvider.Callback
        public void onAppBackgroundSwitch(boolean r3) {
            Logger.i("onAppBackgroundSwitch isEnterBackground:" + r3);
            if (BDLocationConfig.isOverSeas() == false) goto L5;
            return;
        L5:
            Logger.i("cold boot upload info coldBootBackground：" + i.b(this.f13151a));
            if (i.b(this.f13151a) == false) goto L9;
            i.c(this.f13151a, false);
            i r2 = this.f13151a;
            i.e(r2, i.d(r2));
            return;
        L9:
            i r4 = this.f13151a;
            if (r3 == false) goto L12;
            i.f(r4);
            return;
        L12:
            i.g(r4);
        }
    }

    class c implements BackgroundProvider.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f13152a;

        c(i r1) {
            this.f13152a = r1;
        }

        private /* synthetic */ void a(boolean r1) {
            i.i(this.f13152a, r1);
        }

        public /* synthetic */ void b(boolean r1) {
            a(r1);
        }

        @Override // com.bytedance.bdlocation.utils.background.BackgroundProvider.Callback
        public void onAppBackgroundSwitch(final boolean r3) {
            Logger.i("onAppBackgroundSwitchTest isEnterBackground:" + r3);
            if (LocationUtil.isMainThread() == false) goto L5;
            i.h(this.f13152a).post(new d.b.c.d.a(this, r3));
            return;
        L5:
            i.i(this.f13152a, r3);
        }
    }

    class d extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f13153a;

        class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ d f13154f;

            a(d r1) {
                this.f13154f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean r0 = LocationUtil.isLocationEnabled();
                Logger.i("LocationServiceObserver");
                if (i.j(this.f13154f.f13153a) == false) goto L6;
                LocationUtil.uploadDeviceStatus("bdlocation_provider_status_change", 0);
                i.k(this.f13154f.f13153a, false);
            L8:
                i.m(this.f13154f.f13153a, r0);
                return;
            L6:
                if (r0 == i.l(this.f13154f.f13153a)) goto L8;
                LocationUtil.uploadDeviceStatus("bdlocation_provider_status_change", 0);
                goto L8
            }
        }

        d(i r1) {
            this.f13153a = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            i.h(this.f13153a).post(new a(this));
        }
    }

    public i() {
        this.f13146d = false;
        this.f13148f = true;
        this.f13149g = true;
        this.f13150h = new d(this);
        this.f13144b = ThreadLooperManager.getSchedulerWorker();
        this.f13143a = new Handler(this.f13144b);
        this.f13145c = BDLocationConfig.getContext();
        o();
        if (BDLocationConfig.isOverSeas() == true) goto L5;
        H();
    L5:
        I();
        if (BDLocationConfig.isColdBootABTest() == false) goto L8;
        F();
    L9:
        G();
        Logger.d("ColdBootManager init`");
        return;
    L8:
        E();
        goto L9
    }

    private /* synthetic */ void A() {
        if (BDLocationConfig.isOverSeas() == true) goto L20;
        Logger.d("boot upload Location:" + BDLocationConfig.isReportLocationAtStart());
        if (LocationInfoConst.ALLOW_USE_LOCATION.equals(LocationUtil.allowUseLocation(true)) == false) goto L17;
        LocInfoRspData r1 = LocationUtil.uploadDeviceStatus("bdlocation_boot_upload_device_info", 0);
        if (r1 != null) goto L13;
    L18:
        u();
        return;
    L13:
        if (r1.isLocate == false) goto L18;
        LocationOption r2 = new LocationOption();
        r2.setUploadSource("bdlocation_boot_upload_location_info");
        r2.setMaxCacheTime(BDLocationConfig.getUploadInterval());
        r2.setTriggerType(0);
        r2.setUpload(true);
        r2.setLocationTimeOutMs(30000);
        r2.setLocateType(BDLocationConfig.getLocateType());
        r2.setBpeaCert(BDLocationConfig.getBpeaCert(LocationInfoConst.COLDSTART_CERT));
        r2.setBpeaAction("getLocation");
        r2.setMode(BDLocationConfig.getLocationMode());
        if (h.F().u(h.F().O(r2), r2) == true) goto L18;
        d.b.c.e.a.c(r2, null);
        goto L18
    L17:
        LocationUtil.uploadDeviceStatus("bdlocation_boot_upload_device_info", 0);
        goto L18
    L20:
        Logger.d("boot uploadLocation");     // Catch: BDLocationException -> L6
        d.b.c.e.a.e("bdlocation_upload_cold_start ", 0, true, 30000, 0);     // Catch: BDLocationException -> L6
        BDLocationExtrasService.getRegionDataCore().init();     // Catch: BDLocationException -> L6
    L6:
        e = move-exception;
        Logger.d("boot uploadLocation exception:" + e.getMessage());
        e.printStackTrace();
        goto L18
    }

    private void C() {
        Logger.i("enter foreground");
        BDLocationConfig.setFirstRequestLocation(true);
        BDLocationConfig.setRequestLocation(false);
        this.f13143a.postDelayed(e.f13091f, BDLocationConfig.getBootLegitimateTime());
        G();
        H();
        this.f13143a.post(new d.b.c.d.b(this));
    }

    private void D() {
        Logger.i("outerBackgroundTaskTest enter foreground");
        if (this.f13149g == false) goto L6;
        this.f13149g = false;
        Logger.i("cold boot upload info");
        J(this.f13145c);
        return;
    L6:
        BDLocationConfig.setFirstRequestLocation(true);
        o();
        this.f13143a.postDelayed(d.b.c.d.c.f13089f, BDLocationConfig.getBootLegitimateTime());
        G();
        H();
        Logger.i("outerBackgroundTaskTest upload info");
        LocationUtil.uploadDeviceStatus("bdlocation_background_switch", 0);
    }

    private void E() {
        Logger.d("ColdBootManager registerBackgroundCallback");
        BackgroundProvider r0 = BDLocationConfig.getAppBackgroundProvider();
        if (r0 != null) goto L5;
        r0 = t();
    L5:
        r0.addCallback(new b(this));
    }

    private void F() {
        Logger.d("ColdBootManager registerBackgroundCallbackABTest");
        BackgroundProvider r0 = BDLocationConfig.getAppBackgroundProvider();
        if (r0 != null) goto L5;
        r0 = t();
    L5:
        r0.addCallback(new c(this));
    }

    private synchronized void G() {
        monitor-enter(this);
        Logger.d("ColdBootManager registerLocationServiceObserver");     // Catch: Throwable -> L18
        if (this.f13145c != null) goto L6;
    L16:
        monitor-exit(this);
        return;
    L6:
        if (this.f13150h == null) goto L16;
        if (this.f13146d == true) goto L16;
        a(this.f13145c, this.f13150h, new IntentFilter("android.location.MODE_CHANGED"));     // Catch: Throwable -> L12
        this.f13146d = true;     // Catch: Throwable -> L12
    L14:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        Logger.i("registerLocationServiceObserver error" + th.toString());     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    private void H() {
        if (BDLocationConfig.isNewNetworkChangeRegister() == false) goto L5;
        return;
    L5:
        NetworkManager.getInstance().registerObserver(this.f13145c);
    }

    private void I() {
        Logger.d("ColdBootManager setLegitimate");
        this.f13143a.postDelayed(new a(this), BDLocationConfig.getBootLegitimateTime());
    }

    private void J(Context r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        Logger.d("ColdBootManager startUploadTask");
        if (d.b.h.a.a.h.s.h.g(r4) == true) goto L7;
        return;
    L7:
        if (BDLocationConfig.isReportAtStart() == false) goto L11;
        this.f13143a.postDelayed(new d.b.c.d.d(this), WsConstants.EXIT_DELAY_TIME);
        return;
    }

    private synchronized void K() {
        monitor-enter(this);
        Logger.d("ColdBootManager unRegisterLocationServiceObserver");     // Catch: Throwable -> L17
    L13:
        th = move-exception;
        Logger.i("unRegisterLocationServiceObserver error" + th.toString());     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);
        return;
    L5:
        if (this.f13146d == false) goto L15;
        Context r0 = this.f13145c;     // Catch: Throwable -> L13
        if (r0 == null) goto L11;
        BroadcastReceiver r1 = this.f13150h;     // Catch: Throwable -> L13
        if (r1 == null) goto L11;
        r0.unregisterReceiver(r1);     // Catch: Throwable -> L13
    L11:
        this.f13146d = false;     // Catch: Throwable -> L13
    L17:
        th = move-exception;
        throw th;
    }

    private void L() {
        NetworkManager.getInstance().unRegisterObserver(this.f13145c);
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

    static /* synthetic */ boolean b(i r0) {
        return r0.f13149g;
    }

    static /* synthetic */ boolean c(i r0, boolean r1) {
        r0.f13149g = r1;
        return r1;
    }

    static /* synthetic */ Context d(i r0) {
        return r0.f13145c;
    }

    static /* synthetic */ void e(i r0, Context r1) {
        r0.J(r1);
    }

    static /* synthetic */ void f(i r0) {
        r0.p();
    }

    static /* synthetic */ void g(i r0) {
        r0.C();
    }

    static /* synthetic */ Handler h(i r0) {
        return r0.f13143a;
    }

    static /* synthetic */ void i(i r0, boolean r1) {
        r0.r(r1);
    }

    static /* synthetic */ boolean j(i r0) {
        return r0.f13148f;
    }

    static /* synthetic */ boolean k(i r0, boolean r1) {
        r0.f13148f = r1;
        return r1;
    }

    static /* synthetic */ boolean l(i r0) {
        return r0.f13147e;
    }

    static /* synthetic */ boolean m(i r0, boolean r1) {
        r0.f13147e = r1;
        return r1;
    }

    private void n() {
        d.b.c.a.a.b().j();
    }

    private void p() {
        Logger.i("enter background");
        n();
        BDLocationConfig.setRequestLocation(false);
        K();
        L();
        h.F().Z();
        g.k().r();
        SensorInfoManager.getInstance().unregisterListener(5);
    }

    private void q() {
        Logger.i("outerBackgroundTaskTest enter background");
        n();
        BDLocationConfig.setRequestLocation(false);
        K();
        L();
        h.F().Z();
        g.k().r();
        SensorInfoManager.getInstance().unregisterListener(5);
    }

    private void r(boolean r2) {
        if (BDLocationConfig.isOverSeas() == false) goto L5;
        return;
    L5:
        if (r2 == false) goto L7;
        q();
        return;
    L7:
        D();
    }

    public static i s() {
        if (f13142i != null) goto L15;
        monitor-enter(i.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f13142i != null) goto L9;
        f13142i = new i();     // Catch: Throwable -> L11
    L9:
        monitor-exit(i.class);     // Catch: Throwable -> L11
    L15:
        return f13142i;
    }

    private BackgroundProvider t() {
        DefaultBackgroundProvider r1 = new DefaultBackgroundProvider();
        ActivityLifecycleUtil.register(r1);
        ActivityLifecycleUtil.init();
        Logger.i("set default AppBackgroundProvider");
        BDLocationConfig.setAppBackgroundProvider(r1);
        return r1;
    }

    private void u() {
        Logger.i("init extra service enable traceroute:" + BDLocationConfig.enableTraceroute());
        if (BDLocationConfig.enableTraceroute() == true) goto L5;
        return;
    L5:
        if (BDLocationConfig.isRestrictedModeOn() == true) goto L9;
        BDLocationExtrasService.getTraceRouteManager().init();
        return;
    }

    static /* synthetic */ void v() {
        LocationCache.getInstance().clearLocalLocationCache();
    }

    static /* synthetic */ void w() {
        BDLocationConfig.setRequestLocation(true);
    }

    private /* synthetic */ void x() {
        o();
        Logger.i("outerBackgroundTask upload info");
        LocationUtil.uploadDeviceStatus("bdlocation_background_switch", 0);
    }

    static /* synthetic */ void z() {
        BDLocationConfig.setRequestLocation(true);
    }

    public /* synthetic */ void B() {
        A();
    }

    public void o() {
        Context r0 = this.f13145c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (PermissionManager.hasLocationPermissions(r0) == false) goto L8;
        return;
    L8:
        if (LocationUtil.isMainThread() == false) goto L10;
        this.f13143a.post(f.f13092f);
        return;
    L10:
        LocationCache.getInstance().clearLocalLocationCache();
    }

    public /* synthetic */ void y() {
        x();
    }
}
