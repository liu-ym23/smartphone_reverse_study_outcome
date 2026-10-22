package com.ttnet.org.chromium.base.library_loader;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes5.dex */
@MainDex
class LibraryLoaderJni implements LibraryLoader.Natives {
    public static final JniStaticTestMocker<LibraryLoader.Natives> TEST_HOOKS = null;
    private static LibraryLoader.Natives testInstance;

    LibraryLoaderJni() {
    }

    static /* synthetic */ LibraryLoader.Natives access$002(LibraryLoader.Natives r0) {
        testInstance = r0;
        return r0;
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    @Override // com.ttnet.org.chromium.base.library_loader.LibraryLoader.Natives
    public boolean libraryLoaded(int r1) {
        return GEN_JNI.com_ttnet_org_chromium_base_library_1loader_LibraryLoader_libraryLoaded(r1);
    }

    @Override // com.ttnet.org.chromium.base.library_loader.LibraryLoader.Natives
    public void registerNonMainDexJni() {
        GEN_JNI.com_ttnet_org_chromium_base_library_1loader_LibraryLoader_registerNonMainDexJni();
    }

    public static LibraryLoader.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        LibraryLoader.Natives r0 = testInstance;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.library_loader.LibraryLoader.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new LibraryLoaderJni();
    }
}
