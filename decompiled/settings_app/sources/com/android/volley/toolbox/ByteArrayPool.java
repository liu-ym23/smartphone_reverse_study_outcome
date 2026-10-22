package com.android.volley.toolbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ByteArrayPool {
    protected static final Comparator<byte[]> BUF_COMPARATOR = null;
    private final List<byte[]> mBuffersByLastUse;
    private final List<byte[]> mBuffersBySize;
    private int mCurrentSize;
    private final int mSizeLimit;

    static {
        BUF_COMPARATOR = new AnonymousClass1();
    }

    public ByteArrayPool(int r3) {
        this.mBuffersByLastUse = new ArrayList();
        this.mBuffersBySize = new ArrayList(64);
        this.mCurrentSize = 0;
        this.mSizeLimit = r3;
    }

    public synchronized byte[] getBuf(int r4) {
        monitor-enter(this);
        int r0 = 0;
    L18:
    L15:
        th = move-exception;
        throw th;
    L5:
        if (r0 >= this.mBuffersBySize.size()) goto L12;
        byte[] r1 = this.mBuffersBySize.get(r0);     // Catch: Throwable -> L15
        if (r1.length >= r4) goto L8;
        r0 = r0 + 1;
        goto L18
    L8:
        this.mCurrentSize -= r1.length;     // Catch: Throwable -> L15
        this.mBuffersBySize.remove(r0);     // Catch: Throwable -> L15
        this.mBuffersByLastUse.remove(r1);     // Catch: Throwable -> L15
        monitor-exit(this);
        return r1;
    L12:
        byte[] r5 = new byte[r4];     // Catch: Throwable -> L15
        monitor-exit(this);
        return r5;
    }

    public synchronized void returnBuf(byte[] r3) {
        monitor-enter(this);
        if (r3 != null) goto L18;
    L16:
        monitor-exit(this);
        return;
    L18:
    L13:
        th = move-exception;
        throw th;
    L5:
        if (r3.length > this.mSizeLimit) goto L16;
        this.mBuffersByLastUse.add(r3);     // Catch: Throwable -> L13
        int r0 = Collections.binarySearch(this.mBuffersBySize, r3, BUF_COMPARATOR);     // Catch: Throwable -> L13
        if (r0 >= 0) goto L10;
        r0 = (-r0) - 1;     // Catch: Throwable -> L13
    L10:
        this.mBuffersBySize.add(r0, r3);     // Catch: Throwable -> L13
        this.mCurrentSize += r3.length;     // Catch: Throwable -> L13
        trim();     // Catch: Throwable -> L13
        monitor-exit(this);
    }

    private synchronized void trim() {
        monitor-enter(this);
    L12:
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mCurrentSize <= this.mSizeLimit) goto L7;
        byte[] r0 = this.mBuffersByLastUse.remove(0);     // Catch: Throwable -> L9
        this.mBuffersBySize.remove(r0);     // Catch: Throwable -> L9
        this.mCurrentSize -= r0.length;     // Catch: Throwable -> L9
        goto L12
    L7:
        monitor-exit(this);
    }
}
