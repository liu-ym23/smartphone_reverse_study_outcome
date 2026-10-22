package cz.msebera.android.httpclient.client.entity;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
class LazyDecompressingInputStream extends InputStream {
    private final InputStreamFactory inputStreamFactory;
    private final InputStream wrappedStream;
    private InputStream wrapperStream;

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public LazyDecompressingInputStream(InputStream r1, InputStreamFactory r2) {
        this.wrappedStream = r1;
        this.inputStreamFactory = r2;
    }

    private void initWrapper() throws IOException {
        if (this.wrapperStream != null) goto L6;
        this.wrapperStream = this.inputStreamFactory.create(this.wrappedStream);
        return;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        initWrapper();
        return this.wrapperStream.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] r1) throws IOException {
        initWrapper();
        return this.wrapperStream.read(r1);
    }

    @Override // java.io.InputStream
    public int read(byte[] r1, int r2, int r3) throws IOException {
        initWrapper();
        return this.wrapperStream.read(r1, r2, r3);
    }

    @Override // java.io.InputStream
    public long skip(long r1) throws IOException {
        initWrapper();
        return this.wrapperStream.skip(r1);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        initWrapper();
        return this.wrapperStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream r0 = this.wrapperStream;     // Catch: Throwable -> L7
        if (r0 == null) goto L5;
        r0.close();     // Catch: Throwable -> L7
    L5:
        this.wrappedStream.close();
        return;
    L7:
        th = move-exception;
        this.wrappedStream.close();
        throw th;
    }
}
