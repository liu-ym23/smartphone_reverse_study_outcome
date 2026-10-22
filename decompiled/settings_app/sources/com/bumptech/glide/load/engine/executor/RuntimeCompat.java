package com.bumptech.glide.load.engine.executor;

import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
final class RuntimeCompat {
    private static final String CPU_LOCATION = "/sys/devices/system/cpu/";
    private static final String CPU_NAME_REGEX = "cpu[0-9]+";
    private static final String TAG = "GlideRuntimeCompat";

    private RuntimeCompat() {
    }

    static int availableProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }

    private static int getCoreCountPre17() {
        StrictMode.ThreadPolicy r1 = StrictMode.allowThreadDiskReads();
        File r2 = new File(CPU_LOCATION);     // Catch: Throwable -> L5
        final Pattern r3 = Pattern.compile(CPU_NAME_REGEX);     // Catch: Throwable -> L5
        File[] r0 = r2.listFiles(new AnonymousClass1(r3));     // Catch: Throwable -> L5
        StrictMode.setThreadPolicy(r1);
    L11:
        if (r0 == null) goto L13;
        int r4 = r0.length;
    L15:
        return Math.max(1, r4);
    L13:
        r4 = 0;
    L5:
        th = move-exception;
    L16:
        th = move-exception;
        StrictMode.setThreadPolicy(r1);
        throw th;
    L8:
        if (Log.isLoggable(TAG, 6) == false) goto L10;
        Log.e(TAG, "Failed to calculate accurate cpu count", th);     // Catch: Throwable -> L16
    L10:
        StrictMode.setThreadPolicy(r1);
        r0 = null;
        goto L11
    }
}
