package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
class CronetUploadDataStreamJni implements CronetUploadDataStream.Natives {
    public static final JniStaticTestMocker<CronetUploadDataStream.Natives> TEST_HOOKS = null;
    private static CronetUploadDataStream.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public CronetUploadDataStreamJni() {
    }

    public static /* synthetic */ CronetUploadDataStream.Natives access$002(CronetUploadDataStream.Natives r0) {
        testInstance = r0;
        return r0;
    }

    public static CronetUploadDataStream.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        CronetUploadDataStream.Natives r0 = testInstance;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new CronetUploadDataStreamJni();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives
    public long attachUploadDataToRequest(CronetUploadDataStream r1, long r2, long r4) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUploadDataStream_attachUploadDataToRequest(r1, r2, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives
    public long createAdapterForTesting(CronetUploadDataStream r1) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUploadDataStream_createAdapterForTesting(r1);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives
    public long createUploadDataStreamForTesting(CronetUploadDataStream r1, long r2, long r4) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUploadDataStream_createUploadDataStreamForTesting(r1, r2, r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives
    public void destroy(long r1) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUploadDataStream_destroy(r1);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives
    public void onReadSucceeded(long r1, CronetUploadDataStream r3, int r4, boolean r5) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUploadDataStream_onReadSucceeded(r1, r3, r4, r5);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives
    public void onRewindSucceeded(long r1, CronetUploadDataStream r3) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUploadDataStream_onRewindSucceeded(r1, r3);
    }
}
