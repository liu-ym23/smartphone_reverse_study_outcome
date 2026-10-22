package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class ContentLengthOutputStream extends OutputStream {
    private boolean closed;
    private final long contentLength;
    private final SessionOutputBuffer out;
    private long total;

    public ContentLengthOutputStream(SessionOutputBuffer r2, long r3) {
        this.out = (SessionOutputBuffer) Args.notNull(r2, "Session output buffer");
        this.contentLength = Args.notNegative(r3, "Content length");
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed == true) goto L6;
        this.closed = true;
        this.out.flush();
        return;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // java.io.OutputStream
    public void write(byte[] r6, int r7, int r8) throws IOException {
        if (this.closed == true) goto L12;
        long r0 = this.total;
        long r2 = this.contentLength;
        if (r0 >= r2) goto L13;
        long r3 = r2 - r0;
        if (r8 <= r3) goto L9;
        r8 = (int) r3;
    L9:
        this.out.write(r6, r7, r8);
        this.total += (long) r8;
        return;
    L13:
        return;
    L12:
        throw new IOException("Attempted write to closed stream.");
    }

    @Override // java.io.OutputStream
    public void write(byte[] r3) throws IOException {
        write(r3, 0, r3.length);
    }

    @Override // java.io.OutputStream
    public void write(int r5) throws IOException {
        if (this.closed == true) goto L9;
        if (this.total >= this.contentLength) goto L10;
        this.out.write(r5);
        this.total++;
        return;
    L10:
        return;
    L9:
        throw new IOException("Attempted write to closed stream.");
    }
}
