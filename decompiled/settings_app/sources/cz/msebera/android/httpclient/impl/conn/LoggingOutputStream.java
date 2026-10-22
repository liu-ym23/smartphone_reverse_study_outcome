package cz.msebera.android.httpclient.impl.conn;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
class LoggingOutputStream extends OutputStream {
    private final OutputStream out;
    private final Wire wire;

    public LoggingOutputStream(OutputStream r1, Wire r2) {
        this.out = r1;
        this.wire = r2;
    }

    @Override // java.io.OutputStream
    public void write(int r3) throws IOException {
        this.wire.output(r3);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        this.wire.output("[write] I/O error: " + e.getMessage());
        throw e;
    }

    @Override // java.io.OutputStream
    public void write(byte[] r3) throws IOException {
        this.wire.output(r3);     // Catch: IOException -> L4
        this.out.write(r3);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        this.wire.output("[write] I/O error: " + e.getMessage());
        throw e;
    }

    @Override // java.io.OutputStream
    public void write(byte[] r2, int r3, int r4) throws IOException {
        this.wire.output(r2, r3, r4);     // Catch: IOException -> L4
        this.out.write(r2, r3, r4);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        this.wire.output("[write] I/O error: " + e.getMessage());
        throw e;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        this.wire.output("[flush] I/O error: " + e.getMessage());
        throw e;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        this.wire.output("[close] I/O error: " + e.getMessage());
        throw e;
    }
}
