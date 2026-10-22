package com.bytedance.bdlocation.settings;

import android.content.Context;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.store.LocationCache;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class LocationSettingUtil {
    public static final String LOCATION_SDK_SETTINGS_KEY = "sdk_key_BDUGLocationKit";
    private static LocationSettingModel sLocationSettingModel;

    public LocationSettingUtil() {
    }

    public static LocationSettingModel getLocationConfig() {
        return sLocationSettingModel;
    }

    public static void setLocationConfig() {
        if (sLocationSettingModel != null) goto L5;
        String r0 = LocationCache.getInstance().getLocationSettings();
        Logger.i("LocationSettings:::" + r0);
        sLocationSettingModel = LocationSettingModel.toModel(r0);
    L5:
        LocationSettingModel r1 = sLocationSettingModel;
        if (r1 == null) goto L9;
        BDLocationConfig.setUpload(r1.collectConfig);
        BDLocationConfig.setPollingUpload(sLocationSettingModel.pollingUpload);
        BDLocationConfig.setUploadInterval(((long) sLocationSettingModel.reportIntervalSeconds) * 1000);
        BDLocationConfig.setReportAtStart(sLocationSettingModel.reportAtStart);
        BDLocationConfig.setReportLocationAtStart(sLocationSettingModel.reportLocationAtStart);
        BDLocationConfig.setIsUploadGPS(sLocationSettingModel.reportGps);
        BDLocationConfig.setBssNum(sLocationSettingModel.reportBssMax);
        BDLocationConfig.setWifiNum(sLocationSettingModel.reportWifiMax);
        BDLocationConfig.setEnableHARCollect(sLocationSettingModel.reportHar);
        BDLocationConfig.setHARStatusRange(sLocationSettingModel.reportHarRange);
        BDLocationConfig.setShakeConfig(sLocationSettingModel.shakeConfig);
        BDLocationConfig.setEnableTraceroute(sLocationSettingModel.enableTraceroute);
        BDLocationConfig.setLocateType(sLocationSettingModel.locateType);
        BDLocationConfig.setColdBootABTest(sLocationSettingModel.coldBootABTest);
        BDLocationConfig.setUploadBleNum(sLocationSettingModel.uploadBleNum);
        BDLocationConfig.setScanBleInterval(sLocationSettingModel.scanBleInterval);
        BDLocationConfig.setEnableScanBle(sLocationSettingModel.scanBle);
        BDLocationConfig.setCheckLocationBpea(sLocationSettingModel.checkLocationBpea);
        BDLocationConfig.setLocationMode(sLocationSettingModel.locationMode);
        BDLocationConfig.setOpenWifiListMonitor(sLocationSettingModel.openWifiListMonitor);
        BDLocationConfig.setUseGpsCheckRegion(sLocationSettingModel.useGpsCheckRegion);
        BDLocationConfig.setNeedDownGradeLocationInOverseas(sLocationSettingModel.needDowngradeLocationInOverseas);
        BDLocationConfig.setRedGeoNameIds(sLocationSettingModel.redGeoNameIds);
        BDLocationConfig.setOverseasGetLocationFailedUseCacheValidity(sLocationSettingModel.overseasGetLocationFailedCacheValidityTime);
        BDLocationConfig.setUseNewCacheStrategy(sLocationSettingModel.useNewCacheStrategy);
        BDLocationConfig.setUseNewNetworkChangeRegister(sLocationSettingModel.newNetworkChangeRegister);
        BDLocationConfig.setEnableLightLocation(sLocationSettingModel.enableLightLocation);
        BDLocationConfig.setCollectLightInfo(sLocationSettingModel.collectLightInfo);
        BDLocationConfig.setLightInfoInterval(sLocationSettingModel.lightInfoInterval);
        BDLocationConfig.setMaxLightCount(sLocationSettingModel.maxLightCount);
        BDLocationConfig.setMaxLightDuration(sLocationSettingModel.maxLightDuration);
        BDLocationConfig.setEnableGpsScan(sLocationSettingModel.enableGpsScan);
        BDLocationConfig.setOverseaUploadInterval(sLocationSettingModel.overseasUploadInterval);
        BDLocationConfig.setOverseaUploadMaxCount(sLocationSettingModel.uploadMaxCount);
        BDLocationConfig.setLatlngPrecision(sLocationSettingModel.latlngPrecision);
        BDLocationConfig.setH3Distance(sLocationSettingModel.h3Distance);
        BDLocationConfig.setH3Resolution(sLocationSettingModel.h3Resolution);
        BDLocationConfig.setEnableH3(sLocationSettingModel.enable_h3);
        BDLocationConfig.setBeaconConfig(sLocationSettingModel.beaconConfig);
        return;
    }

    public static void updateSettings(Context r2, JSONObject r3) {
        if (r2 == null) goto L11;
        if (r3 != null) goto L6;
        return;
    L6:
        if (r3.has(LOCATION_SDK_SETTINGS_KEY) == false) goto L8;
        r3 = r3.optJSONObject(LOCATION_SDK_SETTINGS_KEY);
    L8:
        if (r3 == null) goto L12;
        Logger.i("updateSettings:::" + r3.toString());
        sLocationSettingModel = LocationSettingModel.toModel(r3.toString());
        LocationCache.getInstance().setLocationSettings(r2, r3.toString());
        return;
    L12:
        return;
    }
}
