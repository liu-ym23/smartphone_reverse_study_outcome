package d.b.c.d;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.entity.LocationExtraBean;
import com.bytedance.bdlocation.entity.LogIdCacheEntity;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.network.model.LocationUploadExtra;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.scan.bluetooth.BDBleInfo;
import com.bytedance.bdlocation.scan.bluetooth.BLECacheEntity;
import com.bytedance.bdlocation.scan.bluetooth.BluetoothInfoManager;
import com.bytedance.bdlocation.scan.bluetooth.BluetoothUtil;
import com.bytedance.bdlocation.scan.gps.BDGpsInfo;
import com.bytedance.bdlocation.scan.gps.GpsCollectCallback;
import com.bytedance.bdlocation.scan.gps.GpsInfoManager;
import com.bytedance.bdlocation.utils.CollectionUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static g f13093f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BluetoothInfoManager f13094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile int f13095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile int f13096c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile BDGpsInfo f13097d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile List<BDBleInfo> f13098e;

    class a implements GpsCollectCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LocationOption f13099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f13100b;

        a(g r1, LocationOption r2) {
            this.f13100b = r1;
            this.f13099a = r2;
        }

        @Override // com.bytedance.bdlocation.scan.gps.GpsCollectCallback
        public void onFail(int r2) {
            g.a(this.f13100b, r2);
            g.c(this.f13100b, this.f13099a);
        }

        @Override // com.bytedance.bdlocation.scan.gps.GpsCollectCallback
        public void onSuccess(BDGpsInfo r3) {
            g.a(this.f13100b, 3);
            g.b(this.f13100b, r3);
            g.c(this.f13100b, this.f13099a);
        }
    }

    private class b implements BluetoothInfoManager.BluetoothScanCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private LocationOption f13101a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f13102b;

        public b(g r1, LocationOption r2) {
            this.f13102b = r1;
            this.f13101a = r2;
        }

        @Override // com.bytedance.bdlocation.scan.bluetooth.BluetoothInfoManager.BluetoothScanCallback
        public void onError() {
            Logger.i("BDLocationExtraDataServer:scanBlueToothData error");
            g.f(this.f13102b, 2);
            g.c(this.f13102b, this.f13101a);
        }

        @Override // com.bytedance.bdlocation.scan.bluetooth.BluetoothInfoManager.BluetoothScanCallback
        public void onScan(BDBleInfo r1) {
        }

        @Override // com.bytedance.bdlocation.scan.bluetooth.BluetoothInfoManager.BluetoothScanCallback
        public void onSuccess(List<BDBleInfo> r4) {
            Logger.i("BDLocationExtraDataServer:scanBlueToothData success");
            List r5 = g.d(this.f13102b, r4);
            if (BDLocationConfig.isUploadBleImmediately() == false) goto L6;
            g.e(this.f13102b, r5, this.f13101a);
            return;
        L6:
            g.f(this.f13102b, 2);
            g.c(this.f13102b, this.f13101a);
            g.g(this.f13102b, r5, this.f13101a.getStartLocationTime());
        }
    }

    public g() {
        this.f13095b = 0;
        this.f13096c = 0;
        this.f13094a = new BluetoothInfoManager(BDLocationConfig.getContext());
    }

    static /* synthetic */ int a(g r0, int r1) {
        r0.f13095b = r1;
        return r1;
    }

    static /* synthetic */ BDGpsInfo b(g r0, BDGpsInfo r1) {
        r0.f13097d = r1;
        return r1;
    }

    static /* synthetic */ void c(g r0, LocationOption r1) {
        r0.t(r1);
    }

    static /* synthetic */ List d(g r0, List r1) {
        return r0.l(r1);
    }

    static /* synthetic */ void e(g r0, List r1, LocationOption r2) {
        r0.s(r1, r2);
    }

    static /* synthetic */ int f(g r0, int r1) {
        r0.f13096c = r1;
        return r1;
    }

    static /* synthetic */ void g(g r0, List r1, long r2) {
        r0.n(r1, r2);
    }

    private void i(LocationOption r3) {
        this.f13095b = 0;
        this.f13096c = 0;
        this.f13097d = null;
        this.f13098e = null;
        GpsInfoManager.getInstance().startGpsCollect(new a(this, r3), r3.getBpeaCert());
    }

    public static g k() {
        if (f13093f != null) goto L15;
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f13093f != null) goto L9;
        f13093f = new g();     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L15:
        return f13093f;
    }

    private List<BDBleInfo> l(List<BDBleInfo> r6) {
        if (r6 != null) goto L4;
    L22:
        Logger.i("BDLocationExtraDataServer:getNewBleInfos bleInfos is null");
        return null;
    L4:
        if (r6.size() < 1) goto L22;
        List<String> r5 = BDLocationConfig.getDisableUuidList();
        if (r5 != null) goto L9;
    L20:
        Logger.i("BDLocationExtraDataServer:getNewBleInfos disableUuidList is null");
        return new ArrayList(r6);
    L9:
        if (r5.size() <= 0) goto L20;
        Logger.i("BDLocationExtraDataServer:getNewBleInfos disableUuidList is not null");
        ArrayList r0 = new ArrayList();
        long r1 = System.currentTimeMillis();
        Iterator<BDBleInfo> r7 = r6.iterator();
    L12:
        if (r7.hasNext() == false) goto L19;
        BDBleInfo r3 = r7.next();
        if (r3.isBeacon == false) goto L18;
        if (CollectionUtil.containsIgnoreCase(r5, r3.beaconUuid) == false) goto L18;
        Logger.i("BDLocationExtraDataServer:getNewBleInfos and ignore the beacon");
    L18:
        r0.add(r3);
        goto L12
    L19:
        Logger.i("BDLocationExtraDataServer:", "getNewBleInfos and filter beacon duration(ms) is " + (System.currentTimeMillis() - r1));
        return r0;
    }

    private void m(long r10, long r12, LocationOption r14) {
        Logger.i("BDLocationExtraDataServer:scanBlueToothData");
        if (LocationUtil.getTargetSdkVersion() >= 31) goto L5;
    L10:
        Logger.i(BluetoothUtil.BLE_SCAN_TRACE, "scanBlueToothData run:");
        this.f13094a.startScan(new b(this, r14), r10, r12, r14.getBpeaCert());
        return;
    L5:
        if (Build.VERSION.SDK_INT < 31) goto L10;
        if (PermissionManager.hasBluetoothPermissions(BDLocationConfig.getContext()) == true) goto L10;
        Logger.i("BDLocationExtraDataServer: scanBlueToothData and has no permission");
        this.f13096c = 1;
        t(r14);
    }

    private void n(List<BDBleInfo> r3, long r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.size() < 1) goto L12;
        Logger.i("BDLocationExtraDataServer:setBleCacheEntity size:" + r3.size());
        Collections.sort(r3);
        if (r3.size() <= BDLocationConfig.getUploadBleNum()) goto L9;
        r3 = r3.subList(0, BDLocationConfig.getUploadBleNum());
    L9:
        BLECacheEntity r2 = new BLECacheEntity();
        r2.setBleInfoList(r3);
        r2.setTimeStamp(r4);
        Logger.i("BDLocationExtraDataServer:setBleCacheEntity size:" + r3.size() + "--startLocationTime：" + r4);
        BDLocationConfig.setBleCacheEntity(r2);
        return;
    }

    private void o(LocationOption r4) {
        Logger.i("BDLocationExtraDataServer:setExtraData startLocationTime:" + r4.getStartLocationTime());
        LocationExtraBean r0 = new LocationExtraBean();
        r0.setBleInfoList(j());
        r0.setLogIdCacheEntity(BDLocationConfig.getLogIdCacheEntity());
        r4.setLocationExtraBean(r0);
    }

    private void s(List<BDBleInfo> r4, LocationOption r5) {
        if (r5 != null) goto L8;
        String r6 = "BDLocationExtraDataServer:uploadBleCacheEntity option is null";
    L5:
        Logger.i(r6);
        this.f13096c = 2;
    L6:
        t(r5);
        return;
    L8:
        if (r4 != null) goto L10;
    L16:
        r6 = "BDLocationExtraDataServer:uploadBleCacheEntity bleInfos is null";
        goto L5
    L10:
        if (r4.size() < 1) goto L16;
        Logger.i("BDLocationExtraDataServer:setBleCacheEntity size:" + r4.size());
        Collections.sort(r4);
        if (r4.size() <= BDLocationConfig.getUploadBleNum()) goto L15;
        r4 = r4.subList(0, BDLocationConfig.getUploadBleNum());
    L15:
        this.f13096c = 3;
        this.f13098e = r4;
        goto L6
    }

    private void t(LocationOption r9) {
        Logger.i("BDLocationExtraDataServer: uploadGpsAndBleInfos and mGpsInfoStatus:" + this.f13095b + ", mBleInfoListStatus:" + this.f13096c);
        if (BDLocationConfig.isEnableGpsScan() == false) goto L7;
        if (this.f13095b != 0) goto L7;
        return;
    L7:
        if (this.f13096c == 0) goto L42;
        StringBuilder r0 = new StringBuilder();
        r0.append("BDLocationExtraDataServer: uploadGpsAndBleInfos and gpsinfo:");
        if (this.f13097d == null) goto L11;
        boolean r1 = true;
    L12:
        r0.append(r1);
        r0.append(", bleinfos:");
        if (this.f13098e == null) goto L15;
        boolean r2 = true;
    L16:
        r0.append(r2);
        Logger.i(r0.toString());
        if (this.f13097d == null) goto L19;
    L22:
        LocationUploadExtra r3 = new LocationUploadExtra();
        LogIdCacheEntity r4 = BDLocationConfig.getLogIdCacheEntity();
        if (r4 != null) goto L25;
    L39:
        this.f13095b = 0;
        this.f13096c = 0;
        return;
    L25:
        if (r4.timestamp != r9.getStartLocationTime()) goto L39;
        if (TextUtils.isEmpty(r4.logId) == true) goto L39;
        Logger.i("BDLocationExtraDataServer: uploadGpsAndBleInfos and gpsCacheEntity != null");
        r3.setLogIdCache(r4);
        r3.setGpsInfo(this.f13097d);
        r3.setBleList(this.f13098e);
        if (this.f13095b != 0) goto L31;
    L37:
        String r5 = "ble";
    L38:
        r3.setGpsAndBleMark(r5);
        r3.setTriggerType(r9.getTriggerType());
        r3.setUploadSource(r9.getUploadSource());
        LocationUtil.uploadGpsAndBleInfos(r3);
        goto L39
    L31:
        if (this.f13095b == 1) goto L37;
        if (this.f13096c == 3) goto L36;
        r5 = "gps";
        goto L38
    L36:
        r5 = "ble_gps";
        goto L38
    L19:
        if (this.f13098e != null) goto L22;
        this.f13095b = 0;
        this.f13096c = 0;
        return;
    L15:
        r2 = false;
        goto L16
    L11:
        r1 = false;
        goto L12
    }

    public void h() {
        Logger.i("BDLocationExtraDataServer:clearExtraData");
        BDLocationConfig.setBleCacheEntity(null);
        BDLocationConfig.setLogIdCacheEntity(null);
    }

    @Nullable
    public List<BDBleInfo> j() {
        LogIdCacheEntity r6 = BDLocationConfig.getLogIdCacheEntity();
        if (r6 != null) goto L7;
        String r7 = "BDLocationExtraDataServer:getLogIdCache cache is null";
    L5:
        Logger.i(r7);
        return null;
    L7:
        BLECacheEntity r1 = BDLocationConfig.getBleCacheEntity();
        if (r1 != null) goto L10;
    L15:
        r7 = "BDLocationExtraDataServer:getBleEntryList error";
        goto L5
    L10:
        if (r1.getTimeStamp() != r6.timestamp) goto L15;
        if (TextUtils.isEmpty(r6.logId) == true) goto L15;
        Logger.i("BDLocationExtraDataServer:getBleEntryList success");
        return r1.getBleInfoList();
    }

    public void p(LocationOption r9) {
        this.f13096c = 0;
        this.f13098e = null;
        if (r9 != null) goto L5;
    L24:
        Logger.i("BDLocationExtraDataServer:startCollectBluetoothData option is null");
        this.f13096c = 1;
        t(r9);
        return;
    L5:
        if (r9.isOnceLocation() == false) goto L24;
        if (r9.scanBle() == false) goto L24;
        if (BDLocationConfig.isUploadBleImmediately() == true) goto L16;
        if (BDLocationConfig.firstRequestLocation() == false) goto L16;
        Logger.i("BDLocationExtraDataServer:startCollectBluetoothData firstRequestLocation");
        this.f13096c = 1;
        t(r9);
        return;
    L16:
        if (BDLocationConfig.enableScanBle() == true) goto L18;
    L22:
        Logger.i("BDLocationExtraDataServer:startCollectBluetoothData not enable scan ble");
        this.f13096c = 1;
        t(r9);
        return;
    L18:
        if (BDLocationConfig.getScanBleInterval() <= 0) goto L22;
        m(0, BDLocationConfig.getScanBleInterval(), r9);
    }

    public void q(LocationOption r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.isOnceLocation() == false) goto L9;
        long r0 = System.currentTimeMillis();
        r5.setStartLocationTime(r0);
        Logger.i("BDLocationExtraDataServer:startCollectGpsData");
        o(r5);
        h();
        i(r5);
        Logger.i("startCollectGpsData duration:" + (System.currentTimeMillis() - r0));
        return;
    }

    public void r() {
        BluetoothInfoManager r0 = this.f13094a;
        if (r0 == null) goto L5;
        r0.stopScan();
    L5:
        GpsInfoManager.getInstance().stopGpsCollect();
    }
}
