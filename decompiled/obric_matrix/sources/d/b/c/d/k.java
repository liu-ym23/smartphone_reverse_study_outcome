package d.b.c.d;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.callback.LocationUploadCallback;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.network.model.LocationUploadExtra;
import com.bytedance.bdlocation.network.response.LocInfoRspData;
import com.bytedance.bdlocation.network.response.LocationResp;
import com.bytedance.bdlocation.scan.networklistener.NetworkManager;
import com.bytedance.bdlocation.store.LocationCache;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class k implements BDLocationCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BDLocationCallback f13157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h.l f13158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LocationOption f13159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Handler f13160d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f13161e;

    class a implements LocationUploadCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f13162a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BDLocation f13163b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f13164c;

        a(k r1, long r2, BDLocation r4) {
            this.f13164c = r1;
            this.f13162a = r2;
            this.f13163b = r4;
        }

        @Override // com.bytedance.bdlocation.callback.LocationUploadCallback
        public void onError(String r5) {
            Logger.i("LocationCallbackServer upload interval:" + (System.currentTimeMillis() - this.f13162a));
            k.a(this.f13164c, this.f13163b, false);
        }

        @Override // com.bytedance.bdlocation.callback.LocationUploadCallback
        public void onSuccess(LocationResp r6) {
            Logger.i("LocationCallbackServer upload intervalTime:" + (System.currentTimeMillis() - this.f13162a));
            LocInfoRspData r7 = LocationUtil.parseLocInfoRsp(r6);
            if (r7 == null) goto L5;
            BDLocation r0 = LocationUtil.locationResultToBDLocation(this.f13163b, r7.location);
        L6:
            k r1 = this.f13164c;
            if (r0 != null) goto L9;
            BDLocation r2 = this.f13163b;
        L10:
            k.a(r1, r2, false);
            d.b.c.c.a.b(r7, r0, k.b(this.f13164c));
            return;
        L9:
            r2 = r0;
            goto L10
        L5:
            r0 = null;
            goto L6
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f13165f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ BDLocation f13166g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ k f13167h;

        b(k r1, boolean r2, BDLocation r3) {
            this.f13167h = r1;
            this.f13165f = r2;
            this.f13166g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (k.b(this.f13167h).isOnceLocation() == true) goto L5;
        L20:
            k.e(this.f13167h).onLocationChanged(this.f13166g);
        L21:
            k.d(this.f13167h, this.f13166g);
            return;
        L5:
            if (this.f13165f == true) goto L20;
            if (k.c(this.f13167h).e(k.b(this.f13167h)) == false) goto L20;
            Logger.i("LocationCallbackServer callbackLocationInfo mergeLocation");
            k.c(this.f13167h).onLocateStop("");
            List<BDLocationCallback> r0 = k.c(this.f13167h).c();
            if (r0 == null) goto L20;
            if (r0.size() <= 0) goto L20;
            int r1 = 0;
        L14:
            if (r1 >= r0.size()) goto L19;
            BDLocationCallback r2 = r0.get(r1);
            if (r2 == null) goto L18;
            r2.onLocationChanged(this.f13166g);
        L18:
            r1 = r1 + 1;
            goto L14
        L19:
            k.c(this.f13167h).b();
            goto L21
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ BDLocationException f13168f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ k f13169g;

        c(k r1, BDLocationException r2) {
            this.f13169g = r1;
            this.f13168f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (k.b(this.f13169g).isOnceLocation() == true) goto L5;
        L18:
            k.e(this.f13169g).onError(this.f13168f);
        L19:
            k.f(this.f13169g, this.f13168f);
            return;
        L5:
            if (k.c(this.f13169g).e(k.b(this.f13169g)) == false) goto L18;
            Logger.i("LocationCallbackServer mergeLocation onError");
            k.c(this.f13169g).onLocateStop("");
            List<BDLocationCallback> r0 = k.c(this.f13169g).c();
            if (r0 == null) goto L18;
            if (r0.size() <= 0) goto L18;
            int r1 = 0;
        L12:
            if (r1 >= r0.size()) goto L17;
            BDLocationCallback r2 = r0.get(r1);
            if (r2 == null) goto L16;
            r2.onError(this.f13168f);
        L16:
            r1 = r1 + 1;
            goto L12
        L17:
            k.c(this.f13169g).b();
            goto L19
        }
    }

    public k(BDLocationCallback r1, LocationOption r2, h.l r3, Handler r4) {
        this.f13157a = r1;
        this.f13158b = r3;
        this.f13159c = r2;
        this.f13160d = r4;
        this.f13161e = SystemClock.elapsedRealtime();
    }

    static /* synthetic */ void a(k r0, BDLocation r1, boolean r2) {
        r0.g(r1, r2);
    }

    static /* synthetic */ LocationOption b(k r0) {
        return r0.f13159c;
    }

    static /* synthetic */ h.l c(k r0) {
        return r0.f13158b;
    }

    static /* synthetic */ void d(k r0, BDLocation r1) {
        r0.k(r1);
    }

    static /* synthetic */ BDLocationCallback e(k r0) {
        return r0.f13157a;
    }

    static /* synthetic */ void f(k r0, BDLocationException r1) {
        r0.j(r1);
    }

    private void g(BDLocation r3, boolean r4) {
        n(r3);
        l(r3);
        BDLocation r5 = LocationUtil.transformLocationForLevel(r3, this.f13159c.getAccuracyLevel());
        if (this.f13160d != null) goto L5;
        this.f13160d = new Handler(Looper.getMainLooper());
    L5:
        this.f13160d.post(new b(this, r4, r5));
    }

    private void h() {
        Logger.i("LocationCallbackServer decideDownGradeLocation locateType:" + this.f13159c.getLocateType());
        this.f13159c.setLocateType(0);
        this.f13159c.setDownGradeLocation(true);
        this.f13158b.onLocateStop("");
        h.F().Y(this.f13157a, new LocationOption(this.f13159c));
    }

    private void i(BDLocation r3, LocationOption r4, LocationUploadCallback r5) {
        LocationUploadExtra r2 = new LocationUploadExtra();
        r2.setUploadInterval(r4.getUploadInterval());
        if (BDLocationConfig.isMockEnable() == false) goto L5;
        String r0 = "mock";
    L6:
        r2.setUploadSource(r0);
        r2.setTriggerType(r4.getTriggerType());
        r2.setLatestAdminVersion(r4.isLatestAdminVersion());
        r2.setBpeaCert(r4.getBpeaCert());
        r2.setStartLocationTime(r4.getStartLocationTime());
        if (r4.getLocationExtraBean() == null) goto L9;
        r2.setLogIdCache(r4.getLocationExtraBean().getLogIdCacheEntity());
        r2.setBleList(r4.getLocationExtraBean().getBleInfoList());
    L9:
        r2.setExtra(r4.getExtra());
        LocationUtil.startLocateUpload(r3, r2, r5);
        return;
    L5:
        r0 = r4.getUploadSource();
        goto L6
    }

    private void j(BDLocationException r5) {
        if (this.f13159c.isOnceLocation() == false) goto L6;
        LocationMonitor.doDesiredLocationFail(SystemClock.elapsedRealtime() - this.f13161e, r5, this.f13159c);
        Logger.i("locationmonitor location total duration is: " + (SystemClock.elapsedRealtime() - this.f13161e) + "ms");
        return;
    }

    private void k(BDLocation r5) {
        if (this.f13159c.isOnceLocation() == false) goto L6;
        LocationMonitor.doDesiredLocationSuccess(SystemClock.elapsedRealtime() - this.f13161e, r5, this.f13159c);
        Logger.i("locationmonitor location total duration is: " + (SystemClock.elapsedRealtime() - this.f13161e) + "ms");
        return;
    }

    private void l(BDLocation r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.getLocationType() != 6) goto L10;
        String r2 = "IP location";
    L7:
        Logger.i(r2);
        return;
    L10:
        if (r3.isMock() == false) goto L12;
        r2 = "mock location";
        goto L7
    L12:
        Logger.i("CheckNewLocation new location time:" + r3.getTime());
        BDLocation r4 = LocationCache.getInstance().getLocationCache().getLatestLocation();
        Logger.i("LocationCallbackServer executeLocationCache isUseNewCacheStrategy: " + BDLocationConfig.isUseNewCacheStrategy());
        if (LocationUtil.isBetterLocation(r3, r4) == true) goto L17;
        if (LocationUtil.isGoodLocation(r3) == true) goto L17;
        return;
    L17:
        if (BDLocationConfig.isRestrictedModeOn() == true) goto L21;
        Logger.i("CheckNewLocation executeLocationCache");
        LocationCache.getInstance().executeLocationCache(r3);
        return;
    }

    private void m(boolean r5) {
        if (BDLocationConfig.isFirstLocation() == true) goto L5;
        return;
    L5:
        LocationMonitor.doFirstLocationDuration(SystemClock.elapsedRealtime() - BDLocationConfig.getInitStartTime(), r5);
        Logger.i("locationmonitor first location duration is: " + (SystemClock.elapsedRealtime() - BDLocationConfig.getInitStartTime()) + "ms");
        BDLocationConfig.setFirstLocation(false);
    }

    private synchronized void n(BDLocation r7) {
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L4:
        if (d.b.c.a.a.b().d() == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        if (r7 != null) goto L9;
    L22:
        monitor-exit(this);
        return;
    L9:
        if (BDLocationConfig.isUpload() == false) goto L22;
        if (BDLocationConfig.isPollingUpload() == false) goto L22;
        Logger.d("register UploadScheduleController isCache：" + r7.isCache());     // Catch: Throwable -> L24
        if (BDLocationConfig.isNewNetworkChangeRegister() == false) goto L15;
        NetworkManager.getInstance().registerObserver(BDLocationConfig.getContext());     // Catch: Throwable -> L24
    L15:
        long r0 = BDLocationConfig.getUploadInterval();     // Catch: Throwable -> L24
        if (r7.isCache() == false) goto L21;
        r0 = BDLocationConfig.getUploadInterval() - (System.currentTimeMillis() - r7.getLocationMs());     // Catch: Throwable -> L24
        if (r0 > 0) goto L20;
        r0 = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
    L20:
        Logger.d("register UploadScheduleController interval:" + r0 + "--cacheTime:" + r7.getLocationMs());     // Catch: Throwable -> L24
    L21:
        d.b.c.a.a.b().e(r0);     // Catch: Throwable -> L24
        goto L22
    }

    private void o(BDLocation r5) {
        long r0 = System.currentTimeMillis();
        i(r5, this.f13159c, new a(this, r0, r5));
    }

    @Override // com.bytedance.bdlocation.callback.BDLocationCallback
    public void onError(@Nullable BDLocationException r4) {
        Logger.i("LocationCallbackServer onError");
        if (this.f13159c.isOnceLocation() == false) goto L11;
        if (this.f13159c.getLocateType() == 0) goto L11;
        if (this.f13159c.isDownGradeLocation() == true) goto L11;
        h();
        return;
    L11:
        if (this.f13159c.isChineseRegion() == true) goto L19;
        if (this.f13159c.getLocateType() != 0) goto L19;
        Logger.i("overseas getLocation error and use cache");
        BDLocation r0 = h.F().O(this.f13159c);
        boolean r1 = h.F().y(r0, this.f13159c);
        LocationMonitor.overseasLocationFailedGetCache(r1);
        if (r1 == false) goto L19;
        g(r0, true);
        return;
    L19:
        if (this.f13160d != null) goto L21;
        this.f13160d = new Handler(Looper.getMainLooper());
    L21:
        this.f13160d.post(new c(this, r4));
    }

    @Override // com.bytedance.bdlocation.callback.BDLocationCallback
    public void onLocationChanged(@Nullable BDLocation r4) {
        if (LocationUtil.isEmpty(r4) == true) goto L5;
        m(r4.isCache());
        if (r4.isCache() == false) goto L18;
        g(r4, true);
        return;
    L18:
        BDLocation r5 = LocationUtil.convertLocation(r4);
        if (this.f13159c.isUpload() == false) goto L24;
        if (LocationUtil.needUpload(r5) == false) goto L24;
        o(r5);
        return;
    L24:
        if (r5.getLocInfoRsp() == null) goto L26;
        d.b.c.c.a.b(new LocInfoRspData(r5.getLocInfoRsp()), r5, this.f13159c);
        r5.setLocInfoRsp(null);
    L26:
        g(r5, false);
        return;
    L5:
        if (this.f13159c.isOnceLocation() == true) goto L7;
    L12:
        onError(new BDLocationException("location callback null!", "UNKnown", BDLocationException.ERROR_LOCATION_IS_NULL));
        return;
    L7:
        if (this.f13159c.getLocateType() == 0) goto L12;
        if (this.f13159c.isDownGradeLocation() == true) goto L12;
        h();
    }
}
