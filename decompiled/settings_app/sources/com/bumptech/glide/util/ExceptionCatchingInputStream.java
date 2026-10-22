package com.bumptech.glide.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class ExceptionCatchingInputStream extends InputStream {
    private static final Queue<ExceptionCatchingInputStream> QUEUE = null;
    private IOException exception;
    private InputStream wrapped;

    static {
        QUEUE = Util.createQueue(0);
    }

    public static ExceptionCatchingInputStream obtain(InputStream r2) {
        Queue<ExceptionCatchingInputStream> r0 = QUEUE;
        monitor-enter(r0);
        ExceptionCatchingInputStream r1 = r0.poll();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        if (r1 != null) goto L8;
        r1 = new ExceptionCatchingInputStream();
    L8:
        r1.setInputStream(r2);
        return r1;
    L10:
        th = move-exception;
        throw th;
    }

    static void clearQueue() {
    L2:
        Queue<ExceptionCatchingInputStream> r0 = QUEUE;
        if (r0.isEmpty() == true) goto L5;
        r0.remove();
        goto L2
    }

    ExceptionCatchingInputStream() {
    }

    void setInputStream(InputStream r1) {
        this.wrapped = r1;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.wrapped.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.wrapped.close();
    }

    @Override // java.io.InputStream
    public void mark(int r1) {
        this.wrapped.mark(r1);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.wrapped.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] r2) {
        return this.wrapped.read(r2);
    L4:
        e = move-exception;
        this.exception = e;
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] r2, int r3, int r4) {
        return this.wrapped.read(r2, r3, r4);
    L4:
        e = move-exception;
        this.exception = e;
        return -1;
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        monitor-enter(this);
        this.wrapped.reset();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public long skip(long r2) {
        return this.wrapped.skip(r2);
    L4:
        e = move-exception;
        this.exception = e;
        return 0;
    }

    @Override // java.io.InputStream
    public int read() {
        return this.wrapped.read();
    L4:
        e = move-exception;
        this.exception = e;
        return -1;
    }

    public IOException getException() {
        return this.exception;
    }

    public void release() {
        this.exception = null;
        this.wrapped = null;
        Queue<ExceptionCatchingInputStream> r0 = QUEUE;
        monitor-enter(r0);
        r0.offer(this);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
