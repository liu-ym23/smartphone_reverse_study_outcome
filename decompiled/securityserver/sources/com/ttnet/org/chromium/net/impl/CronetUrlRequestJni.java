package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.natives.GEN_JNI;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
class CronetUrlRequestJni implements CronetUrlRequest.Natives {
    public static final JniStaticTestMocker<CronetUrlRequest.Natives> TEST_HOOKS = null;
    private static CronetUrlRequest.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public CronetUrlRequestJni() {
    }

    public static /* synthetic */ CronetUrlRequest.Natives access$002(CronetUrlRequest.Natives r0) {
        testInstance = r0;
        return r0;
    }

    public static CronetUrlRequest.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        CronetUrlRequest.Natives r0 = testInstance;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new CronetUrlRequestJni();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void abortWhenUploadException(long r1, CronetUrlRequest r3) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_abortWhenUploadException(r1, r3);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void addRequestCookieHeader(long r1, CronetUrlRequest r3, String r4, String r5) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_addRequestCookieHeader(r1, r3, r4, r5);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public boolean addRequestHeader(long r1, CronetUrlRequest r3, String r4, String r5) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_addRequestHeader(r1, r3, r4, r5);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void appTimeout(long r1, CronetUrlRequest r3) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_appTimeout(r1, r3);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public long createRequestAdapter(CronetUrlRequest r1, long r2, String r4, int r5, int r6, boolean r7, boolean r8, boolean r9, int r10, boolean r11, int r12, int r13, long r14) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_createRequestAdapter(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void destroy(long r1, CronetUrlRequest r3, boolean r4) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_destroy(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void followDeferredRedirect(long r1, CronetUrlRequest r3) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_followDeferredRedirect(r1, r3);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void getStatus(long r1, CronetUrlRequest r3, VersionSafeCallbacks.UrlRequestStatusListener r4) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_getStatus(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public boolean readData(long r1, CronetUrlRequest r3, ByteBuffer r4, int r5, int r6) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_readData(r1, r3, r4, r5, r6);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void removeRequestCookieHeader(long r1, CronetUrlRequest r3) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_removeRequestCookieHeader(r1, r3);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void setAuthCredentials(long r1, CronetUrlRequest r3, String r4, String r5) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_setAuthCredentials(r1, r3, r4, r5);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public boolean setHttpMethod(long r1, CronetUrlRequest r3, String r4) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_setHttpMethod(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void setRequestTimeout(long r1, CronetUrlRequest r3, int r4) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_setRequestTimeout(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void setRequestTypeFlags(long r1, CronetUrlRequest r3, int r4) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_setRequestTypeFlags(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void setSocketTimeout(long r1, CronetUrlRequest r3, int r4, int r5, int r6) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_setSocketTimeout(r1, r3, r4, r5, r6);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void setThrottleNetSpeed(long r1, CronetUrlRequest r3, long r4) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_setThrottleNetSpeed(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void start(long r1, CronetUrlRequest r3) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_start(r1, r3);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void stopRedirect(long r1, CronetUrlRequest r3) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_stopRedirect(r1, r3);
    }
}
