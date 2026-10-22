package com.ttnet.org.chromium.net;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ICronetEngineBuilder {
    public abstract ICronetEngineBuilder addPublicKeyPins(String r1, Set<byte[]> r2, boolean r3, Date r4);

    public abstract ICronetEngineBuilder addQuicHint(String r1, int r2, int r3);

    public abstract ExperimentalCronetEngine build();

    public abstract ICronetEngineBuilder enableBoeProxy(boolean r1);

    public ICronetEngineBuilder enableBrotli(boolean r1) {
        return this;
    }

    public abstract ICronetEngineBuilder enableHttp2(boolean r1);

    public abstract ICronetEngineBuilder enableHttpCache(int r1, long r2);

    public abstract ICronetEngineBuilder enableHttpDns(boolean r1);

    public ICronetEngineBuilder enableNetworkQualityEstimator(boolean r1) {
        return this;
    }

    public abstract ICronetEngineBuilder enablePublicKeyPinningBypassForLocalTrustAnchors(boolean r1);

    public abstract ICronetEngineBuilder enableQuic(boolean r1);

    public abstract ICronetEngineBuilder enableSdch(boolean r1);

    public abstract ICronetEngineBuilder enableTncSecureMode(boolean r1);

    public abstract ICronetEngineBuilder enableVerboseLog();

    public abstract String getDefaultUserAgent();

    public abstract ICronetEngineBuilder listenAppStateIndependently(boolean r1);

    public abstract ICronetEngineBuilder setALogFuncAddr(long r1);

    public abstract ICronetEngineBuilder setAppInfoProvider(TTAppInfoProvider r1);

    public abstract ICronetEngineBuilder setAppMonitorProvider(TTMonitorProvider r1);

    public abstract ICronetEngineBuilder setAppSecurityLevel(int r1);

    public abstract ICronetEngineBuilder setBypassBOEJSON(String r1);

    public abstract ICronetEngineBuilder setClientOpaqueData(Map<String[], Pair<byte[], byte[]>> r1);

    public abstract ICronetEngineBuilder setCronetSoPath(String r1);

    public abstract ICronetEngineBuilder setEventListener(TTEventListener r1);

    public abstract ICronetEngineBuilder setExperimentalOptions(String r1);

    public abstract ICronetEngineBuilder setGetDomainDefaultJSON(String r1);

    public abstract ICronetEngineBuilder setIsMainProcess(boolean r1);

    public abstract ICronetEngineBuilder setLazyInitIPC(boolean r1);

    public abstract ICronetEngineBuilder setLibraryLoader(CronetEngine.Builder.LibraryLoader r1);

    public abstract ICronetEngineBuilder setOpaqueData(ArrayList<byte[]> r1);

    public abstract ICronetEngineBuilder setOptInit(boolean r1);

    public abstract ICronetEngineBuilder setOptNqeInit(boolean r1, boolean r2);

    public abstract ICronetEngineBuilder setProcessName(String r1);

    public abstract ICronetEngineBuilder setProxyConfig(String r1);

    public abstract ICronetEngineBuilder setSlaSamplingSetting(TTSamplingSettingProvider.TTSlaSamplingSetting r1);

    public abstract ICronetEngineBuilder setStackInfo(boolean r1, String r2);

    public abstract ICronetEngineBuilder setStoragePath(String r1);

    public abstract ICronetEngineBuilder setStoreIdcRuleJSON(String r1);

    public abstract ICronetEngineBuilder setTTAppInfoColdStartSubset(TTAppInfoProvider.AppInfo r1);

    public abstract ICronetEngineBuilder setTTNetInitStart(long r1);

    public abstract ICronetEngineBuilder setThreadConfigCallbackImpl(TTThreadConfigInfoProvider.Callback r1);

    public abstract ICronetEngineBuilder setThreadConfigInfoList(ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r1);

    public ICronetEngineBuilder setThreadPriority(int r1) {
        return this;
    }

    public abstract ICronetEngineBuilder setUserAgent(String r1);

    public ICronetEngineBuilder() {
    }
}
