package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
class CronetFrontierClientJni implements CronetFrontierClient.Natives {
    public static final JniStaticTestMocker<CronetFrontierClient.Natives> TEST_HOOKS = null;
    private static CronetFrontierClient.Natives testInstance;

    CronetFrontierClientJni() {
    }

    static /* synthetic */ CronetFrontierClient.Natives access$002(CronetFrontierClient.Natives r0) {
        testInstance = r0;
        return r0;
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public long createFrontierClientAdapter(CronetFrontierClient r1) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_createFrontierClientAdapter(r1);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public void addHeader(long r1, CronetFrontierClient r3, String r4, String r5) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_addHeader(r1, r3, r4, r5);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public void addServiceId(long r1, CronetFrontierClient r3, int r4) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_addServiceId(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public void configParams(long r1, CronetFrontierClient r3, int r4, int r5, String r6, int r7, String r8, String r9, String r10, String r11, int r12, int r13, int r14, boolean r15, String r16, String r17) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_configParams(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public void registerService(long r1, CronetFrontierClient r3, String[] r4, ByteBuffer r5, int r6, int r7, boolean r8) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_registerService(r1, r3, r4, r5, r6, r7, r8);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public void unregisterService(long r1, CronetFrontierClient r3, int r4) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_unregisterService(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public boolean isServiceReady(long r1, CronetFrontierClient r3, int r4) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_isServiceReady(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public void sendMessage(long r1, CronetFrontierClient r3, int r4, String[] r5, ByteBuffer r6) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_sendMessage(r1, r3, r4, r5, r6);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public void reportAppStateChange(long r1, CronetFrontierClient r3, boolean r4) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_reportAppStateChange(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public void destroy(long r1, CronetFrontierClient r3) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_destroy(r1, r3);
    }

    public static CronetFrontierClient.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        CronetFrontierClient.Natives r0 = testInstance;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new CronetFrontierClientJni();
    }
}
