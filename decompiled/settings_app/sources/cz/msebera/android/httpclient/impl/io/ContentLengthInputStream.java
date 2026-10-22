package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.ConnectionClosedException;
import cz.msebera.android.httpclient.io.BufferInfo;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public class ContentLengthInputStream extends InputStream {
    private static final int BUFFER_SIZE = 2048;
    private boolean closed;
    private final long contentLength;
    private SessionInputBuffer in;
    private long pos;

    public ContentLengthInputStream(SessionInputBuffer r3, long r4) {
        this.pos = 0;
        this.closed = false;
        this.in = null;
        this.in = (SessionInputBuffer) Args.notNull(r3, "Session input buffer");
        this.contentLength = Args.notNegative(r4, "Content length");
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed == false) goto L16;
        return;
    L16:
    L12:
        th = move-exception;
        this.closed = true;
        throw th;
    L6:
        if (this.pos >= this.contentLength) goto L11;
        byte[] r1 = new byte[2048];     // Catch: Throwable -> L12
    L8:
        if (read(r1) >= 0) goto L8;
    L11:
        this.closed = true;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        SessionInputBuffer r0 = this.in;
        if ((r0 instanceof BufferInfo) == true) goto L5;
        return 0;
    L5:
        return Math.min(((BufferInfo) r0).length(), (int) (this.contentLength - this.pos));
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.closed == true) goto L17;
        if (this.pos < this.contentLength) goto L7;
        return -1;
    L7:
        int r0 = this.in.read();
        if (r0 == (-1)) goto L10;
        this.pos++;
    L15:
        return r0;
    L10:
        if (this.pos >= this.contentLength) goto L15;
        throw new ConnectionClosedException("Premature end of Content-Length delimited message body (expected: %,d; received: %,d)", new Object[]{Long.valueOf(this.contentLength), Long.valueOf(this.pos)});
    L17:
        throw new IOException("Attempted read from closed stream.");
    }

    @Override // java.io.InputStream
    public int read(byte[] r9, int r10, int r11) throws IOException {
        if (this.closed == true) goto L21;
        long r0 = this.pos;
        long r2 = this.contentLength;
        if (r0 < r2) goto L8;
        return -1;
    L8:
        if ((((long) r11) + r0) <= r2) goto L10;
        r11 = (int) (r2 - r0);
    L10:
        int r12 = this.in.read(r9, r10, r11);
        if (r12 == (-1)) goto L13;
    L17:
        if (r12 <= 0) goto L19;
        this.pos += (long) r12;
    L19:
        return r12;
    L13:
        if (this.pos >= this.contentLength) goto L17;
        throw new ConnectionClosedException("Premature end of Content-Length delimited message body (expected: %,d; received: %,d)", new Object[]{Long.valueOf(this.contentLength), Long.valueOf(this.pos)});
    L21:
        throw new IOException("Attempted read from closed stream.");
    }

    @Override // java.io.InputStream
    public int read(byte[] r3) throws IOException {
        return read(r3, 0, r3.length);
    }

    @Override // java.io.InputStream
    public long skip(long r8) throws IOException {
        if (r8 > 0) goto L5;
        return 0;
    L5:
        byte[] r2 = new byte[2048];
        long r9 = Math.min(r8, this.contentLength - this.pos);
        long r3 = 0;
    L7:
        if (r9 <= 0) goto L12;
        int r5 = read(r2, 0, (int) Math.min(2048, r9));
        if (r5 == (-1)) goto L12;
        long r6 = r5;
        r3 = r3 + r6;
        r9 = r9 - r6;
    L12:
        return r3;
    }
}
