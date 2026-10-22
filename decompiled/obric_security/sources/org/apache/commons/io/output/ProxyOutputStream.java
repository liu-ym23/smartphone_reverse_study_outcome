package org.apache.commons.io.output;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class ProxyOutputStream extends FilterOutputStream {
    public ProxyOutputStream(OutputStream r1) {
        super(r1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int r1) throws IOException {
        this.out.write(r1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r1) throws IOException {
        this.out.write(r1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r1, int r2, int r3) throws IOException {
        this.out.write(r1, r2, r3);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
    }
}
