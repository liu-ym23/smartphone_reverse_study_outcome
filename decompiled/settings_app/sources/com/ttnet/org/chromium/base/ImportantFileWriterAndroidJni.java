package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes5.dex */
class ImportantFileWriterAndroidJni implements ImportantFileWriterAndroid.Natives {
    public static final JniStaticTestMocker<ImportantFileWriterAndroid.Natives> TEST_HOOKS = null;
    private static ImportantFileWriterAndroid.Natives testInstance;

    ImportantFileWriterAndroidJni() {
    }

    static /* synthetic */ ImportantFileWriterAndroid.Natives access$002(ImportantFileWriterAndroid.Natives r0) {
        testInstance = r0;
        return r0;
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    @Override // com.ttnet.org.chromium.base.ImportantFileWriterAndroid.Natives
    public boolean writeFileAtomically(String r1, byte[] r2) {
        return GEN_JNI.com_ttnet_org_chromium_base_ImportantFileWriterAndroid_writeFileAtomically(r1, r2);
    }

    public static ImportantFileWriterAndroid.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        ImportantFileWriterAndroid.Natives r0 = testInstance;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.ImportantFileWriterAndroid.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new ImportantFileWriterAndroidJni();
    }
}
