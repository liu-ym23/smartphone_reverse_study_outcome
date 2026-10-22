package com.bytedance.bdlocation;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.os.EnvironmentCompat;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.bytedance.bdlocation.api.ILocate;
import com.bytedance.bdlocation.api.ILocationH3Core;
import com.bytedance.bdlocation.callback.LightLocationCallback;
import com.bytedance.bdlocation.callback.LocationUploadCallback;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.BDPoint;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.entity.PoiInfoEntity;
import com.bytedance.bdlocation.entity.gis.BdGisResult;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.exception.BDLocationExceptionMessage;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.network.ServerApi;
import com.bytedance.bdlocation.network.model.BaseStation;
import com.bytedance.bdlocation.network.model.BdLBSResult;
import com.bytedance.bdlocation.network.model.DeviceLocation;
import com.bytedance.bdlocation.network.model.DeviceStatus;
import com.bytedance.bdlocation.network.model.GPSResult;
import com.bytedance.bdlocation.network.model.HARStatus;
import com.bytedance.bdlocation.network.model.LocationInfo;
import com.bytedance.bdlocation.network.model.LocationResult;
import com.bytedance.bdlocation.network.model.LocationUploadExtra;
import com.bytedance.bdlocation.network.model.Place;
import com.bytedance.bdlocation.network.model.PlaceInfo;
import com.bytedance.bdlocation.network.model.RegionCountry;
import com.bytedance.bdlocation.network.model.RegionInfo;
import com.bytedance.bdlocation.network.model.RuralInfo;
import com.bytedance.bdlocation.network.response.LocInfoRspData;
import com.bytedance.bdlocation.network.response.LocationResp;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.scan.wifi.WifiUtil;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.service.SystemBaseLocationImpl;
import com.bytedance.bdlocation.store.LocationCache;
import com.bytedance.bdlocation.thread.AppExecutors;
import com.bytedance.bdlocation.utils.CollectionUtil;
import com.bytedance.bdlocation.utils.HARServiceUtil;
import com.bytedance.bdlocation.utils.NetworkUtil;
import com.bytedance.bdlocation.utils.cell.BaseStationHelper;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import com.bytedance.common.utility.k;
import com.google.gson.m;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class LocationUtil {
    private LocationUtil() {
    }

    static /* synthetic */ void a(LocationUploadExtra r1, LocationUploadCallback r2) {
        getLocationInfo(null, r1, r2);
    }

    static /* synthetic */ void access$000(DeviceLocation r0, DeviceStatus r1, LocationUploadExtra r2, LocationUploadCallback r3) {
        startLocation(r0, r1, r2, r3);
    }

    public static BDLocation addressesToBDLocation(List<Address> r1, BDLocation r2, String r3) {
        if (CollectionUtil.isEmpty(r1) == false) goto L6;
        return null;
    L6:
        BDLocation r0 = new BDLocation(r2);
        r0.setGeocodeSDKName(r3);
        Iterator<Address> r4 = r1.iterator();
    L8:
        if (r4.hasNext() == false) goto L14;
        Address r5 = r4.next();
        if (r5.hasLatitude() == false) goto L8;
        if (r5.hasLongitude() == false) goto L8;
        r0.setCountry(r5.getCountryName());
        r0.setAdministrativeArea(r5.getAdminArea());
        r0.setSubAdministrativeArea(r5.getSubAdminArea());
        r0.setCity(r5.getLocality());
        r0.setDistrict(r5.getSubLocality());
        r0.setStreet(r5.getThoroughfare());
        r0.setStreetNum(r5.getSubThoroughfare());
        r0.setAddress(r5.getAddressLine(0));
        r0.setPoi(r5.getFeatureName());
    L14:
        return r0;
    }

    private static boolean allowUploadLocationInfo() {
        if (BDLocationConfig.isUploadLocation() == true) goto L8;
        String r0 = "The collection of data is unable upload location!";
    L5:
        Logger.i(r0);
        return false;
    L8:
        if (BDLocationConfig.isPrivacyConfirmed() == true) goto L10;
        r0 = "The collection of data is allowed after user confirmed the privacy!";
        goto L5
    L10:
        return true;
    }

    public static String allowUseLocation(boolean r0) {
        if (r0 == false) goto L8;
        if (BDLocationConfig.isBackground() == false) goto L8;
        Logger.i("check allowUseLocation isBackground");
        return BDLocationException.ERROR_BACKGROUND_LOCATE;
    L8:
        if (BDLocationConfig.isRestrictedModeOn() == false) goto L12;
        Logger.i("check allowUseLocation isRestrictedModeOn");
        return BDLocationException.ERROR_RESTRICTED_MODE_ON;
    L12:
        if (needLocate() == true) goto L16;
        Logger.i("check allowUseLocation NO_PERMISSION");
        return BDLocationException.ERROR_SDK_NO_PERMISSION;
    L16:
        if (isLocationEnabled() == true) goto L19;
        Logger.i("check allowUseLocation ERROR_DEVICE_LOCATION_DISABLE");
        return BDLocationException.ERROR_DEVICE_LOCATION_DISABLE;
    L19:
        return LocationInfoConst.ALLOW_USE_LOCATION;
    }

    static /* synthetic */ void b(BDLocation r1, LocationUploadExtra r2, LocationUploadCallback r3) {
    L6:
        e = move-exception;
        Logger.e("startLocateUpload", e);
        if (r3 == null) goto L14;
        r3.onError(e.getMessage());
        return;
    L14:
        return;
    L3:
        if (allowUploadLocationInfo() == false) goto L13;
        getLocationInfo(r1, r2, r3);     // Catch: Exception -> L6
        return;
    }

    public static LocationInfo bdLocationToLocationInfo(BDLocation r5, boolean r6) {
        if (r5 != null) goto L5;
        return null;
    L5:
        LocationInfo r0 = new LocationInfo();
        r0.country = r5.getCountry();     // Catch: Throwable -> L14
        r0.district = r5.getDistrict();     // Catch: Throwable -> L14
        r0.province = r5.getAdministrativeArea();     // Catch: Throwable -> L14
        r0.city = r5.getCity();     // Catch: Throwable -> L14
        r0.address = r5.getAddress();     // Catch: Throwable -> L14
        r0.street = r5.getStreet();     // Catch: Throwable -> L14
        r0.streetNum = r5.getStreetNum();     // Catch: Throwable -> L14
        r0.buildingId = r5.getBuildingId();     // Catch: Throwable -> L14
        r0.floor = r5.getFloor();     // Catch: Throwable -> L14
        if (r6 == false) goto L9;
        r0.latitude = r5.getLatitude();     // Catch: Throwable -> L14
        r0.longitude = r5.getLongitude();     // Catch: Throwable -> L14
    L9:
        r0.timestamp = r5.getTime() / 1000;     // Catch: Throwable -> L14
        r0.locateType = r5.getLocationType();     // Catch: Throwable -> L14
        r0.provider = r5.getLocationSDKName();     // Catch: Throwable -> L14
        r0.altitude = r5.getAltitude();     // Catch: Throwable -> L14
        r0.accuracy = r5.getAccuracy();     // Catch: Throwable -> L14
        r0.coordinateSystem = r5.getCoordinateSystem();     // Catch: Throwable -> L14
        r0.isMock = r5.isMock();     // Catch: Throwable -> L14
        if (Build.VERSION.SDK_INT < 26) goto L12;
        r0.altitudeAccuracy = r5.getVerticalAccuracyMeters();     // Catch: Throwable -> L14
    L12:
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L14
        r7.put("bearing", r5.getBearing());     // Catch: Throwable -> L14
        r7.put("speed", r5.getSpeed());     // Catch: Throwable -> L14
        r7.put("trusted_level", r5.getTrustedLevel());     // Catch: Throwable -> L14
        r7.put("location_detail", r5.getLocationDetail());     // Catch: Throwable -> L14
        r7.put("satellites", r5.getSatellites());     // Catch: Throwable -> L14
        r7.put("provider", r5.getProvider());     // Catch: Throwable -> L14
        r0.extra = r7.toString();     // Catch: Throwable -> L14
    L16:
        return r0;
    L14:
        th = move-exception;
        th.printStackTrace();
        goto L16
    }

    public static BDLocation blurredLocation(ILocationH3Core r2, BDLocation r3) {
        StringBuilder r0 = new StringBuilder();
        r0.append("regularizationLatLon:");
        r0.append(BDLocationConfig.isEnableH3());
        r0.append("--h3:");
        if (r2 != null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        Logger.i(r0.toString());
        if (r2 == null) goto L16;
        if (BDLocationConfig.isEnableH3() == false) goto L16;
        BDLocation r4 = turnToH3LatLon(r2, r3);
        if (r4 == null) goto L14;
        return r4;
    L14:
        return interceptLatLon(r3);
    L16:
        return interceptLatLon(r3);
    L5:
        r1 = false;
        goto L6
    }

    public static void checkBpeaCertNull(String r2, Object r3) {
        LocationMonitor.certNullCheck(r2, r3);
        if (BDLocationConfig.isCheckLocationBpea() == false) goto L8;
        if (r3 != null) goto L9;
        Logger.i(r2 + "check bpea is null");
        throw new BDLocationException(BDLocationExceptionMessage.BPEA_CERT_CHECK_EXCEPTION, EnvironmentCompat.MEDIA_UNKNOWN, BDLocationException.ERROR_BPEA_CERT_NULL);
    L9:
        return;
    }

    public static boolean checkCacheTime(long r1, long r3) {
        return checkCacheTime(r1, r3, true);
    }

    public static boolean checkCacheTime(long r6, long r8, boolean r10) {
        if (r6 != 0) goto L5;
        return false;
    L5:
        long r2 = System.currentTimeMillis();
        Logger.i("LocationCache currentTimeMillis:" + r2 + "-locationTime:" + r6 + "-cacheTimeMS:" + r8 + "-needDefaultCache:" + r10);
        if (r10 == false) goto L9;
        r8 = r8 + CoroutineLiveDataKt.DEFAULT_TIMEOUT;
    L9:
        if (Math.abs(r2 - r6) < r8) goto L11;
        return false;
    L11:
        return true;
    }

    public static boolean checkGeocode(BDLocation r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r2.getCountry()) == false) goto L9;
        return false;
    L9:
        if (TextUtils.isEmpty(r2.getAdministrativeArea()) == true) goto L11;
        return true;
    L11:
        if (TextUtils.isEmpty(r2.getSubAdministrativeArea()) == true) goto L13;
        return true;
    L13:
        if (TextUtils.isEmpty(r2.getCity()) == false) goto L18;
        return false;
    L18:
        return true;
    }

    public static boolean checkMockCacheTime(BDLocation r7) {
        if (r7 != null) goto L5;
        return false;
    L5:
        long r1 = System.currentTimeMillis();
        if (r7.getMockDuration() != 0) goto L8;
        return true;
    L8:
        if ((r1 - r7.getLocationMs()) <= r7.getMockDuration()) goto L12;
        return false;
    L12:
        return true;
    }

    public static boolean checkVPN() {
        if (BDLocationConfig.getContext() != null) goto L7;
        return false;
    L7:
        return NetworkUtil.checkVPN(BDLocationConfig.getContext());
    }

    public static int compareLocation(BDLocation r1, BDLocation r2) {
        if (r2 != null) goto L4;
        return -1;
    L4:
        if (r2.isEmpty() == true) goto L17;
        if (r1 != null) goto L8;
        return 0;
    L8:
        if (r1.isEmpty() == false) goto L11;
        return 0;
    L11:
        return locationEqual(r1, r2);
    L17:
        return -1;
    }

    @NonNull
    public static BDLocation composeGeocodeLocation(@NonNull BDLocation r3, @NonNull BDLocation r4) {
        BDLocation r0 = new BDLocation(r3);
        r0.setAddress(r4.getAddress());
        r0.setCity(r4.getCity());
        r0.setAdministrativeArea(r4.getAdministrativeArea());
        r0.setSubAdministrativeArea(r4.getSubAdministrativeArea());
        r0.setProvider(r4.getProvider());
        r0.setDistrict(r4.getDistrict());
        r0.setCountry(r4.getCountry());
        r0.setCityCode(r4.getCityCode());
        r0.setTown(r4.getTown());
        r0.setStreet(r4.getStreet());
        r0.setStreetNum(r4.getStreetNum());
        r0.setFloor(r4.getFloor());
        r0.setThirdPartLocation(r4.getThirdPartLocation());
        r0.setLocationSDKName(r4.getLocationSDKName());
        r0.setPoi(r4.getPoi());
        r0.setGCJ02(r4.getGCJ02());
        r0.setCountryCode(r4.getCountryCode());
        r0.setCountryLocalID(r4.getCountryLocalID());
        r0.setLocalID(r4.getLocalID());
        r0.setDistrictLocalID(r4.getDistrictLocalID());
        r0.setGeoNameID(r4.getGeoNameID());
        r0.setBdLBSResult(r4.getBdLBSResult());
        r0.setLocationResult(r4.getLocationResult());
        r0.setGeocodeSDKName(r4.getGeocodeSDKName());
        r0.setAoi(r4.getAoi());
        r0.setIsDisputed(r4.getIsDisputed());
        r0.setIsCompliance(r4.getIsCompliance());
        r0.setCountryId(r4.getCountryId());
        r0.setSubdivisionId(r4.getSubdivisionId());
        r0.setCityId(r4.getCityId());
        r0.setDistrictId(r4.getDistrictId());
        r0.setTownId(r4.getTownId());
        r0.setCountryAsciName(r4.getCountryAsciName());
        r0.setSubdivisionAsciName(r4.getSubdivisionAsciName());
        r0.setCityAsciName(r4.getCityAsciName());
        r0.setDistrictAsciName(r4.getDistrictAsciName());
        r0.setTownAsciName(r4.getTownAsciName());
        return r0;
    }

    @WorkerThread
    public static BDPoint convertGCJ02(BDPoint r2) {
        ILocate r0 = BDLocationExtrasService.getLocate(BDLocationConfig.getContext(), 1);
        if (r0 != null) goto L5;
        ILocate r1 = BDLocationExtrasService.getLocate(BDLocationConfig.getContext(), 5);
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1.convertGCJ02(r2);
    L5:
        return r0.convertGCJ02(r2);
    }

    @WorkerThread
    public static BDLocation convertLocation(BDLocation r8) {
        if (LocationInfoConst.GCJ_O2.equals(r8.getCoordinateSystem()) == true) goto L10;
        BDPoint r0 = convertGCJ02(new BDPoint(r8.getLatitude(), r8.getLongitude(), r8.getProvider()));
        if (r0 != null) goto L7;
        r8.setLatitude(0.0d);
        r8.setLongitude(0.0d);
        goto L10
    L7:
        double r2 = r0.getLatitude();
        double r4 = r0.getLongitude();
        if (isChineseChannel(r2, r4) == false) goto L10;
        r8.setCoordinateSystem(LocationInfoConst.GCJ_O2);
        r8.setLatitude(r2);
        r8.setLongitude(r4);
    L10:
        return r8;
    }

    public static boolean enableUseLocation(boolean r1) {
        return LocationInfoConst.ALLOW_USE_LOCATION.equals(allowUseLocation(r1));
    }

    public static BDLocation geocode(Context r7, BDLocation r8) {
        if (Geocoder.isPresent() == false) goto L8;
        Locale r0 = BDLocationConfig.getLocale();
        if (r0 != null) goto L10;
        r0 = Locale.getDefault();
    L10:
        return addressesToBDLocation(new Geocoder(r7, r0).getFromLocation(r8.getLatitude(), r8.getLongitude(), 10), r8, LocationInfoConst.SYSTEM);
    L8:
        return null;
    }

    @Nullable
    public static BaseStation getBaseStation(Context r5, Object r6) {
        BaseStation r0 = null;
    L9:
        e = move-exception;
        Logger.e("", e);
        return r0;
    L4:
        if (BDLocationConfig.isUploadBaseSite() == true) goto L6;
        return null;
    L6:
        if (BDLocationConfig.isOverSeas() == true) goto L15;
        long r1 = SystemClock.elapsedRealtime();     // Catch: Exception -> L9
        r0 = new BaseStationHelper(r5).getBaseStation(r6);     // Catch: Exception -> L9
        LocationMonitor.fetchStationDuration(SystemClock.elapsedRealtime() - r1);     // Catch: Exception -> L9
        Logger.i("locationmonitor basestation duration is: " + (SystemClock.elapsedRealtime() - r1) + "ms");     // Catch: Exception -> L9
        return r0;
    L15:
        return null;
    }

    @Nullable
    public static String getCityCodeForChina(BdLBSResult r0) {
        if (r0 == null) goto L9;
        LocationResult r1 = r0.location;
        if (r1 == null) goto L11;
        PlaceInfo r2 = r1.city;
        if (r2 != null) goto L8;
        return null;
    L8:
        return r2.localID;
    L11:
        return null;
    L9:
        return null;
    }

    @Nullable
    public static String getCityCodeForOverSea(BdLBSResult r2) {
        if (r2 == null) goto L9;
        LocationResult r3 = r2.location;
        if (r3 == null) goto L11;
        PlaceInfo r4 = r3.city;
        if (r4 != null) goto L8;
        return null;
    L8:
        return String.valueOf(r4.geoNameID);
    L11:
        return null;
    L9:
        return null;
    }

    @Nullable
    public static String getCountryCode(BdLBSResult r0) {
        if (r0 == null) goto L9;
        LocationResult r1 = r0.location;
        if (r1 == null) goto L11;
        PlaceInfo r2 = r1.country;
        if (r2 != null) goto L8;
        return null;
    L8:
        return r2.code;
    L11:
        return null;
    L9:
        return null;
    }

    @Nullable
    public static BaseStation getCurrentStation(Context r5, Object r6) {
        BaseStation r0 = null;
    L9:
        e = move-exception;
        Logger.e("", e);
        return r0;
    L4:
        if (BDLocationConfig.isUploadBaseSite() == true) goto L6;
        return null;
    L6:
        if (BDLocationConfig.isOverSeas() == true) goto L15;
        long r1 = SystemClock.elapsedRealtime();     // Catch: Exception -> L9
        r0 = new BaseStationHelper(r5).getCurrentStation(r6);     // Catch: Exception -> L9
        Logger.i("locationmonitor basestation duration is: " + (SystemClock.elapsedRealtime() - r1) + "ms");     // Catch: Exception -> L9
        return r0;
    L15:
        return null;
    }

    public static DeviceLocation getDeviceLocation(BDLocation r2, Object r3) {
        if (BDLocationConfig.isUploadLocation() == false) goto L7;
        DeviceLocation r0 = new DeviceLocation();
        r0.baseLocation = getBaseStation(BDLocationConfig.getContext(), r3);
        if (r2 == null) goto L9;
        r0.sysLocation = bdLocationToLocationInfo(r2, BDLocationConfig.isUploadGPS());
        return r0;
    L9:
        return r0;
    L7:
        return null;
    }

    public static DeviceStatus getDeviceStatus(Context r3) {
        if (BDLocationConfig.isUploadMccAndSystemRegionInfo() == false) goto L8;
        DeviceStatus r0 = new DeviceStatus();
        r0.deviceType = 2;
        r0.mccmnc = getSimOperator(r3);
        Locale r1 = BDLocationConfig.getLocale();
        if (r1 != null) goto L7;
        r1 = Locale.getDefault();
    L7:
        r0.language = r1.getLanguage();
        r0.region = r1.getCountry();
        r0.locale = r1.toString();
        r0.permission = PermissionManager.checkLocationPermissions(r3);
        r0.restrictedMode = BDLocationConfig.getRestrictedMode();
        r0.isStrictRestrictedMode = BDLocationConfig.isStrictRestrictedMode();
        r0.locationMode = getLocationMode(r3);
        r0.bluetoothSwitch = getbluetoothSwitch();
        r0.isWifiOpen = isWifiOpen();
        return r0;
    L8:
        return null;
    }

    @WorkerThread
    public static BdGisResult getGeocodeResult(double r1, double r3, int r5) {
        if (BDLocationConfig.isRestrictedModeOn() == false) goto L11;
        return null;
    L11:
        BdGisResult r2 = ServerApi.getGisResult(r1, r3, r5);     // Catch: Exception -> L8
        Logger.d("GisResult:" + r2);     // Catch: Exception -> L8
        return r2;
    L8:
        e = move-exception;
        Logger.i("getGeocodeResult exception:" + e.toString());
        throw new BDLocationException(BDLocationExceptionMessage.GET_GEOCODE_RESULT_ERROR, LocationInfoConst.BDLOCATION, BDLocationException.ERROR_GET_GEOCODE);
    }

    public static List<HARStatus> getHARStatusList() {
        return HARServiceUtil.getHARStatusList();
    }

    @WorkerThread
    public static BDLocation getIPResult(int r1) {
        LocationResult r2 = ServerApi.getIPResult(r1);
        if (r2 != null) goto L5;
        return null;
    L5:
        return locationResultToBDLocation(null, r2);
    }

    public static String getLanguage() {
        Locale r0 = BDLocationConfig.getLocale();
        if (r0 != null) goto L6;
        r0 = Locale.getDefault();
    L6:
        return languageTag(r0);
    }

    public static DeviceStatus getLightDeviceStatus(Context r3) {
        if (BDLocationConfig.isUploadMccAndSystemRegionInfo() == false) goto L8;
        DeviceStatus r0 = new DeviceStatus();
        r0.deviceType = 2;
        Locale r1 = BDLocationConfig.getLocale();
        if (r1 != null) goto L7;
        r1 = Locale.getDefault();
    L7:
        r0.language = r1.getLanguage();
        r0.region = r1.getCountry();
        r0.locale = r1.toString();
        r0.permission = 1;
        r0.restrictedMode = BDLocationConfig.getRestrictedMode();
        r0.locationMode = getLocationMode(r3);
        r0.bluetoothSwitch = getbluetoothSwitch();
        r0.isWifiOpen = isWifiOpen();
        return r0;
    L8:
        return null;
    }

    private static RegionInfo getLocaleRegion() {
        RegionInfo r0 = new RegionInfo();
        Locale r1 = Locale.getDefault();     // Catch: Exception -> L15
        String r2 = r1.getCountry();     // Catch: Exception -> L15
        String r3 = r1.getLanguage();     // Catch: Exception -> L15
        String r4 = r1.toString();     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r2) == true) goto L8;
        if (TextUtils.isEmpty(r3) == true) goto L8;
    L13:
        r0.locale = r4;     // Catch: Exception -> L15
        r0.systemRegion = r2;     // Catch: Exception -> L15
        r0.systemLanguage = r3;     // Catch: Exception -> L15
    L17:
        return r0;
    L8:
        if (Build.VERSION.SDK_INT < 24) goto L10;
        Locale r5 = Resources.getSystem().getConfiguration().getLocales().get(0);     // Catch: Exception -> L15
    L11:
        if (r5 == null) goto L13;
        r2 = r5.getCountry();     // Catch: Exception -> L15
        r3 = r5.getLanguage();     // Catch: Exception -> L15
        r4 = r3 + "_" + r2;     // Catch: Exception -> L15
        goto L13
    L10:
        r5 = Resources.getSystem().getConfiguration().locale;     // Catch: Exception -> L15
    L15:
        e = move-exception;
        Logger.i("getLocal error" + e.toString());
        goto L17
    }

    public static void getLocationInfo(BDLocation r9, final LocationUploadExtra r10, final LocationUploadCallback r11) {
        if (r10 == null) goto L4;
        Object r0 = r10.getBpeaCert();
    L5:
        final DeviceStatus r6 = getDeviceStatus(BDLocationConfig.getContext());
        final DeviceLocation r5 = getDeviceLocation(r9, r0);
        if (BDLocationConfig.isMockEnable() == true) goto L8;
        final long r3 = System.currentTimeMillis();
        WifiUtil.getWifiInfoJsonAsync(BDLocationConfig.getContext(), new AnonymousClass1(r3, r5, r6, r10, r11), r0);
        return;
    L8:
        if (TextUtils.isEmpty(BDLocationConfig.getMockWifiName()) == true) goto L10;
        r5.wifiInfo = WifiUtil.getMockWifiJson();
    L10:
        startLocation(r5, r6, r10, r11);
        return;
    L4:
        r0 = null;
        goto L5
    }

    public static int getLocationMode(Context r4) {
    L26:
        th = move-exception;
        Logger.i("LocationUtil getLocationMode exception:" + th.getMessage());
    L28:
        return 0;
    L4:
        if (isLocationEnabled() == true) goto L6;
        return 1;
    L6:
        LocationManager r1 = (LocationManager) r4.getSystemService(LocationMonitorConst.LOCATION);     // Catch: Throwable -> L26
        if (r1 == null) goto L28;
        List<String> r2 = r1.getProviders(true);     // Catch: Throwable -> L26
        if (r2 == null) goto L28;
        if (r2.isEmpty() == true) goto L28;
        if (r1.isProviderEnabled("gps") == false) goto L15;
        int r3 = 2;
    L17:
        if (r1.isProviderEnabled("network") == false) goto L20;
        r3 = r3 | 4;     // Catch: Throwable -> L26
    L20:
        if (r1.isProviderEnabled("passive") == false) goto L22;
        r3 = r3 | 8;     // Catch: Throwable -> L26
    L22:
        if (PermissionManager.isApproximateLocation(r4) == true) goto L25;
        return r3;
    L25:
        return r3 | 32;
    L15:
        r3 = 0;
        goto L17
    }

    public static int getMaxHARStatus() {
        return HARServiceUtil.getMaxHARStatus();
    }

    public static String getNetworkOperator(Context r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        TelephonyManager r3 = (TelephonyManager) r2.getSystemService("phone");
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.getNetworkOperator();
    }

    public static RegionInfo getRegionInfo(Context r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if (BDLocationConfig.isUploadMccAndSystemRegionInfo() == false) goto L9;
        RegionInfo r0 = getLocaleRegion();
        String r1 = getSimOperator(r2);
        r0.carrierRegion = r1;
        r0.networkSimRegion = r1;
        r0.mccmnc = getNetworkOperator(r2);
        return r0;
    L9:
        return null;
    }

    @Nullable
    public static String getSimOperator(Context r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        TelephonyManager r4 = (TelephonyManager) r3.getSystemService("phone");
        if (r4 != null) goto L9;
        return null;
    L9:
        if (r4.getSimState() == 5) goto L11;
        return null;
    L11:
        return r4.getSimOperator();
    }

    public static int getTargetSdkVersion() {
        if (BDLocationConfig.getContext() != null) goto L5;
        return Integer.MAX_VALUE;
    L5:
        if (BDLocationConfig.getContext().getApplicationInfo() != null) goto L7;
        return Integer.MAX_VALUE;
    L7:
        return BDLocationConfig.getContext().getApplicationInfo().targetSdkVersion;
    }

    private static boolean getbluetoothSwitch() {
        BluetoothAdapter r0 = BluetoothAdapter.getDefaultAdapter();     // Catch: Exception -> L6
        if (r0 == null) goto L12;
        return r0.isEnabled();
    L12:
        return false;
    L6:
        e = move-exception;
        Logger.i("getbluetoothSwitch exception:" + e.toString());
        return false;
    }

    private static BDLocation interceptLatLon(BDLocation r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        Logger.i("regularizationLatLon interceptLatLon");
        if (BDLocationConfig.getLatlngPrecision() < 0) goto L8;
        r5.setLatitude(new BigDecimal(r5.getLatitude()).setScale(BDLocationConfig.getLatlngPrecision(), 1).doubleValue());
        r5.setLongitude(new BigDecimal(r5.getLongitude()).setScale(BDLocationConfig.getLatlngPrecision(), 1).doubleValue());
        Logger.i("regularizationLatLon interceptLatLon success");
    L8:
        return r5;
    }

    public static boolean isBetterLocation(Location r8, Location r9) {
        if (r8 != null) goto L6;
        return false;
    L6:
        if (r9 != null) goto L9;
        return true;
    L9:
        if (BDLocationConfig.isUseNewCacheStrategy() == true) goto L11;
        long r2 = r8.getTime() - r9.getTime();     // Catch: Exception -> L50
        if (r2 <= 120000) goto L15;
        boolean r4 = true;
    L17:
        if (r2 >= (-120000)) goto L19;
        boolean r5 = true;
    L21:
        if (r2 <= 0) goto L23;
        boolean r3 = true;
    L24:
        if (r4 == false) goto L26;
        return true;
    L26:
        if (r5 == false) goto L29;
        Logger.i("CheckNewLocation isSignificantlyOlder");     // Catch: Exception -> L50
        return false;
    L29:
        int r6 = (int) (r8.getAccuracy() - r9.getAccuracy());     // Catch: Exception -> L50
        if (r6 <= 0) goto L32;
        boolean r7 = true;
    L33:
        if (r6 >= 0) goto L35;
        boolean r10 = true;
    L37:
        if (r6 <= 200) goto L39;
        boolean r11 = true;
    L40:
        boolean r12 = isSameProvider(r8.getProvider(), r9.getProvider());     // Catch: Exception -> L50
        if (r10 == false) goto L43;
        return true;
    L43:
        if (r3 == false) goto L46;
        if (r7 == true) goto L46;
        return true;
    L46:
        if (r3 == false) goto L52;
        if (r11 == true) goto L52;
        if (r12 == false) goto L52;
        return true;
    L52:
        return false;
    L39:
        r11 = false;
        goto L40
    L35:
        r10 = false;
        goto L37
    L32:
        r7 = false;
        goto L33
    L23:
        r3 = false;
        goto L24
    L19:
        r5 = false;
        goto L21
    L15:
        r4 = false;
    L50:
        e = move-exception;
        Logger.i(e.getMessage());
        goto L52
    L11:
        return newIsBetterLocation(r8, r9);
    }

    @WorkerThread
    public static boolean isChineseChannel(double r2, double r4) {
        ILocate r0 = BDLocationExtrasService.getLocate(BDLocationConfig.getContext(), 1);
        if (r0 != null) goto L5;
        return true;
    L5:
        return r0.isAMapDataAvailable(r2, r4);
    }

    public static boolean isChineseRegion(BDLocation r6) {
        if (BDLocationConfig.needDownGradeLocationInOverseas() == true) goto L6;
        Logger.i("needDownGradeLocationInOverseas:" + BDLocationConfig.needDownGradeLocationInOverseas());
        return true;
    L6:
        if (r6 != null) goto L8;
        r6 = LocationCache.getInstance().getLocationCache().getLatestLocation();
    L8:
        boolean r0 = BDLocationConfig.isRegionInChineseChannel();
        if (BDLocationConfig.useGpsCheckRegion() == false) goto L16;
        if (r6 == null) goto L16;
        boolean r7 = isChineseChannel(r6.getLatitude(), r6.getLongitude());
        Logger.i("region check isGpsChineseChannel:" + r7);
        LocationMonitor.gpsCheckRegion(r7, r0);
        if (r7 == true) goto L15;
        return false;
    L15:
        return true;
    L16:
        Logger.i("region check isRegionInChineseChannel:" + r0);
        return r0;
    }

    public static boolean isEmpty(Location r0) {
        if (r0 != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isEnableLocationService(Context r1) {
        if (isGpsProviderEnabled(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (isNetworkProviderEnabled(r1) == true) goto L8;
        return false;
    }

    public static boolean isGoodLocation(BDLocation r5) {
        if (r5 != null) goto L23;
        return false;
    L23:
        long r1 = Calendar.getInstance().getTimeInMillis();     // Catch: Exception -> L20
        if (BDLocationConfig.isUseNewCacheStrategy() == true) goto L12;
        if ((r1 - r5.getTime()) < 30000) goto L12;
        Logger.i("CheckNewLocation not goodLocation");     // Catch: Exception -> L20
        return false;
    L12:
        if (r5.getAccuracy() <= 500.0f) goto L16;
        return false;
    L16:
        if (r5.getLocationType() != 3) goto L18;
        return false;
    L18:
        return true;
    L20:
        e = move-exception;
        Logger.i(e.getMessage());
        return false;
    }

    public static boolean isGpsProviderEnabled(Context r2) {
        LocationManager r3 = (LocationManager) r2.getSystemService(LocationMonitorConst.LOCATION);
        if (r3 == null) goto L12;
        return r3.isProviderEnabled("gps");
    L6:
        e = move-exception;
        Logger.i("isProviderEnabled error:" + e.toString());
        return false;
    L12:
        return false;
    }

    public static boolean isLocationEnabled() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 28) goto L10;
        return ((LocationManager) BDLocationConfig.getContext().getSystemService(LocationMonitorConst.LOCATION)).isLocationEnabled();
    L6:
        e = move-exception;
        Logger.e("location enable status error", e.getMessage());
        return false;
    L10:
        if (r0 < 19) goto L19;
        if (Settings.Secure.getInt(BDLocationConfig.getContext().getContentResolver(), LocationMonitorConst.LOCATION_MODE) != 0) goto L14;
        return false;
    L14:
        return true;
    L15:
        e = move-exception;
        e.printStackTrace();
        return false;
    L19:
        return !TextUtils.isEmpty(Settings.Secure.getString(BDLocationConfig.getContext().getContentResolver(), "location_providers_allowed"));
    }

    public static boolean isMainThread() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isNeedAddress(LocationOption r0) {
        if (r0 != null) goto L4;
        return true;
    L4:
        if (r0.getGeocodeMode() != 0) goto L9;
        return false;
    L9:
        return true;
    }

    public static boolean isNetworkProviderEnabled(Context r1) {
        LocationManager r2 = (LocationManager) r1.getSystemService(LocationMonitorConst.LOCATION);
        if (r2 != null) goto L5;
        return false;
    L5:
        return r2.isProviderEnabled("network");
    }

    public static boolean isProxy() {
        if (BDLocationConfig.getContext() != null) goto L7;
        return false;
    L7:
        return NetworkUtil.isWifiProxy(BDLocationConfig.getContext());
    }

    private static boolean isRegionInChineseChannel(String r1) {
        if (BDLocationConfig.getRedGeoNameIds().contains(r1) == false) goto L6;
        return true;
    L6:
        return false;
    }

    private static boolean isSameProvider(String r0, String r1) {
        if (r0 != null) goto L8;
        if (r1 != null) goto L5;
        return true;
    L5:
        return false;
    L8:
        return r0.equals(r1);
    }

    public static boolean isWifiOpen() {
        WifiManager r0 = (WifiManager) BDLocationConfig.getContext().getApplicationContext().getSystemService("wifi");     // Catch: Exception -> L6
        if (r0 == null) goto L12;
        return r0.isWifiEnabled();
    L12:
        return false;
    L6:
        e = move-exception;
        Logger.i("isWifiOpen exception:" + e.toString());
        return false;
    }

    public static String languageTag(Locale r2) {
        if (r2 != null) goto L5;
        return "";
    L5:
        String r0 = r2.getLanguage();
        String r3 = r2.getCountry();
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return r0;
    L8:
        return r0 + "-" + r3;
    }

    private static int locationEqual(BDLocation r9, BDLocation r10) {
        LocationResult r0 = r9.getLocationResult();
        LocationResult r1 = r10.getLocationResult();
        if (r0 == null) goto L45;
        if (r1 == null) goto L47;
        PlaceInfo r2 = r0.country;
        if (r2 == null) goto L13;
        PlaceInfo r4 = r1.country;
        if (r4 == null) goto L13;
        if (r2.geoNameID == r4.geoNameID) goto L13;
        return 0;
    L13:
        PlaceInfo[] r3 = r0.subdivisions;
        PlaceInfo[] r5 = r1.subdivisions;
        if (r3 == null) goto L27;
        if (r5 == null) goto L27;
        if (r3.length <= 0) goto L27;
        if (r5.length <= 0) goto L27;
        PlaceInfo r6 = r3[0];
        PlaceInfo r7 = r5[0];
        if (r6 == null) goto L27;
        if (r7 == null) goto L27;
        if (r6.geoNameID == r7.geoNameID) goto L27;
        return 1;
    L27:
        PlaceInfo r8 = r0.city;
        if (r8 == null) goto L35;
        PlaceInfo r11 = r1.city;
        if (r11 == null) goto L35;
        if (r8.geoNameID == r11.geoNameID) goto L35;
        return 2;
    L35:
        PlaceInfo r12 = r0.district;
        if (r12 == null) goto L44;
        PlaceInfo r13 = r1.district;
        if (r13 == null) goto L44;
        if (r12.geoNameID == r13.geoNameID) goto L44;
        return 3;
    L44:
        return locationNameEqual(r9, r10);
    L47:
        return -1;
    L45:
        return -1;
    }

    private static int locationNameEqual(BDLocation r2, BDLocation r3) {
        if (k.b(r2.getCountry(), r3.getCountry()) == true) goto L11;
        if (TextUtils.isEmpty(r2.getCountry()) == true) goto L11;
        if (TextUtils.isEmpty(r3.getCountry()) == true) goto L11;
        return 0;
    L11:
        if (k.b(r2.getAdministrativeArea(), r3.getAdministrativeArea()) == true) goto L19;
        if (TextUtils.isEmpty(r2.getAdministrativeArea()) == true) goto L19;
        if (TextUtils.isEmpty(r3.getAdministrativeArea()) == true) goto L19;
        return 1;
    L19:
        if (k.b(r2.getCity(), r3.getCity()) == true) goto L27;
        if (TextUtils.isEmpty(r2.getCity()) == true) goto L27;
        if (TextUtils.isEmpty(r3.getCity()) == true) goto L27;
        return 2;
    L27:
        if (k.b(r2.getDistrict(), r3.getDistrict()) == true) goto L35;
        if (TextUtils.isEmpty(r2.getDistrict()) == true) goto L35;
        if (TextUtils.isEmpty(r3.getDistrict()) == true) goto L35;
        return 3;
    L35:
        if (k.b(r2.getSubAdministrativeArea(), r3.getSubAdministrativeArea()) == false) goto L37;
        return -1;
    L37:
        if (TextUtils.isEmpty(r2.getSubAdministrativeArea()) == false) goto L39;
        return -1;
    L39:
        if (TextUtils.isEmpty(r3.getSubAdministrativeArea()) == true) goto L45;
        return 4;
    L45:
        return -1;
    }

    @SuppressLint({"WrongConstant"})
    public static BDLocation locationResultToBDLocation(BDLocation r12, @Nullable LocationResult r13) {
        if (r13 != null) goto L5;
        return null;
    L5:
        if (r12 != null) goto L7;
        BDLocation r14 = new BDLocation("bd_geocode", "unKnown");
        r14.setGeocodeSDKName(SystemBaseLocationImpl.LBS_GEOCODE_NAME);
    L8:
        PlaceInfo r0 = r13.country;
        if (r0 == null) goto L11;
        r14.setCountry(r0.name);
        r14.setCountryCode(r0.code);
        r14.setCountryId(r0.geoNameID);
        r14.setCountryAsciName(r0.asciName);
        r14.setCountryLocalID(r0.localID);
    L11:
        Place r1 = r13.place;
        if (r1 != null) goto L14;
    L16:
        PlaceInfo[] r3 = r13.subdivisions;
        if (r3 == null) goto L22;
        if (r3.length <= 0) goto L22;
        r14.setAdministrativeArea(r3[0].name);
        r14.setSubdivisionId(r3[0].geoNameID);
        r14.setSubdivisionAsciName(r3[0].asciName);
    L22:
        if (r3 != null) goto L24;
    L26:
        PlaceInfo r4 = r13.city;
        if (r4 == null) goto L29;
        r14.setCity(r4.name);
        r14.setLocalID(r4.localID);
        r14.setGeoNameID(String.valueOf(r4.geoNameID));
        r14.setCityId(r4.geoNameID);
        r14.setCityAsciName(r4.asciName);
    L29:
        PlaceInfo r5 = r13.district;
        if (r5 == null) goto L32;
        r14.setDistrict(r5.name);
        r14.setDistrictId(r5.geoNameID);
        r14.setDistrictAsciName(r5.asciName);
        r14.setDistrictLocalID(r5.localID);
    L32:
        RuralInfo r6 = r13.town;
        if (r6 == null) goto L35;
        r14.setTown(r6.name);
        r14.setTownId(r6.geoNameID);
        r14.setTownAsciName(r6.asciName);
    L35:
        RuralInfo r7 = r13.village;
        if (r7 == null) goto L38;
        r14.setVillage(r7.name);
        r14.setVillageId(r7.geoNameID);
        r14.setVillageAsciName(r7.asciName);
    L38:
        GPSResult r8 = r13.gps;
        if (r8 == null) goto L46;
        double r9 = r8.latitude;
        if (r9 != 0.0d) goto L43;
    L45:
        r14.setLocationType(r8.locateType);
        goto L46
    L43:
        if (r9 == 0.0d) goto L45;
        r14.setLatitude(r9);
        r14.setLongitude(r8.longitude);
        r14.setCoordinateSystem(r8.coordinateSystem);
    L46:
        List<PoiInfoEntity> r10 = r13.poiList;
        if (r10 == null) goto L49;
        Collections.sort(r10);
        r14.setPoiEntities(r13.poiList);
    L49:
        List<PoiInfoEntity> r11 = r13.aoiList;
        if (r11 == null) goto L53;
        Collections.sort(r11);
        r14.setAoiEntities(r13.aoiList);
    L53:
        if (r13.isDisputed == false) goto L60;
        if (r0 != null) goto L60;
        if (r3 != null) goto L60;
        if (r4 != null) goto L60;
        if (r5 != null) goto L60;
        if (r1 != null) goto L60;
        r14 = new BDLocation("", "");
    L60:
        r14.setIsDisputed(r13.isDisputed);
        r14.setIsCompliance(true);
        r14.setLocationResult(r13);
        if (TextUtils.isEmpty(r13.timestamp) == true) goto L63;
        r14.setTime(Long.valueOf(r13.timestamp).longValue() * 1000);
    L63:
        m r15 = r13.extra;
        if (r15 == null) goto L66;
        r14.setExtra(r15.toString());
    L66:
        return r14;
    L24:
        if (r3.length <= 1) goto L26;
        r14.setSubAdministrativeArea(r3[1].name);
        goto L26
    L14:
        if (CollectionUtil.isEmpty(r1.addressLines) == true) goto L16;
        r14.setAddress(r1.addressLines.get(0));
        goto L16
    L7:
        r14 = new BDLocation(r12);
        goto L8
    }

    public static BDAddress locationToAddress2(BDLocation r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        BDAddress r0 = new BDAddress(Locale.getDefault());
        r0.setSpeed(r3.getSpeed());
        r0.setAccuracy(r3.getAccuracy());
        r0.setAltitude(r3.getAltitude());
        r0.setLatitude(r3.getLatitude());
        r0.setLongitude(r3.getLongitude());
        r0.setAdminArea(r3.getAdministrativeArea());
        r0.setSubAdminArea(r3.getSubAdministrativeArea());
        r0.setCountryName(r3.getCountry());
        r0.setLocality(r3.getCity());
        r0.setSubLocality(r3.getDistrict());
        r0.setAddressLine(0, r3.getAddress());
        return r0;
    }

    public static boolean needLocate() {
        return PermissionManager.hasLocationPermissions(BDLocationConfig.getContext());
    }

    public static boolean needUpload(BDLocation r2) {
        if (r2 != null) goto L4;
        return false;
    L4:
        if (LocationInfoConst.BYTE.equals(r2.getLocationSDKName()) == true) goto L6;
    L7:
        return true;
    L6:
        if (1 == r2.getLocationType()) goto L7;
        return false;
    }

    public static boolean newIsBetterLocation(Location r8, Location r9) {
        long r1 = r8.getTime() - r9.getTime();     // Catch: Exception -> L37
        if (r1 <= 120000) goto L6;
        boolean r3 = true;
    L8:
        if (r1 <= 0) goto L10;
        boolean r2 = true;
    L11:
        if (r1 >= 0) goto L13;
        boolean r4 = true;
    L14:
        if (r3 == false) goto L16;
        return true;
    L16:
        int r5 = (int) (r8.getAccuracy() - r9.getAccuracy());     // Catch: Exception -> L37
        if (r5 <= 0) goto L19;
        boolean r6 = true;
    L20:
        if (r5 >= 0) goto L22;
        boolean r7 = true;
    L24:
        if (r5 <= 200) goto L26;
        boolean r10 = true;
    L27:
        boolean r11 = isSameProvider(r8.getProvider(), r9.getProvider());     // Catch: Exception -> L37
        if (r7 == false) goto L30;
        return true;
    L30:
        if (r4 == true) goto L33;
        if (r6 == true) goto L33;
        return true;
    L33:
        if (r2 == false) goto L39;
        if (r10 == true) goto L39;
        if (r11 == false) goto L39;
        return true;
    L39:
        return false;
    L26:
        r10 = false;
        goto L27
    L22:
        r7 = false;
        goto L24
    L19:
        r6 = false;
        goto L20
    L13:
        r4 = false;
        goto L14
    L10:
        r2 = false;
        goto L11
    L6:
        r3 = false;
    L37:
        e = move-exception;
        Logger.i(e.getMessage());
        goto L39
    }

    public static LocInfoRspData parseInfoRsp(LocationResp r3) {
        if (r3 != null) goto L5;
    L14:
        StringBuilder r1 = new StringBuilder();
        r1.append("LocationUtil parseInfoRsp error:");
        if (r3 != null) goto L17;
        String r4 = "";
    L12:
        r1.append(r4);
        Logger.i(r1.toString());
        return null;
    L17:
        r4 = r3.toString();
        goto L12
    L5:
        if (r3.resultCode != 0) goto L14;
        String r5 = r3.data;
        return (LocInfoRspData) JsonUtil.sGson.m(ServerApi.unpackFingerprint(r5), LocInfoRspData.class);
    L10:
        e = move-exception;
        r1 = new StringBuilder();
        r1.append("parseLocInfoRsp exception:");
        r4 = e.toString();
        goto L12
    }

    public static LocInfoRspData parseLocInfoRsp(LocationResp r4) {
        if (r4 != null) goto L5;
    L18:
        StringBuilder r1 = new StringBuilder();
        r1.append("LocationUtil parseLocInfoRsp error:");
        if (r4 != null) goto L21;
        String r5 = "";
    L16:
        r1.append(r5);
        Logger.i(r1.toString());
        return null;
    L21:
        r5 = r4.toString();
        goto L16
    L5:
        if (r4.resultCode != 0) goto L18;
        String r2 = r4.data;
        LocInfoRspData r3 = (LocInfoRspData) JsonUtil.sGson.m(ServerApi.unpackFingerprint(r2), LocInfoRspData.class);     // Catch: Exception -> L14
        if (r3 != null) goto L11;
    L13:
        return r3;
    L11:
        if (TextUtils.isEmpty(r4.submitLogId) == true) goto L13;
        r3.submitLogId = r4.submitLogId;     // Catch: Exception -> L14
    L14:
        e = move-exception;
        r1 = new StringBuilder();
        r1.append("parseLocInfoRsp exception:");
        r5 = e.toString();
        goto L16
    }

    public static void startGetLocate(final LocationUploadExtra r3, final LocationUploadCallback r4) {
        if (BDLocationConfig.isUpload() == true) goto L5;
    L7:
        r4.onError(new BDLocationException(BDLocationExceptionMessage.NON_ALLOWED_UPLOAD, LocationInfoConst.BYTE, BDLocationException.ERROR_LOCATION_UPLOAD).getMessage());
        return;
    L5:
        if (BDLocationConfig.isRestrictedModeOn() == true) goto L7;
        AppExecutors.getInstance().networkIO().execute(new b(r3, r4));
    }

    public static void startLightLocationUpload(LocationUploadExtra r7, Object r8, LightLocationCallback r9) {
    L13:
        e = move-exception;
        Logger.e("startLocateUpload", e);
        if (r9 == null) goto L21;
        r9.onError(BDLocationException.ERROR_LIGHT_LOCATION_UPLOAD_EXCEPTION, e.getMessage());
        return;
    L21:
        return;
    L4:
        if (allowUploadLocationInfo() == false) goto L11;
        long r2 = System.currentTimeMillis();     // Catch: Exception -> L13
        DeviceStatus r0 = getLightDeviceStatus(BDLocationConfig.getContext());     // Catch: Exception -> L13
        Logger.i("getLightDeviceStatusTime:" + (System.currentTimeMillis() - r2));     // Catch: Exception -> L13
        long r3 = System.currentTimeMillis();     // Catch: Exception -> L13
        DeviceLocation r4 = new DeviceLocation();     // Catch: Exception -> L13
        r4.baseLocation = getCurrentStation(BDLocationConfig.getContext(), r8);     // Catch: Exception -> L13
        r7.setCurrentStationDuration(System.currentTimeMillis() - r3);     // Catch: Exception -> L13
        if (r4.baseLocation != null) goto L10;
        if (r9 == null) goto L19;
        r9.onError(BDLocationException.ERROR_LIGHT_LOCATION_GET_CURRENT_STATION, "get current cell info error");     // Catch: Exception -> L13
        return;
    L19:
        return;
    L10:
        r9.onSuccess(ServerApi.uploadLightLocation(r4, r0, r7), r7);     // Catch: Exception -> L13
        return;
    L11:
        r9.onError(BDLocationException.ERROR_LIGHT_LOCATION_UPLOAD_LOCATION_INFO, "get current cell info error");     // Catch: Exception -> L13
    }

    public static void startLocateUpload(final BDLocation r2, final LocationUploadExtra r3, final LocationUploadCallback r4) {
        if (BDLocationConfig.isUpload() == true) goto L5;
    L7:
        r4.onError(new BDLocationException(BDLocationExceptionMessage.NON_ALLOWED_UPLOAD, r2.getLocationSDKName(), BDLocationException.ERROR_LOCATION_UPLOAD).getMessage());
        return;
    L5:
        if (BDLocationConfig.isRestrictedModeOn() == true) goto L7;
        AppExecutors.getInstance().networkIO().execute(new a(r2, r3, r4));
    }

    @WorkerThread
    private static void startLocation(DeviceLocation r0, DeviceStatus r1, LocationUploadExtra r2, LocationUploadCallback r3) {
        LocationResp r4 = ServerApi.uploadLocationInfo(r0, r1, r2);
        StringBuilder r5 = new StringBuilder();
        r5.append("LocationUtil startLocation locationResp:");
        if (r4 != null) goto L5;
        boolean r6 = true;
    L6:
        r5.append(r6);
        Logger.i(r5.toString());
        if (r3 == null) goto L10;
        r3.onSuccess(r4);
        return;
    L10:
        return;
    L5:
        r6 = false;
        goto L6
    }

    public static int transformLocateMethod(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return 0;
    L5:
        if (r1.equals("GPSLocation") == false) goto L9;
        return 1;
    L9:
        if (r1.equals("WiFi") == false) goto L13;
        return 2;
    L13:
        if (r1.equals("bss") == false) goto L17;
        return 3;
    L17:
        if (r1.equals("IPLocation") == false) goto L21;
        return 6;
    L21:
        if (r1.equals("MCC") == false) goto L26;
        return 7;
    L26:
        return 0;
    }

    public static BDLocation transformLocationForLevel(BDLocation r1, int r2) {
        if (r2 != 4) goto L5;
        return r1;
    L5:
        BDLocation r0 = new BDLocation(r1);
        r0.setAccuracyLevel(r2);
        return r0;
    }

    private static BDLocation turnToH3LatLon(ILocationH3Core r8, BDLocation r9) {
        if (r8 == null) goto L16;
        if (r9 == null) goto L16;
        long r2 = r8.geoToH3(r9.getLatitude(), r9.getLongitude(), BDLocationConfig.getH3Resolution());     // Catch: Exception -> L14
        Logger.i("regularizationLatLon hex");     // Catch: Exception -> L14
        List<Long> r3 = r8.kRing(r2, BDLocationConfig.getH3Distance());     // Catch: Exception -> L14
        Logger.i("regularizationLatLon kRingsResult size:" + r3.size());     // Catch: Exception -> L14
        if (r3 == null) goto L16;
        if (r3.size() <= 1) goto L16;
        int r4 = new Random().nextInt(r3.size() - 1) + 1;     // Catch: Exception -> L14
        Logger.i("regularizationLatLon index:" + r4);     // Catch: Exception -> L14
        Pair<Double, Double> r10 = r8.h3ToGeo(r3.get(r4).longValue());     // Catch: Exception -> L14
        if (r10 == null) goto L16;
        Logger.i("regularizationLatLon geoCoord:" + r10);     // Catch: Exception -> L14
        r9.setLatitude(((Double) r10.first).doubleValue());     // Catch: Exception -> L14
        r9.setLongitude(((Double) r10.second).doubleValue());     // Catch: Exception -> L14
        return r9;
    L14:
        e = move-exception;
        Logger.i("regularizationLatLon geoCoord:" + e.getMessage());
    L16:
        return null;
    }

    @Nullable
    public static LocInfoRspData uploadDeviceStatus(String r2, int r3) {
        if (BDLocationConfig.isUploadMccAndSystemRegionInfo() == true) goto L5;
        return null;
    L5:
        if (BDLocationConfig.isRestrictedModeOn() == true) goto L18;
        LocInfoRspData r4 = parseInfoRsp(ServerApi.uploadMccAndSystemRegionInfo(BDLocationConfig.getContext(), r2, r3));     // Catch: Exception -> L12
        if (r4 == null) goto L11;
        RegionCountry r5 = r4.regionCountry;     // Catch: Exception -> L12
        if (r5 == null) goto L11;
        Logger.i("uploadDeviceStatus RegionCountry:" + r5.toString());     // Catch: Exception -> L12
        BDLocationConfig.setRegionInChineseChannel(isRegionInChineseChannel(r5.geoNameID));     // Catch: Exception -> L12
    L11:
        return r4;
    L12:
        Logger.d("upload device status error");
        return null;
    L18:
        return null;
    }

    public static void uploadGpsAndBleInfos(final LocationUploadExtra r2) {
        if (isMainThread() == false) goto L5;
        AppExecutors.getInstance().networkIO().execute(new AnonymousClass2(r2));
        return;
    L5:
        ServerApi.uploadGpsAndBleInfos(r2);
    }

    public static void withoutBpeaCertCheck(String r3) {
        LocationMonitor.withoutCert(r3);
        if (BDLocationConfig.isCheckLocationBpea() == true) goto L6;
        return;
    L6:
        throw new BDLocationException(BDLocationExceptionMessage.BPEA_CERT_CHECK_EXCEPTION, EnvironmentCompat.MEDIA_UNKNOWN, BDLocationException.ERROR_BPEA_WITHOUT_CERT);
    }
}
