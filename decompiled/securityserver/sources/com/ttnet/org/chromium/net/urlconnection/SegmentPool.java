package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.base.Logger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
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

    private SegmentPool() {
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

    public static boolean recycle(Segment r5) {
        if (r5.next != null) goto L22;
        if (r5.prev != null) goto L22;
        monitor-enter(SegmentPool.class);
    L13:
        th = move-exception;
        throw th;
    L9:
        if ((byteCount + ((long) Segment.getSize())) <= getSize()) goto L15;
        monitor-exit(SegmentPool.class);     // Catch: Throwable -> L13
        return false;
    L15:
        byteCount += (long) Segment.getSize();     // Catch: Throwable -> L13
        r5.next = next;     // Catch: Throwable -> L13
        next = r5;     // Catch: Throwable -> L13
        monitor-exit(SegmentPool.class);     // Catch: Throwable -> L13
        return true;
    L22:
        throw new IllegalArgumentException();
    }

    public static void setSize(long r3) {
        if (sSizeInited == false) goto L5;
        return;
    L5:
        ReentrantReadWriteLock r0 = sSizeLock;
        r0.writeLock().lock();
    L9:
        th = move-exception;
        sSizeLock.writeLock().unlock();
        throw th;
    L7:
        if (sSizeInited == true) goto L11;
        sSizeInited = true;     // Catch: Throwable -> L9
        sMaxSize = r3;     // Catch: Throwable -> L9
    L11:
        sSizeInited = true;     // Catch: Throwable -> L9
        r0.writeLock().unlock();
    }

    public static Segment take() {
        monitor-enter(SegmentPool.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (Logger.debug() == false) goto L10;
        segmentRequestTimes.incrementAndGet();     // Catch: Throwable -> L7
    L10:
        if (next != null) goto L12;
        monitor-exit(SegmentPool.class);     // Catch: Throwable -> L7
        if (Logger.debug() == false) goto L22;
        AtomicLong r0 = segmentAllocateTimes;
        r0.incrementAndGet();
        StringBuilder r2 = new StringBuilder("state: ");
        AtomicLong r3 = segmentRequestTimes;
        r2.append(r3.get());
        r2.append(" ");
        r2.append(r0);
        r2.append(" ");
        AtomicLong r1 = segmentReuseTimes;
        r2.append(r1);
        r2.append(" ");
        r2.append(r1.get() / r3.get());
        Logger.d("SegmentPool", r2.toString());
    L22:
        return new Segment();
    L12:
        if (Logger.debug() == false) goto L14;
        segmentReuseTimes.incrementAndGet();     // Catch: Throwable -> L7
    L14:
        Segment r4 = next;     // Catch: Throwable -> L7
        next = r4.next;     // Catch: Throwable -> L7
        r4.next = null;     // Catch: Throwable -> L7
        byteCount -= (long) Segment.getSize();     // Catch: Throwable -> L7
        monitor-exit(SegmentPool.class);     // Catch: Throwable -> L7
        return r4;
    }
}
