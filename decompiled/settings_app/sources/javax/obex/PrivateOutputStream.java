package javax.obex;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public final class PrivateOutputStream extends OutputStream {
    private ByteArrayOutputStream mArray;
    private int mMaxPacketSize;
    private boolean mOpen;
    private BaseStream mParent;

    public PrivateOutputStream(BaseStream r1, int r2) {
        this.mParent = r1;
        this.mArray = new ByteArrayOutputStream();
        this.mMaxPacketSize = r2;
        this.mOpen = true;
    }

    public int size() {
        return this.mArray.size();
    }

    @Override // java.io.OutputStream
    public synchronized void write(int r3) throws IOException {
        monitor-enter(this);
        ensureOpen();     // Catch: Throwable -> L8
        this.mParent.ensureNotDone();     // Catch: Throwable -> L8
        this.mArray.write(r3);     // Catch: Throwable -> L8
        if (this.mArray.size() != this.mMaxPacketSize) goto L6;
        this.mParent.continueOperation(true, false);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // java.io.OutputStream
    public void write(byte[] r3) throws IOException {
        write(r3, 0, r3.length);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] r4, int r5, int r6) throws IOException {
        monitor-enter(this);
        if (r4 == null) goto L19;
        if ((r5 | r6) < 0) goto L17;
        if (r6 > (r4.length - r5)) goto L17;
        ensureOpen();     // Catch: Throwable -> L20
        this.mParent.ensureNotDone();     // Catch: Throwable -> L20
    L9:
        int r0 = this.mArray.size() + r6;     // Catch: Throwable -> L20
        int r1 = this.mMaxPacketSize;     // Catch: Throwable -> L20
        if (r0 < r1) goto L12;
        int r2 = r1 - this.mArray.size();     // Catch: Throwable -> L20
        this.mArray.write(r4, r5, r2);     // Catch: Throwable -> L20
        r5 = r5 + r2;     // Catch: Throwable -> L20
        r6 = r6 - r2;     // Catch: Throwable -> L20
        this.mParent.continueOperation(true, false);     // Catch: Throwable -> L20
        goto L9
    L12:
        if (r6 <= 0) goto L14;
        this.mArray.write(r4, r5, r6);     // Catch: Throwable -> L20
    L14:
        monitor-exit(this);
        return;
    L17:
        throw new IndexOutOfBoundsException("index outof bound");     // Catch: Throwable -> L20
    L19:
        throw new IOException("buffer is null");     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public synchronized byte[] readBytes(int r5) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.mArray.size() <= 0) goto L10;
        byte[] r0 = this.mArray.toByteArray();     // Catch: Throwable -> L13
        this.mArray.reset();     // Catch: Throwable -> L13
        byte[] r1 = new byte[r5];     // Catch: Throwable -> L13
        System.arraycopy(r0, 0, r1, 0, r5);     // Catch: Throwable -> L13
        if (r0.length == r5) goto L8;
        this.mArray.write(r0, r5, r0.length - r5);     // Catch: Throwable -> L13
    L8:
        monitor-exit(this);
        return r1;
    L10:
        monitor-exit(this);
        return null;
    }

    private void ensureOpen() throws IOException {
        this.mParent.ensureOpen();
        if (this.mOpen == false) goto L6;
        return;
    L6:
        throw new IOException("Output stream is closed");
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mOpen = false;
        this.mParent.streamClosed(false);
    }

    public boolean isClosed() {
        return !this.mOpen;
    }
}
