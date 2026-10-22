package com.bytedance.common.wschannel.utils;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.librarian.LibrarianImpl;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class DiskStorageUtils {
    private static final String FILE_NAME_SUFFIX = "_frontier.bin";
    private static final String TAG = "DiskStorageUtils";
    private static final String WORKING_DIR_NAME = "wschannel";
    private static File sPersistentFile;
    private static File sWorkingDirectory;

    static {
    }

    public DiskStorageUtils() {
    }

    private static File getWorkingDirectory(Context r2) {
        File r0 = sWorkingDirectory;
        if (r0 == null) goto L5;
        return r0;
    L5:
        File r1 = new File(r2.getFilesDir(), WORKING_DIR_NAME);
        sWorkingDirectory = r1;
        if (r1.exists() == true) goto L9;
        sWorkingDirectory.mkdirs();
    L9:
        return sWorkingDirectory;
    }

    public static synchronized File getPersistentFile(Context r6) {
        monitor-enter(DiskStorageUtils.class);
        File r2 = sPersistentFile;     // Catch: Throwable -> L20
        if (r2 == null) goto L25;
        monitor-exit(DiskStorageUtils.class);
        return r2;
    L25:
        File r3 = new File(getWorkingDirectory(r6), Utils.getCurProcessName(r6).replace(LibrarianImpl.Constants.DOT, "_").replace(":", "-") + FILE_NAME_SUFFIX);     // Catch: Exception -> L15 Throwable -> L20
        if (r3.exists() == true) goto L11;
        r3.createNewFile();     // Catch: Exception -> L15 Throwable -> L20
    L11:
        sPersistentFile = r3;     // Catch: Exception -> L15 Throwable -> L20
        if (Logger.debug() == false) goto L17;
        Logger.d(TAG, "prepare PersistentFile success. fileName=" + sPersistentFile);     // Catch: Exception -> L15 Throwable -> L20
    L17:
        File r7 = sPersistentFile;     // Catch: Throwable -> L20
        monitor-exit(DiskStorageUtils.class);
        return r7;
    L15:
        e = move-exception;
        Logger.e(TAG, "prepare PersistentFile fail.", e);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }
}
