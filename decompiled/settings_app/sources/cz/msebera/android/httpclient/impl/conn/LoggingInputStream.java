package cz.msebera.android.httpclient.impl.conn;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
class LoggingInputStream extends InputStream {
    private final InputStream in;
    private final Wire wire;

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public LoggingInputStream(InputStream r1, Wire r2) {
        this.in = r1;
        this.wire = r2;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int r0 = this.in.read();     // Catch: IOException -> L7
        if (r0 != (-1)) goto L5;
        this.wire.input("end of stream");     // Catch: IOException -> L7
    L6:
        return r0;
    L5:
        this.wire.input(r0);     // Catch: IOException -> L7
    L7:
        e = move-exception;
        this.wire.input("[read] I/O error: " + e.getMessage());
        throw e;
    }

    @Override // java.io.InputStream
    public int read(byte[] r4) throws IOException {
        int r0 = this.in.read(r4);     // Catch: IOException -> L8
        if (r0 != (-1)) goto L5;
        this.wire.input("end of stream");     // Catch: IOException -> L8
    L7:
        return r0;
    L5:
        if (r0 <= 0) goto L7;
        this.wire.input(r4, 0, r0);     // Catch: IOException -> L8
    L8:
        e = move-exception;
        this.wire.input("[read] I/O error: " + e.getMessage());
        throw e;
    }

    @Override // java.io.InputStream
    public int read(byte[] r2, int r3, int r4) throws IOException {
        int r5 = this.in.read(r2, r3, r4);     // Catch: IOException -> L8
        if (r5 != (-1)) goto L5;
        this.wire.input("end of stream");     // Catch: IOException -> L8
    L7:
        return r5;
    L5:
        if (r5 <= 0) goto L7;
        this.wire.input(r2, r3, r5);     // Catch: IOException -> L8
    L8:
        e = move-exception;
        this.wire.input("[read] I/O error: " + e.getMessage());
        throw e;
    }

    @Override // java.io.InputStream
    public long skip(long r2) throws IOException {
        return super.skip(r2);
    L4:
        e = move-exception;
        this.wire.input("[skip] I/O error: " + e.getMessage());
        throw e;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.in.available();
    L4:
        e = move-exception;
        this.wire.input("[available] I/O error : " + e.getMessage());
        throw e;
    }

    @Override // java.io.InputStream
    public void mark(int r1) {
        super.mark(r1);
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        super.reset();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.in.close();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        this.wire.input("[close] I/O error: " + e.getMessage());
        throw e;
    }
}
