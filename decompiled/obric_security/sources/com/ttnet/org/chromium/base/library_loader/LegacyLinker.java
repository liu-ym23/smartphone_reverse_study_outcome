package com.ttnet.org.chromium.base.library_loader;

import com.ttnet.org.chromium.base.Log;

/* JADX INFO: loaded from: classes4.dex */
class LegacyLinker extends Linker {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "LegacyLinker";

    static {
    }

    private static native boolean nativeAddZipArchivePath(String r0);

    private static native boolean nativeCreateSharedRelro(String r0, long r1, Linker.LibInfo r3);

    private static native boolean nativeLoadLibrary(String r0, long r1, Linker.LibInfo r3);

    private static native boolean nativeUseSharedRelro(String r0, Linker.LibInfo r1);

    @Override // com.ttnet.org.chromium.base.library_loader.Linker
    protected boolean keepMemoryReservationUntilLoad() {
        return false;
    }

    LegacyLinker() {
    }

    @Override // com.ttnet.org.chromium.base.library_loader.Linker
    void setApkFilePath(String r1) {
        ensureInitializedImplicitlyAsLastResort();
        Object r0 = this.mLock;
        monitor-enter(r0);
        nativeAddZipArchivePath(r1);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.base.library_loader.Linker
    protected void loadLibraryImplLocked(String r7, int r8) {
        String r9 = System.mapLibraryName(r7);
        if (nativeLoadLibrary(r9, this.mLocalLibInfo.mLoadAddress, this.mLocalLibInfo) == false) goto L14;
        this.mLocalLibInfo.mLibFilePath = r9;
        if (r8 == 1) goto L10;
        if (r8 == 0) goto L10;
        waitForSharedRelrosLocked();
        useSharedRelrosLocked(this.mRemoteLibInfo);
        this.mRemoteLibInfo.close();
        this.mRemoteLibInfo = null;
        this.mState = 3;
        return;
    L10:
        if (nativeCreateSharedRelro(r9, this.mLocalLibInfo.mLoadAddress, this.mLocalLibInfo) == true) goto L12;
        Log.w(TAG, "Could not create shared RELRO for %s at %x", new Object[]{r9, Long.valueOf(this.mLocalLibInfo.mLoadAddress)});
        this.mLocalLibInfo.mRelroFd = -1;
    L12:
        useSharedRelrosLocked(this.mLocalLibInfo);
        this.mState = 2;
        return;
    L14:
        String r6 = "Unable to load library: " + r9;
        Log.e(TAG, r6, new Object[0]);
        throw new UnsatisfiedLinkError(r6);
    }

    private static void useSharedRelrosLocked(Linker.LibInfo r2) {
        String r0 = r2.mLibFilePath;
        if (nativeUseSharedRelro(r0, r2) == true) goto L6;
        Log.w(TAG, "Could not use shared RELRO section for %s", new Object[]{r0});
        return;
    }
}
