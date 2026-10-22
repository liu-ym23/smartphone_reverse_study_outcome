package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class CountingOutputStream extends ProxyOutputStream {
    private long count;

    public CountingOutputStream(OutputStream r1) {
        super(r1);
    }

    @Override // org.apache.commons.io.output.ProxyOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r5) throws IOException {
        this.count += (long) r5.length;
        super.write(r5);
    }

    @Override // org.apache.commons.io.output.ProxyOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r5, int r6, int r7) throws IOException {
        this.count += (long) r7;
        super.write(r5, r6, r7);
    }

    @Override // org.apache.commons.io.output.ProxyOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(int r5) throws IOException {
        this.count++;
        super.write(r5);
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
