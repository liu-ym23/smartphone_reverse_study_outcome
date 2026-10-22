package com.bytedance.bdlocation.settings;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ss.ttuploader.TTVideoUploader;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class LocationSettingModel {
    public static final String LOCATION_BEACON_SETTINGS_KEY = "locationsdk_beacon_config_android";
    public static final String LOCATION_OVERSEAS_SETTINGS_KEY = "locationsdk_overseas_config_android";
    public static final String LOCATION_SETTINGS_KEY = "locationsdk_config_android";
    public static final String LOCATION_SHAKE_SETTINGS_KEY = "locationsdk_shake_config_android";
    public JSONObject beaconConfig;
    public boolean checkLocationBpea;
    public boolean coldBootABTest;
    public boolean collectConfig;
    public boolean collectLightInfo;
    public boolean enableGpsScan;
    public boolean enableLightLocation;
    public boolean enableTraceroute;
    public boolean enable_h3;
    public int h3Distance;
    public int h3Resolution;
    public int latlngPrecision;
    public int lightInfoInterval;
    public int locateType;
    public int locationMode;
    public int maxLightCount;
    public long maxLightDuration;
    public boolean needDowngradeLocationInOverseas;
    public boolean newNetworkChangeRegister;
    public boolean openWifiListMonitor;
    public long overseasGetLocationFailedCacheValidityTime;
    public int overseasUploadInterval;
    public boolean pollingUpload;
    public String redGeoNameIds;
    public boolean reportAtStart;
    public boolean reportBss;
    public int reportBssMax;
    public boolean reportGps;
    public boolean reportHar;
    public int reportHarRange;
    public int reportIntervalSeconds;
    public boolean reportLocationAtStart;
    public boolean reportWifi;
    public int reportWifiMax;
    public boolean scanBle;
    public long scanBleInterval;
    public JSONObject shakeConfig;
    public int uploadBleNum;
    public int uploadMaxCount;
    public boolean useGpsCheckRegion;
    public boolean useNewCacheStrategy;

    public LocationSettingModel() {
        this.collectConfig = true;
        this.reportAtStart = true;
        this.reportLocationAtStart = false;
        this.pollingUpload = true;
        this.locateType = 3;
        this.reportIntervalSeconds = TTVideoUploader.KeyIsGetTosKey;
        this.reportWifiMax = 30;
        this.reportBssMax = 10;
        this.reportGps = true;
        this.reportWifi = true;
        this.reportBss = true;
        this.reportHar = false;
        this.reportHarRange = 64;
        this.overseasUploadInterval = 3600;
        this.uploadMaxCount = 7;
        this.latlngPrecision = 2;
        this.enable_h3 = true;
        this.enableTraceroute = false;
        this.h3Resolution = 7;
        this.h3Distance = 1;
        this.openWifiListMonitor = false;
        this.coldBootABTest = false;
        this.uploadBleNum = 30;
        this.scanBleInterval = 1000;
        this.scanBle = false;
        this.checkLocationBpea = false;
        this.locationMode = 2;
        this.useNewCacheStrategy = false;
        this.newNetworkChangeRegister = false;
        this.collectLightInfo = false;
        this.lightInfoInterval = 3;
        this.maxLightCount = 30;
        this.maxLightDuration = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
        this.enableGpsScan = false;
    }

    @Nullable
    public static String fromModel(LocationSettingModel r5) {
        Logger.i("LocationSettingModel from");
        if (r5 != null) goto L6;
        return null;
    L6:
        JSONObject r0 = new JSONObject();
        JSONObject r1 = new JSONObject();
        r0.put("collect_config", r5.collectConfig);     // Catch: JSONException -> L9
        r0.put("polling_upload", r5.pollingUpload);     // Catch: JSONException -> L9
        r0.put(LocationMonitorConst.LOCATE_TYPE, r5.locateType);     // Catch: JSONException -> L9
        r0.put("report_interval_seconds", r5.reportIntervalSeconds);     // Catch: JSONException -> L9
        r0.put("report_at_start", r5.reportAtStart);     // Catch: JSONException -> L9
        r0.put("report_location_at_start", r5.reportLocationAtStart);     // Catch: JSONException -> L9
        r0.put("report_gps", r5.reportGps);     // Catch: JSONException -> L9
        r0.put("report_bss", r5.reportBss);     // Catch: JSONException -> L9
        r0.put("report_wifi", r5.reportWifi);     // Catch: JSONException -> L9
        r0.put("report_bss_max", r5.reportBssMax);     // Catch: JSONException -> L9
        r0.put("report_wifi_max", r5.reportWifiMax);     // Catch: JSONException -> L9
        r0.put("report_har", r5.reportHar);     // Catch: JSONException -> L9
        r0.put("report_har_range", r5.reportHarRange);     // Catch: JSONException -> L9
        r0.put("shake_config", r5.shakeConfig);     // Catch: JSONException -> L9
        r0.put("enable_traceroute", r5.enableTraceroute);     // Catch: JSONException -> L9
        r0.put(SettingsConstants.COLD_BOOT_AB_TEST, r5.coldBootABTest);     // Catch: JSONException -> L9
        r0.put("upload_ble_num", r5.uploadBleNum);     // Catch: JSONException -> L9
        r0.put("scan_ble_interval", r5.scanBleInterval);     // Catch: JSONException -> L9
        r0.put("scan_ble", r5.scanBle);     // Catch: JSONException -> L9
        r0.put("check_location_bpea", r5.checkLocationBpea);     // Catch: JSONException -> L9
        r0.put(LocationMonitorConst.LOCATION_MODE, r5.locationMode);     // Catch: JSONException -> L9
        r0.put("open_wifi_list_monitor", r5.openWifiListMonitor);     // Catch: JSONException -> L9
        r0.put("use_gps_check_region", r5.useGpsCheckRegion);     // Catch: JSONException -> L9
        r0.put("overseas_get_location_failed_cache_validity_time", r5.overseasGetLocationFailedCacheValidityTime);     // Catch: JSONException -> L9
        r0.put("red_geo_name_ids", r5.redGeoNameIds);     // Catch: JSONException -> L9
        r0.put("need_downgrade_location_in_overseas", r5.needDowngradeLocationInOverseas);     // Catch: JSONException -> L9
        r0.put("use_new_cache_strategy", r5.useNewCacheStrategy);     // Catch: JSONException -> L9
        r0.put("new_network_change_register", r5.newNetworkChangeRegister);     // Catch: JSONException -> L9
        r0.put(SettingsConstants.ENABLE_LIGHT_LOCATION, r5.enableLightLocation);     // Catch: JSONException -> L9
        r0.put("collect_light_info", r5.collectLightInfo);     // Catch: JSONException -> L9
        r0.put("light_info_interval", r5.lightInfoInterval);     // Catch: JSONException -> L9
        r0.put("max_light_count", r5.maxLightCount);     // Catch: JSONException -> L9
        r0.put("max_light_duration", r5.maxLightDuration);     // Catch: JSONException -> L9
        r0.put("enable_gps_scan", r5.enableGpsScan);     // Catch: JSONException -> L9
        r0.put("overseas_upload_interval", r5.overseasUploadInterval);     // Catch: JSONException -> L9
        r0.put("upload_max_count", r5.uploadMaxCount);     // Catch: JSONException -> L9
        r0.put("latlng_precision", r5.latlngPrecision);     // Catch: JSONException -> L9
        r0.put("enable_h3", r5.enable_h3);     // Catch: JSONException -> L9
        r0.put("h3_resolution", r5.h3Resolution);     // Catch: JSONException -> L9
        r0.put("h3_distance", r5.h3Distance);     // Catch: JSONException -> L9
        r0.put("beacon_config", r5.beaconConfig);     // Catch: JSONException -> L9
        r1.put(LOCATION_SETTINGS_KEY, r0);     // Catch: JSONException -> L9
    L12:
        return r1.toString();
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    @Nullable
    public static LocationSettingModel toModel(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return null;
    L6:
        LocationSettingModel r0 = new LocationSettingModel();
        JSONObject r1 = new JSONObject(r10);     // Catch: JSONException -> L15
        JSONObject r11 = r1.optJSONObject(LOCATION_SETTINGS_KEY);     // Catch: JSONException -> L15
        if (r11 == null) goto L10;
        r0.collectConfig = r11.optBoolean("collect_config", true);     // Catch: JSONException -> L15
        r0.pollingUpload = r11.optBoolean("polling_upload", true);     // Catch: JSONException -> L15
        r0.locateType = r11.optInt(LocationMonitorConst.LOCATE_TYPE, 3);     // Catch: JSONException -> L15
        r0.reportIntervalSeconds = r11.optInt("report_interval_seconds", TTVideoUploader.KeyIsGetTosKey);     // Catch: JSONException -> L15
        r0.reportAtStart = r11.optBoolean("report_at_start", true);     // Catch: JSONException -> L15
        r0.reportLocationAtStart = r11.optBoolean("report_location_at_start", false);     // Catch: JSONException -> L15
        r0.reportGps = r11.optBoolean("report_gps", true);     // Catch: JSONException -> L15
        r0.reportWifi = r11.optBoolean("report_wifi", true);     // Catch: JSONException -> L15
        r0.reportBss = r11.optBoolean("report_bss", true);     // Catch: JSONException -> L15
        r0.reportHar = r11.optBoolean("report_har", false);     // Catch: JSONException -> L15
        r0.reportHarRange = r11.optInt("report_har_range", 64);     // Catch: JSONException -> L15
        r0.enableTraceroute = r11.optBoolean("enable_traceroute", false);     // Catch: JSONException -> L15
        r0.reportBssMax = r11.optInt("report_bss_max", 10);     // Catch: JSONException -> L15
        r0.reportWifiMax = r11.optInt("report_wifi_max", 30);     // Catch: JSONException -> L15
        r0.coldBootABTest = r11.optBoolean(SettingsConstants.COLD_BOOT_AB_TEST, false);     // Catch: JSONException -> L15
        r0.uploadBleNum = r11.optInt("upload_ble_num", 30);     // Catch: JSONException -> L15
        r0.scanBleInterval = r11.optLong("scan_ble_interval", 1000);     // Catch: JSONException -> L15
        r0.scanBle = r11.optBoolean("scan_ble", false);     // Catch: JSONException -> L15
        r0.checkLocationBpea = r11.optBoolean("check_location_bpea", false);     // Catch: JSONException -> L15
        r0.locationMode = r11.optInt(LocationMonitorConst.LOCATION_MODE, 2);     // Catch: JSONException -> L15
        r0.openWifiListMonitor = r11.optBoolean("open_wifi_list_monitor", false);     // Catch: JSONException -> L15
        r0.useGpsCheckRegion = r11.optBoolean("use_gps_check_region", false);     // Catch: JSONException -> L15
        r0.overseasGetLocationFailedCacheValidityTime = r11.optLong("overseas_get_location_failed_cache_validity_time", LocationInfoConst.defaultsOverseasCacheValidity);     // Catch: JSONException -> L15
        r0.redGeoNameIds = r11.optString("red_geo_name_ids", LocationInfoConst.defaultRedGeoNameIds);     // Catch: JSONException -> L15
        r0.needDowngradeLocationInOverseas = r11.optBoolean("need_downgrade_location_in_overseas", false);     // Catch: JSONException -> L15
        r0.useNewCacheStrategy = r11.optBoolean("use_new_cache_strategy", false);     // Catch: JSONException -> L15
        r0.newNetworkChangeRegister = r11.optBoolean("new_network_change_register", false);     // Catch: JSONException -> L15
        r0.enableLightLocation = r11.optBoolean(SettingsConstants.ENABLE_LIGHT_LOCATION, false);     // Catch: JSONException -> L15
        r0.collectLightInfo = r11.optBoolean("collect_light_info", false);     // Catch: JSONException -> L15
        r0.lightInfoInterval = r11.optInt("light_info_interval", 3);     // Catch: JSONException -> L15
        r0.maxLightCount = r11.optInt("max_light_count", 30);     // Catch: JSONException -> L15
        r0.maxLightDuration = r11.optLong("max_light_duration", CoroutineLiveDataKt.DEFAULT_TIMEOUT);     // Catch: JSONException -> L15
        r0.enableGpsScan = r11.optBoolean("enable_gps_scan", false);     // Catch: JSONException -> L15
    L10:
        r0.shakeConfig = r1.optJSONObject(LOCATION_SHAKE_SETTINGS_KEY);     // Catch: JSONException -> L15
        JSONObject r12 = r1.optJSONObject(LOCATION_OVERSEAS_SETTINGS_KEY);     // Catch: JSONException -> L15
        if (r12 == null) goto L13;
        r0.overseasUploadInterval = r12.optInt("overseas_upload_interval", 3600);     // Catch: JSONException -> L15
        r0.uploadMaxCount = r12.optInt("upload_max_count", 7);     // Catch: JSONException -> L15
        r0.latlngPrecision = r12.optInt("latlng_precision", 2);     // Catch: JSONException -> L15
        r0.enable_h3 = r12.optBoolean("enable_h3", true);     // Catch: JSONException -> L15
        r0.h3Resolution = r12.optInt("h3_resolution", 7);     // Catch: JSONException -> L15
        r0.h3Distance = r12.optInt("h3_distance", 1);     // Catch: JSONException -> L15
    L13:
        r0.beaconConfig = r1.optJSONObject(LOCATION_BEACON_SETTINGS_KEY);     // Catch: JSONException -> L15
    L14:
        return r0;
    }
}
