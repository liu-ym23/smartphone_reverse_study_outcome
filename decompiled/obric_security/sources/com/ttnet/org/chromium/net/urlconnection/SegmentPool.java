package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.base.Logger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes3.dex */
public final class SegmentPool {
    static long byteCount = 0;
    static Segment next = null;
    private static long sMaxSize = 262144;
    private static boolean sSizeInited = false;
    private static final ReentrantReadWriteLock sSizeLock = null;
    private static final AtomicLong segmentAllocateTimes = null;
    private static final AtomicLong segmentRequestTimes = null;
    private static final AtomicLong segmentReuseTimes = null;

    static {
        sSizeLock = new ReentrantReadWriteLock();
        segmentAllocateTimes = new AtomicLong(0);
        segmentReuseTimes = new AtomicLong(0);
        segmentRequestTimes = new AtomicLong(0);
    }

    private static long getSize() {
        ReentrantReadWriteLock r0 = sSizeLock;
        r0.readLock().lock();
        sSizeInited = true;     // Catch: Throwable -> L6
        long r1 = sMaxSize;     // Catch: Throwable -> L6
        r0.readLock().unlock();
        return r1;
    L6:
        th = move-exception;
        sSizeLock.readLock().unlock();
        throw th;
    }

    public static void setSize(long r3) {
        if (sSizeInited == false) goto L5;
        return;
    L5:
        ReentrantReadWriteLock r0 = sSizeLock;
        r0.writeLock().lock();
    L12:
        th = move-exception;
        sSizeLock.writeLock().unlock();
        throw th;
    L7:
        if (sSizeInited == true) goto L9;
        sSizeInited = true;     // Catch: Throwable -> L12
        sMaxSize = r3;     // Catch: Throwable -> L12
    L9:
        sSizeInited = true;     // Catch: Throwable -> L12
        r0.writeLock().unlock();
    }

    private SegmentPool() {
    }

    static Segment take() {
        monitor-enter(SegmentPool.class);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (Logger.debug() == false) goto L8;
        segmentRequestTimes.incrementAndGet();     // Catch: Throwable -> L21
    L8:
        if (next != null) goto L10;
        monitor-exit(SegmentPool.class);     // Catch: Throwable -> L21
        if (Logger.debug() == false) goto L20;
        AtomicLong r0 = segmentAllocateTimes;
        r0.incrementAndGet();
        StringBuilder r2 = new StringBuilder("state: ");
        AtomicLong r3 = segmentRequestTimes;
        StringBuilder r1 = r2.append(r3.get()).append(" ").append(r0).append(" ");
        AtomicLong r4 = segmentReuseTimes;
        Logger.d("SegmentPool", r1.append(r4).append(" ").append(r4.get() / r3.get()).toString());
    L20:
        return new Segment();
    L10:
        if (Logger.debug() == false) goto L12;
        segmentReuseTimes.incrementAndGet();     // Catch: Throwable -> L21
    L12:
        Segment r5 = next;     // Catch: Throwable -> L21
        next = r5.next;     // Catch: Throwable -> L21
        r5.next = null;     // Catch: Throwable -> L21
        byteCount -= (long) Segment.getSize();     // Catch: Throwable -> L21
        monitor-exit(SegmentPool.class);     // Catch: Throwable -> L21
        return r5;
    }

    static boolean recycle(Segment r5) {
        if (r5.next != null) goto L21;
        if (r5.prev != null) goto L21;
        monitor-enter(SegmentPool.class);
    L17:
        th = move-exception;
        throw th;
    L9:
        if ((byteCount + ((long) Segment.getSize())) <= getSize()) goto L13;
        monitor-exit(SegmentPool.class);     // Catch: Throwable -> L17
        return false;
    L13:
        byteCount += (long) Segment.getSize();     // Catch: Throwable -> L17
        r5.next = next;     // Catch: Throwable -> L17
        next = r5;     // Catch: Throwable -> L17
        monitor-exit(SegmentPool.class);     // Catch: Throwable -> L17
        return true;
    L21:
        throw new IllegalArgumentException();
    }
}
