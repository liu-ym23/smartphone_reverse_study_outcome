package com.ttnet.org.chromium.base.library_loader;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
@MainDex
class LibraryPrefetcherJni implements LibraryPrefetcher.Natives {
    public static final JniStaticTestMocker<LibraryPrefetcher.Natives> TEST_HOOKS = null;
    private static LibraryPrefetcher.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public LibraryPrefetcherJni() {
    }

    public static /* synthetic */ LibraryPrefetcher.Natives access$002(LibraryPrefetcher.Natives r0) {
        testInstance = r0;
        return r0;
    }

    public static LibraryPrefetcher.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        LibraryPrefetcher.Natives r0 = testInstance;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.library_loader.LibraryPrefetcher.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new LibraryPrefetcherJni();
    }

    @Override // com.ttnet.org.chromium.base.library_loader.LibraryPrefetcher.Natives
    public void forkAndPrefetchNativeLibrary() {
        GEN_JNI.com_ttnet_org_chromium_base_library_1loader_LibraryPrefetcher_forkAndPrefetchNativeLibrary();
    }

    @Override // com.ttnet.org.chromium.base.library_loader.LibraryPrefetcher.Natives
    public int percentageOfResidentNativeLibraryCode() {
        return GEN_JNI.com_ttnet_org_chromium_base_library_1loader_LibraryPrefetcher_percentageOfResidentNativeLibraryCode();
    }

    @Override // com.ttnet.org.chromium.base.library_loader.LibraryPrefetcher.Natives
    public void periodicallyCollectResidency() {
        GEN_JNI.com_ttnet_org_chromium_base_library_1loader_LibraryPrefetcher_periodicallyCollectResidency();
    }
}
