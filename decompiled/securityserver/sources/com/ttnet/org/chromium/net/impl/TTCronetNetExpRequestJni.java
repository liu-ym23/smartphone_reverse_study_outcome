package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
class TTCronetNetExpRequestJni implements TTCronetNetExpRequest.Natives {
    public static final JniStaticTestMocker<TTCronetNetExpRequest.Natives> TEST_HOOKS = null;
    private static TTCronetNetExpRequest.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public TTCronetNetExpRequestJni() {
    }

    public static /* synthetic */ TTCronetNetExpRequest.Natives access$002(TTCronetNetExpRequest.Natives r0) {
        testInstance = r0;
        return r0;
    }

    public static TTCronetNetExpRequest.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        TTCronetNetExpRequest.Natives r0 = testInstance;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.TTCronetNetExpRequest.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new TTCronetNetExpRequestJni();
    }

    @Override // com.ttnet.org.chromium.net.impl.TTCronetNetExpRequest.Natives
    public long createRequestAdapter(TTCronetNetExpRequest r1, long r2, int r4, String[] r5, int r6, int r7, int r8) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_TTCronetNetExpRequest_createRequestAdapter(r1, r2, r4, r5, r6, r7, r8);
    }

    @Override // com.ttnet.org.chromium.net.impl.TTCronetNetExpRequest.Natives
    public void destroy(long r1, TTCronetNetExpRequest r3) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_TTCronetNetExpRequest_destroy(r1, r3);
    }

    @Override // com.ttnet.org.chromium.net.impl.TTCronetNetExpRequest.Natives
    public void doExtraCommand(long r1, TTCronetNetExpRequest r3, String r4, String r5) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_TTCronetNetExpRequest_doExtraCommand(r1, r3, r4, r5);
    }

    @Override // com.ttnet.org.chromium.net.impl.TTCronetNetExpRequest.Natives
    public void start(long r1, TTCronetNetExpRequest r3) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_TTCronetNetExpRequest_start(r1, r3);
    }
}
