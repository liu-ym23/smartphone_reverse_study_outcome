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

    public DiskStorageUtils() {
    }

    public static synchronized File getPersistentFile(Context r6) {
        monitor-enter(DiskStorageUtils.class);
        File r2 = sPersistentFile;     // Catch: Throwable -> L11
        if (r2 == null) goto L27;
        monitor-exit(DiskStorageUtils.class);
        return r2;
    L27:
        File r3 = new File(getWorkingDirectory(r6), Utils.getCurProcessName(r6).replace(LibrarianImpl.Constants.DOT, "_").replace(":", "-") + FILE_NAME_SUFFIX);     // Catch: Throwable -> L11 Exception -> L13
        if (r3.exists() == true) goto L15;
        r3.createNewFile();     // Catch: Throwable -> L11 Exception -> L13
    L15:
        sPersistentFile = r3;     // Catch: Throwable -> L11 Exception -> L13
        if (Logger.debug() == false) goto L20;
        Logger.d(TAG, "prepare PersistentFile success. fileName=" + sPersistentFile);     // Catch: Throwable -> L11 Exception -> L13
    L20:
        File r7 = sPersistentFile;     // Catch: Throwable -> L11
        monitor-exit(DiskStorageUtils.class);
        return r7;
    L13:
        e = move-exception;
        Logger.e(TAG, "prepare PersistentFile fail.", e);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
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
}
