package cz.msebera.android.httpclient.client.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes5.dex */
public class DeflateInputStream extends InputStream {
    private final InputStream sourceStream;

    static class DeflateStream extends InflaterInputStream {
        private boolean closed;

        public DeflateStream(InputStream r1, Inflater r2) {
            super(r1, r2);
            this.closed = false;
        }

        @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed == false) goto L5;
            return;
        L5:
            this.closed = true;
            this.inf.end();
            super.close();
        }
    }

    public DeflateInputStream(InputStream r6) throws IOException {
        PushbackInputStream r0 = new PushbackInputStream(r6, 2);
        int r7 = r0.read();
        int r1 = r0.read();
        if (r7 == (-1)) goto L16;
        if (r1 == (-1)) goto L16;
        r0.unread(r1);
        r0.unread(r7);
        int r8 = r7 & 255;
        int r3 = (r8 >> 4) & 15;
        int r2 = r1 & 255;
        if ((r8 & 15) == 8) goto L8;
    L12:
        boolean r9 = true;
    L13:
        this.sourceStream = new DeflateStream(r0, new Inflater(r9));
        return;
    L8:
        if (r3 > 7) goto L12;
        if ((((r8 << 8) | r2) % 31) != 0) goto L12;
        r9 = false;
    L16:
        throw new ZipException("Unexpected end of stream");
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.sourceStream.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] r1) throws IOException {
        return this.sourceStream.read(r1);
    }

    @Override // java.io.InputStream
    public int read(byte[] r1, int r2, int r3) throws IOException {
        return this.sourceStream.read(r1, r2, r3);
    }

    @Override // java.io.InputStream
    public long skip(long r1) throws IOException {
        return this.sourceStream.skip(r1);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.sourceStream.available();
    }

    @Override // java.io.InputStream
    public void mark(int r1) {
        this.sourceStream.mark(r1);
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.sourceStream.reset();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.sourceStream.markSupported();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.sourceStream.close();
    }
}
