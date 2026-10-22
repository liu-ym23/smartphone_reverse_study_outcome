package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class IdentityOutputStream extends OutputStream {
    private boolean closed;
    private final SessionOutputBuffer out;

    public IdentityOutputStream(SessionOutputBuffer r2) {
        this.closed = false;
        this.out = (SessionOutputBuffer) Args.notNull(r2, "Session output buffer");
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
    public void write(byte[] r2, int r3, int r4) throws IOException {
        if (this.closed == true) goto L7;
        this.out.write(r2, r3, r4);
        return;
    L7:
        throw new IOException("Attempted write to closed stream.");
    }

    @Override // java.io.OutputStream
    public void write(byte[] r3) throws IOException {
        write(r3, 0, r3.length);
    }

    @Override // java.io.OutputStream
    public void write(int r2) throws IOException {
        if (this.closed == true) goto L7;
        this.out.write(r2);
        return;
    L7:
        throw new IOException("Attempted write to closed stream.");
    }
}
