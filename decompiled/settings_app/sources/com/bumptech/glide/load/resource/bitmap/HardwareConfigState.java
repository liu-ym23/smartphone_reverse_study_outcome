package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class HardwareConfigState {
    public static final boolean BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED = false;
    private static final File FD_SIZE_LIST = null;
    public static final boolean HARDWARE_BITMAPS_SUPPORTED = false;
    private static final int MAXIMUM_FDS_FOR_HARDWARE_CONFIGS_P = 20000;
    private static final int MINIMUM_DECODES_BETWEEN_FD_CHECKS = 50;

    @Deprecated
    public static final int NO_MAX_FD_COUNT = -1;
    private static final int REDUCED_MAX_FDS_FOR_HARDWARE_CONFIGS_P = 500;
    private static final String TAG = "HardwareConfig";
    private static volatile HardwareConfigState instance;
    private int decodesSinceLastFdCheck;
    private boolean isFdSizeBelowHardwareLimit;
    private final AtomicBoolean isHardwareConfigAllowedByAppState;
    private final int sdkBasedMaxFdCount;

    private static boolean isHardwareBitmapCountReducedOnApi28ByB139097735() {
        return false;
    }

    static {
        BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED = false;
        HARDWARE_BITMAPS_SUPPORTED = true;
        FD_SIZE_LIST = new File("/proc/self/fd");
    }

    public static HardwareConfigState getInstance() {
        if (instance != null) goto L15;
        monitor-enter(HardwareConfigState.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new HardwareConfigState();     // Catch: Throwable -> L11
    L9:
        monitor-exit(HardwareConfigState.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    HardwareConfigState() {
        this.isFdSizeBelowHardwareLimit = true;
        this.isHardwareConfigAllowedByAppState = new AtomicBoolean(false);
        this.sdkBasedMaxFdCount = 20000;
    }

    public void blockHardwareBitmaps() {
        Util.assertMainThread();
        this.isHardwareConfigAllowedByAppState.set(false);
    }

    public void unblockHardwareBitmaps() {
        Util.assertMainThread();
        this.isHardwareConfigAllowedByAppState.set(true);
    }

    public boolean isHardwareConfigAllowed(int r4, int r5, boolean r6, boolean r7) {
        if (r6 == true) goto L9;
        if (Log.isLoggable(TAG, 2) == false) goto L7;
        Log.v(TAG, "Hardware config disallowed by caller");
    L7:
        return false;
    L9:
        if (HARDWARE_BITMAPS_SUPPORTED == true) goto L15;
        if (Log.isLoggable(TAG, 2) == false) goto L13;
        Log.v(TAG, "Hardware config disallowed by sdk");
    L13:
        return false;
    L15:
        if (areHardwareBitmapsBlockedByAppState() == true) goto L17;
        if (r7 == true) goto L22;
        if (r4 < 0) goto L37;
        if (r5 < 0) goto L37;
        if (isFdSizeBelowHardwareLimit() == false) goto L31;
        return true;
    L31:
        if (Log.isLoggable(TAG, 2) == false) goto L33;
        Log.v(TAG, "Hardware config disallowed because there are insufficient FDs");
    L33:
        return false;
    L37:
        if (Log.isLoggable(TAG, 2) == false) goto L39;
        Log.v(TAG, "Hardware config disallowed because of invalid dimensions");
    L39:
        return false;
    L22:
        if (Log.isLoggable(TAG, 2) == false) goto L24;
        Log.v(TAG, "Hardware config disallowed because exif orientation is required");
    L24:
        return false;
    L17:
        if (Log.isLoggable(TAG, 2) == false) goto L19;
        Log.v(TAG, "Hardware config disallowed by app state");
    L19:
        return false;
    }

    private boolean areHardwareBitmapsBlockedByAppState() {
        if (BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED == true) goto L5;
    L7:
        return false;
    L5:
        if (this.isHardwareConfigAllowedByAppState.get() == true) goto L7;
        return true;
    }

    boolean setHardwareConfigIfAllowed(int r1, int r2, BitmapFactory.Options r3, boolean r4, boolean r5) {
        boolean r0 = isHardwareConfigAllowed(r1, r2, r4, r5);
        if (r0 == false) goto L5;
        r3.inPreferredConfig = Bitmap.Config.HARDWARE;
        r3.inMutable = false;
    L5:
        return r0;
    }

    private int getMaxFdCount() {
        if (isHardwareBitmapCountReducedOnApi28ByB139097735() == false) goto L7;
        return 500;
    L7:
        return this.sdkBasedMaxFdCount;
    }

    private synchronized boolean isFdSizeBelowHardwareLimit() {
        monitor-enter(this);
        boolean r2 = true;
        int r1 = this.decodesSinceLastFdCheck + 1;     // Catch: Throwable -> L18
        this.decodesSinceLastFdCheck = r1;     // Catch: Throwable -> L18
        if (r1 < 50) goto L15;
        this.decodesSinceLastFdCheck = 0;     // Catch: Throwable -> L18
        int r3 = FD_SIZE_LIST.list().length;     // Catch: Throwable -> L18
        long r4 = getMaxFdCount();     // Catch: Throwable -> L18
        if (r3 < r4) goto L10;
        r2 = false;
    L10:
        this.isFdSizeBelowHardwareLimit = r2;     // Catch: Throwable -> L18
        if (r2 == true) goto L15;
        if (Log.isLoggable("Downsampler", 5) == false) goto L15;
        Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + r3 + ", limit " + r4);     // Catch: Throwable -> L18
    L15:
        boolean r0 = this.isFdSizeBelowHardwareLimit;     // Catch: Throwable -> L18
        monitor-exit(this);
        return r0;
    L18:
        th = move-exception;
        throw th;
    }
}
