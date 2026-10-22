package com.ttnet.org.chromium.net.urlconnection;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
class CronetInputStream extends InputStream {
    private static final int READ_BUFFER_SIZE = 32768;
    private static final int READ_BUFFER_SIZE_MIN = 8192;
    private ByteBuffer mBuffer;
    protected IOException mException;
    protected final CronetHttpURLConnection mHttpURLConnection;
    private boolean mResponseDataCompleted;

    public CronetInputStream(CronetHttpURLConnection r1) {
        this.mHttpURLConnection = r1;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        getMoreDataIfNeeded();
        if (hasUnreadData() == true) goto L5;
        return -1;
    L5:
        return this.mBuffer.get() & UByte.MAX_VALUE;
    }

    @Override // java.io.InputStream
    public int read(byte[] r3, int r4, int r5) throws IOException {
        if (r4 < 0) goto L16;
        if (r5 < 0) goto L16;
        if ((r4 + r5) > r3.length) goto L16;
        if (r5 != 0) goto L9;
        return 0;
    L9:
        getMoreDataIfNeeded();
        if (hasUnreadData() == false) goto L13;
        int r6 = Math.min(this.mBuffer.limit() - this.mBuffer.position(), r5);
        this.mBuffer.get(r3, r4, r6);
        return r6;
    L13:
        return -1;
    L16:
        throw new IndexOutOfBoundsException();
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.mResponseDataCompleted == false) goto L9;
        IOException r2 = this.mException;
        if (r2 != null) goto L7;
        return 0;
    L7:
        throw r2;
    L9:
        if (hasUnreadData() == true) goto L11;
        return 0;
    L11:
        return this.mBuffer.remaining();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        CronetHttpURLConnection r0 = this.mHttpURLConnection;
        if (r0 == null) goto L5;
        r0.disconnect();
    L5:
        super.close();
    }

    void setResponseDataCompleted(IOException r1) {
        this.mException = r1;
        this.mResponseDataCompleted = true;
        this.mBuffer = null;
    }

    private void getMoreDataIfNeeded() throws IOException {
        if (this.mResponseDataCompleted == false) goto L9;
        IOException r2 = this.mException;
        if (r2 != null) goto L7;
        return;
    L7:
        throw r2;
    L9:
        if (hasUnreadData() == false) goto L11;
        return;
    L11:
        if (this.mBuffer == null) goto L13;
    L17:
        this.mBuffer.clear();
        this.mHttpURLConnection.getMoreData(this.mBuffer);
        IOException r0 = this.mException;
        if (r0 != null) goto L22;
        ByteBuffer r3 = this.mBuffer;
        if (r3 == null) goto L24;
        r3.flip();
        return;
    L24:
        return;
    L22:
        throw r0;
    L13:
        if (this.mHttpURLConnection.getInputStreamBufferSize() < 8192) goto L15;
        int r1 = this.mHttpURLConnection.getInputStreamBufferSize();
    L16:
        this.mBuffer = ByteBuffer.allocateDirect(r1);
        goto L17
    L15:
        r1 = 32768;
        goto L16
    }

    private boolean hasUnreadData() {
        ByteBuffer r0 = this.mBuffer;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.hasRemaining() == false) goto L7;
        return true;
    }
}
