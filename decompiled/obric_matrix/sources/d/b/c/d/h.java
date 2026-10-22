package d.b.c.d;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.BaseLocate;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.api.IBPEALocal;
import com.bytedance.bdlocation.api.ILocate;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.callback.LightLocationCallback;
import com.bytedance.bdlocation.callback.LocateCallback;
import com.bytedance.bdlocation.callback.LocationNotification;
import com.bytedance.bdlocation.callback.LocationSubmitNotification;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.BDPoint;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.entity.bpea.BPEACertCheckResult;
import com.bytedance.bdlocation.entity.gis.BdGisResult;
import com.bytedance.bdlocation.event.LocationEvent;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.exception.BDLocationExceptionMessage;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.network.model.LocationUploadExtra;
import com.bytedance.bdlocation.network.response.LocationResp;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.permission.request.RequestPermissionUtils;
import com.bytedance.bdlocation.sensor.SensorInfoManager;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.store.LocationCache;
import com.bytedance.bdlocation.store.LocationCacheInfo;
import com.bytedance.bdlocation.thread.AppExecutors;
import com.bytedance.bdlocation.thread.ThreadLooperManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile h f13103i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LocationCache f13104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d.b.c.d.j f13105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f13106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Handler f13107d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Looper f13108e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ILocate f13109f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private IBPEALocal f13110g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private l f13111h;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ LocationSubmitNotification f13112f;

        a(h r1, LocationSubmitNotification r2) {
            this.f13112f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            BDLocationConfig.removeSubmitNotification(this.f13112f);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Object f13113f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f13114g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f13115h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f13116i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ long f13117j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ h f13118k;

        class a implements LightLocationCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f13119a;

            a(b r1) {
                this.f13119a = r1;
            }

            @Override // com.bytedance.bdlocation.callback.LightLocationCallback
            public void onError(String r3, String r4) {
                Logger.i("getLightLocation parseLocInfoRsp:" + r4 + "--code:" + r3);
                LocationMonitor.doLightLocationError(r3, r4, this.f13119a.f13116i);
            }

            @Override // com.bytedance.bdlocation.callback.LightLocationCallback
            public void onSuccess(LocationResp r18, LocationUploadExtra r19) {
                if (r18 != null) goto L6;
                LocationMonitor.doLightLocationError(BDLocationException.ERROR_LIGHT_LOCATION_UPLOAD_LOCATION_INFO, "LocationResp is null", this.f13119a.f13116i);
                Logger.i("getLightLocation parseLocInfoRsp error : result is null");
                return;
            L6:
                int r2 = r18.resultCode;
                if (r2 == 0) goto L10;
                LocationMonitor.doLightLocationError(String.valueOf(r2), r18.resultMsg, this.f13119a.f13116i);
                Logger.i("getLightLocation parseLocInfoRsp error:" + r18.toString());
                return;
            L10:
                long r7 = System.currentTimeMillis() - this.f13119a.f13115h;
                Logger.i("getLightLocation total Duration：" + r7 + "--geCellDuration:" + r19.getCurrentStationDuration() + "--submitDuration:" + r19.getLightSubmitDuration() + "--appColdBootToStartLocationDuration:" + this.f13119a.f13117j);
                LocationMonitor.doLightLocation(this.f13119a.f13117j, r7, r19.getCurrentStationDuration(), r19.getLightSubmitDuration(), true, BDLocationException.SUCCESS, "", this.f13119a.f13116i);
            }
        }

        b(h r1, Object r2, String r3, long r4, boolean r6, long r7) {
            this.f13118k = r1;
            this.f13113f = r2;
            this.f13114g = r3;
            this.f13115h = r4;
            this.f13116i = r6;
            this.f13117j = r7;
        }

        @Override // java.lang.Runnable
        public void run() {
            LocationUtil.checkBpeaCertNull("getLightLocation", this.f13113f);     // Catch: BDLocationException -> L10
            LocationUploadExtra r1 = new LocationUploadExtra();     // Catch: BDLocationException -> L10
            if (h.e(this.f13118k, this.f13113f) == false) goto L7;
            h.f(this.f13118k).checkAndTranslateCert(this.f13113f, "getLightLocation");     // Catch: BDLocationException -> L10
            String r0 = h.f(this.f13118k).getBpeaToken(this.f13113f);     // Catch: BDLocationException -> L10
        L6:
            r1.setUploadSource(r0);     // Catch: BDLocationException -> L10
            r1.setStartLocationTime(this.f13115h);     // Catch: BDLocationException -> L10
            LocationUtil.startLightLocationUpload(r1, this.f13113f, new a(this));     // Catch: BDLocationException -> L10
            return;
        L7:
            r0 = this.f13114g;     // Catch: BDLocationException -> L10
        L10:
            e = move-exception;
            LocationMonitor.doLightLocationError(e.getCode(), e.getMessage(), this.f13116i);
        }
    }

    class c implements BDLocationCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BDLocation[] f13120a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f13121b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BDLocationException[] f13122c;

        c(h r1, BDLocation[] r2, CountDownLatch r3, BDLocationException[] r4) {
            this.f13120a = r2;
            this.f13121b = r3;
            this.f13122c = r4;
        }

        @Override // com.bytedance.bdlocation.callback.BDLocationCallback
        public void onError(BDLocationException r3) {
            this.f13122c[0] = r3;
            this.f13121b.countDown();
        }

        @Override // com.bytedance.bdlocation.callback.BDLocationCallback
        public void onLocationChanged(BDLocation r3) {
            this.f13120a[0] = r3;
            this.f13121b.countDown();
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ LocationOption f13123f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ BDLocationCallback f13124g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ h f13125h;

        d(h r1, LocationOption r2, BDLocationCallback r3) {
            this.f13125h = r1;
            this.f13123f = r2;
            this.f13124g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            h r0 = h.a();
            monitor-enter(r0);
            Logger.i("startLocation is DownGradeLocation:" + this.f13123f.isDownGradeLocation());     // Catch: Throwable -> L40
            if (this.f13123f.isDownGradeLocation() == false) goto L7;
            LocationOption r1 = new LocationOption(this.f13123f);     // Catch: Throwable -> L40
        L9:
            if (BDLocationConfig.isOverSeas() == true) goto L11;
            r1.setUploadInterval(d.b.c.a.a.b().c() / 1000);     // Catch: Throwable -> L40
        L11:
            BDLocation r2 = this.f13125h.O(r1);     // Catch: Throwable -> L40
            h.g(this.f13125h, r1, r2);     // Catch: Throwable -> L40
            boolean r3 = this.f13125h.u(r2, r1);     // Catch: Throwable -> L40
            if (h.h(this.f13125h, r1, r3) == false) goto L18;
            h.i(this.f13125h).a(this.f13124g);     // Catch: Throwable -> L40
            if (h.i(this.f13125h).d() == false) goto L17;
            monitor-exit(r0);     // Catch: Throwable -> L40
            return;
        L17:
            h.i(this.f13125h).onLocateStart("");     // Catch: Throwable -> L40
            h.i(this.f13125h).f(r1);     // Catch: Throwable -> L40
        L18:
            BDLocationCallback r4 = d.b.c.b.a.a().b(this.f13124g, r1, h.i(this.f13125h), h.j(this.f13125h));     // Catch: Throwable -> L40
            if (this.f13125h.s(r1, r4) == true) goto L23;
            Logger.i("RestrictedMode|background|LocationServer|permission unable");     // Catch: Throwable -> L40
            monitor-exit(r0);     // Catch: Throwable -> L40
            return;
        L23:
            StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L40
            r5.append("BDLocationUPTest getSuitableCache :::");     // Catch: Throwable -> L40
            if (r2 == null) goto L26;
            boolean r6 = true;
        L27:
            r5.append(String.valueOf(r6));     // Catch: Throwable -> L40
            Logger.d(r5.toString());     // Catch: Throwable -> L40
            if (r3 == false) goto L30;
            h.k(this.f13125h, r2, r4);     // Catch: Throwable -> L40
        L37:
            Logger.d("startLocation :");     // Catch: Throwable -> L40
            monitor-exit(r0);     // Catch: Throwable -> L40
            return;
        L30:
            int r7 = h.l(this.f13125h, r1, r2);     // Catch: Throwable -> L40
            Logger.i("startLocation locateType:" + r7);     // Catch: Throwable -> L40
            h r8 = this.f13125h;     // Catch: Throwable -> L40
            h.n(r8, h.o(r8).b(r7));     // Catch: Throwable -> L40
            if (h.m(this.f13125h) != null) goto L33;
            h.d(this.f13125h, r4, new BDLocationException("未获取到定位内核异常", BuildConfig.BDLOCATION_VERSION, BDLocationException.ERROR_NO_LOCATE));     // Catch: Throwable -> L40
            goto L37
        L33:
            if (this.f13123f.isDownGradeLocation() == true) goto L35;
            d.b.c.d.g.k().q(r1);     // Catch: Throwable -> L40
            SensorInfoManager.getInstance().registerListener(5);     // Catch: Throwable -> L40
        L35:
            h.m(this.f13125h).startLocation(r4, r1, h.c(this.f13125h));     // Catch: Throwable -> L40
            goto L37
        L26:
            r6 = false;
            goto L27
        L7:
            r1 = new LocationOption(h.b(this.f13125h, this.f13123f, this.f13124g));     // Catch: Throwable -> L40
            LocationMonitor.uploadAuthStatus(LocationMonitorConst.LOCATION, PermissionManager.checkLocationPermissions(BDLocationConfig.getContext()), LocationUtil.getLocationMode(BDLocationConfig.getContext()));     // Catch: Throwable -> L40
        L40:
            th = move-exception;
            throw th;
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ BDLocationCallback f13126f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ BDLocation f13127g;

        e(h r1, BDLocationCallback r2, BDLocation r3) {
            this.f13126f = r2;
            this.f13127g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f13126f.onLocationChanged(this.f13127g);
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ BDLocationCallback f13128f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ BDLocationException f13129g;

        f(h r1, BDLocationCallback r2, BDLocationException r3) {
            this.f13128f = r2;
            this.f13129g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f13128f.onError(this.f13129g);
        }
    }

    class g implements RequestPermissionUtils.OnPermissionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestPermissionUtils.OnPermissionListener f13130a;

        g(h r1, RequestPermissionUtils.OnPermissionListener r2) {
            this.f13130a = r2;
        }

        @Override // com.bytedance.bdlocation.permission.request.RequestPermissionUtils.OnPermissionListener
        public void onPermissionDenied() {
            this.f13130a.onPermissionDenied();
            LocationCache.getInstance().setLocationDenyTime(System.currentTimeMillis());
        }

        @Override // com.bytedance.bdlocation.permission.request.RequestPermissionUtils.OnPermissionListener
        public void onPermissionGranted() {
            this.f13130a.onPermissionGranted();
        }
    }

    /* JADX INFO: renamed from: d.b.c.d.h$h, reason: collision with other inner class name */
    class RunnableC0348h implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ LocationNotification f13131f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f13132g;

        RunnableC0348h(h r1, LocationNotification r2, int r3) {
            this.f13131f = r2;
            this.f13132g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            BDLocationConfig.addNotification(this.f13131f, this.f13132g);
        }
    }

    class i implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ LocationNotification f13133f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Object f13134g;

        i(h r1, LocationNotification r2, Object r3) {
            this.f13133f = r2;
            this.f13134g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            BDLocationConfig.addNotification(this.f13133f, this.f13134g);
        }
    }

    class j implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ LocationNotification f13135f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f13136g;

        j(h r1, LocationNotification r2, int r3) {
            this.f13135f = r2;
            this.f13136g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            BDLocationConfig.removeNotification(this.f13135f, this.f13136g);
        }
    }

    class k implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Object f13137f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ LocationSubmitNotification f13138g;

        k(h r1, Object r2, LocationSubmitNotification r3) {
            this.f13137f = r2;
            this.f13138g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            BDLocationConfig.addSubmitNotification(this.f13137f, this.f13138g);
        }
    }

    public class l implements LocateCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f13139a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private LocationOption f13140b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List<BDLocationCallback> f13141c;

        public l(h r1) {
            this.f13139a = false;
            this.f13141c = new ArrayList();
        }

        public synchronized void a(BDLocationCallback r2) {
            monitor-enter(this);
            this.f13141c.add(r2);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized void b() {
            monitor-enter(this);
            this.f13141c.clear();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized List<BDLocationCallback> c() {
            monitor-enter(this);
            List<BDLocationCallback> r0 = this.f13141c;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized boolean d() {
            monitor-enter(this);
            boolean r0 = this.f13139a;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        public boolean e(LocationOption r1) {
            if (r1 == null) goto L9;
            LocationOption r0 = this.f13140b;
            if (r0 != null) goto L6;
            return true;
        L6:
            if (r0.isLatestAdminVersion() == r1.isLatestAdminVersion()) goto L12;
            return false;
        L12:
            return true;
        L9:
            return true;
        }

        public void f(LocationOption r1) {
            this.f13140b = r1;
        }

        @Override // com.bytedance.bdlocation.callback.LocateCallback
        public synchronized void onLocateChange(String r1, BDLocation r2) {
            monitor-enter(this);
            monitor-exit(this);
        }

        @Override // com.bytedance.bdlocation.callback.LocateCallback
        public synchronized void onLocateError(String r1, BDLocationException r2) {
            monitor-enter(this);
            monitor-exit(this);
        }

        @Override // com.bytedance.bdlocation.callback.LocateCallback
        public synchronized void onLocateStart(String r1) {
            monitor-enter(this);
            this.f13139a = true;     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.bdlocation.callback.LocateCallback
        public synchronized void onLocateStop(String r1) {
            monitor-enter(this);
            this.f13139a = false;     // Catch: Throwable -> L7
            this.f13140b = null;     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static {
    }

    private h(Context r2) {
        this.f13111h = new l(this);
        this.f13108e = ThreadLooperManager.getLocationWorker();
        this.f13106c = new Handler(this.f13108e);
        this.f13107d = new Handler(Looper.getMainLooper());
        this.f13104a = LocationCache.getInstance();
        this.f13105b = d.b.c.d.j.a();
        this.f13110g = BDLocationExtrasService.getBPEAManager();
        d.b.c.d.i.s();
    }

    public static h F() {
        if (f13103i != null) goto L15;
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f13103i != null) goto L9;
        f13103i = new h(BDLocationConfig.getContext());     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    L15:
        return f13103i;
    }

    @Nullable
    private BDLocation J(int r2) {
        Logger.i("getLastKnowLocation start");
        LocationCache r1 = F().D();
        if (r1 != null) goto L6;
        return null;
    L6:
        BDLocation r3 = r1.getLocationCache().getLatestLocation();
        if (r3 == null) goto L9;
        r3.setCache(true);
    L9:
        BDLocation r4 = LocationUtil.transformLocationForLevel(r3, r2);
        Logger.i("getLastKnowLocation end");
        return r4;
    }

    private int L(LocationOption r1, BDLocation r2) {
        int r0 = r1.getLocateType();
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        return BDLocationConfig.getLocateType();
    }

    private static String[] M(int r3) {
        if (r3 != 0) goto L7;
        return new String[]{"android.permission.ACCESS_FINE_LOCATION"};
    L7:
        if (r3 != 1) goto L11;
        return new String[]{"android.permission.ACCESS_COARSE_LOCATION"};
    L11:
        return new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
    }

    private long N() {
        return d.b.c.a.a.b().c() + 1000;
    }

    private boolean P(LocationOption r2, boolean r3) {
        if (r3 == false) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r2.getExtra()) == true) goto L9;
        return false;
    L9:
        if (r2.isDownGradeLocation() == false) goto L12;
        return false;
    L12:
        if (r2.isOnceLocation() == true) goto L14;
    L17:
        return false;
    L14:
        if (this.f13111h.e(r2) == false) goto L17;
        return true;
    }

    private void Q(BDLocationCallback r3, BDLocationException r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        AppExecutors.getInstance().mainThread().execute(new f(this, r3, r4));
    }

    private void R(BDLocation r3, BDLocationCallback r4) {
        AppExecutors.getInstance().mainThread().execute(new e(this, r4, r3));
    }

    private void V(LocationOption r2, BDLocation r3) {
        boolean r1 = LocationUtil.isChineseRegion(r3);
        Logger.i("getLocateType check region isChineseRegion:" + r1);
        r2.setChineseRegion(r1);
        if (r1 == true) goto L6;
        r2.setLocateType(0);
        return;
    }

    private LocationOption W(JSONObject r7, LocationOption r8) {
        if (r7 == null) goto L9;
        if (r8 != null) goto L5;
        r8 = new LocationOption();
    L5:
        r8.setUpload(r7.optBoolean("single_is_upload", true));
        long r2 = r7.optInt("cache_time", 300000);
        if (r2 <= 0) goto L8;
        r2 = N();
    L8:
        r8.setMaxCacheTime(r2);
        r8.setLocationTimeOutMs(r7.optLong("time_out", 30000));
        r8.setTriggerType(r7.optInt("trigger_type", 1));
        r8.setInterval(r7.optInt("location_interval", 1000));
        r8.setGeocodeMode(r7.optInt("geocode_mode", 1));
        r8.setAccuracyLevel(r7.optInt("accuracy_level", 4));
        r8.setLocateType(r7.optInt(LocationMonitorConst.LOCATE_TYPE, 3));
    L9:
        return r8;
    }

    static /* synthetic */ h a() {
        return f13103i;
    }

    static /* synthetic */ LocationOption b(h r0, LocationOption r1, BDLocationCallback r2) {
        return r0.v(r1, r2);
    }

    private BDLocationException b0(String r1, String r2, String r3, BDLocationCallback r4) {
        BDLocationException r0 = new BDLocationException(r1, r2, r3);
        if (r4 == null) goto L5;
        r4.onError(r0);
    L5:
        return r0;
    }

    static /* synthetic */ Looper c(h r0) {
        return r0.f13108e;
    }

    private void c0(BDLocationException r1, BDLocationCallback r2) {
        if (r2 == null) goto L5;
        r2.onError(r1);
        return;
    }

    static /* synthetic */ void d(h r0, BDLocationCallback r1, BDLocationException r2) {
        r0.Q(r1, r2);
    }

    static /* synthetic */ boolean e(h r0, Object r1) {
        return r0.t(r1);
    }

    static /* synthetic */ IBPEALocal f(h r0) {
        return r0.f13110g;
    }

    static /* synthetic */ void g(h r0, LocationOption r1, BDLocation r2) {
        r0.V(r1, r2);
    }

    static /* synthetic */ boolean h(h r0, LocationOption r1, boolean r2) {
        return r0.P(r1, r2);
    }

    static /* synthetic */ l i(h r0) {
        return r0.f13111h;
    }

    static /* synthetic */ Handler j(h r0) {
        return r0.f13107d;
    }

    static /* synthetic */ void k(h r0, BDLocation r1, BDLocationCallback r2) {
        r0.R(r1, r2);
    }

    static /* synthetic */ int l(h r0, LocationOption r1, BDLocation r2) {
        return r0.L(r1, r2);
    }

    static /* synthetic */ ILocate m(h r0) {
        return r0.f13109f;
    }

    static /* synthetic */ ILocate n(h r0, ILocate r1) {
        r0.f13109f = r1;
        return r1;
    }

    static /* synthetic */ d.b.c.d.j o(h r0) {
        return r0.f13105b;
    }

    private boolean t(Object r1) {
        if (r1 != null) goto L4;
        return false;
    L4:
        if (this.f13110g == null) goto L9;
        return true;
    L9:
        return false;
    }

    private LocationOption v(LocationOption r4, BDLocationCallback r5) {
    L10:
        e = move-exception;
        e.printStackTrace();
        c0(e, r5);
        return null;
    L3:
        if (t(r4.getBpeaCert()) == false) goto L8;
        BPEACertCheckResult r0 = this.f13110g.checkAndTranslateCert(r4.getBpeaCert(), r4.getBpeaAction());     // Catch: BDLocationException -> L10
        if (r0 == null) goto L7;
        r4 = W(r0.getParams(), r4);     // Catch: BDLocationException -> L10
    L7:
        r4.setUploadSource(this.f13110g.getBpeaToken(r4.getBpeaCert()));     // Catch: BDLocationException -> L10
    L9:
        return r4;
    L8:
        x(r4.isCert());     // Catch: BDLocationException -> L10
        goto L9
    }

    private void x(boolean r4) {
        if (BDLocationConfig.shouldRequestLocation() == true) goto L8;
        if (r4 == false) goto L7;
        return;
    L7:
        throw b0(BDLocationExceptionMessage.NON_COMPLIANCE_MESSAGE, LocationInfoConst.BDLOCATION, BDLocationException.ERROR_BOOT_NO_CERT_LOCATE, null);
    }

    @WorkerThread
    public BDLocation A(LocationOption r5) {
        CountDownLatch r0 = new CountDownLatch(1);
        BDLocation[] r2 = new BDLocation[1];
        BDLocationException[] r1 = new BDLocationException[1];
        X(new c(this, r2, r0, r1), r5);
        r0.await(r5.getLocationTimeOutMs(), TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L10
        if (r1[0] != null) goto L9;
        return r2[0];
    L9:
        throw r1[0];
    L10:
        e = move-exception;
        throw new BDLocationException(e, LocationInfoConst.SYSTEM, BDLocationException.ERROR_TIMEOUT);
    }

    @Nullable
    @WorkerThread
    public synchronized BdGisResult B(double r3, double r5, int r7, @Nullable Object r8) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (t(r8) == false) goto L6;
        BDLocationExtrasService.getBPEAManager().checkAndTranslateCert(r8, "geocode");     // Catch: Throwable -> L9
    L6:
        new LocationOption().setTriggerType(r7);     // Catch: Throwable -> L9
        BdGisResult r4 = LocationUtil.getGeocodeResult(r3, r5, r7);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r4;
    }

    @Nullable
    @WorkerThread
    public BdGisResult C(double r8, double r10, int r12, boolean r13) {
        x(r13);
        return B(r8, r10, r12, null);
    }

    public LocationCache D() {
        return this.f13104a;
    }

    @WorkerThread
    public BDLocation E(@Nullable Object r2, int r3) {
        if (t(r2) == false) goto L6;
        BDLocationExtrasService.getBPEAManager().checkAndTranslateCert(r2, "getIPLocation");
    L6:
        return LocationUtil.getIPResult(r3);
    }

    @Nullable
    public BDLocation G(int r2, boolean r3, boolean r4) {
        x(r3);
        String r5 = LocationUtil.allowUseLocation(r4);
        if (LocationInfoConst.ALLOW_USE_LOCATION.equals(r5) == false) goto L7;
        return J(r2);
    L7:
        throw b0(BDLocationExceptionMessage.NON_ALLOWED_MESSAGE, LocationInfoConst.BDLOCATION, r5, null);
    }

    @Nullable
    public BDLocation H(Object r2, int r3, boolean r4) {
        if (t(r2) == false) goto L7;
        return I(r2, r4);
    L7:
        return G(r3, true, r4);
    }

    @Nullable
    public BDLocation I(@Nullable Object r3, boolean r4) {
        Logger.i("getLastKnowLocation start");
        String r5 = LocationUtil.allowUseLocation(r4);
        Logger.i("getLastKnowLocation allowLocation");
        BDLocation r1 = null;
        if (LocationInfoConst.ALLOW_USE_LOCATION.equals(r5) == false) goto L17;
        int r6 = -1;
        if (t(r3) == false) goto L15;
        BPEACertCheckResult r7 = BDLocationExtrasService.getBPEAManager().checkAndTranslateCert(r3, "getLastKnowLocation");
        Logger.i("getLastKnowLocation checkAndTranslateCert");
        if (r7 == null) goto L11;
        JSONObject r8 = r7.getParams();
        if (r8 == null) goto L11;
        r6 = r8.optInt("accuracyLevel", 0);
    L11:
        r1 = J(r6);
        if (r1 == null) goto L14;
        r1.setCache(true);
    L14:
        Logger.i("getLastKnowLocation end");
    L15:
        return r1;
    L17:
        throw b0(BDLocationExceptionMessage.NON_ALLOWED_MESSAGE, LocationInfoConst.BDLOCATION, r5, null);
    }

    public void K(Object r12, String r13, boolean r14) {
        long r4 = System.currentTimeMillis();
        long r7 = r4 - BDLocationConfig.getAppBootTime();
        Logger.i("start getLightLocation:" + r4 + "-isColdBoot:" + r14);
        if (BDLocationConfig.enableLightLocation() == true) goto L7;
        Logger.i("getLightLocation unable");
        return;
    L7:
        if (w(null) == true) goto L10;
        Logger.i("getLightLocation checkInit error");
        LocationMonitor.doLightLocationError(BDLocationException.ERROR_INIT_LOCATION, "location checkInit error", r14);
        return;
    L10:
        String r0 = LocationUtil.allowUseLocation(true);
        if (LocationInfoConst.ALLOW_USE_LOCATION.equals(r0) == true) goto L14;
        Logger.i("getLightLocation unable use location allowLocation:" + r0);
        LocationMonitor.doLightLocationError(r0, "unable use location", r14);
        return;
    L14:
        AppExecutors.getInstance().networkIO().execute(new b(this, r12, r13, r4, r14, r7));
    }

    @Nullable
    @VisibleForTesting(otherwise = 2)
    public BDLocation O(LocationOption r5) {
        if (r5.isOnceLocation() == true) goto L7;
        String r4 = "LocationCache MaxCacheTime： " + r5.getMaxCacheTime();
    L5:
        Logger.i(r4);
        return null;
    L7:
        LocationCacheInfo r6 = this.f13104a.getLocationCache();
        if (r6 != null) goto L10;
        r4 = "LocationCache cacheInfo is null";
        goto L5
    L10:
        BDLocation r7 = r6.getLatestLocation();
        if (r7 != null) goto L13;
    L21:
        r4 = "LocationCache cache is null";
        goto L5
    L13:
        if (LocationUtil.isEmpty(r7) == true) goto L21;
        r7.setCache(true);
        StringBuilder r8 = new StringBuilder();
        r8.append("LocationCache: cache is ");
        if (r7 != null) goto L18;
        String r0 = "";
    L19:
        r8.append(r0);
        Logger.i(r8.toString());
        return r7;
    L18:
        r0 = r7.getAddress();
        goto L19
    }

    public void S(LocationNotification r3, int r4) {
        Handler r0 = this.f13106c;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.post(new j(this, r3, r4));
    }

    public void T(LocationSubmitNotification r3) {
        Handler r0 = this.f13106c;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.post(new a(this, r3));
    }

    public void U(Activity r3, @Nullable Object r4, int r5, RequestPermissionUtils.OnPermissionListener r6) {
        if (PermissionManager.canRequestLocationPermission() == true) goto L7;
        r6.onPermissionDenied();
        return;
    L7:
        if (PermissionManager.hasLocationPermissions(BDLocationConfig.getContext()) == false) goto L16;
    L13:
        r6.onPermissionGranted();
        return;
    L16:
        if (t(r4) == false) goto L11;
        BDLocationExtrasService.getBPEAManager().checkAndTranslateCert(r4, "requestLocationPermissionWithCert");     // Catch: Exception -> L15
    L11:
        LocationEvent.onRequestPermission();     // Catch: Exception -> L15
        RequestPermissionUtils.requestPermissionsLimited(r3, M(r5), new g(this, r6));     // Catch: Exception -> L15
    }

    @AnyThread
    public void X(BDLocationCallback r3, LocationOption r4) {
        this.f13106c.post(new d(this, r4, r3));
    }

    public void Y(BDLocationCallback r1, LocationOption r2) {
        X(r1, r2);
    }

    public void Z() {
        a0(false);
    }

    public void a0(boolean r6) {
        ILocate r0 = this.f13109f;
        if (r0 == null) goto L8;
        if (r6 == false) goto L6;
        ((BaseLocate) r0).onLocateError(r0.getLocateName(), new BDLocationException("Timeout.", this.f13109f.getLocateName(), BDLocationException.ERROR_TIMEOUT));
    L6:
        this.f13109f.stopLocation();
        return;
    }

    public void p(LocationNotification r3, int r4) {
        Handler r0 = this.f13106c;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.post(new RunnableC0348h(this, r3, r4));
    }

    public void q(LocationNotification r3, Object r4) {
        Handler r0 = this.f13106c;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.post(new i(this, r3, r4));
    }

    public void r(Object r3, LocationSubmitNotification r4) {
        Handler r0 = this.f13106c;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.post(new k(this, r3, r4));
    }

    public boolean s(LocationOption r5, BDLocationCallback r6) {
        if (w(r6) == true) goto L6;
        Logger.i("Must be called after BDLocation initialization!");
        return false;
    L6:
        String r1 = LocationUtil.allowUseLocation(true);
        if (LocationInfoConst.ALLOW_USE_LOCATION.equals(r1) == true) goto L10;
        Logger.i("checkAbleLocation is not allowed,error code is:" + r1);
        Q(r6, new BDLocationException(BDLocationExceptionMessage.NON_ALLOWED_MESSAGE, LocationInfoConst.BDLOCATION, r1));
        return false;
    L10:
        return true;
    }

    public boolean u(BDLocation r5, LocationOption r6) {
        if (r5 != null) goto L8;
        String r7 = "LocationCache IS NULL";
    L5:
        Logger.i(r7);
        return false;
    L8:
        if (r6.getGeocodeMode() == 0) goto L13;
        if (r5.hasAddress() == true) goto L13;
        r7 = "LocationCache NO_GEOCODE";
    L13:
        if (LocationUtil.checkCacheTime(r5.getLocationMs(), r6.getMaxCacheTime(), TextUtils.isEmpty(r6.getExtra())) == true) goto L15;
        r7 = "LocationCache checkCacheTime is false";
        goto L5
    L15:
        return true;
    }

    public boolean w(BDLocationCallback r5) {
        if (BDLocationConfig.checkInit() == false) goto L6;
        return true;
    L6:
        Logger.i("Must be called after BDLocation initialization!");
        if (r5 == null) goto L11;
        Q(r5, new BDLocationException(BDLocationExceptionMessage.NOT_INITIALIZATION, LocationInfoConst.BDLOCATION, BDLocationException.ERROR_INIT_LOCATION));
        return false;
    L11:
        return false;
    }

    public boolean y(BDLocation r3, LocationOption r4) {
        if (r3 != null) goto L8;
        String r5 = "LocationCache IS NULL";
    L5:
        Logger.i(r5);
        return false;
    L8:
        if (r4.getGeocodeMode() == 0) goto L13;
        if (r3.hasAddress() == true) goto L13;
        r5 = "LocationCache NO_GEOCODE";
    L13:
        if (LocationUtil.checkCacheTime(r3.getLocationMs(), BDLocationConfig.getOverseasGetLocationFailedUseCacheValidity()) == true) goto L15;
        r5 = "LocationCache checkCacheTime is false";
        goto L5
    L15:
        return true;
    }

    @Nullable
    @WorkerThread
    public BDPoint z(@NonNull BDPoint r1) {
        return LocationUtil.convertGCJ02(r1);
    }
}
