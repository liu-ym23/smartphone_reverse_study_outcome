package org.apache.commons.io.input;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

/* JADX INFO: loaded from: classes6.dex */
public class NullReader extends Reader {
    private boolean eof;
    private long mark;
    private boolean markSupported;
    private long position;
    private long readlimit;
    private long size;
    private boolean throwEofException;

    protected int processChar() {
        return 0;
    }

    protected void processChars(char[] r1, int r2, int r3) {
    }

    public NullReader(long r3) {
        this(r3, true, false);
    }

    public NullReader(long r3, boolean r5, boolean r6) {
        this.mark = -1;
        this.size = r3;
        this.markSupported = r5;
        this.throwEofException = r6;
    }

    public long getPosition() {
        return this.position;
    }

    public long getSize() {
        return this.size;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.eof = false;
        this.position = 0;
        this.mark = -1;
    }

    @Override // java.io.Reader
    public synchronized void mark(int r3) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.markSupported == false) goto L9;
        this.mark = this.position;     // Catch: Throwable -> L10
        this.readlimit = r3;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L9:
        throw new UnsupportedOperationException("Mark not supported");     // Catch: Throwable -> L10
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return this.markSupported;
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        if (this.eof == true) goto L11;
        long r0 = this.position;
        if (r0 == this.size) goto L7;
        this.position = r0 + 1;
        return processChar();
    L7:
        return doEndOfFile();
    L11:
        throw new IOException("Read after end of file");
    }

    @Override // java.io.Reader
    public int read(char[] r3) throws IOException {
        return read(r3, 0, r3.length);
    }

    @Override // java.io.Reader
    public int read(char[] r7, int r8, int r9) throws IOException {
        if (this.eof == true) goto L14;
        long r0 = this.position;
        long r2 = this.size;
        if (r0 == r2) goto L7;
        long r1 = r0 + ((long) r9);
        this.position = r1;
        if (r1 <= r2) goto L11;
        r9 = r9 - ((int) (r1 - r2));
        this.position = r2;
    L11:
        processChars(r7, r8, r9);
        return r9;
    L7:
        return doEndOfFile();
    L14:
        throw new IOException("Read after end of file");
    }

    @Override // java.io.Reader
    public synchronized void reset() throws IOException {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.markSupported == false) goto L18;
        long r1 = this.mark;     // Catch: Throwable -> L19
        if (r1 < 0) goto L16;
        if (this.position > (this.readlimit + r1)) goto L14;
        this.position = r1;     // Catch: Throwable -> L19
        this.eof = false;     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L14:
        throw new IOException(new StringBuffer("Marked position [").append(this.mark).append("] is no longer valid - passed the read limit [").append(this.readlimit).append("]").toString());     // Catch: Throwable -> L19
    L16:
        throw new IOException("No position has been marked");     // Catch: Throwable -> L19
    L18:
        throw new UnsupportedOperationException("Mark not supported");     // Catch: Throwable -> L19
    }

    @Override // java.io.Reader
    public long skip(long r6) throws IOException {
        if (this.eof == true) goto L13;
        long r0 = this.position;
        long r2 = this.size;
        if (r0 == r2) goto L7;
        long r1 = r0 + r6;
        this.position = r1;
        if (r1 <= r2) goto L14;
        long r7 = r6 - (r1 - r2);
        this.position = r2;
        return r7;
    L14:
        return r6;
    L7:
        return doEndOfFile();
    L13:
        throw new IOException("Skip after end of file");
    }

    private int doEndOfFile() throws EOFException {
        this.eof = true;
        if (this.throwEofException == true) goto L7;
        return -1;
    L7:
        throw new EOFException();
    }
}
