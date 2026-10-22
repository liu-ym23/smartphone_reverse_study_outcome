package javax.obex;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public final class PrivateInputStream extends InputStream {
    private byte[] mData;
    private int mIndex;
    private boolean mOpen;
    private BaseStream mParent;

    public PrivateInputStream(BaseStream r2) {
        this.mParent = r2;
        this.mData = new byte[0];
        this.mIndex = 0;
        this.mOpen = true;
    }

    @Override // java.io.InputStream
    public synchronized int available() throws IOException {
        monitor-enter(this);
        ensureOpen();     // Catch: Throwable -> L7
        int r0 = this.mData.length - this.mIndex;
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        monitor-enter(this);
        ensureOpen();     // Catch: Throwable -> L16
    L4:
        byte[] r0 = this.mData;     // Catch: Throwable -> L16
        int r1 = r0.length;     // Catch: Throwable -> L16
        int r2 = this.mIndex;     // Catch: Throwable -> L16
        if (r1 != r2) goto L12;
        if (this.mParent.continueOperation(true, true) == true) goto L4;
        monitor-exit(this);
        return -1;
    L12:
        this.mIndex = r2 + 1;     // Catch: Throwable -> L16
        int r3 = r0[r2] & 255;
        monitor-exit(this);
        return r3;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public int read(byte[] r3) throws IOException {
        return read(r3, 0, r3.length);
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] r5, int r6, int r7) throws IOException {
        monitor-enter(this);
        if (r5 == null) goto L25;
        if ((r6 | r7) < 0) goto L23;
        if (r7 > (r5.length - r6)) goto L23;
        ensureOpen();     // Catch: Throwable -> L26
        int r0 = this.mData.length - this.mIndex;     // Catch: Throwable -> L26
        int r1 = 0;
    L9:
        if (r0 > r7) goto L17;
        System.arraycopy(this.mData, this.mIndex, r5, r6, r0);     // Catch: Throwable -> L26
        this.mIndex += r0;     // Catch: Throwable -> L26
        r6 = r6 + r0;     // Catch: Throwable -> L26
        r1 = r1 + r0;     // Catch: Throwable -> L26
        r7 = r7 - r0;     // Catch: Throwable -> L26
        if (this.mParent.continueOperation(true, true) == false) goto L12;
        r0 = this.mData.length - this.mIndex;     // Catch: Throwable -> L26
        goto L9
    L12:
        if (r1 != 0) goto L14;
        r1 = -1;
    L14:
        monitor-exit(this);
        return r1;
    L17:
        if (r7 <= 0) goto L20;
        System.arraycopy(this.mData, this.mIndex, r5, r6, r7);     // Catch: Throwable -> L26
        this.mIndex += r7;     // Catch: Throwable -> L26
        r1 = r1 + r7;
    L20:
        monitor-exit(this);
        return r1;
    L23:
        throw new ArrayIndexOutOfBoundsException("index outof bound");     // Catch: Throwable -> L26
    L25:
        throw new IOException("buffer is null");     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    public synchronized void writeBytes(byte[] r6, int r7) {
        monitor-enter(this);
        int r0 = r6.length - r7;     // Catch: Throwable -> L6
        byte[] r1 = this.mData;     // Catch: Throwable -> L6
        int r2 = r1.length;     // Catch: Throwable -> L6
        int r3 = this.mIndex;     // Catch: Throwable -> L6
        byte[] r4 = new byte[r0 + (r2 - r3)];     // Catch: Throwable -> L6
        System.arraycopy(r1, r3, r4, 0, r1.length - r3);     // Catch: Throwable -> L6
        System.arraycopy(r6, r7, r4, this.mData.length - this.mIndex, r6.length - r7);     // Catch: Throwable -> L6
        this.mData = r4;     // Catch: Throwable -> L6
        this.mIndex = 0;     // Catch: Throwable -> L6
        notifyAll();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void ensureOpen() throws IOException {
        this.mParent.ensureOpen();
        if (this.mOpen == false) goto L6;
        return;
    L6:
        throw new IOException("Input stream is closed");
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mOpen = false;
        this.mParent.streamClosed(true);
    }
}
