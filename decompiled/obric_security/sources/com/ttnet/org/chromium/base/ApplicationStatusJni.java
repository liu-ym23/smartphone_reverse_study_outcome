package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes4.dex */
class ApplicationStatusJni implements ApplicationStatus.Natives {
    public static final JniStaticTestMocker<ApplicationStatus.Natives> TEST_HOOKS = null;
    private static ApplicationStatus.Natives testInstance;

    ApplicationStatusJni() {
    }

    static /* synthetic */ ApplicationStatus.Natives access$002(ApplicationStatus.Natives r0) {
        testInstance = r0;
        return r0;
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    @Override // com.ttnet.org.chromium.base.ApplicationStatus.Natives
    public void onApplicationStateChange(int r1) {
        GEN_JNI.com_ttnet_org_chromium_base_ApplicationStatus_onApplicationStateChange(r1);
    }

    public static ApplicationStatus.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        ApplicationStatus.Natives r0 = testInstance;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.ApplicationStatus.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new ApplicationStatusJni();
    }
}
