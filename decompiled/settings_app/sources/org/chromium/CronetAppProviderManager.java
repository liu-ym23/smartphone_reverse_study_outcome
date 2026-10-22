package org.chromium;

import android.util.Pair;
import com.ttnet.org.chromium.base.Reflect;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class CronetAppProviderManager {
    private static final String ADAPTER_CLASS_NAME = "com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider";
    private static volatile CronetAppProviderManager sCronetAppProviderManager;
    private Object mCronetAppProviderAdapter;

    private CronetAppProviderManager() {
    }

    public static CronetAppProviderManager inst() {
        if (sCronetAppProviderManager != null) goto L15;
        monitor-enter(CronetAppProviderManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sCronetAppProviderManager != null) goto L9;
        sCronetAppProviderManager = new CronetAppProviderManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CronetAppProviderManager.class);     // Catch: Throwable -> L11
    L15:
        return sCronetAppProviderManager;
    }

    public void setAdapter(Object r4) {
        if (r4 == null) goto L31;
        Class<?> r0 = r4.getClass();     // Catch: Throwable -> L22
        if (r0 != null) goto L6;
        return;
    L6:
        List r1 = Utils.getAllInterfaces(r0);     // Catch: Throwable -> L22
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.isEmpty() == true) goto L30;
        Iterator r2 = r1.iterator();     // Catch: Throwable -> L22
    L13:
        if (r2.hasNext() == false) goto L33;
        if (ADAPTER_CLASS_NAME.equals(((Class) r2.next()).getName()) == false) goto L13;
        if (CronetDependManager.inst().loggerDebug() == false) goto L19;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "inject CronetAppProviderManager success");     // Catch: Throwable -> L22
    L19:
        this.mCronetAppProviderAdapter = r4;     // Catch: Throwable -> L22
        return;
    L33:
        return;
    L30:
        return;
    L22:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public void sendAppMonitorEvent(String r7, String r8) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "Send monitor json = " + r7 + ", log type =" + r8);
    L13:
        Object r6 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r6 != null) goto L8;
        return;
    L8:
        Reflect.on(r6).call("sendAppMonitorEvent", new Class[]{String.class, String.class}, new Object[]{r7, r8});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void handleApiResult(boolean r28, String r29, String r30, String r31, long r32, long r34, long r36, long r38, long r40, long r42, long r44, long r46, long r48, long r50, boolean r52, long r53, long r55, String r57, String r58, String r59, int r60, int r61, String r62) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L16;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "handleApiResult ");
    L16:
    L13:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (this.mCronetAppProviderAdapter != null) goto L8;
        return;
    L8:
        if (r28 == true) goto L10;
        IOException r1 = Utils.tryConvertCronetException(Utils.createCronetException(r60, r61, r62));     // Catch: Throwable -> L13
    L11:
        Reflect.on(this.mCronetAppProviderAdapter).call("handleApiResult", new Class[]{Boolean.TYPE, String.class, String.class, String.class, Long.TYPE, Long.TYPE, Long.TYPE, Long.TYPE, Long.TYPE, Long.TYPE, Long.TYPE, Long.TYPE, Long.TYPE, Long.TYPE, Boolean.TYPE, Long.TYPE, Long.TYPE, String.class, String.class, String.class, Exception.class}, new Object[]{Boolean.valueOf(r28), r29, r30, r31, Long.valueOf(r32), Long.valueOf(r34), Long.valueOf(r36), Long.valueOf(r38), Long.valueOf(r40), Long.valueOf(r42), Long.valueOf(r44), Long.valueOf(r46), Long.valueOf(r48), Long.valueOf(r50), Boolean.valueOf(r52), Long.valueOf(r53), Long.valueOf(r55), r57, r58, r59, r1});     // Catch: Throwable -> L13
        return;
    L10:
        r1 = null;
        goto L11
    }

    public boolean handleApiSample(String r7, String r8) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L14;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "handleApiSample");
    L14:
        Object r6 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L11
        if (r6 != null) goto L9;
        return false;
    L9:
        return ((Boolean) Reflect.on(r6).call("handleApiSample", new Class[]{String.class, String.class}, new Object[]{r7, r8}).get()).booleanValue();
    L11:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public void onServerConfigUpdated(String r7, String r8, String r9) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onServerConfigUpdated json = " + r7);
    L13:
        Object r0 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r0 != null) goto L8;
        return;
    L8:
        Reflect.on(r0).call("onServerConfigEtagChanged", new Class[]{String.class}, new Object[]{r8});     // Catch: Throwable -> L10
        Reflect.on(this.mCronetAppProviderAdapter).call("onServerConfigABTestChanged", new Class[]{String.class}, new Object[]{r9});     // Catch: Throwable -> L10
        Reflect.on(this.mCronetAppProviderAdapter).call("onServerConfigUpdated", new Class[]{String.class}, new Object[]{r7});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onTTNetDetectInfoChanged(String r6) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onTTNetDetectInfoChanged info str = " + r6);
    L13:
        Object r5 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r5 != null) goto L8;
        return;
    L8:
        Reflect.on(r5).call("onTTNetDetectInfoChanged", new Class[]{String.class}, new Object[]{r6});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onTTDnsResolveResult(String r15, String r16, int r17, int r18, int r19, List<String> r20, String r21) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L14;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onTTDnsResolveResult info uuid = " + r15 + " host: " + r16);
    L14:
        Object r2 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L11
        if (r2 != null) goto L9;
        return;
    L9:
        Reflect.on(r2).call("onTTDnsResolveResult", new Class[]{String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, List.class, String.class}, new Object[]{r15, r16, Integer.valueOf(r17), Integer.valueOf(r18), Integer.valueOf(r19), r20, r21});     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
    }

    public void onMappingRequestStatus(String r7, int r8) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onMappingRequestStatus key = " + r7 + " status = " + r8);
    L13:
        Object r6 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r6 != null) goto L8;
        return;
    L8:
        Reflect.on(r6).call("onMappingRequestStatus", new Class[]{String.class, Integer.TYPE}, new Object[]{r7, Integer.valueOf(r8)});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onEffectiveConnectionTypeChanged(int r6) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onEffectiveConnectionTypeChanged type = " + r6);
    L13:
        Object r5 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r5 != null) goto L8;
        return;
    L8:
        Reflect.on(r5).call("onEffectiveConnectionTypeChangedOnIOThread", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r6)});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onRTTOrThroughputEstimatesComputed(int r8, int r9, int r10) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onRTTOrThroughputEstimatesComputed httpRtt = " + r8 + ", transportRttMs = " + r9 + ",downstreamThroughputKbps = " + r10);
    L13:
        Object r7 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r7 != null) goto L8;
        return;
    L8:
        Reflect.on(r7).call("onRTTOrThroughputEstimatesComputedOnIOThread", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE}, new Object[]{Integer.valueOf(r8), Integer.valueOf(r9), Integer.valueOf(r10)});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onPacketLossComputed(int r20, double r21, double r23, double r25, double r27) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L15;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onPacketLossComputed protocol = " + r20 + ", upstreamLossRate = " + r21 + ", upstreamLossRateVariance = " + r23 + ", downstreamLossRate = " + r25 + ", downstreamLossRateVariance = " + r27);
    L15:
        Object r0 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L12
        if (r0 != null) goto L10;
        return;
    L10:
        Reflect.on(r0).call("onPacketLossComputedOnIOThread", new Class[]{Integer.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE}, new Object[]{Integer.valueOf(r20), Double.valueOf(r21), Double.valueOf(r23), Double.valueOf(r25), Double.valueOf(r27)});     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
    }

    public void onNetworkQualityTypeChangedV3(int r7) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onNetworkQualityTypeChangedV3, network_quality_type = " + r7);
    L13:
        Object r6 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r6 != null) goto L8;
        return;
    L8:
        Reflect.on(r6).call("onEffectiveConnectionTypeChangedOnIOThread", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r7)});     // Catch: Throwable -> L10
        Reflect.on("com.bytedance.ttnet.NQEManager").call("notifyNQTChanged", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r7)});     // Catch: Throwable -> L10
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

    public void onClientIPChanged(String r6) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onClientIPChanged ");
    L13:
        Object r5 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r5 != null) goto L8;
        return;
    L8:
        Reflect.on(r5).call("onClientIPChanged", new Class[]{String.class}, new Object[]{r6});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onPublicIPsChanged(List<String> r7, List<String> r8) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onPublicIPsChanged ");
    L13:
        Object r6 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r6 != null) goto L8;
        return;
    L8:
        Reflect.on(r6).call("onPublicIPsChanged", new Class[]{List.class, List.class}, new Object[]{r7, r8});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onStoreIdcChanged(String r10, String r11, String r12, String r13, String r14) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onStoreIdcChanged ");
    L13:
        Object r9 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r9 != null) goto L8;
        return;
    L8:
        Reflect.on(r9).call("onStoreIdcChanged", new Class[]{String.class, String.class, String.class, String.class, String.class}, new Object[]{r10, r11, r12, r13, r14});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onDropReasonChanged(boolean r7, List<Integer> r8) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onDropReasonChanged " + r7 + ", Drop Reason List " + r8);
    L13:
        Object r6 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r6 != null) goto L8;
        return;
    L8:
        Reflect.on(r6).call("onDropReasonChanged", new Class[]{Boolean.TYPE, List.class}, new Object[]{Boolean.valueOf(r7), r8});     // Catch: Throwable -> L10
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

    public void onTNCUpdateFailed(String[] r7, String r8) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L20;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onTNCUpdateFailed ");
    L20:
    L17:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (this.mCronetAppProviderAdapter == null) goto L16;
        if (r7 != null) goto L9;
        return;
    L9:
        if (r7.length <= 0) goto L24;
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L17
        int r1 = r7.length;     // Catch: Throwable -> L17
        int r3 = 0;
    L12:
        if (r3 >= r1) goto L14;
        r0.add(r7[r3]);     // Catch: Throwable -> L17
        r3 = r3 + 1;     // Catch: Throwable -> L17
        goto L12
    L14:
        Reflect.on(this.mCronetAppProviderAdapter).call("onTNCUpdateFailed", new Class[]{ArrayList.class, String.class}, new Object[]{r0, r8});     // Catch: Throwable -> L17
        return;
    L24:
        return;
    }

    public Map<String, String> onCallToAddSecurityFactor(String r8, Map<String, String> r9) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L14;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onCallToAddSecurityFactor info url = " + r8);
    L14:
        Object r7 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L11
        if (r7 != null) goto L9;
        return null;
    L9:
        return (Map) Reflect.on(r7).call("onCallToAddSecurityFactor", new Class[]{String.class, Map.class}, new Object[]{r8, r9}).get();
    L11:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public void onMultiNetworkStateChanged(int r7, int r8) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onMultiNetworkStateChanged, prev state = " + r7 + ", curr state = " + r8);
    L13:
        Object r6 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r6 != null) goto L8;
        return;
    L8:
        Reflect.on(r6).call("onWiFiToCellStateChangedOnIOThread", new Class[]{Integer.TYPE, Integer.TYPE}, new Object[]{Integer.valueOf(r7), Integer.valueOf(r8)}).get();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onMultiNetStateChanged(int r7, int r8) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onMultiNetStateChanged, prev state = " + r7 + ", curr state = " + r8);
    L13:
        Object r6 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r6 != null) goto L8;
        return;
    L8:
        Reflect.on(r6).call("onMultiNetStateChanged", new Class[]{Integer.TYPE, Integer.TYPE}, new Object[]{Integer.valueOf(r7), Integer.valueOf(r8)}).get();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onUserSpecifiedNetworkEnabled(boolean r6) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onUserSpecifiedNetworkEnabled, enable = " + r6);
    L13:
        Object r5 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r5 != null) goto L8;
        return;
    L8:
        Reflect.on(r5).call("onUserSpecifiedNetworkEnabled", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(r6)});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onNetworkQualityLevelChanged(int r6) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onNetworkQualityLevelChanged, nql: " + r6);
    L13:
        Object r5 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r5 != null) goto L8;
        return;
    L8:
        Reflect.on(r5).call("onNetworkQualityLevelChangedOnIOThread", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r6)}).get();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void onNetworkQualityRttAndThroughputNotified(int r8, int r9, int r10) {
        if (CronetDependManager.inst().loggerDebug() == false) goto L13;
        CronetDependManager.inst().loggerD("CronetAppProviderManager", "onNetworkQualityRttAndThroughputNotified, effectiveHrttMs: " + r8 + ", effectiveTrttMs: " + r9 + ", effectiveRxThroughputKbps: " + r10);
    L13:
        Object r7 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L10
        if (r7 != null) goto L8;
        return;
    L8:
        Reflect.on(r7).call("onNetworkQualityRttAndThroughputNotifiedOnIOThread", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE}, new Object[]{Integer.valueOf(r8), Integer.valueOf(r9), Integer.valueOf(r10)}).get();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public String getUserId() {
        return getStringAttribute("getUserId");
    }

    public String getAppId() {
        return getStringAttribute("getAppId");
    }

    public String getOSApi() {
        return getStringAttribute("getOSApi");
    }

    public String getDeviceId() {
        return getStringAttribute("getDeviceId");
    }

    public String getNetAccessType() {
        return getStringAttribute("getNetAccessType");
    }

    public String getVersionCode() {
        return getStringAttribute("getVersionCode");
    }

    public String getDeviceType() {
        return getStringAttribute("getDeviceType");
    }

    public String getAppName() {
        return getStringAttribute("getAppName");
    }

    public String getSdkAppId() {
        return getStringAttribute("getSdkAppId");
    }

    public String getSdkVersion() {
        return getStringAttribute("getSdkVersion");
    }

    public String getChannel() {
        return getStringAttribute("getChannel");
    }

    public String getOSVersion() {
        return getStringAttribute("getOSVersion");
    }

    public String getAbi() {
        return getStringAttribute("getAbi");
    }

    public String getDevicePlatform() {
        return getStringAttribute("getDevicePlatform");
    }

    public String getDeviceBrand() {
        return getStringAttribute("getDeviceBrand");
    }

    public String getDeviceModel() {
        return getStringAttribute("getDeviceModel");
    }

    public String getVersionName() {
        return getStringAttribute("getVersionName");
    }

    public String getUpdateVersionCode() {
        return getStringAttribute("getUpdateVersionCode");
    }

    public String getManifestVersionCode() {
        return getStringAttribute("getManifestVersionCode");
    }

    public String getStoreIdc() {
        return getStringAttribute("getStoreIdc");
    }

    public String getRegion() {
        return getStringAttribute("getRegion");
    }

    public String getSysRegion() {
        return getStringAttribute("getSysRegion");
    }

    public String getCarrierRegion() {
        return getStringAttribute("getCarrierRegion");
    }

    public String getInitRegion() {
        return getStringAttribute("getAppInitialRegionInfo");
    }

    public String getTNCRequestFlags() {
        return getStringAttribute("getTNCRequestFlags");
    }

    public String getHttpDnsRequestFlags() {
        return getStringAttribute("getHttpDnsRequestFlags");
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

    public Map<String, String> getGetDomainDependHostMap() {
        Object r1 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L8
        if (r1 != null) goto L7;
        return Collections.emptyMap();
    L7:
        return (Map) Reflect.on(r1).call("getGetDomainDependHostMap").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return Collections.emptyMap();
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

    public void doLoadLibrary(String r6) {
        Object r5 = this.mCronetAppProviderAdapter;     // Catch: Throwable -> L7
        if (r5 != null) goto L5;
        return;
    L5:
        Reflect.on(r5).call("doLoadLibrary", new Class[]{String.class}, new Object[]{r6});     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
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
}
