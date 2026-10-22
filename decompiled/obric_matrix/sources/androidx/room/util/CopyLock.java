package androidx.room.util;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class CopyLock {
    private static final Map<String, Lock> sThreadLocks = null;
    private final File mCopyLockFile;
    private final boolean mFileLevelLock;
    private FileChannel mLockChannel;
    private final Lock mThreadLock;

    static {
        sThreadLocks = new HashMap();
    }

    public CopyLock(@NonNull String r3, @NonNull File r4, boolean r5) {
        File r0 = new File(r4, r3 + ".lck");
        this.mCopyLockFile = r0;
        this.mThreadLock = getThreadLock(r0.getAbsolutePath());
        this.mFileLevelLock = r5;
    }

    private static Lock getThreadLock(String r2) {
        Map<String, Lock> r0 = sThreadLocks;
        monitor-enter(r0);
        Lock r1 = r0.get(r2);     // Catch: Throwable -> L9
        if (r1 != null) goto L7;
        r1 = new ReentrantLock();     // Catch: Throwable -> L9
        r0.put(r2, r1);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    }

    public void lock() {
        this.mThreadLock.lock();
        if (this.mFileLevelLock == true) goto L10;
        return;
    L10:
        FileChannel r0 = new FileOutputStream(this.mCopyLockFile).getChannel();     // Catch: IOException -> L6
        this.mLockChannel = r0;     // Catch: IOException -> L6
        r0.lock();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        throw new IllegalStateException("Unable to grab copy lock.", e);
    }

    public void unlock() {
        FileChannel r0 = this.mLockChannel;
        if (r0 != null) goto L8;
    L5:
        this.mThreadLock.unlock();
        return;
    L8:
        r0.close();     // Catch: IOException -> L7
        goto L5
    }
}
