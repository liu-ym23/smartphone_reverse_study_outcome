package cz.msebera.android.httpclient.impl.auth;

import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes5.dex */
class HttpEntityDigester extends OutputStream {
    private boolean closed;
    private byte[] digest;
    private final MessageDigest digester;

    HttpEntityDigester(MessageDigest r1) {
        this.digester = r1;
        r1.reset();
    }

    @Override // java.io.OutputStream
    public void write(int r2) throws IOException {
        if (this.closed == true) goto L7;
        this.digester.update((byte) r2);
        return;
    L7:
        throw new IOException("Stream has been already closed");
    }

    @Override // java.io.OutputStream
    public void write(byte[] r2, int r3, int r4) throws IOException {
        if (this.closed == true) goto L7;
        this.digester.update(r2, r3, r4);
        return;
    L7:
        throw new IOException("Stream has been already closed");
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed == false) goto L5;
        return;
    L5:
        this.closed = true;
        this.digest = this.digester.digest();
        super.close();
    }

    public byte[] getDigest() {
        return this.digest;
    }
}
