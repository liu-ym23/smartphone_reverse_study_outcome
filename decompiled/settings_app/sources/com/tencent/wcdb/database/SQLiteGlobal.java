package com.tencent.wcdb.database;

import android.os.Environment;
import android.os.StatFs;

/* JADX INFO: loaded from: classes5.dex */
public final class SQLiteGlobal {
    private static final String TAG = "WCDB.SQLiteGlobal";
    public static final String defaultJournalMode = "PERSIST";
    public static final int defaultPageSize = 0;
    public static final String defaultSyncMode = "FULL";
    public static final int journalSizeLimit = 524288;
    public static final int walAutoCheckpoint = 100;
    public static final int walConnectionPoolSize = 4;
    public static final String walSyncMode = "FULL";

    public static void loadLib() {
    }

    private static native int nativeReleaseMemory();

    private static native void nativeSetDefaultCipherSettings(int r0);

    static {
        if (WCDBInitializationProbe.libLoaded == true) goto L10;
        System.loadLibrary("wcdb");
    L10:
        int r0 = new StatFs(Environment.getDataDirectory().getAbsolutePath()).getBlockSize();     // Catch: RuntimeException -> L7
    L8:
        defaultPageSize = r0;
        nativeSetDefaultCipherSettings(r0);
        return;
    L7:
        r0 = 4096;
        goto L8
    }

    private SQLiteGlobal() {
    }

    public static int releaseMemory() {
        return nativeReleaseMemory();
    }
}
