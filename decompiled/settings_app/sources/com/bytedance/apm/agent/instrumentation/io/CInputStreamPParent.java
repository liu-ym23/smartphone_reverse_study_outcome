package com.bytedance.apm.agent.instrumentation.io;

import com.bytedance.apm.agent.logging.AgentLog;
import com.bytedance.apm.agent.logging.AgentLogManager;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CInputStreamPParent extends InputStream implements StreamCompleteListenerSource {
    protected static final int DEFAULT_LIMIT_OF_RESPONSE_BODY_BYTES = 2048;
    protected static final AgentLog sLog = null;
    protected final ByteBuffer buf;
    protected long c;
    protected boolean cac;
    protected final StreamCompleteListenerManager callback;
    protected final InputStream impl;

    public String getBufferAsString() {
        ByteBuffer r0 = this.buf;
        if (r0 == null) goto L15;
        monitor-enter(r0);
        byte[] r1 = new byte[this.buf.limit()];     // Catch: Throwable -> L12
        int r2 = 0;
    L7:
        if (r2 >= this.buf.limit()) goto L9;
        r1[r2] = this.buf.get(r2);     // Catch: Throwable -> L12
        r2 = r2 + 1;     // Catch: Throwable -> L12
        goto L7
    L9:
        String r4 = new String(r1);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r4;
    L12:
        th = move-exception;
        throw th;
    L15:
        return "";
    }

    @Override // java.io.InputStream
    public long skip(long r4) throws IOException {
        if (this.cac == false) goto L26;
        ByteBuffer r0 = this.buf;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L7:
        if (isBufferLargerThan(r4) == false) goto L11;
        this.buf.position((int) r4);     // Catch: Throwable -> L18
        this.c += r4;     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return r4;
    L11:
        r4 = r4 - ((long) this.buf.remaining());     // Catch: Throwable -> L18
        if (r4 <= 0) goto L17;
        ByteBuffer r1 = this.buf;     // Catch: Throwable -> L18
        r1.position(r1.remaining());     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        goto L26
    L17:
        throw new IOException("Failed to partial read from buffer (skip)");     // Catch: Throwable -> L18
    L26:
        long r5 = this.impl.skip(r4);     // Catch: IOException -> L23
        this.c += r5;     // Catch: IOException -> L23
        return r5;
    L23:
        e = move-exception;
        notifyError(e);
        throw e;
    }

    private boolean isBufferEmpty() {
        return !this.buf.hasRemaining();
    }

    @Override // java.io.InputStream
    public int read(byte[] r8, int r9, int r10) throws IOException {
        int r1 = 0;
        if (this.cac == false) goto L29;
        ByteBuffer r0 = this.buf;
        monitor-enter(r0);
    L26:
        th = move-exception;
        throw th;
    L8:
        if (isBufferLargerThan(r10) == false) goto L16;
        int r11 = readBuffer(r8, r9, r10);     // Catch: Throwable -> L26
        if (r11 < 0) goto L15;
        this.c += (long) r11;     // Catch: Throwable -> L26
        monitor-exit(r0);     // Catch: Throwable -> L26
        return r11;
    L15:
        throw new IOException("Failed to readBuffer()");     // Catch: Throwable -> L26
    L16:
        int r2 = this.buf.remaining();     // Catch: Throwable -> L26
        if (r2 <= 0) goto L23;
        int r3 = readBuffer(r8, r9, r2);     // Catch: Throwable -> L26
        if (r3 < 0) goto L22;
        r10 = r10 - r3;     // Catch: Throwable -> L26
        this.c += (long) r3;     // Catch: Throwable -> L26
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L26
    L44:
        InputStream r4 = this.impl;     // Catch: IOException -> L41
        if (r4 == null) goto L34;
        r1 = r4.read(r8, r9 + r3, r10);     // Catch: IOException -> L41
    L34:
        if (r1 < 0) goto L37;
        this.c += (long) r1;     // Catch: IOException -> L41
        return r1 + r3;
    L37:
        if (r3 > 0) goto L40;
        notifyComplete();     // Catch: IOException -> L41
        return r1;
    L40:
        return r3;
    L41:
        e = move-exception;
        notifyError(e);
        throw e;
    L22:
        throw new IOException("Failed to partial read from buffer");     // Catch: Throwable -> L26
    L23:
        r3 = 0;
        goto L24
    L29:
        r3 = 0;
        goto L44
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream r0 = this.impl;     // Catch: IOException -> L7
        if (r0 == null) goto L5;
        r0.close();     // Catch: IOException -> L7
    L5:
        notifyComplete();     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        notifyError(e);
        throw e;
    }

    private void notifyError(Exception r4) {
        if (this.callback.isComplete() == true) goto L6;
        StreamCompleteEvent r0 = new StreamCompleteEvent(this, this.c, r4);
        this.callback.notifyStreamError(r0);
        return;
    }

    @Override // java.io.InputStream
    public void mark(int r2) {
        if (markSupported() == true) goto L5;
        return;
    L5:
        this.impl.mark(r2);
    }

    public void fillBuffer() {
        ByteBuffer r0 = this.buf;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hasArray() == false) goto L28;
        ByteBuffer r1 = this.buf;
        monitor-enter(r1);
        int r2 = this.impl.read(this.buf.array(), 0, this.buf.capacity());     // Catch: Throwable -> L11 IOException -> L13
    L15:
        if (r2 > 0) goto L18;
        this.buf.limit(0);     // Catch: Throwable -> L11
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L18:
        if (r2 >= this.buf.capacity()) goto L20;
        this.buf.limit(r2);     // Catch: Throwable -> L11
        goto L20
    L11:
        th = move-exception;
        throw th;
    L13:
        e = move-exception;
        sLog.error(e.toString());     // Catch: Throwable -> L11
        r2 = 0;
        goto L15
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
    L9:
        e = move-exception;
        notifyError(e);
        throw e;
    L3:
        if (this.cac == false) goto L5;
        int r0 = this.buf.remaining();     // Catch: IOException -> L9
    L6:
        return r0 + this.impl.available();
    L5:
        r0 = 0;
        goto L6
    }

    static {
        sLog = AgentLogManager.getAgentLog();
    }

    public CInputStreamPParent(InputStream r2) {
        this(r2, false);
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        if (markSupported() == true) goto L10;
        return;
    L10:
        this.impl.reset();     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        notifyError(e);
        throw e;
    }

    private void notifyComplete() {
        if (this.callback.isComplete() == true) goto L6;
        StreamCompleteEvent r0 = new StreamCompleteEvent(this, this.c);
        this.callback.notifyStreamComplete(r0);
        return;
    }

    private int readBuffer() {
        if (isBufferEmpty() == false) goto L6;
        return -1;
    L6:
        return this.buf.get();
    }

    private int readBuffer(byte[] r3) {
        return readBuffer(r3, 0, r3.length);
    }

    private int readBuffer(byte[] r3, int r4, int r5) {
        if (isBufferEmpty() == false) goto L6;
        return -1;
    L6:
        int r0 = this.buf.remaining();
        this.buf.get(r3, r4, r5);
        return r0 - this.buf.remaining();
    }

    private boolean isBufferLargerThan(long r3) {
        if (this.buf.remaining() < r3) goto L5;
        return true;
    L5:
        return false;
    }

    public CInputStreamPParent(InputStream r3, boolean r4) {
        this.c = 0;
        this.callback = new StreamCompleteListenerManager();
        this.impl = r3;
        this.cac = r4;
        if (r4 == true) goto L5;
        ByteBuffer r5 = null;
    L6:
        this.buf = r5;
        fillBuffer();
        return;
    L5:
        r5 = ByteBuffer.allocate(2048);
        goto L6
    }

    @Override // com.bytedance.apm.agent.instrumentation.io.StreamCompleteListenerSource
    public void removeStreamCompleteListener(StreamCompleteListener r1) {
        this.callback.removeStreamCompleteListener(r1);
    }
}
