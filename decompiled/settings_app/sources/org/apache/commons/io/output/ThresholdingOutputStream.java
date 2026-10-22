package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ThresholdingOutputStream extends OutputStream {
    private int threshold;
    private boolean thresholdExceeded;
    private long written;

    protected abstract OutputStream getStream() throws IOException;

    protected abstract void thresholdReached() throws IOException;

    public ThresholdingOutputStream(int r1) {
        this.threshold = r1;
    }

    @Override // java.io.OutputStream
    public void write(int r5) throws IOException {
        checkThreshold(1);
        getStream().write(r5);
        this.written++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] r5) throws IOException {
        checkThreshold(r5.length);
        getStream().write(r5);
        this.written += (long) r5.length;
    }

    @Override // java.io.OutputStream
    public void write(byte[] r3, int r4, int r5) throws IOException {
        checkThreshold(r5);
        getStream().write(r3, r4, r5);
        this.written += (long) r5;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        getStream().flush();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        flush();     // Catch: IOException -> L5
    L3:
        getStream().close();
    }

    public int getThreshold() {
        return this.threshold;
    }

    public long getByteCount() {
        return this.written;
    }

    public boolean isThresholdExceeded() {
        if (this.written <= this.threshold) goto L5;
        return true;
    L5:
        return false;
    }

    protected void checkThreshold(int r5) throws IOException {
        if (this.thresholdExceeded == false) goto L5;
        return;
    L5:
        if ((this.written + ((long) r5)) <= this.threshold) goto L9;
        thresholdReached();
        this.thresholdExceeded = true;
        return;
    }
}
