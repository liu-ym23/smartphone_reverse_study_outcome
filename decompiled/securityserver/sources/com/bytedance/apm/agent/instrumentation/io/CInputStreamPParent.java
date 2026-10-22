package com.bytedance.apm.agent.instrumentation.io;

import com.bytedance.apm.agent.logging.AgentLog;
import com.bytedance.apm.agent.logging.AgentLogManager;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public abstract class CInputStreamPParent extends InputStream implements StreamCompleteListenerSource {
    protected static final int DEFAULT_LIMIT_OF_RESPONSE_BODY_BYTES = 2048;
    protected static final AgentLog sLog = null;
    protected final ByteBuffer buf;
    protected long c;
    protected boolean cac;
    protected final StreamCompleteListenerManager callback;
    protected final InputStream impl;

    static {
        sLog = AgentLogManager.getAgentLog();
    }

    public CInputStreamPParent(InputStream r2) {
        this(r2, false);
    }

    private boolean isBufferEmpty() {
        return !this.buf.hasRemaining();
    }

    private boolean isBufferLargerThan(long r3) {
        if (this.buf.remaining() < r3) goto L5;
        return true;
    L5:
        return false;
    }

    private void notifyComplete() {
        if (this.callback.isComplete() == true) goto L6;
        StreamCompleteEvent r0 = new StreamCompleteEvent(this, this.c);
        this.callback.notifyStreamComplete(r0);
        return;
    }

    private void notifyError(Exception r4) {
        if (this.callback.isComplete() == true) goto L6;
        StreamCompleteEvent r0 = new StreamCompleteEvent(this, this.c, r4);
        this.callback.notifyStreamError(r0);
        return;
    }

    private int readBuffer() {
        if (isBufferEmpty() == false) goto L6;
        return -1;
    L6:
        return this.buf.get();
    }

    @Override // java.io.InputStream
    public int available() {
    L5:
        e = move-exception;
        notifyError(e);
        throw e;
    L3:
        if (this.cac == false) goto L7;
        int r0 = this.buf.remaining();     // Catch: IOException -> L5
    L8:
        return r0 + this.impl.available();
    L7:
        r0 = 0;
        goto L8
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        InputStream r0 = this.impl;     // Catch: IOException -> L5
        if (r0 == null) goto L7;
        r0.close();     // Catch: IOException -> L5
    L7:
        notifyComplete();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        notifyError(e);
        throw e;
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

    public String getBufferAsString() {
        ByteBuffer r0 = this.buf;
        if (r0 == null) goto L16;
        monitor-enter(r0);
        byte[] r1 = new byte[this.buf.limit()];     // Catch: Throwable -> L9
        int r2 = 0;
    L7:
        if (r2 >= this.buf.limit()) goto L11;
        r1[r2] = this.buf.get(r2);     // Catch: Throwable -> L9
        r2 = r2 + 1;     // Catch: Throwable -> L9
        goto L7
    L11:
        String r4 = new String(r1);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r4;
    L9:
        th = move-exception;
        throw th;
    L16:
        return "";
    }

    @Override // java.io.InputStream
    public void mark(int r2) {
        if (markSupported() == true) goto L5;
        return;
    L5:
        this.impl.mark(r2);
    }

    @Override // java.io.InputStream
    public int read(byte[] r8, int r9, int r10) {
        int r1 = 0;
        if (this.cac == false) goto L30;
        ByteBuffer r0 = this.buf;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (isBufferLargerThan(r10) == false) goto L18;
        int r11 = readBuffer(r8, r9, r10);     // Catch: Throwable -> L14
        if (r11 < 0) goto L17;
        this.c += (long) r11;     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r11;
    L17:
        throw new IOException("Failed to readBuffer()");     // Catch: Throwable -> L14
    L18:
        int r2 = this.buf.remaining();     // Catch: Throwable -> L14
        if (r2 <= 0) goto L25;
        int r3 = readBuffer(r8, r9, r2);     // Catch: Throwable -> L14
        if (r3 < 0) goto L24;
        r10 = r10 - r3;     // Catch: Throwable -> L14
        this.c += (long) r3;     // Catch: Throwable -> L14
    L26:
        monitor-exit(r0);     // Catch: Throwable -> L14
    L46:
        InputStream r4 = this.impl;     // Catch: IOException -> L38
        if (r4 == null) goto L35;
        r1 = r4.read(r8, r9 + r3, r10);     // Catch: IOException -> L38
    L35:
        if (r1 < 0) goto L40;
        this.c += (long) r1;     // Catch: IOException -> L38
        return r1 + r3;
    L40:
        if (r3 > 0) goto L43;
        notifyComplete();     // Catch: IOException -> L38
        return r1;
    L43:
        return r3;
    L38:
        e = move-exception;
        notifyError(e);
        throw e;
    L24:
        throw new IOException("Failed to partial read from buffer");     // Catch: Throwable -> L14
    L25:
        r3 = 0;
        goto L26
    L30:
        r3 = 0;
        goto L46
    }

    @Override // com.bytedance.apm.agent.instrumentation.io.StreamCompleteListenerSource
    public void removeStreamCompleteListener(StreamCompleteListener r1) {
        this.callback.removeStreamCompleteListener(r1);
    }

    @Override // java.io.InputStream
    public void reset() {
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

    @Override // java.io.InputStream
    public long skip(long r4) {
        if (this.cac == false) goto L28;
        ByteBuffer r0 = this.buf;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (isBufferLargerThan(r4) == false) goto L13;
        this.buf.position((int) r4);     // Catch: Throwable -> L11
        this.c += r4;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r4;
    L13:
        r4 = r4 - ((long) this.buf.remaining());     // Catch: Throwable -> L11
        if (r4 <= 0) goto L19;
        ByteBuffer r1 = this.buf;     // Catch: Throwable -> L11
        r1.position(r1.remaining());     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        goto L28
    L19:
        throw new IOException("Failed to partial read from buffer (skip)");     // Catch: Throwable -> L11
    L28:
        long r5 = this.impl.skip(r4);     // Catch: IOException -> L24
        this.c += r5;     // Catch: IOException -> L24
        return r5;
    L24:
        e = move-exception;
        notifyError(e);
        throw e;
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
}
