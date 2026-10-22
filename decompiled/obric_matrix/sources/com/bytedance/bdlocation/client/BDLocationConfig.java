package com.bytedance.bdlocation.client;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.BDRestrictedMode;
import com.bytedance.bdlocation.callback.LocationNotification;
import com.bytedance.bdlocation.callback.LocationSubmitNotification;
import com.bytedance.bdlocation.entity.LogIdCacheEntity;
import com.bytedance.bdlocation.entity.bpea.BPEACertCheckResult;
import com.bytedance.bdlocation.event.IEventManager;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.network.ICustomNetworkApi;
import com.bytedance.bdlocation.scan.bluetooth.BLECacheEntity;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.settings.LocationSettingUtil;
import com.bytedance.bdlocation.store.LocationCache;
import com.bytedance.bdlocation.utils.background.BackgroundProvider;
import com.ss.ttuploader.TTVideoUploader;
import com.ttnet.org.chromium.base.TimeUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BDLocationConfig {
    private static final String DEFAULT_SLARDAR_AID = "306184";
    public static final String ENABLE_BPEA_CACHE_KEY = "enable_bpea_cache";
    private static String RESTRICTED_LOCK = null;
    public static final String TAG = "BDLocation";
    private static boolean isDebug = false;
    private static boolean isInit = false;
    private static boolean isPrivacyConfirmed = false;
    private static BLECacheEntity mBleCacheEntity = null;
    private static boolean mEnableTraceroute = false;
    private static LogIdCacheEntity mLogIdCacheEntity = null;
    private static long mOverseaUploadInterval = 0;
    private static long mOverseaUploadMaxCount = 0;
    private static long mOverseaUploadMaxDuration = 0;
    private static boolean mOverseas = false;
    private static JSONObject mShakeConfig = null;
    private static boolean sAllowFetchConfigAtStart = false;
    private static boolean sAllowLocateFallback = true;
    private static long sAppBootTime = 0;
    private static String sAppId = null;
    private static String sAppVersion = null;
    private static String sBaseUrl = null;
    private static JSONObject sBeaconConfig = null;
    private static long sBootLegitimateTime = 3000;
    private static Map<String, Object> sBpeaCerts = null;
    private static int sBssNum = 10;
    private static String sChannel = null;
    private static boolean sCheckLocationBpea = false;
    private static boolean sColdBootABTest = false;
    private static boolean sCollectLightInfo = false;
    private static Map<String, String> sCommonParams = null;

    @SuppressLint({"StaticFieldLeak", "CI_StaticFieldLeak"})
    private static Context sContext = null;
    private static String sDeviceId = null;
    private static List<String> sDisableUuidList = null;
    private static boolean sEnableBpea = false;
    private static boolean sEnableGpsScan = false;
    private static boolean sEnableH3 = false;
    private static boolean sEnableHARCollect = false;
    private static boolean sEnableLightLocation = false;
    private static Pair<String, String> sEnv = null;
    private static IEventManager sEventManager = null;
    private static boolean sFirstRequestLocation = false;
    private static long sGpsScanInterval = 0;
    private static int sH3Distance = 0;
    private static int sH3Resolution = 0;
    private static int sHARStatusRange = 0;
    private static long sInitStartTime = 0;
    private static boolean sIsChineseChannel = false;
    private static boolean sIsFirstLocation = false;
    private static boolean sIsMockEnable = false;
    private static boolean sIsMockUpload = false;
    private static boolean sIsPollingUpload = false;
    private static boolean sIsStrictRestrictedMode = false;
    private static boolean sIsUpload = true;
    private static boolean sIsUploadBaseSite = true;
    private static boolean sIsUploadGPS = true;
    private static boolean sIsUploadLocation = true;
    private static boolean sIsUploadWIFI = true;
    private static int sLatlngPrecision = 0;
    private static int sLightInfoInterval = 0;
    private static Locale sLocale = null;
    private static int sLocateType = 0;
    private static int sLocationMode = 0;
    private static int sMaxLightCount = 0;
    private static long sMaxLightDuration = 0;
    private static long sMaxLocationTimeMs = 300000;
    private static String sMockWifiName = null;
    private static boolean sNeedDownGradeLocationInOverseas = false;
    private static ICustomNetworkApi sNetworkApi = null;
    private static long sNetworkStatusChangeUploadInterval = 60000;
    private static boolean sNewNetworkChangeRegister = false;
    private static SparseArray<List<LocationNotification>> sNotifications = null;
    private static boolean sOnline = false;
    private static boolean sOpenWifiListMonitor = false;
    private static long sOverseasGetLocationFailedUseCacheValidity = 0;
    private static String sPackageName = null;
    private static BackgroundProvider sProvider = null;
    private static String sRedGeoNameIds = null;
    private static boolean sRegionInChineseChannel = false;
    private static boolean sReportAtStart = true;
    private static boolean sReportLocationAtStart = false;
    private static BDRestrictedMode sRestrictedMode = null;
    private static boolean sScanBle = false;
    private static long sScanBleInterval = 0;
    public static final long sScanBleMaxInterval = 10000;
    private static String sSdkVersion = null;
    private static String sSessionId = null;
    private static boolean sShouldRequestLocation = false;
    private static String sSlardarAid = null;
    private static List<LocationSubmitNotification> sSubmitNotifications = null;
    private static String sUpdateVersionCode = null;
    private static boolean sUploadBleImmediately = false;
    private static int sUploadBleNum = 0;
    private static long sUploadInterval = 300000;
    private static boolean sUploadMccAndSystemRegionInfo = true;
    private static boolean sUseGpsCheckRegion = false;
    private static boolean sUseNewCacheStrategy = false;
    private static int sWifiNum = 30;
    private static String sWorldView;

    static {
        sLocale = Locale.getDefault();
        sIsChineseChannel = true;
        sLocateType = 3;
        RESTRICTED_LOCK = "RESTRICTED_LOCK";
        sIsStrictRestrictedMode = false;
        sBaseUrl = "";
        sNotifications = new SparseArray();
        isPrivacyConfirmed = false;
        sOnline = true;
        mOverseas = false;
        mOverseaUploadInterval = TimeUtils.SECONDS_PER_HOUR;
        mOverseaUploadMaxDuration = TimeUtils.SECONDS_PER_DAY;
        mOverseaUploadMaxCount = 7;
        sLatlngPrecision = 2;
        sH3Resolution = 7;
        sH3Distance = 1;
        sEnableH3 = true;
        sIsMockEnable = false;
        sIsMockUpload = true;
        isInit = false;
        sSlardarAid = DEFAULT_SLARDAR_AID;
        sDeviceId = "";
        sAppId = "";
        sSdkVersion = BuildConfig.BDLOCATION_VERSION;
        sChannel = "";
        sAppVersion = "";
        sUpdateVersionCode = "";
        sPackageName = "";
        sEnableHARCollect = false;
        sHARStatusRange = 64;
        sEnableBpea = true;
        sUploadBleNum = 30;
        sScanBleInterval = 1000;
        sScanBle = false;
        sCheckLocationBpea = false;
        sLocationMode = 2;
        sSubmitNotifications = null;
        sFirstRequestLocation = true;
        sOverseasGetLocationFailedUseCacheValidity = LocationInfoConst.defaultsOverseasCacheValidity;
        sRegionInChineseChannel = true;
        sRedGeoNameIds = LocationInfoConst.defaultRedGeoNameIds;
        sIsFirstLocation = true;
        sUseNewCacheStrategy = false;
        sCollectLightInfo = false;
        sLightInfoInterval = 3;
        sMaxLightCount = 30;
        sMaxLightDuration = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
        sGpsScanInterval = 0;
        sEnableGpsScan = false;
        sColdBootABTest = false;
    }

    public BDLocationConfig() {
    }

    static /* synthetic */ void a(int r3, BDLocation r4) {
        String r0 = RESTRICTED_LOCK;
        monitor-enter(r0);
    L5:
        if (r3 >= 5) goto L13;
        List<LocationNotification> r1 = sNotifications.get(r3);     // Catch: Throwable -> L15
        if (r1 == null) goto L12;
        Iterator<LocationNotification> r2 = r1.iterator();     // Catch: Throwable -> L15
    L10:
        if (r2.hasNext() == false) goto L12;
        r2.next().onLocationChanged(r4);     // Catch: Throwable -> L15
    L12:
        r3 = r3 + 1;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
    }

    public static void addNotification(LocationNotification r5, int r6) {
        long r0 = System.currentTimeMillis();
        String r2 = RESTRICTED_LOCK;
        monitor-enter(r2);
        LocationUtil.withoutBpeaCertCheck("addNotification");     // Catch: Throwable -> L6 Exception -> L8
        switchNotification(r6).add(r5);     // Catch: Throwable -> L6 Exception -> L8
        Logger.i("addNotification interval:" + (System.currentTimeMillis() - r0));     // Catch: Throwable -> L6 Exception -> L8
    L10:
        monitor-exit(r2);     // Catch: Throwable -> L6
        return;
    L8:
        e = move-exception;
        Logger.d("addNotification change withoutBpeaCertCheck error:" + e.getMessage());     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public static void addNotification(LocationNotification r6, @Nullable Object r7) {
        long r0 = System.currentTimeMillis();
        String r2 = RESTRICTED_LOCK;     // Catch: Exception -> L19
        monitor-enter(r2);     // Catch: Exception -> L19
        LocationUtil.checkBpeaCertNull("addNotification", r7);     // Catch: Throwable -> L16
        int r3 = 0;
        if (r7 == null) goto L12;
        BPEACertCheckResult r8 = BDLocationExtrasService.getBPEAManager().checkAndTranslateCert(r7, "addNotification");     // Catch: Throwable -> L16
        if (r8 == null) goto L12;
        if (r8.getParams() == null) goto L12;
        r3 = r8.getParams().optInt("range", 0);     // Catch: Throwable -> L16
    L12:
        switchNotification(r3).add(r6);     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L16
        Logger.i("addNotification interval:" + (System.currentTimeMillis() - r0));     // Catch: Exception -> L19
        return;
    L16:
        th = move-exception;
        throw th;     // Catch: Exception -> L19
    L19:
        e = move-exception;
        Logger.d("addNotification change error:" + e.getMessage());
    }

    public static void addSubmitNotification(Object r2, LocationSubmitNotification r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r2 == null) goto L14;
        BDLocationExtrasService.getBPEAManager().checkAndTranslateCert(r2, "addSubmitNotification");     // Catch: BDLocationException -> L11
        if (sSubmitNotifications != null) goto L9;
        sSubmitNotifications = new CopyOnWriteArrayList();     // Catch: BDLocationException -> L11
    L9:
        sSubmitNotifications.add(r3);     // Catch: BDLocationException -> L11
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L14:
        if (sSubmitNotifications != null) goto L16;
        sSubmitNotifications = new CopyOnWriteArrayList();
    L16:
        sSubmitNotifications.add(r3);
    }

    public static boolean checkInit() {
        if (sContext != null) goto L5;
        return false;
    L5:
        if (isInit == false) goto L10;
        return true;
    L10:
        return false;
    }

    public static boolean enableBpea() {
        return sEnableBpea;
    }

    public static boolean enableLightLocation() {
        return sEnableLightLocation;
    }

    public static boolean enableScanBle() {
        return sScanBle;
    }

    public static boolean enableTraceroute() {
        return mEnableTraceroute;
    }

    public static boolean firstRequestLocation() {
        return sFirstRequestLocation;
    }

    public static BackgroundProvider getAppBackgroundProvider() {
        return sProvider;
    }

    public static long getAppBootTime() {
        return sAppBootTime;
    }

    public static String getAppId() {
        return sAppId;
    }

    public static String getAppVersion() {
        return sAppVersion;
    }

    public static String getBaseUrl() {
        return sBaseUrl;
    }

    public static JSONObject getBeaconConfig() {
        return sBeaconConfig;
    }

    public static BLECacheEntity getBleCacheEntity() {
        return mBleCacheEntity;
    }

    public static long getBootLegitimateTime() {
        return sBootLegitimateTime;
    }

    @Nullable
    public static Object getBpeaCert(String r1) {
        if (sBpeaCerts != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r1) == false) goto L8;
        return null;
    L8:
        return sBpeaCerts.get(r1);
    }

    public static int getBssNum() {
        return sBssNum;
    }

    public static String getChannel() {
        return sChannel;
    }

    public static Map<String, String> getCommonParams() {
        return sCommonParams;
    }

    public static Context getContext() {
        return sContext;
    }

    public static String getDeviceId() {
        return sDeviceId;
    }

    public static List<String> getDisableUuidList() {
        return sDisableUuidList;
    }

    public static Pair getEnv() {
        return sEnv;
    }

    public static IEventManager getEventManager() {
        return sEventManager;
    }

    public static long getGpsScanInterval() {
        return sGpsScanInterval;
    }

    public static int getH3Distance() {
        return sH3Distance;
    }

    public static int getH3Resolution() {
        return sH3Resolution;
    }

    public static int getHARStatusRange() {
        return sHARStatusRange;
    }

    public static long getInitStartTime() {
        return sInitStartTime;
    }

    public static int getLatlngPrecision() {
        return sLatlngPrecision;
    }

    public static int getLightInfoInterval() {
        return sLightInfoInterval;
    }

    @Nullable
    public static Locale getLocale() {
        return sLocale;
    }

    @Nullable
    public static int getLocateType() {
        return sLocateType;
    }

    public static int getLocationMode() {
        return sLocationMode;
    }

    public static LogIdCacheEntity getLogIdCacheEntity() {
        return mLogIdCacheEntity;
    }

    public static int getMaxLightCount() {
        return sMaxLightCount;
    }

    public static long getMaxLightDuration() {
        return sMaxLightDuration;
    }

    public static long getMaxLocationTimeMs() {
        return sMaxLocationTimeMs;
    }

    public static String getMockWifiName() {
        if (sMockWifiName != null) goto L6;
        sMockWifiName = LocationCache.getInstance().getMockWifiName();
    L6:
        return sMockWifiName;
    }

    public static ICustomNetworkApi getNetworkApi() {
        return sNetworkApi;
    }

    public static long getNetworkStatusChangeUploadInterval() {
        return sNetworkStatusChangeUploadInterval;
    }

    public static long getOverseaUploadInterval() {
        return mOverseaUploadInterval * 1000;
    }

    public static long getOverseaUploadMaxCount() {
        return mOverseaUploadMaxCount;
    }

    public static long getOverseaUploadMaxDuration() {
        return mOverseaUploadMaxDuration * 1000;
    }

    public static long getOverseasGetLocationFailedUseCacheValidity() {
        return sOverseasGetLocationFailedUseCacheValidity;
    }

    public static String getPackageName() {
        return sPackageName;
    }

    public static String getRedGeoNameIds() {
        return sRedGeoNameIds;
    }

    public static BDRestrictedMode getRestricted() {
        BDRestrictedMode r0 = sRestrictedMode;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0;
    }

    public static int getRestrictedMode() {
        BDRestrictedMode r0 = sRestrictedMode;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getRestrictedMode();
    }

    public static long getScanBleInterval() {
        return sScanBleInterval;
    }

    public static String getSdkVersion() {
        return sSdkVersion;
    }

    public static String getSessionId() {
        return sSessionId;
    }

    public static JSONObject getShakeConfig() {
        return mShakeConfig;
    }

    public static String getSlardarAid() {
        return sSlardarAid;
    }

    public static List<LocationSubmitNotification> getSubmitNotification() {
        return sSubmitNotifications;
    }

    public static String getUpdateVersionCode() {
        return sUpdateVersionCode;
    }

    public static int getUploadBleNum() {
        return sUploadBleNum;
    }

    public static long getUploadInterval() {
        return sUploadInterval;
    }

    public static int getWifiNum() {
        return sWifiNum;
    }

    @Nullable
    public static String getWorldView() {
        return sWorldView;
    }

    public static boolean init(Context r4) {
        if (checkInit() == false) goto L5;
        return true;
    L5:
        sInitStartTime = SystemClock.elapsedRealtime();
        sContext = r4;
        LocationSettingUtil.setLocationConfig();
        Object r5 = getBpeaCert(LocationInfoConst.INIT_CERT);
        LocationUtil.checkBpeaCertNull("locationInit", r5);
        if (r5 != null) goto L19;
    L17:
        isInit = true;
        Logger.i("config init finish");
        return true;
    L19:
        BPEACertCheckResult r6 = BDLocationExtrasService.getBPEAManager().checkAndTranslateCert(r5, "init");     // Catch: BDLocationException -> L14
        if (r6 == null) goto L17;
        if (r6.getParams() == null) goto L17;
        setConfigParam(r6.getParams());     // Catch: BDLocationException -> L14
    L14:
        e = move-exception;
        Logger.i("location init bpea check error");
        throw e;
    }

    public static boolean isAllowFetchConfigAtStart() {
        return sAllowFetchConfigAtStart;
    }

    public static boolean isAllowLocateFallback() {
        return sAllowLocateFallback;
    }

    public static boolean isBackground() {
        if (getAppBackgroundProvider() != null) goto L6;
        return true;
    L6:
        if (getAppBackgroundProvider().isBackground() == false) goto L8;
        return true;
    L8:
        return false;
    }

    public static boolean isCheckLocationBpea() {
        return sCheckLocationBpea;
    }

    public static boolean isChineseChannel() {
        return sIsChineseChannel;
    }

    public static boolean isColdBootABTest() {
        return sColdBootABTest;
    }

    public static boolean isCollectLightInfo() {
        return sCollectLightInfo;
    }

    public static boolean isDebug() {
        return isDebug;
    }

    public static boolean isEnableGpsScan() {
        return sEnableGpsScan;
    }

    public static boolean isEnableH3() {
        return sEnableH3;
    }

    public static boolean isEnableHARCollect() {
        return sEnableHARCollect;
    }

    public static boolean isFirstLocation() {
        return sIsFirstLocation;
    }

    public static boolean isMockEnable() {
        return sIsMockEnable;
    }

    public static boolean isMockUpload() {
        return sIsMockUpload;
    }

    public static boolean isNewNetworkChangeRegister() {
        return sNewNetworkChangeRegister;
    }

    public static boolean isOnline() {
        return sOnline;
    }

    public static boolean isOpenWifiListMonitor() {
        return sOpenWifiListMonitor;
    }

    public static boolean isOverSeas() {
        return mOverseas;
    }

    public static boolean isPollingUpload() {
        return sIsPollingUpload;
    }

    public static boolean isPrivacyConfirmed() {
        return isPrivacyConfirmed;
    }

    public static boolean isRegionInChineseChannel() {
        return sRegionInChineseChannel;
    }

    public static boolean isReportAtStart() {
        return sReportAtStart;
    }

    public static boolean isReportLocationAtStart() {
        return sReportLocationAtStart;
    }

    public static boolean isRestrictedModeOn() {
        BDRestrictedMode r0 = sRestrictedMode;
        if (r0 != null) goto L5;
        return false;
    L5:
        int r1 = r0.getRestrictedMode();
        Logger.i("BDLocationConfig restrictedMode:" + r1);
        if (r1 == 1) goto L8;
        return false;
    L8:
        return true;
    }

    public static boolean isStrictRestrictedMode() {
        return sIsStrictRestrictedMode;
    }

    public static boolean isUpload() {
        return sIsUpload;
    }

    public static boolean isUploadBaseSite() {
        return sIsUploadBaseSite;
    }

    public static boolean isUploadBleImmediately() {
        return sUploadBleImmediately;
    }

    public static boolean isUploadGPS() {
        return sIsUploadGPS;
    }

    public static boolean isUploadLocation() {
        return sIsUploadLocation;
    }

    public static boolean isUploadMccAndSystemRegionInfo() {
        return sUploadMccAndSystemRegionInfo;
    }

    public static boolean isUploadWIFI() {
        return sIsUploadWIFI;
    }

    public static boolean isUseNewCacheStrategy() {
        return sUseNewCacheStrategy;
    }

    public static boolean needDownGradeLocationInOverseas() {
        return sNeedDownGradeLocationInOverseas;
    }

    public static void notificationLocationChange(final int r3, BDLocation r4) {
        final BDLocation r0 = new BDLocation(r4);
        r0.setLongitude(0.0d);
        r0.setLatitude(0.0d);
        r0.setAltitude(0.0d);
        if (r0.getLocationResult() == null) goto L5;
        r0.getLocationResult().gps = null;
    L5:
        new Handler(Looper.getMainLooper()).post(new a(r3, r0));
    }

    public static void removeNotification(LocationNotification r1, int r2) {
        String r0 = RESTRICTED_LOCK;
        monitor-enter(r0);
        switchNotification(r2).remove(r1);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void removeSubmitNotification(LocationSubmitNotification r2) {
        List<LocationSubmitNotification> r0 = sSubmitNotifications;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() < 1) goto L11;
        if (r2 == null) goto L12;
        sSubmitNotifications.remove(r2);
        return;
    L12:
        return;
    }

    public static void setAllowFetchConfigAtStart(boolean r0) {
        sAllowFetchConfigAtStart = r0;
    }

    public static void setAllowLocateFallback(boolean r0) {
        sAllowLocateFallback = r0;
    }

    public static void setAppBackgroundProvider(BackgroundProvider r3) {
        StringBuilder r0 = new StringBuilder();
        r0.append("setAppBackgroundProvider provider:");
        if (r3 != null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        Logger.i(r0.toString());
        BackgroundProvider r2 = sProvider;
        List<BackgroundProvider.Callback> r4 = null;
        if (r2 == null) goto L9;
        List<BackgroundProvider.Callback> r5 = r2.getCallback();
        sProvider.setCallback(null);
        r4 = r5;
    L9:
        sProvider = r3;
        if (r4 == null) goto L14;
        if (r3 == null) goto L15;
        r3.setCallback(r4);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public static void setAppBootTime(long r0) {
        sAppBootTime = r0;
    }

    public static void setAppId(String r0) {
        sAppId = r0;
    }

    public static void setAppVersion(String r0) {
        sAppVersion = r0;
    }

    public static void setBaseUrl(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L14:
        sBaseUrl = r2;
        return;
    L5:
        if (r2.contains(LocationInfoConst.HTTPS) == true) goto L14;
        if (isDebug() == false) goto L9;
    L13:
        Logger.e("当前定位接口非https加密，使用明文信息违反合规要求，请修改为https");
        goto L14
    L9:
        if (isOnline() == false) goto L13;
        throw new IllegalArgumentException("当前定位接口非https加密，使用明文信息违反合规要求，请修改为https");
    }

    public static void setBeaconConfig(JSONObject r0) {
        sBeaconConfig = r0;
    }

    public static void setBleCacheEntity(BLECacheEntity r0) {
        mBleCacheEntity = r0;
    }

    public static void setBootLegitimateTime(long r0) {
        sBootLegitimateTime = r0;
    }

    public static void setBpeaCerts(Map<String, Object> r0) {
        sBpeaCerts = r0;
    }

    public static void setBssNum(int r0) {
        sBssNum = r0;
    }

    public static void setChannel(String r0) {
        sChannel = r0;
    }

    public static void setCheckLocationBpea(boolean r0) {
        sCheckLocationBpea = r0;
    }

    public static void setChineseChannel(boolean r0) {
        sIsChineseChannel = r0;
    }

    public static void setColdBootABTest(boolean r0) {
        sColdBootABTest = r0;
    }

    public static void setCollectLightInfo(boolean r0) {
        sCollectLightInfo = r0;
    }

    public static void setCommonParams(Map<String, String> r0) {
        sCommonParams = r0;
    }

    public static void setConfigParam(JSONObject r6) {
        Logger.d("BDLocation", "init config params are " + r6.toString());
        setIsUploadGPS(r6.optBoolean("report_gps", true));
        int r0 = r6.optInt("report_bss_max", 10);
        if (r0 <= 0) goto L5;
        setUploadBaseSite(true);
        setBssNum(r0);
    L6:
        setReportAtStart(r6.optBoolean("report_at_start", false));
        setReportLocationAtStart(r6.optBoolean("report_location_at_start", false));
        setUpload(r6.optBoolean("is_upload", true));
        setUploadLocation(r6.optBoolean("is_upload_location", true));
        setChineseChannel(r6.optBoolean("chinese_channel", true));
        int r1 = r6.optInt("location_update_interval", TTVideoUploader.KeyIsGetTosKey);
        int r3 = r6.optInt("report_interval_seconds", TTVideoUploader.KeyIsGetTosKey);
        if (r3 <= 0) goto L9;
        long r4 = r3 * 1000;
    L10:
        setUploadInterval(r4);
        setDebug(r6.optBoolean("debug_able", false));
        setAllowLocateFallback(r6.optBoolean("allow_locate_fallback", true));
        JSONArray r2 = r6.optJSONArray("error_code_list_for_fallback");
        ArrayList r5 = new ArrayList();
        if (r2 == null) goto L16;
        int r7 = 0;
    L14:
        if (r7 >= r2.length()) goto L16;
        r5.add(Integer.valueOf(r2.optInt(r7, 0)));
        r7 = r7 + 1;
    L16:
        setAllowFetchConfigAtStart(r6.optBoolean("allow_fetch_config_at_start", true));
        setPollingUpload(r6.optBoolean("polling_upload", true));
        setMaxLocationTimeMs(r6.optLong("max_location_time_ms", 300000));
        setLocateType(r6.optInt(LocationMonitorConst.LOCATE_TYPE, 3));
        return;
    L9:
        r4 = r1 * 1000;
        goto L10
    L5:
        setUploadBaseSite(false);
        goto L6
    }

    public static void setContext(Context r0) {
        sContext = r0;
    }

    public static void setDebug(boolean r0) {
        isDebug = r0;
    }

    public static void setDeviceId(String r0) {
        sDeviceId = r0;
    }

    public static void setDisableUuidList(List<String> r0) {
        sDisableUuidList = r0;
    }

    @VisibleForTesting
    public static void setEnableBpea(boolean r2) {
        sEnableBpea = r2;
        if (getContext() == null) goto L6;
        LocationCache.getInstance().setBooleanValue(ENABLE_BPEA_CACHE_KEY, r2);
        return;
    }

    public static void setEnableGpsScan(boolean r0) {
        sEnableGpsScan = r0;
    }

    public static void setEnableH3(boolean r0) {
        sEnableH3 = r0;
    }

    public static void setEnableHARCollect(boolean r0) {
        sEnableHARCollect = r0;
    }

    public static void setEnableLightLocation(boolean r0) {
        sEnableLightLocation = r0;
    }

    public static void setEnableScanBle(boolean r0) {
        sScanBle = r0;
    }

    public static void setEnableTraceroute(boolean r0) {
        mEnableTraceroute = r0;
    }

    public static void setEnv(Pair<String, String> r0) {
        sEnv = r0;
    }

    public static void setEventManager(IEventManager r0) {
        sEventManager = r0;
    }

    public static void setFirstLocation(boolean r0) {
        sIsFirstLocation = r0;
    }

    public static void setFirstRequestLocation(boolean r0) {
        sFirstRequestLocation = r0;
    }

    public static void setGpsScanInterval(long r0) {
        sGpsScanInterval = r0;
    }

    public static void setH3Distance(int r1) {
        if (r1 >= 1) goto L5;
        return;
    L5:
        sH3Distance = r1;
    }

    public static void setH3Resolution(int r1) {
        if (r1 >= 0) goto L4;
        return;
    L4:
        if (r1 > 15) goto L9;
        sH3Resolution = r1;
        return;
    }

    public static void setHARStatusRange(int r0) {
        sHARStatusRange = r0;
    }

    public static void setIsUploadGPS(boolean r0) {
        sIsUploadGPS = r0;
    }

    public static void setLatlngPrecision(int r0) {
        sLatlngPrecision = r0;
    }

    public static void setLightInfoInterval(int r0) {
        sLightInfoInterval = r0;
    }

    public static void setLocale(Locale r0) {
        sLocale = r0;
    }

    public static void setLocateType(int r0) {
        sLocateType = r0;
    }

    public static void setLocationMode(int r0) {
        sLocationMode = r0;
    }

    public static void setLogIdCacheEntity(LogIdCacheEntity r0) {
        mLogIdCacheEntity = r0;
    }

    public static void setMaxLightCount(int r0) {
        sMaxLightCount = r0;
    }

    public static void setMaxLightDuration(long r0) {
        sMaxLightDuration = r0;
    }

    public static void setMaxLocationTimeMs(long r0) {
        sMaxLocationTimeMs = r0;
    }

    public static void setMockEnable(boolean r0) {
        sIsMockEnable = r0;
    }

    public static void setMockUpload(boolean r0) {
        sIsMockUpload = r0;
    }

    public static void setMockWifiName(String r1) {
        sMockWifiName = r1;
        LocationCache.getInstance().setMockWifiName(r1);
    }

    public static void setNeedDownGradeLocationInOverseas(boolean r0) {
        sNeedDownGradeLocationInOverseas = r0;
    }

    public static void setNetworkApi(ICustomNetworkApi r0) {
        sNetworkApi = r0;
    }

    public static void setNetworkStatusChangeUploadInterval(long r0) {
        sNetworkStatusChangeUploadInterval = sNetworkStatusChangeUploadInterval;
    }

    public static void setOnline(boolean r0) {
        sOnline = r0;
    }

    public static void setOpenWifiListMonitor(boolean r0) {
        sOpenWifiListMonitor = r0;
    }

    public static void setOverseaUploadInterval(long r3) {
        if (r3 >= 1800) goto L5;
        r3 = 1800;
    L5:
        mOverseaUploadInterval = r3;
    }

    public static void setOverseaUploadMaxCount(long r0) {
        mOverseaUploadMaxCount = r0;
    }

    public static void setOverseaUploadMaxDuration(long r0) {
        mOverseaUploadMaxDuration = r0;
    }

    public static void setOverseas(boolean r0) {
        mOverseas = r0;
    }

    public static void setOverseasGetLocationFailedUseCacheValidity(long r0) {
        sOverseasGetLocationFailedUseCacheValidity = r0;
    }

    public static void setPackageName(String r0) {
        sPackageName = r0;
    }

    public static void setPollingUpload(boolean r0) {
        sIsPollingUpload = r0;
    }

    public static void setPrivacyConfirmed(boolean r0) {
        isPrivacyConfirmed = r0;
    }

    public static void setRedGeoNameIds(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return;
    L5:
        sRedGeoNameIds = r1;
    }

    public static void setRegionInChineseChannel(boolean r0) {
        sRegionInChineseChannel = r0;
    }

    public static void setReportAtStart(boolean r0) {
        sReportAtStart = r0;
    }

    public static void setReportLocationAtStart(boolean r0) {
        sReportLocationAtStart = r0;
    }

    public static void setRequestLocation(boolean r0) {
        sShouldRequestLocation = r0;
    }

    public static void setRestrictedMode(BDRestrictedMode r0) {
        sRestrictedMode = r0;
    }

    public static void setScanBleInterval(long r3) {
        if (r3 <= sScanBleMaxInterval) goto L5;
        r3 = 10000;
    L5:
        sScanBleInterval = r3;
    }

    public static void setSdkVersion(String r0) {
        sSdkVersion = r0;
    }

    public static void setSessionId(String r0) {
        sSessionId = r0;
    }

    public static void setShakeConfig(JSONObject r0) {
        mShakeConfig = r0;
    }

    public static void setSlardarAid(String r0) {
        sSlardarAid = r0;
    }

    public static void setStrictRestrictedMode(boolean r0) {
        sIsStrictRestrictedMode = r0;
    }

    public static void setUpdateVersionCode(String r0) {
        sUpdateVersionCode = r0;
    }

    public static void setUpload(boolean r0) {
        sIsUpload = r0;
    }

    public static void setUploadBaseSite(boolean r0) {
        sIsUploadBaseSite = r0;
    }

    public static void setUploadBleImmediately(boolean r0) {
        sUploadBleImmediately = r0;
    }

    public static void setUploadBleNum(int r0) {
        sUploadBleNum = r0;
    }

    public static void setUploadInterval(long r0) {
        sUploadInterval = r0;
    }

    public static void setUploadLocation(boolean r0) {
        sIsUploadLocation = r0;
    }

    public static void setUploadMccAndSystemRegionInfo(boolean r0) {
        sUploadMccAndSystemRegionInfo = r0;
    }

    @Deprecated
    public static void setUploadWIFI(boolean r1) {
        if (isDebug() == false) goto L6;
        sIsUploadWIFI = r1;
        return;
    }

    public static void setUseGpsCheckRegion(boolean r0) {
        sUseGpsCheckRegion = r0;
    }

    public static void setUseNewCacheStrategy(boolean r0) {
        sUseNewCacheStrategy = r0;
    }

    public static void setUseNewNetworkChangeRegister(boolean r0) {
        sNewNetworkChangeRegister = r0;
    }

    public static void setWifiNum(int r0) {
        sWifiNum = r0;
    }

    public static void setWorldView(String r0) {
        sWorldView = r0;
    }

    public static boolean shouldRequestLocation() {
        return sShouldRequestLocation;
    }

    private static List<LocationNotification> switchNotification(int r2) {
        List<LocationNotification> r0 = sNotifications.get(r2);
        if (r0 != null) goto L6;
        ArrayList r1 = new ArrayList();
        sNotifications.put(r2, r1);
        return r1;
    L6:
        return r0;
    }

    public static boolean useGpsCheckRegion() {
        return sUseGpsCheckRegion;
    }
}
