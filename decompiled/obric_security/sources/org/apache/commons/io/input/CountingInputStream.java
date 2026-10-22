package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public class CountingInputStream extends ProxyInputStream {
    private long count;

    public CountingInputStream(InputStream r1) {
        super(r1);
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r5) throws IOException {
        int r6 = super.read(r5);
        long r0 = this.count;
        if (r6 < 0) goto L5;
        long r2 = r6;
    L6:
        this.count = r0 + r2;
        return r6;
    L5:
        r2 = 0;
        goto L6
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r3, int r4, int r5) throws IOException {
        int r6 = super.read(r3, r4, r5);
        long r7 = this.count;
        if (r6 < 0) goto L5;
        long r0 = r6;
    L6:
        this.count = r7 + r0;
        return r6;
    L5:
        r0 = 0;
        goto L6
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int r0 = super.read();
        long r1 = this.count;
        if (r0 < 0) goto L5;
        long r3 = 1;
    L6:
        this.count = r1 + r3;
        return r0;
    L5:
        r3 = 0;
        goto L6
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public long skip(long r3) throws IOException {
        long r4 = super.skip(r3);
        this.count += r4;
        return r4;
    }

    public synchronized int getCount() {
        monitor-enter(this);
        long r1 = getByteCount();     // Catch: Throwable -> L12
        if (r1 > 2147483647L) goto L11;
        int r0 = (int) r1;
        monitor-exit(this);
        return r0;
    L11:
        throw new ArithmeticException(new StringBuffer("The byte count ").append(r1).append(" is too large to be converted to an int").toString());     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public synchronized int resetCount() {
        monitor-enter(this);
        long r1 = resetByteCount();     // Catch: Throwable -> L12
        if (r1 > 2147483647L) goto L11;
        int r0 = (int) r1;
        monitor-exit(this);
        return r0;
    L11:
        throw new ArithmeticException(new StringBuffer("The byte count ").append(r1).append(" is too large to be converted to an int").toString());     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public synchronized long getByteCount() {
        monitor-enter(this);
        long r0 = this.count;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized long resetByteCount() {
        monitor-enter(this);
        long r0 = this.count;     // Catch: Throwable -> L6
        this.count = 0;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }
}
