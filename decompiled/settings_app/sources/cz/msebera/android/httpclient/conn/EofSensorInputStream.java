package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public class EofSensorInputStream extends InputStream implements ConnectionReleaseTrigger {
    private final EofSensorWatcher eofWatcher;
    private boolean selfClosed;
    protected InputStream wrappedStream;

    public EofSensorInputStream(InputStream r2, EofSensorWatcher r3) {
        Args.notNull(r2, "Wrapped stream");
        this.wrappedStream = r2;
        this.selfClosed = false;
        this.eofWatcher = r3;
    }

    boolean isSelfClosed() {
        return this.selfClosed;
    }

    InputStream getWrappedStream() {
        return this.wrappedStream;
    }

    protected boolean isReadAllowed() throws IOException {
        if (this.selfClosed == true) goto L10;
        if (this.wrappedStream == null) goto L7;
        return true;
    L7:
        return false;
    L10:
        throw new IOException("Attempted read on closed stream.");
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (isReadAllowed() == true) goto L11;
        return -1;
    L11:
        int r0 = this.wrappedStream.read();     // Catch: IOException -> L6
        checkEOF(r0);     // Catch: IOException -> L6
        return r0;
    L6:
        e = move-exception;
        checkAbort();
        throw e;
    }

    @Override // java.io.InputStream
    public int read(byte[] r2, int r3, int r4) throws IOException {
        if (isReadAllowed() == true) goto L11;
        return -1;
    L11:
        int r5 = this.wrappedStream.read(r2, r3, r4);     // Catch: IOException -> L6
        checkEOF(r5);     // Catch: IOException -> L6
        return r5;
    L6:
        e = move-exception;
        checkAbort();
        throw e;
    }

    @Override // java.io.InputStream
    public int read(byte[] r3) throws IOException {
        return read(r3, 0, r3.length);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (isReadAllowed() == true) goto L11;
        return 0;
    L11:
        return this.wrappedStream.available();
    L6:
        e = move-exception;
        checkAbort();
        throw e;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.selfClosed = true;
        checkClose();
    }

    protected void checkEOF(int r3) throws IOException {
        InputStream r0 = this.wrappedStream;
        if (r0 == null) goto L16;
        if (r3 < 0) goto L17;
        return;
    L17:
        EofSensorWatcher r1 = this.eofWatcher;     // Catch: Throwable -> L13
        if (r1 == null) goto L9;
        boolean r2 = r1.eofDetected(r0);     // Catch: Throwable -> L13
    L10:
        if (r2 == false) goto L12;
        r0.close();     // Catch: Throwable -> L13
    L12:
        this.wrappedStream = null;
        return;
    L9:
        r2 = true;
    L13:
        th = move-exception;
        this.wrappedStream = null;
        throw th;
    }

    protected void checkClose() throws IOException {
        InputStream r0 = this.wrappedStream;
        if (r0 != null) goto L16;
        return;
    L16:
        EofSensorWatcher r2 = this.eofWatcher;     // Catch: Throwable -> L12
        if (r2 == null) goto L8;
        boolean r3 = r2.streamClosed(r0);     // Catch: Throwable -> L12
    L9:
        if (r3 == false) goto L11;
        r0.close();     // Catch: Throwable -> L12
    L11:
        this.wrappedStream = null;
        return;
    L8:
        r3 = true;
    L12:
        th = move-exception;
        this.wrappedStream = null;
        throw th;
    }

    protected void checkAbort() throws IOException {
        InputStream r0 = this.wrappedStream;
        if (r0 != null) goto L16;
        return;
    L16:
        EofSensorWatcher r2 = this.eofWatcher;     // Catch: Throwable -> L12
        if (r2 == null) goto L8;
        boolean r3 = r2.streamAbort(r0);     // Catch: Throwable -> L12
    L9:
        if (r3 == false) goto L11;
        r0.close();     // Catch: Throwable -> L12
    L11:
        this.wrappedStream = null;
        return;
    L8:
        r3 = true;
    L12:
        th = move-exception;
        this.wrappedStream = null;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.conn.ConnectionReleaseTrigger
    public void releaseConnection() throws IOException {
        close();
    }

    @Override // cz.msebera.android.httpclient.conn.ConnectionReleaseTrigger
    public void abortConnection() throws IOException {
        this.selfClosed = true;
        checkAbort();
    }
}
