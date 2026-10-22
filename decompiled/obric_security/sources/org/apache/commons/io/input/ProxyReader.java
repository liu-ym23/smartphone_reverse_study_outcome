package org.apache.commons.io.input;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ProxyReader extends FilterReader {
    public ProxyReader(Reader r1) {
        super(r1);
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read() throws IOException {
        return this.in.read();
    }

    @Override // java.io.Reader
    public int read(char[] r1) throws IOException {
        return this.in.read(r1);
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read(char[] r1, int r2, int r3) throws IOException {
        return this.in.read(r1, r2, r3);
    }

    @Override // java.io.FilterReader, java.io.Reader
    public long skip(long r1) throws IOException {
        return this.in.skip(r1);
    }

    @Override // java.io.FilterReader, java.io.Reader
    public boolean ready() throws IOException {
        return this.in.ready();
    }

    @Override // java.io.FilterReader, java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.in.close();
    }

    @Override // java.io.FilterReader, java.io.Reader
    public synchronized void mark(int r2) throws IOException {
        monitor-enter(this);
        this.in.mark(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterReader, java.io.Reader
    public synchronized void reset() throws IOException {
        monitor-enter(this);
        this.in.reset();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterReader, java.io.Reader
    public boolean markSupported() {
        return this.in.markSupported();
    }
}
