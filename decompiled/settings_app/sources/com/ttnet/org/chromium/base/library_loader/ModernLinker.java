package com.ttnet.org.chromium.base.library_loader;

import com.bytedance.librarian.LibrarianImpl;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.TimeUtils;
import com.ttnet.org.chromium.base.metrics.RecordHistogram;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes5.dex */
class ModernLinker extends Linker {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String DETAILED_LOAD_TIME_HISTOGRAM_PREFIX = "ChromiumAndroidLinker.ModernLinkerDetailedLoadTime.";
    private static final String DETAILED_LOAD_TIME_HISTOGRAM_PREFIX_BLKIO_CGROUP = "ChromiumAndroidLinker.ModernLinkerDetailedLoadTimeByBlkioCgroup.";
    private static final String SELF_CGROUP_FILE_NAME = "/proc/self/cgroup";
    private static final String SUFFIX_UNKNOWN = "Unknown";
    private static final String TAG = "ModernLinker";
    private static Natives sNativesInstance;

    interface Natives {
        int getRelroSharingResult();

        boolean loadLibrary(String r1, Linker.LibInfo r2, boolean r3);

        boolean useRelros(long r1, Linker.LibInfo r3);
    }

    static {
    }

    @Override // com.ttnet.org.chromium.base.library_loader.Linker
    protected boolean keepMemoryReservationUntilLoad() {
        return true;
    }

    ModernLinker() {
    }

    private static String extractBlkioCgroupFromLine(String r2) {
        int r0 = r2.indexOf(":blkio:");
        if (r0 != (-1)) goto L7;
        return "";
    L7:
        return r2.substring(r0 + 7);
    }

    private String readBackgroundStateFromCgroups() {
        BufferedReader r4 = new BufferedReader(new InputStreamReader(new FileInputStream(SELF_CGROUP_FILE_NAME)));     // Catch: IOException -> L33
        String r5 = null;
    L36:
        String r6 = r4.readLine();     // Catch: Throwable -> L27
        if (r6 == null) goto L10;
        r5 = extractBlkioCgroupFromLine(r6);     // Catch: Throwable -> L27
        if (r5.equals("") == true) goto L36;
    L10:
        if (r5 == null) goto L25;
        if (r5.equals("") == true) goto L25;
        r4.close();     // Catch: IOException -> L33
        if (r5.equals(LibrarianImpl.Constants.SEPARATOR) == false) goto L20;
        return "Foreground";
    L20:
        if (r5.equals("/background") == false) goto L23;
        return "Background";
    L23:
        Log.e(TAG, "blkio cgroup with unexpected name: '%s'", new Object[]{r5});
        return SUFFIX_UNKNOWN;
    L25:
        r4.close();     // Catch: IOException -> L33
        return SUFFIX_UNKNOWN;
    L27:
        th = move-exception;
        r4.close();     // Catch: Throwable -> L30
    L32:
        throw th;     // Catch: IOException -> L33
    L30:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L33
    L33:
        Log.e(TAG, "IOException while reading %s", new Object[]{SELF_CGROUP_FILE_NAME});
        return SUFFIX_UNKNOWN;
    }

    @Override // com.ttnet.org.chromium.base.library_loader.Linker
    protected void loadLibraryImplLocked(String r8, int r9) {
        boolean r1 = false;
        if ("monochrome".equals(r8) == true) goto L6;
        Log.i(TAG, "loadLibraryImplLocked: %s, relroMode=%d", new Object[]{r8, Integer.valueOf(r9)});
    L6:
        String r0 = readBackgroundStateFromCgroups();
        TimeUtils.UptimeMillisTimer r4 = new TimeUtils.UptimeMillisTimer();
        String r5 = System.mapLibraryName(r8);
        if (r9 != 0) goto L9;
        this.mState = 3;
    L13:
        String r2 = readBackgroundStateFromCgroups();
        if (r0.equals(r2) == false) goto L16;
    L22:
        if (r1 == false) goto L27;
        if (r9 != 1) goto L25;
        String r10 = "Produce";
    L26:
        recordDetailedLoadTimeSince(r4, r10, r0);
        goto L27
    L25:
        r10 = "Consume";
    L27:
        TimeUtils.UptimeMillisTimer r11 = new TimeUtils.UptimeMillisTimer();
        System.loadLibrary(r8);     // Catch: UnsatisfiedLinkError -> L30
    L31:
        if (r1 == false) goto L33;
        String r12 = "Second";
    L34:
        recordDetailedLoadTimeSince(r11, r12, r0);
        return;
    L33:
        r12 = "NoSharing";
    L30:
        resetAndThrow("Failed at System.loadLibrary()");
        goto L31
    L16:
        if (r0.equals(SUFFIX_UNKNOWN) == false) goto L18;
    L21:
        r0 = SUFFIX_UNKNOWN;
        goto L22
    L18:
        if (r2.equals(SUFFIX_UNKNOWN) == true) goto L21;
        r0 = "Mixed";
        goto L22
    L9:
        if (r9 != 1) goto L11;
        loadAndProduceSharedRelro(r5);
        this.mState = 2;
    L12:
        r1 = true;
        goto L13
    L11:
        loadWithoutProducingRelro(r5);
        this.mState = 3;
        goto L12
    }

    private void recordDetailedLoadTimeSince(TimeUtils.UptimeMillisTimer r3, String r4, String r5) {
        long r2 = r3.getElapsedMillis();
        RecordHistogram.recordTimesHistogram(DETAILED_LOAD_TIME_HISTOGRAM_PREFIX + r4, r2);
        RecordHistogram.recordTimesHistogram(DETAILED_LOAD_TIME_HISTOGRAM_PREFIX_BLKIO_CGROUP + r4 + "." + r5, r2);
    }

    private void loadWithoutProducingRelro(String r4) {
        if (getModernLinkerJni().loadLibrary(r4, this.mLocalLibInfo, false) == true) goto L6;
        resetAndThrow(String.format("Unable to load library: %s", new Object[]{r4}));
        return;
    }

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

    @Override // com.ttnet.org.chromium.base.library_loader.Linker
    protected void atomicReplaceRelroLocked(boolean r4) {
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

    private void resetAndThrow(String r2) {
        this.mState = 1;
        Log.e(TAG, r2, new Object[0]);
        throw new UnsatisfiedLinkError(r2);
    }

    public static void reportDlopenExtTime(long r1) {
        RecordHistogram.recordTimesHistogram("ChromiumAndroidLinker.ModernLinkerDlopenExtTime", r1);
    }

    public static void reportIteratePhdrTime(long r1) {
        RecordHistogram.recordTimesHistogram("ChromiumAndroidLinker.ModernLinkerIteratePhdrTime", r1);
    }

    static void setModernLinkerNativesForTesting(Natives r0) {
        sNativesInstance = r0;
    }

    static Natives getModernLinkerJni() {
        Natives r0 = sNativesInstance;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return new ModernLinkerJni();
    }
}
