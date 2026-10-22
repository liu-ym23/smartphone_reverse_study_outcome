package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes5.dex */
class HttpUtilJni implements HttpUtil.Natives {
    public static final JniStaticTestMocker<HttpUtil.Natives> TEST_HOOKS = null;
    private static HttpUtil.Natives testInstance;

    HttpUtilJni() {
    }

    static /* synthetic */ HttpUtil.Natives access$002(HttpUtil.Natives r0) {
        testInstance = r0;
        return r0;
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    @Override // com.ttnet.org.chromium.net.HttpUtil.Natives
    public boolean isAllowedHeader(String r1, String r2) {
        return GEN_JNI.com_ttnet_org_chromium_net_HttpUtil_isAllowedHeader(r1, r2);
    }

    public static HttpUtil.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        HttpUtil.Natives r0 = testInstance;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.HttpUtil.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new HttpUtilJni();
    }
}
