package cz.msebera.android.httpclient.impl.io;

import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public final class EmptyInputStream extends InputStream {
    public static final EmptyInputStream INSTANCE = null;

    @Override // java.io.InputStream
    public int available() {
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.InputStream
    public void mark(int r1) {
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() {
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] r1) {
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] r1, int r2, int r3) {
        return -1;
    }

    @Override // java.io.InputStream
    public void reset() {
    }

    @Override // java.io.InputStream
    public long skip(long r1) {
        return 0;
    }

    static {
        INSTANCE = new EmptyInputStream();
    }

    private EmptyInputStream() {
    }
}
