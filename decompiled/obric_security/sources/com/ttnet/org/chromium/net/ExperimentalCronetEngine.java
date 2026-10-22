package com.ttnet.org.chromium.net;

import android.content.Context;
import android.util.Pair;
import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ExperimentalCronetEngine extends CronetEngine {
    public static final int CONNECTION_METRIC_UNKNOWN = -1;
    public static final int EFFECTIVE_CONNECTION_TYPE_2G = 3;
    public static final int EFFECTIVE_CONNECTION_TYPE_3G = 4;
    public static final int EFFECTIVE_CONNECTION_TYPE_4G = 5;
    public static final int EFFECTIVE_CONNECTION_TYPE_OFFLINE = 1;
    public static final int EFFECTIVE_CONNECTION_TYPE_SLOW_2G = 2;
    public static final int EFFECTIVE_CONNECTION_TYPE_UNKNOWN = 0;
    public static final int PACKET_LOSS_PROTOCOL_QUIC = 1;
    public static final int PACKET_LOSS_PROTOCOL_TCP = 0;
    public static final long UNBIND_NETWORK_HANDLE = -1;

    public static class Builder extends CronetEngine.Builder {
        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder enableSdch(boolean r1) {
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder addPublicKeyPins(String r1, Set r2, boolean r3, Date r4) {
            return addPublicKeyPins(r1, r2, r3, r4);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder addQuicHint(String r1, int r2, int r3) {
            return addQuicHint(r1, r2, r3);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine build() {
            return build();
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder enableBoeProxy(boolean r1) {
            return enableBoeProxy(r1);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder enableHttp2(boolean r1) {
            return enableHttp2(r1);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder enableHttpCache(int r1, long r2) {
            return enableHttpCache(r1, r2);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder enableHttpDns(boolean r1) {
            return enableHttpDns(r1);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder enablePublicKeyPinningBypassForLocalTrustAnchors(boolean r1) {
            return enablePublicKeyPinningBypassForLocalTrustAnchors(r1);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder enableQuic(boolean r1) {
            return enableQuic(r1);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder enableSdch(boolean r1) {
            return enableSdch(r1);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder enableTncSecureMode(boolean r1) {
            return enableTncSecureMode(r1);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder enableVerboseLog() {
            return enableVerboseLog();
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder listenAppStateIndependently(boolean r1) {
            return listenAppStateIndependently(r1);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setALogFuncAddr(long r1) {
            return setALogFuncAddr(r1);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setAppInfoProvider(TTAppInfoProvider r1) {
            return setAppInfoProvider(r1);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setAppMonitorProvider(TTMonitorProvider r1) {
            return setAppMonitorProvider(r1);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setAppSecurityLevel(int r1) {
            return setAppSecurityLevel(r1);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setBypassBOEJSON(String r1) {
            return setBypassBOEJSON(r1);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setClientOpaqueData(Map r1) {
            return setClientOpaqueData(r1);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setEventListener(TTEventListener r1) {
            return setEventListener(r1);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setGetDomainDefaultJSON(String r1) {
            return setGetDomainDefaultJSON(r1);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setIsMainProcess(boolean r1) {
            return setIsMainProcess(r1);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setLazyInitIPC(boolean r1) {
            return setLazyInitIPC(r1);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setLibraryLoader(CronetEngine.Builder.LibraryLoader r1) {
            return setLibraryLoader(r1);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setOpaqueData(ArrayList r1) {
            return setOpaqueData(r1);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setOptInit(boolean r1) {
            return setOptInit(r1);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setOptNqeInit(boolean r1, boolean r2) {
            return setOptNqeInit(r1, r2);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setProcessName(String r1) {
            return setProcessName(r1);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setProxyConfig(String r1) {
            return setProxyConfig(r1);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setSlaSamplingSetting(TTSamplingSettingProvider.TTSlaSamplingSetting r1) {
            return setSlaSamplingSetting(r1);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setStackInfo(boolean r1, String r2) {
            return setStackInfo(r1, r2);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setStoragePath(String r1) {
            return setStoragePath(r1);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setStoreIdcRuleJSON(String r1) {
            return setStoreIdcRuleJSON(r1);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setTTAppInfoColdStartSubset(TTAppInfoProvider.AppInfo r1) {
            return setTTAppInfoColdStartSubset(r1);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setTTNetInitStart(long r1) {
            return setTTNetInitStart(r1);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setThreadConfigCallbackImpl(TTThreadConfigInfoProvider.Callback r1) {
            return setThreadConfigCallbackImpl(r1);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setThreadConfigInfoList(ArrayList r1) {
            return setThreadConfigInfoList(r1);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setUserAgent(String r1) {
            return setUserAgent(r1);
        }

        public Builder(Context r1, boolean r2) {
            super(r1, r2);
        }

        public Builder(ICronetEngineBuilder r1) {
            super(r1);
        }

        public Builder enableNetworkQualityEstimator(boolean r2) {
            this.mBuilderDelegate.enableNetworkQualityEstimator(r2);
            return this;
        }

        public Builder setExperimentalOptions(String r2) {
            this.mBuilderDelegate.setExperimentalOptions(r2);
            return this;
        }

        public Builder setThreadPriority(int r2) {
            this.mBuilderDelegate.setThreadPriority(r2);
            return this;
        }

        public ICronetEngineBuilder getBuilderDelegate() {
            return this.mBuilderDelegate;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setUserAgent(String r1) {
            super.setUserAgent(r1);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setStoragePath(String r1) {
            super.setStoragePath(r1);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setLibraryLoader(CronetEngine.Builder.LibraryLoader r1) {
            super.setLibraryLoader(r1);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder enableQuic(boolean r1) {
            super.enableQuic(r1);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder enableHttp2(boolean r1) {
            super.enableHttp2(r1);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder enableHttpCache(int r1, long r2) {
            super.enableHttpCache(r1, r2);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder enableHttpDns(boolean r1) {
            super.enableHttpDns(r1);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder listenAppStateIndependently(boolean r1) {
            super.listenAppStateIndependently(r1);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder enableVerboseLog() {
            super.enableVerboseLog();
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setAppInfoProvider(TTAppInfoProvider r1) {
            super.setAppInfoProvider(r1);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setAppMonitorProvider(TTMonitorProvider r1) {
            super.setAppMonitorProvider(r1);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setEventListener(TTEventListener r1) {
            super.setEventListener(r1);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setAppSecurityLevel(int r1) {
            super.setAppSecurityLevel(r1);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setGetDomainDefaultJSON(String r1) {
            super.setGetDomainDefaultJSON(r1);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setOpaqueData(ArrayList<byte[]> r1) {
            super.setOpaqueData(r1);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setClientOpaqueData(Map<String[], Pair<byte[], byte[]>> r1) {
            super.setClientOpaqueData(r1);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setBypassBOEJSON(String r1) {
            super.setBypassBOEJSON(r1);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setStoreIdcRuleJSON(String r1) {
            super.setStoreIdcRuleJSON(r1);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setProxyConfig(String r1) {
            super.setProxyConfig(r1);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder enableBoeProxy(boolean r1) {
            super.enableBoeProxy(r1);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder enableTncSecureMode(boolean r1) {
            super.enableTncSecureMode(r1);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setALogFuncAddr(long r1) {
            super.setALogFuncAddr(r1);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setIsMainProcess(boolean r1) {
            super.setIsMainProcess(r1);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setLazyInitIPC(boolean r1) {
            super.setLazyInitIPC(r1);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setProcessName(String r1) {
            super.setProcessName(r1);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setTTAppInfoColdStartSubset(TTAppInfoProvider.AppInfo r1) {
            super.setTTAppInfoColdStartSubset(r1);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setOptInit(boolean r1) {
            super.setOptInit(r1);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setOptNqeInit(boolean r1, boolean r2) {
            super.setOptNqeInit(r1, r2);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setTTNetInitStart(long r1) {
            super.setTTNetInitStart(r1);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setThreadConfigInfoList(ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r1) {
            super.setThreadConfigInfoList(r1);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setThreadConfigCallbackImpl(TTThreadConfigInfoProvider.Callback r1) {
            super.setThreadConfigCallbackImpl(r1);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setSlaSamplingSetting(TTSamplingSettingProvider.TTSlaSamplingSetting r1) {
            super.setSlaSamplingSetting(r1);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setStackInfo(boolean r1, String r2) {
            super.setStackInfo(r1, r2);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder addQuicHint(String r1, int r2, int r3) {
            super.addQuicHint(r1, r2, r3);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder addPublicKeyPins(String r1, Set<byte[]> r2, boolean r3, Date r4) {
            super.addPublicKeyPins(r1, r2, r3, r4);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder enablePublicKeyPinningBypassForLocalTrustAnchors(boolean r1) {
            super.enablePublicKeyPinningBypassForLocalTrustAnchors(r1);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public ExperimentalCronetEngine build() {
            return this.mBuilderDelegate.build();
        }
    }

    public void addClientOpaqueData(String[] r1, byte[] r2, byte[] r3, long r4, long r6) {
    }

    public void addRequestFinishedListener(RequestFinishedInfo.Listener r1) {
    }

    public void addRttListener(NetworkQualityRttListener r1) {
    }

    public void addSamplingSetting(TTSamplingSettingProvider.TTSlaSamplingSetting r1) {
    }

    public void addThroughputListener(NetworkQualityThroughputListener r1) {
    }

    public void bindBigCore(int r1) {
    }

    public void bindLittleCore(int r1) {
    }

    public void bindToNetwork(long r1) {
    }

    public void clearClientOpaqueData() {
    }

    public void configureNetworkQualityEstimatorForTesting(boolean r1, boolean r2, boolean r3) {
    }

    public void enableTTBizHttpDns(boolean r1, String r2, String r3, String r4, boolean r5, String r6) {
    }

    public double getDownstreamPacketLossRate(int r1) {
        return -1.0d;
    }

    public double getDownstreamPacketLossRateVariance(int r1) {
        return -1.0d;
    }

    public int getDownstreamThroughputKbps() {
        return -1;
    }

    public int getEffectiveConnectionType() {
        return 0;
    }

    public int getEffectiveHttpRtt() {
        return -1;
    }

    public int getEffectiveRxThroughput() {
        return -1;
    }

    public int getEffectiveTransportRtt() {
        return -1;
    }

    public int getHttpRttMs() {
        return -1;
    }

    public int getNetworkQualityLevel() {
        return 0;
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public List<Long> getOpaqueFuncAddress() {
        return null;
    }

    public int getTransportRttMs() {
        return -1;
    }

    public double getUpstreamPacketLossRate(int r1) {
        return -1.0d;
    }

    public double getUpstreamPacketLossRateVariance(int r1) {
        return -1.0d;
    }

    public abstract ExperimentalBidirectionalStream.Builder newBidirectionalStreamBuilder(String r1, BidirectionalStream.Callback r2, Executor r3);

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public abstract ExperimentalUrlRequest.Builder newUrlRequestBuilder(String r1, UrlRequest.Callback r2, Executor r3);

    public void notifySwitchToMultiNetwork(boolean r1) {
    }

    public void notifyTNCConfigUpdated(String r1, String r2, String r3, String r4, String r5, String r6) {
    }

    public void preconnectUrl(String r1, int r2, Map<String, String> r3) {
    }

    public void registerAppInfoProvider(TTAppInfoProvider r1) {
    }

    public void registerAppMonitorProvider(TTMonitorProvider r1) {
    }

    public void registerEventListener(TTEventListener r1) {
    }

    public void removeClientOpaqueData(String r1) {
    }

    public void removeRequestFinishedListener(RequestFinishedInfo.Listener r1) {
    }

    public void removeRttListener(NetworkQualityRttListener r1) {
    }

    public void removeThroughputListener(NetworkQualityThroughputListener r1) {
    }

    public void reportNetDiagnosisUserLog(String r1) {
    }

    public void resetCoreBind(int r1) {
    }

    public void runInBackGround(boolean r1) {
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public void setAlogFuncAddr(long r1) {
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public void setAppStartUpState(int r1) {
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public void setCookieInitCompleted() {
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public void setHostResolverRules(String r1) {
    }

    public void setHttpDnsForTesting(boolean r1, boolean r2, boolean r3) {
    }

    public void setProxy(String r1) {
    }

    public void setRouteSelectionBestHost(String r1, String r2) {
    }

    public void setZstdFuncAddr(long r1, long r3, long r5, long r7, long r9, long r11, long r13, long r15) {
    }

    public void startNetLogToDisk(String r1, boolean r2, int r3) {
    }

    public void startThrottle(String[] r1, int r2, long r3) {
    }

    public void stopThrottle(String[] r1, int r2) {
    }

    public void triggerGetDomain(boolean r1) {
    }

    public void triggerWiFiToCellularByThirdParty() {
    }

    public void tryStartNetDetect(String[] r1, int r2, int r3) {
    }

    public void ttDnsResolve(String r1, int r2, String r3, Map<String, String> r4) {
    }

    public Map<String, String> ttUrlDispatch(String r1, int r2, boolean r3) throws IOException {
        return null;
    }

    public void updateStoreRegionFromServer(String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11) {
    }

    public ExperimentalCronetEngine() {
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public /* bridge */ /* synthetic */ UrlRequest.Builder newUrlRequestBuilder(String r1, UrlRequest.Callback r2, Executor r3) {
        return newUrlRequestBuilder(r1, r2, r3);
    }

    public Map<String, int[]> getGroupRttEstimates() {
        return new HashMap();
    }

    public URLConnection openConnection(URL r1, Proxy r2) throws IOException {
        return r1.openConnection(r2);
    }
}
