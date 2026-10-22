package com.bytedance.frameworks.baselib.network.http.cronet;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface ICronetAppProvider {
    void doLoadLibrary(String r1);

    String getAbClient();

    String getAbFeature();

    String getAbFlag();

    List<String> getAbSdkVersion();

    String getAbVersion();

    String getAbi();

    String getAppId();

    b getAppInfoSubset();

    String getAppInitialRegionInfo();

    String getAppName();

    long getAppStartTime();

    String getBypassBOEJSON();

    String getCarrierRegion();

    String getChannel();

    String getCityName();

    Map<String[], Pair<byte[], byte[]>> getClientOpaqueData();

    String getCronetSoPath();

    String getDPI();

    String getDeviceBrand();

    String getDeviceId();

    String getDeviceModel();

    String getDevicePlatform();

    String getDeviceType();

    String getGetDomainDefaultJSON();

    Map<String, String> getGetDomainDependHostMap();

    String getHttpDnsRequestFlags();

    String getIId();

    String getIsDropFirstTnc();

    String getLanguage();

    boolean getLazyInitCronetIPC();

    String getManifestVersionCode();

    String getNetAccessType();

    String getNetworkOperator();

    String getOSApi();

    String getOSVersion();

    ArrayList<byte[]> getOpaqueData();

    String getOpenUdid();

    boolean getOptInit();

    boolean getOptNqeDefault();

    boolean getOptNqePersist();

    int getProcessFlag();

    Map<String, Pair<Integer, Integer>> getQuicHint();

    String getRegion();

    String getResolution();

    String getRticket();

    String getSdkAppId();

    String getSdkVersion();

    String getSimOperator();

    String getSsmix();

    String getStoreIdc();

    String getStoreIdcRuleJSON();

    String getSysRegion();

    String getTNCRequestFlags();

    Map<String, String> getTNCRequestHeader();

    Map<String, String> getTNCRequestQuery();

    @Deprecated
    String getUUID();

    String getUpdateVersionCode();

    String getUserId();

    String getVersionCode();

    String getVersionName();

    int getWifiFrequency();

    int getWifiRssi();

    void handleApiResult(boolean r1, String r2, String r3, String r4, long r5, long r7, long r9, long r11, long r13, long r15, long r17, long r19, long r21, long r23, boolean r25, long r26, long r28, String r30, String r31, String r32, Exception r33);

    boolean handleApiSample(String r1, String r2);

    boolean isBOEProxyEnabled();

    boolean isEnableBrotli();

    boolean isEnableHttp2();

    boolean isEnableQuic();

    boolean needCustomLoadLibrary();

    Map<String, String> onCallToAddSecurityFactor(String r1, Map<String, String> r2);

    void onClientIPChanged(String r1);

    void onColdStartFinish();

    void onCronetBootSucceed();

    void onDropReasonChanged(boolean r1, List<Integer> r2);

    void onEffectiveConnectionTypeChanged(int r1);

    void onEffectiveConnectionTypeChangedOnIOThread(int r1);

    void onMultiNetStateChanged(int r1, int r2);

    void onMultiNetworkStateChanged(int r1, int r2);

    void onNetworkQualityLevelChanged(int r1);

    void onNetworkQualityLevelChangedOnIOThread(int r1);

    void onNetworkQualityRttAndThroughputNotified(int r1, int r2, int r3);

    void onNetworkQualityRttAndThroughputNotifiedOnIOThread(int r1, int r2, int r3);

    void onPacketLossComputed(int r1, double r2, double r4, double r6, double r8);

    void onPacketLossComputedOnIOThread(int r1, double r2, double r4, double r6, double r8);

    void onPublicIPsChanged(List<String> r1, List<String> r2);

    void onRTTOrThroughputEstimatesComputed(int r1, int r2, int r3);

    void onRTTOrThroughputEstimatesComputedOnIOThread(int r1, int r2, int r3);

    void onServerConfigABTestChanged(String r1);

    void onServerConfigEtagChanged(String r1);

    void onServerConfigUpdated(String r1);

    void onStoreIdcChanged(String r1, String r2, String r3, String r4, String r5, String r6);

    void onTNCUpdateFailed(ArrayList<String> r1, String r2);

    void onTTDnsResolveResult(String r1, String r2, int r3, int r4, int r5, List<String> r6, String r7);

    void onTTNetDetectInfoChanged(String r1);

    void onTncRequestSucceeded(boolean r1, boolean r2, int r3);

    void onUserSpecifiedNetworkEnabled(boolean r1);

    void onWiFiToCellStateChangedOnIOThread(int r1, int r2);

    void sendAppMonitorEvent(String r1, String r2);
}
