package com.ttnet.org.chromium.base.library_loader;

import androidx.annotation.NonNull;
import com.ttnet.org.chromium.base.Log;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes2.dex */
class LegacyLinker extends Linker {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "LegacyLinker";

    public LegacyLinker() {
    }

    private static native boolean nativeAddZipArchivePath(String r0);

    private static native boolean nativeCreateSharedRelro(String r0, long r1, Linker.LibInfo r3);

    private static native boolean nativeLoadLibrary(String r0, long r1, @NonNull Linker.LibInfo r3);

    private static native boolean nativeUseSharedRelro(String r0, Linker.LibInfo r1);

    private static void useSharedRelrosLocked(Linker.LibInfo r2) {
        String r0 = r2.mLibFilePath;
        if (nativeUseSharedRelro(r0, r2) == true) goto L6;
        Log.w(TAG, "Could not use shared RELRO section for %s", new Object[]{r0});
        return;
    }

    @Override // com.ttnet.org.chromium.base.library_loader.Linker
    public boolean keepMemoryReservationUntilLoad() {
        return false;
    }

    @Override // com.ttnet.org.chromium.base.library_loader.Linker
    @GuardedBy
    public void loadLibraryImplLocked(String r5, int r6) {
        String r7 = System.mapLibraryName(r5);
        Linker.LibInfo r0 = this.mLocalLibInfo;
        if (nativeLoadLibrary(r7, r0.mLoadAddress, r0) == false) goto L14;
        Linker.LibInfo r1 = this.mLocalLibInfo;
        r1.mLibFilePath = r7;
        if (r6 == 1) goto L10;
        if (r6 == 0) goto L10;
        waitForSharedRelrosLocked();
        useSharedRelrosLocked(this.mRemoteLibInfo);
        this.mRemoteLibInfo.close();
        this.mRemoteLibInfo = null;
        this.mState = 3;
        return;
    L10:
        if (nativeCreateSharedRelro(r7, r1.mLoadAddress, r1) == true) goto L12;
        Log.w(TAG, "Could not create shared RELRO for %s at %x", new Object[]{r7, Long.valueOf(this.mLocalLibInfo.mLoadAddress)});
        this.mLocalLibInfo.mRelroFd = -1;
    L12:
        useSharedRelrosLocked(this.mLocalLibInfo);
        this.mState = 2;
        return;
    L14:
        String r4 = a.a.A("Unable to load library: ", r7);
        Log.e(TAG, r4, new Object[0]);
        throw new UnsatisfiedLinkError(r4);
    }

    @Override // com.ttnet.org.chromium.base.library_loader.Linker
    public void setApkFilePath(String r1) {
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
}
