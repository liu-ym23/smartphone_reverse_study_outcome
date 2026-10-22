package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.net.UploadDataProvider;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
abstract class CronetOutputStream extends OutputStream {
    private boolean mClosed;
    private IOException mException;
    private boolean mRequestCompleted;

    abstract void checkReceivedEnoughContent() throws IOException;

    abstract UploadDataProvider getUploadDataProvider();

    abstract void setConnected() throws IOException;

    CronetOutputStream() {
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mClosed = true;
    }

    void setRequestCompleted(IOException r1) {
        this.mException = r1;
        this.mRequestCompleted = true;
    }

    protected void checkNotClosed() throws IOException {
        if (this.mRequestCompleted == false) goto L5;
        checkNoException();
        throw new IOException("Writing after request completed.");
    L5:
        if (this.mClosed == true) goto L8;
        return;
    L8:
        throw new IOException("Stream has been closed.");
    }

    protected void checkNoException() throws IOException {
        IOException r0 = this.mException;
        if (r0 != null) goto L5;
        return;
    L5:
        throw r0;
    }
}
