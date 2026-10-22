package com.bytedance.apm6.consumer.slardar;

import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class DiskEnvironmentHelper {
    private static final String CHILD_PROCESS_PERSISTENT_DIR_NAME = "child_process_persistent";
    private static final String FLUSH_DIR_NAME = "flush";
    private static final String PERSISTENT_DIR_NAME = "persistent";
    private static final String WORKING_DIR_NAME = "apm6";
    private static File sFlushDirectory;
    private static File sPersistentDirectory;
    private static File sPersistentFile;
    private static File sWorkingDirectory;

    public DiskEnvironmentHelper() {
    }

    public static String generateFlushFileName() {
        return System.currentTimeMillis() + "_" + UUID.randomUUID().toString() + ".log";
    }

    public static synchronized File getFlushDirectory() {
        monitor-enter(DiskEnvironmentHelper.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (sFlushDirectory != null) goto L14;
        File r2 = new File(getWorkingDirectory(), FLUSH_DIR_NAME);     // Catch: Throwable -> L9
        if (r2.exists() == true) goto L11;
        r2.mkdirs();     // Catch: Throwable -> L9
    L11:
        sFlushDirectory = r2;     // Catch: Throwable -> L9
        if (ApmBaseContext.isDebugMode() == false) goto L14;
        Logger.d(Constants.TAG, "prepare FlushDirectory success. name=" + sFlushDirectory);     // Catch: Throwable -> L9
    L14:
        File r0 = sFlushDirectory;     // Catch: Throwable -> L9
        monitor-exit(DiskEnvironmentHelper.class);
        return r0;
    }

    public static synchronized File getPersistentDirectory() {
        monitor-enter(DiskEnvironmentHelper.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (sPersistentDirectory == null) goto L7;
    L18:
        File r0 = sPersistentDirectory;     // Catch: Throwable -> L9
        monitor-exit(DiskEnvironmentHelper.class);
        return r0;
    L7:
        if (ApmContext.isMainProcess() == false) goto L11;
        File r2 = new File(getWorkingDirectory(), PERSISTENT_DIR_NAME);     // Catch: Throwable -> L9
    L13:
        if (r2.exists() == true) goto L15;
        r2.mkdirs();     // Catch: Throwable -> L9
    L15:
        sPersistentDirectory = r2;     // Catch: Throwable -> L9
        if (ApmBaseContext.isDebugMode() == false) goto L18;
        Logger.d(Constants.TAG, "prepare PersistentDirectory success. name=" + sPersistentDirectory);     // Catch: Throwable -> L9
        goto L18
    L11:
        r2 = new File(getWorkingDirectory(), CHILD_PROCESS_PERSISTENT_DIR_NAME);     // Catch: Throwable -> L9
        goto L13
    }

    public static synchronized File getPersistentFile() {
        monitor-enter(DiskEnvironmentHelper.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (sPersistentFile == null) goto L26;
    L21:
        File r0 = sPersistentFile;     // Catch: Throwable -> L9
        monitor-exit(DiskEnvironmentHelper.class);
        return r0;
    L26:
        String r2 = ApmContext.getCurrentProcessName().replace(LibrarianImpl.Constants.DOT, "_").replace(":", "-") + ".bin";     // Catch: Throwable -> L9 Exception -> L11
        if (ApmContext.isMainProcess() == true) goto L13;
        r2 = ApmContext.getInitTimeStamp() + "_" + r2;     // Catch: Throwable -> L9 Exception -> L11
    L13:
        File r3 = new File(getPersistentDirectory(), r2);     // Catch: Throwable -> L9 Exception -> L11
        if (r3.exists() == true) goto L16;
        r3.createNewFile();     // Catch: Throwable -> L9 Exception -> L11
    L16:
        sPersistentFile = r3;     // Catch: Throwable -> L9 Exception -> L11
        if (ApmBaseContext.isDebugMode() == false) goto L21;
        Logger.d(Constants.TAG, "prepare PersistentFile success. fileName=" + sPersistentFile);     // Catch: Throwable -> L9 Exception -> L11
    L11:
        e = move-exception;
        Logger.e(Constants.TAG, "prepare PersistentFile fail.", e);     // Catch: Throwable -> L9
        goto L21
    }

    public static File getSubProcessPersistentDirectory() {
        return new File(getWorkingDirectory(), CHILD_PROCESS_PERSISTENT_DIR_NAME);
    }

    public static synchronized File getWorkingDirectory() {
        monitor-enter(DiskEnvironmentHelper.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (sWorkingDirectory != null) goto L11;
        File r1 = new File(ApmBaseContext.getContext().getFilesDir(), WORKING_DIR_NAME);     // Catch: Throwable -> L9
        sWorkingDirectory = r1;     // Catch: Throwable -> L9
        if (r1.exists() == true) goto L11;
        sWorkingDirectory.mkdirs();     // Catch: Throwable -> L9
    L11:
        File r2 = sWorkingDirectory;     // Catch: Throwable -> L9
        monitor-exit(DiskEnvironmentHelper.class);
        return r2;
    }
}
