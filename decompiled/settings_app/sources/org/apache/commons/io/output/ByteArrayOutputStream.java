package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class ByteArrayOutputStream extends OutputStream {
    private static final byte[] EMPTY_BYTE_ARRAY = null;
    private List buffers;
    private int count;
    private byte[] currentBuffer;
    private int currentBufferIndex;
    private int filledBufferSum;

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    static {
        EMPTY_BYTE_ARRAY = new byte[0];
    }

    public ByteArrayOutputStream() {
        this(1024);
    }

    public ByteArrayOutputStream(int r3) {
        this.buffers = new ArrayList();
        if (r3 < 0) goto L7;
        needNewBuffer(r3);
        return;
    L7:
        throw new IllegalArgumentException(new StringBuffer("Negative initial size: ").append(r3).toString());
    }

    private byte[] getBuffer(int r1) {
        return (byte[]) this.buffers.get(r1);
    }

    private void needNewBuffer(int r3) {
        if (this.currentBufferIndex >= (this.buffers.size() - 1)) goto L5;
        this.filledBufferSum += this.currentBuffer.length;
        int r4 = this.currentBufferIndex + 1;
        this.currentBufferIndex = r4;
        this.currentBuffer = getBuffer(r4);
        return;
    L5:
        byte[] r0 = this.currentBuffer;
        if (r0 != null) goto L8;
        this.filledBufferSum = 0;
    L9:
        this.currentBufferIndex++;
        byte[] r5 = new byte[r3];
        this.currentBuffer = r5;
        this.buffers.add(r5);
        return;
    L8:
        r3 = Math.max(r0.length << 1, r3 - this.filledBufferSum);
        this.filledBufferSum += this.currentBuffer.length;
        goto L9
    }

    @Override // java.io.OutputStream
    public void write(byte[] r6, int r7, int r8) {
        if (r7 < 0) goto L24;
        if (r7 > r6.length) goto L24;
        if (r8 < 0) goto L24;
        int r9 = r7 + r8;
        if (r9 > r6.length) goto L24;
        if (r9 < 0) goto L24;
        if (r8 != 0) goto L11;
        return;
    L11:
        monitor-enter(this);
        int r0 = this.count;     // Catch: Throwable -> L20
        int r1 = r0 + r8;     // Catch: Throwable -> L20
        int r2 = r0 - this.filledBufferSum;     // Catch: Throwable -> L20
    L13:
        if (r8 <= 0) goto L17;
        int r3 = Math.min(r8, this.currentBuffer.length - r2);     // Catch: Throwable -> L20
        System.arraycopy(r6, r9 - r8, this.currentBuffer, r2, r3);     // Catch: Throwable -> L20
        r8 = r8 - r3;     // Catch: Throwable -> L20
        if (r8 <= 0) goto L13;
        needNewBuffer(r1);     // Catch: Throwable -> L20
        r2 = 0;
        goto L13
    L17:
        this.count = r1;     // Catch: Throwable -> L20
        monitor-exit(this);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    L24:
        throw new IndexOutOfBoundsException();
    }

    @Override // java.io.OutputStream
    public synchronized void write(int r4) {
        monitor-enter(this);
        int r0 = this.count;     // Catch: Throwable -> L9
        int r1 = r0 - this.filledBufferSum;     // Catch: Throwable -> L9
        if (r1 != this.currentBuffer.length) goto L6;
        needNewBuffer(r0 + 1);     // Catch: Throwable -> L9
        r1 = 0;
    L6:
        this.currentBuffer[r1] = (byte) r4;     // Catch: Throwable -> L9
        this.count++;     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized int size() {
        monitor-enter(this);
        int r0 = this.count;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void reset() {
        monitor-enter(this);
        this.count = 0;     // Catch: Throwable -> L7
        this.filledBufferSum = 0;     // Catch: Throwable -> L7
        this.currentBufferIndex = 0;     // Catch: Throwable -> L7
        this.currentBuffer = getBuffer(0);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void writeTo(OutputStream r6) throws IOException {
        monitor-enter(this);
        int r0 = this.count;     // Catch: Throwable -> L13
        int r2 = 0;
    L5:
        if (r2 >= this.buffers.size()) goto L11;
        byte[] r3 = getBuffer(r2);     // Catch: Throwable -> L13
        int r4 = Math.min(r3.length, r0);     // Catch: Throwable -> L13
        r6.write(r3, 0, r4);     // Catch: Throwable -> L13
        r0 = r0 - r4;
        if (r0 == 0) goto L11;
        r2 = r2 + 1;
    L11:
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public synchronized byte[] toByteArray() {
        monitor-enter(this);
        int r0 = this.count;     // Catch: Throwable -> L18
        if (r0 != 0) goto L8;
        byte[] r1 = EMPTY_BYTE_ARRAY;     // Catch: Throwable -> L18
        monitor-exit(this);
        return r1;
    L8:
        byte[] r2 = new byte[r0];     // Catch: Throwable -> L18
        int r3 = 0;
        int r4 = 0;
    L10:
        if (r3 >= this.buffers.size()) goto L16;
        byte[] r5 = getBuffer(r3);     // Catch: Throwable -> L18
        int r6 = Math.min(r5.length, r0);     // Catch: Throwable -> L18
        System.arraycopy(r5, 0, r2, r4, r6);     // Catch: Throwable -> L18
        r4 = r4 + r6;
        r0 = r0 - r6;
        if (r0 == 0) goto L16;
        r3 = r3 + 1;
    L16:
        monitor-exit(this);
        return r2;
    L18:
        th = move-exception;
        throw th;
    }

    public String toString() {
        return new String(toByteArray());
    }

    public String toString(String r2) throws UnsupportedEncodingException {
        return new String(toByteArray(), r2);
    }
}
