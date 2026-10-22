package com.ttnet.org.chromium.base.library_loader;

import androidx.annotation.VisibleForTesting;
import com.bytedance.librarian.LibrarianImpl;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.TimeUtils;
import com.ttnet.org.chromium.base.metrics.RecordHistogram;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes2.dex */
class ModernLinker extends Linker {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String DETAILED_LOAD_TIME_HISTOGRAM_PREFIX = "ChromiumAndroidLinker.ModernLinkerDetailedLoadTime.";
    private static final String DETAILED_LOAD_TIME_HISTOGRAM_PREFIX_BLKIO_CGROUP = "ChromiumAndroidLinker.ModernLinkerDetailedLoadTimeByBlkioCgroup.";
    private static final String SELF_CGROUP_FILE_NAME = "/proc/self/cgroup";
    private static final String SUFFIX_UNKNOWN = "Unknown";
    private static final String TAG = "ModernLinker";
    private static Natives sNativesInstance;

    public interface Natives {
        int getRelroSharingResult();

        boolean loadLibrary(String r1, Linker.LibInfo r2, boolean r3);

        boolean useRelros(long r1, Linker.LibInfo r3);
    }

    public ModernLinker() {
    }

    private static String extractBlkioCgroupFromLine(String r2) {
        int r0 = r2.indexOf(":blkio:");
        if (r0 != (-1)) goto L7;
        return "";
    L7:
        return r2.substring(r0 + 7);
    }

    @VisibleForTesting(otherwise = 2)
    public static Natives getModernLinkerJni() {
        Natives r0 = sNativesInstance;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return new ModernLinkerJni();
    }

    @GuardedBy
    private void loadAndProduceSharedRelro(String r6) {
        this.mLocalLibInfo.mLibFilePath = r6;
        boolean r2 = true;
        if (getModernLinkerJni().loadLibrary(r6, this.mLocalLibInfo, true) == true) goto L7;
        Log.e(TAG, "Unable to load with ModernLinker, using the system linker instead", new Object[0]);
        this.mLocalLibInfo.mRelroFd = -1;
    L7:
        if (this.mLocalLibInfo.mRelroFd != (-1)) goto L10;
        r2 = false;
    L10:
        RecordHistogram.recordBooleanHistogram("ChromiumAndroidLinker.RelroProvidedSuccessfully", r2);
    }

    @GuardedBy
    private void loadWithoutProducingRelro(String r4) {
        if (getModernLinkerJni().loadLibrary(r4, this.mLocalLibInfo, false) == true) goto L6;
        resetAndThrow(a.a.A("Unable to load library: ", r4));
        return;
    }

    private String readBackgroundStateFromCgroups() {
        BufferedReader r2 = new BufferedReader(new InputStreamReader(new FileInputStream(SELF_CGROUP_FILE_NAME)));     // Catch: IOException -> L35
        String r3 = null;
    L38:
        String r4 = r2.readLine();     // Catch: Throwable -> L11
        if (r4 == null) goto L13;
        r3 = extractBlkioCgroupFromLine(r4);     // Catch: Throwable -> L11
        if (r3.equals("") == true) goto L38;
    L13:
        if (r3 == null) goto L28;
        if (r3.equals("") == true) goto L28;
        r2.close();     // Catch: IOException -> L35
        if (r3.equals(LibrarianImpl.Constants.SEPARATOR) == false) goto L23;
        return "Foreground";
    L23:
        if (r3.equals("/background") == false) goto L26;
        return "Background";
    L26:
        Log.e(TAG, "blkio cgroup with unexpected name: '%s'", new Object[]{r3});
        return SUFFIX_UNKNOWN;
    L28:
        r2.close();     // Catch: IOException -> L35
        return SUFFIX_UNKNOWN;
    L11:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L32
    L34:
        throw th;     // Catch: IOException -> L35
    L32:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L35
    L35:
        Log.e(TAG, "IOException while reading %s", new Object[]{SELF_CGROUP_FILE_NAME});
        return SUFFIX_UNKNOWN;
    }

