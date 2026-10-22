package com.google.crypto.tink.subtle;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;

/* JADX INFO: loaded from: classes4.dex */
public final class RewindableReadableByteChannel implements ReadableByteChannel {
    final ReadableByteChannel baseChannel;
    ByteBuffer buffer;
    boolean canRewind;
    boolean directRead;

    public RewindableReadableByteChannel(ReadableByteChannel baseChannel) {
        this.baseChannel = baseChannel;
        this.buffer = null;
        this.canRewind = true;
        this.directRead = false;
    }

    public synchronized void disableRewinding() {
        monitor-enter(this);
        this.canRewind = false;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void rewind() throws IOException {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.canRewind == false) goto L11;
        ByteBuffer r0 = this.buffer;     // Catch: Throwable -> L12
        if (r0 == null) goto L8;
        r0.position(0);     // Catch: Throwable -> L12
    L8:
        monitor-exit(this);
        return;
    L11:
        throw new IOException("Cannot rewind anymore.");     // Catch: Throwable -> L12
    }

    private synchronized void setBufferLimit(int newLimit) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.buffer.capacity() >= newLimit) goto L6;
        int r0 = this.buffer.position();     // Catch: Throwable -> L9
        ByteBuffer r1 = ByteBuffer.allocate(Math.max(this.buffer.capacity() * 2, newLimit));     // Catch: Throwable -> L9
        this.buffer.rewind();     // Catch: Throwable -> L9
        r1.put(this.buffer);     // Catch: Throwable -> L9
        r1.position(r0);     // Catch: Throwable -> L9
        this.buffer = r1;     // Catch: Throwable -> L9
    L6:
        this.buffer.limit(newLimit);     // Catch: Throwable -> L9
        monitor-exit(this);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public synchronized int read(ByteBuffer dst) throws IOException {
        monitor-enter(this);
    L47:
        th = move-exception;
        throw th;
    L4:
        if (this.directRead == false) goto L8;
        int r7 = this.baseChannel.read(dst);     // Catch: Throwable -> L47
        monitor-exit(this);
        return r7;
    L8:
        int r0 = dst.remaining();     // Catch: Throwable -> L47
        if (r0 != 0) goto L13;
        monitor-exit(this);
        return 0;
    L13:
        ByteBuffer r1 = this.buffer;     // Catch: Throwable -> L47
        if (r1 != null) goto L26;
        if (this.canRewind == true) goto L20;
        this.directRead = true;     // Catch: Throwable -> L47
        int r8 = this.baseChannel.read(dst);     // Catch: Throwable -> L47
        monitor-exit(this);
        return r8;
    L20:
        ByteBuffer r2 = ByteBuffer.allocate(r0);     // Catch: Throwable -> L47
        this.buffer = r2;     // Catch: Throwable -> L47
        int r3 = this.baseChannel.read(r2);     // Catch: Throwable -> L47
        this.buffer.flip();     // Catch: Throwable -> L47
        if (r3 <= 0) goto L23;
        dst.put(this.buffer);     // Catch: Throwable -> L47
    L23:
        monitor-exit(this);
        return r3;
    L26:
        if (r1.remaining() < r0) goto L34;
        int r4 = this.buffer.limit();     // Catch: Throwable -> L47
        ByteBuffer r5 = this.buffer;     // Catch: Throwable -> L47
        r5.limit(r5.position() + r0);     // Catch: Throwable -> L47
        dst.put(this.buffer);     // Catch: Throwable -> L47
        this.buffer.limit(r4);     // Catch: Throwable -> L47
        if (this.canRewind == false) goto L30;
    L32:
        monitor-exit(this);
        return r0;
    L30:
        if (this.buffer.hasRemaining() == true) goto L32;
        this.buffer = null;     // Catch: Throwable -> L47
        this.directRead = true;     // Catch: Throwable -> L47
        goto L32
    L34:
        int r6 = this.buffer.remaining();     // Catch: Throwable -> L47
        int r9 = this.buffer.position();     // Catch: Throwable -> L47
        int r10 = this.buffer.limit();     // Catch: Throwable -> L47
        setBufferLimit((r0 - r6) + r10);     // Catch: Throwable -> L47
        this.buffer.position(r10);     // Catch: Throwable -> L47
        int r11 = this.baseChannel.read(this.buffer);     // Catch: Throwable -> L47
        this.buffer.flip();     // Catch: Throwable -> L47
        this.buffer.position(r9);     // Catch: Throwable -> L47
        dst.put(this.buffer);     // Catch: Throwable -> L47
        if (r6 != 0) goto L40;
        if (r11 >= 0) goto L40;
        monitor-exit(this);
        return -1;
    L40:
        int r12 = this.buffer.position() - r9;     // Catch: Throwable -> L47
        if (this.canRewind == false) goto L43;
    L45:
        monitor-exit(this);
        return r12;
    L43:
        if (this.buffer.hasRemaining() == true) goto L45;
        this.buffer = null;     // Catch: Throwable -> L47
        this.directRead = true;     // Catch: Throwable -> L47
        goto L45
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        monitor-enter(this);
        this.canRewind = false;     // Catch: Throwable -> L7
        this.directRead = true;     // Catch: Throwable -> L7
        this.baseChannel.close();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.nio.channels.Channel
    public synchronized boolean isOpen() {
        monitor-enter(this);
        boolean r0 = this.baseChannel.isOpen();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }
}
