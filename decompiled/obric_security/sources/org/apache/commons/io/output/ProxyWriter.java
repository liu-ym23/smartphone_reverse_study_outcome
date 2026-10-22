package org.apache.commons.io.output;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes5.dex */
public class ProxyWriter extends FilterWriter {
    public ProxyWriter(Writer r1) {
        super(r1);
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(int r1) throws IOException {
        this.out.write(r1);
    }

    @Override // java.io.Writer
    public void write(char[] r1) throws IOException {
        this.out.write(r1);
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(char[] r1, int r2, int r3) throws IOException {
        this.out.write(r1, r2, r3);
    }

    @Override // java.io.Writer
    public void write(String r1) throws IOException {
        this.out.write(r1);
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(String r1, int r2, int r3) throws IOException {
        this.out.write(r1, r2, r3);
    }

    @Override // java.io.FilterWriter, java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // java.io.FilterWriter, java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
    }
}
