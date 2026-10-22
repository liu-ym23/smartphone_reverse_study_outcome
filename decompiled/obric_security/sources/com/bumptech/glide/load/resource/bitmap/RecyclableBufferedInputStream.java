package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public class RecyclableBufferedInputStream extends FilterInputStream {
    private volatile byte[] buf;
    private final ArrayPool byteArrayPool;
    private int count;
    private int marklimit;
    private int markpos;
    private int pos;

    static class InvalidMarkException extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        InvalidMarkException(String r1) {
            super(r1);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    public RecyclableBufferedInputStream(InputStream r2, ArrayPool r3) {
        this(r2, r3, 65536);
    }

    RecyclableBufferedInputStream(InputStream r1, ArrayPool r2, int r3) {
        super(r1);
        this.markpos = -1;
        this.byteArrayPool = r2;
        this.buf = (byte[]) r2.get(r3, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        monitor-enter(this);
        InputStream r0 = this.in;     // Catch: Throwable -> L12
        if (this.buf == null) goto L11;
        if (r0 == null) goto L11;
        int r1 = (this.count - this.pos) + r0.available();
        monitor-exit(this);
        return r1;
    L11:
        throw streamClosed();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    private static IOException streamClosed() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    public synchronized void fixMarkLimit() {
        monitor-enter(this);
        this.marklimit = this.buf.length;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void release() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.buf == null) goto L6;
        this.byteArrayPool.put(this.buf);     // Catch: Throwable -> L8
        this.buf = null;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.buf == null) goto L5;
        this.byteArrayPool.put(this.buf);
        this.buf = null;
    L5:
        InputStream r0 = this.in;
        this.in = null;
        if (r0 == null) goto L9;
        r0.close();
        return;
    }

    private int fillbuf(InputStream r6, byte[] r7) throws IOException {
        int r0 = this.markpos;
        if (r0 == (-1)) goto L25;
        int r3 = this.pos - r0;
        int r4 = this.marklimit;
        if (r3 >= r4) goto L25;
        if (r0 == 0) goto L9;
    L17:
        if (r0 <= 0) goto L19;
        System.arraycopy(r7, r0, r7, 0, r7.length - r0);
    L19:
        int r1 = this.pos - this.markpos;
        this.pos = r1;
        this.markpos = 0;
        this.count = 0;
        int r8 = r6.read(r7, r1, r7.length - r1);
        int r9 = this.pos;
        if (r8 <= 0) goto L23;
        r9 = r9 + r8;
    L23:
        this.count = r9;
        return r8;
    L9:
        if (r4 <= r7.length) goto L17;
        if (this.count != r7.length) goto L17;
        int r2 = r7.length * 2;
        if (r2 > r4) goto L16;
        r4 = r2;
    L16:
        byte[] r5 = (byte[]) this.byteArrayPool.get(r4, byte[].class);
        System.arraycopy(r7, 0, r5, 0, r7.length);
        this.buf = r5;
        this.byteArrayPool.put(r7);
        r7 = r5;
    L25:
        int r10 = r6.read(r7);
        if (r10 <= 0) goto L28;
        this.markpos = -1;
        this.pos = 0;
        this.count = r10;
    L28:
        return r10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int r2) {
        monitor-enter(this);
        this.marklimit = Math.max(this.marklimit, r2);     // Catch: Throwable -> L6
        this.markpos = this.pos;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        monitor-enter(this);
        byte[] r0 = this.buf;     // Catch: Throwable -> L29
        InputStream r1 = this.in;     // Catch: Throwable -> L29
        if (r0 == null) goto L28;
        if (r1 == null) goto L28;
        if (this.pos < this.count) goto L13;
        if (fillbuf(r1, r0) != (-1)) goto L13;
        monitor-exit(this);
        return -1;
    L13:
        if (r0 == this.buf) goto L19;
        r0 = this.buf;     // Catch: Throwable -> L29
        if (r0 != null) goto L19;
        throw streamClosed();     // Catch: Throwable -> L29
    L19:
        int r2 = this.count;     // Catch: Throwable -> L29
        int r3 = this.pos;     // Catch: Throwable -> L29
        if ((r2 - r3) <= 0) goto L25;
        this.pos = r3 + 1;     // Catch: Throwable -> L29
        int r4 = r0[r3] & UByte.MAX_VALUE;
        monitor-exit(this);
        return r4;
    L25:
        monitor-exit(this);
        return -1;
    L28:
        throw streamClosed();     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] r7, int r8, int r9) throws IOException {
        monitor-enter(this);
        byte[] r0 = this.buf;     // Catch: Throwable -> L70
        if (r0 == null) goto L69;
        if (r9 != 0) goto L9;
        monitor-exit(this);
        return 0;
    L9:
        InputStream r1 = this.in;     // Catch: Throwable -> L70
        if (r1 == null) goto L67;
        int r2 = this.pos;     // Catch: Throwable -> L70
        int r3 = this.count;     // Catch: Throwable -> L70
        if (r2 < r3) goto L14;
        int r4 = r9;
    L26:
        int r5 = -1;
        if (this.markpos != (-1)) goto L38;
        if (r4 < r0.length) goto L38;
        int r6 = r1.read(r7, r8, r4);     // Catch: Throwable -> L70
        if (r6 == (-1)) goto L32;
    L56:
        r4 = r4 - r6;
        if (r4 == 0) goto L58;
        if (r1.available() == 0) goto L62;
        r8 = r8 + r6;
        goto L26
    L62:
        int r10 = r9 - r4;
        monitor-exit(this);
        return r10;
    L58:
        monitor-exit(this);
        return r9;
    L32:
        if (r4 == r9) goto L35;
        r5 = r9 - r4;
    L35:
        monitor-exit(this);
        return r5;
    L38:
        if (fillbuf(r1, r0) == (-1)) goto L39;
        if (r0 == this.buf) goto L51;
        r0 = this.buf;     // Catch: Throwable -> L70
        if (r0 != null) goto L51;
        throw streamClosed();     // Catch: Throwable -> L70
    L51:
        int r11 = this.count;     // Catch: Throwable -> L70
        int r12 = this.pos;     // Catch: Throwable -> L70
        if ((r11 - r12) < r4) goto L54;
        r6 = r4;
    L55:
        System.arraycopy(r0, r12, r7, r8, r6);     // Catch: Throwable -> L70
        this.pos += r6;     // Catch: Throwable -> L70
        goto L56
    L54:
        r6 = r11 - r12;     // Catch: Throwable -> L70
        goto L55
    L39:
        if (r4 == r9) goto L42;
        r5 = r9 - r4;
    L42:
        monitor-exit(this);
        return r5;
    L14:
        if ((r3 - r2) < r9) goto L16;
        int r13 = r9;
    L17:
        System.arraycopy(r0, r2, r7, r8, r13);     // Catch: Throwable -> L70
        this.pos += r13;     // Catch: Throwable -> L70
        if (r13 != r9) goto L20;
    L23:
        monitor-exit(this);
        return r13;
    L20:
        if (r1.available() == 0) goto L23;
        r8 = r8 + r13;
        r4 = r9 - r13;
        goto L26
    L16:
        r13 = r3 - r2;     // Catch: Throwable -> L70
        goto L17
    L67:
        throw streamClosed();     // Catch: Throwable -> L70
    L69:
        throw streamClosed();     // Catch: Throwable -> L70
    L70:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.buf == null) goto L14;
        int r1 = this.markpos;     // Catch: Throwable -> L15
        if ((-1) == r1) goto L12;
        this.pos = r1;     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L12:
        throw new InvalidMarkException("Mark has been invalidated, pos: " + this.pos + " markLimit: " + this.marklimit);     // Catch: Throwable -> L15
    L14:
        throw new IOException("Stream is closed");     // Catch: Throwable -> L15
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long r11) throws IOException {
        monitor-enter(this);
        if (r11 >= 1) goto L48;
        monitor-exit(this);
        return 0;
    L48:
        byte[] r0 = this.buf;     // Catch: Throwable -> L45
        if (r0 == null) goto L44;
        InputStream r3 = this.in;     // Catch: Throwable -> L45
        if (r3 == null) goto L42;
        int r4 = this.count;     // Catch: Throwable -> L45
        int r5 = this.pos;     // Catch: Throwable -> L45
        if ((r4 - r5) < r11) goto L16;
        this.pos = (int) (((long) r5) + r11);     // Catch: Throwable -> L45
        monitor-exit(this);
        return r11;
    L16:
        long r6 = ((long) r4) - ((long) r5);
        this.pos = r4;     // Catch: Throwable -> L45
        if (this.markpos == (-1)) goto L35;
        if (r11 > this.marklimit) goto L35;
        if (fillbuf(r3, r0) != (-1)) goto L25;
        monitor-exit(this);
        return r6;
    L25:
        int r1 = this.count;     // Catch: Throwable -> L45
        int r2 = this.pos;     // Catch: Throwable -> L45
        if ((r1 - r2) < (r11 - r6)) goto L30;
        this.pos = (int) ((((long) r2) + r11) - r6);     // Catch: Throwable -> L45
        monitor-exit(this);
        return r11;
    L30:
        long r7 = (r6 + ((long) r1)) - ((long) r2);
        this.pos = r1;     // Catch: Throwable -> L45
        monitor-exit(this);
        return r7;
    L35:
        long r12 = r3.skip(r11 - r6);     // Catch: Throwable -> L45
        if (r12 <= 0) goto L38;
        this.markpos = -1;     // Catch: Throwable -> L45
    L38:
        long r8 = r6 + r12;
        monitor-exit(this);
        return r8;
    L42:
        throw streamClosed();     // Catch: Throwable -> L45
    L44:
        throw streamClosed();     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }
}
