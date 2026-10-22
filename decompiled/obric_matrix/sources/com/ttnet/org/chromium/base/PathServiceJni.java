package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
class PathServiceJni implements PathService.Natives {
    public static final JniStaticTestMocker<PathService.Natives> TEST_HOOKS = null;
    private static PathService.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    PathServiceJni() {
    }

    static /* synthetic */ PathService.Natives access$002(PathService.Natives r0) {
        testInstance = r0;
        return r0;
    }

    public static PathService.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        PathService.Natives r0 = testInstance;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.PathService.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new PathServiceJni();
    }

    @Override // com.ttnet.org.chromium.base.PathService.Natives
    public void override(int r1, String r2) {
        GEN_JNI.com_ttnet_org_chromium_base_PathService_override(r1, r2);
    }
}
