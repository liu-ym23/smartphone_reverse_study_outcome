package com.bytedance.bdlocation.init;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.LocationNotification;
import com.bytedance.bdlocation.callback.LocationSubmitNotification;
import com.bytedance.bdlocation.callback.RegionUploadCallback;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.BDPoint;
import com.bytedance.bdlocation.entity.gis.BdGisResult;
import com.bytedance.bdlocation.entity.region.RegionBean;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorUtil;
import com.bytedance.bdlocation.permission.request.RequestPermissionUtils;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.settings.LocationSettingUtil;
import d.b.c.d.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BDLocationHelper {
    private static BDLocationHelper sInstance;
    private volatile boolean sIsRegister;

    public BDLocationHelper() {
    }

    public static void addNotification(LocationNotification r1, int r2) {
        h.F().p(r1, r2);
    }

    public static void addNotification(LocationNotification r1, Object r2) {
        h.F().q(r1, r2);
    }

    public static void addSubmitNotification(Object r1, LocationSubmitNotification r2) {
        if (r2 != null) goto L9;
        return;
    L9:
        LocationUtil.checkBpeaCertNull("addSubmitNotification", r1);     // Catch: BDLocationException -> L7
        h.F().r(r1, r2);
        return;
    L7:
        Logger.i("addSubmitNotification checkBpeaCertNull error");
    }

    private static void checkConfiguration(LocationInitConfig r1) {
        if (r1.getContext() != null) goto L5;
        Logger.i("context is null!");
        throw new IllegalStateException("The context must be configured before initialization of SDK");
    L5:
        if (TextUtils.isEmpty(r1.getBaseUrl()) == false) goto L7;
        Logger.i("base url is empty");
        throw new IllegalStateException("The base url must be configured before initialization of SDK");
    L7:
        if (r1.isPrivacyConfirmed() == false) goto L9;
        return;
    L9:
        Logger.i("Privacy not Confirmed");
        throw new IllegalStateException("The Privacy must be Confirmed before initialization of SDK");
    }

    private boolean executeInit(LocationInitConfig r11) {
        long r0 = System.currentTimeMillis();
        Logger.i("init start time:" + r0);
        Logger.addPrinter(r11.getALogPrinter());
        BDLocationConfig.setDebug(r11.getDebug());
        BDLocationConfig.setDeviceId(r11.getDid());
        BDLocationConfig.setAppId(r11.getAppId());
        BDLocationConfig.setChannel(r11.getChannel());
        BDLocationConfig.setAppVersion(r11.getAppVersion());
        BDLocationConfig.setUpdateVersionCode(r11.getUpdateVersionCode());
        BDLocationConfig.setPackageName(r11.getPackageName());
        BDLocationConfig.setOverseas(r11.isOverseas());
        BDLocationConfig.setOverseaUploadInterval(r11.getOverseaUploadInterval());
        BDLocationConfig.setOverseaUploadMaxDuration(r11.getOverseaUploadMaxDuration());
        BDLocationConfig.setOverseaUploadMaxCount(r11.getOverseaUploadMaxCount());
        BDLocationConfig.setLatlngPrecision(r11.getLatlngPrecision());
        BDLocationConfig.setEnableH3(r11.isEnableH3());
        BDLocationConfig.setH3Distance(r11.getH3Distance());
        BDLocationConfig.setH3Resolution(r11.getH3Resolution());
        BDLocationConfig.setAppBootTime(r11.getAppBootTime());
        BDLocationConfig.setLocateType(r11.getLocateType());
        BDLocationConfig.setLocale(r11.getLocale());
        BDLocationConfig.setWorldView(r11.getWorldView());
        BDLocationConfig.setBaseUrl(r11.getBaseUrl());
        BDLocationConfig.setAppBackgroundProvider(r11.getBackgroundProvider());
        BDLocationConfig.setPrivacyConfirmed(r11.isPrivacyConfirmed());
        BDLocationConfig.setNetworkApi(r11.getCustomNetworkApi());
        BDLocationConfig.setRestrictedMode(r11.getRestrictedMode());
        BDLocationConfig.setEventManager(r11.getEventManager());
        BDLocationConfig.setEnableHARCollect(r11.isEnableHARCollect());
        BDLocationConfig.setBpeaCerts(r11.getBpeaCerts());
        LocationMonitorUtil.init(r11.getContext());
        BDLocationConfig.init(r11.getContext());
        h.F();
        long r2 = System.currentTimeMillis();
        long r6 = r11.getAppBootTime();
        long r10 = 0;
        if (r6 <= 0) goto L5;
        r10 = r2 - r6;
    L5:
        Logger.i("init end time:" + r2 + "--AppBootTime:" + r6);
        LocationMonitor.uploadInitInfo(r10, r6, r2 - r0);
        return true;
    }

    public static BDLocationHelper getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(BDLocationHelper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new BDLocationHelper();     // Catch: Throwable -> L11
    L9:
        monitor-exit(BDLocationHelper.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public static void removeNotification(LocationNotification r1, int r2) {
        h.F().S(r1, r2);
    }

    public static void removeSubmitNotification(LocationSubmitNotification r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        h.F().T(r1);
    }

    @Nullable
    @WorkerThread
    public BDPoint convertGCJ02(BDPoint r1) {
        if (isInit() == true) goto L7;
        Logger.i("must be init");
        return null;
    L7:
        return h.F().z(r1);
    }

    @Nullable
    public BdGisResult geocode(double r8, double r10, int r12, @Nullable Object r13) {
        if (isInit() == true) goto L6;
        Logger.i("must be init");
        return null;
    L6:
        LocationUtil.checkBpeaCertNull("geocode", r13);
        return h.F().B(r8, r10, r12, r13);
    }

    @Nullable
    public BdGisResult geocode(double r8, double r10, int r12, boolean r13) {
        if (isInit() == true) goto L6;
        Logger.i("must be init");
        return null;
    L6:
        LocationUtil.withoutBpeaCertCheck("geocode");
        return h.F().C(r8, r10, r12, r13);
    }

    @Nullable
    @WorkerThread
    public BDLocation getIPLocation(Object r1, int r2) {
        if (isInit() == true) goto L6;
        Logger.i("must be init");
        return null;
    L6:
        LocationUtil.checkBpeaCertNull("getIPLocation", r1);
        return h.F().E(r1, r2);
    }

    @Nullable
    public BDLocation getLastKnowLocation(int r2, boolean r3) {
        if (isInit() == true) goto L6;
        Logger.i("must be init");
        return null;
    L6:
        LocationUtil.withoutBpeaCertCheck("getLastKnowLocation");
        return h.F().G(r2, r3, true);
    }

    @Nullable
    public BDLocation getLastKnowLocation(@Nullable Object r2) {
        if (isInit() == true) goto L6;
        Logger.i("must be init");
        return null;
    L6:
        LocationUtil.checkBpeaCertNull("getLastKnowLocation", r2);
        Logger.i("BDLocationHelper getLastKnowLocation start");
        BDLocation r1 = h.F().I(r2, true);
        Logger.i("BDLocationHelper getLastKnowLocation end");
        return r1;
    }

    @Nullable
    public BDLocation getLastKnowLocation(Object r1, int r2, boolean r3) {
        if (isInit() == true) goto L6;
        Logger.i("must be init");
        return null;
    L6:
        LocationUtil.checkBpeaCertNull("getLastKnowLocation", r1);
        return h.F().H(r1, r2, r3);
    }

    public void getLightLocation(Object r1, String r2, boolean r3) {
        h.F().K(r1, r2, r3);
    }

    @Nullable
    @WorkerThread
    public RegionBean getRegion(boolean r1) {
        if (isInit() == true) goto L7;
        Logger.i("must be init");
        return null;
    L7:
        return BDLocationExtrasService.getRegionDataCore().getRegion(r1);
    }

    @Nullable
    @WorkerThread
    public RegionBean getRegion(boolean r1, boolean r2) {
        if (isInit() == true) goto L7;
        Logger.i("must be init");
        return null;
    L7:
        return BDLocationExtrasService.getRegionDataCore().getRegion(r1, r2);
    }

    public synchronized void init(LocationInitConfig r3) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.sIsRegister == false) goto L18;
        Logger.i("location already init");     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L18:
        checkConfiguration(r3);     // Catch: Exception -> L10 Throwable -> L14
        executeInit(r3);     // Catch: Exception -> L10 Throwable -> L14
        this.sIsRegister = true;     // Catch: Exception -> L10 Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L10:
        e = move-exception;
        Logger.i("init error:" + e.toString());     // Catch: Throwable -> L14
        this.sIsRegister = false;     // Catch: Throwable -> L14
        goto L12
    }

    public boolean isInit() {
        return this.sIsRegister;
    }

    public void requestLocationPermission(Activity r1, Object r2, int r3, RequestPermissionUtils.OnPermissionListener r4) {
        if (isInit() == true) goto L11;
        r4.onPermissionDenied();
        Logger.i("must be init");
        return;
    L11:
        LocationUtil.checkBpeaCertNull("requestLocationPermission", r2);     // Catch: BDLocationException -> L9
        h.F().U(r1, r2, r3, r4);
        return;
    L9:
        r4.onPermissionDenied();
        Logger.i("checkBpeaCertNull error");
    }

    public void setBaseUrl(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return;
    L5:
        BDLocationConfig.setBaseUrl(r1);
    }

    public void updateSettings(Context r1, JSONObject r2) {
        LocationSettingUtil.updateSettings(r1, r2);
    }

    @WorkerThread
    public boolean uploadRegionInfo() {
        if (isInit() == true) goto L7;
        Logger.i("must be init");
        return false;
    L7:
        return BDLocationExtrasService.getRegionDataCore().uploadRegionInfo();
    }

    public void uploadRegionInfoAsync(RegionUploadCallback r2) {
        if (isInit() == true) goto L6;
        r2.onUpLoadResult(false, null);
        Logger.i("must be init");
        return;
    L6:
        BDLocationExtrasService.getRegionDataCore().uploadRegionInfoAsync(r2);
    }
}
