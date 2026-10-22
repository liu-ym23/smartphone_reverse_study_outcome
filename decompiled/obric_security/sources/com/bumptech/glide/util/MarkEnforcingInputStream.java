package com.bumptech.glide.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class MarkEnforcingInputStream extends FilterInputStream {
    private static final int END_OF_STREAM = -1;
    private static final int UNSET = Integer.MIN_VALUE;
    private int availableBytes;

    public MarkEnforcingInputStream(InputStream r1) {
        super(r1);
        this.availableBytes = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int r1) {
        monitor-enter(this);
        super.mark(r1);     // Catch: Throwable -> L6
        this.availableBytes = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (getBytesToRead(1) != (-1)) goto L6;
        return -1;
    L6:
        int r2 = super.read();
        updateAvailableBytesAfterRead(1);
        return r2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r3, int r4, int r5) throws IOException {
        int r6 = (int) getBytesToRead(r5);
        if (r6 != (-1)) goto L5;
        return -1;
    L5:
        int r7 = super.read(r3, r4, r6);
        updateAvailableBytesAfterRead(r7);
        return r7;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        monitor-enter(this);
        super.reset();     // Catch: Throwable -> L6
        this.availableBytes = Integer.MIN_VALUE;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long r3) throws IOException {
        long r4 = getBytesToRead(r3);
        if (r4 != (-1)) goto L6;
        return 0;
    L6:
        long r5 = super.skip(r4);
        updateAvailableBytesAfterRead(r5);
        return r5;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int r0 = this.availableBytes;
        if (r0 != Integer.MIN_VALUE) goto L6;
        return super.available();
    L6:
        return Math.min(r0, super.available());
    }

    private long getBytesToRead(long r3) {
        int r2 = this.availableBytes;
        if (r2 != 0) goto L7;
        return -1;
    L7:
        if (r2 != Integer.MIN_VALUE) goto L9;
    L12:
        return r3;
    L9:
        if (r3 <= r2) goto L12;
        return r2;
    }

    private void updateAvailableBytesAfterRead(long r4) {
        int r0 = this.availableBytes;
        if (r0 != Integer.MIN_VALUE) goto L5;
        return;
    L5:
        if (r4 == (-1)) goto L9;
        this.availableBytes = (int) (((long) r0) - r4);
        return;
    }
}
