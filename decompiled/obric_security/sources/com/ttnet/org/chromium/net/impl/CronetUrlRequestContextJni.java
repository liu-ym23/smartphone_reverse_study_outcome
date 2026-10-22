package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.ttnet.org.chromium.net.TTSamplingSettingProvider;
import com.ttnet.org.chromium.net.TTThreadConfigInfoProvider;

/* JADX INFO: loaded from: classes3.dex */
class CronetUrlRequestContextJni implements CronetUrlRequestContext.Natives {
    public static final JniStaticTestMocker<CronetUrlRequestContext.Natives> TEST_HOOKS = null;
    private static CronetUrlRequestContext.Natives testInstance;

    CronetUrlRequestContextJni() {
    }

    static /* synthetic */ CronetUrlRequestContext.Natives access$002(CronetUrlRequestContext.Natives r0) {
        testInstance = r0;
        return r0;
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public long createRequestContextConfig(String r3, String r4, boolean r5, String r6, boolean r7, boolean r8, boolean r9, int r10, long r11, String r13, long r14, boolean r16, boolean r17, int r18) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_createRequestContextConfig(r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14, r16, r17, r18);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void addQuicHint(long r1, String r3, int r4, int r5) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_addQuicHint(r1, r3, r4, r5);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void addPkp(long r1, String r3, byte[][] r4, boolean r5, long r6) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_addPkp(r1, r3, r4, r5, r6);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public long createRequestContextAdapter(long r1) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_createRequestContextAdapter(r1);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public int setMinLogLevel(int r1) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setMinLogLevel(r1);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public byte[] getHistogramDeltas() {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_getHistogramDeltas();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void destroy(long r1, CronetUrlRequestContext r3) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_destroy(r1, r3);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public boolean startNetLogToFile(long r1, CronetUrlRequestContext r3, String r4, boolean r5) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_startNetLogToFile(r1, r3, r4, r5);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void startNetLogToDisk(long r1, CronetUrlRequestContext r3, String r4, boolean r5, int r6) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_startNetLogToDisk(r1, r3, r4, r5, r6);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void stopNetLog(long r1, CronetUrlRequestContext r3) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_stopNetLog(r1, r3);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void initRequestContextOnInitThread(long r1, CronetUrlRequestContext r3) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_initRequestContextOnInitThread(r1, r3);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void configureNetworkQualityEstimatorForTesting(long r1, CronetUrlRequestContext r3, boolean r4, boolean r5, boolean r6) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_configureNetworkQualityEstimatorForTesting(r1, r3, r4, r5, r6);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void provideRTTObservations(long r1, CronetUrlRequestContext r3, boolean r4) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_provideRTTObservations(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setTTNetInitConfig(long r1, int r3, boolean r4, boolean r5, String r6, String r7, String r8, boolean r9, String r10, String r11, byte[][] r12, TTThreadConfigInfoProvider.ThreadConfigInfo[] r13, boolean r14, boolean r15, boolean r16, String r17, TTAppInfoProvider.AppInfo r18, long r19, boolean r21, boolean r22, boolean r23, TTSamplingSettingProvider.TTSlaSamplingSetting r24, boolean r25, String r26) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setTTNetInitConfig(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r21, r22, r23, r24, r25, r26);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setClientOpaqueData(long r1, String[] r3, byte[] r4, byte[] r5) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setClientOpaqueData(r1, r3, r4, r5);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void initALogFuncAddr(long r1) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_initALogFuncAddr(r1);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public long[] getOpaqueFuncAddress() {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_getOpaqueFuncAddress();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void parseTNCConfigFromSystemHTTPRequest(long r1, CronetUrlRequestContext r3, String r4, String r5, String r6, String r7, String r8, String r9) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_parseTNCConfigFromSystemHTTPRequest(r1, r3, r4, r5, r6, r7, r8, r9);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void triggerTNCRequestByUser(long r1, CronetUrlRequestContext r3, boolean r4) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_triggerTNCRequestByUser(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void ttUrlDispatch(long r1, CronetUrlRequestContext r3, URLDispatch r4, String r5, boolean r6) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_ttUrlDispatch(r1, r3, r4, r5, r6);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void runInBackGround(long r1, CronetUrlRequestContext r3, boolean r4) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_runInBackGround(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void addClientOpaqueData(long r1, CronetUrlRequestContext r3, String[] r4, byte[] r5, byte[] r6, long r7, long r9) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_addClientOpaqueData(r1, r3, r4, r5, r6, r7, r9);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void clearClientOpaqueData(long r1, CronetUrlRequestContext r3) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_clearClientOpaqueData(r1, r3);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void removeClientOpaqueData(long r1, CronetUrlRequestContext r3, String r4) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_removeClientOpaqueData(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setProxy(long r1, CronetUrlRequestContext r3, String r4) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setProxy(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void preconnectUrl(long r1, CronetUrlRequestContext r3, String r4, int r5, String r6) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_preconnectUrl(r1, r3, r4, r5, r6);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void ttDnsResolve(long r1, CronetUrlRequestContext r3, String r4, int r5, String r6, String r7) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_ttDnsResolve(r1, r3, r4, r5, r6, r7);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void controlHttpDNSConfig(long r1, CronetUrlRequestContext r3, boolean r4, boolean r5, boolean r6) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_controlHttpDNSConfig(r1, r3, r4, r5, r6);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setHostResolverRules(long r1, CronetUrlRequestContext r3, String r4) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setHostResolverRules(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void addSamplingSetting(long r1, CronetUrlRequestContext r3, TTSamplingSettingProvider.TTSlaSamplingSetting r4) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_addSamplingSetting(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void tryStartNetDetect(long r1, CronetUrlRequestContext r3, String[] r4, int r5, int r6) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_tryStartNetDetect(r1, r3, r4, r5, r6);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void updateStoreRegionFromServer(long r1, CronetUrlRequestContext r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_updateStoreRegionFromServer(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setAlogFuncAddr(long r1, CronetUrlRequestContext r3, long r4) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setAlogFuncAddr(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setZstdFuncAddr(long r1, CronetUrlRequestContext r3, long r4, long r6, long r8, long r10, long r12, long r14, long r16, long r18) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setZstdFuncAddr(r1, r3, r4, r6, r8, r10, r12, r14, r16, r18);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setRouteSelectionBestHost(long r1, CronetUrlRequestContext r3, String r4, String r5) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setRouteSelectionBestHost(r1, r3, r4, r5);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void startThrottle(long r1, CronetUrlRequestContext r3, String[] r4, int r5, long r6) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_startThrottle(r1, r3, r4, r5, r6);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void stopThrottle(long r1, CronetUrlRequestContext r3, String[] r4, int r5) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_stopThrottle(r1, r3, r4, r5);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void enableTTBizHttpDns(long r1, CronetUrlRequestContext r3, boolean r4, String r5, String r6, String r7, boolean r8, String r9) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_enableTTBizHttpDns(r1, r3, r4, r5, r6, r7, r8, r9);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void notifySwitchToMultiNetwork(long r1, CronetUrlRequestContext r3, boolean r4) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_notifySwitchToMultiNetwork(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void triggerWiFiToCellularByThirdParty(long r1, CronetUrlRequestContext r3) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_triggerWiFiToCellularByThirdParty(r1, r3);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setAppStartUpState(long r1, CronetUrlRequestContext r3, int r4) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setAppStartUpState(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setCookieInitCompleted(long r1, CronetUrlRequestContext r3) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setCookieInitCompleted(r1, r3);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void reportNetDiagnosisUserLog(long r1, CronetUrlRequestContext r3, String r4) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_reportNetDiagnosisUserLog(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void provideThroughputObservations(long r1, CronetUrlRequestContext r3, boolean r4) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_provideThroughputObservations(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public boolean skipLogging(long r1, CronetUrlRequestContext r3) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_skipLogging(r1, r3);
    }

    public static CronetUrlRequestContext.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        CronetUrlRequestContext.Natives r0 = testInstance;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new CronetUrlRequestContextJni();
    }
}
