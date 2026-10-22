package com.bytedance.bdlocation.network;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.entity.LogIdCacheEntity;
import com.bytedance.bdlocation.entity.gis.BdGisResult;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.network.model.BaseResp;
import com.bytedance.bdlocation.network.model.DeviceLocation;
import com.bytedance.bdlocation.network.model.DeviceStatus;
import com.bytedance.bdlocation.network.model.LocationResult;
import com.bytedance.bdlocation.network.model.LocationUploadExtra;
import com.bytedance.bdlocation.network.model.ShakeUploadInfo;
import com.bytedance.bdlocation.network.response.LocationResp;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.m;
import d.b.r.d0;
import d.b.r.h0.b;
import java.util.LinkedHashMap;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ServerApi {
    private static final String GEOCODE_RELATIVE_PATH = "/location/geocode/";
    private static final String GIS_RELATIVE_PATH = "/location/gis/reverse_geolocation";
    private static final String INFO_RELATIVE_PATH = "/location/info/";
    public static final String LOCATION_RELATIVE_PATH = "/location/submit-v2/";
    private static final String OVERSEA_GEOCODE_RELATIVE_PATH = "/ttloc/geocode/";
    private static final String OVERSEA_SUBMIT_RELATIVE_PATH = "/ttloc/new_submit/";
    private static final String SHAKE_REFRESH_RELATIVE_PATH = "/location/refresh-nearby-user-info/";
    private static final String SHAKE_RELATIVE_PATH = "/location/submit-nearby-user-info/";
    private static boolean sIsFirstUpload = true;

    static {
    }

    public ServerApi() {
    }

    @Nullable
    private static LocationResp analysisLocationResult(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L11;
        String r4 = "analysisLocationResult networkResponse is null";
    L5:
        Logger.i(r4);
        return null;
    L11:
        return (LocationResp) JsonUtil.sGson.m(r3, LocationResp.class);
    L9:
        e = move-exception;
        r4 = "analysisLocationResult exception:" + e.toString();
        goto L5
    }

    private static void cacheLogId(String r3, long r4) {
        if (TextUtils.isEmpty(r3) == false) goto L7;
        String r5 = "cacheLogId setUploadLogEntity error";
    L5:
        Logger.i(r5);
        return;
    L7:
        LogIdCacheEntity r0 = BDLocationConfig.getLogIdCacheEntity();
        if (r0 != null) goto L10;
        r0 = new LogIdCacheEntity();
        r0.timestamp = r4;
    L13:
        r0.logId = r3;
        Logger.i("cacheLogId logId:" + r3 + "--startLocationTime：" + r4);
        BDLocationConfig.setLogIdCacheEntity(r0);
        r5 = "cacheLogId setUploadLogEntity success";
        goto L5
    L10:
        if (r4 == r0.timestamp) goto L13;
        r5 = "cacheLogId check time error startLocationTime:" + r4 + "--entityTIme:" + r0.timestamp;
        goto L5
    }

    private static boolean checkoutUploadRule() {
        if (BDLocationConfig.isRestrictedModeOn() == false) goto L8;
        String r0 = "The collection of data is allowed restricted mode off!";
    L5:
        Logger.i(r0);
        return false;
    L8:
        if (BDLocationConfig.isBackground() == false) goto L11;
        r0 = "The collection of data is allowed enter foreground!";
        goto L5
    L11:
        if (BDLocationConfig.isPrivacyConfirmed() == true) goto L13;
        r0 = "The collection of data is allowed after user confirmed the privacy!";
        goto L5
    L13:
        return true;
    }

    @Nullable
    @WorkerThread
    public static BdGisResult getGisResult(double r3, double r5, int r7) {
        if (checkoutUploadRule() == true) goto L7;
        String r4 = "The collection of data is allowed checkoutUploadRule!";
    L5:
        Logger.i(r4);
        return null;
    L7:
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("longitude", String.valueOf(r5));
        r0.put("latitude", String.valueOf(r3));
        Locale r6 = BDLocationConfig.getLocale();
        if (r6 != null) goto L10;
        r6 = Locale.getDefault();
    L10:
        r0.put("language", LocationUtil.languageTag(r6));
        String r8 = BDLocationConfig.getWorldView();
        if (TextUtils.isEmpty(r8) == true) goto L13;
        r0.put("worldview", r8);
    L13:
        long r9 = SystemClock.elapsedRealtime();
        BdGisResult r10 = (BdGisResult) JsonUtil.sGson.m(NetworkRequestManager.get(GIS_RELATIVE_PATH, r0, r7), BdGisResult.class);     // Catch: Exception -> L20
        if (r10 != null) goto L17;
    L19:
        return r10;
    L17:
        if (r10.baseResp == null) goto L19;
        long r11 = SystemClock.elapsedRealtime() - r9;     // Catch: Exception -> L20
        BaseResp r1 = r10.baseResp;     // Catch: Exception -> L20
        LocationMonitor.doGis(r11, r1.statusCode, r1.statusMessage);     // Catch: Exception -> L20
    L20:
        e = move-exception;
        LocationMonitor.doGis(SystemClock.elapsedRealtime() - r9, -1, e.getMessage());
        r4 = "getGisResult Exception:" + e.toString();
        goto L5
    }

    private static m getGpsAndBleUploadBody(LocationUploadExtra r5) {
        if (r5 != null) goto L5;
        Logger.i("getGpsAndBleUploadBody extra is null");
        return null;
    L5:
        m r0 = new m();
        r0.t(LocationMonitorConst.UPLOAD_SOURCE, r5.getUploadSource());
        String r1 = r5.getGpsAndBleMark();
        r0.t("upload_sensors", r1);
        LogIdCacheEntity r2 = r5.getLogIdCache();
        if (r2 != null) goto L8;
    L27:
        r0.s("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
        return r0;
    L8:
        if (TextUtils.isEmpty(r2.logId) == true) goto L27;
        r0.t("last_log_id", r2.logId);
        if (BDLocationConfig.enableScanBle() == false) goto L19;
        if (TextUtils.isEmpty(r1) == true) goto L19;
        if ("ble".equals(r1) == false) goto L16;
    L17:
        r0.q("bluetooth_list", JsonUtil.safeToJsonTree(r5.getBleList()));
        goto L19
    L16:
        if ("ble_gps".equals(r1) == true) goto L17;
    L19:
        if (BDLocationConfig.isEnableGpsScan() == false) goto L27;
        if (TextUtils.isEmpty(r1) == true) goto L27;
        if ("gps".equals(r1) == false) goto L25;
    L26:
        r0.q("upload_gps", JsonUtil.safeToJsonTree(r5.getGpsInfo()));
        goto L27
    L25:
        if ("ble_gps".equals(r1) == false) goto L27;
        goto L26
    }

    @Nullable
    @WorkerThread
    public static LocationResult getIPResult(int r7) {
        if (checkoutUploadRule() == true) goto L6;
        Logger.i("The collection of data is allowed checkoutUploadRule!");
        return null;
    L6:
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("dwinfo", packFingerprint(new m()));
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("sdk_version", BuildConfig.BDLOCATION_VERSION);
        long r3 = SystemClock.elapsedRealtime();
        JSONObject r1 = new JSONObject(NetworkRequestManager.post(GEOCODE_RELATIVE_PATH, r0, r2, r7));     // Catch: Exception -> L11
        int r8 = r1.optInt("err_no");     // Catch: Exception -> L11
        String r4 = r1.optString(LocationMonitorConst.ERR_MSG);     // Catch: Exception -> L11
        LocationMonitor.doGeocode(SystemClock.elapsedRealtime() - r3, r8, r4);     // Catch: Exception -> L11
        if (r8 != 0) goto L13;
        String r9 = r1.getString("data");     // Catch: Exception -> L11
        return (LocationResult) JsonUtil.sGson.m(unpackFingerprint(r9), LocationResult.class);
    L13:
        return null;
    L11:
        e = move-exception;
        LocationMonitor.doGeocode(SystemClock.elapsedRealtime() - r3, -2, e.getMessage());
        e.printStackTrace();
        goto L13
    }

    private static m getLightUploadBody(DeviceLocation r3, DeviceStatus r4, LocationUploadExtra r5) {
        m r0 = new m();
        if (r5 == null) goto L5;
        r0.t(LocationMonitorConst.UPLOAD_SOURCE, r5.getUploadSource());
        r0.t("upload_sensors", "light_sensor");
    L5:
        r0.q(LocationMonitorConst.LOCATION, JsonUtil.safeToJsonTree(r3));
        r0.q("status", JsonUtil.safeToJsonTree(r4));
        r0.t("language", LocationUtil.getLanguage());
        r0.t("world_view", BDLocationConfig.getWorldView());
        r0.s("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
        return r0;
    }

    @Nullable
    @WorkerThread
    public static LocationResp getLocationInfo(DeviceLocation r6, DeviceStatus r7, LocationUploadExtra r8) {
        m r9 = getSubmitUploadBody(r6, r7, r8);
        LinkedHashMap r10 = new LinkedHashMap();
        r10.put("locinfo", packFingerprint(r9));
        LinkedHashMap r11 = new LinkedHashMap();
        r11.put("sdk_version", BuildConfig.BDLOCATION_VERSION);
        long r0 = SystemClock.elapsedRealtime();
        if (sIsFirstUpload == false) goto L5;
        LocationMonitor.doFirstSubmitDuration(r0 - BDLocationConfig.getInitStartTime());
        Logger.i("locationmonitor first submit duration is: " + (r0 - BDLocationConfig.getInitStartTime()) + "ms");
        sIsFirstUpload = false;
    L5:
        d0<String> r12 = NetworkRequestManager.submitPost(LOCATION_RELATIVE_PATH, r10, r11, r8.getTriggerType());
        LocationMonitor.uploadAuthStatus(LocationMonitorConst.SUBMIT, PermissionManager.checkLocationPermissions(BDLocationConfig.getContext()), LocationUtil.getLocationMode(BDLocationConfig.getContext()));
        if (r12 == null) goto L16;
        String r13 = getLogId(r12);
        if (BDLocationConfig.isOverSeas() == true) goto L10;
        cacheLogId(r13, r8.getStartLocationTime());
    L10:
        LocationResp r14 = analysisLocationResult(r12.a());
        if (r14 == null) goto L13;
        r14.submitLogId = r13;
        LocationMonitor.doSubmit(SystemClock.elapsedRealtime() - r0, r14.resultCode, r14.resultMsg);
        Logger.i("locationmonitor submit total duration is: " + (SystemClock.elapsedRealtime() - r0) + "ms");
    L14:
        Logger.i("ServerApi", "end network duration is " + (System.currentTimeMillis() - r0));
        return r14;
    L13:
        LocationMonitor.doSubmit(SystemClock.elapsedRealtime() - r0, -2, "result is null");
        goto L14
    L16:
        return null;
    }

    private static String getLogId(d0<String> r2) {
        if (r2 != null) goto L5;
    L14:
        String r3 = "getLogId ssResponse error";
    L10:
        Logger.i(r3);
        return "";
    L5:
        if (r2.g() == null) goto L14;
        b r4 = r2.g().c("X-Tt-Logid");
        if (r4 != null) goto L13;
        r3 = "getLogId firstHeader error";
        goto L10
    L13:
        return r4.b();
    }

    private static m getSubmitUploadBody(DeviceLocation r4, DeviceStatus r5, LocationUploadExtra r6) {
        m r0 = new m();
        if (r6 == null) goto L12;
        r0.s("upload_interval", Long.valueOf(r6.getUploadInterval()));
        r0.t(LocationMonitorConst.UPLOAD_SOURCE, r6.getUploadSource());
        r0.r("latest_admin_version", Boolean.valueOf(r6.isLatestAdminVersion()));
        r0.t(WsConstants.KEY_EXTRA, r6.getExtra());
        LogIdCacheEntity r1 = r6.getLogIdCache();
        if (r1 != null) goto L7;
    L11:
        Logger.i("getLocationInfo upload_source:" + r6.getUploadSource() + "-upload_interval:" + r6.getUploadInterval() + "-extra:" + r6.getExtra());
        goto L12
    L7:
        if (TextUtils.isEmpty(r1.logId) == true) goto L11;
        r0.t("last_log_id", r1.logId);
        if (BDLocationConfig.enableScanBle() == false) goto L11;
        r0.q("bluetooth_list", JsonUtil.safeToJsonTree(r6.getBleList()));
    L12:
        r0.q(LocationMonitorConst.LOCATION, JsonUtil.safeToJsonTree(r4));
        r0.q("status", JsonUtil.safeToJsonTree(r5));
        r0.t("language", LocationUtil.getLanguage());
        r0.t("world_view", BDLocationConfig.getWorldView());
        r0.r("is_vpn", Boolean.valueOf(LocationUtil.checkVPN()));
        r0.r("is_proxy", Boolean.valueOf(LocationUtil.isProxy()));
        if (BDLocationConfig.isEnableHARCollect() == false) goto L15;
        r0.q("har_status_list", JsonUtil.safeToJsonTree(LocationUtil.getHARStatusList()));
        r0.s("har_status_max", Integer.valueOf(LocationUtil.getMaxHARStatus()));
    L15:
        r0.s("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
        return r0;
    }

    @Nullable
    public static String packFingerprint(m r0) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return packFingerprint(r0.toString());
    }

    @Nullable
    public static String packFingerprint(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L13;
        return null;
    L13:
        byte[] r5 = r4.getBytes("utf-8");     // Catch: Exception -> L10
        int r0 = r5.length;     // Catch: Exception -> L10
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L8;
        r5[r2] = (byte) (r5[r2] ^ (-99));     // Catch: Exception -> L10
        r2 = r2 + 1;     // Catch: Exception -> L10
        goto L6
    L8:
        return Base64.encodeToString(r5, 10);
    L10:
        e = move-exception;
        Logger.i("packFingerprint exception:" + e.toString());
        return null;
    }

    private static boolean shakeSubmitResult(String r6, String r7, String r8, long r9, boolean r11) {
        if (TextUtils.isEmpty(r6) == false) goto L24;
        return false;
    L24:
        LocationResp r10 = (LocationResp) JsonUtil.sGson.m(r6, LocationResp.class);     // Catch: Exception -> L17
        if (r10 != null) goto L8;
        return true;
    L8:
        if (r11 == false) goto L10;
        LocationMonitor.doScanRefresh(SystemClock.elapsedRealtime() - r9, r10.resultCode, r10.resultMsg);     // Catch: Exception -> L17
    L12:
        if (r10.resultCode != 0) goto L15;
        Logger.d("BDLocationUPTest UploadSchedule: result", unpackFingerprint(r10.data) + "---end");     // Catch: Exception -> L17
        Logger.i(r7);     // Catch: Exception -> L17
        return true;
    L15:
        Logger.i(r8);     // Catch: Exception -> L17
        return false;
    L10:
        LocationMonitor.doScanUpload(SystemClock.elapsedRealtime() - r9, r10.resultCode, r10.resultMsg);     // Catch: Exception -> L17
    L17:
        e = move-exception;
        long r2 = SystemClock.elapsedRealtime() - r9;
        String r12 = e.getMessage();
        if (r11 == false) goto L21;
        LocationMonitor.doScanRefresh(r2, -1, r12);
    L22:
        e.printStackTrace();
        Logger.e("The exception was occurred when the response data was convert to LocInfoRspData ");
        return false;
    L21:
        LocationMonitor.doScanUpload(r2, -1, r12);
        goto L22
    }

    @Nullable
    public static String unpackFingerprint(String r4) {
        if (r4 != null) goto L5;
    L13:
        return null;
    L5:
        if (r4.isEmpty() == true) goto L13;
        byte[] r5 = Base64.decode(r4, 2);     // Catch: Exception -> L14
        int r1 = r5.length;     // Catch: Exception -> L14
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L11;
        r5[r2] = (byte) (r5[r2] ^ (-99));     // Catch: Exception -> L14
        r2 = r2 + 1;     // Catch: Exception -> L14
        goto L9
    L11:
        return new String(r5);
    }

    @Nullable
    @WorkerThread
    public static LocationResp uploadGpsAndBleInfos(LocationUploadExtra r5) {
        if (LocationUtil.enableUseLocation(true) == true) goto L7;
        String r6 = "uploadGpsAndBleInfos locinfo is not allow";
    L5:
        Logger.i(r6);
        return null;
    L7:
        m r0 = getGpsAndBleUploadBody(r5);
        if (r0 != null) goto L10;
        r6 = "uploadGpsAndBleInfos locinfo is null";
        goto L5
    L10:
        LinkedHashMap r2 = new LinkedHashMap();
        String r1 = packFingerprint(r0);
        if (TextUtils.isEmpty(r1) == false) goto L13;
        r6 = "uploadGpsAndBleInfos body is empty";
        goto L5
    L13:
        r2.put("locinfo", r1);
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put("sdk_version", BuildConfig.BDLOCATION_VERSION);
        d0<String> r7 = NetworkRequestManager.submitPost(LOCATION_RELATIVE_PATH, r2, r3, r5.getTriggerType());
        if (r7 == null) goto L17;
        LocationResp r8 = analysisLocationResult(r7.a());
        Logger.i("uploadGpsAndBleInfos success");
        return r8;
    L17:
        return null;
    }

    @Nullable
    @WorkerThread
    public static LocationResp uploadLightLocation(DeviceLocation r4, DeviceStatus r5, LocationUploadExtra r6) {
        m r7 = getLightUploadBody(r4, r5, r6);
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("locinfo", packFingerprint(r7));
        LinkedHashMap r9 = new LinkedHashMap();
        r9.put("sdk_version", BuildConfig.BDLOCATION_VERSION);
        long r0 = System.currentTimeMillis();
        d0<String> r10 = NetworkRequestManager.submitPost(LOCATION_RELATIVE_PATH, r8, r9, r6.getTriggerType());
        r6.setLightSubmitDuration(System.currentTimeMillis() - r0);
        Logger.i("ServerApi", "end network duration is " + (System.currentTimeMillis() - r0));
        if (r10 != null) goto L5;
        return null;
    L5:
        return analysisLocationResult(r10.a());
    }

    @Nullable
    @WorkerThread
    public static LocationResp uploadLocationInfo(DeviceLocation r1, DeviceStatus r2, LocationUploadExtra r3) {
        if (checkoutUploadRule() == true) goto L7;
        Logger.i("The collection of data is allowed checkoutUploadRule!");
        return null;
    L7:
        return getLocationInfo(r1, r2, r3);
    }

    @Nullable
    @WorkerThread
    public static LocationResp uploadMccAndSystemRegionInfo(Context r5, String r6, int r7) {
        if (checkoutUploadRule() == true) goto L6;
        Logger.i("The collection of data is allowed checkoutUploadRule!");
        return null;
    L6:
        m r0 = new m();
        if (r6 == null) goto L9;
        r0.t(LocationMonitorConst.UPLOAD_SOURCE, r6);
        Logger.i("uploadMccAndSystemRegionInfo upload_source:" + r6);
    L9:
        r0.q("region_info", JsonUtil.safeToJsonTree(LocationUtil.getRegionInfo(r5)));
        r0.q("status", JsonUtil.safeToJsonTree(LocationUtil.getDeviceStatus(r5)));
        r0.s("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
        r0.r("is_vpn", Boolean.valueOf(LocationUtil.checkVPN()));
        r0.r("is_proxy", Boolean.valueOf(LocationUtil.isProxy()));
        Logger.i("submit device:" + JsonUtil.sGson.u(r0));
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("locinfo", packFingerprint(r0));
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("sdk_version", BuildConfig.BDLOCATION_VERSION);
        long r2 = SystemClock.elapsedRealtime();
        String r9 = NetworkRequestManager.post(INFO_RELATIVE_PATH, r8, r1, r7);
        Logger.i("info result:" + r9);
        LocationMonitor.uploadAuthStatus(LocationMonitorConst.INFO, PermissionManager.checkLocationPermissions(r5), LocationUtil.getLocationMode(r5));
        LocationResp r10 = analysisLocationResult(r9);
        long r11 = SystemClock.elapsedRealtime() - r2;
        if (r10 == null) goto L14;
        LocationMonitor.uploadBaseInfo(r11, r10.resultCode, r10.resultMsg);
        Logger.i("locationmonitor info total duration is: " + (SystemClock.elapsedRealtime() - r2) + "ms");
        if (BDLocationConfig.isRestrictedModeOn() == false) goto L15;
        LocationMonitor.uploadRestrictedInfo(SystemClock.elapsedRealtime() - r2, r10.resultCode, r10.resultMsg);
    L15:
        return r10;
    L14:
        LocationMonitor.uploadBaseInfo(r11, -2, "result is null");
        goto L15
    }

    @WorkerThread
    public static boolean uploadShakeInfo(ShakeUploadInfo r8, boolean r9, int r10) {
        if (checkoutUploadRule() == true) goto L6;
        Logger.i("The collection of data is allowed checkoutUploadRule!");
        return false;
    L6:
        String r11 = JsonUtil.sGson.v(r8);
        Logger.i("start submit uploadShakeInfo");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("userloc", packFingerprint(r11));
        LinkedHashMap r12 = new LinkedHashMap();
        r12.put("sdk_version", BuildConfig.BDLOCATION_VERSION);
        Logger.d("ServerApi uploadShakeInfo");
        if (r9 == false) goto L9;
        String r1 = SHAKE_REFRESH_RELATIVE_PATH;
    L10:
        long r5 = SystemClock.elapsedRealtime();
        return shakeSubmitResult(NetworkRequestManager.post(r1, r0, r12, r10), "upload location info success", "upload location info failed", r5, r9);
    L9:
        r1 = SHAKE_RELATIVE_PATH;
        goto L10
    }
}
