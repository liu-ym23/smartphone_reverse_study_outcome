package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.io.BufferInfo;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public class IdentityInputStream extends InputStream {
    private boolean closed;
    private final SessionInputBuffer in;

    public IdentityInputStream(SessionInputBuffer r2) {
        this.closed = false;
        this.in = (SessionInputBuffer) Args.notNull(r2, "Session input buffer");
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        SessionInputBuffer r1 = this.in;
        if ((r1 instanceof BufferInfo) == true) goto L5;
        return 0;
    L5:
        return ((BufferInfo) r1).length();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.closed == false) goto L6;
        return -1;
    L6:
        return this.in.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] r2, int r3, int r4) throws IOException {
        if (this.closed == false) goto L6;
        return -1;
    L6:
        return this.in.read(r2, r3, r4);
    }
}
