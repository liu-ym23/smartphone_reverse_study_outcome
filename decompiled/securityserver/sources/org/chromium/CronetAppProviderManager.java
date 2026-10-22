package org.chromium;

import a.a;
import android.util.Pair;
import com.ttnet.org.chromium.base.Reflect;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class CronetAppProviderManager {
    private static final String ADAPTER_CLASS_NAME = "com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider";
    private static volatile CronetAppProviderManager sCronetAppProviderManager;
    private Object mCronetAppProviderAdapter;

    private CronetAppProviderManager() {
    }

    private String getStringAttribute(String r2) {
        Object r1 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r1 != null) goto L6;
        return "";
    L6:
        return (String) Reflect.on(r1).call(r2).get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public static CronetAppProviderManager inst() {
        if (sCronetAppProviderManager != null) goto L16;
        monitor-enter(CronetAppProviderManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sCronetAppProviderManager != null) goto L11;
        sCronetAppProviderManager = new CronetAppProviderManager();     // Catch: Throwable -> L9
    L11:
        monitor-exit(CronetAppProviderManager.class);     // Catch: Throwable -> L9
    L16:
        return sCronetAppProviderManager;
    }

    public void doLoadLibrary(String r3) {
        Object r2 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L7
        if (r2 != null) goto L5;
        return;
    L5:
        Reflect.on(r2).call("doLoadLibrary", new Class[]{String.class}, new Object[]{r3});     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public List<String> getAbSdkVersion() {
        Object r2 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return null;
    L6:
        return (List) Reflect.on(r2).call("getAbSdkVersion").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public String getAbi() {
        return getStringAttribute("getAbi");
    }

    public String getAppId() {
        return getStringAttribute("getAppId");
    }

    public String getAppName() {
        return getStringAttribute("getAppName");
    }

    public long getAppStartTime() {
        Object r3 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r3 != null) goto L6;
        return -1;
    L6:
        return ((Long) Reflect.on(r3).call("getAppStartTime").get()).longValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return -1;
    }

    public String getBypassBOEJSON() {
        Object r2 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return null;
    L6:
        return (String) Reflect.on(r2).call("getBypassBOEJSON").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public String getCarrierRegion() {
        return getStringAttribute("getCarrierRegion");
    }

    public String getChannel() {
        return getStringAttribute("getChannel");
    }

    public Map<String[], Pair<byte[], byte[]>> getClientOpaqueData() {
        Object r2 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return null;
    L6:
        return (Map) Reflect.on(r2).call("getClientOpaqueData").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public String getCronetSoPath() {
        Object r2 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return null;
    L6:
        return (String) Reflect.on(r2).call("getCronetSoPath").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public String getDeviceBrand() {
        return getStringAttribute("getDeviceBrand");
    }

    public String getDeviceId() {
        return getStringAttribute("getDeviceId");
    }

    public String getDeviceModel() {
        return getStringAttribute("getDeviceModel");
    }

    public String getDevicePlatform() {
        return getStringAttribute("getDevicePlatform");
    }

    public String getDeviceType() {
        return getStringAttribute("getDeviceType");
    }

    public String getGetDomainDefaultJSON() {
        Object r2 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return null;
    L6:
        return (String) Reflect.on(r2).call("getGetDomainDefaultJSON").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public Map<String, String> getGetDomainDependHostMap() {
        Object r1 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L6
        if (r1 != null) goto L9;
        return Collections.emptyMap();
    L9:
        return (Map) Reflect.on(r1).call("getGetDomainDependHostMap").get();
    L6:
        th = move-exception;
        th.printStackTrace();
        return Collections.emptyMap();
    }

    public String getHttpDnsRequestFlags() {
        return getStringAttribute("getHttpDnsRequestFlags");
    }

    public String getInitRegion() {
        return getStringAttribute("getAppInitialRegionInfo");
    }

    public String getIsDropFirstTnc() {
        Object r1 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r1 != null) goto L6;
        return null;
    L6:
        return (String) Reflect.on(r1).call("getIsDropFirstTnc").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public String getManifestVersionCode() {
        return getStringAttribute("getManifestVersionCode");
    }

    public String getNetAccessType() {
        return getStringAttribute("getNetAccessType");
    }

    public String getNetworkOperator() {
        Object r2 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return "";
    L6:
        return (String) Reflect.on(r2).call("getNetworkOperator").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public String getOSApi() {
        return getStringAttribute("getOSApi");
    }

    public String getOSVersion() {
        return getStringAttribute("getOSVersion");
    }

    public ArrayList<byte[]> getOpaqueData() {
        Object r2 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return null;
    L6:
        return (ArrayList) Reflect.on(r2).call("getOpaqueData").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public boolean getOptInit() {
        Object r2 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return false;
    L6:
        return ((Boolean) Reflect.on(r2).call("getOptInit").get()).booleanValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public int getProcessFlag() {
        Object r2 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return 0;
    L6:
        return ((Integer) Reflect.on(r2).call("getProcessFlag").get()).intValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public Map<String, Pair<Integer, Integer>> getQuicHint() {
        Object r2 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return null;
    L6:
        return (Map) Reflect.on(r2).call("getQuicHint").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public String getRegion() {
        return getStringAttribute("getRegion");
    }

    public String getSdkAppId() {
        return getStringAttribute("getSdkAppId");
    }

    public String getSdkVersion() {
        return getStringAttribute("getSdkVersion");
    }

    public String getSimOperator() {
        Object r2 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return "";
    L6:
        return (String) Reflect.on(r2).call("getSimOperator").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public String getStoreIdc() {
        return getStringAttribute("getStoreIdc");
    }

    public String getStoreIdcRuleJSON() {
        Object r2 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return null;
    L6:
        return (String) Reflect.on(r2).call("getStoreIdcRuleJSON").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public String getSysRegion() {
        return getStringAttribute("getSysRegion");
    }

    public String getTNCRequestFlags() {
        return getStringAttribute("getTNCRequestFlags");
    }

    public Map<String, String> getTNCRequestHeader() {
        Object r2 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return null;
    L6:
        return (Map) Reflect.on(r2).call("getTNCRequestHeader").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public Map<String, String> getTNCRequestQuery() {
        Object r2 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return null;
    L6:
        return (Map) Reflect.on(r2).call("getTNCRequestQuery").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public String getUpdateVersionCode() {
        return getStringAttribute("getUpdateVersionCode");
    }

    public String getUserId() {
        return getStringAttribute("getUserId");
    }

    public String getVersionCode() {
        return getStringAttribute("getVersionCode");
    }

    public String getVersionName() {
        return getStringAttribute("getVersionName");
    }

    public int getWifiFrequency() {
        Object r2 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return 0;
    L6:
        return ((Integer) Reflect.on(r2).call("getWifiFrequency").get()).intValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public int getWifiRssi() {
        Object r2 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return 0;
    L6:
        return ((Integer) Reflect.on(r2).call("getWifiRssi").get()).intValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public void handleApiResult(boolean r25, String r26, String r27, String r28, long r29, long r31, long r33, long r35, long r37, long r39, long r41, long r43, long r45, long r47, boolean r49, long r50, long r52, String r54, String r55, String r56, int r57, int r58, String r59) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L17;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "handleApiResult ");
    L17:
    L10:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (this.mCronetAppProviderAdapter != null) goto L8;
        return;
    L8:
        if (r25 == true) goto L12;
        IOException r1 = Utils.tryConvertCronetException(Utils.createCronetException(r57, r58, r59));     // Catch: Throwable -> L10
    L13:
        Reflect r0 = Reflect.on(this.mCronetAppProviderAdapter);     // Catch: Throwable -> L10
        Class r17 = Boolean.TYPE;     // Catch: Throwable -> L10
        Class r19 = Long.TYPE;     // Catch: Throwable -> L10
        r0.call("handleApiResult", new Class[]{r17, String.class, String.class, String.class, r19, r19, r19, r19, r19, r19, r19, r19, r19, r19, r17, r19, r19, String.class, String.class, String.class, Exception.class}, new Object[]{Boolean.valueOf(r25), r26, r27, r28, Long.valueOf(r29), Long.valueOf(r31), Long.valueOf(r33), Long.valueOf(r35), Long.valueOf(r37), Long.valueOf(r39), Long.valueOf(r41), Long.valueOf(r43), Long.valueOf(r45), Long.valueOf(r47), Boolean.valueOf(r49), Long.valueOf(r50), Long.valueOf(r52), r54, r55, r56, r1});     // Catch: Throwable -> L10
        return;
    L12:
        r1 = null;
        goto L13
    }

    public boolean handleApiSample(String r5, String r6) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L14;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "handleApiSample");
    L14:
        Object r4 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L11
        if (r4 != null) goto L9;
        return false;
    L9:
        return ((Boolean) Reflect.on(r4).call("handleApiSample", new Class[]{String.class, String.class}, new Object[]{r5, r6}).get()).booleanValue();
    L11:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public boolean isBOEProxyEnabled() {
        Object r2 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return false;
    L6:
        return ((Boolean) Reflect.on(r2).call("isBOEProxyEnabled").get()).booleanValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public boolean isEnableBrotli() {
        Object r2 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return false;
    L6:
        return ((Boolean) Reflect.on(r2).call("isEnableBrotli").get()).booleanValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public boolean isEnableHttp2() {
        Object r2 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return false;
    L6:
        return ((Boolean) Reflect.on(r2).call("isEnableHttp2").get()).booleanValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public boolean isEnableQuic() {
        Object r2 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return false;
    L6:
        return ((Boolean) Reflect.on(r2).call("isEnableQuic").get()).booleanValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public boolean needCustomLoadLibrary() {
        Object r2 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return false;
    L6:
        return ((Boolean) Reflect.on(r2).call("needCustomLoadLibrary").get()).booleanValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public Map<String, String> onCallToAddSecurityFactor(String r5, Map<String, String> r6) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L14;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onCallToAddSecurityFactor info url = " + r5);
    L14:
        Object r4 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L11
        if (r4 != null) goto L9;
        return null;
    L9:
        return (Map) Reflect.on(r4).call("onCallToAddSecurityFactor", new Class[]{String.class, Map.class}, new Object[]{r5, r6}).get();
    L11:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public void onClientIPChanged(String r4) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onClientIPChanged ");
    L13:
        Object r3 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r3 != null) goto L8;
        return;
    L8:
        Reflect.on(r3).call("onClientIPChanged", new Class[]{String.class}, new Object[]{r4});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onColdStartFinish() {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onColdStartFinish ");
    L13:
        Object r3 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r3 != null) goto L8;
        return;
    L8:
        Reflect.on(r3).call("onColdStartFinish");     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onCronetBootSucceed() {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onCronetBootSucceed ");
    L13:
        Object r3 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r3 != null) goto L8;
        return;
    L8:
        Reflect.on(r3).call("onCronetBootSucceed");     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onDropReasonChanged(boolean r4, List<Integer> r5) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onDropReasonChanged " + r4 + ", Drop Reason List " + r5);
    L13:
        Object r3 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r3 != null) goto L8;
        return;
    L8:
        Reflect.on(r3).call("onDropReasonChanged", new Class[]{Boolean.TYPE, List.class}, new Object[]{Boolean.valueOf(r4), r5});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onEffectiveConnectionTypeChanged(int r4) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onEffectiveConnectionTypeChanged type = " + r4);
    L13:
        Object r3 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r3 != null) goto L8;
        return;
    L8:
        Reflect.on(r3).call("onEffectiveConnectionTypeChangedOnIOThread", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r4)});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onMappingRequestStatus(String r4, int r5) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onMappingRequestStatus key = " + r4 + " status = " + r5);
    L13:
        Object r3 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r3 != null) goto L8;
        return;
    L8:
        Reflect.on(r3).call("onMappingRequestStatus", new Class[]{String.class, Integer.TYPE}, new Object[]{r4, Integer.valueOf(r5)});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onMultiNetStateChanged(int r4, int r5) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onMultiNetStateChanged, prev state = " + r4 + ", curr state = " + r5);
    L13:
        Object r3 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r3 != null) goto L8;
        return;
    L8:
        Reflect r6 = Reflect.on(r3);     // Catch: Throwable -> L10
        Class r1 = Integer.TYPE;     // Catch: Throwable -> L10
        r6.call("onMultiNetStateChanged", new Class[]{r1, r1}, new Object[]{Integer.valueOf(r4), Integer.valueOf(r5)}).get();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onMultiNetworkStateChanged(int r4, int r5) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onMultiNetworkStateChanged, prev state = " + r4 + ", curr state = " + r5);
    L13:
        Object r3 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r3 != null) goto L8;
        return;
    L8:
        Reflect r6 = Reflect.on(r3);     // Catch: Throwable -> L10
        Class r1 = Integer.TYPE;     // Catch: Throwable -> L10
        r6.call("onWiFiToCellStateChangedOnIOThread", new Class[]{r1, r1}, new Object[]{Integer.valueOf(r4), Integer.valueOf(r5)}).get();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onNetworkQualityLevelChanged(int r4) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onNetworkQualityLevelChanged, nql: " + r4);
    L13:
        Object r3 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r3 != null) goto L8;
        return;
    L8:
        Reflect.on(r3).call("onNetworkQualityLevelChangedOnIOThread", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r4)}).get();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onNetworkQualityRttAndThroughputNotified(int r5, int r6, int r7) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager r0 = CronetDependManager.inst();
        StringBuilder r1 = a.r("onNetworkQualityRttAndThroughputNotified, effectiveHrttMs: ", r5, ", effectiveTrttMs: ", r6, ", effectiveRxThroughputKbps: ");
        r1.append(r7);
        r0.loggerD("CronetAppProviderManager", r1.toString());
    L13:
        Object r4 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r4 != null) goto L8;
        return;
    L8:
        Reflect r8 = Reflect.on(r4);     // Catch: Throwable -> L10
        Class r2 = Integer.TYPE;     // Catch: Throwable -> L10
        r8.call("onNetworkQualityRttAndThroughputNotifiedOnIOThread", new Class[]{r2, r2, r2}, new Object[]{Integer.valueOf(r5), Integer.valueOf(r6), Integer.valueOf(r7)}).get();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onNetworkQualityTypeChangedV3(int r5) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onNetworkQualityTypeChangedV3, network_quality_type = " + r5);
    L13:
        Object r4 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r4 != null) goto L8;
        return;
    L8:
        Reflect r6 = Reflect.on(r4);     // Catch: Throwable -> L10
        Class r1 = Integer.TYPE;     // Catch: Throwable -> L10
        r6.call("onEffectiveConnectionTypeChangedOnIOThread", new Class[]{r1}, new Object[]{Integer.valueOf(r5)});     // Catch: Throwable -> L10
        Reflect.on("com.bytedance.ttnet.NQEManager").call("notifyNQTChanged", new Class[]{r1}, new Object[]{Integer.valueOf(r5)});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onPacketLossComputed(int r4, double r5, double r7, double r9, double r11) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onPacketLossComputed protocol = " + r4 + ", upstreamLossRate = " + r5 + ", upstreamLossRateVariance = " + r7 + ", downstreamLossRate = " + r9 + ", downstreamLossRateVariance = " + r11);
    L13:
        Object r3 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r3 != null) goto L8;
        return;
    L8:
        Reflect r6 = Reflect.on(r3);     // Catch: Throwable -> L10
        Class r1 = Integer.TYPE;     // Catch: Throwable -> L10
        Class r2 = Double.TYPE;     // Catch: Throwable -> L10
        r6.call("onPacketLossComputedOnIOThread", new Class[]{r1, r2, r2, r2, r2}, new Object[]{Integer.valueOf(r4), Double.valueOf(r5), Double.valueOf(r7), Double.valueOf(r9), Double.valueOf(r11)});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onPublicIPsChanged(List<String> r5, List<String> r6) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onPublicIPsChanged ");
    L13:
        Object r4 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r4 != null) goto L8;
        return;
    L8:
        Reflect.on(r4).call("onPublicIPsChanged", new Class[]{List.class, List.class}, new Object[]{r5, r6});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onRTTOrThroughputEstimatesComputed(int r5, int r6, int r7) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager r0 = CronetDependManager.inst();
        StringBuilder r1 = a.r("onRTTOrThroughputEstimatesComputed httpRtt = ", r5, ", transportRttMs = ", r6, ",downstreamThroughputKbps = ");
        r1.append(r7);
        r0.loggerD("CronetAppProviderManager", r1.toString());
    L13:
        Object r4 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r4 != null) goto L8;
        return;
    L8:
        Reflect r8 = Reflect.on(r4);     // Catch: Throwable -> L10
        Class r2 = Integer.TYPE;     // Catch: Throwable -> L10
        r8.call("onRTTOrThroughputEstimatesComputedOnIOThread", new Class[]{r2, r2, r2}, new Object[]{Integer.valueOf(r5), Integer.valueOf(r6), Integer.valueOf(r7)});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onServerConfigUpdated(String r5, String r6, String r7) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onServerConfigUpdated json = " + r5);
    L13:
        Object r1 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r1 != null) goto L8;
        return;
    L8:
        Reflect.on(r1).call("onServerConfigEtagChanged", new Class[]{String.class}, new Object[]{r6});     // Catch: Throwable -> L10
        Reflect.on(this.mCronetAppProviderAdapter).call("onServerConfigABTestChanged", new Class[]{String.class}, new Object[]{r7});     // Catch: Throwable -> L10
        Reflect.on(this.mCronetAppProviderAdapter).call("onServerConfigUpdated", new Class[]{String.class}, new Object[]{r5});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onStoreIdcChanged(String r8, String r9, String r10, String r11, String r12, String r13) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onStoreIdcChanged ");
    L13:
        Object r7 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r7 != null) goto L8;
        return;
    L8:
        Reflect.on(r7).call("onStoreIdcChanged", new Class[]{String.class, String.class, String.class, String.class, String.class, String.class}, new Object[]{r8, r9, r10, r11, r12, r13});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onTNCUpdateFailed(String[] r5, String r6) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L21;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onTNCUpdateFailed ");
    L21:
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (this.mCronetAppProviderAdapter == null) goto L18;
        if (r5 != null) goto L9;
        return;
    L9:
        if (r5.length <= 0) goto L25;
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L14
        int r1 = r5.length;     // Catch: Throwable -> L14
        int r2 = 0;
    L12:
        if (r2 >= r1) goto L16;
        r0.add(r5[r2]);     // Catch: Throwable -> L14
        r2 = r2 + 1;     // Catch: Throwable -> L14
        goto L12
    L16:
        Reflect.on(this.mCronetAppProviderAdapter).call("onTNCUpdateFailed", new Class[]{ArrayList.class, String.class}, new Object[]{r0, r6});     // Catch: Throwable -> L14
        return;
    L25:
        return;
    }

    public void onTTDnsResolveResult(String r13, String r14, int r15, int r16, int r17, List<String> r18, String r19) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L15;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onTTDnsResolveResult info uuid = " + r13 + " host: " + r14);
    L15:
        Object r0 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L12
        if (r0 != null) goto L10;
        return;
    L10:
        Reflect r1 = Reflect.on(r0);     // Catch: Throwable -> L12
        Class r9 = Integer.TYPE;     // Catch: Throwable -> L12
        r1.call("onTTDnsResolveResult", new Class[]{String.class, String.class, r9, r9, r9, List.class, String.class}, new Object[]{r13, r14, Integer.valueOf(r15), Integer.valueOf(r16), Integer.valueOf(r17), r18, r19});     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
    }

    public void onTTNetDetectInfoChanged(String r4) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onTTNetDetectInfoChanged info str = " + r4);
    L13:
        Object r3 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r3 != null) goto L8;
        return;
    L8:
        Reflect.on(r3).call("onTTNetDetectInfoChanged", new Class[]{String.class}, new Object[]{r4});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onTncRequestSucceeded(boolean r4, boolean r5, int r6) {
        Object r3 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L7
        if (r3 != null) goto L5;
        return;
    L5:
        Reflect r7 = Reflect.on(r3);     // Catch: Throwable -> L7
        Class r1 = Boolean.TYPE;     // Catch: Throwable -> L7
        r7.call("onTncRequestSucceeded", new Class[]{r1, r1, Integer.TYPE}, new Object[]{Boolean.valueOf(r4), Boolean.valueOf(r5), Integer.valueOf(r6)}).get();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public void onUserSpecifiedNetworkEnabled(boolean r4) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onUserSpecifiedNetworkEnabled, enable = " + r4);
    L13:
        Object r3 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r3 != null) goto L8;
        return;
    L8:
        Reflect.on(r3).call("onUserSpecifiedNetworkEnabled", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(r4)});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void sendAppMonitorEvent(String r5, String r6) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "Send monitor json = " + r5 + ", log type =" + r6);
    L13:
        Object r4 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r4 != null) goto L8;
        return;
    L8:
        Reflect.on(r4).call("sendAppMonitorEvent", new Class[]{String.class, String.class}, new Object[]{r5, r6});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void setAdapter(Object r4) {
        if (r4 == null) goto L29;
        List r0 = Utils.getAllInterfaces(r4.getClass());     // Catch: Throwable -> L16
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.isEmpty() == true) goto L28;
        Iterator r1 = r0.iterator();     // Catch: Throwable -> L16
    L10:
        if (r1.hasNext() == false) goto L31;
        if (ADAPTER_CLASS_NAME.equals(((Class) r1.next()).getName()) == false) goto L10;
        if (CronetDependManager.inst().loggerDebug() == false) goto L18;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "inject CronetAppProviderManager success");     // Catch: Throwable -> L16
    L18:
        this.mCronetAppProviderAdapter = r4;     // Catch: Throwable -> L16
        return;
    L31:
        return;
    L28:
        return;
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    }
}
