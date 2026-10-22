package com.ttnet.org.chromium.base.library_loader;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bytedance.librarian.LibrarianImpl;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.StreamUtil;
import com.ttnet.org.chromium.base.TimeUtils;
import com.ttnet.org.chromium.base.annotations.AccessedByNative;
import com.ttnet.org.chromium.base.metrics.RecordHistogram;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes2.dex */
abstract class Linker {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String BASE_LOAD_ADDRESS = "com.ttnet.org.chromium.base.android.linker.base_load_address";
    protected static final boolean DEBUG = false;
    protected static final String LINKER_JNI_LIBRARY = "chromium_android_linker";

    @VisibleForTesting(otherwise = 2)
    static final String SHARED_RELROS = "com.ttnet.org.chromium.base.android.linker.shared_relros";
    private static final String TAG = "Linker";
    private static Linker sLinkerForAssert;
    private static Natives sNativesInstance;

    @GuardedBy
    private boolean mLinkerWasWaitingSynchronously;

    @GuardedBy
    protected LibInfo mLocalLibInfo;
    protected final Object mLock;

    @GuardedBy
    @VisibleForTesting(otherwise = 2)
    boolean mRelroProducer;

    @GuardedBy
    protected LibInfo mRemoteLibInfo;

    @GuardedBy
    protected int mState;

    @GuardedBy
    @VisibleForTesting(otherwise = 2)
    WebViewReservationSearchResult mWebviewReservationSearchResult;

    @VisibleForTesting(otherwise = 4)
    public static class LibInfo implements Parcelable {
        public static final Parcelable.Creator<LibInfo> CREATOR = null;
        private static final String EXTRA_LINKER_LIB_INFO = "libinfo";
        public String mLibFilePath;

        @AccessedByNative
        public long mLoadAddress;

        @AccessedByNative
        public long mLoadSize;

        @AccessedByNative
        public int mRelroFd;

        @AccessedByNative
        public long mRelroSize;

        @AccessedByNative
        public long mRelroStart;

        static {
            CREATOR = new AnonymousClass1();
        }

        public LibInfo() {
            this.mRelroFd = -1;
        }

        public static LibInfo fromBundle(Bundle r1) {
            r1.setClassLoader(Linker.class.getClassLoader());
            return (LibInfo) r1.getParcelable(EXTRA_LINKER_LIB_INFO);
        }

        public void close() {
            int r0 = this.mRelroFd;
            if (r0 < 0) goto L6;
            StreamUtil.closeQuietly(ParcelFileDescriptor.adoptFd(r0));
            this.mRelroFd = -1;
            return;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 1;
        }

        public Bundle toBundle() {
            Bundle r0 = new Bundle();
            r0.putParcelable(EXTRA_LINKER_LIB_INFO, this);
            return r0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r3, int r4) {
            r3.writeString(this.mLibFilePath);
            r3.writeLong(this.mLoadAddress);
            r3.writeLong(this.mLoadSize);
            r3.writeLong(this.mRelroStart);
            r3.writeLong(this.mRelroSize);
            if (this.mRelroFd < 0) goto L5;
            int r5 = 1;
        L6:
            r3.writeInt(r5);
            int r2 = this.mRelroFd;
            if (r2 < 0) goto L15;
            ParcelFileDescriptor r6 = ParcelFileDescriptor.fromFd(r2);     // Catch: IOException -> L10
            r6.writeToParcel(r3, 0);     // Catch: IOException -> L10
            r6.close();     // Catch: IOException -> L10
            return;
        L10:
            e = move-exception;
            Log.e(Linker.TAG, "Can't write LibInfo file descriptor to parcel", new Object[]{e});
            return;
        L15:
            return;
        L5:
            r5 = 0;
            goto L6
        }

        public LibInfo(Parcel r4) {
            this.mRelroFd = -1;
            this.mLibFilePath = r4.readString();
            this.mLoadAddress = r4.readLong();
            this.mLoadSize = r4.readLong();
            this.mRelroStart = r4.readLong();
            this.mRelroSize = r4.readLong();
            if (r4.readInt() == 0) goto L7;
            ParcelFileDescriptor r5 = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(r4);
            if (r5 == null) goto L9;
            this.mRelroFd = r5.detachFd();
            return;
        L9:
            return;
        L7:
            this.mRelroFd = -1;
        }
    }

    public interface Natives {
        void findMemoryRegionAtRandomAddress(@NonNull LibInfo r1, boolean r2);

        boolean findRegionReservedByWebViewZygote(@NonNull LibInfo r1);

