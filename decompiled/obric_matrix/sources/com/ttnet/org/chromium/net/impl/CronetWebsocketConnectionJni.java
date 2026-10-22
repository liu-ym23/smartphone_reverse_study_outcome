package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.natives.GEN_JNI;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
class CronetWebsocketConnectionJni implements CronetWebsocketConnection.Natives {
    public static final JniStaticTestMocker<CronetWebsocketConnection.Natives> TEST_HOOKS = null;
    private static CronetWebsocketConnection.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    CronetWebsocketConnectionJni() {
    }

    static /* synthetic */ CronetWebsocketConnection.Natives access$002(CronetWebsocketConnection.Natives r0) {
        testInstance = r0;
        return r0;
    }

    public static CronetWebsocketConnection.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        CronetWebsocketConnection.Natives r0 = testInstance;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new CronetWebsocketConnectionJni();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void addGetParam(long r1, CronetWebsocketConnection r3, String r4, String r5) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_addGetParam(r1, r3, r4, r5);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void addHeader(long r1, CronetWebsocketConnection r3, String r4, String r5) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_addHeader(r1, r3, r4, r5);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void addUrl(long r1, CronetWebsocketConnection r3, String r4) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_addUrl(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public long createWebsocketConnectionAdapter(CronetWebsocketConnection r1, long r2) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_createWebsocketConnectionAdapter(r1, r2);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void destroy(long r1, CronetWebsocketConnection r3) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_destroy(r1, r3);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void sendBinary(long r1, CronetWebsocketConnection r3, ByteBuffer r4) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_sendBinary(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void sendText(long r1, CronetWebsocketConnection r3, String r4) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_sendText(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void startWithFrontier(long r1, CronetWebsocketConnection r3, int r4, String r5, long r6, int r8, long r9, String r11, int r12, String r13, boolean r14) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_startWithFrontier(r1, r3, r4, r5, r6, r8, r9, r11, r12, r13, r14);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void startWithWSChannel(long r1, CronetWebsocketConnection r3, boolean r4) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_startWithWSChannel(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void stop(long r1, CronetWebsocketConnection r3) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_stop(r1, r3);
    }
}
