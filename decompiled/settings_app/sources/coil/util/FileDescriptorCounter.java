package coil.util;

import android.os.SystemClock;
import java.io.File;
import kotlin.Metadata;

/* JADX INFO: compiled from: HardwareBitmaps.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\rH\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcoil/util/FileDescriptorCounter;", "", "()V", "FILE_DESCRIPTOR_CHECK_INTERVAL_DECODES", "", "FILE_DESCRIPTOR_CHECK_INTERVAL_MILLIS", "FILE_DESCRIPTOR_LIMIT", "TAG", "", "decodesSinceLastFileDescriptorCheck", "fileDescriptorList", "Ljava/io/File;", "hasAvailableFileDescriptors", "", "lastFileDescriptorCheckTimestamp", "", "checkFileDescriptors", "logger", "Lcoil/util/Logger;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class FileDescriptorCounter {
    private static final int FILE_DESCRIPTOR_CHECK_INTERVAL_DECODES = 30;
    private static final int FILE_DESCRIPTOR_CHECK_INTERVAL_MILLIS = 30000;
    private static final int FILE_DESCRIPTOR_LIMIT = 800;
    public static final FileDescriptorCounter INSTANCE = null;
    private static final String TAG = "FileDescriptorCounter";
    private static int decodesSinceLastFileDescriptorCheck;
    private static final File fileDescriptorList = null;
    private static boolean hasAvailableFileDescriptors;
    private static long lastFileDescriptorCheckTimestamp;

    private FileDescriptorCounter() {
    }

    static {
        INSTANCE = new FileDescriptorCounter();
        fileDescriptorList = new File("/proc/self/fd");
        decodesSinceLastFileDescriptorCheck = 30;
        lastFileDescriptorCheckTimestamp = SystemClock.uptimeMillis();
        hasAvailableFileDescriptors = true;
    }

    public final synchronized boolean hasAvailableFileDescriptors(Logger r6) {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (checkFileDescriptors() == false) goto L18;
        boolean r1 = false;
        decodesSinceLastFileDescriptorCheck = 0;     // Catch: Throwable -> L21
        lastFileDescriptorCheckTimestamp = SystemClock.uptimeMillis();     // Catch: Throwable -> L21
        String[] r2 = fileDescriptorList.list();     // Catch: Throwable -> L21
        if (r2 != null) goto L9;
        r2 = new String[0];     // Catch: Throwable -> L21
    L9:
        int r3 = r2.length;     // Catch: Throwable -> L21
        if (r3 >= 800) goto L12;
        r1 = true;
    L12:
        hasAvailableFileDescriptors = r1;     // Catch: Throwable -> L21
        if (r1 == true) goto L18;
        if (r6 == null) goto L18;
        if (r6.getLevel() > 5) goto L18;
        r6.log(TAG, 5, "Unable to allocate more hardware bitmaps. Number of used file descriptors: " + r3, null);     // Catch: Throwable -> L21
    L18:
        boolean r7 = hasAvailableFileDescriptors;     // Catch: Throwable -> L21
        monitor-exit(this);
        return r7;
    }

    private final boolean checkFileDescriptors() {
        int r6 = decodesSinceLastFileDescriptorCheck;
        decodesSinceLastFileDescriptorCheck = r6 + 1;
        if (r6 < 30) goto L5;
    L8:
        return true;
    L5:
        if (SystemClock.uptimeMillis() > (lastFileDescriptorCheckTimestamp + ((long) 30000))) goto L8;
        return false;
    }
}
