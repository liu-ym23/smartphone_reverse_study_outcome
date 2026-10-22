package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.util.Preconditions;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes3.dex */
final class DiskCacheWriteLocker {
    private final Map<String, WriteLock> locks;
    private final WriteLockPool writeLockPool;

    private static class WriteLock {
        int interestedThreads;
        final Lock lock;

        WriteLock() {
            this.lock = new ReentrantLock();
        }
    }

    private static class WriteLockPool {
        private static final int MAX_POOL_SIZE = 10;
        private final Queue<WriteLock> pool;

        WriteLockPool() {
            this.pool = new ArrayDeque();
        }

        WriteLock obtain() {
            Queue<WriteLock> r0 = this.pool;
            monitor-enter(r0);
            WriteLock r1 = this.pool.poll();     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            if (r1 == null) goto L8;
            return r1;
        L8:
            return new WriteLock();
        L9:
            th = move-exception;
            throw th;
        }

        void offer(WriteLock r4) {
            Queue<WriteLock> r0 = this.pool;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.pool.size() >= 10) goto L7;
            this.pool.offer(r4);     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
        }
    }

    DiskCacheWriteLocker() {
        this.locks = new HashMap();
        this.writeLockPool = new WriteLockPool();
    }

    void acquire(String r3) {
        monitor-enter(this);
        WriteLock r0 = this.locks.get(r3);     // Catch: Throwable -> L10
        if (r0 != null) goto L6;
        r0 = this.writeLockPool.obtain();     // Catch: Throwable -> L10
        this.locks.put(r3, r0);     // Catch: Throwable -> L10
    L6:
        r0.interestedThreads++;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        r0.lock.lock();
        return;
    L10:
        th = move-exception;
        throw th;
    }

    void release(String r6) {
        monitor-enter(this);
        WriteLock r2 = (WriteLock) Preconditions.checkNotNull(this.locks.get(r6));     // Catch: Throwable -> L18
        if (r2.interestedThreads < 1) goto L17;
        r2.interestedThreads--;     // Catch: Throwable -> L18
        if (r2.interestedThreads != 0) goto L13;
        WriteLock r1 = this.locks.remove(r6);     // Catch: Throwable -> L18
        if (r1.equals(r2) == false) goto L12;
        this.writeLockPool.offer(r1);     // Catch: Throwable -> L18
        goto L13
    L12:
        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + r2 + ", but actually removed: " + r1 + ", safeKey: " + r6);     // Catch: Throwable -> L18
    L13:
        monitor-exit(this);     // Catch: Throwable -> L18
        r2.lock.unlock();
        return;
    L17:
        throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + r6 + ", interestedThreads: " + r2.interestedThreads);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }
}
