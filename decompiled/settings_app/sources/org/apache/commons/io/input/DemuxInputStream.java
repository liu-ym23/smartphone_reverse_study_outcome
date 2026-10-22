package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public class DemuxInputStream extends InputStream {
    private InheritableThreadLocal m_streams;

    public DemuxInputStream() {
        this.m_streams = new InheritableThreadLocal();
    }

    public InputStream bindStream(InputStream r2) {
        InputStream r0 = getStream();
        this.m_streams.set(r2);
        return r0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream r0 = getStream();
        if (r0 == null) goto L6;
        r0.close();
        return;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        InputStream r0 = getStream();
        if (r0 != null) goto L5;
        return -1;
    L5:
        return r0.read();
    }

    private InputStream getStream() {
        return (InputStream) this.m_streams.get();
    }
}
