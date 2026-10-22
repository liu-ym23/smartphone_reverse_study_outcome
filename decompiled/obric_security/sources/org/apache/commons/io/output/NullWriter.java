package org.apache.commons.io.output;

import java.io.Writer;

/* JADX INFO: loaded from: classes5.dex */
public class NullWriter extends Writer {
    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    @Override // java.io.Writer
    public void write(int r1) {
    }

    @Override // java.io.Writer
    public void write(String r1) {
    }

    @Override // java.io.Writer
    public void write(String r1, int r2, int r3) {
    }

    @Override // java.io.Writer
    public void write(char[] r1) {
    }

    @Override // java.io.Writer
    public void write(char[] r1, int r2, int r3) {
    }

    public NullWriter() {
    }
}