        void reserveMemoryForLibrary(@NonNull LibInfo r1);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface PreferAddress {
        public static final int FIND_RESERVED = 0;
        public static final int RESERVE_HINT = 1;
        public static final int RESERVE_RANDOM = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RelroSharingMode {
        public static final int CONSUME = 2;
        public static final int NO_SHARING = 0;
        public static final int PRODUCE = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
        public static final int DONE = 3;
        public static final int DONE_PROVIDE_RELRO = 2;
        public static final int INITIALIZED = 1;
        public static final int UNINITIALIZED = 0;
    }

    public static class WebViewReservationSearchResult {
        private final long mDurationMs;
        private final boolean mSuccess;

        public WebViewReservationSearchResult(boolean r1, long r2) {
            this.mSuccess = r1;
            this.mDurationMs = r2;
        }

        public static /* synthetic */ void access$000(WebViewReservationSearchResult r0, String r1) {
            r0.recordHistograms(r1);
        }

        private void recordHistograms(String r4) {
            if (this.mSuccess == false) goto L5;
            String r0 = "Found";
        L6:
            RecordHistogram.recordTimesHistogram("ChromiumAndroidLinker.TimeToFindWebViewReservation." + r0 + LibrarianImpl.Constants.DOT + r4, this.mDurationMs);
            return;
        L5:
            r0 = "NotFound";
            goto L6
        }
    }

    public Linker() {
        this.mLock = new Object();
        this.mRelroProducer = true;
        this.mState = 0;
        sLinkerForAssert = this;
    }

    @GuardedBy
    private void attemptLoadLibraryLocked(String r2, int r3) {
        loadLibraryImplLocked(r2, r3);     // Catch: Throwable -> L7
        if (shouldAtomicallyReplaceRelroAfterLoad() == false) goto L9;
        atomicReplaceRelroLocked(true);     // Catch: Throwable -> L7
    L9:
        this.mLinkerWasWaitingSynchronously = false;
        return;
    L7:
        th = move-exception;
        this.mLinkerWasWaitingSynchronously = false;
        throw th;
    }

    @GuardedBy
    private void chooseAndReserveMemoryRange(boolean r6, int r7, long r8) {
        this.mLocalLibInfo = new LibInfo();
        this.mRelroProducer = r6;
        loadLinkerJniLibraryLocked();
        boolean r9 = keepMemoryReservationUntilLoad();
        if (r7 != 0) goto L5;
        TimeUtils.UptimeMillisTimer r10 = new TimeUtils.UptimeMillisTimer();
        boolean r2 = getLinkerJni().findRegionReservedByWebViewZygote(this.mLocalLibInfo);
        saveWebviewReservationSearchStats(r2, r10.getElapsedMillis());
        if (r2 == true) goto L12;
    L16:
        this.mLocalLibInfo.mLoadAddress = r8;
        if (r8 == 0) goto L23;
        if (r9 == true) goto L20;
        return;
    L20:
        getLinkerJni().reserveMemoryForLibrary(this.mLocalLibInfo);
        if (this.mLocalLibInfo.mLoadAddress == 0) goto L23;
        return;
    L23:
        getLinkerJni().findMemoryRegionAtRandomAddress(this.mLocalLibInfo, r9);
        return;
    L12:
        if (r8 != 0) goto L14;
        return;
    L14:
        if (r8 != this.mLocalLibInfo.mLoadAddress) goto L16;
        return;
    L5:
        if (r7 == 1) goto L16;
        if (r7 == 2) goto L23;
    }

    public static long extractLoadAddressFromBundle(Bundle r3) {
        return r3.getLong(BASE_LOAD_ADDRESS, 0);
    }

    @VisibleForTesting(otherwise = 2)
    public static Natives getLinkerJni() {
        Natives r0 = sNativesInstance;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return new LinkerJni();
    }

    private String preferAddressToString(int r1) {
        if (r1 != 0) goto L4;
        return "FIND_RESERVED";
    L4:
        if (r1 != 1) goto L6;
        return "RESERVE_HINT";
    L6:
        if (r1 != 2) goto L8;
        return "RESERVE_RANDOM";
    L8:
        return String.valueOf(r1);
    }

    @GuardedBy
    private void saveWebviewReservationSearchStats(boolean r2, long r3) {
        this.mWebviewReservationSearchResult = new WebViewReservationSearchResult(r2, r3);
    }

    public static void setNativesForTesting(Natives r0) {
        sNativesInstance = r0;
        sLinkerForAssert = null;
    }

    @GuardedBy
    private boolean shouldAtomicallyReplaceRelroAfterLoad() {
        if (this.mLinkerWasWaitingSynchronously == false) goto L6;
        return false;
    L6:
        if (this.mRemoteLibInfo != null) goto L8;
        return false;
    L8:
        if (this.mState == 3) goto L10;
        return false;
    L10:
        if (this.mLocalLibInfo.mLoadAddress == 0) goto L15;
        return true;
    L15:
        return false;
    }

    public void atomicReplaceRelroLocked(boolean r1) {
    }

    public final void ensureInitialized(boolean r3, int r4, long r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mState == 0) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        chooseAndReserveMemoryRange(r3, r4, r5);     // Catch: Throwable -> L8
        this.mState = 1;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    public final void ensureInitializedImplicitlyAsLastResort() {
        ensureInitialized(true, 2, 0);
    }

    @VisibleForTesting(otherwise = 2)
    public boolean isNonZeroLoadAddress(LibInfo r3) {
        if (r3 != null) goto L4;
    L6:
        return false;
    L4:
        if (r3.mLoadAddress == 0) goto L6;
        return true;
    }

    public abstract boolean keepMemoryReservationUntilLoad();

    public final void loadLibrary(String r7) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ensureInitializedImplicitlyAsLastResort();     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
        if (this.mRelroProducer == false) goto L7;
        int r1 = 1;
    L8:
        attemptLoadLibraryLocked(r7, r1);     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L12
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L7:
        r1 = 2;
    L10:
        th = move-exception;
        throw th;
    L12:
        Log.w(TAG, "Failed to load native library with shared RELRO, retrying without", new Object[0]);     // Catch: Throwable -> L10
        this.mLocalLibInfo.mLoadAddress = 0;     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L16
        attemptLoadLibraryLocked(r7, 0);     // Catch: Throwable -> L10 UnsatisfiedLinkError -> L16
    L16:
        e = move-exception;
        Log.w(TAG, "Failed to load native library without RELRO sharing", new Object[0]);     // Catch: Throwable -> L10
        throw e;     // Catch: Throwable -> L10
    }

