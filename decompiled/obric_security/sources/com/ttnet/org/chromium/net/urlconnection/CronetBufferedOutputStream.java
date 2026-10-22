package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UploadDataSink;
import java.io.IOException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
final class CronetBufferedOutputStream extends CronetOutputStream {
    private static final int INITIAL_BUFFER_SIZE = 16384;
    private ByteBuffer mBuffer;
    private boolean mConnected;
    private final CronetHttpURLConnection mConnection;
    private final int mInitialContentLength;
    private final UploadDataProvider mUploadDataProvider;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.urlconnection.CronetBufferedOutputStream$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class UploadDataProviderImpl extends UploadDataProvider {
        final /* synthetic */ CronetBufferedOutputStream this$0;

        private UploadDataProviderImpl(CronetBufferedOutputStream r1) {
            this.this$0 = r1;
        }

        /* synthetic */ UploadDataProviderImpl(CronetBufferedOutputStream r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public long getLength() {
            if (CronetBufferedOutputStream.access$100(this.this$0) != (-1)) goto L11;
            boolean r0 = CronetBufferedOutputStream.access$200(this.this$0);
            ByteBuffer r2 = CronetBufferedOutputStream.access$300(this.this$0);
            if (r0 == false) goto L7;
            int r3 = r2.limit();
        L9:
            return r3;
        L7:
            r3 = r2.position();
            goto L9
        L11:
            return CronetBufferedOutputStream.access$100(this.this$0);
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void read(UploadDataSink r4, ByteBuffer r5) {
            int r0 = r5.remaining();
            if (r0 >= CronetBufferedOutputStream.access$300(this.this$0).remaining()) goto L5;
            r5.put(CronetBufferedOutputStream.access$300(this.this$0).array(), CronetBufferedOutputStream.access$300(this.this$0).position(), r0);
            CronetBufferedOutputStream.access$300(this.this$0).position(CronetBufferedOutputStream.access$300(this.this$0).position() + r0);
        L6:
            r4.onReadSucceeded(false);
            return;
        L5:
            r5.put(CronetBufferedOutputStream.access$300(this.this$0));
            goto L6
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink r2) {
            CronetBufferedOutputStream.access$300(this.this$0).position(0);
            r2.onRewindSucceeded();
        }
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetOutputStream
    void checkReceivedEnoughContent() throws IOException {
    }

    static /* synthetic */ int access$100(CronetBufferedOutputStream r0) {
        return r0.mInitialContentLength;
    }

    static /* synthetic */ boolean access$200(CronetBufferedOutputStream r0) {
        return r0.mConnected;
    }

    static /* synthetic */ ByteBuffer access$300(CronetBufferedOutputStream r0) {
        return r0.mBuffer;
    }

    CronetBufferedOutputStream(CronetHttpURLConnection r3, long r4) {
        this.mUploadDataProvider = new UploadDataProviderImpl(this, null);
        if (r3 == null) goto L15;
        if (r4 > 2147483647L) goto L13;
        if (r4 < 0) goto L11;
        this.mConnection = r3;
        int r5 = (int) r4;
        this.mInitialContentLength = r5;
        this.mBuffer = ByteBuffer.allocate(r5);
        return;
    L11:
        throw new IllegalArgumentException("Content length < 0.");
    L13:
        throw new IllegalArgumentException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2GB.");
    L15:
        throw new NullPointerException("Argument connection cannot be null.");
    }

    CronetBufferedOutputStream(CronetHttpURLConnection r3) {
        this.mUploadDataProvider = new UploadDataProviderImpl(this, null);
        r3.getClass();
        this.mConnection = r3;
        this.mInitialContentLength = -1;
        this.mBuffer = ByteBuffer.allocate(16384);
    }

    @Override // java.io.OutputStream
    public void write(int r2) throws IOException {
        checkNotClosed();
        ensureCanWrite(1);
        this.mBuffer.put((byte) r2);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r1, int r2, int r3) throws IOException {
        checkNotClosed();
        ensureCanWrite(r3);
        this.mBuffer.put(r1, r2, r3);
    }

    private void ensureCanWrite(int r4) throws IOException {
        if (this.mInitialContentLength == (-1)) goto L10;
        if ((this.mBuffer.position() + r4) <= this.mInitialContentLength) goto L10;
        throw new ProtocolException("exceeded content-length limit of " + this.mInitialContentLength + " bytes");
    L10:
        if (this.mConnected == true) goto L20;
        if (this.mInitialContentLength == (-1)) goto L15;
        return;
    L15:
        if ((this.mBuffer.limit() - this.mBuffer.position()) <= r4) goto L17;
        return;
    L17:
        ByteBuffer r5 = ByteBuffer.allocate(Math.max(this.mBuffer.capacity() * 2, this.mBuffer.capacity() + r4));
        this.mBuffer.flip();
        r5.put(this.mBuffer);
        this.mBuffer = r5;
        return;
    L20:
        throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for writing after connect");
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetOutputStream
    void setConnected() throws IOException {
        this.mConnected = true;
        if (this.mBuffer.position() < this.mInitialContentLength) goto L7;
        this.mBuffer.flip();
        return;
    L7:
        throw new ProtocolException("Content received is less than Content-Length");
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetOutputStream
    UploadDataProvider getUploadDataProvider() {
        return this.mUploadDataProvider;
    }
}
