package d.b.c.d;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.api.ILocationH3Core;
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
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.store.LocationCache;
import com.bytedance.bdlocation.utils.EncryptUtil;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class l implements BDLocationCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BDLocationCallback f13170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h.l f13171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LocationOption f13172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ILocationH3Core f13173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f13174e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f13175f;

    class a implements LocationUploadCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f13176a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BDLocation f13177b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ l f13178c;

        a(l r1, long r2, BDLocation r4) {
            this.f13178c = r1;
            this.f13176a = r2;
            this.f13177b = r4;
        }

        @Override // com.bytedance.bdlocation.callback.LocationUploadCallback
        public void onError(String r5) {
            Logger.i("LocationCallbackServer upload interval:" + (System.currentTimeMillis() - this.f13176a));
            l.b(this.f13178c, this.f13177b, false);
        }

        @Override // com.bytedance.bdlocation.callback.LocationUploadCallback
        public void onSuccess(LocationResp r6) {
            Logger.d("BDRegionLocation Upload success:", r6 + "---uploadSource:" + l.a(this.f13178c).getUploadSource());
            StringBuilder r0 = new StringBuilder();
            r0.append("LocationCallbackServer upload intervalTime:");
            r0.append(System.currentTimeMillis() - this.f13176a);
            Logger.i(r0.toString());
            LocInfoRspData r7 = LocationUtil.parseLocInfoRsp(r6);
            if (r7 == null) goto L5;
            d.b.c.c.a.c(l.a(this.f13178c).getUploadSource());
            BDLocation r8 = LocationUtil.locationResultToBDLocation(this.f13177b, r7.location);
        L6:
            l r1 = this.f13178c;
            if (r8 != null) goto L9;
            r8 = this.f13177b;
        L9:
            l.b(r1, r8, false);
            return;
        L5:
            r8 = null;
            goto L6
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f13179f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ BDLocation f13180g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ l f13181h;

        b(l r1, boolean r2, BDLocation r3) {
            this.f13181h = r1;
            this.f13179f = r2;
            this.f13180g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.a(this.f13181h).isOnceLocation() == true) goto L5;
        L21:
            BDLocationCallback r0 = l.e(this.f13181h);
            BDLocation r1 = LocationUtil.transformLocationForLevel(this.f13180g, l.a(this.f13181h).getAccuracyLevel());
        L22:
            r0.onLocationChanged(r1);
            l.d(this.f13181h, this.f13180g);
            return;
        L5:
            if (this.f13179f == true) goto L21;
            if (l.c(this.f13181h).e(l.a(this.f13181h)) == false) goto L21;
            l.c(this.f13181h).onLocateStop("");
            List<BDLocationCallback> r2 = l.c(this.f13181h).c();
            if (r2 != null) goto L11;
        L20:
            r0 = l.e(this.f13181h);
            r1 = this.f13180g;
            goto L22
        L11:
            if (r2.size() <= 0) goto L20;
            int r3 = 0;
        L14:
            if (r3 >= r2.size()) goto L19;
            BDLocationCallback r4 = r2.get(r3);
            if (r4 == null) goto L18;
            r4.onLocationChanged(this.f13180g);
            l.d(this.f13181h, this.f13180g);
        L18:
            r3 = r3 + 1;
            goto L14
        L19:
            l.c(this.f13181h).b();
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ BDLocationException f13182f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ l f13183g;

        c(l r1, BDLocationException r2) {
            this.f13183g = r1;
            this.f13182f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.a(this.f13183g).isOnceLocation() == true) goto L5;
        L18:
            l.e(this.f13183g).onError(this.f13182f);
            l.f(this.f13183g, this.f13182f);
            return;
        L5:
            if (l.c(this.f13183g).e(l.a(this.f13183g)) == false) goto L18;
            l.c(this.f13183g).onLocateStop("");
            List<BDLocationCallback> r0 = l.c(this.f13183g).c();
            if (r0 == null) goto L18;
            if (r0.size() <= 0) goto L18;
            int r1 = 0;
        L12:
            if (r1 >= r0.size()) goto L17;
            BDLocationCallback r2 = r0.get(r1);
            if (r2 == null) goto L16;
            r2.onError(this.f13182f);
            l.f(this.f13183g, this.f13182f);
        L16:
            r1 = r1 + 1;
            goto L12
        L17:
            l.c(this.f13183g).b();
        }
    }

    public l(BDLocationCallback r1, LocationOption r2, h.l r3, Handler r4) {
        this.f13170a = r1;
        this.f13171b = r3;
        this.f13172c = r2;
        this.f13173d = BDLocationExtrasService.getLocationH3Core();
        this.f13174e = r4;
        this.f13175f = SystemClock.elapsedRealtime();
    }

    static /* synthetic */ LocationOption a(l r0) {
        return r0.f13172c;
    }

    static /* synthetic */ void b(l r0, BDLocation r1, boolean r2) {
        r0.h(r1, r2);
    }

    static /* synthetic */ h.l c(l r0) {
        return r0.f13171b;
    }

    static /* synthetic */ void d(l r0, BDLocation r1) {
        r0.k(r1);
    }

    static /* synthetic */ BDLocationCallback e(l r0) {
        return r0.f13170a;
    }

    static /* synthetic */ void f(l r0, BDLocationException r1) {
        r0.j(r1);
    }

    private void g(double r2, double r4) {
        JSONObject r1 = new JSONObject();
        JsonUtil.safePutDouble(r1, "latitude", r2);
        JsonUtil.safePutDouble(r1, "longitude", r4);
        h.F().D().setPreciseLatLng(EncryptUtil.encrypt(r1));
    }

    private void h(BDLocation r3, boolean r4) {
        l(r3);
        BDLocation r5 = LocationUtil.transformLocationForLevel(r3, this.f13172c.getAccuracyLevel());
        if (this.f13174e != null) goto L5;
        this.f13174e = new Handler(Looper.getMainLooper());
    L5:
        this.f13174e.post(new b(this, r4, r5));
    }

    private void i(BDLocation r2, LocationOption r3, LocationUploadCallback r4) {
        LocationUploadExtra r1 = new LocationUploadExtra();
        r1.setUploadSource(r3.getUploadSource());
        r1.setLatestAdminVersion(r3.isLatestAdminVersion());
        r1.setBpeaCert(r3.getBpeaCert());
        LocationUtil.startLocateUpload(r2, r1, r4);
    }

    private void j(BDLocationException r5) {
        if (this.f13172c.isOnceLocation() == false) goto L6;
        LocationMonitor.doDesiredLocationFail(SystemClock.elapsedRealtime() - this.f13175f, r5, this.f13172c);
        return;
    }

    private void k(BDLocation r5) {
        if (this.f13172c.isOnceLocation() == false) goto L6;
        LocationMonitor.doDesiredLocationSuccess(SystemClock.elapsedRealtime() - this.f13175f, r5, this.f13172c);
        return;
    }

    private void l(BDLocation r1) {
        if (r1 != null) goto L5;
        return;
    L5:
        if (LocationUtil.isBetterLocation(r1, LocationCache.getInstance().getLocationCache().getLatestLocation()) == true) goto L9;
        if (LocationUtil.isGoodLocation(r1) == true) goto L9;
        return;
    L9:
        if (BDLocationConfig.isRestrictedModeOn() == true) goto L13;
        LocationCache.getInstance().executeLocationCache(r1);
        return;
    }

    private void m(BDLocation r5) {
        long r0 = System.currentTimeMillis();
        i(r5, this.f13172c, new a(this, r0, r5));
    }

    @Override // com.bytedance.bdlocation.callback.BDLocationCallback
    public void onError(@Nullable BDLocationException r3) {
        if (this.f13174e != null) goto L5;
        this.f13174e = new Handler(Looper.getMainLooper());
    L5:
        this.f13174e.post(new c(this, r3));
    }

    @Override // com.bytedance.bdlocation.callback.BDLocationCallback
    public void onLocationChanged(@Nullable BDLocation r5) {
        if (LocationUtil.isEmpty(r5) == false) goto L7;
        onError(new BDLocationException("location callback null!", "UNKnown", BDLocationException.ERROR_LOCATION_IS_NULL));
        return;
    L7:
        if (r5.isCache() == false) goto L10;
        h(r5, true);
        return;
    L10:
        g(r5.getLatitude(), r5.getLongitude());
        BDLocation r6 = LocationUtil.blurredLocation(this.f13173d, r5);
        if (this.f13172c.isUpload() == true) goto L13;
        h(r6, false);
        return;
    L13:
        if (LocationUtil.needUpload(r6) == false) goto L17;
        m(new BDLocation(r6));
        return;
    }
}
