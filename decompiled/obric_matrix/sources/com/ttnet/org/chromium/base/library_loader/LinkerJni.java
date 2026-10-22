package com.ttnet.org.chromium.base.library_loader;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
class LinkerJni implements Linker.Natives {
    LinkerJni() {
    }

    private static native void nativeFindMemoryRegionAtRandomAddress(@NonNull Linker.LibInfo r0, boolean r1);

    private static native boolean nativeFindRegionReservedByWebViewZygote(@NonNull Linker.LibInfo r0);

    private static native void nativeReserveMemoryForLibrary(@NonNull Linker.LibInfo r0);

    @Override // com.ttnet.org.chromium.base.library_loader.Linker.Natives
    public void findMemoryRegionAtRandomAddress(@NonNull Linker.LibInfo r1, boolean r2) {
        nativeFindMemoryRegionAtRandomAddress(r1, r2);
    }

    @Override // com.ttnet.org.chromium.base.library_loader.Linker.Natives
    public boolean findRegionReservedByWebViewZygote(@NonNull Linker.LibInfo r1) {
        return nativeFindRegionReservedByWebViewZygote(r1);
    }

    @Override // com.ttnet.org.chromium.base.library_loader.Linker.Natives
    public void reserveMemoryForLibrary(@NonNull Linker.LibInfo r1) {
        nativeReserveMemoryForLibrary(r1);
    }
}
