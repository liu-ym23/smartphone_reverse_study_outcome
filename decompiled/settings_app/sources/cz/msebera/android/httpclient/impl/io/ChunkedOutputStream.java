package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class ChunkedOutputStream extends OutputStream {
    private final byte[] cache;
    private int cachePosition;
    private boolean closed;
    private final SessionOutputBuffer out;
    private boolean wroteLastChunk;

    @Deprecated
    public ChunkedOutputStream(SessionOutputBuffer r1, int r2) throws IOException {
        this(r2, r1);
    }

    @Deprecated
    public ChunkedOutputStream(SessionOutputBuffer r2) throws IOException {
        this(2048, r2);
    }

    public ChunkedOutputStream(int r2, SessionOutputBuffer r3) {
        this.cachePosition = 0;
        this.wroteLastChunk = false;
        this.closed = false;
        this.cache = new byte[r2];
        this.out = r3;
    }

    protected void flushCache() throws IOException {
        int r0 = this.cachePosition;
        if (r0 <= 0) goto L6;
        this.out.writeLine(Integer.toHexString(r0));
        this.out.write(this.cache, 0, this.cachePosition);
        this.out.writeLine("");
        this.cachePosition = 0;
        return;
    }

    protected void flushCacheWithAppend(byte[] r5, int r6, int r7) throws IOException {
        this.out.writeLine(Integer.toHexString(this.cachePosition + r7));
        this.out.write(this.cache, 0, this.cachePosition);
        this.out.write(r5, r6, r7);
        this.out.writeLine("");
        this.cachePosition = 0;
    }

    protected void writeClosingChunk() throws IOException {
        this.out.writeLine("0");
        this.out.writeLine("");
    }

    public void finish() throws IOException {
        if (this.wroteLastChunk == true) goto L6;
        flushCache();
        writeClosingChunk();
        this.wroteLastChunk = true;
        return;
    }

    @Override // java.io.OutputStream
    public void write(int r3) throws IOException {
        if (this.closed == true) goto L9;
        byte[] r0 = this.cache;
        int r1 = this.cachePosition;
        r0[r1] = (byte) r3;
        int r2 = r1 + 1;
        this.cachePosition = r2;
        if (r2 != r0.length) goto L10;
        flushCache();
        return;
    L10:
        return;
    L9:
        throw new IOException("Attempted write to closed stream.");
    }

    @Override // java.io.OutputStream
    public void write(byte[] r3) throws IOException {
        write(r3, 0, r3.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r4, int r5, int r6) throws IOException {
        if (this.closed == true) goto L10;
        byte[] r0 = this.cache;
        int r1 = r0.length;
        int r2 = this.cachePosition;
        if (r6 < (r1 - r2)) goto L7;
        flushCacheWithAppend(r4, r5, r6);
        return;
    L7:
        System.arraycopy(r4, r5, r0, r2, r6);
        this.cachePosition += r6;
        return;
    L10:
        throw new IOException("Attempted write to closed stream.");
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        flushCache();
        this.out.flush();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed == true) goto L6;
        this.closed = true;
        finish();
        this.out.flush();
        return;
    }
}