    public abstract void loadLibraryImplLocked(String r1, int r2);

    @GuardedBy
    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    @VisibleForTesting(otherwise = 2)
    public void loadLinkerJniLibraryLocked() {
        LibraryLoader.setEnvForNative();
        System.loadLibrary(LINKER_JNI_LIBRARY);
    }

    public void pretendLibraryIsLoadedForTesting() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mState = 3;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void putLoadAddressToBundle(Bundle r6) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        LibInfo r5 = this.mLocalLibInfo;     // Catch: Throwable -> L9
        if (r5 == null) goto L11;
        long r1 = r5.mLoadAddress;     // Catch: Throwable -> L9
        if (r1 == 0) goto L11;
        r6.putLong(BASE_LOAD_ADDRESS, r1);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void putSharedRelrosToBundle(Bundle r4) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mState != 2) goto L9;
        Bundle r3 = this.mLocalLibInfo.toBundle();     // Catch: Throwable -> L7
    L10:
        r4.putBundle(SHARED_RELROS, r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        r3 = null;
        goto L10
    }

    public void recordHistograms(String r2) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        WebViewReservationSearchResult r1 = this.mWebviewReservationSearchResult;     // Catch: Throwable -> L8
        if (r1 != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        WebViewReservationSearchResult.access$000(r1, r2);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void setApkFilePath(String r1) {
    }

    public void takeSharedRelrosFromBundle(Bundle r4) {
        Bundle r5 = r4.getBundle(SHARED_RELROS);
        if (r5 != null) goto L5;
        return;
    L5:
        LibInfo r6 = LibInfo.fromBundle(r5);
        if (r6 != null) goto L8;
        return;
    L8:
        Object r0 = this.mLock;
        monitor-enter(r0);
        LibInfo r1 = this.mRemoteLibInfo;     // Catch: Throwable -> L16
        if (r1 != null) goto L13;
    L18:
        this.mRemoteLibInfo = r6;     // Catch: Throwable -> L16
        int r7 = this.mState;     // Catch: Throwable -> L16
        if (r7 != 3) goto L22;
        atomicReplaceRelroLocked(false);     // Catch: Throwable -> L16
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L22:
        if (r7 == 2) goto L24;
        this.mLock.notifyAll();     // Catch: Throwable -> L16
        goto L24
    L13:
        if (r1.mRelroFd == (-1)) goto L18;
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @GuardedBy
    public final void waitForSharedRelrosLocked() {
        this.mLinkerWasWaitingSynchronously = true;
    L4:
        if (this.mRemoteLibInfo != null) goto L7;
        this.mLock.wait();     // Catch: InterruptedException -> L8
        goto L4
    }
}
