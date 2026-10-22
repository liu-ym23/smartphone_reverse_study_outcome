package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UploadDataSink;
import java.io.IOException;
import java.net.HttpRetryException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
final class CronetChunkedOutputStream extends CronetOutputStream {
    private final ByteBuffer mBuffer;
    private final CronetHttpURLConnection mConnection;
    private boolean mLastChunk;
    private final MessageLoop mMessageLoop;
    private final UploadDataProvider mUploadDataProvider;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.urlconnection.CronetChunkedOutputStream$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class UploadDataProviderImpl extends UploadDataProvider {
        final /* synthetic */ CronetChunkedOutputStream this$0;

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public long getLength() {
            return -1;
        }

        private UploadDataProviderImpl(CronetChunkedOutputStream r1) {
            this.this$0 = r1;
        }

        /* synthetic */ UploadDataProviderImpl(CronetChunkedOutputStream r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void read(UploadDataSink r5, ByteBuffer r6) {
            if (r6.remaining() < CronetChunkedOutputStream.access$100(this.this$0).remaining()) goto L7;
            r6.put(CronetChunkedOutputStream.access$100(this.this$0));
            CronetChunkedOutputStream.access$100(this.this$0).clear();
            r5.onReadSucceeded(CronetChunkedOutputStream.access$200(this.this$0));
            if (CronetChunkedOutputStream.access$200(this.this$0) == true) goto L9;
            CronetChunkedOutputStream.access$300(this.this$0).quit();
            return;
        L9:
            return;
        L7:
            int r0 = CronetChunkedOutputStream.access$100(this.this$0).limit();
            CronetChunkedOutputStream.access$100(this.this$0).limit(CronetChunkedOutputStream.access$100(this.this$0).position() + r6.remaining());
            r6.put(CronetChunkedOutputStream.access$100(this.this$0));
            CronetChunkedOutputStream.access$100(this.this$0).limit(r0);
            r5.onReadSucceeded(false);
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink r3) {
            r3.onRewindError(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetOutputStream
    void checkReceivedEnoughContent() throws IOException {
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetOutputStream
    void setConnected() throws IOException {
    }

    static /* synthetic */ ByteBuffer access$100(CronetChunkedOutputStream r0) {
        return r0.mBuffer;
    }

    static /* synthetic */ boolean access$200(CronetChunkedOutputStream r0) {
        return r0.mLastChunk;
    }

    static /* synthetic */ MessageLoop access$300(CronetChunkedOutputStream r0) {
        return r0.mMessageLoop;
    }

    CronetChunkedOutputStream(CronetHttpURLConnection r3, int r4, MessageLoop r5) {
        this.mUploadDataProvider = new UploadDataProviderImpl(this, null);
        r3.getClass();
        if (r4 <= 0) goto L7;
        this.mBuffer = ByteBuffer.allocate(r4);
        this.mConnection = r3;
        this.mMessageLoop = r5;
        return;
    L7:
        throw new IllegalArgumentException("chunkLength should be greater than 0");
    }

    @Override // java.io.OutputStream
    public void write(int r1) throws IOException {
        ensureBufferHasRemaining();
        this.mBuffer.put((byte) r1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r5, int r6, int r7) throws IOException {
        checkNotClosed();
        if ((r5.length - r6) < r7) goto L11;
        if (r6 < 0) goto L11;
        if (r7 < 0) goto L11;
        int r0 = r7;
    L7:
        if (r0 <= 0) goto L9;
        int r1 = Math.min(r0, this.mBuffer.remaining());
        this.mBuffer.put(r5, (r6 + r7) - r0, r1);
        r0 = r0 - r1;
        ensureBufferHasRemaining();
        goto L7
    L9:
        return;
    L11:
        throw new IndexOutOfBoundsException();
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        if (this.mLastChunk == true) goto L6;
        this.mLastChunk = true;
        this.mBuffer.flip();
        return;
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetOutputStream
    UploadDataProvider getUploadDataProvider() {
        return this.mUploadDataProvider;
    }

    private void ensureBufferHasRemaining() throws IOException {
        if (this.mBuffer.hasRemaining() == true) goto L6;
        uploadBufferInternal();
        return;
    }

    private void cronet_loop(int r6) throws IOException {
        this.mMessageLoop.loop(r6);     // Catch: Exception -> L4 SocketTimeoutException -> L8
    L17:
        return;
    L8:
        CronetHttpURLConnection r0 = this.mConnection;
        if (r0 == null) goto L16;
        r0.onUploadTimeout();
        this.mMessageLoop.reset();
        this.mMessageLoop.loop(r6 / 2);
        return;
    L16:
        return;
    L4:
        e = move-exception;
        CronetHttpURLConnection r1 = this.mConnection;
        if (r1 == null) goto L14;
        r1.setException(new IOException("Unexpected request usage, caught in CronetChunkedOutputStream, caused by " + e));
        this.mMessageLoop.reset();
        this.mMessageLoop.loop(r6 / 2);
        return;
    }

    private void uploadBufferInternal() throws IOException {
        checkNotClosed();
        this.mBuffer.flip();
        cronet_loop(this.mConnection.getReadTimeout());
        checkNoException();
    }
}
