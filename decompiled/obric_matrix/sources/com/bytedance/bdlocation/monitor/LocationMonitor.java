package com.bytedance.bdlocation.monitor;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class LocationMonitor {
    public LocationMonitor() {
    }

    public static void certNullCheck(String r6, Object r7) {
        if (r7 == null) goto L4;
        return;
    L4:
        Logger.i("bpea cert is null:" + r6);
        long r0 = System.currentTimeMillis();
        StackTraceElement[] r8 = Thread.currentThread().getStackTrace();
        StringBuilder r2 = new StringBuilder();
        if (r8 != null) goto L7;
    L12:
        doBpeaCertIsNull(r6, System.currentTimeMillis() - r0, r2.toString());
        return;
    L7:
        if (r8.length <= 0) goto L12;
        int r3 = 0;
    L10:
        if (r3 >= r8.length) goto L12;
        r2.append(r8[r3].toString() + "\n");
        r3 = r3 + 1;
        goto L10
    }

    public static void doBpeaCertCheck(String r2, boolean r3, String r4, long r5) {
        Logger.i("bpea check " + r3 + ",token is:" + r4);
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutString(r0, LocationMonitorConst.METHOD_NAME, r2);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_VALID, r3);
        JsonUtil.safePutString(r0, LocationMonitorConst.CERT_TOKEN, r4);
        JSONObject r6 = new JSONObject();
        JsonUtil.safePutLong(r6, LocationMonitorConst.BPEA_CHECK_DURATION, r5);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BPEA_CERT_CHECK, r0, r6, null);
    }

    private static void doBpeaCertIsNull(String r2, long r3, String r5) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutString(r0, LocationMonitorConst.METHOD_NAME, r2);
        JSONObject r4 = new JSONObject();
        JsonUtil.safePutLong(r4, LocationMonitorConst.STACKTRACE_DURATION, r3);
        JSONObject r6 = new JSONObject();
        JsonUtil.safePutString(r6, LocationMonitorConst.STACK_TRACE, r5);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BPEA_CERT_NULL, r0, r4, r6);
    }

    public static void doBpeaCertParamsNull(String r2, String r3) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutString(r0, LocationMonitorConst.BPEA_ACTION, r3);
        JSONObject r4 = new JSONObject();
        JsonUtil.safePutString(r4, LocationMonitorConst.CERT_TOKEN, r2);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BPEA_CHECK_PARAMS_NULL, r0, null, r4);
    }

    public static void doConnectWifiInfo(boolean r3, String r4) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_WIFI_OPEN, LocationUtil.isWifiOpen());
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_WIFI_CACHE, r3);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_WIFI_NULL, TextUtils.isEmpty(r4));
        JSONObject r5 = new JSONObject();
        JsonUtil.safePutString(r5, LocationMonitorConst.CONNECT_WIFI_INFO, r4);
        JsonUtil.safePutString(r5, LocationMonitorConst.STACK_TRACE, Log.getStackTraceString(new Throwable()));
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_CONNECT_WIFI_INFO, r0, null, r5);
    }

    public static void doContinueLocation(String r2, String r3, String r4, String r5) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutString(r0, LocationMonitorConst.LOCATION_NAME, r2);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_CODE, r3);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, r4);
        JSONObject r6 = new JSONObject();
        JsonUtil.safePutString(r6, LocationMonitorConst.DETAIL_ERR_MSG, r5);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_CONTINUE, r0, null, r6);
    }

    public static void doDesiredLocationDuration(String r9, long r10, String r12, String r13, String r14, boolean r15, int r16) {
        doDesiredLocationDuration(r9, r10, r12, r13, r14, r15, r16, "");
    }

    public static void doDesiredLocationDuration(String r2, long r3, String r5, String r6, String r7, boolean r8, int r9, String r10) {
        Logger.i("locationmonitor location only duration is: " + r3 + "ms");
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutString(r0, LocationMonitorConst.LOCATION_NAME, r2);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_CODE, r5);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, r6);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_CN, r8);
        JsonUtil.safePutInt(r0, LocationMonitorConst.LOCATE_TYPE, r9);
        JSONObject r4 = new JSONObject();
        JsonUtil.safePutLong(r4, "total_duration", r3);
        JSONObject r11 = new JSONObject();
        JsonUtil.safePutString(r11, LocationMonitorConst.DETAIL_ERR_MSG, r7);
        JsonUtil.safePutString(r11, "sdk_version", r10);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_DESIRED_LOCATION_DURATION, r0, r4, r11);
    }

    public static void doDesiredLocationFail(long r7, BDLocationException r9, LocationOption r10) {
        JSONObject r0 = new JSONObject();
        if (r9 == null) goto L5;
        JsonUtil.safePutString(r0, LocationMonitorConst.LOCATION_NAME, r9.getSdkName());
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_TIMEOUT, r9.getCode().equals(BDLocationException.ERROR_TIMEOUT));
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_CODE, r9.getCode());
        String r11 = r9.getMessage();
    L6:
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, r11);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_SUCCESS, false);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_CACHE, false);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_CN, r10.isChineseRegion());
        JSONObject r12 = new JSONObject();
        JsonUtil.safePutLong(r12, "total_duration", r7);
        JSONObject r8 = new JSONObject();
        JsonUtil.safePutDouble(r8, LocationMonitorConst.ACCURACY, 0.0d);
        JsonUtil.safePutLong(r8, "cache_time", r10.getMaxCacheTime());
        JsonUtil.safePutLong(r8, LocationMonitorConst.TIMEOUT, r10.getLocationTimeOutMs());
        JsonUtil.safePutString(r8, LocationMonitorConst.UPLOAD_SOURCE, r10.getUploadSource());
        JsonUtil.safePutLong(r8, LocationMonitorConst.INTEL_UPLOAD_INTERVAL, r10.getUploadInterval());
        JsonUtil.safePutLong(r8, LocationMonitorConst.CACHE_TIMESTAMP, 0);
        JsonUtil.safePutLong(r8, LocationMonitorConst.CACHE_DURATION, 0);
        JsonUtil.safePutLong(r8, "timestamp", System.currentTimeMillis());
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_DESIRED_LOCATION, r0, r12, r8);
        return;
    L5:
        JsonUtil.safePutString(r0, LocationMonitorConst.LOCATION_NAME, "");
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_TIMEOUT, false);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_CODE, "-2");
        r11 = "exception is null";
        goto L6
    }

    public static void doDesiredLocationSuccess(long r5, BDLocation r7, LocationOption r8) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutString(r0, LocationMonitorConst.LOCATION_NAME, r7.getLocationSDKName());
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_CODE, BDLocationException.SUCCESS);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, "success");
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_SUCCESS, true);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_TIMEOUT, false);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_CACHE, r7.isCache());
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_CN, r8.isChineseRegion());
        JsonUtil.safePutInt(r0, LocationMonitorConst.LOCATE_TYPE, r7.getLocationType());
        JSONObject r1 = new JSONObject();
        JsonUtil.safePutLong(r1, "total_duration", r5);
        JSONObject r6 = new JSONObject();
        JsonUtil.safePutDouble(r6, LocationMonitorConst.ACCURACY, r7.getAccuracy());
        JsonUtil.safePutLong(r6, "cache_time", r8.getMaxCacheTime());
        JsonUtil.safePutLong(r6, LocationMonitorConst.TIMEOUT, r8.getLocationTimeOutMs());
        JsonUtil.safePutString(r6, LocationMonitorConst.UPLOAD_SOURCE, r8.getUploadSource());
        JsonUtil.safePutLong(r6, LocationMonitorConst.INTEL_UPLOAD_INTERVAL, r8.getUploadInterval());
        if (r7.isCache() == false) goto L5;
        JsonUtil.safePutLong(r6, LocationMonitorConst.CACHE_TIMESTAMP, r7.getLocationMs());
        JsonUtil.safePutLong(r6, LocationMonitorConst.CACHE_DURATION, System.currentTimeMillis() - r7.getLocationMs());
    L6:
        JsonUtil.safePutLong(r6, "timestamp", System.currentTimeMillis());
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_DESIRED_LOCATION, r0, r1, r6);
        return;
    L5:
        JsonUtil.safePutLong(r6, LocationMonitorConst.CACHE_TIMESTAMP, 0);
        JsonUtil.safePutLong(r6, LocationMonitorConst.CACHE_DURATION, 0);
        goto L6
    }

    public static void doFirstLocationDuration(long r2, boolean r4) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_CACHE, r4);
        JSONObject r5 = new JSONObject();
        JsonUtil.safePutLong(r5, "total_duration", r2);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_FIRST_LOCATION_DURATION, r0, r5);
    }

    public static void doFirstSubmitDuration(long r2) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutLong(r0, "total_duration", r2);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_FIRST_SUBMIT_DURATION, null, r0);
    }

    public static void doGeocode(long r3, int r5, String r6) {
        JSONObject r0 = new JSONObject();
        if (r5 != 0) goto L5;
        int r1 = 0;
    L6:
        JsonUtil.safePutInt(r0, "status", r1);
        JsonUtil.safePutInt(r0, LocationMonitorConst.ERR_CODE, r5);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, r6);
        JSONObject r7 = new JSONObject();
        JsonUtil.safePutLong(r7, "total_duration", r3);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_GEOCODE, r0, r7);
        return;
    L5:
        r1 = 1;
        goto L6
    }

    public static void doGis(long r3, int r5, String r6) {
        JSONObject r0 = new JSONObject();
        if (r5 != 0) goto L5;
        int r1 = 0;
    L6:
        JsonUtil.safePutInt(r0, "status", r1);
        JsonUtil.safePutInt(r0, LocationMonitorConst.ERR_CODE, r5);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, r6);
        JSONObject r7 = new JSONObject();
        JsonUtil.safePutLong(r7, "total_duration", r3);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_GIS, r0, r7);
        return;
    L5:
        r1 = 1;
        goto L6
    }

    public static void doLightLocation(long r3, long r5, long r7, long r9, boolean r11, String r12, String r13, boolean r14) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_SUCCESS, r11);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_COLD_BOOT, r14);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_CODE, r12);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, r13);
        JSONObject r15 = new JSONObject();
        if (r11 == true) goto L5;
    L8:
        JSONObject r4 = new JSONObject();
        JsonUtil.safePutLong(r4, LocationMonitorConst.APP_BOOT_TIME, BDLocationConfig.getAppBootTime());
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BD_LOCATION_LIGHT_LOCATION, r0, r15, r4);
        return;
    L5:
        if (BDLocationConfig.getAppBootTime() == 0) goto L7;
        JsonUtil.safePutLong(r15, LocationMonitorConst.APP_COLD_BOOT_TO_START_LOCATION_DURATION, r3);
    L7:
        JsonUtil.safePutLong(r15, "total_duration", r5);
        JsonUtil.safePutLong(r15, LocationMonitorConst.GET_CELL_DURATION, r7);
        JsonUtil.safePutLong(r15, LocationMonitorConst.SUBMIT_DURATION, r9);
        goto L8
    }

    public static void doLightLocationError(String r12, String r13, boolean r14) {
        doLightLocation(0, 0, 0, 0, false, r12, r13, r14);
    }

    public static void doScanRefresh(long r3, int r5, String r6) {
        JSONObject r0 = new JSONObject();
        if (r5 != 0) goto L5;
        int r1 = 0;
    L6:
        JsonUtil.safePutInt(r0, "status", r1);
        JsonUtil.safePutInt(r0, LocationMonitorConst.ERR_CODE, r5);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, r6);
        JSONObject r7 = new JSONObject();
        JsonUtil.safePutLong(r7, "total_duration", r3);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_SCAN_REFRESH, r0, r7);
        return;
    L5:
        r1 = 1;
        goto L6
    }

    public static void doScanUpload(long r3, int r5, String r6) {
        JSONObject r0 = new JSONObject();
        if (r5 != 0) goto L5;
        int r1 = 0;
    L6:
        JsonUtil.safePutInt(r0, "status", r1);
        JsonUtil.safePutInt(r0, LocationMonitorConst.ERR_CODE, r5);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, r6);
        JSONObject r7 = new JSONObject();
        JsonUtil.safePutLong(r7, "total_duration", r3);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_SCAN_UPLOAD, r0, r7);
        return;
    L5:
        r1 = 1;
        goto L6
    }

    public static void doScanWiFiList(boolean r3, String r4) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_WIFI_OPEN, LocationUtil.isWifiOpen());
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_WIFI_CACHE, r3);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_WIFI_NULL, TextUtils.isEmpty(r4));
        JSONObject r5 = new JSONObject();
        JsonUtil.safePutString(r5, LocationMonitorConst.SCAN_WIFI_LIST, r4);
        JsonUtil.safePutString(r5, LocationMonitorConst.STACK_TRACE, Log.getStackTraceString(new Throwable()));
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_SCAN_WIFI_LIST, r0, null, r5);
    }

    public static void doSubmit(long r3, int r5, String r6) {
        JSONObject r0 = new JSONObject();
        if (r5 != 0) goto L5;
        int r1 = 0;
    L6:
        JsonUtil.safePutInt(r0, "status", r1);
        JsonUtil.safePutInt(r0, LocationMonitorConst.ERR_CODE, r5);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, r6);
        JSONObject r7 = new JSONObject();
        JsonUtil.safePutLong(r7, "total_duration", r3);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_SUBMIT_V2, r0, r7);
        return;
    L5:
        r1 = 1;
        goto L6
    }

    public static void fetchStationDuration(long r2) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutLong(r0, "total_duration", r2);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_FETCH_STATION_DURATION, null, r0);
    }

    public static void fetchTracerouteConfig(long r3, int r5, String r6) {
        JSONObject r0 = new JSONObject();
        if (r5 != 0) goto L5;
        int r1 = 0;
    L6:
        JsonUtil.safePutInt(r0, "status", r1);
        JsonUtil.safePutInt(r0, LocationMonitorConst.ERR_CODE, r5);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, r6);
        JSONObject r7 = new JSONObject();
        JsonUtil.safePutLong(r7, "total_duration", r3);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_TRACEROUTE_FETCH_CONFIG, r0, r7);
        return;
    L5:
        r1 = 1;
        goto L6
    }

    public static void fetchWifiDuration(long r2) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutLong(r0, "total_duration", r2);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_FETCH_WIFI_DURATION, null, r0);
    }

    public static void gpsCheckRegion(boolean r2, boolean r3) {
        if (r2 == r3) goto L5;
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_GPS_CHINESE_CHANNEL, r2);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_REGION_IN_CHINESECHANNEL, r3);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_GPS_CHECK_REGION, r0, null, null);
        return;
    }

    public static void overseasLocationFailedGetCache(boolean r3) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.OVERSEAS_GET_LOCATION_FAILED_CACHE_IS_VALIDITY, r3);
        JsonUtil.safePutLong(r0, "cache_time", BDLocationConfig.getOverseasGetLocationFailedUseCacheValidity());
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_OVERSEAS_GET_LOCATION_FAILED_CACHE_VALIDITY, r0, null, null);
    }

    public static void uploadAuthStatus(String r2, int r3, int r4) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutString(r0, LocationMonitorConst.TAG, r2);
        JsonUtil.safePutInt(r0, LocationMonitorConst.AUTH_STATUS, r3);
        JsonUtil.safePutInt(r0, LocationMonitorConst.LOCATION_MODE, r4);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_AUTH_STATUS, r0, null);
    }

    public static void uploadBaseInfo(long r3, int r5, String r6) {
        JSONObject r0 = new JSONObject();
        if (r5 != 0) goto L5;
        int r1 = 0;
    L6:
        JsonUtil.safePutInt(r0, "status", r1);
        JsonUtil.safePutInt(r0, LocationMonitorConst.ERR_CODE, r5);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, r6);
        JSONObject r7 = new JSONObject();
        JsonUtil.safePutLong(r7, "total_duration", r3);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BASE_INFO, r0, r7);
        return;
    L5:
        r1 = 1;
        goto L6
    }

    public static void uploadInitInfo(long r2, long r4, long r6) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutLong(r0, "total_duration", r6);
        if (r2 <= 0) goto L5;
        JsonUtil.safePutLong(r0, LocationMonitorConst.APP_COLD_BOOT_TO_END_INIT_DURATION, r2);
    L5:
        JSONObject r3 = new JSONObject();
        JsonUtil.safePutLong(r3, LocationMonitorConst.APP_BOOT_TIME, r4);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_INIT, null, r0, r3);
    }

    public static void uploadRestrictedInfo(long r3, int r5, String r6) {
        JSONObject r0 = new JSONObject();
        if (r5 != 0) goto L5;
        int r1 = 0;
    L6:
        JsonUtil.safePutInt(r0, "status", r1);
        JsonUtil.safePutInt(r0, LocationMonitorConst.ERR_CODE, r5);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, r6);
        JSONObject r7 = new JSONObject();
        JsonUtil.safePutLong(r7, "total_duration", r3);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_RESTRICTED_INFO, r0, r7);
        return;
    L5:
        r1 = 1;
        goto L6
    }

    public static void uploadTraceroute(long r2, int r4, int r5, String r6) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutInt(r0, "status", r4);
        JsonUtil.safePutInt(r0, LocationMonitorConst.ERR_CODE, r5);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, r6);
        JSONObject r7 = new JSONObject();
        JsonUtil.safePutLong(r7, "total_duration", r2);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_TRACEROUTE_UPLOAD, r0, r7);
    }

    public static void withoutCert(String r3) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutString(r0, LocationMonitorConst.METHOD_NAME, r3);
        JSONObject r4 = new JSONObject();
        JsonUtil.safePutString(r4, LocationMonitorConst.STACK_TRACE, Log.getStackTraceString(new Throwable()));
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BPEA_WITHOUT_CERT_CHECK, r0, null, r4);
    }
}
