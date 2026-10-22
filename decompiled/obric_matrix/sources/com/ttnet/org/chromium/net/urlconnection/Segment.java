package com.ttnet.org.chromium.net.urlconnection;

import java.nio.ByteBuffer;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
public final class Segment {
    private static int sSize = 32768;
    private static boolean sSizeInited = false;
    private static final ReentrantReadWriteLock sSizeLock = null;
    private ByteBuffer bb;
    private boolean bufferFlipped;
    Segment next;
    Segment prev;

    static {
        sSizeLock = new ReentrantReadWriteLock();
    }

    Segment() {
        this.bufferFlipped = false;
        getInnerBuffer();
    }

    public static int getSize() {
        ReentrantReadWriteLock r0 = sSizeLock;
        r0.readLock().lock();
        sSizeInited = true;     // Catch: Throwable -> L6
        int r1 = sSize;     // Catch: Throwable -> L6
        r0.readLock().unlock();
        return r1;
    L6:
        th = move-exception;
        sSizeLock.readLock().unlock();
        throw th;
    }

    public static void setSize(int r2) {
        if (sSizeInited == false) goto L5;
        return;
    L5:
        ReentrantReadWriteLock r0 = sSizeLock;
        r0.writeLock().lock();
    L11:
        th = move-exception;
        sSizeLock.writeLock().unlock();
        throw th;
    L7:
        if (sSizeInited == true) goto L9;
        sSizeInited = true;     // Catch: Throwable -> L11
        sSize = r2;     // Catch: Throwable -> L11
    L9:
        r0.writeLock().unlock();
    }

    public void completeRead() {
        this.bb.flip();
        this.bufferFlipped = true;
    }

    public ByteBuffer getInnerBuffer() {
        if (this.bb != null) goto L6;
        this.bb = ByteBuffer.allocateDirect(getSize());
    L6:
        return this.bb;
    }

    public int getInnerBufferTo(byte[] r2, int r3, int r4) {
        if (this.bufferFlipped == true) goto L6;
        return -1;
    L6:
        int r5 = Math.min(this.bb.remaining(), r4);
        this.bb.get(r2, r3, r5);
        return r5;
    }

    public boolean isWritable() {
        if (this.bufferFlipped == false) goto L5;
    L7:
        return false;
    L5:
        if (this.bb.hasRemaining() == false) goto L7;
        return true;
    }

    public Segment pop() {
        Segment r0 = this.next;
        if (r0 == this) goto L5;
        Segment r2 = r0;
    L6:
        Segment r3 = this.prev;
        r3.next = r0;
        this.next.prev = r3;
        this.next = null;
        this.prev = null;
        return r2;
    L5:
        r2 = null;
        goto L6
    }

    public Segment push(Segment r2) {
        r2.prev = this;
        r2.next = this.next;
        this.next.prev = r2;
        this.next = r2;
        return r2;
    }

    public Segment release() {
        this.bb.clear();
        this.bufferFlipped = false;
        Segment r0 = pop();
        if (SegmentPool.recycle(this) == true) goto L5;
        this.bb = null;
    L5:
        return r0;
    }
}
