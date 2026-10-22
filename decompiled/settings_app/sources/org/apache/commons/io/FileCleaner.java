package org.apache.commons.io;

import java.io.File;

/* JADX INFO: loaded from: classes6.dex */
public class FileCleaner {
    static final FileCleaningTracker theInstance = null;

    public FileCleaner() {
    }

    static {
        theInstance = new FileCleaningTracker();
    }

    public static void track(File r1, Object r2) {
        theInstance.track(r1, r2);
    }

    public static void track(File r1, Object r2, FileDeleteStrategy r3) {
        theInstance.track(r1, r2, r3);
    }

    public static void track(String r1, Object r2) {
        theInstance.track(r1, r2);
    }

    public static void track(String r1, Object r2, FileDeleteStrategy r3) {
        theInstance.track(r1, r2, r3);
    }

    public static int getTrackCount() {
        return theInstance.getTrackCount();
    }

    public static synchronized void exitWhenFinished() {
        monitor-enter(FileCleaner.class);
        theInstance.exitWhenFinished();     // Catch: Throwable -> L7
        monitor-exit(FileCleaner.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static FileCleaningTracker getInstance() {
        return theInstance;
    }
}
