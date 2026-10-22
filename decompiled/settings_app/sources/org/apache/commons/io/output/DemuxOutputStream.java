package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
public class DemuxOutputStream extends OutputStream {
    private InheritableThreadLocal m_streams;

    public DemuxOutputStream() {
        this.m_streams = new InheritableThreadLocal();
    }

    public OutputStream bindStream(OutputStream r2) {
        OutputStream r0 = getStream();
        this.m_streams.set(r2);
        return r0;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        OutputStream r0 = getStream();
        if (r0 == null) goto L6;
        r0.close();
        return;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        OutputStream r0 = getStream();
        if (r0 == null) goto L6;
        r0.flush();
        return;
    }

    @Override // java.io.OutputStream
    public void write(int r1) throws IOException {
        OutputStream r0 = getStream();
        if (r0 == null) goto L6;
        r0.write(r1);
        return;
    }

    private OutputStream getStream() {
        return (OutputStream) this.m_streams.get();
    }
}
