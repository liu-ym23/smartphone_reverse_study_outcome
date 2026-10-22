package com.bytedance.boost_multidex;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes.dex */
class Locker {
    private FileLock cacheLock;
    private FileChannel lockChannel;
    private File lockFile;
    private RandomAccessFile lockRaf;

    Locker(File r1) {
        this.lockFile = r1;
    }

    void close() {
        FileLock r0 = this.cacheLock;
        if (r0 != null) goto L8;
    L5:
        Monitor.get().logInfo("Released lock " + this.lockFile.getPath());
        Utility.closeQuietly(this.lockChannel);
        Utility.closeQuietly(this.lockRaf);
        return;
    L8:
        r0.release();     // Catch: IOException -> L7
        goto L5
    }

    void lock() {
        RandomAccessFile r0 = new RandomAccessFile(this.lockFile, "rw");
        this.lockRaf = r0;
        this.lockChannel = r0.getChannel();     // Catch: IOException -> L10
        Monitor.get().logInfo("Blocking on lock " + this.lockFile.getPath());     // Catch: IOException -> L7
        this.cacheLock = this.lockChannel.lock();     // Catch: IOException -> L7
        Monitor.get().logInfo("Acquired on lock " + this.lockFile.getPath());     // Catch: IOException -> L10
        return;
    L7:
        e = move-exception;
        Utility.closeQuietly(this.lockChannel);     // Catch: IOException -> L10
        throw e;     // Catch: IOException -> L10
    L10:
        e = move-exception;
        Utility.closeQuietly(this.lockRaf);
        throw e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.String] */
    boolean test() {
        RandomAccessFile r1 = new RandomAccessFile(this.lockFile, "rw");
        this.lockRaf = r1;
        this.lockChannel = r1.getChannel();
        boolean r2 = false;
        Monitor.get().logInfo("Blocking on lock " + this.lockFile.getPath());     // Catch: Throwable -> L9 IOException -> L11
        FileLock r3 = this.lockChannel.tryLock();     // Catch: Throwable -> L9 IOException -> L11
        this.cacheLock = r3;     // Catch: Throwable -> L9 IOException -> L11
        if (r3 == null) goto L6;
        r2 = true;
    L6:
        Monitor r4 = Monitor.get();
        StringBuilder r5 = new StringBuilder();
        Monitor r6 = r4;
    L7:
        r5.append("Acquired on lock ");
        r5.append(this.lockFile.getPath());
        Locker this = r5.toString();
        r6.logInfo(this);
        return r2;
    L9:
        th = move-exception;
        Monitor.get().logInfo("Acquired on lock " + this.lockFile.getPath());
        throw th;
    L11:
        Monitor.get().logInfo("Aborting on lock " + this.lockFile.getPath());     // Catch: Throwable -> L9
        Monitor r7 = Monitor.get();
        r5 = new StringBuilder();
        r6 = r7;
        goto L7
    }
}