    private void recordDetailedLoadTimeSince(TimeUtils.UptimeMillisTimer r3, String r4, String r5) {
        long r2 = r3.getElapsedMillis();
        RecordHistogram.recordTimesHistogram(DETAILED_LOAD_TIME_HISTOGRAM_PREFIX + r4, r2);
        RecordHistogram.recordTimesHistogram(DETAILED_LOAD_TIME_HISTOGRAM_PREFIX_BLKIO_CGROUP + r4 + LibrarianImpl.Constants.DOT + r5, r2);
    }

    public static void reportDlopenExtTime(long r1) {
        RecordHistogram.recordTimesHistogram("ChromiumAndroidLinker.ModernLinkerDlopenExtTime", r1);
    }

    public static void reportIteratePhdrTime(long r1) {
        RecordHistogram.recordTimesHistogram("ChromiumAndroidLinker.ModernLinkerIteratePhdrTime", r1);
    }

    @GuardedBy
    private void resetAndThrow(String r2) {
        this.mState = 1;
        Log.e(TAG, r2, new Object[0]);
        throw new UnsatisfiedLinkError(r2);
    }

    public static void setModernLinkerNativesForTesting(Natives r0) {
        sNativesInstance = r0;
    }

    @Override // com.ttnet.org.chromium.base.library_loader.Linker
    @GuardedBy
    public void atomicReplaceRelroLocked(boolean r4) {
        if (this.mRemoteLibInfo.mRelroFd != (-1)) goto L6;
        return;
    L6:
        if (this.mLocalLibInfo != null) goto L8;
        return;
    L8:
        getModernLinkerJni().useRelros(this.mLocalLibInfo.mLoadAddress, this.mRemoteLibInfo);
        RecordHistogram.recordBooleanHistogram("ChromiumAndroidLinker.RelroAvailableImmediately", r4);
        RecordHistogram.recordEnumeratedHistogram("ChromiumAndroidLinker.RelroSharingStatus2", getModernLinkerJni().getRelroSharingResult(), 9);
    }

    @Override // com.ttnet.org.chromium.base.library_loader.Linker
    public boolean keepMemoryReservationUntilLoad() {
        return true;
    }

    @Override // com.ttnet.org.chromium.base.library_loader.Linker
    @GuardedBy
    public void loadLibraryImplLocked(String r7, int r8) {
        if ("monochrome".equals(r7) == true) goto L6;
        Log.i(TAG, "loadLibraryImplLocked: %s, relroMode=%d", new Object[]{r7, Integer.valueOf(r8)});
    L6:
        String r0 = readBackgroundStateFromCgroups();
        TimeUtils.UptimeMillisTimer r1 = new TimeUtils.UptimeMillisTimer();
        String r2 = System.mapLibraryName(r7);
        if (r8 != 0) goto L9;
        this.mState = 3;
        boolean r3 = false;
    L13:
        String r4 = readBackgroundStateFromCgroups();
        if (r0.equals(r4) == false) goto L16;
    L22:
        if (r3 == false) goto L27;
        if (r8 != 1) goto L25;
        String r9 = "Produce";
    L26:
        recordDetailedLoadTimeSince(r1, r9, r0);
        goto L27
    L25:
        r9 = "Consume";
    L27:
        TimeUtils.UptimeMillisTimer r10 = new TimeUtils.UptimeMillisTimer();
        System.loadLibrary(r7);     // Catch: UnsatisfiedLinkError -> L30
    L31:
        if (r3 == false) goto L33;
        String r11 = "Second";
    L34:
        recordDetailedLoadTimeSince(r10, r11, r0);
        return;
    L33:
        r11 = "NoSharing";
    L30:
        resetAndThrow("Failed at System.loadLibrary()");
        goto L31
    L16:
        if (r0.equals(SUFFIX_UNKNOWN) == false) goto L18;
    L21:
        r0 = SUFFIX_UNKNOWN;
        goto L22
    L18:
        if (r4.equals(SUFFIX_UNKNOWN) == true) goto L21;
        r0 = "Mixed";
        goto L22
    L9:
        if (r8 != 1) goto L11;
        loadAndProduceSharedRelro(r2);
        this.mState = 2;
    L12:
        r3 = true;
        goto L13
    L11:
        loadWithoutProducingRelro(r2);
        this.mState = 3;
        goto L12
    }
}
