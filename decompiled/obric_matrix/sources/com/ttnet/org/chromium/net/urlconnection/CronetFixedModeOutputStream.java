package com.ttnet.org.chromium.net.urlconnection;

import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UploadDataSink;
import java.io.IOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class CronetFixedModeOutputStream extends CronetOutputStream {

    @VisibleForTesting
    private static int sDefaultBufferLength = 16384;
    private final ByteBuffer mBuffer;
    private long mBytesWritten;
    private final CronetHttpURLConnection mConnection;
    private final long mContentLength;
    private boolean mIsRewinding;
    private final MessageLoop mMessageLoop;
    private boolean mSupportRewind;
    private final UploadDataProvider mUploadDataProvider;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.urlconnection.CronetFixedModeOutputStream$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class UploadDataProviderImpl extends UploadDataProvider {
        final /* synthetic */ CronetFixedModeOutputStream this$0;

        private UploadDataProviderImpl(CronetFixedModeOutputStream r1) {
            this.this$0 = r1;
        }

        /* synthetic */ UploadDataProviderImpl(CronetFixedModeOutputStream r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public long getLength() {
            return CronetFixedModeOutputStream.access$100(this.this$0);
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void read(UploadDataSink r6, ByteBuffer r7) {
            if (r7.remaining() < CronetFixedModeOutputStream.access$200(this.this$0).remaining()) goto L7;
            r7.put(CronetFixedModeOutputStream.access$200(this.this$0));
            CronetFixedModeOutputStream.access$200(this.this$0).clear();
            r6.onReadSucceeded(false);
            if (CronetFixedModeOutputStream.access$300(this.this$0) == true) goto L9;
            CronetFixedModeOutputStream.access$400(this.this$0).quit();
            return;
        L9:
            return;
        L7:
            int r0 = CronetFixedModeOutputStream.access$200(this.this$0).limit();
            CronetFixedModeOutputStream.access$200(this.this$0).limit(CronetFixedModeOutputStream.access$200(this.this$0).position() + r7.remaining());
            r7.put(CronetFixedModeOutputStream.access$200(this.this$0));
            CronetFixedModeOutputStream.access$200(this.this$0).limit(r0);
            r6.onReadSucceeded(false);
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink r3) {
            if (CronetFixedModeOutputStream.access$500(this.this$0) == false) goto L5;
            CronetFixedModeOutputStream.access$302(this.this$0, true);
            CronetFixedModeOutputStream.access$200(this.this$0).rewind();
            r3.onRewindSucceeded();
            return;
        L5:
            r3.onRewindError(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }

    static {
    }

    CronetFixedModeOutputStream(CronetHttpURLConnection r5, long r6, int r8, MessageLoop r9) {
        this.mUploadDataProvider = new UploadDataProviderImpl(this, null);
        Objects.requireNonNull(r5);
        if (r6 < 0) goto L7;
        this.mContentLength = r6;
        this.mBuffer = ByteBuffer.allocate((int) Math.min(r6, Math.max(sDefaultBufferLength, r8)));
        this.mConnection = r5;
        this.mMessageLoop = r9;
        this.mBytesWritten = 0;
        this.mSupportRewind = true;
        this.mIsRewinding = false;
        return;
    L7:
        throw new IllegalArgumentException("Content length must be larger than 0 for non-chunked upload.");
    }

    static /* synthetic */ long access$100(CronetFixedModeOutputStream r2) {
        return r2.mContentLength;
    }

    static /* synthetic */ ByteBuffer access$200(CronetFixedModeOutputStream r0) {
        return r0.mBuffer;
    }

    static /* synthetic */ boolean access$300(CronetFixedModeOutputStream r0) {
        return r0.mIsRewinding;
    }

    static /* synthetic */ boolean access$302(CronetFixedModeOutputStream r0, boolean r1) {
        r0.mIsRewinding = r1;
        return r1;
    }

    static /* synthetic */ MessageLoop access$400(CronetFixedModeOutputStream r0) {
        return r0.mMessageLoop;
    }

    static /* synthetic */ boolean access$500(CronetFixedModeOutputStream r0) {
        return r0.mSupportRewind;
    }

    private void checkNotExceedContentLength(int r7) {
        if ((this.mBytesWritten + ((long) r7)) > this.mContentLength) goto L6;
        return;
    L6:
        throw new ProtocolException("expected " + (this.mContentLength - this.mBytesWritten) + " bytes but received " + r7);
    }

    private void cronet_loop(int r6) {
        this.mMessageLoop.loop(r6);     // Catch: Exception -> L4 SocketTimeoutException -> L9
    L17:
        return;
    L9:
        CronetHttpURLConnection r0 = this.mConnection;
        if (r0 == null) goto L16;
        r0.onUploadTimeout();
    L8:
        this.mMessageLoop.reset();
        this.mMessageLoop.loop(r6 / 2);
        return;
    L16:
        return;
    L4:
        e = move-exception;
        CronetHttpURLConnection r1 = this.mConnection;
        if (r1 == null) goto L12;
        r1.setException(new IOException("Unexpected request usage, caught in CronetFixedModeOutputStream, caused by " + e));
        goto L8
    }

    private void ensureBufferHasRemaining() {
        if (this.mBuffer.hasRemaining() == true) goto L6;
        this.mSupportRewind = false;
        uploadBufferInternal();
        return;
    }

    @VisibleForTesting
    static void setDefaultBufferLengthForTesting(int r0) {
        sDefaultBufferLength = r0;
    }

    private void uploadBufferInternal() {
        checkNotClosed();
        this.mBuffer.flip();
        cronet_loop(this.mConnection.getReadTimeout());
        checkNoException();
    }

    private void uploadIfComplete() {
        if (this.mBytesWritten != this.mContentLength) goto L6;
        uploadBufferInternal();
        return;
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetOutputStream
    void checkReceivedEnoughContent() {
        if (this.mBytesWritten < this.mContentLength) goto L6;
        return;
    L6:
        throw new ProtocolException("Content received is less than Content-Length.");
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetOutputStream
    UploadDataProvider getUploadDataProvider() {
        return this.mUploadDataProvider;
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetOutputStream
    void setConnected() {
    }

    @Override // java.io.OutputStream
    public void write(int r5) {
        checkNotClosed();
        checkNotExceedContentLength(1);
        ensureBufferHasRemaining();
        this.mBuffer.put((byte) r5);
        this.mBytesWritten++;
        uploadIfComplete();
    }

    @Override // java.io.OutputStream
    public void write(byte[] r5, int r6, int r7) {
        checkNotClosed();
        if ((r5.length - r6) < r7) goto L12;
        if (r6 < 0) goto L12;
        if (r7 < 0) goto L12;
        checkNotExceedContentLength(r7);
        int r0 = r7;
    L7:
        if (r0 <= 0) goto L9;
        ensureBufferHasRemaining();
        int r1 = Math.min(r0, this.mBuffer.remaining());
        this.mBuffer.put(r5, (r6 + r7) - r0, r1);
        r0 = r0 - r1;
        goto L7
    L9:
        this.mBytesWritten += (long) r7;
        uploadIfComplete();
        return;
    L12:
        throw new IndexOutOfBoundsException();
    }
}
